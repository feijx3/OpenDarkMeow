/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.buffer.PoolChunkListMetric;
import net.darkmeow.irc.lib.io.netty.buffer.PoolSubpageMetric;
import net.darkmeow.irc.lib.io.netty.buffer.SizeClassesMetric;

public interface PoolArenaMetric
extends SizeClassesMetric {
    public int numThreadCaches();

    @Deprecated
    public int numTinySubpages();

    public int numSmallSubpages();

    public int numChunkLists();

    @Deprecated
    public List<PoolSubpageMetric> tinySubpages();

    public List<PoolSubpageMetric> smallSubpages();

    public List<PoolChunkListMetric> chunkLists();

    public long numAllocations();

    @Deprecated
    public long numTinyAllocations();

    public long numSmallAllocations();

    public long numNormalAllocations();

    public long numHugeAllocations();

    default public long numChunkAllocations() {
        return -1L;
    }

    public long numDeallocations();

    @Deprecated
    public long numTinyDeallocations();

    public long numSmallDeallocations();

    public long numNormalDeallocations();

    public long numHugeDeallocations();

    default public long numChunkDeallocations() {
        return -1L;
    }

    public long numActiveAllocations();

    @Deprecated
    public long numActiveTinyAllocations();

    public long numActiveSmallAllocations();

    public long numActiveNormalAllocations();

    public long numActiveHugeAllocations();

    default public long numActiveChunks() {
        return -1L;
    }

    public long numActiveBytes();
}

