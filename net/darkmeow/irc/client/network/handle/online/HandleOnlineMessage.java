/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.online;

import java.util.Objects;
import net.darkmeow.irc.client.data.DataOtherSessionInfo;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketPrivateMessageResult;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketSessionMessage;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketSystemMessage;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineMessage
extends ChannelInboundHandlerAdapter {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleOnlineMessage(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        if (packet instanceof S2CPacketSessionMessage) {
            this.handleSessionMessage((S2CPacketSessionMessage)packet);
        } else if (packet instanceof S2CPacketSystemMessage) {
            this.handleSystemMessage((S2CPacketSystemMessage)packet);
        } else if (packet instanceof S2CPacketPrivateMessageResult) {
            this.handlePrivateMessageResult((S2CPacketPrivateMessageResult)packet);
        } else {
            super.channelRead(ctx, packet);
        }
    }

    public void handleSessionMessage(@NotNull S2CPacketSessionMessage packet) {
        DataOtherSessionInfo info = this.connection.base.sessionManager.users.computeIfAbsent(packet.getSender(), DataOtherSessionInfo::new);
        info.update(packet.getSenderData());
        switch (packet.getType()) {
            case PUBLIC: {
                this.connection.base.listenable.onMessagePublic(info, packet.getMessage());
                break;
            }
            case PRIVATE: {
                this.connection.base.listenable.onMessagePrivate(info, packet.getMessage());
            }
        }
    }

    public void handleSystemMessage(@NotNull S2CPacketSystemMessage packet) {
        this.connection.base.listenable.onMessageSystem(packet.getMessage());
    }

    public void handlePrivateMessageResult(@NotNull S2CPacketPrivateMessageResult packet) {
        if (packet.isSuccess()) {
            this.connection.base.listenable.onPrivateMessageSendSuccess(packet.getReceiver(), Objects.requireNonNull(packet.getMessage()));
        } else {
            this.connection.base.listenable.onPrivateMessageSendFailed(packet.getReceiver());
        }
    }
}

