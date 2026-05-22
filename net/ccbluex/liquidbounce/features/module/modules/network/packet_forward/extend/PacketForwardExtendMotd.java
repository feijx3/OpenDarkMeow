/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.SimpleChannelInboundHandler
 *  io.netty.util.concurrent.GenericFutureListener
 *  kotlin.jvm.JvmField
 *  net.minecraft.network.Packet
 *  net.minecraft.network.ServerStatusResponse
 *  net.minecraft.network.ServerStatusResponse$Players
 *  net.minecraft.network.ServerStatusResponse$Version
 *  net.minecraft.network.status.client.CPacketPing
 *  net.minecraft.network.status.client.CPacketServerQuery
 *  net.minecraft.network.status.server.SPacketPong
 *  net.minecraft.network.status.server.SPacketServerInfo
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.extend;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.GenericFutureListener;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardExtend;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.network.Packet;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.network.status.client.CPacketServerQuery;
import net.minecraft.network.status.server.SPacketPong;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/PacketForwardExtendMotd;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "<init>", "()V", "messageValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "onRemoteConnect", "", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "Handler", "DarkMeow"})
public final class PacketForwardExtendMotd
extends PacketForwardExtend {
    @JvmField
    @NotNull
    public final TextValue messageValue = new TextValue("Message", "A Minecraft Server.");

    public PacketForwardExtendMotd() {
        super("Motd", false, false, 4, null);
    }

    @Override
    public void onRemoteConnect(@NotNull PacketForwardChannel client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.addHandle("handle_motd", (ChannelHandler)new Handler(this, client));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/PacketForwardExtendMotd$Handler;", "Lio/netty/channel/SimpleChannelInboundHandler;", "Lnet/minecraft/network/Packet;", "base", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/PacketForwardExtendMotd;", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/PacketForwardExtendMotd;Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;)V", "getBase", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/PacketForwardExtendMotd;", "getClient", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "channelRead0", "", "ctx", "Lio/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
    public static final class Handler
    extends SimpleChannelInboundHandler<Packet<?>> {
        @NotNull
        private final PacketForwardExtendMotd base;
        @NotNull
        private final PacketForwardChannel client;

        public Handler(@NotNull PacketForwardExtendMotd base, @NotNull PacketForwardChannel client) {
            Intrinsics.checkNotNullParameter(base, "base");
            Intrinsics.checkNotNullParameter(client, "client");
            this.base = base;
            this.client = client;
        }

        @NotNull
        public final PacketForwardExtendMotd getBase() {
            return this.base;
        }

        @NotNull
        public final PacketForwardChannel getClient() {
            return this.client;
        }

        /*
         * WARNING - void declaration
         */
        protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull Packet<?> packet) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(packet, "packet");
            Packet<?> packet2 = packet;
            if (packet2 instanceof CPacketPing) {
                this.client.sendPacket((Packet)new SPacketPong(((CPacketPing)packet).func_149289_c()), new GenericFutureListener[0]);
            } else if (packet2 instanceof CPacketServerQuery) {
                void $this$channelRead0_u24lambda_u240;
                ServerStatusResponse serverStatusResponse;
                ServerStatusResponse serverStatusResponse2 = serverStatusResponse = new ServerStatusResponse();
                PacketForwardChannel packetForwardChannel = this.client;
                boolean bl2 = false;
                $this$channelRead0_u24lambda_u240.func_151315_a((ITextComponent)new TextComponentString((String)this.base.messageValue.get()));
                $this$channelRead0_u24lambda_u240.func_151319_a(new ServerStatusResponse.Players(999, this.base.getInstance().getClients().size()));
                $this$channelRead0_u24lambda_u240.func_151321_a(new ServerStatusResponse.Version("1.12.2", 340));
                $this$channelRead0_u24lambda_u240.func_151320_a("");
                ServerStatusResponse serverStatusResponse3 = serverStatusResponse;
                packetForwardChannel.sendPacket((Packet)new SPacketServerInfo(serverStatusResponse3), new GenericFutureListener[0]);
            }
            ctx.fireChannelRead(packet);
        }
    }
}

