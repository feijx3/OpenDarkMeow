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

public class UnsignedByteType
extends Type<Short>
implements TypeConverter<Short> {
    public static final int MAX_VALUE = 255;

    public UnsignedByteType() {
        super("Unsigned Byte", Short.class);
    }

    @Override
    public Short read(ByteBuf buffer) {
        return buffer.readUnsignedByte();
    }

    @Override
    public void write(ByteBuf buffer, Short object) {
        buffer.writeByte((int)object.shortValue());
    }

    @Override
    public void write(Ops ops, Short value) {
        Types.BYTE.write(ops, (Byte)((byte)(value & 0xFF)));
    }

    @Override
    public Short from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.shortValue();
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return boo != false ? (short)1 : 0;
        }
        throw new UnsupportedOperationException();
    }
}

