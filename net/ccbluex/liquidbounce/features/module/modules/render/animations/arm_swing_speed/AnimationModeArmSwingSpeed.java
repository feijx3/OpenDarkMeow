/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.arm_swing_speed;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.math.RenderUpdateArmSwingAnimationSpeedEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.AnimationMode;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/arm_swing_speed/AnimationModeArmSwingSpeed;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/AnimationMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onRender2DItemInFirstPersonSwingProgress", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/math/RenderUpdateArmSwingAnimationSpeedEvent;", "DarkMeow"})
public final class AnimationModeArmSwingSpeed
extends AnimationMode {
    @JvmField
    @NotNull
    public final IntegerValue speedValue = new IntegerValue("Speed", 4, new IntRange(1, 10));

    public AnimationModeArmSwingSpeed() {
        super("ArmSwingSpeed", true);
    }

    @EventTarget
    public final void onRender2DItemInFirstPersonSwingProgress(@NotNull RenderUpdateArmSwingAnimationSpeedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.setReturnValue(((Number)event.getReturnValue()).intValue() * ((Number)this.speedValue.get()).intValue());
    }
}

