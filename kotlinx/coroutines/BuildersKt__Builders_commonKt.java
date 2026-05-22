/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.LazyDeferredCoroutine;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\f\u00a2\u0006\u0002\u0010\r\u001aX\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u0010*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\f\u00a2\u0006\u0002\u0010\u0011\u001aR\u0010\u0012\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00152)\b\b\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0086J\u00a2\u0006\u0002\u0010\u0016\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0018X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0018X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"launch", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "async", "Lkotlinx/coroutines/Deferred;", "T", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "withContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UNDECIDED", "", "SUSPENDED", "RESUMED", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/BuildersKt")
@SourceDebugExtension(value={"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,268:1\n91#2,5:269\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n164#1:269,5\n*E\n"})
final class BuildersKt__Builders_commonKt {
    private static final int UNDECIDED = 0;
    private static final int SUSPENDED = 1;
    private static final int RESUMED = 2;

    @NotNull
    public static final Job launch(@NotNull CoroutineScope $this$launch, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$launch, context);
        StandaloneCoroutine coroutine = start.isLazy() ? (StandaloneCoroutine)new LazyStandaloneCoroutine(newContext, block) : new StandaloneCoroutine(newContext, true);
        coroutine.start(start, coroutine, block);
        return coroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final <T> Deferred<T> async(@NotNull CoroutineScope $this$async, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$async, context);
        DeferredCoroutine coroutine = start.isLazy() ? (DeferredCoroutine)new LazyDeferredCoroutine(newContext, block) : new DeferredCoroutine(newContext, true);
        coroutine.start(start, coroutine, block);
        return coroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Nullable
    public static final <T> Object withContext(@NotNull CoroutineContext context, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        Object object;
        Continuation<T> uCont = $completion;
        boolean bl2 = false;
        CoroutineContext oldContext = uCont.getContext();
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext(oldContext, context);
        JobKt.ensureActive(newContext);
        if (newContext == oldContext) {
            ScopeCoroutine<? super T> coroutine = new ScopeCoroutine<T>(newContext, uCont);
            object = UndispatchedKt.startUndispatchedOrReturn(coroutine, coroutine, block);
        } else if (Intrinsics.areEqual(newContext.get(ContinuationInterceptor.Key), oldContext.get(ContinuationInterceptor.Key))) {
            void context$iv;
            UndispatchedCoroutine<T> coroutine = new UndispatchedCoroutine<T>(newContext, uCont);
            CoroutineContext coroutineContext = coroutine.getContext();
            Object countOrElement$iv = null;
            boolean $i$f$withCoroutineContext = false;
            Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
            try {
                boolean bl3 = false;
                Object object2 = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)coroutine, coroutine, block);
                object = object2;
            }
            finally {
                ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
            }
        } else {
            DispatchedCoroutine<T> coroutine = new DispatchedCoroutine<T>(newContext, uCont);
            CancellableKt.startCoroutineCancellable(block, coroutine, (Continuation)coroutine);
            object = coroutine.getResult$kotlinx_coroutines_core();
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @Nullable
    public static final <T> Object invoke(@NotNull CoroutineDispatcher $this$invoke, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        boolean $i$f$invoke = false;
        return BuildersKt.withContext($this$invoke, block, $completion);
    }

    private static final <T> Object invoke$$forInline(CoroutineDispatcher $this$invoke, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        boolean $i$f$invoke = false;
        CoroutineContext coroutineContext = $this$invoke;
        InlineMarker.mark(0);
        Object object = BuildersKt.withContext(coroutineContext, block, $completion);
        InlineMarker.mark(1);
        return object;
    }
}

