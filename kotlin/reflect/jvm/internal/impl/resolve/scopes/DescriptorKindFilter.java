/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1869#2,2:262\n1740#2,3:264\n295#2,2:267\n1617#2,9:269\n1869#2:278\n1870#2:280\n1626#2:281\n1617#2,9:286\n1869#2:295\n1870#2:297\n1626#2:298\n774#2:303\n865#2,2:304\n1617#2,9:306\n1869#2:315\n1870#2:317\n1626#2:318\n1#3:279\n1#3:296\n1#3:316\n210#4:282\n210#4:299\n3829#5:283\n4344#5,2:284\n3829#5:300\n4344#5,2:301\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n*L\n98#1:262,2\n103#1:264,3\n129#1:267,2\n131#1:269,9\n131#1:278\n131#1:280\n131#1:281\n197#1:286,9\n197#1:295\n197#1:297\n197#1:298\n203#1:303\n203#1:304,2\n204#1:306,9\n204#1:315\n204#1:317\n204#1:318\n131#1:279\n197#1:296\n204#1:316\n196#1:282\n202#1:299\n196#1:283\n196#1:284,2\n202#1:300\n202#1:301,2\n*E\n"})
public final class DescriptorKindFilter {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;
    private static int nextMaskValue;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK;
    private static final int SINGLETON_CLASSIFIERS_MASK;
    private static final int TYPE_ALIASES_MASK;
    private static final int PACKAGES_MASK;
    private static final int FUNCTIONS_MASK;
    private static final int VARIABLES_MASK;
    private static final int ALL_KINDS_MASK;
    private static final int CLASSIFIERS_MASK;
    private static final int VALUES_MASK;
    private static final int CALLABLES_MASK;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter ALL;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CALLABLES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter TYPE_ALIASES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter PACKAGES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter FUNCTIONS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VARIABLES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VALUES;
    @NotNull
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    @NotNull
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;

    public DescriptorKindFilter(int kindMask, @NotNull List<? extends DescriptorKindExclude> excludes) {
        Intrinsics.checkNotNullParameter(excludes, "excludes");
        this.excludes = excludes;
        int mask = 0;
        mask = kindMask;
        Iterable $this$forEach$iv = this.excludes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            DescriptorKindExclude it = (DescriptorKindExclude)element$iv;
            boolean bl2 = false;
            mask &= ~it.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = mask;
    }

    public /* synthetic */ DescriptorKindFilter(int n2, List list, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        this(n2, list);
    }

    @NotNull
    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int kinds) {
        return (this.kindMask & kinds) != 0;
    }

    @Nullable
    public final DescriptorKindFilter restrictedToKindsOrNull(int kinds) {
        int mask = this.kindMask & kinds;
        if (mask == 0) {
            return null;
        }
        return new DescriptorKindFilter(mask, this.excludes);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String toString() {
        Object v0;
        block3: {
            Iterable $this$firstOrNull$iv = DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Companion.MaskToName it = (Companion.MaskToName)element$iv;
                boolean bl2 = false;
                if (!(it.getMask() == this.kindMask)) continue;
                v0 = element$iv;
                break block3;
            }
            v0 = null;
        }
        Companion.MaskToName maskToName = v0;
        String predefinedFilterName = maskToName != null ? maskToName.getName() : null;
        String string = predefinedFilterName;
        if (string == null) {
            void $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = DEBUG_MASK_BIT_NAMES;
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                String it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl3 = false;
                Companion.MaskToName it = (Companion.MaskToName)element$iv$iv;
                boolean bl4 = false;
                if ((this.acceptsKinds(it.getMask()) ? it.getName() : null) == null) continue;
                it$iv$iv = it$iv$iv;
                boolean bl5 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            string = CollectionsKt.joinToString$default((List)destination$iv$iv, " | ", null, null, 0, null, null, 62, null);
        }
        String kindString = string;
        return "DescriptorKindFilter(" + kindString + ", " + this.excludes + ')';
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter cfr_ignored_0 = (DescriptorKindFilter)other;
        if (!Intrinsics.areEqual(this.excludes, ((DescriptorKindFilter)other).excludes)) {
            return false;
        }
        return this.kindMask == ((DescriptorKindFilter)other).kindMask;
    }

    public int hashCode() {
        int result = ((Object)this.excludes).hashCode();
        result = 31 * result + this.kindMask;
        return result;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_6;
        Iterable $this$filterTo$iv$iv;
        void $this$filterTo$iv$iv$iv;
        boolean bl2;
        Companion.MaskToName it$iv$iv;
        Object element$iv$iv;
        void $this$mapNotNullTo$iv$iv;
        void $this$filterTo$iv$iv$iv2;
        Companion = new Companion(null);
        nextMaskValue = 1;
        NON_SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.nextMask();
        TYPE_ALIASES_MASK = DescriptorKindFilter.Companion.nextMask();
        PACKAGES_MASK = DescriptorKindFilter.Companion.nextMask();
        FUNCTIONS_MASK = DescriptorKindFilter.Companion.nextMask();
        VARIABLES_MASK = DescriptorKindFilter.Companion.nextMask();
        ALL_KINDS_MASK = DescriptorKindFilter.Companion.nextMask() - 1;
        CLASSIFIERS_MASK = NON_SINGLETON_CLASSIFIERS_MASK | SINGLETON_CLASSIFIERS_MASK | TYPE_ALIASES_MASK;
        VALUES_MASK = SINGLETON_CLASSIFIERS_MASK | FUNCTIONS_MASK | VARIABLES_MASK;
        CALLABLES_MASK = FUNCTIONS_MASK | VARIABLES_MASK;
        ALL = new DescriptorKindFilter(ALL_KINDS_MASK, null, 2, null);
        CALLABLES = new DescriptorKindFilter(CALLABLES_MASK, null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(NON_SINGLETON_CLASSIFIERS_MASK, null, 2, null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(SINGLETON_CLASSIFIERS_MASK, null, 2, null);
        TYPE_ALIASES = new DescriptorKindFilter(TYPE_ALIASES_MASK, null, 2, null);
        CLASSIFIERS = new DescriptorKindFilter(CLASSIFIERS_MASK, null, 2, null);
        PACKAGES = new DescriptorKindFilter(PACKAGES_MASK, null, 2, null);
        FUNCTIONS = new DescriptorKindFilter(FUNCTIONS_MASK, null, 2, null);
        VARIABLES = new DescriptorKindFilter(VARIABLES_MASK, null, 2, null);
        VALUES = new DescriptorKindFilter(VALUES_MASK, null, 2, null);
        Companion this_$iv = Companion;
        boolean $i$f$staticFields = false;
        Field[] fieldArray = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getFields(...)");
        Object $this$filter$iv$iv = fieldArray;
        boolean $i$f$filter = false;
        Object[] objectArray = $this$filter$iv$iv;
        Object destination$iv$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (void element$iv$iv$iv : $this$filterTo$iv$iv$iv2) {
            Field it$iv = (Field)element$iv$iv$iv;
            boolean bl3 = false;
            if (!Modifier.isStatic(it$iv.getModifiers())) continue;
            destination$iv$iv$iv.add(element$iv$iv$iv);
        }
        Iterable $this$mapNotNull$iv = (List)destination$iv$iv$iv;
        boolean $i$f$mapNotNull = false;
        $this$filter$iv$iv = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo22 = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Companion.MaskToName maskToName;
            DescriptorKindFilter filter;
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl4 = false;
            Field field = (Field)element$iv$iv;
            boolean bl5 = false;
            Object object = field.get(null);
            DescriptorKindFilter descriptorKindFilter = filter = object instanceof DescriptorKindFilter ? (DescriptorKindFilter)object : null;
            if (filter != null) {
                int n2 = filter.kindMask;
                String string = field.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                maskToName = new Companion.MaskToName(n2, string);
            } else {
                maskToName = null;
            }
            if (maskToName == null) continue;
            it$iv$iv = maskToName;
            bl2 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = (List)destination$iv$iv;
        this_$iv = Companion;
        $i$f$staticFields = false;
        Field[] fieldArray2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray2, "getFields(...)");
        $this$filter$iv$iv = fieldArray2;
        $i$f$filter = false;
        Object $i$f$mapNotNullTo22 = $this$filter$iv$iv;
        destination$iv$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (void element$iv$iv$iv : $this$filterTo$iv$iv$iv) {
            Field it$iv = (Field)element$iv$iv$iv;
            boolean bl6 = false;
            if (!Modifier.isStatic(it$iv.getModifiers())) continue;
            destination$iv$iv$iv.add(element$iv$iv$iv);
        }
        Iterable $this$filter$iv = (List)destination$iv$iv$iv;
        boolean $i$f$filter2 = false;
        $this$filter$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
            Field it = (Field)element$iv$iv2;
            boolean bl7 = false;
            if (!Intrinsics.areEqual(it.getType(), Integer.TYPE)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        $this$mapNotNull$iv = (List)destination$iv$iv;
        $i$f$mapNotNull = false;
        $this$filterTo$iv$iv = $this$mapNotNull$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        $i$f$forEach = false;
        Iterator iterator3 = $this$forEach$iv$iv$iv.iterator();
        while (iterator3.hasNext()) {
            Companion.MaskToName maskToName;
            boolean isOneBitMask;
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = iterator3.next();
            boolean bl8 = false;
            Field field = (Field)element$iv$iv;
            boolean bl9 = false;
            Object object = field.get(null);
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Int");
            int mask = (Integer)object;
            boolean bl10 = isOneBitMask = mask == (mask & -mask);
            if (isOneBitMask) {
                String string = field.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                maskToName = new Companion.MaskToName(mask, string);
            } else {
                maskToName = null;
            }
            if (maskToName == null) continue;
            it$iv$iv = maskToName;
            bl2 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        DEBUG_MASK_BIT_NAMES = (List)var3_6;
    }

    @SourceDebugExtension(value={"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1#2:262\n3829#3:263\n4344#3,2:264\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n*L\n210#1:263\n210#1:264,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final int nextMask() {
            int n2;
            int $this$nextMask_u24lambda_u240 = n2 = nextMaskValue;
            boolean bl2 = false;
            nextMaskValue = nextMaskValue << 1;
            return n2;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return TYPE_ALIASES_MASK;
        }

        public final int getPACKAGES_MASK() {
            return PACKAGES_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return FUNCTIONS_MASK;
        }

        public final int getVARIABLES_MASK() {
            return VARIABLES_MASK;
        }

        public final int getALL_KINDS_MASK() {
            return ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return CLASSIFIERS_MASK;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private static final class MaskToName {
            private final int mask;
            @NotNull
            private final String name;

            public MaskToName(int mask, @NotNull String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                this.mask = mask;
                this.name = name;
            }

            public final int getMask() {
                return this.mask;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }
        }
    }
}

