/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimpleClassicTypeSystemContext
implements ClassicTypeSystemContext {
    @NotNull
    public static final SimpleClassicTypeSystemContext INSTANCE = new SimpleClassicTypeSystemContext();

    private SimpleClassicTypeSystemContext() {
    }

    @Override
    public boolean isDenotable(@NotNull TypeConstructorMarker $this$isDenotable) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, $this$isDenotable);
    }

    @Override
    public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker $this$isIntegerLiteralTypeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, $this$isIntegerLiteralTypeConstructor);
    }

    @Override
    @Nullable
    public TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker $this$typeParameter) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, $this$typeParameter);
    }

    @Override
    @NotNull
    public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull RigidTypeMarker $this$possibleIntegerTypes) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, $this$possibleIntegerTypes);
    }

    @Override
    @NotNull
    public SimpleTypeMarker withNullability(@NotNull RigidTypeMarker $this$withNullability, boolean nullable) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext)this, $this$withNullability, nullable);
    }

    @Override
    @NotNull
    public KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker $this$withNullability, boolean nullable) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext)this, $this$withNullability, nullable);
    }

    @Override
    public boolean isError(@NotNull KotlinTypeMarker $this$isError) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, $this$isError);
    }

    @Override
    public boolean isStubType(@NotNull RigidTypeMarker $this$isStubType) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, $this$isStubType);
    }

    @Override
    public boolean isStubTypeForBuilderInference(@NotNull RigidTypeMarker $this$isStubTypeForBuilderInference) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, $this$isStubTypeForBuilderInference);
    }

    @Override
    @Nullable
    public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker $this$lowerType) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, $this$lowerType);
    }

    @Override
    public boolean isIntersection(@NotNull TypeConstructorMarker $this$isIntersection) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, $this$isIntersection);
    }

    @Override
    public boolean identicalArguments(@NotNull RigidTypeMarker a2, @NotNull RigidTypeMarker b2) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, a2, b2);
    }

    @Override
    @Nullable
    public SimpleTypeMarker asRigidType(@NotNull KotlinTypeMarker $this$asRigidType) {
        return ClassicTypeSystemContext.DefaultImpls.asRigidType(this, $this$asRigidType);
    }

    @Override
    @Nullable
    public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker $this$asFlexibleType) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, $this$asFlexibleType);
    }

    @Override
    @Nullable
    public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker $this$asDynamicType) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, $this$asDynamicType);
    }

    @Override
    public boolean isRawType(@NotNull KotlinTypeMarker $this$isRawType) {
        return ClassicTypeSystemContext.DefaultImpls.isRawType(this, $this$isRawType);
    }

    @Override
    @NotNull
    public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker $this$upperBound) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, $this$upperBound);
    }

    @Override
    @NotNull
    public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker $this$lowerBound) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, $this$lowerBound);
    }

    @Override
    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker $this$asCapturedType) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, $this$asCapturedType);
    }

    @Override
    @Nullable
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull RigidTypeMarker $this$asDefinitelyNotNullType) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, $this$asDefinitelyNotNullType);
    }

    @Override
    public boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker $this$isNotNullTypeParameter) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, $this$isNotNullTypeParameter);
    }

    @Override
    public boolean isMarkedNullable(@NotNull KotlinTypeMarker $this$isMarkedNullable) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, $this$isMarkedNullable);
    }

    @Override
    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull RigidTypeMarker $this$typeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext)this, $this$typeConstructor);
    }

    @Override
    @NotNull
    public CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker $this$typeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext)this, $this$typeConstructor);
    }

    @Override
    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker $this$typeConstructor) {
        return this.default$typeConstructor($this$typeConstructor);
    }

    @Override
    @NotNull
    public TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker $this$projection) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, $this$projection);
    }

    @Override
    public int argumentsCount(@NotNull KotlinTypeMarker $this$argumentsCount) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, $this$argumentsCount);
    }

    @Override
    @NotNull
    public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker $this$getArgument, int index) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, $this$getArgument, index);
    }

    @Override
    @NotNull
    public List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker $this$getArguments) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, $this$getArguments);
    }

    @Override
    public boolean isStarProjection(@NotNull TypeArgumentMarker $this$isStarProjection) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, $this$isStarProjection);
    }

    @Override
    @NotNull
    public TypeVariance getVariance(@NotNull TypeArgumentMarker $this$getVariance) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext)this, $this$getVariance);
    }

    @Override
    @NotNull
    public TypeVariance getVariance(@NotNull TypeParameterMarker $this$getVariance) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext)this, $this$getVariance);
    }

    @Override
    @Nullable
    public KotlinTypeMarker getType(@NotNull TypeArgumentMarker $this$getType) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, $this$getType);
    }

    @Override
    public int parametersCount(@NotNull TypeConstructorMarker $this$parametersCount) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, $this$parametersCount);
    }

    @Override
    @NotNull
    public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker $this$getParameter, int index) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, $this$getParameter, index);
    }

    @Override
    @NotNull
    public List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker $this$getParameters) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, $this$getParameters);
    }

    @Override
    @NotNull
    public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker $this$supertypes) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, $this$supertypes);
    }

    @Override
    @NotNull
    public List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker $this$getUpperBounds) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, $this$getUpperBounds);
    }

    @Override
    public boolean hasRecursiveBounds(@NotNull TypeParameterMarker $this$hasRecursiveBounds, @Nullable TypeConstructorMarker selfConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, $this$hasRecursiveBounds, selfConstructor);
    }

    @Override
    public boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker c1, @NotNull TypeConstructorMarker c2) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, c1, c2);
    }

    @Override
    public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker $this$isClassTypeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, $this$isClassTypeConstructor);
    }

    @Override
    public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker $this$isCommonFinalClassConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, $this$isCommonFinalClassConstructor);
    }

    @Override
    @NotNull
    public TypeArgumentListMarker asArgumentList(@NotNull RigidTypeMarker $this$asArgumentList) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, $this$asArgumentList);
    }

    @Override
    @Nullable
    public SimpleType captureFromArguments(@NotNull RigidTypeMarker type, @NotNull CaptureStatus status) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, type, status);
    }

    @Override
    public boolean isAnyConstructor(@NotNull TypeConstructorMarker $this$isAnyConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, $this$isAnyConstructor);
    }

    @Override
    public boolean isNothingConstructor(@NotNull TypeConstructorMarker $this$isNothingConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, $this$isNothingConstructor);
    }

    @Override
    @NotNull
    public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker $this$asTypeArgument) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, $this$asTypeArgument);
    }

    @Override
    public boolean isSingleClassifierType(@NotNull RigidTypeMarker $this$isSingleClassifierType) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, $this$isSingleClassifierType);
    }

    @Override
    @NotNull
    public KotlinTypeMarker intersectTypes(@NotNull Collection<? extends KotlinTypeMarker> types) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, types);
    }

    @Override
    @NotNull
    public KotlinTypeMarker createFlexibleType(@NotNull RigidTypeMarker lowerBound, @NotNull RigidTypeMarker upperBound) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, lowerBound, upperBound);
    }

    @Override
    @NotNull
    public TypeCheckerState newTypeCheckerState(boolean errorTypesEqualToAnything, boolean stubTypesEqualToAnything, boolean dnnTypesEqualToFlexible) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, errorTypesEqualToAnything, stubTypesEqualToAnything, dnnTypesEqualToFlexible);
    }

    @Override
    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull, boolean preserveAttributes) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, $this$makeDefinitelyNotNullOrNotNull, preserveAttributes);
    }

    @Override
    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
        return this.default$makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull);
    }

    @Override
    public boolean isProjectionNotNull(@NotNull CapturedTypeMarker $this$isProjectionNotNull) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, $this$isProjectionNotNull);
    }

    @Override
    @NotNull
    public CaptureStatus captureStatus(@NotNull CapturedTypeMarker $this$captureStatus) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, $this$captureStatus);
    }

    @Override
    public boolean isOldCapturedType(@NotNull CapturedTypeMarker $this$isOldCapturedType) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, $this$isOldCapturedType);
    }

    @Override
    public boolean isNullableType(@NotNull KotlinTypeMarker $this$isNullableType) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, $this$isNullableType);
    }

    @Override
    @NotNull
    public SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker $this$original) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, $this$original);
    }

    @Override
    public boolean isPrimitiveType(@NotNull SimpleTypeMarker $this$isPrimitiveType) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, $this$isPrimitiveType);
    }

    @Override
    public boolean hasAnnotation(@NotNull KotlinTypeMarker $this$hasAnnotation, @NotNull FqName fqName) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, $this$hasAnnotation, fqName);
    }

    @Override
    @Nullable
    public TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker $this$getTypeParameterClassifier) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, $this$getTypeParameterClassifier);
    }

    @Override
    public boolean isInlineClass(@NotNull TypeConstructorMarker $this$isInlineClass) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, $this$isInlineClass);
    }

    @Override
    @NotNull
    public KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker $this$getRepresentativeUpperBound) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, $this$getRepresentativeUpperBound);
    }

    @Override
    @Nullable
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull KotlinTypeMarker $this$getUnsubstitutedUnderlyingType) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, $this$getUnsubstitutedUnderlyingType);
    }

    @Override
    @Nullable
    public PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker $this$getPrimitiveType) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, $this$getPrimitiveType);
    }

    @Override
    @Nullable
    public PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker $this$getPrimitiveArrayType) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, $this$getPrimitiveArrayType);
    }

    @Override
    public boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker $this$isUnderKotlinPackage) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, $this$isUnderKotlinPackage);
    }

    @Override
    @NotNull
    public FqNameUnsafe getClassFqNameUnsafe(@NotNull TypeConstructorMarker $this$getClassFqNameUnsafe) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, $this$getClassFqNameUnsafe);
    }

    @Override
    @NotNull
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull RigidTypeMarker type) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, type);
    }

    @Override
    public boolean isTypeVariableType(@NotNull KotlinTypeMarker $this$isTypeVariableType) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, $this$isTypeVariableType);
    }

    @Override
    public boolean isK2() {
        return ClassicTypeSystemContext.DefaultImpls.isK2(this);
    }

    @Override
    @Nullable
    public CapturedTypeMarker asCapturedTypeUnwrappingDnn(@NotNull RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
        return this.default$asCapturedTypeUnwrappingDnn($this$asCapturedTypeUnwrappingDnn);
    }

    @Override
    public boolean isCapturedType(@NotNull KotlinTypeMarker $this$isCapturedType) {
        return this.default$isCapturedType($this$isCapturedType);
    }

    @Override
    @NotNull
    public SimpleTypeMarker originalIfDefinitelyNotNullable(@NotNull RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
        return this.default$originalIfDefinitelyNotNullable($this$originalIfDefinitelyNotNullable);
    }

    @Override
    @Nullable
    public TypeArgumentMarker getArgumentOrNull(@NotNull RigidTypeMarker $this$getArgumentOrNull, int index) {
        return this.default$getArgumentOrNull($this$getArgumentOrNull, index);
    }

    @Override
    @NotNull
    public RigidTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker $this$lowerBoundIfFlexible) {
        return this.default$lowerBoundIfFlexible($this$lowerBoundIfFlexible);
    }

    @Override
    @NotNull
    public RigidTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker $this$upperBoundIfFlexible) {
        return this.default$upperBoundIfFlexible($this$upperBoundIfFlexible);
    }

    @Override
    public boolean isFlexibleWithDifferentTypeConstructors(@NotNull KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
        return this.default$isFlexibleWithDifferentTypeConstructors($this$isFlexibleWithDifferentTypeConstructors);
    }

    @Override
    public boolean isFlexible(@NotNull KotlinTypeMarker $this$isFlexible) {
        return this.default$isFlexible($this$isFlexible);
    }

    @Override
    public boolean isDynamic(@NotNull KotlinTypeMarker $this$isDynamic) {
        return this.default$isDynamic($this$isDynamic);
    }

    @Override
    public boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker $this$isDefinitelyNotNullType) {
        return this.default$isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    @Override
    public boolean isDefinitelyNotNullType(@NotNull RigidTypeMarker $this$isDefinitelyNotNullType) {
        return this.default$isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    @Override
    public boolean hasFlexibleNullability(@NotNull KotlinTypeMarker $this$hasFlexibleNullability) {
        return this.default$hasFlexibleNullability($this$hasFlexibleNullability);
    }

    @Override
    public boolean isNothing(@NotNull KotlinTypeMarker $this$isNothing) {
        return this.default$isNothing($this$isNothing);
    }

    @Override
    public boolean isClassType(@NotNull RigidTypeMarker $this$isClassType) {
        return this.default$isClassType($this$isClassType);
    }

    @Override
    @Nullable
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull RigidTypeMarker $this$fastCorrespondingSupertypes, @NotNull TypeConstructorMarker constructor) {
        return this.default$fastCorrespondingSupertypes($this$fastCorrespondingSupertypes, constructor);
    }

    @Override
    public boolean isIntegerLiteralType(@NotNull RigidTypeMarker $this$isIntegerLiteralType) {
        return this.default$isIntegerLiteralType($this$isIntegerLiteralType);
    }

    @Override
    @NotNull
    public TypeArgumentMarker get(@NotNull TypeArgumentListMarker $this$get, int index) {
        return this.default$get($this$get, index);
    }

    @Override
    public int size(@NotNull TypeArgumentListMarker $this$size) {
        return this.default$size($this$size);
    }

    @Override
    @NotNull
    public KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker $this$makeNullable) {
        return this.default$makeNullable($this$makeNullable);
    }

    @NotNull
    public KotlinTypeMarker default$makeNullable(KotlinTypeMarker $this$makeNullable) {
        Intrinsics.checkNotNullParameter($this$makeNullable, "<this>");
        RigidTypeMarker rigidTypeMarker = this.asRigidType($this$makeNullable);
        return rigidTypeMarker != null && (rigidTypeMarker = this.withNullability(rigidTypeMarker, true)) != null ? (KotlinTypeMarker)rigidTypeMarker : $this$makeNullable;
    }

    @Nullable
    public CapturedTypeMarker default$asCapturedTypeUnwrappingDnn(RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
        Intrinsics.checkNotNullParameter($this$asCapturedTypeUnwrappingDnn, "<this>");
        return this.asCapturedType(this.originalIfDefinitelyNotNullable($this$asCapturedTypeUnwrappingDnn));
    }

    public boolean default$isCapturedType(KotlinTypeMarker $this$isCapturedType) {
        Intrinsics.checkNotNullParameter($this$isCapturedType, "<this>");
        RigidTypeMarker rigidTypeMarker = this.asRigidType($this$isCapturedType);
        return (rigidTypeMarker != null ? this.asCapturedTypeUnwrappingDnn(rigidTypeMarker) : null) != null;
    }

    @NotNull
    public SimpleTypeMarker default$originalIfDefinitelyNotNullable(RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
        Intrinsics.checkNotNullParameter($this$originalIfDefinitelyNotNullable, "<this>");
        RigidTypeMarker rigidTypeMarker = this.asDefinitelyNotNullType($this$originalIfDefinitelyNotNullable);
        if (rigidTypeMarker == null || (rigidTypeMarker = this.original((DefinitelyNotNullTypeMarker)rigidTypeMarker)) == null) {
            rigidTypeMarker = (SimpleTypeMarker)$this$originalIfDefinitelyNotNullable;
        }
        return rigidTypeMarker;
    }

    @NotNull
    public KotlinTypeMarker default$makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
        Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
        return this.makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull, false);
    }

    @Nullable
    public TypeArgumentMarker default$getArgumentOrNull(RigidTypeMarker $this$getArgumentOrNull, int index) {
        Intrinsics.checkNotNullParameter($this$getArgumentOrNull, "<this>");
        boolean bl2 = 0 <= index ? index < this.argumentsCount($this$getArgumentOrNull) : false;
        if (bl2) {
            return this.getArgument($this$getArgumentOrNull, index);
        }
        return null;
    }

    @NotNull
    public RigidTypeMarker default$lowerBoundIfFlexible(KotlinTypeMarker $this$lowerBoundIfFlexible) {
        Intrinsics.checkNotNullParameter($this$lowerBoundIfFlexible, "<this>");
        KotlinTypeMarker kotlinTypeMarker = this.asFlexibleType($this$lowerBoundIfFlexible);
        if (kotlinTypeMarker == null || (kotlinTypeMarker = this.lowerBound((FlexibleTypeMarker)kotlinTypeMarker)) == null) {
            RigidTypeMarker rigidTypeMarker = this.asRigidType($this$lowerBoundIfFlexible);
            kotlinTypeMarker = rigidTypeMarker;
            Intrinsics.checkNotNull(rigidTypeMarker);
        }
        return kotlinTypeMarker;
    }

    @NotNull
    public RigidTypeMarker default$upperBoundIfFlexible(KotlinTypeMarker $this$upperBoundIfFlexible) {
        Intrinsics.checkNotNullParameter($this$upperBoundIfFlexible, "<this>");
        KotlinTypeMarker kotlinTypeMarker = this.asFlexibleType($this$upperBoundIfFlexible);
        if (kotlinTypeMarker == null || (kotlinTypeMarker = this.upperBound((FlexibleTypeMarker)kotlinTypeMarker)) == null) {
            RigidTypeMarker rigidTypeMarker = this.asRigidType($this$upperBoundIfFlexible);
            kotlinTypeMarker = rigidTypeMarker;
            Intrinsics.checkNotNull(rigidTypeMarker);
        }
        return kotlinTypeMarker;
    }

    public boolean default$isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
        Intrinsics.checkNotNullParameter($this$isFlexibleWithDifferentTypeConstructors, "<this>");
        return !Intrinsics.areEqual(this.typeConstructor(this.lowerBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)), this.typeConstructor(this.upperBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)));
    }

    public boolean default$isFlexible(KotlinTypeMarker $this$isFlexible) {
        Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
        return this.asFlexibleType($this$isFlexible) != null;
    }

    public boolean default$isDynamic(KotlinTypeMarker $this$isDynamic) {
        Intrinsics.checkNotNullParameter($this$isDynamic, "<this>");
        FlexibleTypeMarker flexibleTypeMarker = this.asFlexibleType($this$isDynamic);
        return (flexibleTypeMarker != null ? this.asDynamicType(flexibleTypeMarker) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(KotlinTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        RigidTypeMarker rigidTypeMarker = this.asRigidType($this$isDefinitelyNotNullType);
        return (rigidTypeMarker != null ? this.asDefinitelyNotNullType(rigidTypeMarker) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(RigidTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return this.asDefinitelyNotNullType($this$isDefinitelyNotNullType) != null;
    }

    public boolean default$hasFlexibleNullability(KotlinTypeMarker $this$hasFlexibleNullability) {
        Intrinsics.checkNotNullParameter($this$hasFlexibleNullability, "<this>");
        return this.isMarkedNullable(this.lowerBoundIfFlexible($this$hasFlexibleNullability)) != this.isMarkedNullable(this.upperBoundIfFlexible($this$hasFlexibleNullability));
    }

    @NotNull
    public TypeConstructorMarker default$typeConstructor(KotlinTypeMarker $this$typeConstructor) {
        Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
        RigidTypeMarker rigidTypeMarker = this.asRigidType($this$typeConstructor);
        if (rigidTypeMarker == null) {
            rigidTypeMarker = this.lowerBoundIfFlexible($this$typeConstructor);
        }
        return this.typeConstructor(rigidTypeMarker);
    }

    public boolean default$isNothing(KotlinTypeMarker $this$isNothing) {
        Intrinsics.checkNotNullParameter($this$isNothing, "<this>");
        return this.isNothingConstructor(this.typeConstructor($this$isNothing)) && !this.isNullableType($this$isNothing);
    }

    public boolean default$isClassType(RigidTypeMarker $this$isClassType) {
        Intrinsics.checkNotNullParameter($this$isClassType, "<this>");
        return this.isClassTypeConstructor(this.typeConstructor($this$isClassType));
    }

    @Nullable
    public List<SimpleTypeMarker> default$fastCorrespondingSupertypes(RigidTypeMarker $this$fastCorrespondingSupertypes, TypeConstructorMarker constructor) {
        Intrinsics.checkNotNullParameter($this$fastCorrespondingSupertypes, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return null;
    }

    public boolean default$isIntegerLiteralType(RigidTypeMarker $this$isIntegerLiteralType) {
        Intrinsics.checkNotNullParameter($this$isIntegerLiteralType, "<this>");
        return this.isIntegerLiteralTypeConstructor(this.typeConstructor($this$isIntegerLiteralType));
    }

    @NotNull
    public TypeArgumentMarker default$get(TypeArgumentListMarker $this$get, int index) {
        TypeArgumentMarker typeArgumentMarker;
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        TypeArgumentListMarker typeArgumentListMarker = $this$get;
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            typeArgumentMarker = this.getArgument((KotlinTypeMarker)((Object)$this$get), index);
        } else if (typeArgumentListMarker instanceof ArgumentList) {
            Object e2 = ((ArgumentList)$this$get).get(index);
            Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
            typeArgumentMarker = (TypeArgumentMarker)e2;
        } else {
            throw new IllegalStateException(("unknown type argument list type: " + $this$get + ", " + Reflection.getOrCreateKotlinClass($this$get.getClass())).toString());
        }
        return typeArgumentMarker;
    }

    public int default$size(TypeArgumentListMarker $this$size) {
        int n2;
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        TypeArgumentListMarker typeArgumentListMarker = $this$size;
        if (typeArgumentListMarker instanceof RigidTypeMarker) {
            n2 = this.argumentsCount((KotlinTypeMarker)((Object)$this$size));
        } else if (typeArgumentListMarker instanceof ArgumentList) {
            n2 = ((ArgumentList)$this$size).size();
        } else {
            throw new IllegalStateException(("unknown type argument list type: " + $this$size + ", " + Reflection.getOrCreateKotlinClass($this$size.getClass())).toString());
        }
        return n2;
    }
}

