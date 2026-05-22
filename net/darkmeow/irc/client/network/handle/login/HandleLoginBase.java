/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.login;

import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.darkmeow.irc.network.EnumConnectionState;
import net.darkmeow.irc.network.packet.login.s2c.S2CPacketLoginFailed;
import net.darkmeow.irc.network.packet.login.s2c.S2CPacketLoginSuccess;
import org.jetbrains.annotations.NotNull;

public final class HandleLoginBase
extends ChannelInboundHandlerAdapter {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleLoginBase(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        if (packet instanceof S2CPacketLoginSuccess) {
            this.handleLoginSuccess((S2CPacketLoginSuccess)packet);
        } else if (packet instanceof S2CPacketLoginFailed) {
            this.handleLoginFailed((S2CPacketLoginFailed)packet);
        } else {
            super.channelRead(ctx, packet);
        }
    }

    public void handleLoginSuccess(S2CPacketLoginSuccess packet) {
        this.connection.setConnectionState(EnumConnectionState.ONLINE);
        this.connection.base.listenable.onUpdateSession(packet.getToken());
    }

    public void handleLoginFailed(S2CPacketLoginFailed packet) {
        this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, packet.getReason(), packet.isMarkSessionTokenInvalid());
    }
}

