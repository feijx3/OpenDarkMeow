/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public ApproximationBounds(T lower, T upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }

    public int hashCode() {
        int result = this.lower == null ? 0 : this.lower.hashCode();
        result = result * 31 + (this.upper == null ? 0 : this.upper.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds)other;
        if (!Intrinsics.areEqual(this.lower, approximationBounds.lower)) {
            return false;
        }
        return Intrinsics.areEqual(this.upper, approximationBounds.upper);
    }
}

