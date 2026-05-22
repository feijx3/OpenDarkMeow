/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaToKotlinClassMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n50#1,2:234\n50#1,2:236\n50#1,2:238\n50#1,2:240\n50#1,2:242\n50#1,2:244\n50#1,2:246\n50#1,2:248\n1634#2,3:230\n1#3:233\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n*L\n55#1:234,2\n56#1:236,2\n57#1:238,2\n58#1:240,2\n59#1:242,2\n60#1:244,2\n61#1:246,2\n62#1:248,2\n218#1:230,3\n*E\n"})
public final class JavaToKotlinClassMap {
    @NotNull
    public static final JavaToKotlinClassMap INSTANCE;
    @NotNull
    private static final String NUMBERED_FUNCTION_PREFIX;
    @NotNull
    private static final String NUMBERED_K_FUNCTION_PREFIX;
    @NotNull
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX;
    @NotNull
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
    @NotNull
    private static final ClassId FUNCTION_N_CLASS_ID;
    @NotNull
    private static final FqName FUNCTION_N_FQ_NAME;
    @NotNull
    private static final ClassId K_FUNCTION_CLASS_ID;
    @NotNull
    private static final ClassId K_CLASS_CLASS_ID;
    @NotNull
    private static final ClassId CLASS_CLASS_ID;
    @NotNull
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin;
    @NotNull
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava;
    @NotNull
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly;
    @NotNull
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable;
    @NotNull
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId;
    @NotNull
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId;
    @NotNull
    private static final List<PlatformMutabilityMapping> mutabilityMappings;

    private JavaToKotlinClassMap() {
    }

    @NotNull
    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    @NotNull
    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    @Nullable
    public final ClassId mapJavaToKotlin(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    @Nullable
    public final ClassId mapKotlinToJava(@NotNull FqNameUnsafe kotlinFqName) {
        Intrinsics.checkNotNullParameter(kotlinFqName, "kotlinFqName");
        return this.isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_FUNCTION_PREFIX) ? FUNCTION_N_CLASS_ID : (this.isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_SUSPEND_FUNCTION_PREFIX) ? FUNCTION_N_CLASS_ID : (this.isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_FUNCTION_PREFIX) ? K_FUNCTION_CLASS_ID : (this.isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) ? K_FUNCTION_CLASS_ID : kotlinToJava.get(kotlinFqName))));
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe kotlinFqName, String prefix) {
        String fqNameAsString = kotlinFqName.asString();
        if (!StringsKt.startsWith$default(fqNameAsString, prefix, false, 2, null)) {
            return false;
        }
        String string = fqNameAsString.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        String arityString = string;
        if (StringsKt.startsWith$default((CharSequence)arityString, '0', false, 2, null)) {
            return false;
        }
        Integer arity = StringsKt.toIntOrNull(arityString);
        return arity != null && arity >= 23;
    }

    private final void addMapping(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId javaClassId = platformMutabilityMapping.component1();
        ClassId readOnlyClassId = platformMutabilityMapping.component2();
        ClassId mutableClassId = platformMutabilityMapping.component3();
        this.add(javaClassId, readOnlyClassId);
        this.addKotlinToJava(mutableClassId.asSingleFqName(), javaClassId);
        ((Map)mutableToReadOnlyClassId).put(mutableClassId, readOnlyClassId);
        ((Map)readOnlyToMutableClassId).put(readOnlyClassId, mutableClassId);
        FqName readOnlyFqName = readOnlyClassId.asSingleFqName();
        FqName mutableFqName = mutableClassId.asSingleFqName();
        ((Map)mutableToReadOnly).put(mutableClassId.asSingleFqName().toUnsafe(), readOnlyFqName);
        ((Map)readOnlyToMutable).put(readOnlyFqName.toUnsafe(), mutableFqName);
    }

    private final void add(ClassId javaClassId, ClassId kotlinClassId) {
        this.addJavaToKotlin(javaClassId, kotlinClassId);
        this.addKotlinToJava(kotlinClassId.asSingleFqName(), javaClassId);
    }

    private final void addTopLevel(Class<?> javaClass, FqNameUnsafe kotlinFqName) {
        this.addTopLevel(javaClass, kotlinFqName.toSafe());
    }

    private final void addTopLevel(Class<?> javaClass, FqName kotlinFqName) {
        this.add(this.classId(javaClass), ClassId.Companion.topLevel(kotlinFqName));
    }

    private final void addJavaToKotlin(ClassId javaClassId, ClassId kotlinClassId) {
        ((Map)javaToKotlin).put(javaClassId.asSingleFqName().toUnsafe(), kotlinClassId);
    }

    private final void addKotlinToJava(FqName kotlinFqNameUnsafe, ClassId javaClassId) {
        ((Map)kotlinToJava).put(kotlinFqNameUnsafe.toUnsafe(), javaClassId);
    }

    @Nullable
    public final FqName mutableToReadOnly(@Nullable FqNameUnsafe fqNameUnsafe) {
        return (FqName)((Map)mutableToReadOnly).get(fqNameUnsafe);
    }

    @Nullable
    public final FqName readOnlyToMutable(@Nullable FqNameUnsafe fqNameUnsafe) {
        return (FqName)((Map)readOnlyToMutable).get(fqNameUnsafe);
    }

    public final boolean isMutable(@Nullable FqNameUnsafe fqNameUnsafe) {
        return ((Map)mutableToReadOnly).containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(@Nullable FqNameUnsafe fqNameUnsafe) {
        return ((Map)readOnlyToMutable).containsKey(fqNameUnsafe);
    }

    private final ClassId classId(Class<?> clazz) {
        ClassId classId;
        boolean bl2;
        boolean bl3 = bl2 = !clazz.isPrimitive() && !clazz.isArray();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Invalid class: " + clazz;
            throw new AssertionError((Object)string);
        }
        Class<?> outer = clazz.getDeclaringClass();
        if (outer == null) {
            String string = clazz.getCanonicalName();
            Intrinsics.checkNotNullExpressionValue(string, "getCanonicalName(...)");
            classId = ClassId.Companion.topLevel(new FqName(string));
        } else {
            ClassId classId2 = this.classId(outer);
            Name name = Name.identifier(clazz.getSimpleName());
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            classId = classId2.createNestedClassId(name);
        }
        return classId;
    }

    static {
        int i2;
        JavaToKotlinClassMap this_$iv;
        ClassId kotlinReadOnly$iv;
        INSTANCE = new JavaToKotlinClassMap();
        NUMBERED_FUNCTION_PREFIX = FunctionTypeKind.Function.INSTANCE.getPackageFqName() + '.' + FunctionTypeKind.Function.INSTANCE.getClassNamePrefix();
        NUMBERED_K_FUNCTION_PREFIX = FunctionTypeKind.KFunction.INSTANCE.getPackageFqName() + '.' + FunctionTypeKind.KFunction.INSTANCE.getClassNamePrefix();
        NUMBERED_SUSPEND_FUNCTION_PREFIX = FunctionTypeKind.SuspendFunction.INSTANCE.getPackageFqName() + '.' + FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix();
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = FunctionTypeKind.KSuspendFunction.INSTANCE.getPackageFqName() + '.' + FunctionTypeKind.KSuspendFunction.INSTANCE.getClassNamePrefix();
        FUNCTION_N_CLASS_ID = ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        FUNCTION_N_FQ_NAME = FUNCTION_N_CLASS_ID.asSingleFqName();
        K_FUNCTION_CLASS_ID = StandardClassIds.INSTANCE.getKFunction();
        K_CLASS_CLASS_ID = StandardClassIds.INSTANCE.getKClass();
        CLASS_CLASS_ID = INSTANCE.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        PlatformMutabilityMapping[] platformMutabilityMappingArray = new PlatformMutabilityMapping[8];
        JavaToKotlinClassMap javaToKotlinClassMap = INSTANCE;
        ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.iterable);
        FqName kotlinMutable$iv = StandardNames.FqNames.mutableIterable;
        boolean $i$f$mutabilityMapping = false;
        ClassId mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[0] = new PlatformMutabilityMapping(super.classId(Iterable.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.iterator);
        kotlinMutable$iv = StandardNames.FqNames.mutableIterator;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[1] = new PlatformMutabilityMapping(this_$iv.classId(Iterator.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.collection);
        kotlinMutable$iv = StandardNames.FqNames.mutableCollection;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[2] = new PlatformMutabilityMapping(this_$iv.classId(Collection.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.list);
        kotlinMutable$iv = StandardNames.FqNames.mutableList;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[3] = new PlatformMutabilityMapping(this_$iv.classId(List.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.set);
        kotlinMutable$iv = StandardNames.FqNames.mutableSet;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[4] = new PlatformMutabilityMapping(this_$iv.classId(Set.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.listIterator);
        kotlinMutable$iv = StandardNames.FqNames.mutableListIterator;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[5] = new PlatformMutabilityMapping(this_$iv.classId(ListIterator.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.map);
        kotlinMutable$iv = StandardNames.FqNames.mutableMap;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[6] = new PlatformMutabilityMapping(this_$iv.classId(Map.class), kotlinReadOnly$iv, mutableClassId$iv);
        this_$iv = INSTANCE;
        kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.map).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        kotlinMutable$iv = StandardNames.FqNames.mutableMapEntry;
        $i$f$mutabilityMapping = false;
        mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        platformMutabilityMappingArray[7] = new PlatformMutabilityMapping(this_$iv.classId(Map.Entry.class), kotlinReadOnly$iv, mutableClassId$iv);
        mutabilityMappings = CollectionsKt.listOf(platformMutabilityMappingArray);
        INSTANCE.addTopLevel(Object.class, StandardNames.FqNames.any);
        INSTANCE.addTopLevel(String.class, StandardNames.FqNames.string);
        INSTANCE.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        INSTANCE.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        INSTANCE.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        INSTANCE.addTopLevel(Number.class, StandardNames.FqNames.number);
        INSTANCE.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        INSTANCE.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        INSTANCE.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        for (PlatformMutabilityMapping platformCollection : mutabilityMappings) {
            INSTANCE.addMapping(platformCollection);
        }
        for (JvmPrimitiveType jvmType : JvmPrimitiveType.values()) {
            FqName fqName = jvmType.getWrapperFqName();
            Intrinsics.checkNotNullExpressionValue(fqName, "getWrapperFqName(...)");
            ClassId classId2 = ClassId.Companion.topLevel(fqName);
            PrimitiveType primitiveType = jvmType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue((Object)primitiveType, "getPrimitiveType(...)");
            INSTANCE.add(classId2, ClassId.Companion.topLevel(StandardNames.getPrimitiveFqName(primitiveType)));
        }
        for (ClassId classId3 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.internal." + classId3.getShortClassName().asString() + "CompanionObject")), classId3.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        }
        for (i2 = 0; i2 < 23; ++i2) {
            INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.Function" + i2)), StandardNames.getFunctionClassId(i2));
            INSTANCE.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + i2), K_FUNCTION_CLASS_ID);
        }
        for (i2 = 0; i2 < 22; ++i2) {
            FunctionTypeKind.KSuspendFunction kSuspendFunction = FunctionTypeKind.KSuspendFunction.INSTANCE;
            String kSuspendFun = kSuspendFunction.getPackageFqName() + '.' + kSuspendFunction.getClassNamePrefix();
            INSTANCE.addKotlinToJava(new FqName(kSuspendFun + i2), K_FUNCTION_CLASS_ID);
        }
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicInt"), INSTANCE.classId(AtomicInteger.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicLong"), INSTANCE.classId(AtomicLong.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicBoolean"), INSTANCE.classId(AtomicBoolean.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicReference"), INSTANCE.classId(AtomicReference.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicIntArray"), INSTANCE.classId(AtomicIntegerArray.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicLongArray"), INSTANCE.classId(AtomicLongArray.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicArray"), INSTANCE.classId(AtomicReferenceArray.class));
        INSTANCE.addKotlinToJava(StandardNames.FqNames.nothing.toSafe(), INSTANCE.classId(Void.class));
    }

    public static final class PlatformMutabilityMapping {
        @NotNull
        private final ClassId javaClass;
        @NotNull
        private final ClassId kotlinReadOnly;
        @NotNull
        private final ClassId kotlinMutable;

        public PlatformMutabilityMapping(@NotNull ClassId javaClass, @NotNull ClassId kotlinReadOnly, @NotNull ClassId kotlinMutable) {
            Intrinsics.checkNotNullParameter(javaClass, "javaClass");
            Intrinsics.checkNotNullParameter(kotlinReadOnly, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(kotlinMutable, "kotlinMutable");
            this.javaClass = javaClass;
            this.kotlinReadOnly = kotlinReadOnly;
            this.kotlinMutable = kotlinMutable;
        }

        @NotNull
        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        @NotNull
        public final ClassId component1() {
            return this.javaClass;
        }

        @NotNull
        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        @NotNull
        public final ClassId component3() {
            return this.kotlinMutable;
        }

        @NotNull
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }

        public int hashCode() {
            int result = this.javaClass.hashCode();
            result = result * 31 + this.kotlinReadOnly.hashCode();
            result = result * 31 + this.kotlinMutable.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlatformMutabilityMapping)) {
                return false;
            }
            PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping)other;
            if (!Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly)) {
                return false;
            }
            return Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
        }
    }
}

