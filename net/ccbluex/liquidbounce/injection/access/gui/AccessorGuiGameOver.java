/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import net.minecraft.client.gui.GuiGameOver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiGameOver.class})
public interface AccessorGuiGameOver {
    @Accessor(value="enableButtonsTimer")
    public int getEnableButtonsTimer();
}

