/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.IdHolder;
import com.viaversion.viaversion.api.minecraft.ValueHolder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Holder<T> {
    public static <T> Holder<T> of(int id) {
        return new IdHolder(id);
    }

    public static <T> Holder<T> of(T value) {
        return new ValueHolder<T>(value);
    }

    public boolean isDirect();

    public boolean hasId();

    public T value();

    public int id();

    default public Holder<T> updateId(Int2IntFunction rewriteFunction) {
        return this.updateId(rewriteFunction, null);
    }

    public Holder<T> updateId(Int2IntFunction var1, Supplier<Holder<T>> var2);

    public Holder<T> updateValue(Function<T, T> var1);
}

