/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOutboundHandlerAdapter;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.handler.codec.EncoderException;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCountUtil;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCounted;
import net.darkmeow.irc.lib.io.netty.util.internal.TypeParameterMatcher;

public abstract class MessageToByteEncoder<I>
extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    protected MessageToByteEncoder() {
        this(true);
    }

    protected MessageToByteEncoder(Class<? extends I> outboundMessageType) {
        this(outboundMessageType, true);
    }

    protected MessageToByteEncoder(boolean preferDirect) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = preferDirect;
    }

    protected MessageToByteEncoder(Class<? extends I> outboundMessageType, boolean preferDirect) {
        this.matcher = TypeParameterMatcher.get(outboundMessageType);
        this.preferDirect = preferDirect;
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        block14: {
            ReferenceCounted buf = null;
            try {
                if (this.acceptOutboundMessage(msg)) {
                    Object cast = msg;
                    buf = this.allocateBuffer(ctx, cast, this.preferDirect);
                    try {
                        this.encode(ctx, cast, (ByteBuf)buf);
                    }
                    finally {
                        ReferenceCountUtil.release(cast);
                    }
                    if (((ByteBuf)buf).isReadable()) {
                        ctx.write(buf, promise);
                    } else {
                        buf.release();
                        ctx.write(Unpooled.EMPTY_BUFFER, promise);
                    }
                    buf = null;
                    break block14;
                }
                ctx.write(msg, promise);
            }
            catch (EncoderException e2) {
                throw e2;
            }
            catch (Throwable e3) {
                throw new EncoderException(e3);
            }
            finally {
                if (buf != null) {
                    buf.release();
                }
            }
        }
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext ctx, I msg, boolean preferDirect) throws Exception {
        if (preferDirect) {
            return ctx.alloc().ioBuffer();
        }
        return ctx.alloc().heapBuffer();
    }

    protected abstract void encode(ChannelHandlerContext var1, I var2, ByteBuf var3) throws Exception;

    protected boolean isPreferDirect() {
        return this.preferDirect;
    }
}

