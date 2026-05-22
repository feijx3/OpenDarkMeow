/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilderKt;
import kotlin.collections.builders.SerializedCollection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003QRSB\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0096\u0002\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010!J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\u0015\u0010'\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u001d\u0010'\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u001e\u0010+\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\b\u0010.\u001a\u00020)H\u0016J\u0015\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0015\u00100\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u0016\u00101\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u0016\u00102\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J'\u00106\u001a\b\u0012\u0004\u0012\u0002H70\r\"\u0004\b\u0001\u001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H70\rH\u0016\u00a2\u0006\u0002\u00109J\u0015\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0016\u00a2\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010=\u001a\u00020\tH\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\tH\u0002J\u0014\u0010F\u001a\u00020\u00112\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0018\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tH\u0002J\u001d\u0010I\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010*J&\u0010J\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010C\u001a\u00020\tH\u0002J\u0015\u0010K\u001a\u00028\u00002\u0006\u0010H\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH\u0002J.\u0010O\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010P\u001a\u00020\u0011H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006T"}, d2={"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "<init>", "(I)V", "backing", "", "[Ljava/lang/Object;", "length", "isReadOnly", "", "build", "", "writeReplace", "", "size", "getSize", "()I", "isEmpty", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkIsMutable", "ensureExtraCapacity", "n", "ensureCapacityInternal", "minCapacity", "contentEquals", "insertAtInternal", "i", "addAtInternal", "addAllInternal", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Companion", "Itr", "BuilderSubList", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
public final class ListBuilder<E>
extends AbstractMutableList<E>
implements List<E>,
RandomAccess,
Serializable,
KMutableList {
    @NotNull
    private static final Companion Companion;
    @NotNull
    private E[] backing;
    private int length;
    private boolean isReadOnly;
    @NotNull
    private static final ListBuilder Empty;

    public ListBuilder(int initialCapacity) {
        this.backing = ListBuilderKt.arrayOfUninitializedElements(initialCapacity);
    }

    public /* synthetic */ ListBuilder(int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 10;
        }
        this(n2);
    }

    @NotNull
    public final List<E> build() {
        this.checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? (List)this : (List)Empty;
    }

    private final Object writeReplace() {
        if (!this.isReadOnly) {
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }
        return new SerializedCollection(this, 0);
    }

    @Override
    public int getSize() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.backing[index];
    }

    @Override
    public E set(int index, E element) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        E old = this.backing[index];
        this.backing[index] = element;
        return old;
    }

    @Override
    public int indexOf(Object element) {
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (!Intrinsics.areEqual(this.backing[i2], element)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        for (int i2 = this.length - 1; i2 >= 0; --i2) {
            if (!Intrinsics.areEqual(this.backing[i2], element)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        return this.listIterator(0);
    }

    @Override
    @NotNull
    public ListIterator<E> listIterator() {
        return this.listIterator(0);
    }

    @Override
    @NotNull
    public ListIterator<E> listIterator(int index) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override
    public boolean add(E element) {
        this.checkIsMutable();
        this.addAtInternal(this.length, element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        this.addAtInternal(index, element);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        int n2 = elements.size();
        this.addAllInternal(this.length, elements, n2);
        return n2 > 0;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        int n2 = elements.size();
        this.addAllInternal(index, elements, n2);
        return n2 > 0;
    }

    @Override
    public void clear() {
        this.checkIsMutable();
        this.removeRangeInternal(0, this.length);
    }

    @Override
    public E removeAt(int index) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.removeAtInternal(index);
    }

    @Override
    public boolean remove(Object element) {
        this.checkIsMutable();
        int i2 = this.indexOf(element);
        if (i2 >= 0) {
            this.removeAt(i2);
        }
        return i2 >= 0;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        return this.retainOrRemoveAllInternal(0, this.length, elements, false) > 0;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        return this.retainOrRemoveAllInternal(0, this.length, elements, true) > 0;
    }

    @Override
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        return new BuilderSubList<E>(this.backing, fromIndex, toIndex - fromIndex, null, this);
    }

    @Override
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < this.length) {
            T[] TArray = Arrays.copyOfRange(this.backing, 0, this.length, array.getClass());
            Intrinsics.checkNotNullExpressionValue(TArray, "copyOfRange(...)");
            return TArray;
        }
        ArraysKt.copyInto(this.backing, array, 0, 0, this.length);
        return CollectionsKt.terminateCollectionToArray(this.length, array);
    }

    @Override
    @NotNull
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other == this || other instanceof List && this.contentEquals((List)other);
    }

    @Override
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override
    @NotNull
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, this);
    }

    private final void registerModification() {
        ++this.modCount;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n2) {
        this.ensureCapacityInternal(this.length + n2);
    }

    private final void ensureCapacityInternal(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > this.backing.length) {
            int newSize = AbstractList.Companion.newCapacity$kotlin_stdlib(this.backing.length, minCapacity);
            this.backing = ListBuilderKt.copyOfUninitializedElements(this.backing, newSize);
        }
    }

    private final boolean contentEquals(List<?> other) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, other);
    }

    private final void insertAtInternal(int i2, int n2) {
        this.ensureExtraCapacity(n2);
        E[] EArray = this.backing;
        E[] EArray2 = this.backing;
        int n3 = this.length;
        int n4 = i2 + n2;
        ArraysKt.copyInto(EArray, EArray2, n4, i2, n3);
        this.length += n2;
    }

    private final void addAtInternal(int i2, E element) {
        this.registerModification();
        this.insertAtInternal(i2, 1);
        this.backing[i2] = element;
    }

    private final void addAllInternal(int i2, Collection<? extends E> elements, int n2) {
        this.registerModification();
        this.insertAtInternal(i2, n2);
        Iterator<E> it = elements.iterator();
        for (int j2 = 0; j2 < n2; ++j2) {
            this.backing[i2 + j2] = it.next();
        }
    }

    private final E removeAtInternal(int i2) {
        this.registerModification();
        E old = this.backing[i2];
        E[] EArray = this.backing;
        E[] EArray2 = this.backing;
        int n2 = i2 + 1;
        int n3 = this.length;
        ArraysKt.copyInto(EArray, EArray2, i2, n2, n3);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        int n4 = this.length;
        this.length = n4 + -1;
        return old;
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            this.registerModification();
        }
        E[] EArray = this.backing;
        E[] EArray2 = this.backing;
        int n2 = rangeOffset + rangeLength;
        int n3 = this.length;
        ArraysKt.copyInto(EArray, EArray2, rangeOffset, n2, n3);
        ListBuilderKt.resetRange(this.backing, this.length - rangeLength, this.length);
        this.length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int i2 = 0;
        int j2 = 0;
        while (i2 < rangeLength) {
            if (elements.contains(this.backing[rangeOffset + i2]) == retain) {
                this.backing[rangeOffset + j2++] = this.backing[rangeOffset + i2++];
                continue;
            }
            ++i2;
        }
        int removed = rangeLength - j2;
        E[] EArray = this.backing;
        E[] EArray2 = this.backing;
        int n2 = rangeOffset + rangeLength;
        int n3 = this.length;
        int n4 = rangeOffset + j2;
        ArraysKt.copyInto(EArray, EArray2, n4, n2, n3);
        ListBuilderKt.resetRange(this.backing, this.length - removed, this.length);
        if (removed > 0) {
            this.registerModification();
        }
        this.length -= removed;
        return removed;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    static {
        ListBuilder listBuilder;
        Companion = new Companion(null);
        ListBuilder it = listBuilder = new ListBuilder(0);
        boolean bl2 = false;
        it.isReadOnly = true;
        Empty = listBuilder;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001TBC\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010%J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010(H\u0096\u0002J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010*H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010*2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0015\u0010+\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010,J\u001d\u0010+\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0016J\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\u0015\u00102\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010 J\u0015\u00103\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010,J\u0016\u00104\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0016J\u0016\u00105\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0016J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0016J'\u00109\u001a\b\u0012\u0004\u0012\u0002H:0\t\"\u0004\b\u0002\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0\tH\u0016\u00a2\u0006\u0002\u0010<J\u0015\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tH\u0016\u00a2\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010@\u001a\u00020\u000bH\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0016H\u0002J\b\u0010D\u001a\u00020\u0016H\u0002J\b\u0010E\u001a\u00020\u0016H\u0002J\u0014\u0010H\u001a\u00020\u001d2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030IH\u0002J\u001d\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0002\u00a2\u0006\u0002\u0010-J&\u0010L\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010M\u001a\u00020\u000bH\u0002J\u0015\u0010N\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010 J\u0018\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000bH\u0002J.\u0010R\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010S\u001a\u00020\u001dH\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010F\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006U"}, d2={"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "size", "getSize", "()I", "isEmpty", "", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkForComodification", "checkIsMutable", "isReadOnly", "()Z", "contentEquals", "", "addAtInternal", "i", "addAllInternal", "n", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Itr", "kotlin-stdlib"})
    public static final class BuilderSubList<E>
    extends AbstractMutableList<E>
    implements List<E>,
    RandomAccess,
    Serializable,
    KMutableList {
        @NotNull
        private E[] backing;
        private final int offset;
        private int length;
        @Nullable
        private final BuilderSubList<E> parent;
        @NotNull
        private final ListBuilder<E> root;

        public BuilderSubList(@NotNull E[] backing, int offset, int length, @Nullable BuilderSubList<E> parent, @NotNull ListBuilder<E> root) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            Intrinsics.checkNotNullParameter(root, "root");
            this.backing = backing;
            this.offset = offset;
            this.length = length;
            this.parent = parent;
            this.root = root;
            this.modCount = ((ListBuilder)this.root).modCount;
        }

        private final Object writeReplace() {
            if (!this.isReadOnly()) {
                throw new NotSerializableException("The list cannot be serialized while it is being built.");
            }
            return new SerializedCollection(this, 0);
        }

        private final void readObject(ObjectInputStream input) {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        @Override
        public int getSize() {
            this.checkForComodification();
            return this.length;
        }

        @Override
        public boolean isEmpty() {
            this.checkForComodification();
            return this.length == 0;
        }

        @Override
        public E get(int index) {
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return this.backing[this.offset + index];
        }

        @Override
        public E set(int index, E element) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            E old = this.backing[this.offset + index];
            this.backing[this.offset + index] = element;
            return old;
        }

        @Override
        public int indexOf(Object element) {
            this.checkForComodification();
            for (int i2 = 0; i2 < this.length; ++i2) {
                if (!Intrinsics.areEqual(this.backing[this.offset + i2], element)) continue;
                return i2;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object element) {
            this.checkForComodification();
            for (int i2 = this.length - 1; i2 >= 0; --i2) {
                if (!Intrinsics.areEqual(this.backing[this.offset + i2], element)) continue;
                return i2;
            }
            return -1;
        }

        @Override
        @NotNull
        public Iterator<E> iterator() {
            return this.listIterator(0);
        }

        @Override
        @NotNull
        public ListIterator<E> listIterator() {
            return this.listIterator(0);
        }

        @Override
        @NotNull
        public ListIterator<E> listIterator(int index) {
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            return new Itr(this, index);
        }

        @Override
        public boolean add(E element) {
            this.checkIsMutable();
            this.checkForComodification();
            this.addAtInternal(this.offset + this.length, element);
            return true;
        }

        @Override
        public void add(int index, E element) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            this.addAtInternal(this.offset + index, element);
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            int n2 = elements.size();
            this.addAllInternal(this.offset + this.length, elements, n2);
            return n2 > 0;
        }

        @Override
        public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            int n2 = elements.size();
            this.addAllInternal(this.offset + index, elements, n2);
            return n2 > 0;
        }

        @Override
        public void clear() {
            this.checkIsMutable();
            this.checkForComodification();
            this.removeRangeInternal(this.offset, this.length);
        }

        @Override
        public E removeAt(int index) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return this.removeAtInternal(this.offset + index);
        }

        @Override
        public boolean remove(Object element) {
            this.checkIsMutable();
            this.checkForComodification();
            int i2 = this.indexOf(element);
            if (i2 >= 0) {
                this.removeAt(i2);
            }
            return i2 >= 0;
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            return this.retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            return this.retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
        }

        @Override
        @NotNull
        public List<E> subList(int fromIndex, int toIndex) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
            return new BuilderSubList<E>(this.backing, this.offset + fromIndex, toIndex - fromIndex, this, this.root);
        }

        @Override
        @NotNull
        public <T> T[] toArray(@NotNull T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.checkForComodification();
            if (array.length < this.length) {
                T[] TArray = Arrays.copyOfRange(this.backing, this.offset, this.offset + this.length, array.getClass());
                Intrinsics.checkNotNullExpressionValue(TArray, "copyOfRange(...)");
                return TArray;
            }
            ArraysKt.copyInto(this.backing, array, 0, this.offset, this.offset + this.length);
            return CollectionsKt.terminateCollectionToArray(this.length, array);
        }

        @Override
        @NotNull
        public Object[] toArray() {
            this.checkForComodification();
            return ArraysKt.copyOfRange(this.backing, this.offset, this.offset + this.length);
        }

        @Override
        public boolean equals(@Nullable Object other) {
            this.checkForComodification();
            return other == this || other instanceof List && this.contentEquals((List)other);
        }

        @Override
        public int hashCode() {
            this.checkForComodification();
            return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override
        @NotNull
        public String toString() {
            this.checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        private final void registerModification() {
            ++this.modCount;
        }

        private final void checkForComodification() {
            if (((ListBuilder)this.root).modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void checkIsMutable() {
            if (this.isReadOnly()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean isReadOnly() {
            return ((ListBuilder)this.root).isReadOnly;
        }

        private final boolean contentEquals(List<?> other) {
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, other);
        }

        private final void addAtInternal(int i2, E element) {
            this.registerModification();
            if (this.parent != null) {
                super.addAtInternal(i2, element);
            } else {
                ((ListBuilder)this.root).addAtInternal(i2, element);
            }
            this.backing = ((ListBuilder)this.root).backing;
            int n2 = this.length;
            this.length = n2 + 1;
        }

        private final void addAllInternal(int i2, Collection<? extends E> elements, int n2) {
            this.registerModification();
            if (this.parent != null) {
                super.addAllInternal(i2, elements, n2);
            } else {
                ((ListBuilder)this.root).addAllInternal(i2, elements, n2);
            }
            this.backing = ((ListBuilder)this.root).backing;
            this.length += n2;
        }

        private final E removeAtInternal(int i2) {
            this.registerModification();
            Object old = this.parent != null ? super.removeAtInternal(i2) : ((ListBuilder)this.root).removeAtInternal(i2);
            int n2 = this.length;
            this.length = n2 + -1;
            return old;
        }

        private final void removeRangeInternal(int rangeOffset, int rangeLength) {
            if (rangeLength > 0) {
                this.registerModification();
            }
            if (this.parent != null) {
                super.removeRangeInternal(rangeOffset, rangeLength);
            } else {
                ((ListBuilder)this.root).removeRangeInternal(rangeOffset, rangeLength);
            }
            this.length -= rangeLength;
        }

        private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
            int removed;
            int n2 = removed = this.parent != null ? super.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain) : ((ListBuilder)this.root).retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            if (removed > 0) {
                this.registerModification();
            }
            this.length -= removed;
            return removed;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\fH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"})
        @SourceDebugExtension(value={"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$BuilderSubList$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
        private static final class Itr<E>
        implements ListIterator<E>,
        KMutableListIterator {
            @NotNull
            private final BuilderSubList<E> list;
            private int index;
            private int lastIndex;
            private int expectedModCount;

            public Itr(@NotNull BuilderSubList<E> list, int index) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.list = list;
                this.index = index;
                this.lastIndex = -1;
                this.expectedModCount = ((BuilderSubList)this.list).modCount;
            }

            @Override
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override
            public boolean hasNext() {
                return this.index < ((BuilderSubList)this.list).length;
            }

            @Override
            public int previousIndex() {
                return this.index - 1;
            }

            @Override
            public int nextIndex() {
                return this.index;
            }

            @Override
            public E previous() {
                this.checkForComodification();
                if (this.index <= 0) {
                    throw new NoSuchElementException();
                }
                this.index += -1;
                this.lastIndex = this.index;
                return (E)((BuilderSubList)this.list).backing[((BuilderSubList)this.list).offset + this.lastIndex];
            }

            @Override
            public E next() {
                this.checkForComodification();
                if (this.index >= ((BuilderSubList)this.list).length) {
                    throw new NoSuchElementException();
                }
                int n2 = this.index;
                this.index = n2 + 1;
                this.lastIndex = n2;
                return (E)((BuilderSubList)this.list).backing[((BuilderSubList)this.list).offset + this.lastIndex];
            }

            @Override
            public void set(E element) {
                this.checkForComodification();
                if (!(this.lastIndex != -1)) {
                    boolean bl2 = false;
                    String string = "Call next() or previous() before replacing element from the iterator.";
                    throw new IllegalStateException(string.toString());
                }
                this.list.set(this.lastIndex, element);
            }

            @Override
            public void add(E element) {
                this.checkForComodification();
                int n2 = this.index;
                this.index = n2 + 1;
                this.list.add(n2, element);
                this.lastIndex = -1;
                this.expectedModCount = ((BuilderSubList)this.list).modCount;
            }

            @Override
            public void remove() {
                this.checkForComodification();
                if (!(this.lastIndex != -1)) {
                    boolean bl2 = false;
                    String string = "Call next() or previous() before removing element from the iterator.";
                    throw new IllegalStateException(string.toString());
                }
                this.list.removeAt(this.lastIndex);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((BuilderSubList)this.list).modCount;
            }

            private final void checkForComodification() {
                if (((BuilderSubList)this.list).root.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lkotlin/collections/builders/ListBuilder$Companion;", "", "<init>", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\fH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"})
    @SourceDebugExtension(value={"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
    private static final class Itr<E>
    implements ListIterator<E>,
    KMutableListIterator {
        @NotNull
        private final ListBuilder<E> list;
        private int index;
        private int lastIndex;
        private int expectedModCount;

        public Itr(@NotNull ListBuilder<E> list, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = index;
            this.lastIndex = -1;
            this.expectedModCount = ((ListBuilder)this.list).modCount;
        }

        @Override
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < ((ListBuilder)this.list).length;
        }

        @Override
        public int previousIndex() {
            return this.index - 1;
        }

        @Override
        public int nextIndex() {
            return this.index;
        }

        @Override
        public E previous() {
            this.checkForComodification();
            if (this.index <= 0) {
                throw new NoSuchElementException();
            }
            this.index += -1;
            this.lastIndex = this.index;
            return (E)((ListBuilder)this.list).backing[this.lastIndex];
        }

        @Override
        public E next() {
            this.checkForComodification();
            if (this.index >= ((ListBuilder)this.list).length) {
                throw new NoSuchElementException();
            }
            int n2 = this.index;
            this.index = n2 + 1;
            this.lastIndex = n2;
            return (E)((ListBuilder)this.list).backing[this.lastIndex];
        }

        @Override
        public void set(E element) {
            this.checkForComodification();
            if (!(this.lastIndex != -1)) {
                boolean bl2 = false;
                String string = "Call next() or previous() before replacing element from the iterator.";
                throw new IllegalStateException(string.toString());
            }
            this.list.set(this.lastIndex, element);
        }

        @Override
        public void add(E element) {
            this.checkForComodification();
            int n2 = this.index;
            this.index = n2 + 1;
            this.list.add(n2, element);
            this.lastIndex = -1;
            this.expectedModCount = ((ListBuilder)this.list).modCount;
        }

        @Override
        public void remove() {
            this.checkForComodification();
            if (!(this.lastIndex != -1)) {
                boolean bl2 = false;
                String string = "Call next() or previous() before removing element from the iterator.";
                throw new IllegalStateException(string.toString());
            }
            this.list.removeAt(this.lastIndex);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ((ListBuilder)this.list).modCount;
        }

        private final void checkForComodification() {
            if (((ListBuilder)this.list).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

