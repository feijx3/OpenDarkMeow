/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nErasureTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasureTypeAttributes.kt\norg/jetbrains/kotlin/types/ErasureTypeAttributes\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public class ErasureTypeAttributes {
    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;
    @Nullable
    private final SimpleType defaultType;

    public ErasureTypeAttributes(@NotNull TypeUsage howThisTypeIsUsed, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters, @Nullable SimpleType defaultType) {
        Intrinsics.checkNotNullParameter((Object)howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = visitedTypeParameters;
        this.defaultType = defaultType;
    }

    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Nullable
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Nullable
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public ErasureTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameter) {
        Set<TypeParameterDescriptor> set;
        TypeUsage typeUsage;
        block3: {
            block2: {
                void it;
                Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
                typeUsage = this.getHowThisTypeIsUsed();
                set = this.getVisitedTypeParameters();
                if (set == null) break block2;
                Set<TypeParameterDescriptor> set2 = set;
                TypeUsage typeUsage2 = typeUsage;
                boolean bl2 = false;
                Set<TypeParameterDescriptor> set3 = SetsKt.plus(it, typeParameter);
                typeUsage = typeUsage2;
                set = set3;
                if (set3 != null) break block3;
            }
            set = SetsKt.setOf(typeParameter);
        }
        SimpleType simpleType = this.getDefaultType();
        Set<TypeParameterDescriptor> set4 = set;
        TypeUsage typeUsage3 = typeUsage;
        return new ErasureTypeAttributes(typeUsage3, set4, simpleType);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ErasureTypeAttributes)) {
            return false;
        }
        return Intrinsics.areEqual(((ErasureTypeAttributes)other).getDefaultType(), this.getDefaultType()) && ((ErasureTypeAttributes)other).getHowThisTypeIsUsed() == this.getHowThisTypeIsUsed();
    }

    public int hashCode() {
        SimpleType simpleType = this.getDefaultType();
        int result = simpleType != null ? ((Object)simpleType).hashCode() : 0;
        result += 31 * result + this.getHowThisTypeIsUsed().hashCode();
        return result;
    }
}

