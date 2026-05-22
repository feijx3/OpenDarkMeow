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
import com.viaversion.viaversion.libs.gson.annotations.SerializedName;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DataItem
implements Item {
    @SerializedName(value="identifier", alternate={"id"})
    private int identifier;
    private byte amount;
    private short data;
    private CompoundTag tag;

    public DataItem() {
    }

    public DataItem(int identifier, byte amount, @Nullable CompoundTag tag) {
        this(identifier, amount, 0, tag);
    }

    public DataItem(int identifier, byte amount, short data, @Nullable CompoundTag tag) {
        this.identifier = identifier;
        this.amount = amount;
        this.data = data;
        this.tag = tag;
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
        if (amount != (byte)amount) {
            throw new IllegalArgumentException(DataItem.jvmdowngrader$concat$setAmount$1(amount));
        }
        this.amount = (byte)amount;
    }

    @Override
    public short data() {
        return this.data;
    }

    @Override
    public void setData(short data) {
        this.data = data;
    }

    @Override
    public @Nullable CompoundTag tag() {
        return this.tag;
    }

    @Override
    public void setTag(@Nullable CompoundTag tag) {
        this.tag = tag;
    }

    @Override
    public StructuredDataContainer dataContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DataItem copy() {
        return new DataItem(this.identifier, this.amount, this.data, this.tag != null ? this.tag.copy() : null);
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        DataItem item = (DataItem)o2;
        if (this.identifier != item.identifier) {
            return false;
        }
        if (this.amount != item.amount) {
            return false;
        }
        if (this.data != item.data) {
            return false;
        }
        return Objects.equals(this.tag, item.tag);
    }

    public int hashCode() {
        int result = this.identifier;
        result = 31 * result + this.amount;
        result = 31 * result + this.data;
        result = 31 * result + (this.tag != null ? this.tag.hashCode() : 0);
        return result;
    }

    public String toString() {
        return DataItem.jvmdowngrader$concat$toString$1(this.identifier, this.amount, this.data, String.valueOf(this.tag));
    }

    private static String jvmdowngrader$concat$setAmount$1(int n2) {
        return "Invalid item amount: " + n2;
    }

    private static String jvmdowngrader$concat$toString$1(int n2, byte by2, short s2, String string) {
        return "DataItem{identifier=" + n2 + ", amount=" + by2 + ", data=" + s2 + ", tag=" + string + "}";
    }
}

