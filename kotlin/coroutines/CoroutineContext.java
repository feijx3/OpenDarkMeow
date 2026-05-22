/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u00a6\u0002\u00a2\u0006\u0002\u0010\u0007J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\t0\fH&\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H&\u00a8\u0006\u0013"}, d2={"Lkotlin/coroutines/CoroutineContext;", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "Key", "Element", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
public interface CoroutineContext {
    @Nullable
    public <E extends Element> E get(@NotNull Key<E> var1);

    public <R> R fold(R var1, @NotNull Function2<? super R, ? super Element, ? extends R> var2);

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext var1);

    @NotNull
    public CoroutineContext minusKey(@NotNull Key<?> var1);

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext plus(@NotNull CoroutineContext $this, @NotNull CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? $this : context.fold($this, DefaultImpls::plus$lambda$0);
        }

        private static CoroutineContext plus$lambda$0(CoroutineContext acc, Element element) {
            CoroutineContext left;
            ContinuationInterceptor interceptor;
            Intrinsics.checkNotNullParameter(acc, "acc");
            Intrinsics.checkNotNullParameter(element, "element");
            CoroutineContext removed = acc.minusKey(element.getKey());
            return removed == EmptyCoroutineContext.INSTANCE ? (CoroutineContext)element : (CoroutineContext)((interceptor = (ContinuationInterceptor)removed.get(ContinuationInterceptor.Key)) == null ? new CombinedContext(removed, element) : ((left = removed.minusKey(ContinuationInterceptor.Key)) == EmptyCoroutineContext.INSTANCE ? new CombinedContext(element, interceptor) : new CombinedContext(new CombinedContext(left, element), interceptor)));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0096\u0002\u00a2\u0006\u0002\u0010\bJ5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0010"}, d2={"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "kotlin-stdlib"})
    public static interface Element
    extends CoroutineContext {
        @NotNull
        public Key<?> getKey();

        @Override
        @Nullable
        public <E extends Element> E get(@NotNull Key<E> var1);

        @Override
        public <R> R fold(R var1, @NotNull Function2<? super R, ? super Element, ? extends R> var2);

        @Override
        @NotNull
        public CoroutineContext minusKey(@NotNull Key<?> var1);

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Nullable
            public static <E extends Element> E get(@NotNull Element $this, @NotNull Key<E> key) {
                Element element;
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.areEqual($this.getKey(), key)) {
                    Intrinsics.checkNotNull($this, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    element = $this;
                } else {
                    element = null;
                }
                return (E)element;
            }

            public static <R> R fold(@NotNull Element $this, R initial, @NotNull Function2<? super R, ? super Element, ? extends R> operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return operation.invoke(initial, $this);
            }

            @NotNull
            public static CoroutineContext minusKey(@NotNull Element $this, @NotNull Key<?> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Intrinsics.areEqual($this.getKey(), key) ? (CoroutineContext)EmptyCoroutineContext.INSTANCE : (CoroutineContext)$this;
            }

            @NotNull
            public static CoroutineContext plus(@NotNull Element $this, @NotNull CoroutineContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return kotlin.coroutines.CoroutineContext$DefaultImpls.plus($this, context);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003\u00a8\u0006\u0004"}, d2={"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"})
    public static interface Key<E extends Element> {
    }
}

