/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.RecvByteBufAllocator;

public interface MaxMessagesRecvByteBufAllocator
extends RecvByteBufAllocator {
    public int maxMessagesPerRead();

    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int var1);
}

