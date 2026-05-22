/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0007H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "_job", "getJob$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "fillInStackTrace", "createCopy", "toString", "equals", "", "other", "", "hashCode", "", "kotlinx-coroutines-core"})
public final class JobCancellationException
extends CancellationException
implements CopyableThrowable<JobCancellationException> {
    @Nullable
    private final transient Job _job;

    public JobCancellationException(@NotNull String message, @Nullable Throwable cause, @NotNull Job job) {
        super(message);
        this._job = job;
        if (cause != null) {
            this.initCause(cause);
        }
    }

    @NotNull
    public final Job getJob$kotlinx_coroutines_core() {
        Job job = this._job;
        if (job == null) {
            job = NonCancellable.INSTANCE;
        }
        return job;
    }

    @Override
    @NotNull
    public Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    @Nullable
    public JobCancellationException createCopy() {
        if (DebugKt.getDEBUG()) {
            String string = this.getMessage();
            Intrinsics.checkNotNull(string);
            return new JobCancellationException(string, this, this.getJob$kotlinx_coroutines_core());
        }
        return null;
    }

    @Override
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.getJob$kotlinx_coroutines_core();
    }

    public boolean equals(@Nullable Object other) {
        return other == this || other instanceof JobCancellationException && Intrinsics.areEqual(((JobCancellationException)other).getMessage(), this.getMessage()) && Intrinsics.areEqual(((JobCancellationException)other).getJob$kotlinx_coroutines_core(), this.getJob$kotlinx_coroutines_core()) && Intrinsics.areEqual(((JobCancellationException)other).getCause(), this.getCause());
    }

    public int hashCode() {
        String string = this.getMessage();
        Intrinsics.checkNotNull(string);
        Job job = this.getJob$kotlinx_coroutines_core();
        Throwable throwable = this.getCause();
        return (string.hashCode() * 31 + (job != null ? job.hashCode() : 0)) * 31 + (throwable != null ? throwable.hashCode() : 0);
    }
}

