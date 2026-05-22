/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.encryption;

import java.nio.ByteBuffer;
import java.security.Key;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToMessageEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/encryption/SFHandleAESEncoder;", "Lnet/darkmeow/irc/lib/io/netty/handler/codec/MessageToMessageEncoder;", "Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "key", "Ljava/security/Key;", "<init>", "(Ljava/security/Key;)V", "getKey", "()Ljava/security/Key;", "encode", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "msg", "out", "", "", "DarkMeow"})
public final class SFHandleAESEncoder
extends MessageToMessageEncoder<ByteBuf> {
    @NotNull
    private final Key key;

    public SFHandleAESEncoder(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @NotNull
    public final Key getKey() {
        return this.key;
    }

    @Override
    protected void encode(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf msg, @NotNull List<Object> out) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(out, "out");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, this.key);
        ByteBuffer encryptBuffer = ByteBuffer.allocate(4 + cipher.getOutputSize(msg.readableBytes()));
        encryptBuffer.putInt(msg.readableBytes());
        cipher.doFinal(msg.nioBuffer(), encryptBuffer);
        encryptBuffer.position(0);
        out.add(Unpooled.wrappedBuffer(encryptBuffer));
    }
}

