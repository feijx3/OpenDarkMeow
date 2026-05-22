/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteTypeBase;
import io.netty.buffer.ByteBuf;

public class ChunkSectionType1_18
extends Type<ChunkSection> {
    private final PaletteTypeBase blockPaletteType;
    private final PaletteTypeBase biomePaletteType;

    public ChunkSectionType1_18(int globalPaletteBlockBits, int globalPaletteBiomeBits) {
        super(ChunkSection.class);
        this.blockPaletteType = new PaletteType1_18(PaletteType.BLOCKS, globalPaletteBlockBits);
        this.biomePaletteType = new PaletteType1_18(PaletteType.BIOMES, globalPaletteBiomeBits);
    }

    protected ChunkSectionType1_18(PaletteTypeBase blockPaletteType, PaletteTypeBase biomePaletteType) {
        super(ChunkSection.class);
        this.blockPaletteType = blockPaletteType;
        this.biomePaletteType = biomePaletteType;
    }

    @Override
    public ChunkSection read(ByteBuf buffer) {
        ChunkSectionImpl chunkSection = new ChunkSectionImpl();
        chunkSection.setNonAirBlocksCount(buffer.readShort());
        chunkSection.addPalette(PaletteType.BLOCKS, (DataPalette)this.blockPaletteType.read(buffer));
        chunkSection.addPalette(PaletteType.BIOMES, (DataPalette)this.biomePaletteType.read(buffer));
        return chunkSection;
    }

    @Override
    public void write(ByteBuf buffer, ChunkSection section) {
        buffer.writeShort(section.getNonAirBlocksCount());
        this.blockPaletteType.write(buffer, section.palette(PaletteType.BLOCKS));
        this.biomePaletteType.write(buffer, section.palette(PaletteType.BIOMES));
    }

    public int serializedSize(Chunk chunk) {
        int length = 0;
        for (ChunkSection section : chunk.getSections()) {
            length += 2 + this.blockPaletteType.serializedSize(section.palette(PaletteType.BLOCKS)) + this.biomePaletteType.serializedSize(section.palette(PaletteType.BIOMES));
        }
        return length;
    }
}

