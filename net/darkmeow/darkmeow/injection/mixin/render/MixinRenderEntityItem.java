/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderEntityItem
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityItemEvent;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={RenderEntityItem.class})
public abstract class MixinRenderEntityItem {
    @Inject(method={"doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void doRender$callEvent$PRE(EntityItem entity, double x2, double y2, double z2, float entityYaw, float partialTicks, CallbackInfo ci2) {
        RenderEntityItemEvent.PRE event = new RenderEntityItemEvent.PRE(entity, x2, y2, z2, entityYaw, partialTicks);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }

    @Inject(method={"doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V"}, at={@At(value="TAIL")})
    private void doRender$callEvent$RETURN(EntityItem entity, double x2, double y2, double z2, float entityYaw, float partialTicks, CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new RenderEntityItemEvent.POST(entity, x2, y2, z2, entityYaw, partialTicks));
    }
}

