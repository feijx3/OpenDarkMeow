/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.NotCompleted;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lkotlinx/coroutines/Active;", "Lkotlinx/coroutines/NotCompleted;", "<init>", "()V", "toString", "", "kotlinx-coroutines-core"})
final class Active
implements NotCompleted {
    @NotNull
    public static final Active INSTANCE = new Active();

    private Active() {
    }

    @NotNull
    public String toString() {
        return "Active";
    }
}

