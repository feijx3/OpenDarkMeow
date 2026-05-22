/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

final class FilledStructuredData<T>
implements StructuredData<T> {
    private final StructuredDataKey<T> key;
    private T value;
    private int id;

    FilledStructuredData(StructuredDataKey<T> key, T value, int id) {
        Preconditions.checkNotNull(key);
        this.key = key;
        this.value = value;
        this.id = id;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void write(ByteBuf buffer) {
        this.key.type().write(buffer, this.value);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public StructuredDataKey<T> key() {
        return this.key;
    }

    @Override
    public StructuredData<T> copy() {
        return new FilledStructuredData<T>(this.key, Copyable.copy(this.value), this.id);
    }

    @Override
    public T value() {
        return this.value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int id() {
        return this.id;
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        FilledStructuredData that = (FilledStructuredData)o2;
        if (this.id != that.id) {
            return false;
        }
        if (!this.key.equals(that.key)) {
            return false;
        }
        return Objects.equals(this.value, that.value);
    }

    public int hashCode() {
        int result = this.key.hashCode();
        result = 31 * result + (this.value != null ? this.value.hashCode() : 0);
        result = 31 * result + this.id;
        return result;
    }

    public String toString() {
        return FilledStructuredData.jvmdowngrader$concat$toString$1(String.valueOf(this.key), String.valueOf(this.value), this.id);
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2, int n2) {
        return "FilledStructuredData{key=" + string + ", value=" + string2 + ", id=" + n2 + "}";
    }
}

