/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.DelicateCoroutinesApi
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "mergeForChild", "Lkotlin/coroutines/CoroutineContext;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext$Element;", "kotlinx-coroutines-core"})
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
public interface CopyableThreadContextElement<S>
extends ThreadContextElement<S> {
    @NotNull
    public CopyableThreadContextElement<S> copyForChild();

    @NotNull
    public CoroutineContext mergeForChild(@NotNull CoroutineContext.Element var1);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <S, E extends CoroutineContext.Element> E get(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext.Key<E> key) {
            return ThreadContextElement.DefaultImpls.get($this, key);
        }

        public static <S, R> R fold(@NotNull CopyableThreadContextElement<S> $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return ThreadContextElement.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static <S> CoroutineContext minusKey(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext.Key<?> key) {
            return ThreadContextElement.DefaultImpls.minusKey($this, key);
        }

        @NotNull
        public static <S> CoroutineContext plus(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext context) {
            return ThreadContextElement.DefaultImpls.plus($this, context);
        }
    }
}

