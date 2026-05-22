/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.EitherHolderImpl;
import com.viaversion.viaversion.api.minecraft.Holder;

public interface EitherHolder<T> {
    public static <T> EitherHolder<T> of(Holder<T> value) {
        return new EitherHolderImpl<T>(value, null);
    }

    public static <T> EitherHolder<T> of(String key) {
        return new EitherHolderImpl(null, key);
    }

    public boolean hasHolder();

    public boolean hasKey();

    public Holder<T> holder();

    public String key();
}

