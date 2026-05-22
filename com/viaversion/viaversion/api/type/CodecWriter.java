/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;

@FunctionalInterface
public interface CodecWriter<T> {
    public void write(Ops var1, T var2);
}

