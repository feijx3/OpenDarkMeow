/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIdsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,341:1\n1285#2,2:342\n1299#2,4:344\n1285#2,2:348\n1299#2,4:350\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n*L\n103#1:342,2\n103#1:344,4\n107#1:348,2\n107#1:350,4\n*E\n"})
public final class StandardClassIds {
    @NotNull
    public static final StandardClassIds INSTANCE;
    @NotNull
    private static final FqName BASE_KOTLIN_PACKAGE;
    @NotNull
    private static final FqName BASE_REFLECT_PACKAGE;
    @NotNull
    private static final FqName BASE_EXPERIMENTAL_PACKAGE;
    @NotNull
    private static final FqName BASE_COLLECTIONS_PACKAGE;
    @NotNull
    private static final FqName BASE_SEQUENCES_PACKAGE;
    @NotNull
    private static final FqName BASE_RANGES_PACKAGE;
    @NotNull
    private static final FqName BASE_JVM_PACKAGE;
    @NotNull
    private static final FqName BASE_JS_PACKAGE;
    @NotNull
    private static final FqName BASE_ANNOTATIONS_JVM_PACKAGE;
    @NotNull
    private static final FqName BASE_JVM_INTERNAL_PACKAGE;
    @NotNull
    private static final FqName BASE_JVM_FUNCTIONS_PACKAGE;
    @NotNull
    private static final FqName BASE_ANNOTATION_PACKAGE;
    @NotNull
    private static final FqName BASE_INTERNAL_PACKAGE;
    @NotNull
    private static final FqName BASE_INTERNAL_IR_PACKAGE;
    @NotNull
    private static final FqName BASE_COROUTINES_PACKAGE;
    @NotNull
    private static final FqName BASE_COROUTINES_INTRINSICS_PACKAGE;
    @NotNull
    private static final FqName BASE_ENUMS_PACKAGE;
    @NotNull
    private static final FqName BASE_CONTRACTS_PACKAGE;
    @NotNull
    private static final FqName BASE_CONCURRENT_PACKAGE;
    @NotNull
    private static final FqName BASE_CONCURRENT_ATOMICS_PACKAGE;
    @NotNull
    private static final FqName BASE_TEST_PACKAGE;
    @NotNull
    private static final FqName BASE_TEXT_PACKAGE;
    @NotNull
    private static final Set<FqName> builtInsPackagesWithDefaultNamedImport;
    @NotNull
    private static final Set<FqName> builtInsPackages;
    @NotNull
    private static final ClassId Nothing;
    @NotNull
    private static final ClassId Unit;
    @NotNull
    private static final ClassId Any;
    @NotNull
    private static final ClassId Enum;
    @NotNull
    private static final ClassId Annotation;
    @NotNull
    private static final ClassId Array;
    @NotNull
    private static final ClassId Boolean;
    @NotNull
    private static final ClassId Char;
    @NotNull
    private static final ClassId Byte;
    @NotNull
    private static final ClassId Short;
    @NotNull
    private static final ClassId Int;
    @NotNull
    private static final ClassId Long;
    @NotNull
    private static final ClassId Float;
    @NotNull
    private static final ClassId Double;
    @NotNull
    private static final ClassId UByte;
    @NotNull
    private static final ClassId UShort;
    @NotNull
    private static final ClassId UInt;
    @NotNull
    private static final ClassId ULong;
    @NotNull
    private static final ClassId CharSequence;
    @NotNull
    private static final ClassId String;
    @NotNull
    private static final ClassId Throwable;
    @NotNull
    private static final ClassId Cloneable;
    @NotNull
    private static final ClassId KProperty;
    @NotNull
    private static final ClassId KMutableProperty;
    @NotNull
    private static final ClassId KProperty0;
    @NotNull
    private static final ClassId KMutableProperty0;
    @NotNull
    private static final ClassId KProperty1;
    @NotNull
    private static final ClassId KMutableProperty1;
    @NotNull
    private static final ClassId KProperty2;
    @NotNull
    private static final ClassId KMutableProperty2;
    @NotNull
    private static final ClassId KFunction;
    @NotNull
    private static final ClassId KClass;
    @NotNull
    private static final ClassId KCallable;
    @NotNull
    private static final ClassId KType;
    @NotNull
    private static final ClassId Comparable;
    @NotNull
    private static final ClassId Number;
    @NotNull
    private static final ClassId Function;
    @NotNull
    private static final Set<ClassId> primitiveTypes;
    @NotNull
    private static final Set<ClassId> signedIntegerTypes;
    @NotNull
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType;
    @NotNull
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType;
    @NotNull
    private static final Set<ClassId> unsignedTypes;
    @NotNull
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType;
    @NotNull
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType;
    @NotNull
    private static final Set<ClassId> constantAllowedTypes;
    @NotNull
    private static final ClassId Continuation;
    @NotNull
    private static final ClassId Iterator;
    @NotNull
    private static final ClassId Iterable;
    @NotNull
    private static final ClassId Collection;
    @NotNull
    private static final ClassId List;
    @NotNull
    private static final ClassId ListIterator;
    @NotNull
    private static final ClassId Set;
    @NotNull
    private static final ClassId Map;
    @NotNull
    private static final ClassId AbstractMap;
    @NotNull
    private static final ClassId MutableIterator;
    @NotNull
    private static final ClassId CharIterator;
    @NotNull
    private static final ClassId MutableIterable;
    @NotNull
    private static final ClassId MutableCollection;
    @NotNull
    private static final ClassId MutableList;
    @NotNull
    private static final ClassId MutableListIterator;
    @NotNull
    private static final ClassId MutableSet;
    @NotNull
    private static final ClassId MutableMap;
    @NotNull
    private static final ClassId MapEntry;
    @NotNull
    private static final ClassId MutableMapEntry;
    @NotNull
    private static final ClassId Result;
    @NotNull
    private static final ClassId IntRange;
    @NotNull
    private static final ClassId LongRange;
    @NotNull
    private static final ClassId CharRange;
    @NotNull
    private static final ClassId AnnotationRetention;
    @NotNull
    private static final ClassId AnnotationTarget;
    @NotNull
    private static final ClassId DeprecationLevel;
    @NotNull
    private static final ClassId EnumEntries;
    @NotNull
    private static final ClassId AtomicBoolean;
    @NotNull
    private static final ClassId AtomicInt;
    @NotNull
    private static final ClassId AtomicLong;
    @NotNull
    private static final ClassId AtomicReference;
    @NotNull
    private static final Map<ClassId, ClassId> atomicByPrimitive;
    @NotNull
    private static final ClassId AtomicArray;
    @NotNull
    private static final ClassId AtomicIntArray;
    @NotNull
    private static final ClassId AtomicLongArray;
    @NotNull
    private static final Map<ClassId, ClassId> atomicArrayByPrimitive;
    @NotNull
    private static final Set<ClassId> allBuiltinTypes;

    private StandardClassIds() {
    }

    @NotNull
    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_CONCURRENT_ATOMICS_PACKAGE() {
        return BASE_CONCURRENT_ATOMICS_PACKAGE;
    }

    @NotNull
    public final ClassId getArray() {
        return Array;
    }

    @NotNull
    public final ClassId getKFunction() {
        return KFunction;
    }

    @NotNull
    public final ClassId getKClass() {
        return KClass;
    }

    @NotNull
    public final ClassId getMutableList() {
        return MutableList;
    }

    @NotNull
    public final ClassId getMutableSet() {
        return MutableSet;
    }

    @NotNull
    public final ClassId getMutableMap() {
        return MutableMap;
    }

    @NotNull
    public final ClassId getEnumEntries() {
        return EnumEntries;
    }

    static {
        ClassId classId;
        ClassId id;
        Map map;
        Object t2;
        INSTANCE = new StandardClassIds();
        BASE_KOTLIN_PACKAGE = new FqName("kotlin");
        Name name = Name.identifier("reflect");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        BASE_REFLECT_PACKAGE = BASE_KOTLIN_PACKAGE.child(name);
        Name name2 = Name.identifier("experimental");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        BASE_EXPERIMENTAL_PACKAGE = BASE_KOTLIN_PACKAGE.child(name2);
        Name name3 = Name.identifier("collections");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        BASE_COLLECTIONS_PACKAGE = BASE_KOTLIN_PACKAGE.child(name3);
        Name name4 = Name.identifier("sequences");
        Intrinsics.checkNotNullExpressionValue(name4, "identifier(...)");
        BASE_SEQUENCES_PACKAGE = BASE_KOTLIN_PACKAGE.child(name4);
        Name name5 = Name.identifier("ranges");
        Intrinsics.checkNotNullExpressionValue(name5, "identifier(...)");
        BASE_RANGES_PACKAGE = BASE_KOTLIN_PACKAGE.child(name5);
        Name name6 = Name.identifier("jvm");
        Intrinsics.checkNotNullExpressionValue(name6, "identifier(...)");
        BASE_JVM_PACKAGE = BASE_KOTLIN_PACKAGE.child(name6);
        Name name7 = Name.identifier("js");
        Intrinsics.checkNotNullExpressionValue(name7, "identifier(...)");
        BASE_JS_PACKAGE = BASE_KOTLIN_PACKAGE.child(name7);
        Name name8 = Name.identifier("annotations");
        Intrinsics.checkNotNullExpressionValue(name8, "identifier(...)");
        FqName fqName = BASE_KOTLIN_PACKAGE.child(name8);
        Name name9 = Name.identifier("jvm");
        Intrinsics.checkNotNullExpressionValue(name9, "identifier(...)");
        BASE_ANNOTATIONS_JVM_PACKAGE = fqName.child(name9);
        Name name10 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(name10, "identifier(...)");
        BASE_JVM_INTERNAL_PACKAGE = BASE_JVM_PACKAGE.child(name10);
        Name name11 = Name.identifier("functions");
        Intrinsics.checkNotNullExpressionValue(name11, "identifier(...)");
        BASE_JVM_FUNCTIONS_PACKAGE = BASE_JVM_PACKAGE.child(name11);
        Name name12 = Name.identifier("annotation");
        Intrinsics.checkNotNullExpressionValue(name12, "identifier(...)");
        BASE_ANNOTATION_PACKAGE = BASE_KOTLIN_PACKAGE.child(name12);
        Name name13 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(name13, "identifier(...)");
        BASE_INTERNAL_PACKAGE = BASE_KOTLIN_PACKAGE.child(name13);
        Name name14 = Name.identifier("ir");
        Intrinsics.checkNotNullExpressionValue(name14, "identifier(...)");
        BASE_INTERNAL_IR_PACKAGE = BASE_INTERNAL_PACKAGE.child(name14);
        Name name15 = Name.identifier("coroutines");
        Intrinsics.checkNotNullExpressionValue(name15, "identifier(...)");
        BASE_COROUTINES_PACKAGE = BASE_KOTLIN_PACKAGE.child(name15);
        Name name16 = Name.identifier("intrinsics");
        Intrinsics.checkNotNullExpressionValue(name16, "identifier(...)");
        BASE_COROUTINES_INTRINSICS_PACKAGE = BASE_COROUTINES_PACKAGE.child(name16);
        Name name17 = Name.identifier("enums");
        Intrinsics.checkNotNullExpressionValue(name17, "identifier(...)");
        BASE_ENUMS_PACKAGE = BASE_KOTLIN_PACKAGE.child(name17);
        Name name18 = Name.identifier("contracts");
        Intrinsics.checkNotNullExpressionValue(name18, "identifier(...)");
        BASE_CONTRACTS_PACKAGE = BASE_KOTLIN_PACKAGE.child(name18);
        Name name19 = Name.identifier("concurrent");
        Intrinsics.checkNotNullExpressionValue(name19, "identifier(...)");
        BASE_CONCURRENT_PACKAGE = BASE_KOTLIN_PACKAGE.child(name19);
        Name name20 = Name.identifier("atomics");
        Intrinsics.checkNotNullExpressionValue(name20, "identifier(...)");
        BASE_CONCURRENT_ATOMICS_PACKAGE = BASE_CONCURRENT_PACKAGE.child(name20);
        Name name21 = Name.identifier("test");
        Intrinsics.checkNotNullExpressionValue(name21, "identifier(...)");
        BASE_TEST_PACKAGE = BASE_KOTLIN_PACKAGE.child(name21);
        Name name22 = Name.identifier("text");
        Intrinsics.checkNotNullExpressionValue(name22, "identifier(...)");
        BASE_TEXT_PACKAGE = BASE_KOTLIN_PACKAGE.child(name22);
        Object[] objectArray = new FqName[4];
        objectArray[0] = BASE_KOTLIN_PACKAGE;
        objectArray[1] = BASE_COLLECTIONS_PACKAGE;
        objectArray[2] = BASE_RANGES_PACKAGE;
        objectArray[3] = BASE_ANNOTATION_PACKAGE;
        builtInsPackagesWithDefaultNamedImport = SetsKt.setOf(objectArray);
        objectArray = new FqName[8];
        objectArray[0] = BASE_KOTLIN_PACKAGE;
        objectArray[1] = BASE_COLLECTIONS_PACKAGE;
        objectArray[2] = BASE_RANGES_PACKAGE;
        objectArray[3] = BASE_ANNOTATION_PACKAGE;
        objectArray[4] = BASE_REFLECT_PACKAGE;
        objectArray[5] = BASE_INTERNAL_PACKAGE;
        objectArray[6] = BASE_COROUTINES_PACKAGE;
        objectArray[7] = BASE_CONCURRENT_ATOMICS_PACKAGE;
        builtInsPackages = SetsKt.setOf(objectArray);
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        Boolean = StandardClassIdsKt.access$baseId("Boolean");
        Char = StandardClassIdsKt.access$baseId("Char");
        Byte = StandardClassIdsKt.access$baseId("Byte");
        Short = StandardClassIdsKt.access$baseId("Short");
        Int = StandardClassIdsKt.access$baseId("Int");
        Long = StandardClassIdsKt.access$baseId("Long");
        Float = StandardClassIdsKt.access$baseId("Float");
        Double = StandardClassIdsKt.access$baseId("Double");
        UByte = StandardClassIdsKt.access$unsignedId(Byte);
        UShort = StandardClassIdsKt.access$unsignedId(Short);
        UInt = StandardClassIdsKt.access$unsignedId(Int);
        ULong = StandardClassIdsKt.access$unsignedId(Long);
        CharSequence = StandardClassIdsKt.access$baseId("CharSequence");
        String = StandardClassIdsKt.access$baseId("String");
        Throwable = StandardClassIdsKt.access$baseId("Throwable");
        Cloneable = StandardClassIdsKt.access$baseId("Cloneable");
        KProperty = StandardClassIdsKt.access$reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.access$reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.access$reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.access$reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.access$reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.access$reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.access$reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.access$reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.access$reflectId("KFunction");
        KClass = StandardClassIdsKt.access$reflectId("KClass");
        KCallable = StandardClassIdsKt.access$reflectId("KCallable");
        KType = StandardClassIdsKt.access$reflectId("KType");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        objectArray = new ClassId[8];
        objectArray[0] = Boolean;
        objectArray[1] = Char;
        objectArray[2] = Byte;
        objectArray[3] = Short;
        objectArray[4] = Int;
        objectArray[5] = Long;
        objectArray[6] = Float;
        objectArray[7] = Double;
        primitiveTypes = SetsKt.setOf(objectArray);
        objectArray = new ClassId[4];
        objectArray[0] = Byte;
        objectArray[1] = Short;
        objectArray[2] = Int;
        objectArray[3] = Long;
        signedIntegerTypes = SetsKt.setOf(objectArray);
        Object $this$associateWith$iv = (ClassId[])primitiveTypes;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
        ClassId[] $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object t3 : $this$associateWithTo$iv$iv) {
            ClassId classId2 = (ClassId)t3;
            t2 = t3;
            map = result$iv;
            boolean bl2 = false;
            classId = StandardClassIdsKt.access$primitiveArrayId(id.getShortClassName());
            map.put(t2, classId);
        }
        primitiveArrayTypeByElementType = result$iv;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(primitiveArrayTypeByElementType);
        $this$associateWith$iv = new ClassId[4];
        $this$associateWith$iv[0] = UByte;
        $this$associateWith$iv[1] = UShort;
        $this$associateWith$iv[2] = UInt;
        $this$associateWith$iv[3] = ULong;
        unsignedTypes = SetsKt.setOf($this$associateWith$iv);
        $this$associateWith$iv = unsignedTypes;
        $i$f$associateWith = false;
        result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
        $this$associateWithTo$iv$iv = $this$associateWith$iv;
        $i$f$associateWithTo = false;
        for (Object t4 : $this$associateWithTo$iv$iv) {
            id = (ClassId)t4;
            t2 = t4;
            map = result$iv;
            boolean bl3 = false;
            classId = StandardClassIdsKt.access$primitiveArrayId(id.getShortClassName());
            map.put(t2, classId);
        }
        unsignedArrayTypeByElementType = result$iv;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(unsignedArrayTypeByElementType);
        constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, (Iterable)unsignedTypes), String);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        Map = StandardClassIdsKt.access$collectionsId("Map");
        AbstractMap = StandardClassIdsKt.access$collectionsId("AbstractMap");
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.access$collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        MutableMap = StandardClassIdsKt.access$collectionsId("MutableMap");
        Name name23 = Name.identifier("Entry");
        Intrinsics.checkNotNullExpressionValue(name23, "identifier(...)");
        MapEntry = Map.createNestedClassId(name23);
        Name name24 = Name.identifier("MutableEntry");
        Intrinsics.checkNotNullExpressionValue(name24, "identifier(...)");
        MutableMapEntry = MutableMap.createNestedClassId(name24);
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
        DeprecationLevel = StandardClassIdsKt.access$baseId("DeprecationLevel");
        EnumEntries = StandardClassIdsKt.access$enumsId("EnumEntries");
        AtomicBoolean = StandardClassIdsKt.access$atomicsId("AtomicBoolean");
        AtomicInt = StandardClassIdsKt.access$atomicsId("AtomicInt");
        AtomicLong = StandardClassIdsKt.access$atomicsId("AtomicLong");
        AtomicReference = StandardClassIdsKt.access$atomicsId("AtomicReference");
        objectArray = new Pair[3];
        objectArray[0] = TuplesKt.to(Boolean, AtomicBoolean);
        objectArray[1] = TuplesKt.to(Int, AtomicInt);
        objectArray[2] = TuplesKt.to(Long, AtomicLong);
        atomicByPrimitive = MapsKt.mapOf(objectArray);
        AtomicArray = StandardClassIdsKt.access$atomicsId("AtomicArray");
        AtomicIntArray = StandardClassIdsKt.access$atomicsId("AtomicIntArray");
        AtomicLongArray = StandardClassIdsKt.access$atomicsId("AtomicLongArray");
        objectArray = new Pair[2];
        objectArray[0] = TuplesKt.to(Int, AtomicIntArray);
        objectArray[1] = TuplesKt.to(Long, AtomicLongArray);
        atomicArrayByPrimitive = MapsKt.mapOf(objectArray);
        allBuiltinTypes = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(primitiveTypes, (Iterable)unsignedTypes), String), Unit), Any), Enum);
    }
}

