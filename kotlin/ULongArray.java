/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExperimentalUnsignedTypes
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u00d6\u0003J\t\u0010*\u001a\u00020\bH\u00d6\u0001J\t\u0010+\u001a\u00020,H\u00d6\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004\u00a8\u0006."}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "storage", "", "constructor-impl", "([J)[J", "size", "", "(I)[J", "getStorage$annotations", "()V", "get", "index", "get-s-VKNKU", "([JI)J", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "getSize-impl", "([J)I", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([J)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
@ExperimentalUnsignedTypes
@SourceDebugExtension(value={"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1740#2,3:83\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n58#1:83,3\n*E\n"})
public final class ULongArray
implements Collection<ULong>,
KMappedMarker {
    @NotNull
    private final long[] storage;

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    @NotNull
    public static long[] constructor-impl(int size) {
        return ULongArray.constructor-impl(new long[size]);
    }

    public static final long get-s-VKNKU(long[] arg0, int index) {
        return ULong.constructor-impl(arg0[index]);
    }

    public static final void set-k8EXiF4(long[] arg0, int index, long value) {
        arg0[index] = value;
    }

    public static int getSize-impl(long[] arg0) {
        return arg0.length;
    }

    public int getSize() {
        return ULongArray.getSize-impl(this.storage);
    }

    @NotNull
    public static java.util.Iterator<ULong> iterator-impl(long[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    @NotNull
    public java.util.Iterator<ULong> iterator() {
        return ULongArray.iterator-impl(this.storage);
    }

    public static boolean contains-VKZWuLQ(long[] arg0, long element) {
        return ArraysKt.contains(arg0, element);
    }

    public boolean contains-VKZWuLQ(long element) {
        return ULongArray.contains-VKZWuLQ(this.storage, element);
    }

    public static boolean containsAll-impl(long[] arg0, @NotNull Collection<ULong> elements) {
        boolean bl2;
        block3: {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterable $this$all$iv = elements;
            boolean $i$f$all = false;
            if (((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                java.util.Iterator iterator2 = $this$all$iv.iterator();
                while (iterator2.hasNext()) {
                    Object element$iv;
                    Object it = element$iv = iterator2.next();
                    boolean bl3 = false;
                    if (it instanceof ULong && ArraysKt.contains(arg0, ((ULong)it).unbox-impl())) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ULongArray.containsAll-impl(this.storage, elements);
    }

    public static boolean isEmpty-impl(long[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return ULongArray.isEmpty-impl(this.storage);
    }

    public static String toString-impl(long[] arg0) {
        return "ULongArray(storage=" + Arrays.toString(arg0) + ')';
    }

    public String toString() {
        return ULongArray.toString-impl(this.storage);
    }

    public static int hashCode-impl(long[] arg0) {
        return Arrays.hashCode(arg0);
    }

    @Override
    public int hashCode() {
        return ULongArray.hashCode-impl(this.storage);
    }

    public static boolean equals-impl(long[] arg0, Object other) {
        if (!(other instanceof ULongArray)) {
            return false;
        }
        return Intrinsics.areEqual(arg0, ((ULongArray)other).unbox-impl());
    }

    @Override
    public boolean equals(Object other) {
        return ULongArray.equals-impl(this.storage, other);
    }

    public boolean add-VKZWuLQ(long element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends ULong> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<?> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<?> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] storage) {
        this.storage = storage;
    }

    @PublishedApi
    @NotNull
    public static long[] constructor-impl(@NotNull long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static final /* synthetic */ ULongArray box-impl(long[] v2) {
        return new ULongArray(v2);
    }

    public final /* synthetic */ long[] unbox-impl() {
        return this.storage;
    }

    public static final boolean equals-impl0(long[] p1, long[] p2) {
        return Intrinsics.areEqual(p1, p2);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "<init>", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"})
    private static final class Iterator
    implements java.util.Iterator<ULong>,
    KMappedMarker {
        @NotNull
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public long next-s-VKNKU() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            int n2 = this.index;
            this.index = n2 + 1;
            return ULong.constructor-impl(this.array[n2]);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}

