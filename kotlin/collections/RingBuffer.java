/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\rJ\u0016\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0096\u0002\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0002J'\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0001\u0010\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0014\u00a2\u0006\u0002\u0010\u001dJ\u0015\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0014\u00a2\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010 \u001a\u00020\tJ\u0013\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\tJ\u0015\u0010'\u001a\u00020\t*\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0082\bR\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006("}, d2={"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "buffer", "", "", "filledSize", "", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "[Ljava/lang/Object;", "startIndex", "value", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "toArray", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "expanded", "maxCapacity", "add", "", "element", "(Ljava/lang/Object;)V", "removeFirst", "n", "forward", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n204#1:208\n204#1:209\n204#1:210\n1#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:208\n175#1:209\n188#1:210\n*E\n"})
final class RingBuffer<T>
extends AbstractList<T>
implements RandomAccess {
    @NotNull
    private final Object[] buffer;
    private final int capacity;
    private int startIndex;
    private int size;

    public RingBuffer(@NotNull Object[] buffer, int filledSize) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (!(filledSize >= 0)) {
            boolean $i$a$-require-RingBuffer$32 = false;
            String $i$a$-require-RingBuffer$32 = "ring buffer filled size should not be negative but it is " + filledSize;
            throw new IllegalArgumentException($i$a$-require-RingBuffer$32.toString());
        }
        if (!(filledSize <= this.buffer.length)) {
            boolean bl2 = false;
            String string = "ring buffer filled size: " + filledSize + " cannot be larger than the buffer size: " + this.buffer.length;
            throw new IllegalArgumentException(string.toString());
        }
        this.capacity = this.buffer.length;
        this.size = filledSize;
    }

    public RingBuffer(int capacity) {
        this(new Object[capacity], 0);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public T get(int index) {
        void this_$iv;
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        RingBuffer ringBuffer = this;
        int $this$forward$iv = this.startIndex;
        boolean $i$f$forward = false;
        return (T)this.buffer[($this$forward$iv + index) % ((RingBuffer)this_$iv).capacity];
    }

    public final boolean isFull() {
        return this.size() == this.capacity;
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this){
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;
            {
                this.this$0 = $receiver;
                this.count = $receiver.size();
                this.index = RingBuffer.access$getStartIndex$p($receiver);
            }

            /*
             * WARNING - void declaration
             */
            protected void computeNext() {
                if (this.count == 0) {
                    this.done();
                } else {
                    void this_$iv;
                    void $this$forward$iv;
                    this.setNext(RingBuffer.access$getBuffer$p(this.this$0)[this.index]);
                    RingBuffer<T> ringBuffer = this.this$0;
                    int n2 = this.index;
                    boolean n$iv = true;
                    boolean $i$f$forward = false;
                    this.index = ($this$forward$iv + n$iv) % RingBuffer.access$getCapacity$p((RingBuffer)this_$iv);
                    int n3 = this.count;
                    this.count = n3 + -1;
                }
            }
        };
    }

    @Override
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        int idx;
        T[] TArray;
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < this.size()) {
            T[] TArray2 = Arrays.copyOf(array, this.size());
            TArray = TArray2;
            Intrinsics.checkNotNullExpressionValue(TArray2, "copyOf(...)");
        } else {
            TArray = array;
        }
        T[] result = TArray;
        int size = this.size();
        int widx = 0;
        for (idx = this.startIndex; widx < size && idx < this.capacity; ++widx, ++idx) {
            result[widx] = this.buffer[idx];
        }
        idx = 0;
        while (widx < size) {
            result[widx] = this.buffer[idx];
            ++widx;
            ++idx;
        }
        return CollectionsKt.terminateCollectionToArray(size, result);
    }

    @Override
    @NotNull
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @NotNull
    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] objectArray;
        int newCapacity = RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            Object[] objectArray2 = Arrays.copyOf(this.buffer, newCapacity);
            objectArray = objectArray2;
            Intrinsics.checkNotNullExpressionValue(objectArray2, "copyOf(...)");
        } else {
            objectArray = this.toArray(new Object[newCapacity]);
        }
        Object[] newBuffer = objectArray;
        return new RingBuffer<T>(newBuffer, this.size());
    }

    public final void add(T element) {
        if (this.isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        RingBuffer ringBuffer = this;
        int n2 = this.startIndex;
        int n$iv = this.size();
        boolean $i$f$forward = false;
        this.buffer[($this$forward$iv + n$iv) % ((RingBuffer)this_$iv).capacity] = element;
        int n3 = this.size();
        this.size = n3 + 1;
    }

    /*
     * WARNING - void declaration
     */
    public final void removeFirst(int n2) {
        if (!(n2 >= 0)) {
            boolean $i$a$-require-RingBuffer$removeFirst$32 = false;
            String $i$a$-require-RingBuffer$removeFirst$32 = "n shouldn't be negative but it is " + n2;
            throw new IllegalArgumentException($i$a$-require-RingBuffer$removeFirst$32.toString());
        }
        if (!(n2 <= this.size())) {
            boolean $i$a$-require-RingBuffer$removeFirst$42 = false;
            String $i$a$-require-RingBuffer$removeFirst$42 = "n shouldn't be greater than the buffer size: n = " + n2 + ", size = " + this.size();
            throw new IllegalArgumentException($i$a$-require-RingBuffer$removeFirst$42.toString());
        }
        if (n2 > 0) {
            void this_$iv;
            int start = this.startIndex;
            RingBuffer ringBuffer = this;
            int $this$forward$iv = start;
            boolean $i$f$forward = false;
            int end = ($this$forward$iv + n2) % ((RingBuffer)this_$iv).capacity;
            if (start > end) {
                ArraysKt.fill(this.buffer, null, start, this.capacity);
                ArraysKt.fill(this.buffer, null, 0, end);
            } else {
                ArraysKt.fill(this.buffer, null, start, end);
            }
            this.startIndex = end;
            this.size = this.size() - n2;
        }
    }

    private final int forward(int $this$forward, int n2) {
        boolean $i$f$forward = false;
        return ($this$forward + n2) % this.capacity;
    }

    public static final /* synthetic */ int access$getStartIndex$p(RingBuffer $this) {
        return $this.startIndex;
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(RingBuffer $this) {
        return $this.buffer;
    }
}

