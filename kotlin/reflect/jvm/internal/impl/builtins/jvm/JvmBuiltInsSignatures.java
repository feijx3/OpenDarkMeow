/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nJvmBuiltInsSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n13#2:213\n13#2:219\n13#2:225\n13#2:226\n13#2:227\n13#2:228\n13#2:229\n13#2:230\n1460#3,5:214\n1460#3,5:220\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n*L\n64#1:213\n185#1:219\n23#1:225\n71#1:226\n80#1:227\n136#1:228\n163#1:229\n180#1:230\n65#1:214,5\n189#1:220,5\n*E\n"})
public final class JvmBuiltInsSignatures {
    @NotNull
    public static final JvmBuiltInsSignatures INSTANCE = new JvmBuiltInsSignatures();
    @NotNull
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> HIDDEN_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> DEPRECATED_LIST_METHODS;
    @NotNull
    private static final Set<String> VISIBLE_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> MUTABLE_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES;
    @NotNull
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES;

    private JvmBuiltInsSignatures() {
    }

    @NotNull
    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<String> buildPrimitiveValueMethodsSet() {
        void $this$flatMapTo$iv;
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$buildPrimitiveValueMethodsSet_u24lambda_u242 = SignatureBuildingComponents.INSTANCE;
        boolean bl2 = false;
        Object object = new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR};
        object = CollectionsKt.listOf(object);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            JvmPrimitiveType it = (JvmPrimitiveType)((Object)element$iv);
            boolean bl3 = false;
            String string = it.getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            String[] stringArray = new String[]{it.getJavaKeywordName() + "Value()" + it.getDesc()};
            Iterable list$iv = $this$buildPrimitiveValueMethodsSet_u24lambda_u242.inJavaLang(string, stringArray);
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (LinkedHashSet)destination$iv;
    }

    @NotNull
    public final Set<String> getDEPRECATED_LIST_METHODS() {
        return DEPRECATED_LIST_METHODS;
    }

    @NotNull
    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    @NotNull
    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<String> buildPrimitiveStringConstructorsSet() {
        void $this$flatMapTo$iv;
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$buildPrimitiveStringConstructorsSet_u24lambda_u249 = SignatureBuildingComponents.INSTANCE;
        boolean bl2 = false;
        Object object = new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT};
        object = CollectionsKt.listOf(object);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            JvmPrimitiveType it = (JvmPrimitiveType)((Object)element$iv);
            boolean bl3 = false;
            String string = it.getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            String[] stringArray = new String[]{"Ljava/lang/String;"};
            String[] stringArray2 = $this$buildPrimitiveStringConstructorsSet_u24lambda_u249.constructors(stringArray);
            Iterable list$iv = $this$buildPrimitiveStringConstructorsSet_u24lambda_u249.inJavaLang(string, Arrays.copyOf(stringArray2, stringArray2.length));
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (LinkedHashSet)destination$iv;
    }

    public final boolean isSerializableInJava(@NotNull FqNameUnsafe fqName) {
        Class<?> clazz;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.isArrayOrPrimitiveArray(fqName)) {
            return true;
        }
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (classId == null) {
            return false;
        }
        ClassId javaClassId = classId;
        try {
            clazz = Class.forName(javaClassId.asSingleFqName().asString());
        }
        catch (ClassNotFoundException e2) {
            return false;
        }
        Class<?> classViaReflection = clazz;
        return Serializable.class.isAssignableFrom(classViaReflection);
    }

    public final boolean isArrayOrPrimitiveArray(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return Intrinsics.areEqual(fqName, StandardNames.FqNames.array) || StandardNames.isPrimitiveArray(fqName);
    }

    static {
        String[] stringArray = new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"};
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", stringArray), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        boolean bl2 = false;
        String[] stringArray2 = new String[]{"sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;"};
        Set<String> set = SetsKt.plus(INSTANCE.buildPrimitiveValueMethodsSet(), (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("List", stringArray2));
        stringArray2 = new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"};
        Set<String> set2 = SetsKt.plus(set, (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("String", stringArray2));
        stringArray2 = new String[]{"isInfinite()Z", "isNaN()Z"};
        Set<String> set3 = SetsKt.plus(set2, (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Double", stringArray2));
        stringArray2 = new String[]{"isInfinite()Z", "isNaN()Z"};
        Set<String> set4 = SetsKt.plus(set3, (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Float", stringArray2));
        stringArray2 = new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"};
        Set<String> set5 = SetsKt.plus(set4, (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Enum", stringArray2));
        stringArray2 = new String[]{"isEmpty()Z"};
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(set5, (Iterable)$this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("CharSequence", stringArray2));
        $i$f$signatures = false;
        SignatureBuildingComponents $this$DEPRECATED_LIST_METHODS_u24lambda_u243 = SignatureBuildingComponents.INSTANCE;
        boolean bl3 = false;
        stringArray2 = new String[]{"getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;"};
        DEPRECATED_LIST_METHODS = $this$DEPRECATED_LIST_METHODS_u24lambda_u243.inJavaUtil("List", stringArray2);
        $i$f$signatures = false;
        SignatureBuildingComponents $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244 = SignatureBuildingComponents.INSTANCE;
        boolean bl4 = false;
        stringArray2 = new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"};
        Set<String> set6 = $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaLang("CharSequence", stringArray2);
        stringArray2 = new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"};
        Set<String> set7 = SetsKt.plus(set6, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaUtil("Iterator", stringArray2));
        stringArray2 = new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"};
        Set<String> set8 = SetsKt.plus(set7, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaLang("Iterable", stringArray2));
        stringArray2 = new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"};
        Set<String> set9 = SetsKt.plus(set8, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaLang("Throwable", stringArray2));
        stringArray2 = new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"};
        Set<String> set10 = SetsKt.plus(set9, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaUtil("Collection", stringArray2));
        stringArray2 = new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"};
        Set<String> set11 = SetsKt.plus(set10, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaUtil("List", stringArray2));
        stringArray2 = new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"};
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(set11, (Iterable)$this$VISIBLE_METHOD_SIGNATURES_u24lambda_u244.inJavaUtil("Map", stringArray2));
        $i$f$signatures = false;
        SignatureBuildingComponents $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u245 = SignatureBuildingComponents.INSTANCE;
        boolean bl5 = false;
        stringArray2 = new String[]{"removeIf(Ljava/util/function/Predicate;)Z"};
        Set<String> set12 = $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u245.inJavaUtil("Collection", stringArray2);
        stringArray2 = new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"};
        Set<String> set13 = SetsKt.plus(set12, (Iterable)$this$MUTABLE_METHOD_SIGNATURES_u24lambda_u245.inJavaUtil("List", stringArray2));
        stringArray2 = new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"};
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(set13, (Iterable)$this$MUTABLE_METHOD_SIGNATURES_u24lambda_u245.inJavaUtil("Map", stringArray2));
        $i$f$signatures = false;
        SignatureBuildingComponents $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u246 = SignatureBuildingComponents.INSTANCE;
        boolean bl6 = false;
        stringArray2 = new String[]{"D"};
        String[] stringArray3 = $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u246.constructors(stringArray2);
        Set<String> set14 = SetsKt.plus(INSTANCE.buildPrimitiveStringConstructorsSet(), (Iterable)$this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u246.inJavaLang("Float", Arrays.copyOf(stringArray3, stringArray3.length)));
        stringArray2 = new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"};
        stringArray3 = $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u246.constructors(stringArray2);
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(set14, (Iterable)$this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u246.inJavaLang("String", Arrays.copyOf(stringArray3, stringArray3.length)));
        $i$f$signatures = false;
        SignatureBuildingComponents $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u247 = SignatureBuildingComponents.INSTANCE;
        boolean bl7 = false;
        stringArray2 = new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"};
        stringArray3 = $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u247.constructors(stringArray2);
        VISIBLE_CONSTRUCTOR_SIGNATURES = $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u247.inJavaLang("Throwable", Arrays.copyOf(stringArray3, stringArray3.length));
    }
}

