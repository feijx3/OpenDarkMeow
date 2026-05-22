/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufInputStream
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.io.TagRegistry;
import com.viaversion.nbt.limiter.TagLimiter;
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
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.NamedCompoundTagType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import java.io.DataInput;
import java.io.IOException;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalTagType.class})
public class TagType
extends Type<Tag> {
    public TagType() {
        super(Tag.class);
    }

    @Override
    public Tag read(ByteBuf buffer) {
        byte id = buffer.readByte();
        if (id == 0) {
            return null;
        }
        TagLimiter tagLimiter = TagLimiter.create(0x200000, 512);
        try {
            return TagRegistry.read(id, (DataInput)new ByteBufInputStream(buffer), tagLimiter, 0);
        }
        catch (IOException e2) {
            if (Via.getManager().isDebug()) {
                throw new RuntimeException(e2);
            }
            throw new RuntimeException(TagType.jvmdowngrader$concat$read$1(e2.getMessage()));
        }
    }

    @Override
    public void write(ByteBuf buffer, Tag tag) {
        try {
            NamedCompoundTagType.write(buffer, tag, null);
        }
        catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override
    public void write(Ops ops, Tag value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot write null tag");
        }
        if (value instanceof StringTag) {
            StringTag stringTag = (StringTag)value;
            ops.writeString(stringTag.getValue());
        } else if (value instanceof NumberTag) {
            if (value instanceof IntTag) {
                IntTag intTag = (IntTag)value;
                ops.writeInt(intTag.asInt());
            } else if (value instanceof ByteTag) {
                ByteTag byteTag = (ByteTag)value;
                ops.writeByte(byteTag.asByte());
            } else if (value instanceof FloatTag) {
                FloatTag floatTag = (FloatTag)value;
                ops.writeFloat(floatTag.asFloat());
            } else if (value instanceof DoubleTag) {
                DoubleTag doubleTag = (DoubleTag)value;
                ops.writeDouble(doubleTag.asDouble());
            } else if (value instanceof ShortTag) {
                ShortTag shortTag = (ShortTag)value;
                ops.writeShort(shortTag.asShort());
            } else if (value instanceof LongTag) {
                LongTag longTag = (LongTag)value;
                ops.writeLong(longTag.asLong());
            }
        } else if (value instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)value;
            ops.writeMap(map -> {
                for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                    map.write(entry.getKey(), this, entry.getValue());
                }
            });
        } else if (value instanceof ListTag) {
            ListTag listTag = (ListTag)value;
            ops.writeList(list -> {
                for (Tag tag : listTag) {
                    list.write(this, tag);
                }
            });
        } else if (value instanceof IntArrayTag) {
            IntArrayTag intArrayTag = (IntArrayTag)value;
            ops.writeInts(intArrayTag.getValue());
        } else if (value instanceof ByteArrayTag) {
            ByteArrayTag byteArrayTag = (ByteArrayTag)value;
            ops.writeBytes(byteArrayTag.getValue());
        } else if (value instanceof LongArrayTag) {
            LongArrayTag longArrayTag = (LongArrayTag)value;
            ops.writeLongs(longArrayTag.getValue());
        } else {
            throw new IllegalArgumentException(TagType.jvmdowngrader$concat$write$1(String.valueOf(value)));
        }
    }

    private static String jvmdowngrader$concat$read$1(String string) {
        return "Error reading tag :" + string;
    }

    private static String jvmdowngrader$concat$write$1(String string) {
        return "Unknown tag type: " + string;
    }

    @NestHost(value=TagType.class)
    public static final class OptionalTagType
    extends OptionalType<Tag> {
        public OptionalTagType() {
            super(Types.TAG);
        }
    }
}

