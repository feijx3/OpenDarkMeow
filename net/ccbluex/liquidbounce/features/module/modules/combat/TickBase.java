/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="TickBase", description="FDP TickBase", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/TickBase;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "ticks", "", "ticksAmount", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "BoostAmount", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "ChargeAmount", "onControllerUseEntityAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onEnable", "onDisable", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class TickBase
extends Module {
    private int ticks;
    @NotNull
    private final IntegerValue ticksAmount = new IntegerValue("BoostTicks", 10, 3, 20);
    @NotNull
    private final FloatValue BoostAmount = new FloatValue("BoostTimer", 10.0f, 1.0f, 50.0f);
    @NotNull
    private final FloatValue ChargeAmount = new FloatValue("ChargeTimer", 0.11f, 0.05f, 1.0f);

    public TickBase() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTarget() instanceof EntityLivingBase && this.ticks == 0) {
            this.ticks = ((Number)this.ticksAmount.get()).intValue();
        }
    }

    @Override
    public void onEnable() {
        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
    }

    @Override
    public void onDisable() {
        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.ticks == ((Number)this.ticksAmount.get()).intValue()) {
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), ((Number)this.ChargeAmount.get()).floatValue());
            int n2 = this.ticks;
            this.ticks = n2 + -1;
        } else if (this.ticks > 1) {
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), ((Number)this.BoostAmount.get()).floatValue());
            int n3 = this.ticks;
            this.ticks = n3 + -1;
        } else if (this.ticks == 1) {
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
            int n4 = this.ticks;
            this.ticks = n4 + -1;
        }
    }
}

