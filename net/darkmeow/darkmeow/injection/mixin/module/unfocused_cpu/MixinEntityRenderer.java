/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 */
package net.darkmeow.darkmeow.injection.mixin.module.unfocused_cpu;

import net.ccbluex.liquidbounce.features.module.modules.misc.UnfocusedCPU;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderer.class})
public class MixinEntityRenderer {
    @Inject(method={"updateCameraAndRender"}, at={@At(value="HEAD")}, cancellable=true)
    public void updateCameraAndRender$cancel(float partialTicks, long nanoTime, CallbackInfo ci2) {
        if (UnfocusedCPU.INSTANCE.getState() && UnfocusedCPU.status == UnfocusedCPU.Status.UN_VISIBLE && ((Boolean)UnfocusedCPU.unVisibleStopRenderRender.get()).booleanValue()) {
            ci2.cancel();
        }
    }
}

