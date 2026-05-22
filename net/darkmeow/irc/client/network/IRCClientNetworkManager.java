/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.network;

import net.darkmeow.irc.client.IRCClient;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.network.handle.handshake.HandleHandShakeBase;
import net.darkmeow.irc.client.network.handle.handshake.HandleHandShakeCompression;
import net.darkmeow.irc.client.network.handle.handshake.HandleHandShakeEncryption;
import net.darkmeow.irc.client.network.handle.handshake.HandleHandShakeServerInfo;
import net.darkmeow.irc.client.network.handle.handshake.HandleHandShakeServerRedirect;
import net.darkmeow.irc.client.network.handle.login.HandleLoginBase;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineCustomPayload;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineInputStatus;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineKeepAlive;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineMessage;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineRemoteDisconnect;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineSessionSkin;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineSessionStatus;
import net.darkmeow.irc.client.network.handle.online.HandleOnlineUpdateMyProfile;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import net.darkmeow.irc.lib.io.netty.bootstrap.Bootstrap;
import net.darkmeow.irc.lib.io.netty.buffer.PooledByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInitializer;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOption;
import net.darkmeow.irc.lib.io.netty.channel.MultiThreadIoEventLoopGroup;
import net.darkmeow.irc.lib.io.netty.channel.nio.NioIoHandler;
import net.darkmeow.irc.lib.io.netty.channel.socket.SocketChannel;
import net.darkmeow.irc.lib.io.netty.channel.socket.nio.NioSocketChannel;
import net.darkmeow.irc.lib.io.netty.handler.timeout.ReadTimeoutHandler;
import net.darkmeow.irc.lib.io.netty.handler.timeout.TimeoutException;
import net.darkmeow.irc.network.EnumPacketDirection;
import net.darkmeow.irc.network.IRCNetworkManager;
import net.darkmeow.irc.network.handle.frame.NettyVarInt21FrameDecoder;
import net.darkmeow.irc.network.handle.frame.NettyVarInt21FrameEncoder;
import net.darkmeow.irc.network.handle.packet.NettyPacketDecoder;
import net.darkmeow.irc.network.handle.packet.NettyPacketEncoder;
import net.darkmeow.irc.network.packet.handshake.c2s.C2SPacketHandShake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCClientNetworkManager
extends IRCNetworkManager {
    public static MultiThreadIoEventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
    @NotNull
    public IRCClient base;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IRCClientNetworkManager createNetworkManagerAndConnect(@NotNull IRCClient base, @NotNull String host, int port, final @Nullable IRCOptionsProxy proxy) throws Throwable {
        final IRCClientNetworkManager networkManager = new IRCClientNetworkManager(base);
        ChannelFuture future = ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(eventLoopGroup)).handler(new ChannelInitializer<SocketChannel>(){

            @Override
            protected void initChannel(SocketChannel ch2) {
                ChannelHandler handler;
                if (proxy != null && (handler = proxy.getNettyHandler()) != null) {
                    ch2.pipeline().addLast("proxy", handler);
                }
                ch2.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(15));
                ch2.pipeline().addLast("splitter", (ChannelHandler)new NettyVarInt21FrameDecoder());
                ch2.pipeline().addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.CLIENT_BOUND));
                ch2.pipeline().addLast("prepender", (ChannelHandler)new NettyVarInt21FrameEncoder());
                ch2.pipeline().addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.SERVER_BOUND));
                ch2.pipeline().addLast("base", (ChannelHandler)networkManager);
                ch2.pipeline().addLast("handler_handshake_base", (ChannelHandler)new HandleHandShakeBase(networkManager));
                ch2.pipeline().addLast("handler_handshake_compression", (ChannelHandler)new HandleHandShakeCompression(networkManager));
                ch2.pipeline().addLast("handler_handshake_encryption", (ChannelHandler)new HandleHandShakeEncryption(networkManager));
                ch2.pipeline().addLast("handler_handshake_server_redirect", (ChannelHandler)new HandleHandShakeServerRedirect(networkManager));
                ch2.pipeline().addLast("handler_handshake_server_info", (ChannelHandler)new HandleHandShakeServerInfo(networkManager));
                ch2.pipeline().addLast("handler_login_base", (ChannelHandler)new HandleLoginBase(networkManager));
                ch2.pipeline().addLast("handler_online_keepalive", (ChannelHandler)new HandleOnlineKeepAlive(networkManager));
                ch2.pipeline().addLast("handler_online_update_my_profile", (ChannelHandler)new HandleOnlineUpdateMyProfile(networkManager));
                ch2.pipeline().addLast("handler_online_message", (ChannelHandler)new HandleOnlineMessage(networkManager));
                ch2.pipeline().addLast("handler_online_input_status", (ChannelHandler)new HandleOnlineInputStatus(networkManager));
                ch2.pipeline().addLast("handler_online_session_status", (ChannelHandler)new HandleOnlineSessionStatus(networkManager));
                ch2.pipeline().addLast("handler_online_session_skin", (ChannelHandler)new HandleOnlineSessionSkin(networkManager));
                ch2.pipeline().addLast("handler_online_remote_disconnect", (ChannelHandler)new HandleOnlineRemoteDisconnect(networkManager));
                ch2.pipeline().addLast("handler_online_custom_payload", (ChannelHandler)new HandleOnlineCustomPayload(networkManager));
            }
        })).channel(NioSocketChannel.class)).option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)).option(ChannelOption.SO_REUSEADDR, true)).connect(host, port).syncUninterruptibly();
        if (future.isSuccess()) {
            IRCClientNetworkManager iRCClientNetworkManager = networkManager;
            synchronized (iRCClientNetworkManager) {
                while (networkManager.channel == null) {
                    networkManager.wait();
                }
            }
        } else {
            throw future.cause();
        }
        return networkManager;
    }

    public IRCClientNetworkManager(@NotNull IRCClient base) {
        this.base = base;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        super.channelActive(ctx);
        this.sendPacket(new C2SPacketHandShake(0, this.base.options.host, this.base.options.port, this.base.options.hardWareUniqueId, this.base.options.brand, System.currentTimeMillis()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e2) {
        if (e2 instanceof TimeoutException) {
            this.base.closeChannel(EnumDisconnectType.OTHER, "\u8fde\u63a5\u8d85\u65f6.", false);
        } else {
            this.base.closeChannel(EnumDisconnectType.OTHER, "\u5185\u90e8\u9519\u8bef: " + e2.getClass().getSimpleName() + ": " + e2.getMessage(), false);
        }
    }
}

