/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Timer", description="Changes the speed of the entire game.", category=ModuleCategory.WORLD)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/Timer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "onMoveValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class Timer
extends Module {
    @NotNull
    private final FloatValue speedValue = new FloatValue("Speed", 2.0f, 0.1f, 10.0f);
    @NotNull
    private final BoolValue onMoveValue = new BoolValue("OnMove", true);

    public Timer() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onDisable() {
        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) || !((Boolean)this.onMoveValue.get()).booleanValue()) {
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), ((Number)this.speedValue.get()).floatValue());
            return;
        }
        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
    }
}

