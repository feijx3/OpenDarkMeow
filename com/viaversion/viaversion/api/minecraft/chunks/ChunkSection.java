/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionLight;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ChunkSection {
    public static final int SIZE = 4096;
    public static final int BIOME_SIZE = 64;

    public static int index(int x2, int y2, int z2) {
        return y2 << 8 | z2 << 4 | x2;
    }

    public static int xFromIndex(int idx) {
        return idx & 0xF;
    }

    public static int yFromIndex(int idx) {
        return idx >> 8 & 0xF;
    }

    public static int zFromIndex(int idx) {
        return idx >> 4 & 0xF;
    }

    public int getNonAirBlocksCount();

    public void setNonAirBlocksCount(int var1);

    default public boolean hasLight() {
        return this.getLight() != null;
    }

    public @Nullable ChunkSectionLight getLight();

    public void setLight(@Nullable ChunkSectionLight var1);

    public @Nullable DataPalette palette(PaletteType var1);

    public void addPalette(PaletteType var1, DataPalette var2);

    public void removePalette(PaletteType var1);
}

