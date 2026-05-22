/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Set;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n+ 2 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n140#2,13:885\n153#2,13:899\n140#2,13:912\n153#2,13:926\n1#3:898\n1#3:925\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n*L\n828#1:885,13\n828#1:899,13\n842#1:912,13\n842#1:926,13\n828#1:898\n842#1:925\n*E\n"})
public final class AbstractNullabilityChecker {
    @NotNull
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(@NotNull TypeCheckerState state, @NotNull RigidTypeMarker subType, @NotNull RigidTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return this.runIsPossibleSubtype(state, subType, superType);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        TypeSystemContext $this$runIsPossibleSubtype_u24lambda_u243 = state.getTypeSystemContext();
        boolean bl2 = false;
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            boolean bl3;
            boolean bl4 = bl3 = $this$runIsPossibleSubtype_u24lambda_u243.isSingleClassifierType(subType) || $this$runIsPossibleSubtype_u24lambda_u243.isIntersection($this$runIsPossibleSubtype_u24lambda_u243.typeConstructor(subType)) || state.isAllowedTypeVariable(subType);
            if (_Assertions.ENABLED && !bl3) {
                boolean $i$a$-assert-AbstractNullabilityChecker$runIsPossibleSubtype$1$32 = false;
                String $i$a$-assert-AbstractNullabilityChecker$runIsPossibleSubtype$1$32 = "Not singleClassifierType and not intersection subType: " + subType;
                throw new AssertionError((Object)$i$a$-assert-AbstractNullabilityChecker$runIsPossibleSubtype$1$32);
            }
            boolean bl5 = bl3 = $this$runIsPossibleSubtype_u24lambda_u243.isSingleClassifierType(superType) || state.isAllowedTypeVariable(superType);
            if (_Assertions.ENABLED && !bl3) {
                boolean bl6 = false;
                String string = "Not singleClassifierType superType: " + superType;
                throw new AssertionError((Object)string);
            }
        }
        if ($this$runIsPossibleSubtype_u24lambda_u243.isMarkedNullable(superType)) {
            return true;
        }
        if ($this$runIsPossibleSubtype_u24lambda_u243.isDefinitelyNotNullType(subType) || $this$runIsPossibleSubtype_u24lambda_u243.isNotNullTypeParameter(subType)) {
            return true;
        }
        if (subType instanceof CapturedTypeMarker && $this$runIsPossibleSubtype_u24lambda_u243.isProjectionNotNull((CapturedTypeMarker)subType)) {
            return true;
        }
        if (INSTANCE.hasNotNullSupertype(state, subType, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if ($this$runIsPossibleSubtype_u24lambda_u243.isDefinitelyNotNullType(superType)) {
            return false;
        }
        if (INSTANCE.hasNotNullSupertype(state, superType, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE)) {
            return false;
        }
        if ($this$runIsPossibleSubtype_u24lambda_u243.isClassType(subType)) {
            return false;
        }
        return INSTANCE.hasPathByNotMarkedNullableNodes(state, subType, $this$runIsPossibleSubtype_u24lambda_u243.typeConstructor(superType));
    }

    public final boolean hasNotNullSupertype(@NotNull TypeCheckerState $this$hasNotNullSupertype, @NotNull RigidTypeMarker type, @NotNull TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        boolean bl2;
        block5: {
            Intrinsics.checkNotNullParameter($this$hasNotNullSupertype, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
            TypeSystemContext $this$hasNotNullSupertype_u24lambda_u246 = $this$hasNotNullSupertype.getTypeSystemContext();
            boolean bl3 = false;
            TypeCheckerState this_$iv = $this$hasNotNullSupertype;
            boolean $i$f$anySupertype = false;
            RigidTypeMarker it = type;
            boolean bl4 = false;
            if ($this$hasNotNullSupertype_u24lambda_u246.isClassType(it) && !$this$hasNotNullSupertype_u24lambda_u246.isMarkedNullable(it) || $this$hasNotNullSupertype_u24lambda_u246.isDefinitelyNotNullType(it)) {
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
                    TypeCheckerState.SupertypesPolicy supertypesPolicy2 = $this$hasNotNullSupertype_u24lambda_u246.isMarkedNullable(it) ? (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
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
                        if ($this$hasNotNullSupertype_u24lambda_u246.isClassType(it) && !$this$hasNotNullSupertype_u24lambda_u246.isMarkedNullable(it) || $this$hasNotNullSupertype_u24lambda_u246.isDefinitelyNotNullType(it)) {
                            this_$iv.clear();
                            bl2 = true;
                            break block5;
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

    public final boolean hasPathByNotMarkedNullableNodes(@NotNull TypeCheckerState state, @NotNull RigidTypeMarker start, @NotNull TypeConstructorMarker end) {
        boolean bl2;
        block5: {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(end, "end");
            TypeSystemContext $this$hasPathByNotMarkedNullableNodes_u24lambda_u249 = state.getTypeSystemContext();
            boolean bl3 = false;
            TypeCheckerState this_$iv = state;
            boolean $i$f$anySupertype = false;
            RigidTypeMarker it = start;
            boolean bl4 = false;
            if (INSTANCE.isApplicableAsEndNode(state, it, end)) {
                bl2 = true;
            } else {
                this_$iv.initialize();
                ArrayDeque<RigidTypeMarker> arrayDeque = this_$iv.getSupertypesDeque();
                Intrinsics.checkNotNull(arrayDeque);
                ArrayDeque<RigidTypeMarker> deque$iv = arrayDeque;
                Set<RigidTypeMarker> set = this_$iv.getSupertypesSet();
                Intrinsics.checkNotNull(set);
                Set<RigidTypeMarker> visitedSupertypes$iv = set;
                deque$iv.push(start);
                while (!((Collection)deque$iv).isEmpty()) {
                    TypeCheckerState.SupertypesPolicy policy$iv;
                    RigidTypeMarker current$iv = deque$iv.pop();
                    Intrinsics.checkNotNull(current$iv);
                    if (!visitedSupertypes$iv.add(current$iv)) continue;
                    it = current$iv;
                    boolean bl5 = false;
                    TypeCheckerState.SupertypesPolicy supertypesPolicy = $this$hasPathByNotMarkedNullableNodes_u24lambda_u249.isMarkedNullable(it) ? (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.None.INSTANCE : (TypeCheckerState.SupertypesPolicy)TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
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
                        if (INSTANCE.isApplicableAsEndNode(state, it, end)) {
                            this_$iv.clear();
                            bl2 = true;
                            break block5;
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

    private final boolean isApplicableAsEndNode(TypeCheckerState state, RigidTypeMarker type, TypeConstructorMarker end) {
        TypeSystemContext $this$isApplicableAsEndNode_u24lambda_u2410 = state.getTypeSystemContext();
        boolean bl2 = false;
        if ($this$isApplicableAsEndNode_u24lambda_u2410.isNothing(type)) {
            return true;
        }
        if ($this$isApplicableAsEndNode_u24lambda_u2410.isMarkedNullable(type)) {
            return false;
        }
        if (state.isStubTypeEqualsToAnything() && $this$isApplicableAsEndNode_u24lambda_u2410.isStubType(type)) {
            return true;
        }
        return $this$isApplicableAsEndNode_u24lambda_u2410.areEqualTypeConstructors($this$isApplicableAsEndNode_u24lambda_u2410.typeConstructor(type), end);
    }
}

