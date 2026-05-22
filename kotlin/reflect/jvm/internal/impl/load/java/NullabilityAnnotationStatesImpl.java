/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityAnnotationStatesImpl<T>
implements NullabilityAnnotationStates<T> {
    @NotNull
    private final Map<FqName, T> states;
    @NotNull
    private final LockBasedStorageManager storageManager;
    @NotNull
    private final MemoizedFunctionToNullable<FqName, T> cache;

    public NullabilityAnnotationStatesImpl(@NotNull Map<FqName, ? extends T> states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.states = states;
        this.storageManager = new LockBasedStorageManager("Java nullability annotation states");
        NullabilityAnnotationStatesImpl nullabilityAnnotationStatesImpl = this;
        MemoizedFunctionToNullable memoizedFunctionToNullable = this.storageManager.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$$Lambda$0(nullabilityAnnotationStatesImpl));
        Intrinsics.checkNotNullExpressionValue(memoizedFunctionToNullable, "createMemoizedFunctionWithNullableValues(...)");
        this.cache = memoizedFunctionToNullable;
    }

    @Override
    @Nullable
    public T get(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (T)this.cache.invoke(fqName);
    }

    private static final Object cache$lambda$0(NullabilityAnnotationStatesImpl this$0, FqName it) {
        Intrinsics.checkNotNull(it);
        return FqNamesUtilKt.findValueForMostSpecificFqname(it, this$0.states);
    }

    static /* synthetic */ Object accessor$NullabilityAnnotationStatesImpl$lambda0(NullabilityAnnotationStatesImpl nullabilityAnnotationStatesImpl, FqName fqName) {
        return NullabilityAnnotationStatesImpl.cache$lambda$0(nullabilityAnnotationStatesImpl, fqName);
    }
}

