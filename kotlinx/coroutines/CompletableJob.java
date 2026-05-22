/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.SubclassOptInRequired
 *  kotlinx.coroutines.InternalForInheritanceCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalForInheritanceCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "complete", "", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"})
@SubclassOptInRequired(markerClass={InternalForInheritanceCoroutinesApi.class})
public interface CompletableJob
extends Job {
    public boolean complete();

    public boolean completeExceptionally(@NotNull Throwable var1);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(CompletableJob $this) {
            Job.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static Job plus(@NotNull CompletableJob $this, @NotNull Job other) {
            return Job.DefaultImpls.plus((Job)$this, other);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CompletableJob $this, @NotNull CoroutineContext context) {
            return Job.DefaultImpls.plus((Job)$this, context);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CompletableJob $this, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get($this, key);
        }

        public static <R> R fold(@NotNull CompletableJob $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Job.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CompletableJob $this, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey($this, key);
        }
    }
}

