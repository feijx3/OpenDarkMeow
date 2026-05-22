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

@RecordComponents(value={@RecordComponents.Value(name="x", type=float.class), @RecordComponents.Value(name="y", type=float.class), @RecordComponents.Value(name="z", type=float.class), @RecordComponents.Value(name="w", type=float.class)})
public final class Quaternion
extends J_L_Record {
    private final float x;
    private final float y;
    private final float z;
    private final float w;

    public Quaternion(float x2, float y2, float z2, float w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
    }

    @Override
    public final String toString() {
        return Quaternion.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Quaternion.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Quaternion.jvmdowngrader$equals$equals(this, o2);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float z() {
        return this.z;
    }

    public float w() {
        return this.w;
    }

    private static String jvmdowngrader$toString$toString(Quaternion quaternion) {
        Quaternion quaternion2 = quaternion;
        return "Quaternion[" + "x=" + quaternion.x + ", " + "y=" + quaternion.y + ", " + "z=" + quaternion.z + ", " + "w=" + quaternion.w + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Quaternion quaternion) {
        Object[] objectArray = new Object[]{Float.valueOf(quaternion.x), Float.valueOf(quaternion.y), Float.valueOf(quaternion.z), Float.valueOf(quaternion.w)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Quaternion quaternion, Object object) {
        if (quaternion == object) {
            return true;
        }
        if (object != null && object instanceof Quaternion) {
            Quaternion quaternion2 = (Quaternion)object;
            if (quaternion.x == quaternion2.x && quaternion.y == quaternion2.y && quaternion.z == quaternion2.z && quaternion.w == quaternion2.w) {
                return true;
            }
        }
        return false;
    }
}

