/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="uuid", type=UUID.class)})
public final class ResourcepackIDStorage
extends J_L_Record
implements StorableObject {
    private final UUID uuid;

    public ResourcepackIDStorage(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public final String toString() {
        return ResourcepackIDStorage.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ResourcepackIDStorage.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ResourcepackIDStorage.jvmdowngrader$equals$equals(this, o2);
    }

    public UUID uuid() {
        return this.uuid;
    }

    private static String jvmdowngrader$toString$toString(ResourcepackIDStorage resourcepackIDStorage) {
        ResourcepackIDStorage resourcepackIDStorage2 = resourcepackIDStorage;
        return "ResourcepackIDStorage[" + "uuid=" + resourcepackIDStorage.uuid + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ResourcepackIDStorage resourcepackIDStorage) {
        Object[] objectArray = new Object[]{resourcepackIDStorage.uuid};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ResourcepackIDStorage resourcepackIDStorage, Object object) {
        if (resourcepackIDStorage == object) {
            return true;
        }
        if (object != null && object instanceof ResourcepackIDStorage) {
            ResourcepackIDStorage resourcepackIDStorage2 = (ResourcepackIDStorage)object;
            if (Objects.equals(resourcepackIDStorage.uuid, resourcepackIDStorage2.uuid)) {
                return true;
            }
        }
        return false;
    }
}

