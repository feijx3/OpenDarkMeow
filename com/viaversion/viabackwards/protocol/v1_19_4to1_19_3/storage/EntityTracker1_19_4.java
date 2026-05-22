/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage;

import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage.LinkedEntityStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class EntityTracker1_19_4
extends EntityTrackerBase {
    private final IntSet generatedEntities = new IntOpenHashSet();

    public EntityTracker1_19_4(UserConnection connection) {
        super(connection, EntityTypes1_19_4.PLAYER);
    }

    public int spawnEntity(EntityTypes1_19_3 entityType, double x2, double y2, double z2, int data) {
        int entityId = this.nextEntityId();
        PacketWrapper addEntity = PacketWrapper.create(ClientboundPackets1_19_3.ADD_ENTITY, this.user());
        addEntity.write(Types.VAR_INT, entityId);
        addEntity.write(Types.UUID, UUID.randomUUID());
        addEntity.write(Types.VAR_INT, entityType.getId());
        addEntity.write(Types.DOUBLE, x2);
        addEntity.write(Types.DOUBLE, y2);
        addEntity.write(Types.DOUBLE, z2);
        addEntity.write(Types.BYTE, (byte)0);
        addEntity.write(Types.BYTE, (byte)0);
        addEntity.write(Types.BYTE, (byte)0);
        addEntity.write(Types.VAR_INT, data);
        addEntity.write(Types.SHORT, (short)0);
        addEntity.write(Types.SHORT, (short)0);
        addEntity.write(Types.SHORT, (short)0);
        addEntity.send(Protocol1_19_4To1_19_3.class);
        this.generatedEntities.add(entityId);
        return entityId;
    }

    @Override
    public void clearEntities() {
        IntIterator intIterator = this.entities.keySet().iterator();
        while (intIterator.hasNext()) {
            int id = (Integer)intIterator.next();
            this.clearLinkedEntities(id);
        }
        super.clearEntities();
    }

    @Override
    public void removeEntity(int id) {
        this.clearLinkedEntities(id);
        super.removeEntity(id);
    }

    public void clearLinkedEntities(int id) {
        LinkedEntityStorage storage = this.linkedEntityStorage(id);
        if (storage != null && storage.entities() != null) {
            storage.remove(this.user());
            this.generatedEntities.remove(id);
        }
    }

    public LinkedEntityStorage linkedEntityStorage(int id) {
        TrackedEntity entity = this.entity(id);
        if (entity != null && entity.hasData()) {
            return entity.data().get(LinkedEntityStorage.class);
        }
        return null;
    }

    private int nextEntityId() {
        int entityId = -ThreadLocalRandom.current().nextInt(10000);
        if (this.generatedEntities.contains(entityId)) {
            return this.nextEntityId();
        }
        return entityId;
    }
}

