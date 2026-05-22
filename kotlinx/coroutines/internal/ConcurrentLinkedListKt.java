/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\r\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0080\b\u001as\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u000228\b\b\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0080\b\u001a!\u0010\u0012\u001a\u0002H\u0013\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u0013H\u0000\u00a2\u0006\u0002\u0010\u0015\u001a8\u0010\u0016\u001a\u00020\r*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u001bH\u0082\b\"\u000e\u0010\u001d\u001a\u00020\u0019X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"findSegmentInternal", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "id", "", "createNewSegment", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "", "Lkotlinx/atomicfu/AtomicRef;", "to", "findSegmentAndMoveForward", "startFrom", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "addConditionally", "Lkotlinx/atomicfu/AtomicInt;", "delta", "", "condition", "Lkotlin/Function1;", "cur", "POINTERS_SHIFT", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,265:1\n42#1,8:280\n103#2,7:266\n103#2,7:273\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n70#1:280,8\n23#1:266,7\n81#1:273,7\n*E\n"})
public final class ConcurrentLinkedListKt {
    private static final int POINTERS_SHIFT = 16;
    @NotNull
    private static final Symbol CLOSED = new Symbol("CLOSED");

    @NotNull
    public static final <S extends Segment<S>> Object findSegmentInternal(@NotNull S $this$findSegmentInternal, long id, @NotNull Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        Object cur = $this$findSegmentInternal;
        while (((Segment)cur).id < id || ((Segment)cur).isRemoved()) {
            ConcurrentLinkedListNode this_$iv = (ConcurrentLinkedListNode)cur;
            boolean $i$f$nextOrIfClosed = false;
            Object it$iv = ConcurrentLinkedListNode.access$getNextOrClosed(this_$iv);
            boolean bl2 = false;
            if (it$iv == ConcurrentLinkedListKt.CLOSED) {
                boolean bl3 = false;
                return SegmentOrClosed.constructor-impl(CLOSED);
            }
            Segment next = (Segment)((ConcurrentLinkedListNode)it$iv);
            if (next != null) {
                cur = next;
                continue;
            }
            Segment newTail = (Segment)createNewSegment.invoke(((Segment)cur).id + 1L, cur);
            if (!((ConcurrentLinkedListNode)cur).trySetNext((ConcurrentLinkedListNode)newTail)) continue;
            if (((Segment)cur).isRemoved()) {
                ((ConcurrentLinkedListNode)cur).remove();
            }
            cur = newTail;
        }
        return SegmentOrClosed.constructor-impl(cur);
    }

    @NotNull
    public static final <N extends ConcurrentLinkedListNode<N>> N close(@NotNull N $this$close) {
        ConcurrentLinkedListNode cur = null;
        cur = $this$close;
        while (true) {
            ConcurrentLinkedListNode this_$iv = cur;
            boolean $i$f$nextOrIfClosed = false;
            Object it$iv = ConcurrentLinkedListNode.access$getNextOrClosed(this_$iv);
            boolean bl2 = false;
            if (it$iv == ConcurrentLinkedListKt.CLOSED) {
                boolean bl3 = false;
                return (N)cur;
            }
            ConcurrentLinkedListNode next = (ConcurrentLinkedListNode)it$iv;
            if (next == null) {
                if (!cur.markAsClosed()) continue;
                return (N)cur;
            }
            cur = next;
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, S to) {
        while (true) {
            Segment cur = (Segment)handler$atomicfu.get(obj$atomicfu);
            boolean bl2 = false;
            if (cur.id >= to.id) {
                return true;
            }
            if (!to.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (handler$atomicfu.compareAndSet(obj$atomicfu, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (!to.decPointers$kotlinx_coroutines_core()) continue;
            to.remove();
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference handler$atomicfu, S to) {
        while (true) {
            Segment cur = (Segment)handler$atomicfu.get();
            boolean bl2 = false;
            if (cur.id >= to.id) {
                return true;
            }
            if (!to.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (handler$atomicfu.compareAndSet(cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (!to.decPointers$kotlinx_coroutines_core()) continue;
            to.remove();
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray handler$atomicfu, int index$atomicfu, S to) {
        while (true) {
            Segment cur = (Segment)handler$atomicfu.get(index$atomicfu);
            boolean bl2 = false;
            if (cur.id >= to.id) {
                return true;
            }
            if (!to.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (handler$atomicfu.compareAndSet(index$atomicfu, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (!to.decPointers$kotlinx_coroutines_core()) continue;
            to.remove();
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, long id, S startFrom, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        Object s2;
        while (!SegmentOrClosed.isClosed-impl(s2 = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, createNewSegment))) {
            boolean bl2;
            Object to$iv = SegmentOrClosed.getSegment-impl(s2);
            while (true) {
                Segment cur$iv = (Segment)handler$atomicfu.get(obj$atomicfu);
                boolean bl3 = false;
                if (cur$iv.id >= ((Segment)to$iv).id) {
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl2 = false;
                    break;
                }
                if (handler$atomicfu.compareAndSet(obj$atomicfu, cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv).remove();
            }
            if (!bl2) continue;
        }
        return s2;
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference handler$atomicfu, long id, S startFrom, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        Object s2;
        while (!SegmentOrClosed.isClosed-impl(s2 = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, createNewSegment))) {
            boolean bl2;
            Object to$iv = SegmentOrClosed.getSegment-impl(s2);
            while (true) {
                Segment cur$iv = (Segment)handler$atomicfu.get();
                boolean bl3 = false;
                if (cur$iv.id >= ((Segment)to$iv).id) {
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl2 = false;
                    break;
                }
                if (handler$atomicfu.compareAndSet(cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv).remove();
            }
            if (!bl2) continue;
        }
        return s2;
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray handler$atomicfu, int index$atomicfu, long id, S startFrom, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        Object s2;
        while (!SegmentOrClosed.isClosed-impl(s2 = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, createNewSegment))) {
            boolean bl2;
            Object to$iv = SegmentOrClosed.getSegment-impl(s2);
            while (true) {
                Segment cur$iv = (Segment)handler$atomicfu.get(index$atomicfu);
                boolean bl3 = false;
                if (cur$iv.id >= ((Segment)to$iv).id) {
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl2 = false;
                    break;
                }
                if (handler$atomicfu.compareAndSet(index$atomicfu, cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl2 = true;
                    break;
                }
                if (!((Segment)to$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv).remove();
            }
            if (!bl2) continue;
        }
        return s2;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater handler$atomicfu, Object obj$atomicfu, int delta, Function1<? super Integer, Boolean> condition) {
        int cur;
        do {
            if (condition.invoke((Integer)(cur = handler$atomicfu.get(obj$atomicfu))).booleanValue()) continue;
            return false;
        } while (!handler$atomicfu.compareAndSet(obj$atomicfu, cur, cur + delta));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$BOXED_ATOMIC$Int(AtomicInteger handler$atomicfu, int delta, Function1<? super Integer, Boolean> condition) {
        int cur;
        do {
            if (condition.invoke((Integer)(cur = handler$atomicfu.get())).booleanValue()) continue;
            return false;
        } while (!handler$atomicfu.compareAndSet(cur, cur + delta));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$ATOMIC_ARRAY$Int(AtomicIntegerArray handler$atomicfu, int index$atomicfu, int delta, Function1<? super Integer, Boolean> condition) {
        int cur;
        do {
            if (condition.invoke((Integer)(cur = handler$atomicfu.get(index$atomicfu))).booleanValue()) continue;
            return false;
        } while (!handler$atomicfu.compareAndSet(index$atomicfu, cur, cur + delta));
        return true;
    }

    private static final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    private static final /* synthetic */ void loop$atomicfu$BOXED_ATOMIC$Any(AtomicReference handler$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get());
        }
    }

    private static final /* synthetic */ void loop$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray handler$atomicfu, int index$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(index$atomicfu));
        }
    }
}

