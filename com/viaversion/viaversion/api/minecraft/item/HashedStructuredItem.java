/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class HashedStructuredItem
implements HashedItem {
    private final Int2IntMap dataHashes;
    private final IntSet removedData;
    private int identifier;
    private int amount;

    public HashedStructuredItem(int identifier, int amount) {
        this(identifier, amount, new Int2IntOpenHashMap(0), new IntOpenHashSet(0));
    }

    public HashedStructuredItem(int identifier, int amount, Int2IntMap dataHashes, IntSet removedData) {
        this.identifier = identifier;
        this.amount = amount;
        this.dataHashes = dataHashes;
        this.removedData = removedData;
    }

    public static HashedStructuredItem empty() {
        return new HashedStructuredItem(0, 0);
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
    public Int2IntMap dataHashesById() {
        return this.dataHashes;
    }

    @Override
    public IntSet removedDataIds() {
        return this.removedData;
    }

    @Override
    public HashedItem copy() {
        return new HashedStructuredItem(this.identifier, this.amount, new Int2IntOpenHashMap(this.dataHashes), new IntOpenHashSet(this.removedData));
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        HashedStructuredItem that = (HashedStructuredItem)o2;
        if (this.identifier != that.identifier) {
            return false;
        }
        if (this.amount != that.amount) {
            return false;
        }
        return this.dataHashes.equals(that.dataHashes) && this.removedData.equals(that.removedData);
    }

    public int hashCode() {
        int result = this.dataHashes.hashCode();
        result = 31 * result + this.removedData.hashCode();
        result = 31 * result + this.identifier;
        result = 31 * result + this.amount;
        return result;
    }

    public String toString() {
        return HashedStructuredItem.jvmdowngrader$concat$toString$1(String.valueOf(this.dataHashes), String.valueOf(this.removedData), this.identifier, this.amount);
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2, int n2, int n3) {
        return "HashedStructuredItem{data=Hashes" + string + ", removedData=" + string2 + ", identifier=" + n2 + ", amount=" + n3 + "}";
    }
}

