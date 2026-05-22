/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_20to1_19_4.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="position", type=BlockPosition.class)})
public final class BackSignEditStorage
extends J_L_Record
implements StorableObject {
    private final BlockPosition position;

    public BackSignEditStorage(BlockPosition position) {
        this.position = position;
    }

    @Override
    public final String toString() {
        return BackSignEditStorage.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BackSignEditStorage.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BackSignEditStorage.jvmdowngrader$equals$equals(this, o2);
    }

    public BlockPosition position() {
        return this.position;
    }

    private static String jvmdowngrader$toString$toString(BackSignEditStorage backSignEditStorage) {
        BackSignEditStorage backSignEditStorage2 = backSignEditStorage;
        return "BackSignEditStorage[" + "position=" + backSignEditStorage.position + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BackSignEditStorage backSignEditStorage) {
        Object[] objectArray = new Object[]{backSignEditStorage.position};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BackSignEditStorage backSignEditStorage, Object object) {
        if (backSignEditStorage == object) {
            return true;
        }
        if (object != null && object instanceof BackSignEditStorage) {
            BackSignEditStorage backSignEditStorage2 = (BackSignEditStorage)object;
            if (Objects.equals(backSignEditStorage.position, backSignEditStorage2.position)) {
                return true;
            }
        }
        return false;
    }
}

