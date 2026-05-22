/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketPlayerAbilities
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.extend.forward;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketForward;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardExtend;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardUtils;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSyncPosition;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "<init>", "()V", "sideValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardExtendSyncPosition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardExtendSyncPosition.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSyncPosition\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,78:1\n20#2,3:79\n*S KotlinDebug\n*F\n+ 1 PacketForwardExtendSyncPosition.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSyncPosition\n*L\n22#1:79,3\n*E\n"})
public final class PacketForwardExtendSyncPosition
extends PacketForwardExtend {
    @JvmField
    @NotNull
    public final ListValue sideValue;

    /*
     * WARNING - void declaration
     */
    public PacketForwardExtendSyncPosition() {
        super("SyncPosition", false, true, 2, null);
        void $receiver$iv;
        Object object = new String[]{"Client", "Server"};
        this.sideValue = new ListValue("Side", (String[])object, "Client");
        object = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, PlayerSPUpdateWalkingEvent.POST, Unit> function$iv = (arg_0, arg_1) -> PacketForwardExtendSyncPosition._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.POST.class), (ListenableOwner)$receiver$iv));
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$1(PacketForwardExtendSyncPosition this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.POST event) {
        void $this$lambda_u241_u24lambda_u240;
        Object object;
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        PlayerCapabilities playerCapabilities = object = new PlayerCapabilities();
        PacketForward packetForward = this$0.getInstance();
        PacketForwardUtils packetForwardUtils = PacketForwardUtils.INSTANCE;
        boolean bl2 = false;
        $this$lambda_u241_u24lambda_u240.field_75102_a = false;
        $this$lambda_u241_u24lambda_u240.field_75100_b = true;
        $this$lambda_u241_u24lambda_u240.field_75101_c = false;
        $this$lambda_u241_u24lambda_u240.field_75099_e = false;
        $this$lambda_u241_u24lambda_u240.func_75092_a(0.0f);
        $this$lambda_u241_u24lambda_u240.func_82877_b(0.0f);
        Unit unit = Unit.INSTANCE;
        PlayerCapabilities playerCapabilities2 = object;
        packetForwardUtils.broadCastPacket(packetForward, (Packet)new SPacketPlayerAbilities(playerCapabilities2));
        object = (String)this$0.sideValue.get();
        double d2 = Intrinsics.areEqual(object, "Client") ? event.player.field_70165_t : (Intrinsics.areEqual(object, "Server") ? event.posX : 0.0);
        object = (String)this$0.sideValue.get();
        double d3 = Intrinsics.areEqual(object, "Client") ? event.player.field_70163_u : (Intrinsics.areEqual(object, "Server") ? event.posY : 0.0);
        object = (String)this$0.sideValue.get();
        double d4 = Intrinsics.areEqual(object, "Client") ? event.player.field_70161_v : (Intrinsics.areEqual(object, "Server") ? event.posZ : 0.0);
        object = (String)this$0.sideValue.get();
        float f2 = MathHelper.func_76142_g((float)(Intrinsics.areEqual(object, "Client") ? event.player.field_70177_z : (Intrinsics.areEqual(object, "Server") ? event.rotationYaw : 0.0f)));
        object = (String)this$0.sideValue.get();
        PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), (Packet)new SPacketPlayerPosLook(d2, d3, d4, f2, MathHelper.func_76142_g((float)(Intrinsics.areEqual(object, "Client") ? event.player.field_70125_A : (Intrinsics.areEqual(object, "Server") ? event.rotationPitch : 0.0f))), SetsKt.emptySet(), -1));
        return Unit.INSTANCE;
    }
}

