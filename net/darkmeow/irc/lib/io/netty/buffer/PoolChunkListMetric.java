/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import net.darkmeow.irc.lib.io.netty.buffer.PoolChunkMetric;

public interface PoolChunkListMetric
extends Iterable<PoolChunkMetric> {
    public int minUsage();

    public int maxUsage();
}

