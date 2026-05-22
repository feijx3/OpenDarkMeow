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

@RecordComponents(value={@RecordComponents.Value(name="x", type=float.class), @RecordComponents.Value(name="y", type=float.class), @RecordComponents.Value(name="z", type=float.class)})
public final class EulerAngle
extends J_L_Record {
    private final float x;
    private final float y;
    private final float z;

    public EulerAngle(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    @Override
    public final String toString() {
        return EulerAngle.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return EulerAngle.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return EulerAngle.jvmdowngrader$equals$equals(this, o2);
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

    private static String jvmdowngrader$toString$toString(EulerAngle eulerAngle) {
        EulerAngle eulerAngle2 = eulerAngle;
        return "EulerAngle[" + "x=" + eulerAngle.x + ", " + "y=" + eulerAngle.y + ", " + "z=" + eulerAngle.z + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(EulerAngle eulerAngle) {
        Object[] objectArray = new Object[]{Float.valueOf(eulerAngle.x), Float.valueOf(eulerAngle.y), Float.valueOf(eulerAngle.z)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(EulerAngle eulerAngle, Object object) {
        if (eulerAngle == object) {
            return true;
        }
        if (object != null && object instanceof EulerAngle) {
            EulerAngle eulerAngle2 = (EulerAngle)object;
            if (eulerAngle.x == eulerAngle2.x && eulerAngle.y == eulerAngle2.y && eulerAngle.z == eulerAngle2.z) {
                return true;
            }
        }
        return false;
    }
}

