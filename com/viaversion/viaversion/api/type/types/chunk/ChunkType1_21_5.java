/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_21_5;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_18;
import com.viaversion.viaversion.api.type.types.chunk.ChunkSectionType1_21_5;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;

public final class ChunkType1_21_5
extends Type<Chunk> {
    private final ChunkSectionType1_18 sectionType;
    private final int ySectionCount;

    public ChunkType1_21_5(int ySectionCount, int globalPaletteBlockBits, int globalPaletteBiomeBits) {
        super(Chunk.class);
        Preconditions.checkArgument((ySectionCount > 0 ? 1 : 0) != 0);
        this.sectionType = new ChunkSectionType1_21_5(globalPaletteBlockBits, globalPaletteBiomeBits);
        this.ySectionCount = ySectionCount;
    }

    @Override
    public Chunk read(ByteBuf buffer) {
        int chunkX = buffer.readInt();
        int chunkZ = buffer.readInt();
        Heightmap[] heightmaps = (Heightmap[])Types.HEIGHTMAP_ARRAY.read(buffer);
        ByteBuf sectionsBuf = buffer.readSlice(Types.VAR_INT.readPrimitive(buffer));
        ChunkSection[] sections = new ChunkSection[this.ySectionCount];
        for (int i2 = 0; i2 < this.ySectionCount; ++i2) {
            sections[i2] = this.sectionType.read(sectionsBuf);
        }
        int blockEntitiesLength = Types.VAR_INT.readPrimitive(buffer);
        ArrayList<BlockEntity> blockEntities = new ArrayList<BlockEntity>(blockEntitiesLength);
        for (int i3 = 0; i3 < blockEntitiesLength; ++i3) {
            blockEntities.add((BlockEntity)Types.BLOCK_ENTITY1_20_2.read(buffer));
        }
        return new Chunk1_21_5(chunkX, chunkZ, sections, heightmaps, blockEntities);
    }

    @Override
    public void write(ByteBuf buffer, Chunk chunk) {
        buffer.writeInt(chunk.getX());
        buffer.writeInt(chunk.getZ());
        Types.HEIGHTMAP_ARRAY.write(buffer, chunk.heightmaps());
        Types.VAR_INT.writePrimitive(buffer, this.sectionType.serializedSize(chunk));
        for (ChunkSection section : chunk.getSections()) {
            this.sectionType.write(buffer, section);
        }
        Types.VAR_INT.writePrimitive(buffer, chunk.blockEntities().size());
        for (BlockEntity blockEntity : chunk.blockEntities()) {
            Types.BLOCK_ENTITY1_20_2.write(buffer, blockEntity);
        }
    }
}

