/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.main.GameConfiguration
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.viamcp.injection.mixin.client;

import net.darkmeow.viamcp.ViaMCP;
import net.darkmeow.viamcp.fixes.AttackOrder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Shadow
    public RayTraceResult field_71476_x;
    @Shadow
    public EntityPlayerSP field_71439_g;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void startVia(GameConfiguration gc2, CallbackInfo ci2) {
        ViaMCP.initViaMCP();
    }

    @Redirect(method={"clickMouse"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;attackEntity(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)V", ordinal=0))
    private void clickMouse$INVOKE$fixSwingArmAttack(PlayerControllerMP instance, EntityPlayer playerIn, Entity targetEntity) {
        AttackOrder.sendFixedAttack((EntityPlayer)this.field_71439_g, this.field_71476_x.field_72308_g, EnumHand.MAIN_HAND);
    }

    @Redirect(method={"clickMouse"}, at=@At(value="INVOKE", target=" Lnet/minecraft/client/entity/EntityPlayerSP;swingArm(Lnet/minecraft/util/EnumHand;)V", ordinal=0))
    private void clickMouse$INVOKE$fixSwingArm(EntityPlayerSP instance, EnumHand hand) {
        AttackOrder.sendConditionalSwing(this.field_71476_x, EnumHand.MAIN_HAND);
    }
}

