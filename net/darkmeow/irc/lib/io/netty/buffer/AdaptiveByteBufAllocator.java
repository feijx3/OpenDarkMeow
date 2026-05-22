/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import net.darkmeow.irc.lib.io.netty.buffer.AbstractByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.AdaptivePoolingAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocatorMetric;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocatorMetricProvider;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledHeapByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledUnsafeHeapByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnsafeByteBufUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public final class AdaptiveByteBufAllocator
extends AbstractByteBufAllocator
implements ByteBufAllocatorMetricProvider,
ByteBufAllocatorMetric {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AdaptiveByteBufAllocator.class);
    private static final boolean DEFAULT_USE_CACHED_MAGAZINES_FOR_NON_EVENT_LOOP_THREADS = SystemPropertyUtil.getBoolean("net.darkmeow.irc.lib.io.netty.allocator.useCachedMagazinesForNonEventLoopThreads", false);
    private final AdaptivePoolingAllocator direct;
    private final AdaptivePoolingAllocator heap;

    public AdaptiveByteBufAllocator() {
        this(PlatformDependent.directBufferPreferred());
    }

    public AdaptiveByteBufAllocator(boolean preferDirect) {
        this(preferDirect, DEFAULT_USE_CACHED_MAGAZINES_FOR_NON_EVENT_LOOP_THREADS);
    }

    public AdaptiveByteBufAllocator(boolean preferDirect, boolean useCacheForNonEventLoopThreads) {
        super(preferDirect);
        AdaptivePoolingAllocator.MagazineCaching magazineCaching = useCacheForNonEventLoopThreads ? AdaptivePoolingAllocator.MagazineCaching.FastThreadLocalThreads : AdaptivePoolingAllocator.MagazineCaching.EventLoopThreads;
        this.direct = new AdaptivePoolingAllocator(new DirectChunkAllocator(this), magazineCaching);
        this.heap = new AdaptivePoolingAllocator(new HeapChunkAllocator(this), magazineCaching);
    }

    @Override
    protected ByteBuf newHeapBuffer(int initialCapacity, int maxCapacity) {
        return AdaptiveByteBufAllocator.toLeakAwareBuffer(this.heap.allocate(initialCapacity, maxCapacity));
    }

    @Override
    protected ByteBuf newDirectBuffer(int initialCapacity, int maxCapacity) {
        return AdaptiveByteBufAllocator.toLeakAwareBuffer(this.direct.allocate(initialCapacity, maxCapacity));
    }

    @Override
    public boolean isDirectBufferPooled() {
        return true;
    }

    @Override
    public long usedHeapMemory() {
        return this.heap.usedMemory();
    }

    @Override
    public long usedDirectMemory() {
        return this.direct.usedMemory();
    }

    @Override
    public ByteBufAllocatorMetric metric() {
        return this;
    }

    static {
        logger.debug("-Dio.netty.allocator.useCachedMagazinesForNonEventLoopThreads: {}", (Object)DEFAULT_USE_CACHED_MAGAZINES_FOR_NON_EVENT_LOOP_THREADS);
    }

    private static final class DirectChunkAllocator
    implements AdaptivePoolingAllocator.ChunkAllocator {
        private final ByteBufAllocator allocator;

        private DirectChunkAllocator(ByteBufAllocator allocator) {
            this.allocator = allocator;
        }

        @Override
        public AbstractByteBuf allocate(int initialCapacity, int maxCapacity) {
            return PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this.allocator, initialCapacity, maxCapacity) : new UnpooledDirectByteBuf(this.allocator, initialCapacity, maxCapacity);
        }
    }

    private static final class HeapChunkAllocator
    implements AdaptivePoolingAllocator.ChunkAllocator {
        private final ByteBufAllocator allocator;

        private HeapChunkAllocator(ByteBufAllocator allocator) {
            this.allocator = allocator;
        }

        @Override
        public AbstractByteBuf allocate(int initialCapacity, int maxCapacity) {
            return PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this.allocator, initialCapacity, maxCapacity) : new UnpooledHeapByteBuf(this.allocator, initialCapacity, maxCapacity);
        }
    }
}

