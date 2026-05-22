/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class LongArrayType
extends Type<long[]> {
    private final int length;

    public LongArrayType(int length) {
        super(long[].class);
        this.length = length;
    }

    public LongArrayType() {
        this(-1);
    }

    @Override
    public long[] read(ByteBuf buffer) {
        int length = this.length == -1 ? Types.VAR_INT.readPrimitive(buffer) : this.length;
        Preconditions.checkArgument((boolean)buffer.isReadable(length), (Object)"Length is fewer than readable bytes");
        return LongArrayType.readFixedLength(buffer, length);
    }

    public static long[] readFixedLength(ByteBuf buffer, int expectedLength) {
        long[] value = new long[expectedLength];
        for (int i2 = 0; i2 < expectedLength; ++i2) {
            value[i2] = buffer.readLong();
        }
        return value;
    }

    @Override
    public void write(ByteBuf buffer, long[] object) {
        if (this.length != -1) {
            Preconditions.checkArgument((this.length == object.length ? 1 : 0) != 0, (Object)"Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(buffer, object.length);
        }
        LongArrayType.writeFixedLength(buffer, object);
    }

    public static void writeFixedLength(ByteBuf buffer, long[] object) {
        for (long l2 : object) {
            buffer.writeLong(l2);
        }
    }

    @Override
    public void write(Ops ops, long[] value) {
        ops.writeLongs(value);
    }
}

