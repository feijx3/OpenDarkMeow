/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlinx.coroutines.DelicateCoroutinesApi
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BlockingEventLoop;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0080\b\u001a\b\u0010\b\u001a\u00020\u0003H\u0001\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0001\u00a8\u0006\f"}, d2={"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "processNextEventInCurrentThread", "", "platformAutoreleasePool", "", "block", "Lkotlin/Function0;", "runSingleTaskFromCurrentSystemDispatcher", "isIoDispatcherThread", "", "Ljava/lang/Thread;", "kotlinx-coroutines-core"})
public final class EventLoopKt {
    @NotNull
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    @InternalCoroutinesApi
    public static final long processNextEventInCurrentThread() {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        return eventLoop != null ? eventLoop.processNextEvent() : Long.MAX_VALUE;
    }

    public static final void platformAutoreleasePool(@NotNull Function0<Unit> block) {
        boolean $i$f$platformAutoreleasePool = false;
        block.invoke();
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    @PublishedApi
    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        Thread thread2 = Thread.currentThread();
        if (!(thread2 instanceof CoroutineScheduler.Worker)) {
            throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + thread2);
        }
        return ((CoroutineScheduler.Worker)thread2).runSingleTask();
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    @PublishedApi
    public static final boolean isIoDispatcherThread(@NotNull Thread $this$isIoDispatcherThread) {
        if (!($this$isIoDispatcherThread instanceof CoroutineScheduler.Worker)) {
            return false;
        }
        return ((CoroutineScheduler.Worker)$this$isIoDispatcherThread).isIo();
    }
}

