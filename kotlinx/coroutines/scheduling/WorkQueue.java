/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\"\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eJ\u0016\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u001cH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\fJ\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0017H\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J$\u0010*\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020)H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010.\u001a\u00020'*\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0010X\u0082\u0004R\t\u0010\u0011\u001a\u00020\u0010X\u0082\u0004R\t\u0010\u0012\u001a\u00020\u0010X\u0082\u0004\u00a8\u0006/"}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "bufferSize", "", "getBufferSize", "()I", "size", "getSize$kotlinx_coroutines_core", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "Lkotlinx/atomicfu/AtomicInt;", "consumerIndex", "blockingTasksInBuffer", "poll", "add", "task", "fair", "", "addLast", "trySteal", "", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stealWithExclusiveMode", "pollBlocking", "pollCpu", "pollWithExclusiveMode", "onlyBlocking", "tryExtractFromTheMiddle", "index", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "tryStealLastScheduled", "pollTo", "queue", "pollBuffer", "decrementIfBlocking", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,251:1\n77#2:252\n77#2:253\n77#2:254\n77#2:257\n77#2:258\n1#3:255\n21#4:256\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n91#1:252\n158#1:253\n181#1:254\n201#1:257\n245#1:258\n201#1:256\n*E\n"})
public final class WorkQueue {
    @NotNull
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$volatile$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$volatile$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$volatile$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$volatile$FU;

    private final int getBufferSize() {
        return WorkQueue.producerIndex$volatile$FU.get(this) - WorkQueue.consumerIndex$volatile$FU.get(this);
    }

    public final int getSize$kotlinx_coroutines_core() {
        return WorkQueue.lastScheduledTask$volatile$FU.get(this) != null ? this.getBufferSize() + 1 : this.getBufferSize();
    }

    private final /* synthetic */ Object getLastScheduledTask$volatile() {
        return this.lastScheduledTask$volatile;
    }

    private final /* synthetic */ void setLastScheduledTask$volatile(Object value) {
        this.lastScheduledTask$volatile = value;
    }

    private final /* synthetic */ int getProducerIndex$volatile() {
        return this.producerIndex$volatile;
    }

    private final /* synthetic */ void setProducerIndex$volatile(int value) {
        this.producerIndex$volatile = value;
    }

    private final /* synthetic */ int getConsumerIndex$volatile() {
        return this.consumerIndex$volatile;
    }

    private final /* synthetic */ void setConsumerIndex$volatile(int value) {
        this.consumerIndex$volatile = value;
    }

    private final /* synthetic */ int getBlockingTasksInBuffer$volatile() {
        return this.blockingTasksInBuffer$volatile;
    }

    private final /* synthetic */ void setBlockingTasksInBuffer$volatile(int value) {
        this.blockingTasksInBuffer$volatile = value;
    }

    @Nullable
    public final Task poll() {
        Task task = WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, null);
        if (task == null) {
            task = this.pollBuffer();
        }
        return task;
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean fair) {
        if (fair) {
            return this.addLast(task);
        }
        Task task2 = WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        Task previous = task2;
        return this.addLast(previous);
    }

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return workQueue.add(task, bl2);
    }

    private final Task addLast(Task task) {
        if (this.getBufferSize() == 127) {
            return task;
        }
        Task $this$isBlocking$iv = task;
        boolean $i$f$isBlocking = false;
        if ($this$isBlocking$iv.taskContext) {
            WorkQueue.blockingTasksInBuffer$volatile$FU.incrementAndGet(this);
        }
        int nextIndex = WorkQueue.producerIndex$volatile$FU.get(this) & 0x7F;
        while (this.buffer.get(nextIndex) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(nextIndex, task);
        WorkQueue.producerIndex$volatile$FU.incrementAndGet(this);
        return null;
    }

    public final long trySteal(int stealingMode, @NotNull Ref.ObjectRef<Task> stolenTaskRef) {
        Task task;
        Task task2 = task = stealingMode == 3 ? this.pollBuffer() : this.stealWithExclusiveMode(stealingMode);
        if (task != null) {
            stolenTaskRef.element = task;
            return -1L;
        }
        return this.tryStealLastScheduled(stealingMode, stolenTaskRef);
    }

    private final Task stealWithExclusiveMode(int stealingMode) {
        boolean onlyBlocking;
        int start = WorkQueue.consumerIndex$volatile$FU.get(this);
        int end = WorkQueue.producerIndex$volatile$FU.get(this);
        boolean bl2 = onlyBlocking = stealingMode == 1;
        while (start != end) {
            if (onlyBlocking && WorkQueue.blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            Task task = this.tryExtractFromTheMiddle(start++, onlyBlocking);
            if (task == null) continue;
            return task;
        }
        return null;
    }

    @Nullable
    public final Task pollBlocking() {
        return this.pollWithExclusiveMode(true);
    }

    @Nullable
    public final Task pollCpu() {
        return this.pollWithExclusiveMode(false);
    }

    private final Task pollWithExclusiveMode(boolean onlyBlocking) {
        while ((Task)WorkQueue.lastScheduledTask$volatile$FU.get(this) != null) {
            Task lastScheduled;
            Task $this$isBlocking$iv = lastScheduled;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext != onlyBlocking) break;
            if (!WorkQueue.lastScheduledTask$volatile$FU.compareAndSet(this, lastScheduled, null)) continue;
            return lastScheduled;
        }
        int start = WorkQueue.consumerIndex$volatile$FU.get(this);
        int end = WorkQueue.producerIndex$volatile$FU.get(this);
        while (start != end) {
            Task task;
            if (onlyBlocking && WorkQueue.blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            if ((task = this.tryExtractFromTheMiddle(--end, onlyBlocking)) == null) continue;
            return task;
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int index, boolean onlyBlocking) {
        int arrayIndex = index & 0x7F;
        Task value = this.buffer.get(arrayIndex);
        if (value != null) {
            Task $this$isBlocking$iv = value;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext == onlyBlocking && this.buffer.compareAndSet(arrayIndex, value, null)) {
                if (onlyBlocking) {
                    WorkQueue.blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
                }
                return value;
            }
        }
        return null;
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        Task task = WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, null);
        if (task != null) {
            Task it = task;
            boolean bl2 = false;
            globalQueue.addLast(it);
        }
        while (this.pollTo(globalQueue)) {
        }
    }

    private final long tryStealLastScheduled(int stealingMode, Ref.ObjectRef<Task> stolenTaskRef) {
        Task lastScheduled;
        do {
            if ((Task)WorkQueue.lastScheduledTask$volatile$FU.get(this) == null) {
                return -2L;
            }
            Task $this$maskForStealingMode$iv = lastScheduled;
            boolean $i$f$getMaskForStealingMode = false;
            Task $this$isBlocking$iv$iv = $this$maskForStealingMode$iv;
            boolean $i$f$isBlocking = false;
            if ((($this$isBlocking$iv$iv.taskContext ? 1 : 2) & stealingMode) == 0) {
                return -2L;
            }
            long time = TasksKt.schedulerTimeSource.nanoTime();
            long staleness = time - lastScheduled.submissionTime;
            if (staleness >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) continue;
            return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - staleness;
        } while (!WorkQueue.lastScheduledTask$volatile$FU.compareAndSet(this, lastScheduled, null));
        stolenTaskRef.element = lastScheduled;
        return -1L;
    }

    private final boolean pollTo(GlobalQueue queue) {
        Task task = this.pollBuffer();
        if (task == null) {
            return false;
        }
        Task task2 = task;
        queue.addLast(task2);
        return true;
    }

    private final Task pollBuffer() {
        Task task;
        while (true) {
            int tailLocal;
            if ((tailLocal = WorkQueue.consumerIndex$volatile$FU.get(this)) - WorkQueue.producerIndex$volatile$FU.get(this) == 0) {
                return null;
            }
            int index = tailLocal & 0x7F;
            if (!WorkQueue.consumerIndex$volatile$FU.compareAndSet(this, tailLocal, tailLocal + 1)) continue;
            task = this.buffer.getAndSet(index, null);
            if (task != null) break;
        }
        Task value = task;
        this.decrementIfBlocking(value);
        return value;
    }

    private final void decrementIfBlocking(Task $this$decrementIfBlocking) {
        if ($this$decrementIfBlocking != null) {
            Task $this$isBlocking$iv = $this$decrementIfBlocking;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext) {
                int value = WorkQueue.blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl2 = false;
                    if (!(value >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    static {
        lastScheduledTask$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");
        producerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");
        consumerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");
        blockingTasksInBuffer$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");
    }
}

