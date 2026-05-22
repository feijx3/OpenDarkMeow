/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 TypeSystemContext.kt\norg/jetbrains/kotlin/types/model/TypeSystemContextKt\n*L\n1#1,884:1\n1#2:885\n1#2:899\n1#2:951\n1#2:986\n140#3,13:886\n153#3,13:900\n54#3,8:924\n140#3,13:938\n153#3,13:952\n140#3,13:973\n153#3,13:987\n1634#4,3:913\n1563#4:916\n1634#4,3:917\n1563#4:920\n1634#4,3:921\n1740#4,3:932\n1740#4,3:935\n774#4:965\n865#4:966\n866#4:972\n1374#4:1000\n1460#4,5:1001\n1761#4,3:1006\n1761#4,3:1009\n635#5,5:967\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n*L\n383#1:899\n671#1:951\n741#1:986\n383#1:886,13\n383#1:900,13\n527#1:924,8\n671#1:938,13\n671#1:952,13\n741#1:973,13\n741#1:987,13\n426#1:913,3\n429#1:916\n429#1:917,3\n442#1:920\n442#1:921,3\n609#1:932,3\n620#1:935,3\n716#1:965\n716#1:966\n716#1:972\n750#1:1000\n750#1:1001,5\n336#1:1006,3\n344#1:1009,3\n717#1:967,5\n*E\n"})
public final class AbstractTypeChecker {
    @NotNull
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    private AbstractTypeChecker() {
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType, boolean isFromNullabilityConstraint) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (!state.customIsSubtypeOf(subType, superType)) {
            return false;
        }
        return this.completeIsSubTypeOf(state, subType, superType, isFromNullabilityConstraint);
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean bl2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, bl2);
    }

    public final boolean equalTypes(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker a2, @NotNull KotlinTypeMarker b2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        TypeSystemContext $this$equalTypes_u24lambda_u241 = state.getTypeSystemContext();
        boolean bl2 = false;
        if (a2 == b2) {
            return true;
        }
        if (INSTANCE.isCommonDenotableType($this$equalTypes_u24lambda_u241, a2) && INSTANCE.isCommonDenotableType($this$equalTypes_u24lambda_u241, b2)) {
            KotlinTypeMarker refinedA = state.prepareType(state.refineType(a2));
            KotlinTypeMarker refinedB = state.prepareType(state.refineType(b2));
            RigidTypeMarker simpleA = $this$equalTypes_u24lambda_u241.lowerBoundIfFlexible(refinedA);
            if (!$this$equalTypes_u24lambda_u241.areEqualTypeConstructors($this$equalTypes_u24lambda_u241.typeConstructor(refinedA), $this$equalTypes_u24lambda_u241.typeConstructor(refinedB))) {
                return false;
            }
            if ($this$equalTypes_u24lambda_u241.argumentsCount(simpleA) == 0) {
                if ($this$equalTypes_u24lambda_u241.hasFlexibleNullability(refinedA) || $this$equalTypes_u24lambda_u241.hasFlexibleNullability(refinedB)) {
                    return true;
                }
                return $this$equalTypes_u24lambda_u241.isMarkedNullable(simpleA) == $this$equalTypes_u24lambda_u241.isMarkedNullable($this$equalTypes_u24lambda_u241.lowerBoundIfFlexible(refinedB));
            }
        }
        return AbstractTypeChecker.isSubtypeOf$default(INSTANCE, state, a2, b2, false, 8, null) && AbstractTypeChecker.isSubtypeOf$default(INSTANCE, state, b2, a2, false, 8, null);
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState state, KotlinTypeMarker subType, KotlinTypeMarker superType, boolean isFromNullabilityConstraint) {
        TypeSystemContext $this$completeIsSubTypeOf_u24lambda_u244 = state.getTypeSystemContext();
        boolean bl2 = false;
        KotlinTypeMarker preparedSubType = state.prepareType(state.refineType(subType));
        KotlinTypeMarker preparedSuperType = state.prepareType(state.refineType(superType));
        if (state.isDnnTypesEqualToFlexible() && $this$completeIsSubTypeOf_u24lambda_u244.isFlexible(preparedSubType) && $this$completeIsSubTypeOf_u24lambda_u244.isDefinitelyNotNullType(preparedSuperType)) {
            FlexibleTypeMarker flexibleTypeMarker = $this$completeIsSubTypeOf_u24lambda_u244.asFlexibleType(preparedSubType);
            Intrinsics.checkNotNull(flexibleTypeMarker);
            KotlinTypeMarker kotlinTypeMarker = $this$completeIsSubTypeOf_u24lambda_u244.lowerBound(flexibleTypeMarker);
            RigidTypeMarker rigidTypeMarker = $this$completeIsSubTypeOf_u24lambda_u244.asRigidType(preparedSuperType);
            Intrinsics.checkNotNull(rigidTypeMarker);
            return INSTANCE.completeIsSubTypeOf(state, kotlinTypeMarker, $this$completeIsSubTypeOf_u24lambda_u244.originalIfDefinitelyNotNullable(rigidTypeMarker), isFromNullabilityConstraint);
        }
        Boolean bl3 = INSTANCE.checkSubtypeForSpecialCases(state, $this$completeIsSubTypeOf_u24lambda_u244.lowerBoundIfFlexible(preparedSubType), $this$completeIsSubTypeOf_u24lambda_u244.upperBoundIfFlexible(preparedSuperType));
        if (bl3 != null) {
            boolean it = bl3;
            boolean bl4 = false;
            state.addSubtypeConstraint(preparedSubType, preparedSuperType, isFromNullabilityConstraint);
            return it;
        }
        Boolean bl5 = state.addSubtypeConstraint(preparedSubType, preparedSuperType, isFromNullabilityConstraint);
        if (bl5 != null) {
            boolean it = bl5;
            boolean bl6 = false;
            return it;
        }
        return INSTANCE.isSubtypeOfForSingleClassifierType(state, $this$completeIsSubTypeOf_u24lambda_u244.lowerBoundIfFlexible(preparedSubType), $this$completeIsSubTypeOf_u24lambda_u244.upperBoundIfFlexible(preparedSuperType));
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        TypeSystemContext $this$checkSubtypeForIntegerLiteralType_u24lambda_u247 = state.getTypeSystemContext();
        boolean bl2 = false;
        if (!$this$checkSubtypeForIntegerLiteralType_u24lambda_u247.isIntegerLiteralType(subType) && !$this$checkSubtypeForIntegerLiteralType_u24lambda_u247.isIntegerLiteralType(superType)) {
            return null;
        }
        if (AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne($this$checkSubtypeForIntegerLiteralType_u24lambda_u247, subType) && AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne($this$checkSubtypeForIntegerLiteralType_u24lambda_u247, superType)) {
            return true;
        }
        if ($this$checkSubtypeForIntegerLiteralType_u24lambda_u247.isIntegerLiteralType(subType) ? AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType($this$checkSubtypeForIntegerLiteralType_u24lambda_u247, state, subType, superType, false) : $this$checkSubtypeForIntegerLiteralType_u24lambda_u247.isIntegerLiteralType(superType) && (AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents($this$checkSubtypeForIntegerLiteralType_u24lambda_u247, subType) || AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType($this$checkSubtypeForIntegerLiteralType_u24lambda_u247, state, superType, subType, true))) {
            return true;
        }
        return null;
    }

    private final boolean hasNothingSupertype(TypeCheckerState state, RigidTypeMarker type) {
        boolean bl2;
        block6: {
            TypeSystemContext $this$hasNothingSupertype_u24lambda_u2410 = state.getTypeSystemContext();
            boolean bl3 = false;
            TypeConstructorMarker typeConstructor2 = $this$hasNothingSupertype_u24lambda_u2410.typeConstructor(type);
            if ($this$hasNothingSupertype_u24lambda_u2410.isClassTypeConstructor(typeConstructor2)) {
                return $this$hasNothingSupertype_u24lambda_u2410.isNothingConstructor(typeConstructor2);
            }
            TypeCheckerState this_$iv = state;
            boolean $i$f$anySupertype = false;
            RigidTypeMarker it = type;
            boolean bl4 = false;
            if ($this$hasNothingSupertype_u24lambda_u2410.isNothingConstructor($this$hasNothingSupertype_u24lambda_u2410.typeConstructor(it))) {
                bl2 = true;
            } else {
                this_$iv.initialize();
                ArrayDeque<RigidTypeMarker> arrayDeque = this_$iv.getSupertypesDeque();
                Intrinsics.checkNotNull(arrayDeque);
                ArrayDeque<RigidTypeMarker> deque$iv = arrayDeque;
                Set<RigidTypeMarker> set = this_$iv.getSupertypesSet();
                Intrinsics.checkNotNull(set);
                Set<RigidTypeMarker> visitedSupertypes$iv = set;
                deque$iv.push(type);
                while (!((Collection)deque$iv).isEmpty()) {
                    TypeCheckerState.SupertypesPolicy policy$iv;
                    RigidTypeMarker current$iv = deque$iv.pop();
                    Intrinsics.checkNotNull(current$iv);
                    if (!visitedSupertypes$iv.add(current$iv)) continue;
                    it = current$iv;
                    boolean bl5 = false;
                    TypeCheckerState.SupertypesPolicy supertypesPolicy = $this$hasNothingSupertype_u24lambda_u2410.isClassType(it) ? (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.None.INSTANCE : (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    TypeCheckerState.SupertypesPolicy it$iv = supertypesPolicy;
                    boolean bl6 = false;
                    if ((!Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE) ? supertypesPolicy : null) == null) continue;
                    policy$iv = policy$iv;
                    TypeSystemContext $this$anySupertype_u24lambda_u243$iv = this_$iv.getTypeSystemContext();
                    boolean bl7 = false;
                    Collection<KotlinTypeMarker> supertypes$iv = $this$anySupertype_u24lambda_u243$iv.supertypes($this$anySupertype_u24lambda_u243$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv;
                        it = newType$iv = policy$iv.transformType(this_$iv, supertype$iv);
                        bl4 = false;
                        if ($this$hasNothingSupertype_u24lambda_u2410.isNothingConstructor($this$hasNothingSupertype_u24lambda_u2410.typeConstructor(it))) {
                            this_$iv.clear();
                            bl2 = true;
                            break block6;
                        }
                        deque$iv.add(newType$iv);
                    }
                }
                this_$iv.clear();
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private final boolean isSubtypeOfForSingleClassifierType(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421 = state.getTypeSystemContext();
        $i$a$-with-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1 = false;
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            v0 = var6_6 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.isSingleClassifierType(subType) != false || $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.isIntersection($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.typeConstructor(subType)) != false || state.isAllowedTypeVariable(subType) != false;
            if (_Assertions.ENABLED && !var6_6) {
                $i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$1 = false;
                $i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$1 = "Not singleClassifierType and not intersection subType: " + subType;
                throw new AssertionError((Object)$i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$1);
            }
            v1 = var6_6 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.isSingleClassifierType(superType) != false || state.isAllowedTypeVariable(superType) != false;
            if (_Assertions.ENABLED && !var6_6) {
                $i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$2 = false;
                $i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$2 = "Not singleClassifierType superType: " + superType;
                throw new AssertionError((Object)$i$a$-assert-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$2);
            }
        }
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(state, subType, superType)) {
            return false;
        }
        v2 = AbstractTypeChecker.INSTANCE.checkSubtypeForIntegerLiteralType(state, subType, superType);
        if (v2 != null) {
            it = v2;
            $i$a$-let-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$3 = false;
            TypeCheckerState.addSubtypeConstraint$default(state, subType, superType, false, 4, null);
            return it;
        }
        superConstructor = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.typeConstructor(superType);
        if ($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.areEqualTypeConstructors($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.typeConstructor(subType), superConstructor) && $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.parametersCount(superConstructor) == 0) {
            return true;
        }
        if ($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.isAnyConstructor($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.typeConstructor(superType))) {
            return true;
        }
        $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421_u24lambda_u2416 = AbstractTypeChecker.INSTANCE.findCorrespondingSupertypes(state, subType, superConstructor);
        $i$a$-with-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$supertypesWithSameConstructor$1 = false;
        if ($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421_u24lambda_u2416.size() <= 1) ** GOTO lbl-1000
        var11_17 = state.getTypeSystemContext();
        v3 = var11_17 instanceof TypeSystemInferenceExtensionContext != false ? (TypeSystemInferenceExtensionContext)var11_17 : null;
        v4 = v3 != null ? v3.isK2() : false;
        if (v4) {
            var12_20 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421_u24lambda_u2416;
            var11_17 = new LinkedHashSet<E>();
            $i$f$mapTo = false;
            for (T item$iv : $this$mapTo$iv) {
                var16_29 = (RigidTypeMarker)item$iv;
                var17_30 = destination$iv;
                $i$a$-mapTo-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$supertypesWithSameConstructor$1$1 = false;
                v5 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.asRigidType(state.prepareType((KotlinTypeMarker)it));
                if (v5 == null) {
                    v5 = it;
                }
                var17_30.add(v5);
            }
            v6 = destination$iv;
        } else lbl-1000:
        // 2 sources

        {
            $this$map$iv = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421_u24lambda_u2416;
            $i$f$map = false;
            $i$f$mapTo = $this$map$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (T item$iv$iv : $this$mapTo$iv$iv) {
                var19_33 = (RigidTypeMarker)item$iv$iv;
                var17_30 = destination$iv$iv;
                $i$a$-map-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$supertypesWithSameConstructor$1$2 = false;
                v7 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.asRigidType(state.prepareType((KotlinTypeMarker)it));
                if (v7 == null) {
                    v7 = it;
                }
                var17_30.add(v7);
            }
            v6 = (List)destination$iv$iv;
        }
        supertypesWithSameConstructor = v6;
        switch (supertypesWithSameConstructor.size()) {
            case 0: {
                return AbstractTypeChecker.INSTANCE.hasNothingSupertype(state, subType);
            }
            case 1: {
                return AbstractTypeChecker.INSTANCE.isSubtypeForSameConstructor(state, $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.asArgumentList((RigidTypeMarker)CollectionsKt.first(supertypesWithSameConstructor)), superType);
            }
        }
        newArguments = new ArgumentList($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.parametersCount(superConstructor));
        anyNonOutParameter = false;
        var12_21 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.parametersCount(superConstructor);
        for (index = 0; index < var12_21; ++index) {
            v8 = anyNonOutParameter = anyNonOutParameter != false || $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.getVariance($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.getParameter(superConstructor, index)) != TypeVariance.OUT;
            if (anyNonOutParameter) continue;
            $this$map$iv = supertypesWithSameConstructor;
            $i$f$map = false;
            it = $this$map$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (E item$iv$iv : $this$mapTo$iv$iv) {
                block24: {
                    block23: {
                        var21_36 = (RigidTypeMarker)item$iv$iv;
                        var22_37 = destination$iv$iv;
                        $i$a$-map-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$allProjections$1 = false;
                        v9 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.getArgumentOrNull((RigidTypeMarker)it, index);
                        if (v9 == null) break block23;
                        it = var24_39 = v9;
                        $i$a$-takeIf-AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$allProjections$1$1 = false;
                        v9 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.getVariance(it) == TypeVariance.INV != false ? var24_39 : null;
                        if (v9 != null && (v9 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.getType((TypeArgumentMarker)v9)) != null) break block24;
                    }
                    throw new IllegalStateException(("Incorrect type: " + it + ", subType: " + subType + ", superType: " + superType).toString());
                }
                var22_37.add(v9);
            }
            allProjections = (List)destination$iv$iv;
            intersection = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.asTypeArgument($this$isSubtypeOfForSingleClassifierType_u24lambda_u2421.intersectTypes(allProjections));
            newArguments.add(intersection);
        }
        if (!anyNonOutParameter && AbstractTypeChecker.INSTANCE.isSubtypeForSameConstructor(state, newArguments, superType)) {
            return true;
        }
        var27_42 = superType;
        var28_43 = $this$isSubtypeOfForSingleClassifierType_u24lambda_u2421;
        var29_44 = state;
        var30_45 = supertypesWithSameConstructor;
        return state.runForkingPoint(new AbstractTypeChecker$$Lambda$0(var30_45, var29_44, var28_43, var27_42));
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext $this$isTypeVariableAgainstStarProjectionForSelfType, KotlinTypeMarker subArgumentType, KotlinTypeMarker superArgumentType, TypeConstructorMarker selfConstructor) {
        RigidTypeMarker simpleSubArgumentType = $this$isTypeVariableAgainstStarProjectionForSelfType.asRigidType(subArgumentType);
        if (!(simpleSubArgumentType instanceof CapturedTypeMarker) || $this$isTypeVariableAgainstStarProjectionForSelfType.isOldCapturedType((CapturedTypeMarker)simpleSubArgumentType) || !$this$isTypeVariableAgainstStarProjectionForSelfType.isStarProjection($this$isTypeVariableAgainstStarProjectionForSelfType.projection($this$isTypeVariableAgainstStarProjectionForSelfType.typeConstructor((CapturedTypeMarker)simpleSubArgumentType)))) {
            return false;
        }
        if ($this$isTypeVariableAgainstStarProjectionForSelfType.captureStatus((CapturedTypeMarker)simpleSubArgumentType) != CaptureStatus.FOR_SUBTYPING) {
            return false;
        }
        TypeConstructorMarker typeConstructorMarker = $this$isTypeVariableAgainstStarProjectionForSelfType.typeConstructor(superArgumentType);
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructorMarker instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker)typeConstructorMarker : null;
        if (typeVariableTypeConstructorMarker == null) {
            return false;
        }
        TypeVariableTypeConstructorMarker typeVariableConstructor = typeVariableTypeConstructorMarker;
        TypeParameterMarker typeParameterMarker = $this$isTypeVariableAgainstStarProjectionForSelfType.getTypeParameter(typeVariableConstructor);
        return typeParameterMarker != null ? $this$isTypeVariableAgainstStarProjectionForSelfType.hasRecursiveBounds(typeParameterMarker, selfConstructor) : false;
    }

    public final boolean isSubtypeForSameConstructor(@NotNull TypeCheckerState $this$isSubtypeForSameConstructor, @NotNull TypeArgumentListMarker capturedSubArguments, @NotNull RigidTypeMarker superType) {
        Intrinsics.checkNotNullParameter($this$isSubtypeForSameConstructor, "<this>");
        Intrinsics.checkNotNullParameter(capturedSubArguments, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(superType, "superType");
        TypeSystemContext $this$isSubtypeForSameConstructor_u24lambda_u2425 = $this$isSubtypeForSameConstructor.getTypeSystemContext();
        boolean bl2 = false;
        TypeConstructorMarker superTypeConstructor = $this$isSubtypeForSameConstructor_u24lambda_u2425.typeConstructor(superType);
        int argumentsCount = $this$isSubtypeForSameConstructor_u24lambda_u2425.size(capturedSubArguments);
        int parametersCount = $this$isSubtypeForSameConstructor_u24lambda_u2425.parametersCount(superTypeConstructor);
        if (argumentsCount != parametersCount || argumentsCount != $this$isSubtypeForSameConstructor_u24lambda_u2425.argumentsCount(superType)) {
            return false;
        }
        for (int index = 0; index < parametersCount; ++index) {
            boolean bl3;
            boolean isTypeVariableAgainstStarProjectionForSelfType;
            KotlinTypeMarker superArgumentType;
            KotlinTypeMarker subArgumentType;
            TypeVariance variance;
            boolean bl4;
            TypeArgumentMarker superProjection = $this$isSubtypeForSameConstructor_u24lambda_u2425.getArgument(superType, index);
            if ($this$isSubtypeForSameConstructor_u24lambda_u2425.getType(superProjection) == null) continue;
            TypeArgumentMarker it = $this$isSubtypeForSameConstructor_u24lambda_u2425.get(capturedSubArguments, index);
            boolean bl5 = false;
            boolean bl6 = bl4 = $this$isSubtypeForSameConstructor_u24lambda_u2425.getVariance(it) == TypeVariance.INV;
            if (_Assertions.ENABLED && !bl4) {
                boolean $i$a$-assert-AbstractTypeChecker$isSubtypeForSameConstructor$1$subArgumentType$1$22 = false;
                String $i$a$-assert-AbstractTypeChecker$isSubtypeForSameConstructor$1$subArgumentType$1$22 = "Incorrect sub argument: " + it;
                throw new AssertionError((Object)$i$a$-assert-AbstractTypeChecker$isSubtypeForSameConstructor$1$subArgumentType$1$22);
            }
            Intrinsics.checkNotNull($this$isSubtypeForSameConstructor_u24lambda_u2425.getType(it));
            if (INSTANCE.effectiveVariance($this$isSubtypeForSameConstructor_u24lambda_u2425.getVariance($this$isSubtypeForSameConstructor_u24lambda_u2425.getParameter(superTypeConstructor, index)), $this$isSubtypeForSameConstructor_u24lambda_u2425.getVariance(superProjection)) == null) {
                return $this$isSubtypeForSameConstructor.isErrorTypeEqualsToAnything();
            }
            boolean bl7 = variance == TypeVariance.INV ? INSTANCE.isTypeVariableAgainstStarProjectionForSelfType($this$isSubtypeForSameConstructor_u24lambda_u2425, subArgumentType, superArgumentType, superTypeConstructor) || INSTANCE.isTypeVariableAgainstStarProjectionForSelfType($this$isSubtypeForSameConstructor_u24lambda_u2425, superArgumentType, subArgumentType, superTypeConstructor) : (isTypeVariableAgainstStarProjectionForSelfType = false);
            if (isTypeVariableAgainstStarProjectionForSelfType) continue;
            TypeCheckerState this_$iv = $this$isSubtypeForSameConstructor;
            boolean $i$f$runWithArgumentsSettings$compiler_common = false;
            if (TypeCheckerState.access$getArgumentsDepth(this_$iv) > 100) {
                throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + subArgumentType).toString());
            }
            int n2 = TypeCheckerState.access$getArgumentsDepth(this_$iv);
            TypeCheckerState.access$setArgumentsDepth(this_$iv, n2 + 1);
            TypeCheckerState $this$isSubtypeForSameConstructor_u24lambda_u2425_u24lambda_u2424 = this_$iv;
            boolean bl8 = false;
            switch (WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
                case 1: {
                    bl3 = INSTANCE.equalTypes($this$isSubtypeForSameConstructor_u24lambda_u2425_u24lambda_u2424, subArgumentType, superArgumentType);
                    break;
                }
                case 2: {
                    bl3 = AbstractTypeChecker.isSubtypeOf$default(INSTANCE, $this$isSubtypeForSameConstructor_u24lambda_u2425_u24lambda_u2424, subArgumentType, superArgumentType, false, 8, null);
                    break;
                }
                case 3: {
                    bl3 = AbstractTypeChecker.isSubtypeOf$default(INSTANCE, $this$isSubtypeForSameConstructor_u24lambda_u2425_u24lambda_u2424, superArgumentType, subArgumentType, false, 8, null);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            boolean result$iv = bl3;
            int n3 = TypeCheckerState.access$getArgumentsDepth(this_$iv);
            TypeCheckerState.access$setArgumentsDepth(this_$iv, n3 + -1);
            boolean correctArgument = result$iv;
            if (correctArgument) continue;
            return false;
        }
        return true;
    }

    private final boolean isCommonDenotableType(TypeSystemContext $this$isCommonDenotableType, KotlinTypeMarker type) {
        return $this$isCommonDenotableType.isDenotable($this$isCommonDenotableType.typeConstructor(type)) && !$this$isCommonDenotableType.isDynamic(type) && !$this$isCommonDenotableType.isDefinitelyNotNullType(type) && !$this$isCommonDenotableType.isNotNullTypeParameter(type) && !$this$isCommonDenotableType.isFlexibleWithDifferentTypeConstructors(type);
    }

    @Nullable
    public final TypeVariance effectiveVariance(@NotNull TypeVariance declared, @NotNull TypeVariance useSite) {
        Intrinsics.checkNotNullParameter((Object)declared, "declared");
        Intrinsics.checkNotNullParameter((Object)useSite, "useSite");
        if (declared == TypeVariance.INV) {
            return useSite;
        }
        if (useSite == TypeVariance.INV) {
            return declared;
        }
        if (declared == useSite) {
            return declared;
        }
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext $this$isStubTypeSubtypeOfAnother, RigidTypeMarker a2, RigidTypeMarker b2) {
        if ($this$isStubTypeSubtypeOfAnother.typeConstructor(a2) != $this$isStubTypeSubtypeOfAnother.typeConstructor(b2)) {
            return false;
        }
        if (!$this$isStubTypeSubtypeOfAnother.isDefinitelyNotNullType(a2) && $this$isStubTypeSubtypeOfAnother.isDefinitelyNotNullType(b2)) {
            return false;
        }
        return !$this$isStubTypeSubtypeOfAnother.isMarkedNullable(a2) || $this$isStubTypeSubtypeOfAnother.isMarkedNullable(b2);
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        block27: {
            TypeParameterMarker typeParameter;
            TypeSystemContext $this$checkSubtypeForSpecialCases_u24lambda_u2429;
            block26: {
                boolean bl2;
                block25: {
                    TypeConstructorMarker superTypeConstructor;
                    KotlinTypeMarker lowerType;
                    CapturedTypeMarker superTypeCaptured;
                    $this$checkSubtypeForSpecialCases_u24lambda_u2429 = state.getTypeSystemContext();
                    boolean bl3 = false;
                    if ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isError(subType) || $this$checkSubtypeForSpecialCases_u24lambda_u2429.isError(superType)) {
                        if (state.isErrorTypeEqualsToAnything()) {
                            return true;
                        }
                        if ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isMarkedNullable(subType) && !$this$checkSubtypeForSpecialCases_u24lambda_u2429.isMarkedNullable(superType)) {
                            return false;
                        }
                        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes($this$checkSubtypeForSpecialCases_u24lambda_u2429, $this$checkSubtypeForSpecialCases_u24lambda_u2429.withNullability(subType, false), $this$checkSubtypeForSpecialCases_u24lambda_u2429.withNullability(superType, false));
                    }
                    if ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isStubTypeForBuilderInference(subType) && $this$checkSubtypeForSpecialCases_u24lambda_u2429.isStubTypeForBuilderInference(superType)) {
                        return INSTANCE.isStubTypeSubtypeOfAnother($this$checkSubtypeForSpecialCases_u24lambda_u2429, subType, superType) || state.isStubTypeEqualsToAnything();
                    }
                    if ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isStubType(subType) || $this$checkSubtypeForSpecialCases_u24lambda_u2429.isStubType(superType)) {
                        return state.isStubTypeEqualsToAnything();
                    }
                    CapturedTypeMarker capturedTypeMarker = superTypeCaptured = $this$checkSubtypeForSpecialCases_u24lambda_u2429.asCapturedTypeUnwrappingDnn(superType);
                    KotlinTypeMarker kotlinTypeMarker = lowerType = capturedTypeMarker != null ? $this$checkSubtypeForSpecialCases_u24lambda_u2429.lowerType(capturedTypeMarker) : null;
                    if (superTypeCaptured != null && lowerType != null) {
                        KotlinTypeMarker nullableLowerType = $this$checkSubtypeForSpecialCases_u24lambda_u2429.isMarkedNullable(superType) ? $this$checkSubtypeForSpecialCases_u24lambda_u2429.withNullability(lowerType, true) : ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isDefinitelyNotNullType(superType) ? $this$checkSubtypeForSpecialCases_u24lambda_u2429.makeDefinitelyNotNullOrNotNull(lowerType) : lowerType);
                        switch (WhenMappings.$EnumSwitchMapping$1[state.getLowerCapturedTypePolicy(subType, superTypeCaptured).ordinal()]) {
                            case 1: {
                                return AbstractTypeChecker.isSubtypeOf$default(INSTANCE, state, subType, nullableLowerType, false, 8, null);
                            }
                            case 2: {
                                if (!AbstractTypeChecker.isSubtypeOf$default(INSTANCE, state, subType, nullableLowerType, false, 8, null)) break;
                                return true;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    if ($this$checkSubtypeForSpecialCases_u24lambda_u2429.isIntersection(superTypeConstructor = $this$checkSubtypeForSpecialCases_u24lambda_u2429.typeConstructor(superType))) {
                        boolean bl4;
                        block24: {
                            boolean bl5;
                            boolean bl6 = bl5 = !$this$checkSubtypeForSpecialCases_u24lambda_u2429.isMarkedNullable(superType);
                            if (_Assertions.ENABLED && !bl5) {
                                boolean $i$a$-assert-AbstractTypeChecker$checkSubtypeForSpecialCases$1$22 = false;
                                String $i$a$-assert-AbstractTypeChecker$checkSubtypeForSpecialCases$1$22 = "Intersection type should not be marked nullable!: " + superType;
                                throw new AssertionError((Object)$i$a$-assert-AbstractTypeChecker$checkSubtypeForSpecialCases$1$22);
                            }
                            Iterable $this$all$iv = $this$checkSubtypeForSpecialCases_u24lambda_u2429.supertypes(superTypeConstructor);
                            boolean $i$f$all = false;
                            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                                bl4 = true;
                            } else {
                                for (Object element$iv : $this$all$iv) {
                                    KotlinTypeMarker it = (KotlinTypeMarker)element$iv;
                                    boolean bl7 = false;
                                    if (AbstractTypeChecker.isSubtypeOf$default(INSTANCE, state, subType, it, false, 8, null)) continue;
                                    bl4 = false;
                                    break block24;
                                }
                                bl4 = true;
                            }
                        }
                        return bl4;
                    }
                    TypeConstructorMarker subTypeConstructor = $this$checkSubtypeForSpecialCases_u24lambda_u2429.typeConstructor(subType);
                    if (subType instanceof CapturedTypeMarker) break block26;
                    if (!$this$checkSubtypeForSpecialCases_u24lambda_u2429.isIntersection(subTypeConstructor)) break block27;
                    Iterable $this$all$iv = $this$checkSubtypeForSpecialCases_u24lambda_u2429.supertypes(subTypeConstructor);
                    boolean $i$f$all = false;
                    if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                        bl2 = true;
                    } else {
                        for (Object element$iv : $this$all$iv) {
                            KotlinTypeMarker it = (KotlinTypeMarker)element$iv;
                            boolean bl8 = false;
                            if (it instanceof CapturedTypeMarker) continue;
                            bl2 = false;
                            break block25;
                        }
                        bl2 = true;
                    }
                }
                if (!bl2) break block27;
            }
            if ((typeParameter = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(state.getTypeSystemContext(), superType, subType)) != null && $this$checkSubtypeForSpecialCases_u24lambda_u2429.hasRecursiveBounds(typeParameter, $this$checkSubtypeForSpecialCases_u24lambda_u2429.typeConstructor(superType))) {
                return true;
            }
        }
        return null;
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext $this$getTypeParameterForArgumentInBaseIfItEqualToTarget, KotlinTypeMarker baseType, KotlinTypeMarker targetType) {
        int n2 = $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.argumentsCount(baseType);
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean areBothTypesCaptured;
            Object object = $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.getArgument(baseType, i2);
            TypeArgumentMarker it = object;
            boolean bl2 = false;
            Object object2 = !$this$getTypeParameterForArgumentInBaseIfItEqualToTarget.isStarProjection(it) ? object : null;
            if (object2 == null || (object2 = $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.getType((TypeArgumentMarker)object2)) == null) continue;
            Object typeArgument = object2;
            boolean bl3 = areBothTypesCaptured = $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.isCapturedType($this$getTypeParameterForArgumentInBaseIfItEqualToTarget.lowerBoundIfFlexible((KotlinTypeMarker)typeArgument)) && $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.isCapturedType($this$getTypeParameterForArgumentInBaseIfItEqualToTarget.lowerBoundIfFlexible(targetType));
            if (Intrinsics.areEqual(typeArgument, targetType) || areBothTypesCaptured && Intrinsics.areEqual($this$getTypeParameterForArgumentInBaseIfItEqualToTarget.typeConstructor((KotlinTypeMarker)typeArgument), $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.typeConstructor(targetType))) {
                return $this$getTypeParameterForArgumentInBaseIfItEqualToTarget.getParameter($this$getTypeParameterForArgumentInBaseIfItEqualToTarget.typeConstructor(baseType), i2);
            }
            object = this.getTypeParameterForArgumentInBaseIfItEqualToTarget($this$getTypeParameterForArgumentInBaseIfItEqualToTarget, (KotlinTypeMarker)typeArgument, targetType);
            if (object == null) continue;
            Object it2 = object;
            boolean bl4 = false;
            return it2;
        }
        return null;
    }

    private final List<RigidTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState state, RigidTypeMarker subType, TypeConstructorMarker superConstructor) {
        List result;
        block13: {
            TypeSystemContext $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435 = state.getTypeSystemContext();
            boolean bl2 = false;
            List<RigidTypeMarker> list = $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.fastCorrespondingSupertypes(subType, superConstructor);
            if (list != null) {
                List<RigidTypeMarker> it = list;
                boolean bl3 = false;
                return it;
            }
            if (!$this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.isClassTypeConstructor(superConstructor) && $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.isClassType(subType)) {
                return CollectionsKt.emptyList();
            }
            if ($this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.isCommonFinalClassConstructor(superConstructor)) {
                List<RigidTypeMarker> list2;
                if ($this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.areEqualTypeConstructors($this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.typeConstructor(subType), superConstructor)) {
                    RigidTypeMarker rigidTypeMarker = $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.captureFromArguments(subType, CaptureStatus.FOR_SUBTYPING);
                    if (rigidTypeMarker == null) {
                        rigidTypeMarker = subType;
                    }
                    list2 = CollectionsKt.listOf(rigidTypeMarker);
                } else {
                    list2 = CollectionsKt.emptyList();
                }
                return list2;
            }
            result = new SmartList();
            TypeCheckerState this_$iv = state;
            boolean $i$f$anySupertype = false;
            RigidTypeMarker it = subType;
            boolean bl4 = false;
            if (!false) {
                this_$iv.initialize();
                ArrayDeque<RigidTypeMarker> arrayDeque = this_$iv.getSupertypesDeque();
                Intrinsics.checkNotNull(arrayDeque);
                ArrayDeque<RigidTypeMarker> deque$iv = arrayDeque;
                Set<RigidTypeMarker> set = this_$iv.getSupertypesSet();
                Intrinsics.checkNotNull(set);
                Set<RigidTypeMarker> visitedSupertypes$iv = set;
                deque$iv.push(subType);
                while (!((Collection)deque$iv).isEmpty()) {
                    TypeCheckerState.SupertypesPolicy policy$iv;
                    TypeCheckerState.SupertypesPolicy supertypesPolicy;
                    RigidTypeMarker current$iv = deque$iv.pop();
                    Intrinsics.checkNotNull(current$iv);
                    if (!visitedSupertypes$iv.add(current$iv)) continue;
                    it = current$iv;
                    boolean bl5 = false;
                    RigidTypeMarker rigidTypeMarker = $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.captureFromArguments(it, CaptureStatus.FOR_SUBTYPING);
                    if (rigidTypeMarker == null) {
                        rigidTypeMarker = it;
                    }
                    RigidTypeMarker current = rigidTypeMarker;
                    if ($this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.areEqualTypeConstructors($this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.typeConstructor(current), superConstructor)) {
                        result.add(current);
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = $this$collectAllSupertypesWithGivenTypeConstructor_u24lambda_u2435.argumentsCount(current) == 0 ? (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE : state.getTypeSystemContext().substitutionSupertypePolicy(current);
                    }
                    TypeCheckerState.SupertypesPolicy supertypesPolicy2 = supertypesPolicy;
                    TypeCheckerState.SupertypesPolicy it$iv = supertypesPolicy2;
                    boolean bl6 = false;
                    if ((!Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE) ? supertypesPolicy2 : null) == null) continue;
                    policy$iv = policy$iv;
                    TypeSystemContext $this$anySupertype_u24lambda_u243$iv = this_$iv.getTypeSystemContext();
                    boolean bl7 = false;
                    Collection<KotlinTypeMarker> supertypes$iv = $this$anySupertype_u24lambda_u243$iv.supertypes($this$anySupertype_u24lambda_u243$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv;
                        it = newType$iv = policy$iv.transformType(this_$iv, supertype$iv);
                        bl4 = false;
                        if (false) {
                            this_$iv.clear();
                            break block13;
                        }
                        deque$iv.add(newType$iv);
                    }
                }
                this_$iv.clear();
            }
        }
        return result;
    }

    private final List<RigidTypeMarker> collectAndFilter(TypeCheckerState state, RigidTypeMarker classType, TypeConstructorMarker constructor) {
        return this.selectOnlyPureKotlinSupertypes(state, this.collectAllSupertypesWithGivenTypeConstructor(state, classType, constructor));
    }

    /*
     * WARNING - void declaration
     */
    private final List<RigidTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState state, List<? extends RigidTypeMarker> supertypes) {
        void $this$filterTo$iv$iv;
        TypeSystemContext $this$selectOnlyPureKotlinSupertypes_u24lambda_u2438 = state.getTypeSystemContext();
        boolean bl2 = false;
        if (supertypes.size() < 2) {
            return supertypes;
        }
        Iterable $this$filter$iv = supertypes;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl3;
            block3: {
                RigidTypeMarker it = (RigidTypeMarker)element$iv$iv;
                boolean bl4 = false;
                TypeArgumentListMarker $this$all$iv = $this$selectOnlyPureKotlinSupertypes_u24lambda_u2438.asArgumentList(it);
                boolean $i$f$all = false;
                TypeSystemContext $this$all_u24lambda_u241$iv = $this$selectOnlyPureKotlinSupertypes_u24lambda_u2438;
                boolean bl5 = false;
                int n2 = $this$all_u24lambda_u241$iv.size($this$all$iv);
                for (int i2 = 0; i2 < n2; ++i2) {
                    int index$iv = i2;
                    boolean bl6 = false;
                    TypeArgumentMarker it2 = $this$all_u24lambda_u241$iv.get($this$all$iv, index$iv);
                    boolean bl7 = false;
                    KotlinTypeMarker kotlinTypeMarker = $this$selectOnlyPureKotlinSupertypes_u24lambda_u2438.getType(it2);
                    if ((kotlinTypeMarker != null ? $this$selectOnlyPureKotlinSupertypes_u24lambda_u2438.asFlexibleType(kotlinTypeMarker) : null) == null) continue;
                    bl3 = false;
                    break block3;
                }
                bl3 = true;
            }
            if (!bl3) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List<RigidTypeMarker> allPureSupertypes = (List<RigidTypeMarker>)destination$iv$iv;
        return !((Collection)allPureSupertypes).isEmpty() ? allPureSupertypes : supertypes;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<RigidTypeMarker> findCorrespondingSupertypes(@NotNull TypeCheckerState state, @NotNull RigidTypeMarker subType, @NotNull TypeConstructorMarker superConstructor) {
        void $this$flatMapTo$iv$iv;
        Object it;
        SmartList<Object> classTypeSupertypes;
        block9: {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(subType, "subType");
            Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
            TypeSystemContext $this$findCorrespondingSupertypes_u24lambda_u2442 = state.getTypeSystemContext();
            boolean bl2 = false;
            if ($this$findCorrespondingSupertypes_u24lambda_u2442.isClassType(subType)) {
                return INSTANCE.collectAndFilter(state, subType, superConstructor);
            }
            if (!$this$findCorrespondingSupertypes_u24lambda_u2442.isClassTypeConstructor(superConstructor) && !$this$findCorrespondingSupertypes_u24lambda_u2442.isIntegerLiteralTypeConstructor(superConstructor)) {
                return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(state, subType, superConstructor);
            }
            classTypeSupertypes = new SmartList<Object>();
            TypeCheckerState this_$iv = state;
            boolean $i$f$anySupertype = false;
            it = subType;
            boolean bl3 = false;
            if (!false) {
                this_$iv.initialize();
                ArrayDeque<RigidTypeMarker> arrayDeque = this_$iv.getSupertypesDeque();
                Intrinsics.checkNotNull(arrayDeque);
                ArrayDeque<RigidTypeMarker> deque$iv = arrayDeque;
                Set<RigidTypeMarker> set = this_$iv.getSupertypesSet();
                Intrinsics.checkNotNull(set);
                Set<RigidTypeMarker> visitedSupertypes$iv = set;
                deque$iv.push(subType);
                while (!((Collection)deque$iv).isEmpty()) {
                    TypeCheckerState.SupertypesPolicy policy$iv;
                    TypeCheckerState.SupertypesPolicy supertypesPolicy;
                    RigidTypeMarker current$iv = deque$iv.pop();
                    Intrinsics.checkNotNull(current$iv);
                    if (!visitedSupertypes$iv.add(current$iv)) continue;
                    it = current$iv;
                    boolean bl4 = false;
                    if ($this$findCorrespondingSupertypes_u24lambda_u2442.isClassType((RigidTypeMarker)it)) {
                        classTypeSupertypes.add(it);
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    TypeCheckerState.SupertypesPolicy supertypesPolicy2 = supertypesPolicy;
                    TypeCheckerState.SupertypesPolicy it$iv = supertypesPolicy2;
                    boolean bl5 = false;
                    if ((!Intrinsics.areEqual(it$iv, TypeCheckerState.SupertypesPolicy.None.INSTANCE) ? supertypesPolicy2 : null) == null) continue;
                    policy$iv = policy$iv;
                    TypeSystemContext $this$anySupertype_u24lambda_u243$iv = this_$iv.getTypeSystemContext();
                    boolean bl6 = false;
                    Collection<KotlinTypeMarker> supertypes$iv = $this$anySupertype_u24lambda_u243$iv.supertypes($this$anySupertype_u24lambda_u243$iv.typeConstructor(current$iv));
                    for (KotlinTypeMarker supertype$iv : supertypes$iv) {
                        RigidTypeMarker newType$iv = policy$iv.transformType(this_$iv, supertype$iv);
                        it = newType$iv;
                        bl3 = false;
                        if (false) {
                            this_$iv.clear();
                            break block9;
                        }
                        deque$iv.add(newType$iv);
                    }
                }
                this_$iv.clear();
            }
        }
        Iterable $this$flatMap$iv = classTypeSupertypes;
        boolean $i$f$flatMap = false;
        it = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            RigidTypeMarker it2 = (RigidTypeMarker)element$iv$iv;
            boolean bl7 = false;
            Intrinsics.checkNotNull(it2);
            Iterable list$iv$iv = INSTANCE.collectAndFilter(state, it2, superConstructor);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(this, state, subType, superType, false, 8, null);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext $this_with, TypeCheckerState $state, RigidTypeMarker integerLiteralType, RigidTypeMarker type, boolean checkSupertypes) {
        boolean bl2;
        block3: {
            Iterable $this$any$iv = $this_with.possibleIntegerTypes(integerLiteralType);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    KotlinTypeMarker possibleType = (KotlinTypeMarker)element$iv;
                    boolean bl3 = false;
                    if (!(Intrinsics.areEqual($this_with.typeConstructor(possibleType), $this_with.typeConstructor(type)) || checkSupertypes && AbstractTypeChecker.isSubtypeOf$default(INSTANCE, $state, type, possibleType, false, 8, null))) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext $this_with, RigidTypeMarker type) {
        boolean bl2;
        TypeConstructorMarker typeConstructor2 = $this_with.typeConstructor(type);
        if (!(typeConstructor2 instanceof IntersectionTypeConstructorMarker)) return false;
        Iterable $this$any$iv = $this_with.supertypes(typeConstructor2);
        boolean $i$f$any = false;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            return false;
        }
        Iterator iterator2 = $this$any$iv.iterator();
        do {
            if (!iterator2.hasNext()) return false;
            Object element$iv = iterator2.next();
            KotlinTypeMarker it = (KotlinTypeMarker)element$iv;
            boolean bl3 = false;
            RigidTypeMarker rigidTypeMarker = $this_with.asRigidType(it);
            if (rigidTypeMarker != null) {
                if ($this_with.isIntegerLiteralType(rigidTypeMarker)) {
                    return true;
                }
                bl2 = false;
                continue;
            }
            bl2 = false;
        } while (!bl2);
        return true;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext $this_with, RigidTypeMarker type) {
        if (!(type instanceof CapturedTypeMarker)) {
            return false;
        }
        TypeArgumentMarker projection = $this_with.projection($this_with.typeConstructor((CapturedTypeMarker)type));
        KotlinTypeMarker kotlinTypeMarker = $this_with.getType(projection);
        return kotlinTypeMarker != null && (kotlinTypeMarker = $this_with.upperBoundIfFlexible(kotlinTypeMarker)) != null ? $this_with.isIntegerLiteralType((RigidTypeMarker)kotlinTypeMarker) : false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext $this_with, RigidTypeMarker type) {
        return $this_with.isIntegerLiteralType(type) || AbstractTypeChecker.checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType($this_with, type);
    }

    private static final boolean isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(TypeCheckerState $state, TypeSystemContext $this_with, RigidTypeMarker $subTypeArguments, RigidTypeMarker $superType) {
        return INSTANCE.isSubtypeForSameConstructor($state, $this_with.asArgumentList($subTypeArguments), $superType);
    }

    private static final Unit isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(Collection $supertypesWithSameConstructor, TypeCheckerState $state, TypeSystemContext $this_with, RigidTypeMarker $superType, TypeCheckerState.ForkPointContext $this$runForkingPoint) {
        Intrinsics.checkNotNullParameter($this$runForkingPoint, "$this$runForkingPoint");
        for (RigidTypeMarker subTypeArguments : $supertypesWithSameConstructor) {
            RigidTypeMarker rigidTypeMarker = $superType;
            RigidTypeMarker rigidTypeMarker2 = subTypeArguments;
            TypeSystemContext typeSystemContext = $this_with;
            TypeCheckerState typeCheckerState = $state;
            $this$runForkingPoint.fork(new AbstractTypeChecker$$Lambda$1(typeCheckerState, typeSystemContext, rigidTypeMarker2, rigidTypeMarker));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Unit accessor$AbstractTypeChecker$lambda0(Collection collection, TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeCheckerState.ForkPointContext forkPointContext) {
        return AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(collection, typeCheckerState, typeSystemContext, rigidTypeMarker, forkPointContext);
    }

    static /* synthetic */ boolean accessor$AbstractTypeChecker$lambda1(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        return AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(typeCheckerState, typeSystemContext, rigidTypeMarker, rigidTypeMarker2);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[TypeVariance.values().length];
            try {
                nArray[TypeVariance.INV.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TypeVariance.OUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TypeVariance.IN.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                nArray[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

