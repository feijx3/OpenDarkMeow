/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.SubclassOptInRequired
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  kotlinx.coroutines.InternalForInheritanceCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.InternalForInheritanceCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 /2\u00020\u0001:\u0001/J\u0011\u0010\f\u001a\u00060\rj\u0002`\u000eH'\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\bH&J\u001f\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH&\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\u0014\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0015H'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH'J\u000e\u0010\u001e\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u001fJ1\u0010$\u001a\u00020%2'\u0010&\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120'j\u0002`*H&JE\u0010$\u001a\u00020%2\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\b2'\u0010&\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120'j\u0002`*H'J\u0011\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0000H\u0097\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00008&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0012\u0010\u000b\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010 \u001a\u00020!X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u00060"}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", "", "()Z", "isCompleted", "isCancelled", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "start", "cancel", "", "cause", "(Ljava/util/concurrent/CancellationException;)V", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "plus", "other", "Key", "kotlinx-coroutines-core"})
@SubclassOptInRequired(markerClass={InternalForInheritanceCoroutinesApi.class})
public interface Job
extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = kotlinx.coroutines.Job$Key.$$INSTANCE;

    @Nullable
    public Job getParent();

    public boolean isActive();

    public boolean isCompleted();

    public boolean isCancelled();

    @InternalCoroutinesApi
    @NotNull
    public CancellationException getCancellationException();

    public boolean start();

    public void cancel(@Nullable CancellationException var1);

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel();

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable var1);

    @NotNull
    public Sequence<Job> getChildren();

    @InternalCoroutinesApi
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob var1);

    @Nullable
    public Object join(@NotNull Continuation<? super Unit> var1);

    @NotNull
    public SelectClause0 getOnJoin();

    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> var1);

    @InternalCoroutinesApi
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean var1, boolean var2, @NotNull Function1<? super Throwable, Unit> var3);

    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job var1);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }

        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(Job $this) {
            $this.cancel(null);
        }

        public static /* synthetic */ boolean cancel$default(Job job, Throwable throwable, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                throwable = null;
            }
            return job.cancel(throwable);
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean bl2, boolean bl3, Function1 function1, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((n2 & 1) != 0) {
                bl2 = false;
            }
            if ((n2 & 2) != 0) {
                bl3 = true;
            }
            return job.invokeOnCompletion(bl2, bl3, function1);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static Job plus(@NotNull Job $this, @NotNull Job other) {
            return other;
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull Job $this, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get($this, key);
        }

        public static <R> R fold(@NotNull Job $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull Job $this, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey($this, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull Job $this, @NotNull CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus($this, context);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Key $$INSTANCE;

        private Key() {
        }

        static {
            $$INSTANCE = new Key();
        }
    }
}

