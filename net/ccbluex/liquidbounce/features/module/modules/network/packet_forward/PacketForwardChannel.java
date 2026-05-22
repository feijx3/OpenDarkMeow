/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandler
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eJK\u0010\u000f\u001a\u00020\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u001122\u0010\u0012\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00160\u00150\u00140\u0013\"\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00160\u00150\u0014\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "", "wrapped", "Lio/netty/channel/Channel;", "<init>", "(Lio/netty/channel/Channel;)V", "getWrapped", "()Lio/netty/channel/Channel;", "state", "", "getState", "()Z", "setConnectionState", "", "Lnet/minecraft/network/EnumConnectionState;", "sendPacket", "packet", "Lnet/minecraft/network/Packet;", "futureListeners", "", "Lio/netty/util/concurrent/GenericFutureListener;", "Lio/netty/util/concurrent/Future;", "Ljava/lang/Void;", "(Lnet/minecraft/network/Packet;[Lio/netty/util/concurrent/GenericFutureListener;)V", "addHandle", "name", "", "handler", "Lio/netty/channel/ChannelHandler;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardChannel.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,38:1\n13472#2,2:39\n*S KotlinDebug\n*F\n+ 1 PacketForwardChannel.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel\n*L\n26#1:39,2\n*E\n"})
public final class PacketForwardChannel {
    @NotNull
    private final Channel wrapped;

    public PacketForwardChannel(@NotNull Channel wrapped) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.wrapped = wrapped;
    }

    @NotNull
    public final Channel getWrapped() {
        return this.wrapped;
    }

    public final boolean getState() {
        return this.wrapped.isOpen();
    }

    public final void setConnectionState(@NotNull EnumConnectionState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.wrapped.attr(NetworkManager.field_150739_c).set((Object)state);
        this.wrapped.config().setAutoRead(true);
    }

    public final void sendPacket(@NotNull Packet<?> packet, GenericFutureListener<? extends Future<? super Void>> ... futureListeners) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(futureListeners, "futureListeners");
        if (this.getState()) {
            ChannelFuture channelFuture;
            ChannelFuture $this$sendPacket_u24lambda_u241 = channelFuture = this.wrapped.writeAndFlush(packet);
            boolean bl2 = false;
            GenericFutureListener<? extends Future<? super Void>>[] $this$forEach$iv = futureListeners;
            boolean $i$f$forEach = false;
            int n2 = $this$forEach$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                GenericFutureListener<? extends Future<? super Void>> element$iv;
                GenericFutureListener<? extends Future<? super Void>> future = element$iv = $this$forEach$iv[i2];
                boolean bl3 = false;
                $this$sendPacket_u24lambda_u241.addListener(future);
            }
            $this$sendPacket_u24lambda_u241.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
    }

    public final void addHandle(@NotNull String name, @NotNull ChannelHandler handler) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.wrapped.pipeline().addLast(name, handler);
    }
}

