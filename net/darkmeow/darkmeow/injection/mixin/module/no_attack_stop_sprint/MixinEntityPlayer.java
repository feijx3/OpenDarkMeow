/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package net.darkmeow.darkmeow.injection.mixin.module.no_attack_stop_sprint;

import net.ccbluex.liquidbounce.features.module.modules.movement.NoAttackStopSprint;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityPlayer.class})
public class MixinEntityPlayer {
    @Inject(method={"attackTargetEntityWithCurrentItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/player/EntityPlayer;setSprinting(Z)V")}, cancellable=true)
    public void attackTargetEntityWithCurrentItem$cancelStopSprint(Entity targetEntity, CallbackInfo ci2) {
        if (NoAttackStopSprint.INSTANCE.getState() && this instanceof EntityPlayerSP) {
            ci2.cancel();
        }
    }
}

