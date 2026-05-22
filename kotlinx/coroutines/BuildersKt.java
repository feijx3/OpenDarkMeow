/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=4, xi=48, d1={"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"})
public final class BuildersKt {
    public static final <T> T runBlocking(@NotNull CoroutineContext context, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(context, block);
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int n2, Object object) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking$default(coroutineContext, function2, n2, object);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope $this$launch, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.launch($this$launch, context, start, block);
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n2, Object object) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, coroutineStart, function2, n2, object);
    }

    @NotNull
    public static final <T> Deferred<T> async(@NotNull CoroutineScope $this$async, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.async($this$async, context, start, block);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n2, Object object) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, coroutineContext, coroutineStart, function2, n2, object);
    }

    @Nullable
    public static final <T> Object withContext(@NotNull CoroutineContext context, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return BuildersKt__Builders_commonKt.withContext(context, block, $completion);
    }

    @Nullable
    public static final <T> Object invoke(@NotNull CoroutineDispatcher $this$invoke, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return BuildersKt__Builders_commonKt.invoke($this$invoke, block, $completion);
    }
}

