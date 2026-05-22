/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredItem
implements Item {
    private final StructuredDataContainer data;
    private int identifier;
    private int amount;

    public StructuredItem(int identifier, int amount) {
        this(identifier, amount, new StructuredDataContainer());
    }

    public StructuredItem(int identifier, int amount, StructuredDataContainer data) {
        this.identifier = identifier;
        this.amount = amount;
        this.data = data;
    }

    public static StructuredItem empty() {
        return new StructuredItem(0, 0);
    }

    public static Item[] emptyArray(int size) {
        Item[] items = new Item[size];
        for (int i2 = 0; i2 < items.length; ++i2) {
            items[i2] = StructuredItem.empty();
        }
        return items;
    }

    @Override
    public int identifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public @Nullable CompoundTag tag() {
        return null;
    }

    @Override
    public void setTag(@Nullable CompoundTag tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructuredDataContainer dataContainer() {
        return this.data;
    }

    @Override
    public StructuredItem copy() {
        return new StructuredItem(this.identifier, this.amount, this.data.copy());
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        StructuredItem that = (StructuredItem)o2;
        if (this.identifier != that.identifier) {
            return false;
        }
        if (this.amount != that.amount) {
            return false;
        }
        return this.data.equals(that.data);
    }

    public int hashCode() {
        int result = this.data.hashCode();
        result = 31 * result + this.identifier;
        result = 31 * result + this.amount;
        return result;
    }

    public String toString() {
        return StructuredItem.jvmdowngrader$concat$toString$1(String.valueOf(this.data), this.identifier, this.amount);
    }

    private static String jvmdowngrader$concat$toString$1(String string, int n2, int n3) {
        return "StructuredItem{data=" + string + ", identifier=" + n2 + ", amount=" + n3 + "}";
    }
}

