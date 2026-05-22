/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public final class LongArrayTag
implements NumberArrayTag {
    public static final int ID = 12;
    private static final long[] EMPTY_ARRAY = new long[0];
    private long[] value;

    public LongArrayTag() {
        this(EMPTY_ARRAY);
    }

    public LongArrayTag(long[] value) {
        if (value == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = value;
    }

    public static LongArrayTag read(DataInput in, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countInt();
        int length = in.readInt();
        tagLimiter.countBytes(8 * length);
        long[] value = new long[length];
        for (int index = 0; index < value.length; ++index) {
            value[index] = in.readLong();
        }
        return new LongArrayTag(value);
    }

    public long[] getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Arrays.toString(this.value);
    }

    public void setValue(long[] value) {
        if (value == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = value;
    }

    public long get(int index) {
        return this.value[index];
    }

    public void set(int index, long value) {
        this.value[index] = value;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    public ListTag<LongTag> toListTag() {
        ListTag<LongTag> list = new ListTag<LongTag>(LongTag.class);
        for (long l2 : this.value) {
            list.add(new LongTag(l2));
        }
        return list;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.value.length);
        for (long l2 : this.value) {
            out.writeLong(l2);
        }
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        LongArrayTag that = (LongArrayTag)o2;
        return Arrays.equals(this.value, that.value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public LongArrayTag copy() {
        return new LongArrayTag((long[])this.value.clone());
    }

    @Override
    public int getTagId() {
        return 12;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

