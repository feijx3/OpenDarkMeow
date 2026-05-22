/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nCapturedTypeApproximation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1761#2,3:179\n1563#2:183\n1634#2,3:184\n1#3:182\n*S KotlinDebug\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n*L\n158#1:179,3\n167#1:183\n167#1:184,3\n*E\n"})
public final class CapturedTypeApproximationKt {
    private static final TypeProjection toTypeProjection(TypeArgument $this$toTypeProjection) {
        boolean bl2 = $this$toTypeProjection.isConsistent();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl3 = false;
            DescriptorRenderer descriptorRenderer = DescriptorRenderer.Companion.withOptions(CapturedTypeApproximationKt$$Lambda$0.INSTANCE);
            String string = "Only consistent enhanced type projection can be converted to type projection, but [" + descriptorRenderer.render($this$toTypeProjection.getTypeParameter()) + ": <" + descriptorRenderer.renderType($this$toTypeProjection.getInProjection()) + ", " + descriptorRenderer.renderType($this$toTypeProjection.getOutProjection()) + ">] was found";
            throw new AssertionError((Object)string);
        }
        return Intrinsics.areEqual($this$toTypeProjection.getInProjection(), $this$toTypeProjection.getOutProjection()) || $this$toTypeProjection.getTypeParameter().getVariance() == Variance.IN_VARIANCE ? (TypeProjection)new TypeProjectionImpl($this$toTypeProjection.getInProjection()) : (KotlinBuiltIns.isNothing($this$toTypeProjection.getInProjection()) && $this$toTypeProjection.getTypeParameter().getVariance() != Variance.IN_VARIANCE ? (TypeProjection)new TypeProjectionImpl(CapturedTypeApproximationKt.toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.OUT_VARIANCE), $this$toTypeProjection.getOutProjection()) : (KotlinBuiltIns.isNullableAny($this$toTypeProjection.getOutProjection()) ? (TypeProjection)new TypeProjectionImpl(CapturedTypeApproximationKt.toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.IN_VARIANCE), $this$toTypeProjection.getInProjection()) : (TypeProjection)new TypeProjectionImpl(CapturedTypeApproximationKt.toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.OUT_VARIANCE), $this$toTypeProjection.getOutProjection())));
    }

    private static final TypeArgument toTypeArgument(TypeProjection $this$toTypeArgument, TypeParameterDescriptor typeParameter) {
        TypeArgument typeArgument;
        switch (WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameter.getVariance(), $this$toTypeArgument).ordinal()]) {
            case 1: {
                KotlinType kotlinType = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                KotlinType kotlinType2 = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
                typeArgument = new TypeArgument(typeParameter, kotlinType, kotlinType2);
                break;
            }
            case 2: {
                KotlinType kotlinType = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                SimpleType simpleType = DescriptorUtilsKt.getBuiltIns(typeParameter).getNullableAnyType();
                Intrinsics.checkNotNullExpressionValue(simpleType, "getNullableAnyType(...)");
                typeArgument = new TypeArgument(typeParameter, kotlinType, simpleType);
                break;
            }
            case 3: {
                SimpleType simpleType = DescriptorUtilsKt.getBuiltIns(typeParameter).getNothingType();
                Intrinsics.checkNotNullExpressionValue(simpleType, "getNothingType(...)");
                KotlinType kotlinType = simpleType;
                KotlinType kotlinType3 = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType3, "getType(...)");
                typeArgument = new TypeArgument(typeParameter, kotlinType, kotlinType3);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return typeArgument;
    }

    @Nullable
    public static final TypeProjection approximateCapturedTypesIfNecessary(@Nullable TypeProjection typeProjection, boolean approximateContravariant) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType kotlinType = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        KotlinType type = kotlinType;
        if (!TypeUtils.contains(type, CapturedTypeApproximationKt$$Lambda$1.INSTANCE)) {
            return typeProjection;
        }
        Variance variance = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue((Object)variance, "getProjectionKind(...)");
        Variance howThisTypeIsUsed = variance;
        if (howThisTypeIsUsed == Variance.OUT_VARIANCE) {
            ApproximationBounds<KotlinType> approximation = CapturedTypeApproximationKt.approximateCapturedTypes(type);
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation.getUpper());
        }
        if (approximateContravariant) {
            KotlinType approximation = CapturedTypeApproximationKt.approximateCapturedTypes(type).getLower();
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation);
        }
        return CapturedTypeApproximationKt.substituteCapturedTypesWithProjections(typeProjection);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(new TypeConstructorSubstitution(){

            public TypeProjection get(TypeConstructor key) {
                Intrinsics.checkNotNullParameter(key, "key");
                CapturedTypeConstructor capturedTypeConstructor = key instanceof CapturedTypeConstructor ? (CapturedTypeConstructor)key : null;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                CapturedTypeConstructor capturedTypeConstructor2 = capturedTypeConstructor;
                if (capturedTypeConstructor2.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor2.getProjection().getType());
                }
                return capturedTypeConstructor2.getProjection();
            }
        });
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor2, "create(...)");
        TypeSubstitutor typeSubstitutor3 = typeSubstitutor2;
        return typeSubstitutor3.substituteWithoutApproximation(typeProjection);
    }

    @NotNull
    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(@NotNull KotlinType type) {
        KotlinType kotlinType;
        boolean lowerBoundIsTrivial;
        ArrayList<TypeArgument> upperBoundArguments;
        ArrayList<TypeArgument> lowerBoundArguments;
        block14: {
            boolean bl2;
            Intrinsics.checkNotNullParameter(type, "type");
            if (FlexibleTypesKt.isFlexible(type)) {
                ApproximationBounds<KotlinType> boundsForFlexibleLower = CapturedTypeApproximationKt.approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(type));
                ApproximationBounds<KotlinType> boundsForFlexibleUpper = CapturedTypeApproximationKt.approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(type));
                return new ApproximationBounds<KotlinType>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getLower()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getLower())), type), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getUpper()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getUpper())), type));
            }
            TypeConstructor typeConstructor2 = type.getConstructor();
            if (CapturedTypeConstructorKt.isCaptured(type)) {
                ApproximationBounds<KotlinType> approximationBounds;
                Intrinsics.checkNotNull(typeConstructor2, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
                TypeProjection typeProjection = ((CapturedTypeConstructor)typeConstructor2).getProjection();
                KotlinType kotlinType2 = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
                KotlinType bound = CapturedTypeApproximationKt.approximateCapturedTypes$makeNullableIfNeeded(kotlinType2, type);
                switch (WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()]) {
                    case 2: {
                        approximationBounds = new ApproximationBounds<KotlinType>(bound, TypeUtilsKt.getBuiltIns(type).getNullableAnyType());
                        break;
                    }
                    case 3: {
                        SimpleType simpleType = TypeUtilsKt.getBuiltIns(type).getNothingType();
                        Intrinsics.checkNotNullExpressionValue(simpleType, "getNothingType(...)");
                        approximationBounds = new ApproximationBounds<KotlinType>(CapturedTypeApproximationKt.approximateCapturedTypes$makeNullableIfNeeded(simpleType, type), bound);
                        break;
                    }
                    default: {
                        throw new AssertionError((Object)("Only nontrivial projections should have been captured, not: " + typeProjection));
                    }
                }
                return approximationBounds;
            }
            if (type.getArguments().isEmpty() || type.getArguments().size() != typeConstructor2.getParameters().size()) {
                return new ApproximationBounds<KotlinType>(type, type);
            }
            lowerBoundArguments = new ArrayList<TypeArgument>();
            upperBoundArguments = new ArrayList<TypeArgument>();
            Iterable iterable = type.getArguments();
            List<TypeParameterDescriptor> list = typeConstructor2.getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            for (Pair pair : CollectionsKt.zip(iterable, (Iterable)list)) {
                boolean bl3;
                TypeProjection typeProjection = (TypeProjection)pair.component1();
                TypeParameterDescriptor typeParameter = (TypeParameterDescriptor)pair.component2();
                Intrinsics.checkNotNull(typeParameter);
                TypeArgument typeArgument = CapturedTypeApproximationKt.toTypeArgument(typeProjection, typeParameter);
                if (typeProjection.isStarProjection()) {
                    lowerBoundArguments.add(typeArgument);
                    bl3 = upperBoundArguments.add(typeArgument);
                    continue;
                }
                ApproximationBounds<TypeArgument> approximationBounds = CapturedTypeApproximationKt.approximateProjection(typeArgument);
                TypeArgument lower = approximationBounds.component1();
                TypeArgument upper = approximationBounds.component2();
                lowerBoundArguments.add(lower);
                bl3 = upperBoundArguments.add(upper);
            }
            Iterable $this$any$iv = lowerBoundArguments;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    TypeArgument it = (TypeArgument)element$iv;
                    boolean bl4 = false;
                    if (!(!it.isConsistent())) continue;
                    bl2 = true;
                    break block14;
                }
                bl2 = lowerBoundIsTrivial = false;
            }
        }
        if (lowerBoundIsTrivial) {
            SimpleType simpleType = TypeUtilsKt.getBuiltIns(type).getNothingType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getNothingType(...)");
            kotlinType = simpleType;
        } else {
            kotlinType = CapturedTypeApproximationKt.replaceTypeArguments(type, (List<TypeArgument>)lowerBoundArguments);
        }
        return new ApproximationBounds<KotlinType>(kotlinType, CapturedTypeApproximationKt.replaceTypeArguments(type, (List<TypeArgument>)upperBoundArguments));
    }

    /*
     * WARNING - void declaration
     */
    private static final KotlinType replaceTypeArguments(KotlinType $this$replaceTypeArguments, List<TypeArgument> newTypeArguments) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        boolean bl2;
        boolean bl3 = bl2 = $this$replaceTypeArguments.getArguments().size() == newTypeArguments.size();
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-CapturedTypeApproximationKt$replaceTypeArguments$22 = false;
            String $i$a$-assert-CapturedTypeApproximationKt$replaceTypeArguments$22 = "Incorrect type arguments " + newTypeArguments;
            throw new AssertionError((Object)$i$a$-assert-CapturedTypeApproximationKt$replaceTypeArguments$22);
        }
        Iterable iterable = newTypeArguments;
        KotlinType kotlinType = $this$replaceTypeArguments;
        boolean $i$f$map = false;
        void var4_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            TypeArgument typeArgument = (TypeArgument)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(CapturedTypeApproximationKt.toTypeProjection((TypeArgument)it));
        }
        return TypeSubstitutionKt.replace$default(kotlinType, (List)destination$iv$iv, null, null, 6, null);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximationBounds = CapturedTypeApproximationKt.approximateCapturedTypes(typeArgument.getInProjection());
        KotlinType inLower = approximationBounds.component1();
        KotlinType inUpper = approximationBounds.component2();
        ApproximationBounds<KotlinType> approximationBounds2 = CapturedTypeApproximationKt.approximateCapturedTypes(typeArgument.getOutProjection());
        KotlinType outLower = approximationBounds2.component1();
        KotlinType outUpper = approximationBounds2.component2();
        return new ApproximationBounds<TypeArgument>(new TypeArgument(typeArgument.getTypeParameter(), inUpper, outLower), new TypeArgument(typeArgument.getTypeParameter(), inLower, outUpper));
    }

    private static final Unit toTypeProjection$lambda$1$lambda$0(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument $this_toTypeProjection, Variance variance) {
        return variance == $this_toTypeProjection.getTypeParameter().getVariance() ? Variance.INVARIANT : variance;
    }

    private static final Boolean approximateCapturedTypesIfNecessary$lambda$2(UnwrappedType it) {
        Intrinsics.checkNotNull(it);
        return CapturedTypeConstructorKt.isCaptured(it);
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType $this$approximateCapturedTypes_u24makeNullableIfNeeded, KotlinType $type) {
        KotlinType kotlinType = TypeUtils.makeNullableIfNeeded($this$approximateCapturedTypes_u24makeNullableIfNeeded, $type.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNullableIfNeeded(...)");
        return kotlinType;
    }

    static /* synthetic */ Unit accessor$CapturedTypeApproximationKt$lambda0(DescriptorRendererOptions descriptorRendererOptions) {
        return CapturedTypeApproximationKt.toTypeProjection$lambda$1$lambda$0(descriptorRendererOptions);
    }

    static /* synthetic */ Boolean accessor$CapturedTypeApproximationKt$lambda1(UnwrappedType unwrappedType) {
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary$lambda$2(unwrappedType);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Variance.values().length];
            try {
                nArray[Variance.INVARIANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.IN_VARIANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.OUT_VARIANCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

