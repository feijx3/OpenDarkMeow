/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_21_5;

public class ChunkSectionType1_21_5
extends ChunkSectionType1_18 {
    public ChunkSectionType1_21_5(int globalPaletteBlockBits, int globalPaletteBiomeBits) {
        super(new PaletteType1_21_5(PaletteType.BLOCKS, globalPaletteBlockBits), new PaletteType1_21_5(PaletteType.BIOMES, globalPaletteBiomeBits));
    }
}

