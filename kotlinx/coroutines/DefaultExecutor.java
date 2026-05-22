/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\n\u0010(\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\fH\u0002J\r\u0010-\u001a\u00020\u001dH\u0000\u00a2\u0006\u0002\b.J\b\u0010/\u001a\u00020\u0019H\u0002J\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\tJ\b\u00102\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0014\u00103\u001a\u00020\u00198@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u001a\u00a8\u00066"}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "THREAD_NAME", "", "DEFAULT_KEEP_ALIVE_MS", "", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "thread", "getThread", "()Ljava/lang/Thread;", "FRESH", "", "ACTIVE", "SHUTDOWN_REQ", "SHUTDOWN_ACK", "SHUTDOWN", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "enqueue", "", "task", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "shutdownError", "shutdown", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "run", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "notifyStartup", "shutdownForTests", "timeout", "acknowledgeShutdownIfNeeded", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "toString", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n1#2:196\n*E\n"})
public final class DefaultExecutor
extends EventLoopImplBase
implements Runnable {
    @NotNull
    public static final DefaultExecutor INSTANCE;
    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000L;
    private static final long KEEP_ALIVE_NANOS;
    @Nullable
    private static volatile Thread _thread;
    private static final int FRESH = 0;
    private static final int ACTIVE = 1;
    private static final int SHUTDOWN_REQ = 2;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN = 4;
    private static volatile int debugStatus;

    private DefaultExecutor() {
    }

    private static /* synthetic */ void get_thread$annotations() {
    }

    @Override
    @NotNull
    protected Thread getThread() {
        Thread thread2 = _thread;
        if (thread2 == null) {
            thread2 = this.createThreadSync();
        }
        return thread2;
    }

    private final boolean isShutDown() {
        return debugStatus == 4;
    }

    private final boolean isShutdownRequested() {
        int debugStatus = DefaultExecutor.debugStatus;
        return debugStatus == 2 || debugStatus == 3;
    }

    @Override
    public void enqueue(@NotNull Runnable task) {
        if (this.isShutDown()) {
            this.shutdownError();
        }
        super.enqueue(task);
    }

    @Override
    protected void reschedule(long now, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        this.shutdownError();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.scheduleInvokeOnTimeout(timeMillis, block);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
        if (abstractTimeSource != null) {
            abstractTimeSource.registerTimeLoopThread();
        }
        try {
            long shutdownNanos = Long.MAX_VALUE;
            if (!this.notifyStartup()) {
                return;
            }
            while (true) {
                Thread.interrupted();
                long parkNanos = this.processNextEvent();
                if (parkNanos == Long.MAX_VALUE) {
                    long tillShutdown;
                    long now;
                    AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.access$getTimeSource$p();
                    long l2 = now = abstractTimeSource2 != null ? abstractTimeSource2.nanoTime() : System.nanoTime();
                    if (shutdownNanos == Long.MAX_VALUE) {
                        shutdownNanos = now + KEEP_ALIVE_NANOS;
                    }
                    if ((tillShutdown = shutdownNanos - now) <= 0L) {
                        return;
                    }
                    parkNanos = RangesKt.coerceAtMost(parkNanos, tillShutdown);
                } else {
                    shutdownNanos = Long.MAX_VALUE;
                }
                if (parkNanos <= 0L) continue;
                if (this.isShutdownRequested()) {
                    return;
                }
                AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.access$getTimeSource$p();
                if (abstractTimeSource3 != null) {
                    abstractTimeSource3.parkNanos(this, parkNanos);
                    continue;
                }
                LockSupport.parkNanos(this, parkNanos);
            }
        }
        finally {
            _thread = null;
            this.acknowledgeShutdownIfNeeded();
            AbstractTimeSource abstractTimeSource4 = AbstractTimeSourceKt.access$getTimeSource$p();
            if (abstractTimeSource4 != null) {
                abstractTimeSource4.unregisterTimeLoopThread();
            }
            if (!this.isEmpty()) {
                this.getThread();
            }
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread2 = _thread;
        if (thread2 == null) {
            Thread thread3;
            Thread $this$createThreadSync_u24lambda_u240 = thread3 = new Thread((Runnable)this, THREAD_NAME);
            boolean bl2 = false;
            _thread = $this$createThreadSync_u24lambda_u240;
            $this$createThreadSync_u24lambda_u240.setContextClassLoader(INSTANCE.getClass().getClassLoader());
            $this$createThreadSync_u24lambda_u240.setDaemon(true);
            $this$createThreadSync_u24lambda_u240.start();
            thread2 = thread3;
        }
        return thread2;
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(_thread == null)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(debugStatus == 0 || debugStatus == 3)) {
                throw new AssertionError();
            }
        }
        debugStatus = 0;
        this.createThreadSync();
        while (debugStatus == 0) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            ((Object)this).wait();
        }
    }

    private final synchronized boolean notifyStartup() {
        if (this.isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        ((Object)this).notifyAll();
        return true;
    }

    public final synchronized void shutdownForTests(long timeout) {
        long deadline = System.currentTimeMillis() + timeout;
        if (!this.isShutdownRequested()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            if (_thread != null) {
                Thread it;
                boolean bl2 = false;
                AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
                if (abstractTimeSource != null) {
                    abstractTimeSource.unpark(it);
                } else {
                    LockSupport.unpark(it);
                }
            }
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0L) break;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            ((Object)this).wait(timeout);
        }
        debugStatus = 0;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (!this.isShutdownRequested()) {
            return;
        }
        debugStatus = 3;
        this.resetAll();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        ((Object)this).notifyAll();
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        return _thread != null;
    }

    @Override
    @NotNull
    public String toString() {
        return "DefaultExecutor";
    }

    static {
        Long l2;
        TimeUnit timeUnit;
        INSTANCE = new DefaultExecutor();
        EventLoop.incrementUseCount$default(INSTANCE, false, 1, null);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        try {
            timeUnit = timeUnit2;
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        }
        catch (SecurityException e2) {
            timeUnit = timeUnit2;
            l2 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l2);
    }
}

