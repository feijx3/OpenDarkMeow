/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 */
package net.darkmeow.darkmeow.injection.mixin.module.no_jump_delay;

import net.ccbluex.liquidbounce.features.module.modules.movement.NoJumpDelay;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={EntityLivingBase.class})
public class MixinEntityLivingBase {
    @Shadow
    private int field_70773_bE;

    @Redirect(method={"onLivingUpdate"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/EntityLivingBase;jumpTicks:I", ordinal=3))
    public int onLivingUpdate$redirectJumpTicks(EntityLivingBase instance) {
        return NoJumpDelay.INSTANCE.getState() ? (this instanceof EntityPlayerSP ? 0 : this.field_70773_bE) : this.field_70773_bE;
    }
}

