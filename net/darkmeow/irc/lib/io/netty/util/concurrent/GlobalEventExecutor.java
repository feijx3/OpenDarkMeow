/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.darkmeow.irc.lib.io.netty.util.concurrent.AbstractEventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.AbstractScheduledEventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.DefaultThreadFactory;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FailedFuture;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.OrderedEventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.ScheduledFutureTask;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PriorityQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ThreadExecutorMap;
import net.darkmeow.irc.lib.io.netty.util.internal.ThrowableUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;
import org.jetbrains.annotations.Async;

public final class GlobalEventExecutor
extends AbstractScheduledEventExecutor
implements OrderedEventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL;
    public static final GlobalEventExecutor INSTANCE;
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    final ScheduledFutureTask<Void> quietPeriodTask = new ScheduledFutureTask<Object>((AbstractScheduledEventExecutor)this, Executors.callable(new Runnable(){

        @Override
        public void run() {
        }
    }, null), GlobalEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), SCHEDULE_QUIET_PERIOD_INTERVAL), -SCHEDULE_QUIET_PERIOD_INTERVAL);
    final ThreadFactory threadFactory;
    private final TaskRunner taskRunner = new TaskRunner();
    private final AtomicBoolean started = new AtomicBoolean();
    volatile Thread thread;
    private final Future<?> terminationFuture;

    private GlobalEventExecutor() {
        this.scheduledTaskQueue().add(this.quietPeriodTask);
        this.threadFactory = ThreadExecutorMap.apply(new DefaultThreadFactory(DefaultThreadFactory.toPoolName(this.getClass()), false, 5, null), (EventExecutor)this);
        UnsupportedOperationException terminationFailure = new UnsupportedOperationException();
        ThrowableUtil.unknownStackTrace(terminationFailure, GlobalEventExecutor.class, "terminationFuture");
        this.terminationFuture = new FailedFuture(this, terminationFailure);
    }

    Runnable takeTask() {
        Runnable task;
        BlockingQueue<Runnable> taskQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> scheduledTask;
            if ((scheduledTask = this.peekScheduledTask()) == null) {
                Runnable task2 = null;
                try {
                    task2 = taskQueue.take();
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                return task2;
            }
            long delayNanos = scheduledTask.delayNanos();
            task = null;
            if (delayNanos > 0L) {
                try {
                    task = taskQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException e2) {
                    return null;
                }
            }
            if (task != null) continue;
            this.fetchFromScheduledTaskQueue();
            task = (Runnable)taskQueue.poll();
        } while (task == null);
        return task;
    }

    private void fetchFromScheduledTaskQueue() {
        long nanoTime = this.getCurrentTimeNanos();
        Runnable scheduledTask = this.pollScheduledTask(nanoTime);
        while (scheduledTask != null) {
            this.taskQueue.add(scheduledTask);
            scheduledTask = this.pollScheduledTask(nanoTime);
        }
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    private void addTask(Runnable task) {
        this.taskQueue.add(ObjectUtil.checkNotNull(task, "task"));
    }

    @Override
    public boolean inEventLoop(Thread thread2) {
        return thread2 == this.thread;
    }

    @Override
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        return this.terminationFuture();
    }

    @Override
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        return false;
    }

    public boolean awaitInactivity(long timeout, TimeUnit unit) throws InterruptedException {
        ObjectUtil.checkNotNull(unit, "unit");
        Thread thread2 = this.thread;
        if (thread2 == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread2.join(unit.toMillis(timeout));
        return !thread2.isAlive();
    }

    @Override
    public void execute(Runnable task) {
        this.execute0(task);
    }

    private void execute0(@Async.Schedule Runnable task) {
        this.addTask(ObjectUtil.checkNotNull(task, "task"));
        if (!this.inEventLoop()) {
            this.startThread();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            final Thread callingThread = Thread.currentThread();
            ClassLoader parentCCL = AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

                @Override
                public ClassLoader run() {
                    return callingThread.getContextClassLoader();
                }
            });
            GlobalEventExecutor.setContextClassLoader(callingThread, null);
            try {
                Thread t2 = this.threadFactory.newThread(this.taskRunner);
                GlobalEventExecutor.setContextClassLoader(t2, null);
                this.thread = t2;
                t2.start();
            }
            finally {
                GlobalEventExecutor.setContextClassLoader(callingThread, parentCCL);
            }
        }
    }

    private static void setContextClassLoader(final Thread t2, final ClassLoader cl2) {
        AccessController.doPrivileged(new PrivilegedAction<Void>(){

            @Override
            public Void run() {
                t2.setContextClassLoader(cl2);
                return null;
            }
        });
    }

    static {
        int quietPeriod = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.globalEventExecutor.quietPeriodSeconds", 1);
        if (quietPeriod <= 0) {
            quietPeriod = 1;
        }
        logger.debug("-Dio.netty.globalEventExecutor.quietPeriodSeconds: {}", (Object)quietPeriod);
        SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(quietPeriod);
        INSTANCE = new GlobalEventExecutor();
    }

    final class TaskRunner
    implements Runnable {
        TaskRunner() {
        }

        @Override
        public void run() {
            while (true) {
                Runnable task;
                if ((task = GlobalEventExecutor.this.takeTask()) != null) {
                    try {
                        AbstractEventExecutor.runTask(task);
                    }
                    catch (Throwable t2) {
                        logger.warn("Unexpected exception from the global event executor: ", t2);
                    }
                    if (task != GlobalEventExecutor.this.quietPeriodTask) continue;
                }
                PriorityQueue scheduledTaskQueue = GlobalEventExecutor.this.scheduledTaskQueue;
                if (!GlobalEventExecutor.this.taskQueue.isEmpty() || scheduledTaskQueue != null && scheduledTaskQueue.size() != 1) continue;
                boolean stopped = GlobalEventExecutor.this.started.compareAndSet(true, false);
                assert (stopped);
                if (GlobalEventExecutor.this.taskQueue.isEmpty() || !GlobalEventExecutor.this.started.compareAndSet(false, true)) break;
            }
        }
    }
}

