/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0017\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0081\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u001c\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\t\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2={"DEBUG_PROPERTY_NAME", "", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_ON", "DEBUG_PROPERTY_VALUE_OFF", "ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "DEBUG", "getDEBUG", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "()V", "getRECOVER_STACK_TRACES", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "resetCoroutineId", "", "assert", "value", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class DebugKt {
    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    private static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
    private static final boolean DEBUG;
    private static final boolean RECOVER_STACK_TRACES;
    @NotNull
    private static final AtomicLong COROUTINE_ID;

    public static final boolean getASSERTIONS_ENABLED() {
        return ASSERTIONS_ENABLED;
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return RECOVER_STACK_TRACES;
    }

    @PublishedApi
    public static /* synthetic */ void getRECOVER_STACK_TRACES$annotations() {
    }

    @NotNull
    public static final AtomicLong getCOROUTINE_ID() {
        return COROUTINE_ID;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }

    @InlineOnly
    private static final void assert(Function0<Boolean> value) {
        if (DebugKt.getASSERTIONS_ENABLED() && !value.invoke().booleanValue()) {
            throw new AssertionError();
        }
    }

    /*
     * Unable to fully structure code
     */
    static {
        value = SystemPropsKt.systemProp("kotlinx.coroutines.debug");
        $i$a$-let-DebugKt$DEBUG$1 = false;
        var2_2 = value;
        if (var2_2 == null) ** GOTO lbl-1000
        tmp = -1;
        switch (var2_2.hashCode()) {
            case 0: {
                if (var2_2.equals("")) {
                    tmp = 1;
                }
                break;
            }
            case 3005871: {
                if (var2_2.equals("auto")) {
                    tmp = 2;
                }
                break;
            }
            case 109935: {
                if (var2_2.equals("off")) {
                    tmp = 3;
                }
                break;
            }
            case 3551: {
                if (var2_2.equals("on")) {
                    tmp = 1;
                }
                break;
            }
        }
        switch (tmp) {
            case 2: lbl-1000:
            // 2 sources

            {
                v0 = DebugKt.ASSERTIONS_ENABLED;
                break;
            }
            case 1: {
                v0 = true;
                break;
            }
            case 3: {
                v0 = false;
                break;
            }
            default: {
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + value + '\'').toString());
            }
        }
        DebugKt.DEBUG = v0;
        DebugKt.RECOVER_STACK_TRACES = DebugKt.DEBUG != false && SystemPropsKt.systemProp("kotlinx.coroutines.stacktrace.recovery", true) != false;
        DebugKt.COROUTINE_ID = new AtomicLong(0L);
    }
}

