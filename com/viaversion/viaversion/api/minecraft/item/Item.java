/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.ItemBase;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Item
extends ItemBase {
    default public short data() {
        return 0;
    }

    default public void setData(short data) {
        throw new UnsupportedOperationException();
    }

    public @Nullable CompoundTag tag();

    public void setTag(@Nullable CompoundTag var1);

    public StructuredDataContainer dataContainer();

    @Override
    public Item copy();
}

