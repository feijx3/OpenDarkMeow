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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "threadLocalIsSet", "", "saveThreadContext", "", "oldValue", "clearThreadContext", "afterCompletionUndispatched", "afterResume", "state", "clearThreadLocal", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,319:1\n103#2,13:320\n1#3:333\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n265#1:320,13\n*E\n"})
public final class UndispatchedCoroutine<T>
extends ScopeCoroutine<T> {
    @NotNull
    private final ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover = new ThreadLocal();
    private volatile boolean threadLocalIsSet;

    public UndispatchedCoroutine(@NotNull CoroutineContext context, @NotNull Continuation<? super T> uCont) {
        super(context.get(UndispatchedMarker.INSTANCE) == null ? context.plus(UndispatchedMarker.INSTANCE) : context, uCont);
        if (!(uCont.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher)) {
            Object values = ThreadContextKt.updateThreadContext(context, null);
            ThreadContextKt.restoreThreadContext(context, values);
            this.saveThreadContext(context, values);
        }
    }

    public final void saveThreadContext(@NotNull CoroutineContext context, @Nullable Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.to(context, oldValue));
    }

    public final boolean clearThreadContext() {
        boolean bl2;
        boolean it = bl2 = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        boolean bl3 = false;
        this.threadStateToRecover.remove();
        return !bl2;
    }

    @Override
    public void afterCompletionUndispatched() {
        this.clearThreadLocal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    protected void afterResume(@Nullable Object state) {
        void continuation$iv;
        this.clearThreadLocal();
        Object result = CompletionStateKt.recoverResult(state, this.uCont);
        Continuation continuation = this.uCont;
        Object countOrElement$iv = null;
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context$iv = continuation$iv.getContext();
        Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, countOrElement$iv);
        UndispatchedCoroutine<?> undispatchedCompletion$iv = oldValue$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv, context$iv, oldValue$iv) : null;
        try {
            boolean bl2 = false;
            this.uCont.resumeWith(result);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            }
        }
    }

    private final void clearThreadLocal() {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                Pair<CoroutineContext, Object> pair2 = pair;
                boolean bl2 = false;
                CoroutineContext ctx = pair2.component1();
                Object value = pair2.component2();
                ThreadContextKt.restoreThreadContext(ctx, value);
            }
            this.threadStateToRecover.remove();
        }
    }
}

