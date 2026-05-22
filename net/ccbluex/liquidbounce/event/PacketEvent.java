/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/PacketEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "packet", "Lnet/minecraft/network/Packet;", "side", "Lnet/darkmeow/darkmeow/utils/network/PacketSide;", "<init>", "(Lnet/minecraft/network/Packet;Lnet/darkmeow/darkmeow/utils/network/PacketSide;)V", "getPacket", "()Lnet/minecraft/network/Packet;", "getSide", "()Lnet/darkmeow/darkmeow/utils/network/PacketSide;", "DarkMeow"})
public final class PacketEvent
extends CancellableEvent {
    @NotNull
    private final Packet<?> packet;
    @NotNull
    private final PacketSide side;

    public PacketEvent(@NotNull Packet<?> packet, @NotNull PacketSide side) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter((Object)side, "side");
        this.packet = packet;
        this.side = side;
    }

    @NotNull
    public final Packet<?> getPacket() {
        return this.packet;
    }

    @NotNull
    public final PacketSide getSide() {
        return this.side;
    }
}

