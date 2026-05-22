/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.RenderEntityEvent;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Render.class})
public abstract class MixinRender {
    @Shadow
    protected abstract <T extends Entity> boolean func_180548_c(T var1);

    @Inject(method={"doRender"}, at={@At(value="HEAD")})
    private void doRender(Entity entity, double x2, double y2, double z2, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
        DarkMeow.eventManager.callEvent(new RenderEntityEvent(entity, x2, y2, z2, entityYaw, partialTicks));
    }
}

