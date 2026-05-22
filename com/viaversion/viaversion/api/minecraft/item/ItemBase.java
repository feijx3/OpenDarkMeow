/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.util.Copyable;

public interface ItemBase
extends Copyable {
    public int identifier();

    public void setIdentifier(int var1);

    public int amount();

    public void setAmount(int var1);

    default public boolean isEmpty() {
        return this.identifier() == 0 || this.amount() <= 0;
    }

    @Override
    public ItemBase copy();
}

