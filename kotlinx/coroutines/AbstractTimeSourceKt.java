/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlinx.coroutines.AbstractTimeSource;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a\t\u0010\u0005\u001a\u00020\u0006H\u0081\b\u001a\t\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a\u0019\u0010\b\u001a\u00060\tj\u0002`\n2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0081\b\u001a\t\u0010\f\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\r\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\u000e\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\u000f\u001a\u00020\u0003H\u0081\b\u001a\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0081\b\u001a\u0011\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0081\b\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "mockTimeSource", "", "source", "currentTimeMillis", "", "nanoTime", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "trackTask", "unTrackTask", "registerTimeLoopThread", "unregisterTimeLoopThread", "parkNanos", "blocker", "", "nanos", "unpark", "thread", "Ljava/lang/Thread;", "kotlinx-coroutines-core"})
public final class AbstractTimeSourceKt {
    @Nullable
    private static AbstractTimeSource timeSource;

    public static final void mockTimeSource(@Nullable AbstractTimeSource source) {
        boolean $i$f$mockTimeSource = false;
        AbstractTimeSourceKt.timeSource = source;
    }

    @InlineOnly
    private static final long currentTimeMillis() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        return abstractTimeSource != null ? abstractTimeSource.currentTimeMillis() : System.currentTimeMillis();
    }

    @InlineOnly
    private static final long nanoTime() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        return abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
    }

    @InlineOnly
    private static final Runnable wrapTask(Runnable block) {
        Object object = AbstractTimeSourceKt.timeSource;
        if (object == null || (object = ((AbstractTimeSource)object).wrapTask(block)) == null) {
            object = block;
        }
        return object;
    }

    @InlineOnly
    private static final void trackTask() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.trackTask();
        }
    }

    @InlineOnly
    private static final void unTrackTask() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.unTrackTask();
        }
    }

    @InlineOnly
    private static final void registerTimeLoopThread() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.registerTimeLoopThread();
        }
    }

    @InlineOnly
    private static final void unregisterTimeLoopThread() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.unregisterTimeLoopThread();
        }
    }

    @InlineOnly
    private static final void parkNanos(Object blocker, long nanos) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        if (abstractTimeSource != null) {
            abstractTimeSource.parkNanos(blocker, nanos);
        } else {
            LockSupport.parkNanos(blocker, nanos);
        }
    }

    @InlineOnly
    private static final void unpark(Thread thread2) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        if (abstractTimeSource != null) {
            abstractTimeSource.unpark(thread2);
        } else {
            LockSupport.unpark(thread2);
        }
    }
}

