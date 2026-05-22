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

public class IntArrayType
extends Type<int[]> {
    private final int length;

    public IntArrayType(int length) {
        super(int[].class);
        this.length = length;
    }

    public IntArrayType() {
        super(int[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf buffer, int[] object) {
        if (this.length != -1) {
            Preconditions.checkArgument((this.length == object.length ? 1 : 0) != 0, (Object)"Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(buffer, object.length);
        }
        for (int i2 : object) {
            buffer.writeInt(i2);
        }
    }

    @Override
    public int[] read(ByteBuf buffer) {
        int length = this.length == -1 ? Types.VAR_INT.readPrimitive(buffer) : this.length;
        Preconditions.checkArgument((boolean)buffer.isReadable(length), (Object)"Length is fewer than readable bytes");
        int[] array = new int[length];
        for (int i2 = 0; i2 < length; ++i2) {
            array[i2] = buffer.readInt();
        }
        return array;
    }

    @Override
    public void write(Ops ops, int[] value) {
        ops.writeInts(value);
    }
}

