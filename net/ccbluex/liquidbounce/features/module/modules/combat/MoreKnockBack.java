/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/MoreKnockBack;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "sprintPackets", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "hurtTime", "onlyMove", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "wasSprinting", "", "getWasSprinting", "()Z", "setWasSprinting", "(Z)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMoreKnockBack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoreKnockBack.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/MoreKnockBack\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,57:1\n20#2,3:58\n*S KotlinDebug\n*F\n+ 1 MoreKnockBack.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/MoreKnockBack\n*L\n31#1:58,3\n*E\n"})
public final class MoreKnockBack
extends Module {
    @JvmField
    @NotNull
    public final IntegerValue sprintPackets = new IntegerValue("SprintPackets", 1, 0, 10);
    @JvmField
    @NotNull
    public final IntegerValue hurtTime = new IntegerValue("HurtTime", 10, 0, 10);
    @JvmField
    @NotNull
    public final BoolValue onlyMove = new BoolValue("OnlyMove", true);
    private boolean wasSprinting;

    /*
     * WARNING - void declaration
     */
    public MoreKnockBack() {
        super("MoreKnockBack", ModuleCategory.COMBAT, null, null, 12, null);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, ControllerUseEntityAttackEvent, Unit> function$iv = (arg_0, arg_1) -> MoreKnockBack._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<ControllerUseEntityAttackEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerUseEntityAttackEvent.class), (ListenableOwner)$receiver$iv));
    }

    public final boolean getWasSprinting() {
        return this.wasSprinting;
    }

    public final void setWasSprinting(boolean bl2) {
        this.wasSprinting = bl2;
    }

    private static final Unit _init_$lambda$1(MoreKnockBack this$0, SafeListenerBase $this$safeListener, ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTarget() instanceof EntityLivingBase && ((EntityLivingBase)event.getTarget()).field_70737_aN <= ((Number)this$0.hurtTime.get()).intValue() || !DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() && !$this$safeListener.getPlayer().func_70617_f_() && (!((Boolean)this$0.onlyMove.get()).booleanValue() || MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null))) {
            if (ExtendEntityPlayerSP.INSTANCE.getServerSprintState($this$safeListener.getPlayer())) {
                this$0.wasSprinting = true;
                ExtendEntityPlayerSP.INSTANCE.setServerSprintState($this$safeListener.getPlayer(), false);
                $this$safeListener.getConnection().func_147297_a((Packet)new CPacketEntityAction((Entity)$this$safeListener.getPlayer(), CPacketEntityAction.Action.STOP_SPRINTING));
            }
            int n2 = ((Number)this$0.sprintPackets.get()).intValue();
            int n3 = 0;
            while (n3 < n2) {
                int it = n3++;
                boolean bl2 = false;
                ExtendEntityPlayerSP.INSTANCE.setServerSprintState($this$safeListener.getPlayer(), true);
                $this$safeListener.getConnection().func_147297_a((Packet)new CPacketEntityAction((Entity)$this$safeListener.getPlayer(), CPacketEntityAction.Action.START_SPRINTING));
                ExtendEntityPlayerSP.INSTANCE.setServerSprintState($this$safeListener.getPlayer(), false);
                $this$safeListener.getConnection().func_147297_a((Packet)new CPacketEntityAction((Entity)$this$safeListener.getPlayer(), CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (this$0.wasSprinting) {
                ExtendEntityPlayerSP.INSTANCE.setServerSprintState($this$safeListener.getPlayer(), true);
                $this$safeListener.getConnection().func_147297_a((Packet)new CPacketEntityAction((Entity)$this$safeListener.getPlayer(), CPacketEntityAction.Action.START_SPRINTING));
                this$0.wasSprinting = false;
            }
        }
        return Unit.INSTANCE;
    }
}

