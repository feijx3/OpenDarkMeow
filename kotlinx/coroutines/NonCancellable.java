/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\fH\u0017J\u000e\u0010\u0014\u001a\u00020\u0015H\u0097@\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0017\u00a2\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u00020!2'\u0010\"\u001a#\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017JA\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2'\u0010\"\u001a#\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017J\u001d\u0010+\u001a\u00020\u00152\u000e\u0010'\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0017\u00a2\u0006\u0002\u0010,J\u0012\u0010+\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010$H\u0017J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000b\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\f8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\f8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u00188VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001bR \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020.8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010\u0004\u001a\u0004\b0\u00101\u00a8\u00067"}, d2={"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "message", "", "parent", "getParent$annotations", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", "", "isActive$annotations", "()Z", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "start", "join", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "children", "Lkotlin/sequences/Sequence;", "getChildren$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "toString", "kotlinx-coroutines-core"})
public final class NonCancellable
extends AbstractCoroutineContextElement
implements Job {
    @NotNull
    public static final NonCancellable INSTANCE = new NonCancellable();
    @NotNull
    private static final String message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private NonCancellable() {
        super(Job.Key);
    }

    @Override
    @Nullable
    public Job getParent() {
        return null;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getParent$annotations() {
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isActive$annotations() {
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public boolean start() {
        return false;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @Nullable
    public Object join(@NotNull Continuation<? super Unit> $completion) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override
    @NotNull
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getOnJoin$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public void cancel(@Nullable CancellationException cause) {
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable cause) {
        return false;
    }

    @Override
    @NotNull
    public Sequence<Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getChildren$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override
    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job other) {
        return Job.DefaultImpls.plus((Job)this, other);
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }
}

