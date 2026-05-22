/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.handshake.client.C00Handshake
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.handshake.client.C00Handshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={C00Handshake.class})
public interface AccessorC00Handshake {
    @Accessor(value="protocolVersion")
    public int func_149595_d();

    @Accessor(value="protocolVersion")
    public void setProtocolVersion(int var1);

    @Accessor(value="ip")
    public String getIp();

    @Accessor(value="ip")
    public void setIp(String var1);

    @Accessor(value="requestedState")
    public EnumConnectionState func_149594_c();

    @Accessor(value="requestedState")
    public void setRequestedState(EnumConnectionState var1);
}

