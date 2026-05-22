/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.darkmeow.viamcp.fixes.AttackOrder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Trigger;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "cpsValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "noGUIAttackValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "attackDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class Trigger
extends Module {
    @JvmField
    @NotNull
    public final IntegerRangeValue cpsValue = new IntegerRangeValue("CPS", new IntRange(5, 8), new IntRange(1, 20));
    @JvmField
    @NotNull
    public final BoolValue noGUIAttackValue = new BoolValue("NoGUIAttack", false);
    @JvmField
    @NotNull
    public final MSDelay attackDelay = new MSDelay();

    public Trigger() {
        super("Trigger", ModuleCategory.COMBAT, null, null, 12, null);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
        if (rayTraceResult == null || (rayTraceResult = rayTraceResult.field_72308_g) == null) {
            return;
        }
        RayTraceResult entity = rayTraceResult;
        if (((Boolean)this.noGUIAttackValue.get()).booleanValue() && MinecraftInstance.mc.getCurrentScreen() != null) {
            return;
        }
        if (TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), (Entity)entity, true, false, 4, null) && MSDelay.hasPassed$default(this.attackDelay, 0L, 1, null)) {
            AttackOrder.sendFixedAttack((EntityPlayer)event.getPlayer(), (Entity)entity, EnumHand.MAIN_HAND);
            this.attackDelay.reset(TimeUtils.randomClickDelay(((Number)((ClosedRange)this.cpsValue.getValue()).getStart()).intValue(), ((Number)((ClosedRange)this.cpsValue.getValue()).getEndInclusive()).intValue()));
        }
    }
}

