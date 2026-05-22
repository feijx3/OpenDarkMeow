/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class RemainingBytesType
extends Type<byte[]> {
    private final int maxLength;

    public RemainingBytesType() {
        this(-1);
    }

    public RemainingBytesType(int maxLength) {
        super(byte[].class);
        this.maxLength = maxLength;
    }

    @Override
    public byte[] read(ByteBuf buffer) {
        int bytes = buffer.readableBytes();
        if (this.maxLength != -1 && bytes > this.maxLength) {
            throw new RuntimeException(RemainingBytesType.jvmdowngrader$concat$read$1(this.maxLength, bytes));
        }
        byte[] array = new byte[bytes];
        buffer.readBytes(array);
        return array;
    }

    @Override
    public void write(ByteBuf buffer, byte[] object) {
        if (this.maxLength != -1 && object.length > this.maxLength) {
            throw new RuntimeException(RemainingBytesType.jvmdowngrader$concat$read$1(this.maxLength, object.length));
        }
        buffer.writeBytes(object);
    }

    private static String jvmdowngrader$concat$read$1(int n2, int n3) {
        return "Remaining bytes cannot be longer than " + n2 + " (got " + n3 + ")";
    }
}

