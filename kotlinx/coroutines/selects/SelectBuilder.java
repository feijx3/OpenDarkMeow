/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.selects;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J0\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u00a6\u0002\u00a2\u0006\u0002\u0010\tJB\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u00a6\u0002\u00a2\u0006\u0002\u0010\rJV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u00a6\u0002\u00a2\u0006\u0002\u0010\u0011JP\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\n*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0004\u0012\u0002H\n0\u000f2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0002\u00a2\u0006\u0002\u0010\u0012J3\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0017\u00a2\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/selects/SelectBuilder;", "R", "", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "onTimeout", "timeMillis", "", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"})
public interface SelectBuilder<R> {
    public void invoke(@NotNull SelectClause0 var1, @NotNull Function1<? super Continuation<? super R>, ? extends Object> var2);

    public <Q> void invoke(@NotNull SelectClause1<? extends Q> var1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> var2);

    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> var1, P var2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> var3);

    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> var1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> var2);

    @Deprecated(message="Replaced with the same extension function", replaceWith=@ReplaceWith(expression="onTimeout", imports={"kotlinx.coroutines.selects.onTimeout"}), level=DeprecationLevel.ERROR)
    @ExperimentalCoroutinesApi
    @LowPriorityInOverloadResolution
    public void onTimeout(long var1, @NotNull Function1<? super Continuation<? super R>, ? extends Object> var3);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static <R, P, Q> void invoke(@NotNull SelectBuilder<? super R> $this, @NotNull SelectClause2<? super P, ? extends Q> $receiver, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
            $this.invoke($receiver, null, block);
        }

        @Deprecated(message="Replaced with the same extension function", replaceWith=@ReplaceWith(expression="onTimeout", imports={"kotlinx.coroutines.selects.onTimeout"}), level=DeprecationLevel.ERROR)
        @ExperimentalCoroutinesApi
        @LowPriorityInOverloadResolution
        public static <R> void onTimeout(@NotNull SelectBuilder<? super R> $this, long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
            OnTimeoutKt.onTimeout($this, timeMillis, block);
        }
    }
}

