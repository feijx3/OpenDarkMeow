/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmFlexibleTypeUpperBound {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private KmType type;
    @Nullable
    private String typeFlexibilityId;

    public KmFlexibleTypeUpperBound(@NotNull KmType type, @Nullable String typeFlexibilityId) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.typeFlexibilityId = typeFlexibilityId;
    }

    @NotNull
    public final KmType getType() {
        return this.type;
    }

    @Nullable
    public final String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
    }

    @NotNull
    public String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.type + ", typeFlexibilityId=" + this.typeFlexibilityId + ')';
    }

    public int hashCode() {
        int result = this.type.hashCode();
        result = result * 31 + (this.typeFlexibilityId == null ? 0 : this.typeFlexibilityId.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmFlexibleTypeUpperBound)) {
            return false;
        }
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = (KmFlexibleTypeUpperBound)other;
        if (!Intrinsics.areEqual(this.type, kmFlexibleTypeUpperBound.type)) {
            return false;
        }
        return Intrinsics.areEqual(this.typeFlexibilityId, kmFlexibleTypeUpperBound.typeFlexibilityId);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

