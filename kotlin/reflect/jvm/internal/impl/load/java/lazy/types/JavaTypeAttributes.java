/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeAttributes
extends ErasureTypeAttributes {
    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    @NotNull
    private final JavaTypeFlexibility flexibility;
    private final boolean isRaw;
    private final boolean isForAnnotationParameter;
    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;
    @Nullable
    private final SimpleType defaultType;

    public JavaTypeAttributes(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean isRaw, boolean isForAnnotationParameter, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters, @Nullable SimpleType defaultType) {
        Intrinsics.checkNotNullParameter((Object)howThisTypeIsUsed, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter((Object)flexibility, "flexibility");
        super(howThisTypeIsUsed, visitedTypeParameters, defaultType);
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.flexibility = flexibility;
        this.isRaw = isRaw;
        this.isForAnnotationParameter = isForAnnotationParameter;
        this.visitedTypeParameters = visitedTypeParameters;
        this.defaultType = defaultType;
    }

    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean bl2, boolean bl3, Set set, SimpleType simpleType, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            javaTypeFlexibility = JavaTypeFlexibility.INFLEXIBLE;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            bl3 = false;
        }
        if ((n2 & 0x10) != 0) {
            set = null;
        }
        if ((n2 & 0x20) != 0) {
            simpleType = null;
        }
        this(typeUsage, javaTypeFlexibility, bl2, bl3, set, simpleType);
    }

    @Override
    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @NotNull
    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @Override
    @Nullable
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Override
    @Nullable
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    @NotNull
    public final JavaTypeAttributes withFlexibility(@NotNull JavaTypeFlexibility flexibility) {
        Intrinsics.checkNotNullParameter((Object)flexibility, "flexibility");
        return JavaTypeAttributes.copy$default(this, null, flexibility, false, false, null, null, 61, null);
    }

    @NotNull
    public final JavaTypeAttributes markIsRaw(boolean isRaw) {
        return JavaTypeAttributes.copy$default(this, null, null, isRaw, false, null, null, 59, null);
    }

    @NotNull
    public JavaTypeAttributes withDefaultType(@Nullable SimpleType type) {
        return JavaTypeAttributes.copy$default(this, null, null, false, false, null, type, 31, null);
    }

    @Override
    @NotNull
    public JavaTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return JavaTypeAttributes.copy$default(this, null, null, false, false, this.getVisitedTypeParameters() != null ? SetsKt.plus(this.getVisitedTypeParameters(), typeParameter) : SetsKt.setOf(typeParameter), null, 47, null);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof JavaTypeAttributes)) {
            return false;
        }
        return Intrinsics.areEqual(((JavaTypeAttributes)other).getDefaultType(), this.getDefaultType()) && ((JavaTypeAttributes)other).getHowThisTypeIsUsed() == this.getHowThisTypeIsUsed() && ((JavaTypeAttributes)other).flexibility == this.flexibility && ((JavaTypeAttributes)other).isRaw == this.isRaw && ((JavaTypeAttributes)other).isForAnnotationParameter == this.isForAnnotationParameter;
    }

    @Override
    public int hashCode() {
        SimpleType simpleType = this.getDefaultType();
        int result = simpleType != null ? ((Object)simpleType).hashCode() : 0;
        result += 31 * result + this.getHowThisTypeIsUsed().hashCode();
        result += 31 * result + this.flexibility.hashCode();
        result += 31 * result + (this.isRaw ? 1 : 0);
        result += 31 * result + (this.isForAnnotationParameter ? 1 : 0);
        return result;
    }

    @NotNull
    public final JavaTypeAttributes copy(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean isRaw, boolean isForAnnotationParameter, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters, @Nullable SimpleType defaultType) {
        Intrinsics.checkNotNullParameter((Object)howThisTypeIsUsed, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter((Object)flexibility, "flexibility");
        return new JavaTypeAttributes(howThisTypeIsUsed, flexibility, isRaw, isForAnnotationParameter, visitedTypeParameters, defaultType);
    }

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean bl2, boolean bl3, Set set, SimpleType simpleType, int n2, Object object) {
        if ((n2 & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((n2 & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        if ((n2 & 4) != 0) {
            bl2 = javaTypeAttributes.isRaw;
        }
        if ((n2 & 8) != 0) {
            bl3 = javaTypeAttributes.isForAnnotationParameter;
        }
        if ((n2 & 0x10) != 0) {
            set = javaTypeAttributes.visitedTypeParameters;
        }
        if ((n2 & 0x20) != 0) {
            simpleType = javaTypeAttributes.defaultType;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility, bl2, bl3, set, simpleType);
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + (Object)((Object)this.howThisTypeIsUsed) + ", flexibility=" + (Object)((Object)this.flexibility) + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }
}

