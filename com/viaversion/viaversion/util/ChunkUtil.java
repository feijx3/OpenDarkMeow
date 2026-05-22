/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import java.util.ArrayList;
import java.util.Arrays;

public class ChunkUtil {
    public static Chunk createEmptyChunk(int chunkX, int chunkZ) {
        return ChunkUtil.createEmptyChunk(chunkX, chunkZ, 16, 65535);
    }

    public static Chunk createEmptyChunk(int chunkX, int chunkZ, int sectionCount) {
        int sectionBitmask = 0;
        for (int i2 = 0; i2 < sectionCount; ++i2) {
            sectionBitmask = sectionBitmask << 1 | 1;
        }
        return ChunkUtil.createEmptyChunk(chunkX, chunkZ, sectionCount, sectionBitmask);
    }

    public static Chunk createEmptyChunk(int chunkX, int chunkZ, int sectionCount, int bitmask) {
        ChunkSection[] airSections = new ChunkSection[sectionCount];
        for (int i2 = 0; i2 < airSections.length; ++i2) {
            airSections[i2] = new ChunkSectionImpl(true);
            airSections[i2].palette(PaletteType.BLOCKS).addId(0);
        }
        return new BaseChunk(chunkX, chunkZ, true, false, bitmask, airSections, new int[256], new ArrayList<CompoundTag>());
    }

    public static void setDummySkylight(Chunk chunk) {
        ChunkUtil.setDummySkylight(chunk, false);
    }

    public static void setDummySkylight(Chunk chunk, boolean fullbright) {
        for (ChunkSection section : chunk.getSections()) {
            if (section == null || !section.hasLight()) continue;
            byte[] skyLight = new byte[2048];
            if (fullbright) {
                Arrays.fill(skyLight, (byte)-1);
            }
            section.getLight().setSkyLight(skyLight);
        }
    }
}

