/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractReferenceCountedByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufHolder;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.AbstractChannel;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPipeline;
import net.darkmeow.irc.lib.io.netty.channel.ChannelProgressivePromise;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.DefaultChannelProgressivePromise;
import net.darkmeow.irc.lib.io.netty.channel.DefaultChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.FileRegion;
import net.darkmeow.irc.lib.io.netty.channel.VoidChannelPromise;
import net.darkmeow.irc.lib.io.netty.util.Recycler;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCountUtil;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FastThreadLocal;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectPool;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PromiseNotificationUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public final class ChannelOutboundBuffer {
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.transport.outboundBufferEntrySizeOverhead", 96);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>(){

        @Override
        protected ByteBuffer[] initialValue() throws Exception {
            return new ByteBuffer[1024];
        }
    };
    private final Channel channel;
    private Entry flushedEntry;
    private Entry unflushedEntry;
    private Entry tailEntry;
    private int flushed;
    private int nioBufferCount;
    private long nioBufferSize;
    private boolean inFail;
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
    private volatile long totalPendingSize;
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
    private volatile int unwritable;
    private volatile Runnable fireChannelWritabilityChangedTask;

    ChannelOutboundBuffer(AbstractChannel channel) {
        this.channel = channel;
    }

    public void addMessage(Object msg, int size, ChannelPromise promise) {
        Entry entry = Entry.newInstance(msg, size, ChannelOutboundBuffer.total(msg), promise);
        if (this.tailEntry == null) {
            this.flushedEntry = null;
        } else {
            Entry tail = this.tailEntry;
            tail.next = entry;
        }
        this.tailEntry = entry;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = entry;
        }
        if (msg instanceof AbstractReferenceCountedByteBuf) {
            ((AbstractReferenceCountedByteBuf)msg).touch();
        } else {
            ReferenceCountUtil.touch(msg);
        }
        this.incrementPendingOutboundBytes(entry.pendingSize, false);
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                ++this.flushed;
                if (entry.promise.setUncancellable()) continue;
                int pending = entry.cancel();
                this.decrementPendingOutboundBytes(pending, false, true);
            } while ((entry = entry.next) != null);
            this.unflushedEntry = null;
        }
    }

    void incrementPendingOutboundBytes(long size) {
        this.incrementPendingOutboundBytes(size, true);
    }

    private void incrementPendingOutboundBytes(long size, boolean invokeLater) {
        if (size == 0L) {
            return;
        }
        long newWriteBufferSize = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, size);
        if (newWriteBufferSize > (long)this.channel.config().getWriteBufferHighWaterMark()) {
            this.setUnwritable(invokeLater);
        }
    }

    void decrementPendingOutboundBytes(long size) {
        this.decrementPendingOutboundBytes(size, true, true);
    }

    private void decrementPendingOutboundBytes(long size, boolean invokeLater, boolean notifyWritability) {
        if (size == 0L) {
            return;
        }
        long newWriteBufferSize = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -size);
        if (notifyWritability && newWriteBufferSize < (long)this.channel.config().getWriteBufferLowWaterMark()) {
            this.setWritable(invokeLater);
        }
    }

    private static long total(Object msg) {
        if (msg instanceof ByteBuf) {
            return ((ByteBuf)msg).readableBytes();
        }
        if (msg instanceof FileRegion) {
            return ((FileRegion)msg).count();
        }
        if (msg instanceof ByteBufHolder) {
            return ((ByteBufHolder)msg).content().readableBytes();
        }
        return -1L;
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    public long currentProgress() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return 0L;
        }
        return entry.progress;
    }

    public void progress(long amount) {
        long progress;
        Entry e2 = this.flushedEntry;
        assert (e2 != null);
        ChannelPromise p2 = e2.promise;
        e2.progress = progress = e2.progress + amount;
        assert (p2 != null);
        Class<?> promiseClass = p2.getClass();
        if (promiseClass == VoidChannelPromise.class || promiseClass == DefaultChannelPromise.class) {
            return;
        }
        if (p2 instanceof DefaultChannelProgressivePromise) {
            ((DefaultChannelProgressivePromise)p2).tryProgress(progress, e2.total);
        } else if (p2 instanceof ChannelProgressivePromise) {
            ((ChannelProgressivePromise)p2).tryProgress(progress, e2.total);
        }
    }

    public boolean remove() {
        Entry e2 = this.flushedEntry;
        if (e2 == null) {
            this.clearNioBuffers();
            return false;
        }
        Object msg = e2.msg;
        ChannelPromise promise = e2.promise;
        int size = e2.pendingSize;
        this.removeEntry(e2);
        if (!e2.cancelled) {
            if (msg instanceof AbstractReferenceCountedByteBuf) {
                try {
                    ((AbstractReferenceCountedByteBuf)msg).release();
                }
                catch (Throwable t2) {
                    logger.warn("Failed to release a ByteBuf: {}", msg, (Object)t2);
                }
            } else {
                ReferenceCountUtil.safeRelease(msg);
            }
            ChannelOutboundBuffer.safeSuccess(promise);
            this.decrementPendingOutboundBytes(size, false, true);
        }
        e2.unguardedRecycle();
        return true;
    }

    public boolean remove(Throwable cause) {
        return this.remove0(cause, true);
    }

    private boolean remove0(Throwable cause, boolean notifyWritability) {
        Entry e2 = this.flushedEntry;
        if (e2 == null) {
            this.clearNioBuffers();
            return false;
        }
        Object msg = e2.msg;
        ChannelPromise promise = e2.promise;
        int size = e2.pendingSize;
        this.removeEntry(e2);
        if (!e2.cancelled) {
            ReferenceCountUtil.safeRelease(msg);
            ChannelOutboundBuffer.safeFail(promise, cause);
            this.decrementPendingOutboundBytes(size, false, notifyWritability);
        }
        e2.unguardedRecycle();
        return true;
    }

    private void removeEntry(Entry e2) {
        if (--this.flushed == 0) {
            this.flushedEntry = null;
            if (e2 == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
            }
        } else {
            this.flushedEntry = e2.next;
        }
    }

    public void removeBytes(long writtenBytes) {
        block5: {
            int readerIndex;
            ByteBuf buf;
            while (true) {
                Object msg;
                if (!((msg = this.current()) instanceof ByteBuf)) {
                    assert (writtenBytes == 0L);
                    break block5;
                }
                buf = (ByteBuf)msg;
                readerIndex = buf.readerIndex();
                int readableBytes = buf.writerIndex() - readerIndex;
                if ((long)readableBytes > writtenBytes) break;
                if (writtenBytes != 0L) {
                    this.progress(readableBytes);
                    writtenBytes -= (long)readableBytes;
                }
                this.remove();
            }
            if (writtenBytes != 0L) {
                buf.readerIndex(readerIndex + (int)writtenBytes);
                this.progress(writtenBytes);
            }
        }
        this.clearNioBuffers();
    }

    private void clearNioBuffers() {
        int count = this.nioBufferCount;
        if (count > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, count, null);
        }
    }

    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public ByteBuffer[] nioBuffers(int maxCount, long maxBytes) {
        assert (maxCount > 0);
        assert (maxBytes > 0L);
        long nioBufferSize = 0L;
        int nioBufferCount = 0;
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] nioBuffers = NIO_BUFFERS.get(threadLocalMap);
        Entry entry = this.flushedEntry;
        while (this.isFlushedEntry(entry) && entry.msg instanceof ByteBuf) {
            if (!entry.cancelled) {
                ByteBuf buf = (ByteBuf)entry.msg;
                int readerIndex = buf.readerIndex();
                int readableBytes = buf.writerIndex() - readerIndex;
                if (readableBytes > 0) {
                    int neededSpace;
                    if (maxBytes - (long)readableBytes < nioBufferSize && nioBufferCount != 0) break;
                    nioBufferSize += (long)readableBytes;
                    int count = entry.count;
                    if (count == -1) {
                        entry.count = count = buf.nioBufferCount();
                    }
                    if ((neededSpace = Math.min(maxCount, nioBufferCount + count)) > nioBuffers.length) {
                        nioBuffers = ChannelOutboundBuffer.expandNioBufferArray(nioBuffers, neededSpace, nioBufferCount);
                        NIO_BUFFERS.set(threadLocalMap, nioBuffers);
                    }
                    if (count == 1) {
                        ByteBuffer nioBuf = entry.buf;
                        if (nioBuf == null) {
                            entry.buf = nioBuf = buf.internalNioBuffer(readerIndex, readableBytes);
                        }
                        nioBuffers[nioBufferCount++] = nioBuf;
                    } else {
                        nioBufferCount = ChannelOutboundBuffer.nioBuffers(entry, buf, nioBuffers, nioBufferCount, maxCount);
                    }
                    if (nioBufferCount >= maxCount) break;
                }
            }
            entry = entry.next;
        }
        this.nioBufferCount = nioBufferCount;
        this.nioBufferSize = nioBufferSize;
        return nioBuffers;
    }

    private static int nioBuffers(Entry entry, ByteBuf buf, ByteBuffer[] nioBuffers, int nioBufferCount, int maxCount) {
        ByteBuffer nioBuf;
        ByteBuffer[] nioBufs = entry.bufs;
        if (nioBufs == null) {
            entry.bufs = nioBufs = buf.nioBuffers();
        }
        for (int i2 = 0; i2 < nioBufs.length && nioBufferCount < maxCount && (nioBuf = nioBufs[i2]) != null; ++i2) {
            if (!nioBuf.hasRemaining()) continue;
            nioBuffers[nioBufferCount++] = nioBuf;
        }
        return nioBufferCount;
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] array, int neededSpace, int size) {
        int newCapacity = array.length;
        do {
            if ((newCapacity <<= 1) >= 0) continue;
            throw new IllegalStateException();
        } while (neededSpace > newCapacity);
        ByteBuffer[] newArray = new ByteBuffer[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public boolean getUserDefinedWritability(int index) {
        return (this.unwritable & ChannelOutboundBuffer.writabilityMask(index)) == 0;
    }

    public void setUserDefinedWritability(int index, boolean writable) {
        if (writable) {
            this.setUserDefinedWritability(index);
        } else {
            this.clearUserDefinedWritability(index);
        }
    }

    private void setUserDefinedWritability(int index) {
        block1: {
            int newValue;
            int oldValue;
            int mask = ~ChannelOutboundBuffer.writabilityMask(index);
            while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue = this.unwritable, newValue = oldValue & mask)) {
            }
            if (oldValue == 0 || newValue != 0) break block1;
            this.fireChannelWritabilityChanged(true);
        }
    }

    private void clearUserDefinedWritability(int index) {
        block1: {
            int newValue;
            int oldValue;
            int mask = ChannelOutboundBuffer.writabilityMask(index);
            while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue = this.unwritable, newValue = oldValue | mask)) {
            }
            if (oldValue != 0 || newValue == 0) break block1;
            this.fireChannelWritabilityChanged(true);
        }
    }

    private static int writabilityMask(int index) {
        if (index < 1 || index > 31) {
            throw new IllegalArgumentException("index: " + index + " (expected: 1~31)");
        }
        return 1 << index;
    }

    private void setWritable(boolean invokeLater) {
        block1: {
            int newValue;
            int oldValue;
            while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue = this.unwritable, newValue = oldValue & 0xFFFFFFFE)) {
            }
            if (oldValue == 0 || newValue != 0) break block1;
            this.fireChannelWritabilityChanged(invokeLater);
        }
    }

    private void setUnwritable(boolean invokeLater) {
        block1: {
            int newValue;
            int oldValue;
            while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue = this.unwritable, newValue = oldValue | 1)) {
            }
            if (oldValue != 0) break block1;
            this.fireChannelWritabilityChanged(invokeLater);
        }
    }

    private void fireChannelWritabilityChanged(boolean invokeLater) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (invokeLater) {
            Runnable task = this.fireChannelWritabilityChangedTask;
            if (task == null) {
                this.fireChannelWritabilityChangedTask = task = new Runnable(){

                    @Override
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
            }
            this.channel.eventLoop().execute(task);
        } else {
            pipeline.fireChannelWritabilityChanged();
        }
    }

    public int size() {
        return this.flushed;
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    void failFlushed(Throwable cause, boolean notify) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            while (this.remove0(cause, notify)) {
            }
        }
        finally {
            this.inFail = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void close(final Throwable cause, final boolean allowChannelOpen) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    ChannelOutboundBuffer.this.close(cause, allowChannelOpen);
                }
            });
            return;
        }
        this.inFail = true;
        if (!allowChannelOpen && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!this.isEmpty()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            for (Entry e2 = this.unflushedEntry; e2 != null; e2 = e2.unguardedRecycleAndGetNext()) {
                int size = e2.pendingSize;
                TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -size);
                if (e2.cancelled) continue;
                ReferenceCountUtil.safeRelease(e2.msg);
                ChannelOutboundBuffer.safeFail(e2.promise, cause);
            }
        }
        finally {
            this.inFail = false;
        }
        this.clearNioBuffers();
    }

    void close(ClosedChannelException cause) {
        this.close(cause, false);
    }

    private static void safeSuccess(ChannelPromise promise) {
        PromiseNotificationUtil.trySuccess(promise, null, promise instanceof VoidChannelPromise ? null : logger);
    }

    private static void safeFail(ChannelPromise promise, Throwable cause) {
        PromiseNotificationUtil.tryFailure(promise, cause, promise instanceof VoidChannelPromise ? null : logger);
    }

    @Deprecated
    public void recycle() {
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    public long bytesBeforeUnwritable() {
        long bytes = (long)this.channel.config().getWriteBufferHighWaterMark() - this.totalPendingSize + 1L;
        return bytes > 0L && this.isWritable() ? bytes : 0L;
    }

    public long bytesBeforeWritable() {
        long bytes = this.totalPendingSize - (long)this.channel.config().getWriteBufferLowWaterMark() + 1L;
        return bytes <= 0L || this.isWritable() ? 0L : bytes;
    }

    public void forEachFlushedMessage(MessageProcessor processor) throws Exception {
        ObjectUtil.checkNotNull(processor, "processor");
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return;
        }
        do {
            if (entry.cancelled || processor.processMessage(entry.msg)) continue;
            return;
        } while (this.isFlushedEntry(entry = entry.next));
    }

    private boolean isFlushedEntry(Entry e2) {
        return e2 != null && e2 != this.unflushedEntry;
    }

    static final class Entry {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>(){

            @Override
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        private final Recycler.EnhancedHandle<Entry> handle;
        Entry next;
        Object msg;
        ByteBuffer[] bufs;
        ByteBuffer buf;
        ChannelPromise promise;
        long progress;
        long total;
        int pendingSize;
        int count = -1;
        boolean cancelled;

        private Entry(ObjectPool.Handle<Entry> handle) {
            this.handle = (Recycler.EnhancedHandle)handle;
        }

        static Entry newInstance(Object msg, int size, long total, ChannelPromise promise) {
            Entry entry = RECYCLER.get();
            entry.msg = msg;
            entry.pendingSize = size + CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = total;
            entry.promise = promise;
            return entry;
        }

        int cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                int pSize = this.pendingSize;
                ReferenceCountUtil.safeRelease(this.msg);
                this.msg = Unpooled.EMPTY_BUFFER;
                this.pendingSize = 0;
                this.total = 0L;
                this.progress = 0L;
                this.bufs = null;
                this.buf = null;
                return pSize;
            }
            return 0;
        }

        void unguardedRecycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.unguardedRecycle(this);
        }

        Entry unguardedRecycleAndGetNext() {
            Entry next = this.next;
            this.unguardedRecycle();
            return next;
        }
    }

    public static interface MessageProcessor {
        public boolean processMessage(Object var1) throws Exception;
    }
}

