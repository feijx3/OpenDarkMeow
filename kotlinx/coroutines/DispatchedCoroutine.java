/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0000\u00a2\u0006\u0002\b\u0014R\t\u0010\t\u001a\u00020\nX\u0082\u0004\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "trySuspend", "", "tryResume", "afterCompletion", "", "state", "", "afterResume", "getResult", "getResult$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class DispatchedCoroutine<T>
extends ScopeCoroutine<T> {
    private volatile /* synthetic */ int _decision$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$volatile$FU;

    public DispatchedCoroutine(@NotNull CoroutineContext context, @NotNull Continuation<? super T> uCont) {
        super(context, uCont);
    }

    private final /* synthetic */ int get_decision$volatile() {
        return this._decision$volatile;
    }

    private final /* synthetic */ void set_decision$volatile(int value) {
        this._decision$volatile = value;
    }

    private final boolean trySuspend() {
        DispatchedCoroutine dispatchedCoroutine = this;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = DispatchedCoroutine._decision$volatile$FU;
        block4: while (true) {
            int decision = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            switch (decision) {
                case 0: {
                    if (!DispatchedCoroutine._decision$volatile$FU.compareAndSet(this, 0, 1)) continue block4;
                    return true;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
            }
            break;
        }
    }

    private final boolean tryResume() {
        DispatchedCoroutine dispatchedCoroutine = this;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = DispatchedCoroutine._decision$volatile$FU;
        block4: while (true) {
            int decision = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            switch (decision) {
                case 0: {
                    if (!DispatchedCoroutine._decision$volatile$FU.compareAndSet(this, 0, 2)) continue block4;
                    return true;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
            }
            break;
        }
    }

    @Override
    protected void afterCompletion(@Nullable Object state) {
        this.afterResume(state);
    }

    @Override
    protected void afterResume(@Nullable Object state) {
        if (this.tryResume()) {
            return;
        }
        DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(state, this.uCont));
    }

    @Nullable
    public final Object getResult$kotlinx_coroutines_core() {
        if (this.trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if (state instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)state).cause;
        }
        return state;
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Integer, Unit> action$atomicfu) {
        while (true) {
            int n2 = handler$atomicfu.get(obj$atomicfu);
            action$atomicfu.invoke((Integer)n2);
        }
    }

    static {
        _decision$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision$volatile");
    }
}

