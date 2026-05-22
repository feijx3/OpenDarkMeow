/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.DataPaletteImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.type.types.LongArrayType;
import com.viaversion.viaversion.api.type.types.chunk.PaletteType1_18;
import com.viaversion.viaversion.util.CompactArrayUtil;
import io.netty.buffer.ByteBuf;

public final class PaletteType1_21_5
extends PaletteType1_18 {
    public PaletteType1_21_5(PaletteType type, int globalPaletteBits) {
        super(type, globalPaletteBits);
    }

    @Override
    protected void readValues(ByteBuf buffer, int bitsPerValue, DataPaletteImpl palette) {
        if (bitsPerValue == 0) {
            return;
        }
        char valuesPerLong = (char)(64 / bitsPerValue);
        int expectedLength = (this.type.size() + valuesPerLong - 1) / valuesPerLong;
        long[] values = LongArrayType.readFixedLength(buffer, expectedLength);
        if (values.length != 0) {
            CompactArrayUtil.iterateCompactArrayWithPadding(bitsPerValue, this.type.size(), values, bitsPerValue == this.globalPaletteBits ? palette::setIdAt : palette::setPaletteIndexAt);
        }
    }

    @Override
    protected void writeValues(ByteBuf buffer, DataPalette palette, int bitsPerValue) {
        if (bitsPerValue == 0) {
            return;
        }
        long[] values = CompactArrayUtil.createCompactArrayWithPadding(bitsPerValue, this.type.size(), bitsPerValue == this.globalPaletteBits ? palette::idAt : palette::paletteIndexAt);
        LongArrayType.writeFixedLength(buffer, values);
    }

    @Override
    protected int serializedValuesSize(int values) {
        return 8 * values;
    }
}

