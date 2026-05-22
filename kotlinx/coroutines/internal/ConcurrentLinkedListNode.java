/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u0004\u0018\u00018\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086\b\u00a2\u0006\u0002\u0010\u0010J\u0013\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u001cR\u0011\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007X\u0082\u0004R\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0011\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0012\u0010\u001e\u001a\u00020\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010 \u001a\u0004\u0018\u00018\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0014\u0010\"\u001a\u00028\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0013\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "nextOrClosed", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrIfClosed", "onClosedAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "getNext", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "trySetNext", "", "value", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "()Z", "getPrev", "cleanPrev", "", "markAsClosed", "isRemoved", "remove", "aliveSegmentLeft", "getAliveSegmentLeft", "aliveSegmentRight", "getAliveSegmentRight", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,265:1\n103#1,7:266\n1#2:273\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n111#1:266,7\n*E\n"})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prev$volatile$FU;

    public ConcurrentLinkedListNode(@Nullable N prev) {
        this._prev$volatile = prev;
    }

    private final /* synthetic */ Object get_next$volatile() {
        return this._next$volatile;
    }

    private final /* synthetic */ void set_next$volatile(Object value) {
        this._next$volatile = value;
    }

    private final /* synthetic */ Object get_prev$volatile() {
        return this._prev$volatile;
    }

    private final /* synthetic */ void set_prev$volatile(Object value) {
        this._prev$volatile = value;
    }

    private final Object getNextOrClosed() {
        return ConcurrentLinkedListNode._next$volatile$FU.get(this);
    }

    @Nullable
    public final N nextOrIfClosed(@NotNull Function0 onClosedAction) {
        boolean $i$f$nextOrIfClosed = false;
        Object it = this.getNextOrClosed();
        boolean bl2 = false;
        if (it == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            onClosedAction.invoke();
            throw new KotlinNothingValueException();
        }
        return (N)((ConcurrentLinkedListNode)it);
    }

    @Nullable
    public final N getNext() {
        ConcurrentLinkedListNode this_$iv = this;
        boolean $i$f$nextOrIfClosed = false;
        Object it$iv = this_$iv.getNextOrClosed();
        boolean bl2 = false;
        if (it$iv == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            boolean bl3 = false;
            return null;
        }
        return (N)((ConcurrentLinkedListNode)it$iv);
    }

    public final boolean trySetNext(@NotNull N value) {
        return ConcurrentLinkedListNode._next$volatile$FU.compareAndSet(this, null, value);
    }

    public final boolean isTail() {
        return this.getNext() == null;
    }

    @Nullable
    public final N getPrev() {
        return (N)((ConcurrentLinkedListNode)ConcurrentLinkedListNode._prev$volatile$FU.get(this));
    }

    public final void cleanPrev() {
        ConcurrentLinkedListNode._prev$volatile$FU.set(this, null);
    }

    public final boolean markAsClosed() {
        return ConcurrentLinkedListNode._next$volatile$FU.compareAndSet(this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public abstract boolean isRemoved();

    public final void remove() {
        N prev;
        N next;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.isRemoved() || this.isTail())) {
                throw new AssertionError();
            }
        }
        if (this.isTail()) {
            return;
        }
        do {
            ConcurrentLinkedListNode it;
            Object v2;
            Object v3;
            prev = this.getAliveSegmentLeft();
            next = this.getAliveSegmentRight();
            ConcurrentLinkedListNode concurrentLinkedListNode = this;
            AtomicReferenceFieldUpdater handler$atomicfu$iv = ConcurrentLinkedListNode._prev$volatile$FU;
            do {
                v3 = handler$atomicfu$iv.get(next);
                it = (ConcurrentLinkedListNode)v3;
                boolean bl3 = false;
            } while (!handler$atomicfu$iv.compareAndSet(next, v3, v2 = it == null ? null : (Object)prev));
            if (prev == null) continue;
            ConcurrentLinkedListNode._next$volatile$FU.set(prev, next);
        } while (((ConcurrentLinkedListNode)next).isRemoved() && !((ConcurrentLinkedListNode)next).isTail() || prev != null && ((ConcurrentLinkedListNode)prev).isRemoved());
    }

    private final N getAliveSegmentLeft() {
        Object cur = this.getPrev();
        while (cur != null && ((ConcurrentLinkedListNode)cur).isRemoved()) {
            cur = (ConcurrentLinkedListNode)ConcurrentLinkedListNode._prev$volatile$FU.get(cur);
        }
        return cur;
    }

    private final N getAliveSegmentRight() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(!this.isTail())) {
                throw new AssertionError();
            }
        }
        N n2 = this.getNext();
        Intrinsics.checkNotNull(n2);
        N cur = n2;
        while (((ConcurrentLinkedListNode)cur).isRemoved()) {
            if (((ConcurrentLinkedListNode)cur).getNext() != null) continue;
            return cur;
        }
        return cur;
    }

    private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, ? extends Object> action$atomicfu) {
        Object object;
        Object v2;
        while (!handler$atomicfu.compareAndSet(obj$atomicfu, v2 = handler$atomicfu.get(obj$atomicfu), object = action$atomicfu.invoke(v2))) {
        }
    }

    static {
        _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next$volatile");
        _prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev$volatile");
    }
}

