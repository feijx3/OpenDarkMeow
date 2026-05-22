/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.AbstractReferenceCountedByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocatorMetricProvider;
import net.darkmeow.irc.lib.io.netty.buffer.PoolArena;
import net.darkmeow.irc.lib.io.netty.buffer.PoolArenaMetric;
import net.darkmeow.irc.lib.io.netty.buffer.PoolThreadCache;
import net.darkmeow.irc.lib.io.netty.buffer.PooledByteBufAllocatorMetric;
import net.darkmeow.irc.lib.io.netty.buffer.SizeClasses;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledHeapByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledUnsafeHeapByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnsafeByteBufUtil;
import net.darkmeow.irc.lib.io.netty.util.NettyRuntime;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FastThreadLocal;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FastThreadLocalThread;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ThreadExecutorMap;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public class PooledByteBufAllocator
extends AbstractByteBufAllocator
implements ByteBufAllocatorMetricProvider {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final boolean DEFAULT_DISABLE_CACHE_FINALIZERS_FOR_FAST_THREAD_LOCAL_THREADS;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final int MAX_CHUNK_SIZE = 0x40000000;
    private static final int CACHE_NOT_USED = 0;
    private final Runnable trimTask = new Runnable(){

        @Override
        public void run() {
            PooledByteBufAllocator.this.trimCurrentThreadCache();
        }
    };
    public static final PooledByteBufAllocator DEFAULT;
    private final PoolArena<byte[]>[] heapArenas;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final int smallCacheSize;
    private final int normalCacheSize;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolThreadLocalCache threadCache;
    private final int chunkSize;
    private final PooledByteBufAllocatorMetric metric;

    public PooledByteBufAllocator() {
        this(false);
    }

    public PooledByteBufAllocator(boolean preferDirect) {
        this(preferDirect, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public PooledByteBufAllocator(int nHeapArena, int nDirectArena, int pageSize, int maxOrder) {
        this(false, nHeapArena, nDirectArena, pageSize, maxOrder);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads);
    }

    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads, int directMemoryCacheAlignment) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads, directMemoryCacheAlignment);
    }

    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads, int directMemoryCacheAlignment) {
        super(preferDirect);
        PoolArena arena;
        int i2;
        SizeClasses sizeClasses;
        ArrayList<PoolArena.HeapArena> metrics;
        this.threadCache = new PoolThreadLocalCache(useCacheForAllThreads);
        this.smallCacheSize = smallCacheSize;
        this.normalCacheSize = normalCacheSize;
        if (directMemoryCacheAlignment != 0) {
            if (!PlatformDependent.hasAlignDirectByteBuffer()) {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
            pageSize = (int)PlatformDependent.align(pageSize, directMemoryCacheAlignment);
        }
        this.chunkSize = PooledByteBufAllocator.validateAndCalculateChunkSize(pageSize, maxOrder);
        ObjectUtil.checkPositiveOrZero(nHeapArena, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(nDirectArena, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(directMemoryCacheAlignment, "directMemoryCacheAlignment");
        if (directMemoryCacheAlignment > 0 && !PooledByteBufAllocator.isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if ((directMemoryCacheAlignment & -directMemoryCacheAlignment) != directMemoryCacheAlignment) {
            throw new IllegalArgumentException("directMemoryCacheAlignment: " + directMemoryCacheAlignment + " (expected: power of two)");
        }
        int pageShifts = PooledByteBufAllocator.validateAndCalculatePageShifts(pageSize, directMemoryCacheAlignment);
        if (nHeapArena > 0) {
            this.heapArenas = PooledByteBufAllocator.newArenaArray(nHeapArena);
            metrics = new ArrayList<PoolArena.HeapArena>(this.heapArenas.length);
            sizeClasses = new SizeClasses(pageSize, pageShifts, this.chunkSize, 0);
            for (i2 = 0; i2 < this.heapArenas.length; ++i2) {
                this.heapArenas[i2] = arena = new PoolArena.HeapArena(this, sizeClasses);
                metrics.add((PoolArena.HeapArena)arena);
            }
            this.heapArenaMetrics = Collections.unmodifiableList(metrics);
        } else {
            this.heapArenas = null;
            this.heapArenaMetrics = Collections.emptyList();
        }
        if (nDirectArena > 0) {
            this.directArenas = PooledByteBufAllocator.newArenaArray(nDirectArena);
            metrics = new ArrayList(this.directArenas.length);
            sizeClasses = new SizeClasses(pageSize, pageShifts, this.chunkSize, directMemoryCacheAlignment);
            for (i2 = 0; i2 < this.directArenas.length; ++i2) {
                this.directArenas[i2] = arena = new PoolArena.DirectArena(this, sizeClasses);
                metrics.add((PoolArena.HeapArena)arena);
            }
            this.directArenaMetrics = Collections.unmodifiableList(metrics);
        } else {
            this.directArenas = null;
            this.directArenaMetrics = Collections.emptyList();
        }
        this.metric = new PooledByteBufAllocatorMetric(this);
    }

    private static <T> PoolArena<T>[] newArenaArray(int size) {
        return new PoolArena[size];
    }

    private static int validateAndCalculatePageShifts(int pageSize, int alignment) {
        if (pageSize < 4096) {
            throw new IllegalArgumentException("pageSize: " + pageSize + " (expected: " + 4096 + ')');
        }
        if ((pageSize & pageSize - 1) != 0) {
            throw new IllegalArgumentException("pageSize: " + pageSize + " (expected: power of 2)");
        }
        if (pageSize < alignment) {
            throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + alignment + ", page size: " + pageSize + '.');
        }
        return 31 - Integer.numberOfLeadingZeros(pageSize);
    }

    private static int validateAndCalculateChunkSize(int pageSize, int maxOrder) {
        if (maxOrder > 14) {
            throw new IllegalArgumentException("maxOrder: " + maxOrder + " (expected: 0-14)");
        }
        int chunkSize = pageSize;
        for (int i2 = maxOrder; i2 > 0; --i2) {
            if (chunkSize > 0x20000000) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", pageSize, maxOrder, 0x40000000));
            }
            chunkSize <<= 1;
        }
        return chunkSize;
    }

    @Override
    protected ByteBuf newHeapBuffer(int initialCapacity, int maxCapacity) {
        PoolThreadCache cache2 = (PoolThreadCache)this.threadCache.get();
        PoolArena<byte[]> heapArena = cache2.heapArena;
        AbstractReferenceCountedByteBuf buf = heapArena != null ? heapArena.allocate(cache2, initialCapacity, maxCapacity) : (PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf((ByteBufAllocator)this, initialCapacity, maxCapacity) : new UnpooledHeapByteBuf((ByteBufAllocator)this, initialCapacity, maxCapacity));
        return PooledByteBufAllocator.toLeakAwareBuffer(buf);
    }

    @Override
    protected ByteBuf newDirectBuffer(int initialCapacity, int maxCapacity) {
        PoolThreadCache cache2 = (PoolThreadCache)this.threadCache.get();
        PoolArena<ByteBuffer> directArena = cache2.directArena;
        AbstractReferenceCountedByteBuf buf = directArena != null ? directArena.allocate(cache2, initialCapacity, maxCapacity) : (PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, initialCapacity, maxCapacity) : new UnpooledDirectByteBuf((ByteBufAllocator)this, initialCapacity, maxCapacity));
        return PooledByteBufAllocator.toLeakAwareBuffer(buf);
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static boolean defaultDisableCacheFinalizersForFastThreadLocalThreads() {
        return DEFAULT_DISABLE_CACHE_FINALIZERS_FOR_FAST_THREAD_LOCAL_THREADS;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    @Override
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    private static boolean useCacheFinalizers(Thread current) {
        if (!PooledByteBufAllocator.defaultDisableCacheFinalizersForFastThreadLocalThreads()) {
            return true;
        }
        return current instanceof FastThreadLocalThread && ((FastThreadLocalThread)current).willCleanupFastThreadLocals();
    }

    @Override
    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    @Deprecated
    public int numThreadLocalCaches() {
        return Math.max(PooledByteBufAllocator.numThreadLocalCaches(this.heapArenas), PooledByteBufAllocator.numThreadLocalCaches(this.directArenas));
    }

    private static int numThreadLocalCaches(PoolArena<?>[] arenas) {
        if (arenas == null) {
            return 0;
        }
        int total = 0;
        for (PoolArena<?> arena : arenas) {
            total += arena.numThreadCaches.get();
        }
        return total;
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    final long usedHeapMemory() {
        return PooledByteBufAllocator.usedMemory(this.heapArenas);
    }

    final long usedDirectMemory() {
        return PooledByteBufAllocator.usedMemory(this.directArenas);
    }

    private static long usedMemory(PoolArena<?>[] arenas) {
        if (arenas == null) {
            return -1L;
        }
        long used = 0L;
        for (PoolArena<?> arena : arenas) {
            if ((used += arena.numActiveBytes()) >= 0L) continue;
            return Long.MAX_VALUE;
        }
        return used;
    }

    public final long pinnedHeapMemory() {
        return PooledByteBufAllocator.pinnedMemory(this.heapArenas);
    }

    public final long pinnedDirectMemory() {
        return PooledByteBufAllocator.pinnedMemory(this.directArenas);
    }

    private static long pinnedMemory(PoolArena<?>[] arenas) {
        if (arenas == null) {
            return -1L;
        }
        long used = 0L;
        for (PoolArena<?> arena : arenas) {
            if ((used += arena.numPinnedBytes()) >= 0L) continue;
            return Long.MAX_VALUE;
        }
        return used;
    }

    final PoolThreadCache threadCache() {
        PoolThreadCache cache2 = (PoolThreadCache)this.threadCache.get();
        assert (cache2 != null);
        return cache2;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache cache2 = (PoolThreadCache)this.threadCache.getIfExists();
        if (cache2 != null) {
            cache2.trim();
            return true;
        }
        return false;
    }

    public String dumpStats() {
        int heapArenasLen = this.heapArenas == null ? 0 : this.heapArenas.length;
        StringBuilder buf = new StringBuilder(512).append(heapArenasLen).append(" heap arena(s):").append(StringUtil.NEWLINE);
        if (heapArenasLen > 0) {
            for (PoolArena<byte[]> a2 : this.heapArenas) {
                buf.append(a2);
            }
        }
        int directArenasLen = this.directArenas == null ? 0 : this.directArenas.length;
        buf.append(directArenasLen).append(" direct arena(s):").append(StringUtil.NEWLINE);
        if (directArenasLen > 0) {
            for (PoolArena<ByteBuffer> a3 : this.directArenas) {
                buf.append(a3);
            }
        }
        return buf.toString();
    }

    static {
        int defaultAlignment = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.directMemoryCacheAlignment", 0);
        int defaultPageSize = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.pageSize", 8192);
        Throwable pageSizeFallbackCause = null;
        try {
            PooledByteBufAllocator.validateAndCalculatePageShifts(defaultPageSize, defaultAlignment);
        }
        catch (Throwable t2) {
            pageSizeFallbackCause = t2;
            defaultPageSize = 8192;
            defaultAlignment = 0;
        }
        DEFAULT_PAGE_SIZE = defaultPageSize;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = defaultAlignment;
        int defaultMaxOrder = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.maxOrder", 9);
        Throwable maxOrderFallbackCause = null;
        try {
            PooledByteBufAllocator.validateAndCalculateChunkSize(DEFAULT_PAGE_SIZE, defaultMaxOrder);
        }
        catch (Throwable t3) {
            maxOrderFallbackCause = t3;
            defaultMaxOrder = 9;
        }
        DEFAULT_MAX_ORDER = defaultMaxOrder;
        Runtime runtime = Runtime.getRuntime();
        int defaultMinNumArena = NettyRuntime.availableProcessors() * 2;
        int defaultChunkSize = DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER;
        DEFAULT_NUM_HEAP_ARENA = Math.max(0, SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.numHeapArenas", (int)Math.min((long)defaultMinNumArena, runtime.maxMemory() / (long)defaultChunkSize / 2L / 3L)));
        DEFAULT_NUM_DIRECT_ARENA = Math.max(0, SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.numDirectArenas", (int)Math.min((long)defaultMinNumArena, PlatformDependent.maxDirectMemory() / (long)defaultChunkSize / 2L / 3L)));
        DEFAULT_SMALL_CACHE_SIZE = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.smallCacheSize", 256);
        DEFAULT_NORMAL_CACHE_SIZE = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.normalCacheSize", 64);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_CACHE_TRIM_INTERVAL = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.cacheTrimInterval", 8192);
        if (SystemPropertyUtil.contains("net.darkmeow.irc.lib.io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.contains("net.darkmeow.irc.lib.io.netty.allocator.cacheTrimIntervalMillis") ? SystemPropertyUtil.getLong("net.darkmeow.irc.lib.io.netty.allocator.cacheTrimIntervalMillis", 0L) : SystemPropertyUtil.getLong("net.darkmeow.irc.lib.io.netty.allocation.cacheTrimIntervalMillis", 0L);
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("net.darkmeow.irc.lib.io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = SystemPropertyUtil.getBoolean("net.darkmeow.irc.lib.io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_DISABLE_CACHE_FINALIZERS_FOR_FAST_THREAD_LOCAL_THREADS = SystemPropertyUtil.getBoolean("net.darkmeow.irc.lib.io.netty.allocator.disableCacheFinalizersForFastThreadLocalThreads", false);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.allocator.numHeapArenas: {}", (Object)DEFAULT_NUM_HEAP_ARENA);
            logger.debug("-Dio.netty.allocator.numDirectArenas: {}", (Object)DEFAULT_NUM_DIRECT_ARENA);
            if (pageSizeFallbackCause == null) {
                logger.debug("-Dio.netty.allocator.pageSize: {}", (Object)DEFAULT_PAGE_SIZE);
            } else {
                logger.debug("-Dio.netty.allocator.pageSize: {}", (Object)DEFAULT_PAGE_SIZE, (Object)pageSizeFallbackCause);
            }
            if (maxOrderFallbackCause == null) {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", (Object)DEFAULT_MAX_ORDER);
            } else {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", (Object)DEFAULT_MAX_ORDER, (Object)maxOrderFallbackCause);
            }
            logger.debug("-Dio.netty.allocator.chunkSize: {}", (Object)(DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER));
            logger.debug("-Dio.netty.allocator.smallCacheSize: {}", (Object)DEFAULT_SMALL_CACHE_SIZE);
            logger.debug("-Dio.netty.allocator.normalCacheSize: {}", (Object)DEFAULT_NORMAL_CACHE_SIZE);
            logger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", (Object)DEFAULT_MAX_CACHED_BUFFER_CAPACITY);
            logger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", (Object)DEFAULT_CACHE_TRIM_INTERVAL);
            logger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", (Object)DEFAULT_CACHE_TRIM_INTERVAL_MILLIS);
            logger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", (Object)DEFAULT_USE_CACHE_FOR_ALL_THREADS);
            logger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", (Object)DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK);
            logger.debug("-Dio.netty.allocator.disableCacheFinalizersForFastThreadLocalThreads: {}", (Object)DEFAULT_DISABLE_CACHE_FINALIZERS_FOR_FAST_THREAD_LOCAL_THREADS);
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    private final class PoolThreadLocalCache
    extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        PoolThreadLocalCache(boolean useCacheForAllThreads) {
            this.useCacheForAllThreads = useCacheForAllThreads;
        }

        @Override
        protected synchronized PoolThreadCache initialValue() {
            PoolArena<byte[]> heapArena = this.leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena<ByteBuffer> directArena = this.leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread current = Thread.currentThread();
            EventExecutor executor = ThreadExecutorMap.currentExecutor();
            if (this.useCacheForAllThreads || current instanceof FastThreadLocalThread || executor != null) {
                PoolThreadCache cache2 = new PoolThreadCache(heapArena, directArena, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, DEFAULT_MAX_CACHED_BUFFER_CAPACITY, DEFAULT_CACHE_TRIM_INTERVAL, PooledByteBufAllocator.useCacheFinalizers(current));
                if (DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0L && executor != null) {
                    executor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
                }
                return cache2;
            }
            return new PoolThreadCache(heapArena, directArena, 0, 0, 0, 0, false);
        }

        @Override
        protected void onRemoval(PoolThreadCache threadCache) {
            threadCache.free(false);
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] arenas) {
            if (arenas == null || arenas.length == 0) {
                return null;
            }
            PoolArena<T> minArena = arenas[0];
            if (minArena.numThreadCaches.get() == 0) {
                return minArena;
            }
            for (int i2 = 1; i2 < arenas.length; ++i2) {
                PoolArena<T> arena = arenas[i2];
                if (arena.numThreadCaches.get() >= minArena.numThreadCaches.get()) continue;
                minArena = arena;
            }
            return minArena;
        }
    }
}

