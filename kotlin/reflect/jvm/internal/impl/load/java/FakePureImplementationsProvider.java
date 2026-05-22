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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFakePureImplementationsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n1299#2,4:39\n11228#3:43\n11563#3,3:44\n126#4:47\n153#4,3:48\n*S KotlinDebug\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n*L\n18#1:39,4\n36#1:43\n36#1:44,3\n32#1:47\n32#1:48,3\n*E\n"})
public final class FakePureImplementationsProvider {
    @NotNull
    public static final FakePureImplementationsProvider INSTANCE;
    @NotNull
    private static final Map<ClassId, ClassId> pureImplementationsClassIds;
    @NotNull
    private static final Map<FqName, FqName> pureImplementationsFqNames;

    private FakePureImplementationsProvider() {
    }

    @Nullable
    public final FqName getPurelyImplementedInterface(@NotNull FqName classFqName) {
        Intrinsics.checkNotNullParameter(classFqName, "classFqName");
        return pureImplementationsFqNames.get(classFqName);
    }

    /*
     * WARNING - void declaration
     */
    private final void implementedWith(ClassId $this$implementedWith, List<ClassId> implementations) {
        void $this$associateWithTo$iv;
        Iterable iterable = implementations;
        Map<ClassId, ClassId> destination$iv = pureImplementationsClassIds;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv : $this$associateWithTo$iv) {
            ClassId classId = (ClassId)element$iv;
            Object t2 = element$iv;
            Map<ClassId, ClassId> map = destination$iv;
            boolean bl2 = false;
            ClassId classId2 = $this$implementedWith;
            map.put((ClassId)t2, classId2);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final List<ClassId> fqNameListOf(String ... names) {
        void $this$mapTo$iv$iv;
        String[] $this$map$iv = names;
        boolean $i$f$map = false;
        String[] stringArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var10_10 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(ClassId.Companion.topLevel(new FqName((String)it)));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $this$mapTo$iv$iv;
        INSTANCE = new FakePureImplementationsProvider();
        pureImplementationsClassIds = new LinkedHashMap();
        String[] stringArray = new String[]{"java.util.ArrayList", "java.util.LinkedList"};
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableList(), INSTANCE.fqNameListOf(stringArray));
        stringArray = new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"};
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableSet(), INSTANCE.fqNameListOf(stringArray));
        stringArray = new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"};
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableMap(), INSTANCE.fqNameListOf(stringArray));
        stringArray = new String[]{"java.util.function.UnaryOperator"};
        INSTANCE.implementedWith(ClassId.Companion.topLevel(new FqName("java.util.function.Function")), INSTANCE.fqNameListOf(stringArray));
        stringArray = new String[]{"java.util.function.BinaryOperator"};
        INSTANCE.implementedWith(ClassId.Companion.topLevel(new FqName("java.util.function.BiFunction")), INSTANCE.fqNameListOf(stringArray));
        Map<ClassId, ClassId> $this$map$iv = pureImplementationsClassIds;
        boolean $i$f$map = false;
        Map<ClassId, ClassId> map = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry item$iv$iv;
            Map.Entry entry = item$iv$iv = iterator2.next();
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            ClassId key = (ClassId)entry.getKey();
            ClassId value = (ClassId)entry.getValue();
            collection.add(TuplesKt.to(key.asSingleFqName(), value.asSingleFqName()));
        }
        pureImplementationsFqNames = MapsKt.toMap((List)var3_3);
    }
}

