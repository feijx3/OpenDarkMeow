/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CopyableThreadContextElement;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0001H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0002\u001a4\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\b\u00a2\u0006\u0002\u0010\u0011\u001a8\u0010\u0012\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\b\u00a2\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0013\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020\u001aH\u0080\u0010\"\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u000e\u0010\u001f\u001a\u00020\u001cX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"newCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineScope;", "context", "addedContext", "hasCopyableElements", "", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "withCoroutineContext", "T", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withContinuationContext", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateUndispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "oldValue", "undispatchedCompletion", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "coroutineName", "", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "DEBUG_THREAD_NAME_SEPARATOR", "kotlinx-coroutines-core"})
public final class CoroutineContextKt {
    @NotNull
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    @ExperimentalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineScope $this$newCoroutineContext, @NotNull CoroutineContext context) {
        CoroutineContext combined = CoroutineContextKt.foldCopies($this$newCoroutineContext.getCoroutineContext(), context, true);
        CoroutineContext debug = DebugKt.getDEBUG() ? combined.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : combined;
        return combined != Dispatchers.getDefault() && combined.get(ContinuationInterceptor.Key) == null ? debug.plus(Dispatchers.getDefault()) : debug;
    }

    @InternalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineContext $this$newCoroutineContext, @NotNull CoroutineContext addedContext) {
        if (!CoroutineContextKt.hasCopyableElements(addedContext)) {
            return $this$newCoroutineContext.plus(addedContext);
        }
        return CoroutineContextKt.foldCopies($this$newCoroutineContext, addedContext, false);
    }

    private static final boolean hasCopyableElements(CoroutineContext $this$hasCopyableElements) {
        return $this$hasCopyableElements.fold(false, CoroutineContextKt::hasCopyableElements$lambda$0);
    }

    private static final CoroutineContext foldCopies(CoroutineContext originalContext, CoroutineContext appendContext, boolean isNewCoroutine) {
        boolean hasElementsLeft = CoroutineContextKt.hasCopyableElements(originalContext);
        boolean hasElementsRight = CoroutineContextKt.hasCopyableElements(appendContext);
        if (!hasElementsLeft && !hasElementsRight) {
            return originalContext.plus(appendContext);
        }
        Ref.ObjectRef leftoverContext = new Ref.ObjectRef();
        leftoverContext.element = appendContext;
        CoroutineContext folded = originalContext.fold(EmptyCoroutineContext.INSTANCE, (arg_0, arg_1) -> CoroutineContextKt.foldCopies$lambda$1(leftoverContext, isNewCoroutine, arg_0, arg_1));
        if (hasElementsRight) {
            leftoverContext.element = ((CoroutineContext)leftoverContext.element).fold(EmptyCoroutineContext.INSTANCE, CoroutineContextKt::foldCopies$lambda$2);
        }
        return folded.plus((CoroutineContext)leftoverContext.element);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T withCoroutineContext(@NotNull CoroutineContext context, @Nullable Object countOrElement, @NotNull Function0<? extends T> block) {
        boolean $i$f$withCoroutineContext = false;
        Object oldValue = ThreadContextKt.updateThreadContext(context, countOrElement);
        try {
            T t2 = block.invoke();
            return t2;
        }
        finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, oldValue);
            InlineMarker.finallyEnd(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T withContinuationContext(@NotNull Continuation<?> continuation, @Nullable Object countOrElement, @NotNull Function0<? extends T> block) {
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context = continuation.getContext();
        Object oldValue = ThreadContextKt.updateThreadContext(context, countOrElement);
        UndispatchedCoroutine<?> undispatchedCompletion = oldValue != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, context, oldValue) : null;
        try {
            T t2 = block.invoke();
            return t2;
        }
        finally {
            InlineMarker.finallyStart(1);
            if (undispatchedCompletion == null || undispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, oldValue);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @Nullable
    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(@NotNull Continuation<?> $this$updateUndispatchedCompletion, @NotNull CoroutineContext context, @Nullable Object oldValue) {
        UndispatchedCoroutine<?> completion;
        block2: {
            boolean potentiallyHasUndispatchedCoroutine;
            if (!($this$updateUndispatchedCompletion instanceof CoroutineStackFrame)) {
                return null;
            }
            boolean bl2 = potentiallyHasUndispatchedCoroutine = context.get(UndispatchedMarker.INSTANCE) != null;
            if (!potentiallyHasUndispatchedCoroutine) {
                return null;
            }
            UndispatchedCoroutine<?> undispatchedCoroutine = completion = CoroutineContextKt.undispatchedCompletion((CoroutineStackFrame)((Object)$this$updateUndispatchedCompletion));
            if (undispatchedCoroutine == null) break block2;
            undispatchedCoroutine.saveThreadContext(context, oldValue);
        }
        return completion;
    }

    @Nullable
    public static final UndispatchedCoroutine<?> undispatchedCompletion(@NotNull CoroutineStackFrame $this$undispatchedCompletion) {
        while (!($this$undispatchedCompletion instanceof DispatchedCoroutine)) {
            CoroutineStackFrame completion;
            if ($this$undispatchedCompletion.getCallerFrame() == null) {
                return null;
            }
            if (completion instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine)completion;
            }
            $this$undispatchedCompletion = completion;
        }
        return null;
    }

    @Nullable
    public static final String getCoroutineName(@NotNull CoroutineContext $this$coroutineName) {
        if (!DebugKt.getDEBUG()) {
            return null;
        }
        CoroutineId coroutineId = (CoroutineId)$this$coroutineName.get(CoroutineId.Key);
        if (coroutineId == null) {
            return null;
        }
        CoroutineId coroutineId2 = coroutineId;
        Object object = (CoroutineName)$this$coroutineName.get(CoroutineName.Key);
        if (object == null || (object = ((CoroutineName)object).getName()) == null) {
            object = "coroutine";
        }
        Object coroutineName = object;
        return (String)coroutineName + '#' + coroutineId2.getId();
    }

    private static final boolean hasCopyableElements$lambda$0(boolean result, CoroutineContext.Element it) {
        return result || it instanceof CopyableThreadContextElement;
    }

    private static final CoroutineContext foldCopies$lambda$1(Ref.ObjectRef $leftoverContext, boolean $isNewCoroutine, CoroutineContext result, CoroutineContext.Element element) {
        if (!(element instanceof CopyableThreadContextElement)) {
            return result.plus(element);
        }
        Object newElement = ((CoroutineContext)$leftoverContext.element).get(element.getKey());
        if (newElement == null) {
            return result.plus($isNewCoroutine ? ((CopyableThreadContextElement)element).copyForChild() : (CopyableThreadContextElement)element);
        }
        $leftoverContext.element = ((CoroutineContext)$leftoverContext.element).minusKey(element.getKey());
        return result.plus(((CopyableThreadContextElement)element).mergeForChild((CoroutineContext.Element)newElement));
    }

    private static final CoroutineContext foldCopies$lambda$2(CoroutineContext result, CoroutineContext.Element element) {
        if (element instanceof CopyableThreadContextElement) {
            return result.plus(((CopyableThreadContextElement)element).copyForChild());
        }
        return result.plus(element);
    }
}

