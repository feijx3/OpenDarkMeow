/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00018\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0019\u0010\n\u001a\u00020\u0001*\u00020\u00018\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0010\u0010\r\u001a\u00020\u000e8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"UNDECIDED", "", "SUSPENDED", "RESUMED", "DECISION_SHIFT", "INDEX_MASK", "NO_INDEX", "decision", "getDecision", "(I)I", "index", "getIndex", "decisionAndIndex", "RESUME_TOKEN", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
public final class CancellableContinuationImplKt {
    private static final int UNDECIDED = 0;
    private static final int SUSPENDED = 1;
    private static final int RESUMED = 2;
    private static final int DECISION_SHIFT = 29;
    private static final int INDEX_MASK = 0x1FFFFFFF;
    private static final int NO_INDEX = 0x1FFFFFFF;
    @JvmField
    @NotNull
    public static final Symbol RESUME_TOKEN = new Symbol("RESUME_TOKEN");

    private static final int getDecision(int $this$decision) {
        boolean $i$f$getDecision = false;
        return $this$decision >> 29;
    }

    private static final int getIndex(int $this$index) {
        boolean $i$f$getIndex = false;
        return $this$index & 0x1FFFFFFF;
    }

    private static final int decisionAndIndex(int decision, int index) {
        boolean $i$f$decisionAndIndex = false;
        return (decision << 29) + index;
    }
}

