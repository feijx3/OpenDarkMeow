/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketChatMessage.class})
public interface AccessorCPacketChatMessage {
    @Accessor(value="message")
    public String func_149439_c();

    @Accessor(value="message")
    public void setMessage(String var1);
}

