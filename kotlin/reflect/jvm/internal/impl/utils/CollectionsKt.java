/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ncollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1222#2,2:130\n1252#2,4:132\n1#3:136\n*S KotlinDebug\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n*L\n22#1:130,2\n22#1:132,4\n*E\n"})
public final class CollectionsKt {
    @NotNull
    public static final <K> Map<K, Integer> mapToIndex(@NotNull Iterable<? extends K> $this$mapToIndex) {
        Intrinsics.checkNotNullParameter($this$mapToIndex, "<this>");
        LinkedHashMap map = new LinkedHashMap();
        Iterator<K> iterator2 = $this$mapToIndex.iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            int index = n2++;
            K k2 = iterator2.next();
            ((Map)map).put(k2, index);
        }
        return map;
    }

    public static final <T> void addIfNotNull(@NotNull Collection<T> $this$addIfNotNull, @Nullable T t2) {
        Intrinsics.checkNotNullParameter($this$addIfNotNull, "<this>");
        if (t2 != null) {
            $this$addIfNotNull.add(t2);
        }
    }

    @NotNull
    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap(CollectionsKt.capacity(expectedSize));
    }

    @NotNull
    public static final <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet(CollectionsKt.capacity(expectedSize));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return new LinkedHashSet(CollectionsKt.capacity(expectedSize));
    }

    private static final int capacity(int expectedSize) {
        return expectedSize < 3 ? 3 : expectedSize + expectedSize / 3 + 1;
    }

    @NotNull
    public static final <T> List<T> compact(@NotNull ArrayList<T> $this$compact) {
        List list;
        Intrinsics.checkNotNullParameter($this$compact, "<this>");
        switch ($this$compact.size()) {
            case 0: {
                list = kotlin.collections.CollectionsKt.emptyList();
                break;
            }
            case 1: {
                list = kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((List)$this$compact));
                break;
            }
            default: {
                ArrayList<T> arrayList;
                ArrayList<T> $this$compact_u24lambda_u241 = arrayList = $this$compact;
                boolean bl2 = false;
                $this$compact_u24lambda_u241.trimToSize();
                list = arrayList;
            }
        }
        return list;
    }
}

