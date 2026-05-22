/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;
import net.darkmeow.irc.lib.io.netty.util.concurrent.ProgressiveFuture;

public interface ChannelProgressiveFuture
extends ChannelFuture,
ProgressiveFuture<Void> {
    @Override
    public ChannelProgressiveFuture addListener(GenericFutureListener<? extends Future<? super Void>> var1);

    @Override
    public ChannelProgressiveFuture addListeners(GenericFutureListener<? extends Future<? super Void>> ... var1);

    @Override
    public ChannelProgressiveFuture removeListener(GenericFutureListener<? extends Future<? super Void>> var1);

    @Override
    public ChannelProgressiveFuture removeListeners(GenericFutureListener<? extends Future<? super Void>> ... var1);

    @Override
    public ChannelProgressiveFuture sync() throws InterruptedException;

    @Override
    public ChannelProgressiveFuture syncUninterruptibly();

    @Override
    public ChannelProgressiveFuture await() throws InterruptedException;

    @Override
    public ChannelProgressiveFuture awaitUninterruptibly();
}

