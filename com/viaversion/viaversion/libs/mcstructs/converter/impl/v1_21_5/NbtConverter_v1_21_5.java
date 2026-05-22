/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_21_5;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class NbtConverter_v1_21_5
extends NbtConverter_v1_20_3 {
    public static final NbtConverter_v1_21_5 INSTANCE = new NbtConverter_v1_21_5();

    public NbtConverter_v1_21_5() {
        this(SNbt.V1_21_5);
    }

    protected NbtConverter_v1_21_5(SNbt<CompoundTag> sNbt) {
        super(sNbt);
    }

    @Override
    public Result<Tag> mergeList(@Nullable Tag list, List<Tag> values) {
        Result<List<Tag>> listResult;
        ListType listType;
        if (list == null) {
            listType = ListType.LIST;
        } else if (list instanceof ByteArrayTag) {
            listType = ((ByteArrayTag)list).length() == 0 ? ListType.LIST : ListType.BYTE;
        } else if (list instanceof IntArrayTag) {
            listType = ((IntArrayTag)list).length() == 0 ? ListType.LIST : ListType.INT;
        } else if (list instanceof LongArrayTag) {
            listType = ((LongArrayTag)list).length() == 0 ? ListType.LIST : ListType.LONG;
        } else if (list instanceof ListTag) {
            ListTag listTag = (ListTag)list;
            listType = CompoundTag.class == listTag.getElementType() ? ListType.MIXED_LIST : ListType.LIST;
        } else {
            return Result.error("Invalid list tag: " + list);
        }
        Result<List<Tag>> result = listResult = list == null ? Result.success(new ArrayList()) : this.asList(list);
        if (listResult.isError()) {
            return listResult.mapError();
        }
        List<Tag> tags = listResult.get();
        tags.addAll(values);
        if (tags.isEmpty()) {
            return Result.success(new ListTag());
        }
        if (listType.equals((Object)ListType.BYTE)) {
            if (tags.stream().allMatch(tag -> tag instanceof ByteTag)) {
                byte[] bytes = new byte[tags.size()];
                for (int i2 = 0; i2 < tags.size(); ++i2) {
                    bytes[i2] = ((ByteTag)tags.get(i2)).getValue();
                }
                return Result.success(new ByteArrayTag(bytes));
            }
        } else if (listType.equals((Object)ListType.INT)) {
            if (tags.stream().allMatch(tag -> tag instanceof IntTag)) {
                int[] ints = new int[tags.size()];
                for (int i3 = 0; i3 < tags.size(); ++i3) {
                    ints[i3] = ((IntTag)tags.get(i3)).getValue();
                }
                return Result.success(new IntArrayTag(ints));
            }
        } else if (listType.equals((Object)ListType.LONG)) {
            if (tags.stream().allMatch(tag -> tag instanceof LongTag)) {
                long[] longs = new long[tags.size()];
                for (int i4 = 0; i4 < tags.size(); ++i4) {
                    longs[i4] = ((LongTag)tags.get(i4)).getValue();
                }
                return Result.success(new LongArrayTag(longs));
            }
        } else if (listType.equals((Object)ListType.LIST)) {
            Tag type = null;
            for (Tag tag2 : tags) {
                if (type == null) {
                    type = tag2;
                    continue;
                }
                if (type.equals(tag2)) continue;
                type = null;
                break;
            }
            if (type != null) {
                return Result.success(new ListTag<Tag>(tags));
            }
        }
        ListTag<Tag> out = new ListTag<Tag>();
        for (Tag tag2 : tags) {
            boolean isMarker;
            boolean bl2 = isMarker = tag2 instanceof CompoundTag && ((CompoundTag)tag2).size() == 1 && ((CompoundTag)tag2).contains("");
            if (tag2 instanceof CompoundTag && !isMarker) {
                out.add(tag2);
                continue;
            }
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("", tag2);
            out.add(compoundTag);
        }
        return Result.success(out);
    }

    private static enum ListType {
        BYTE,
        INT,
        LONG,
        LIST,
        MIXED_LIST;

    }
}

