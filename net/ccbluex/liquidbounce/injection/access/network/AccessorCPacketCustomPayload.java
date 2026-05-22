/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketCustomPayload.class})
public interface AccessorCPacketCustomPayload {
    @Accessor(value="channel")
    public String getChannel();

    @Accessor(value="channel")
    public void setChannel(String var1);

    @Accessor(value="data")
    public PacketBuffer getData();

    @Accessor(value="data")
    public void setData(PacketBuffer var1);
}

