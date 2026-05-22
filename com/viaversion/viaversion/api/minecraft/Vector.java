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

@RecordComponents(value={@RecordComponents.Value(name="blockX", type=int.class), @RecordComponents.Value(name="blockY", type=int.class), @RecordComponents.Value(name="blockZ", type=int.class)})
public final class Vector
extends J_L_Record {
    private final int blockX;
    private final int blockY;
    private final int blockZ;

    public Vector(int blockX, int blockY, int blockZ) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.blockZ = blockZ;
    }

    @Override
    public final String toString() {
        return Vector.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Vector.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Vector.jvmdowngrader$equals$equals(this, o2);
    }

    public int blockX() {
        return this.blockX;
    }

    public int blockY() {
        return this.blockY;
    }

    public int blockZ() {
        return this.blockZ;
    }

    private static String jvmdowngrader$toString$toString(Vector vector) {
        Vector vector2 = vector;
        return "Vector[" + "blockX=" + vector.blockX + ", " + "blockY=" + vector.blockY + ", " + "blockZ=" + vector.blockZ + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Vector vector) {
        Object[] objectArray = new Object[]{vector.blockX, vector.blockY, vector.blockZ};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Vector vector, Object object) {
        if (vector == object) {
            return true;
        }
        if (object != null && object instanceof Vector) {
            Vector vector2 = (Vector)object;
            if (vector.blockX == vector2.blockX && vector.blockY == vector2.blockY && vector.blockZ == vector2.blockZ) {
                return true;
            }
        }
        return false;
    }
}

