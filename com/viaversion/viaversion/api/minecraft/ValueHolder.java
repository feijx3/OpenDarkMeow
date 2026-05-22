/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="value", type=Object.class)})
final class ValueHolder<T>
extends J_L_Record
implements Holder<T> {
    private final T value;

    ValueHolder(T value) {
        this.value = value;
    }

    @Override
    public boolean isDirect() {
        return true;
    }

    @Override
    public boolean hasId() {
        return false;
    }

    @Override
    public int id() {
        return -1;
    }

    @Override
    public Holder<T> updateId(Int2IntFunction rewriteFunction, Supplier<Holder<T>> ifMissing) {
        return this;
    }

    @Override
    public Holder<T> updateValue(Function<T, T> rewriteFunction) {
        T rewrittenValue = rewriteFunction.apply(this.value);
        return rewrittenValue != this.value ? Holder.of(rewrittenValue) : this;
    }

    @Override
    public final String toString() {
        return ValueHolder.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ValueHolder.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ValueHolder.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public T value() {
        return this.value;
    }

    private static String jvmdowngrader$toString$toString(ValueHolder valueHolder) {
        ValueHolder valueHolder2 = valueHolder;
        return "ValueHolder[" + "value=" + valueHolder.value + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ValueHolder valueHolder) {
        Object[] objectArray = new Object[]{valueHolder.value};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ValueHolder valueHolder, Object object) {
        if (valueHolder == object) {
            return true;
        }
        if (object != null && object instanceof ValueHolder) {
            ValueHolder valueHolder2 = (ValueHolder)object;
            if (Objects.equals(valueHolder.value, valueHolder2.value)) {
                return true;
            }
        }
        return false;
    }
}

