/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_6;

import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.UUID;

public class ExtraCodecs_v1_21_6 {
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
    public static final Codec<URI> UNTRUSTED_URI = Codec.STRING.flatMap(uri -> Result.success(uri.toString()), s2 -> {
        try {
            URI uri = new URI((String)s2);
            if (uri.getScheme() == null) {
                throw new URISyntaxException((String)s2, "Missing scheme");
            }
            if (!uri.getScheme().equalsIgnoreCase("http") && !uri.getScheme().equalsIgnoreCase("https")) {
                throw new URISyntaxException((String)s2, "Unsupported scheme: " + uri.getScheme());
            }
            return Result.success(uri);
        }
        catch (Throwable t2) {
            return Result.error(t2);
        }
    });
    public static final Codec<String> CHAT_STRING = Codec.STRING.verified(s2 -> {
        for (char c2 : s2.toCharArray()) {
            if (c2 != '\u00a7' && c2 >= ' ' && c2 != '\u007f') continue;
            return Result.error("Illegal character: " + c2);
        }
        return null;
    });
    public static final Codec<UUID> LENIENT_UUID = Codec.oneOf(Codec.INT_ARRAY_UUID, Codec.STRICT_STRING_UUID);
}

