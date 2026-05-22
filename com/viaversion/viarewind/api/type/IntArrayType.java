/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viarewind.api.type;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class IntArrayType
extends Type<int[]> {
    public IntArrayType() {
        super(int[].class);
    }

    @Override
    public int[] read(ByteBuf byteBuf) {
        byte size = byteBuf.readByte();
        int[] array = new int[size];
        for (byte i2 = 0; i2 < size; i2 = (byte)(i2 + 1)) {
            array[i2] = byteBuf.readInt();
        }
        return array;
    }

    @Override
    public void write(ByteBuf byteBuf, int[] array) {
        byteBuf.writeByte(array.length);
        for (int i2 : array) {
            byteBuf.writeInt(i2);
        }
    }
}

