/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.darkmeow.irc.lib.io.netty.handler.codec.CodecOutputList;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderException;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCountUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.TypeParameterMatcher;

public abstract class MessageToMessageDecoder<I>
extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private boolean decodeCalled;
    private boolean messageProduced;

    protected MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    protected MessageToMessageDecoder(Class<? extends I> inboundMessageType) {
        this.matcher = TypeParameterMatcher.get(inboundMessageType);
    }

    public boolean acceptInboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CodecOutputList out;
        block17: {
            this.decodeCalled = true;
            out = CodecOutputList.newInstance();
            try {
                if (this.acceptInboundMessage(msg)) {
                    Object cast = msg;
                    try {
                        this.decode(ctx, cast, out);
                        break block17;
                    }
                    finally {
                        ReferenceCountUtil.release(cast);
                    }
                }
                out.add(msg);
            }
            catch (DecoderException e2) {
                try {
                    throw e2;
                    catch (Exception e3) {
                        throw new DecoderException(e3);
                    }
                }
                catch (Throwable throwable) {
                    try {
                        int size = out.size();
                        this.messageProduced |= size > 0;
                        for (int i2 = 0; i2 < size; ++i2) {
                            ctx.fireChannelRead(out.getUnsafe(i2));
                        }
                        throw throwable;
                    }
                    finally {
                        out.recycle();
                    }
                }
            }
        }
        try {
            int size = out.size();
            this.messageProduced |= size > 0;
            for (int i3 = 0; i3 < size; ++i3) {
                ctx.fireChannelRead(out.getUnsafe(i3));
            }
            return;
        }
        finally {
            out.recycle();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if (!this.isSharable()) {
            if (this.decodeCalled && !this.messageProduced && !ctx.channel().config().isAutoRead()) {
                ctx.read();
            }
            this.decodeCalled = false;
            this.messageProduced = false;
        }
        ctx.fireChannelReadComplete();
    }

    protected abstract void decode(ChannelHandlerContext var1, I var2, List<Object> var3) throws Exception;
}

