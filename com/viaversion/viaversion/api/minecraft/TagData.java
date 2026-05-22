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

@RecordComponents(value={@RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="entries", type=int[].class)})
public final class TagData
extends J_L_Record {
    private final String identifier;
    private final int[] entries;

    public TagData(String identifier, int[] entries) {
        this.identifier = identifier;
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        TagData tagData = (TagData)o2;
        if (!this.identifier.equals(tagData.identifier)) {
            return false;
        }
        return Arrays.equals(this.entries, tagData.entries);
    }

    @Override
    public int hashCode() {
        int result = this.identifier.hashCode();
        result = 31 * result + Arrays.hashCode(this.entries);
        return result;
    }

    @Override
    public final String toString() {
        return TagData.jvmdowngrader$toString$toString(this);
    }

    public String identifier() {
        return this.identifier;
    }

    public int[] entries() {
        return this.entries;
    }

    private static String jvmdowngrader$toString$toString(TagData tagData) {
        TagData tagData2 = tagData;
        return "TagData[" + "identifier=" + tagData.identifier + ", " + "entries=" + tagData.entries + "]";
    }
}

