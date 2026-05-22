/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;

public interface ChannelHandler {
    public void handlerAdded(ChannelHandlerContext var1) throws Exception;

    public void handlerRemoved(ChannelHandlerContext var1) throws Exception;

    @Deprecated
    public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception;

    @Inherited
    @Documented
    @Target(value={ElementType.TYPE})
    @Retention(value=RetentionPolicy.RUNTIME)
    public static @interface Sharable {
    }
}

