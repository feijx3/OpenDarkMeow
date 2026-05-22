/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ParentJob;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="This is internal API and may be removed in the future releases", level=DeprecationLevel.ERROR)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'\u00a8\u0006\u0006"}, d2={"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "parentCancelled", "", "parentJob", "Lkotlinx/coroutines/ParentJob;", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
public interface ChildJob
extends Job {
    @InternalCoroutinesApi
    public void parentCancelled(@NotNull ParentJob var1);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(ChildJob $this) {
            Job.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static Job plus(@NotNull ChildJob $this, @NotNull Job other) {
            return Job.DefaultImpls.plus((Job)$this, other);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull ChildJob $this, @NotNull CoroutineContext context) {
            return Job.DefaultImpls.plus((Job)$this, context);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull ChildJob $this, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get($this, key);
        }

        public static <R> R fold(@NotNull ChildJob $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Job.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull ChildJob $this, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey($this, key);
        }
    }
}

