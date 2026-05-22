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

public class ShortType
extends Type<Short>
implements TypeConverter<Short> {
    public ShortType() {
        super(Short.class);
    }

    public short readPrimitive(ByteBuf buffer) {
        return buffer.readShort();
    }

    public void writePrimitive(ByteBuf buffer, short object) {
        buffer.writeShort((int)object);
    }

    @Override
    @Deprecated
    public Short read(ByteBuf buffer) {
        return buffer.readShort();
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Short object) {
        buffer.writeShort((int)object.shortValue());
    }

    @Override
    public void write(Ops ops, Short value) {
        ops.writeShort(value);
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

