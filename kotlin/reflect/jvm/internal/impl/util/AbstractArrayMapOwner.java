/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractArrayMapOwner<K, V>
implements Iterable<V>,
KMappedMarker {
    @NotNull
    protected abstract ArrayMap<V> getArrayMap();

    @NotNull
    protected abstract TypeRegistry<K, V> getTypeRegistry();

    protected abstract void registerComponent(@NotNull String var1, @NotNull V var2);

    protected final void registerComponent(@NotNull KClass<? extends K> tClass, @NotNull V value) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        Intrinsics.checkNotNullParameter(value, "value");
        String string = tClass.getQualifiedName();
        Intrinsics.checkNotNull(string);
        this.registerComponent(string, value);
    }

    @Override
    @NotNull
    public final Iterator<V> iterator() {
        return this.getArrayMap().iterator();
    }

    public final boolean isEmpty() {
        return this.getArrayMap().getSize() == 0;
    }

    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;

        public AbstractArrayMapAccessor(int id) {
            this.id = id;
        }

        @Nullable
        protected final T extractValue(@NotNull AbstractArrayMapOwner<K, V> thisRef) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return (T)thisRef.getArrayMap().get(this.id);
        }
    }
}

