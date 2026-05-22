/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={BoatEntity.class})
public final class EntityTracker1_21_2
extends EntityTrackerBase {
    private final Int2ObjectMap<BoatEntity> boats = new Int2ObjectOpenHashMap<BoatEntity>();
    private double playerMaxHealthAttributeValue = 20.0;

    public EntityTracker1_21_2(UserConnection connection) {
        super(connection, EntityTypes1_21_2.PLAYER);
    }

    public BoatEntity trackBoatEntity(int entityId, UUID uuid, int data) {
        BoatEntity entity = new BoatEntity(uuid, data);
        this.boats.put(entityId, entity);
        return entity;
    }

    public BoatEntity trackedBoatEntity(int entityId) {
        return (BoatEntity)this.boats.get(entityId);
    }

    @Override
    public void removeEntity(int id) {
        super.removeEntity(id);
        this.boats.remove(id);
    }

    public void updateBoatType(int entityId, EntityType type) {
        BoatEntity entity = (BoatEntity)this.boats.get(entityId);
        this.removeEntity(entityId);
        this.boats.put(entityId, entity);
        this.addEntity(entityId, type);
    }

    public double playerMaxHealthAttributeValue() {
        return this.playerMaxHealthAttributeValue;
    }

    public void setPlayerMaxHealthAttributeValue(double playerMaxHealthAttributeValue) {
        this.playerMaxHealthAttributeValue = playerMaxHealthAttributeValue;
    }

    @NestHost(value=EntityTracker1_21_2.class)
    public static class BoatEntity {
        private final List<EntityData> entityData = new ArrayList<EntityData>();
        private final UUID uuid;
        private final int data;
        private double x;
        private double y;
        private double z;
        private float yaw;
        private float pitch;
        private int[] passengers;

        public BoatEntity(UUID uuid, int data) {
            this.uuid = uuid;
            this.data = data;
        }

        public void setPosition(double x2, double y2, double z2) {
            this.x = x2;
            this.y = y2;
            this.z = z2;
        }

        public void setRotation(float yaw, float pitch) {
            this.yaw = yaw;
            this.pitch = pitch;
        }

        public void setPassengers(int[] passengers) {
            this.passengers = passengers;
        }

        public UUID uuid() {
            return this.uuid;
        }

        public int data() {
            return this.data;
        }

        public double x() {
            return this.x;
        }

        public double y() {
            return this.y;
        }

        public double z() {
            return this.z;
        }

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }

        public List<EntityData> entityData() {
            return this.entityData;
        }

        public int[] passengers() {
            return this.passengers;
        }
    }
}

