/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.IoHandler;
import net.darkmeow.irc.lib.io.netty.util.concurrent.ThreadAwareExecutor;

public interface IoHandlerFactory {
    public IoHandler newHandler(ThreadAwareExecutor var1);
}

