/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0000\u00a2\u0006\u0002\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a+\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0014\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\u001a;\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "safeDispatch", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "safeIsDispatchNeeded", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "executeUnconfined", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,313:1\n293#1,5:321\n298#1,12:327\n310#1:395\n297#1:397\n298#1,12:399\n310#1:428\n207#2,7:314\n214#2,23:342\n237#2,2:375\n239#2:379\n217#2:380\n219#2:396\n1#3:326\n1#3:398\n1#3:429\n184#4,3:339\n187#4,14:381\n184#4,17:411\n184#4,17:430\n103#5,10:365\n114#5,2:377\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n278#1:321,5\n278#1:327,12\n278#1:395\n283#1:397\n283#1:399,12\n283#1:428\n278#1:314,7\n278#1:342,23\n278#1:375,2\n278#1:379\n278#1:380\n278#1:396\n278#1:326\n283#1:398\n278#1:339,3\n278#1:381,14\n283#1:411,17\n309#1:430,17\n278#1:365,10\n278#1:377,2\n*E\n"})
public final class DispatchedContinuationKt {
    @NotNull
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    @JvmField
    @NotNull
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static final void safeDispatch(@NotNull CoroutineDispatcher $this$safeDispatch, @NotNull CoroutineContext context, @NotNull Runnable runnable) {
        try {
            $this$safeDispatch.dispatch(context, runnable);
        }
        catch (Throwable e2) {
            throw new DispatchException(e2, $this$safeDispatch, context);
        }
    }

    public static final boolean safeIsDispatchNeeded(@NotNull CoroutineDispatcher $this$safeIsDispatchNeeded, @NotNull CoroutineContext context) {
        try {
            return $this$safeIsDispatchNeeded.isDispatchNeeded(context);
        }
        catch (Throwable e2) {
            throw new DispatchException(e2, $this$safeIsDispatchNeeded, context);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @InternalCoroutinesApi
    public static final <T> void resumeCancellableWith(@NotNull Continuation<? super T> $this$resumeCancellableWith, @NotNull Object result) {
        if ($this$resumeCancellableWith instanceof DispatchedContinuation) {
            DispatchedContinuation this_$iv = (DispatchedContinuation)$this$resumeCancellableWith;
            boolean $i$f$resumeCancellableWith$kotlinx_coroutines_core = false;
            Object state$iv = CompletionStateKt.toState(result);
            if (DispatchedContinuationKt.safeIsDispatchNeeded(this_$iv.dispatcher, this_$iv.getContext())) {
                this_$iv._state = state$iv;
                this_$iv.resumeMode = 1;
                DispatchedContinuationKt.safeDispatch(this_$iv.dispatcher, this_$iv.getContext(), this_$iv);
            } else {
                boolean bl2;
                void $this$executeUnconfined_u24default$iv$iv;
                DispatchedContinuation dispatchedContinuation = this_$iv;
                int mode$iv$iv = 1;
                boolean doYield$iv$iv = false;
                boolean $i$f$executeUnconfined = false;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl3 = false;
                    if (!true) {
                        throw new AssertionError();
                    }
                }
                EventLoop eventLoop$iv$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (eventLoop$iv$iv.isUnconfinedLoopActive()) {
                    $this$executeUnconfined_u24default$iv$iv._state = state$iv;
                    $this$executeUnconfined_u24default$iv$iv.resumeMode = mode$iv$iv;
                    eventLoop$iv$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv$iv);
                    bl2 = true;
                } else {
                    DispatchedTask $this$runUnconfinedEventLoop$iv$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv$iv;
                    boolean $i$f$runUnconfinedEventLoop = false;
                    eventLoop$iv$iv.incrementUseCount(true);
                    try {
                        boolean bl4;
                        boolean bl5 = false;
                        DispatchedContinuation this_$iv$iv = this_$iv;
                        boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
                        Object job$iv$iv = (Job)this_$iv$iv.getContext().get(Job.Key);
                        if (job$iv$iv != null && !job$iv$iv.isActive()) {
                            CancellationException cause$iv$iv = job$iv$iv.getCancellationException();
                            this_$iv$iv.cancelCompletedResult$kotlinx_coroutines_core(state$iv, cause$iv$iv);
                            ((Continuation)this_$iv$iv).resumeWith(Result.constructor-impl(ResultKt.createFailure(cause$iv$iv)));
                            bl4 = true;
                        } else {
                            bl4 = false;
                        }
                        if (!bl4) {
                            void continuation$iv$iv$iv;
                            this_$iv$iv = this_$iv;
                            boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
                            job$iv$iv = this_$iv$iv.continuation;
                            Object countOrElement$iv$iv$iv = this_$iv$iv.countOrElement;
                            boolean $i$f$withContinuationContext = false;
                            CoroutineContext context$iv$iv$iv = continuation$iv$iv$iv.getContext();
                            Object oldValue$iv$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv$iv, countOrElement$iv$iv$iv);
                            UndispatchedCoroutine<?> undispatchedCompletion$iv$iv$iv = oldValue$iv$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv$iv, context$iv$iv$iv, oldValue$iv$iv$iv) : null;
                            try {
                                boolean bl6 = false;
                                this_$iv$iv.continuation.resumeWith(result);
                                Unit unit = Unit.INSTANCE;
                            }
                            finally {
                                if (undispatchedCompletion$iv$iv$iv == null || undispatchedCompletion$iv$iv$iv.clearThreadContext()) {
                                    ThreadContextKt.restoreThreadContext(context$iv$iv$iv, oldValue$iv$iv$iv);
                                }
                            }
                        }
                        while (eventLoop$iv$iv.processUnconfinedEvent()) {
                        }
                    }
                    catch (Throwable e$iv$iv$iv) {
                        $this$runUnconfinedEventLoop$iv$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv$iv);
                    }
                    finally {
                        eventLoop$iv$iv.decrementUseCount(true);
                    }
                    bl2 = false;
                }
            }
        } else {
            $this$resumeCancellableWith.resumeWith(result);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final boolean yieldUndispatched(@NotNull DispatchedContinuation<? super Unit> $this$yieldUndispatched) {
        void $this$executeUnconfined$iv;
        boolean bl2;
        EventLoop eventLoop$iv;
        DispatchedContinuation<? super Unit> dispatchedContinuation = $this$yieldUndispatched;
        Unit unit = Unit.INSTANCE;
        boolean bl3 = true;
        boolean doYield$iv = true;
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl4 = false;
            if (!true) {
                throw new AssertionError();
            }
        }
        if ((eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core()).isUnconfinedQueueEmpty()) {
            bl2 = false;
        } else if (eventLoop$iv.isUnconfinedLoopActive()) {
            void mode$iv;
            void contState$iv;
            $this$executeUnconfined$iv._state = contState$iv;
            $this$executeUnconfined$iv.resumeMode = mode$iv;
            eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined$iv);
            bl2 = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined$iv;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop$iv.incrementUseCount(true);
            try {
                boolean bl5 = false;
                $this$yieldUndispatched.run();
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
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final boolean executeUnconfined(DispatchedContinuation<?> $this$executeUnconfined, Object contState, int mode, boolean doYield, Function0<Unit> block) {
        boolean bl2;
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(mode != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $this$executeUnconfined._state = contState;
            $this$executeUnconfined.resumeMode = mode;
            eventLoop.dispatchUnconfined((DispatchedTask)$this$executeUnconfined);
            bl2 = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv = $this$executeUnconfined;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop.incrementUseCount(true);
            try {
                block.invoke();
                while (eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv) {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv);
            }
            finally {
                InlineMarker.finallyStart(1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
            bl2 = false;
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation $this$executeUnconfined_u24default, Object contState, int mode, boolean doYield, Function0 block, int n2, Object object) {
        boolean bl2;
        if ((n2 & 4) != 0) {
            doYield = false;
        }
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(mode != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $this$executeUnconfined_u24default._state = contState;
            $this$executeUnconfined_u24default.resumeMode = mode;
            eventLoop.dispatchUnconfined($this$executeUnconfined_u24default);
            bl2 = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv = $this$executeUnconfined_u24default;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop.incrementUseCount(true);
            try {
                block.invoke();
                while (eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv) {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv);
            }
            finally {
                InlineMarker.finallyStart(1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
            bl2 = false;
        }
        return bl2;
    }

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }
}

