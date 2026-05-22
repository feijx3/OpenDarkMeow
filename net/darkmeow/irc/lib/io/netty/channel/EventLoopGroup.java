/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.EventLoop;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutorGroup;

public interface EventLoopGroup
extends EventExecutorGroup {
    @Override
    public EventLoop next();

    public ChannelFuture register(Channel var1);

    public ChannelFuture register(ChannelPromise var1);

    @Deprecated
    public ChannelFuture register(Channel var1, ChannelPromise var2);
}

