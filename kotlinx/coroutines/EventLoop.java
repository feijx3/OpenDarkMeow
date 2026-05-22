/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0006\u0010\u0011\u001a\u00020\u0007J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\nJ\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0007J\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00078TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\r\u00a8\u0006#"}, d2={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "useCount", "", "shared", "", "unconfinedQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/DispatchedTask;", "processNextEvent", "isEmpty", "()Z", "nextTime", "getNextTime", "()J", "processUnconfinedEvent", "shouldBeProcessedFromContext", "dispatchUnconfined", "", "task", "isActive", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "delta", "unconfined", "incrementUseCount", "decrementUseCount", "limitedParallelism", "parallelism", "", "name", "", "shutdown", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n1#2:548\n*E\n"})
public abstract class EventLoop
extends CoroutineDispatcher {
    private long useCount;
    private boolean shared;
    @Nullable
    private ArrayDeque<DispatchedTask<?>> unconfinedQueue;

    public long processNextEvent() {
        if (!this.processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    protected boolean isEmpty() {
        return this.isUnconfinedQueueEmpty();
    }

    protected long getNextTime() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return Long.MAX_VALUE;
        }
        ArrayDeque<DispatchedTask<?>> queue = arrayDeque;
        return queue.isEmpty() ? Long.MAX_VALUE : 0L;
    }

    public final boolean processUnconfinedEvent() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return false;
        }
        ArrayDeque<DispatchedTask<?>> queue = arrayDeque;
        DispatchedTask<?> dispatchedTask = queue.removeFirstOrNull();
        if (dispatchedTask == null) {
            return false;
        }
        DispatchedTask<?> task = dispatchedTask;
        task.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> task) {
        ArrayDeque<DispatchedTask<Object>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            ArrayDeque arrayDeque2;
            ArrayDeque it = arrayDeque2 = new ArrayDeque();
            boolean bl2 = false;
            this.unconfinedQueue = it;
            arrayDeque = arrayDeque2;
        }
        ArrayDeque<DispatchedTask<?>> queue = arrayDeque;
        queue.addLast(task);
    }

    public final boolean isActive() {
        return this.useCount > 0L;
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= this.delta(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        return arrayDeque != null ? arrayDeque.isEmpty() : true;
    }

    private final long delta(boolean unconfined) {
        return unconfined ? 0x100000000L : 1L;
    }

    public final void incrementUseCount(boolean unconfined) {
        this.useCount += this.delta(unconfined);
        if (!unconfined) {
            this.shared = true;
        }
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        eventLoop.incrementUseCount(bl2);
    }

    public final void decrementUseCount(boolean unconfined) {
        this.useCount -= this.delta(unconfined);
        if (this.useCount > 0L) {
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.useCount == 0L)) {
                throw new AssertionError();
            }
        }
        if (this.shared) {
            this.shutdown();
        }
    }

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        eventLoop.decrementUseCount(bl2);
    }

    @Override
    @NotNull
    public final CoroutineDispatcher limitedParallelism(int parallelism, @Nullable String name) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return LimitedDispatcherKt.namedOrThis(this, name);
    }

    public void shutdown() {
    }
}

