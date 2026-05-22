/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0017\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00150\u0019\u00a2\u0006\u0002\u0010\u001cJ\r\u0010\u001d\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u001eJ$\u0010 \u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000\u00a2\u0006\u0002\u0010$J,\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u00002\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b\u00a2\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u0000\u00a2\u0006\u0002\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00018\u0000H\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0015\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u000eH\u0001\u00a2\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0001\u00a2\u0006\u0002\u0010$J\u0011\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0011\u00101\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0015\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0002\u00a2\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002R\u001a\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016\u00a8\u00066"}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "_size", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "isEmpty", "", "()Z", "find", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "removeFirstIf", "addLast", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLastIf", "cond", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "siftUpFrom", "i", "siftDownFrom", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "swap", "j", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n29#2:160\n29#2:162\n29#2:164\n29#2:166\n29#2:168\n29#2:170\n29#2:172\n16#3:161\n16#3:163\n16#3:165\n16#3:167\n16#3:169\n16#3:171\n16#3:173\n1#4:174\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n33#1:160\n41#1:162\n43#1:164\n51#1:166\n60#1:168\n63#1:170\n72#1:172\n33#1:161\n41#1:163\n43#1:165\n51#1:167\n60#1:169\n63#1:171\n72#1:173\n*E\n"})
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    @Nullable
    private T[] a;
    private volatile /* synthetic */ int _size$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$volatile$FU;

    private final /* synthetic */ int get_size$volatile() {
        return this._size$volatile;
    }

    private final /* synthetic */ void set_size$volatile(int value) {
        this._size$volatile = value;
    }

    public final int getSize() {
        return ThreadSafeHeap._size$volatile$FU.get(this);
    }

    private final void setSize(int value) {
        ThreadSafeHeap._size$volatile$FU.set(this, value);
    }

    public final boolean isEmpty() {
        return this.getSize() == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T find(@NotNull Function1<? super T, Boolean> predicate) {
        T t2;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            T t3;
            block4: {
                boolean bl2 = false;
                int n2 = this.getSize();
                for (int i2 = 0; i2 < n2; ++i2) {
                    T value;
                    Intrinsics.checkNotNull(this.a != null ? this.a[i2] : null);
                    value = value;
                    if (!predicate.invoke(value).booleanValue()) continue;
                    t3 = value;
                    break block4;
                }
                t3 = null;
            }
            t2 = t3;
        }
        return t2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T peek() {
        T t2;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl2 = false;
            t2 = this.firstImpl();
        }
        return t2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T removeFirstOrNull() {
        T t2;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl2 = false;
            t2 = this.getSize() > 0 ? (T)this.removeAtImpl(0) : null;
        }
        return t2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> predicate) {
        block5: {
            boolean $i$f$removeFirstIf = false;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            ThreadSafeHeap threadSafeHeap = this;
            // MONITORENTER : threadSafeHeap
            boolean bl2 = false;
            if (this.firstImpl() != null) break block5;
            T t2 = null;
            InlineMarker.finallyStart(2);
            // MONITOREXIT : threadSafeHeap
            InlineMarker.finallyEnd(2);
            return t2;
        }
        try {
            T t3;
            T first = t3;
            T t4 = predicate.invoke(first).booleanValue() ? (T)this.removeAtImpl(0) : null;
            return t4;
        }
        finally {
            InlineMarker.finallyStart(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addLast(@NotNull T node) {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl2 = false;
            this.addImpl(node);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean addLastIf(@NotNull T node, @NotNull Function1<? super T, Boolean> cond) {
        boolean $i$f$addLastIf = false;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl2;
            try {
                boolean bl3;
                boolean bl4 = false;
                if (cond.invoke(this.firstImpl()).booleanValue()) {
                    this.addImpl(node);
                    bl3 = true;
                } else {
                    bl3 = false;
                }
                bl2 = bl3;
            }
            finally {
                InlineMarker.finallyStart(1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl19 : MonitorExitStatement: MONITOREXIT : var6_6
                InlineMarker.finallyEnd(1);
            }
            return bl2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean remove(@NotNull T node) {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl2;
            boolean bl3 = false;
            if (node.getHeap() == null) {
                bl2 = false;
            } else {
                int index = node.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl4 = false;
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                this.removeAtImpl(index);
                bl2 = true;
            }
            boolean bl5 = bl2;
            return bl5;
        }
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        return (T)(this.a != null ? this.a[0] : null);
    }

    /*
     * Unable to fully structure code
     */
    @PublishedApi
    @NotNull
    public final T removeAtImpl(int index) {
        block6: {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                $i$a$-assert-ThreadSafeHeap$removeAtImpl$1 = false;
                if (!(this.getSize() > 0)) {
                    throw new AssertionError();
                }
            }
            Intrinsics.checkNotNull(this.a);
            a = this.a;
            var3_4 = this.getSize();
            this.setSize(var3_4 + -1);
            if (index >= this.getSize()) break block6;
            this.swap(index, this.getSize());
            j = (index - 1) / 2;
            if (index <= 0) ** GOTO lbl-1000
            v0 = a[index];
            Intrinsics.checkNotNull(v0);
            v1 = (Comparable)v0;
            v2 = a[j];
            Intrinsics.checkNotNull(v2);
            if (v1.compareTo(v2) < 0) {
                this.swap(index, j);
                this.siftUpFrom(j);
            } else lbl-1000:
            // 2 sources

            {
                this.siftDownFrom(index);
            }
        }
        v3 = a[this.getSize()];
        Intrinsics.checkNotNull(v3);
        result = v3;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            $i$a$-assert-ThreadSafeHeap$removeAtImpl$2 = false;
            if (!(result.getHeap() == this)) {
                throw new AssertionError();
            }
        }
        result.setHeap(null);
        result.setIndex(-1);
        a[this.getSize()] = null;
        return result;
    }

    @PublishedApi
    public final void addImpl(@NotNull T node) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(node.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        node.setHeap(this);
        ThreadSafeHeapNode[] a2 = this.realloc();
        int n2 = this.getSize();
        this.setSize(n2 + 1);
        int i2 = n2;
        a2[i2] = node;
        node.setIndex(i2);
        this.siftUpFrom(i2);
    }

    private final void siftUpFrom(int i2) {
        ThreadSafeHeap threadSafeHeap = this;
        while (i2 > 0) {
            Intrinsics.checkNotNull(threadSafeHeap.a);
            T[] a2 = threadSafeHeap.a;
            int j2 = (i2 - 1) / 2;
            T t2 = a2[j2];
            Intrinsics.checkNotNull(t2);
            Comparable comparable = (Comparable)t2;
            T t3 = a2[i2];
            Intrinsics.checkNotNull(t3);
            if (comparable.compareTo(t3) <= 0) {
                return;
            }
            threadSafeHeap.swap(i2, j2);
            i2 = j2;
        }
        return;
    }

    private final void siftDownFrom(int i2) {
        ThreadSafeHeap threadSafeHeap = this;
        int j2;
        while ((j2 = 2 * i2 + 1) < threadSafeHeap.getSize()) {
            Intrinsics.checkNotNull(threadSafeHeap.a);
            T[] a2 = threadSafeHeap.a;
            if (j2 + 1 < threadSafeHeap.getSize()) {
                T t2 = a2[j2 + 1];
                Intrinsics.checkNotNull(t2);
                Comparable comparable = (Comparable)t2;
                T t3 = a2[j2];
                Intrinsics.checkNotNull(t3);
                if (comparable.compareTo(t3) < 0) {
                    ++j2;
                }
            }
            T t4 = a2[i2];
            Intrinsics.checkNotNull(t4);
            Comparable comparable = (Comparable)t4;
            T t5 = a2[j2];
            Intrinsics.checkNotNull(t5);
            if (comparable.compareTo(t5) <= 0) {
                return;
            }
            threadSafeHeap.swap(i2, j2);
            ThreadSafeHeap threadSafeHeap2 = threadSafeHeap;
            int n2 = j2;
            threadSafeHeap = threadSafeHeap2;
            i2 = n2;
        }
        return;
    }

    private final T[] realloc() {
        Object[] objectArray;
        T[] a2 = this.a;
        if (a2 == null) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArray;
            ThreadSafeHeapNode[] it = threadSafeHeapNodeArray = new ThreadSafeHeapNode[4];
            boolean bl2 = false;
            this.a = it;
            objectArray = threadSafeHeapNodeArray;
        } else if (this.getSize() >= a2.length) {
            T[] TArray = Arrays.copyOf(a2, this.getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(TArray, "copyOf(...)");
            T[] TArray2 = TArray;
            ThreadSafeHeapNode[] it = (ThreadSafeHeapNode[])TArray2;
            boolean bl3 = false;
            this.a = it;
            objectArray = (ThreadSafeHeapNode[])TArray2;
        } else {
            objectArray = a2;
        }
        return objectArray;
    }

    private final void swap(int i2, int j2) {
        Intrinsics.checkNotNull(this.a);
        T[] a2 = this.a;
        T t2 = a2[j2];
        Intrinsics.checkNotNull(t2);
        T ni = t2;
        T t3 = a2[i2];
        Intrinsics.checkNotNull(t3);
        T nj = t3;
        a2[i2] = ni;
        a2[j2] = nj;
        ni.setIndex(i2);
        nj.setIndex(j2);
    }

    static {
        _size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    }
}

