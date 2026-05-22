/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import java.util.List;
import java.util.RandomAccess;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.EncoderException;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToByteEncoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressEncoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5CommandRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5InitialRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequest;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

@ChannelHandler.Sharable
public class Socks5ClientEncoder
extends MessageToByteEncoder<Socks5Message> {
    public static final Socks5ClientEncoder DEFAULT = new Socks5ClientEncoder();
    private final Socks5AddressEncoder addressEncoder;

    protected Socks5ClientEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    public Socks5ClientEncoder(Socks5AddressEncoder addressEncoder) {
        this.addressEncoder = ObjectUtil.checkNotNull(addressEncoder, "addressEncoder");
    }

    protected final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Socks5Message msg, ByteBuf out) throws Exception {
        if (msg instanceof Socks5InitialRequest) {
            Socks5ClientEncoder.encodeAuthMethodRequest((Socks5InitialRequest)msg, out);
        } else if (msg instanceof Socks5PasswordAuthRequest) {
            Socks5ClientEncoder.encodePasswordAuthRequest((Socks5PasswordAuthRequest)msg, out);
        } else if (msg instanceof Socks5CommandRequest) {
            this.encodeCommandRequest((Socks5CommandRequest)msg, out);
        } else {
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(msg));
        }
    }

    private static void encodeAuthMethodRequest(Socks5InitialRequest msg, ByteBuf out) {
        out.writeByte(msg.version().byteValue());
        List<Socks5AuthMethod> authMethods = msg.authMethods();
        int numAuthMethods = authMethods.size();
        out.writeByte(numAuthMethods);
        if (authMethods instanceof RandomAccess) {
            for (int i2 = 0; i2 < numAuthMethods; ++i2) {
                out.writeByte(authMethods.get(i2).byteValue());
            }
        } else {
            for (Socks5AuthMethod a2 : authMethods) {
                out.writeByte(a2.byteValue());
            }
        }
    }

    private static void encodePasswordAuthRequest(Socks5PasswordAuthRequest msg, ByteBuf out) {
        out.writeByte(1);
        String username = msg.username();
        out.writeByte(username.length());
        ByteBufUtil.writeAscii(out, (CharSequence)username);
        String password = msg.password();
        out.writeByte(password.length());
        ByteBufUtil.writeAscii(out, (CharSequence)password);
    }

    private void encodeCommandRequest(Socks5CommandRequest msg, ByteBuf out) throws Exception {
        out.writeByte(msg.version().byteValue());
        out.writeByte(msg.type().byteValue());
        out.writeByte(0);
        Socks5AddressType dstAddrType = msg.dstAddrType();
        out.writeByte(dstAddrType.byteValue());
        this.addressEncoder.encodeAddress(dstAddrType, msg.dstAddr(), out);
        ByteBufUtil.writeShortBE(out, msg.dstPort());
    }
}

