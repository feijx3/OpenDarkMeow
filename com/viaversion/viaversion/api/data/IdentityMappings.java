/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.data.Mappings;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="size", type=int.class), @RecordComponents.Value(name="mappedSize", type=int.class)})
public final class IdentityMappings
extends J_L_Record
implements Mappings {
    private final int size;
    private final int mappedSize;

    public IdentityMappings(int size, int mappedSize) {
        this.size = size;
        this.mappedSize = mappedSize;
    }

    @Override
    public int getNewId(int id) {
        return id >= 0 && id < this.size ? id : -1;
    }

    @Override
    public void setNewId(int id, int mappedId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mappings inverse() {
        return new IdentityMappings(this.mappedSize, this.size);
    }

    @Override
    public final String toString() {
        return IdentityMappings.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return IdentityMappings.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return IdentityMappings.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int mappedSize() {
        return this.mappedSize;
    }

    private static String jvmdowngrader$toString$toString(IdentityMappings identityMappings) {
        IdentityMappings identityMappings2 = identityMappings;
        return "IdentityMappings[" + "size=" + identityMappings.size + ", " + "mappedSize=" + identityMappings.mappedSize + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(IdentityMappings identityMappings) {
        Object[] objectArray = new Object[]{identityMappings.size, identityMappings.mappedSize};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(IdentityMappings identityMappings, Object object) {
        if (identityMappings == object) {
            return true;
        }
        if (object != null && object instanceof IdentityMappings) {
            IdentityMappings identityMappings2 = (IdentityMappings)object;
            if (identityMappings.size == identityMappings2.size && identityMappings.mappedSize == identityMappings2.mappedSize) {
                return true;
            }
        }
        return false;
    }
}

