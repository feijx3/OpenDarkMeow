/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$Profile
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={RenderPlayer.class})
public abstract class MixinRenderPlayer
extends RenderLivingBase<AbstractClientPlayer> {
    public MixinRenderPlayer(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    @Shadow
    protected abstract void func_177137_d(AbstractClientPlayer var1);

    @Inject(method={"doRender*"}, at={@At(value="FIELD", target="Lnet/minecraft/client/renderer/entity/RenderManager;renderViewEntity:Lnet/minecraft/entity/Entity;")})
    public void doRenderGetRenderViewEntity(AbstractClientPlayer entity, double x2, double y2, double z2, float entityYaw, float partialTicks, CallbackInfo ci2) {
        if (FreeCam.INSTANCE.getState() && MinecraftInstance.mc.getRenderViewEntity() != entity) {
            double renderY = y2;
            if (entity.func_70093_af()) {
                renderY = y2 - 0.125;
            }
            this.func_177137_d(entity);
            GlStateManager.func_187408_a((GlStateManager.Profile)GlStateManager.Profile.PLAYER_SKIN);
            super.func_76986_a((EntityLivingBase)entity, x2, renderY, z2, entityYaw, partialTicks);
            GlStateManager.func_187440_b((GlStateManager.Profile)GlStateManager.Profile.PLAYER_SKIN);
        }
    }
}

