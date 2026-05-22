/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.handle.encryption;

import javax.crypto.Cipher;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToByteEncoder;
import net.darkmeow.irc.network.handle.encryption.data.NettyEncryptionTranslator;
import org.jetbrains.annotations.NotNull;

public class NettyEncryptingEncoder
extends MessageToByteEncoder<ByteBuf> {
    @NotNull
    private final NettyEncryptionTranslator encryptionCodec;

    public NettyEncryptingEncoder(@NotNull Cipher cipher) {
        this.encryptionCodec = new NettyEncryptionTranslator(cipher);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        this.encryptionCodec.cipher(in, out);
    }
}

