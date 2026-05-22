/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={ModelBiped.class})
public class MixinModelBiped {
    @Shadow
    public ModelRenderer field_78116_c;

    @Inject(method={"setRotationAngles"}, at={@At(value="FIELD", target="Lnet/minecraft/client/model/ModelBiped;swingProgress:F")})
    private void revertSwordAnimation(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn, CallbackInfo ci2) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            Rotation sr = DarkMeow.rotationManager.serverRotation;
            if (sr != null && !DarkMeow.rotationManager.pauseRotationVisualFix && entityIn instanceof EntityPlayer && entityIn.equals((Object)Minecraft.func_71410_x().field_71439_g)) {
                this.field_78116_c.field_78795_f = sr.pitch / 57.295776f;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

