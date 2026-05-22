/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PreReleaseInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isInvisible;
    @NotNull
    private final List<String> poisoningFeatures;
    @NotNull
    private static final PreReleaseInfo DEFAULT_VISIBLE = new PreReleaseInfo(false, null, 2, null);

    public PreReleaseInfo(boolean isInvisible, @NotNull List<String> poisoningFeatures) {
        Intrinsics.checkNotNullParameter(poisoningFeatures, "poisoningFeatures");
        this.isInvisible = isInvisible;
        this.poisoningFeatures = poisoningFeatures;
    }

    public /* synthetic */ PreReleaseInfo(boolean bl2, List list, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        this(bl2, list);
    }

    @NotNull
    public String toString() {
        return "PreReleaseInfo(isInvisible=" + this.isInvisible + ", poisoningFeatures=" + this.poisoningFeatures + ')';
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.isInvisible);
        result = result * 31 + ((Object)this.poisoningFeatures).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreReleaseInfo)) {
            return false;
        }
        PreReleaseInfo preReleaseInfo = (PreReleaseInfo)other;
        if (this.isInvisible != preReleaseInfo.isInvisible) {
            return false;
        }
        return Intrinsics.areEqual(this.poisoningFeatures, preReleaseInfo.poisoningFeatures);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

