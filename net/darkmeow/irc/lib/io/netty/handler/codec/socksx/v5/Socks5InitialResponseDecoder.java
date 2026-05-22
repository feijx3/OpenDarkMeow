/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderException;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.ReplayingDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.SocksVersion;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.DefaultSocks5InitialResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AuthMethod;

public class Socks5InitialResponseDecoder
extends ReplayingDecoder<State> {
    public Socks5InitialResponseDecoder() {
        super(State.INIT);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            switch ((State)((Object)this.state())) {
                case INIT: {
                    byte version = in.readByte();
                    if (version != SocksVersion.SOCKS5.byteValue()) {
                        throw new DecoderException("unsupported version: " + version + " (expected: " + SocksVersion.SOCKS5.byteValue() + ')');
                    }
                    Socks5AuthMethod authMethod = Socks5AuthMethod.valueOf(in.readByte());
                    out.add(new DefaultSocks5InitialResponse(authMethod));
                    this.checkpoint(State.SUCCESS);
                }
                case SUCCESS: {
                    int readableBytes = this.actualReadableBytes();
                    if (readableBytes <= 0) break;
                    out.add(in.readRetainedSlice(readableBytes));
                    break;
                }
                case FAILURE: {
                    in.skipBytes(this.actualReadableBytes());
                }
            }
        }
        catch (Exception e2) {
            this.fail(out, e2);
        }
    }

    private void fail(List<Object> out, Exception cause) {
        if (!(cause instanceof DecoderException)) {
            cause = new DecoderException(cause);
        }
        this.checkpoint(State.FAILURE);
        DefaultSocks5InitialResponse m2 = new DefaultSocks5InitialResponse(Socks5AuthMethod.UNACCEPTED);
        m2.setDecoderResult(DecoderResult.failure(cause));
        out.add(m2);
    }

    public static enum State {
        INIT,
        SUCCESS,
        FAILURE;

    }
}

