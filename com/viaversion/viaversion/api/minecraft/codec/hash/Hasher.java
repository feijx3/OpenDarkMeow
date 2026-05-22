/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec.hash;

import com.viaversion.viaversion.api.minecraft.codec.Ops;

public interface Hasher
extends Ops {
    public int hash();

    public void reset();
}

