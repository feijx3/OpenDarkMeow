/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={GuiContainer.class})
public interface AccessorGuiContainer {
    @Invoker(value="keyTyped")
    public void darkMeow_keyTyped(char var1, int var2);
}

