/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004:;<=B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0016J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00142\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0004\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0014H\u0016J\u001f\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\n\u0010\u001f\u001a\u00060 j\u0002`!\u00a2\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00182\n\u0010)\u001a\u00060 j\u0002`!H\u0016\u00a2\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020\r2\n\u0010)\u001a\u00060 j\u0002`!H\u0002\u00a2\u0006\u0002\u0010,J\u0015\u0010-\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!H\u0002\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\u0016\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\r2\u0006\u0010)\u001a\u000204H\u0002J\u0018\u00106\u001a\u0002072\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0002J\b\u00108\u001a\u00020\u0018H\u0004J\b\u00109\u001a\u00020\u0018H\u0002R\u0011\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004R\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\r8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006>"}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "_queue", "Lkotlinx/atomicfu/AtomicRef;", "", "_delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_isCompleted", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "nextTime", "", "getNextTime", "()J", "shutdown", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "scheduleInvokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "enqueue", "task", "(Ljava/lang/Runnable;)V", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "dequeue", "()Ljava/lang/Runnable;", "enqueueDelayedTasks", "closeQueue", "schedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "shouldUnpark", "scheduleImpl", "", "resetAll", "rescheduleAllDelayed", "DelayedTask", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTaskQueue", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 3 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n53#2:548\n51#3:549\n52#3,7:552\n29#4:550\n16#5:551\n1#6:559\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n263#1:548\n336#1:549\n336#1:552,7\n336#1:550\n336#1:551\n*E\n"})
public abstract class EventLoopImplBase
extends EventLoopImplPlatform
implements Delay {
    private volatile /* synthetic */ Object _queue$volatile;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$volatile$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleted$volatile$FU;

    private final /* synthetic */ Object get_queue$volatile() {
        return this._queue$volatile;
    }

    private final /* synthetic */ void set_queue$volatile(Object value) {
        this._queue$volatile = value;
    }

    private final /* synthetic */ Object get_delayed$volatile() {
        return this._delayed$volatile;
    }

    private final /* synthetic */ void set_delayed$volatile(Object value) {
        this._delayed$volatile = value;
    }

    private final /* synthetic */ int get_isCompleted$volatile() {
        return this._isCompleted$volatile;
    }

    private final /* synthetic */ void set_isCompleted$volatile(int value) {
        this._isCompleted$volatile = value;
    }

    private final boolean isCompleted() {
        return EventLoopImplBase._isCompleted$volatile$FU.get(this) == 1;
    }

    private final void setCompleted(boolean value) {
        EventLoopImplBase._isCompleted$volatile$FU.set(this, value ? 1 : 0);
    }

    @Override
    protected boolean isEmpty() {
        if (!this.isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayed = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if (delayed != null && !delayed.isEmpty()) {
            return false;
        }
        Object queue = EventLoopImplBase._queue$volatile$FU.get(this);
        return queue == null ? true : (queue instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore)queue).isEmpty() : queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p());
    }

    @Override
    protected long getNextTime() {
        Object object;
        if (super.getNextTime() == 0L) {
            return 0L;
        }
        Object queue = EventLoopImplBase._queue$volatile$FU.get(this);
        if (queue != null) {
            if (queue instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore)queue).isEmpty()) {
                    return 0L;
                }
            } else {
                if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return Long.MAX_VALUE;
                }
                return 0L;
            }
        }
        if ((object = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this)) == null || (object = (DelayedTask)((ThreadSafeHeap)object).peek()) == null) {
            return Long.MAX_VALUE;
        }
        Object nextDelayedTask = object;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
        return RangesKt.coerceAtLeast(((DelayedTask)nextDelayedTask).nanoTime - (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()), 0L);
    }

    @Override
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        while (this.processNextEvent() <= 0L) {
        }
        this.rescheduleAllDelayed();
    }

    @Override
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        long timeNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (timeNanos < 0x3FFFFFFFFFFFFFFFL) {
            DelayedResumeTask delayedResumeTask;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            DelayedResumeTask task = delayedResumeTask = new DelayedResumeTask(now + timeNanos, continuation);
            boolean bl2 = false;
            this.schedule(now, task);
            CancellableContinuationKt.disposeOnCancellation(continuation, task);
        }
    }

    @NotNull
    protected final DisposableHandle scheduleInvokeOnTimeout(long timeMillis, @NotNull Runnable block) {
        DisposableHandle disposableHandle;
        long timeNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (timeNanos < 0x3FFFFFFFFFFFFFFFL) {
            DelayedRunnableTask delayedRunnableTask;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            DelayedRunnableTask task = delayedRunnableTask = new DelayedRunnableTask(now + timeNanos, block);
            boolean bl2 = false;
            this.schedule(now, task);
            disposableHandle = delayedRunnableTask;
        } else {
            disposableHandle = NonDisposableHandle.INSTANCE;
        }
        return disposableHandle;
    }

    @Override
    public long processNextEvent() {
        if (this.processUnconfinedEvent()) {
            return 0L;
        }
        this.enqueueDelayedTasks();
        Runnable task = this.dequeue();
        if (task != null) {
            boolean $i$f$platformAutoreleasePool = false;
            boolean bl2 = false;
            task.run();
            return 0L;
        }
        return this.getNextTime();
    }

    @Override
    public final void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.enqueue(block);
    }

    public void enqueue(@NotNull Runnable task) {
        this.enqueueDelayedTasks();
        if (this.enqueueImpl(task)) {
            this.unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    private final boolean enqueueImpl(Runnable task) {
        EventLoopImplBase eventLoopImplBase = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = EventLoopImplBase._queue$volatile$FU;
        while (true) {
            Object queue = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if (this.isCompleted()) {
                return false;
            }
            Object v2 = queue;
            if (v2 == null) {
                if (!EventLoopImplBase._queue$volatile$FU.compareAndSet(this, null, task)) continue;
                return true;
            }
            if (v2 instanceof LockFreeTaskQueueCore) {
                Object v3 = queue;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                switch (((LockFreeTaskQueueCore)v3).addLast(task)) {
                    case 0: {
                        return true;
                    }
                    case 2: {
                        return false;
                    }
                    case 1: {
                        EventLoopImplBase._queue$volatile$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore)queue).next());
                    }
                }
                continue;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            }
            LockFreeTaskQueueCore<Runnable> newQueue = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(queue, "null cannot be cast to non-null type java.lang.Runnable");
            newQueue.addLast((Runnable)queue);
            newQueue.addLast(task);
            if (EventLoopImplBase._queue$volatile$FU.compareAndSet(this, queue, newQueue)) break;
        }
        return true;
    }

    private final Runnable dequeue() {
        Object queue;
        EventLoopImplBase eventLoopImplBase = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = EventLoopImplBase._queue$volatile$FU;
        while (true) {
            queue = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            Object v2 = queue;
            if (v2 == null) {
                return null;
            }
            if (v2 instanceof LockFreeTaskQueueCore) {
                Object v3 = queue;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                Object result = ((LockFreeTaskQueueCore)v3).removeFirstOrNull();
                if (result != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable)result;
                }
                EventLoopImplBase._queue$volatile$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore)queue).next());
                continue;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return null;
            }
            if (EventLoopImplBase._queue$volatile$FU.compareAndSet(this, queue, null)) break;
        }
        Intrinsics.checkNotNull(queue, "null cannot be cast to non-null type java.lang.Runnable");
        return (Runnable)queue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void enqueueDelayedTasks() {
        DelayedTaskQueue delayed = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if (delayed != null && !delayed.isEmpty()) {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            while (true) {
                Object v1;
                ThreadSafeHeap this_$iv = delayed;
                boolean $i$f$removeFirstIf = false;
                boolean $i$f$synchronized = false;
                boolean $i$f$synchronizedImpl = false;
                ThreadSafeHeap threadSafeHeap = this_$iv;
                synchronized (threadSafeHeap) {
                    Object t2;
                    block6: {
                        boolean bl2 = false;
                        if (this_$iv.firstImpl() != null) break block6;
                        Object var10_10 = null;
                        // MONITOREXIT @DISABLED, blocks:[0, 2, 4, 5] lbl18 : MonitorExitStatement: MONITOREXIT : var8_7
                        v1 = var10_10;
                    }
                    Object first$iv = t2;
                    DelayedTask it = (DelayedTask)first$iv;
                    boolean bl3 = false;
                    Object var14_14 = (it.timeToExecute(now) ? this.enqueueImpl(it) : false) ? this_$iv.removeAtImpl(0) : null;
                    // MONITOREXIT @DISABLED, blocks:[1, 2, 4, 5] lbl26 : MonitorExitStatement: MONITOREXIT : var8_7
                    v1 = var14_14;
                }
                if ((DelayedTask)v1 == null) break;
            }
        }
    }

    private final void closeQueue() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!this.isCompleted()) {
                throw new AssertionError();
            }
        }
        EventLoopImplBase bl2 = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = EventLoopImplBase._queue$volatile$FU;
        while (true) {
            Object queue = handler$atomicfu$iv.get(this);
            boolean bl3 = false;
            Object v2 = queue;
            if (v2 == null) {
                if (!EventLoopImplBase._queue$volatile$FU.compareAndSet(this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) continue;
                return;
            }
            if (v2 instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore)queue).close();
                return;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return;
            }
            LockFreeTaskQueueCore<Runnable> newQueue = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(queue, "null cannot be cast to non-null type java.lang.Runnable");
            newQueue.addLast((Runnable)queue);
            if (EventLoopImplBase._queue$volatile$FU.compareAndSet(this, queue, newQueue)) break;
        }
    }

    public final void schedule(long now, @NotNull DelayedTask delayedTask) {
        switch (this.scheduleImpl(now, delayedTask)) {
            case 0: {
                if (this.shouldUnpark(delayedTask)) {
                    this.unpark();
                }
                break;
            }
            case 1: {
                this.reschedule(now, delayedTask);
                break;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("unexpected result".toString());
            }
        }
    }

    private final boolean shouldUnpark(DelayedTask task) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        return (delayedTaskQueue != null ? (DelayedTask)delayedTaskQueue.peek() : null) == task;
    }

    private final int scheduleImpl(long now, DelayedTask delayedTask) {
        if (this.isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if (delayedTaskQueue == null) {
            EventLoopImplBase $this$scheduleImpl_u24lambda_u248 = this;
            boolean bl2 = false;
            EventLoopImplBase._delayed$volatile$FU.compareAndSet($this$scheduleImpl_u24lambda_u248, null, new DelayedTaskQueue(now));
            Object v2 = EventLoopImplBase._delayed$volatile$FU.get($this$scheduleImpl_u24lambda_u248);
            Intrinsics.checkNotNull(v2);
            delayedTaskQueue = (DelayedTaskQueue)v2;
        }
        DelayedTaskQueue delayedQueue = delayedTaskQueue;
        return delayedTask.scheduleTask(now, delayedQueue, this);
    }

    protected final void resetAll() {
        EventLoopImplBase._queue$volatile$FU.set(this, null);
        EventLoopImplBase._delayed$volatile$FU.set(this, null);
    }

    private final void rescheduleAllDelayed() {
        Object object;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
        long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
        while ((object = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this)) != null && (object = (DelayedTask)((ThreadSafeHeap)object).removeFirstOrNull()) != null) {
            Object delayedTask = object;
            this.reschedule(now, (DelayedTask)delayedTask);
        }
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return Delay.DefaultImpls.invokeOnTimeout(this, timeMillis, block, context);
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    static {
        _queue$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");
        _delayed$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");
        _isCompleted$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n1#2:548\n*E\n"})
    private final class DelayedResumeTask
    extends DelayedTask {
        @NotNull
        private final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(@NotNull long nanoTime, CancellableContinuation<? super Unit> cont) {
            super(nanoTime);
            this.cont = cont;
        }

        @Override
        public void run() {
            CancellableContinuation<Unit> cancellableContinuation = this.cont;
            EventLoopImplBase eventLoopImplBase = EventLoopImplBase.this;
            CancellableContinuation<Unit> $this$run_u24lambda_u240 = cancellableContinuation;
            boolean bl2 = false;
            $this$run_u24lambda_u240.resumeUndispatched(eventLoopImplBase, Unit.INSTANCE);
        }

        @Override
        @NotNull
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "(JLjava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", "", "toString", "", "kotlinx-coroutines-core"})
    private static final class DelayedRunnableTask
    extends DelayedTask {
        @NotNull
        private final Runnable block;

        public DelayedRunnableTask(long nanoTime, @NotNull Runnable block) {
            super(nanoTime);
            this.block = block;
        }

        @Override
        public void run() {
            this.block.run();
        }

        @Override
        @NotNull
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020'H\u0016R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006("}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "nanoTime", "", "<init>", "(J)V", "_heap", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "timeToExecute", "", "now", "scheduleTask", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,547:1\n29#2:548\n29#2:551\n29#2:560\n16#3:549\n16#3:552\n16#3:561\n63#4:550\n64#4,7:553\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n441#1:548\n443#1:551\n483#1:560\n441#1:549\n443#1:552\n483#1:561\n443#1:550\n443#1:553,7\n*E\n"})
    public static abstract class DelayedTask
    implements Runnable,
    Comparable<DelayedTask>,
    DisposableHandle,
    ThreadSafeHeapNode {
        @JvmField
        public long nanoTime;
        @Nullable
        private volatile Object _heap;
        private int index;

        public DelayedTask(long nanoTime) {
            this.nanoTime = nanoTime;
            this.index = -1;
        }

        @Override
        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object object = this._heap;
            return object instanceof ThreadSafeHeap ? (ThreadSafeHeap)object : null;
        }

        @Override
        public void setHeap(@Nullable ThreadSafeHeap<?> value) {
            if (!(this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p())) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            this._heap = value;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

        @Override
        public void setIndex(int n2) {
            this.index = n2;
        }

        @Override
        public int compareTo(@NotNull DelayedTask other) {
            long dTime = this.nanoTime - other.nanoTime;
            return dTime > 0L ? 1 : (dTime < 0L ? -1 : 0);
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0L;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final int scheduleTask(long now, @NotNull DelayedTaskQueue delayed, @NotNull EventLoopImplBase eventLoop) {
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            DelayedTask delayedTask = this;
            synchronized (delayedTask) {
                boolean bl2 = false;
                if (this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return 2;
                }
                ThreadSafeHeap this_$iv = delayed;
                boolean $i$f$addLastIf = false;
                boolean $i$f$synchronized2 = false;
                boolean $i$f$synchronizedImpl2 = false;
                ThreadSafeHeap threadSafeHeap = this_$iv;
                synchronized (threadSafeHeap) {
                    boolean bl3 = false;
                    DelayedTask firstTask = (DelayedTask)this_$iv.firstImpl();
                    boolean bl4 = false;
                    if (eventLoop.isCompleted()) {
                        return 1;
                    }
                    if (firstTask == null) {
                        delayed.timeNow = now;
                    } else {
                        long minTime;
                        long firstTime = firstTask.nanoTime;
                        long l2 = minTime = firstTime - now >= 0L ? now : firstTime;
                        if (minTime - delayed.timeNow > 0L) {
                            delayed.timeNow = minTime;
                        }
                    }
                    if (this.nanoTime - delayed.timeNow < 0L) {
                        this.nanoTime = delayed.timeNow;
                    }
                    this_$iv.addImpl((ThreadSafeHeapNode)this);
                    return 0;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public final void dispose() {
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            DelayedTask delayedTask = this;
            synchronized (delayedTask) {
                boolean bl2 = false;
                Object heap = this._heap;
                if (heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return;
                }
                DelayedTaskQueue delayedTaskQueue = heap instanceof DelayedTaskQueue ? (DelayedTaskQueue)heap : null;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove((ThreadSafeHeapNode)this);
                }
                this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                Unit unit = Unit.INSTANCE;
            }
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "<init>", "(J)V", "kotlinx-coroutines-core"})
    public static final class DelayedTaskQueue
    extends ThreadSafeHeap<DelayedTask> {
        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long timeNow) {
            this.timeNow = timeNow;
        }
    }
}

