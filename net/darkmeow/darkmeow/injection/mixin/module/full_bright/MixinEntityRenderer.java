/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.texture.DynamicTexture
 */
package net.darkmeow.darkmeow.injection.mixin.module.full_bright;

import net.ccbluex.liquidbounce.features.module.modules.render.FullBright;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderer.class})
public class MixinEntityRenderer {
    @Shadow
    @Final
    private Minecraft field_78531_r;
    @Shadow
    @Final
    private int[] field_78504_Q;
    @Shadow
    @Final
    private DynamicTexture field_78513_d;
    @Shadow
    private boolean field_78536_aa;

    @Inject(method={"updateLightmap"}, at={@At(value="HEAD")}, cancellable=true)
    public void updateLightMap(float partialTicks, CallbackInfo ci2) {
        if (FullBright.INSTANCE.getState()) {
            ci2.cancel();
            if (this.field_78536_aa) {
                this.field_78531_r.field_71424_I.func_76320_a("lightTex");
                for (int i2 = 0; i2 < 256; ++i2) {
                    this.field_78504_Q[i2] = -1;
                }
                this.field_78513_d.func_110564_a();
                this.field_78536_aa = false;
                this.field_78531_r.field_71424_I.func_76319_b();
            }
        }
    }
}

