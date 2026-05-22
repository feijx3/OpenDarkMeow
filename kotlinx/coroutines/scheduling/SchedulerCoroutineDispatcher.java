/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TasksKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J-\u0010\u001a\u001a\u00020\u00132\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u0014\u001a\u00060\u001bj\u0002`\u001c2\u0006\u0010\u001d\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0016J\r\u0010 \u001a\u00020\u0013H\u0000\u00a2\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0013H\u0000\u00a2\u0006\u0002\b&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "<init>", "(IIJLjava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "createScheduler", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "dispatchWithContext", "", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "dispatchWithContext$kotlinx_coroutines_core", "close", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class SchedulerCoroutineDispatcher
extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private final int maxPoolSize;
    private final long idleWorkerKeepAliveNs;
    @NotNull
    private final String schedulerName;
    @NotNull
    private CoroutineScheduler coroutineScheduler;

    public SchedulerCoroutineDispatcher(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, @NotNull String schedulerName) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = schedulerName;
        this.coroutineScheduler = this.createScheduler();
    }

    public /* synthetic */ SchedulerCoroutineDispatcher(int n2, int n3, long l2, String string, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 1) != 0) {
            n2 = TasksKt.CORE_POOL_SIZE;
        }
        if ((n4 & 2) != 0) {
            n3 = TasksKt.MAX_POOL_SIZE;
        }
        if ((n4 & 4) != 0) {
            l2 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((n4 & 8) != 0) {
            string = "CoroutineScheduler";
        }
        this(n2, n3, l2, string);
    }

    @Override
    @NotNull
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, false, false, 6, null);
    }

    @Override
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, false, true, 2, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable block, boolean context, boolean fair) {
        this.coroutineScheduler.dispatch(block, context, fair);
    }

    @Override
    public void close() {
        this.coroutineScheduler.close();
    }

    public final synchronized void usePrivateScheduler$kotlinx_coroutines_core() {
        this.coroutineScheduler.shutdown(1000L);
        this.coroutineScheduler = this.createScheduler();
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long timeout) {
        this.coroutineScheduler.shutdown(timeout);
    }

    public final void restore$kotlinx_coroutines_core() {
        this.usePrivateScheduler$kotlinx_coroutines_core();
    }

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0L, null, 15, null);
    }
}

