/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007\u00a2\u0006\u0002\u0010\n\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007\u00a2\u0006\u0004\b\r\u0010\n\u00a8\u0006\u000e"}, d2={"onTimeout", "", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "timeout", "Lkotlin/time/Duration;", "onTimeout-8Mi8wO0", "kotlinx-coroutines-core"})
public final class OnTimeoutKt {
    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> $this$onTimeout, long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        $this$onTimeout.invoke(new OnTimeout(timeMillis).getSelectClause(), block);
    }

    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout-8Mi8wO0(@NotNull SelectBuilder<? super R> $this$onTimeout_u2d8Mi8wO0, long timeout, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeoutKt.onTimeout($this$onTimeout_u2d8Mi8wO0, DelayKt.toDelayMillis-LRDsOJo(timeout), block);
    }
}

