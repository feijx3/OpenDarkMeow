/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.BitArray
 *  net.minecraft.world.chunk.BlockStateContainer
 *  net.minecraft.world.chunk.IBlockStatePalette
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.util.BitArray;
import net.minecraft.world.chunk.BlockStateContainer;
import net.minecraft.world.chunk.IBlockStatePalette;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BlockStateContainer.class})
public interface AccessorBlockStateContainer {
    @Accessor(value="storage")
    public BitArray trollGetStorage();

    @Accessor(value="palette")
    public IBlockStatePalette trollGetPalette();
}

