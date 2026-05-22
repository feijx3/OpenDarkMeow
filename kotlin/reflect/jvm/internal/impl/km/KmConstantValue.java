/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.contracts.ExperimentalContracts
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalContracts
public final class KmConstantValue {
    @Nullable
    private final Object value;

    public KmConstantValue(@Nullable Object value) {
        this.value = value;
    }

    @NotNull
    public String toString() {
        return "KmConstantValue(value=" + this.value + ')';
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmConstantValue)) {
            return false;
        }
        KmConstantValue kmConstantValue = (KmConstantValue)other;
        return Intrinsics.areEqual(this.value, kmConstantValue.value);
    }
}

