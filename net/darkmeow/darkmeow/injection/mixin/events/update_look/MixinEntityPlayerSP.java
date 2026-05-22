/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.update_look;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.PlayerSPLookEvent;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinAbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP
extends MixinAbstractClientPlayer {
    @Inject(method={"getLook"}, at={@At(value="HEAD")}, cancellable=true)
    private void getLook$callEvent$callEvent(float partialTicks, CallbackInfoReturnable<Vec3d> cir) {
        PlayerSPLookEvent event = new PlayerSPLookEvent(new Rotation(this.field_70177_z, this.field_70125_A), partialTicks);
        DarkMeow.eventManager.callEvent(event);
        if (event.isChanged()) {
            cir.setReturnValue(this.func_174806_f(((Rotation)event.getReturnValue()).pitch, ((Rotation)event.getReturnValue()).yaw));
            cir.cancel();
        }
    }
}

