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

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J\r\u0010\u001d\u001a\u00020\u001eH\u0000\u00a2\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020!H\u0000\u00a2\u0006\u0002\b\"J\r\u0010#\u001a\u00020!H\u0000\u00a2\u0006\u0002\b$J\u0015\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aH\u0000\u00a2\u0006\u0002\b&J\u001b\u0010'\u001a\u0004\u0018\u00010(2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030)H\u0000\u00a2\u0006\u0002\b*J\u0015\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020(H\u0000\u00a2\u0006\u0002\b-J\u000f\u0010.\u001a\u0004\u0018\u00010\fH\u0010\u00a2\u0006\u0002\b/J\u001b\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016\u00a2\u0006\u0002\u00106J\u001e\u00107\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0080\b\u00a2\u0006\u0004\b8\u00106J\u0018\u00109\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010\fH\u0080\b\u00a2\u0006\u0002\b;J\u001e\u0010<\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0080\b\u00a2\u0006\u0004\b=\u00106J\u001f\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020EH\u0016R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0016\u001a\u00020\f8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018X\u0082\u0004R\u001a\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u0010?\u001a\u00020@X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006H"}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "countOrElement", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "isReusable", "", "isReusable$kotlinx_coroutines_core", "awaitReusability", "", "awaitReusability$kotlinx_coroutines_core", "release", "release$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "tryReleaseClaimedContinuation", "", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "postponeCancellation", "cause", "postponeCancellation$kotlinx_coroutines_core", "takeState", "takeState$kotlinx_coroutines_core", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumeCancellableWith", "resumeCancellableWith$kotlinx_coroutines_core", "resumeCancelled", "state", "resumeCancelled$kotlinx_coroutines_core", "resumeUndispatchedWith", "resumeUndispatchedWith$kotlinx_coroutines_core", "dispatchYield", "context", "Lkotlin/coroutines/CoroutineContext;", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "toString", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,313:1\n224#1,8:377\n236#1:385\n237#1,2:396\n239#1:400\n1#2:314\n1#2:320\n1#2:361\n293#3,5:315\n298#3,12:321\n310#3:355\n293#3,5:356\n298#3,12:362\n310#3:415\n184#4,3:333\n187#4,14:341\n184#4,3:374\n187#4,14:401\n91#5,5:336\n103#5,10:386\n114#5,2:398\n103#5,13:416\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n214#1:377,8\n215#1:385\n215#1:396,2\n215#1:400\n195#1:320\n213#1:361\n195#1:315,5\n195#1:321,12\n195#1:355\n213#1:356,5\n213#1:362,12\n213#1:415\n195#1:333,3\n195#1:341,14\n213#1:374,3\n213#1:401,14\n196#1:336,5\n215#1:386,10\n215#1:398,2\n236#1:416,13\n*E\n"})
public final class DispatchedContinuation<T>
extends DispatchedTask<T>
implements CoroutineStackFrame,
Continuation<T> {
    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;
    @JvmField
    @NotNull
    public final Continuation<T> continuation;
    @JvmField
    @Nullable
    public Object _state;
    @JvmField
    @NotNull
    public final Object countOrElement;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _reusableCancellableContinuation$volatile$FU;

    public DispatchedContinuation(@NotNull CoroutineDispatcher dispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = dispatcher;
        this.continuation = continuation;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    @Override
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.continuation;
        return continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame)((Object)continuation) : null;
    }

    @Override
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final /* synthetic */ Object get_reusableCancellableContinuation$volatile() {
        return this._reusableCancellableContinuation$volatile;
    }

    private final /* synthetic */ void set_reusableCancellableContinuation$volatile(Object value) {
        this._reusableCancellableContinuation$volatile = value;
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object v2 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU.get(this);
        return v2 instanceof CancellableContinuationImpl ? (CancellableContinuationImpl)v2 : null;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        return DispatchedContinuation._reusableCancellableContinuation$volatile$FU.get(this) != null;
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        Object it;
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        do {
            it = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
        } while (it == DispatchedContinuationKt.REUSABLE_CLAIMED);
    }

    public final void release$kotlinx_coroutines_core() {
        block0: {
            this.awaitReusability$kotlinx_coroutines_core();
            CancellableContinuationImpl<?> cancellableContinuationImpl = this.getReusableCancellableContinuation();
            if (cancellableContinuationImpl == null) break block0;
            cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
        }
    }

    @Nullable
    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        Object state;
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while (true) {
            state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if (state == null) {
                DispatchedContinuation._reusableCancellableContinuation$volatile$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
                return null;
            }
            if (state instanceof CancellableContinuationImpl) {
                if (!DispatchedContinuation._reusableCancellableContinuation$volatile$FU.compareAndSet(this, state, DispatchedContinuationKt.REUSABLE_CLAIMED)) continue;
                return (CancellableContinuationImpl)state;
            }
            if (state != DispatchedContinuationKt.REUSABLE_CLAIMED && !(state instanceof Throwable)) break;
        }
        throw new IllegalStateException(("Inconsistent state " + state).toString());
    }

    @Nullable
    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(@NotNull CancellableContinuation<?> continuation) {
        Object state;
        block3: {
            DispatchedContinuation dispatchedContinuation = this;
            AtomicReferenceFieldUpdater handler$atomicfu$iv = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
            do {
                state = handler$atomicfu$iv.get(this);
                boolean bl2 = false;
                if (state != DispatchedContinuationKt.REUSABLE_CLAIMED) break block3;
            } while (!DispatchedContinuation._reusableCancellableContinuation$volatile$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, continuation));
            return null;
        }
        if (state instanceof Throwable) {
            if (!DispatchedContinuation._reusableCancellableContinuation$volatile$FU.compareAndSet(this, state, null)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            return (Throwable)state;
        }
        throw new IllegalStateException(("Inconsistent state " + state).toString());
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(@NotNull Throwable cause) {
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while (true) {
            Object state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            Object v2 = state;
            if (Intrinsics.areEqual(v2, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if (!DispatchedContinuation._reusableCancellableContinuation$volatile$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, cause)) continue;
                return true;
            }
            if (v2 instanceof Throwable) {
                return true;
            }
            if (DispatchedContinuation._reusableCancellableContinuation$volatile$FU.compareAndSet(this, state, null)) break;
        }
        return false;
    }

    @Override
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object state = this._state;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(state != DispatchedContinuationKt.access$getUNDEFINED$p())) {
                throw new AssertionError();
            }
        }
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return state;
    }

    @Override
    @NotNull
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    public void resumeWith(@NotNull Object result) {
        Object state = CompletionStateKt.toState(result);
        if (DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, this.getContext())) {
            this._state = state;
            this.resumeMode = 0;
            DispatchedContinuationKt.safeDispatch(this.dispatcher, this.getContext(), this);
        } else {
            boolean bl2;
            void $this$executeUnconfined_u24default$iv;
            DispatchedContinuation dispatchedContinuation = this;
            int mode$iv = 0;
            boolean doYield$iv = false;
            boolean $i$f$executeUnconfined = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!true) {
                    throw new AssertionError();
                }
            }
            EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$iv.isUnconfinedLoopActive()) {
                $this$executeUnconfined_u24default$iv._state = state;
                $this$executeUnconfined_u24default$iv.resumeMode = mode$iv;
                eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv);
                bl2 = true;
            } else {
                DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv;
                boolean $i$f$runUnconfinedEventLoop = false;
                eventLoop$iv.incrementUseCount(true);
                try {
                    void context$iv;
                    boolean bl4 = false;
                    CoroutineContext coroutineContext = this.getContext();
                    Object countOrElement$iv = this.countOrElement;
                    boolean $i$f$withCoroutineContext = false;
                    Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
                    try {
                        boolean bl5 = false;
                        this.continuation.resumeWith(result);
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
                    }
                    while (eventLoop$iv.processUnconfinedEvent()) {
                    }
                }
                catch (Throwable e$iv$iv) {
                    $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv);
                }
                finally {
                    eventLoop$iv.decrementUseCount(true);
                }
                bl2 = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void resumeCancellableWith$kotlinx_coroutines_core(@NotNull Object result) {
        boolean $i$f$resumeCancellableWith$kotlinx_coroutines_core = false;
        Object state = CompletionStateKt.toState(result);
        if (DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, this.getContext())) {
            this._state = state;
            this.resumeMode = 1;
            DispatchedContinuationKt.safeDispatch(this.dispatcher, this.getContext(), this);
        } else {
            boolean bl2;
            void $this$executeUnconfined_u24default$iv;
            DispatchedContinuation dispatchedContinuation = this;
            int mode$iv = 1;
            boolean doYield$iv = false;
            boolean $i$f$executeUnconfined = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!true) {
                    throw new AssertionError();
                }
            }
            EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$iv.isUnconfinedLoopActive()) {
                $this$executeUnconfined_u24default$iv._state = state;
                $this$executeUnconfined_u24default$iv.resumeMode = mode$iv;
                eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv);
                bl2 = true;
            } else {
                DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv;
                boolean $i$f$runUnconfinedEventLoop = false;
                eventLoop$iv.incrementUseCount(true);
                try {
                    boolean bl4;
                    boolean bl5 = false;
                    DispatchedContinuation this_$iv = this;
                    boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
                    Object job$iv = (Job)this_$iv.getContext().get(Job.Key);
                    if (job$iv != null && !job$iv.isActive()) {
                        CancellationException cause$iv = job$iv.getCancellationException();
                        this_$iv.cancelCompletedResult$kotlinx_coroutines_core(state, cause$iv);
                        ((Continuation)this_$iv).resumeWith(Result.constructor-impl(ResultKt.createFailure(cause$iv)));
                        bl4 = true;
                    } else {
                        bl4 = false;
                    }
                    if (!bl4) {
                        void continuation$iv$iv;
                        this_$iv = this;
                        boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
                        job$iv = this_$iv.continuation;
                        Object countOrElement$iv$iv = this_$iv.countOrElement;
                        boolean $i$f$withContinuationContext = false;
                        CoroutineContext context$iv$iv = continuation$iv$iv.getContext();
                        Object oldValue$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv, countOrElement$iv$iv);
                        UndispatchedCoroutine<?> undispatchedCompletion$iv$iv = oldValue$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv, context$iv$iv, oldValue$iv$iv) : null;
                        try {
                            boolean bl6 = false;
                            this_$iv.continuation.resumeWith(result);
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            InlineMarker.finallyStart(1);
                            if (undispatchedCompletion$iv$iv == null || undispatchedCompletion$iv$iv.clearThreadContext()) {
                                ThreadContextKt.restoreThreadContext(context$iv$iv, oldValue$iv$iv);
                            }
                            InlineMarker.finallyEnd(1);
                        }
                    }
                    while (eventLoop$iv.processUnconfinedEvent()) {
                    }
                }
                catch (Throwable e$iv$iv) {
                    $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv);
                }
                finally {
                    InlineMarker.finallyStart(1);
                    eventLoop$iv.decrementUseCount(true);
                    InlineMarker.finallyEnd(1);
                }
                bl2 = false;
            }
        }
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(@Nullable Object state) {
        boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
        Job job = (Job)this.getContext().get(Job.Key);
        if (job != null && !job.isActive()) {
            CancellationException cause = job.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(state, cause);
            ((Continuation)this).resumeWith(Result.constructor-impl(ResultKt.createFailure(cause)));
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void resumeUndispatchedWith$kotlinx_coroutines_core(@NotNull Object result) {
        void continuation$iv;
        boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
        Continuation<T> continuation = this.continuation;
        Object countOrElement$iv = this.countOrElement;
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context$iv = continuation$iv.getContext();
        Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, countOrElement$iv);
        UndispatchedCoroutine<?> undispatchedCompletion$iv = oldValue$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv, context$iv, oldValue$iv) : null;
        try {
            boolean bl2 = false;
            this.continuation.resumeWith(result);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart(1);
            if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    @Override
    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    static {
        _reusableCancellableContinuation$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    }
}

