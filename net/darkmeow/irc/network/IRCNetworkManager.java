/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.network;

import javax.crypto.SecretKey;
import lombok.Generated;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFutureListener;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;
import net.darkmeow.irc.network.EnumConnectionState;
import net.darkmeow.irc.network.IRCNetworkAttributes;
import net.darkmeow.irc.network.handle.compression.NettyCompressionDecoder;
import net.darkmeow.irc.network.handle.compression.NettyCompressionEncoder;
import net.darkmeow.irc.network.handle.encryption.NettyEncryptingDecoder;
import net.darkmeow.irc.network.handle.encryption.NettyEncryptingEncoder;
import net.darkmeow.irc.network.packet.Packet;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCNetworkManager
extends ChannelInboundHandlerAdapter {
    @Nullable
    protected Channel channel;
    private boolean isEncrypted = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.channel = ctx.channel();
        IRCNetworkManager iRCNetworkManager = this;
        synchronized (iRCNetworkManager) {
            this.notifyAll();
        }
        this.setConnectionState(EnumConnectionState.HANDSHAKING);
    }

    public boolean isConnected() {
        return this.channel != null && this.channel.isOpen();
    }

    public void close() {
        if (this.channel != null && this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
        }
    }

    public void setConnectionState(EnumConnectionState newState) {
        if (this.channel != null) {
            this.channel.attr(IRCNetworkAttributes.PROTOCOL_TYPE).set(newState);
            this.channel.config().setAutoRead(true);
        }
    }

    @Nullable
    public EnumConnectionState getConnectionState() {
        return this.channel != null ? this.channel.attr(IRCNetworkAttributes.PROTOCOL_TYPE).get() : null;
    }

    public void sendPacket(@NotNull Packet packet) {
        if (this.channel != null && this.channel.isActive()) {
            ChannelFuture channelfuture = this.channel.writeAndFlush(packet);
            channelfuture.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
    }

    @SafeVarargs
    public final void sendPacket(@NotNull Packet packet, GenericFutureListener<? extends Future<? super Void>> ... futureListeners) {
        if (this.channel != null && this.channel.isActive()) {
            ChannelFuture channelfuture = this.channel.writeAndFlush(packet);
            if (futureListeners != null) {
                channelfuture.addListeners((GenericFutureListener[])futureListeners);
            }
            channelfuture.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
    }

    public void enableEncryption(SecretKey key) {
        if (this.channel != null) {
            this.channel.pipeline().addBefore("splitter", "decrypt", new NettyEncryptingDecoder(CryptUtils.createNetCipherInstance(2, key)));
            this.channel.pipeline().addBefore("prepender", "encrypt", new NettyEncryptingEncoder(CryptUtils.createNetCipherInstance(1, key)));
            this.isEncrypted = true;
        }
    }

    public void enableCompression(int threshold) {
        if (this.channel != null && threshold >= 0) {
            this.channel.pipeline().addBefore("decoder", "decompress", new NettyCompressionDecoder(threshold));
            this.channel.pipeline().addBefore("encoder", "compress", new NettyCompressionEncoder(threshold));
        }
    }

    @Nullable
    @Generated
    public Channel getChannel() {
        return this.channel;
    }

    @Generated
    public boolean isEncrypted() {
        return this.isEncrypted;
    }
}

