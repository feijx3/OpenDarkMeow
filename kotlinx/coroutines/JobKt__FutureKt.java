/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.PublicCancelFutureOnCancel;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u00a8\u0006\u0005"}, d2={"cancelFutureOnCancellation", "", "Lkotlinx/coroutines/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/JobKt")
final class JobKt__FutureKt {
    @Deprecated(message="This function does not do what its name implies: it will not cancel the future if just cancel() was called.", replaceWith=@ReplaceWith(expression="this.invokeOnCancellation { future.cancel(false) }", imports={}), level=DeprecationLevel.WARNING)
    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> $this$cancelFutureOnCancellation, @NotNull Future<?> future) {
        CancellableContinuationKt.invokeOnCancellation($this$cancelFutureOnCancellation, new PublicCancelFutureOnCancel(future));
    }
}

