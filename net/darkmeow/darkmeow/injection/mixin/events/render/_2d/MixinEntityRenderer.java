/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 */
package net.darkmeow.darkmeow.injection.mixin.events.render._2d;

import net.ccbluex.liquidbounce.DarkMeow;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderer.class})
public abstract class MixinEntityRenderer {
    @Inject(method={"updateCameraAndRender"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiIngame;renderGameOverlay(F)V", shift=At.Shift.AFTER)})
    private void updateCameraAndRender$callEvent(float partialTicks, long nanoTime, CallbackInfo ci2) {
        DarkMeow.visualManager.callRender2DEvent(partialTicks);
    }
}

