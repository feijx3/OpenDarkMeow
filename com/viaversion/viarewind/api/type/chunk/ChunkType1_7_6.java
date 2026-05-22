/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viarewind.api.type.chunk;

import com.viaversion.viarewind.api.minecraft.ExtendedBlockStorage;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Pair;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.zip.Deflater;

public class ChunkType1_7_6
extends Type<Chunk> {
    public static final ChunkType1_7_6 TYPE = new ChunkType1_7_6();

    public ChunkType1_7_6() {
        super(Chunk.class);
    }

    @Override
    public Chunk read(ByteBuf byteBuf) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf output, Chunk chunk) {
        int compressedSize;
        byte[] compressedData;
        Pair<byte[], Short> chunkData;
        try {
            chunkData = ChunkType1_7_6.serialize(chunk);
        }
        catch (IOException e2) {
            throw new RuntimeException("Unable to serialize chunk", e2);
        }
        byte[] data = chunkData.key();
        short additionalBitMask = chunkData.value();
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
        output.writeInt(chunk.getX());
        output.writeInt(chunk.getZ());
        output.writeBoolean(chunk.isFullChunk());
        output.writeShort(chunk.getBitmask());
        output.writeShort((int)additionalBitMask);
        output.writeInt(compressedSize);
        output.writeBytes(compressedData, 0, compressedSize);
    }

    public static Pair<byte[], Short> serialize(Chunk chunk) throws IOException {
        int i2;
        ExtendedBlockStorage[] storageArrays = new ExtendedBlockStorage[16];
        for (int i3 = 0; i3 < storageArrays.length; ++i3) {
            ChunkSection section = chunk.getSections()[i3];
            if (section == null) continue;
            ExtendedBlockStorage storage = storageArrays[i3] = new ExtendedBlockStorage(section.getLight().hasSkyLight());
            for (int x2 = 0; x2 < 16; ++x2) {
                for (int z2 = 0; z2 < 16; ++z2) {
                    for (int y2 = 0; y2 < 16; ++y2) {
                        int flatBlock = section.palette(PaletteType.BLOCKS).idAt(x2, y2, z2);
                        storage.setBlockId(x2, y2, z2, flatBlock >> 4);
                        storage.setBlockMetadata(x2, y2, z2, flatBlock & 0xF);
                    }
                }
            }
            storage.getBlockLightArray().setHandle(section.getLight().getBlockLight());
            if (!section.getLight().hasSkyLight()) continue;
            storage.getSkyLightArray().setHandle(section.getLight().getSkyLight());
        }
        boolean biomes = chunk.isFullChunk() && chunk.getBiomeData() != null;
        int totalSize = ChunkType1_7_6.calculateSize(storageArrays, chunk.getBitmask(), biomes);
        byte[] output = new byte[totalSize];
        int index = 0;
        for (i2 = 0; i2 < storageArrays.length; ++i2) {
            if ((chunk.getBitmask() & 1 << i2) == 0) continue;
            byte[] blockLSBArray = storageArrays[i2].getBlockLSBArray();
            System.arraycopy(blockLSBArray, 0, output, index, blockLSBArray.length);
            index += blockLSBArray.length;
        }
        for (i2 = 0; i2 < storageArrays.length; ++i2) {
            if ((chunk.getBitmask() & 1 << i2) == 0) continue;
            byte[] blockMetadataArray = storageArrays[i2].getBlockMetadataArray().getHandle();
            System.arraycopy(blockMetadataArray, 0, output, index, blockMetadataArray.length);
            index += blockMetadataArray.length;
        }
        for (i2 = 0; i2 < storageArrays.length; ++i2) {
            if ((chunk.getBitmask() & 1 << i2) == 0) continue;
            byte[] blockLightArray = storageArrays[i2].getBlockLightArray().getHandle();
            System.arraycopy(blockLightArray, 0, output, index, blockLightArray.length);
            index += blockLightArray.length;
        }
        for (i2 = 0; i2 < storageArrays.length; ++i2) {
            if ((chunk.getBitmask() & 1 << i2) == 0 || storageArrays[i2].getSkyLightArray() == null) continue;
            byte[] skyLightArray = storageArrays[i2].getSkyLightArray().getHandle();
            System.arraycopy(skyLightArray, 0, output, index, skyLightArray.length);
            index += skyLightArray.length;
        }
        short additionalBitMask = 0;
        for (int i4 = 0; i4 < storageArrays.length; ++i4) {
            if ((chunk.getBitmask() & 1 << i4) == 0 || !storageArrays[i4].hasBlockMSBArray()) continue;
            additionalBitMask = (short)(additionalBitMask | (short)(1 << i4));
            byte[] blockMSBArray = storageArrays[i4].getOrCreateBlockMSBArray().getHandle();
            System.arraycopy(blockMSBArray, 0, output, index, blockMSBArray.length);
            index += blockMSBArray.length;
        }
        if (biomes) {
            for (int biome : chunk.getBiomeData()) {
                output[index++] = (byte)biome;
            }
        }
        return new Pair<byte[], Short>(output, additionalBitMask);
    }

    private static int calculateSize(ExtendedBlockStorage[] storageArrays, int bitmask, boolean biomes) {
        int totalSize = 0;
        for (int i2 = 0; i2 < storageArrays.length; ++i2) {
            if ((bitmask & 1 << i2) == 0) continue;
            totalSize += 4096;
            totalSize += 2048;
            totalSize += 2048;
            if (storageArrays[i2].getSkyLightArray() != null) {
                totalSize += 2048;
            }
            if (!storageArrays[i2].hasBlockMSBArray()) continue;
            totalSize += 2048;
        }
        if (biomes) {
            totalSize += 256;
        }
        return totalSize;
    }
}

