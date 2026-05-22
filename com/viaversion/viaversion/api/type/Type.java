/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.ByteBufReader;
import com.viaversion.viaversion.api.type.ByteBufWriter;
import com.viaversion.viaversion.api.type.CodecWriter;

public abstract class Type<T>
implements ByteBufReader<T>,
ByteBufWriter<T>,
CodecWriter<T> {
    private final Class<? super T> outputClass;
    private final String typeName;

    protected Type(Class<? super T> outputClass) {
        this(null, outputClass);
    }

    protected Type(String typeName, Class<? super T> outputClass) {
        this.outputClass = outputClass;
        this.typeName = typeName;
    }

    public Class<? super T> getOutputClass() {
        return this.outputClass;
    }

    public String getTypeName() {
        return this.typeName != null && !this.typeName.isEmpty() ? this.typeName : this.getClass().getName();
    }

    @Override
    public void write(Ops ops, T value) {
        throw new UnsupportedOperationException(Type.jvmdowngrader$concat$write$1(this.getTypeName()));
    }

    public Class<? extends Type> getBaseClass() {
        return this.getClass();
    }

    public String toString() {
        return this.getTypeName();
    }

    private static String jvmdowngrader$concat$write$1(String string) {
        return "Write operation not supported for type: " + string;
    }
}

