/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KProperty1Impl$$Lambda$0;
import kotlin.reflect.jvm.internal.KProperty1Impl$$Lambda$1;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001eB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\f\u0010\u0010J\u0015\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001d\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0019R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "delegateSource", "Ljava/lang/reflect/Member;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class KProperty1Impl<T, V>
extends KPropertyImpl<V>
implements KProperty1<T, V> {
    @NotNull
    private final Lazy<Getter<T, V>> _getter;
    @NotNull
    private final Lazy<Member> delegateSource;

    public KProperty1Impl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object boundReceiver) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        super(container, name, signature, boundReceiver);
        KProperty1Impl kProperty1Impl = this;
        this._getter = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$$Lambda$0(kProperty1Impl));
        kProperty1Impl = this;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$$Lambda$1(kProperty1Impl));
    }

    public KProperty1Impl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        super(container, descriptor2);
        KProperty1Impl kProperty1Impl = this;
        this._getter = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$$Lambda$0(kProperty1Impl));
        kProperty1Impl = this;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$$Lambda$1(kProperty1Impl));
    }

    @Override
    @NotNull
    public Getter<T, V> getGetter() {
        return this._getter.getValue();
    }

    @Override
    public V get(T receiver) {
        Object[] objectArray = new Object[]{receiver};
        return (V)((KCallableImpl)((Object)this.getGetter())).call(objectArray);
    }

    @Override
    @Nullable
    public Object getDelegate(T receiver) {
        return this.getDelegateImpl(this.delegateSource.getValue(), receiver, null);
    }

    @Override
    public V invoke(T receiver) {
        return this.get(receiver);
    }

    private static final Getter _getter$lambda$0(KProperty1Impl this$0) {
        return new Getter(this$0);
    }

    private static final Member delegateSource$lambda$1(KProperty1Impl this$0) {
        return this$0.computeDelegateSource();
    }

    static /* synthetic */ Getter accessor$KProperty1Impl$lambda0(KProperty1Impl kProperty1Impl) {
        return KProperty1Impl._getter$lambda$0(kProperty1Impl);
    }

    static /* synthetic */ Member accessor$KProperty1Impl$lambda1(KProperty1Impl kProperty1Impl) {
        return KProperty1Impl.delegateSource$lambda$1(kProperty1Impl);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Getter<T, V>
    extends KPropertyImpl.Getter<V>
    implements KProperty1.Getter<T, V> {
        @NotNull
        private final KProperty1Impl<T, V> property;

        public Getter(@NotNull KProperty1Impl<T, ? extends V> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @NotNull
        public KProperty1Impl<T, V> getProperty() {
            return this.property;
        }

        @Override
        public V invoke(T receiver) {
            return ((KProperty1Impl)this.getProperty()).get(receiver);
        }
    }
}

