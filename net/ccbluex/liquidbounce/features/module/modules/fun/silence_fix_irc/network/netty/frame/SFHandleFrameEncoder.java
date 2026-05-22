/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.frame;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToByteEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/frame/SFHandleFrameEncoder;", "Lnet/darkmeow/irc/lib/io/netty/handler/codec/MessageToByteEncoder;", "Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "<init>", "()V", "encode", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "msg", "out", "DarkMeow"})
public final class SFHandleFrameEncoder
extends MessageToByteEncoder<ByteBuf> {
    @Override
    protected void encode(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf msg, @NotNull ByteBuf out) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(msg.readableBytes());
        out.writeBytes(msg);
    }
}

