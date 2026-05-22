/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitAll;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u0006\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0007H\u0086@\u00a2\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0004\"\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\r\u001a\u0018\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\f0\u0007H\u0086@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000e"}, d2={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n37#2:122\n36#2,3:123\n13402#3,2:126\n1863#4,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n36#1:122\n36#1:123,3\n47#1:126,2\n58#1:128,2\n*E\n"})
public final class AwaitKt {
    @Nullable
    public static final <T> Object awaitAll(@NotNull Deferred<? extends T>[] deferreds, @NotNull Continuation<? super List<? extends T>> $completion) {
        if (!(deferreds.length == 0)) {
            return new AwaitAll<T>(deferreds).await($completion);
        }
        return CollectionsKt.emptyList();
    }

    @Nullable
    public static final <T> Object awaitAll(@NotNull Collection<? extends Deferred<? extends T>> $this$awaitAll, @NotNull Continuation<? super List<? extends T>> $completion) {
        if (!$this$awaitAll.isEmpty()) {
            Collection<Deferred<Deferred>> $this$toTypedArray$iv = $this$awaitAll;
            boolean $i$f$toTypedArray = false;
            Collection<Deferred<Deferred>> thisCollection$iv = $this$toTypedArray$iv;
            return new AwaitAll(thisCollection$iv.toArray(new Deferred[0])).await($completion);
        }
        return CollectionsKt.emptyList();
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object joinAll(@NotNull Job[] var0, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof joinAll.1)) ** GOTO lbl-1000
        var10_2 = $completion;
        if ((var10_2.label & -2147483648) != 0) {
            var10_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super joinAll.1>)$completion){
                Object L$0;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return AwaitKt.joinAll(null, (Continuation<? super Unit>)this);
                }
            };
        }
        $result = $continuation.result;
        var11_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure($result);
                $this$forEach$iv = jobs;
                $i$f$forEach = false;
                var4_7 = 0;
                var5_8 = $this$forEach$iv.length;
lbl16:
                // 2 sources

                while (var4_7 < var5_8) {
                    it = element$iv = $this$forEach$iv[var4_7];
                    $i$a$-forEach-AwaitKt$joinAll$2 = false;
                    $continuation.L$0 = $this$forEach$iv;
                    $continuation.I$0 = var4_7;
                    $continuation.I$1 = var5_8;
                    $continuation.label = 1;
                    v0 = it.join($continuation);
                    if (v0 == var11_4) {
                        return var11_4;
                    }
                    ** GOTO lbl36
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-AwaitKt$joinAll$2 = false;
                var5_8 = $continuation.I$1;
                var4_7 = $continuation.I$0;
                $this$forEach$iv = (Job[])$continuation.L$0;
                ResultKt.throwOnFailure($result);
                v0 = $result;
lbl36:
                // 2 sources

                ++var4_7;
                ** GOTO lbl16
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object joinAll(@NotNull Collection<? extends Job> var0, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof joinAll.3)) ** GOTO lbl-1000
        var9_2 = $completion;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super joinAll.3>)$completion){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return AwaitKt.joinAll(null, (Continuation<? super Unit>)this);
                }
            };
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure($result);
                $this$forEach$iv = $this$joinAll;
                $i$f$forEach = false;
                var4_7 = $this$forEach$iv.iterator();
lbl15:
                // 3 sources

                while (var4_7.hasNext()) {
                    element$iv = var4_7.next();
                    it = (Job)element$iv;
                    $i$a$-forEach-AwaitKt$joinAll$4 = false;
                    $continuation.L$0 = var4_7;
                    $continuation.label = 1;
                    v0 = it.join($continuation);
                    if (v0 != var10_4) continue;
                    return var10_4;
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-AwaitKt$joinAll$4 = false;
                var4_7 = (Iterator<T>)$continuation.L$0;
                ResultKt.throwOnFailure($result);
                v0 = $result;
                ** GOTO lbl15
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

