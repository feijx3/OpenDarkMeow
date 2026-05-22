/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class OptionalType<T>
extends Type<T> {
    private final Type<T> type;

    protected OptionalType(Type<T> type) {
        super(type.getOutputClass());
        this.type = type;
    }

    @Override
    public @Nullable T read(ByteBuf buffer) {
        return buffer.readBoolean() ? (T)this.type.read(buffer) : null;
    }

    @Override
    public void write(ByteBuf buffer, @Nullable T value) {
        if (value == null) {
            buffer.writeBoolean(false);
        } else {
            buffer.writeBoolean(true);
            this.type.write(buffer, value);
        }
    }

    @Override
    public void write(Ops ops, T value) {
        this.type.write(ops, value);
    }
}

