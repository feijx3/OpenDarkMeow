/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.EventLoop;
import net.darkmeow.irc.lib.io.netty.channel.IoEventLoopGroup;
import net.darkmeow.irc.lib.io.netty.channel.IoHandle;
import net.darkmeow.irc.lib.io.netty.channel.IoHandler;
import net.darkmeow.irc.lib.io.netty.channel.IoRegistration;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;

public interface IoEventLoop
extends EventLoop,
IoEventLoopGroup {
    @Override
    default public IoEventLoop next() {
        return this;
    }

    @Override
    public Future<IoRegistration> register(IoHandle var1);

    @Override
    public boolean isCompatible(Class<? extends IoHandle> var1);

    @Override
    public boolean isIoType(Class<? extends IoHandler> var1);
}

