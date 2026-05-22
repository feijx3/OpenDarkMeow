/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12;

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
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtSerializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtSerializer;
import java.util.Map;
import java.util.regex.Pattern;

public class SNbtSerializer_v1_12
implements SNbtSerializer {
    private static final Pattern ESCAPE_PATTERN = Pattern.compile("[A-Za-z0-9._+-]+");

    @Override
    public String serialize(Tag tag) throws SNbtSerializeException {
        if (tag instanceof ByteTag) {
            ByteTag byteTag = (ByteTag)tag;
            return byteTag.getValue() + "b";
        }
        if (tag instanceof ShortTag) {
            ShortTag shortTag = (ShortTag)tag;
            return shortTag.getValue() + "s";
        }
        if (tag instanceof IntTag) {
            IntTag intTag = (IntTag)tag;
            return String.valueOf(intTag.getValue());
        }
        if (tag instanceof LongTag) {
            LongTag longTag = (LongTag)tag;
            return longTag.getValue() + "L";
        }
        if (tag instanceof FloatTag) {
            FloatTag floatTag = (FloatTag)tag;
            return floatTag.getValue() + "f";
        }
        if (tag instanceof DoubleTag) {
            DoubleTag doubleTag = (DoubleTag)tag;
            return doubleTag.getValue() + "d";
        }
        if (tag instanceof ByteArrayTag) {
            ByteArrayTag byteArrayTag = (ByteArrayTag)tag;
            StringBuilder out = new StringBuilder("[B;");
            for (int i2 = 0; i2 < byteArrayTag.length(); ++i2) {
                if (i2 != 0) {
                    out.append(",");
                }
                out.append(byteArrayTag.get(i2)).append("B");
            }
            return out.append("]").toString();
        }
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return this.escape(stringTag.getValue());
        }
        if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            StringBuilder out = new StringBuilder("[");
            for (int i3 = 0; i3 < listTag.size(); ++i3) {
                if (i3 != 0) {
                    out.append(",");
                }
                out.append(this.serialize((Tag)listTag.get(i3)));
            }
            return out.append("]").toString();
        }
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            StringBuilder out = new StringBuilder("{");
            for (Map.Entry entry : compoundTag.getValue().entrySet()) {
                if (out.length() != 1) {
                    out.append(",");
                }
                out.append(this.checkEscape((String)entry.getKey())).append(":").append(this.serialize((Tag)entry.getValue()));
            }
            return out.append("}").toString();
        }
        if (tag instanceof IntArrayTag) {
            IntArrayTag intArrayTag = (IntArrayTag)tag;
            StringBuilder out = new StringBuilder("[I;");
            for (int i4 = 0; i4 < intArrayTag.length(); ++i4) {
                if (i4 != 0) {
                    out.append(",");
                }
                out.append(intArrayTag.get(i4));
            }
            return out.append("]").toString();
        }
        if (tag instanceof LongArrayTag) {
            LongArrayTag longArrayTag = (LongArrayTag)tag;
            StringBuilder out = new StringBuilder("[L;");
            for (int i5 = 0; i5 < longArrayTag.length(); ++i5) {
                if (i5 != 0) {
                    out.append(",");
                }
                out.append(longArrayTag.get(i5)).append("L");
            }
            return out.append("]").toString();
        }
        throw new SNbtSerializeException(tag);
    }

    protected String checkEscape(String s2) {
        if (ESCAPE_PATTERN.matcher(s2).matches()) {
            return s2;
        }
        return this.escape(s2);
    }

    protected String escape(String s2) {
        char[] chars;
        StringBuilder out = new StringBuilder("\"");
        for (char c2 : chars = s2.toCharArray()) {
            if (c2 == '\\' || c2 == '\"') {
                out.append("\\");
            }
            out.append(c2);
        }
        return out.append("\"").toString();
    }
}

