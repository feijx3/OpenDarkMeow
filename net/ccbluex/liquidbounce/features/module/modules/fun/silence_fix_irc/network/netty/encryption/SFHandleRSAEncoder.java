/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.encryption;

import java.nio.ByteBuffer;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFProtocol;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToMessageEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/encryption/SFHandleRSAEncoder;", "Lnet/darkmeow/irc/lib/io/netty/handler/codec/MessageToMessageEncoder;", "Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "<init>", "()V", "encode", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "out", "", "", "DarkMeow"})
public final class SFHandleRSAEncoder
extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(@NotNull ChannelHandlerContext ctx, @Nullable ByteBuf packet, @NotNull List<Object> out) {
        block0: {
            ByteBuf byteBuf;
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(out, "out");
            if (packet == null) break block0;
            ByteBuf msg = byteBuf = packet;
            boolean bl2 = false;
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, SFProtocol.INSTANCE.getPROTOCOL_KEY());
            int inputLength = msg.readableBytes();
            int outputSize = cipher.getOutputSize(inputLength);
            ByteBuffer encryptBuffer = ByteBuffer.allocate(4 + outputSize);
            encryptBuffer.putInt(inputLength);
            cipher.doFinal(msg.nioBuffer(), encryptBuffer);
            encryptBuffer.flip();
            ByteBuf byteBuf2 = Unpooled.wrappedBuffer(encryptBuffer);
            Intrinsics.checkNotNullExpressionValue(byteBuf2, "wrappedBuffer(...)");
            out.add(byteBuf2);
        }
    }
}

