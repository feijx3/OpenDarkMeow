/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class FloatArrayType
extends Type<float[]> {
    private final int length;

    public FloatArrayType(int length) {
        super(float[].class);
        this.length = length;
    }

    public FloatArrayType() {
        super(float[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf buffer, float[] object) {
        if (this.length != -1) {
            Preconditions.checkArgument((this.length == object.length ? 1 : 0) != 0, (Object)"Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(buffer, object.length);
        }
        for (float f2 : object) {
            buffer.writeFloat(f2);
        }
    }

    @Override
    public float[] read(ByteBuf buffer) {
        int length = this.length == -1 ? Types.VAR_INT.readPrimitive(buffer) : this.length;
        Preconditions.checkArgument((boolean)buffer.isReadable(length), (Object)"Length is fewer than readable bytes");
        float[] array = new float[length];
        for (int i2 = 0; i2 < length; ++i2) {
            array[i2] = buffer.readFloat();
        }
        return array;
    }
}

