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
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketServerInfo;
import org.jetbrains.annotations.NotNull;

public final class HandleHandShakeServerInfo
extends SimpleChannelInboundHandler<S2CPacketServerInfo> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleHandShakeServerInfo(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        IRCClientRemoteVerify remoteVerify = this.connection.base.options.remoteVerify;
        if (remoteVerify != null) {
            remoteVerify.verify = false;
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, S2CPacketServerInfo packet) throws Exception {
        IRCClientRemoteVerify remoteVerify = this.connection.base.options.remoteVerify;
        if (remoteVerify != null) {
            if (!packet.checkSignature(remoteVerify.getKey())) {
                this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, "\u670d\u52a1\u5668\u8eab\u4efd\u9a8c\u8bc1\u5931\u8d25 (\u65e0\u6548\u7b7e\u540d)", false);
                return;
            }
            long currentTime = System.currentTimeMillis();
            if (currentTime - 15000L > packet.getTimestamp() || packet.getTimestamp() > currentTime + 15000L) {
                this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, "\u670d\u52a1\u5668\u8eab\u4efd\u9a8c\u8bc1\u5931\u8d25 (\u6821\u65f6\u504f\u5dee\u8fc7\u5927)", false);
                return;
            }
            remoteVerify.verify = true;
        }
    }
}

