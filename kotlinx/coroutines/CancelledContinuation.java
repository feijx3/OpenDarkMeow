/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletedExceptionally;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\u0007R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "continuation", "Lkotlin/coroutines/Continuation;", "cause", "", "handled", "", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "_resumed", "Lkotlinx/atomicfu/AtomicBoolean;", "makeResumed", "kotlinx-coroutines-core"})
public final class CancelledContinuation
extends CompletedExceptionally {
    private volatile /* synthetic */ int _resumed$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _resumed$volatile$FU;

    public CancelledContinuation(@NotNull Continuation<?> continuation, @Nullable Throwable cause, boolean handled) {
        Throwable throwable = cause;
        if (throwable == null) {
            throwable = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        super(throwable, handled);
    }

    private final /* synthetic */ int get_resumed$volatile() {
        return this._resumed$volatile;
    }

    private final /* synthetic */ void set_resumed$volatile(int value) {
        this._resumed$volatile = value;
    }

    public final boolean makeResumed() {
        return CancelledContinuation._resumed$volatile$FU.compareAndSet(this, 0, 1);
    }

    static {
        _resumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed$volatile");
    }
}

