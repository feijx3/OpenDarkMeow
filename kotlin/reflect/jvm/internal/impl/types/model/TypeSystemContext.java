/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
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
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeSystemContext
extends TypeSystemOptimizationContext {
    @Nullable
    public RigidTypeMarker asRigidType(@NotNull KotlinTypeMarker var1);

    @Nullable
    public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker var1);

    public boolean isError(@NotNull KotlinTypeMarker var1);

    @Nullable
    public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker var1);

    public boolean isRawType(@NotNull KotlinTypeMarker var1);

    @NotNull
    public RigidTypeMarker upperBound(@NotNull FlexibleTypeMarker var1);

    @NotNull
    public RigidTypeMarker lowerBound(@NotNull FlexibleTypeMarker var1);

    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker var1);

    @Nullable
    public CapturedTypeMarker asCapturedTypeUnwrappingDnn(@NotNull RigidTypeMarker var1);

    public boolean isCapturedType(@NotNull KotlinTypeMarker var1);

    @Nullable
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull RigidTypeMarker var1);

    @NotNull
    public SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker var1);

    @NotNull
    public SimpleTypeMarker originalIfDefinitelyNotNullable(@NotNull RigidTypeMarker var1);

    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker var1);

    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker var1, boolean var2);

    public boolean isMarkedNullable(@NotNull KotlinTypeMarker var1);

    @NotNull
    public RigidTypeMarker withNullability(@NotNull RigidTypeMarker var1, boolean var2);

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull RigidTypeMarker var1);

    @NotNull
    public KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker var1, boolean var2);

    public boolean isOldCapturedType(@NotNull CapturedTypeMarker var1);

    @NotNull
    public CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker var1);

    @NotNull
    public CaptureStatus captureStatus(@NotNull CapturedTypeMarker var1);

    public boolean isProjectionNotNull(@NotNull CapturedTypeMarker var1);

    @NotNull
    public TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker var1);

    public int argumentsCount(@NotNull KotlinTypeMarker var1);

    @NotNull
    public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker var1, int var2);

    @NotNull
    public List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker var1);

    @Nullable
    public TypeArgumentMarker getArgumentOrNull(@NotNull RigidTypeMarker var1, int var2);

    public boolean isStubType(@NotNull RigidTypeMarker var1);

    public boolean isStubTypeForBuilderInference(@NotNull RigidTypeMarker var1);

    @NotNull
    public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker var1);

    @Nullable
    public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker var1);

    public boolean isStarProjection(@NotNull TypeArgumentMarker var1);

    @NotNull
    public TypeVariance getVariance(@NotNull TypeArgumentMarker var1);

    @Nullable
    public KotlinTypeMarker getType(@NotNull TypeArgumentMarker var1);

    public int parametersCount(@NotNull TypeConstructorMarker var1);

    @NotNull
    public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker var1, int var2);

    @NotNull
    public List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker var1);

    @NotNull
    public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker var1);

    public boolean isIntersection(@NotNull TypeConstructorMarker var1);

    public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker var1);

    public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker var1);

    @Nullable
    public TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker var1);

    @Nullable
    public TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker var1);

    @NotNull
    public TypeVariance getVariance(@NotNull TypeParameterMarker var1);

    @NotNull
    public List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker var1);

    public boolean hasRecursiveBounds(@NotNull TypeParameterMarker var1, @Nullable TypeConstructorMarker var2);

    public boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker var1, @NotNull TypeConstructorMarker var2);

    public boolean isDenotable(@NotNull TypeConstructorMarker var1);

    @NotNull
    public RigidTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker var1);

    @NotNull
    public RigidTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker var1);

    public boolean isFlexibleWithDifferentTypeConstructors(@NotNull KotlinTypeMarker var1);

    public boolean isFlexible(@NotNull KotlinTypeMarker var1);

    public boolean isDynamic(@NotNull KotlinTypeMarker var1);

    public boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker var1);

    public boolean isDefinitelyNotNullType(@NotNull RigidTypeMarker var1);

    public boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker var1);

    public boolean hasFlexibleNullability(@NotNull KotlinTypeMarker var1);

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker var1);

    public boolean isNullableType(@NotNull KotlinTypeMarker var1);

    public boolean isNothing(@NotNull KotlinTypeMarker var1);

    public boolean isClassType(@NotNull RigidTypeMarker var1);

    @Nullable
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull RigidTypeMarker var1, @NotNull TypeConstructorMarker var2);

    public boolean isIntegerLiteralType(@NotNull RigidTypeMarker var1);

    @NotNull
    public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull RigidTypeMarker var1);

    public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker var1);

    @Nullable
    public RigidTypeMarker captureFromArguments(@NotNull RigidTypeMarker var1, @NotNull CaptureStatus var2);

    @NotNull
    public TypeArgumentListMarker asArgumentList(@NotNull RigidTypeMarker var1);

    @NotNull
    public TypeArgumentMarker get(@NotNull TypeArgumentListMarker var1, int var2);

    public int size(@NotNull TypeArgumentListMarker var1);

    public boolean isAnyConstructor(@NotNull TypeConstructorMarker var1);

    public boolean isNothingConstructor(@NotNull TypeConstructorMarker var1);

    public boolean isSingleClassifierType(@NotNull RigidTypeMarker var1);

    @NotNull
    public KotlinTypeMarker intersectTypes(@NotNull Collection<? extends KotlinTypeMarker> var1);

    public boolean isPrimitiveType(@NotNull SimpleTypeMarker var1);

    @NotNull
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull RigidTypeMarker var1);

    public boolean isTypeVariableType(@NotNull KotlinTypeMarker var1);
}

