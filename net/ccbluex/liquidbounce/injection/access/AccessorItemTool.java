/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemTool
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ItemTool.class})
public interface AccessorItemTool {
    @Accessor(value="efficiency")
    public float getEfficiency();

    @Accessor(value="attackDamage")
    public float getAttackDamage();

    @Accessor(value="attackSpeed")
    public float getAttackSpeed();

    @Accessor(value="toolMaterial")
    public Item.ToolMaterial getToolMaterial();
}

