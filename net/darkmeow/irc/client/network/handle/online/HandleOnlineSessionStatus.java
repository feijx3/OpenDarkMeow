/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.online;

import java.util.ArrayList;
import java.util.UUID;
import net.darkmeow.irc.client.data.DataOtherSessionInfo;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.data.DataUser;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSessionState;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSessionStateMulti;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineSessionStatus
extends ChannelInboundHandlerAdapter {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleOnlineSessionStatus(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        if (packet instanceof S2CPacketUpdateSessionState) {
            this.handleUpdateOtherState((S2CPacketUpdateSessionState)packet);
        } else if (packet instanceof S2CPacketUpdateSessionStateMulti) {
            this.handleUpdateOtherStateMulti((S2CPacketUpdateSessionStateMulti)packet);
        } else {
            super.channelRead(ctx, packet);
        }
    }

    public void handleUpdateOtherState(@NotNull S2CPacketUpdateSessionState packet) {
        if (packet.getUser() == null) {
            this.connection.base.sessionManager.users.remove(packet.getId());
        } else {
            this.connection.base.sessionManager.users.computeIfAbsent(packet.getId(), DataOtherSessionInfo::new).update(packet.getUser());
        }
    }

    public void handleUpdateOtherStateMulti(@NotNull S2CPacketUpdateSessionStateMulti packet) {
        ArrayList updates = new ArrayList();
        packet.getUserMap().forEach((uuid, info) -> {
            this.connection.base.sessionManager.users.computeIfAbsent((UUID)uuid, DataOtherSessionInfo::new).update((DataUser)info);
            updates.add(uuid);
        });
        if (packet.isOverrideAll()) {
            this.connection.base.sessionManager.users.forEach((uuid, info) -> {
                if (!updates.contains(uuid)) {
                    info.markInvalid();
                }
            });
            this.connection.base.sessionManager.clearInvalidUsers();
        }
    }
}

