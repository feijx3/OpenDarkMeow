/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.handle.encryption;

import java.util.List;
import javax.crypto.Cipher;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToMessageDecoder;
import net.darkmeow.irc.network.handle.encryption.data.NettyEncryptionTranslator;
import org.jetbrains.annotations.NotNull;

public class NettyEncryptingDecoder
extends MessageToMessageDecoder<ByteBuf> {
    @NotNull
    private final NettyEncryptionTranslator decryptionCodec;

    public NettyEncryptingDecoder(@NotNull Cipher cipher) {
        this.decryptionCodec = new NettyEncryptionTranslator(cipher);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(this.decryptionCodec.decipher(ctx, in));
    }
}

