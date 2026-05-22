/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nSpecialGenericSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,194:1\n1563#2:195\n1634#2,3:196\n1563#2:199\n1634#2,3:200\n1563#2:203\n1634#2,3:204\n1252#2,4:210\n1563#2:214\n1634#2,3:215\n1563#2:218\n1634#2,3:219\n1252#2,4:225\n1634#2,3:232\n1563#2:235\n1634#2,3:236\n1222#2,2:239\n1252#2,4:241\n13#3:207\n13#3:222\n478#4:208\n424#4:209\n478#4:223\n424#4:224\n153#5,3:229\n*S KotlinDebug\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n*L\n57#1:195\n57#1:196,3\n59#1:199\n59#1:200,3\n60#1:203\n60#1:204,3\n98#1:210,4\n104#1:214\n104#1:215,3\n105#1:218\n105#1:219,3\n168#1:225,4\n176#1:232,3\n180#1:235\n180#1:236,3\n181#1:239,2\n181#1:241,4\n63#1:207\n114#1:222\n98#1:208\n98#1:209\n168#1:223\n168#1:224\n172#1:229,3\n*E\n"})
public class SpecialGenericSignatures {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    @NotNull
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    @NotNull
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    @NotNull
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    @NotNull
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    @NotNull
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    @NotNull
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    @NotNull
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    @NotNull
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    @NotNull
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    @NotNull
    private static final Set<String> JVM_SIGNATURES_FOR_RENAMED_BUILT_INS;
    @NotNull
    private static final Set<Name> ORIGINAL_SHORT_NAMES;
    @NotNull
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;

    /*
     * WARNING - void declaration
     */
    static {
        void $this$associateByTo$iv$iv;
        Iterable $this$mapTo$iv;
        Pair[] $this$mapTo$iv$iv;
        Map.Entry it$iv$iv;
        Object object;
        String string;
        void $this$mapKeysTo$iv$iv;
        Iterable $this$mapTo$iv$iv2;
        Object object2;
        Iterable $this$mapTo$iv$iv22;
        Companion = new Companion(null);
        String[] stringArray = new String[]{"containsAll", "removeAll", "retainAll"};
        Iterable $this$map$iv = SetsKt.setOf(stringArray);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Object destination$iv$iv = (Pair[])new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl2 = false;
        for (Object item$iv$iv2 : $this$mapTo$iv$iv22) {
            String string2 = (String)item$iv$iv2;
            object2 = destination$iv$iv;
            boolean bl3 = false;
            String string3 = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(string3, "getDesc(...)");
            object2.add(SpecialGenericSignatures.Companion.method("java/util/Collection", string2, "Ljava/util/Collection;", string3));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = (List)destination$iv$iv;
        $this$map$iv = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        $i$f$map = false;
        $this$mapTo$iv$iv22 = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl3 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            Companion.NameAndSignature nameAndSignature = (Companion.NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv;
            boolean bl4 = false;
            object2.add(nameAndSignature.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = (List)destination$iv$iv;
        $this$map$iv = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        $i$f$map = false;
        $this$mapTo$iv$iv2 = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl4 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            Companion.NameAndSignature nameAndSignature = (Companion.NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv;
            boolean bl5 = false;
            object2.add(nameAndSignature.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = (List)destination$iv$iv;
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243 = SignatureBuildingComponents.INSTANCE;
        boolean $i$a$-signatures-SpecialGenericSignatures$Companion$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP$232 = false;
        destination$iv$iv = new Pair[10];
        String string4 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Collection");
        String string5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(string5, "getDesc(...)");
        destination$iv$iv[0] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string4, "contains", "Ljava/lang/Object;", string5), TypeSafeBarrierDescription.FALSE);
        String string6 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Collection");
        String string7 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(string7, "getDesc(...)");
        destination$iv$iv[1] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string6, "remove", "Ljava/lang/Object;", string7), TypeSafeBarrierDescription.FALSE);
        String string8 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map");
        String string9 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(string9, "getDesc(...)");
        destination$iv$iv[2] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string8, "containsKey", "Ljava/lang/Object;", string9), TypeSafeBarrierDescription.FALSE);
        String string10 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map");
        String string11 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(string11, "getDesc(...)");
        destination$iv$iv[3] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string10, "containsValue", "Ljava/lang/Object;", string11), TypeSafeBarrierDescription.FALSE);
        String string12 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map");
        String string13 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(string13, "getDesc(...)");
        destination$iv$iv[4] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string12, "remove", "Ljava/lang/Object;Ljava/lang/Object;", string13), TypeSafeBarrierDescription.FALSE);
        destination$iv$iv[5] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        destination$iv$iv[6] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        destination$iv$iv[7] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        String string14 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("List");
        String string15 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string15, "getDesc(...)");
        destination$iv$iv[8] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string14, "indexOf", "Ljava/lang/Object;", string15), TypeSafeBarrierDescription.INDEX);
        String string16 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u243.javaUtil("List");
        String string17 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string17, "getDesc(...)");
        destination$iv$iv[9] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string16, "lastIndexOf", "Ljava/lang/Object;", string17), TypeSafeBarrierDescription.INDEX);
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> $this$mapKeys$iv = GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = MapsKt.mapOf(destination$iv$iv);
        boolean $i$f$mapKeys = false;
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> $i$a$-signatures-SpecialGenericSignatures$Companion$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP$232 = $this$mapKeys$iv;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv.size()));
        boolean bl5 = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeysTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Object it2;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            object2 = destination$iv$iv;
            boolean bl6 = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            string = ((Companion.NameAndSignature)it2.getKey()).getSignature();
            object = object2;
            boolean bl22 = false;
            it2 = it$iv$iv.getValue();
            object.put(string, it2);
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = destination$iv$iv;
        Set<Companion.NameAndSignature> allMethods = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable)ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        Iterable $this$map$iv2 = allMethods;
        boolean $i$f$map2 = false;
        destination$iv$iv = $this$map$iv2;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        boolean $i$f$mapTo2 = false;
        for (Object t2 : $this$mapTo$iv$iv) {
            void it3;
            Companion.NameAndSignature element$iv$iv$iv = (Companion.NameAndSignature)t2;
            object2 = collection;
            boolean bl7 = false;
            object2.add(it3.getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet((List)collection);
        Pair[] $this$map$iv3 = (Pair[])allMethods;
        boolean $i$f$map3 = false;
        $this$mapTo$iv$iv = $this$map$iv3;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        boolean $i$f$mapTo = false;
        for (Object t3 : $this$mapTo$iv$iv) {
            void it;
            Companion.NameAndSignature it3 = (Companion.NameAndSignature)t3;
            object2 = collection2;
            boolean bl8 = false;
            object2.add(it.getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet((List)collection2);
        String string18 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string18, "getDesc(...)");
        REMOVE_AT_NAME_AND_SIGNATURE = SpecialGenericSignatures.Companion.method("java/util/List", "removeAt", string18, "Ljava/lang/Object;");
        $i$f$signatures = false;
        SignatureBuildingComponents $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247 = SignatureBuildingComponents.INSTANCE;
        boolean $i$a$-signatures-SpecialGenericSignatures$Companion$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP$232 = false;
        $this$mapTo$iv$iv = new Pair[40];
        String string19 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string20 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(string20, "getDesc(...)");
        $this$mapTo$iv$iv[0] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string19, "toByte", "", string20), Name.identifier("byteValue"));
        String string21 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string22 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string22, "getDesc(...)");
        $this$mapTo$iv$iv[1] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string21, "toShort", "", string22), Name.identifier("shortValue"));
        String string23 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string24 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string24, "getDesc(...)");
        $this$mapTo$iv$iv[2] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string23, "toInt", "", string24), Name.identifier("intValue"));
        String string25 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string26 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(string26, "getDesc(...)");
        $this$mapTo$iv$iv[3] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string25, "toLong", "", string26), Name.identifier("longValue"));
        String string27 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string28 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string28, "getDesc(...)");
        $this$mapTo$iv$iv[4] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string27, "toFloat", "", string28), Name.identifier("floatValue"));
        String string29 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("Number");
        String string30 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(string30, "getDesc(...)");
        $this$mapTo$iv$iv[5] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string29, "toDouble", "", string30), Name.identifier("doubleValue"));
        $this$mapTo$iv$iv[6] = TuplesKt.to(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove"));
        String string31 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaLang("CharSequence");
        String string32 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(string32, "getDesc(...)");
        String string33 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(string33, "getDesc(...)");
        $this$mapTo$iv$iv[7] = TuplesKt.to(SpecialGenericSignatures.Companion.method(string31, "get", string32, string33), Name.identifier("charAt"));
        $this$mapTo$iv$iv[8] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicInteger"), "load", "", "I"), Name.identifier("get"));
        $this$mapTo$iv$iv[9] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicInteger"), "store", "I", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[10] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicInteger"), "exchange", "I", "I"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[11] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicInteger"), "fetchAndAdd", "I", "I"), Name.identifier("getAndAdd"));
        $this$mapTo$iv$iv[12] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicInteger"), "addAndFetch", "I", "I"), Name.identifier("addAndGet"));
        $this$mapTo$iv$iv[13] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLong"), "load", "", "J"), Name.identifier("get"));
        $this$mapTo$iv$iv[14] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLong"), "store", "J", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[15] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLong"), "exchange", "J", "J"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[16] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLong"), "fetchAndAdd", "J", "J"), Name.identifier("getAndAdd"));
        $this$mapTo$iv$iv[17] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLong"), "addAndFetch", "J", "J"), Name.identifier("addAndGet"));
        $this$mapTo$iv$iv[18] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicBoolean"), "load", "", "Z"), Name.identifier("get"));
        $this$mapTo$iv$iv[19] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicBoolean"), "store", "Z", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[20] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicBoolean"), "exchange", "Z", "Z"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[21] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReference"), "load", "", "Ljava/lang/Object;"), Name.identifier("get"));
        $this$mapTo$iv$iv[22] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReference"), "store", "Ljava/lang/Object;", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[23] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[24] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "loadAt", "I", "I"), Name.identifier("get"));
        $this$mapTo$iv$iv[25] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "storeAt", "II", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[26] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "exchangeAt", "II", "I"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[27] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), Name.identifier("compareAndSet"));
        $this$mapTo$iv$iv[28] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), Name.identifier("getAndAdd"));
        $this$mapTo$iv$iv[29] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), Name.identifier("addAndGet"));
        $this$mapTo$iv$iv[30] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "loadAt", "I", "J"), Name.identifier("get"));
        $this$mapTo$iv$iv[31] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "storeAt", "IJ", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[32] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "exchangeAt", "IJ", "J"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[33] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), Name.identifier("compareAndSet"));
        $this$mapTo$iv$iv[34] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), Name.identifier("getAndAdd"));
        $this$mapTo$iv$iv[35] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), Name.identifier("addAndGet"));
        $this$mapTo$iv$iv[36] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), Name.identifier("get"));
        $this$mapTo$iv$iv[37] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", "V"), Name.identifier("set"));
        $this$mapTo$iv$iv[38] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet"));
        $this$mapTo$iv$iv[39] = TuplesKt.to(SpecialGenericSignatures.Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u247.javaUtilConcurrentAtomic("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), Name.identifier("compareAndSet"));
        Map<Companion.NameAndSignature, Name> $this$mapKeys$iv2 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = MapsKt.mapOf($this$mapTo$iv$iv);
        $i$f$mapKeys = false;
        Map<Companion.NameAndSignature, Name> $i$a$-signatures-SpecialGenericSignatures$Companion$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP$232 = $this$mapKeys$iv2;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv2.size()));
        boolean bl6 = false;
        Object $this$associateByTo$iv$iv$iv2 = $this$mapKeysTo$iv$iv.entrySet();
        $i$f$associateByTo = false;
        Iterator iterator2 = $this$associateByTo$iv$iv$iv2.iterator();
        while (iterator2.hasNext()) {
            Object it4;
            Object element$iv$iv$iv = iterator2.next();
            Map.Entry bl8 = (Map.Entry)element$iv$iv$iv;
            object2 = destination$iv$iv;
            boolean bl9 = false;
            it$iv$iv = (Map.Entry)element$iv$iv$iv;
            string = ((Companion.NameAndSignature)it4.getKey()).getSignature();
            object = object2;
            boolean bl7 = false;
            it4 = it$iv$iv.getValue();
            object.put(string, it4);
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = destination$iv$iv;
        $this$mapKeys$iv2 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo3 = false;
        for (Map.Entry entry : $this$mapTo$iv.entrySet()) {
            $this$associateByTo$iv$iv$iv2 = entry;
            object2 = destination$iv;
            boolean bl10 = false;
            Companion.NameAndSignature nameAndSignature = (Companion.NameAndSignature)$this$associateByTo$iv$iv$iv2.getKey();
            Name jdkName = (Name)$this$associateByTo$iv$iv$iv2.getValue();
            object2.add(Companion.NameAndSignature.copy$default(nameAndSignature, null, jdkName, null, null, 13, null).getSignature());
        }
        JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = (Set)destination$iv;
        $this$mapTo$iv = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        destination$iv = new HashSet();
        boolean $i$f$mapTo232 = false;
        for (Object e2 : $this$mapTo$iv) {
            Iterator it5;
            $this$associateByTo$iv$iv$iv2 = (Companion.NameAndSignature)e2;
            object2 = destination$iv;
            boolean bl11 = false;
            object2.add(((Companion.NameAndSignature)((Object)it5)).getName());
        }
        ORIGINAL_SHORT_NAMES = (Set)destination$iv;
        $this$map$iv = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        $i$f$map = false;
        Iterable $i$f$mapTo232 = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl8 = false;
        for (Object item$iv$iv4 : $this$mapTo$iv$iv) {
            Map.Entry entry = (Map.Entry)item$iv$iv4;
            object2 = destination$iv$iv;
            boolean bl12 = false;
            object2.add(new Pair(((Companion.NameAndSignature)entry.getKey()).getName(), entry.getValue()));
        }
        Iterable $this$associateBy$iv = (List)destination$iv$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        destination$iv$iv = $this$associateBy$iv;
        Map map = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo2 = false;
        for (Object t4 : $this$associateByTo$iv$iv) {
            void it;
            Pair bl12 = (Pair)t4;
            object2 = map;
            boolean bl13 = false;
            Pair it6 = (Pair)t4;
            Name name = (Name)it6.getSecond();
            boolean bl14 = false;
            Name name2 = (Name)it.getFirst();
            object2.put(name, name2);
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = map;
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SpecialSignatureInfo getSpecialSignatureInfo(@NotNull String builtinSignature) {
            Intrinsics.checkNotNullParameter(builtinSignature, "builtinSignature");
            if (this.getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            TypeSafeBarrierDescription defaultValue = MapsKt.getValue(this.getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature);
            return defaultValue == TypeSafeBarrierDescription.NULL ? SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC : SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        private final NameAndSignature method(String $this$method, String name, String parameters, String returnType) {
            Name name2 = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
            return new NameAndSignature($this$method, name2, parameters, returnType);
        }

        @NotNull
        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        @NotNull
        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        @NotNull
        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        @NotNull
        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return REMOVE_AT_NAME_AND_SIGNATURE;
        }

        @NotNull
        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        @NotNull
        public final Set<Name> getORIGINAL_SHORT_NAMES() {
            return ORIGINAL_SHORT_NAMES;
        }

        @NotNull
        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        @Nullable
        public final Name getBuiltinFunctionNamesByJvmName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name $this$sameAsRenamedInJvmBuiltin) {
            Intrinsics.checkNotNullParameter($this$sameAsRenamedInJvmBuiltin, "<this>");
            return this.getORIGINAL_SHORT_NAMES().contains($this$sameAsRenamedInJvmBuiltin);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class NameAndSignature {
            @NotNull
            private final String classInternalName;
            @NotNull
            private final Name name;
            @NotNull
            private final String parameters;
            @NotNull
            private final String returnType;
            @NotNull
            private final String signature;

            public NameAndSignature(@NotNull String classInternalName, @NotNull Name name, @NotNull String parameters, @NotNull String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                this.classInternalName = classInternalName;
                this.name = name;
                this.parameters = parameters;
                this.returnType = returnType;
                this.signature = SignatureBuildingComponents.INSTANCE.signature(this.classInternalName, this.name + '(' + this.parameters + ')' + this.returnType);
            }

            @NotNull
            public final Name getName() {
                return this.name;
            }

            @NotNull
            public final String getSignature() {
                return this.signature;
            }

            @NotNull
            public final NameAndSignature copy(@NotNull String classInternalName, @NotNull Name name, @NotNull String parameters, @NotNull String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                return new NameAndSignature(classInternalName, name, parameters, returnType);
            }

            public static /* synthetic */ NameAndSignature copy$default(NameAndSignature nameAndSignature, String string, Name name, String string2, String string3, int n2, Object object) {
                if ((n2 & 1) != 0) {
                    string = nameAndSignature.classInternalName;
                }
                if ((n2 & 2) != 0) {
                    name = nameAndSignature.name;
                }
                if ((n2 & 4) != 0) {
                    string2 = nameAndSignature.parameters;
                }
                if ((n2 & 8) != 0) {
                    string3 = nameAndSignature.returnType;
                }
                return nameAndSignature.copy(string, name, string2, string3);
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(classInternalName=" + this.classInternalName + ", name=" + this.name + ", parameters=" + this.parameters + ", returnType=" + this.returnType + ')';
            }

            public int hashCode() {
                int result = this.classInternalName.hashCode();
                result = result * 31 + this.name.hashCode();
                result = result * 31 + this.parameters.hashCode();
                result = result * 31 + this.returnType.hashCode();
                return result;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature)other;
                if (!Intrinsics.areEqual(this.classInternalName, nameAndSignature.classInternalName)) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.name, nameAndSignature.name)) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.parameters, nameAndSignature.parameters)) {
                    return false;
                }
                return Intrinsics.areEqual(this.returnType, nameAndSignature.returnType);
            }
        }
    }

    public static final class SpecialSignatureInfo
    extends Enum<SpecialSignatureInfo> {
        @Nullable
        private final String valueParametersSignature;
        private final boolean isObjectReplacedWithTypeParameter;
        public static final /* enum */ SpecialSignatureInfo ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("Ljava/util/Collection<+Ljava/lang/Object;>;", false);
        public static final /* enum */ SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo(null, true);
        public static final /* enum */ SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("Ljava/lang/Object;", true);
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private SpecialSignatureInfo(String valueParametersSignature, boolean isObjectReplacedWithTypeParameter) {
            this.valueParametersSignature = valueParametersSignature;
            this.isObjectReplacedWithTypeParameter = isObjectReplacedWithTypeParameter;
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[])$VALUES.clone();
        }

        public static SpecialSignatureInfo valueOf(String value) {
            return Enum.valueOf(SpecialSignatureInfo.class, value);
        }

        static {
            $VALUES = specialSignatureInfoArray = new SpecialSignatureInfo[]{SpecialSignatureInfo.ONE_COLLECTION_PARAMETER, SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC, SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    public static final class TypeSafeBarrierDescription
    extends Enum<TypeSafeBarrierDescription> {
        @Nullable
        private final Object defaultValue;
        public static final /* enum */ TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription(null);
        public static final /* enum */ TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription(-1);
        public static final /* enum */ TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription(false);
        public static final /* enum */ TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private TypeSafeBarrierDescription(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[])$VALUES.clone();
        }

        public static TypeSafeBarrierDescription valueOf(String value) {
            return Enum.valueOf(TypeSafeBarrierDescription.class, value);
        }

        public /* synthetic */ TypeSafeBarrierDescription(String $enum$name, int $enum$ordinal, Object defaultValue, DefaultConstructorMarker $constructor_marker) {
            this(defaultValue);
        }

        static {
            $VALUES = typeSafeBarrierDescriptionArray = new TypeSafeBarrierDescription[]{TypeSafeBarrierDescription.NULL, TypeSafeBarrierDescription.INDEX, TypeSafeBarrierDescription.FALSE, TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }

        static final class MAP_GET_OR_DEFAULT
        extends TypeSafeBarrierDescription {
            /*
             * WARNING - void declaration
             */
            MAP_GET_OR_DEFAULT() {
                void var1_1;
            }
        }
    }
}

