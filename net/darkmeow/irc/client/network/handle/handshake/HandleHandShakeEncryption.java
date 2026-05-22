/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.network.handle.handshake;

import javax.crypto.SecretKey;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.darkmeow.irc.network.packet.handshake.c2s.C2SPacketEncryptionResponse;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketEncryptionRequest;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public final class HandleHandShakeEncryption
extends SimpleChannelInboundHandler<S2CPacketEncryptionRequest> {
    @NotNull
    public final IRCClientNetworkManager connection;

    public HandleHandShakeEncryption(@NotNull IRCClientNetworkManager connection) {
        this.connection = connection;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, S2CPacketEncryptionRequest packet) throws Exception {
        SecretKey secretkey = CryptUtils.createNewSharedKey();
        if (packet.hasSignatureRequire()) {
            if (this.connection.base.options.clientKey != null) {
                this.connection.sendPacket(new C2SPacketEncryptionResponse(packet.getPublicKey(), secretkey, this.connection.base.options.clientKey.getKey(), packet.getSignatureData()), future -> this.connection.enableEncryption(secretkey));
            } else {
                this.connection.base.closeChannel(EnumDisconnectType.FAILED_TO_LOGIN, "\u672a\u914d\u7f6e\u7b7e\u540d\u79c1\u94a5, \u65e0\u6cd5\u901a\u8fc7\u670d\u52a1\u7aef\u8ba4\u8bc1", false);
            }
        } else {
            this.connection.sendPacket(new C2SPacketEncryptionResponse(packet.getPublicKey(), secretkey), future -> this.connection.enableEncryption(secretkey));
        }
    }
}

