/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.handle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFState;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.encryption.SFHandleAESDecoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.encryption.SFHandleAESEncoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketEncryptionReady;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketLogin;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketHandShakeSuccess;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPipeline;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/handle/SFHandleHandShake;", "Lnet/darkmeow/irc/lib/io/netty/channel/SimpleChannelInboundHandler;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketHandShakeSuccess;", "connection", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;)V", "getConnection", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "channelRead0", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
public final class SFHandleHandShake
extends SimpleChannelInboundHandler<SFS2CPacketHandShakeSuccess> {
    @NotNull
    private final SFConnection connection;

    public SFHandleHandShake(@NotNull SFConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
    }

    @NotNull
    public final SFConnection getConnection() {
        return this.connection;
    }

    @Override
    protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull SFS2CPacketHandShakeSuccess packet) {
        ChannelPipeline channelPipeline;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(packet, "packet");
        ChannelPipeline $this$channelRead0_u24lambda_u240 = channelPipeline = this.connection.getChannel().pipeline();
        boolean bl2 = false;
        $this$channelRead0_u24lambda_u240.addAfter("frame_decoder", "aes_decoder", new SFHandleAESDecoder(this.connection.getKey()));
        $this$channelRead0_u24lambda_u240.replace("rsa_encoder", "aes_encoder", (ChannelHandler)new SFHandleAESEncoder(this.connection.getKey()));
        String string = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue(string, "getProperty(...)");
        this.connection.sendPacket(new SFC2SPacketEncryptionReady(string));
        this.connection.setState(SFState.LOGIN);
        this.connection.sendPacket(new SFC2SPacketLogin(this.connection.getConfig()));
    }
}

