/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.blocking;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerSyncCurrentItemEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Disabler;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.category.NoSlowBlockingMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafe;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u00020\n*\u00020\u000fJ\n\u0010\u0015\u001a\u00020\b*\u00020\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/blocking/NoSlowBlockingModeGrimAC;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "releaseValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "changeHeldItemValue", "onEnable", "", "canEnable", "", "onSlowDown", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "shouldApply", "Lnet/minecraft/client/entity/EntityPlayerSP;", "prevBlocking", "getPrevBlocking", "()Z", "setPrevBlocking", "(Z)V", "sendBlockingPacket", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBlockingModeGrimAC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBlockingModeGrimAC.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/blocking/NoSlowBlockingModeGrimAC\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n25#2,2:112\n21#2,2:114\n21#2,2:116\n20#2,3:118\n20#2,3:121\n1#3:124\n*S KotlinDebug\n*F\n+ 1 NoSlowBlockingModeGrimAC.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/blocking/NoSlowBlockingModeGrimAC\n*L\n63#1:112,2\n77#1:114,2\n80#1:116,2\n89#1:118,3\n95#1:121,3\n*E\n"})
public final class NoSlowBlockingModeGrimAC
extends NoSlowSubMode {
    @JvmField
    @NotNull
    public final BoolValue releaseValue = new BoolValue("Release", true);
    @JvmField
    @NotNull
    public final BoolValue changeHeldItemValue = new BoolValue("ChangeHeldItem", false);
    private boolean prevBlocking;

    public NoSlowBlockingModeGrimAC() {
        super("GrimAC");
        ListenableOwner $receiver$iv;
        ListenableOwner $this$safeListener$iv;
        int priority$iv;
        ListenableOwner $this$safeListenerAlways$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        int n2 = 2000;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> NoSlowBlockingModeGrimAC._init_$lambda$1(this, arg_0, arg_1);
        boolean $i$f$safeListenerAlways = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListenerAlways$iv).add(new EventHookSafe<PlayerSPUpdateWalkingEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.PRE.class), $this$safeListenerAlways$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListenerAlways$iv = this;
        priority$iv = 2000;
        function$iv = (arg_0, arg_1) -> NoSlowBlockingModeGrimAC._init_$lambda$2(this, arg_0, arg_1);
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.POST.class), $this$safeListener$iv));
        this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListener$iv = this;
        priority$iv = 2000;
        function$iv = (arg_0, arg_1) -> NoSlowBlockingModeGrimAC._init_$lambda$5(this, arg_0, arg_1);
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), $this$safeListener$iv));
        this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListener$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowBlockingModeGrimAC._init_$lambda$7(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerUseEntityAttackEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowBlockingModeGrimAC._init_$lambda$9(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerSyncCurrentItemEvent.class), $receiver$iv));
    }

    @Override
    public void onEnable() {
        if (!this.canEnable()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayError("NoSlow\\Blocking\\GrimAC \u9700\u8981\u914d\u5408 Disabler\\GrimPost \u624d\u80fd\u4f7f\u7528 \u8bf7\u5148\u542f\u7528");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean canEnable() {
        Disabler disabler = DarkMeow.INSTANCE.getModuleManager().get(Disabler.class);
        if (disabler == null) return false;
        Disabler it = disabler;
        boolean bl2 = false;
        if (!it.getState()) return false;
        Value<?> value = it.getValue("GrimPost");
        if (value == null) return false;
        boolean bl3 = Intrinsics.areEqual(value.getValue(), true);
        if (!bl3) return false;
        return true;
    }

    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.canEnable()) {
            event.cancelEvent();
        }
    }

    public final boolean shouldApply(@NotNull EntityPlayerSP $this$shouldApply) {
        Intrinsics.checkNotNullParameter($this$shouldApply, "<this>");
        if (!this.canEnable()) {
            return false;
        }
        if (!NoSlowBlockingMode.INSTANCE.shouldApply($this$shouldApply)) {
            return false;
        }
        KeyBinding keyBinding = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)$this$shouldApply).field_71474_y.field_74313_G;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
        return ExtendKeyBinding.INSTANCE.getPressed(keyBinding);
    }

    public final boolean getPrevBlocking() {
        return this.prevBlocking;
    }

    public final void setPrevBlocking(boolean bl2) {
        this.prevBlocking = bl2;
    }

    public final void sendBlockingPacket(@NotNull NetHandlerPlayClient $this$sendBlockingPacket) {
        Intrinsics.checkNotNullParameter($this$sendBlockingPacket, "<this>");
        $this$sendBlockingPacket.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        $this$sendBlockingPacket.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
    }

    private static final Unit _init_$lambda$1(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this$safeListenerAlways, PlayerSPUpdateWalkingEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$safeListenerAlways, "$this$safeListenerAlways");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.prevBlocking && !event.isCancelled()) {
            this$0.prevBlocking = false;
            if (((Boolean)this$0.releaseValue.get()).booleanValue()) {
                $this$safeListenerAlways.getConnection().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
            }
            if (((Boolean)this$0.changeHeldItemValue.get()).booleanValue()) {
                $this$safeListenerAlways.getConnection().func_147297_a((Packet)new CPacketHeldItemChange(($this$safeListenerAlways.getPlayer().field_71071_by.field_70461_c + 1) % 8));
                $this$safeListenerAlways.getConnection().func_147297_a((Packet)new CPacketCustomPayload("L", new PacketBuffer(Unpooled.buffer())));
                $this$safeListenerAlways.getConnection().func_147297_a((Packet)new CPacketHeldItemChange($this$safeListenerAlways.getPlayer().field_71071_by.field_70461_c));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.POST event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.shouldApply($this$safeListener.getPlayer())) {
            this$0.sendBlockingPacket($this$safeListener.getConnection());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        block1: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            if (!(event.getPacket() instanceof CPacketPlayerTryUseItem)) break block1;
            EntityPlayerSP it = entityPlayerSP2 = $this$safeListener.getPlayer();
            boolean bl2 = false;
            Object object = entityPlayerSP = this$0.shouldApply(it) ? entityPlayerSP2 : null;
            if (entityPlayerSP != null) {
                it = entityPlayerSP2 = entityPlayerSP;
                boolean bl3 = false;
                this$0.prevBlocking = true;
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$7$lambda$6(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this_safeListener, Entity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() && this$0.shouldApply($this_safeListener.getPlayer())) {
            this$0.sendBlockingPacket($this_safeListener.getConnection());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this$safeListener, ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.postAction(arg_0 -> NoSlowBlockingModeGrimAC.lambda$7$lambda$6(this$0, $this$safeListener, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$9$lambda$8(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this_safeListener) {
        if (DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() && this$0.shouldApply($this_safeListener.getPlayer())) {
            this$0.sendBlockingPacket($this_safeListener.getConnection());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(NoSlowBlockingModeGrimAC this$0, SafeListenerBase $this$safeListener, ControllerSyncCurrentItemEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (NoSlowBlockingMode.INSTANCE.shouldApply($this$safeListener.getPlayer())) {
            event.postAction(() -> NoSlowBlockingModeGrimAC.lambda$9$lambda$8(this$0, $this$safeListener));
        } else {
            this$0.prevBlocking = false;
        }
        return Unit.INSTANCE;
    }
}

