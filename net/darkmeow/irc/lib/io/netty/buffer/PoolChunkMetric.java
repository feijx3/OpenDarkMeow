/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

public interface PoolChunkMetric {
    public int usage();

    public int chunkSize();

    public int freeBytes();
}

