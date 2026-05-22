/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__FutureKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=4, xi=48, d1={"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"})
public final class JobKt {
    @Deprecated(message="This function does not do what its name implies: it will not cancel the future if just cancel() was called.", replaceWith=@ReplaceWith(expression="this.invokeOnCancellation { future.cancel(false) }", imports={}), level=DeprecationLevel.WARNING)
    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> $this$cancelFutureOnCancellation, @NotNull Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation($this$cancelFutureOnCancellation, future);
    }

    @NotNull
    public static final DisposableHandle invokeOnCompletion(@NotNull Job $this$invokeOnCompletion, boolean invokeImmediately, @NotNull JobNode handler) {
        return JobKt__JobKt.invokeOnCompletion($this$invokeOnCompletion, invokeImmediately, handler);
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean bl2, JobNode jobNode, int n2, Object object) {
        return JobKt__JobKt.invokeOnCompletion$default(job, bl2, jobNode, n2, object);
    }

    @NotNull
    public static final CompletableJob Job(@Nullable Job parent) {
        return JobKt__JobKt.Job(parent);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int n2, Object object) {
        return JobKt__JobKt.Job$default(job, n2, object);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    @JvmName(name="Job")
    public static final /* synthetic */ Job Job(Job parent) {
        return JobKt__JobKt.Job(parent);
    }

    public static /* synthetic */ Job Job$default(Job job, int n2, Object object) {
        return JobKt__JobKt.Job$default(job, n2, object);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job $this$disposeOnCompletion, @NotNull DisposableHandle handle) {
        return JobKt__JobKt.disposeOnCompletion($this$disposeOnCompletion, handle);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job $this$cancelAndJoin, @NotNull Continuation<? super Unit> $completion) {
        return JobKt__JobKt.cancelAndJoin($this$cancelAndJoin, $completion);
    }

    public static final void cancelChildren(@NotNull Job $this$cancelChildren, @Nullable CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int n2, Object object) {
        JobKt__JobKt.cancelChildren$default(job, cancellationException, n2, object);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren) {
        JobKt__JobKt.cancelChildren($this$cancelChildren);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren, Throwable cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable throwable, int n2, Object object) {
        JobKt__JobKt.cancelChildren$default(job, throwable, n2, object);
    }

    public static final boolean isActive(@NotNull CoroutineContext $this$isActive) {
        return JobKt__JobKt.isActive($this$isActive);
    }

    public static final void cancel(@NotNull CoroutineContext $this$cancel, @Nullable CancellationException cause) {
        JobKt__JobKt.cancel($this$cancel, cause);
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        JobKt__JobKt.cancel$default(coroutineContext, cancellationException, n2, object);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancel(CoroutineContext $this$cancel) {
        JobKt__JobKt.cancel($this$cancel);
    }

    public static final void ensureActive(@NotNull Job $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final void ensureActive(@NotNull CoroutineContext $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final void cancel(@NotNull Job $this$cancel, @NotNull String message, @Nullable Throwable cause) {
        JobKt__JobKt.cancel($this$cancel, message, cause);
    }

    public static /* synthetic */ void cancel$default(Job job, String string, Throwable throwable, int n2, Object object) {
        JobKt__JobKt.cancel$default(job, string, throwable, n2, object);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ boolean cancel(CoroutineContext $this$cancel, Throwable cause) {
        return JobKt__JobKt.cancel($this$cancel, cause);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        return JobKt__JobKt.cancel$default(coroutineContext, throwable, n2, object);
    }

    public static final void cancelChildren(@NotNull CoroutineContext $this$cancelChildren, @Nullable CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, cancellationException, n2, object);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren) {
        JobKt__JobKt.cancelChildren($this$cancelChildren);
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext $this$job) {
        return JobKt__JobKt.getJob($this$job);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren, Throwable cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, throwable, n2, object);
    }
}

