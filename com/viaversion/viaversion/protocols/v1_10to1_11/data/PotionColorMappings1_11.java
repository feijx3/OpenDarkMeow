/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_10to1_11.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PotionData.class})
public class PotionColorMappings1_11 {
    private static final Int2ObjectMap<PotionData> POTIONS = new Int2ObjectOpenHashMap<PotionData>(37);

    public static @Nullable PotionData getNewData(int oldData) {
        return (PotionData)POTIONS.get(oldData);
    }

    private static void addRewrite(int oldData, int newData, boolean isInstant) {
        POTIONS.put(oldData, new PotionData(newData, isInstant));
    }

    static {
        PotionColorMappings1_11.addRewrite(0, 3694022, false);
        PotionColorMappings1_11.addRewrite(1, 3694022, false);
        PotionColorMappings1_11.addRewrite(2, 3694022, false);
        PotionColorMappings1_11.addRewrite(3, 3694022, false);
        PotionColorMappings1_11.addRewrite(4, 3694022, false);
        PotionColorMappings1_11.addRewrite(5, 0x1F1FA1, false);
        PotionColorMappings1_11.addRewrite(6, 0x1F1FA1, false);
        PotionColorMappings1_11.addRewrite(7, 8356754, false);
        PotionColorMappings1_11.addRewrite(8, 8356754, false);
        PotionColorMappings1_11.addRewrite(9, 2293580, false);
        PotionColorMappings1_11.addRewrite(10, 2293580, false);
        PotionColorMappings1_11.addRewrite(11, 2293580, false);
        PotionColorMappings1_11.addRewrite(12, 14981690, false);
        PotionColorMappings1_11.addRewrite(13, 14981690, false);
        PotionColorMappings1_11.addRewrite(14, 8171462, false);
        PotionColorMappings1_11.addRewrite(15, 8171462, false);
        PotionColorMappings1_11.addRewrite(16, 8171462, false);
        PotionColorMappings1_11.addRewrite(17, 5926017, false);
        PotionColorMappings1_11.addRewrite(18, 5926017, false);
        PotionColorMappings1_11.addRewrite(19, 3035801, false);
        PotionColorMappings1_11.addRewrite(20, 3035801, false);
        PotionColorMappings1_11.addRewrite(21, 16262179, true);
        PotionColorMappings1_11.addRewrite(22, 16262179, true);
        PotionColorMappings1_11.addRewrite(23, 4393481, true);
        PotionColorMappings1_11.addRewrite(24, 4393481, true);
        PotionColorMappings1_11.addRewrite(25, 5149489, false);
        PotionColorMappings1_11.addRewrite(26, 5149489, false);
        PotionColorMappings1_11.addRewrite(27, 5149489, false);
        PotionColorMappings1_11.addRewrite(28, 13458603, false);
        PotionColorMappings1_11.addRewrite(29, 13458603, false);
        PotionColorMappings1_11.addRewrite(30, 13458603, false);
        PotionColorMappings1_11.addRewrite(31, 9643043, false);
        PotionColorMappings1_11.addRewrite(32, 9643043, false);
        PotionColorMappings1_11.addRewrite(33, 9643043, false);
        PotionColorMappings1_11.addRewrite(34, 0x484D48, false);
        PotionColorMappings1_11.addRewrite(35, 0x484D48, false);
        PotionColorMappings1_11.addRewrite(36, 0x339900, false);
    }

    @RecordComponents(value={@RecordComponents.Value(name="data", type=int.class), @RecordComponents.Value(name="instant", type=boolean.class)})
    @NestHost(value=PotionColorMappings1_11.class)
    public static final class PotionData
    extends J_L_Record {
        private final int data;
        private final boolean instant;

        public PotionData(int data, boolean instant) {
            this.data = data;
            this.instant = instant;
        }

        @Override
        public final String toString() {
            return PotionData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PotionData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PotionData.jvmdowngrader$equals$equals(this, o2);
        }

        public int data() {
            return this.data;
        }

        public boolean instant() {
            return this.instant;
        }

        private static String jvmdowngrader$toString$toString(PotionData potionData) {
            PotionData potionData2 = potionData;
            return "PotionColorMappings1_11$PotionData[" + "data=" + potionData.data + ", " + "instant=" + potionData.instant + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PotionData potionData) {
            Object[] objectArray = new Object[]{potionData.data, potionData.instant};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PotionData potionData, Object object) {
            if (potionData == object) {
                return true;
            }
            if (object != null && object instanceof PotionData) {
                PotionData potionData2 = (PotionData)object;
                if (potionData.data == potionData2.data && potionData.instant == potionData2.instant) {
                    return true;
                }
            }
            return false;
        }
    }
}

