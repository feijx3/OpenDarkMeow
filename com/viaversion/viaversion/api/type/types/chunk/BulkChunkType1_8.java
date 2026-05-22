/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ChunkBulkSection.class})
public class BulkChunkType1_8
extends Type<Chunk[]> {
    public static final Type<Chunk[]> TYPE = new BulkChunkType1_8();
    private static final int BLOCKS_PER_SECTION = 4096;
    private static final int BLOCKS_BYTES = 8192;
    private static final int LIGHT_BYTES = 2048;
    private static final int BIOME_BYTES = 256;

    public BulkChunkType1_8() {
        super(Chunk[].class);
    }

    @Override
    public Chunk[] read(ByteBuf input) {
        int i2;
        boolean skyLight = input.readBoolean();
        int count = Types.VAR_INT.readPrimitive(input);
        Chunk[] chunks = new Chunk[count];
        ChunkBulkSection[] chunkInfo = new ChunkBulkSection[count];
        for (i2 = 0; i2 < chunkInfo.length; ++i2) {
            chunkInfo[i2] = new ChunkBulkSection(input, skyLight);
        }
        for (i2 = 0; i2 < chunks.length; ++i2) {
            ChunkBulkSection chunkBulkSection = chunkInfo[i2];
            chunkBulkSection.readData(input);
            chunks[i2] = ChunkType1_8.deserialize(chunkBulkSection.jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$chunkX(), chunkBulkSection.jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$chunkZ(), true, skyLight, chunkBulkSection.jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$bitmask(), chunkBulkSection.data());
        }
        return chunks;
    }

    @Override
    public void write(ByteBuf output, Chunk[] chunks) {
        boolean skyLight = false;
        block0: for (Chunk chunk : chunks) {
            for (ChunkSection section : chunk.getSections()) {
                if (section == null || !section.getLight().hasSkyLight()) continue;
                skyLight = true;
                break block0;
            }
        }
        output.writeBoolean(skyLight);
        Types.VAR_INT.writePrimitive(output, chunks.length);
        for (Chunk chunk : chunks) {
            output.writeInt(chunk.getX());
            output.writeInt(chunk.getZ());
            output.writeShort(chunk.getBitmask());
        }
        for (Chunk chunk : chunks) {
            output.writeBytes(ChunkType1_8.serialize(chunk));
        }
    }

    @NestHost(value=BulkChunkType1_8.class)
    public static final class ChunkBulkSection {
        private final int chunkX;
        private final int chunkZ;
        private final int bitmask;
        private final byte[] data;

        public ChunkBulkSection(ByteBuf input, boolean skyLight) {
            this.chunkX = input.readInt();
            this.chunkZ = input.readInt();
            this.bitmask = input.readUnsignedShort();
            int setSections = Integer.bitCount(this.bitmask);
            this.data = new byte[setSections * (8192 + (skyLight ? 4096 : 2048)) + 256];
        }

        public void readData(ByteBuf input) {
            input.readBytes(this.data);
        }

        public int chunkX() {
            return this.chunkX;
        }

        public int chunkZ() {
            return this.chunkZ;
        }

        public int bitmask() {
            return this.bitmask;
        }

        public byte[] data() {
            return this.data;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$bitmask() {
            return this.bitmask;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$set$bitmask(int n2) {
            this.bitmask = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$chunkZ() {
            return this.chunkZ;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$set$chunkZ(int n2) {
            this.chunkZ = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$get$chunkX() {
            return this.chunkX;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_chunk_BulkChunkType1_8$ChunkBulkSection$set$chunkX(int n2) {
            this.chunkX = n2;
        }
    }
}

