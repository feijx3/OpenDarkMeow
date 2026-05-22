/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.render.RenderCameraEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.CameraTweaksMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0014H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/impl/CameraTweaksModeMotion;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/CameraTweaksMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "onlyYValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "prevRenderX", "", "prevRenderY", "prevRenderZ", "isReload", "", "onReload", "", "onMovementInputPre", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onRenderCamera", "Lnet/ccbluex/liquidbounce/event/events/render/RenderCameraEvent;", "DarkMeow"})
public final class CameraTweaksModeMotion
extends CameraTweaksMode {
    @JvmField
    @NotNull
    public final FloatValue speedValue = new FloatValue("Speed", 0.1f, (ClosedRange<Float>)RangesKt.rangeTo(0.01f, 0.5f));
    @JvmField
    @NotNull
    public final BoolValue onlyYValue = new BoolValue("OnlyY", false);
    @JvmField
    public double prevRenderX;
    @JvmField
    public double prevRenderY;
    @JvmField
    public double prevRenderZ;
    @JvmField
    public boolean isReload = true;

    public CameraTweaksModeMotion() {
        super("Motion", true);
    }

    @Override
    public void onReload() {
        this.isReload = true;
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (MinecraftInstance.mc.getGameSettings().field_74320_O == 0) {
            this.onReload();
        }
    }

    @EventTarget(priority=97)
    public final void onRenderCamera(@NotNull RenderCameraEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity currentEntity = entity;
        double partialX = currentEntity.field_70169_q + (currentEntity.field_70165_t - currentEntity.field_70169_q) * (double)event.getPartialTick();
        double partialY = currentEntity.field_70167_r + (currentEntity.field_70163_u - currentEntity.field_70167_r) * (double)event.getPartialTick() + (double)currentEntity.func_70047_e();
        double partialZ = currentEntity.field_70166_s + (currentEntity.field_70161_v - currentEntity.field_70166_s) * (double)event.getPartialTick();
        if (this.isReload) {
            this.prevRenderX = partialX;
            this.prevRenderY = partialY;
            this.prevRenderZ = partialZ;
            this.isReload = false;
        } else {
            this.prevRenderX += (partialX - this.prevRenderX) * ((Number)this.speedValue.get()).doubleValue();
            this.prevRenderY += (partialY - this.prevRenderY) * ((Number)this.speedValue.get()).doubleValue();
            this.prevRenderZ += (partialZ - this.prevRenderZ) * ((Number)this.speedValue.get()).doubleValue();
        }
        GlStateManager.func_179137_b((double)((Boolean)this.onlyYValue.get() != false ? 0.0 : this.prevRenderX - partialX), (double)(partialY - this.prevRenderY), (double)((Boolean)this.onlyYValue.get() != false ? 0.0 : this.prevRenderZ - partialZ));
    }
}

