/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.message.send_message;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.SendMessageEvent;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinAbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP
extends MixinAbstractClientPlayer {
    @Shadow
    @Final
    public NetHandlerPlayClient field_71174_a;

    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendChatMessage$callEvent(String message, CallbackInfo ci2) {
        try {
            SendMessageEvent event = new SendMessageEvent((EntityPlayerSP)this, message);
            DarkMeow.eventManager.callEvent(event);
            String newMessage = (String)event.getReturnValue();
            if (event.isChanged() || newMessage == null || newMessage.isEmpty()) {
                if (newMessage != null && !newMessage.isEmpty()) {
                    this.field_71174_a.func_147297_a((Packet)new CPacketChatMessage(newMessage));
                } else {
                    ci2.cancel();
                }
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call send message event.", e2);
        }
    }
}

