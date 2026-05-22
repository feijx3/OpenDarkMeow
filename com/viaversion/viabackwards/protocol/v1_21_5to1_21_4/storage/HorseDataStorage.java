/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="data", type=byte.class), @RecordComponents.Value(name="saddled", type=boolean.class)})
public final class HorseDataStorage
extends J_L_Record {
    private final byte data;
    private final boolean saddled;

    public HorseDataStorage(byte data, boolean saddled) {
        this.data = data;
        this.saddled = saddled;
    }

    @Override
    public final String toString() {
        return HorseDataStorage.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return HorseDataStorage.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return HorseDataStorage.jvmdowngrader$equals$equals(this, o2);
    }

    public byte data() {
        return this.data;
    }

    public boolean saddled() {
        return this.saddled;
    }

    private static String jvmdowngrader$toString$toString(HorseDataStorage horseDataStorage) {
        HorseDataStorage horseDataStorage2 = horseDataStorage;
        return "HorseDataStorage[" + "data=" + horseDataStorage.data + ", " + "saddled=" + horseDataStorage.saddled + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(HorseDataStorage horseDataStorage) {
        Object[] objectArray = new Object[]{horseDataStorage.data, horseDataStorage.saddled};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(HorseDataStorage horseDataStorage, Object object) {
        if (horseDataStorage == object) {
            return true;
        }
        if (object != null && object instanceof HorseDataStorage) {
            HorseDataStorage horseDataStorage2 = (HorseDataStorage)object;
            if (horseDataStorage.data == horseDataStorage2.data && horseDataStorage.saddled == horseDataStorage2.saddled) {
                return true;
            }
        }
        return false;
    }
}

