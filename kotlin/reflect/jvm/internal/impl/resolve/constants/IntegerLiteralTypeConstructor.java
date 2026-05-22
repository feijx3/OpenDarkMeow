/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.resolve.constants.PrimitiveTypeUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1740#2,3:182\n1761#2,3:185\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n*L\n132#1:182,3\n176#1:185,3\n*E\n"})
public final class IntegerLiteralTypeConstructor
implements TypeConstructor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long value;
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final Set<KotlinType> possibleTypes;
    @NotNull
    private final SimpleType type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
    @NotNull
    private final Lazy supertypes$delegate;

    @NotNull
    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    private IntegerLiteralTypeConstructor(long value, ModuleDescriptor module, Set<? extends KotlinType> possibleTypes) {
        IntegerLiteralTypeConstructor integerLiteralTypeConstructor = this;
        this.supertypes$delegate = LazyKt.lazy(new IntegerLiteralTypeConstructor$$Lambda$0(integerLiteralTypeConstructor));
        this.value = value;
        this.module = module;
        this.possibleTypes = possibleTypes;
    }

    private final boolean isContainsOnlyUnsignedTypes() {
        boolean bl2;
        block3: {
            Iterable $this$all$iv = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    KotlinType it = (KotlinType)element$iv;
                    boolean bl3 = false;
                    if (!this.possibleTypes.contains(it)) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    private final List<KotlinType> getSupertypes() {
        Lazy lazy = this.supertypes$delegate;
        return (List)lazy.getValue();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return this.getSupertypes();
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Override
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        return "IntegerLiteralType" + this.valueToString();
    }

    private final String valueToString() {
        return '[' + CollectionsKt.joinToString$default(this.possibleTypes, ",", null, null, 0, null, IntegerLiteralTypeConstructor$$Lambda$1.INSTANCE, 30, null) + ']';
    }

    private static final List supertypes_delegate$lambda$2(IntegerLiteralTypeConstructor this$0) {
        SimpleType[] simpleTypeArray = new SimpleType[1];
        SimpleType simpleType = this$0.getBuiltIns().getComparable().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        simpleTypeArray[0] = TypeSubstitutionKt.replace$default(simpleType, CollectionsKt.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, this$0.type)), null, 2, null);
        List<SimpleType> result = CollectionsKt.mutableListOf(simpleTypeArray);
        if (!this$0.isContainsOnlyUnsignedTypes()) {
            ((Collection)result).add(this$0.getBuiltIns().getNumberType());
        }
        return result;
    }

    private static final CharSequence valueToString$lambda$4(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long value, ModuleDescriptor module, Set possibleTypes, DefaultConstructorMarker $constructor_marker) {
        this(value, module, possibleTypes);
    }

    static /* synthetic */ List accessor$IntegerLiteralTypeConstructor$lambda0(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        return IntegerLiteralTypeConstructor.supertypes_delegate$lambda$2(integerLiteralTypeConstructor);
    }

    static /* synthetic */ CharSequence accessor$IntegerLiteralTypeConstructor$lambda1(KotlinType kotlinType) {
        return IntegerLiteralTypeConstructor.valueToString$lambda$4(kotlinType);
    }

    @SourceDebugExtension(value={"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n2783#2,7:182\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n*L\n40#1:182,7\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final SimpleType findIntersectionType(@NotNull Collection<? extends SimpleType> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return this.findCommonSuperTypeOrIntersectionType(types, Mode.INTERSECTION_TYPE);
        }

        /*
         * WARNING - void declaration
         */
        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> types, Mode mode) {
            if (types.isEmpty()) {
                return null;
            }
            Iterable $this$reduce$iv = types;
            boolean $i$f$reduce = false;
            Iterator iterator$iv = $this$reduce$iv.iterator();
            if (!iterator$iv.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object accumulator$iv = iterator$iv.next();
            while (iterator$iv.hasNext()) {
                void right;
                SimpleType simpleType = (SimpleType)iterator$iv.next();
                SimpleType left = (SimpleType)accumulator$iv;
                boolean bl2 = false;
                accumulator$iv = Companion.fold(left, (SimpleType)right, mode);
            }
            return (SimpleType)accumulator$iv;
        }

        private final SimpleType fold(SimpleType left, SimpleType right, Mode mode) {
            if (left == null || right == null) {
                return null;
            }
            TypeConstructor leftConstructor = left.getConstructor();
            TypeConstructor rightConstructor = right.getConstructor();
            return leftConstructor instanceof IntegerLiteralTypeConstructor && rightConstructor instanceof IntegerLiteralTypeConstructor ? this.fold((IntegerLiteralTypeConstructor)leftConstructor, (IntegerLiteralTypeConstructor)rightConstructor, mode) : (leftConstructor instanceof IntegerLiteralTypeConstructor ? this.fold((IntegerLiteralTypeConstructor)leftConstructor, right) : (rightConstructor instanceof IntegerLiteralTypeConstructor ? this.fold((IntegerLiteralTypeConstructor)rightConstructor, left) : null));
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor left, IntegerLiteralTypeConstructor right, Mode mode) {
            Set set;
            switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
                case 1: {
                    set = CollectionsKt.intersect((Iterable)left.getPossibleTypes(), (Iterable)right.getPossibleTypes());
                    break;
                }
                case 2: {
                    set = CollectionsKt.union((Iterable)left.getPossibleTypes(), (Iterable)right.getPossibleTypes());
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Set possibleTypes = set;
            IntegerLiteralTypeConstructor constructor = new IntegerLiteralTypeConstructor(left.value, left.module, possibleTypes, null);
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), constructor, false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor left, SimpleType right) {
            return left.getPossibleTypes().contains(right) ? right : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private static final class Mode
        extends Enum<Mode> {
            public static final /* enum */ Mode COMMON_SUPER_TYPE = new Mode();
            public static final /* enum */ Mode INTERSECTION_TYPE = new Mode();
            private static final /* synthetic */ Mode[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            public static Mode[] values() {
                return (Mode[])$VALUES.clone();
            }

            public static Mode valueOf(String value) {
                return Enum.valueOf(Mode.class, value);
            }

            static {
                $VALUES = modeArray = new Mode[]{Mode.COMMON_SUPER_TYPE, Mode.INTERSECTION_TYPE};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }

        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[Mode.values().length];
                try {
                    nArray[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

