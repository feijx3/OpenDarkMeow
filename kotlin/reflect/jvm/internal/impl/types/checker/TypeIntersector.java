/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$$Lambda$0;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1563#2:184\n1634#2,2:185\n1636#2:188\n1803#2,3:189\n1634#2,3:192\n1563#2:195\n1634#2,3:196\n2783#2,7:199\n1761#2,3:206\n1#3:187\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n*L\n80#1:184\n80#1:185,2\n80#1:188\n87#1:189,3\n98#1:192,3\n104#1:195\n104#1:196,3\n104#1:199,7\n137#1:206,3\n*E\n"})
public final class TypeIntersector {
    @NotNull
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    private TypeIntersector() {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final SimpleType intersectTypes$descriptors(@NotNull List<? extends SimpleType> types) {
        void $this$reduce$iv;
        void $this$mapTo$iv$iv;
        void $this$mapTo$iv;
        SimpleType p1;
        Object destination$iv$iv;
        Collection<void> collection;
        boolean bl2;
        Intrinsics.checkNotNullParameter(types, "types");
        boolean bl3 = bl2 = types.size() > 1;
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-TypeIntersector$intersectTypes$232 = false;
            String $i$a$-assert-TypeIntersector$intersectTypes$232 = "Size should be at least 2, but it is " + types.size();
            throw new AssertionError((Object)$i$a$-assert-TypeIntersector$intersectTypes$232);
        }
        ArrayList<SimpleType> inputTypes = new ArrayList<SimpleType>();
        for (SimpleType simpleType : types) {
            boolean bl4;
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                void $this$mapTo$iv$iv2;
                void $this$map$iv;
                Collection<KotlinType> collection2 = simpleType.getConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(collection2, "getSupertypes(...)");
                Iterable iterable = collection2;
                collection = inputTypes;
                boolean $i$f$map = false;
                void var7_13 = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv2) {
                    void it;
                    KotlinType kotlinType = (KotlinType)item$iv$iv;
                    Iterator iterator2 = destination$iv$iv;
                    boolean bl5 = false;
                    Intrinsics.checkNotNull(it);
                    SimpleType it2 = FlexibleTypesKt.upperIfFlexible((KotlinType)it);
                    boolean bl6 = false;
                    iterator2.add((SimpleType)(simpleType.isMarkedNullable() ? it2.makeNullableAsSpecified(true) : it2));
                }
                bl4 = ((ArrayList)collection).addAll((List)destination$iv$iv);
                continue;
            }
            bl4 = inputTypes.add(simpleType);
        }
        Iterable iterable = inputTypes;
        Object initial$iv = ResultNullability.START;
        boolean $i$f$fold = false;
        ResultNullability accumulator$iv = initial$iv;
        for (Object element$iv : iterable) {
            UnwrappedType unwrappedType = (UnwrappedType)element$iv;
            ResultNullability p0 = accumulator$iv;
            boolean bl7 = false;
            accumulator$iv = p0.combine(p1);
        }
        ResultNullability resultNullability = accumulator$iv;
        initial$iv = inputTypes;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            p1 = (SimpleType)item$iv;
            collection = destination$iv;
            boolean bl8 = false;
            collection.add((void)(resultNullability == ResultNullability.NOT_NULL ? SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default((SimpleType)(it instanceof NewCapturedType ? (SimpleType)SpecialTypesKt.withNotNullProjection((NewCapturedType)it) : it), false, 1, null) : it));
        }
        LinkedHashSet linkedHashSet = (LinkedHashSet)destination$iv;
        Iterable $this$map$iv = types;
        boolean $i$f$map = false;
        destination$iv$iv = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo222 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            SimpleType bl5 = (SimpleType)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl9 = false;
            collection.add((void)it.getAttributes());
        }
        $this$map$iv = (List)destination$iv$iv2;
        boolean $i$f$reduce = false;
        Iterator iterator$iv = $this$reduce$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object accumulator$iv2 = iterator$iv.next();
        while (iterator$iv.hasNext()) {
            void y2;
            TypeAttributes $i$f$mapTo222 = (TypeAttributes)iterator$iv.next();
            TypeAttributes x2 = (TypeAttributes)accumulator$iv2;
            boolean bl10 = false;
            accumulator$iv2 = x2.intersect((TypeAttributes)y2);
        }
        TypeAttributes resultAttributes = (TypeAttributes)accumulator$iv2;
        return this.intersectTypesWithoutIntersectionType(linkedHashSet).replaceAttributes(resultAttributes);
    }

    private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> inputTypes) {
        boolean bl2;
        boolean bl3;
        if (inputTypes.size() == 1) {
            return (SimpleType)CollectionsKt.single((Iterable)inputTypes);
        }
        Set<? extends SimpleType> set = inputTypes;
        TypeIntersector$$Lambda$0 errorMessage = new TypeIntersector$$Lambda$0(set);
        Collection<SimpleType> filteredEqualTypes2 = this.filterTypes((Collection<? extends SimpleType>)inputTypes, (Function2<? super SimpleType, ? super SimpleType, Boolean>)new Function2<KotlinType, KotlinType, Boolean>((Object)this){

            public final Boolean invoke(KotlinType p0, KotlinType p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                return TypeIntersector.access$isStrictSupertype((TypeIntersector)this.receiver, p0, p1);
            }
        });
        boolean bl4 = bl3 = !filteredEqualTypes2.isEmpty();
        if (_Assertions.ENABLED && !bl3) {
            Object r2 = errorMessage.invoke();
            throw new AssertionError(r2);
        }
        SimpleType simpleType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filteredEqualTypes2);
        if (simpleType != null) {
            SimpleType it = simpleType;
            boolean bl5 = false;
            return it;
        }
        Collection<SimpleType> filteredSuperAndEqualTypes2 = this.filterTypes(filteredEqualTypes2, (Function2<? super SimpleType, ? super SimpleType, Boolean>)new Function2<KotlinType, KotlinType, Boolean>((Object)NewKotlinTypeChecker.Companion.getDefault()){

            public final Boolean invoke(KotlinType p0, KotlinType p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                return ((NewKotlinTypeCheckerImpl)this.receiver).equalTypes(p0, p1);
            }
        });
        boolean bl6 = bl2 = !filteredSuperAndEqualTypes2.isEmpty();
        if (_Assertions.ENABLED && !bl2) {
            Object r3 = errorMessage.invoke();
            throw new AssertionError(r3);
        }
        if (filteredSuperAndEqualTypes2.size() < 2) {
            return (SimpleType)CollectionsKt.single((Iterable)filteredSuperAndEqualTypes2);
        }
        return new IntersectionTypeConstructor((Collection<? extends KotlinType>)inputTypes).createType();
    }

    /*
     * Unable to fully structure code
     */
    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> inputTypes, Function2<? super SimpleType, ? super SimpleType, Boolean> predicate) {
        filteredTypes = new ArrayList<SimpleType>(inputTypes);
        v0 = filteredTypes.iterator();
        Intrinsics.checkNotNullExpressionValue(v0, "iterator(...)");
        iterator = v0;
        while (iterator.hasNext()) {
            block4: {
                block5: {
                    upper = iterator.next();
                    $this$any$iv = filteredTypes;
                    $i$f$any = false;
                    if (!($this$any$iv instanceof Collection) || !((Collection)$this$any$iv).isEmpty()) break block5;
                    v1 = false;
                    break block4;
                }
                for (T element$iv : $this$any$iv) {
                    lower = (SimpleType)element$iv;
                    $i$a$-any-TypeIntersector$filterTypes$shouldFilter$1 = false;
                    if (lower == upper) ** GOTO lbl-1000
                    Intrinsics.checkNotNull(lower);
                    Intrinsics.checkNotNull(upper);
                    if (predicate.invoke(lower, upper).booleanValue()) {
                        v2 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v2 = false;
                    }
                    if (!v2) continue;
                    v1 = true;
                    break block4;
                }
                v1 = false;
            }
            if (!(shouldFilter = v1)) continue;
            iterator.remove();
        }
        return filteredTypes;
    }

    private final boolean isStrictSupertype(KotlinType subtype, KotlinType supertype) {
        NewKotlinTypeCheckerImpl $this$isStrictSupertype_u24lambda_u249 = NewKotlinTypeChecker.Companion.getDefault();
        boolean bl2 = false;
        return $this$isStrictSupertype_u24lambda_u249.isSubtypeOf(subtype, supertype) && !$this$isStrictSupertype_u24lambda_u249.isSubtypeOf(supertype, subtype);
    }

    private static final String intersectTypesWithoutIntersectionType$lambda$6(Set $inputTypes) {
        return "This collections cannot be empty! input types: " + CollectionsKt.joinToString$default($inputTypes, null, null, null, 0, null, null, 63, null);
    }

    public static final /* synthetic */ boolean access$isStrictSupertype(TypeIntersector $this, KotlinType subtype, KotlinType supertype) {
        return $this.isStrictSupertype(subtype, supertype);
    }

    static /* synthetic */ String accessor$TypeIntersector$lambda0(Set set) {
        return TypeIntersector.intersectTypesWithoutIntersectionType$lambda$6(set);
    }

    private static final abstract class ResultNullability
    extends Enum<ResultNullability> {
        public static final /* enum */ ResultNullability START = new START("START", 0);
        public static final /* enum */ ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final /* enum */ ResultNullability UNKNOWN = new UNKNOWN("UNKNOWN", 2);
        public static final /* enum */ ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);
        private static final /* synthetic */ ResultNullability[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private ResultNullability() {
        }

        @NotNull
        public abstract ResultNullability combine(@NotNull UnwrappedType var1);

        @NotNull
        protected final ResultNullability getResultNullability(@NotNull UnwrappedType $this$resultNullability) {
            Intrinsics.checkNotNullParameter($this$resultNullability, "<this>");
            return $this$resultNullability.isMarkedNullable() ? ACCEPT_NULL : ($this$resultNullability instanceof DefinitelyNotNullType && ((DefinitelyNotNullType)$this$resultNullability).getOriginal() instanceof StubTypeForBuilderInference ? NOT_NULL : ($this$resultNullability instanceof StubTypeForBuilderInference ? UNKNOWN : (NullabilityChecker.INSTANCE.isSubtypeOfAny($this$resultNullability) ? NOT_NULL : UNKNOWN)));
        }

        public static ResultNullability[] values() {
            return (ResultNullability[])$VALUES.clone();
        }

        public static ResultNullability valueOf(String value) {
            return Enum.valueOf(ResultNullability.class, value);
        }

        public /* synthetic */ ResultNullability(String $enum$name, int $enum$ordinal, DefaultConstructorMarker $constructor_marker) {
            this();
        }

        static {
            $VALUES = resultNullabilityArray = new ResultNullability[]{ResultNullability.START, ResultNullability.ACCEPT_NULL, ResultNullability.UNKNOWN, ResultNullability.NOT_NULL};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }

        static final class ACCEPT_NULL
        extends ResultNullability {
            /*
             * WARNING - void declaration
             */
            ACCEPT_NULL() {
                void var1_1;
            }

            @Override
            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return this.getResultNullability(nextType);
            }
        }

        static final class NOT_NULL
        extends ResultNullability {
            /*
             * WARNING - void declaration
             */
            NOT_NULL() {
                void var1_1;
            }

            @Override
            @NotNull
            public NOT_NULL combine(@NotNull UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return this;
            }
        }

        static final class START
        extends ResultNullability {
            /*
             * WARNING - void declaration
             */
            START() {
                void var1_1;
            }

            @Override
            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return this.getResultNullability(nextType);
            }
        }

        static final class UNKNOWN
        extends ResultNullability {
            /*
             * WARNING - void declaration
             */
            UNKNOWN() {
                void var1_1;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType nextType) {
                void var2_2;
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                ResultNullability it = this.getResultNullability(nextType);
                boolean bl2 = false;
                return it == ACCEPT_NULL ? (ResultNullability)this : var2_2;
            }
        }
    }
}

