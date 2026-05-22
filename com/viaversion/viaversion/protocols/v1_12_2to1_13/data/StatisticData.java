/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="categoryId", type=int.class), @RecordComponents.Value(name="newId", type=int.class), @RecordComponents.Value(name="value", type=int.class)})
public final class StatisticData
extends J_L_Record {
    private final int categoryId;
    private final int newId;
    private final int value;

    public StatisticData(int categoryId, int newId, int value) {
        this.categoryId = categoryId;
        this.newId = newId;
        this.value = value;
    }

    @Override
    public final String toString() {
        return StatisticData.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return StatisticData.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return StatisticData.jvmdowngrader$equals$equals(this, o2);
    }

    public int categoryId() {
        return this.categoryId;
    }

    public int newId() {
        return this.newId;
    }

    public int value() {
        return this.value;
    }

    private static String jvmdowngrader$toString$toString(StatisticData statisticData) {
        StatisticData statisticData2 = statisticData;
        return "StatisticData[" + "categoryId=" + statisticData.categoryId + ", " + "newId=" + statisticData.newId + ", " + "value=" + statisticData.value + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(StatisticData statisticData) {
        Object[] objectArray = new Object[]{statisticData.categoryId, statisticData.newId, statisticData.value};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(StatisticData statisticData, Object object) {
        if (statisticData == object) {
            return true;
        }
        if (object != null && object instanceof StatisticData) {
            StatisticData statisticData2 = (StatisticData)object;
            if (statisticData.categoryId == statisticData2.categoryId && statisticData.newId == statisticData2.newId && statisticData.value == statisticData2.value) {
                return true;
            }
        }
        return false;
    }
}

