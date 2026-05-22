/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="type", type=int.class), @RecordComponents.Value(name="data", type=long[].class)})
public final class Heightmap
extends J_L_Record {
    private final int type;
    private final long[] data;

    public Heightmap(int type, long[] data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public final String toString() {
        return Heightmap.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Heightmap.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Heightmap.jvmdowngrader$equals$equals(this, o2);
    }

    public int type() {
        return this.type;
    }

    public long[] data() {
        return this.data;
    }

    private static String jvmdowngrader$toString$toString(Heightmap heightmap) {
        Heightmap heightmap2 = heightmap;
        return "Heightmap[" + "type=" + heightmap.type + ", " + "data=" + heightmap.data + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Heightmap heightmap) {
        Object[] objectArray = new Object[]{heightmap.type, heightmap.data};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Heightmap heightmap, Object object) {
        if (heightmap == object) {
            return true;
        }
        if (object != null && object instanceof Heightmap) {
            Heightmap heightmap2 = (Heightmap)object;
            if (heightmap.type == heightmap2.type && Objects.equals(heightmap.data, heightmap2.data)) {
                return true;
            }
        }
        return false;
    }
}

