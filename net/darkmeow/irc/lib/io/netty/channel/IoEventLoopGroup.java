/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.EventLoopGroup;
import net.darkmeow.irc.lib.io.netty.channel.IoEventLoop;
import net.darkmeow.irc.lib.io.netty.channel.IoHandle;
import net.darkmeow.irc.lib.io.netty.channel.IoHandler;
import net.darkmeow.irc.lib.io.netty.channel.IoRegistration;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;

public interface IoEventLoopGroup
extends EventLoopGroup {
    @Override
    public IoEventLoop next();

    @Override
    @Deprecated
    default public ChannelFuture register(Channel channel) {
        return this.next().register(channel);
    }

    @Override
    @Deprecated
    default public ChannelFuture register(ChannelPromise promise) {
        return this.next().register(promise);
    }

    default public Future<IoRegistration> register(IoHandle handle) {
        return this.next().register(handle);
    }

    default public boolean isCompatible(Class<? extends IoHandle> handleType) {
        return this.next().isCompatible(handleType);
    }

    default public boolean isIoType(Class<? extends IoHandler> handlerType) {
        return this.next().isIoType(handlerType);
    }
}

