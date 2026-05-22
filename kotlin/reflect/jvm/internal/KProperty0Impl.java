/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KProperty0Impl$$Lambda$0;
import kotlin.reflect.jvm.internal.KProperty0Impl$$Lambda$1;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\b\u0010\u000fJ\r\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u001a\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0017R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "V", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "delegateValue", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class KProperty0Impl<V>
extends KPropertyImpl<V>
implements KProperty0<V> {
    @NotNull
    private final Lazy<Getter<V>> _getter;
    @NotNull
    private final Lazy<Object> delegateValue;

    public KProperty0Impl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        super(container, descriptor2);
        KProperty0Impl kProperty0Impl = this;
        this._getter = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$$Lambda$0(kProperty0Impl));
        kProperty0Impl = this;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$$Lambda$1(kProperty0Impl));
    }

    public KProperty0Impl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object boundReceiver) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        super(container, name, signature, boundReceiver);
        KProperty0Impl kProperty0Impl = this;
        this._getter = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$$Lambda$0(kProperty0Impl));
        kProperty0Impl = this;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$$Lambda$1(kProperty0Impl));
    }

    @Override
    @NotNull
    public Getter<V> getGetter() {
        return this._getter.getValue();
    }

    @Override
    public V get() {
        return (V)((KCallableImpl)((Object)this.getGetter())).call(new Object[0]);
    }

    @Override
    @Nullable
    public Object getDelegate() {
        return this.delegateValue.getValue();
    }

    @Override
    public V invoke() {
        return this.get();
    }

    private static final Getter _getter$lambda$0(KProperty0Impl this$0) {
        return new Getter(this$0);
    }

    private static final Object delegateValue$lambda$1(KProperty0Impl this$0) {
        return this$0.getDelegateImpl(this$0.computeDelegateSource(), null, null);
    }

    static /* synthetic */ Getter accessor$KProperty0Impl$lambda0(KProperty0Impl kProperty0Impl) {
        return KProperty0Impl._getter$lambda$0(kProperty0Impl);
    }

    static /* synthetic */ Object accessor$KProperty0Impl$lambda1(KProperty0Impl kProperty0Impl) {
        return KProperty0Impl.delegateValue$lambda$1(kProperty0Impl);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Getter<R>
    extends KPropertyImpl.Getter<R>
    implements KProperty0.Getter<R> {
        @NotNull
        private final KProperty0Impl<R> property;

        public Getter(@NotNull KProperty0Impl<? extends R> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override
        @NotNull
        public KProperty0Impl<R> getProperty() {
            return this.property;
        }

        @Override
        public R invoke() {
            return (R)((KProperty0Impl)this.getProperty()).get();
        }
    }
}

