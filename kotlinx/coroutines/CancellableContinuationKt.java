/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCancel;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a0\u0010\u0006\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bH\u0086H\u00a2\u0006\u0002\u0010\t\u001a0\u0010\n\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000b\u0012\u0004\u0012\u00020\u00010\bH\u0080H\u00a2\u0006\u0002\u0010\t\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000eH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\u0012"}, d2={"invokeOnCancellation", "", "T", "Lkotlinx/coroutines/CancellableContinuation;", "handler", "Lkotlinx/coroutines/CancelHandler;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getOrCreateCancellableContinuation", "delegate", "Lkotlin/coroutines/Continuation;", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,498:1\n1#2:499\n*E\n"})
public final class CancellableContinuationKt {
    public static final <T> void invokeOnCancellation(@NotNull CancellableContinuation<? super T> $this$invokeOnCancellation, @NotNull CancelHandler handler) {
        if (!($this$invokeOnCancellation instanceof CancellableContinuationImpl)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((CancellableContinuationImpl)$this$invokeOnCancellation).invokeOnCancellationInternal$kotlinx_coroutines_core(handler);
    }

    @Nullable
    public static final <T> Object suspendCancellableCoroutine(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> block, @NotNull Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super T> uCont = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<T> cancellable = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(uCont), 1);
        cancellable.initCancellability();
        block.invoke(cancellable);
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    private static final <T> Object suspendCancellableCoroutine$$forInline(Function1<? super CancellableContinuation<? super T>, Unit> block, Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        InlineMarker.mark(0);
        Continuation<? super T> uCont = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<T> cancellable = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(uCont), 1);
        cancellable.initCancellability();
        block.invoke(cancellable);
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark(1);
        return object;
    }

    @Nullable
    public static final <T> Object suspendCancellableCoroutineReusable(@NotNull Function1<? super CancellableContinuationImpl<? super T>, Unit> block, @NotNull Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        Continuation<? super T> uCont = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<T> cancellable = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont));
        try {
            block.invoke(cancellable);
        }
        catch (Throwable e2) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e2;
        }
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    private static final <T> Object suspendCancellableCoroutineReusable$$forInline(Function1<? super CancellableContinuationImpl<? super T>, Unit> block, Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        InlineMarker.mark(0);
        Continuation<? super T> uCont = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<T> cancellable = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont));
        try {
            block.invoke(cancellable);
        }
        catch (Throwable e2) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e2;
        }
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark(1);
        return object;
    }

    @NotNull
    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(@NotNull Continuation<? super T> delegate) {
        CancellableContinuationImpl cancellableContinuationImpl;
        block5: {
            block4: {
                CancellableContinuationImpl cancellableContinuationImpl2;
                if (!(delegate instanceof DispatchedContinuation)) {
                    return new CancellableContinuationImpl<T>(delegate, 1);
                }
                cancellableContinuationImpl = ((DispatchedContinuation)delegate).claimReusableCancellableContinuation$kotlinx_coroutines_core();
                if (cancellableContinuationImpl == null) break block4;
                CancellableContinuationImpl it = cancellableContinuationImpl2 = cancellableContinuationImpl;
                boolean bl2 = false;
                cancellableContinuationImpl = it.resetStateReusable() ? cancellableContinuationImpl2 : null;
                if (cancellableContinuationImpl != null) break block5;
            }
            return new CancellableContinuationImpl<T>(delegate, 2);
        }
        return cancellableContinuationImpl;
    }

    @InternalCoroutinesApi
    public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> $this$disposeOnCancellation, @NotNull DisposableHandle handle) {
        CancellableContinuationKt.invokeOnCancellation($this$disposeOnCancellation, new DisposeOnCancel(handle));
    }
}

