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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1193#2,2:159\n1267#2,4:161\n1563#2:166\n1634#2,3:167\n1#3:165\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n*L\n77#1:159,2\n77#1:161,4\n100#1:166\n100#1:167,3\n*E\n"})
public final class TypeParameterUpperBoundEraser {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ErasureProjectionComputer projectionComputer;
    @NotNull
    private final TypeParameterErasureOptions options;
    @NotNull
    private final LockBasedStorageManager storage;
    @NotNull
    private final Lazy erroneousErasedBound$delegate;
    @NotNull
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;

    public TypeParameterUpperBoundEraser(@NotNull ErasureProjectionComputer projectionComputer, @NotNull TypeParameterErasureOptions options) {
        Intrinsics.checkNotNullParameter(projectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(options, "options");
        this.projectionComputer = projectionComputer;
        this.options = options;
        this.storage = new LockBasedStorageManager("Type parameter upper bound erasure results");
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = this;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$$Lambda$0(typeParameterUpperBoundEraser));
        typeParameterUpperBoundEraser = this;
        MemoizedFunctionToNotNull memoizedFunctionToNotNull = this.storage.createMemoizedFunction(new TypeParameterUpperBoundEraser$$Lambda$1(typeParameterUpperBoundEraser));
        Intrinsics.checkNotNullExpressionValue(memoizedFunctionToNotNull, "createMemoizedFunction(...)");
        this.getErasedUpperBound = memoizedFunctionToNotNull;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            typeParameterErasureOptions = new TypeParameterErasureOptions(false, false);
        }
        this(erasureProjectionComputer, typeParameterErasureOptions);
    }

    private final ErrorType getErroneousErasedBound() {
        Lazy lazy = this.erroneousErasedBound$delegate;
        return (ErrorType)lazy.getValue();
    }

    @NotNull
    public final KotlinType getErasedUpperBound(@NotNull TypeParameterDescriptor typeParameter, @NotNull ErasureTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        Object r2 = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, typeAttr));
        Intrinsics.checkNotNullExpressionValue(r2, "invoke(...)");
        return (KotlinType)r2;
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes typeAttr) {
        KotlinType kotlinType = typeAttr.getDefaultType();
        if (kotlinType == null || (kotlinType = TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType)) == null) {
            kotlinType = this.getErroneousErasedBound();
        }
        return kotlinType;
    }

    /*
     * WARNING - void declaration
     */
    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
        Annotated it;
        void $this$associateTo$iv$iv;
        Set<TypeParameterDescriptor> visitedTypeParameters = typeAttr.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameter.getOriginal())) {
            return this.getDefaultType(typeAttr);
        }
        SimpleType simpleType = typeParameter.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        Iterable $this$associate$iv = TypeUtilsKt.extractTypeParametersFromUpperBounds(simpleType, visitedTypeParameters);
        boolean $i$f$associate = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Iterable iterable = $this$associate$iv;
        Object destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateTo = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv) {
            TypeProjection typeProjection;
            Map map = destination$iv$iv;
            it = (TypeParameterDescriptor)element$iv$iv;
            boolean bl2 = false;
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(it)) {
                typeProjection = this.projectionComputer.computeProjection((TypeParameterDescriptor)it, typeAttr, this, this.getErasedUpperBound((TypeParameterDescriptor)it, typeAttr.withNewVisitedTypeParameter(typeParameter)));
            } else {
                TypeProjection typeProjection2 = TypeUtils.makeStarProjection((TypeParameterDescriptor)it, typeAttr);
                typeProjection = typeProjection2;
                Intrinsics.checkNotNullExpressionValue(typeProjection2, "makeStarProjection(...)");
            }
            TypeProjection boundProjection = typeProjection;
            Pair<TypeConstructor, TypeProjection> pair = TuplesKt.to(it.getTypeConstructor(), boundProjection);
            map.put(pair.getFirst(), pair.getSecond());
        }
        Map erasedTypeParameters = destination$iv$iv;
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, erasedTypeParameters, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor2, "create(...)");
        TypeSubstitutor erasedTypeParametersSubstitutor = typeSubstitutor2;
        List<KotlinType> list = typeParameter.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
        Set<KotlinType> erasedUpperBounds = this.substituteErasedUpperBounds(erasedTypeParametersSubstitutor, list, typeAttr);
        if (!((Collection)erasedUpperBounds).isEmpty()) {
            void $this$mapTo$iv$iv;
            if (!this.options.getIntersectUpperBounds()) {
                if (!(erasedUpperBounds.size() == 1)) {
                    boolean $i$a$-require-TypeParameterUpperBoundEraser$getErasedUpperBoundInternal$22 = false;
                    String $i$a$-require-TypeParameterUpperBoundEraser$getErasedUpperBoundInternal$22 = "Should only be one computed upper bound if no need to intersect all bounds";
                    throw new IllegalArgumentException($i$a$-require-TypeParameterUpperBoundEraser$getErasedUpperBoundInternal$22.toString());
                }
                return (KotlinType)CollectionsKt.single((Iterable)erasedUpperBounds);
            }
            Iterable $this$map$iv = CollectionsKt.toList((Iterable)erasedUpperBounds);
            boolean $i$f$map = false;
            destination$iv$iv = $this$map$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it = (KotlinType)item$iv$iv;
                Collection collection = destination$iv$iv2;
                boolean bl3 = false;
                collection.add(((KotlinType)it).unwrap());
            }
            return IntersectionTypeKt.intersectTypes((List)destination$iv$iv2);
        }
        return this.getDefaultType(typeAttr);
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor $this$substituteErasedUpperBounds, List<? extends KotlinType> upperBounds, ErasureTypeAttributes typeAttr) {
        Set<KotlinType> set;
        Set<KotlinType> $this$substituteErasedUpperBounds_u24lambda_u246 = set = SetsKt.createSetBuilder();
        boolean bl2 = false;
        for (KotlinType kotlinType : upperBounds) {
            ClassifierDescriptor declaration = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declaration instanceof ClassDescriptor) {
                $this$substituteErasedUpperBounds_u24lambda_u246.add(Companion.replaceArgumentsOfUpperBound(kotlinType, $this$substituteErasedUpperBounds, typeAttr.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (declaration instanceof TypeParameterDescriptor) {
                boolean bl3;
                Set<TypeParameterDescriptor> set2 = typeAttr.getVisitedTypeParameters();
                boolean bl4 = set2 != null ? set2.contains(declaration) : false;
                if (bl4) {
                    bl3 = $this$substituteErasedUpperBounds_u24lambda_u246.add(this.getDefaultType(typeAttr));
                } else {
                    List<KotlinType> list = ((TypeParameterDescriptor)declaration).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
                    bl3 = $this$substituteErasedUpperBounds_u24lambda_u246.addAll((Collection)this.substituteErasedUpperBounds($this$substituteErasedUpperBounds, list, typeAttr));
                }
            }
            if (this.options.getIntersectUpperBounds()) continue;
            break;
        }
        return SetsKt.build(set);
    }

    private static final ErrorType erroneousErasedBound_delegate$lambda$0(TypeParameterUpperBoundEraser this$0) {
        String[] stringArray = new String[]{this$0.toString()};
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, stringArray);
    }

    private static final KotlinType getErasedUpperBound$lambda$2(TypeParameterUpperBoundEraser this$0, DataToEraseUpperBound it) {
        DataToEraseUpperBound $this$getErasedUpperBound_u24lambda_u242_u24lambda_u241 = it;
        boolean bl2 = false;
        return this$0.getErasedUpperBoundInternal($this$getErasedUpperBound_u24lambda_u242_u24lambda_u241.getTypeParameter(), $this$getErasedUpperBound_u24lambda_u242_u24lambda_u241.getTypeAttr());
    }

    static /* synthetic */ ErrorType accessor$TypeParameterUpperBoundEraser$lambda0(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        return TypeParameterUpperBoundEraser.erroneousErasedBound_delegate$lambda$0(typeParameterUpperBoundEraser);
    }

    static /* synthetic */ KotlinType accessor$TypeParameterUpperBoundEraser$lambda1(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, DataToEraseUpperBound dataToEraseUpperBound) {
        return TypeParameterUpperBoundEraser.getErasedUpperBound$lambda$2(typeParameterUpperBoundEraser, dataToEraseUpperBound);
    }

    @SourceDebugExtension(value={"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n+ 2 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n245#2,14:159\n260#2:177\n1563#3:173\n1634#3,3:174\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n*L\n140#1:159,14\n140#1:177\n140#1:173\n140#1:174,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * Unable to fully structure code
         */
        @NotNull
        public final KotlinType replaceArgumentsOfUpperBound(@NotNull KotlinType $this$replaceArgumentsOfUpperBound, @NotNull TypeSubstitutor substitutor, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters, boolean leaveNonTypeParameterTypes) {
            block18: {
                block19: {
                    block21: {
                        block20: {
                            block9: {
                                block15: {
                                    block14: {
                                        block11: {
                                            block10: {
                                                Intrinsics.checkNotNullParameter($this$replaceArgumentsOfUpperBound, "<this>");
                                                Intrinsics.checkNotNullParameter(substitutor, "substitutor");
                                                $this$replaceArgumentsByParametersWith$iv = $this$replaceArgumentsOfUpperBound;
                                                $i$f$replaceArgumentsByParametersWith = false;
                                                var9_8 = unwrapped$iv = $this$replaceArgumentsByParametersWith$iv.unwrap();
                                                if (!(var9_8 instanceof FlexibleType)) break block9;
                                                $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType)unwrapped$iv).getLowerBound();
                                                $i$f$replaceArgumentsByParametersWith = false;
                                                if (!$this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() != null) break block10;
                                                v0 = $this$replaceArgumentsByParametersWith$iv$iv;
                                                break block11;
                                            }
                                            v1 = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                                            Intrinsics.checkNotNullExpressionValue(v1, "getParameters(...)");
                                            $this$map$iv$iv$iv = v1;
                                            $i$f$map = false;
                                            var14_17 = $this$map$iv$iv$iv;
                                            destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                                            $i$f$mapTo = false;
                                            for (T item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                                                block13: {
                                                    block12: {
                                                        var19_27 = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                                                        var25_35 = destination$iv$iv$iv$iv;
                                                        $i$a$-replaceArgumentsByParametersWith-TypeParameterUpperBoundEraser$Companion$replaceArgumentsOfUpperBound$replacedArguments$1 = false;
                                                        argument = CollectionsKt.getOrNull($this$replaceArgumentsOfUpperBound.getArguments(), typeParameterDescriptor.getIndex());
                                                        if (!leaveNonTypeParameterTypes) break block12;
                                                        v2 = argument;
                                                        v3 = v2 != null && (v2 = v2.getType()) != null ? !TypeUtilsKt.containsTypeParameter((KotlinType)v2) : false;
                                                        if (!v3) break block12;
                                                        v4 = argument;
                                                        break block13;
                                                    }
                                                    v5 = isTypeParameterVisited = visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor) != false;
                                                    if (argument == null || isTypeParameterVisited) ** GOTO lbl-1000
                                                    v6 = substitutor.getSubstitution();
                                                    v7 = argument.getType();
                                                    Intrinsics.checkNotNullExpressionValue(v7, "getType(...)");
                                                    if (v6.get(v7) == null) lbl-1000:
                                                    // 2 sources

                                                    {
                                                        v4 = new StarProjectionImpl(typeParameterDescriptor);
                                                    } else {
                                                        v4 = argument;
                                                    }
                                                }
                                                var25_35.add(v4);
                                            }
                                            newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                                            v0 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
                                        }
                                        $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType)unwrapped$iv).getUpperBound();
                                        var24_39 = v0;
                                        $i$f$replaceArgumentsByParametersWith = false;
                                        if (!$this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() != null) break block14;
                                        v8 = $this$replaceArgumentsByParametersWith$iv$iv;
                                        break block15;
                                    }
                                    v9 = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                                    Intrinsics.checkNotNullExpressionValue(v9, "getParameters(...)");
                                    $this$map$iv$iv$iv = v9;
                                    $i$f$map = false;
                                    $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                                    destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                                    $i$f$mapTo = false;
                                    for (T item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                                        block17: {
                                            block16: {
                                                typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                                                var25_35 = destination$iv$iv$iv$iv;
                                                $i$a$-replaceArgumentsByParametersWith-TypeParameterUpperBoundEraser$Companion$replaceArgumentsOfUpperBound$replacedArguments$1 = false;
                                                argument = CollectionsKt.getOrNull($this$replaceArgumentsOfUpperBound.getArguments(), typeParameterDescriptor.getIndex());
                                                if (!leaveNonTypeParameterTypes) break block16;
                                                v10 = argument;
                                                v11 = v10 != null && (v10 = v10.getType()) != null ? !TypeUtilsKt.containsTypeParameter((KotlinType)v10) : false;
                                                if (!v11) break block16;
                                                v12 = argument;
                                                break block17;
                                            }
                                            v13 = isTypeParameterVisited = visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor) != false;
                                            if (argument == null || isTypeParameterVisited) ** GOTO lbl-1000
                                            v14 = substitutor.getSubstitution();
                                            v15 = argument.getType();
                                            Intrinsics.checkNotNullExpressionValue(v15, "getType(...)");
                                            if (v14.get(v15) == null) lbl-1000:
                                            // 2 sources

                                            {
                                                v12 = new StarProjectionImpl(typeParameterDescriptor);
                                            } else {
                                                v12 = argument;
                                            }
                                        }
                                        var25_35.add(v12);
                                    }
                                    newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                                    v8 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
                                }
                                v16 = KotlinTypeFactory.flexibleType(var24_39, v8);
                                break block18;
                            }
                            if (!(var9_8 instanceof SimpleType)) break block19;
                            $this$replaceArgumentsByParametersWith$iv$iv = (SimpleType)unwrapped$iv;
                            $i$f$replaceArgumentsByParametersWith = false;
                            if (!$this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() != null) break block20;
                            v17 = $this$replaceArgumentsByParametersWith$iv$iv;
                            break block21;
                        }
                        v18 = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                        Intrinsics.checkNotNullExpressionValue(v18, "getParameters(...)");
                        $this$map$iv$iv$iv = v18;
                        $i$f$map = false;
                        $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                        destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                        $i$f$mapTo = false;
                        for (T item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                            block23: {
                                block22: {
                                    typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                                    var25_36 = destination$iv$iv$iv$iv;
                                    $i$a$-replaceArgumentsByParametersWith-TypeParameterUpperBoundEraser$Companion$replaceArgumentsOfUpperBound$replacedArguments$1 = false;
                                    argument = CollectionsKt.getOrNull($this$replaceArgumentsOfUpperBound.getArguments(), typeParameterDescriptor.getIndex());
                                    if (!leaveNonTypeParameterTypes) break block22;
                                    v19 = argument;
                                    v20 = v19 != null && (v19 = v19.getType()) != null ? !TypeUtilsKt.containsTypeParameter((KotlinType)v19) : false;
                                    if (!v20) break block22;
                                    v21 = argument;
                                    break block23;
                                }
                                v22 = isTypeParameterVisited = visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor) != false;
                                if (argument == null || isTypeParameterVisited) ** GOTO lbl-1000
                                v23 = substitutor.getSubstitution();
                                v24 = argument.getType();
                                Intrinsics.checkNotNullExpressionValue(v24, "getType(...)");
                                if (v23.get(v24) == null) lbl-1000:
                                // 2 sources

                                {
                                    v21 = new StarProjectionImpl(typeParameterDescriptor);
                                } else {
                                    v21 = argument;
                                }
                            }
                            var25_36.add(v21);
                        }
                        newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                        v17 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
                    }
                    v16 = v17;
                    break block18;
                }
                throw new NoWhenBranchMatchedException();
            }
            replacedArguments = TypeWithEnhancementKt.inheritEnhancement(v16, unwrapped$iv);
            v25 = substitutor.safeSubstitute(replacedArguments, Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(v25, "safeSubstitute(...)");
            return v25;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    private static final class DataToEraseUpperBound {
        @NotNull
        private final TypeParameterDescriptor typeParameter;
        @NotNull
        private final ErasureTypeAttributes typeAttr;

        public DataToEraseUpperBound(@NotNull TypeParameterDescriptor typeParameter, @NotNull ErasureTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.typeAttr = typeAttr;
        }

        @NotNull
        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        @NotNull
        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof DataToEraseUpperBound)) {
                return false;
            }
            return Intrinsics.areEqual(((DataToEraseUpperBound)other).typeParameter, this.typeParameter) && Intrinsics.areEqual(((DataToEraseUpperBound)other).typeAttr, this.typeAttr);
        }

        public int hashCode() {
            int result = this.typeParameter.hashCode();
            result += 31 * result + this.typeAttr.hashCode();
            return result;
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }
    }
}

