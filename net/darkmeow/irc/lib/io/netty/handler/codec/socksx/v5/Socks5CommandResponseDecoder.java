/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderException;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.ReplayingDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.SocksVersion;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.DefaultSocks5CommandResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public class Socks5CommandResponseDecoder
extends ReplayingDecoder<State> {
    private final Socks5AddressDecoder addressDecoder;

    public Socks5CommandResponseDecoder() {
        this(Socks5AddressDecoder.DEFAULT);
    }

    public Socks5CommandResponseDecoder(Socks5AddressDecoder addressDecoder) {
        super(State.INIT);
        this.addressDecoder = ObjectUtil.checkNotNull(addressDecoder, "addressDecoder");
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
                    Socks5CommandStatus status = Socks5CommandStatus.valueOf(in.readByte());
                    in.skipBytes(1);
                    Socks5AddressType addrType = Socks5AddressType.valueOf(in.readByte());
                    String addr = this.addressDecoder.decodeAddress(addrType, in);
                    int port = ByteBufUtil.readUnsignedShortBE(in);
                    out.add(new DefaultSocks5CommandResponse(status, addrType, addr, port));
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
        DefaultSocks5CommandResponse m2 = new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, Socks5AddressType.IPv4, null, 0);
        m2.setDecoderResult(DecoderResult.failure(cause));
        out.add(m2);
    }

    public static enum State {
        INIT,
        SUCCESS,
        FAILURE;

    }
}

