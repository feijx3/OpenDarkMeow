/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.entity.RenderEntityItem
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.item.ItemStack
 */
package net.darkmeow.darkmeow.injection.mixin.module.item_physics;

import net.ccbluex.liquidbounce.features.module.modules.render.ItemPhysics;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={RenderEntityItem.class})
public abstract class MixinRenderEntityItem {
    @Shadow
    protected abstract int func_177078_a(ItemStack var1);

    @Inject(method={"transformModelCount"}, at={@At(value="HEAD")}, cancellable=true)
    private void transformModelCount$callEvent(EntityItem entity, double x2, double y2, double z2, float partialTicks, IBakedModel model, CallbackInfoReturnable<Integer> cir) {
        if (ItemPhysics.INSTANCE.getState()) {
            ItemPhysics.transform(entity, x2, y2, z2, partialTicks, model);
            cir.setReturnValue(this.func_177078_a(entity.func_92059_d()));
            cir.cancel();
        }
    }
}

