/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.EventLoopGroup;
import net.darkmeow.irc.lib.io.netty.util.concurrent.OrderedEventExecutor;

public interface EventLoop
extends OrderedEventExecutor,
EventLoopGroup {
    @Override
    public EventLoopGroup parent();
}

