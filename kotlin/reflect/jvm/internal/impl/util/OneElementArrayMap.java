/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OneElementArrayMap<T>
extends ArrayMap<T> {
    @NotNull
    private final T value;
    private final int index;

    public OneElementArrayMap(@NotNull T value, int index) {
        Intrinsics.checkNotNullParameter(value, "value");
        super(null);
        this.value = value;
        this.index = index;
    }

    @NotNull
    public final T getValue() {
        return this.value;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void set(int index, @NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException();
    }

    @Override
    @Nullable
    public T get(int index) {
        return index == this.index ? (T)this.value : null;
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        return new Iterator<T>(this){
            private boolean notVisited;
            final /* synthetic */ OneElementArrayMap<T> this$0;
            {
                this.this$0 = $receiver;
                this.notVisited = true;
            }

            public boolean hasNext() {
                return this.notVisited;
            }

            public T next() {
                if (this.notVisited) {
                    this.notVisited = false;
                    return this.this$0.getValue();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}

