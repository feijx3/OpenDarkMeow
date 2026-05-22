/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiEditSign
 *  net.minecraft.tileentity.TileEntitySign
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiEditSign.class})
public interface AccessorGuiEditSign {
    @Accessor(value="tileSign")
    public TileEntitySign getTileSign();

    @Accessor(value="editLine")
    public int getEditLine();
}

