/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.data;

import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.legacy.bossbar.BossBar;
import com.viaversion.viaversion.api.legacy.bossbar.BossColor;
import com.viaversion.viaversion.api.legacy.bossbar.BossFlag;
import com.viaversion.viaversion.api.legacy.bossbar.BossStyle;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class WitherBossBar
implements BossBar {
    private static int highestId = 2147473647;
    private final UUID uuid;
    private String title;
    private float health;
    private boolean visible = false;
    private final UserConnection connection;
    private final int entityId = highestId++;
    private double locX;
    private double locY;
    private double locZ;

    public WitherBossBar(UserConnection connection, UUID uuid, String title, float health) {
        this.connection = connection;
        this.uuid = uuid;
        this.title = title;
        this.health = health;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public BossBar setTitle(String title) {
        this.title = title;
        if (this.visible) {
            this.updateEntityData();
        }
        return this;
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    @Override
    public BossBar setHealth(float health) {
        this.health = health;
        if (this.health <= 0.0f) {
            this.health = 1.0E-4f;
        }
        if (this.visible) {
            this.updateEntityData();
        }
        return this;
    }

    @Override
    public BossColor getColor() {
        return null;
    }

    @Override
    public BossBar setColor(BossColor bossColor) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$setColor$1(this.getClass().getName()));
    }

    @Override
    public BossStyle getStyle() {
        return null;
    }

    @Override
    public BossBar setStyle(BossStyle bossStyle) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$setStyle$1(this.getClass().getName()));
    }

    @Override
    public BossBar addPlayer(UUID uuid) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addPlayer$1(this.getClass().getName()));
    }

    @Override
    public BossBar addConnection(UserConnection userConnection) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addPlayer$1(this.getClass().getName()));
    }

    @Override
    public BossBar removePlayer(UUID uuid) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addPlayer$1(this.getClass().getName()));
    }

    @Override
    public BossBar removeConnection(UserConnection userConnection) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addPlayer$1(this.getClass().getName()));
    }

    @Override
    public BossBar addFlag(BossFlag bossFlag) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addFlag$1(this.getClass().getName()));
    }

    @Override
    public BossBar removeFlag(BossFlag bossFlag) {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addFlag$1(this.getClass().getName()));
    }

    @Override
    public boolean hasFlag(BossFlag bossFlag) {
        return false;
    }

    @Override
    public Set<UUID> getPlayers() {
        return Collections.singleton(this.connection.getProtocolInfo().getUuid());
    }

    @Override
    public Set<UserConnection> getConnections() {
        throw new UnsupportedOperationException(WitherBossBar.jvmdowngrader$concat$addPlayer$1(this.getClass().getName()));
    }

    @Override
    public BossBar show() {
        if (!this.visible) {
            this.addWither();
            this.visible = true;
        }
        return this;
    }

    @Override
    public BossBar hide() {
        if (this.visible) {
            this.removeWither();
            this.visible = false;
        }
        return this;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public UUID getId() {
        return this.uuid;
    }

    public void setLocation(double x2, double y2, double z2) {
        this.locX = x2;
        this.locY = y2;
        this.locZ = z2;
        this.updateLocation();
    }

    private void addWither() {
        PacketWrapper addMob = PacketWrapper.create(ClientboundPackets1_7_2_5.ADD_MOB, this.connection);
        addMob.write(Types.VAR_INT, this.entityId);
        addMob.write(Types.UNSIGNED_BYTE, (short)64);
        addMob.write(Types.INT, (int)(this.locX * 32.0));
        addMob.write(Types.INT, (int)(this.locY * 32.0));
        addMob.write(Types.INT, (int)(this.locZ * 32.0));
        addMob.write(Types.BYTE, (byte)0);
        addMob.write(Types.BYTE, (byte)0);
        addMob.write(Types.BYTE, (byte)0);
        addMob.write(Types.SHORT, (short)0);
        addMob.write(Types.SHORT, (short)0);
        addMob.write(Types.SHORT, (short)0);
        ArrayList<EntityData> entityData = new ArrayList<EntityData>();
        entityData.add(new EntityData(0, EntityDataTypes1_8.BYTE, (byte)32));
        entityData.add(new EntityData(2, EntityDataTypes1_8.STRING, this.title));
        entityData.add(new EntityData(3, EntityDataTypes1_8.BYTE, (byte)1));
        entityData.add(new EntityData(6, EntityDataTypes1_8.FLOAT, Float.valueOf(this.health * 300.0f)));
        addMob.write(Types.ENTITY_DATA_LIST1_8, entityData);
        addMob.scheduleSend(Protocol1_9To1_8.class);
    }

    private void updateLocation() {
        PacketWrapper teleportEntity = PacketWrapper.create(ClientboundPackets1_7_2_5.TELEPORT_ENTITY, this.connection);
        teleportEntity.write(Types.VAR_INT, this.entityId);
        teleportEntity.write(Types.INT, (int)(this.locX * 32.0));
        teleportEntity.write(Types.INT, (int)(this.locY * 32.0));
        teleportEntity.write(Types.INT, (int)(this.locZ * 32.0));
        teleportEntity.write(Types.BYTE, (byte)0);
        teleportEntity.write(Types.BYTE, (byte)0);
        teleportEntity.write(Types.BOOLEAN, false);
        teleportEntity.scheduleSend(Protocol1_9To1_8.class);
    }

    private void updateEntityData() {
        PacketWrapper setEntityData = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_DATA, this.connection);
        setEntityData.write(Types.VAR_INT, this.entityId);
        ArrayList<EntityData> entityData = new ArrayList<EntityData>();
        entityData.add(new EntityData(2, EntityDataTypes1_8.STRING, this.title));
        entityData.add(new EntityData(6, EntityDataTypes1_8.FLOAT, Float.valueOf(this.health * 300.0f)));
        setEntityData.write(Types.ENTITY_DATA_LIST1_8, entityData);
        setEntityData.scheduleSend(Protocol1_9To1_8.class);
    }

    private void removeWither() {
        PacketWrapper removeEntity = PacketWrapper.create(ClientboundPackets1_7_2_5.REMOVE_ENTITIES, this.connection);
        removeEntity.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{this.entityId});
        removeEntity.scheduleSend(Protocol1_9To1_8.class);
    }

    public void setPlayerLocation(double posX, double posY, double posZ, float yaw, float pitch) {
        double yawR = Math.toRadians(yaw);
        double pitchR = Math.toRadians(pitch);
        this.setLocation(posX -= Math.cos(pitchR) * Math.sin(yawR) * 48.0, posY -= Math.sin(pitchR) * 48.0, posZ += Math.cos(pitchR) * Math.cos(yawR) * 48.0);
    }

    private static /* synthetic */ String jvmdowngrader$concat$setColor$1(String string) {
        return string + " does not support color";
    }

    private static /* synthetic */ String jvmdowngrader$concat$setStyle$1(String string) {
        return string + " does not support styles";
    }

    private static /* synthetic */ String jvmdowngrader$concat$addPlayer$1(String string) {
        return string + " is only for one UserConnection!";
    }

    private static /* synthetic */ String jvmdowngrader$concat$addFlag$1(String string) {
        return string + " does not support flags";
    }
}

