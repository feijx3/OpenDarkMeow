/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.JobSupportKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000b\u0010\u0012\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
final class BlockingCoroutine<T>
extends AbstractCoroutine<T> {
    @NotNull
    private final Thread blockedThread;
    @Nullable
    private final EventLoop eventLoop;

    public BlockingCoroutine(@NotNull CoroutineContext parentContext, @NotNull Thread blockedThread, @Nullable EventLoop eventLoop) {
        super(parentContext, true, true);
        this.blockedThread = blockedThread;
        this.eventLoop = eventLoop;
    }

    @Override
    protected boolean isScopedCoroutine() {
        return true;
    }

    @Override
    protected void afterCompletion(@Nullable Object state) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            Thread thread2 = this.blockedThread;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
            if (abstractTimeSource != null) {
                abstractTimeSource.unpark(thread2);
            } else {
                LockSupport.unpark(thread2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final T joinBlocking() {
        CompletedExceptionally completedExceptionally;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.access$getTimeSource$p();
        if (abstractTimeSource != null) {
            abstractTimeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop = this.eventLoop;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            try {
                while (true) {
                    long parkNanos;
                    EventLoop eventLoop2 = this.eventLoop;
                    long l2 = parkNanos = eventLoop2 != null ? eventLoop2.processNextEvent() : Long.MAX_VALUE;
                    if (!this.isCompleted()) {
                        AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.access$getTimeSource$p();
                        if (abstractTimeSource2 != null) {
                            abstractTimeSource2.parkNanos(this, parkNanos);
                        } else {
                            LockSupport.parkNanos(this, parkNanos);
                        }
                        if (!Thread.interrupted()) continue;
                        this.cancelCoroutine(new InterruptedException());
                        continue;
                    }
                    break;
                }
            }
            finally {
                EventLoop eventLoop3 = this.eventLoop;
                if (eventLoop3 != null) {
                    EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                }
            }
        }
        finally {
            AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.access$getTimeSource$p();
            if (abstractTimeSource3 != null) {
                abstractTimeSource3.unregisterTimeLoopThread();
            }
        }
        Object state = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        CompletedExceptionally completedExceptionally2 = completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally)state : null;
        if (completedExceptionally != null) {
            CompletedExceptionally it = completedExceptionally;
            boolean bl2 = false;
            throw it.cause;
        }
        return (T)state;
    }
}

