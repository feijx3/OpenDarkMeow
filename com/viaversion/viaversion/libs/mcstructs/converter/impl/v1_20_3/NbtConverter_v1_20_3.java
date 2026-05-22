/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.MixedListTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class NbtConverter_v1_20_3
implements DataConverter<Tag> {
    public static final NbtConverter_v1_20_3 INSTANCE = new NbtConverter_v1_20_3();
    private final SNbt<CompoundTag> sNbt;

    public NbtConverter_v1_20_3() {
        this(SNbt.V1_14);
    }

    protected NbtConverter_v1_20_3(SNbt<CompoundTag> sNbt) {
        this.sNbt = sNbt;
    }

    @Override
    public <N> N convertTo(DataConverter<N> to, @Nullable Tag element) {
        if (to == this) {
            return (N)element;
        }
        if (element == null) {
            return to.empty();
        }
        if (element.getTagId() == 0) {
            return to.empty();
        }
        if (element instanceof ByteTag) {
            return to.createByte(((ByteTag)element).getValue());
        }
        if (element instanceof ShortTag) {
            return to.createShort(((ShortTag)element).getValue());
        }
        if (element instanceof IntTag) {
            return to.createInt(((IntTag)element).getValue());
        }
        if (element instanceof LongTag) {
            return to.createLong(((LongTag)element).getValue());
        }
        if (element instanceof FloatTag) {
            return to.createFloat(((FloatTag)element).getValue().floatValue());
        }
        if (element instanceof DoubleTag) {
            return to.createDouble(((DoubleTag)element).getValue());
        }
        if (element instanceof ByteArrayTag) {
            return to.createByteArray(((ByteArrayTag)element).getValue());
        }
        if (element instanceof StringTag) {
            return to.createString(((StringTag)element).getValue());
        }
        if (element instanceof ListTag) {
            return this.convertList(to, element);
        }
        if (element instanceof CompoundTag) {
            return this.convertMap(to, element);
        }
        if (element instanceof IntArrayTag) {
            return to.createIntArray(((IntArrayTag)element).getValue());
        }
        if (element instanceof LongArrayTag) {
            return to.createLongArray(((LongArrayTag)element).getValue());
        }
        throw new IllegalArgumentException("Unknown Nbt type: " + element);
    }

    @Override
    public Tag createBoolean(boolean value) {
        return new ByteTag(value);
    }

    @Override
    public Result<Boolean> asBoolean(Tag element) {
        return this.asNumber(element).map(number -> number.byteValue() != 0);
    }

    @Override
    public Tag createNumber(Number number) {
        return new DoubleTag(number.doubleValue());
    }

    @Override
    public Result<Number> asNumber(Tag element) {
        if (!(element instanceof NumberTag)) {
            return Result.unexpected((Object)element, NumberTag.class);
        }
        return Result.success(((NumberTag)element).getValue());
    }

    @Override
    public Tag createByte(byte value) {
        return new ByteTag(value);
    }

    @Override
    public Tag createShort(short value) {
        return new ShortTag(value);
    }

    @Override
    public Tag createInt(int value) {
        return new IntTag(value);
    }

    @Override
    public Tag createLong(long value) {
        return new LongTag(value);
    }

    @Override
    public Tag createFloat(float value) {
        return new FloatTag(value);
    }

    @Override
    public Tag createDouble(double value) {
        return new DoubleTag(value);
    }

    @Override
    public Tag createString(String value) {
        return new StringTag(value);
    }

    @Override
    public Result<String> asString(Tag element) {
        if (!(element instanceof StringTag)) {
            return Result.unexpected((Object)element, StringTag.class);
        }
        return Result.success(((StringTag)element).getValue());
    }

    @Override
    public Result<Tag> mergeList(@Nullable Tag list, List<Tag> values) {
        if (list == null) {
            list = new ListTag();
        }
        if (list instanceof ByteArrayTag && values.stream().allMatch(tag -> tag instanceof ByteTag)) {
            ByteArrayTag tag2 = (ByteArrayTag)((Object)list);
            byte[] bytes = Arrays.copyOf(tag2.getValue(), tag2.length() + values.size());
            for (int i2 = 0; i2 < values.size(); ++i2) {
                bytes[tag2.length() + i2] = ((NumberTag)values.get(i2)).asByte();
            }
            return Result.success(new ByteArrayTag(bytes));
        }
        if (list instanceof IntArrayTag && values.stream().allMatch(tag -> tag instanceof IntTag)) {
            IntArrayTag tag3 = (IntArrayTag)((Object)list);
            int[] ints = Arrays.copyOf(tag3.getValue(), tag3.length() + values.size());
            for (int i3 = 0; i3 < values.size(); ++i3) {
                ints[tag3.length() + i3] = ((NumberTag)values.get(i3)).asInt();
            }
            return Result.success(new IntArrayTag(ints));
        }
        if (list instanceof LongArrayTag && values.stream().allMatch(tag -> tag instanceof LongTag)) {
            LongArrayTag tag4 = (LongArrayTag)((Object)list);
            long[] longs = Arrays.copyOf(tag4.getValue(), tag4.length() + values.size());
            for (int i4 = 0; i4 < values.size(); ++i4) {
                longs[tag4.length() + i4] = ((NumberTag)values.get(i4)).asLong();
            }
            return Result.success(new LongArrayTag(longs));
        }
        Result<List<Tag>> listResult = this.asList(list);
        if (listResult.isError()) {
            return listResult.mapError();
        }
        ArrayList<Tag> elements = new ArrayList<Tag>((Collection)listResult.get());
        elements.addAll(values);
        Tag listType = null;
        Iterator iterator2 = elements.iterator();
        while (iterator2.hasNext()) {
            Tag value;
            Tag valueType = value = (Tag)iterator2.next();
            if (listType == null) {
                listType = valueType;
                continue;
            }
            if (valueType.equals(listType)) continue;
            listType = new MixedListTag();
        }
        if (listType == null) {
            return Result.success(new ListTag());
        }
        if (listType instanceof ByteTag) {
            byte[] bytes = new byte[elements.size()];
            for (int i5 = 0; i5 < elements.size(); ++i5) {
                bytes[i5] = ((ByteTag)elements.get(i5)).asByte();
            }
            return Result.success(new ByteArrayTag(bytes));
        }
        if (listType instanceof IntTag) {
            int[] ints = new int[elements.size()];
            for (int i6 = 0; i6 < elements.size(); ++i6) {
                ints[i6] = ((IntTag)elements.get(i6)).asInt();
            }
            return Result.success(new IntArrayTag(ints));
        }
        if (listType instanceof LongTag) {
            long[] longs = new long[elements.size()];
            for (int i7 = 0; i7 < elements.size(); ++i7) {
                longs[i7] = ((LongTag)elements.get(i7)).asLong();
            }
            return Result.success(new LongArrayTag(longs));
        }
        if (listType instanceof MixedListTag) {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>();
            for (Tag tag5 : elements) {
                boolean isMarker;
                boolean bl2 = isMarker = tag5 instanceof CompoundTag && ((CompoundTag)tag5).size() == 1 && ((CompoundTag)tag5).contains("");
                if (tag5 instanceof CompoundTag && !isMarker) {
                    listTag.add((CompoundTag)tag5);
                    continue;
                }
                CompoundTag wrappingTag = new CompoundTag();
                wrappingTag.put("", tag5);
                listTag.add(wrappingTag);
            }
            return Result.success(listTag);
        }
        return Result.success(new ListTag(elements));
    }

    @Override
    public Result<List<Tag>> asList(Tag element) {
        if (element instanceof ListTag) {
            ListTag listTag = (ListTag)element;
            ArrayList<Tag> list = new ArrayList<Tag>();
            if (CompoundTag.class == listTag.getElementType()) {
                for (Tag tag : listTag) {
                    Tag wrapped;
                    CompoundTag compound = (CompoundTag)tag;
                    Tag tag2 = wrapped = compound.size() == 1 ? compound.get("") : null;
                    if (wrapped != null) {
                        list.add(wrapped);
                        continue;
                    }
                    list.add(tag);
                }
            } else {
                list.addAll((Collection<Tag>)listTag.getValue());
            }
            return Result.success(list);
        }
        if (element instanceof NumberArrayTag) {
            return Result.success(((NumberArrayTag)element).toListTag().getValue());
        }
        return Result.unexpected((Object)element, ListTag.class, NumberArrayTag.class);
    }

    @Override
    public Tag createUnsafeMap(Map<Tag, Tag> values) {
        CompoundTag compound = new CompoundTag();
        for (Map.Entry<Tag, Tag> entry : values.entrySet()) {
            String key = entry.getKey() instanceof StringTag ? ((StringTag)entry.getKey()).getValue() : this.sNbt.trySerialize(entry.getKey());
            compound.put(key, entry.getValue());
        }
        return compound;
    }

    @Override
    public Result<Tag> mergeMap(@Nullable Tag map, Map<Tag, Tag> values) {
        if (map == null) {
            map = new CompoundTag();
        }
        if (!(map instanceof CompoundTag)) {
            return Result.unexpected((Object)map, CompoundTag.class);
        }
        CompoundTag compound = (CompoundTag)map;
        for (Map.Entry<Tag, Tag> entry : values.entrySet()) {
            if (entry.getKey() instanceof StringTag) {
                compound.put(((StringTag)entry.getKey()).getValue(), entry.getValue());
                continue;
            }
            return Result.error("Map key is not a string tag");
        }
        return Result.success(compound);
    }

    @Override
    public Result<Map<Tag, Tag>> asMap(Tag element) {
        if (!(element instanceof CompoundTag)) {
            return Result.unexpected((Object)element, CompoundTag.class);
        }
        CompoundTag compound = (CompoundTag)element;
        HashMap<Tag, Tag> map = new HashMap<Tag, Tag>();
        for (Map.Entry<String, Tag> entry : compound) {
            map.put(this.createString(entry.getKey()), entry.getValue());
        }
        return Result.success(map);
    }

    @Override
    public Result<Map<String, Tag>> asStringTypeMap(Tag element) {
        if (!(element instanceof CompoundTag)) {
            return Result.unexpected((Object)element, CompoundTag.class);
        }
        CompoundTag compound = (CompoundTag)element;
        HashMap<String, Tag> map = new HashMap<String, Tag>();
        for (Map.Entry<String, Tag> entry : compound) {
            map.put(entry.getKey(), entry.getValue());
        }
        return Result.success(map);
    }

    @Override
    public Tag createByteArray(byte[] value) {
        return new ByteArrayTag(value);
    }

    @Override
    public Result<byte[]> asByteArray(Tag element) {
        if (element instanceof ByteArrayTag) {
            return Result.success(((ByteArrayTag)element).getValue());
        }
        if (element instanceof IntArrayTag) {
            IntArrayTag intArrayTag = (IntArrayTag)element;
            byte[] bytes = new byte[intArrayTag.length()];
            for (int i2 = 0; i2 < intArrayTag.length(); ++i2) {
                bytes[i2] = (byte)intArrayTag.get(i2);
            }
            return Result.success(bytes);
        }
        if (element instanceof LongArrayTag) {
            LongArrayTag longArrayTag = (LongArrayTag)element;
            byte[] bytes = new byte[longArrayTag.length()];
            for (int i3 = 0; i3 < longArrayTag.length(); ++i3) {
                bytes[i3] = (byte)longArrayTag.get(i3);
            }
            return Result.success(bytes);
        }
        if (element instanceof ListTag) {
            List<Tag> list = this.asList(element).get();
            if (list.stream().allMatch(tag -> tag instanceof NumberTag)) {
                byte[] bytes = new byte[list.size()];
                for (int i4 = 0; i4 < list.size(); ++i4) {
                    bytes[i4] = ((NumberTag)list.get(i4)).asByte();
                }
                return Result.success(bytes);
            }
            return Result.error("List tag does not contain only number tags");
        }
        return Result.unexpected((Object)element, ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class);
    }

    @Override
    public Tag createIntArray(int[] value) {
        return new IntArrayTag(value);
    }

    @Override
    public Result<int[]> asIntArray(Tag element) {
        if (element instanceof ByteArrayTag) {
            ByteArrayTag byteArrayTag = (ByteArrayTag)element;
            int[] ints = new int[byteArrayTag.length()];
            for (int i2 = 0; i2 < byteArrayTag.length(); ++i2) {
                ints[i2] = byteArrayTag.get(i2);
            }
            return Result.success(ints);
        }
        if (element instanceof IntArrayTag) {
            return Result.success(((IntArrayTag)element).getValue());
        }
        if (element instanceof LongArrayTag) {
            LongArrayTag longArrayTag = (LongArrayTag)element;
            int[] ints = new int[longArrayTag.length()];
            for (int i3 = 0; i3 < longArrayTag.length(); ++i3) {
                ints[i3] = (int)longArrayTag.get(i3);
            }
            return Result.success(ints);
        }
        if (element instanceof ListTag) {
            List<Tag> list = this.asList(element).get();
            if (list.stream().allMatch(tag -> tag instanceof NumberTag)) {
                int[] ints = new int[list.size()];
                for (int i4 = 0; i4 < list.size(); ++i4) {
                    ints[i4] = ((NumberTag)list.get(i4)).asInt();
                }
                return Result.success(ints);
            }
            return Result.error("List tag does not contain only number tags");
        }
        return Result.unexpected((Object)element, ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class);
    }

    @Override
    public Tag createLongArray(long[] value) {
        return new LongArrayTag(value);
    }

    @Override
    public Result<long[]> asLongArray(Tag element) {
        if (element instanceof ByteArrayTag) {
            ByteArrayTag byteArrayTag = (ByteArrayTag)element;
            long[] longs = new long[byteArrayTag.length()];
            for (int i2 = 0; i2 < byteArrayTag.length(); ++i2) {
                longs[i2] = byteArrayTag.get(i2);
            }
            return Result.success(longs);
        }
        if (element instanceof IntArrayTag) {
            IntArrayTag intArrayTag = (IntArrayTag)element;
            long[] longs = new long[intArrayTag.length()];
            for (int i3 = 0; i3 < intArrayTag.length(); ++i3) {
                longs[i3] = intArrayTag.get(i3);
            }
            return Result.success(longs);
        }
        if (element instanceof LongArrayTag) {
            return Result.success(((LongArrayTag)element).getValue());
        }
        if (element instanceof ListTag) {
            List<Tag> list = this.asList(element).get();
            if (list.stream().allMatch(tag -> tag instanceof NumberTag)) {
                long[] longs = new long[list.size()];
                for (int i4 = 0; i4 < list.size(); ++i4) {
                    longs[i4] = ((NumberTag)list.get(i4)).asLong();
                }
                return Result.success(longs);
            }
            return Result.error("List tag does not contain only number tags");
        }
        return Result.unexpected((Object)element, ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class);
    }
}

