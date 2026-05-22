/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/selects/OnTimeout;", "", "timeMillis", "", "<init>", "(J)V", "selectClause", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "register", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "kotlinx-coroutines-core"})
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    @NotNull
    public final SelectClause0 getSelectClause() {
        selectClause.1 v0 = selectClause.1.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0, 3), null, 4, null);
    }

    public static /* synthetic */ void getSelectClause$annotations() {
    }

    private final void register(SelectInstance<?> select, Object ignoredParam) {
        if (this.timeMillis <= 0L) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        Runnable action = () -> OnTimeout.register$lambda$0(select, this);
        Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation cfr_ignored_0 = (SelectImplementation)select;
        CoroutineContext context = ((SelectImplementation)select).getContext();
        DisposableHandle disposableHandle = DelayKt.getDelay(context).invokeOnTimeout(this.timeMillis, action, context);
        ((SelectImplementation)select).disposeOnCompletion(disposableHandle);
    }

    private static final void register$lambda$0(SelectInstance $select, OnTimeout this$0) {
        $select.trySelect(this$0, Unit.INSTANCE);
    }

    public static final /* synthetic */ void access$register(OnTimeout $this, SelectInstance select, Object ignoredParam) {
        $this.register(select, ignoredParam);
    }
}

