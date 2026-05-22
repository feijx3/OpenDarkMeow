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

public class DoubleType
extends Type<Double>
implements TypeConverter<Double> {
    public DoubleType() {
        super(Double.class);
    }

    @Override
    @Deprecated
    public Double read(ByteBuf buffer) {
        return buffer.readDouble();
    }

    public double readPrimitive(ByteBuf buffer) {
        return buffer.readDouble();
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Double object) {
        buffer.writeDouble(object.doubleValue());
    }

    public void writePrimitive(ByteBuf buffer, double object) {
        buffer.writeDouble(object);
    }

    @Override
    public void write(Ops ops, Double value) {
        ops.writeDouble(value);
    }

    @Override
    public Double from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.doubleValue();
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return boo != false ? 1.0 : 0.0;
        }
        throw new UnsupportedOperationException();
    }
}

