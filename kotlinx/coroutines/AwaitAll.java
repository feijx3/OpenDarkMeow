/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000e\u000fB\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0086@\u00a2\u0006\u0002\u0010\rR\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\t\u0010\t\u001a\u00020\nX\u0082\u0004\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DisposeHandlersOnCancel", "AwaitAllNode", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,121:1\n426#2,9:122\n435#2,2:133\n13402#3,2:131\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n63#1:122,9\n63#1:133,2\n75#1:131,2\n*E\n"})
final class AwaitAll<T> {
    @NotNull
    private final Deferred<T>[] deferreds;
    private volatile /* synthetic */ int notCompletedCount$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater notCompletedCount$volatile$FU;

    public AwaitAll(@NotNull Deferred<? extends T>[] deferreds) {
        this.deferreds = deferreds;
        this.notCompletedCount$volatile = this.deferreds.length;
    }

    private final /* synthetic */ int getNotCompletedCount$volatile() {
        return this.notCompletedCount$volatile;
    }

    private final /* synthetic */ void setNotCompletedCount$volatile(int value) {
        this.notCompletedCount$volatile = value;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Object await(@NotNull Continuation<? super List<? extends T>> $completion) {
        int n2;
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super List<? extends T>> uCont$iv = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<List<T>> cancellable$iv = new CancellableContinuationImpl<List<T>>(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl3 = false;
        int n3 = 0;
        int n4 = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArray = new AwaitAllNode[n4];
        while (n3 < n4) {
            void $this$await_u24lambda_u242_u24lambda_u240;
            AwaitAllNode awaitAllNode;
            n2 = n3++;
            Deferred deferred = this.deferreds[n2];
            deferred.start();
            AwaitAllNode awaitAllNode2 = awaitAllNode = new AwaitAllNode(cont);
            int n5 = n2;
            AwaitAllNode[] awaitAllNodeArray2 = awaitAllNodeArray;
            boolean bl4 = false;
            $this$await_u24lambda_u242_u24lambda_u240.setHandle(JobKt.invokeOnCompletion$default(deferred, false, (JobNode)$this$await_u24lambda_u242_u24lambda_u240, 1, null));
            Unit unit = Unit.INSTANCE;
            awaitAllNodeArray2[n5] = awaitAllNode;
        }
        AwaitAllNode[] nodes = awaitAllNodeArray;
        DisposeHandlersOnCancel disposer = new DisposeHandlersOnCancel(nodes);
        AwaitAllNode[] $this$forEach$iv = nodes;
        boolean $i$f$forEach = false;
        int n6 = $this$forEach$iv.length;
        for (n2 = 0; n2 < n6; ++n2) {
            AwaitAllNode element$iv;
            AwaitAllNode it = element$iv = $this$forEach$iv[n2];
            boolean bl5 = false;
            it.setDisposer(disposer);
        }
        if (cont.isCompleted()) {
            disposer.disposeAll();
        } else {
            CancellableContinuationKt.invokeOnCancellation(cont, disposer);
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    static {
        notCompletedCount$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00100\u000eX\u0082\u0004R<\u0010\u0012\u001a\u000e\u0018\u00010\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00102\u0012\u0010\u0011\u001a\u000e\u0018\u00010\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "_disposer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "disposer", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,121:1\n11158#2:122\n11493#2,3:123\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n115#1:122\n115#1:123,3\n*E\n"})
    private final class AwaitAllNode
    extends JobNode {
        @NotNull
        private final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;
        private volatile /* synthetic */ Object _disposer$volatile;
        private static final /* synthetic */ AtomicReferenceFieldUpdater _disposer$volatile$FU;

        public AwaitAllNode(CancellableContinuation<? super List<? extends T>> continuation) {
            this.continuation = continuation;
        }

        @NotNull
        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        public final void setHandle(@NotNull DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }

        private final /* synthetic */ Object get_disposer$volatile() {
            return this._disposer$volatile;
        }

        private final /* synthetic */ void set_disposer$volatile(Object value) {
            this._disposer$volatile = value;
        }

        @Nullable
        public final DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel)AwaitAllNode._disposer$volatile$FU.get(this);
        }

        public final void setDisposer(@Nullable DisposeHandlersOnCancel value) {
            AwaitAllNode._disposer$volatile$FU.set(this, value);
        }

        @Override
        public boolean getOnCancelling() {
            return false;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void invoke(@Nullable Throwable cause) {
            if (cause != null) {
                Object token = this.continuation.tryResumeWithException(cause);
                if (token != null) {
                    this.continuation.completeResume(token);
                    DisposeHandlersOnCancel disposeHandlersOnCancel = this.getDisposer();
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                    }
                }
            } else if (AwaitAll.notCompletedCount$volatile$FU.decrementAndGet(AwaitAll.this) == 0) {
                void $this$mapTo$iv$iv;
                Continuation continuation = this.continuation;
                Deferred[] $this$map$iv = AwaitAll.this.deferreds;
                boolean $i$f$map = false;
                Deferred[] deferredArray = $this$map$iv;
                Collection destination$iv$iv = new ArrayList($this$map$iv.length);
                boolean $i$f$mapTo = false;
                int n2 = ((void)$this$mapTo$iv$iv).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void it;
                    void item$iv$iv;
                    void var11_12 = item$iv$iv = $this$mapTo$iv$iv[i2];
                    Collection collection = destination$iv$iv;
                    boolean bl2 = false;
                    collection.add(it.getCompleted());
                }
                List list = (List)destination$iv$iv;
                continuation.resumeWith(Result.constructor-impl(list));
            }
        }

        static {
            _disposer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer$volatile");
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,121:1\n13402#2,2:122\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n88#1:122,2\n*E\n"})
    private final class DisposeHandlersOnCancel
    implements CancelHandler {
        @NotNull
        private final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAllNode[] nodes) {
            this.nodes = nodes;
        }

        public final void disposeAll() {
            AwaitAllNode[] $this$forEach$iv = this.nodes;
            boolean $i$f$forEach = false;
            int n2 = $this$forEach$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                AwaitAllNode element$iv;
                AwaitAllNode it = element$iv = $this$forEach$iv[i2];
                boolean bl2 = false;
                it.getHandle().dispose();
            }
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.disposeAll();
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }
}

