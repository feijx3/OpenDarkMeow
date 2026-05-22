/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.entity.collision_border_size;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.entity.EntityCollisionBorderSizeEvent;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Entity.class})
public abstract class MixinEntity {
    @Inject(method={"getCollisionBorderSize"}, at={@At(value="RETURN")}, cancellable=true)
    private void getCollisionBorderSize(CallbackInfoReturnable<Float> cir) {
        Entity entity = (Entity)this;
        try {
            EntityCollisionBorderSizeEvent event = new EntityCollisionBorderSizeEvent(entity, cir.getReturnValue().floatValue());
            DarkMeow.eventManager.callEvent(event);
            if (event.isChanged()) {
                cir.setReturnValue((Float)event.getReturnValue());
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call get collision border size event.", e2);
        }
    }
}

