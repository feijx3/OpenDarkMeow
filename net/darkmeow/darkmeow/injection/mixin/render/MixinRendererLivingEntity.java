/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.TrueSight;
import net.darkmeow.darkmeow.injection.mixin.render.MixinRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={RenderLivingBase.class})
public abstract class MixinRendererLivingEntity
extends MixinRender {
    @Unique
    public String darkMeow$renderEntityNameEvent$renderName = "";
    @Shadow
    protected ModelBase field_77045_g;

    @Inject(method={"renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderName$callEvent(EntityLivingBase entity, double x2, double y2, double z2, CallbackInfo ci2) {
        RenderEntityNameEvent event = new RenderEntityNameEvent(entity, x2, y2, z2);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        } else {
            this.darkMeow$renderEntityNameEvent$renderName = event.getDisplayName();
        }
    }

    @Redirect(method={"renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/text/ITextComponent;getFormattedText()Ljava/lang/String;"))
    private String renderName$callEvent(ITextComponent instance) {
        return this.darkMeow$renderEntityNameEvent$renderName;
    }

    @Overwrite
    protected <T extends EntityLivingBase> void func_77036_a(T entitylivingbaseIn, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float scaleFactor) {
        boolean semiVisible;
        boolean visible = !entitylivingbaseIn.func_82150_aj();
        TrueSight trueSight = DarkMeow.moduleManager.getModule(TrueSight.class);
        boolean bl2 = semiVisible = !visible && (!entitylivingbaseIn.func_98034_c((EntityPlayer)Minecraft.func_71410_x().field_71439_g) || trueSight.getState() && (Boolean)trueSight.getEntitiesValue().get() != false);
        if (visible || semiVisible) {
            if (!this.func_180548_c(entitylivingbaseIn)) {
                return;
            }
            if (semiVisible) {
                GlStateManager.func_179094_E();
                GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.15f);
                GlStateManager.func_179132_a((boolean)false);
                GL11.glEnable((int)3042);
                GlStateManager.func_179112_b((int)770, (int)771);
                GlStateManager.func_179092_a((int)516, (float)0.003921569f);
            }
            this.field_77045_g.func_78088_a(entitylivingbaseIn, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, scaleFactor);
            if (semiVisible) {
                GlStateManager.func_179084_k();
                GlStateManager.func_179092_a((int)516, (float)0.1f);
                GlStateManager.func_179121_F();
                GlStateManager.func_179132_a((boolean)true);
            }
        }
    }
}

