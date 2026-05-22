/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SideOnly(value=Side.CLIENT)
@Mixin(targets={"net.minecraft.client.renderer.EntityRenderer$1"}, remap=false)
public abstract class MixinEntityRenderer$1 {
    @Redirect(method={"apply(Lnet/minecraft/entity/Entity;)Z"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;canBeCollidedWith()Z"))
    private boolean apply$ignoreFakeEntity(Entity instance) {
        return !(instance instanceof IFakeEntity) && instance.func_70067_L();
    }
}

