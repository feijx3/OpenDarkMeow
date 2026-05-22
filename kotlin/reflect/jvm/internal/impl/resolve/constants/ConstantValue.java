/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ConstantValue<T> {
    private final T value;

    public ConstantValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @NotNull
    public abstract KotlinType getType(@NotNull ModuleDescriptor var1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        ConstantValue constantValue = other instanceof ConstantValue ? (ConstantValue)other : null;
        if (!Intrinsics.areEqual(this.getValue(), constantValue != null ? constantValue.getValue() : null)) return false;
        return true;
    }

    public int hashCode() {
        T t2 = this.getValue();
        return t2 != null ? t2.hashCode() : 0;
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.getValue());
    }
}

