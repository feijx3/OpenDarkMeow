/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.UUID;

public class ExtraCodecs_v1_20_5 {
    public static final Codec<UUID> LENIENT_UUID = Codec.oneOf(Codec.INT_ARRAY_UUID, Codec.STRICT_STRING_UUID);
    public static final Codec<CompoundTag> INLINED_COMPOUND_TAG = NbtConverter_v1_20_3.INSTANCE.toCodec().verified(tag -> {
        if (!(tag instanceof CompoundTag)) {
            return Result.error("Expected a compound tag");
        }
        return null;
    }).map(tag -> tag, tag -> (CompoundTag)tag);
}

