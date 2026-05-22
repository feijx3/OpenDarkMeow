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

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ListClosed;
import kotlinx.coroutines.internal.Removed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\u0016\u001a\u00060\u0000j\u0002`\u00112\n\u0010\u0017\u001a\u00060\u0000j\u0002`\u0011H\u0082\u0010J\u0012\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u0011J\u001a\u0010\u001a\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cJ \u0010 \u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00112\n\u0010\r\u001a\u00060\u0000j\u0002`\u0011H\u0001J\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0011H\u0001J\u0014\u0010#\u001a\u00020\u001e2\n\u0010\r\u001a\u00060\u0000j\u0002`\u0011H\u0002J\u0011\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0011H\u0082\u0010J%\u0010%\u001a\u00020\u001e2\n\u0010&\u001a\u00060\u0000j\u0002`\u00112\n\u0010\r\u001a\u00060\u0000j\u0002`\u0011H\u0000\u00a2\u0006\u0002\b'J\b\u0010(\u001a\u00020)H\u0016R\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004R\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005X\u0082\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00060\u0000j\u0002`\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006*"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "removed", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "findPrevNonRemoved", "current", "addOneIfEmpty", "node", "addLast", "permissionsBitmask", "", "close", "", "forbiddenElementsBit", "addNext", "remove", "removeOrNext", "finishAdd", "correctPrev", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "toString", "", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n1#2:289\n*E\n"})
public class LockFreeLinkedListNode {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prev$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$volatile$FU;

    public LockFreeLinkedListNode() {
        this._next$volatile = this;
        this._prev$volatile = this;
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

    private final /* synthetic */ Object get_removedRef$volatile() {
        return this._removedRef$volatile;
    }

    private final /* synthetic */ void set_removedRef$volatile(Object value) {
        this._removedRef$volatile = value;
    }

    private final Removed removed() {
        Removed removed = (Removed)LockFreeLinkedListNode._removedRef$volatile$FU.get(this);
        if (removed == null) {
            Removed removed2;
            Removed it = removed2 = new Removed(this);
            boolean bl2 = false;
            LockFreeLinkedListNode._removedRef$volatile$FU.set(this, it);
            removed = removed2;
        }
        return removed;
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    @NotNull
    public final Object getNext() {
        return LockFreeLinkedListNode._next$volatile$FU.get(this);
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        Object it = this.getNext();
        boolean bl2 = false;
        Object object = it instanceof Removed ? (Removed)it : null;
        if (object == null || (object = ((Removed)object).ref) == null) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            object = (LockFreeLinkedListNode)it;
        }
        return object;
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this.correctPrev();
        if (lockFreeLinkedListNode == null) {
            lockFreeLinkedListNode = this.findPrevNonRemoved((LockFreeLinkedListNode)LockFreeLinkedListNode._prev$volatile$FU.get(this));
        }
        return lockFreeLinkedListNode;
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode current) {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (current.isRemoved()) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            Object v2 = LockFreeLinkedListNode._prev$volatile$FU.get(current);
            lockFreeLinkedListNode = lockFreeLinkedListNode2;
            current = (LockFreeLinkedListNode)v2;
        }
        return current;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode node) {
        LockFreeLinkedListNode._prev$volatile$FU.set(node, this);
        LockFreeLinkedListNode._next$volatile$FU.set(node, this);
        do {
            Object next;
            if ((next = this.getNext()) == this) continue;
            return false;
        } while (!LockFreeLinkedListNode._next$volatile$FU.compareAndSet(this, this, node));
        node.finishAdd(this);
        return true;
    }

    public final boolean addLast(@NotNull LockFreeLinkedListNode node, int permissionsBitmask) {
        boolean bl2;
        block1: {
            LockFreeLinkedListNode currentPrev;
            do {
                currentPrev = this.getPrevNode();
                if (!(currentPrev instanceof ListClosed)) continue;
                bl2 = (((ListClosed)currentPrev).forbiddenElementsBitmask & permissionsBitmask) == 0 && currentPrev.addLast(node, permissionsBitmask);
                break block1;
            } while (!currentPrev.addNext(node, this));
            bl2 = true;
        }
        return bl2;
    }

    public final void close(int forbiddenElementsBit) {
        this.addLast(new ListClosed(forbiddenElementsBit), forbiddenElementsBit);
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next) {
        LockFreeLinkedListNode._prev$volatile$FU.set(node, this);
        LockFreeLinkedListNode._next$volatile$FU.set(node, next);
        if (!LockFreeLinkedListNode._next$volatile$FU.compareAndSet(this, next, node)) {
            return false;
        }
        node.finishAdd(next);
        return true;
    }

    public boolean remove() {
        return this.removeOrNext() == null;
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        Removed removed;
        Object next;
        do {
            if ((next = this.getNext()) instanceof Removed) {
                return ((Removed)next).ref;
            }
            if (next == this) {
                return (LockFreeLinkedListNode)next;
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            removed = ((LockFreeLinkedListNode)next).removed();
        } while (!LockFreeLinkedListNode._next$volatile$FU.compareAndSet(this, next, removed));
        ((LockFreeLinkedListNode)next).correctPrev();
        return null;
    }

    private final void finishAdd(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode nextPrev;
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = LockFreeLinkedListNode._prev$volatile$FU;
        do {
            nextPrev = (LockFreeLinkedListNode)handler$atomicfu$iv.get(next);
            boolean bl2 = false;
            if (this.getNext() == next) continue;
            return;
        } while (!LockFreeLinkedListNode._prev$volatile$FU.compareAndSet(next, nextPrev, this));
        if (this.isRemoved()) {
            next.correctPrev();
        }
    }

    /*
     * Unable to fully structure code
     */
    private final LockFreeLinkedListNode correctPrev() {
        var1_1 = this;
        block0: while (true) {
            prev = oldPrev = (LockFreeLinkedListNode)LockFreeLinkedListNode.get_prev$volatile$FU().get(var1_1);
            last = null;
            while (true) {
                prevNext = LockFreeLinkedListNode.get_next$volatile$FU().get(prev);
                if (prevNext == var1_1) {
                    if (oldPrev == prev) {
                        return prev;
                    }
                    if (!LockFreeLinkedListNode.get_prev$volatile$FU().compareAndSet(var1_1, oldPrev, prev)) continue block0;
                    return prev;
                }
                if (var1_1.isRemoved()) {
                    return null;
                }
                if (prevNext instanceof Removed) {
                    if (last != null) {
                        if (LockFreeLinkedListNode.get_next$volatile$FU().compareAndSet(last, prev, ((Removed)prevNext).ref)) ** break;
                        continue block0;
                        prev = last;
                        last = null;
                        continue;
                    }
                    prev = (LockFreeLinkedListNode)LockFreeLinkedListNode.get_prev$volatile$FU().get(prev);
                    continue;
                }
                last = prev;
                Intrinsics.checkNotNull(prevNext, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                prev = (LockFreeLinkedListNode)prevNext;
            }
            break;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode prev, @NotNull LockFreeLinkedListNode next) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(prev == LockFreeLinkedListNode._prev$volatile$FU.get(this))) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(next == LockFreeLinkedListNode._next$volatile$FU.get(this))) {
                throw new AssertionError();
            }
        }
    }

    @NotNull
    public String toString() {
        return new PropertyReference0Impl(this){

            public Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    static {
        _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
        _prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
        _removedRef$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    }
}

