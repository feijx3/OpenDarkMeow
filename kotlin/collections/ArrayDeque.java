/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \\*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\\B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u0005\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0004H\u0083\b\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0083\bJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u000b\u0010#\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J\r\u0010%\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010$J\u000b\u0010&\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J\r\u0010'\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010$J\u0013\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00028\u0000\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00152\u0006\u0010)\u001a\u00028\u0000\u00a2\u0006\u0002\u0010*J\u000b\u0010,\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J\r\u0010-\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010$J\u000b\u0010.\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J\r\u0010/\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010$J\u0015\u00100\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\u001d\u00100\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00102J\u001e\u00103\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u0016\u00104\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001e\u00104\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0016\u00105\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0096\u0002\u00a2\u0006\u0002\u0010\u001bJ\u001e\u00106\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u00101J\u0015\u00109\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010:J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010:J\u0015\u0010<\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010>\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0016\u0010?\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001d\u0010@\u001a\u00020\"2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0BH\u0082\bJ\b\u0010C\u001a\u00020\u0015H\u0016J'\u0010D\u001a\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0\rH\u0016\u00a2\u0006\u0002\u0010GJ\u0015\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016\u00a2\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0014J\u0018\u0010L\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0018\u0010M\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J)\u0010R\u001a\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0\rH\u0000\u00a2\u0006\u0004\bS\u0010GJ\u0017\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0000\u00a2\u0006\u0004\bS\u0010HJ\u001d\u0010T\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\bUJM\u0010V\u001a\u00020\u00152>\u0010W\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u00a2\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150XH\u0000\u00a2\u0006\u0002\b[R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006]"}, d2={"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "<init>", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "head", "elementData", "", "", "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "ensureCapacity", "", "minCapacity", "copyElements", "newCapacity", "internalGet", "internalIndex", "(I)Ljava/lang/Object;", "positiveMod", "index", "negativeMod", "incremented", "decremented", "isEmpty", "", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "copyCollectionElements", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "filterInPlace", "predicate", "Lkotlin/Function1;", "clear", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "registerModification", "testToArray", "testToArray$kotlin_stdlib", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.4")
@SourceDebugExtension(value={"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,660:1\n476#1,53:665\n476#1,53:718\n37#2:661\n36#2,3:662\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n471#1:665,53\n473#1:718,53\n46#1:661\n46#1:662,3\n*E\n"})
public final class ArrayDeque<E>
extends AbstractMutableList<E> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int head;
    @NotNull
    private Object[] elementData;
    private int size;
    @NotNull
    private static final Object[] emptyElementData = new Object[0];
    private static final int defaultMinCapacity = 10;

    @Override
    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int initialCapacity) {
        Object[] objectArray;
        if (initialCapacity == 0) {
            objectArray = emptyElementData;
        } else if (initialCapacity > 0) {
            objectArray = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = objectArray;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<E> $this$toTypedArray$iv = elements;
        boolean $i$f$toTypedArray = false;
        Collection<E> thisCollection$iv = $this$toTypedArray$iv;
        this.elementData = thisCollection$iv.toArray(new Object[0]);
        this.size = this.elementData.length;
        if (this.elementData.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        if (minCapacity <= this.elementData.length) {
            return;
        }
        if (this.elementData == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
            return;
        }
        int newCapacity = AbstractList.Companion.newCapacity$kotlin_stdlib(this.elementData.length, minCapacity);
        this.copyElements(newCapacity);
    }

    private final void copyElements(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        ArraysKt.copyInto(this.elementData, newElements, 0, this.head, this.elementData.length);
        ArraysKt.copyInto(this.elementData, newElements, this.elementData.length - this.head, 0, this.head);
        this.head = 0;
        this.elementData = newElements;
    }

    @InlineOnly
    private final E internalGet(int internalIndex) {
        return (E)this.elementData[internalIndex];
    }

    private final int positiveMod(int index) {
        return index >= this.elementData.length ? index - this.elementData.length : index;
    }

    private final int negativeMod(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    @InlineOnly
    private final int internalIndex(int index) {
        return this.positiveMod(this.head + index);
    }

    private final int incremented(int index) {
        return index == ArraysKt.getLastIndex(this.elementData) ? 0 : index + 1;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public final E first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E)this.elementData[this.head];
    }

    @Nullable
    public final E firstOrNull() {
        return (E)(this.isEmpty() ? null : this.elementData[this.head]);
    }

    public final E last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        ArrayDeque arrayDeque = this;
        return (E)this.elementData[arrayDeque.positiveMod(arrayDeque.head + CollectionsKt.getLastIndex(this))];
    }

    @Nullable
    public final E lastOrNull() {
        Object object;
        if (this.isEmpty()) {
            object = null;
        } else {
            ArrayDeque arrayDeque = this;
            object = this.elementData[arrayDeque.positiveMod(arrayDeque.head + CollectionsKt.getLastIndex(this))];
        }
        return (E)object;
    }

    public final void addFirst(E element) {
        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        this.head = this.decremented(this.head);
        this.elementData[this.head] = element;
        this.size = this.size() + 1;
    }

    public final void addLast(E element) {
        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        ArrayDeque arrayDeque = this;
        this.elementData[arrayDeque.positiveMod((int)(arrayDeque.head + this.size()))] = element;
        this.size = this.size() + 1;
    }

    public final E removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        this.registerModification();
        Object element = this.elementData[this.head];
        this.elementData[this.head] = null;
        this.head = this.incremented(this.head);
        this.size = this.size() - 1;
        return (E)element;
    }

    @Nullable
    public final E removeFirstOrNull() {
        return this.isEmpty() ? null : (E)this.removeFirst();
    }

    public final E removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        this.registerModification();
        ArrayDeque arrayDeque = this;
        int internalLastIndex = arrayDeque.positiveMod(arrayDeque.head + CollectionsKt.getLastIndex(this));
        Object element = this.elementData[internalLastIndex];
        this.elementData[internalLastIndex] = null;
        this.size = this.size() - 1;
        return (E)element;
    }

    @Nullable
    public final E removeLastOrNull() {
        return this.isEmpty() ? null : (E)this.removeLast();
    }

    @Override
    public boolean add(E element) {
        this.addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.size());
        if (index == this.size()) {
            this.addLast(element);
            return;
        }
        if (index == 0) {
            this.addFirst(element);
            return;
        }
        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        ArrayDeque arrayDeque = this;
        int internalIndex = arrayDeque.positiveMod(arrayDeque.head + index);
        if (index < this.size() + 1 >> 1) {
            Object[] objectArray;
            int decrementedInternalIndex = this.decremented(internalIndex);
            int decrementedHead = this.decremented(this.head);
            if (decrementedInternalIndex >= this.head) {
                this.elementData[decrementedHead] = this.elementData[this.head];
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, this.head, this.head + 1, decrementedInternalIndex + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, this.head - 1, this.head, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, decrementedInternalIndex + 1);
            }
            this.elementData[decrementedInternalIndex] = element;
            this.head = decrementedHead;
        } else {
            Object[] objectArray;
            ArrayDeque arrayDeque2 = this;
            int tail = arrayDeque2.positiveMod(arrayDeque2.head + this.size());
            if (internalIndex < tail) {
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, tail);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, tail);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, this.elementData.length - 1);
            }
            this.elementData[internalIndex] = element;
        }
        this.size = this.size() + 1;
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        int index;
        Iterator<E> iterator2 = elements.iterator();
        int n2 = this.elementData.length;
        for (index = internalIndex; index < n2 && iterator2.hasNext(); ++index) {
            this.elementData[index] = iterator2.next();
        }
        n2 = this.head;
        for (index = 0; index < n2 && iterator2.hasNext(); ++index) {
            this.elementData[index] = iterator2.next();
        }
        this.size = this.size() + elements.size();
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        this.registerModification();
        this.ensureCapacity(this.size() + elements.size());
        ArrayDeque arrayDeque = this;
        this.copyCollectionElements(arrayDeque.positiveMod(arrayDeque.head + this.size()), elements);
        return true;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == this.size()) {
            return this.addAll(elements);
        }
        this.registerModification();
        this.ensureCapacity(this.size() + elements.size());
        ArrayDeque arrayDeque = this;
        int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
        ArrayDeque arrayDeque2 = this;
        int internalIndex = arrayDeque2.positiveMod(arrayDeque2.head + index);
        int elementsSize = elements.size();
        if (index < this.size() + 1 >> 1) {
            Object[] objectArray;
            int shiftedHead = this.head - elementsSize;
            if (internalIndex >= this.head) {
                if (shiftedHead >= 0) {
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                } else {
                    int shiftToBack = this.elementData.length - (shiftedHead += this.elementData.length);
                    int elementsToShift = internalIndex - this.head;
                    if (shiftToBack >= elementsToShift) {
                        objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                    } else {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.head + shiftToBack);
                        objectArray = ArraysKt.copyInto(this.elementData, this.elementData, 0, this.head + shiftToBack, internalIndex);
                    }
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.elementData.length);
                if (elementsSize >= internalIndex) {
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, internalIndex);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, elementsSize);
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, 0, elementsSize, internalIndex);
                }
            }
            this.head = shiftedHead;
            this.copyCollectionElements(this.negativeMod(internalIndex - elementsSize), elements);
        } else {
            Object[] objectArray;
            int shiftedInternalIndex = internalIndex + elementsSize;
            if (internalIndex < tail) {
                if (tail + elementsSize <= this.elementData.length) {
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail);
                } else if (shiftedInternalIndex >= this.elementData.length) {
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, tail);
                } else {
                    int shiftToFront = tail + elementsSize - this.elementData.length;
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, tail - shiftToFront, tail);
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail - shiftToFront);
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, elementsSize, 0, tail);
                if (shiftedInternalIndex >= this.elementData.length) {
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, this.elementData.length);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, this.elementData.length - elementsSize, this.elementData.length);
                    objectArray = ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, this.elementData.length - elementsSize);
                }
            }
            this.copyCollectionElements(internalIndex, elements);
        }
        return true;
    }

    @Override
    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        ArrayDeque arrayDeque = this;
        return (E)this.elementData[arrayDeque.positiveMod(arrayDeque.head + index)];
    }

    @Override
    public E set(int index, E element) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        ArrayDeque arrayDeque = this;
        int internalIndex = arrayDeque.positiveMod(arrayDeque.head + index);
        Object oldElement = this.elementData[internalIndex];
        this.elementData[internalIndex] = element;
        return (E)oldElement;
    }

    @Override
    public boolean contains(Object element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public int indexOf(Object element) {
        block4: {
            int index;
            int tail;
            block3: {
                ArrayDeque arrayDeque = this;
                tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
                if (this.head >= tail) break block3;
                for (int index2 = this.head; index2 < tail; ++index2) {
                    if (!Intrinsics.areEqual(element, this.elementData[index2])) continue;
                    return index2 - this.head;
                }
                break block4;
            }
            if (this.head < tail) break block4;
            int n2 = this.elementData.length;
            for (index = this.head; index < n2; ++index) {
                if (!Intrinsics.areEqual(element, this.elementData[index])) continue;
                return index - this.head;
            }
            for (index = 0; index < tail; ++index) {
                if (!Intrinsics.areEqual(element, this.elementData[index])) continue;
                return index + this.elementData.length - this.head;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        ArrayDeque arrayDeque = this;
        int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
        if (this.head < tail) {
            int n2 = this.head;
            int index = tail - 1;
            if (n2 <= index) {
                while (true) {
                    if (Intrinsics.areEqual(element, this.elementData[index])) {
                        return index - this.head;
                    }
                    if (index != n2) {
                        --index;
                        continue;
                    }
                    break;
                }
            }
        } else if (this.head > tail) {
            int index;
            for (index = tail - 1; -1 < index; --index) {
                if (!Intrinsics.areEqual(element, this.elementData[index])) continue;
                return index + this.elementData.length - this.head;
            }
            int n3 = this.head;
            index = ArraysKt.getLastIndex(this.elementData);
            if (n3 <= index) {
                while (true) {
                    if (Intrinsics.areEqual(element, this.elementData[index])) {
                        return index - this.head;
                    }
                    if (index == n3) break;
                    --index;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object element) {
        int index = this.indexOf(element);
        if (index == -1) {
            return false;
        }
        this.removeAt(index);
        return true;
    }

    @Override
    public E removeAt(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        if (index == CollectionsKt.getLastIndex(this)) {
            return this.removeLast();
        }
        if (index == 0) {
            return this.removeFirst();
        }
        this.registerModification();
        ArrayDeque arrayDeque = this;
        int internalIndex = arrayDeque.positiveMod(arrayDeque.head + index);
        Object element = this.elementData[internalIndex];
        if (index < this.size() >> 1) {
            Object[] objectArray;
            if (internalIndex >= this.head) {
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, internalIndex);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, internalIndex);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, this.elementData.length - 1);
            }
            this.elementData[this.head] = null;
            this.head = this.incremented(this.head);
        } else {
            Object[] objectArray;
            ArrayDeque arrayDeque2 = this;
            int internalLastIndex = arrayDeque2.positiveMod(arrayDeque2.head + CollectionsKt.getLastIndex(this));
            if (internalIndex <= internalLastIndex) {
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, internalIndex, internalIndex + 1, internalLastIndex + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, internalIndex, internalIndex + 1, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                objectArray = ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, internalLastIndex + 1);
            }
            this.elementData[internalLastIndex] = null;
        }
        this.size = this.size() - 1;
        return (E)element;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> elements) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayDeque this_$iv = this;
        boolean $i$f$filterInPlace = false;
        if (this_$iv.isEmpty() || this_$iv.elementData.length == 0) {
            bl2 = false;
        } else {
            ArrayDeque arrayDeque = this_$iv;
            int tail$iv = arrayDeque.positiveMod(arrayDeque.head + this_$iv.size());
            int newTail$iv = this_$iv.head;
            boolean modified$iv = false;
            if (this_$iv.head < tail$iv) {
                for (int index$iv = this_$iv.head; index$iv < tail$iv; ++index$iv) {
                    Object element$iv;
                    Object it = element$iv = this_$iv.elementData[index$iv];
                    boolean bl3 = false;
                    if (!elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv;
                        continue;
                    }
                    modified$iv = true;
                }
                ArraysKt.fill(this_$iv.elementData, null, newTail$iv, tail$iv);
            } else {
                boolean bl4;
                Object it;
                int index$iv;
                int element$iv = this_$iv.elementData.length;
                for (index$iv = this_$iv.head; index$iv < element$iv; ++index$iv) {
                    Object element$iv2 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    it = element$iv2;
                    bl4 = false;
                    if (!elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv2;
                        continue;
                    }
                    modified$iv = true;
                }
                newTail$iv = this_$iv.positiveMod(newTail$iv);
                for (index$iv = 0; index$iv < tail$iv; ++index$iv) {
                    Object element$iv3 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    it = element$iv3;
                    bl4 = false;
                    if (!elements.contains(it)) {
                        this_$iv.elementData[newTail$iv] = element$iv3;
                        newTail$iv = this_$iv.incremented(newTail$iv);
                        continue;
                    }
                    modified$iv = true;
                }
            }
            if (modified$iv) {
                this_$iv.registerModification();
                this_$iv.size = this_$iv.negativeMod(newTail$iv - this_$iv.head);
            }
            bl2 = modified$iv;
        }
        return bl2;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> elements) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayDeque this_$iv = this;
        boolean $i$f$filterInPlace = false;
        if (this_$iv.isEmpty() || this_$iv.elementData.length == 0) {
            bl2 = false;
        } else {
            ArrayDeque arrayDeque = this_$iv;
            int tail$iv = arrayDeque.positiveMod(arrayDeque.head + this_$iv.size());
            int newTail$iv = this_$iv.head;
            boolean modified$iv = false;
            if (this_$iv.head < tail$iv) {
                for (int index$iv = this_$iv.head; index$iv < tail$iv; ++index$iv) {
                    Object element$iv;
                    Object it = element$iv = this_$iv.elementData[index$iv];
                    boolean bl3 = false;
                    if (elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv;
                        continue;
                    }
                    modified$iv = true;
                }
                ArraysKt.fill(this_$iv.elementData, null, newTail$iv, tail$iv);
            } else {
                boolean bl4;
                Object it;
                int index$iv;
                int element$iv = this_$iv.elementData.length;
                for (index$iv = this_$iv.head; index$iv < element$iv; ++index$iv) {
                    Object element$iv2 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    it = element$iv2;
                    bl4 = false;
                    if (elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv2;
                        continue;
                    }
                    modified$iv = true;
                }
                newTail$iv = this_$iv.positiveMod(newTail$iv);
                for (index$iv = 0; index$iv < tail$iv; ++index$iv) {
                    Object element$iv3 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    it = element$iv3;
                    bl4 = false;
                    if (elements.contains(it)) {
                        this_$iv.elementData[newTail$iv] = element$iv3;
                        newTail$iv = this_$iv.incremented(newTail$iv);
                        continue;
                    }
                    modified$iv = true;
                }
            }
            if (modified$iv) {
                this_$iv.registerModification();
                this_$iv.size = this_$iv.negativeMod(newTail$iv - this_$iv.head);
            }
            bl2 = modified$iv;
        }
        return bl2;
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        boolean $i$f$filterInPlace = false;
        if (this.isEmpty() || this.elementData.length == 0) {
            return false;
        }
        ArrayDeque arrayDeque = this;
        int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
        int newTail = this.head;
        boolean modified = false;
        if (this.head < tail) {
            for (int index = this.head; index < tail; ++index) {
                Object element = this.elementData[index];
                if (predicate.invoke(element).booleanValue()) {
                    this.elementData[newTail++] = element;
                    continue;
                }
                modified = true;
            }
            ArraysKt.fill(this.elementData, null, newTail, tail);
        } else {
            int index;
            int element = this.elementData.length;
            for (index = this.head; index < element; ++index) {
                Object element2 = this.elementData[index];
                this.elementData[index] = null;
                if (predicate.invoke(element2).booleanValue()) {
                    this.elementData[newTail++] = element2;
                    continue;
                }
                modified = true;
            }
            newTail = this.positiveMod(newTail);
            for (index = 0; index < tail; ++index) {
                Object element3 = this.elementData[index];
                this.elementData[index] = null;
                if (predicate.invoke(element3).booleanValue()) {
                    this.elementData[newTail] = element3;
                    newTail = this.incremented(newTail);
                    continue;
                }
                modified = true;
            }
        }
        if (modified) {
            this.registerModification();
            this.size = this.negativeMod(newTail - this.head);
        }
        return modified;
    }

    @Override
    public void clear() {
        if (!((Collection)this).isEmpty()) {
            this.registerModification();
            ArrayDeque arrayDeque = this;
            int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
            this.nullifyNonEmpty(this.head, tail);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] dest = array.length >= this.size() ? array : ArraysKt.arrayOfNulls(array, this.size());
        ArrayDeque arrayDeque = this;
        int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
        if (this.head < tail) {
            ArraysKt.copyInto$default(this.elementData, dest, 0, this.head, tail, 2, null);
        } else if (!((Collection)this).isEmpty()) {
            ArraysKt.copyInto(this.elementData, dest, 0, this.head, this.elementData.length);
            ArraysKt.copyInto(this.elementData, dest, this.elementData.length - this.head, 0, tail);
        }
        return CollectionsKt.terminateCollectionToArray(this.size(), dest);
    }

    @Override
    @NotNull
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        int length;
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.size());
        int n2 = length = toIndex - fromIndex;
        if (n2 == 0) {
            return;
        }
        if (n2 == this.size()) {
            this.clear();
            return;
        }
        if (n2 == 1) {
            this.removeAt(fromIndex);
            return;
        }
        this.registerModification();
        if (fromIndex < this.size() - toIndex) {
            this.removeRangeShiftPreceding(fromIndex, toIndex);
            int newHead = this.positiveMod(this.head + length);
            this.nullifyNonEmpty(this.head, newHead);
            this.head = newHead;
        } else {
            this.removeRangeShiftSucceeding(fromIndex, toIndex);
            ArrayDeque arrayDeque = this;
            int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
            this.nullifyNonEmpty(this.negativeMod(tail - length), tail);
        }
        this.size = this.size() - length;
    }

    private final void removeRangeShiftPreceding(int fromIndex, int toIndex) {
        int segmentLength;
        ArrayDeque arrayDeque = this;
        int n2 = fromIndex - 1;
        int copyFromIndex = arrayDeque.positiveMod(arrayDeque.head + n2);
        ArrayDeque arrayDeque2 = this;
        int n3 = toIndex - 1;
        int copyToIndex = arrayDeque2.positiveMod(arrayDeque2.head + n3);
        for (int copyCount = fromIndex; copyCount > 0; copyCount -= segmentLength) {
            int n4 = copyFromIndex + 1;
            int n5 = copyToIndex + 1;
            segmentLength = Math.min(copyCount, Math.min(n4, n5));
            ArraysKt.copyInto(this.elementData, this.elementData, copyToIndex - segmentLength + 1, copyFromIndex - segmentLength + 1, copyFromIndex + 1);
            copyFromIndex = this.negativeMod(copyFromIndex - segmentLength);
            copyToIndex = this.negativeMod(copyToIndex - segmentLength);
        }
    }

    private final void removeRangeShiftSucceeding(int fromIndex, int toIndex) {
        int segmentLength;
        ArrayDeque arrayDeque = this;
        int copyFromIndex = arrayDeque.positiveMod(arrayDeque.head + toIndex);
        ArrayDeque arrayDeque2 = this;
        int copyToIndex = arrayDeque2.positiveMod(arrayDeque2.head + fromIndex);
        for (int copyCount = this.size() - toIndex; copyCount > 0; copyCount -= segmentLength) {
            int n2 = this.elementData.length - copyFromIndex;
            int n3 = this.elementData.length - copyToIndex;
            segmentLength = Math.min(copyCount, Math.min(n2, n3));
            ArraysKt.copyInto(this.elementData, this.elementData, copyToIndex, copyFromIndex, copyFromIndex + segmentLength);
            copyFromIndex = this.positiveMod(copyFromIndex + segmentLength);
            copyToIndex = this.positiveMod(copyToIndex + segmentLength);
        }
    }

    private final void nullifyNonEmpty(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            ArraysKt.fill(this.elementData, null, internalFromIndex, internalToIndex);
        } else {
            ArraysKt.fill(this.elementData, null, internalFromIndex, this.elementData.length);
            ArraysKt.fill(this.elementData, null, 0, internalToIndex);
        }
    }

    private final void registerModification() {
        ++this.modCount;
    }

    @NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return this.toArray(array);
    }

    @NotNull
    public final Object[] testToArray$kotlin_stdlib() {
        return this.toArray();
    }

    public final void testRemoveRange$kotlin_stdlib(int fromIndex, int toIndex) {
        this.removeRange(fromIndex, toIndex);
    }

    public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        ArrayDeque arrayDeque = this;
        int tail = arrayDeque.positiveMod(arrayDeque.head + this.size());
        int head = this.isEmpty() || this.head < tail ? this.head : this.head - this.elementData.length;
        structure.invoke((Integer)head, (Object[])this.toArray());
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lkotlin/collections/ArrayDeque$Companion;", "", "<init>", "()V", "emptyElementData", "", "[Ljava/lang/Object;", "defaultMinCapacity", "", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

