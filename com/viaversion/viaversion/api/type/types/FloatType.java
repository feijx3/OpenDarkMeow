/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalFloatType.class})
public class FloatType
extends Type<Float>
implements TypeConverter<Float> {
    public FloatType() {
        super(Float.class);
    }

    public float readPrimitive(ByteBuf buffer) {
        return buffer.readFloat();
    }

    public void writePrimitive(ByteBuf buffer, float object) {
        buffer.writeFloat(object);
    }

    @Override
    @Deprecated
    public Float read(ByteBuf buffer) {
        return Float.valueOf(buffer.readFloat());
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Float object) {
        buffer.writeFloat(object.floatValue());
    }

    @Override
    public Float from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return Float.valueOf(number.floatValue());
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return Float.valueOf(boo != false ? 1.0f : 0.0f);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(Ops ops, Float value) {
        ops.writeFloat(value.floatValue());
    }

    @NestHost(value=FloatType.class)
    public static final class OptionalFloatType
    extends OptionalType<Float> {
        public OptionalFloatType() {
            super(Types.FLOAT);
        }
    }
}

