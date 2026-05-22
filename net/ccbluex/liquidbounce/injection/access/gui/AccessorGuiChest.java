/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.inventory.IInventory
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiChest.class})
public interface AccessorGuiChest {
    @Accessor(value="lowerChestInventory")
    public IInventory getLowerChestInventory();
}

