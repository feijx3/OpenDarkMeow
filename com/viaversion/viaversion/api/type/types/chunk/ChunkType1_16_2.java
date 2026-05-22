/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;

public class ChunkType1_16_2
extends Type<Chunk> {
    public static final Type<Chunk> TYPE = new ChunkType1_16_2();
    private static final CompoundTag[] EMPTY_COMPOUNDS = new CompoundTag[0];

    public ChunkType1_16_2() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf input) {
        int chunkX = input.readInt();
        int chunkZ = input.readInt();
        boolean fullChunk = input.readBoolean();
        int primaryBitmask = Types.VAR_INT.readPrimitive(input);
        CompoundTag heightMap = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(input);
        int[] biomeData = null;
        if (fullChunk) {
            biomeData = (int[])Types.VAR_INT_ARRAY_PRIMITIVE.read(input);
        }
        ByteBuf data = input.readSlice(Types.VAR_INT.readPrimitive(input));
        ChunkSection[] sections = new ChunkSection[16];
        for (int i2 = 0; i2 < 16; ++i2) {
            if ((primaryBitmask & 1 << i2) == 0) continue;
            short nonAirBlocksCount = data.readShort();
            ChunkSection section = (ChunkSection)Types.CHUNK_SECTION1_16.read(data);
            section.setNonAirBlocksCount(nonAirBlocksCount);
            sections[i2] = section;
        }
        ArrayList<CompoundTag> nbtData = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Types.NAMED_COMPOUND_TAG_ARRAY.read(input)));
        return new BaseChunk(chunkX, chunkZ, fullChunk, false, primaryBitmask, sections, biomeData, heightMap, nbtData);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf output, Chunk chunk) {
        output.writeInt(chunk.getX());
        output.writeInt(chunk.getZ());
        output.writeBoolean(chunk.isFullChunk());
        Types.VAR_INT.writePrimitive(output, chunk.getBitmask());
        Types.NAMED_COMPOUND_TAG.write(output, chunk.getHeightMap());
        if (chunk.isBiomeData()) {
            Types.VAR_INT_ARRAY_PRIMITIVE.write(output, chunk.getBiomeData());
        }
        ByteBuf buf = output.alloc().buffer();
        try {
            for (int i2 = 0; i2 < 16; ++i2) {
                ChunkSection section = chunk.getSections()[i2];
                if (section == null) continue;
                buf.writeShort(section.getNonAirBlocksCount());
                Types.CHUNK_SECTION1_16.write(buf, section);
            }
            buf.readerIndex(0);
            Types.VAR_INT.writePrimitive(output, buf.readableBytes());
            output.writeBytes(buf);
        }
        finally {
            buf.release();
        }
        Types.NAMED_COMPOUND_TAG_ARRAY.write(output, chunk.getBlockEntities().toArray(EMPTY_COMPOUNDS));
    }
}

