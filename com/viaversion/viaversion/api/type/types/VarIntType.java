/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VarIntType
extends Type<Integer>
implements TypeConverter<Integer> {
    private static final int CONTINUE_BIT = 128;
    private static final int VALUE_BITS = 127;
    private static final int MULTI_BYTE_BITS = -128;
    private static final int MAX_BYTES = 5;
    private static final int[] VAR_INT_LENGTHS = new int[65];

    public VarIntType() {
        super("VarInt", Integer.class);
    }

    public int readPrimitive(ByteBuf buffer) {
        byte in;
        int value = 0;
        int bytes = 0;
        do {
            in = buffer.readByte();
            value |= (in & 0x7F) << bytes++ * 7;
            if (bytes <= 5) continue;
            throw new RuntimeException("VarInt too big");
        } while ((in & 0x80) == 128);
        return value;
    }

    public void writePrimitive(ByteBuf buffer, int value) {
        while ((value & 0xFFFFFF80) != 0) {
            buffer.writeByte(value & 0x7F | 0x80);
            value >>>= 7;
        }
        buffer.writeByte(value);
    }

    @Override
    @Deprecated
    public Integer read(ByteBuf buffer) {
        return this.readPrimitive(buffer);
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Integer object) {
        this.writePrimitive(buffer, object);
    }

    @Override
    public void write(Ops ops, Integer integer) {
        Types.INT.write(ops, integer);
    }

    @Override
    public Integer from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.intValue();
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return boo != false ? 1 : 0;
        }
        throw new UnsupportedOperationException();
    }

    public static int varIntLength(int value) {
        return VAR_INT_LENGTHS[Integer.numberOfLeadingZeros(value)];
    }

    static {
        for (int i2 = 0; i2 <= 32; ++i2) {
            VarIntType.VAR_INT_LENGTHS[i2] = (int)Math.ceil((31.0 - (double)(i2 - 1)) / 7.0);
        }
        VarIntType.VAR_INT_LENGTHS[32] = 1;
    }
}

