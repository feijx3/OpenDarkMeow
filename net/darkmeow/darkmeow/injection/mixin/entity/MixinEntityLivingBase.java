/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.entity;

import java.util.Objects;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPMoveRelativeEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.LiquidWalk;
import net.ccbluex.liquidbounce.features.module.modules.render.AntiBlind;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityLivingBase.class})
public abstract class MixinEntityLivingBase
extends MixinEntity {
    @Shadow
    public int field_70737_aN;
    @Shadow
    protected boolean field_70703_bu;
    @Shadow
    private int field_70773_bE;
    @Unique
    public float darkMeow$handleJump$jumpUpwardsMotion;
    @Unique
    public float darkMeow$handleJump$movementYaw;
    @Unique
    public float darkMeow$moveRelative$movementYaw;

    @Shadow
    protected abstract void func_70664_aZ();

    @Shadow
    protected abstract float func_175134_bD();

    @Shadow
    public abstract float func_110143_aJ();

    @Shadow
    protected abstract void func_70629_bd();

    @Shadow
    public abstract ItemStack func_184614_ca();

    @Inject(method={"jump"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleJump$event$call(CallbackInfo ci2) {
        if (this == Minecraft.func_71410_x().field_71439_g) {
            JumpEvent event = new JumpEvent(this.func_175134_bD(), this.field_70177_z);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            } else {
                this.darkMeow$handleJump$jumpUpwardsMotion = event.getMotion();
                this.darkMeow$handleJump$movementYaw = event.getMovementYaw();
            }
        } else {
            this.darkMeow$handleJump$jumpUpwardsMotion = this.func_175134_bD();
            this.darkMeow$handleJump$movementYaw = this.field_70177_z;
        }
    }

    @Redirect(method={"jump"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityLivingBase;getJumpUpwardsMotion()F"))
    private float handleJump$event$jumpUpwardsMotion(EntityLivingBase instance) {
        return this.darkMeow$handleJump$jumpUpwardsMotion;
    }

    @Redirect(method={"jump"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/EntityLivingBase;rotationYaw:F"))
    private float handleJump$event$rotationYaw(EntityLivingBase instance) {
        return this.darkMeow$handleJump$movementYaw;
    }

    @Inject(method={"onLivingUpdate"}, at={@At(value="FIELD", target="Lnet/minecraft/entity/EntityLivingBase;isJumping:Z", ordinal=1)})
    private void onJumpSection(CallbackInfo callbackInfo) {
        LiquidWalk liquidWalk = DarkMeow.moduleManager.getModule(LiquidWalk.class);
        if (Objects.requireNonNull(liquidWalk).getState() && !this.field_70703_bu && !this.func_70093_af() && this.func_70090_H() && ((String)liquidWalk.getModeValue().get()).equalsIgnoreCase("Swim")) {
            this.func_70629_bd();
        }
    }

    @Inject(method={"isPotionActive(Lnet/minecraft/potion/Potion;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void isPotionActive(Potion p_isPotionActive_1_, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        AntiBlind antiBlind = DarkMeow.moduleManager.getModule(AntiBlind.class);
        if ((p_isPotionActive_1_ == MobEffects.field_76431_k || p_isPotionActive_1_ == MobEffects.field_76440_q) && Objects.requireNonNull(antiBlind).getState() && ((Boolean)antiBlind.getConfusionEffect().get()).booleanValue()) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"moveRelative"}, at={@At(value="HEAD")}, cancellable=true)
    private void moveRelative$event$call(float strafe, float up, float forward, float friction, CallbackInfo ci2) {
        if (this == Minecraft.func_71410_x().field_71439_g) {
            PlayerSPMoveRelativeEvent event = new PlayerSPMoveRelativeEvent((EntityPlayerSP)this, strafe, up, forward, friction, this.field_70177_z);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            } else {
                this.darkMeow$moveRelative$movementYaw = event.getMovementYaw();
            }
        } else {
            this.darkMeow$moveRelative$movementYaw = this.field_70177_z;
        }
    }

    @Redirect(method={"moveRelative"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/EntityLivingBase;rotationYaw:F"))
    private float moveRelative$event$rotationYaw(EntityLivingBase instance) {
        return this.darkMeow$moveRelative$movementYaw;
    }
}

