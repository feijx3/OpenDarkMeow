/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_19_4;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_21_5;

public class ChunkBiomesType1_21_5
extends ChunkBiomesType1_19_4 {
    public ChunkBiomesType1_21_5(int ySectionCount, int globalPaletteBiomeBits) {
        super(ySectionCount, new PaletteType1_21_5(PaletteType.BIOMES, globalPaletteBiomeBits));
    }
}

