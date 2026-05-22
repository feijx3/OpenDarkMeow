/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import io.netty.buffer.ByteBuf;

final class EmptyStructuredData<T>
implements StructuredData<T> {
    private final StructuredDataKey<T> key;
    private int id;

    EmptyStructuredData(StructuredDataKey<T> key, int id) {
        this.key = key;
        this.id = id;
    }

    @Override
    public void setValue(T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(ByteBuf buffer) {
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
        return new EmptyStructuredData<T>(this.key, this.id);
    }

    @Override
    public T value() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
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
        EmptyStructuredData that = (EmptyStructuredData)o2;
        if (this.id != that.id) {
            return false;
        }
        return this.key.equals(that.key);
    }

    public int hashCode() {
        int result = this.key.hashCode();
        result = 31 * result + this.id;
        return result;
    }

    public String toString() {
        return EmptyStructuredData.jvmdowngrader$concat$toString$1(String.valueOf(this.key), this.id);
    }

    private static String jvmdowngrader$concat$toString$1(String string, int n2) {
        return "EmptyStructuredData{key=" + string + ", id=" + n2 + "}";
    }
}

