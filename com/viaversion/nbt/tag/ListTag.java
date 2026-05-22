/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.io.TagRegistry;
import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.MixedListTag;
import com.viaversion.nbt.tag.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

public class ListTag<T extends Tag>
implements Tag,
Iterable<T> {
    public static final int ID = 9;
    protected List<T> value;
    private Class<T> type;

    @Deprecated
    public ListTag() {
        this.value = new ArrayList<T>();
    }

    public ListTag(Class<T> type) {
        this.type = type;
        this.value = new ArrayList<T>();
    }

    private ListTag(Class<T> type, List<T> value) {
        this.type = type;
        this.value = value;
    }

    public ListTag(List<T> value) {
        this.setValue(value);
    }

    public static ListTag<?> of(List<Tag> value) {
        int type = -1;
        for (Tag tag : value) {
            if (type == -1) {
                type = tag.getTagId();
                continue;
            }
            if (type == tag.getTagId()) continue;
            return new MixedListTag(value);
        }
        return new ListTag<Tag>(value);
    }

    public static ListTag<?> read(DataInput in, TagLimiter tagLimiter, int nestingLevel) throws IOException {
        tagLimiter.checkLevel(nestingLevel);
        tagLimiter.countBytes(5);
        byte id = in.readByte();
        Class<? extends Tag> type = null;
        if (id != 0 && (type = TagRegistry.getClassFor(id)) == null) {
            throw new IOException("Unknown tag ID in ListTag: " + id);
        }
        return ListTag.read(in, id, type, tagLimiter, nestingLevel);
    }

    private static <T extends Tag> ListTag<?> read(DataInput in, int id, Class<T> type, TagLimiter tagLimiter, int nestingLevel) throws IOException {
        int count = in.readInt();
        ListTag<T> listTag = new ListTag<T>(type, new ArrayList(Math.min(count, Short.MAX_VALUE)));
        int newNestingLevel = nestingLevel + 1;
        for (int index = 0; index < count; ++index) {
            Tag tag;
            try {
                tag = TagRegistry.read(id, in, tagLimiter, newNestingLevel);
            }
            catch (IllegalArgumentException e2) {
                throw new IOException("Failed to create tag.", e2);
            }
            Tag wrappedTag = ListTag.unwrap(tag);
            if (wrappedTag != null) {
                MixedListTag mixedListTag = new MixedListTag(listTag.value);
                mixedListTag.add(wrappedTag);
                int remaining = count - index - 1;
                return ListTag.readMixed(mixedListTag, in, tagLimiter, nestingLevel, remaining);
            }
            listTag.value.add(tag);
        }
        return listTag;
    }

    private static MixedListTag readMixed(MixedListTag listTag, DataInput in, TagLimiter tagLimiter, int nestingLevel, int count) throws IOException {
        for (int index = 0; index < count; ++index) {
            Tag tag;
            try {
                tag = TagRegistry.read(10, in, tagLimiter, nestingLevel);
            }
            catch (IllegalArgumentException e2) {
                throw new IOException("Failed to create tag.", e2);
            }
            Tag wrappedTag = ListTag.unwrap(tag);
            listTag.add(wrappedTag != null ? wrappedTag : tag);
        }
        return listTag;
    }

    @Nullable
    private static Tag unwrap(Tag tag) {
        CompoundTag compoundTag;
        if (tag instanceof CompoundTag && (compoundTag = (CompoundTag)tag).size() == 1) {
            return compoundTag.get("");
        }
        return null;
    }

    @Override
    public List<T> getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return this.value.toString();
    }

    public void setValue(List<T> value) {
        this.value = new ArrayList<T>(value);
        if (!value.isEmpty()) {
            if (this.type == null) {
                this.type = ((Tag)value.get(0)).getClass();
            }
            for (Tag t2 : value) {
                this.checkType(t2);
            }
        }
    }

    @Nullable
    public Class<? extends Tag> getElementType() {
        return this.type;
    }

    public boolean add(T tag) throws IllegalArgumentException {
        this.checkAddedTag(tag);
        return this.value.add(tag);
    }

    protected void checkAddedTag(T tag) {
        if (this.type == null) {
            this.type = tag.getClass();
        } else {
            this.checkType((Tag)tag);
        }
    }

    private void checkType(Tag tag) {
        if (tag.getClass() != this.type) {
            throw new IllegalArgumentException("Tag type " + tag.getClass().getSimpleName() + " differs from list type " + this.type.getSimpleName());
        }
    }

    public boolean remove(T tag) {
        return this.value.remove(tag);
    }

    public T get(int index) {
        return (T)((Tag)this.value.get(index));
    }

    public T set(int index, T tag) {
        this.checkAddedTag(tag);
        return (T)((Tag)this.value.set(index, tag));
    }

    public T remove(int index) {
        return (T)((Tag)this.value.remove(index));
    }

    public int size() {
        return this.value.size();
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public Stream<T> stream() {
        return this.value.stream();
    }

    @Override
    public Iterator<T> iterator() {
        return this.value.iterator();
    }

    @Override
    public void write(DataOutput out) throws IOException {
        if (this.value.isEmpty()) {
            out.writeByte(0);
        } else {
            int id = TagRegistry.getIdFor(this.type);
            if (id == -1) {
                throw new IOException("ListTag contains unregistered tag class.");
            }
            out.writeByte(id);
        }
        out.writeInt(this.value.size());
        for (Tag tag : this.value) {
            tag.write(out);
        }
    }

    @Override
    public ListTag<T> copy() {
        ListTag<Tag> copy = new ListTag<Tag>(this.type);
        copy.value = new ArrayList<T>(this.value.size());
        for (Tag value : this.value) {
            copy.add(value.copy());
        }
        return copy;
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        ListTag tags = (ListTag)o2;
        if (!Objects.equals(this.type, tags.type)) {
            return false;
        }
        return this.value.equals(tags.value);
    }

    public int hashCode() {
        int result = this.type != null ? this.type.hashCode() : 0;
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public int getTagId() {
        return 9;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

