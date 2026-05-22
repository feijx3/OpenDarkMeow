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
import io.netty.buffer.ByteBuf;

public class ByteType
extends Type<Byte>
implements TypeConverter<Byte> {
    public ByteType() {
        super(Byte.class);
    }

    public byte readPrimitive(ByteBuf buffer) {
        return buffer.readByte();
    }

    public void writePrimitive(ByteBuf buffer, byte object) {
        buffer.writeByte((int)object);
    }

    @Override
    @Deprecated
    public Byte read(ByteBuf buffer) {
        return buffer.readByte();
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Byte object) {
        buffer.writeByte((int)object.byteValue());
    }

    @Override
    public void write(Ops ops, Byte value) {
        ops.writeByte(value);
    }

    @Override
    public Byte from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.byteValue();
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return boo != false ? (byte)1 : 0;
        }
        throw new UnsupportedOperationException();
    }
}

