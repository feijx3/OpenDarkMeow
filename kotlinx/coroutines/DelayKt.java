/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@\u00a2\u0006\u0002\u0010\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0004\b\n\u0010\u0007\u001a\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\tH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0003\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delay", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,159:1\n426#2,11:160\n426#2,11:171\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n103#1:160,11\n123#1:171,11\n*E\n"})
public final class DelayKt {
    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object awaitCancellation(@NotNull Continuation<?> $completion) {
        if (!($completion instanceof awaitCancellation.1)) ** GOTO lbl-1000
        var7_1 = $completion;
        if ((var7_1.label & -2147483648) != 0) {
            var7_1.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super awaitCancellation.1>)$completion){
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return DelayKt.awaitCancellation(this);
                }
            };
        }
        $result = $continuation.result;
        var8_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure($result);
                $i$f$suspendCancellableCoroutine = false;
                $continuation.label = 1;
                uCont$iv = $continuation;
                $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv = false;
                cancellable$iv = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellable$iv.initCancellability();
                (CancellableContinuation)cancellable$iv;
                $i$a$-suspendCancellableCoroutine-DelayKt$awaitCancellation$2 = false;
                v0 = cancellable$iv.getResult();
                if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended($continuation);
                }
                v1 = v0;
                if (v0 == var8_3) {
                    return var8_3;
                }
                ** GOTO lbl35
            }
            case 1: {
                $i$f$suspendCancellableCoroutine = false;
                ResultKt.throwOnFailure($result);
                v1 = $result;
lbl35:
                // 2 sources

                throw new KotlinNothingValueException();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public static final Object delay(long timeMillis, @NotNull Continuation<? super Unit> $completion) {
        if (timeMillis <= 0L) {
            return Unit.INSTANCE;
        }
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<? super Unit> cancellable$iv = new CancellableContinuationImpl<Unit>(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl3 = false;
        if (timeMillis < Long.MAX_VALUE) {
            DelayKt.getDelay(cont.getContext()).scheduleResumeAfterDelay(timeMillis, cont);
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object delay-VtjQ1oo(long duration, @NotNull Continuation<? super Unit> $completion) {
        Object object = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(duration), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Delay getDelay(@NotNull CoroutineContext $this$delay) {
        Object e2 = $this$delay.get(ContinuationInterceptor.Key);
        Delay delay = e2 instanceof Delay ? (Delay)e2 : null;
        if (delay == null) {
            delay = DefaultExecutorKt.getDefaultDelay();
        }
        return delay;
    }

    public static final long toDelayMillis-LRDsOJo(long $this$toDelayMillis_u2dLRDsOJo) {
        long l2;
        boolean bl2 = Duration.isPositive-impl($this$toDelayMillis_u2dLRDsOJo);
        if (bl2) {
            l2 = Duration.getInWholeMilliseconds-impl(Duration.plus-LRDsOJo($this$toDelayMillis_u2dLRDsOJo, DurationKt.toDuration(999999L, DurationUnit.NANOSECONDS)));
        } else if (!bl2) {
            l2 = 0L;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return l2;
    }
}

