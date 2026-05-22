/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_4;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Arrays;
import java.util.UUID;

public class ExtraCodecs_v1_21_4 {
    public static final Codec<Integer> ARGB_COLOR = Codec.oneOf(Codec.INTEGER, Codec.FLOAT.listOf(4, 4).map(i2 -> {
        float a2 = (float)(i2 >> 24 & 0xFF) / 255.0f;
        float r2 = (float)(i2 >> 16 & 0xFF) / 255.0f;
        float g2 = (float)(i2 >> 8 & 0xFF) / 255.0f;
        float b2 = (float)(i2 & 0xFF) / 255.0f;
        return Arrays.asList(Float.valueOf(r2), Float.valueOf(g2), Float.valueOf(b2), Float.valueOf(a2));
    }, floats -> {
        int r2 = (int)(((Float)floats.get(0)).floatValue() * 255.0f);
        int g2 = (int)(((Float)floats.get(1)).floatValue() * 255.0f);
        int b2 = (int)(((Float)floats.get(2)).floatValue() * 255.0f);
        int a2 = (int)(((Float)floats.get(3)).floatValue() * 255.0f);
        return a2 << 24 | r2 << 16 | g2 << 8 | b2;
    }));
    public static final Codec<UUID> LENIENT_UUID = Codec.oneOf(Codec.INT_ARRAY_UUID, Codec.STRICT_STRING_UUID);
    public static final Codec<CompoundTag> INLINED_COMPOUND_TAG = NbtConverter_v1_20_3.INSTANCE.toCodec().verified(tag -> {
        if (!(tag instanceof CompoundTag)) {
            return Result.error("Expected a compound tag");
        }
        return null;
    }).map(tag -> tag, tag -> (CompoundTag)tag);
}

