/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Empty;
import kotlinx.coroutines.InactiveNodeList;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.InvokeOnCancelling;
import kotlinx.coroutines.InvokeOnCompletion;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.NodeList;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ParentJob;
import kotlinx.coroutines.ResumeAwaitOnCompletion;
import kotlinx.coroutines.ResumeOnCompletion;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="This is internal API and may be removed in the future releases", level=DeprecationLevel.ERROR)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n\u00b7\u0001\u00b8\u0001\u00b9\u0001\u00ba\u0001\u00bb\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0004J\u001f\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u001b0\"H\u0082\bJ\u001c\u0010'\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001c\u001a\u00020(2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001e\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001a\u00100\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u00103\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020+H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020+H\u0002J\u0016\u00109\u001a\u00020\u001b*\u0002062\b\u00107\u001a\u0004\u0018\u00010+H\u0002J/\u0010:\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00050\"H\u0082\bJ\u0006\u0010=\u001a\u00020\u0005J\u0012\u0010>\u001a\u00020?2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010@\u001a\u00020\u001bH\u0014J\u000f\u0010A\u001a\u00060Bj\u0002`C\u00a2\u0006\u0002\u0010DJ!\u0010E\u001a\u00060Bj\u0002`C*\u00020+2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GH\u0004\u00a2\u0006\u0002\u0010HJ/\u0010N\u001a\u00020O2'\u0010P\u001a#\u0012\u0015\u0012\u0013\u0018\u00010+\u00a2\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001b0\"j\u0002`SJ?\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u00052'\u0010P\u001a#\u0012\u0015\u0012\u0013\u0018\u00010+\u00a2\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001b0\"j\u0002`SJ\u001d\u0010V\u001a\u00020O2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010W\u001a\u00020<H\u0000\u00a2\u0006\u0002\bXJ+\u0010Y\u001a\u00020\u00052\u0006\u0010W\u001a\u00020<2\u0018\u0010Z\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00050[H\u0082\bJ\u0010\u0010\\\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020<H\u0002J\u000e\u0010_\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u0005H\u0002J\u000e\u0010b\u001a\u00020\u001bH\u0082@\u00a2\u0006\u0002\u0010`J\u001e\u0010i\u001a\u00020\u001b2\n\u0010j\u001a\u0006\u0012\u0002\b\u00030k2\b\u0010l\u001a\u0004\u0018\u00010\u000eH\u0002J\u0015\u0010m\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020<H\u0000\u00a2\u0006\u0002\bnJ\u001d\u0010q\u001a\u00020\u001b2\u000e\u00107\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`CH\u0016\u00a2\u0006\u0002\u0010rJ\b\u0010s\u001a\u00020GH\u0014J\u0012\u0010q\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010+H\u0017J\u0010\u0010t\u001a\u00020\u001b2\u0006\u00107\u001a\u00020+H\u0016J\u000e\u0010u\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020\u0003J\u0010\u0010w\u001a\u00020\u00052\u0006\u00107\u001a\u00020+H\u0016J\u0010\u0010x\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010+J\u0017\u0010y\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0002\bzJ\u0014\u0010{\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010|\u001a\u00020}2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u00107\u001a\u0004\u0018\u00010+H\u0080\b\u00a2\u0006\u0002\b~J\u0011\u0010\u007f\u001a\u00060Bj\u0002`CH\u0016\u00a2\u0006\u0002\u0010DJ\u0013\u0010\u0080\u0001\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J\u0013\u0010\u0082\u0001\u001a\u0004\u0018\u0001062\u0006\u0010\u001c\u001a\u000201H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u0002012\u0006\u0010/\u001a\u00020+H\u0002J\u0019\u0010\u0084\u0001\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0003\b\u0085\u0001J\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0003\b\u0087\u0001J\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u0002012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u008d\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020(2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0082\u0010J%\u0010\u0090\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020(2\b\u0010\u0091\u0001\u001a\u00030\u008f\u00012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u0001*\u00030\u0093\u0001H\u0002J\u0010\u0010\u0098\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u0002J\u0018\u0010\u0099\u0001\u001a\u00020\u001b2\u0007\u0010\u009a\u0001\u001a\u00020+H\u0010\u00a2\u0006\u0003\b\u009b\u0001J\u0012\u0010T\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020+H\u0014J\u0013\u0010\u00a0\u0001\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0014J\u0013\u0010\u00a1\u0001\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0014J\t\u0010\u00a2\u0001\u001a\u00020GH\u0016J\t\u0010\u00a3\u0001\u001a\u00020GH\u0007J\u000f\u0010\u00a4\u0001\u001a\u00020GH\u0010\u00a2\u0006\u0003\b\u00a5\u0001J\u0013\u0010\u00a6\u0001\u001a\u00020G2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\t\u0010\u00aa\u0001\u001a\u0004\u0018\u00010+J\u0011\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0003\b\u00ac\u0001J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u000eH\u0084@\u00a2\u0006\u0002\u0010`J\u0011\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u000eH\u0082@\u00a2\u0006\u0002\u0010`J\u001f\u0010\u00b4\u0001\u001a\u00020\u001b2\n\u0010j\u001a\u0006\u0012\u0002\b\u00030k2\b\u0010l\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u00b5\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010l\u001a\u0004\u0018\u00010\u000e2\t\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\u000eH\u0002R\u0015\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004R(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u000e8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b%\u0010$R\u0011\u0010&\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b&\u0010$R\u0016\u0010I\u001a\u0004\u0018\u00010+8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010$R\u0017\u0010c\u001a\u00020d8F\u00a2\u0006\f\u0012\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0014\u0010o\u001a\u00020\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010$R\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010+*\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u0095\u00018F\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010$R\u0016\u0010\u009d\u0001\u001a\u00020\u00058PX\u0090\u0004\u00a2\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010$R\u001b\u0010\u00a7\u0001\u001a\u00020\u0005*\u0002018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0013\u0010\u00a9\u0001\u001a\u00020\u00058F\u00a2\u0006\u0007\u001a\u0005\b\u00a9\u0001\u0010$R#\u0010\u00af\u0001\u001a\u0007\u0012\u0002\b\u00030\u00b0\u00018DX\u0084\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00b1\u0001\u0010f\u001a\u0006\b\u00b2\u0001\u0010\u00b3\u0001\u00a8\u0006\u00bc\u0001"}, d2={"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "<init>", "(Z)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/ChildHandle;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "initParentJob", "", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "loopOnState", "", "block", "Lkotlin/Function1;", "isActive", "()Z", "isCompleted", "isCancelled", "finalizeFinishingState", "Lkotlinx/coroutines/JobSupport$Finishing;", "proposedUpdate", "getFinalRootCause", "", "exceptions", "", "addSuppressedExceptions", "rootCause", "tryFinalizeSimpleState", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "notifyCancelling", "list", "Lkotlinx/coroutines/NodeList;", "cause", "cancelParent", "notifyCompletion", "notifyHandlers", "predicate", "Lkotlinx/coroutines/JobNode;", "start", "startInternal", "", "onStart", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "toCancellationException", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "completionCause", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "invokeOnCompletionInternal", "node", "invokeOnCompletionInternal$kotlinx_coroutines_core", "tryPutNodeIntoList", "tryAdd", "Lkotlin/Function2;", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinInternal", "joinSuspend", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "()V", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "registerSelectForOnJoin", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "removeNode", "removeNode$kotlinx_coroutines_core", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "cancelInternal", "parentCancelled", "parentJob", "childCancelled", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelMakeCompleting", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "getChildJobCancellationCause", "createCauseException", "makeCancelling", "getOrPromoteCancellingList", "tryMakeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "tryMakeCompleting", "tryMakeCompletingSlowPath", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "tryWaitForChild", "child", "Lkotlinx/coroutines/ChildHandleNode;", "continueCompleting", "lastChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "handleOnCompletionException", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "isScopedCoroutine", "handlesException", "getHandlesException$kotlinx_coroutines_core", "handleJobException", "onCompletionInternal", "afterCompletion", "toString", "toDebugString", "nameString", "nameString$kotlinx_coroutines_core", "stateString", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "isCompletedExceptionally", "getCompletionExceptionOrNull", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "awaitInternal", "awaitSuspend", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwaitInternalRegFunc", "onAwaitInternalProcessResFunc", "result", "SelectOnJoinCompletionHandler", "Finishing", "ChildCompletion", "AwaitContinuation", "SelectOnAwaitCompletionHandler", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 9 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1583:1\n732#1,3:1587\n361#1,2:1597\n363#1,5:1602\n368#1,5:1608\n373#1,2:1616\n361#1,2:1618\n363#1,5:1623\n368#1,5:1629\n373#1,2:1637\n169#1,2:1645\n734#1:1647\n536#1:1648\n169#1,2:1649\n537#1,15:1651\n169#1,2:1666\n169#1,2:1668\n169#1,2:1681\n732#1,3:1683\n732#1,3:1686\n169#1,2:1689\n732#1,3:1691\n169#1,2:1694\n169#1,2:1698\n169#1,2:1700\n536#1:1704\n169#1,2:1705\n537#1,15:1707\n1#2:1584\n1#2:1607\n1#2:1628\n29#3:1585\n29#3:1696\n29#3:1702\n16#4:1586\n16#4:1697\n16#4:1703\n295#5,2:1590\n295#5,2:1592\n23#6:1594\n159#7:1595\n159#7:1596\n149#7,4:1722\n273#8,3:1599\n276#8,3:1613\n273#8,3:1620\n276#8,3:1634\n273#8,6:1639\n426#9,11:1670\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n241#1:1587,3\n324#1:1597,2\n324#1:1602,5\n324#1:1608,5\n324#1:1616,2\n357#1:1618,2\n357#1:1623,5\n357#1:1629,5\n357#1:1637,2\n377#1:1645,2\n422#1:1647\n468#1:1648\n468#1:1649,2\n468#1:1651,15\n536#1:1666,2\n579#1:1668,2\n621#1:1681,2\n648#1:1683,3\n657#1:1686,3\n721#1:1689,2\n750#1:1691,3\n763#1:1694,2\n836#1:1698,2\n858#1:1700,2\n1023#1:1704\n1023#1:1705,2\n1023#1:1707,15\n324#1:1607\n357#1:1628\n204#1:1585\n766#1:1696\n911#1:1702\n204#1:1586\n766#1:1697\n911#1:1703\n252#1:1590,2\n256#1:1592,2\n264#1:1594\n270#1:1595\n272#1:1596\n1327#1:1722,4\n324#1:1599,3\n324#1:1613,3\n357#1:1620,3\n357#1:1634,3\n362#1:1639,6\n585#1:1670,11\n*E\n"})
public class JobSupport
implements Job,
ChildJob,
ParentJob {
    private volatile /* synthetic */ Object _state$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU;

    public JobSupport(boolean active) {
        this._state$volatile = active ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
    }

    @Override
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
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

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)JobSupport._parentHandle$volatile$FU.get(this);
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle value) {
        JobSupport._parentHandle$volatile$FU.set(this, value);
    }

    @Override
    @Nullable
    public Job getParent() {
        ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
        return childHandle != null ? childHandle.getParent() : null;
    }

    protected final void initParentJob(@Nullable Job parent) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (parent == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle handle = parent.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core(handle);
        if (this.isCompleted()) {
            handle.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return JobSupport._state$volatile$FU.get(this);
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        boolean $i$f$loopOnState = false;
        while (true) {
            block.invoke(this.getState$kotlinx_coroutines_core());
        }
    }

    @Override
    public boolean isActive() {
        Object state = this.getState$kotlinx_coroutines_core();
        return state instanceof Incomplete && ((Incomplete)state).isActive();
    }

    @Override
    public final boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override
    public final boolean isCancelled() {
        Object state = this.getState$kotlinx_coroutines_core();
        return state instanceof CompletedExceptionally || state instanceof Finishing && ((Finishing)state).isCancelling();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) {
        Object finalState;
        Throwable throwable;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(!state.isSealed())) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl4 = false;
            if (!state.isCompleting()) {
                throw new AssertionError();
            }
        }
        CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally)proposedUpdate : null;
        Throwable proposedException = completedExceptionally != null ? completedExceptionally.cause : null;
        boolean wasCancelling = false;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Finishing finishing = state;
        synchronized (finishing) {
            boolean bl5 = false;
            wasCancelling = state.isCancelling();
            List<Throwable> exceptions = state.sealLocked(proposedException);
            Throwable finalCause = this.getFinalRootCause(state, exceptions);
            if (finalCause != null) {
                this.addSuppressedExceptions(finalCause, exceptions);
            }
            throwable = finalCause;
        }
        Throwable finalException = throwable;
        Object object = finalException == null ? proposedUpdate : (finalState = finalException == proposedException ? proposedUpdate : new CompletedExceptionally(finalException, false, 2, null));
        if (finalException != null) {
            boolean handled;
            boolean bl6 = handled = this.cancelParent(finalException) || this.handleJobException(finalException);
            if (handled) {
                Intrinsics.checkNotNull(finalState, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally)finalState).makeHandled();
            }
        }
        if (!wasCancelling) {
            this.onCancelling(finalException);
        }
        this.onCompletionInternal(finalState);
        boolean casSuccess = JobSupport._state$volatile$FU.compareAndSet(this, state, JobSupportKt.boxIncomplete(finalState));
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl7 = false;
            if (!casSuccess) {
                throw new AssertionError();
            }
        }
        this.completeStateFinalization(state, finalState);
        return finalState;
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Throwable firstNonCancellation;
        Object v0;
        block7: {
            if (exceptions.isEmpty()) {
                if (state.isCancelling()) {
                    Object message$iv = null;
                    Throwable cause$iv = null;
                    boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
                    return new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
                }
                return null;
            }
            Iterable $this$firstOrNull$iv = exceptions;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Throwable it = (Throwable)element$iv;
                boolean bl2 = false;
                if (!(!(it instanceof CancellationException))) continue;
                v0 = element$iv;
                break block7;
            }
            v0 = null;
        }
        Throwable throwable = firstNonCancellation = (Throwable)v0;
        if (throwable != null) {
            return throwable;
        }
        Throwable first = exceptions.get(0);
        if (first instanceof TimeoutCancellationException) {
            Object v2;
            block8: {
                Iterable $this$firstOrNull$iv = exceptions;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Throwable it = (Throwable)element$iv;
                    boolean bl3 = false;
                    if (!(it != first && it instanceof TimeoutCancellationException)) continue;
                    v2 = element$iv;
                    break block8;
                }
                v2 = null;
            }
            Throwable detailedTimeoutException = v2;
            if (detailedTimeoutException != null) {
                return detailedTimeoutException;
            }
        }
        return first;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        int expectedSize$iv = exceptions.size();
        boolean $i$f$identitySet = false;
        Set<Throwable> seenExceptions = Collections.newSetFromMap(new IdentityHashMap(expectedSize$iv));
        boolean $i$f$unwrap = false;
        Throwable unwrappedCause = !DebugKt.getRECOVER_STACK_TRACES() ? rootCause : StackTraceRecoveryKt.unwrapImpl(rootCause);
        for (Throwable throwable : exceptions) {
            boolean $i$f$unwrap2 = false;
            Throwable unwrapped = !DebugKt.getRECOVER_STACK_TRACES() ? throwable : StackTraceRecoveryKt.unwrapImpl(throwable);
            if (unwrapped == rootCause || unwrapped == unwrappedCause || unwrapped instanceof CancellationException || !seenExceptions.add(unwrapped)) continue;
            ExceptionsKt.addSuppressed(rootCause, unwrapped);
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(state instanceof Empty || state instanceof JobNode)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(!(update instanceof CompletedExceptionally))) {
                throw new AssertionError();
            }
        }
        if (!JobSupport._state$volatile$FU.compareAndSet(this, state, JobSupportKt.boxIncomplete(update))) {
            return false;
        }
        this.onCancelling(null);
        this.onCompletionInternal(update);
        this.completeStateFinalization(state, update);
        return true;
    }

    private final void completeStateFinalization(Incomplete state, Object update) {
        block4: {
            Throwable cause;
            block3: {
                ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
                if (childHandle != null) {
                    ChildHandle it = childHandle;
                    boolean bl2 = false;
                    it.dispose();
                    this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
                }
                CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally)update : null;
                Throwable throwable = cause = completedExceptionally != null ? completedExceptionally.cause : null;
                if (!(state instanceof JobNode)) break block3;
                try {
                    ((JobNode)state).invoke(cause);
                }
                catch (Throwable ex2) {
                    this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, ex2));
                }
                break block4;
            }
            NodeList nodeList = state.getList();
            if (nodeList == null) break block4;
            this.notifyCompletion(nodeList, cause);
        }
    }

    private final void notifyCancelling(NodeList list, Throwable cause) {
        this.onCancelling(cause);
        list.close(4);
        JobSupport this_$iv = this;
        boolean $i$f$notifyHandlers = false;
        CompletionHandlerException exception$iv = null;
        LockFreeLinkedListHead this_$iv$iv = list;
        boolean $i$f$forEach = false;
        Object object = this_$iv$iv.getNext();
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual(cur$iv$iv, this_$iv$iv)) {
            block7: {
                LockFreeLinkedListNode node$iv = cur$iv$iv;
                boolean bl2 = false;
                if (node$iv instanceof JobNode) {
                    JobNode it = (JobNode)node$iv;
                    boolean bl3 = false;
                    if (it.getOnCancelling()) {
                        try {
                            ((JobNode)node$iv).invoke(cause);
                        }
                        catch (Throwable ex$iv) {
                            Object object2 = exception$iv;
                            if (object2 != null) {
                                Throwable throwable;
                                Throwable $this$notifyHandlers_u24lambda_u2415_u24lambda_u2413$iv = throwable = object2;
                                boolean bl4 = false;
                                ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2415_u24lambda_u2413$iv, ex$iv);
                                object2 = throwable;
                                if (object2 != null) break block7;
                            }
                            JobSupport $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414$iv = this_$iv;
                            boolean bl5 = false;
                            exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414$iv, ex$iv);
                            object2 = Unit.INSTANCE;
                        }
                    }
                }
            }
            cur$iv$iv = cur$iv$iv.getNextNode();
        }
        Throwable throwable = exception$iv;
        if (throwable != null) {
            Throwable it$iv = throwable;
            boolean bl6 = false;
            this_$iv.handleOnCompletionException$kotlinx_coroutines_core(it$iv);
        }
        this.cancelParent(cause);
    }

    private final boolean cancelParent(Throwable cause) {
        if (this.isScopedCoroutine()) {
            return true;
        }
        boolean isCancellation = cause instanceof CancellationException;
        ChildHandle parent = this.getParentHandle$kotlinx_coroutines_core();
        if (parent == null || parent == NonDisposableHandle.INSTANCE) {
            return isCancellation;
        }
        return parent.childCancelled(cause) || isCancellation;
    }

    private final void notifyCompletion(NodeList $this$notifyCompletion, Throwable cause) {
        block7: {
            $this$notifyCompletion.close(1);
            JobSupport this_$iv = this;
            boolean $i$f$notifyHandlers = false;
            CompletionHandlerException exception$iv = null;
            LockFreeLinkedListHead this_$iv$iv = $this$notifyCompletion;
            boolean $i$f$forEach = false;
            Object object = this_$iv$iv.getNext();
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode)object;
            while (!Intrinsics.areEqual(cur$iv$iv, this_$iv$iv)) {
                block6: {
                    LockFreeLinkedListNode node$iv = cur$iv$iv;
                    boolean bl2 = false;
                    if (node$iv instanceof JobNode) {
                        JobNode it = (JobNode)node$iv;
                        boolean bl3 = false;
                        if (true) {
                            try {
                                ((JobNode)node$iv).invoke(cause);
                            }
                            catch (Throwable ex$iv) {
                                Object object2 = exception$iv;
                                if (object2 != null) {
                                    Throwable throwable;
                                    Throwable $this$notifyHandlers_u24lambda_u2415_u24lambda_u2413$iv = throwable = object2;
                                    boolean bl4 = false;
                                    ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2415_u24lambda_u2413$iv, ex$iv);
                                    object2 = throwable;
                                    if (object2 != null) break block6;
                                }
                                JobSupport $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414$iv = this_$iv;
                                boolean bl5 = false;
                                exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414$iv, ex$iv);
                                object2 = Unit.INSTANCE;
                            }
                        }
                    }
                }
                cur$iv$iv = cur$iv$iv.getNextNode();
            }
            Throwable throwable = exception$iv;
            if (throwable == null) break block7;
            Throwable it$iv = throwable;
            boolean bl6 = false;
            this_$iv.handleOnCompletionException$kotlinx_coroutines_core(it$iv);
        }
    }

    private final void notifyHandlers(NodeList list, Throwable cause, Function1<? super JobNode, Boolean> predicate) {
        block6: {
            boolean $i$f$notifyHandlers = false;
            CompletionHandlerException exception = null;
            LockFreeLinkedListHead this_$iv = list;
            boolean $i$f$forEach = false;
            Object object = this_$iv.getNext();
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode)object;
            while (!Intrinsics.areEqual(cur$iv, this_$iv)) {
                block5: {
                    LockFreeLinkedListNode node = cur$iv;
                    boolean bl2 = false;
                    if (node instanceof JobNode && predicate.invoke((JobNode)node).booleanValue()) {
                        try {
                            ((JobNode)node).invoke(cause);
                        }
                        catch (Throwable ex2) {
                            Object object2 = exception;
                            if (object2 != null) {
                                Throwable throwable;
                                Throwable $this$notifyHandlers_u24lambda_u2415_u24lambda_u2413 = throwable = object2;
                                boolean bl3 = false;
                                ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2415_u24lambda_u2413, ex2);
                                object2 = throwable;
                                if (object2 != null) break block5;
                            }
                            JobSupport $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414 = this;
                            boolean bl4 = false;
                            exception = new CompletionHandlerException("Exception in completion handler " + node + " for " + $this$notifyHandlers_u24lambda_u2415_u24lambda_u2414, ex2);
                            object2 = Unit.INSTANCE;
                        }
                    }
                }
                cur$iv = cur$iv.getNextNode();
            }
            Throwable throwable = exception;
            if (throwable == null) break block6;
            Throwable it = throwable;
            boolean bl5 = false;
            this.handleOnCompletionException$kotlinx_coroutines_core(it);
        }
    }

    @Override
    public final boolean start() {
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        while (true) {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl2 = false;
            switch (this.startInternal(state)) {
                case 0: {
                    return false;
                }
                case 1: {
                    return true;
                }
            }
        }
    }

    private final int startInternal(Object state) {
        Object object = state;
        if (object instanceof Empty) {
            if (((Empty)state).isActive()) {
                return 0;
            }
            if (!JobSupport._state$volatile$FU.compareAndSet(this, state, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        if (object instanceof InactiveNodeList) {
            if (!JobSupport._state$volatile$FU.compareAndSet(this, state, ((InactiveNodeList)state).getList())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        return 0;
    }

    protected void onStart() {
    }

    @Override
    @NotNull
    public final CancellationException getCancellationException() {
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
            if (throwable == null || (throwable = this.toCancellationException(throwable, DebugStringsKt.getClassSimpleName(this) + " is cancelling")) == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
        } else {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            throwable = state instanceof CompletedExceptionally ? JobSupport.toCancellationException$default(this, ((CompletedExceptionally)state).cause, null, 1, null) : (CancellationException)new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
        return throwable;
    }

    @NotNull
    protected final CancellationException toCancellationException(@NotNull Throwable $this$toCancellationException, @Nullable String message) {
        CancellationException cancellationException = $this$toCancellationException instanceof CancellationException ? (CancellationException)$this$toCancellationException : null;
        if (cancellationException == null) {
            JobSupport this_$iv = this;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            String string = message;
            if (string == null) {
                string = this_$iv.cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(string, $this$toCancellationException, this_$iv);
        }
        return cancellationException;
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable throwable, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((n2 & 1) != 0) {
            string = null;
        }
        return jobSupport.toCancellationException(throwable, string);
    }

    @Nullable
    protected final Throwable getCompletionCause() {
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
            if (throwable == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
        } else {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            throwable = state instanceof CompletedExceptionally ? ((CompletedExceptionally)state).cause : null;
        }
        return throwable;
    }

    protected final boolean getCompletionCauseHandled() {
        Object it = this.getState$kotlinx_coroutines_core();
        boolean bl2 = false;
        return it instanceof CompletedExceptionally && ((CompletedExceptionally)it).getHandled();
    }

    @Override
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return this.invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(handler));
    }

    @Override
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        return this.invokeOnCompletionInternal$kotlinx_coroutines_core(invokeImmediately, onCancelling ? (JobNode)new InvokeOnCancelling(handler) : (JobNode)new InvokeOnCompletion(handler));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @NotNull
    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean invokeImmediately, @NotNull JobNode node) {
        boolean bl2;
        block11: {
            block12: {
                node.setJob(this);
                JobSupport this_$iv = this;
                boolean $i$f$tryPutNodeIntoList = false;
                JobSupport this_$iv$iv = this_$iv;
                boolean $i$f$loopOnState = false;
                while (true) {
                    boolean bl3;
                    block13: {
                        void list;
                        Object state$iv = this_$iv$iv.getState$kotlinx_coroutines_core();
                        boolean bl4 = false;
                        Object object = state$iv;
                        if (object instanceof Empty) {
                            if (((Empty)state$iv).isActive()) {
                                if (!JobSupport._state$volatile$FU.compareAndSet(this_$iv, state$iv, node)) continue;
                                bl2 = true;
                                break block11;
                            } else {
                                this_$iv.promoteEmptyToNodeList((Empty)state$iv);
                                continue;
                            }
                        }
                        if (!(object instanceof Incomplete)) break block12;
                        NodeList list$iv = ((Incomplete)state$iv).getList();
                        if (list$iv == null) {
                            Object object2 = state$iv;
                            Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                            this_$iv.promoteSingleToNodeList((JobNode)object2);
                            continue;
                        }
                        NodeList nodeList = list$iv;
                        Incomplete state = (Incomplete)state$iv;
                        boolean bl5 = false;
                        if (node.getOnCancelling()) {
                            Throwable rootCause;
                            Finishing finishing = state instanceof Finishing ? (Finishing)state : null;
                            Throwable throwable = rootCause = finishing != null ? finishing.getRootCause() : null;
                            if (rootCause == null) {
                                bl3 = list.addLast(node, 5);
                                break block13;
                            } else {
                                if (invokeImmediately) {
                                    node.invoke(rootCause);
                                }
                                return NonDisposableHandle.INSTANCE;
                            }
                        }
                        bl3 = list.addLast(node, 1);
                    }
                    if (bl3) break;
                }
                bl2 = true;
                break block11;
            }
            bl2 = false;
        }
        boolean added = bl2;
        if (added) {
            return node;
        }
        if (invokeImmediately) {
            Object object = this.getState$kotlinx_coroutines_core();
            CompletedExceptionally completedExceptionally = object instanceof CompletedExceptionally ? (CompletedExceptionally)object : null;
            node.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
        }
        return NonDisposableHandle.INSTANCE;
    }

    private final boolean tryPutNodeIntoList(JobNode node, Function2<? super Incomplete, ? super NodeList, Boolean> tryAdd) {
        block4: {
            boolean $i$f$tryPutNodeIntoList = false;
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            while (true) {
                Object state = this_$iv.getState$kotlinx_coroutines_core();
                boolean bl2 = false;
                Object object = state;
                if (object instanceof Empty) {
                    if (((Empty)state).isActive()) {
                        if (!JobSupport._state$volatile$FU.compareAndSet(this, state, node)) continue;
                        return true;
                    }
                    this.promoteEmptyToNodeList((Empty)state);
                    continue;
                }
                if (!(object instanceof Incomplete)) break block4;
                NodeList list = ((Incomplete)state).getList();
                if (list == null) {
                    Object object2 = state;
                    Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    this.promoteSingleToNodeList((JobNode)object2);
                    continue;
                }
                if (tryAdd.invoke((Incomplete)state, list).booleanValue()) break;
            }
            return true;
        }
        return false;
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList list = new NodeList();
        Incomplete update = state.isActive() ? (Incomplete)list : (Incomplete)new InactiveNodeList(list);
        JobSupport._state$volatile$FU.compareAndSet(this, state, update);
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode list = state.getNextNode();
        JobSupport._state$volatile$FU.compareAndSet(this, state, list);
    }

    @Override
    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> $completion) {
        if (!this.joinInternal()) {
            JobKt.ensureActive($completion.getContext());
            return Unit.INSTANCE;
        }
        Object object = this.joinSuspend($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final boolean joinInternal() {
        Object state;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl2 = false;
            if (state instanceof Incomplete) continue;
            return false;
        } while (this.startInternal(state) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl<? super Unit> cancellable$iv = new CancellableContinuationImpl<Unit>(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl3 = false;
        CancellableContinuationKt.disposeOnCancellation(cont, JobKt.invokeOnCompletion$default(this, false, new ResumeOnCompletion(cont), 1, null));
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @NotNull
    public final SelectClause0 getOnJoin() {
        onJoin.1 v0 = onJoin.1.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0, 3), null, 4, null);
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void registerSelectForOnJoin(SelectInstance<?> select, Object ignoredParam) {
        if (!this.joinInternal()) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        DisposableHandle disposableHandle = JobKt.invokeOnCompletion$default(this, false, new SelectOnJoinCompletionHandler(select), 1, null);
        select.disposeOnCompletion(disposableHandle);
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode node) {
        Object object;
        Object state;
        block3: {
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            do {
                state = this_$iv.getState$kotlinx_coroutines_core();
                boolean bl2 = false;
                object = state;
                if (!(object instanceof JobNode)) break block3;
                if (state == node) continue;
                return;
            } while (!JobSupport._state$volatile$FU.compareAndSet(this, state, JobSupportKt.access$getEMPTY_ACTIVE$p()));
            return;
        }
        if (object instanceof Incomplete) {
            if (((Incomplete)state).getList() != null) {
                node.remove();
            }
            return;
        }
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override
    public void cancel(@Nullable CancellationException cause) {
        CancellationException cancellationException = cause;
        if (cancellationException == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            cancellationException = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
        }
        this.cancelInternal(cancellationException);
    }

    @NotNull
    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    @Override
    @Deprecated(message="Added since 1.2.0 for binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable cause) {
        Throwable throwable = cause;
        if (throwable == null || (throwable = JobSupport.toCancellationException$default(this, throwable, null, 1, null)) == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            throwable = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
        }
        this.cancelInternal(throwable);
        return true;
    }

    public void cancelInternal(@NotNull Throwable cause) {
        this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        this.cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(@NotNull Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return this.cancelImpl$kotlinx_coroutines_core(cause) && this.getHandlesException$kotlinx_coroutines_core();
    }

    public final boolean cancelCoroutine(@Nullable Throwable cause) {
        return this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object cause) {
        boolean bl2;
        Object finalState = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if (this.getOnCancelComplete$kotlinx_coroutines_core() && (finalState = this.cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            finalState = this.makeCancelling(cause);
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            bl2 = true;
        } else if (finalState == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            bl2 = true;
        } else if (finalState == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
            bl2 = false;
        } else {
            this.afterCompletion(finalState);
            bl2 = true;
        }
        return bl2;
    }

    private final Object cancelMakeCompleting(Object cause) {
        CompletedExceptionally proposedUpdate;
        Object state;
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl2 = false;
            if (state instanceof Incomplete && (!(state instanceof Finishing) || !((Finishing)state).isCompleting())) continue;
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        } while ((finalState = this.tryMakeCompleting(state, proposedUpdate = new CompletedExceptionally(this.createCauseException(cause), false, 2, null))) == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return finalState;
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String message, @Nullable Throwable cause) {
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        String string = message;
        if (string == null) {
            string = this.cancellationExceptionMessage();
        }
        return new JobCancellationException(string, cause, this);
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport $this, String message, Throwable cause, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((n2 & 1) != 0) {
            message = null;
        }
        if ((n2 & 2) != 0) {
            cause = null;
        }
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        String string = message;
        if (string == null) {
            string = $this.cancellationExceptionMessage();
        }
        return new JobCancellationException(string, cause, $this);
    }

    @Override
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Throwable rootCause;
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        Object object = state;
        if (object instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
        } else if (object instanceof CompletedExceptionally) {
            throwable = ((CompletedExceptionally)state).cause;
        } else {
            if (object instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state).toString());
            }
            throwable = rootCause = null;
        }
        if ((cancellationException = rootCause instanceof CancellationException ? (CancellationException)rootCause : null) == null) {
            cancellationException = new JobCancellationException("Parent job is " + this.stateString(state), rootCause, this);
        }
        return cancellationException;
    }

    private final Throwable createCauseException(Object cause) {
        Throwable throwable;
        Object object = cause;
        if (object == null ? true : object instanceof Throwable) {
            throwable = (Throwable)cause;
            if (throwable == null) {
                Object message$iv = null;
                Throwable cause$iv = null;
                boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
                throwable = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
            }
        } else {
            Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            throwable = ((ParentJob)cause).getChildJobCancellationCause();
        }
        return throwable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object makeCancelling(Object cause) {
        block13: {
            Object finalState;
            Throwable causeExceptionCache = null;
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            while (true) {
                Throwable causeException;
                Object state = this_$iv.getState$kotlinx_coroutines_core();
                boolean bl2 = false;
                Object object = state;
                if (object instanceof Finishing) {
                    Throwable notifyRootCause;
                    Throwable throwable;
                    Object lock$iv = state;
                    boolean $i$f$synchronized = false;
                    boolean $i$f$synchronizedImpl = false;
                    Object object2 = lock$iv;
                    synchronized (object2) {
                        Throwable throwable2;
                        block12: {
                            boolean bl3 = false;
                            if (!((Finishing)state).isSealed()) break block12;
                            Symbol symbol = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                            return symbol;
                        }
                        boolean wasCancelling = ((Finishing)state).isCancelling();
                        if (cause != null || !wasCancelling) {
                            Throwable throwable3 = causeExceptionCache;
                            if (throwable3 == null) {
                                Throwable throwable4;
                                Throwable it = throwable4 = this.createCauseException(cause);
                                boolean bl4 = false;
                                causeExceptionCache = it;
                                throwable3 = throwable4;
                            }
                            Throwable causeException2 = throwable3;
                            ((Finishing)state).addExceptionLocked(causeException2);
                        }
                        Throwable it = throwable2 = ((Finishing)state).getRootCause();
                        boolean bl5 = false;
                        throwable = !wasCancelling ? throwable2 : null;
                    }
                    Throwable throwable5 = notifyRootCause = throwable;
                    if (throwable5 != null) {
                        Throwable it = throwable5;
                        boolean bl6 = false;
                        this.notifyCancelling(((Finishing)state).getList(), it);
                    }
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                if (!(object instanceof Incomplete)) break block13;
                Throwable throwable = causeExceptionCache;
                if (throwable == null) {
                    Throwable throwable6;
                    Throwable it = throwable6 = this.createCauseException(cause);
                    boolean bl7 = false;
                    causeExceptionCache = it;
                    throwable = causeException = throwable6;
                }
                if (((Incomplete)state).isActive()) {
                    if (!this.tryMakeCancelling((Incomplete)state, causeException)) continue;
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                finalState = this.tryMakeCompleting(state, new CompletedExceptionally(causeException, false, 2, null));
                if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                    throw new IllegalStateException(("Cannot happen in " + state).toString());
                }
                if (finalState != JobSupportKt.access$getCOMPLETING_RETRY$p()) break;
            }
            return finalState;
        }
        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList nodeList = state.getList();
        if (nodeList == null) {
            Incomplete incomplete = state;
            if (incomplete instanceof Empty) {
                nodeList = new NodeList();
            } else if (incomplete instanceof JobNode) {
                this.promoteSingleToNodeList((JobNode)state);
                nodeList = null;
            } else {
                throw new IllegalStateException(("State should have list: " + state).toString());
            }
        }
        return nodeList;
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(!(state instanceof Finishing))) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!state.isActive()) {
                throw new AssertionError();
            }
        }
        NodeList nodeList = this.getOrPromoteCancellingList(state);
        if (nodeList == null) {
            return false;
        }
        NodeList list = nodeList;
        Finishing cancelling = new Finishing(list, false, rootCause);
        if (!JobSupport._state$volatile$FU.compareAndSet(this, state, cancelling)) {
            return false;
        }
        this.notifyCancelling(list, rootCause);
        return true;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl2 = false;
            finalState = this.tryMakeCompleting(state, proposedUpdate);
            if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if (finalState != JobSupportKt.COMPLETING_WAITING_CHILDREN) continue;
            return true;
        } while (finalState == JobSupportKt.access$getCOMPLETING_RETRY$p());
        this.afterCompletion(finalState);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl2 = false;
            finalState = this.tryMakeCompleting(state, proposedUpdate);
            if (finalState != JobSupportKt.access$getCOMPLETING_ALREADY$p()) continue;
            throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, this.getExceptionOrNull(proposedUpdate));
        } while (finalState == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return finalState;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        if (!(state instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if ((state instanceof Empty || state instanceof JobNode) && !(state instanceof ChildHandleNode) && !(proposedUpdate instanceof CompletedExceptionally)) {
            if (this.tryFinalizeSimpleState((Incomplete)state, proposedUpdate)) {
                return proposedUpdate;
            }
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        return this.tryMakeCompletingSlowPath((Incomplete)state, proposedUpdate);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) {
        NodeList nodeList = this.getOrPromoteCancellingList(state);
        if (nodeList == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        NodeList list = nodeList;
        Finishing finishing = state instanceof Finishing ? (Finishing)state : null;
        if (finishing == null) {
            finishing = new Finishing(list, false, null);
        }
        Finishing finishing2 = finishing;
        Ref.ObjectRef notifyRootCause = new Ref.ObjectRef();
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Finishing finishing3 = finishing2;
        synchronized (finishing3) {
            Throwable throwable;
            block14: {
                block13: {
                    boolean bl2 = false;
                    if (!finishing2.isCompleting()) break block13;
                    Symbol symbol = JobSupportKt.access$getCOMPLETING_ALREADY$p();
                    return symbol;
                }
                finishing2.setCompleting(true);
                if (finishing2 == state || JobSupport._state$volatile$FU.compareAndSet(this, state, finishing2)) break block14;
                Symbol symbol = JobSupportKt.access$getCOMPLETING_RETRY$p();
                return symbol;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!(!finishing2.isSealed())) {
                    throw new AssertionError();
                }
            }
            boolean wasCancelling = finishing2.isCancelling();
            CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally)proposedUpdate : null;
            if (completedExceptionally != null) {
                CompletedExceptionally it = completedExceptionally;
                boolean bl4 = false;
                finishing2.addExceptionLocked(it.cause);
            }
            Throwable throwable2 = throwable = finishing2.getRootCause();
            Ref.ObjectRef objectRef = notifyRootCause;
            boolean bl5 = false;
            objectRef.element = Boolean.valueOf(!wasCancelling) != false ? throwable : null;
            Unit unit = Unit.INSTANCE;
        }
        Throwable throwable = (Throwable)notifyRootCause.element;
        if (throwable != null) {
            Throwable it = throwable;
            boolean bl6 = false;
            this.notifyCancelling(list, it);
        }
        ChildHandleNode child = this.nextChild(list);
        if (child != null && this.tryWaitForChild(finishing2, child, proposedUpdate)) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
        list.close(2);
        ChildHandleNode anotherChild = this.nextChild(list);
        if (anotherChild != null && this.tryWaitForChild(finishing2, anotherChild, proposedUpdate)) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
        return this.finalizeFinishingState(finishing2, proposedUpdate);
    }

    private final Throwable getExceptionOrNull(Object $this$exceptionOrNull) {
        CompletedExceptionally completedExceptionally = $this$exceptionOrNull instanceof CompletedExceptionally ? (CompletedExceptionally)$this$exceptionOrNull : null;
        return completedExceptionally != null ? completedExceptionally.cause : null;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        JobSupport jobSupport = this;
        DisposableHandle handle;
        while ((handle = JobKt.invokeOnCompletion(child.childJob, false, new ChildCompletion(jobSupport, state, child, proposedUpdate))) == NonDisposableHandle.INSTANCE) {
            ChildHandleNode nextChild;
            if (jobSupport.nextChild(child) == null) {
                return false;
            }
            JobSupport jobSupport2 = jobSupport;
            Finishing finishing = state;
            Object object = proposedUpdate;
            jobSupport = jobSupport2;
            state = finishing;
            child = nextChild;
            proposedUpdate = object;
        }
        return true;
    }

    private final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        ChildHandleNode waitChild;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        if ((waitChild = this.nextChild(lastChild)) != null && this.tryWaitForChild(state, waitChild, proposedUpdate)) {
            return;
        }
        state.getList().close(2);
        ChildHandleNode waitChildAgain = this.nextChild(lastChild);
        if (waitChildAgain != null && this.tryWaitForChild(state, waitChildAgain, proposedUpdate)) {
            return;
        }
        Object finalState = this.finalizeFinishingState(state, proposedUpdate);
        this.afterCompletion(finalState);
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode $this$nextChild) {
        LockFreeLinkedListNode cur = $this$nextChild;
        while (cur.isRemoved()) {
            cur = cur.getPrevNode();
        }
        while (true) {
            if ((cur = cur.getNextNode()).isRemoved()) {
                continue;
            }
            if (cur instanceof ChildHandleNode) {
                return (ChildHandleNode)cur;
            }
            if (cur instanceof NodeList) break;
        }
        return null;
    }

    @Override
    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence((Function2)new Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object>(this, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ JobSupport this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object var1_1) {
                block9: {
                    var11_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(var1_1);
                            $this$sequence = (SequenceScope)this.L$0;
                            state = this.this$0.getState$kotlinx_coroutines_core();
                            if (!(state instanceof ChildHandleNode)) break;
                            this.label = 1;
                            v0 = $this$sequence.yield(((ChildHandleNode)state).childJob, this);
                            if (v0 == var11_2) {
                                return var11_2;
                            }
                            break;
                        }
                        case 1: {
                            ResultKt.throwOnFailure($result);
                            v0 = $result;
                            break;
                        }
                    }
                    if (!(state instanceof Incomplete)) break block9;
                    v1 = ((Incomplete)state).getList();
                    if (v1 == null) break block9;
                    list = v1;
                    $i$a$-let-JobSupport$children$1$1 = false;
                    this_$iv = list;
                    $i$f$forEach = false;
                    v2 = this_$iv.getNext();
                    Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                    cur$iv = (LockFreeLinkedListNode)v2;
lbl27:
                    // 2 sources

                    while (!Intrinsics.areEqual(cur$iv, this_$iv)) {
                        it = cur$iv;
                        $i$a$-forEach-JobSupport$children$1$1$1 = false;
                        if (it instanceof ChildHandleNode) {
                            this.L$0 = $this$sequence;
                            this.L$1 = this_$iv;
                            this.L$2 = cur$iv;
                            this.label = 2;
                            v3 = $this$sequence.yield(((ChildHandleNode)it).childJob, this);
                            if (v3 == var11_2) {
                                return var11_2;
                            }
                        }
                        ** GOTO lbl49
                    }
                    {
                        break;
                        case 2: {
                            $i$a$-let-JobSupport$children$1$1 = false;
                            $i$f$forEach = false;
                            $i$a$-forEach-JobSupport$children$1$1$1 = false;
                            cur$iv = (LockFreeLinkedListNode)this.L$2;
                            this_$iv = (LockFreeLinkedListHead)this.L$1;
                            $this$sequence = (SequenceScope)this.L$0;
                            ResultKt.throwOnFailure($result);
                            v3 = $result;
lbl49:
                            // 2 sources

                            cur$iv = cur$iv.getNextNode();
                            ** GOTO lbl27
                        }
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(SequenceScope<? super Job> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob child) {
        boolean bl2;
        ChildHandleNode node;
        block15: {
            block16: {
                ChildHandleNode childHandleNode;
                ChildHandleNode it = childHandleNode = new ChildHandleNode(child);
                boolean bl3 = false;
                it.setJob(this);
                node = childHandleNode;
                JobSupport this_$iv = this;
                boolean $i$f$tryPutNodeIntoList = false;
                JobSupport this_$iv$iv = this_$iv;
                boolean $i$f$loopOnState = false;
                while (true) {
                    boolean bl4;
                    void list;
                    Object state$iv = this_$iv$iv.getState$kotlinx_coroutines_core();
                    boolean bl5 = false;
                    Object object = state$iv;
                    if (object instanceof Empty) {
                        if (((Empty)state$iv).isActive()) {
                            if (!JobSupport._state$volatile$FU.compareAndSet(this_$iv, state$iv, (JobNode)node)) continue;
                            bl2 = true;
                            break block15;
                        }
                        this_$iv.promoteEmptyToNodeList((Empty)state$iv);
                        continue;
                    }
                    if (!(object instanceof Incomplete)) break block16;
                    NodeList list$iv = ((Incomplete)state$iv).getList();
                    if (list$iv == null) {
                        Object object2 = state$iv;
                        Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this_$iv.promoteSingleToNodeList((JobNode)object2);
                        continue;
                    }
                    NodeList nodeList = list$iv;
                    Incomplete cfr_ignored_0 = (Incomplete)state$iv;
                    boolean bl6 = false;
                    boolean addedBeforeCancellation = list.addLast(node, 7);
                    if (addedBeforeCancellation) {
                        bl4 = true;
                    } else {
                        Throwable throwable;
                        boolean addedBeforeCompletion = list.addLast(node, 3);
                        Object latestState = this.getState$kotlinx_coroutines_core();
                        if (latestState instanceof Finishing) {
                            throwable = ((Finishing)latestState).getRootCause();
                        } else {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                boolean bl7 = false;
                                if (!(!(latestState instanceof Incomplete))) {
                                    throw new AssertionError();
                                }
                            }
                            CompletedExceptionally completedExceptionally = latestState instanceof CompletedExceptionally ? (CompletedExceptionally)latestState : null;
                            throwable = completedExceptionally != null ? completedExceptionally.cause : null;
                        }
                        Throwable rootCause = throwable;
                        node.invoke(rootCause);
                        if (addedBeforeCompletion) {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                boolean bl8 = false;
                                if (!(rootCause != null)) {
                                    throw new AssertionError();
                                }
                            }
                            bl4 = true;
                        } else {
                            return NonDisposableHandle.INSTANCE;
                        }
                    }
                    if (bl4) break;
                }
                bl2 = true;
                break block15;
            }
            bl2 = false;
        }
        boolean added = bl2;
        if (added) {
            return node;
        }
        Object object = this.getState$kotlinx_coroutines_core();
        CompletedExceptionally completedExceptionally = object instanceof CompletedExceptionally ? (CompletedExceptionally)object : null;
        node.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
        return NonDisposableHandle.INSTANCE;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable exception) {
        throw exception;
    }

    protected void onCancelling(@Nullable Throwable cause) {
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    protected boolean handleJobException(@NotNull Throwable exception) {
        return false;
    }

    protected void onCompletionInternal(@Nullable Object state) {
    }

    protected void afterCompletion(@Nullable Object state) {
    }

    @NotNull
    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return this.nameString$kotlinx_coroutines_core() + '{' + this.stateString(this.getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        Object object = state;
        return object instanceof Finishing ? (((Finishing)state).isCancelling() ? "Cancelling" : (((Finishing)state).isCompleting() ? "Completing" : "Active")) : (object instanceof Incomplete ? (((Incomplete)state).isActive() ? "Active" : "New") : (object instanceof CompletedExceptionally ? "Cancelled" : "Completed"));
    }

    private final boolean isCancelling(Incomplete $this$isCancelling) {
        return $this$isCancelling instanceof Finishing && ((Finishing)$this$isCancelling).isCancelling();
    }

    public final boolean isCompletedExceptionally() {
        return this.getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state = this.getState$kotlinx_coroutines_core();
        if (!(!(state instanceof Incomplete))) {
            boolean bl2 = false;
            String string = "This job has not completed yet";
            throw new IllegalStateException(string.toString());
        }
        return this.getExceptionOrNull(state);
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state = this.getState$kotlinx_coroutines_core();
        if (!(!(state instanceof Incomplete))) {
            boolean bl2 = false;
            String string = "This job has not completed yet";
            throw new IllegalStateException(string.toString());
        }
        if (state instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)state).cause;
        }
        return JobSupportKt.unboxState(state);
    }

    @Nullable
    protected final Object awaitInternal(@NotNull Continuation<Object> $completion) {
        Object state;
        do {
            if ((state = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            if (state instanceof CompletedExceptionally) {
                Throwable exception$iv = ((CompletedExceptionally)state).cause;
                boolean $i$f$recoverAndThrow = false;
                if (!DebugKt.getRECOVER_STACK_TRACES()) {
                    throw exception$iv;
                }
                Continuation<Object> it$iv = $completion;
                boolean bl2 = false;
                if (!(it$iv instanceof CoroutineStackFrame)) {
                    throw exception$iv;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)((Object)it$iv));
            }
            return JobSupportKt.unboxState(state);
        } while (this.startInternal(state) < 0);
        return this.awaitSuspend($completion);
    }

    private final Object awaitSuspend(Continuation<Object> $completion) {
        Continuation<Object> uCont = $completion;
        boolean bl2 = false;
        AwaitContinuation<Object> cont = new AwaitContinuation<Object>(IntrinsicsKt.intercepted(uCont), this);
        cont.initCancellability();
        CancellableContinuationKt.disposeOnCancellation((CancellableContinuation)cont, JobKt.invokeOnCompletion$default(this, false, new ResumeAwaitOnCompletion(cont), 1, null));
        Object object = cont.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @NotNull
    protected final SelectClause1<?> getOnAwaitInternal() {
        onAwaitInternal.1 v0 = onAwaitInternal.1.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0, 3);
        onAwaitInternal.2 v2 = onAwaitInternal.2.INSTANCE;
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2, 3), null, 8, null);
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    private final void onAwaitInternalRegFunc(SelectInstance<?> select, Object ignoredParam) {
        Object state;
        do {
            if ((state = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            Object result = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
            select.selectInRegistrationPhase(result);
            return;
        } while (this.startInternal(state) < 0);
        DisposableHandle disposableHandle = JobKt.invokeOnCompletion$default(this, false, new SelectOnAwaitCompletionHandler(select), 1, null);
        select.disposeOnCompletion(disposableHandle);
    }

    private final Object onAwaitInternalProcessResFunc(Object ignoredParam, Object result) {
        if (result instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)result).cause;
        }
        return result;
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override
    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job other) {
        return Job.DefaultImpls.plus((Job)this, other);
    }

    @Override
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        return Job.DefaultImpls.plus((Job)this, context);
    }

    @Override
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.get(this, key);
    }

    @Override
    public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return Job.DefaultImpls.fold(this, initial, operation);
    }

    @Override
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    public static final /* synthetic */ Object access$joinSuspend(JobSupport $this, Continuation $completion) {
        return $this.joinSuspend($completion);
    }

    public static final /* synthetic */ void access$registerSelectForOnJoin(JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.registerSelectForOnJoin(select, ignoredParam);
    }

    public static final /* synthetic */ Object access$awaitSuspend(JobSupport $this, Continuation $completion) {
        return $this.awaitSuspend($completion);
    }

    public static final /* synthetic */ void access$onAwaitInternalRegFunc(JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.onAwaitInternalRegFunc(select, ignoredParam);
    }

    public static final /* synthetic */ Object access$onAwaitInternalProcessResFunc(JobSupport $this, Object ignoredParam, Object result) {
        return $this.onAwaitInternalProcessResFunc(ignoredParam, result);
    }

    static {
        _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
        _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    private static final class AwaitContinuation<T>
    extends CancellableContinuationImpl<T> {
        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> delegate, @NotNull JobSupport job) {
            super(delegate, 1);
            this.job = job;
        }

        @Override
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job parent) {
            Throwable throwable;
            Object state = this.job.getState$kotlinx_coroutines_core();
            if (state instanceof Finishing && (throwable = ((Finishing)state).getRootCause()) != null) {
                Throwable it = throwable;
                boolean bl2 = false;
                return it;
            }
            if (state instanceof CompletedExceptionally) {
                return ((CompletedExceptionally)state).cause;
            }
            return parent.getCancellationException();
        }

        @Override
        @NotNull
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"})
    private static final class ChildCompletion
    extends JobNode {
        @NotNull
        private final JobSupport parent;
        @NotNull
        private final Finishing state;
        @NotNull
        private final ChildHandleNode child;
        @Nullable
        private final Object proposedUpdate;

        public ChildCompletion(@NotNull JobSupport parent, @NotNull Finishing state, @NotNull ChildHandleNode child, @Nullable Object proposedUpdate) {
            this.parent = parent;
            this.state = state;
            this.child = child;
            this.proposedUpdate = proposedUpdate;
        }

        @Override
        public boolean getOnCancelling() {
            return false;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$2\b\u0010%\u001a\u0004\u0018\u00010\tJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tJ\u0018\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\t0*j\b\u0012\u0004\u0012\u00020\t`+H\u0002J\b\u0010,\u001a\u00020-H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015X\u0082\u0004R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015X\u0082\u0004R(\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0011R\u0011\u0010!\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0011\u00a8\u0006."}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "getList", "()Lkotlinx/coroutines/NodeList;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "()Z", "setCompleting", "(Z)V", "_rootCause", "Lkotlinx/atomicfu/AtomicRef;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "_exceptionsHolder", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isSealed", "isCancelling", "isActive", "sealLocked", "", "proposedException", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    private static final class Finishing
    implements Incomplete {
        @NotNull
        private final NodeList list;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleting$volatile$FU;
        private static final /* synthetic */ AtomicReferenceFieldUpdater _rootCause$volatile$FU;
        private static final /* synthetic */ AtomicReferenceFieldUpdater _exceptionsHolder$volatile$FU;

        public Finishing(@NotNull NodeList list, boolean isCompleting, @Nullable Throwable rootCause) {
            this.list = list;
            this._isCompleting$volatile = isCompleting ? 1 : 0;
            this._rootCause$volatile = rootCause;
        }

        @Override
        @NotNull
        public NodeList getList() {
            return this.list;
        }

        private final /* synthetic */ int get_isCompleting$volatile() {
            return this._isCompleting$volatile;
        }

        private final /* synthetic */ void set_isCompleting$volatile(int value) {
            this._isCompleting$volatile = value;
        }

        public final boolean isCompleting() {
            return Finishing._isCompleting$volatile$FU.get(this) == 1;
        }

        public final void setCompleting(boolean value) {
            Finishing._isCompleting$volatile$FU.set(this, value ? 1 : 0);
        }

        private final /* synthetic */ Object get_rootCause$volatile() {
            return this._rootCause$volatile;
        }

        private final /* synthetic */ void set_rootCause$volatile(Object value) {
            this._rootCause$volatile = value;
        }

        @Nullable
        public final Throwable getRootCause() {
            return (Throwable)Finishing._rootCause$volatile$FU.get(this);
        }

        public final void setRootCause(@Nullable Throwable value) {
            Finishing._rootCause$volatile$FU.set(this, value);
        }

        private final /* synthetic */ Object get_exceptionsHolder$volatile() {
            return this._exceptionsHolder$volatile;
        }

        private final /* synthetic */ void set_exceptionsHolder$volatile(Object value) {
            this._exceptionsHolder$volatile = value;
        }

        private final Object getExceptionsHolder() {
            return Finishing._exceptionsHolder$volatile$FU.get(this);
        }

        private final void setExceptionsHolder(Object value) {
            Finishing._exceptionsHolder$volatile$FU.set(this, value);
        }

        public final boolean isSealed() {
            return this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
        }

        public final boolean isCancelling() {
            return this.getRootCause() != null;
        }

        @Override
        public boolean isActive() {
            return this.getRootCause() == null;
        }

        @NotNull
        public final List<Throwable> sealLocked(@Nullable Throwable proposedException) {
            Throwable rootCause;
            Serializable it;
            ArrayList<Throwable> arrayList;
            Object eh2 = this.getExceptionsHolder();
            if (eh2 == null) {
                arrayList = this.allocateList();
            } else if (eh2 instanceof Throwable) {
                ArrayList<Throwable> arrayList2 = this.allocateList();
                it = arrayList2;
                boolean bl2 = false;
                ((ArrayList)it).add((Throwable)eh2);
                arrayList = arrayList2;
            } else if (eh2 instanceof ArrayList) {
                arrayList = (ArrayList<Throwable>)eh2;
            } else {
                throw new IllegalStateException(("State is " + eh2).toString());
            }
            ArrayList<Throwable> list = arrayList;
            Throwable throwable = rootCause = this.getRootCause();
            if (throwable != null) {
                it = throwable;
                boolean bl3 = false;
                list.add(0, (Throwable)it);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                list.add(proposedException);
            }
            this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return list;
        }

        /*
         * WARNING - void declaration
         */
        public final void addExceptionLocked(@NotNull Throwable exception) {
            Throwable rootCause = this.getRootCause();
            if (rootCause == null) {
                this.setRootCause(exception);
                return;
            }
            if (exception == rootCause) {
                return;
            }
            Object eh2 = this.getExceptionsHolder();
            if (eh2 == null) {
                this.setExceptionsHolder(exception);
            } else if (eh2 instanceof Throwable) {
                void $this$addExceptionLocked_u24lambda_u242;
                ArrayList<Throwable> arrayList;
                if (exception == eh2) {
                    return;
                }
                ArrayList<Throwable> arrayList2 = arrayList = this.allocateList();
                Finishing finishing = this;
                boolean bl2 = false;
                $this$addExceptionLocked_u24lambda_u242.add(eh2);
                $this$addExceptionLocked_u24lambda_u242.add(exception);
                finishing.setExceptionsHolder(arrayList);
            } else if (eh2 instanceof ArrayList) {
                ((ArrayList)eh2).add(exception);
            } else {
                throw new IllegalStateException(("State is " + eh2).toString());
            }
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<Throwable>(4);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + this.isCancelling() + ", completing=" + this.isCompleting() + ", rootCause=" + this.getRootCause() + ", exceptions=" + this.getExceptionsHolder() + ", list=" + this.getList() + ']';
        }

        static {
            _isCompleting$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");
            _rootCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");
            _exceptionsHolder$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"})
    private final class SelectOnAwaitCompletionHandler
    extends JobNode {
        @NotNull
        private final SelectInstance<?> select;

        public SelectOnAwaitCompletionHandler(SelectInstance<?> select) {
            this.select = select;
        }

        @Override
        public boolean getOnCancelling() {
            return false;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            Object state = JobSupport.this.getState$kotlinx_coroutines_core();
            Object result = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
            this.select.trySelect(JobSupport.this, result);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"})
    private final class SelectOnJoinCompletionHandler
    extends JobNode {
        @NotNull
        private final SelectInstance<?> select;

        public SelectOnJoinCompletionHandler(SelectInstance<?> select) {
            this.select = select;
        }

        @Override
        public boolean getOnCancelling() {
            return false;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.select.trySelect(JobSupport.this, Unit.INSTANCE);
        }
    }
}

