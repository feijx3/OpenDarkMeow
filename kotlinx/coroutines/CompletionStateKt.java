/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u00a2\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0000\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2={"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "recoverResult", "state", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,51:1\n1#2:52\n57#3,2:53\n57#3,2:55\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n11#1:53,2\n16#1:55,2\n*E\n"})
public final class CompletionStateKt {
    @Nullable
    public static final <T> Object toState(@NotNull Object $this$toState) {
        Object object;
        Object object2 = $this$toState;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable == null) {
            object = object2;
        } else {
            Throwable it = throwable;
            boolean bl2 = false;
            object = new CompletedExceptionally(it, false, 2, null);
        }
        return object;
    }

    @Nullable
    public static final <T> Object toState(@NotNull Object $this$toState, @NotNull CancellableContinuation<?> caller) {
        Object object;
        Object object2 = $this$toState;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable == null) {
            object = object2;
        } else {
            Throwable it = throwable;
            boolean bl2 = false;
            boolean $i$f$recoverStackTrace = false;
            object = new CompletedExceptionally(!DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)caller instanceof CoroutineStackFrame) ? it : StackTraceRecoveryKt.access$recoverFromStackFrame(it, (CoroutineStackFrame)((Object)caller)), false, 2, null);
        }
        return object;
    }

    @NotNull
    public static final <T> Object recoverResult(@Nullable Object state, @NotNull Continuation<? super T> uCont) {
        Object object;
        if (state instanceof CompletedExceptionally) {
            Throwable exception$iv = ((CompletedExceptionally)state).cause;
            boolean $i$f$recoverStackTrace = false;
            object = Result.constructor-impl(ResultKt.createFailure(!DebugKt.getRECOVER_STACK_TRACES() || !(uCont instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)((Object)uCont))));
        } else {
            object = Result.constructor-impl(state);
        }
        return object;
    }
}

