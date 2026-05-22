/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\t"}, d2={"hexAddress", "", "", "getHexAddress", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "Lkotlin/coroutines/Continuation;", "classSimpleName", "getClassSimpleName", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
public final class DebugStringsKt {
    @NotNull
    public static final String getHexAddress(@NotNull Object $this$hexAddress) {
        return Integer.toHexString(System.identityHashCode($this$hexAddress));
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation<?> $this$toDebugString) {
        String string;
        if ($this$toDebugString instanceof DispatchedContinuation) {
            string = ((DispatchedContinuation)$this$toDebugString).toString();
        } else {
            Object object;
            Object $this$toDebugString_u24lambda_u240;
            Object object2 = $this$toDebugString;
            try {
                $this$toDebugString_u24lambda_u240 = object2;
                boolean bl2 = false;
                $this$toDebugString_u24lambda_u240 = Result.constructor-impl($this$toDebugString_u24lambda_u240 + '@' + DebugStringsKt.getHexAddress($this$toDebugString_u24lambda_u240));
            }
            catch (Throwable bl2) {
                $this$toDebugString_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(bl2));
            }
            object2 = $this$toDebugString_u24lambda_u240;
            Throwable throwable = Result.exceptionOrNull-impl(object2);
            if (throwable == null) {
                object = object2;
            } else {
                Throwable it = throwable;
                boolean bl3 = false;
                object = $this$toDebugString.getClass().getName() + '@' + DebugStringsKt.getHexAddress($this$toDebugString);
            }
            string = (String)object;
        }
        return string;
    }

    @NotNull
    public static final String getClassSimpleName(@NotNull Object $this$classSimpleName) {
        return $this$classSimpleName.getClass().getSimpleName();
    }
}

