/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public final class StandardNames {
    @NotNull
    public static final StandardNames INSTANCE = new StandardNames();
    @JvmField
    @NotNull
    public static final Name BACKING_FIELD;
    @JvmField
    @NotNull
    public static final Name DEFAULT_VALUE_PARAMETER;
    @JvmField
    @NotNull
    public static final Name ENUM_VALUES;
    @JvmField
    @NotNull
    public static final Name ENUM_ENTRIES;
    @JvmField
    @NotNull
    public static final Name ENUM_VALUE_OF;
    @JvmField
    @NotNull
    public static final Name DATA_CLASS_COPY;
    @JvmField
    @NotNull
    public static final String DATA_CLASS_COMPONENT_PREFIX;
    @JvmField
    @NotNull
    public static final Name HASHCODE_NAME;
    @JvmField
    @NotNull
    public static final Name TO_STRING_NAME;
    @JvmField
    @NotNull
    public static final Name EQUALS_NAME;
    @JvmField
    @NotNull
    public static final Name CHAR_CODE;
    @JvmField
    @NotNull
    public static final Name NAME;
    @JvmField
    @NotNull
    public static final Name MAIN;
    @JvmField
    @NotNull
    public static final Name NEXT_CHAR;
    @JvmField
    @NotNull
    public static final Name IMPLICIT_LAMBDA_PARAMETER_NAME;
    @JvmField
    @NotNull
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;
    @JvmField
    @NotNull
    public static final FqName DYNAMIC_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final Name COROUTINE_SUSPENDED_NAME;
    @JvmField
    @NotNull
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName RESULT_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    @JvmField
    @NotNull
    public static final List<String> PREFIXES;
    @JvmField
    @NotNull
    public static final Name BUILT_INS_PACKAGE_NAME;
    @JvmField
    @NotNull
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName TEXT_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName KOTLIN_INTERNAL_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName CONCURRENT_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName CONCURRENT_ATOMICS_PACKAGE_FQ_NAME;
    @NotNull
    private static final FqName NON_EXISTENT_CLASS;
    @JvmField
    @NotNull
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;

    private StandardNames() {
    }

    @JvmStatic
    @NotNull
    public static final String getFunctionName(int parameterCount) {
        return "Function" + parameterCount;
    }

    @JvmStatic
    @NotNull
    public static final ClassId getFunctionClassId(int parameterCount) {
        Name name = Name.identifier(StandardNames.getFunctionName(parameterCount));
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, name);
    }

    @JvmStatic
    @NotNull
    public static final String getSuspendFunctionName(int parameterCount) {
        return FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + parameterCount;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(@NotNull FqNameUnsafe arrayFqName) {
        Intrinsics.checkNotNullParameter(arrayFqName, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(arrayFqName) != null;
    }

    @JvmStatic
    @NotNull
    public static final FqName getPrimitiveFqName(@NotNull PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter((Object)primitiveType, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
    }

    static {
        Name name = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        BACKING_FIELD = name;
        Name name2 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        DEFAULT_VALUE_PARAMETER = name2;
        Name name3 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        ENUM_VALUES = name3;
        Name name4 = Name.identifier("entries");
        Intrinsics.checkNotNullExpressionValue(name4, "identifier(...)");
        ENUM_ENTRIES = name4;
        Name name5 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(name5, "identifier(...)");
        ENUM_VALUE_OF = name5;
        Name name6 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(name6, "identifier(...)");
        DATA_CLASS_COPY = name6;
        DATA_CLASS_COMPONENT_PREFIX = "component";
        Name name7 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(name7, "identifier(...)");
        HASHCODE_NAME = name7;
        Name name8 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(name8, "identifier(...)");
        TO_STRING_NAME = name8;
        Name name9 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(name9, "identifier(...)");
        EQUALS_NAME = name9;
        Name name10 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(name10, "identifier(...)");
        CHAR_CODE = name10;
        Name name11 = Name.identifier("name");
        Intrinsics.checkNotNullExpressionValue(name11, "identifier(...)");
        NAME = name11;
        Name name12 = Name.identifier("main");
        Intrinsics.checkNotNullExpressionValue(name12, "identifier(...)");
        MAIN = name12;
        Name name13 = Name.identifier("nextChar");
        Intrinsics.checkNotNullExpressionValue(name13, "identifier(...)");
        NEXT_CHAR = name13;
        Name name14 = Name.identifier("it");
        Intrinsics.checkNotNullExpressionValue(name14, "identifier(...)");
        IMPLICIT_LAMBDA_PARAMETER_NAME = name14;
        Name name15 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(name15, "identifier(...)");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = name15;
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        COROUTINES_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines");
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        Name name16 = Name.identifier("COROUTINE_SUSPENDED");
        Intrinsics.checkNotNullExpressionValue(name16, "identifier(...)");
        COROUTINE_SUSPENDED_NAME = name16;
        Name name17 = Name.identifier("Continuation");
        Intrinsics.checkNotNullExpressionValue(name17, "identifier(...)");
        CONTINUATION_INTERFACE_FQ_NAME = COROUTINES_PACKAGE_FQ_NAME.child(name17);
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        KOTLIN_REFLECT_FQ_NAME = new FqName("kotlin.reflect");
        Object[] objectArray = new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"};
        PREFIXES = kotlin.collections.CollectionsKt.listOf(objectArray);
        Name name18 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(name18, "identifier(...)");
        BUILT_INS_PACKAGE_NAME = name18;
        BUILT_INS_PACKAGE_FQ_NAME = FqName.Companion.topLevel(BUILT_INS_PACKAGE_NAME);
        Name name19 = Name.identifier("annotation");
        Intrinsics.checkNotNullExpressionValue(name19, "identifier(...)");
        ANNOTATION_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name19);
        Name name20 = Name.identifier("collections");
        Intrinsics.checkNotNullExpressionValue(name20, "identifier(...)");
        COLLECTIONS_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name20);
        Name name21 = Name.identifier("ranges");
        Intrinsics.checkNotNullExpressionValue(name21, "identifier(...)");
        RANGES_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name21);
        Name name22 = Name.identifier("text");
        Intrinsics.checkNotNullExpressionValue(name22, "identifier(...)");
        TEXT_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name22);
        Name name23 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(name23, "identifier(...)");
        KOTLIN_INTERNAL_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name23);
        Name name24 = Name.identifier("concurrent");
        Intrinsics.checkNotNullExpressionValue(name24, "identifier(...)");
        CONCURRENT_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(name24);
        Name name25 = Name.identifier("atomics");
        Intrinsics.checkNotNullExpressionValue(name25, "identifier(...)");
        CONCURRENT_ATOMICS_PACKAGE_FQ_NAME = CONCURRENT_PACKAGE_FQ_NAME.child(name25);
        NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
        objectArray = new FqName[]{BUILT_INS_PACKAGE_FQ_NAME, COLLECTIONS_PACKAGE_FQ_NAME, RANGES_PACKAGE_FQ_NAME, ANNOTATION_PACKAGE_FQ_NAME, KOTLIN_REFLECT_FQ_NAME, KOTLIN_INTERNAL_FQ_NAME, COROUTINES_PACKAGE_FQ_NAME, CONCURRENT_ATOMICS_PACKAGE_FQ_NAME};
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(objectArray);
    }

    @SourceDebugExtension(value={"SMAP\nStandardNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,332:1\n11563#2,3:333\n11563#2,3:336\n*S KotlinDebug\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n*L\n220#1:333,3\n224#1:336,3\n*E\n"})
    public static final class FqNames {
        @NotNull
        public static final FqNames INSTANCE;
        @JvmField
        @NotNull
        public static final FqNameUnsafe any;
        @JvmField
        @NotNull
        public static final FqNameUnsafe nothing;
        @JvmField
        @NotNull
        public static final FqNameUnsafe cloneable;
        @JvmField
        @NotNull
        public static final FqName suppress;
        @JvmField
        @NotNull
        public static final FqNameUnsafe unit;
        @JvmField
        @NotNull
        public static final FqNameUnsafe charSequence;
        @JvmField
        @NotNull
        public static final FqNameUnsafe string;
        @JvmField
        @NotNull
        public static final FqNameUnsafe array;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _boolean;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _char;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _byte;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _short;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _int;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _long;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _float;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _double;
        @JvmField
        @NotNull
        public static final FqNameUnsafe number;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _enum;
        @JvmField
        @NotNull
        public static final FqNameUnsafe functionSupertype;
        @JvmField
        @NotNull
        public static final FqName throwable;
        @JvmField
        @NotNull
        public static final FqName comparable;
        @JvmField
        @NotNull
        public static final FqNameUnsafe intRange;
        @JvmField
        @NotNull
        public static final FqNameUnsafe longRange;
        @JvmField
        @NotNull
        public static final FqName deprecated;
        @JvmField
        @NotNull
        public static final FqName deprecatedSinceKotlin;
        @JvmField
        @NotNull
        public static final FqName deprecationLevel;
        @JvmField
        @NotNull
        public static final FqName replaceWith;
        @JvmField
        @NotNull
        public static final FqName extensionFunctionType;
        @JvmField
        @NotNull
        public static final FqName contextFunctionTypeParams;
        @JvmField
        @NotNull
        public static final FqName parameterName;
        @JvmField
        @NotNull
        public static final ClassId parameterNameClassId;
        @JvmField
        @NotNull
        public static final FqName annotation;
        @JvmField
        @NotNull
        public static final FqName target;
        @JvmField
        @NotNull
        public static final ClassId targetClassId;
        @JvmField
        @NotNull
        public static final FqName annotationTarget;
        @JvmField
        @NotNull
        public static final FqName annotationRetention;
        @JvmField
        @NotNull
        public static final FqName retention;
        @JvmField
        @NotNull
        public static final ClassId retentionClassId;
        @JvmField
        @NotNull
        public static final FqName repeatable;
        @JvmField
        @NotNull
        public static final ClassId repeatableClassId;
        @JvmField
        @NotNull
        public static final FqName mustBeDocumented;
        @JvmField
        @NotNull
        public static final FqName unsafeVariance;
        @JvmField
        @NotNull
        public static final FqName publishedApi;
        @JvmField
        @NotNull
        public static final FqName accessibleLateinitPropertyLiteral;
        @JvmField
        @NotNull
        public static final FqName platformDependent;
        @JvmField
        @NotNull
        public static final ClassId platformDependentClassId;
        @JvmField
        @NotNull
        public static final FqName iterator;
        @JvmField
        @NotNull
        public static final FqName iterable;
        @JvmField
        @NotNull
        public static final FqName collection;
        @JvmField
        @NotNull
        public static final FqName list;
        @JvmField
        @NotNull
        public static final FqName listIterator;
        @JvmField
        @NotNull
        public static final FqName set;
        @JvmField
        @NotNull
        public static final FqName map;
        @JvmField
        @NotNull
        public static final FqName mapEntry;
        @JvmField
        @NotNull
        public static final FqName mutableIterator;
        @JvmField
        @NotNull
        public static final FqName mutableIterable;
        @JvmField
        @NotNull
        public static final FqName mutableCollection;
        @JvmField
        @NotNull
        public static final FqName mutableList;
        @JvmField
        @NotNull
        public static final FqName mutableListIterator;
        @JvmField
        @NotNull
        public static final FqName mutableSet;
        @JvmField
        @NotNull
        public static final FqName mutableMap;
        @JvmField
        @NotNull
        public static final FqName mutableMapEntry;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kClass;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kType;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kCallable;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty0;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty1;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty2;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty0;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty1;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty2;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kPropertyFqName;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutablePropertyFqName;
        @JvmField
        @NotNull
        public static final ClassId kProperty;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kDeclarationContainer;
        @JvmField
        @NotNull
        public static final FqNameUnsafe findAssociatedObject;
        @JvmField
        @NotNull
        public static final FqName uByteFqName;
        @JvmField
        @NotNull
        public static final FqName uShortFqName;
        @JvmField
        @NotNull
        public static final FqName uIntFqName;
        @JvmField
        @NotNull
        public static final FqName uLongFqName;
        @JvmField
        @NotNull
        public static final ClassId uByte;
        @JvmField
        @NotNull
        public static final ClassId uShort;
        @JvmField
        @NotNull
        public static final ClassId uInt;
        @JvmField
        @NotNull
        public static final ClassId uLong;
        @JvmField
        @NotNull
        public static final FqName uByteArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uShortArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uIntArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uLongArrayFqName;
        @JvmField
        @NotNull
        public static final FqName atomicInt;
        @JvmField
        @NotNull
        public static final FqName atomicLong;
        @JvmField
        @NotNull
        public static final FqName atomicBoolean;
        @JvmField
        @NotNull
        public static final FqName atomicReference;
        @JvmField
        @NotNull
        public static final FqName atomicIntArray;
        @JvmField
        @NotNull
        public static final FqName atomicLongArray;
        @JvmField
        @NotNull
        public static final FqName atomicArray;
        @JvmField
        @NotNull
        public static final Set<Name> primitiveTypeShortNames;
        @JvmField
        @NotNull
        public static final Set<Name> primitiveArrayTypeShortNames;
        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;

        private FqNames() {
        }

        private final FqNameUnsafe fqNameUnsafe(String simpleName) {
            return this.fqName(simpleName).toUnsafe();
        }

        private final FqName fqName(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return BUILT_INS_PACKAGE_FQ_NAME.child(name);
        }

        private final FqName collectionsFqName(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return COLLECTIONS_PACKAGE_FQ_NAME.child(name);
        }

        private final FqNameUnsafe rangesFqName(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return RANGES_PACKAGE_FQ_NAME.child(name).toUnsafe();
        }

        @JvmStatic
        @NotNull
        public static final FqNameUnsafe reflect(@NotNull String simpleName) {
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return KOTLIN_REFLECT_FQ_NAME.child(name).toUnsafe();
        }

        private final FqName annotationName(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return ANNOTATION_PACKAGE_FQ_NAME.child(name);
        }

        private final FqName internalName(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return KOTLIN_INTERNAL_FQ_NAME.child(name);
        }

        private final FqName concurrentAtomics(String simpleName) {
            Name name = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            return CONCURRENT_ATOMICS_PACKAGE_FQ_NAME.child(name);
        }

        static {
            Map map;
            PrimitiveType it;
            Collection collection;
            PrimitiveType item$iv;
            int n2;
            Cloneable cloneable;
            INSTANCE = new FqNames();
            any = INSTANCE.fqNameUnsafe("Any");
            nothing = INSTANCE.fqNameUnsafe("Nothing");
            FqNames.cloneable = INSTANCE.fqNameUnsafe("Cloneable");
            suppress = INSTANCE.fqName("Suppress");
            unit = INSTANCE.fqNameUnsafe("Unit");
            charSequence = INSTANCE.fqNameUnsafe("CharSequence");
            string = INSTANCE.fqNameUnsafe("String");
            array = INSTANCE.fqNameUnsafe("Array");
            _boolean = INSTANCE.fqNameUnsafe("Boolean");
            _char = INSTANCE.fqNameUnsafe("Char");
            _byte = INSTANCE.fqNameUnsafe("Byte");
            _short = INSTANCE.fqNameUnsafe("Short");
            _int = INSTANCE.fqNameUnsafe("Int");
            _long = INSTANCE.fqNameUnsafe("Long");
            _float = INSTANCE.fqNameUnsafe("Float");
            _double = INSTANCE.fqNameUnsafe("Double");
            number = INSTANCE.fqNameUnsafe("Number");
            _enum = INSTANCE.fqNameUnsafe("Enum");
            functionSupertype = INSTANCE.fqNameUnsafe("Function");
            throwable = INSTANCE.fqName("Throwable");
            comparable = INSTANCE.fqName("Comparable");
            intRange = INSTANCE.rangesFqName("IntRange");
            longRange = INSTANCE.rangesFqName("LongRange");
            deprecated = INSTANCE.fqName("Deprecated");
            deprecatedSinceKotlin = INSTANCE.fqName("DeprecatedSinceKotlin");
            deprecationLevel = INSTANCE.fqName("DeprecationLevel");
            replaceWith = INSTANCE.fqName("ReplaceWith");
            extensionFunctionType = INSTANCE.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = INSTANCE.fqName("ContextFunctionTypeParams");
            parameterName = INSTANCE.fqName("ParameterName");
            parameterNameClassId = ClassId.Companion.topLevel(parameterName);
            annotation = INSTANCE.fqName("Annotation");
            target = INSTANCE.annotationName("Target");
            targetClassId = ClassId.Companion.topLevel(target);
            annotationTarget = INSTANCE.annotationName("AnnotationTarget");
            annotationRetention = INSTANCE.annotationName("AnnotationRetention");
            retention = INSTANCE.annotationName("Retention");
            retentionClassId = ClassId.Companion.topLevel(retention);
            repeatable = INSTANCE.annotationName("Repeatable");
            repeatableClassId = ClassId.Companion.topLevel(repeatable);
            mustBeDocumented = INSTANCE.annotationName("MustBeDocumented");
            unsafeVariance = INSTANCE.fqName("UnsafeVariance");
            publishedApi = INSTANCE.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = INSTANCE.internalName("AccessibleLateinitPropertyLiteral");
            platformDependent = new FqName("kotlin.internal.PlatformDependent");
            platformDependentClassId = ClassId.Companion.topLevel(platformDependent);
            iterator = INSTANCE.collectionsFqName("Iterator");
            iterable = INSTANCE.collectionsFqName("Iterable");
            FqNames.collection = INSTANCE.collectionsFqName("Collection");
            list = INSTANCE.collectionsFqName("List");
            listIterator = INSTANCE.collectionsFqName("ListIterator");
            set = INSTANCE.collectionsFqName("Set");
            FqNames.map = INSTANCE.collectionsFqName("Map");
            Name name = Name.identifier("Entry");
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            mapEntry = FqNames.map.child(name);
            mutableIterator = INSTANCE.collectionsFqName("MutableIterator");
            mutableIterable = INSTANCE.collectionsFqName("MutableIterable");
            mutableCollection = INSTANCE.collectionsFqName("MutableCollection");
            mutableList = INSTANCE.collectionsFqName("MutableList");
            mutableListIterator = INSTANCE.collectionsFqName("MutableListIterator");
            mutableSet = INSTANCE.collectionsFqName("MutableSet");
            mutableMap = INSTANCE.collectionsFqName("MutableMap");
            Name name2 = Name.identifier("MutableEntry");
            Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
            mutableMapEntry = mutableMap.child(name2);
            kClass = FqNames.reflect("KClass");
            kType = FqNames.reflect("KType");
            kCallable = FqNames.reflect("KCallable");
            kProperty0 = FqNames.reflect("KProperty0");
            kProperty1 = FqNames.reflect("KProperty1");
            kProperty2 = FqNames.reflect("KProperty2");
            kMutableProperty0 = FqNames.reflect("KMutableProperty0");
            kMutableProperty1 = FqNames.reflect("KMutableProperty1");
            kMutableProperty2 = FqNames.reflect("KMutableProperty2");
            kPropertyFqName = FqNames.reflect("KProperty");
            kMutablePropertyFqName = FqNames.reflect("KMutableProperty");
            kProperty = ClassId.Companion.topLevel(kPropertyFqName.toSafe());
            kDeclarationContainer = FqNames.reflect("KDeclarationContainer");
            findAssociatedObject = FqNames.reflect("findAssociatedObject");
            uByteFqName = INSTANCE.fqName("UByte");
            uShortFqName = INSTANCE.fqName("UShort");
            uIntFqName = INSTANCE.fqName("UInt");
            uLongFqName = INSTANCE.fqName("ULong");
            uByte = ClassId.Companion.topLevel(uByteFqName);
            uShort = ClassId.Companion.topLevel(uShortFqName);
            uInt = ClassId.Companion.topLevel(uIntFqName);
            uLong = ClassId.Companion.topLevel(uLongFqName);
            uByteArrayFqName = INSTANCE.fqName("UByteArray");
            uShortArrayFqName = INSTANCE.fqName("UShortArray");
            uIntArrayFqName = INSTANCE.fqName("UIntArray");
            uLongArrayFqName = INSTANCE.fqName("ULongArray");
            atomicInt = INSTANCE.concurrentAtomics("AtomicInt");
            atomicLong = INSTANCE.concurrentAtomics("AtomicLong");
            atomicBoolean = INSTANCE.concurrentAtomics("AtomicBoolean");
            atomicReference = INSTANCE.concurrentAtomics("AtomicReference");
            atomicIntArray = INSTANCE.concurrentAtomics("AtomicIntArray");
            atomicLongArray = INSTANCE.concurrentAtomics("AtomicLongArray");
            atomicArray = INSTANCE.concurrentAtomics("AtomicArray");
            HashSet $this$primitiveTypeShortNames_u24lambda_u241 = cloneable = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            boolean bl2 = false;
            PrimitiveType[] $this$mapTo$iv = PrimitiveType.values();
            boolean $i$f$mapTo = false;
            int n3 = $this$mapTo$iv.length;
            for (n2 = 0; n2 < n3; ++n2) {
                PrimitiveType primitiveType = item$iv = $this$mapTo$iv[n2];
                collection = $this$primitiveTypeShortNames_u24lambda_u241;
                boolean bl3 = false;
                collection.add(it.getTypeName());
            }
            primitiveTypeShortNames = cloneable;
            HashSet $this$primitiveArrayTypeShortNames_u24lambda_u243 = cloneable = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            boolean bl4 = false;
            $this$mapTo$iv = PrimitiveType.values();
            $i$f$mapTo = false;
            n3 = $this$mapTo$iv.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it = item$iv = $this$mapTo$iv[n2];
                collection = $this$primitiveArrayTypeShortNames_u24lambda_u243;
                boolean bl5 = false;
                collection.add(it.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = cloneable;
            Cloneable $this$fqNameToPrimitiveType_u24lambda_u244 = cloneable = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            boolean bl6 = false;
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                map = (Map)((Object)$this$fqNameToPrimitiveType_u24lambda_u244);
                String string = primitiveType.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                map.put(INSTANCE.fqNameUnsafe(string), primitiveType);
            }
            fqNameToPrimitiveType = (Map)((Object)cloneable);
            Cloneable $this$arrayClassFqNameToPrimitiveType_u24lambda_u245 = cloneable = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            boolean bl7 = false;
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                map = (Map)((Object)$this$arrayClassFqNameToPrimitiveType_u24lambda_u245);
                String string = primitiveType.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                map.put(INSTANCE.fqNameUnsafe(string), primitiveType);
            }
            arrayClassFqNameToPrimitiveType = (Map)((Object)cloneable);
        }
    }
}

