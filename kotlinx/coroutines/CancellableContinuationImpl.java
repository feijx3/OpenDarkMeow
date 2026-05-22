/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Active;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CancelledContinuation;
import kotlinx.coroutines.ChildContinuation;
import kotlinx.coroutines.CompletedContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.DispatchedTaskKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0001J\u0015\u00100\u001a\n\u0018\u000101j\u0004\u0018\u0001`2H\u0016\u00a2\u0006\u0002\u00103J\u000f\u00104\u001a\u0004\u0018\u00010\u0017H\u0010\u00a2\u0006\u0002\b5J\u001f\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u000209H\u0010\u00a2\u0006\u0002\b:J\u0010\u0010;\u001a\u00020!2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0015\u0010=\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0000\u00a2\u0006\u0002\b>J\u0017\u0010?\u001a\u00020*2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020*0AH\u0082\bJ\u0018\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\b\u00108\u001a\u0004\u0018\u000109J\u001e\u0010E\u001a\u00020*2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G2\b\u00108\u001a\u0004\u0018\u000109H\u0002Jn\u0010H\u001a\u00020*\"\u0004\b\u0001\u0010I2K\u0010J\u001aG\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*0K2\u0006\u00108\u001a\u0002092\u0006\u0010N\u001a\u0002HI\u00a2\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020!H\u0002J\b\u0010T\u001a\u00020!H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\u0017H\u0001J\n\u0010V\u001a\u0004\u0018\u00010\u0019H\u0002J\r\u0010W\u001a\u00020*H\u0000\u00a2\u0006\u0002\bXJ\u001b\u0010Y\u001a\u00020*2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016\u00a2\u0006\u0002\u0010\\J:\u0010]\u001a\u00020*2\u0006\u0010N\u001a\u00028\u00002#\u0010J\u001a\u001f\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*\u0018\u00010^H\u0016\u00a2\u0006\u0002\u0010_Jn\u0010]\u001a\u00020*\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001a\u0002HI2M\u0010J\u001aI\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016\u00a2\u0006\u0002\u0010`J\u001c\u0010a\u001a\u00020*2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G2\u0006\u0010b\u001a\u00020\nH\u0016J1\u0010a\u001a\u00020*2'\u0010C\u001a#\u0012\u0015\u0012\u0013\u0018\u000109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*0^j\u0002`cH\u0016J\u0015\u0010d\u001a\u00020*2\u0006\u0010C\u001a\u00020DH\u0000\u00a2\u0006\u0002\beJ\u0010\u0010f\u001a\u00020*2\u0006\u0010C\u001a\u00020\u0017H\u0002J\u001a\u0010g\u001a\u00020*2\u0006\u0010C\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010h\u001a\u00020*2\u0006\u0010i\u001a\u00020\nH\u0002J\u0086\u0001\u0010j\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0001\u0010I2\u0006\u0010\u001d\u001a\u00020k2\u0006\u0010l\u001a\u0002HI2\u0006\u0010\t\u001a\u00020\n2M\u0010J\u001aI\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010K2\b\u0010m\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0002\u0010nJv\u0010o\u001a\u00020*\"\u0004\b\u0001\u0010I2\u0006\u0010l\u001a\u0002HI2\u0006\u0010\t\u001a\u00020\n2O\b\u0002\u0010J\u001aI\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0000\u00a2\u0006\u0004\bp\u0010qJv\u0010r\u001a\u0004\u0018\u00010s\"\u0004\b\u0001\u0010I2\u0006\u0010l\u001a\u0002HI2\b\u0010m\u001a\u0004\u0018\u00010\u00172M\u0010J\u001aI\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0002\u00a2\u0006\u0002\u0010tJ\u0012\u0010u\u001a\u00020v2\b\u0010l\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010w\u001a\u00020*H\u0002J\r\u0010x\u001a\u00020*H\u0000\u00a2\u0006\u0002\byJ!\u0010T\u001a\u0004\u0018\u00010\u00172\u0006\u0010N\u001a\u00028\u00002\b\u0010m\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0002\u0010zJz\u0010T\u001a\u0004\u0018\u00010\u0017\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001a\u0002HI2\b\u0010m\u001a\u0004\u0018\u00010\u00172M\u0010J\u001aI\u0012\u0013\u0012\u001109\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016\u00a2\u0006\u0002\u0010{J\u0012\u0010|\u001a\u0004\u0018\u00010\u00172\u0006\u0010}\u001a\u000209H\u0016J\u0010\u0010~\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020\u0017H\u0016J\u001c\u0010\u0080\u0001\u001a\u00020**\u00030\u0081\u00012\u0006\u0010N\u001a\u00028\u0000H\u0016\u00a2\u0006\u0003\u0010\u0082\u0001J\u0016\u0010\u0083\u0001\u001a\u00020**\u00030\u0081\u00012\u0006\u0010}\u001a\u000209H\u0016J\"\u0010\u0084\u0001\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0010\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u0001092\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0010\u00a2\u0006\u0003\b\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020&H\u0016J\t\u0010\u008a\u0001\u001a\u00020&H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\t\u0010\u0013\u001a\u00020\u0014X\u0082\u0004R\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004R\u0011\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016X\u0082\u0004R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u0006\u008b\u0001"}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "isActive", "", "()Z", "isCompleted", "isCancelled", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "initCancellability", "", "isReusable", "resetStateReusable", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "takeState", "takeState$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "cancel", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callCancelHandler", "handler", "Lkotlinx/coroutines/CancelHandler;", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "callOnCancellation", "R", "onCancellation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Ljava/lang/Object;)V", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "trySuspend", "tryResume", "getResult", "installParentHandle", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resume", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "invokeOnCancellation", "index", "Lkotlinx/coroutines/CompletionHandler;", "invokeOnCancellationInternal", "invokeOnCancellationInternal$kotlinx_coroutines_core", "invokeOnCancellationImpl", "multipleHandlersError", "dispatchResume", "mode", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "idempotent", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "resumeImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function3;)V", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/internal/Symbol;", "alreadyResumedError", "", "detachChildIfNonReusable", "detachChild", "detachChild$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "tryResumeWithException", "exception", "completeResume", "token", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "toString", "nameString", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,701:1\n227#1,10:705\n227#1,10:716\n1#2:702\n20#3:703\n20#3:704\n18#3:715\n17#3:726\n18#3,3:727\n17#3:730\n18#3,3:731\n18#3:738\n17#3,4:739\n57#4,2:734\n57#4,2:736\n57#4,2:743\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n239#1:705,10\n244#1:716,10\n69#1:703\n155#1:704\n242#1:715\n271#1:726\n272#1:727,3\n281#1:730\n282#1:731,3\n387#1:738\n390#1:739,4\n323#1:734,2\n333#1:736,2\n614#1:743,2\n*E\n"})
public class CancellableContinuationImpl<T>
extends DispatchedTask<T>
implements CancellableContinuation<T>,
CoroutineStackFrame,
Waiter {
    @NotNull
    private final Continuation<T> delegate;
    @NotNull
    private final CoroutineContext context;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU;

    /*
     * WARNING - void declaration
     */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> delegate, int resumeMode) {
        super(resumeMode);
        void decision$iv;
        boolean bl2;
        this.delegate = delegate;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            bl2 = false;
            if (!(resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        this.context = this.delegate.getContext();
        bl2 = false;
        int index$iv = 0x1FFFFFFF;
        boolean $i$f$decisionAndIndex = false;
        this._decisionAndIndex$volatile = (decision$iv << 29) + index$iv;
        this._state$volatile = Active.INSTANCE;
    }

    @Override
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    private final /* synthetic */ int get_decisionAndIndex$volatile() {
        return this._decisionAndIndex$volatile;
    }

    private final /* synthetic */ void set_decisionAndIndex$volatile(int value) {
        this._decisionAndIndex$volatile = value;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object value) {
        this._state$volatile = value;
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object value) {
        this._parentHandle$volatile = value;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle)CancellableContinuationImpl._parentHandle$volatile$FU.get(this);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return CancellableContinuationImpl._state$volatile$FU.get(this);
    }

    @Override
    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override
    public boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override
    public boolean isCancelled() {
        return this.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final String getStateDebugRepresentation() {
        Object object = this.getState$kotlinx_coroutines_core();
        return object instanceof NotCompleted ? "Active" : (object instanceof CancelledContinuation ? "Cancelled" : "Completed");
    }

    @Override
    public void initCancellability() {
        DisposableHandle disposableHandle = this.installParentHandle();
        if (disposableHandle == null) {
            return;
        }
        DisposableHandle handle = disposableHandle;
        if (this.isCompleted()) {
            handle.dispose();
            CancellableContinuationImpl._parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isReusable() {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) return false;
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (!((DispatchedContinuation)continuation).isReusable$kotlinx_coroutines_core()) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="resetStateReusable")
    public final boolean resetStateReusable() {
        void decision$iv;
        boolean bl2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl4 = false;
            if (!(this.getParentHandle() != NonDisposableHandle.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object state = CancellableContinuationImpl._state$volatile$FU.get(this);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            bl2 = false;
            if (!(!(state instanceof NotCompleted))) {
                throw new AssertionError();
            }
        }
        if (state instanceof CompletedContinuation && ((CompletedContinuation)state).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return false;
        }
        bl2 = false;
        int index$iv = 0x1FFFFFFF;
        boolean $i$f$decisionAndIndex = false;
        CancellableContinuationImpl._decisionAndIndex$volatile$FU.set(this, (int)((decision$iv << 29) + index$iv));
        CancellableContinuationImpl._state$volatile$FU.set(this, Active.INSTANCE);
        return true;
    }

    @Override
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        return continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame)((Object)continuation) : null;
    }

    @Override
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    @Override
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._state$volatile$FU;
        while (true) {
            Object state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            Object v2 = state;
            if (v2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (v2 instanceof CompletedExceptionally) {
                return;
            }
            if (v2 instanceof CompletedContinuation) {
                if (!(!((CompletedContinuation)state).getCancelled())) {
                    boolean bl3 = false;
                    String string = "Must be called at most once";
                    throw new IllegalStateException(string.toString());
                }
                CompletedContinuation update = CompletedContinuation.copy$default((CompletedContinuation)state, null, null, null, null, cause, 15, null);
                if (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update)) continue;
                ((CompletedContinuation)state).invokeHandlers(this, cause);
                return;
            }
            if (CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, new CompletedContinuation(state, null, null, null, cause, 14, null))) break;
        }
    }

    private final boolean cancelLater(Throwable cause) {
        if (!this.isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        DispatchedContinuation dispatched = (DispatchedContinuation)continuation;
        return dispatched.postponeCancellation$kotlinx_coroutines_core(cause);
    }

    @Override
    public boolean cancel(@Nullable Throwable cause) {
        CancelledContinuation update;
        Object state;
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if (!(state instanceof NotCompleted)) {
                return false;
            }
            update = new CancelledContinuation(this, cause, state instanceof CancelHandler || state instanceof Segment);
        } while (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update));
        NotCompleted notCompleted = (NotCompleted)state;
        if (notCompleted instanceof CancelHandler) {
            this.callCancelHandler((CancelHandler)state, cause);
        } else if (notCompleted instanceof Segment) {
            this.callSegmentOnCancellation((Segment)state, cause);
        }
        this.detachChildIfNonReusable();
        this.dispatchResume(this.resumeMode);
        return true;
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable cause) {
        if (this.cancelLater(cause)) {
            return;
        }
        this.cancel(cause);
        this.detachChildIfNonReusable();
    }

    private final void callCancelHandlerSafely(Function0<Unit> block) {
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            block.invoke();
        }
        catch (Throwable ex2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex2));
        }
    }

    public final void callCancelHandler(@NotNull CancelHandler handler, @Nullable Throwable cause) {
        CancellableContinuationImpl this_$iv = this;
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            boolean bl2 = false;
            handler.invoke(cause);
        }
        catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this_$iv.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this_$iv, ex$iv));
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable cause) {
        int $this$index$iv = CancellableContinuationImpl._decisionAndIndex$volatile$FU.get(this);
        boolean $i$f$getIndex = false;
        int index = $this$index$iv & 0x1FFFFFFF;
        if (!(index != 0x1FFFFFFF)) {
            boolean $i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22 = false;
            String $i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22 = "The index for Segment.onCancellation(..) is broken";
            throw new IllegalStateException($i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22.toString());
        }
        CancellableContinuationImpl this_$iv = this;
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            boolean bl2 = false;
            segment.onCancellation(index, cause, this.getContext());
        }
        catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this_$iv.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this_$iv, ex$iv));
        }
    }

    public final <R> void callOnCancellation(@NotNull Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, @NotNull Throwable cause, R value) {
        try {
            onCancellation.invoke(cause, value, this.getContext());
        }
        catch (Throwable ex2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, ex2));
        }
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job parent) {
        return parent.getCancellationException();
    }

    /*
     * WARNING - void declaration
     */
    private final boolean trySuspend() {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
        block4: while (true) {
            int cur = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int $this$decision$iv = cur;
            boolean $i$f$getDecision = false;
            switch ($this$decision$iv >> 29) {
                case 0: {
                    void decision$iv;
                    $this$decision$iv = 1;
                    int $this$index$iv = cur;
                    boolean $i$f$getIndex = false;
                    int index$iv = $this$index$iv & 0x1FFFFFFF;
                    boolean $i$f$decisionAndIndex = false;
                    if (!CancellableContinuationImpl._decisionAndIndex$volatile$FU.compareAndSet(this, cur, (int)((decision$iv << 29) + index$iv))) continue block4;
                    return true;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
            }
            break;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final boolean tryResume() {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
        block4: while (true) {
            int cur = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int $this$decision$iv = cur;
            boolean $i$f$getDecision = false;
            switch ($this$decision$iv >> 29) {
                case 0: {
                    void decision$iv;
                    $this$decision$iv = 2;
                    int $this$index$iv = cur;
                    boolean $i$f$getIndex = false;
                    int index$iv = $this$index$iv & 0x1FFFFFFF;
                    boolean $i$f$decisionAndIndex = false;
                    if (!CancellableContinuationImpl._decisionAndIndex$volatile$FU.compareAndSet(this, cur, (int)((decision$iv << 29) + index$iv))) continue block4;
                    return true;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
            }
            break;
        }
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        Object state;
        boolean isReusable = this.isReusable();
        if (this.trySuspend()) {
            if (this.getParentHandle() == null) {
                this.installParentHandle();
            }
            if (isReusable) {
                this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        if ((state = this.getState$kotlinx_coroutines_core()) instanceof CompletedExceptionally) {
            Throwable exception$iv = ((CompletedExceptionally)state).cause;
            boolean $i$f$recoverStackTrace = false;
            throw !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)this instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)((Object)((Continuation)this)));
        }
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job)this.getContext().get(Job.Key)) != null && !job.isActive()) {
            CancellationException cause = job.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(state, cause);
            boolean $i$f$recoverStackTrace = false;
            throw !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)this instanceof CoroutineStackFrame) ? (Throwable)cause : StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)((Object)((Continuation)this)));
        }
        return this.getSuccessfulResult$kotlinx_coroutines_core(state);
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job)this.getContext().get(Job.Key);
        if (job == null) {
            return null;
        }
        Job parent = job;
        DisposableHandle handle = JobKt.invokeOnCompletion$default(parent, false, new ChildContinuation(this), 1, null);
        CancellableContinuationImpl._parentHandle$volatile$FU.compareAndSet(this, null, handle);
        return handle;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation<T> continuation = this.delegate;
        Object object = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        if (object == null || (object = ((DispatchedContinuation)object).tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        Object cancellationCause = object;
        this.detachChild$kotlinx_coroutines_core();
        this.cancel((Throwable)cancellationCause);
    }

    @Override
    public void resumeWith(@NotNull Object result) {
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, CompletionStateKt.toState(result, this), this.resumeMode, null, 4, null);
    }

    @Override
    public void resume(T value, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        Function3<Throwable, Object, CoroutineContext, Unit> function3;
        CancellableContinuationImpl cancellableContinuationImpl = this;
        T t2 = value;
        int n2 = this.resumeMode;
        Function1<? super Throwable, Unit> function1 = onCancellation;
        if (function1 != null) {
            Function1<? super Throwable, Unit> function12 = function1;
            int n3 = n2;
            T t3 = t2;
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            boolean bl2 = false;
            Function3<Throwable, Object, CoroutineContext, Unit> function32 = (arg_0, arg_1, arg_2) -> CancellableContinuationImpl.resume$lambda$13$lambda$12(onCancellation, arg_0, arg_1, arg_2);
            cancellableContinuationImpl = cancellableContinuationImpl2;
            t2 = t3;
            n2 = n3;
            function3 = function32;
        } else {
            function3 = null;
        }
        cancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core(t2, n2, function3);
    }

    @Override
    public <R extends T> void resume(R value, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        this.resumeImpl$kotlinx_coroutines_core(value, this.resumeMode, onCancellation);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        void decision$iv;
        void var6_6;
        int n2;
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
        do {
            int it = n2 = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            int $this$index$iv = it;
            boolean $i$f$getIndex = false;
            if (!(($this$index$iv & 0x1FFFFFFF) == 0x1FFFFFFF)) {
                boolean $i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22 = false;
                String $i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22 = "invokeOnCancellation should be called at most once";
                throw new IllegalStateException($i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22.toString());
            }
            int $this$decision$iv = it;
            boolean $i$f$getDecision = false;
            $this$decision$iv >>= 29;
            boolean $i$f$decisionAndIndex = false;
        } while (!handler$atomicfu$iv.compareAndSet(this, n2, (int)(var6_6 = (decision$iv << 29) + index)));
        this.invokeOnCancellationImpl(segment);
    }

    @Override
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
        CancellableContinuationKt.invokeOnCancellation(this, new CancelHandler.UserSupplied(handler));
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(@NotNull CancelHandler handler) {
        this.invokeOnCancellationImpl(handler);
    }

    private final void invokeOnCancellationImpl(Object handler) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(handler instanceof CancelHandler || handler instanceof Segment)) {
                throw new AssertionError();
            }
        }
        CancellableContinuationImpl bl2 = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._state$volatile$FU;
        while (true) {
            CompletedContinuation update;
            Object state = handler$atomicfu$iv.get(this);
            boolean bl3 = false;
            Object v2 = state;
            if (v2 instanceof Active) {
                if (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, handler)) continue;
                return;
            }
            if (v2 instanceof CancelHandler || v2 instanceof Segment) {
                this.multipleHandlersError(handler, state);
                continue;
            }
            if (v2 instanceof CompletedExceptionally) {
                if (!((CompletedExceptionally)state).makeHandled()) {
                    this.multipleHandlersError(handler, state);
                }
                if (state instanceof CancelledContinuation) {
                    Throwable cause;
                    Object v3 = state;
                    CompletedExceptionally completedExceptionally = v3 instanceof CompletedExceptionally ? (CompletedExceptionally)v3 : null;
                    Throwable throwable = cause = completedExceptionally != null ? completedExceptionally.cause : null;
                    if (handler instanceof CancelHandler) {
                        this.callCancelHandler((CancelHandler)handler, cause);
                    } else {
                        Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        Segment segment = (Segment)handler;
                        this.callSegmentOnCancellation(segment, cause);
                    }
                }
                return;
            }
            if (v2 instanceof CompletedContinuation) {
                if (((CompletedContinuation)state).cancelHandler != null) {
                    this.multipleHandlersError(handler, state);
                }
                if (handler instanceof Segment) {
                    return;
                }
                Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                CancelHandler cfr_ignored_0 = (CancelHandler)handler;
                if (((CompletedContinuation)state).getCancelled()) {
                    this.callCancelHandler((CancelHandler)handler, ((CompletedContinuation)state).cancelCause);
                    return;
                }
                update = CompletedContinuation.copy$default((CompletedContinuation)state, null, (CancelHandler)handler, null, null, null, 29, null);
                if (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update)) continue;
                return;
            }
            if (handler instanceof Segment) {
                return;
            }
            Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            CancelHandler cfr_ignored_1 = (CancelHandler)handler;
            update = new CompletedContinuation(state, (CancelHandler)handler, null, null, null, 28, null);
            if (CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update)) break;
        }
    }

    private final void multipleHandlersError(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final void dispatchResume(int mode) {
        if (this.tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, mode);
    }

    private final <R> Object resumedState(NotCompleted state, R proposedUpdate, int resumeMode, Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, Object idempotent) {
        Object object;
        if (proposedUpdate instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl2 = false;
                if (!(idempotent == null)) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!(onCancellation == null)) {
                    throw new AssertionError();
                }
            }
            object = proposedUpdate;
        } else {
            object = !DispatchedTaskKt.isCancellableMode(resumeMode) && idempotent == null ? proposedUpdate : (onCancellation != null || state instanceof CancelHandler || idempotent != null ? new CompletedContinuation(proposedUpdate, state instanceof CancelHandler ? (CancelHandler)state : null, onCancellation, idempotent, null, 16, null) : proposedUpdate);
        }
        return object;
    }

    public final <R> void resumeImpl$kotlinx_coroutines_core(R proposedUpdate, int resumeMode, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        Object v2;
        Object state;
        block3: {
            Object update;
            CancellableContinuationImpl cancellableContinuationImpl = this;
            AtomicReferenceFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._state$volatile$FU;
            do {
                state = handler$atomicfu$iv.get(this);
                boolean bl2 = false;
                v2 = state;
                if (!(v2 instanceof NotCompleted)) break block3;
                update = this.resumedState((NotCompleted)state, proposedUpdate, resumeMode, onCancellation, null);
            } while (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update));
            this.detachChildIfNonReusable();
            this.dispatchResume(resumeMode);
            return;
        }
        if (v2 instanceof CancelledContinuation && ((CancelledContinuation)state).makeResumed()) {
            Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> function3 = onCancellation;
            if (function3 != null) {
                Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> it = function3;
                boolean bl3 = false;
                this.callOnCancellation(it, ((CancelledContinuation)state).cause, proposedUpdate);
            }
            return;
        }
        this.alreadyResumedError(proposedUpdate);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl cancellableContinuationImpl, Object object, int n2, Function3 function3, int n3, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((n3 & 4) != 0) {
            function3 = null;
        }
        cancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core(object, n2, function3);
    }

    private final <R> Symbol tryResumeImpl(R proposedUpdate, Object idempotent, Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        Object v2;
        Object state;
        block6: {
            Object update;
            CancellableContinuationImpl cancellableContinuationImpl = this;
            AtomicReferenceFieldUpdater handler$atomicfu$iv = CancellableContinuationImpl._state$volatile$FU;
            do {
                state = handler$atomicfu$iv.get(this);
                boolean bl2 = false;
                v2 = state;
                if (!(v2 instanceof NotCompleted)) break block6;
                update = this.resumedState((NotCompleted)state, proposedUpdate, this.resumeMode, onCancellation, idempotent);
            } while (!CancellableContinuationImpl._state$volatile$FU.compareAndSet(this, state, update));
            this.detachChildIfNonReusable();
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
        if (v2 instanceof CompletedContinuation) {
            Symbol symbol;
            if (idempotent != null && ((CompletedContinuation)state).idempotentResume == idempotent) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(((CompletedContinuation)state).result, proposedUpdate)) {
                        throw new AssertionError();
                    }
                }
                symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            } else {
                symbol = null;
            }
            return symbol;
        }
        return null;
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void detachChildIfNonReusable() {
        if (!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.getParentHandle();
        if (disposableHandle == null) {
            return;
        }
        DisposableHandle handle = disposableHandle;
        handle.dispose();
        CancellableContinuationImpl._parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent) {
        return this.tryResumeImpl(value, idempotent, null);
    }

    @Override
    @Nullable
    public <R extends T> Object tryResume(R value, @Nullable Object idempotent, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        return this.tryResumeImpl(value, idempotent, onCancellation);
    }

    @Override
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable exception) {
        return this.tryResumeImpl(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    @Override
    public void completeResume(@NotNull Object token) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(token == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        this.dispatchResume(this.resumeMode);
    }

    @Override
    public void resumeUndispatched(@NotNull CoroutineDispatcher $this$resumeUndispatched, T value) {
        DispatchedContinuation dc2;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = dc2 = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, value, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == $this$resumeUndispatched ? 4 : this.resumeMode, null, 4, null);
    }

    @Override
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher $this$resumeUndispatchedWithException, @NotNull Throwable exception) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dc2 = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        DispatchedContinuation dispatchedContinuation = dc2;
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, new CompletedExceptionally(exception, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == $this$resumeUndispatchedWithException ? 4 : this.resumeMode, null, 4, null);
    }

    @Override
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object state) {
        return (T)(state instanceof CompletedContinuation ? ((CompletedContinuation)state).result : state);
    }

    @Override
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object state) {
        Throwable throwable;
        Throwable throwable2 = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (throwable2 != null) {
            Throwable it = throwable2;
            boolean bl2 = false;
            Continuation<T> continuation$iv = this.delegate;
            boolean $i$f$recoverStackTrace = false;
            throwable = !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? it : StackTraceRecoveryKt.access$recoverFromStackFrame(it, (CoroutineStackFrame)((Object)continuation$iv));
        } else {
            throwable = null;
        }
        return throwable;
    }

    @NotNull
    public String toString() {
        return this.nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + this.getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @NotNull
    protected String nameString() {
        return "CancellableContinuation";
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Integer, Unit> action$atomicfu) {
        while (true) {
            int n2 = handler$atomicfu.get(obj$atomicfu);
            action$atomicfu.invoke((Integer)n2);
        }
    }

    private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<? super Integer, Integer> action$atomicfu) {
        Integer n2;
        int n3;
        while (!handler$atomicfu.compareAndSet(obj$atomicfu, n3 = handler$atomicfu.get(obj$atomicfu), ((Number)(n2 = action$atomicfu.invoke((Integer)n3))).intValue())) {
        }
    }

    private static final Unit resume$lambda$13$lambda$12(Function1 $onCancellation, Throwable cause, Object object, CoroutineContext coroutineContext) {
        $onCancellation.invoke(cause);
        return Unit.INSTANCE;
    }

    static {
        _decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
        _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
        _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");
    }
}

