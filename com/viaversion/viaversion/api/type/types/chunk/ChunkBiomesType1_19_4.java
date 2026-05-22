/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.api.type.types.chunk.PaletteTypeBase;
import io.netty.buffer.ByteBuf;

public class ChunkBiomesType1_19_4
extends Type<DataPalette[]> {
    private final PaletteTypeBase paletteType;
    private final int ySectionCount;

    public ChunkBiomesType1_19_4(int ySectionCount, int globalPaletteBiomeBits) {
        this(ySectionCount, new PaletteType1_18(PaletteType.BIOMES, globalPaletteBiomeBits));
    }

    protected ChunkBiomesType1_19_4(int ySectionCount, PaletteTypeBase paletteType) {
        super(DataPalette[].class);
        this.paletteType = paletteType;
        this.ySectionCount = ySectionCount;
    }

    @Override
    public DataPalette[] read(ByteBuf buffer) {
        ByteBuf data = buffer.readSlice(Types.VAR_INT.readPrimitive(buffer));
        DataPalette[] sections = new DataPalette[this.ySectionCount];
        for (int i2 = 0; i2 < this.ySectionCount; ++i2) {
            sections[i2] = (DataPalette)this.paletteType.read(data);
        }
        return sections;
    }

    @Override
    public void write(ByteBuf buffer, DataPalette[] value) {
        int size = 0;
        for (DataPalette biomes : value) {
            size += this.paletteType.serializedSize(biomes);
        }
        Types.VAR_INT.writePrimitive(buffer, size);
        for (DataPalette biomes : value) {
            this.paletteType.write(buffer, biomes);
        }
    }
}

