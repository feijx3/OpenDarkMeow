/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.api.minecraft.item.ItemBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public interface HashedItem
extends ItemBase {
    public Int2IntMap dataHashesById();

    public IntSet removedDataIds();

    @Override
    public HashedItem copy();
}

