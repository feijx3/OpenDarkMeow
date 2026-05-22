/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.handshake;

import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketRedirectServer;
import org.jetbrains.annotations.NotNull;

public final class HandleHandShakeServerRedirect
extends SimpleChannelInboundHandler<S2CPacketRedirectServer> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleHandShakeServerRedirect(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, S2CPacketRedirectServer packet) {
        this.connection.base.options.host = packet.getHost();
        this.connection.base.options.port = packet.getPort();
        this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, "\u670d\u52a1\u5668\u5730\u5740\u66f4\u65b0, \u8bf7\u91cd\u65b0\u8fde\u63a5", false);
    }
}

