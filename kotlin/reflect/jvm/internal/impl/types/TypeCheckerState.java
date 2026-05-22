/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
public class TypeCheckerState {
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final boolean isDnnTypesEqualToFlexible;
    private final boolean allowedTypeVariable;
    @NotNull
    private final TypeSystemContext typeSystemContext;
    @NotNull
    private final AbstractTypePreparator kotlinTypePreparator;
    @NotNull
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private int argumentsDepth;
    private boolean supertypesLocked;
    @Nullable
    private ArrayDeque<RigidTypeMarker> supertypesDeque;
    @Nullable
    private Set<RigidTypeMarker> supertypesSet;

    public TypeCheckerState(boolean isErrorTypeEqualsToAnything, boolean isStubTypeEqualsToAnything, boolean isDnnTypesEqualToFlexible, boolean allowedTypeVariable, @NotNull TypeSystemContext typeSystemContext, @NotNull AbstractTypePreparator kotlinTypePreparator, @NotNull AbstractTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "typeSystemContext");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = isErrorTypeEqualsToAnything;
        this.isStubTypeEqualsToAnything = isStubTypeEqualsToAnything;
        this.isDnnTypesEqualToFlexible = isDnnTypesEqualToFlexible;
        this.allowedTypeVariable = allowedTypeVariable;
        this.typeSystemContext = typeSystemContext;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final boolean isDnnTypesEqualToFlexible() {
        return this.isDnnTypesEqualToFlexible;
    }

    @NotNull
    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    @NotNull
    public final KotlinTypeMarker refineType(@NotNull KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypeRefiner.refineType(type);
    }

    @NotNull
    public final KotlinTypeMarker prepareType(@NotNull KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypePreparator.prepareType(type);
    }

    public boolean customIsSubtypeOf(@NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return true;
    }

    @NotNull
    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(@NotNull RigidTypeMarker subType, @NotNull CapturedTypeMarker superType) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Nullable
    public Boolean addSubtypeConstraint(@NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType, boolean isFromNullabilityConstraint) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return null;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        return typeCheckerState.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, bl2);
    }

    public boolean runForkingPoint(@NotNull Function1<? super ForkPointContext, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ForkPointContext.Default $this$runForkingPoint_u24lambda_u240 = new ForkPointContext.Default();
        boolean bl2 = false;
        block.invoke($this$runForkingPoint_u24lambda_u240);
        return $this$runForkingPoint_u24lambda_u240.getResult();
    }

    @Nullable
    public final ArrayDeque<RigidTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    @Nullable
    public final Set<RigidTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final void initialize() {
        boolean bl2;
        boolean bl3 = bl2 = !this.supertypesLocked;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Supertypes were locked for " + Reflection.getOrCreateKotlinClass(this.getClass());
            throw new AssertionError((Object)string);
        }
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    public final void clear() {
        ArrayDeque<RigidTypeMarker> arrayDeque = this.supertypesDeque;
        Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<RigidTypeMarker> set = this.supertypesSet;
        Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isAllowedTypeVariable(@NotNull KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.allowedTypeVariable) return false;
        TypeSystemContext $this$isAllowedTypeVariable_u24lambda_u244 = this.typeSystemContext;
        boolean bl2 = false;
        if (!$this$isAllowedTypeVariable_u24lambda_u244.isTypeVariableType(type)) return false;
        return true;
    }

    public static final /* synthetic */ int access$getArgumentsDepth(TypeCheckerState $this) {
        return $this.argumentsDepth;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(TypeCheckerState $this, int n2) {
        $this.argumentsDepth = n2;
    }

    public static interface ForkPointContext {
        public void fork(@NotNull Function0<Boolean> var1);

        public static final class Default
        implements ForkPointContext {
            private boolean result;

            public final boolean getResult() {
                return this.result;
            }

            @Override
            public void fork(@NotNull Function0<Boolean> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                if (this.result) {
                    return;
                }
                this.result = block.invoke();
            }
        }
    }

    public static final class LowerCapturedTypePolicy
    extends Enum<LowerCapturedTypePolicy> {
        public static final /* enum */ LowerCapturedTypePolicy CHECK_ONLY_LOWER = new LowerCapturedTypePolicy();
        public static final /* enum */ LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy();
        public static final /* enum */ LowerCapturedTypePolicy SKIP_LOWER = new LowerCapturedTypePolicy();
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[])$VALUES.clone();
        }

        public static LowerCapturedTypePolicy valueOf(String value) {
            return Enum.valueOf(LowerCapturedTypePolicy.class, value);
        }

        static {
            $VALUES = lowerCapturedTypePolicyArray = new LowerCapturedTypePolicy[]{LowerCapturedTypePolicy.CHECK_ONLY_LOWER, LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER, LowerCapturedTypePolicy.SKIP_LOWER};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    public static abstract class SupertypesPolicy {
        private SupertypesPolicy() {
        }

        @NotNull
        public abstract RigidTypeMarker transformType(@NotNull TypeCheckerState var1, @NotNull KotlinTypeMarker var2);

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static abstract class DoCustomTransform
        extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        @SourceDebugExtension(value={"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$LowerIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
        public static final class LowerIfFlexible
        extends SupertypesPolicy {
            @NotNull
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            private LowerIfFlexible() {
                super(null);
            }

            @Override
            @NotNull
            public RigidTypeMarker transformType(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                TypeSystemContext $this$transformType_u24lambda_u240 = state.getTypeSystemContext();
                boolean bl2 = false;
                return $this$transformType_u24lambda_u240.lowerBoundIfFlexible(type);
            }
        }

        public static final class None
        extends SupertypesPolicy {
            @NotNull
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }

            @NotNull
            public Void transformType(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        @SourceDebugExtension(value={"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$UpperIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
        public static final class UpperIfFlexible
        extends SupertypesPolicy {
            @NotNull
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            private UpperIfFlexible() {
                super(null);
            }

            @Override
            @NotNull
            public RigidTypeMarker transformType(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                TypeSystemContext $this$transformType_u24lambda_u240 = state.getTypeSystemContext();
                boolean bl2 = false;
                return $this$transformType_u24lambda_u240.upperBoundIfFlexible(type);
            }
        }
    }
}

