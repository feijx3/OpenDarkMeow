/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketCloseWindow
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketCloseWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketCloseWindow.class})
public interface AccessorCPacketCloseWindow {
    @Accessor(value="windowId")
    public int getWindowId();

    @Accessor(value="windowId")
    public void setWindowId(int var1);
}

