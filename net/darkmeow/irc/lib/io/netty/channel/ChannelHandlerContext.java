/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundInvoker;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOutboundInvoker;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPipeline;
import net.darkmeow.irc.lib.io.netty.util.Attribute;
import net.darkmeow.irc.lib.io.netty.util.AttributeKey;
import net.darkmeow.irc.lib.io.netty.util.AttributeMap;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;

public interface ChannelHandlerContext
extends AttributeMap,
ChannelInboundInvoker,
ChannelOutboundInvoker {
    public Channel channel();

    public EventExecutor executor();

    public String name();

    public ChannelHandler handler();

    public boolean isRemoved();

    @Override
    public ChannelHandlerContext fireChannelRegistered();

    @Override
    public ChannelHandlerContext fireChannelUnregistered();

    @Override
    public ChannelHandlerContext fireChannelActive();

    @Override
    public ChannelHandlerContext fireChannelInactive();

    @Override
    public ChannelHandlerContext fireExceptionCaught(Throwable var1);

    @Override
    public ChannelHandlerContext fireUserEventTriggered(Object var1);

    @Override
    public ChannelHandlerContext fireChannelRead(Object var1);

    @Override
    public ChannelHandlerContext fireChannelReadComplete();

    @Override
    public ChannelHandlerContext fireChannelWritabilityChanged();

    @Override
    public ChannelHandlerContext read();

    @Override
    public ChannelHandlerContext flush();

    public ChannelPipeline pipeline();

    public ByteBufAllocator alloc();

    @Override
    @Deprecated
    public <T> Attribute<T> attr(AttributeKey<T> var1);

    @Override
    @Deprecated
    public <T> boolean hasAttr(AttributeKey<T> var1);
}

