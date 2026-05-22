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
public final class Vector3f
extends J_L_Record {
    private final float x;
    private final float y;
    private final float z;

    public Vector3f(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    @Override
    public final String toString() {
        return Vector3f.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Vector3f.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Vector3f.jvmdowngrader$equals$equals(this, o2);
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

    private static String jvmdowngrader$toString$toString(Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        return "Vector3f[" + "x=" + vector3f.x + ", " + "y=" + vector3f.y + ", " + "z=" + vector3f.z + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Vector3f vector3f) {
        Object[] objectArray = new Object[]{Float.valueOf(vector3f.x), Float.valueOf(vector3f.y), Float.valueOf(vector3f.z)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Vector3f vector3f, Object object) {
        if (vector3f == object) {
            return true;
        }
        if (object != null && object instanceof Vector3f) {
            Vector3f vector3f2 = (Vector3f)object;
            if (vector3f.x == vector3f2.x && vector3f.y == vector3f2.y && vector3f.z == vector3f2.z) {
                return true;
            }
        }
        return false;
    }
}

