/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.handle;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFState;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketUpdateGameProfile;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketLoginResult;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketUserInformation;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/handle/SFHandleAccount;", "Lnet/darkmeow/irc/lib/io/netty/channel/SimpleChannelInboundHandler;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "connection", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;)V", "getConnection", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "channelRead0", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
public final class SFHandleAccount
extends SimpleChannelInboundHandler<SFS2CPacket> {
    @NotNull
    private final SFConnection connection;

    public SFHandleAccount(@NotNull SFConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
    }

    @NotNull
    public final SFConnection getConnection() {
        return this.connection;
    }

    @Override
    protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull SFS2CPacket packet) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(packet, "packet");
        SFS2CPacket sFS2CPacket = packet;
        if (sFS2CPacket instanceof SFS2CPacketLoginResult) {
            if (((SFS2CPacketLoginResult)packet).isSuccess()) {
                this.connection.setState(SFState.PLAY);
                this.connection.sendPacket(new SFC2SPacketUpdateGameProfile(new UUID(0L, 0L), ""));
            } else {
                this.connection.close("\u767b\u5f55\u5931\u8d25: " + ((SFS2CPacketLoginResult)packet).getMessage());
            }
        } else if (sFS2CPacket instanceof SFS2CPacketUserInformation) {
            this.connection.setInfo(((SFS2CPacketUserInformation)packet).getUser());
        }
        ctx.fireChannelRead(packet);
    }
}

