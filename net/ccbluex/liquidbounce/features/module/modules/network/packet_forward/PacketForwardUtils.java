/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.GenericFutureListener
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward;

import io.netty.util.concurrent.GenericFutureListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketForward;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bJ\u001e\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardUtils;", "", "<init>", "()V", "broadCastPacket", "", "Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "packet", "Lnet/minecraft/network/Packet;", "forEachClients", "Lkotlin/Function1;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardUtils.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,18:1\n1869#2,2:19\n1869#2,2:21\n*S KotlinDebug\n*F\n+ 1 PacketForwardUtils.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardUtils\n*L\n8#1:19,2\n14#1:21,2\n*E\n"})
public final class PacketForwardUtils {
    @NotNull
    public static final PacketForwardUtils INSTANCE = new PacketForwardUtils();

    private PacketForwardUtils() {
    }

    public final void broadCastPacket(@NotNull PacketForward $this$broadCastPacket, @NotNull Packet<?> packet) {
        Intrinsics.checkNotNullParameter($this$broadCastPacket, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        Iterable $this$forEach$iv = $this$broadCastPacket.getClients();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PacketForwardChannel client = (PacketForwardChannel)element$iv;
            boolean bl2 = false;
            client.sendPacket(packet, new GenericFutureListener[0]);
        }
    }

    public final void forEachClients(@NotNull PacketForward $this$forEachClients, @NotNull Function1<? super PacketForwardChannel, Unit> packet) {
        Intrinsics.checkNotNullParameter($this$forEachClients, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        Iterable $this$forEach$iv = $this$forEachClients.getClients();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PacketForwardChannel client = (PacketForwardChannel)element$iv;
            boolean bl2 = false;
            packet.invoke(client);
        }
    }
}

