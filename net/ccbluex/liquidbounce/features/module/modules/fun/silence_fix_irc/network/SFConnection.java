/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network;

import java.net.InetSocketAddress;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFConfig;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUserSelf;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFState;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.encryption.SFHandleRSAEncoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.frame.SFHandleFrameDecoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.frame.SFHandleFrameEncoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.handle.SFHandleAccount;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.handle.SFHandleHandShake;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.handle.SFHandleKeepAlive;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.packet.SFHandlePacketDecoder;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.lib.io.netty.bootstrap.Bootstrap;
import net.darkmeow.irc.lib.io.netty.buffer.PooledByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFutureListener;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInitializer;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOption;
import net.darkmeow.irc.lib.io.netty.channel.socket.SocketChannel;
import net.darkmeow.irc.lib.io.netty.channel.socket.nio.NioSocketChannel;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u001fJ\u0016\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006/"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "", "config", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;)V", "getConfig", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;", "channel", "Lnet/darkmeow/irc/lib/io/netty/channel/Channel;", "getChannel", "()Lnet/darkmeow/irc/lib/io/netty/channel/Channel;", "setChannel", "(Lnet/darkmeow/irc/lib/io/netty/channel/Channel;)V", "key", "Ljavax/crypto/SecretKey;", "getKey", "()Ljavax/crypto/SecretKey;", "state", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFState;", "getState", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFState;", "setState", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFState;)V", "info", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "getInfo", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "setInfo", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;)V", "disconnectReason", "", "getDisconnectReason", "()Ljava/lang/String;", "setDisconnectReason", "(Ljava/lang/String;)V", "sendPacket", "", "packet", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacket;", "close", "reason", "addPipeLineToLast", "name", "handler", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandler;", "Companion", "DarkMeow"})
public final class SFConnection {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SFConfig config;
    public Channel channel;
    @NotNull
    private final SecretKey key;
    @NotNull
    private SFState state;
    @NotNull
    private SFUserSelf info;
    @NotNull
    private String disconnectReason;

    /*
     * WARNING - void declaration
     */
    public SFConnection(@NotNull SFConfig config) {
        void $this$key_u24lambda_u240;
        KeyGenerator keyGenerator;
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        KeyGenerator keyGenerator2 = keyGenerator = KeyGenerator.getInstance("AES");
        SFConnection sFConnection = this;
        boolean bl2 = false;
        $this$key_u24lambda_u240.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKey, "generateKey(...)");
        sFConnection.key = secretKey;
        this.state = SFState.CONNECTING;
        this.info = SFUserSelf.Companion.getEMPTY();
        this.disconnectReason = "";
    }

    @NotNull
    public final SFConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final Channel getChannel() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        return null;
    }

    public final void setChannel(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "<set-?>");
        this.channel = channel;
    }

    @NotNull
    public final SecretKey getKey() {
        return this.key;
    }

    @NotNull
    public final SFState getState() {
        return this.state;
    }

    public final void setState(@NotNull SFState sFState) {
        Intrinsics.checkNotNullParameter((Object)sFState, "<set-?>");
        this.state = sFState;
    }

    @NotNull
    public final SFUserSelf getInfo() {
        return this.info;
    }

    public final void setInfo(@NotNull SFUserSelf sFUserSelf) {
        Intrinsics.checkNotNullParameter(sFUserSelf, "<set-?>");
        this.info = sFUserSelf;
    }

    @NotNull
    public final String getDisconnectReason() {
        return this.disconnectReason;
    }

    public final void setDisconnectReason(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.disconnectReason = string;
    }

    public final void sendPacket(@NotNull SFC2SPacket packet) {
        SilenceFixNettyBuffer silenceFixNettyBuffer;
        Intrinsics.checkNotNullParameter(packet, "packet");
        SilenceFixNettyBuffer $this$sendPacket_u24lambda_u241 = silenceFixNettyBuffer = SilenceFixNettyBuffer.Companion.create();
        boolean bl2 = false;
        $this$sendPacket_u24lambda_u241.writeByte(packet.getId());
        packet.write($this$sendPacket_u24lambda_u241);
        SilenceFixNettyBuffer buf = silenceFixNettyBuffer;
        boolean bl3 = false;
        this.getChannel().writeAndFlush(buf.getWrapped()).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }

    public final void close(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.getChannel().close();
        this.disconnectReason = reason;
    }

    public static /* synthetic */ void close$default(SFConnection sFConnection, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = "";
        }
        sFConnection.close(string);
    }

    public final void addPipeLineToLast(@NotNull String name, @NotNull ChannelHandler handler) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.getChannel().pipeline().addLast(name, handler);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection$Companion;", "", "<init>", "()V", "create", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "config", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SFConnection create(@NotNull SFConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            SFConnection connection = new SFConnection(config);
            ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(IRCClientNetworkManager.eventLoopGroup)).handler(new ChannelInitializer<SocketChannel>(connection, config){
                final /* synthetic */ SFConnection $connection;
                final /* synthetic */ SFConfig $config;
                {
                    this.$connection = $connection;
                    this.$config = $config;
                }

                protected void initChannel(SocketChannel channel) {
                    Intrinsics.checkNotNullParameter(channel, "channel");
                    this.$connection.setChannel(channel);
                    this.$connection.setState(SFState.HANDSHAKE);
                    channel.pipeline().addLast("frame_decoder", (ChannelHandler)new SFHandleFrameDecoder()).addLast("frame_encoder", (ChannelHandler)new SFHandleFrameEncoder()).addLast("rsa_encoder", (ChannelHandler)new SFHandleRSAEncoder()).addLast("packet_decoder", (ChannelHandler)new SFHandlePacketDecoder(this.$connection)).addLast("handle_handshake", (ChannelHandler)new SFHandleHandShake(this.$connection)).addLast("handle_keepalive", (ChannelHandler)new SFHandleKeepAlive(this.$connection)).addLast("handle_account", (ChannelHandler)new SFHandleAccount(this.$connection));
                    this.$config.getBlockNettyChannelInject().invoke(this.$connection);
                }
            })).channel(NioSocketChannel.class)).option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)).option(ChannelOption.SO_REUSEADDR, true)).connect(new InetSocketAddress("4sm6gjha.svipcdn.cn", 41201));
            return connection;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

