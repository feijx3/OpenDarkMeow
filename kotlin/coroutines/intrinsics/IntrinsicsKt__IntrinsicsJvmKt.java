/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001aA\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u001a=\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u00a2\u0006\u0002\u0010\u0006\u001aZ\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001aV\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u00a2\u0006\u0002\u0010\f\u001an\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u00a2\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001aj\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u00a2\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u00a2\u0006\u0002\u0010\u0010\u001aA\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0013\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001aF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001c\b\u0004\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0083\b\u00a2\u0006\u0002\b\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u00a2\u0006\u0002\b\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001b"}, d2={"startCoroutineUninterceptedOrReturn", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapWithContinuationImpl", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutineUnintercepted", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "createCoroutineFromSuspendFunction", "block", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createSimpleCoroutineForSuspendFunction", "createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "kotlin-stdlib"}, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
@SourceDebugExtension(value={"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
class IntrinsicsKt__IntrinsicsJvmKt {
    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return !($this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, completion) : ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 1)).invoke(completion);
    }

    @PublishedApi
    @Nullable
    public static final <T> Object wrapWithContinuationImpl(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation<? super T> newCompletion = IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion));
        return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 1)).invoke(newCompletion);
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, R receiver, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return !($this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, receiver, completion) : ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 2)).invoke(receiver, completion);
    }

    @PublishedApi
    @Nullable
    public static final <R, T> Object wrapWithContinuationImpl(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, R receiver, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation<? super T> newCompletion = IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion));
        return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 2)).invoke(receiver, newCompletion);
    }

    @InlineOnly
    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, R receiver, P param, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return !($this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, receiver, param, completion) : ((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 3)).invoke(receiver, param, completion);
    }

    @PublishedApi
    @Nullable
    public static final <R, P, T> Object wrapWithContinuationImpl(@NotNull Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, R receiver, P param, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation<? super T> newCompletion = IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion));
        return ((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 3)).invoke(receiver, param, newCompletion);
    }

    @SinceKotlin(version="1.3")
    @NotNull
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$createCoroutineUnintercepted, @NotNull Continuation<? super T> completion) {
        Continuation continuation;
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation<T> probeCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            continuation = ((BaseContinuationImpl)((Object)$this$createCoroutineUnintercepted)).create(probeCompletion);
        } else {
            boolean $i$f$createCoroutineFromSuspendFunction = false;
            CoroutineContext context$iv = probeCompletion.getContext();
            continuation = context$iv == EmptyCoroutineContext.INSTANCE ? (Continuation)new RestrictedContinuationImpl(probeCompletion, $this$createCoroutineUnintercepted){
                private int label;
                final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
                {
                    this.$this_createCoroutineUnintercepted$inlined = function1;
                    Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                    super($completion);
                }

                protected Object invokeSuspend(Object result) {
                    Object object;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Continuation it = this;
                            boolean bl2 = false;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            Object object2 = result;
                            ResultKt.throwOnFailure(object2);
                            object = object2;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return object;
                }
            } : (Continuation)new ContinuationImpl(probeCompletion, context$iv, $this$createCoroutineUnintercepted){
                private int label;
                final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
                {
                    this.$this_createCoroutineUnintercepted$inlined = function1;
                    Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                    super($completion, $context);
                }

                protected Object invokeSuspend(Object result) {
                    Object object;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Continuation it = this;
                            boolean bl2 = false;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            Object object2 = result;
                            ResultKt.throwOnFailure(object2);
                            object = object2;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return object;
                }
            };
        }
        return continuation;
    }

    @SinceKotlin(version="1.3")
    @NotNull
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$createCoroutineUnintercepted, R receiver, @NotNull Continuation<? super T> completion) {
        Continuation continuation;
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation<T> probeCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            continuation = ((BaseContinuationImpl)((Object)$this$createCoroutineUnintercepted)).create(receiver, probeCompletion);
        } else {
            boolean $i$f$createCoroutineFromSuspendFunction = false;
            CoroutineContext context$iv = probeCompletion.getContext();
            continuation = context$iv == EmptyCoroutineContext.INSTANCE ? (Continuation)new RestrictedContinuationImpl(probeCompletion, $this$createCoroutineUnintercepted, receiver){
                private int label;
                final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
                final /* synthetic */ Object $receiver$inlined;
                {
                    this.$this_createCoroutineUnintercepted$inlined = function2;
                    this.$receiver$inlined = object;
                    Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                    super($completion);
                }

                protected Object invokeSuspend(Object result) {
                    Object object;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Continuation it = this;
                            boolean bl2 = false;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            object = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            Object object2 = result;
                            ResultKt.throwOnFailure(object2);
                            object = object2;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return object;
                }
            } : (Continuation)new ContinuationImpl(probeCompletion, context$iv, $this$createCoroutineUnintercepted, receiver){
                private int label;
                final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
                final /* synthetic */ Object $receiver$inlined;
                {
                    this.$this_createCoroutineUnintercepted$inlined = function2;
                    this.$receiver$inlined = object;
                    Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                    super($completion, $context);
                }

                protected Object invokeSuspend(Object result) {
                    Object object;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Continuation it = this;
                            boolean bl2 = false;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            object = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            Object object2 = result;
                            ResultKt.throwOnFailure(object2);
                            object = object2;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return object;
                }
            };
        }
        return continuation;
    }

    @SinceKotlin(version="1.3")
    @NotNull
    public static final <T> Continuation<T> intercepted(@NotNull Continuation<? super T> $this$intercepted) {
        Intrinsics.checkNotNullParameter($this$intercepted, "<this>");
        Continuation<Object> continuation = $this$intercepted instanceof ContinuationImpl ? (ContinuationImpl)$this$intercepted : null;
        if (continuation == null || (continuation = continuation.intercepted()) == null) {
            continuation = $this$intercepted;
        }
        return continuation;
    }

    @SinceKotlin(version="1.3")
    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> completion, Function1<? super Continuation<? super T>, ? extends Object> block) {
        boolean $i$f$createCoroutineFromSuspendFunction = false;
        CoroutineContext context = completion.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? (Continuation)new RestrictedContinuationImpl(completion, block){
            private int label;
            final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
            {
                this.$block = $block;
                Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                super($completion);
            }

            protected Object invokeSuspend(Object result) {
                Object object;
                switch (this.label) {
                    case 0: {
                        this.label = 1;
                        Object object2 = result;
                        ResultKt.throwOnFailure(object2);
                        object = this.$block.invoke(this);
                        break;
                    }
                    case 1: {
                        this.label = 2;
                        Object object3 = result;
                        ResultKt.throwOnFailure(object3);
                        object = object3;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
                return object;
            }
        } : (Continuation)new ContinuationImpl(completion, context, block){
            private int label;
            final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
            {
                this.$block = $block;
                Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                super($completion, $context);
            }

            protected Object invokeSuspend(Object result) {
                Object object;
                switch (this.label) {
                    case 0: {
                        this.label = 1;
                        Object object2 = result;
                        ResultKt.throwOnFailure(object2);
                        object = this.$block.invoke(this);
                        break;
                    }
                    case 1: {
                        this.label = 2;
                        Object object3 = result;
                        ResultKt.throwOnFailure(object3);
                        object = object3;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
                return object;
            }
        };
    }

    private static final <T> Continuation<T> createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> completion) {
        CoroutineContext context = completion.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? (Continuation)new RestrictedContinuationImpl(completion){
            {
                Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                super($completion);
            }

            protected Object invokeSuspend(Object result) {
                Object object = result;
                ResultKt.throwOnFailure(object);
                return object;
            }
        } : (Continuation)new ContinuationImpl(completion, context){
            {
                Intrinsics.checkNotNull($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                super($completion, $context);
            }

            protected Object invokeSuspend(Object result) {
                Object object = result;
                ResultKt.throwOnFailure(object);
                return object;
            }
        };
    }
}

