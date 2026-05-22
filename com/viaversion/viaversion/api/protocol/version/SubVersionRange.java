/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.protocol.version;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="baseVersion", type=String.class), @RecordComponents.Value(name="rangeFrom", type=int.class), @RecordComponents.Value(name="rangeTo", type=int.class)})
public final class SubVersionRange
extends J_L_Record {
    private final String baseVersion;
    private final int rangeFrom;
    private final int rangeTo;

    public SubVersionRange(String baseVersion, int rangeFrom, int rangeTo) {
        Preconditions.checkNotNull((Object)baseVersion);
        Preconditions.checkArgument((rangeFrom >= 0 ? 1 : 0) != 0);
        Preconditions.checkArgument((rangeTo > rangeFrom ? 1 : 0) != 0);
        this.baseVersion = baseVersion;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public String baseVersion() {
        return this.baseVersion;
    }

    public int rangeFrom() {
        return this.rangeFrom;
    }

    public int rangeTo() {
        return this.rangeTo;
    }

    @Override
    public final String toString() {
        return SubVersionRange.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return SubVersionRange.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return SubVersionRange.jvmdowngrader$equals$equals(this, o2);
    }

    private static String jvmdowngrader$toString$toString(SubVersionRange subVersionRange) {
        SubVersionRange subVersionRange2 = subVersionRange;
        return "SubVersionRange[" + "baseVersion=" + subVersionRange.baseVersion + ", " + "rangeFrom=" + subVersionRange.rangeFrom + ", " + "rangeTo=" + subVersionRange.rangeTo + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(SubVersionRange subVersionRange) {
        Object[] objectArray = new Object[]{subVersionRange.baseVersion, subVersionRange.rangeFrom, subVersionRange.rangeTo};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(SubVersionRange subVersionRange, Object object) {
        if (subVersionRange == object) {
            return true;
        }
        if (object != null && object instanceof SubVersionRange) {
            SubVersionRange subVersionRange2 = (SubVersionRange)object;
            if (Objects.equals(subVersionRange.baseVersion, subVersionRange2.baseVersion) && subVersionRange.rangeFrom == subVersionRange2.rangeFrom && subVersionRange.rangeTo == subVersionRange2.rangeTo) {
                return true;
            }
        }
        return false;
    }
}

