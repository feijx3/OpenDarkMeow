/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viarewind.api.type.chunk;

import com.viaversion.viarewind.api.type.chunk.ChunkType1_7_6;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Pair;
import io.netty.buffer.ByteBuf;
import java.util.zip.Deflater;

public class BulkChunkType1_7_6
extends Type<Chunk[]> {
    public static final BulkChunkType1_7_6 TYPE = new BulkChunkType1_7_6();

    public BulkChunkType1_7_6() {
        super(Chunk[].class);
    }

    @Override
    public Chunk[] read(ByteBuf byteBuf) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Chunk[] chunks) {
        int compressedSize;
        byte[] compressedData;
        int chunkCount = chunks.length;
        int[] chunkX = new int[chunkCount];
        int[] chunkZ = new int[chunkCount];
        short[] primaryBitMask = new short[chunkCount];
        short[] additionalBitMask = new short[chunkCount];
        byte[][] dataArrays = new byte[chunkCount][];
        int dataSize = 0;
        for (int i2 = 0; i2 < chunkCount; ++i2) {
            Object chunkData;
            Chunk chunk = chunks[i2];
            try {
                byte[] data;
                chunkData = ChunkType1_7_6.serialize(chunk);
                dataArrays[i2] = data = (byte[])((Pair)chunkData).key();
                dataSize += data.length;
            }
            catch (Exception e2) {
                throw new RuntimeException("Unable to serialize chunk", e2);
            }
            chunkX[i2] = chunk.getX();
            chunkZ[i2] = chunk.getZ();
            primaryBitMask[i2] = (short)chunk.getBitmask();
            additionalBitMask[i2] = (Short)((Pair)chunkData).value();
        }
        byte[] data = new byte[dataSize];
        int destPos = 0;
        for (byte[] array : dataArrays) {
            System.arraycopy(array, 0, data, destPos, array.length);
            destPos += array.length;
        }
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(data, 0, data.length);
            deflater.finish();
            compressedData = new byte[data.length];
            compressedSize = deflater.deflate(compressedData);
        }
        finally {
            deflater.end();
        }
        byteBuf.writeShort(chunkCount);
        byteBuf.writeInt(compressedSize);
        boolean skyLight = false;
        block7: for (Chunk chunk : chunks) {
            for (ChunkSection section : chunk.getSections()) {
                if (section == null || !section.getLight().hasSkyLight()) continue;
                skyLight = true;
                continue block7;
            }
        }
        byteBuf.writeBoolean(skyLight);
        byteBuf.writeBytes(compressedData, 0, compressedSize);
        for (int i3 = 0; i3 < chunkCount; ++i3) {
            byteBuf.writeInt(chunkX[i3]);
            byteBuf.writeInt(chunkZ[i3]);
            byteBuf.writeShort((int)primaryBitMask[i3]);
            byteBuf.writeShort((int)additionalBitMask[i3]);
        }
    }
}

