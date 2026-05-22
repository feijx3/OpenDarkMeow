/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.StampedLock;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractReferenceCountedByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.util.ByteProcessor;
import net.darkmeow.irc.lib.io.netty.util.IllegalReferenceCountException;
import net.darkmeow.irc.lib.io.netty.util.NettyRuntime;
import net.darkmeow.irc.lib.io.netty.util.Recycler;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCounted;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FastThreadLocal;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FastThreadLocalThread;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectPool;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.ReferenceCountUpdater;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ThreadExecutorMap;

final class AdaptivePoolingAllocator {
    private static final int MIN_CHUNK_SIZE = 131072;
    private static final int EXPANSION_ATTEMPTS = 3;
    private static final int INITIAL_MAGAZINES = 4;
    private static final int RETIRE_CAPACITY = 4096;
    private static final int MAX_STRIPES = NettyRuntime.availableProcessors() * 2;
    private static final int BUFS_PER_CHUNK = 10;
    private static final int MAX_CHUNK_SIZE = 0xA00000;
    private static final int CENTRAL_QUEUE_CAPACITY = Math.max(2, SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.centralQueueCapacity", NettyRuntime.availableProcessors()));
    private static final int MAGAZINE_BUFFER_QUEUE_CAPACITY = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.magazineBufferQueueCapacity", 1024);
    private static final Object NO_MAGAZINE = Boolean.TRUE;
    private final ChunkAllocator chunkAllocator;
    private final Queue<Chunk> centralQueue;
    private final StampedLock magazineExpandLock;
    private volatile Magazine[] magazines;
    private final FastThreadLocal<Object> threadLocalMagazine;
    private final Set<Magazine> liveCachedMagazines;
    private volatile boolean freed;

    AdaptivePoolingAllocator(ChunkAllocator chunkAllocator, MagazineCaching magazineCaching) {
        ObjectUtil.checkNotNull(chunkAllocator, "chunkAllocator");
        ObjectUtil.checkNotNull(magazineCaching, "magazineCaching");
        this.chunkAllocator = chunkAllocator;
        this.centralQueue = ObjectUtil.checkNotNull(AdaptivePoolingAllocator.createSharedChunkQueue(), "centralQueue");
        this.magazineExpandLock = new StampedLock();
        if (magazineCaching != MagazineCaching.None) {
            assert (magazineCaching == MagazineCaching.EventLoopThreads || magazineCaching == MagazineCaching.FastThreadLocalThreads);
            final boolean cachedMagazinesNonEventLoopThreads = magazineCaching == MagazineCaching.FastThreadLocalThreads;
            final CopyOnWriteArraySet<Magazine> liveMagazines = new CopyOnWriteArraySet<Magazine>();
            this.threadLocalMagazine = new FastThreadLocal<Object>(){

                @Override
                protected Object initialValue() {
                    if (cachedMagazinesNonEventLoopThreads || ThreadExecutorMap.currentExecutor() != null) {
                        if (!FastThreadLocalThread.willCleanupFastThreadLocals(Thread.currentThread())) {
                            return NO_MAGAZINE;
                        }
                        Magazine mag = new Magazine(AdaptivePoolingAllocator.this, false);
                        liveMagazines.add(mag);
                        return mag;
                    }
                    return NO_MAGAZINE;
                }

                @Override
                protected void onRemoval(Object value) throws Exception {
                    if (value != NO_MAGAZINE) {
                        liveMagazines.remove(value);
                    }
                }
            };
            this.liveCachedMagazines = liveMagazines;
        } else {
            this.threadLocalMagazine = null;
            this.liveCachedMagazines = null;
        }
        Magazine[] mags = new Magazine[4];
        for (int i2 = 0; i2 < mags.length; ++i2) {
            mags[i2] = new Magazine(this);
        }
        this.magazines = mags;
    }

    private static Queue<Chunk> createSharedChunkQueue() {
        return PlatformDependent.newFixedMpmcQueue(CENTRAL_QUEUE_CAPACITY);
    }

    ByteBuf allocate(int size, int maxCapacity) {
        return this.allocate(size, maxCapacity, Thread.currentThread(), null);
    }

    private AdaptiveByteBuf allocate(int size, int maxCapacity, Thread currentThread, AdaptiveByteBuf buf) {
        if (size <= 0xA00000) {
            Magazine[] mags;
            Object mag;
            int sizeBucket = AllocationStatistics.sizeBucket(size);
            FastThreadLocal<Object> threadLocalMagazine = this.threadLocalMagazine;
            if (threadLocalMagazine != null && currentThread instanceof FastThreadLocalThread && (mag = threadLocalMagazine.get()) != NO_MAGAZINE) {
                Magazine magazine = (Magazine)mag;
                if (buf == null) {
                    buf = magazine.newBuffer();
                }
                boolean allocated = magazine.tryAllocate(size, sizeBucket, maxCapacity, buf);
                assert (allocated) : "Allocation of threadLocalMagazine must always succeed";
                return buf;
            }
            long threadId = currentThread.getId();
            int expansions = 0;
            do {
                mags = this.magazines;
                int mask = mags.length - 1;
                int index = (int)(threadId & (long)mask);
                int m2 = Integer.numberOfTrailingZeros(~mask);
                for (int i2 = 0; i2 < m2; ++i2) {
                    Magazine mag2 = mags[index + i2 & mask];
                    if (buf == null) {
                        buf = mag2.newBuffer();
                    }
                    if (!mag2.tryAllocate(size, sizeBucket, maxCapacity, buf)) continue;
                    return buf;
                }
            } while (++expansions <= 3 && this.tryExpandMagazines(mags.length));
        }
        return this.allocateFallback(size, maxCapacity, currentThread, buf);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private AdaptiveByteBuf allocateFallback(int size, int maxCapacity, Thread currentThread, AdaptiveByteBuf buf) {
        Magazine magazine;
        if (buf != null) {
            Chunk chunk = buf.chunk;
            if (chunk == null || chunk == Magazine.MAGAZINE_FREED || (magazine = chunk.currentMagazine()) == null) {
                magazine = this.getFallbackMagazine(currentThread);
            }
        } else {
            magazine = this.getFallbackMagazine(currentThread);
            buf = magazine.newBuffer();
        }
        AbstractByteBuf innerChunk = this.chunkAllocator.allocate(size, maxCapacity);
        Chunk chunk = new Chunk(innerChunk, magazine, false);
        try {
            chunk.readInitInto(buf, size, maxCapacity);
        }
        finally {
            chunk.release();
        }
        return buf;
    }

    private Magazine getFallbackMagazine(Thread currentThread) {
        Object tlMag;
        FastThreadLocal<Object> threadLocalMagazine = this.threadLocalMagazine;
        if (threadLocalMagazine != null && currentThread instanceof FastThreadLocalThread && (tlMag = threadLocalMagazine.get()) != NO_MAGAZINE) {
            return (Magazine)tlMag;
        }
        Magazine[] mags = this.magazines;
        return mags[(int)currentThread.getId() & mags.length - 1];
    }

    void allocate(int size, int maxCapacity, AdaptiveByteBuf into) {
        AdaptiveByteBuf result = this.allocate(size, maxCapacity, Thread.currentThread(), into);
        assert (result == into) : "Re-allocation created separate buffer instance";
    }

    long usedMemory() {
        long sum = 0L;
        for (Chunk chunk : this.centralQueue) {
            sum += (long)chunk.capacity();
        }
        for (Magazine magazine : this.magazines) {
            sum += magazine.usedMemory.get();
        }
        if (this.liveCachedMagazines != null) {
            for (Magazine magazine : this.liveCachedMagazines) {
                sum += magazine.usedMemory.get();
            }
        }
        return sum;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean tryExpandMagazines(int currentLength) {
        if (currentLength >= MAX_STRIPES) {
            return true;
        }
        long writeLock = this.magazineExpandLock.tryWriteLock();
        if (writeLock != 0L) {
            Magazine[] mags;
            try {
                mags = this.magazines;
                if (mags.length >= MAX_STRIPES || mags.length > currentLength || this.freed) {
                    boolean bl2 = true;
                    return bl2;
                }
                int preferredChunkSize = mags[0].sharedPrefChunkSize;
                Magazine[] expanded = new Magazine[mags.length * 2];
                int l2 = expanded.length;
                for (int i2 = 0; i2 < l2; ++i2) {
                    Magazine m2 = new Magazine(this);
                    m2.localPrefChunkSize = preferredChunkSize;
                    m2.sharedPrefChunkSize = preferredChunkSize;
                    expanded[i2] = m2;
                }
                this.magazines = expanded;
            }
            finally {
                this.magazineExpandLock.unlockWrite(writeLock);
            }
            for (Magazine magazine : mags) {
                magazine.free();
            }
        }
        return true;
    }

    private boolean offerToQueue(Chunk buffer) {
        if (this.freed) {
            return false;
        }
        assert (buffer.allocatedBytes == 0);
        assert (buffer.magazine == null);
        boolean isAdded = this.centralQueue.offer(buffer);
        if (this.freed && isAdded) {
            this.freeCentralQueue();
        }
        return isAdded;
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        }
        finally {
            this.free();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void free() {
        this.freed = true;
        long stamp = this.magazineExpandLock.writeLock();
        try {
            Magazine[] mags;
            for (Magazine magazine : mags = this.magazines) {
                magazine.free();
            }
        }
        finally {
            this.magazineExpandLock.unlockWrite(stamp);
        }
        this.freeCentralQueue();
    }

    private void freeCentralQueue() {
        Chunk chunk;
        while ((chunk = this.centralQueue.poll()) != null) {
            chunk.release();
        }
    }

    static int sizeBucket(int size) {
        return AllocationStatistics.sizeBucket(size);
    }

    static {
        if (MAGAZINE_BUFFER_QUEUE_CAPACITY < 2) {
            throw new IllegalArgumentException("MAGAZINE_BUFFER_QUEUE_CAPACITY: " + MAGAZINE_BUFFER_QUEUE_CAPACITY + " (expected: >= " + 2 + ')');
        }
    }

    static interface ChunkAllocator {
        public AbstractByteBuf allocate(int var1, int var2);
    }

    static final class AdaptiveByteBuf
    extends AbstractReferenceCountedByteBuf {
        private final ObjectPool.Handle<AdaptiveByteBuf> handle;
        private int adjustment;
        private AbstractByteBuf rootParent;
        Chunk chunk;
        private int length;
        private ByteBuffer tmpNioBuf;
        private boolean hasArray;
        private boolean hasMemoryAddress;

        AdaptiveByteBuf(ObjectPool.Handle<AdaptiveByteBuf> recyclerHandle) {
            super(0);
            this.handle = ObjectUtil.checkNotNull(recyclerHandle, "recyclerHandle");
        }

        void init(AbstractByteBuf unwrapped, Chunk wrapped, int readerIndex, int writerIndex, int adjustment, int capacity, int maxCapacity) {
            this.adjustment = adjustment;
            this.chunk = wrapped;
            this.length = capacity;
            this.maxCapacity(maxCapacity);
            this.setIndex0(readerIndex, writerIndex);
            this.hasArray = unwrapped.hasArray();
            this.hasMemoryAddress = unwrapped.hasMemoryAddress();
            this.rootParent = unwrapped;
            this.tmpNioBuf = null;
        }

        private AbstractByteBuf rootParent() {
            AbstractByteBuf rootParent = this.rootParent;
            if (rootParent != null) {
                return rootParent;
            }
            throw new IllegalReferenceCountException();
        }

        @Override
        public int capacity() {
            return this.length;
        }

        @Override
        public ByteBuf capacity(int newCapacity) {
            if (newCapacity == this.capacity()) {
                this.ensureAccessible();
                return this;
            }
            this.checkNewCapacity(newCapacity);
            if (newCapacity < this.capacity()) {
                this.length = newCapacity;
                this.setIndex0(Math.min(this.readerIndex(), newCapacity), Math.min(this.writerIndex(), newCapacity));
                return this;
            }
            Chunk chunk = this.chunk;
            AdaptivePoolingAllocator allocator = chunk.allocator;
            int readerIndex = this.readerIndex;
            int writerIndex = this.writerIndex;
            int baseOldRootIndex = this.adjustment;
            int oldCapacity = this.length;
            AbstractByteBuf oldRoot = this.rootParent();
            allocator.allocate(newCapacity, this.maxCapacity(), this);
            oldRoot.getBytes(baseOldRootIndex, this, 0, oldCapacity);
            chunk.release();
            this.readerIndex = readerIndex;
            this.writerIndex = writerIndex;
            return this;
        }

        @Override
        public ByteBufAllocator alloc() {
            return this.rootParent().alloc();
        }

        @Override
        public ByteOrder order() {
            return this.rootParent().order();
        }

        @Override
        public ByteBuf unwrap() {
            return null;
        }

        @Override
        public boolean isDirect() {
            return this.rootParent().isDirect();
        }

        @Override
        public int arrayOffset() {
            return this.idx(this.rootParent().arrayOffset());
        }

        @Override
        public boolean hasMemoryAddress() {
            return this.hasMemoryAddress;
        }

        @Override
        public long memoryAddress() {
            this.ensureAccessible();
            return this.rootParent().memoryAddress() + (long)this.adjustment;
        }

        @Override
        public ByteBuffer nioBuffer(int index, int length) {
            this.checkIndex(index, length);
            return this.rootParent().nioBuffer(this.idx(index), length);
        }

        @Override
        public ByteBuffer internalNioBuffer(int index, int length) {
            this.checkIndex(index, length);
            return (ByteBuffer)this.internalNioBuffer().position(index).limit(index + length);
        }

        private ByteBuffer internalNioBuffer() {
            if (this.tmpNioBuf == null) {
                this.tmpNioBuf = this.rootParent().internalNioBuffer(this.adjustment, this.length).slice();
            }
            return (ByteBuffer)this.tmpNioBuf.clear();
        }

        @Override
        public ByteBuffer[] nioBuffers(int index, int length) {
            this.checkIndex(index, length);
            return this.rootParent().nioBuffers(this.idx(index), length);
        }

        @Override
        public boolean hasArray() {
            return this.hasArray;
        }

        @Override
        public byte[] array() {
            this.ensureAccessible();
            return this.rootParent().array();
        }

        @Override
        public ByteBuf copy(int index, int length) {
            this.checkIndex(index, length);
            return this.rootParent().copy(this.idx(index), length);
        }

        @Override
        public int nioBufferCount() {
            return this.rootParent().nioBufferCount();
        }

        @Override
        protected byte _getByte(int index) {
            return this.rootParent()._getByte(this.idx(index));
        }

        @Override
        protected short _getShort(int index) {
            return this.rootParent()._getShort(this.idx(index));
        }

        @Override
        protected short _getShortLE(int index) {
            return this.rootParent()._getShortLE(this.idx(index));
        }

        @Override
        protected int _getUnsignedMedium(int index) {
            return this.rootParent()._getUnsignedMedium(this.idx(index));
        }

        @Override
        protected int _getUnsignedMediumLE(int index) {
            return this.rootParent()._getUnsignedMediumLE(this.idx(index));
        }

        @Override
        protected int _getInt(int index) {
            return this.rootParent()._getInt(this.idx(index));
        }

        @Override
        protected int _getIntLE(int index) {
            return this.rootParent()._getIntLE(this.idx(index));
        }

        @Override
        protected long _getLong(int index) {
            return this.rootParent()._getLong(this.idx(index));
        }

        @Override
        protected long _getLongLE(int index) {
            return this.rootParent()._getLongLE(this.idx(index));
        }

        @Override
        public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
            this.checkIndex(index, length);
            this.rootParent().getBytes(this.idx(index), dst, dstIndex, length);
            return this;
        }

        @Override
        public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
            this.checkIndex(index, length);
            this.rootParent().getBytes(this.idx(index), dst, dstIndex, length);
            return this;
        }

        @Override
        public ByteBuf getBytes(int index, ByteBuffer dst) {
            this.checkIndex(index, dst.remaining());
            this.rootParent().getBytes(this.idx(index), dst);
            return this;
        }

        @Override
        protected void _setByte(int index, int value) {
            this.rootParent()._setByte(this.idx(index), value);
        }

        @Override
        protected void _setShort(int index, int value) {
            this.rootParent()._setShort(this.idx(index), value);
        }

        @Override
        protected void _setShortLE(int index, int value) {
            this.rootParent()._setShortLE(this.idx(index), value);
        }

        @Override
        protected void _setMedium(int index, int value) {
            this.rootParent()._setMedium(this.idx(index), value);
        }

        @Override
        protected void _setMediumLE(int index, int value) {
            this.rootParent()._setMediumLE(this.idx(index), value);
        }

        @Override
        protected void _setInt(int index, int value) {
            this.rootParent()._setInt(this.idx(index), value);
        }

        @Override
        protected void _setIntLE(int index, int value) {
            this.rootParent()._setIntLE(this.idx(index), value);
        }

        @Override
        protected void _setLong(int index, long value) {
            this.rootParent()._setLong(this.idx(index), value);
        }

        @Override
        protected void _setLongLE(int index, long value) {
            this.rootParent().setLongLE(this.idx(index), value);
        }

        @Override
        public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
            this.checkIndex(index, length);
            this.rootParent().setBytes(this.idx(index), src, srcIndex, length);
            return this;
        }

        @Override
        public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
            this.checkIndex(index, length);
            this.rootParent().setBytes(this.idx(index), src, srcIndex, length);
            return this;
        }

        @Override
        public ByteBuf setBytes(int index, ByteBuffer src) {
            this.checkIndex(index, src.remaining());
            this.rootParent().setBytes(this.idx(index), src);
            return this;
        }

        @Override
        public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
            this.checkIndex(index, length);
            if (length != 0) {
                ByteBufUtil.readBytes(this.alloc(), this.internalNioBuffer().duplicate(), index, length, out);
            }
            return this;
        }

        @Override
        public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
            return out.write(this.internalNioBuffer(index, length).duplicate());
        }

        @Override
        public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
            return out.write(this.internalNioBuffer(index, length).duplicate(), position);
        }

        @Override
        public int setBytes(int index, InputStream in, int length) throws IOException {
            this.checkIndex(index, length);
            AbstractByteBuf rootParent = this.rootParent();
            if (rootParent.hasArray()) {
                return rootParent.setBytes(this.idx(index), in, length);
            }
            byte[] tmp = ByteBufUtil.threadLocalTempArray(length);
            int readBytes = in.read(tmp, 0, length);
            if (readBytes <= 0) {
                return readBytes;
            }
            this.setBytes(index, tmp, 0, readBytes);
            return readBytes;
        }

        @Override
        public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
            try {
                return in.read(this.internalNioBuffer(index, length).duplicate());
            }
            catch (ClosedChannelException ignored) {
                return -1;
            }
        }

        @Override
        public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
            try {
                return in.read(this.internalNioBuffer(index, length).duplicate(), position);
            }
            catch (ClosedChannelException ignored) {
                return -1;
            }
        }

        @Override
        public int forEachByte(int index, int length, ByteProcessor processor) {
            this.checkIndex(index, length);
            int ret = this.rootParent().forEachByte(this.idx(index), length, processor);
            return this.forEachResult(ret);
        }

        @Override
        public int forEachByteDesc(int index, int length, ByteProcessor processor) {
            this.checkIndex(index, length);
            int ret = this.rootParent().forEachByteDesc(this.idx(index), length, processor);
            return this.forEachResult(ret);
        }

        private int forEachResult(int ret) {
            if (ret < this.adjustment) {
                return -1;
            }
            return ret - this.adjustment;
        }

        @Override
        public boolean isContiguous() {
            return this.rootParent().isContiguous();
        }

        private int idx(int index) {
            return index + this.adjustment;
        }

        @Override
        protected void deallocate() {
            if (this.chunk != null) {
                this.chunk.release();
            }
            this.tmpNioBuf = null;
            this.chunk = null;
            this.rootParent = null;
            if (this.handle instanceof Recycler.EnhancedHandle) {
                Recycler.EnhancedHandle enhancedHandle = (Recycler.EnhancedHandle)this.handle;
                enhancedHandle.unguardedRecycle(this);
            } else {
                this.handle.recycle(this);
            }
        }
    }

    private static final class Chunk
    implements ReferenceCounted {
        private final AbstractByteBuf delegate;
        private Magazine magazine;
        private final AdaptivePoolingAllocator allocator;
        private final int capacity;
        private final boolean pooled;
        private int allocatedBytes;
        private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(Chunk.class, "refCnt");
        private static final AtomicIntegerFieldUpdater<Chunk> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(Chunk.class, "refCnt");
        private static final ReferenceCountUpdater<Chunk> updater = new ReferenceCountUpdater<Chunk>(){

            @Override
            protected AtomicIntegerFieldUpdater<Chunk> updater() {
                return AIF_UPDATER;
            }

            @Override
            protected long unsafeOffset() {
                return REFCNT_FIELD_OFFSET;
            }
        };
        private volatile int refCnt;

        Chunk() {
            this.delegate = null;
            this.magazine = null;
            this.allocator = null;
            this.capacity = 0;
            this.pooled = false;
        }

        Chunk(AbstractByteBuf delegate, Magazine magazine, boolean pooled) {
            this.delegate = delegate;
            this.pooled = pooled;
            this.capacity = delegate.capacity();
            updater.setInitialValue(this);
            this.allocator = magazine.parent;
            this.attachToMagazine(magazine);
        }

        Magazine currentMagazine() {
            return this.magazine;
        }

        void detachFromMagazine() {
            if (this.magazine != null) {
                this.magazine.usedMemory.getAndAdd(-this.capacity);
                this.magazine = null;
            }
        }

        void attachToMagazine(Magazine magazine) {
            assert (this.magazine == null);
            this.magazine = magazine;
            magazine.usedMemory.getAndAdd(this.capacity);
        }

        @Override
        public Chunk touch(Object hint) {
            return this;
        }

        @Override
        public int refCnt() {
            return updater.refCnt(this);
        }

        @Override
        public Chunk retain() {
            return updater.retain(this);
        }

        @Override
        public Chunk retain(int increment) {
            return updater.retain(this, increment);
        }

        @Override
        public Chunk touch() {
            return this;
        }

        @Override
        public boolean release() {
            if (updater.release(this)) {
                this.deallocate();
                return true;
            }
            return false;
        }

        @Override
        public boolean release(int decrement) {
            if (updater.release(this, decrement)) {
                this.deallocate();
                return true;
            }
            return false;
        }

        private void deallocate() {
            Magazine mag = this.magazine;
            AdaptivePoolingAllocator parent = mag.parent;
            int chunkSize = mag.preferredChunkSize();
            int memSize = this.delegate.capacity();
            if (!this.pooled || Chunk.shouldReleaseSuboptimalChunkSize(memSize, chunkSize)) {
                this.detachFromMagazine();
                this.delegate.release();
            } else {
                updater.resetRefCnt(this);
                this.delegate.setIndex(0, 0);
                this.allocatedBytes = 0;
                if (!mag.trySetNextInLine(this)) {
                    this.detachFromMagazine();
                    if (!parent.offerToQueue(this)) {
                        boolean released = updater.release(this);
                        this.delegate.release();
                        assert (released);
                    }
                }
            }
        }

        private static boolean shouldReleaseSuboptimalChunkSize(int givenSize, int preferredSize) {
            int givenChunks = givenSize / 131072;
            int preferredChunks = preferredSize / 131072;
            int deviation = Math.abs(givenChunks - preferredChunks);
            return deviation != 0 && ThreadLocalRandom.current().nextDouble() * 20.0 < (double)deviation;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void readInitInto(AdaptiveByteBuf buf, int size, int maxCapacity) {
            int startIndex = this.allocatedBytes;
            this.allocatedBytes = startIndex + size;
            Chunk chunk = this;
            chunk.retain();
            try {
                buf.init(this.delegate, chunk, 0, 0, startIndex, size, maxCapacity);
                chunk = null;
            }
            finally {
                if (chunk != null) {
                    this.allocatedBytes = startIndex;
                    chunk.release();
                }
            }
        }

        public int remainingCapacity() {
            return this.capacity - this.allocatedBytes;
        }

        public int capacity() {
            return this.capacity;
        }
    }

    private static final class Magazine
    extends AllocationStatistics {
        private static final AtomicReferenceFieldUpdater<Magazine, Chunk> NEXT_IN_LINE = AtomicReferenceFieldUpdater.newUpdater(Magazine.class, Chunk.class, "nextInLine");
        private static final Chunk MAGAZINE_FREED = new Chunk();
        private static final ObjectPool<AdaptiveByteBuf> EVENT_LOOP_LOCAL_BUFFER_POOL = ObjectPool.newPool(new ObjectPool.ObjectCreator<AdaptiveByteBuf>(){

            @Override
            public AdaptiveByteBuf newObject(ObjectPool.Handle<AdaptiveByteBuf> handle) {
                return new AdaptiveByteBuf(handle);
            }
        });
        private Chunk current;
        private volatile Chunk nextInLine;
        private final AtomicLong usedMemory;
        private final StampedLock allocationLock;
        private final Queue<AdaptiveByteBuf> bufferQueue;
        private final ObjectPool.Handle<AdaptiveByteBuf> handle;

        Magazine(AdaptivePoolingAllocator parent) {
            this(parent, true);
        }

        Magazine(AdaptivePoolingAllocator parent, boolean shareable) {
            super(parent, shareable);
            if (shareable) {
                this.allocationLock = new StampedLock();
                this.bufferQueue = PlatformDependent.newFixedMpmcQueue(MAGAZINE_BUFFER_QUEUE_CAPACITY);
                this.handle = new ObjectPool.Handle<AdaptiveByteBuf>(){

                    @Override
                    public void recycle(AdaptiveByteBuf self) {
                        bufferQueue.offer(self);
                    }
                };
            } else {
                this.allocationLock = null;
                this.bufferQueue = null;
                this.handle = null;
            }
            this.usedMemory = new AtomicLong();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean tryAllocate(int size, int sizeBucket, int maxCapacity, AdaptiveByteBuf buf) {
            if (this.allocationLock == null) {
                return this.allocate(size, sizeBucket, maxCapacity, buf);
            }
            long writeLock = this.allocationLock.tryWriteLock();
            if (writeLock != 0L) {
                try {
                    boolean bl2 = this.allocate(size, sizeBucket, maxCapacity, buf);
                    return bl2;
                }
                finally {
                    this.allocationLock.unlockWrite(writeLock);
                }
            }
            return this.allocateWithoutLock(size, maxCapacity, buf);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private boolean allocateWithoutLock(int size, int maxCapacity, AdaptiveByteBuf buf) {
            Chunk curr = NEXT_IN_LINE.getAndSet(this, null);
            if (curr == MAGAZINE_FREED) {
                this.restoreMagazineFreed();
                return false;
            }
            if (curr == null) {
                curr = (Chunk)this.parent.centralQueue.poll();
                if (curr == null) {
                    return false;
                }
                curr.attachToMagazine(this);
            }
            boolean allocated = false;
            if (curr.remainingCapacity() >= size) {
                curr.readInitInto(buf, size, maxCapacity);
                allocated = true;
            }
            try {
                if (curr.remainingCapacity() >= 4096) {
                    this.transferToNextInLineOrRelease(curr);
                    curr = null;
                }
            }
            finally {
                if (curr != null) {
                    curr.release();
                }
            }
            return allocated;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private boolean allocate(int size, int sizeBucket, int maxCapacity, AdaptiveByteBuf buf) {
            this.recordAllocationSize(sizeBucket);
            Chunk curr = this.current;
            if (curr != null) {
                if (curr.remainingCapacity() > size) {
                    curr.readInitInto(buf, size, maxCapacity);
                    return true;
                }
                this.current = null;
                if (curr.remainingCapacity() == size) {
                    try {
                        curr.readInitInto(buf, size, maxCapacity);
                        boolean bl2 = true;
                        return bl2;
                    }
                    finally {
                        curr.release();
                    }
                }
                if (curr.remainingCapacity() < 4096) {
                    curr.release();
                } else {
                    this.transferToNextInLineOrRelease(curr);
                }
            }
            assert (this.current == null);
            curr = NEXT_IN_LINE.getAndSet(this, null);
            if (curr != null) {
                if (curr == MAGAZINE_FREED) {
                    this.restoreMagazineFreed();
                    return false;
                }
                if (curr.remainingCapacity() > size) {
                    curr.readInitInto(buf, size, maxCapacity);
                    this.current = curr;
                    return true;
                }
                if (curr.remainingCapacity() == size) {
                    try {
                        curr.readInitInto(buf, size, maxCapacity);
                        boolean bl3 = true;
                        return bl3;
                    }
                    finally {
                        curr.release();
                    }
                }
                curr.release();
            }
            if ((curr = (Chunk)this.parent.centralQueue.poll()) == null) {
                curr = this.newChunkAllocation(size);
            } else {
                curr.attachToMagazine(this);
                if (curr.remainingCapacity() < size) {
                    if (curr.remainingCapacity() < 4096) {
                        curr.release();
                    } else {
                        this.transferToNextInLineOrRelease(curr);
                    }
                    curr = this.newChunkAllocation(size);
                }
            }
            this.current = curr;
            try {
                assert (this.current.remainingCapacity() >= size);
                if (curr.remainingCapacity() > size) {
                    curr.readInitInto(buf, size, maxCapacity);
                    curr = null;
                } else {
                    curr.readInitInto(buf, size, maxCapacity);
                }
            }
            finally {
                if (curr != null) {
                    curr.release();
                    this.current = null;
                }
            }
            return true;
        }

        private void restoreMagazineFreed() {
            Chunk next = NEXT_IN_LINE.getAndSet(this, MAGAZINE_FREED);
            if (next != null && next != MAGAZINE_FREED) {
                next.release();
            }
        }

        private void transferToNextInLineOrRelease(Chunk chunk) {
            if (NEXT_IN_LINE.compareAndSet(this, null, chunk)) {
                return;
            }
            Chunk nextChunk = NEXT_IN_LINE.get(this);
            if (nextChunk != null && nextChunk != MAGAZINE_FREED && chunk.remainingCapacity() > nextChunk.remainingCapacity() && NEXT_IN_LINE.compareAndSet(this, nextChunk, chunk)) {
                nextChunk.release();
                return;
            }
            chunk.release();
        }

        private Chunk newChunkAllocation(int promptingSize) {
            int size = Math.max(promptingSize * 10, this.preferredChunkSize());
            int minChunks = size / 131072;
            if (131072 * minChunks < size) {
                size = 131072 * (1 + minChunks);
            }
            ChunkAllocator chunkAllocator = this.parent.chunkAllocator;
            return new Chunk(chunkAllocator.allocate(size, size), this, true);
        }

        boolean trySetNextInLine(Chunk chunk) {
            return NEXT_IN_LINE.compareAndSet(this, null, chunk);
        }

        void free() {
            this.restoreMagazineFreed();
            long stamp = this.allocationLock.writeLock();
            try {
                if (this.current != null) {
                    this.current.release();
                    this.current = null;
                }
            }
            finally {
                this.allocationLock.unlockWrite(stamp);
            }
        }

        public AdaptiveByteBuf newBuffer() {
            AdaptiveByteBuf buf;
            if (this.handle == null) {
                buf = EVENT_LOOP_LOCAL_BUFFER_POOL.get();
            } else {
                buf = this.bufferQueue.poll();
                if (buf == null) {
                    buf = new AdaptiveByteBuf(this.handle);
                }
            }
            buf.resetRefCnt();
            buf.discardMarks();
            return buf;
        }
    }

    private static class AllocationStatistics {
        private static final int MIN_DATUM_TARGET = 1024;
        private static final int MAX_DATUM_TARGET = 65534;
        private static final int INIT_DATUM_TARGET = 9;
        private static final int HISTO_MIN_BUCKET_SHIFT = 13;
        private static final int HISTO_MAX_BUCKET_SHIFT = 20;
        private static final int HISTO_BUCKET_COUNT = 8;
        private static final int HISTO_MAX_BUCKET_MASK = 7;
        private static final int SIZE_MAX_MASK = 0x9FFFFF;
        protected final AdaptivePoolingAllocator parent;
        private final boolean shareable;
        private final short[][] histos = new short[][]{new short[8], new short[8], new short[8], new short[8]};
        private short[] histo = this.histos[0];
        private final int[] sums = new int[8];
        private int histoIndex;
        private int datumCount;
        private int datumTarget = 9;
        protected volatile int sharedPrefChunkSize = 131072;
        protected volatile int localPrefChunkSize = 131072;

        private AllocationStatistics(AdaptivePoolingAllocator parent, boolean shareable) {
            this.parent = parent;
            this.shareable = shareable;
        }

        protected void recordAllocationSize(int bucket) {
            int n2 = bucket;
            this.histo[n2] = (short)(this.histo[n2] + 1);
            if (this.datumCount++ == this.datumTarget) {
                this.rotateHistograms();
            }
        }

        static int sizeBucket(int size) {
            if (size == 0) {
                return 0;
            }
            int normalizedSize = size - 1 >> 13 & 0x9FFFFF;
            return Math.min(32 - Integer.numberOfLeadingZeros(normalizedSize), 7);
        }

        private void rotateHistograms() {
            int prefChunkSize;
            int sizeBucket;
            short[][] hs = this.histos;
            for (int i2 = 0; i2 < 8; ++i2) {
                this.sums[i2] = (hs[0][i2] & 0xFFFF) + (hs[1][i2] & 0xFFFF) + (hs[2][i2] & 0xFFFF) + (hs[3][i2] & 0xFFFF);
            }
            int sum = 0;
            for (int count : this.sums) {
                sum += count;
            }
            int targetPercentile = (int)((double)sum * 0.99);
            for (sizeBucket = 0; sizeBucket < this.sums.length && this.sums[sizeBucket] <= targetPercentile; targetPercentile -= this.sums[sizeBucket], ++sizeBucket) {
            }
            int percentileSize = 1 << sizeBucket + 13;
            this.localPrefChunkSize = prefChunkSize = Math.max(percentileSize * 10, 131072);
            if (this.shareable) {
                for (Magazine mag : this.parent.magazines) {
                    prefChunkSize = Math.max(prefChunkSize, mag.localPrefChunkSize);
                }
            }
            if (this.sharedPrefChunkSize != prefChunkSize) {
                this.datumTarget = Math.max(this.datumTarget >> 1, 1024);
                this.sharedPrefChunkSize = prefChunkSize;
            } else {
                this.datumTarget = Math.min(this.datumTarget << 1, 65534);
            }
            this.histoIndex = this.histoIndex + 1 & 3;
            this.histo = this.histos[this.histoIndex];
            this.datumCount = 0;
            Arrays.fill(this.histo, (short)0);
        }

        protected int preferredChunkSize() {
            return this.sharedPrefChunkSize;
        }
    }

    static enum MagazineCaching {
        EventLoopThreads,
        FastThreadLocalThreads,
        None;

    }
}

