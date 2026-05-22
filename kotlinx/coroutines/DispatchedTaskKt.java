/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a'\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0080\b\u001a\u0019\u0010\u001b\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u001e"}, d2={"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "resumeWithStackTrace", "exception", "", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,220:1\n184#1,17:238\n1#2:221\n236#3:222\n237#3,2:233\n239#3:237\n103#4,10:223\n114#4,2:235\n57#5,2:255\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n174#1:238,17\n162#1:222\n162#1:233,2\n162#1:237\n162#1:223,10\n162#1:235,2\n204#1:255,2\n*E\n"})
public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    @PublishedApi
    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int $this$isCancellableMode) {
        return $this$isCancellableMode == 1 || $this$isCancellableMode == 2;
    }

    public static final boolean isReusableMode(int $this$isReusableMode) {
        return $this$isReusableMode == 2;
    }

    public static final <T> void dispatch(@NotNull DispatchedTask<? super T> $this$dispatch, int mode) {
        boolean undispatched;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(mode != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> delegate = $this$dispatch.getDelegate$kotlinx_coroutines_core();
        boolean bl3 = undispatched = mode == 4;
        if (!undispatched && delegate instanceof DispatchedContinuation && DispatchedTaskKt.isCancellableMode(mode) == DispatchedTaskKt.isCancellableMode($this$dispatch.resumeMode)) {
            CoroutineDispatcher dispatcher = ((DispatchedContinuation)delegate).dispatcher;
            CoroutineContext context = ((DispatchedContinuation)delegate).getContext();
            if (DispatchedContinuationKt.safeIsDispatchNeeded(dispatcher, context)) {
                DispatchedContinuationKt.safeDispatch(dispatcher, context, $this$dispatch);
            } else {
                DispatchedTaskKt.resumeUnconfined($this$dispatch);
            }
        } else {
            DispatchedTaskKt.resume($this$dispatch, delegate, undispatched);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final <T> void resume(@NotNull DispatchedTask<? super T> $this$resume, @NotNull Continuation<? super T> delegate, boolean undispatched) {
        Object state = $this$resume.takeState$kotlinx_coroutines_core();
        Throwable exception = $this$resume.getExceptionalResult$kotlinx_coroutines_core(state);
        Object result = exception != null ? Result.constructor-impl(ResultKt.createFailure(exception)) : Result.constructor-impl($this$resume.getSuccessfulResult$kotlinx_coroutines_core(state));
        if (undispatched) {
            void continuation$iv$iv;
            Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation this_$iv = (DispatchedContinuation)delegate;
            boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
            Continuation continuation = this_$iv.continuation;
            Object countOrElement$iv$iv = this_$iv.countOrElement;
            boolean $i$f$withContinuationContext = false;
            CoroutineContext context$iv$iv = continuation$iv$iv.getContext();
            Object oldValue$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv, countOrElement$iv$iv);
            UndispatchedCoroutine<?> undispatchedCompletion$iv$iv = oldValue$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv, context$iv$iv, oldValue$iv$iv) : null;
            try {
                boolean bl2 = false;
                this_$iv.continuation.resumeWith(result);
                Unit unit = Unit.INSTANCE;
            }
            finally {
                if (undispatchedCompletion$iv$iv == null || undispatchedCompletion$iv$iv.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context$iv$iv, oldValue$iv$iv);
                }
            }
        } else {
            delegate.resumeWith(result);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final void resumeUnconfined(DispatchedTask<?> $this$resumeUnconfined) {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop.isUnconfinedLoopActive()) {
            eventLoop.dispatchUnconfined($this$resumeUnconfined);
        } else {
            DispatchedTask<?> $this$runUnconfinedEventLoop$iv = $this$resumeUnconfined;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop.incrementUseCount(true);
            try {
                boolean bl2 = false;
                DispatchedTaskKt.resume($this$resumeUnconfined, $this$resumeUnconfined.getDelegate$kotlinx_coroutines_core(), true);
                while (eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv) {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv);
            }
            finally {
                eventLoop.decrementUseCount(true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void runUnconfinedEventLoop(@NotNull DispatchedTask<?> $this$runUnconfinedEventLoop, @NotNull EventLoop eventLoop, @NotNull Function0<Unit> block) {
        boolean $i$f$runUnconfinedEventLoop = false;
        eventLoop.incrementUseCount(true);
        try {
            block.invoke();
            while (eventLoop.processUnconfinedEvent()) {
            }
        }
        catch (Throwable e2) {
            $this$runUnconfinedEventLoop.handleFatalException$kotlinx_coroutines_core(e2);
        }
        finally {
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void resumeWithStackTrace(@NotNull Continuation<?> $this$resumeWithStackTrace, @NotNull Throwable exception) {
        boolean $i$f$resumeWithStackTrace = false;
        boolean $i$f$recoverStackTrace = false;
        $this$resumeWithStackTrace.resumeWith(Result.constructor-impl(ResultKt.createFailure(!DebugKt.getRECOVER_STACK_TRACES() || !($this$resumeWithStackTrace instanceof CoroutineStackFrame) ? exception : StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame)((Object)$this$resumeWithStackTrace)))));
    }
}

