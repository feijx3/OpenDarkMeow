/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeQualifiers {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final NullabilityQualifier nullability;
    @Nullable
    private final MutabilityQualifier mutability;
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    @NotNull
    private static final JavaTypeQualifiers NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);

    public JavaTypeQualifiers(@Nullable NullabilityQualifier nullability, @Nullable MutabilityQualifier mutability, boolean definitelyNotNull, boolean isNullabilityQualifierForWarning) {
        this.nullability = nullability;
        this.mutability = mutability;
        this.definitelyNotNull = definitelyNotNull;
        this.isNullabilityQualifierForWarning = isNullabilityQualifierForWarning;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean bl2, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            bl3 = false;
        }
        this(nullabilityQualifier, mutabilityQualifier, bl2, bl3);
    }

    @Nullable
    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    @Nullable
    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    @NotNull
    public final JavaTypeQualifiers copy(@Nullable NullabilityQualifier nullability, @Nullable MutabilityQualifier mutability, boolean definitelyNotNull, boolean isNullabilityQualifierForWarning) {
        return new JavaTypeQualifiers(nullability, mutability, definitelyNotNull, isNullabilityQualifierForWarning);
    }

    public static /* synthetic */ JavaTypeQualifiers copy$default(JavaTypeQualifiers javaTypeQualifiers, NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            nullabilityQualifier = javaTypeQualifiers.nullability;
        }
        if ((n2 & 2) != 0) {
            mutabilityQualifier = javaTypeQualifiers.mutability;
        }
        if ((n2 & 4) != 0) {
            bl2 = javaTypeQualifiers.definitelyNotNull;
        }
        if ((n2 & 8) != 0) {
            bl3 = javaTypeQualifiers.isNullabilityQualifierForWarning;
        }
        return javaTypeQualifiers.copy(nullabilityQualifier, mutabilityQualifier, bl2, bl3);
    }

    @NotNull
    public String toString() {
        return "JavaTypeQualifiers(nullability=" + (Object)((Object)this.nullability) + ", mutability=" + (Object)((Object)this.mutability) + ", definitelyNotNull=" + this.definitelyNotNull + ", isNullabilityQualifierForWarning=" + this.isNullabilityQualifierForWarning + ')';
    }

    public int hashCode() {
        int result = this.nullability == null ? 0 : this.nullability.hashCode();
        result = result * 31 + (this.mutability == null ? 0 : this.mutability.hashCode());
        result = result * 31 + Boolean.hashCode(this.definitelyNotNull);
        result = result * 31 + Boolean.hashCode(this.isNullabilityQualifierForWarning);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JavaTypeQualifiers)) {
            return false;
        }
        JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers)other;
        if (this.nullability != javaTypeQualifiers.nullability) {
            return false;
        }
        if (this.mutability != javaTypeQualifiers.mutability) {
            return false;
        }
        if (this.definitelyNotNull != javaTypeQualifiers.definitelyNotNull) {
            return false;
        }
        return this.isNullabilityQualifierForWarning == javaTypeQualifiers.isNullabilityQualifierForWarning;
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final JavaTypeQualifiers getNONE() {
            return NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

