/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0007\u001aO\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0006\u0010\n\u001a\u0002H\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001a#\u0010\r\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0082\b\u001a\u001c\u0010\u0010\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u00a8\u0006\u0013"}, d2={"startCoroutineCancellable", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "fatalCompletion", "runSafely", "block", "Lkotlin/Function0;", "dispatcherFailure", "e", "", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,65:1\n45#1,6:66\n45#1,6:72\n45#1,6:78\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n15#1:66,6\n25#1:72,6\n34#1:78,6\n*E\n"})
public final class CancellableKt {
    @InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, @NotNull Continuation<? super T> completion) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl2 = false;
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, completion)), Result.constructor-impl(Unit.INSTANCE));
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(completion, e$iv);
        }
    }

    public static final <R, T> void startCoroutineCancellable(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, R receiver, @NotNull Continuation<? super T> completion) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl2 = false;
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, receiver, completion)), Result.constructor-impl(Unit.INSTANCE));
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(completion, e$iv);
        }
    }

    public static final void startCoroutineCancellable(@NotNull Continuation<? super Unit> $this$startCoroutineCancellable, @NotNull Continuation<?> fatalCompletion) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl2 = false;
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted($this$startCoroutineCancellable), Result.constructor-impl(Unit.INSTANCE));
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(fatalCompletion, e$iv);
        }
    }

    private static final void runSafely(Continuation<?> completion, Function0<Unit> block) {
        boolean $i$f$runSafely = false;
        try {
            block.invoke();
        }
        catch (Throwable e2) {
            CancellableKt.dispatcherFailure(completion, e2);
        }
    }

    private static final void dispatcherFailure(Continuation<?> completion, Throwable e2) {
        Throwable reportException = e2 instanceof DispatchException ? ((DispatchException)e2).getCause() : e2;
        completion.resumeWith(Result.constructor-impl(ResultKt.createFailure(reportException)));
        throw reportException;
    }
}

