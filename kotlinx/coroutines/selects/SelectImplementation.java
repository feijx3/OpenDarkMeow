/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001IB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001b\u001a\u00028\u0000H\u0091@\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00028\u0000H\u0082@\u00a2\u0006\u0002\u0010\u001cJ0\u0010\u001e\u001a\u00020\u001f*\u00020 2\u001c\u0010!\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0096\u0002\u00a2\u0006\u0002\u0010$JB\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0001\u0010%*\b\u0012\u0004\u0012\u0002H%0&2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0'H\u0096\u0002\u00a2\u0006\u0002\u0010(JV\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u0010%*\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H%0*2\u0006\u0010+\u001a\u0002H)2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0'H\u0096\u0002\u00a2\u0006\u0002\u0010,J \u0010-\u001a\u00020\u001f*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010.\u001a\u00020\u000fH\u0001J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J\u001c\u00104\u001a\u00020\u001f2\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\u0006\u00107\u001a\u00020\u0019H\u0016J\u0012\u00108\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u00109\u001a\u00020\u001fH\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\rH\u0002J\u001a\u0010;\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010=\u001a\u00020>2\u0006\u00100\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\rJ\u001a\u0010?\u001a\u00020\u00192\u0006\u00100\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010@\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\rH\u0002J\u000e\u0010A\u001a\u00028\u0000H\u0082@\u00a2\u0006\u0002\u0010\u001cJ*\u0010B\u001a\u00028\u00002\u0010\u0010C\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0082@\u00a2\u0006\u0002\u0010DJ\u001a\u0010E\u001a\u00020\u001f2\u0010\u0010F\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\u0014\u0012\u000e\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "state", "Lkotlinx/atomicfu/AtomicRef;", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "isSelected", "isCancelled", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "disposableHandleOrSegment", "indexInSegment", "", "internalResult", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSelectSuspend", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "checkClauseObject", "clauseObject", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "selectInRegistrationPhase", "waitUntilSelected", "reregisterClause", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "findClause", "complete", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "selectedClause", "cause", "", "ClauseData", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,904:1\n1#2:905\n2632#3,3:906\n1863#3,2:918\n1863#3,2:926\n1863#3,2:928\n426#4,9:909\n435#4,2:920\n149#5,4:922\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n529#1:906,3\n593#1:918,2\n749#1:926,2\n774#1:928,2\n569#1:909,9\n569#1:920,2\n734#1:922,4\n*E\n"})
public class SelectImplementation<R>
implements CancelHandler,
SelectBuilder<R>,
SelectInstanceInternal<R> {
    @NotNull
    private final CoroutineContext context;
    private volatile /* synthetic */ Object state$volatile;
    @Nullable
    private List<ClauseData> clauses;
    @Nullable
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    @Nullable
    private Object internalResult;
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU;

    public SelectImplementation(@NotNull CoroutineContext context) {
        this.context = context;
        this.state$volatile = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    @Override
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    private final /* synthetic */ Object getState$volatile() {
        return this.state$volatile;
    }

    private final /* synthetic */ void setState$volatile(Object value) {
        this.state$volatile = value;
    }

    private final boolean getInRegistrationPhase() {
        Object it = SelectImplementation.state$volatile$FU.get(this);
        boolean bl2 = false;
        return it == SelectKt.access$getSTATE_REG$p() || it instanceof List;
    }

    private final boolean isSelected() {
        return SelectImplementation.state$volatile$FU.get(this) instanceof ClauseData;
    }

    private final boolean isCancelled() {
        return SelectImplementation.state$volatile$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p();
    }

    @PublishedApi
    @Nullable
    public Object doSelect(@NotNull Continuation<? super R> $completion) {
        return SelectImplementation.doSelect$suspendImpl(this, $completion);
    }

    @PublishedApi
    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> $this, Continuation<? super R> $completion) {
        if (super.isSelected()) {
            return super.complete($completion);
        }
        return super.doSelectSuspend($completion);
    }

    /*
     * Unable to fully structure code
     */
    private final Object doSelectSuspend(Continuation<? super R> $completion) {
        if (!($completion instanceof doSelectSuspend.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ SelectImplementation<R> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SelectImplementation.access$doSelectSuspend(this.this$0, this);
                }
            };
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure($result);
                $continuation.L$0 = this;
                $continuation.label = 1;
                v0 = this.waitUntilSelected($continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl22
            }
            case 1: {
                this = (SelectImplementation)$continuation.L$0;
                ResultKt.throwOnFailure($result);
                v0 = $result;
lbl22:
                // 2 sources

                $continuation.L$0 = null;
                $continuation.label = 2;
                v1 = this.complete($continuation);
                if (v1 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl31
            }
            case 2: {
                ResultKt.throwOnFailure($result);
                v1 = $result;
lbl31:
                // 2 sources

                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    public void invoke(@NotNull SelectClause0 $this$invoke, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> $this$invoke, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), null, block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> $this$invoke, P param, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), param, block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @JvmName(name="register")
    public final void register(@NotNull ClauseData $this$register, boolean reregister) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(SelectImplementation.state$volatile$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p())) {
                throw new AssertionError();
            }
        }
        Object it = SelectImplementation.state$volatile$FU.get(this);
        boolean bl3 = false;
        if (it instanceof ClauseData) {
            return;
        }
        if (!reregister) {
            this.checkClauseObject($this$register.clauseObject);
        }
        if ($this$register.tryRegisterAsWaiter(this)) {
            if (!reregister) {
                List<ClauseData> list = this.clauses;
                Intrinsics.checkNotNull(list);
                ((Collection)list).add($this$register);
            }
            $this$register.disposableHandleOrSegment = this.disposableHandleOrSegment;
            $this$register.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
        } else {
            SelectImplementation.state$volatile$FU.set(this, $this$register);
        }
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        selectImplementation.register(clauseData, bl2);
    }

    private final void checkClauseObject(Object clauseObject) {
        boolean bl2;
        block4: {
            List<ClauseData> list = this.clauses;
            Intrinsics.checkNotNull(list);
            List<ClauseData> clauses = list;
            Iterable $this$none$iv = clauses;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$none$iv) {
                    ClauseData it = (ClauseData)element$iv;
                    boolean bl3 = false;
                    if (!(it.clauseObject == clauseObject)) continue;
                    bl2 = false;
                    break block4;
                }
                bl2 = true;
            }
        }
        if (!bl2) {
            boolean bl4 = false;
            String string = "Cannot use select clauses on the same object: " + clauseObject;
            throw new IllegalStateException(string.toString());
        }
    }

    @Override
    public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @Override
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override
    public void selectInRegistrationPhase(@Nullable Object internalResult) {
        this.internalResult = internalResult;
    }

    /*
     * Unable to fully structure code
     */
    private final Object waitUntilSelected(Continuation<? super Unit> $completion) {
        block7: {
            $i$f$suspendCancellableCoroutine = false;
            uCont$iv = $completion;
            $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv = false;
            cancellable$iv = new CancellableContinuationImpl<Unit>(IntrinsicsKt.intercepted(uCont$iv), 1);
            cancellable$iv.initCancellability();
            cont = cancellable$iv;
            $i$a$-suspendCancellableCoroutine-SelectImplementation$waitUntilSelected$2 = false;
            var8_8 = this;
            handler$atomicfu$iv = SelectImplementation.access$getState$volatile$FU();
            block0: while (true) {
                curState = handler$atomicfu$iv.get(this);
                $i$a$-loop$atomicfu$ATOMIC_FIELD_UPDATER$Any-SelectImplementation$waitUntilSelected$2$1 = false;
                if (curState == SelectKt.access$getSTATE_REG$p()) {
                    if (!SelectImplementation.access$getState$volatile$FU().compareAndSet(this, curState, cont)) continue;
                    CancellableContinuationKt.invokeOnCancellation(cont, this);
                    break block7;
                }
                if (!(curState instanceof List)) break;
                if (!SelectImplementation.access$getState$volatile$FU().compareAndSet(this, curState, SelectKt.access$getSTATE_REG$p())) continue;
                (List)curState;
                $this$forEach$iv = (Iterable)curState;
                $i$f$forEach = false;
                var14_14 = $this$forEach$iv.iterator();
                while (true) {
                    if (var14_14.hasNext()) ** break;
                    continue block0;
                    it = element$iv = var14_14.next();
                    $i$a$-forEach-SelectImplementation$waitUntilSelected$2$1$1 = false;
                    SelectImplementation.access$reregisterClause(this, it);
                }
                break;
            }
            if (curState instanceof ClauseData) {
                cont.resume(Unit.INSTANCE, ((ClauseData)curState).createOnCancellationAction(this, SelectImplementation.access$getInternalResult$p(this)));
            } else {
                throw new IllegalStateException(("unexpected state: " + curState).toString());
            }
        }
        v0 = cancellable$iv.getResult();
        if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }
        return Unit.INSTANCE;
    }

    private final void reregisterClause(Object clauseObject) {
        ClauseData clauseData = this.findClause(clauseObject);
        Intrinsics.checkNotNull(clauseData);
        ClauseData clause = clauseData;
        clause.disposableHandleOrSegment = null;
        clause.indexInSegment = -1;
        this.register(clause, true);
    }

    @Override
    public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result) {
        return this.trySelectInternal(clauseObject, result) == 0;
    }

    @NotNull
    public final TrySelectDetailedResult trySelectDetailed(@NotNull Object clauseObject, @Nullable Object result) {
        return SelectKt.access$TrySelectDetailedResult(this.trySelectInternal(clauseObject, result));
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        Object curState;
        block6: {
            while (true) {
                if ((curState = SelectImplementation.state$volatile$FU.get(this)) instanceof CancellableContinuation) {
                    ClauseData clause;
                    if (this.findClause(clauseObject) == null) continue;
                    Function3<Throwable, Object, CoroutineContext, Unit> onCancellation = clause.createOnCancellationAction(this, internalResult);
                    if (!SelectImplementation.state$volatile$FU.compareAndSet(this, curState, clause)) continue;
                    CancellableContinuation cont = (CancellableContinuation)curState;
                    this.internalResult = internalResult;
                    if (SelectKt.access$tryResume(cont, onCancellation)) {
                        return 0;
                    }
                    this.internalResult = SelectKt.access$getNO_RESULT$p();
                    return 2;
                }
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_COMPLETED$p()) || curState instanceof ClauseData) {
                    return 3;
                }
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_CANCELLED$p())) {
                    return 2;
                }
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_REG$p())) {
                    if (!SelectImplementation.state$volatile$FU.compareAndSet(this, curState, CollectionsKt.listOf(clauseObject))) continue;
                    return 1;
                }
                if (!(curState instanceof List)) break block6;
                if (SelectImplementation.state$volatile$FU.compareAndSet(this, curState, CollectionsKt.plus((Collection)curState, clauseObject))) break;
            }
            return 1;
        }
        throw new IllegalStateException(("Unexpected state: " + curState).toString());
    }

    private final ClauseData findClause(Object clauseObject) {
        Object v1;
        block3: {
            List<ClauseData> list = this.clauses;
            if (list == null) {
                return null;
            }
            List<ClauseData> clauses = list;
            Iterable iterable = clauses;
            for (Object t2 : iterable) {
                ClauseData it = (ClauseData)t2;
                boolean bl2 = false;
                if (!(it.clauseObject == clauseObject)) continue;
                v1 = t2;
                break block3;
            }
            v1 = null;
        }
        ClauseData clauseData = v1;
        if (clauseData == null) {
            throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
        }
        return clauseData;
    }

    private final Object complete(Continuation<? super R> $completion) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!this.isSelected()) {
                throw new AssertionError();
            }
        }
        Object v2 = SelectImplementation.state$volatile$FU.get(this);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData selectedClause = (ClauseData)v2;
        Object internalResult = this.internalResult;
        this.cleanup(selectedClause);
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            Object blockArgument = selectedClause.processResult(internalResult);
            return selectedClause.invokeBlock(blockArgument, $completion);
        }
        return this.processResultAndInvokeBlockRecoveringException(selectedClause, internalResult, $completion);
    }

    /*
     * Unable to fully structure code
     */
    private final Object processResultAndInvokeBlockRecoveringException(ClauseData var1_1, Object var2_2, Continuation<? super R> $completion) {
        if (!($completion instanceof processResultAndInvokeBlockRecoveringException.1)) ** GOTO lbl-1000
        var10_4 = $completion;
        if ((var10_4.label & -2147483648) != 0) {
            var10_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ SelectImplementation<R> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SelectImplementation.access$processResultAndInvokeBlockRecoveringException(this.this$0, null, null, this);
                }
            };
        }
        $result = $continuation.result;
        var11_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure($result);
                blockArgument = clause.processResult(internalResult);
                $continuation.label = 1;
                v0 = clause.invokeBlock(blockArgument, $continuation);
                ** if (v0 != var11_6) goto lbl19
lbl18:
                // 1 sources

                return var11_6;
lbl19:
                // 1 sources

                ** GOTO lbl25
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure($result);
                    v0 = $result;
lbl25:
                    // 2 sources

                    var4_7 = v0;
                }
                catch (Throwable e) {
                    $i$f$recoverAndThrow = false;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                        throw e;
                    }
                    it$iv = $continuation;
                    $i$a$-suspendCoroutineUninterceptedOrReturn-StackTraceRecoveryKt$recoverAndThrow$2$iv = false;
                    if (!(it$iv instanceof CoroutineStackFrame)) {
                        throw e;
                    }
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(e, it$iv);
                }
                return var4_7;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final void cleanup(ClauseData selectedClause) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!Intrinsics.areEqual(SelectImplementation.state$volatile$FU.get(this), selectedClause)) {
                throw new AssertionError();
            }
        }
        List<ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        List<ClauseData> clauses = list;
        Iterable $this$forEach$iv = clauses;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData clause = (ClauseData)element$iv;
            boolean bl3 = false;
            if (clause == selectedClause) continue;
            clause.dispose();
        }
        SelectImplementation.state$volatile$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override
    public void invoke(@Nullable Throwable cause) {
        Object object;
        Object v2;
        SelectImplementation selectImplementation = this;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = SelectImplementation.state$volatile$FU;
        do {
            Object cur = v2 = handler$atomicfu$iv.get(this);
            boolean bl2 = false;
            if (cur != SelectKt.access$getSTATE_COMPLETED$p()) continue;
            return;
        } while (!handler$atomicfu$iv.compareAndSet(this, v2, object = SelectKt.access$getSTATE_CANCELLED$p()));
        List<ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        List<ClauseData> clauses = list;
        Iterable $this$forEach$iv = clauses;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData it = (ClauseData)element$iv;
            boolean bl3 = false;
            it.dispose();
        }
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> $this$invoke, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.invoke(this, $this$invoke, block);
    }

    @Override
    @Deprecated(message="Replaced with the same extension function", replaceWith=@ReplaceWith(expression="onTimeout", imports={"kotlinx.coroutines.selects.onTimeout"}), level=DeprecationLevel.ERROR)
    @ExperimentalCoroutinesApi
    @LowPriorityInOverloadResolution
    public void onTimeout(long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.onTimeout(this, timeMillis, block);
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, Unit> action$atomicfu) {
        while (true) {
            action$atomicfu.invoke(handler$atomicfu.get(obj$atomicfu));
        }
    }

    private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater handler$atomicfu, Object obj$atomicfu, Function1<Object, ? extends Object> action$atomicfu) {
        Object object;
        Object v2;
        while (!handler$atomicfu.compareAndSet(obj$atomicfu, v2 = handler$atomicfu.get(obj$atomicfu), object = action$atomicfu.invoke(v2))) {
        }
    }

    public static final /* synthetic */ Object access$doSelectSuspend(SelectImplementation $this, Continuation $completion) {
        return $this.doSelectSuspend($completion);
    }

    public static final /* synthetic */ Object access$waitUntilSelected(SelectImplementation $this, Continuation $completion) {
        return $this.waitUntilSelected($completion);
    }

    public static final /* synthetic */ Object access$complete(SelectImplementation $this, Continuation $completion) {
        return $this.complete($completion);
    }

    public static final /* synthetic */ Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation $this, ClauseData clause, Object internalResult, Continuation $completion) {
        return $this.processResultAndInvokeBlockRecoveringException(clause, internalResult, $completion);
    }

    public static final /* synthetic */ void access$reregisterClause(SelectImplementation $this, Object clauseObject) {
        $this.reregisterClause(clauseObject);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getState$volatile$FU() {
        return SelectImplementation.state$volatile$FU;
    }

    static {
        state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u00c6\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012u\u0010\u0010\u001aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u001f\u001a\u00028\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0086@\u00a2\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\nJ8\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u007f\u0010\u0010\u001aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "processResult", "result", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "createOnCancellationAction", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,904:1\n1#2:905\n*E\n"})
    public final class ClauseData {
        @JvmField
        @NotNull
        public final Object clauseObject;
        @NotNull
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;
        @NotNull
        private final Function3<Object, Object, Object, Object> processResFunc;
        @Nullable
        private final Object param;
        @NotNull
        private final Object block;
        @JvmField
        @Nullable
        public final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onCancellationConstructor;
        @JvmField
        @Nullable
        public Object disposableHandleOrSegment;
        @JvmField
        public int indexInSegment;

        public ClauseData(@NotNull Object clauseObject, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> regFunc, @Nullable Function3<Object, Object, Object, ? extends Object> processResFunc, @NotNull Object param, @Nullable Object block, Function3<? super SelectInstance<?>, Object, Object, ? extends Function3<? super Throwable, Object, ? super CoroutineContext, Unit>> onCancellationConstructor) {
            this.clauseObject = clauseObject;
            this.regFunc = regFunc;
            this.processResFunc = processResFunc;
            this.param = param;
            this.block = block;
            this.onCancellationConstructor = onCancellationConstructor;
            this.indexInSegment = -1;
        }

        public final boolean tryRegisterAsWaiter(@NotNull SelectImplementation<R> select) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl2 = false;
                if (!(select.getInRegistrationPhase() || select.isCancelled())) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!(select.internalResult == SelectKt.access$getNO_RESULT$p())) {
                    throw new AssertionError();
                }
            }
            this.regFunc.invoke(this.clauseObject, select, this.param);
            return select.internalResult == SelectKt.access$getNO_RESULT$p();
        }

        @Nullable
        public final Object processResult(@Nullable Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        @Nullable
        public final Object invokeBlock(@Nullable Object argument, @NotNull Continuation<? super R> $completion) {
            Object block = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                Function1 cfr_ignored_0 = (Function1)block;
                return ((Function1)block).invoke($completion);
            }
            Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            Function2 cfr_ignored_1 = (Function2)block;
            return ((Function2)block).invoke(argument, $completion);
        }

        public final void dispose() {
            block1: {
                Object $this$dispose_u24lambda_u242;
                block0: {
                    Object object = this.disposableHandleOrSegment;
                    SelectImplementation selectImplementation = SelectImplementation.this;
                    $this$dispose_u24lambda_u242 = object;
                    boolean bl2 = false;
                    if (!($this$dispose_u24lambda_u242 instanceof Segment)) break block0;
                    ((Segment)$this$dispose_u24lambda_u242).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                    break block1;
                }
                DisposableHandle disposableHandle = $this$dispose_u24lambda_u242 instanceof DisposableHandle ? (DisposableHandle)$this$dispose_u24lambda_u242 : null;
                if (disposableHandle == null) break block1;
                disposableHandle.dispose();
            }
        }

        @Nullable
        public final Function3<Throwable, Object, CoroutineContext, Unit> createOnCancellationAction(@NotNull SelectInstance<?> select, @Nullable Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> function3 = this.onCancellationConstructor;
            return function3 != null ? function3.invoke(select, this.param, internalResult) : null;
        }
    }
}

