/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.online;

import net.darkmeow.irc.client.data.DataOtherSessionInfo;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSkin;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineSessionSkin
extends SimpleChannelInboundHandler<S2CPacketUpdateSkin> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleOnlineSessionSkin(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, S2CPacketUpdateSkin packet) {
        DataOtherSessionInfo info = this.connection.base.sessionManager.users.get(packet.getSessionId());
        if (info != null) {
            info.update(packet.getSkin());
            this.connection.base.listenable.onUpdateSessionSkin(info);
        }
    }
}

