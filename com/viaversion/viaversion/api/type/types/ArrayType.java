/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayType<T>
extends Type<T[]> {
    private final Type<T> elementType;
    private final int maxLength;

    public ArrayType(Type<T> type) {
        this(type, -1);
    }

    public ArrayType(Type<T> type, int maxLength) {
        super(ArrayType.jvmdowngrader$concat$$init$$1(type.getTypeName()), ArrayType.getArrayClass(type.getOutputClass()));
        this.elementType = type;
        this.maxLength = maxLength;
    }

    public static Class<?> getArrayClass(Class<?> componentType) {
        return Array.newInstance(componentType, 0).getClass();
    }

    @Override
    public T[] read(ByteBuf buffer) {
        int amount = Types.VAR_INT.readPrimitive(buffer);
        if (this.maxLength != -1 && amount > this.maxLength) {
            throw new IllegalArgumentException(ArrayType.jvmdowngrader$concat$read$1(amount, this.maxLength));
        }
        return amount < Short.MAX_VALUE ? this.readArray(buffer, amount) : this.readList(buffer, amount);
    }

    private T[] readArray(ByteBuf buffer, int length) {
        T[] array = this.createArray(length);
        for (int i2 = 0; i2 < length; ++i2) {
            array[i2] = this.elementType.read(buffer);
        }
        return array;
    }

    private T[] readList(ByteBuf buffer, int length) {
        ArrayList list = new ArrayList();
        for (int i2 = 0; i2 < length; ++i2) {
            list.add(this.elementType.read(buffer));
        }
        return list.toArray(this.createArray(0));
    }

    private T[] createArray(int length) {
        return (Object[])Array.newInstance(this.elementType.getOutputClass(), length);
    }

    @Override
    public void write(ByteBuf buffer, T[] object) {
        if (this.maxLength != -1 && object.length > this.maxLength) {
            throw new IllegalArgumentException(ArrayType.jvmdowngrader$concat$read$1(object.length, this.maxLength));
        }
        Types.VAR_INT.writePrimitive(buffer, object.length);
        for (T o2 : object) {
            this.elementType.write(buffer, o2);
        }
    }

    @Override
    public void write(Ops ops, T[] value) {
        ops.writeList(list -> {
            for (Object element : value) {
                list.write(this.elementType, element);
            }
        });
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return string + " Array";
    }

    private static String jvmdowngrader$concat$read$1(int n2, int n3) {
        return "Array length " + n2 + " is longer than maximum " + n3;
    }
}

