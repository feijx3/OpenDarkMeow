/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.SimpleChannelInboundHandler
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.Packet
 *  net.minecraft.network.handshake.client.C00Handshake
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketForward;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/handle/PacketForwardHandleHandShake;", "Lio/netty/channel/SimpleChannelInboundHandler;", "Lnet/minecraft/network/Packet;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "getClient", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "channelActive", "", "ctx", "Lio/netty/channel/ChannelHandlerContext;", "channelRead0", "packet", "DarkMeow"})
public final class PacketForwardHandleHandShake
extends SimpleChannelInboundHandler<Packet<?>> {
    @NotNull
    private final PacketForward module;
    @NotNull
    private final PacketForwardChannel client;

    public PacketForwardHandleHandShake(@NotNull PacketForward module, @NotNull PacketForwardChannel client) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(client, "client");
        this.module = module;
        this.client = client;
    }

    @NotNull
    public final PacketForward getModule() {
        return this.module;
    }

    @NotNull
    public final PacketForwardChannel getClient() {
        return this.client;
    }

    public void channelActive(@NotNull ChannelHandlerContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.client.setConnectionState(EnumConnectionState.HANDSHAKING);
    }

    protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull Packet<?> packet) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet instanceof C00Handshake) {
            EnumConnectionState enumConnectionState = ((C00Handshake)packet).func_149594_c();
            Intrinsics.checkNotNullExpressionValue(enumConnectionState, "getRequestedState(...)");
            this.client.setConnectionState(enumConnectionState);
        }
        ctx.fireChannelRead(packet);
    }
}

