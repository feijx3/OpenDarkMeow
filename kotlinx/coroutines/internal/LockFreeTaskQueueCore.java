/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002-.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0006J\u0013\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0019J1\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002J,\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\f2\u0006\u0010%\u001a\u00020#H\u0002J \u0010&\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\f2\u0006\u0010%\u001a\u00020#H\u0002J&\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0001\u0010)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+J\u0006\u0010,\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010X\u0082\u0004R\u0011\u0010\u0011\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006/"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "<init>", "(IZ)V", "mask", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "size", "getSize", "()I", "close", "addLast", "element", "(Ljava/lang/Object;)I", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "next", "markFrozen", "", "allocateOrGetNextCopy", "state", "allocateNextCopy", "map", "", "R", "transform", "Lkotlin/Function1;", "isClosed", "Placeholder", "Companion", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,304:1\n295#2,3:305\n295#2,3:308\n295#2,3:311\n295#2,3:314\n295#2,3:317\n295#2,3:321\n295#2,3:324\n1#3:320\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n87#1:305,3\n88#1:308,3\n103#1:311,3\n163#1:314,3\n196#1:317,3\n227#1:321,3\n243#1:324,3\n*E\n"})
public final class LockFreeTaskQueueCore<E> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int capacity;
    private final boolean singleConsumer;
    private final int mask;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final /* synthetic */ AtomicReferenceArray array;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater _state$volatile$FU;
    public static final int INITIAL_CAPACITY = 8;
    public static final int CAPACITY_BITS = 30;
    public static final int MAX_CAPACITY_MASK = 0x3FFFFFFF;
    public static final int HEAD_SHIFT = 0;
    public static final long HEAD_MASK = 0x3FFFFFFFL;
    public static final int TAIL_SHIFT = 30;
    public static final long TAIL_MASK = 0xFFFFFFFC0000000L;
    public static final int FROZEN_SHIFT = 60;
    public static final long FROZEN_MASK = 0x1000000000000000L;
    public static final int CLOSED_SHIFT = 61;
    public static final long CLOSED_MASK = 0x2000000000000000L;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    @JvmField
    @NotNull
    public static final Symbol REMOVE_FROZEN;
    public static final int ADD_SUCCESS = 0;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_CLOSED = 2;

    public LockFreeTaskQueueCore(int capacity, boolean singleConsumer) {
        this.capacity = capacity;
        this.singleConsumer = singleConsumer;
        this.mask = this.capacity - 1;
        this.array = new AtomicReferenceArray(this.capacity);
        if (!(this.mask <= 0x3FFFFFFF)) {
            throw new IllegalStateException("Check failed.");
        }
        if (!((this.capacity & this.mask) == 0)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final /* synthetic */ Object get_next$volatile() {
        return this._next$volatile;
    }

    private final /* synthetic */ void set_next$volatile(Object value) {
        this._next$volatile = value;
    }

    private final /* synthetic */ long get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(long value) {
        this._state$volatile = value;
    }

    private final /* synthetic */ AtomicReferenceArray getArray() {
        return this.array;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isEmpty() {
        void tail;
        int tail$iv;
        Companion companion = Companion;
        long $this$withState$iv = LockFreeTaskQueueCore._state$volatile$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl2 = false;
        return head == tail;
    }

    /*
     * WARNING - void declaration
     */
    public final int getSize() {
        void tail;
        int tail$iv;
        Companion companion = Companion;
        long $this$withState$iv = LockFreeTaskQueueCore._state$volatile$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl2 = false;
        return tail - head & 0x3FFFFFFF;
    }

    public final boolean close() {
        long state;
        long l2;
        long l3;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            state = l3 = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if ((state & 0x2000000000000000L) != 0L) {
                return true;
            }
            if ((state & 0x1000000000000000L) == 0L) continue;
            return false;
        } while (!handler$atomicfu$iv.compareAndSet(this, l3, l2 = state | 0x2000000000000000L));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public final int addLast(@NotNull E element) {
        void tail;
        int mask;
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = LockFreeTaskQueueCore._state$volatile$FU;
        while (true) {
            int tail$iv;
            long state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if ((state & 0x3000000000000000L) != 0L) {
                return Companion.addFailReason(state);
            }
            Companion companion = Companion;
            long $this$withState$iv = state;
            boolean $i$f$withState = false;
            int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
            int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
            int head = head$iv;
            boolean bl3 = false;
            mask = this.mask;
            if ((tail + 2 & mask) == (head & mask)) {
                return 1;
            }
            if (!this.singleConsumer && this.getArray().get(tail & mask) != null) {
                if (this.capacity >= 1024 && (tail - head & 0x3FFFFFFF) <= this.capacity >> 1) continue;
                return 1;
            }
            int newTail = tail + true & 0x3FFFFFFF;
            if (LockFreeTaskQueueCore._state$volatile$FU.compareAndSet(this, state, Companion.updateTail(state, newTail))) break;
        }
        this.getArray().set(tail & mask, element);
        LockFreeTaskQueueCore<E> cur = this;
        while ((LockFreeTaskQueueCore._state$volatile$FU.get(cur) & 0x1000000000000000L) != 0L && super.fillPlaceholder((int)tail, element) != null) {
        }
        return 0;
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        Object old = this.getArray().get(index & this.mask);
        if (old instanceof Placeholder && ((Placeholder)old).index == index) {
            this.getArray().set(index & this.mask, element);
            return this;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object removeFirstOrNull() {
        var1_1 = this;
        handler$atomicfu$iv = LockFreeTaskQueueCore.get_state$volatile$FU();
        do lbl-1000:
        // 3 sources

        {
            block5: {
                state = handler$atomicfu$iv.get(this);
                $i$a$-loop$atomicfu$ATOMIC_FIELD_UPDATER$Long-LockFreeTaskQueueCore$removeFirstOrNull$1 = false;
                if ((state & 0x1000000000000000L) != 0L) {
                    return LockFreeTaskQueueCore.REMOVE_FROZEN;
                }
                var6_5 = LockFreeTaskQueueCore.Companion;
                $this$withState$iv = state;
                $i$f$withState = false;
                head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
                var12_10 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
                head = head$iv;
                $i$a$-withState-LockFreeTaskQueueCore$removeFirstOrNull$1$1 = false;
                if ((tail & this.mask) == (head & this.mask)) {
                    return null;
                }
                element = this.getArray().get(head & this.mask);
                if (element != null) break block5;
                if (!this.singleConsumer) ** GOTO lbl-1000
                return null;
            }
            if (element instanceof Placeholder) {
                return null;
            }
            newHead = head + 1 & 0x3FFFFFFF;
            if (!LockFreeTaskQueueCore.get_state$volatile$FU().compareAndSet(this, state, LockFreeTaskQueueCore.Companion.updateHead(state, newHead))) continue;
            this.getArray().set(head & this.mask, null);
            return element;
        } while (!this.singleConsumer);
        cur = this;
        while (true) {
            if (cur.removeSlowPath(head, newHead) != null) continue;
            return element;
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        int head;
        long state;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            Companion companion = Companion;
            long $this$withState$iv = state;
            boolean $i$f$withState = false;
            int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
            int tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
            head = head$iv;
            boolean bl3 = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl4 = false;
                if (!(head == oldHead)) {
                    throw new AssertionError();
                }
            }
            if ((state & 0x1000000000000000L) == 0L) continue;
            return this.next();
        } while (!LockFreeTaskQueueCore._state$volatile$FU.compareAndSet(this, state, Companion.updateHead(state, newHead)));
        this.getArray().set(head & this.mask, null);
        return null;
    }

    @NotNull
    public final LockFreeTaskQueueCore<E> next() {
        return this.allocateOrGetNextCopy(this.markFrozen());
    }

    private final long markFrozen() {
        long state;
        long l2;
        long l3;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            state = l3 = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if ((state & 0x1000000000000000L) == 0L) continue;
            return state;
        } while (!handler$atomicfu$iv.compareAndSet(this, l3, l2 = state | 0x1000000000000000L));
        return l2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = LockFreeTaskQueueCore._next$volatile$FU;
        while (true) {
            LockFreeTaskQueueCore next = (LockFreeTaskQueueCore)handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = next;
            if (lockFreeTaskQueueCore2 != null) {
                return lockFreeTaskQueueCore2;
            }
            LockFreeTaskQueueCore._next$volatile$FU.compareAndSet(this, null, this.allocateNextCopy(state));
        }
    }

    /*
     * WARNING - void declaration
     */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        void tail;
        int tail$iv;
        LockFreeTaskQueueCore<E> next = new LockFreeTaskQueueCore<E>(this.capacity * 2, this.singleConsumer);
        Companion companion = Companion;
        long $this$withState$iv = state;
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl2 = false;
        int index = head;
        while ((index & this.mask) != (tail & this.mask)) {
            Object object = this.getArray().get(index & this.mask);
            if (object == null) {
                object = new Placeholder(index);
            }
            Object value = object;
            super.getArray().set(index & next.mask, value);
            ++index;
        }
        LockFreeTaskQueueCore._state$volatile$FU.set(next, Companion.wo(state, 0x1000000000000000L));
        return next;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> transform) {
        void tail;
        int tail$iv;
        ArrayList<R> res = new ArrayList<R>(this.capacity);
        Companion companion = Companion;
        long $this$withState$iv = LockFreeTaskQueueCore._state$volatile$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl2 = false;
        int index = head;
        while ((index & this.mask) != (tail & this.mask)) {
            Object element = this.getArray().get(index & this.mask);
            if (element != null && !(element instanceof Placeholder)) {
                res.add(transform.invoke(element));
            }
            ++index;
        }
        return res;
    }

    public final boolean isClosed() {
        return (LockFreeTaskQueueCore._state$volatile$FU.get(this) & 0x2000000000000000L) != 0L;
    }

    private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Long, Long> action$atomicfu) {
        Long l2;
        long l3;
        while (!handler$atomicfu.compareAndSet(obj$atomicfu, l3 = handler$atomicfu.get(obj$atomicfu), ((Number)(l2 = action$atomicfu.invoke((Long)l3))).longValue())) {
        }
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Long, Unit> action$atomicfu) {
        while (true) {
            long l2 = handler$atomicfu.get(obj$atomicfu);
            action$atomicfu.invoke((Long)l2);
        }
    }

    private final /* synthetic */ long updateAndGet$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Long, Long> action$atomicfu) {
        Long l2;
        long l3;
        while (!handler$atomicfu.compareAndSet(obj$atomicfu, l3 = handler$atomicfu.get(obj$atomicfu), ((Number)(l2 = action$atomicfu.invoke((Long)l3))).longValue())) {
        }
        return ((Number)l2).longValue();
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    static {
        _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");
        _state$volatile$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");
        REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\n*\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0086\u0004J\u0012\u0010\u0019\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0005J\u0012\u0010\u001b\u001a\u00020\n*\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005JP\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0001\u0010\u001e*\u00020\n26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u001e0 H\u0086\b\u00a2\u0006\u0002\u0010%J\n\u0010&\u001a\u00020\u0005*\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "<init>", "()V", "INITIAL_CAPACITY", "", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "HEAD_MASK", "", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "wo", "other", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "addFailReason", "kotlinx-coroutines-core"})
    public static final class Companion {
        private Companion() {
        }

        public final long wo(long $this$wo, long other) {
            return $this$wo & (other ^ 0xFFFFFFFFFFFFFFFFL);
        }

        public final long updateHead(long $this$updateHead, int newHead) {
            return this.wo($this$updateHead, 0x3FFFFFFFL) | (long)newHead << 0;
        }

        public final long updateTail(long $this$updateTail, int newTail) {
            return this.wo($this$updateTail, 0xFFFFFFFC0000000L) | (long)newTail << 30;
        }

        public final <T> T withState(long $this$withState, @NotNull Function2<? super Integer, ? super Integer, ? extends T> block) {
            boolean $i$f$withState = false;
            int head = (int)(($this$withState & 0x3FFFFFFFL) >> 0);
            int tail = (int)(($this$withState & 0xFFFFFFFC0000000L) >> 30);
            return block.invoke(head, tail);
        }

        public final int addFailReason(long $this$addFailReason) {
            return ($this$addFailReason & 0x2000000000000000L) != 0L ? 2 : 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "<init>", "(I)V", "kotlinx-coroutines-core"})
    public static final class Placeholder {
        @JvmField
        public final int index;

        public Placeholder(int index) {
            this.index = index;
        }
    }
}

