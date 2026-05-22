/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.network;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.network.DisconnectEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={NetHandlerPlayClient.class})
public abstract class MixinNetHandlerPlayClient {
    @Shadow
    @Final
    private NetworkManager field_147302_e;
    @Shadow
    private Minecraft field_147299_f;
    @Shadow
    private boolean field_147309_h;

    @Inject(method={"onDisconnect"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDisconnect(ITextComponent reason, CallbackInfo ci2) {
        if (this.field_147299_f.field_71441_e == null || this.field_147299_f.field_71439_g == null) {
            return;
        }
        try {
            DisconnectEvent event = new DisconnectEvent(reason);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Redirect(method={"handleEntityVelocity"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;setVelocity(DDD)V"))
    public void handleEntityVelocity$callEvent(Entity entity, double x2, double y2, double z2) {
        if (entity != null) {
            if (entity == this.field_147299_f.field_71439_g) {
                PlayerSPVelocityEvent event = new PlayerSPVelocityEvent(this.field_147299_f.field_71439_g, x2, y2, z2);
                DarkMeow.eventManager.callEvent(event);
                if (!event.isCancelled()) {
                    entity.func_70016_h(event.motionX, event.motionY, event.motionZ);
                }
                return;
            }
            entity.func_70016_h(x2, y2, z2);
        }
    }
}

