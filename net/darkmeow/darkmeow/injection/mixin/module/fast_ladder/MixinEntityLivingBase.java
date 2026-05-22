/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 */
package net.darkmeow.darkmeow.injection.mixin.module.fast_ladder;

import net.ccbluex.liquidbounce.features.module.modules.movement.FastLadder;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={EntityLivingBase.class})
public class MixinEntityLivingBase {
    @Unique
    boolean darkMeow$fastFalling = false;

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityLivingBase;isOnLadder()Z", ordinal=0))
    public boolean travel$redirectSpeedLimit(EntityLivingBase entity) {
        boolean state = entity.func_70617_f_();
        if (state && FastLadder.INSTANCE.handleEvents() && entity instanceof EntityPlayerSP) {
            EntityPlayerSP player = (EntityPlayerSP)entity;
            this.darkMeow$fastFalling = false;
            if (FastLadder.handleFastFall(player)) {
                this.darkMeow$fastFalling = true;
                return false;
            }
        }
        return state;
    }

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityLivingBase;isOnLadder()Z", ordinal=1))
    public boolean travel$redirectClimb(EntityLivingBase entity) {
        boolean state = entity.func_70617_f_();
        if (state && FastLadder.INSTANCE.handleEvents() && entity instanceof EntityPlayerSP && !this.darkMeow$fastFalling) {
            EntityPlayerSP player = (EntityPlayerSP)entity;
            FastLadder.handleFastClimb(player);
        }
        return !this.darkMeow$fastFalling && state;
    }
}

