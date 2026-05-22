/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketKeepAlive
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.extend.forward;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardExtend;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketKeepAlive;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendModifyKeepAlive;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "<init>", "()V", "delay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardExtendModifyKeepAlive.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardExtendModifyKeepAlive.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendModifyKeepAlive\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,25:1\n20#2,3:26\n*S KotlinDebug\n*F\n+ 1 PacketForwardExtendModifyKeepAlive.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendModifyKeepAlive\n*L\n18#1:26,3\n*E\n"})
public final class PacketForwardExtendModifyKeepAlive
extends PacketForwardExtend {
    @NotNull
    private final MSDelay delay = new MSDelay();

    /*
     * WARNING - void declaration
     */
    public PacketForwardExtendModifyKeepAlive() {
        super("ModifyKeepAlive", false, true, 2, null);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, MovementInputEvent.PRE, Unit> function$iv = (arg_0, arg_1) -> PacketForwardExtendModifyKeepAlive._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), (ListenableOwner)$receiver$iv));
    }

    @NotNull
    public final MSDelay getDelay() {
        return this.delay;
    }

    private static final Unit _init_$lambda$0(PacketForwardExtendModifyKeepAlive this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (MSDelay.hasPassed$default(this$0.delay, 0L, 1, null)) {
            this$0.delay.reset(15000L);
            PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), (Packet)new SPacketKeepAlive(System.currentTimeMillis()));
        }
        return Unit.INSTANCE;
    }
}

