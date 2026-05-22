/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCompletion;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0019\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0002\b\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0086@\u00a2\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u00a2\u0006\u0002\u0010\u0014\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0002H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0019\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u00a2\u0006\u0002\u0010\u001a\u001a\f\u0010\u0019\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015\u001a\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u00a2\u0006\u0002\u0010\u001a\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a\u001b\u0010!\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\b\"\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018\"\u0015\u0010\u001e\u001a\u00020\u0002*\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2={"invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "invokeImmediately", "", "handler", "Lkotlinx/coroutines/JobNode;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "disposeOnCompletion", "handle", "cancelAndJoin", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "", "isActive", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "cancel", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "message", "", "job", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/JobKt")
@SourceDebugExtension(value={"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,692:1\n1317#2,2:693\n1317#2,2:695\n1317#2,2:697\n1317#2,2:699\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n520#1:693,2\n534#1:695,2\n628#1:697,2\n652#1:699,2\n*E\n"})
final class JobKt__JobKt {
    @NotNull
    public static final DisposableHandle invokeOnCompletion(@NotNull Job $this$invokeOnCompletion, boolean invokeImmediately, @NotNull JobNode handler) {
        return $this$invokeOnCompletion instanceof JobSupport ? ((JobSupport)$this$invokeOnCompletion).invokeOnCompletionInternal$kotlinx_coroutines_core(invokeImmediately, handler) : $this$invokeOnCompletion.invokeOnCompletion(handler.getOnCancelling(), invokeImmediately, (Function1<? super Throwable, Unit>)new Function1<Throwable, Unit>((Object)handler){

            public final void invoke(Throwable p0) {
                ((JobNode)this.receiver).invoke(p0);
            }
        });
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean bl2, JobNode jobNode, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        return JobKt.invokeOnCompletion(job, bl2, jobNode);
    }

    @NotNull
    public static final CompletableJob Job(@Nullable Job parent) {
        return new JobImpl(parent);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int n2, Object object) {
        if ((n2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    @JvmName(name="Job")
    public static final /* synthetic */ Job Job(Job parent) {
        return JobKt.Job(parent);
    }

    public static /* synthetic */ Job Job$default(Job job, int n2, Object object) {
        if ((n2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job $this$disposeOnCompletion, @NotNull DisposableHandle handle) {
        return JobKt.invokeOnCompletion$default($this$disposeOnCompletion, false, new DisposeOnCompletion(handle), 1, null);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job $this$cancelAndJoin, @NotNull Continuation<? super Unit> $completion) {
        Job.DefaultImpls.cancel$default($this$cancelAndJoin, null, 1, null);
        Object object = $this$cancelAndJoin.join($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final void cancelChildren(@NotNull Job $this$cancelChildren, @Nullable CancellationException cause) {
        Sequence<Job> $this$forEach$iv = $this$cancelChildren.getChildren();
        boolean $i$f$forEach = false;
        Iterator<Job> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Job element$iv;
            Job it = element$iv = iterator2.next();
            boolean bl2 = false;
            it.cancel(cause);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, null);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren, Throwable cause) {
        Sequence<Job> $this$forEach$iv = $this$cancelChildren.getChildren();
        boolean $i$f$forEach = false;
        Iterator<Job> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Job element$iv;
            Job it = element$iv = iterator2.next();
            boolean bl2 = false;
            JobSupport jobSupport = it instanceof JobSupport ? (JobSupport)it : null;
            if (jobSupport == null) continue;
            jobSupport.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, $this$cancelChildren));
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(job, throwable);
    }

    public static final boolean isActive(@NotNull CoroutineContext $this$isActive) {
        Job job = (Job)$this$isActive.get(Job.Key);
        return job != null ? job.isActive() : true;
    }

    public static final void cancel(@NotNull CoroutineContext $this$cancel, @Nullable CancellationException cause) {
        block0: {
            Job job = (Job)$this$cancel.get(Job.Key);
            if (job == null) break block0;
            job.cancel(cause);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancel(CoroutineContext $this$cancel) {
        JobKt.cancel($this$cancel, null);
    }

    public static final void ensureActive(@NotNull Job $this$ensureActive) {
        if (!$this$ensureActive.isActive()) {
            throw $this$ensureActive.getCancellationException();
        }
    }

    public static final void ensureActive(@NotNull CoroutineContext $this$ensureActive) {
        block0: {
            Job job = (Job)$this$ensureActive.get(Job.Key);
            if (job == null) break block0;
            JobKt.ensureActive(job);
        }
    }

    public static final void cancel(@NotNull Job $this$cancel, @NotNull String message, @Nullable Throwable cause) {
        $this$cancel.cancel(ExceptionsKt.CancellationException(message, cause));
    }

    public static /* synthetic */ void cancel$default(Job job, String string, Throwable throwable, int n2, Object object) {
        if ((n2 & 2) != 0) {
            throwable = null;
        }
        JobKt.cancel(job, string, throwable);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ boolean cancel(CoroutineContext $this$cancel, Throwable cause) {
        Object e2 = $this$cancel.get(Job.Key);
        JobSupport jobSupport = e2 instanceof JobSupport ? (JobSupport)e2 : null;
        if (jobSupport == null) {
            return false;
        }
        JobSupport job = jobSupport;
        job.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, job));
        return true;
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        return JobKt.cancel(coroutineContext, throwable);
    }

    public static final void cancelChildren(@NotNull CoroutineContext $this$cancelChildren, @Nullable CancellationException cause) {
        block1: {
            Object object = (Job)$this$cancelChildren.get(Job.Key);
            if (object == null || (object = object.getChildren()) == null) break block1;
            Object $this$forEach$iv = object;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv = iterator2.next();
                Job it = (Job)element$iv;
                boolean bl2 = false;
                it.cancel(cause);
            }
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, null);
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext $this$job) {
        Job job = (Job)$this$job.get(Job.Key);
        if (job == null) {
            throw new IllegalStateException(("Current context doesn't contain Job in it: " + $this$job).toString());
        }
        return job;
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren, Throwable cause) {
        Job job = (Job)$this$cancelChildren.get(Job.Key);
        if (job == null) {
            return;
        }
        Job job2 = job;
        Sequence<Job> $this$forEach$iv = job2.getChildren();
        boolean $i$f$forEach = false;
        Iterator<Job> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Job element$iv;
            Job it = element$iv = iterator2.next();
            boolean bl2 = false;
            JobSupport jobSupport = it instanceof JobSupport ? (JobSupport)it : null;
            if (jobSupport == null) continue;
            jobSupport.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, job2));
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(coroutineContext, throwable);
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable $this$orCancellation, Job job) {
        Throwable throwable = $this$orCancellation;
        if (throwable == null) {
            throwable = new JobCancellationException("Job was cancelled", null, job);
        }
        return throwable;
    }
}

