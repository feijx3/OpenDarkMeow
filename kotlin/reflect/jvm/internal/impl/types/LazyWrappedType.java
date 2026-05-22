/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class LazyWrappedType
extends WrappedType {
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final Function0<KotlinType> computation;
    @NotNull
    private final NotNullLazyValue<KotlinType> lazyValue;

    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends KotlinType> computation) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(computation, "computation");
        this.storageManager = storageManager;
        this.computation = computation;
        this.lazyValue = this.storageManager.createLazyValue(this.computation);
    }

    @Override
    @NotNull
    protected KotlinType getDelegate() {
        return (KotlinType)this.lazyValue.invoke();
    }

    @Override
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override
    @NotNull
    public LazyWrappedType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        LazyWrappedType lazyWrappedType = this;
        KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$$Lambda$0(kotlinTypeRefiner2, lazyWrappedType));
    }

    private static final KotlinType refine$lambda$0(KotlinTypeRefiner $kotlinTypeRefiner, LazyWrappedType this$0) {
        return $kotlinTypeRefiner.refineType(this$0.computation.invoke());
    }

    static /* synthetic */ KotlinType accessor$LazyWrappedType$lambda0(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        return LazyWrappedType.refine$lambda$0(kotlinTypeRefiner, lazyWrappedType);
    }
}

