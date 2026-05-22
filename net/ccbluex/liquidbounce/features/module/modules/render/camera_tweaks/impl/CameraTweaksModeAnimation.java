/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.RenderCameraEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.CameraTweaksMode;
import net.ccbluex.liquidbounce.utils.render.EaseUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/impl/CameraTweaksModeAnimation;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/CameraTweaksMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "lastThirdPersonView", "", "lastMS", "", "progress", "", "onRenderCamera", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/RenderCameraEvent;", "DarkMeow"})
public final class CameraTweaksModeAnimation
extends CameraTweaksMode {
    @JvmField
    @NotNull
    public final IntegerValue speedValue = new IntegerValue("Speed", 500, new IntRange(100, 1000));
    private int lastThirdPersonView;
    private long lastMS;
    private double progress;

    public CameraTweaksModeAnimation() {
        super("Animation", true);
    }

    @EventTarget(priority=99)
    public final void onRenderCamera(@NotNull RenderCameraEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getThirdPersonView() != this.lastThirdPersonView) {
            this.lastThirdPersonView = event.getThirdPersonView();
            this.progress = 0.0;
            this.lastMS = System.currentTimeMillis();
        }
        this.progress = this.progress < 1.0 ? (double)(System.currentTimeMillis() - this.lastMS) / (double)((Number)this.speedValue.get()).intValue() : 1.0;
        event.setDistance(event.getDistance() * (float)EaseUtils.easeOutQuart(this.progress));
    }
}

