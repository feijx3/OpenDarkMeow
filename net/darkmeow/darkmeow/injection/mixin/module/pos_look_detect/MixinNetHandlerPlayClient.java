/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 */
package net.darkmeow.darkmeow.injection.mixin.module.pos_look_detect;

import net.ccbluex.liquidbounce.features.module.modules.misc.PosLookDetect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetHandlerPlayClient.class})
public class MixinNetHandlerPlayClient {
    @Shadow
    private Minecraft field_147299_f;

    @Inject(method={"handlePlayerPosLook"}, at={@At(value="HEAD")})
    public void handlePlayerPosLook$callModule(SPacketPlayerPosLook packet, CallbackInfo ci2) {
        EntityPlayerSP player = this.field_147299_f.field_71439_g;
        if (player != null && PosLookDetect.INSTANCE.getState()) {
            PosLookDetect.onPosLook(player, packet);
        }
    }
}

