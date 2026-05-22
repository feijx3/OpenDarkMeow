/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.render.update_arm_swing_animation_speed;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.math.RenderUpdateArmSwingAnimationSpeedEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityLivingBase.class})
public abstract class MixinEntityLivingBase {
    @Inject(method={"getArmSwingAnimationEnd"}, at={@At(value="RETURN")}, cancellable=true)
    private void getArmSwingAnimationEnd$callEvent(CallbackInfoReturnable<Integer> cir) {
        RenderUpdateArmSwingAnimationSpeedEvent event = new RenderUpdateArmSwingAnimationSpeedEvent(cir.getReturnValue());
        DarkMeow.eventManager.callEvent(event);
        if (event.isChanged()) {
            cir.setReturnValue((Integer)event.getReturnValue());
            cir.cancel();
        }
    }
}

