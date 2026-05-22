/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.util.Map;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerMask;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;

public abstract class ChannelHandlerAdapter
implements ChannelHandler {
    boolean added;

    protected void ensureNotSharable() {
        if (this.isSharable()) {
            throw new IllegalStateException("ChannelHandler " + this.getClass().getName() + " is not allowed to be shared");
        }
    }

    public boolean isSharable() {
        Class<?> clazz = this.getClass();
        Map<Class<?>, Boolean> cache2 = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean sharable = cache2.get(clazz);
        if (sharable == null) {
            sharable = clazz.isAnnotationPresent(ChannelHandler.Sharable.class);
            cache2.put(clazz, sharable);
        }
        return sharable;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    @ChannelHandlerMask.Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}

