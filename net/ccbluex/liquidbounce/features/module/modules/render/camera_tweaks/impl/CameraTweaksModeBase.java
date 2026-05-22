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
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.RenderCameraEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.CameraTweaksMode;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/impl/CameraTweaksModeBase;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/CameraTweaksMode;", "<init>", "()V", "distanceValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "noClipValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onRenderCamera", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/RenderCameraEvent;", "DarkMeow"})
public final class CameraTweaksModeBase
extends CameraTweaksMode {
    @JvmField
    @NotNull
    public final FloatValue distanceValue = new FloatValue("Distance", 4.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 32.0f));
    @JvmField
    @NotNull
    public final BoolValue noClipValue = new BoolValue("NoClip", true);

    public CameraTweaksModeBase() {
        super("Base", true);
    }

    @EventTarget(priority=100)
    public final void onRenderCamera(@NotNull RenderCameraEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.setDistance(((Number)this.distanceValue.get()).floatValue());
        event.setNoClip((Boolean)this.noClipValue.get());
    }
}

