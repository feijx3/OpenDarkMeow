/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ArrayMap<T>
implements Iterable<T>,
KMappedMarker {
    private ArrayMap() {
    }

    public abstract int getSize();

    public abstract void set(int var1, @NotNull T var2);

    @Nullable
    public abstract T get(int var1);

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ ArrayMap(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

