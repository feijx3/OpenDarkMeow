/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityQualifierWithMigrationStatus {
    @NotNull
    private final NullabilityQualifier qualifier;
    private final boolean isForWarningOnly;

    public NullabilityQualifierWithMigrationStatus(@NotNull NullabilityQualifier qualifier, boolean isForWarningOnly) {
        Intrinsics.checkNotNullParameter((Object)qualifier, "qualifier");
        this.qualifier = qualifier;
        this.isForWarningOnly = isForWarningOnly;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(nullabilityQualifier, bl2);
    }

    @NotNull
    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus copy(@NotNull NullabilityQualifier qualifier, boolean isForWarningOnly) {
        Intrinsics.checkNotNullParameter((Object)qualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(qualifier, isForWarningOnly);
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.qualifier;
        }
        if ((n2 & 2) != 0) {
            bl2 = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, bl2);
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + (Object)((Object)this.qualifier) + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }

    public int hashCode() {
        int result = this.qualifier.hashCode();
        result = result * 31 + Boolean.hashCode(this.isForWarningOnly);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus)other;
        if (this.qualifier != nullabilityQualifierWithMigrationStatus.qualifier) {
            return false;
        }
        return this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly;
    }
}

