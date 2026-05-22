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

public class IntType
extends Type<Integer>
implements TypeConverter<Integer> {
    public IntType() {
        super(Integer.class);
    }

    @Override
    public Integer read(ByteBuf buffer) {
        return buffer.readInt();
    }

    public int readPrimitive(ByteBuf buffer) {
        return buffer.readInt();
    }

    @Override
    public void write(ByteBuf buffer, Integer object) {
        buffer.writeInt(object.intValue());
    }

    public void writePrimitive(ByteBuf buffer, int object) {
        buffer.writeInt(object);
    }

    @Override
    public void write(Ops ops, Integer value) {
        ops.writeInt(value);
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
}

