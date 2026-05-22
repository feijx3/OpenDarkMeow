/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.handshake;

import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.client.options.IRCClientRemoteVerify;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.EnumConnectionState;
import net.darkmeow.irc.network.packet.S2CPacket;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketDenyHandShake;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketHandShakeSuccess;
import org.jetbrains.annotations.NotNull;

public final class HandleHandShakeBase
extends SimpleChannelInboundHandler<S2CPacket> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleHandShakeBase(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, S2CPacket packet) throws Exception {
        if (packet instanceof S2CPacketHandShakeSuccess) {
            this.handleHandShakeSuccess((S2CPacketHandShakeSuccess)packet);
        } else if (packet instanceof S2CPacketDenyHandShake) {
            this.handleDenyHandShake((S2CPacketDenyHandShake)packet);
        } else {
            ctx.fireChannelRead(packet);
        }
    }

    public void handleHandShakeSuccess(S2CPacketHandShakeSuccess packet) {
        IRCClientRemoteVerify remoteVerify = this.connection.base.options.remoteVerify;
        if (remoteVerify != null && !remoteVerify.verify) {
            this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, "\u670d\u52a1\u5668\u8eab\u4efd\u9a8c\u8bc1\u5931\u8d25 (\u672a\u53d1\u9001\u8fc7\u7b7e\u540d\u6570\u636e)", false);
            return;
        }
        this.connection.base.sessionManager.reset(packet.getSessionId());
        this.connection.setConnectionState(EnumConnectionState.LOGIN);
        this.connection.base.listenable.onReadyLogin(this.connection.base);
    }

    public void handleDenyHandShake(S2CPacketDenyHandShake packet) {
        this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, packet.getReason(), false);
    }
}

