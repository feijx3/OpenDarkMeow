/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.IoHandle;
import net.darkmeow.irc.lib.io.netty.channel.IoHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.IoRegistration;

public interface IoHandler {
    default public void initialize() {
    }

    public int run(IoHandlerContext var1);

    default public void prepareToDestroy() {
    }

    default public void destroy() {
    }

    public IoRegistration register(IoHandle var1) throws Exception;

    public void wakeup();

    public boolean isCompatible(Class<? extends IoHandle> var1);
}

