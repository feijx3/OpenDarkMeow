/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOutboundHandlerAdapter;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.handler.codec.CodecOutputList;
import net.darkmeow.irc.lib.io.netty.handler.codec.EncoderException;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCountUtil;
import net.darkmeow.irc.lib.io.netty.util.concurrent.PromiseCombiner;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.TypeParameterMatcher;

public abstract class MessageToMessageEncoder<I>
extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    protected MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    protected MessageToMessageEncoder(Class<? extends I> outboundMessageType) {
        this.matcher = TypeParameterMatcher.get(outboundMessageType);
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        block21: {
            CodecOutputList out = null;
            try {
                if (this.acceptOutboundMessage(msg)) {
                    out = CodecOutputList.newInstance();
                    Object cast = msg;
                    try {
                        this.encode(ctx, cast, out);
                    }
                    catch (Throwable th) {
                        ReferenceCountUtil.safeRelease(cast);
                        PlatformDependent.throwException(th);
                    }
                    ReferenceCountUtil.release(cast);
                    if (out.isEmpty()) {
                        throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                    }
                    break block21;
                }
                ctx.write(msg, promise);
            }
            catch (EncoderException e2) {
                throw e2;
            }
            catch (Throwable t2) {
                throw new EncoderException(t2);
            }
            finally {
                if (out != null) {
                    try {
                        int sizeMinusOne = out.size() - 1;
                        if (sizeMinusOne == 0) {
                            ctx.write(out.getUnsafe(0), promise);
                        } else if (sizeMinusOne > 0) {
                            if (promise == ctx.voidPromise()) {
                                MessageToMessageEncoder.writeVoidPromise(ctx, out);
                            } else {
                                MessageToMessageEncoder.writePromiseCombiner(ctx, out, promise);
                            }
                        }
                    }
                    finally {
                        out.recycle();
                    }
                }
            }
        }
    }

    private static void writeVoidPromise(ChannelHandlerContext ctx, CodecOutputList out) {
        ChannelPromise voidPromise = ctx.voidPromise();
        for (int i2 = 0; i2 < out.size(); ++i2) {
            ctx.write(out.getUnsafe(i2), voidPromise);
        }
    }

    private static void writePromiseCombiner(ChannelHandlerContext ctx, CodecOutputList out, ChannelPromise promise) {
        PromiseCombiner combiner = new PromiseCombiner(ctx.executor());
        for (int i2 = 0; i2 < out.size(); ++i2) {
            combiner.add(ctx.write(out.getUnsafe(i2)));
        }
        combiner.finish(promise);
    }

    protected abstract void encode(ChannelHandlerContext var1, I var2, List<Object> var3) throws Exception;
}

