/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data;

import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;

public final class MaxStackSize1_20_3 {
    private static final Int2IntMap MAPPING = new Int2IntOpenHashMap();

    public static int getMaxStackSize(int identifier) {
        return MAPPING.getOrDefault(identifier, 64);
    }

    private static void fill(int start, int end, int value) {
        for (int i2 = start; i2 <= end; ++i2) {
            MAPPING.put(i2, value);
        }
    }

    static {
        MaxStackSize1_20_3.fill(521, 537, 1);
        MaxStackSize1_20_3.fill(764, 790, 1);
        MAPPING.put(793, 1);
        MAPPING.put(795, 1);
        MAPPING.put(797, 1);
        MaxStackSize1_20_3.fill(814, 843, 1);
        MAPPING.put(846, 1);
        MAPPING.put(853, 1);
        MaxStackSize1_20_3.fill(854, 876, 1);
        MaxStackSize1_20_3.fill(883, 905, 16);
        MaxStackSize1_20_3.fill(906, 908, 1);
        MAPPING.put(909, 16);
        MaxStackSize1_20_3.fill(911, 917, 1);
        MAPPING.put(924, 16);
        MAPPING.put(927, 1);
        MAPPING.put(928, 1);
        MAPPING.put(930, 1);
        MaxStackSize1_20_3.fill(960, 976, 1);
        MAPPING.put(980, 1);
        MAPPING.put(990, 16);
        MAPPING.put(995, 1);
        MAPPING.put(1085, 1);
        MAPPING.put(1086, 16);
        MAPPING.put(1107, 1);
        MAPPING.put(1113, 1);
        MAPPING.put(1116, 16);
        MaxStackSize1_20_3.fill(1117, 1120, 1);
        MAPPING.put(1123, 1);
        MaxStackSize1_20_3.fill(1126, 1141, 16);
        MAPPING.put(1149, 1);
        MAPPING.put(1151, 1);
        MaxStackSize1_20_3.fill(1154, 1156, 1);
        MaxStackSize1_20_3.fill(1159, 1176, 1);
        MAPPING.put(1178, 1);
        MAPPING.put(1182, 1);
        MAPPING.put(1183, 1);
        MaxStackSize1_20_3.fill(1185, 1191, 1);
        MAPPING.put(1212, 16);
        MAPPING.put(1256, 1);
    }
}

