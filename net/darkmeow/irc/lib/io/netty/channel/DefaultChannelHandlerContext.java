/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.AbstractChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.DefaultChannelPipeline;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;

final class DefaultChannelHandlerContext
extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    DefaultChannelHandlerContext(DefaultChannelPipeline pipeline, EventExecutor executor, String name, ChannelHandler handler) {
        super(pipeline, executor, name, handler.getClass());
        this.handler = handler;
    }

    @Override
    public ChannelHandler handler() {
        return this.handler;
    }
}

