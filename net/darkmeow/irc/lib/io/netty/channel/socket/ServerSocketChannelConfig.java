/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.socket;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.channel.ChannelConfig;
import net.darkmeow.irc.lib.io.netty.channel.MessageSizeEstimator;
import net.darkmeow.irc.lib.io.netty.channel.RecvByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.channel.WriteBufferWaterMark;

public interface ServerSocketChannelConfig
extends ChannelConfig {
    public int getBacklog();

    public ServerSocketChannelConfig setBacklog(int var1);

    public boolean isReuseAddress();

    public ServerSocketChannelConfig setReuseAddress(boolean var1);

    public int getReceiveBufferSize();

    public ServerSocketChannelConfig setReceiveBufferSize(int var1);

    public ServerSocketChannelConfig setPerformancePreferences(int var1, int var2, int var3);

    @Override
    public ServerSocketChannelConfig setConnectTimeoutMillis(int var1);

    @Override
    @Deprecated
    public ServerSocketChannelConfig setMaxMessagesPerRead(int var1);

    @Override
    public ServerSocketChannelConfig setWriteSpinCount(int var1);

    @Override
    public ServerSocketChannelConfig setAllocator(ByteBufAllocator var1);

    @Override
    public ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator var1);

    @Override
    public ServerSocketChannelConfig setAutoRead(boolean var1);

    @Override
    public ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator var1);

    @Override
    public ServerSocketChannelConfig setWriteBufferHighWaterMark(int var1);

    @Override
    public ServerSocketChannelConfig setWriteBufferLowWaterMark(int var1);

    @Override
    public ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark var1);
}

