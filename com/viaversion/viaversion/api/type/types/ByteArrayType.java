/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalByteArrayType.class})
public class ByteArrayType
extends Type<byte[]> {
    private final int length;

    public ByteArrayType(int length) {
        super(byte[].class);
        this.length = length;
    }

    public ByteArrayType() {
        super(byte[].class);
        this.length = -1;
    }

    @Override
    public void write(ByteBuf buffer, byte[] object) {
        if (this.length != -1) {
            Preconditions.checkArgument((this.length == object.length ? 1 : 0) != 0, (Object)"Length does not match expected length");
        } else {
            Types.VAR_INT.writePrimitive(buffer, object.length);
        }
        buffer.writeBytes(object);
    }

    @Override
    public byte[] read(ByteBuf buffer) {
        int length = this.length == -1 ? Types.VAR_INT.readPrimitive(buffer) : this.length;
        Preconditions.checkArgument((boolean)buffer.isReadable(length), (Object)"Length is fewer than readable bytes");
        byte[] array = new byte[length];
        buffer.readBytes(array);
        return array;
    }

    @Override
    public void write(Ops ops, byte[] value) {
        ops.writeBytes(value);
    }

    @NestHost(value=ByteArrayType.class)
    public static final class OptionalByteArrayType
    extends OptionalType<byte[]> {
        public OptionalByteArrayType() {
            super(Types.BYTE_ARRAY_PRIMITIVE);
        }

        public OptionalByteArrayType(int length) {
            super(new ByteArrayType(length));
        }
    }
}

