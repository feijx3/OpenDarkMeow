/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000N\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a+\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0006\u001a$\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000b\"\u0004\b\u0000\u0010\u0002H\u0087\b\u00a2\u0006\u0002\u0010\f\u001a5\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002\u00a2\u0006\u0002\u0010\r\u001a$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u0002H\u0087\b\u00a2\u0006\u0002\u0010\u0011\u001a5\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0012\u001a'\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u0001H\u0002H\u0007\u00a2\u0006\u0002\u0010\u0016\u001a5\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00142\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0005\"\u0004\u0018\u0001H\u0002H\u0007\u00a2\u0006\u0002\u0010\u0006\u001aF\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0001\"\u0004\b\u0000\u0010\u00182\u001f\b\u0001\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0002\b\u001cH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0001\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u001f\b\u0001\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0002\b\u001cH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a!\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006!"}, d2={"emptySet", "", "T", "setOf", "elements", "", "([Ljava/lang/Object;)Ljava/util/Set;", "mutableSetOf", "", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "()Ljava/util/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "setOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSet", "E", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "orEmpty", "optimizeReadOnlySet", "kotlin-stdlib"}, xs="kotlin/collections/SetsKt")
class SetsKt__SetsKt
extends SetsKt__SetsJVMKt {
    @NotNull
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static final <T> Set<T> setOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.toSet(elements);
    }

    @InlineOnly
    private static final <T> Set<T> setOf() {
        return SetsKt.emptySet();
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    @NotNull
    public static final <T> Set<T> mutableSetOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set)ArraysKt.toCollection(elements, (Collection)new LinkedHashSet(MapsKt.mapCapacity(elements.length)));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet();
    }

    @NotNull
    public static final <T> HashSet<T> hashSetOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (HashSet)ArraysKt.toCollection(elements, (Collection)new HashSet(MapsKt.mapCapacity(elements.length)));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet();
    }

    @NotNull
    public static final <T> LinkedHashSet<T> linkedSetOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (LinkedHashSet)ArraysKt.toCollection(elements, (Collection)new LinkedHashSet(MapsKt.mapCapacity(elements.length)));
    }

    @SinceKotlin(version="1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@Nullable T element) {
        T t2 = element;
        return t2 != null ? SetsKt.setOf(t2) : SetsKt.emptySet();
    }

    @SinceKotlin(version="1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set)ArraysKt.filterNotNullTo(elements, (Collection)new LinkedHashSet());
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final <E> Set<E> buildSet(@BuilderInference Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set set = SetsKt.createSetBuilder();
        builderAction.invoke(set);
        return SetsKt.build(set);
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final <E> Set<E> buildSet(int capacity, @BuilderInference Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set set = SetsKt.createSetBuilder(capacity);
        builderAction.invoke(set);
        return SetsKt.build(set);
    }

    @InlineOnly
    private static final <T> Set<T> orEmpty(Set<? extends T> $this$orEmpty) {
        Set<Object> set = $this$orEmpty;
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    @NotNull
    public static final <T> Set<T> optimizeReadOnlySet(@NotNull Set<? extends T> $this$optimizeReadOnlySet) {
        Set<T> set;
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlySet, "<this>");
        switch ($this$optimizeReadOnlySet.size()) {
            case 0: {
                set = SetsKt.emptySet();
                break;
            }
            case 1: {
                set = SetsKt.setOf($this$optimizeReadOnlySet.iterator().next());
                break;
            }
            default: {
                set = $this$optimizeReadOnlySet;
            }
        }
        return set;
    }
}

