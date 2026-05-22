/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.projectile.EntityTippedArrow
 *  net.minecraft.potion.PotionType
 */
package net.ccbluex.liquidbounce.injection.access.entity;

import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.potion.PotionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityTippedArrow.class})
public interface AccessorEntityTippedArrow {
    @Accessor(value="potion")
    public PotionType getPotion();
}

