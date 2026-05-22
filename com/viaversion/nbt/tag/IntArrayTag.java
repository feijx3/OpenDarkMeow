/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public final class IntArrayTag
implements NumberArrayTag {
    public static final int ID = 11;
    private static final int[] EMPTY_ARRAY = new int[0];
    private int[] value;

    public IntArrayTag() {
        this(EMPTY_ARRAY);
    }

    public IntArrayTag(int[] value) {
        if (value == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = value;
    }

    public static IntArrayTag read(DataInput in, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countInt();
        int length = in.readInt();
        tagLimiter.countBytes(4 * length);
        int[] value = new int[length];
        for (int index = 0; index < value.length; ++index) {
            value[index] = in.readInt();
        }
        return new IntArrayTag(value);
    }

    public int[] getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Arrays.toString(this.value);
    }

    public void setValue(int[] value) {
        if (value == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = value;
    }

    public int get(int index) {
        return this.value[index];
    }

    public void set(int index, int value) {
        this.value[index] = value;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    public ListTag<IntTag> toListTag() {
        ListTag<IntTag> list = new ListTag<IntTag>(IntTag.class);
        for (int i2 : this.value) {
            list.add(new IntTag(i2));
        }
        return list;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.value.length);
        for (int i2 : this.value) {
            out.writeInt(i2);
        }
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        IntArrayTag that = (IntArrayTag)o2;
        return Arrays.equals(this.value, that.value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public IntArrayTag copy() {
        return new IntArrayTag((int[])this.value.clone());
    }

    @Override
    public int getTagId() {
        return 11;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

