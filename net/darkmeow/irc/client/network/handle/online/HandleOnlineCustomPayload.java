/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.online;

import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketCustomPayload;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineCustomPayload
extends SimpleChannelInboundHandler<S2CPacketCustomPayload> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleOnlineCustomPayload(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, S2CPacketCustomPayload packet) {
        this.connection.base.listenable.onCustomPayload(packet.getChannel(), packet.getData());
    }
}

