/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.version.Ref
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.TagType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

public class TextComponentTagType
extends TagType {
    private static final Set<String> BOOLEAN_KEYS = TextComponentTagType.jvmdg$inlined$of("bold", "italic", "underlined", "strikethrough", "obfuscated", "interpret");

    @Override
    public void write(Ops ops, Tag value) {
        if (value instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)value;
            ops.writeMap(map -> {
                for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                    this.write((Ops.MapSerializer)map, entry.getKey(), entry.getValue());
                }
            });
        } else {
            super.write(ops, value);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void write(Ops.MapSerializer map, String key, Tag value) {
        if (value instanceof ByteTag) {
            ByteTag byteTag = (ByteTag)value;
            if (BOOLEAN_KEYS.contains(key)) {
                map.write(key, Types.BOOLEAN, byteTag.asBoolean());
                return;
            }
        }
        map.write(key, this, value);
    }

    @Stub(ref=@Ref(value="Ljava/util/Set;"))
    private static <E> Set<E> jvmdg$inlined$of(E e1, E e2, E e3, E e4, E e5, E e6) {
        return Collections.unmodifiableSet(new HashSet<Object>(Arrays.asList(e1, e2, e3, e4, e5, e6)));
    }
}

