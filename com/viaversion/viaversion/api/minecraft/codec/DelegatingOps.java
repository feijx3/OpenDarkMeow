/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import java.util.function.Consumer;

public class DelegatingOps
implements Ops {
    private final Ops delegate;

    public DelegatingOps(Ops delegate) {
        this.delegate = delegate;
    }

    @Override
    public CodecContext context() {
        return this.delegate.context();
    }

    @Override
    public void writeByte(byte b2) {
        this.delegate.writeByte(b2);
    }

    @Override
    public void writeBytes(byte[] array) {
        this.delegate.writeBytes(array);
    }

    @Override
    public void writeBoolean(boolean b2) {
        this.delegate.writeBoolean(b2);
    }

    @Override
    public void writeShort(short s2) {
        this.delegate.writeShort(s2);
    }

    @Override
    public void writeString(CharSequence sequence) {
        this.delegate.writeString(sequence);
    }

    @Override
    public void writeInt(int i2) {
        this.delegate.writeInt(i2);
    }

    @Override
    public void writeLong(long l2) {
        this.delegate.writeLong(l2);
    }

    @Override
    public void writeFloat(float f2) {
        this.delegate.writeFloat(f2);
    }

    @Override
    public void writeDouble(double d2) {
        this.delegate.writeDouble(d2);
    }

    @Override
    public void writeInts(int[] array) {
        this.delegate.writeInts(array);
    }

    @Override
    public void writeLongs(long[] array) {
        this.delegate.writeLongs(array);
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        this.delegate.writeList(consumer);
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        this.delegate.writeMap(consumer);
    }

    @Override
    public <V> void write(Type<V> type, V value) {
        this.delegate.write(type, value);
    }
}

