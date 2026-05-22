/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import java.util.function.Consumer;

public class ThrowingOps
implements Ops {
    @Override
    public CodecContext context() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeByte(byte b2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeBytes(byte[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeBoolean(boolean b2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeShort(short s2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeString(CharSequence sequence) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeInt(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeLong(long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeFloat(float f2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeDouble(double d2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeInts(int[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeLongs(long[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <V> void write(Type<V> type, V value) {
        throw new UnsupportedOperationException();
    }
}

