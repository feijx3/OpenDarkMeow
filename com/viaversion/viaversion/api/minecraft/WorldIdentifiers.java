/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="overworld", type=String.class), @RecordComponents.Value(name="nether", type=String.class), @RecordComponents.Value(name="end", type=String.class)})
public final class WorldIdentifiers
extends J_L_Record
implements StorableObject {
    private final String overworld;
    private final String nether;
    private final String end;
    public static final String OVERWORLD_DEFAULT = "minecraft:overworld";
    public static final String NETHER_DEFAULT = "minecraft:the_nether";
    public static final String END_DEFAULT = "minecraft:the_end";

    public WorldIdentifiers(String overworld) {
        this(overworld, NETHER_DEFAULT, END_DEFAULT);
    }

    public WorldIdentifiers(String overworld, String nether, String end) {
        this.overworld = overworld;
        this.nether = nether;
        this.end = end;
    }

    @Override
    public final String toString() {
        return WorldIdentifiers.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return WorldIdentifiers.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return WorldIdentifiers.jvmdowngrader$equals$equals(this, o2);
    }

    public String overworld() {
        return this.overworld;
    }

    public String nether() {
        return this.nether;
    }

    public String end() {
        return this.end;
    }

    private static String jvmdowngrader$toString$toString(WorldIdentifiers worldIdentifiers) {
        WorldIdentifiers worldIdentifiers2 = worldIdentifiers;
        return "WorldIdentifiers[" + "overworld=" + worldIdentifiers.overworld + ", " + "nether=" + worldIdentifiers.nether + ", " + "end=" + worldIdentifiers.end + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(WorldIdentifiers worldIdentifiers) {
        Object[] objectArray = new Object[]{worldIdentifiers.overworld, worldIdentifiers.nether, worldIdentifiers.end};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(WorldIdentifiers worldIdentifiers, Object object) {
        if (worldIdentifiers == object) {
            return true;
        }
        if (object != null && object instanceof WorldIdentifiers) {
            WorldIdentifiers worldIdentifiers2 = (WorldIdentifiers)object;
            if (Objects.equals(worldIdentifiers.overworld, worldIdentifiers2.overworld) && Objects.equals(worldIdentifiers.nether, worldIdentifiers2.nether) && Objects.equals(worldIdentifiers.end, worldIdentifiers2.end)) {
                return true;
            }
        }
        return false;
    }
}

