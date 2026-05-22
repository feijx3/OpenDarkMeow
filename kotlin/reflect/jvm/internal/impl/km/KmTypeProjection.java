/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmTypeProjection {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private KmVariance variance;
    @Nullable
    private KmType type;
    @JvmField
    @NotNull
    public static final KmTypeProjection STAR = new KmTypeProjection(null, null);

    public KmTypeProjection(@Nullable KmVariance variance, @Nullable KmType type) {
        this.variance = variance;
        this.type = type;
    }

    @Nullable
    public final KmVariance component1() {
        return this.variance;
    }

    @Nullable
    public final KmType component2() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "KmTypeProjection(variance=" + (Object)((Object)this.variance) + ", type=" + this.type + ')';
    }

    public int hashCode() {
        int result = this.variance == null ? 0 : this.variance.hashCode();
        result = result * 31 + (this.type == null ? 0 : this.type.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmTypeProjection)) {
            return false;
        }
        KmTypeProjection kmTypeProjection = (KmTypeProjection)other;
        if (this.variance != kmTypeProjection.variance) {
            return false;
        }
        return Intrinsics.areEqual(this.type, kmTypeProjection.type);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

