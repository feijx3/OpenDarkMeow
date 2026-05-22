/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.intrinsics;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aO\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000\u00a2\u0006\u0002\u0010\t\u001aV\u0010\n\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\u0007\u001a\u0002H\u00022'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u00a2\u0006\u0002\b\rH\u0000\u00a2\u0006\u0002\u0010\u000e\u001aV\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\u0007\u001a\u0002H\u00022'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u00a2\u0006\u0002\b\rH\u0000\u00a2\u0006\u0002\u0010\u000e\u001a^\u0010\u0010\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u0002H\u00022'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u00a2\u0006\u0002\b\rH\u0002\u00a2\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u00a8\u0006\u001b"}, d2={"startCoroutineUndispatched", "", "R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "startUndspatched", "alwaysRethrow", "", "(Lkotlinx/coroutines/internal/ScopeCoroutine;ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "notOwnTimeout", "cause", "", "dispatchExceptionAndMakeCompleting", "", "e", "Lkotlinx/coroutines/DispatchException;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,105:1\n8#2:106\n11#2,2:110\n91#3,3:107\n95#3:112\n57#4,2:113\n57#4,2:115\n57#4,2:117\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n14#1:106\n19#1:110,2\n18#1:107,3\n18#1:112\n88#1:113,2\n89#1:115,2\n103#1:117,2\n*E\n"})
public final class UndispatchedKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final <R, T> void startCoroutineUndispatched(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUndispatched, R receiver, @NotNull Continuation<? super T> completion) {
        Object object;
        boolean $i$f$probeCoroutineCreated = false;
        Continuation<T> actualCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        try {
            Object object2;
            void context$iv;
            object = actualCompletion.getContext();
            Object countOrElement$iv = null;
            boolean $i$f$withCoroutineContext = false;
            Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
            try {
                boolean bl2 = false;
                boolean $i$f$probeCoroutineResumed = false;
                DebugProbesKt.probeCoroutineResumed(actualCompletion);
                Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2 = $this$startCoroutineUndispatched;
                object2 = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, receiver, actualCompletion) : ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(receiver, actualCompletion);
            }
            finally {
                ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
            }
            object = object2;
        }
        catch (Throwable e2) {
            Throwable reportException = e2 instanceof DispatchException ? ((DispatchException)e2).getCause() : e2;
            actualCompletion.resumeWith(Result.constructor-impl(ResultKt.createFailure(reportException)));
            return;
        }
        Object value = object;
        if (value != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            actualCompletion.resumeWith(Result.constructor-impl(value));
        }
    }

    @Nullable
    public static final <T, R> Object startUndispatchedOrReturn(@NotNull ScopeCoroutine<? super T> $this$startUndispatchedOrReturn, R receiver, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        return UndispatchedKt.startUndspatched($this$startUndispatchedOrReturn, true, receiver, block);
    }

    @Nullable
    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(@NotNull ScopeCoroutine<? super T> $this$startUndispatchedOrReturnIgnoreTimeout, R receiver, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        return UndispatchedKt.startUndspatched($this$startUndispatchedOrReturnIgnoreTimeout, false, receiver, block);
    }

    /*
     * WARNING - void declaration
     */
    private static final <T, R> Object startUndspatched(ScopeCoroutine<? super T> $this$startUndspatched, boolean alwaysRethrow, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Object object;
        Object object2;
        try {
            object2 = block;
            object2 = !(object2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(object2, receiver, (Continuation)$this$startUndspatched) : ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object2, 2)).invoke(receiver, (Continuation)$this$startUndspatched);
        }
        catch (DispatchException e2) {
            UndispatchedKt.dispatchExceptionAndMakeCompleting($this$startUndspatched, e2);
            throw new KotlinNothingValueException();
        }
        catch (Throwable e3) {
            object2 = new CompletedExceptionally(e3, false, 2, null);
        }
        Object result = object2;
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = $this$startUndspatched.makeCompletingOnce$kotlinx_coroutines_core(result);
        if (state == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        $this$startUndspatched.afterCompletionUndispatched();
        if (state instanceof CompletedExceptionally) {
            if (alwaysRethrow || UndispatchedKt.notOwnTimeout($this$startUndspatched, ((CompletedExceptionally)state).cause)) {
                void exception$iv;
                e3 = ((CompletedExceptionally)state).cause;
                Continuation continuation$iv = $this$startUndspatched.uCont;
                boolean $i$f$recoverStackTrace = false;
                throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)exception$iv, (CoroutineStackFrame)((Object)continuation$iv));
            }
            if (result instanceof CompletedExceptionally) {
                Throwable exception$iv = ((CompletedExceptionally)result).cause;
                Continuation continuation$iv = $this$startUndspatched.uCont;
                boolean $i$f$recoverStackTrace = false;
                throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)((Object)continuation$iv));
            }
            object = result;
        } else {
            object = JobSupportKt.unboxState(state);
        }
        return object;
    }

    private static final boolean notOwnTimeout(ScopeCoroutine<?> $this$notOwnTimeout, Throwable cause) {
        return !(cause instanceof TimeoutCancellationException) || ((TimeoutCancellationException)cause).coroutine != $this$notOwnTimeout;
    }

    /*
     * WARNING - void declaration
     */
    private static final Void dispatchExceptionAndMakeCompleting(ScopeCoroutine<?> $this$dispatchExceptionAndMakeCompleting, DispatchException e2) {
        void exception$iv;
        $this$dispatchExceptionAndMakeCompleting.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(e2.getCause(), false, 2, null));
        Throwable throwable = e2.getCause();
        Continuation continuation$iv = $this$dispatchExceptionAndMakeCompleting.uCont;
        boolean $i$f$recoverStackTrace = false;
        throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)exception$iv, (CoroutineStackFrame)((Object)continuation$iv));
    }
}

