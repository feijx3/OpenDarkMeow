/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.EventLoop;
import net.darkmeow.irc.lib.io.netty.channel.EventLoopGroup;
import net.darkmeow.irc.lib.io.netty.util.NettyRuntime;
import net.darkmeow.irc.lib.io.netty.util.concurrent.DefaultThreadFactory;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutorChooserFactory;
import net.darkmeow.irc.lib.io.netty.util.concurrent.MultithreadEventExecutorGroup;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public abstract class MultithreadEventLoopGroup
extends MultithreadEventExecutorGroup
implements EventLoopGroup {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(MultithreadEventLoopGroup.class);
    private static final int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

    protected MultithreadEventLoopGroup(int nThreads, Executor executor, Object ... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, executor, args);
    }

    protected MultithreadEventLoopGroup(int nThreads, ThreadFactory threadFactory, Object ... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, threadFactory, args);
    }

    protected MultithreadEventLoopGroup(int nThreads, Executor executor, EventExecutorChooserFactory chooserFactory, Object ... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, executor, chooserFactory, args);
    }

    @Override
    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(this.getClass(), 10);
    }

    @Override
    public EventLoop next() {
        return (EventLoop)super.next();
    }

    @Override
    protected abstract EventLoop newChild(Executor var1, Object ... var2) throws Exception;

    @Override
    public ChannelFuture register(Channel channel) {
        return this.next().register(channel);
    }

    @Override
    public ChannelFuture register(ChannelPromise promise) {
        return this.next().register(promise);
    }

    @Override
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise promise) {
        return this.next().register(channel, promise);
    }

    static {
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.eventLoopThreads: {}", (Object)DEFAULT_EVENT_LOOP_THREADS);
        }
    }
}

