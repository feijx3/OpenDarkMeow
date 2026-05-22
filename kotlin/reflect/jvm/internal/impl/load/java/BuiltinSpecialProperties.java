/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialPropertiesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,50:1\n1563#2:51\n1634#2,3:52\n1504#2:55\n1534#2,3:56\n1537#2,3:66\n1252#2,4:71\n1563#2:78\n1634#2,3:79\n382#3,7:59\n463#3:69\n413#3:70\n153#4,3:75\n*S KotlinDebug\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n*L\n31#1:51\n31#1:52,3\n32#1:55\n32#1:56,3\n32#1:66,3\n33#1:71,4\n42#1:78\n42#1:79,3\n32#1:59,7\n33#1:69\n33#1:70\n37#1:75,3\n*E\n"})
public final class BuiltinSpecialProperties {
    @NotNull
    public static final BuiltinSpecialProperties INSTANCE;
    @NotNull
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    @NotNull
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    @NotNull
    private static final Set<FqName> GETTER_FQ_NAMES;
    @NotNull
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    @NotNull
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    @NotNull
    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    @NotNull
    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name1) {
        Intrinsics.checkNotNullParameter(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_7;
        void $this$mapTo$iv;
        void $this$mapValuesTo$iv$iv;
        Object list$iv$iv;
        Object value$iv$iv$iv;
        Object key$iv$iv;
        Map<FqName, Name> $this$groupByTo$iv$iv;
        Pair it;
        Object object;
        Iterable $this$mapTo$iv$iv;
        INSTANCE = new BuiltinSpecialProperties();
        Pair[] pairArray = new Pair[]{TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames._enum, "name"), StandardNames.NAME), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "entries"), Name.identifier("entrySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.atomicIntArray, "size"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.atomicLongArray, "size"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.atomicArray, "size"), Name.identifier("length"))};
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = MapsKt.mapOf(pairArray);
        Iterable $this$map$iv = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.entrySet();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Object destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Map.Entry entry = (Map.Entry)item$iv$iv;
            object = destination$iv$iv;
            boolean bl22 = false;
            object.add(new Pair(((FqName)it.getKey()).shortName(), it.getValue()));
        }
        Iterable $this$groupBy$iv = (List)destination$iv$iv;
        boolean $i$f$groupBy = false;
        $this$mapTo$iv$iv = $this$groupBy$iv;
        destination$iv$iv = new LinkedHashMap();
        boolean bl3 = false;
        Iterator iterator2 = $this$groupByTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it2;
            Object object2;
            Object element$iv$iv = iterator2.next();
            it = (Pair)element$iv$iv;
            boolean $i$a$-groupBy-BuiltinSpecialProperties$GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP$432 = false;
            key$iv$iv = (Name)it.getSecond();
            Map<FqName, Name> $this$getOrPut$iv$iv$iv = destination$iv$iv;
            boolean $i$f$getOrPut = false;
            value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl32 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put((FqName)key$iv$iv, (Name)((Object)answer$iv$iv$iv));
                object2 = answer$iv$iv$iv;
            } else {
                object2 = value$iv$iv$iv;
            }
            list$iv$iv = (List)object2;
            Pair $i$a$-groupBy-BuiltinSpecialProperties$GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP$432 = (Pair)element$iv$iv;
            object = list$iv$iv;
            boolean bl4 = false;
            object.add((Name)it2.getFirst());
        }
        Map<FqName, Name> $this$mapValues$iv = destination$iv$iv;
        boolean $i$f$mapValues = false;
        $this$groupByTo$iv$iv = $this$mapValues$iv;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        boolean bl4 = false;
        Object $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        list$iv$iv = $this$associateByTo$iv$iv$iv.iterator();
        while (list$iv$iv.hasNext()) {
            void it3;
            void it$iv$iv;
            Object element$iv$iv$iv = list$iv$iv.next();
            key$iv$iv = (Map.Entry)element$iv$iv$iv;
            Map<FqName, Name> map = destination$iv$iv;
            boolean bl5 = false;
            value$iv$iv$iv = (Map.Entry)element$iv$iv$iv;
            Object k2 = it$iv$iv.getKey();
            object = map;
            boolean bl6 = false;
            List list = CollectionsKt.distinct((Iterable)it3.getValue());
            object.put(k2, list);
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = destination$iv$iv;
        $this$mapValues$iv = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo232 = false;
        for (Map.Entry entry : $this$mapTo$iv.entrySet()) {
            void it4;
            $this$associateByTo$iv$iv$iv = entry;
            object = destination$iv;
            boolean bl7 = false;
            ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(((FqName)it4.getKey()).parent().toUnsafe());
            Intrinsics.checkNotNull(classId);
            object.add(classId.asSingleFqName().child((Name)it4.getValue()));
        }
        GETTER_FQ_NAMES = (Set)destination$iv;
        SPECIAL_FQ_NAMES = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        $this$map$iv = SPECIAL_FQ_NAMES;
        $i$f$map = false;
        Iterable $i$f$mapTo232 = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean bl5 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            list$iv$iv = (FqName)item$iv$iv;
            object = destination$iv$iv;
            boolean bl8 = false;
            object.add(p0.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet((List)var3_7);
    }
}

