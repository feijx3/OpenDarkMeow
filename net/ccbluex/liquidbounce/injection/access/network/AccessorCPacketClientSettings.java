/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketClientSettings
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketClientSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketClientSettings.class})
public interface AccessorCPacketClientSettings {
    @Accessor(value="view")
    public int getView();

    @Accessor(value="view")
    public void setView(int var1);

    @Accessor(value="lang")
    public String func_149524_c();

    @Accessor(value="lang")
    public void setLang(String var1);
}

