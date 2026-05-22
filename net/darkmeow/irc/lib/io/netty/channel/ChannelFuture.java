/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;

public interface ChannelFuture
extends Future<Void> {
    public Channel channel();

    public ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> var1);

    public ChannelFuture addListeners(GenericFutureListener<? extends Future<? super Void>> ... var1);

    public ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> var1);

    public ChannelFuture removeListeners(GenericFutureListener<? extends Future<? super Void>> ... var1);

    public ChannelFuture sync() throws InterruptedException;

    public ChannelFuture syncUninterruptibly();

    public ChannelFuture await() throws InterruptedException;

    public ChannelFuture awaitUninterruptibly();

    public boolean isVoid();
}

