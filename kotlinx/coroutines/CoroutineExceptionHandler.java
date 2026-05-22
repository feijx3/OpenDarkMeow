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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"})
public interface CoroutineExceptionHandler
extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = kotlinx.coroutines.CoroutineExceptionHandler$Key.$$INSTANCE;

    public void handleException(@NotNull CoroutineContext var1, @NotNull Throwable var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get($this, key);
        }

        public static <R> R fold(@NotNull CoroutineExceptionHandler $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold($this, initial, operation);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey($this, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus($this, context);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE;

        private Key() {
        }

        static {
            $$INSTANCE = new Key();
        }
    }
}

