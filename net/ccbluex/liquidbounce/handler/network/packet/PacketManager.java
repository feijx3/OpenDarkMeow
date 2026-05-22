/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.network.packet;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.handler.network.NetworkManager;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.darkmeow.darkmeow.utils.network.PacketUtils;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u0010J2\u0010\u0012\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u0010J0\u0010\u0013\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/handler/network/packet/PacketManager;", "", "manager", "Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "sentPackets", "", "Lnet/minecraft/network/Packet;", "sendPacket", "", "packet", "noEvent", "excludeEventCall", "", "Ljava/lang/Class;", "sendPacketToClient", "callPacketEvent", "side", "Lnet/darkmeow/darkmeow/utils/network/PacketSide;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketManager.kt\nnet/ccbluex/liquidbounce/handler/network/packet/PacketManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class PacketManager {
    @NotNull
    private final NetworkManager manager;
    @NotNull
    private final List<Packet<?>> sentPackets;

    public PacketManager(@NotNull NetworkManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.sentPackets = new ArrayList();
    }

    @NotNull
    public final NetworkManager getManager() {
        return this.manager;
    }

    public final boolean sendPacket(@NotNull Packet<?> packet, boolean noEvent, @Nullable List<? extends Class<?>> excludeEventCall) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(packet, "packet");
        NetHandlerPlayClient netHandlerPlayClient = this.manager.mc.func_147114_u();
        if (netHandlerPlayClient != null) {
            Packet<?> packet2;
            NetHandlerPlayClient connection = netHandlerPlayClient;
            boolean bl3 = false;
            Packet<?> it = packet2 = packet;
            boolean bl4 = false;
            this.sentPackets.add(packet);
            if (!noEvent && this.callPacketEvent(packet, PacketSide.CLIENT, excludeEventCall)) {
                return false;
            }
            it = packet2;
            boolean bl5 = false;
            connection.func_147297_a(packet);
            it = packet2;
            boolean bl6 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ boolean sendPacket$default(PacketManager packetManager, Packet packet, boolean bl2, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            list = null;
        }
        return packetManager.sendPacket(packet, bl2, list);
    }

    public final boolean sendPacketToClient(@NotNull Packet<?> packet, boolean noEvent, @Nullable List<? extends Class<?>> excludeEventCall) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (!noEvent && this.callPacketEvent(packet, PacketSide.SERVER, excludeEventCall)) {
            return false;
        }
        NetHandlerPlayClient netHandlerPlayClient = this.manager.mc.func_147114_u();
        if (netHandlerPlayClient != null) {
            Unit unit;
            NetHandlerPlayClient it = netHandlerPlayClient;
            boolean bl3 = false;
            Packet<?> packet2 = packet;
            if (packet2 != null) {
                INetHandler iNetHandler = it.func_147298_b().func_150729_e();
                Intrinsics.checkNotNull(iNetHandler, "null cannot be cast to non-null type net.minecraft.network.INetHandler");
                packet2.func_148833_a(iNetHandler);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Unit it2 = unit;
            boolean bl4 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ boolean sendPacketToClient$default(PacketManager packetManager, Packet packet, boolean bl2, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            list = null;
        }
        return packetManager.sendPacketToClient(packet, bl2, list);
    }

    public final boolean callPacketEvent(@NotNull Packet<?> packet, @NotNull PacketSide side, @Nullable List<? extends Class<?>> excludeEventCall) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter((Object)side, "side");
        if (this.sentPackets.contains(packet)) {
            this.sentPackets.remove(packet);
            return false;
        }
        PacketEvent event = new PacketEvent(PacketUtils.keepFMLProxyPacketAway(packet, side), side);
        DarkMeow.INSTANCE.getEventManager().callEvent(event, excludeEventCall);
        return event.isCancelled();
    }

    public static /* synthetic */ boolean callPacketEvent$default(PacketManager packetManager, Packet packet, PacketSide packetSide, List list, int n2, Object object) {
        if ((n2 & 4) != 0) {
            list = null;
        }
        return packetManager.callPacketEvent(packet, packetSide, list);
    }
}

