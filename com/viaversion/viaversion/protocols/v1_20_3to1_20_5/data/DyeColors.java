/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data;

import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.util.KeyMappings;

public final class DyeColors {
    public static final KeyMappings COLORS = new KeyMappings(EnumTypes.DYE_COLOR.names());

    public static String idToKey(int id) {
        String color = COLORS.idToKey(id);
        return color == null ? "white" : color;
    }

    public static int keyToId(String pattern) {
        return COLORS.keyToId(pattern);
    }
}

