/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="position", type=GlobalBlockPosition.class)})
public final class LastDeathPosition
extends J_L_Record
implements StorableObject {
    private final GlobalBlockPosition position;

    public LastDeathPosition(GlobalBlockPosition position) {
        this.position = position;
    }

    @Override
    public final String toString() {
        return LastDeathPosition.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return LastDeathPosition.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return LastDeathPosition.jvmdowngrader$equals$equals(this, o2);
    }

    public GlobalBlockPosition position() {
        return this.position;
    }

    private static String jvmdowngrader$toString$toString(LastDeathPosition lastDeathPosition) {
        LastDeathPosition lastDeathPosition2 = lastDeathPosition;
        return "LastDeathPosition[" + "position=" + lastDeathPosition.position + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(LastDeathPosition lastDeathPosition) {
        Object[] objectArray = new Object[]{lastDeathPosition.position};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(LastDeathPosition lastDeathPosition, Object object) {
        if (lastDeathPosition == object) {
            return true;
        }
        if (object != null && object instanceof LastDeathPosition) {
            LastDeathPosition lastDeathPosition2 = (LastDeathPosition)object;
            if (Objects.equals(lastDeathPosition.position, lastDeathPosition2.position)) {
                return true;
            }
        }
        return false;
    }
}

