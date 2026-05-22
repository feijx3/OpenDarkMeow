/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nscopeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CollectionUtil.kt\norg/jetbrains/kotlin/utils/CollectionUtilKt\n*L\n1#1,111:1\n4344#2,2:112\n865#3,2:114\n9#4,6:116\n*S KotlinDebug\n*F\n+ 1 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n*L\n85#1:112,2\n88#1:114,2\n109#1:116,6\n*E\n"})
public final class ScopeUtilsKt {
    @Nullable
    public static final <T> Collection<T> concat(@Nullable Collection<? extends T> $this$concat, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return $this$concat;
        }
        if ($this$concat == null) {
            return collection;
        }
        if ($this$concat instanceof LinkedHashSet) {
            ((LinkedHashSet)$this$concat).addAll(collection);
            return $this$concat;
        }
        LinkedHashSet<T> result = new LinkedHashSet<T>($this$concat);
        result.addAll(collection);
        return result;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final SmartList<MemberScope> listOfNonEmptyScopes(@NotNull Iterable<? extends MemberScope> scopes) {
        void var2_2;
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Iterable<? extends MemberScope> iterable = scopes;
        Collection destination$iv = new SmartList();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            MemberScope it = (MemberScope)element$iv;
            boolean bl2 = false;
            if (!(it != null && it != MemberScope.Empty.INSTANCE)) continue;
            destination$iv.add(element$iv);
        }
        return (SmartList)var2_2;
    }
}

