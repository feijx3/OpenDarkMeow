/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lkotlin/coroutines/CoroutineContext$Element;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "restoreThreadContext", "", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "kotlinx-coroutines-core"})
public interface ThreadContextElement<S>
extends CoroutineContext.Element {
    public S updateThreadContext(@NotNull CoroutineContext var1);

    public void restoreThreadContext(@NotNull CoroutineContext var1, S var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <S, E extends CoroutineContext.Element> E get(@NotNull ThreadContextElement<S> $this, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get($this, key);
        }

        public static <S, R> R fold(@NotNull ThreadContextElement<S> $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static <S> CoroutineContext minusKey(@NotNull ThreadContextElement<S> $this, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey($this, key);
        }

        @NotNull
        public static <S> CoroutineContext plus(@NotNull ThreadContextElement<S> $this, @NotNull CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus($this, context);
        }
    }
}

