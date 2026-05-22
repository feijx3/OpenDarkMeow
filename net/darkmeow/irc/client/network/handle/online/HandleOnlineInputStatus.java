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
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketOtherInputState;
import org.jetbrains.annotations.NotNull;

public final class HandleOnlineInputStatus
extends SimpleChannelInboundHandler<S2CPacketOtherInputState> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleOnlineInputStatus(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, S2CPacketOtherInputState packet) {
        this.connection.base.listenable.onUpdateOtherInputs(packet.getPublicInputs(), packet.getPrivateInputs());
    }
}

