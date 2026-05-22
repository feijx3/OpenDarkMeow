/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0084\u0001\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012O\b\u0002\u0010\u0006\u001aI\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0019\u001a\u00020\u000f2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JP\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0093\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052O\b\u0002\u0010\u0006\u001aI\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u0012\u0010\u0003\u001a\u00028\u00008\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000RW\u0010\u0006\u001aI\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006*"}, d2={"Lkotlinx/coroutines/CompletedContinuation;", "R", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "value", "Lkotlin/coroutines/CoroutineContext;", "context", "", "idempotentResume", "cancelCause", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Throwable;)V", "Ljava/lang/Object;", "cancelled", "", "getCancelled", "()Z", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,701:1\n1#2:702\n*E\n"})
final class CompletedContinuation<R> {
    @JvmField
    public final R result;
    @JvmField
    @Nullable
    public final CancelHandler cancelHandler;
    @JvmField
    @Nullable
    public final Function3<Throwable, R, CoroutineContext, Unit> onCancellation;
    @JvmField
    @Nullable
    public final Object idempotentResume;
    @JvmField
    @Nullable
    public final Throwable cancelCause;

    public CompletedContinuation(R result, @Nullable CancelHandler cancelHandler, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, @Nullable Object idempotentResume, @Nullable Throwable cancelCause) {
        this.result = result;
        this.cancelHandler = cancelHandler;
        this.onCancellation = onCancellation;
        this.idempotentResume = idempotentResume;
        this.cancelCause = cancelCause;
    }

    public /* synthetic */ CompletedContinuation(Object object, CancelHandler cancelHandler, Function3 function3, Object object2, Throwable throwable, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            cancelHandler = null;
        }
        if ((n2 & 4) != 0) {
            function3 = null;
        }
        if ((n2 & 8) != 0) {
            object2 = null;
        }
        if ((n2 & 0x10) != 0) {
            throwable = null;
        }
        this(object, cancelHandler, function3, object2, throwable);
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public final void invokeHandlers(@NotNull CancellableContinuationImpl<?> cont, @NotNull Throwable cause) {
        block1: {
            Object it;
            CancelHandler cancelHandler = this.cancelHandler;
            if (cancelHandler != null) {
                it = cancelHandler;
                boolean bl2 = false;
                cont.callCancelHandler((CancelHandler)it, cause);
            }
            Function3<Throwable, R, CoroutineContext, Unit> function3 = this.onCancellation;
            if (function3 == null) break block1;
            it = function3;
            boolean bl3 = false;
            cont.callOnCancellation(it, cause, this.result);
        }
    }

    public final R component1() {
        return this.result;
    }

    @Nullable
    public final CancelHandler component2() {
        return this.cancelHandler;
    }

    @Nullable
    public final Function3<Throwable, R, CoroutineContext, Unit> component3() {
        return this.onCancellation;
    }

    @Nullable
    public final Object component4() {
        return this.idempotentResume;
    }

    @Nullable
    public final Throwable component5() {
        return this.cancelCause;
    }

    @NotNull
    public final CompletedContinuation<R> copy(R result, @Nullable CancelHandler cancelHandler, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, @Nullable Object idempotentResume, @Nullable Throwable cancelCause) {
        return new CompletedContinuation<R>(result, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object object, CancelHandler cancelHandler, Function3 function3, Object object2, Throwable throwable, int n2, Object object3) {
        if ((n2 & 1) != 0) {
            object = completedContinuation.result;
        }
        if ((n2 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        if ((n2 & 4) != 0) {
            function3 = completedContinuation.onCancellation;
        }
        if ((n2 & 8) != 0) {
            object2 = completedContinuation.idempotentResume;
        }
        if ((n2 & 0x10) != 0) {
            throwable = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(object, cancelHandler, function3, object2, throwable);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public int hashCode() {
        int result = this.result == null ? 0 : this.result.hashCode();
        result = result * 31 + (this.cancelHandler == null ? 0 : this.cancelHandler.hashCode());
        result = result * 31 + (this.onCancellation == null ? 0 : this.onCancellation.hashCode());
        result = result * 31 + (this.idempotentResume == null ? 0 : this.idempotentResume.hashCode());
        result = result * 31 + (this.cancelCause == null ? 0 : this.cancelCause.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation)other;
        if (!Intrinsics.areEqual(this.result, completedContinuation.result)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume)) {
            return false;
        }
        return Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }
}

