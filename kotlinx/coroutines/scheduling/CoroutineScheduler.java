/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TasksKt;
import kotlinx.coroutines.scheduling.WorkQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0012\u0010\u001b\u001a\u00020\u00102\n\u0010\u0017\u001a\u00060\u0018R\u00020\u0000J\u000e\u0010\u001c\u001a\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\u0014\u0010\u001d\u001a\u00020\u00042\n\u0010\u0017\u001a\u00060\u0018R\u00020\u0000H\u0002J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0082\bJ\u0011\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0082\bJ\u0011\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0086\bJ\t\u0010(\u001a\u00020\u0004H\u0082\bJ\t\u0010)\u001a\u00020\u0004H\u0082\bJ\t\u0010*\u001a\u00020\u0007H\u0082\bJ\t\u0010+\u001a\u00020\u0016H\u0082\bJ\t\u0010,\u001a\u00020\u0010H\u0082\bJ\t\u0010-\u001a\u00020\u0007H\u0082\bJ\u0014\u00102\u001a\u00020\u00162\n\u00103\u001a\u000604j\u0002`5H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\u000e\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0007J*\u00109\u001a\u00020\u00162\n\u0010:\u001a\u000604j\u0002`52\f\b\u0002\u0010;\u001a\u00060\u0010j\u0002`<2\b\b\u0002\u0010=\u001a\u00020\u0010J\u001e\u0010>\u001a\u00020\u00122\n\u0010:\u001a\u000604j\u0002`52\n\u0010;\u001a\u00060\u0010j\u0002`<J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0006\u0010A\u001a\u00020\u0016J\u0012\u0010B\u001a\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0010H\u0002J\b\u0010D\u001a\u00020\u0004H\u0002J$\u0010E\u001a\u0004\u0018\u00010\u0012*\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0010H\u0002J\u000e\u0010F\u001a\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\b\u0010G\u001a\u00020\tH\u0016J\u000e\u0010H\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\u0013\u001a\u00020\u0014X\u0082\u0004R\u001a\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010 \u001a\u00020\u0014X\u0082\u0004R\u0015\u0010!\u001a\u00020\u00048\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u00020\u00048\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#R\t\u0010.\u001a\u00020/X\u0082\u0004R\u0011\u00100\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u0006L"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "<init>", "(IIJLjava/lang/String;)V", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "addToGlobalQueue", "", "task", "Lkotlinx/coroutines/scheduling/Task;", "parkedWorkersStack", "Lkotlinx/atomicfu/AtomicLong;", "parkedWorkersStackTopUpdate", "", "worker", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "oldIndex", "newIndex", "parkedWorkersStackPush", "parkedWorkersStackPop", "parkedWorkersStackNextIndex", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "controlState", "createdWorkers", "getCreatedWorkers", "()I", "availableCpuPermits", "getAvailableCpuPermits", "state", "blockingTasks", "incrementCreatedWorkers", "decrementCreatedWorkers", "incrementBlockingTasks", "decrementBlockingTasks", "tryAcquireCpuPermit", "releaseCpuPermit", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "isTerminated", "()Z", "execute", "command", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "close", "shutdown", "timeout", "dispatch", "block", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "createTask", "signalBlockingWork", "stateSnapshot", "signalCpuWork", "tryCreateWorker", "tryUnpark", "createNewWorker", "submitToLocalQueue", "currentWorker", "toString", "runSafely", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1041:1\n286#1:1044\n284#1:1045\n284#1:1046\n286#1:1047\n281#1:1050\n282#1,5:1051\n292#1:1057\n284#1:1058\n285#1:1059\n284#1:1062\n285#1:1063\n281#1:1064\n289#1:1065\n284#1:1066\n284#1:1069\n285#1:1070\n286#1:1071\n77#2:1042\n77#2:1056\n77#2:1067\n1#3:1043\n29#4:1048\n29#4:1060\n16#5:1049\n16#5:1061\n619#6:1068\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n282#1:1044\n289#1:1045\n290#1:1046\n299#1:1047\n348#1:1050\n377#1:1051,5\n400#1:1057\n444#1:1058\n445#1:1059\n481#1:1062\n482#1:1063\n488#1:1064\n497#1:1065\n497#1:1066\n578#1:1069\n579#1:1070\n580#1:1071\n120#1:1042\n397#1:1056\n514#1:1067\n348#1:1048\n477#1:1060\n348#1:1049\n477#1:1061\n521#1:1068\n*E\n"})
public final class CoroutineScheduler
implements Executor,
Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    public final int corePoolSize;
    @JvmField
    public final int maxPoolSize;
    @JvmField
    public final long idleWorkerKeepAliveNs;
    @JvmField
    @NotNull
    public final String schedulerName;
    @JvmField
    @NotNull
    public final GlobalQueue globalCpuQueue;
    @JvmField
    @NotNull
    public final GlobalQueue globalBlockingQueue;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    @JvmField
    @NotNull
    public final ResizableAtomicArray<Worker> workers;
    private volatile /* synthetic */ long controlState$volatile;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU;
    @JvmField
    @NotNull
    public static final Symbol NOT_IN_STACK;
    private static final int PARKED = -1;
    private static final int CLAIMED = 0;
    private static final int TERMINATED = 1;
    private static final int BLOCKING_SHIFT = 21;
    private static final long CREATED_MASK = 0x1FFFFFL;
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final int MAX_SUPPORTED_POOL_SIZE = 0x1FFFFE;
    private static final long PARKED_INDEX_MASK = 0x1FFFFFL;
    private static final long PARKED_VERSION_MASK = -2097152L;
    private static final long PARKED_VERSION_INC = 0x200000L;

    public CoroutineScheduler(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, @NotNull String schedulerName) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = schedulerName;
        if (!(this.corePoolSize >= 1)) {
            boolean $i$a$-require-CoroutineScheduler$52 = false;
            String $i$a$-require-CoroutineScheduler$52 = "Core pool size " + this.corePoolSize + " should be at least 1";
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$52.toString());
        }
        if (!(this.maxPoolSize >= this.corePoolSize)) {
            boolean $i$a$-require-CoroutineScheduler$62 = false;
            String $i$a$-require-CoroutineScheduler$62 = "Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize;
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$62.toString());
        }
        if (!(this.maxPoolSize <= 0x1FFFFE)) {
            boolean $i$a$-require-CoroutineScheduler$72 = false;
            String $i$a$-require-CoroutineScheduler$72 = "Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150";
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$72.toString());
        }
        if (!(this.idleWorkerKeepAliveNs > 0L)) {
            boolean bl2 = false;
            String string = "Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive";
            throw new IllegalArgumentException(string.toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((this.corePoolSize + 1) * 2);
        this.controlState$volatile = (long)this.corePoolSize << 42;
    }

    public /* synthetic */ CoroutineScheduler(int n2, int n3, long l2, String string, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            l2 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((n4 & 8) != 0) {
            string = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(n2, n3, l2, string);
    }

    private final boolean addToGlobalQueue(Task task) {
        Task $this$isBlocking$iv = task;
        boolean $i$f$isBlocking = false;
        return $this$isBlocking$iv.taskContext ? this.globalBlockingQueue.addLast(task) : this.globalCpuQueue.addLast(task);
    }

    private final /* synthetic */ long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private final /* synthetic */ void setParkedWorkersStack$volatile(long value) {
        this.parkedWorkersStack$volatile = value;
    }

    public final void parkedWorkersStackTopUpdate(@NotNull Worker worker, int oldIndex, int newIndex) {
        long updVersion;
        long top;
        int n2;
        int updIndex;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            top = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int index = (int)(top & 0x1FFFFFL);
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
            if (index == oldIndex) {
                if (newIndex == 0) {
                    n2 = this.parkedWorkersStackNextIndex(worker);
                    continue;
                }
                n2 = newIndex;
                continue;
            }
            n2 = index;
        } while ((updIndex = n2) < 0 || !CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | (long)updIndex));
    }

    public final boolean parkedWorkersStackPush(@NotNull Worker worker) {
        int updIndex;
        long updVersion;
        long top;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            top = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int index = (int)(top & 0x1FFFFFL);
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
            updIndex = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!(updIndex != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(index));
        } while (!CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | (long)updIndex));
        return true;
    }

    private final Worker parkedWorkersStackPop() {
        long updVersion;
        long top;
        Worker worker;
        int updIndex;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            top = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int index = (int)(top & 0x1FFFFFL);
            if (this.workers.get(index) == null) {
                return null;
            }
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
        } while ((updIndex = this.parkedWorkersStackNextIndex(worker)) < 0 || !CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | (long)updIndex));
        worker.setNextParkedWorker(NOT_IN_STACK);
        return worker;
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object next = worker.getNextParkedWorker();
        while (next != NOT_IN_STACK) {
            if (next == null) {
                return 0;
            }
            Worker nextWorker = (Worker)next;
            int updIndex = nextWorker.getIndexInArray();
            if (updIndex != 0) {
                return updIndex;
            }
            next = nextWorker.getNextParkedWorker();
        }
        return -1;
    }

    private final /* synthetic */ long getControlState$volatile() {
        return this.controlState$volatile;
    }

    private final /* synthetic */ void setControlState$volatile(long value) {
        this.controlState$volatile = value;
    }

    private final int getCreatedWorkers() {
        boolean $i$f$getCreatedWorkers = false;
        return (int)(CoroutineScheduler.getControlState$volatile$FU().get(this) & 0x1FFFFFL);
    }

    private final int getAvailableCpuPermits() {
        boolean $i$f$getAvailableCpuPermits = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = CoroutineScheduler.controlState$volatile$FU.get(this);
        boolean $i$f$availableCpuPermits = false;
        return (int)((state$iv & 0x7FFFFC0000000000L) >> 42);
    }

    private final int createdWorkers(long state) {
        boolean $i$f$createdWorkers = false;
        return (int)(state & 0x1FFFFFL);
    }

    private final int blockingTasks(long state) {
        boolean $i$f$blockingTasks = false;
        return (int)((state & 0x3FFFFE00000L) >> 21);
    }

    public final int availableCpuPermits(long state) {
        boolean $i$f$availableCpuPermits = false;
        return (int)((state & 0x7FFFFC0000000000L) >> 42);
    }

    private final int incrementCreatedWorkers() {
        boolean $i$f$incrementCreatedWorkers = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = CoroutineScheduler.controlState$volatile$FU.incrementAndGet(this);
        boolean $i$f$createdWorkers = false;
        return (int)(state$iv & 0x1FFFFFL);
    }

    private final int decrementCreatedWorkers() {
        boolean $i$f$decrementCreatedWorkers = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = CoroutineScheduler.getControlState$volatile$FU().getAndDecrement(this);
        boolean $i$f$createdWorkers = false;
        return (int)(state$iv & 0x1FFFFFL);
    }

    private final long incrementBlockingTasks() {
        boolean $i$f$incrementBlockingTasks = false;
        return CoroutineScheduler.controlState$volatile$FU.addAndGet(this, 0x200000L);
    }

    private final void decrementBlockingTasks() {
        boolean $i$f$decrementBlockingTasks = false;
        CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, -2097152L);
    }

    private final boolean tryAcquireCpuPermit() {
        long update;
        long state;
        boolean $i$f$tryAcquireCpuPermit = false;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater handler$atomicfu$iv = CoroutineScheduler.getControlState$volatile$FU();
        do {
            state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$availableCpuPermits = false;
            int available = (int)((state & 0x7FFFFC0000000000L) >> 42);
            if (available == 0) {
                return false;
            }
            update = state - 0x40000000000L;
        } while (!CoroutineScheduler.getControlState$volatile$FU().compareAndSet(this, state, update));
        return true;
    }

    private final long releaseCpuPermit() {
        boolean $i$f$releaseCpuPermit = false;
        return CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, 0x40000000000L);
    }

    private final /* synthetic */ int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private final /* synthetic */ void set_isTerminated$volatile(int value) {
        this._isTerminated$volatile = value;
    }

    public final boolean isTerminated() {
        return CoroutineScheduler._isTerminated$volatile$FU.get(this) == 1;
    }

    @Override
    public void execute(@NotNull Runnable command) {
        CoroutineScheduler.dispatch$default(this, command, false, false, 6, null);
    }

    @Override
    public void close() {
        this.shutdown(10000L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void shutdown(long timeout) {
        Runnable runnable;
        int n2;
        if (!CoroutineScheduler._isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = this.currentWorker();
        ResizableAtomicArray<Worker> lock$iv = this.workers;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Object object = lock$iv;
        synchronized (object) {
            n2 = 0;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getCreatedWorkers = false;
            n2 = (int)(CoroutineScheduler.getControlState$volatile$FU().get(this_$iv) & 0x1FFFFFL);
        }
        int created = n2;
        int i2 = 1;
        if (i2 <= created) {
            while (true) {
                Worker worker;
                Intrinsics.checkNotNull(this.workers.get(i2));
                if (worker != currentWorker) {
                    while (worker.getState() != Thread.State.TERMINATED) {
                        LockSupport.unpark(worker);
                        worker.join(timeout);
                    }
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        boolean bl2 = false;
                        if (!(worker.state == WorkerState.TERMINATED)) {
                            throw new AssertionError();
                        }
                    }
                    worker.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i2 == created) break;
                ++i2;
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while ((runnable = currentWorker) != null && (runnable = runnable.findTask(true)) != null || (runnable = (Task)this.globalCpuQueue.removeFirstOrNull()) != null || (runnable = (Task)this.globalBlockingQueue.removeFirstOrNull()) != null) {
            Runnable task = runnable;
            this.runSafely((Task)task);
        }
        Worker worker = currentWorker;
        if (worker != null) {
            worker.tryReleaseCpu(WorkerState.TERMINATED);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getAvailableCpuPermits = false;
            object = this_$iv;
            long state$iv$iv = CoroutineScheduler.controlState$volatile$FU.get(this_$iv);
            boolean $i$f$availableCpuPermits = false;
            if (!((int)((state$iv$iv & 0x7FFFFC0000000000L) >> 42) == this.corePoolSize)) {
                throw new AssertionError();
            }
        }
        CoroutineScheduler.parkedWorkersStack$volatile$FU.set(this, 0L);
        CoroutineScheduler.controlState$volatile$FU.set(this, 0L);
    }

    public final void dispatch(@NotNull Runnable block, boolean taskContext, boolean fair) {
        long l2;
        Task task;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
        Task $this$isBlocking$iv = task = this.createTask(block, taskContext);
        boolean $i$f$isBlocking = false;
        boolean isBlockingTask = $this$isBlocking$iv.taskContext;
        if (isBlockingTask) {
            CoroutineScheduler this_$iv = this;
            boolean $i$f$incrementBlockingTasks = false;
            l2 = CoroutineScheduler.controlState$volatile$FU.addAndGet(this_$iv, 0x200000L);
        } else {
            l2 = 0L;
        }
        long stateSnapshot = l2;
        Worker currentWorker = this.currentWorker();
        Task notAdded = this.submitToLocalQueue(currentWorker, task, fair);
        if (notAdded != null && !this.addToGlobalQueue(notAdded)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (isBlockingTask) {
            this.signalBlockingWork(stateSnapshot);
        } else {
            this.signalCpuWork();
        }
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        coroutineScheduler.dispatch(runnable, bl2, bl3);
    }

    @NotNull
    public final Task createTask(@NotNull Runnable block, boolean taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            ((Task)block).submissionTime = nanoTime;
            ((Task)block).taskContext = taskContext;
            return (Task)block;
        }
        return TasksKt.asTask(block, nanoTime, taskContext);
    }

    private final void signalBlockingWork(long stateSnapshot) {
        if (this.tryUnpark()) {
            return;
        }
        if (this.tryCreateWorker(stateSnapshot)) {
            return;
        }
        this.tryUnpark();
    }

    public final void signalCpuWork() {
        if (this.tryUnpark()) {
            return;
        }
        if (CoroutineScheduler.tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        this.tryUnpark();
    }

    private final boolean tryCreateWorker(long state) {
        CoroutineScheduler this_$iv = this;
        boolean $i$f$createdWorkers = false;
        int created = (int)(state & 0x1FFFFFL);
        CoroutineScheduler this_$iv2 = this;
        boolean $i$f$blockingTasks = false;
        int blocking = (int)((state & 0x3FFFFE00000L) >> 21);
        int cpuWorkers = RangesKt.coerceAtLeast(created - blocking, 0);
        if (cpuWorkers < this.corePoolSize) {
            int newCpuWorkers = this.createNewWorker();
            if (newCpuWorkers == 1 && this.corePoolSize > 1) {
                this.createNewWorker();
            }
            if (newCpuWorkers > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(l2);
    }

    private final boolean tryUnpark() {
        Worker worker;
        do {
            if (this.parkedWorkersStackPop() != null) continue;
            return false;
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(worker, -1, 0));
        LockSupport.unpark(worker);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final int createNewWorker() {
        int n2;
        int n3;
        Worker worker = null;
        ResizableAtomicArray<Worker> lock$iv = this.workers;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ResizableAtomicArray<Worker> resizableAtomicArray = lock$iv;
        synchronized (resizableAtomicArray) {
            int cpuWorkers;
            block10: {
                int created;
                block9: {
                    block8: {
                        boolean bl2 = false;
                        if (!this.isTerminated()) break block8;
                        int n4 = -1;
                        return n4;
                    }
                    long state = CoroutineScheduler.controlState$volatile$FU.get(this);
                    CoroutineScheduler this_$iv = this;
                    boolean $i$f$createdWorkers = false;
                    created = (int)(state & 0x1FFFFFL);
                    CoroutineScheduler this_$iv2 = this;
                    boolean $i$f$blockingTasks = false;
                    int blocking = (int)((state & 0x3FFFFE00000L) >> 21);
                    cpuWorkers = RangesKt.coerceAtLeast(created - blocking, 0);
                    if (cpuWorkers < this.corePoolSize) break block9;
                    int n5 = 0;
                    return n5;
                }
                if (created < this.maxPoolSize) break block10;
                int n6 = 0;
                return n6;
            }
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getCreatedWorkers2 = false;
            int newIndex = (int)(CoroutineScheduler.getControlState$volatile$FU().get(this_$iv) & 0x1FFFFFL) + 1;
            if (!(newIndex > 0 && this.workers.get(newIndex) == null)) {
                String $i$f$getCreatedWorkers2 = "Failed requirement.";
                throw new IllegalArgumentException($i$f$getCreatedWorkers2.toString());
            }
            worker = new Worker(newIndex);
            this.workers.setSynchronized(newIndex, worker);
            this_$iv = this;
            boolean $i$f$incrementCreatedWorkers = false;
            CoroutineScheduler coroutineScheduler = this_$iv;
            long state$iv$iv = CoroutineScheduler.controlState$volatile$FU.incrementAndGet(this_$iv);
            boolean $i$f$createdWorkers = false;
            if (!(newIndex == (int)(state$iv$iv & 0x1FFFFFL))) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            n3 = cpuWorkers + 1;
        }
        int it = n2 = n3;
        boolean bl3 = false;
        worker.start();
        return n2;
    }

    private final Task submitToLocalQueue(Worker $this$submitToLocalQueue, Task task, boolean fair) {
        if ($this$submitToLocalQueue == null) {
            return task;
        }
        if ($this$submitToLocalQueue.state == WorkerState.TERMINATED) {
            return task;
        }
        Task $this$isBlocking$iv = task;
        boolean $i$f$isBlocking = false;
        if (!$this$isBlocking$iv.taskContext && $this$submitToLocalQueue.state == WorkerState.BLOCKING) {
            return task;
        }
        $this$submitToLocalQueue.mayHaveLocalTasks = true;
        return $this$submitToLocalQueue.localQueue.add(task, fair);
    }

    private final Worker currentWorker() {
        Thread thread2;
        Thread thread3 = Thread.currentThread();
        Worker worker = thread3 instanceof Worker ? (Worker)thread3 : null;
        if (worker != null) {
            Thread it = thread3 = worker;
            boolean bl2 = false;
            Thread this_$iv = it;
            boolean $i$f$getScheduler = false;
            thread2 = Intrinsics.areEqual(((Worker)this_$iv).CoroutineScheduler.this, this) ? thread3 : null;
        } else {
            thread2 = null;
        }
        return thread2;
    }

    @NotNull
    public String toString() {
        int parkedWorkers = 0;
        int blockingWorkers = 0;
        int cpuWorkers = 0;
        int dormant = 0;
        int terminated = 0;
        ArrayList queueSizes = new ArrayList();
        int n2 = this.workers.currentLength();
        block7: for (int index = 1; index < n2; ++index) {
            Worker worker;
            if (this.workers.get(index) == null) continue;
            int queueSize = worker.localQueue.getSize$kotlinx_coroutines_core();
            switch (WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()]) {
                case 1: {
                    ++parkedWorkers;
                    continue block7;
                }
                case 2: {
                    ++blockingWorkers;
                    ((Collection)queueSizes).add("" + queueSize + 'b');
                    continue block7;
                }
                case 3: {
                    ++cpuWorkers;
                    ((Collection)queueSizes).add("" + queueSize + 'c');
                    continue block7;
                }
                case 4: {
                    ++dormant;
                    if (queueSize <= 0) continue block7;
                    ((Collection)queueSizes).add("" + queueSize + 'd');
                    continue block7;
                }
                case 5: {
                    ++terminated;
                    continue block7;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        long state = CoroutineScheduler.controlState$volatile$FU.get(this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize).append(", max = ").append(this.maxPoolSize).append("}, Worker States {CPU = ").append(cpuWorkers).append(", blocking = ").append(blockingWorkers).append(", parked = ").append(parkedWorkers).append(", dormant = ").append(dormant).append(", terminated = ").append(terminated).append("}, running workers queues = ").append(queueSizes).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        CoroutineScheduler this_$iv = this;
        boolean $i$f$createdWorkers = false;
        this_$iv = this;
        boolean $i$f$blockingTasks = false;
        this_$iv = this;
        boolean $i$f$availableCpuPermits = false;
        stringBuilder.append(", Control State {created workers= ").append((int)(state & 0x1FFFFFL)).append(", blocking tasks = ").append((int)((state & 0x3FFFFE00000L) >> 21)).append(", CPUs acquired = ").append(this.corePoolSize - (int)((state & 0x7FFFFC0000000000L) >> 42)).append("}]");
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void runSafely(@NotNull Task task) {
        try {
            task.run();
        }
        catch (Throwable e2) {
            Thread thread2 = Thread.currentThread();
            thread2.getUncaughtExceptionHandler().uncaughtException(thread2, e2);
        }
        finally {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
            if (abstractTimeSource != null) {
                abstractTimeSource.unTrackTask();
            }
        }
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Long, Unit> action$atomicfu) {
        while (true) {
            long l2 = handler$atomicfu.get(obj$atomicfu);
            action$atomicfu.invoke((Long)l2);
        }
    }

    static {
        parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "<init>", "()V", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "", "CLAIMED", "TERMINATED", "BLOCKING_SHIFT", "CREATED_MASK", "", "BLOCKING_MASK", "CPU_PERMITS_SHIFT", "CPU_PERMITS_MASK", "MIN_SUPPORTED_POOL_SIZE", "MAX_SUPPORTED_POOL_SIZE", "PARKED_INDEX_MASK", "PARKED_VERSION_MASK", "PARKED_VERSION_INC", "kotlinx-coroutines-core"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[WorkerState.values().length];
            try {
                nArray[WorkerState.PARKING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.BLOCKING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.DORMANT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.TERMINATED.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0002J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020$J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u0014H\u0002J\u000e\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\u0010\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020$J\n\u00106\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u00107\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00142\u0006\u00109\u001a\u00020$H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010;\u001a\u0004\u0018\u00010\u00142\n\u0010<\u001a\u00060\u0005j\u0002`=H\u0002R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "terminationDeadline", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "tryAcquireCpuPermit", "", "tryReleaseCpu", "newState", "run", "", "mayHaveLocalTasks", "runWorker", "runSingleTask", "isIo", "tryPark", "inStack", "executeTask", "task", "nextInt", "upperBound", "park", "tryTerminateWorker", "findTask", "findBlockingTask", "findCpuTask", "findAnyTask", "scanLocalQueue", "pollGlobalQueues", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1041:1\n298#2,2:1042\n286#2:1044\n300#2,4:1045\n305#2:1049\n295#2,2:1050\n295#2,2:1055\n281#2:1059\n290#2:1060\n284#2:1061\n281#2:1062\n1#3:1052\n77#4:1053\n77#4:1054\n29#5:1057\n16#6:1058\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n684#1:1042,2\n684#1:1044\n684#1:1045,4\n699#1:1049\n773#1:1050,2\n821#1:1055,2\n872#1:1059\n898#1:1060\n898#1:1061\n971#1:1062\n812#1:1053\n815#1:1054\n868#1:1057\n868#1:1058\n*E\n"})
    public final class Worker
    extends Thread {
        private volatile int indexInArray;
        @JvmField
        @NotNull
        public final WorkQueue localQueue;
        @NotNull
        private final Ref.ObjectRef<Task> stolenTask;
        @JvmField
        @NotNull
        public WorkerState state;
        private volatile /* synthetic */ int workerCtl$volatile;
        private long terminationDeadline;
        @Nullable
        private volatile Object nextParkedWorker;
        private long minDelayUntilStealableTaskNs;
        private int rngState;
        @JvmField
        public boolean mayHaveLocalTasks;
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU;

        private Worker() {
            this.setDaemon(true);
            this.setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = NOT_IN_STACK;
            Worker worker = this;
            Worker worker2 = this;
            boolean bl2 = false;
            int seed = (int)System.nanoTime();
            int n2 = seed != 0 ? seed : 42;
            worker2.rngState = n2;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int index) {
            this.setName(CoroutineScheduler.this.schedulerName + "-worker-" + (index == 0 ? "TERMINATED" : String.valueOf(index)));
            this.indexInArray = index;
        }

        public Worker(int index) {
            this();
            this.setIndexInArray(index);
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            boolean $i$f$getScheduler = false;
            return CoroutineScheduler.this;
        }

        public final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        public final /* synthetic */ void setWorkerCtl$volatile(int value) {
            this.workerCtl$volatile = value;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(@Nullable Object object) {
            this.nextParkedWorker = object;
        }

        private final boolean tryAcquireCpuPermit() {
            boolean bl2;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                bl2 = true;
            } else {
                boolean bl3;
                block6: {
                    long update$iv;
                    long state$iv;
                    CoroutineScheduler this_$iv = CoroutineScheduler.this;
                    boolean $i$f$tryAcquireCpuPermit = false;
                    CoroutineScheduler coroutineScheduler = this_$iv;
                    AtomicLongFieldUpdater handler$atomicfu$iv$iv = CoroutineScheduler.controlState$volatile$FU;
                    do {
                        state$iv = handler$atomicfu$iv$iv.get(this_$iv);
                        boolean bl4 = false;
                        CoroutineScheduler this_$iv$iv = this_$iv;
                        boolean $i$f$availableCpuPermits = false;
                        int available$iv = (int)((state$iv & 0x7FFFFC0000000000L) >> 42);
                        if (available$iv == 0) {
                            bl3 = false;
                            break block6;
                        }
                        update$iv = state$iv - 0x40000000000L;
                    } while (!CoroutineScheduler.controlState$volatile$FU.compareAndSet(this_$iv, state$iv, update$iv));
                    bl3 = true;
                }
                if (bl3) {
                    this.state = WorkerState.CPU_ACQUIRED;
                    bl2 = true;
                } else {
                    bl2 = false;
                }
            }
            return bl2;
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState newState) {
            boolean hadCpu;
            WorkerState previousState = this.state;
            boolean bl2 = hadCpu = previousState == WorkerState.CPU_ACQUIRED;
            if (hadCpu) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                boolean $i$f$releaseCpuPermit = false;
                CoroutineScheduler.controlState$volatile$FU.addAndGet(this_$iv, 0x40000000000L);
            }
            if (previousState != newState) {
                this.state = newState;
            }
            return hadCpu;
        }

        @Override
        public void run() {
            this.runWorker();
        }

        private final void runWorker() {
            boolean rescanned = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task task = this.findTask(this.mayHaveLocalTasks);
                if (task != null) {
                    rescanned = false;
                    this.minDelayUntilStealableTaskNs = 0L;
                    this.executeTask(task);
                    continue;
                }
                this.mayHaveLocalTasks = false;
                if (this.minDelayUntilStealableTaskNs != 0L) {
                    if (!rescanned) {
                        rescanned = true;
                        continue;
                    }
                    rescanned = false;
                    this.tryReleaseCpu(WorkerState.PARKING);
                    Thread.interrupted();
                    LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                    this.minDelayUntilStealableTaskNs = 0L;
                    continue;
                }
                this.tryPark();
            }
            this.tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            Task task;
            WorkerState stateSnapshot = this.state;
            boolean isCpuThread = this.state == WorkerState.CPU_ACQUIRED;
            Task task2 = task = isCpuThread ? this.findCpuTask() : this.findBlockingTask();
            if (task == null) {
                if (this.minDelayUntilStealableTaskNs == 0L) {
                    return -1L;
                }
                return this.minDelayUntilStealableTaskNs;
            }
            CoroutineScheduler.this.runSafely(task);
            if (!isCpuThread) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                boolean $i$f$decrementBlockingTasks = false;
                CoroutineScheduler.controlState$volatile$FU.addAndGet(this_$iv, -2097152L);
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl2 = false;
                if (!(this.state == stateSnapshot)) {
                    throw new AssertionError();
                }
            }
            return 0L;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        private final void tryPark() {
            if (!this.inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            Worker.workerCtl$volatile$FU.set(this, -1);
            while (this.inStack() && Worker.workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                this.tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                this.park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != NOT_IN_STACK;
        }

        private final void executeTask(Task task) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl2 = false;
                    Task $this$isBlocking$iv = task;
                    boolean $i$f$isBlocking = false;
                    if (!$this$isBlocking$iv.taskContext) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
            Task $this$isBlocking$iv = task;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext) {
                if (this.tryReleaseCpu(WorkerState.BLOCKING)) {
                    CoroutineScheduler.this.signalCpuWork();
                }
                CoroutineScheduler.this.runSafely(task);
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                boolean $i$f$decrementBlockingTasks = false;
                CoroutineScheduler.controlState$volatile$FU.addAndGet(this_$iv, -2097152L);
                WorkerState currentState = this.state;
                if (currentState != WorkerState.TERMINATED) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        boolean bl3 = false;
                        if (!(currentState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.state = WorkerState.DORMANT;
                }
            } else {
                CoroutineScheduler.this.runSafely(task);
            }
        }

        public final int nextInt(int upperBound) {
            int r2 = this.rngState;
            r2 ^= r2 << 13;
            r2 ^= r2 >> 17;
            r2 ^= r2 << 5;
            this.rngState = r2;
            int mask = upperBound - 1;
            if ((mask & upperBound) == 0) {
                return r2 & mask;
            }
            return (r2 & Integer.MAX_VALUE) % upperBound;
        }

        private final void park() {
            if (this.terminationDeadline == 0L) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0L) {
                this.terminationDeadline = 0L;
                this.tryTerminateWorker();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        private final void tryTerminateWorker() {
            void lock$iv;
            ResizableAtomicArray<Worker> resizableAtomicArray = CoroutineScheduler.this.workers;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            void var5_5 = lock$iv;
            synchronized (var5_5) {
                boolean bl2 = false;
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                CoroutineScheduler this_$iv = coroutineScheduler;
                boolean $i$f$getCreatedWorkers = false;
                if ((int)(CoroutineScheduler.controlState$volatile$FU.get(this_$iv) & 0x1FFFFFL) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (!Worker.workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                    return;
                }
                int oldIndex = this.indexInArray;
                this.setIndexInArray(0);
                coroutineScheduler.parkedWorkersStackTopUpdate(this, oldIndex, 0);
                CoroutineScheduler this_$iv2 = coroutineScheduler;
                boolean $i$f$decrementCreatedWorkers = false;
                CoroutineScheduler coroutineScheduler2 = this_$iv2;
                long state$iv$iv = CoroutineScheduler.controlState$volatile$FU.getAndDecrement(this_$iv2);
                boolean $i$f$createdWorkers = false;
                int lastIndex = (int)(state$iv$iv & 0x1FFFFFL);
                if (lastIndex != oldIndex) {
                    Worker worker = coroutineScheduler.workers.get(lastIndex);
                    Intrinsics.checkNotNull(worker);
                    Worker lastWorker = worker;
                    coroutineScheduler.workers.setSynchronized(oldIndex, lastWorker);
                    lastWorker.setIndexInArray(oldIndex);
                    coroutineScheduler.parkedWorkersStackTopUpdate(lastWorker, lastIndex, oldIndex);
                }
                coroutineScheduler.workers.setSynchronized(lastIndex, null);
                Unit unit = Unit.INSTANCE;
            }
            this.state = WorkerState.TERMINATED;
        }

        @Nullable
        public final Task findTask(boolean mayHaveLocalTasks) {
            if (this.tryAcquireCpuPermit()) {
                return this.findAnyTask(mayHaveLocalTasks);
            }
            return this.findBlockingTask();
        }

        private final Task findBlockingTask() {
            Task task = this.localQueue.pollBlocking();
            if (task == null && (task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull()) == null) {
                task = this.trySteal(1);
            }
            return task;
        }

        private final Task findCpuTask() {
            Task task = this.localQueue.pollCpu();
            if (task == null && (task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull()) == null) {
                task = this.trySteal(2);
            }
            return task;
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            if (scanLocalQueue) {
                Task task;
                boolean globalFirst;
                boolean bl2 = globalFirst = this.nextInt(2 * CoroutineScheduler.this.corePoolSize) == 0;
                if (globalFirst && (task = this.pollGlobalQueues()) != null) {
                    Task it = task;
                    boolean bl3 = false;
                    return it;
                }
                task = this.localQueue.poll();
                if (task != null) {
                    Task it = task;
                    boolean bl4 = false;
                    return it;
                }
                if (!globalFirst && (task = this.pollGlobalQueues()) != null) {
                    Task it = task;
                    boolean bl5 = false;
                    return it;
                }
            } else {
                Task task = this.pollGlobalQueues();
                if (task != null) {
                    Task it = task;
                    boolean bl6 = false;
                    return it;
                }
            }
            return this.trySteal(3);
        }

        private final Task pollGlobalQueues() {
            if (this.nextInt(2) == 0) {
                Task task = (Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    Task it = task;
                    boolean bl2 = false;
                    return it;
                }
                return (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task != null) {
                Task it = task;
                boolean bl3 = false;
                return it;
            }
            return (Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(int stealingMode) {
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            boolean $i$f$getCreatedWorkers = false;
            int created = (int)(CoroutineScheduler.controlState$volatile$FU.get(this_$iv) & 0x1FFFFFL);
            if (created < 2) {
                return null;
            }
            int currentIndex = 0;
            currentIndex = this.nextInt(created);
            long minDelay = 0L;
            minDelay = Long.MAX_VALUE;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            for (int i2 = 0; i2 < created; ++i2) {
                Worker worker;
                int it = i2;
                boolean bl2 = false;
                if (++currentIndex > created) {
                    currentIndex = 1;
                }
                if ((worker = coroutineScheduler.workers.get(currentIndex)) == null || worker == this) continue;
                long stealResult = worker.localQueue.trySteal(stealingMode, this.stolenTask);
                if (stealResult == -1L) {
                    Task result = (Task)this.stolenTask.element;
                    this.stolenTask.element = null;
                    return result;
                }
                if (stealResult <= 0L) continue;
                minDelay = Math.min(minDelay, stealResult);
            }
            this.minDelayUntilStealableTaskNs = minDelay != Long.MAX_VALUE ? minDelay : 0L;
            return null;
        }

        static {
            workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
    public static final class WorkerState
    extends Enum<WorkerState> {
        public static final /* enum */ WorkerState CPU_ACQUIRED = new WorkerState();
        public static final /* enum */ WorkerState BLOCKING = new WorkerState();
        public static final /* enum */ WorkerState PARKING = new WorkerState();
        public static final /* enum */ WorkerState DORMANT = new WorkerState();
        public static final /* enum */ WorkerState TERMINATED = new WorkerState();
        private static final /* synthetic */ WorkerState[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static WorkerState[] values() {
            return (WorkerState[])$VALUES.clone();
        }

        public static WorkerState valueOf(String value) {
            return Enum.valueOf(WorkerState.class, value);
        }

        @NotNull
        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = workerStateArray = new WorkerState[]{WorkerState.CPU_ACQUIRED, WorkerState.BLOCKING, WorkerState.PARKING, WorkerState.DORMANT, WorkerState.TERMINATED};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

