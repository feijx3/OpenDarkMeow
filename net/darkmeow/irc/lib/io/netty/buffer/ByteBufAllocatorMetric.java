/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

public interface ByteBufAllocatorMetric {
    public long usedHeapMemory();

    public long usedDirectMemory();
}

