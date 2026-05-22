/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="type", type=int.class), @RecordComponents.Value(name="profession", type=int.class), @RecordComponents.Value(name="level", type=int.class)})
public final class VillagerData
extends J_L_Record {
    private final int type;
    private final int profession;
    private final int level;

    public VillagerData(int type, int profession, int level) {
        this.type = type;
        this.profession = profession;
        this.level = level;
    }

    @Override
    public final String toString() {
        return VillagerData.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return VillagerData.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return VillagerData.jvmdowngrader$equals$equals(this, o2);
    }

    public int type() {
        return this.type;
    }

    public int profession() {
        return this.profession;
    }

    public int level() {
        return this.level;
    }

    private static String jvmdowngrader$toString$toString(VillagerData villagerData) {
        VillagerData villagerData2 = villagerData;
        return "VillagerData[" + "type=" + villagerData.type + ", " + "profession=" + villagerData.profession + ", " + "level=" + villagerData.level + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(VillagerData villagerData) {
        Object[] objectArray = new Object[]{villagerData.type, villagerData.profession, villagerData.level};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(VillagerData villagerData, Object object) {
        if (villagerData == object) {
            return true;
        }
        if (object != null && object instanceof VillagerData) {
            VillagerData villagerData2 = (VillagerData)object;
            if (villagerData.type == villagerData2.type && villagerData.profession == villagerData2.profession && villagerData.level == villagerData2.level) {
                return true;
            }
        }
        return false;
    }
}

