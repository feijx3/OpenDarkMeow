/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.online;

import java.util.Objects;
import lombok.Generated;
import net.darkmeow.irc.client.data.DataSelfSessionInfo;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateMyProfile;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineUpdateMyProfile
extends SimpleChannelInboundHandler<S2CPacketUpdateMyProfile> {
    @NotNull
    public final IRCClientNetworkManager connection;
    private int updateCount = 0;

    public HandleOnlineUpdateMyProfile(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, S2CPacketUpdateMyProfile packet) {
        ++this.updateCount;
        if (this.connection.base.sessionManager.self == null || this.connection.base.sessionManager.self.uniqueId != this.connection.base.sessionManager.sessionId) {
            if (this.connection.base.sessionManager.self != null) {
                this.connection.base.sessionManager.self.markInvalid();
            }
            this.connection.base.sessionManager.self = new DataSelfSessionInfo(Objects.requireNonNull(this.connection.base.sessionManager.sessionId), packet.getName(), packet.getPremium(), packet.isInvisible());
        } else {
            this.connection.base.sessionManager.self.update(packet.getName(), packet.getPremium(), packet.isInvisible());
        }
        this.connection.base.listenable.onUpdateUserInfo(this.connection.base.sessionManager.self, this.updateCount == 1);
    }

    @Generated
    public int getUpdateCount() {
        return this.updateCount;
    }
}

