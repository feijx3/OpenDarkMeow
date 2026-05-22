/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "", "<init>", "(Ljava/lang/Throwable;Z)V", "_handled", "Lkotlinx/atomicfu/AtomicBoolean;", "getHandled", "()Z", "makeHandled", "toString", "", "kotlinx-coroutines-core"})
public class CompletedExceptionally {
    @JvmField
    @NotNull
    public final Throwable cause;
    private volatile /* synthetic */ int _handled$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _handled$volatile$FU;

    public CompletedExceptionally(@NotNull Throwable cause, boolean handled) {
        this.cause = cause;
        this._handled$volatile = handled ? 1 : 0;
    }

    public /* synthetic */ CompletedExceptionally(Throwable throwable, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(throwable, bl2);
    }

    private final /* synthetic */ int get_handled$volatile() {
        return this._handled$volatile;
    }

    private final /* synthetic */ void set_handled$volatile(int value) {
        this._handled$volatile = value;
    }

    public final boolean getHandled() {
        return CompletedExceptionally._handled$volatile$FU.get(this) == 1;
    }

    public final boolean makeHandled() {
        return CompletedExceptionally._handled$volatile$FU.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }

    static {
        _handled$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled$volatile");
    }
}

