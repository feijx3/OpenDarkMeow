/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.timeout.IdleState;
import net.darkmeow.irc.lib.io.netty.handler.timeout.IdleStateEvent;
import net.darkmeow.irc.lib.io.netty.handler.timeout.IdleStateHandler;
import net.darkmeow.irc.lib.io.netty.handler.timeout.ReadTimeoutException;

public class ReadTimeoutHandler
extends IdleStateHandler {
    private boolean closed;

    public ReadTimeoutHandler(int timeoutSeconds) {
        this(timeoutSeconds, TimeUnit.SECONDS);
    }

    public ReadTimeoutHandler(long timeout, TimeUnit unit) {
        super(timeout, 0L, 0L, unit);
    }

    @Override
    protected final void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        assert (evt.state() == IdleState.READER_IDLE);
        this.readTimedOut(ctx);
    }

    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
        if (!this.closed) {
            ctx.fireExceptionCaught(ReadTimeoutException.INSTANCE);
            ctx.close();
            this.closed = true;
        }
    }
}

