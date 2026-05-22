/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "threadContextElements", "context", "Lkotlin/coroutines/CoroutineContext;", "updateThreadContext", "countOrElement", "restoreThreadContext", "", "oldState", "kotlinx-coroutines-core"})
public final class ThreadContextKt {
    @JvmField
    @NotNull
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    @NotNull
    private static final Function2<Object, CoroutineContext.Element, Object> countAll = ThreadContextKt::countAll$lambda$0;
    @NotNull
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = ThreadContextKt::findOne$lambda$1;
    @NotNull
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = ThreadContextKt::updateState$lambda$2;

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext context) {
        Object object = context.fold(0, countAll);
        Intrinsics.checkNotNull(object);
        return object;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext context, @Nullable Object countOrElement) {
        Object object;
        Object object2 = countOrElement;
        if (object2 == null) {
            object2 = ThreadContextKt.threadContextElements(context);
        }
        Object countOrElement2 = object2;
        if (countOrElement2 == Integer.valueOf(0)) {
            object = NO_THREAD_ELEMENTS;
        } else if (countOrElement2 instanceof Integer) {
            object = context.fold(new ThreadState(context, ((Number)countOrElement2).intValue()), updateState);
        } else {
            Intrinsics.checkNotNull(countOrElement2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ThreadContextElement element = (ThreadContextElement)countOrElement2;
            object = element.updateThreadContext(context);
        }
        return object;
    }

    public static final void restoreThreadContext(@NotNull CoroutineContext context, @Nullable Object oldState) {
        if (oldState == NO_THREAD_ELEMENTS) {
            return;
        }
        if (oldState instanceof ThreadState) {
            ((ThreadState)oldState).restore(context);
        } else {
            ThreadContextElement<?> threadContextElement = context.fold(null, findOne);
            Intrinsics.checkNotNull(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ThreadContextElement<?> element = threadContextElement;
            element.restoreThreadContext(context, oldState);
        }
    }

    private static final Object countAll$lambda$0(Object countOrElement, CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            Integer n2 = countOrElement instanceof Integer ? (Integer)countOrElement : null;
            int inCount = n2 != null ? n2 : 1;
            return inCount == 0 ? element : Integer.valueOf(inCount + 1);
        }
        return countOrElement;
    }

    private static final ThreadContextElement<?> findOne$lambda$1(ThreadContextElement<?> found, CoroutineContext.Element element) {
        if (found != null) {
            return found;
        }
        return element instanceof ThreadContextElement ? (ThreadContextElement)element : null;
    }

    private static final ThreadState updateState$lambda$2(ThreadState state, CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            state.append((ThreadContextElement)element, ((ThreadContextElement)element).updateThreadContext(state.context));
        }
        return state;
    }
}

