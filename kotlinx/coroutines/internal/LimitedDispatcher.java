/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.LockFreeTaskQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u000ej\u0002`\u000fH\u0016\u00a2\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u000ej\u0002`\u000fH\u0017\u00a2\u0006\u0002\u0010\u001aJ2\u0010\u001c\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001eH\u0082\b\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0002J\u0015\u0010#\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0002\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0007H\u0016J\u0016\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0097A\u00a2\u0006\u0002\u0010)J*\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020(2\n\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001\u00a2\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\u00162\u0006\u0010,\u001a\u00020(2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001600H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R\u0018\u0010\f\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013\u00a8\u00062"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "name", "", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;ILjava/lang/String;)V", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Ljava/lang/Object;", "limitedParallelism", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "(Ljava/lang/Runnable;Lkotlin/jvm/functions/Function1;)V", "tryAllocateWorker", "", "obtainTaskOrDeallocateWorker", "()Ljava/lang/Runnable;", "toString", "delay", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Worker", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,154:1\n62#1,18:155\n62#1,18:173\n29#2:191\n29#2:193\n16#3:192\n16#3:194\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n44#1:155,18\n51#1:173,18\n85#1:191\n98#1:193\n85#1:192\n98#1:194\n*E\n"})
public final class LimitedDispatcher
extends CoroutineDispatcher
implements Delay {
    private final /* synthetic */ Delay $$delegate_0;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    @Nullable
    private final String name;
    private volatile /* synthetic */ int runningWorkers$volatile;
    @NotNull
    private final LockFreeTaskQueue<Runnable> queue;
    @NotNull
    private final Object workerAllocationLock;
    private static final /* synthetic */ AtomicIntegerFieldUpdater runningWorkers$volatile$FU;

    public LimitedDispatcher(@NotNull CoroutineDispatcher dispatcher, int parallelism, @Nullable String name) {
        Delay delay = dispatcher instanceof Delay ? (Delay)((Object)dispatcher) : null;
        if (delay == null) {
            delay = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = delay;
        this.dispatcher = dispatcher;
        this.parallelism = parallelism;
        this.name = name;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    private final /* synthetic */ int getRunningWorkers$volatile() {
        return this.runningWorkers$volatile;
    }

    private final /* synthetic */ void setRunningWorkers$volatile(int value) {
        this.runningWorkers$volatile = value;
    }

    @Override
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism, @Nullable String name) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= this.parallelism) {
            return LimitedDispatcherKt.namedOrThis(this, name);
        }
        return super.limitedParallelism(parallelism, name);
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        LimitedDispatcher this_$iv = this;
        boolean $i$f$dispatchInternal = false;
        this_$iv.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$volatile$FU.get(this_$iv) < this_$iv.parallelism && this_$iv.tryAllocateWorker()) {
            Runnable runnable = this_$iv.obtainTaskOrDeallocateWorker();
            if (runnable != null) {
                Runnable task$iv = runnable;
                try {
                    Worker worker = this_$iv.new Worker(task$iv);
                    boolean bl2 = false;
                    DispatchedContinuationKt.safeDispatch(this.dispatcher, this, worker);
                }
                catch (Throwable e$iv) {
                    LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this_$iv);
                    throw e$iv;
                }
            }
        }
    }

    @Override
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        LimitedDispatcher this_$iv = this;
        boolean $i$f$dispatchInternal = false;
        this_$iv.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$volatile$FU.get(this_$iv) < this_$iv.parallelism && this_$iv.tryAllocateWorker()) {
            Runnable runnable = this_$iv.obtainTaskOrDeallocateWorker();
            if (runnable != null) {
                Runnable task$iv = runnable;
                try {
                    Worker worker = this_$iv.new Worker(task$iv);
                    boolean bl2 = false;
                    this.dispatcher.dispatchYield(this, worker);
                }
                catch (Throwable e$iv) {
                    LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this_$iv);
                    throw e$iv;
                }
            }
        }
    }

    private final void dispatchInternal(Runnable block, Function1<? super Worker, Unit> startWorker) {
        boolean $i$f$dispatchInternal = false;
        this.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$volatile$FU.get(this) >= this.parallelism) {
            return;
        }
        if (!this.tryAllocateWorker()) {
            return;
        }
        Runnable runnable = this.obtainTaskOrDeallocateWorker();
        if (runnable == null) {
            return;
        }
        Runnable task = runnable;
        try {
            startWorker.invoke(new Worker(task));
        }
        catch (Throwable e2) {
            LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this);
            throw e2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final boolean tryAllocateWorker() {
        Object lock$iv = this.workerAllocationLock;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Object object = lock$iv;
        synchronized (object) {
            block4: {
                boolean bl2 = false;
                if (LimitedDispatcher.runningWorkers$volatile$FU.get(this) < this.parallelism) break block4;
                boolean bl3 = false;
                return bl3;
            }
            LimitedDispatcher.runningWorkers$volatile$FU.incrementAndGet(this);
            boolean bl4 = true;
            return bl4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Runnable obtainTaskOrDeallocateWorker() {
        Runnable nextTask;
        while ((nextTask = this.queue.removeFirstOrNull()) == null) {
            Object lock$iv = this.workerAllocationLock;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            Object object = lock$iv;
            synchronized (object) {
                block5: {
                    boolean bl2 = false;
                    LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this);
                    if (this.queue.getSize() != 0) break block5;
                    Runnable runnable = null;
                    return runnable;
                }
                int n2 = LimitedDispatcher.runningWorkers$volatile$FU.incrementAndGet(this);
            }
        }
        return nextTask;
    }

    @Override
    @NotNull
    public String toString() {
        String string = this.name;
        if (string == null) {
            string = this.dispatcher + ".limitedParallelism(" + this.parallelism + ')';
        }
        return string;
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return this.$$delegate_0.delay(time, $completion);
    }

    @Override
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        this.$$delegate_0.scheduleResumeAfterDelay(timeMillis, continuation);
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.$$delegate_0.invokeOnTimeout(timeMillis, block, context);
    }

    static {
        runningWorkers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "<init>", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher$Worker\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,154:1\n29#2:155\n16#3:156\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher$Worker\n*L\n139#1:155\n139#1:156\n*E\n"})
    private final class Worker
    implements Runnable {
        @NotNull
        private Runnable currentTask;

        public Worker(Runnable currentTask) {
            this.currentTask = currentTask;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        @Override
        public void run() {
            try {
                int fairnessCounter = 0;
                do {
                    try {
                        this.currentTask.run();
                    }
                    catch (Throwable e2) {
                        CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, e2);
                    }
                    if (LimitedDispatcher.this.obtainTaskOrDeallocateWorker() == null) {
                        return;
                    }
                    this.currentTask = this.currentTask;
                } while (++fairnessCounter < 16 || !DispatchedContinuationKt.safeIsDispatchNeeded(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this));
                DispatchedContinuationKt.safeDispatch(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this, this);
                return;
            }
            catch (Throwable e3) {
                void lock$iv;
                Object e2 = LimitedDispatcher.this.workerAllocationLock;
                LimitedDispatcher limitedDispatcher = LimitedDispatcher.this;
                boolean $i$f$synchronized = false;
                boolean $i$f$synchronizedImpl = false;
                void var6_8 = lock$iv;
                synchronized (var6_8) {
                    boolean bl2 = false;
                    int n2 = LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(limitedDispatcher);
                }
                throw e3;
            }
        }
    }
}

