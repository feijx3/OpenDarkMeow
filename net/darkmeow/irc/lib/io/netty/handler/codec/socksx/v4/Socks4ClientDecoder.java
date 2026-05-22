/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderException;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.ReplayingDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.DefaultSocks4CommandResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import net.darkmeow.irc.lib.io.netty.util.NetUtil;

public class Socks4ClientDecoder
extends ReplayingDecoder<State> {
    public Socks4ClientDecoder() {
        super(State.START);
        this.setSingleDecode(true);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            switch ((State)((Object)this.state())) {
                case START: {
                    short version = in.readUnsignedByte();
                    if (version != 0) {
                        throw new DecoderException("unsupported reply version: " + version + " (expected: 0)");
                    }
                    Socks4CommandStatus status = Socks4CommandStatus.valueOf(in.readByte());
                    int dstPort = ByteBufUtil.readUnsignedShortBE(in);
                    String dstAddr = NetUtil.intToIpAddress(ByteBufUtil.readIntBE(in));
                    out.add(new DefaultSocks4CommandResponse(status, dstAddr, dstPort));
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
        DefaultSocks4CommandResponse m2 = new DefaultSocks4CommandResponse(Socks4CommandStatus.REJECTED_OR_FAILED);
        m2.setDecoderResult(DecoderResult.failure(cause));
        out.add(m2);
        this.checkpoint(State.FAILURE);
    }

    public static enum State {
        START,
        SUCCESS,
        FAILURE;

    }
}

