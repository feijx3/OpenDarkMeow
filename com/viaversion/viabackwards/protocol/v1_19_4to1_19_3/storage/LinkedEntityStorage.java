/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage;

import com.viaversion.viabackwards.api.entities.storage.EntityPositionStorage;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;

public class LinkedEntityStorage
extends EntityPositionStorage
implements StorableObject {
    private int[] entities;

    public int[] entities() {
        return this.entities;
    }

    public void setEntities(int ... entities) {
        this.entities = entities;
    }

    public void remove(UserConnection connection) {
        PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_19_3.REMOVE_ENTITIES, connection);
        wrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, this.entities);
        wrapper.send(Protocol1_19_4To1_19_3.class);
    }
}

