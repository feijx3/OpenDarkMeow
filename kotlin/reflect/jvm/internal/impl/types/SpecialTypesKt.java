/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nSpecialTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n+ 2 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n102#2,2:217\n104#2,6:222\n112#2,7:229\n1563#3:219\n1634#3,2:220\n1636#3:228\n*S KotlinDebug\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n*L\n214#1:217,2\n214#1:222,6\n214#1:229,7\n214#1:219\n214#1:220,2\n214#1:228\n*E\n"})
public final class SpecialTypesKt {
    @Nullable
    public static final AbbreviatedType getAbbreviatedType(@NotNull KotlinType $this$getAbbreviatedType) {
        Intrinsics.checkNotNullParameter($this$getAbbreviatedType, "<this>");
        UnwrappedType unwrappedType = $this$getAbbreviatedType.unwrap();
        return unwrappedType instanceof AbbreviatedType ? (AbbreviatedType)unwrappedType : null;
    }

    @Nullable
    public static final SimpleType getAbbreviation(@NotNull KotlinType $this$getAbbreviation) {
        Intrinsics.checkNotNullParameter($this$getAbbreviation, "<this>");
        AbbreviatedType abbreviatedType = SpecialTypesKt.getAbbreviatedType($this$getAbbreviation);
        return abbreviatedType != null ? abbreviatedType.getAbbreviation() : null;
    }

    @NotNull
    public static final SimpleType withAbbreviation(@NotNull SimpleType $this$withAbbreviation, @NotNull SimpleType abbreviatedType) {
        Intrinsics.checkNotNullParameter($this$withAbbreviation, "<this>");
        Intrinsics.checkNotNullParameter(abbreviatedType, "abbreviatedType");
        if (KotlinTypeKt.isError($this$withAbbreviation)) {
            return $this$withAbbreviation;
        }
        return new AbbreviatedType($this$withAbbreviation, abbreviatedType);
    }

    public static final boolean isDefinitelyNotNullType(@NotNull KotlinType $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return $this$isDefinitelyNotNullType.unwrap() instanceof DefinitelyNotNullType;
    }

    @NotNull
    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(@NotNull SimpleType $this$makeSimpleTypeDefinitelyNotNullOrNotNull, boolean useCorrectedNullabilityForTypeParameters) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter($this$makeSimpleTypeDefinitelyNotNullOrNotNull, "<this>");
        DefinitelyNotNullType definitelyNotNullType = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, $this$makeSimpleTypeDefinitelyNotNullOrNotNull, useCorrectedNullabilityForTypeParameters, false, 4, null);
        if (definitelyNotNullType != null) {
            simpleType = definitelyNotNullType;
        } else {
            simpleType = SpecialTypesKt.makeIntersectionTypeDefinitelyNotNullOrNotNull($this$makeSimpleTypeDefinitelyNotNullOrNotNull);
            if (simpleType == null) {
                simpleType = $this$makeSimpleTypeDefinitelyNotNullOrNotNull.makeNullableAsSpecified(false);
            }
        }
        return simpleType;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType simpleType, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, bl2);
    }

    @NotNull
    public static final NewCapturedType withNotNullProjection(@NotNull NewCapturedType $this$withNotNullProjection) {
        Intrinsics.checkNotNullParameter($this$withNotNullProjection, "<this>");
        return new NewCapturedType($this$withNotNullProjection.getCaptureStatus(), $this$withNotNullProjection.getConstructor(), $this$withNotNullProjection.getLowerType(), $this$withNotNullProjection.getAttributes(), $this$withNotNullProjection.isMarkedNullable(), true);
    }

    @NotNull
    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(@NotNull UnwrappedType $this$makeDefinitelyNotNullOrNotNull, boolean useCorrectedNullabilityForTypeParameters) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
        DefinitelyNotNullType definitelyNotNullType = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, $this$makeDefinitelyNotNullOrNotNull, useCorrectedNullabilityForTypeParameters, false, 4, null);
        if (definitelyNotNullType != null) {
            unwrappedType = definitelyNotNullType;
        } else {
            SimpleType simpleType = SpecialTypesKt.makeIntersectionTypeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull);
            unwrappedType = simpleType != null ? (UnwrappedType)simpleType : $this$makeDefinitelyNotNullOrNotNull.makeNullableAsSpecified(false);
        }
        return unwrappedType;
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(unwrappedType, bl2);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType $this$makeIntersectionTypeDefinitelyNotNullOrNotNull) {
        TypeConstructor typeConstructor2 = $this$makeIntersectionTypeDefinitelyNotNullOrNotNull.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = typeConstructor2 instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor)typeConstructor2 : null;
        if (intersectionTypeConstructor == null) {
            return null;
        }
        IntersectionTypeConstructor typeConstructor3 = intersectionTypeConstructor;
        IntersectionTypeConstructor intersectionTypeConstructor2 = SpecialTypesKt.makeDefinitelyNotNullOrNotNull(typeConstructor3);
        if (intersectionTypeConstructor2 == null) {
            return null;
        }
        IntersectionTypeConstructor definitelyNotNullConstructor = intersectionTypeConstructor2;
        return definitelyNotNullConstructor.createType();
    }

    /*
     * WARNING - void declaration
     */
    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor $this$makeDefinitelyNotNullOrNotNull) {
        IntersectionTypeConstructor intersectionTypeConstructor;
        boolean bl2;
        boolean bl3;
        KotlinType it;
        void $this$mapTo$iv$iv$iv;
        IntersectionTypeConstructor $this$transformComponents$iv = $this$makeDefinitelyNotNullOrNotNull;
        boolean $i$f$transformComponents = false;
        boolean changed$iv = false;
        Iterable $this$map$iv$iv = $this$transformComponents$iv.getSupertypes();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
            KotlinType kotlinType;
            void it$iv;
            KotlinType kotlinType2 = (KotlinType)item$iv$iv$iv;
            Collection collection = destination$iv$iv$iv;
            boolean bl4 = false;
            it = it$iv;
            bl3 = false;
            if (TypeUtils.isNullableType(it)) {
                changed$iv = true;
                it = it$iv;
                bl2 = false;
                kotlinType = SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(it.unwrap(), false, 1, null);
            } else {
                kotlinType = it$iv;
            }
            collection.add(kotlinType);
        }
        List newSupertypes$iv = (List)destination$iv$iv$iv;
        if (!changed$iv) {
            intersectionTypeConstructor = null;
        } else {
            KotlinType kotlinType;
            KotlinType kotlinType3 = $this$transformComponents$iv.getAlternativeType();
            if (kotlinType3 != null) {
                KotlinType alternative$iv = kotlinType3;
                boolean bl5 = false;
                it = alternative$iv;
                bl3 = false;
                if (TypeUtils.isNullableType(it)) {
                    it = alternative$iv;
                    bl2 = false;
                    kotlinType = SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(it.unwrap(), false, 1, null);
                } else {
                    kotlinType = alternative$iv;
                }
            } else {
                kotlinType = null;
            }
            KotlinType updatedAlternative$iv = kotlinType;
            intersectionTypeConstructor = new IntersectionTypeConstructor(newSupertypes$iv).setAlternative(updatedAlternative$iv);
        }
        return intersectionTypeConstructor;
    }
}

