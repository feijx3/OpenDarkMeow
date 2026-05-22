/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.NullableArrayMapAccessor;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry$$Lambda$0;
import org.jetbrains.annotations.NotNull;

public abstract class TypeRegistry<K, V> {
    @NotNull
    private final ConcurrentHashMap<String, Integer> idPerType = new ConcurrentHashMap();
    @NotNull
    private final AtomicInteger idCounter = new AtomicInteger(0);

    @NotNull
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(@NotNull KClass<KK> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new NullableArrayMapAccessor(this.getId(kClass));
    }

    public final <T extends K> int getId(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String string = kClass.getQualifiedName();
        Intrinsics.checkNotNull(string);
        return this.getId(string);
    }

    public final int getId(@NotNull String keyQualifiedName) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        TypeRegistry typeRegistry = this;
        return this.customComputeIfAbsent(this.idPerType, keyQualifiedName, new TypeRegistry$$Lambda$0(typeRegistry));
    }

    public abstract int customComputeIfAbsent(@NotNull ConcurrentHashMap<String, Integer> var1, @NotNull String var2, @NotNull Function1<? super String, Integer> var3);

    @NotNull
    public final Map<String, Integer> allValuesThreadUnsafeForRendering() {
        return this.idPerType;
    }

    @NotNull
    protected final Collection<Integer> getIndices() {
        Collection<Integer> collection = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        return collection;
    }

    private static final int getId$lambda$0(TypeRegistry this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.idCounter.getAndIncrement();
    }

    static /* synthetic */ int accessor$TypeRegistry$lambda0(TypeRegistry typeRegistry, String string) {
        return TypeRegistry.getId$lambda$0(typeRegistry, string);
    }
}

