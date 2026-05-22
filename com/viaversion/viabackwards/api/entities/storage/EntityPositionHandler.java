/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.EntityPositionStorage;
import com.viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.StoredEntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.ProtocolLogger;
import java.util.function.Supplier;

public class EntityPositionHandler {
    public static final double RELATIVE_MOVE_FACTOR = 4096.0;
    private final EntityRewriterBase<?, ?> entityRewriter;
    private final Class<? extends EntityPositionStorage> storageClass;
    private final Supplier<? extends EntityPositionStorage> storageSupplier;
    private boolean warnedForMissingEntity;

    public EntityPositionHandler(EntityRewriterBase<?, ?> entityRewriter, Class<? extends EntityPositionStorage> storageClass, Supplier<? extends EntityPositionStorage> storageSupplier) {
        this.entityRewriter = entityRewriter;
        this.storageClass = storageClass;
        this.storageSupplier = storageSupplier;
    }

    public void cacheEntityPosition(PacketWrapper wrapper, boolean create2, boolean relative) {
        this.cacheEntityPosition(wrapper, wrapper.get(Types.DOUBLE, 0), wrapper.get(Types.DOUBLE, 1), wrapper.get(Types.DOUBLE, 2), create2, relative);
    }

    public void cacheEntityPosition(PacketWrapper wrapper, double x2, double y2, double z2, boolean create2, boolean relative) {
        EntityPositionStorage positionStorage;
        int entityId = wrapper.get(Types.VAR_INT, 0);
        StoredEntityData storedEntity = this.entityRewriter.tracker(wrapper.user()).entityData(entityId);
        if (storedEntity == null) {
            if (Via.getManager().isDebug()) {
                ProtocolLogger logger = ((BackwardsProtocol)this.entityRewriter.protocol()).getLogger();
                logger.warning(EntityPositionHandler.jvmdowngrader$concat$cacheEntityPosition$1(entityId, x2, y2, z2, this.storageClass.getSimpleName()));
                if (entityId == -1 && x2 == 0.0 && y2 == 0.0 && z2 == 0.0) {
                    logger.warning("DO NOT REPORT THIS TO VIA, THIS IS A PLUGIN ISSUE");
                } else if (!this.warnedForMissingEntity) {
                    this.warnedForMissingEntity = true;
                    logger.warning("This is very likely caused by a plugin sending a teleport packet for an entity outside of the player's range.");
                }
            }
            return;
        }
        if (create2) {
            positionStorage = this.storageSupplier.get();
            storedEntity.put(positionStorage);
        } else {
            positionStorage = storedEntity.get(this.storageClass);
            if (positionStorage == null) {
                ((BackwardsProtocol)this.entityRewriter.protocol()).getLogger().warning(EntityPositionHandler.jvmdowngrader$concat$cacheEntityPosition$1(entityId, this.storageClass.getSimpleName()));
                return;
            }
        }
        if (relative) {
            positionStorage.addRelativePosition(x2, y2, z2);
        } else {
            positionStorage.setPosition(x2, y2, z2);
        }
    }

    public EntityPositionStorage getStorage(UserConnection user, int entityId) {
        EntityPositionStorage entityStorage;
        StoredEntityData storedEntity = this.entityRewriter.tracker(user).entityData(entityId);
        if (storedEntity == null || (entityStorage = storedEntity.get(EntityPositionStorage.class)) == null) {
            ((BackwardsProtocol)this.entityRewriter.protocol()).getLogger().warning(EntityPositionHandler.jvmdowngrader$concat$getStorage$1(entityId, this.storageClass.getSimpleName()));
            return null;
        }
        return entityStorage;
    }

    public static void writeFacingAngles(PacketWrapper wrapper, double x2, double y2, double z2, double targetX, double targetY, double targetZ) {
        double dX = targetX - x2;
        double dY = targetY - y2;
        double dZ = targetZ - z2;
        double r2 = Math.sqrt(dX * dX + dY * dY + dZ * dZ);
        double yaw = -Math.atan2(dX, dZ) / Math.PI * 180.0;
        if (yaw < 0.0) {
            yaw = 360.0 + yaw;
        }
        double pitch = -Math.asin(dY / r2) / Math.PI * 180.0;
        wrapper.write(Types.BYTE, (byte)(yaw * 256.0 / 360.0));
        wrapper.write(Types.BYTE, (byte)(pitch * 256.0 / 360.0));
    }

    public static void writeFacingDegrees(PacketWrapper wrapper, double x2, double y2, double z2, double targetX, double targetY, double targetZ) {
        double dX = targetX - x2;
        double dY = targetY - y2;
        double dZ = targetZ - z2;
        double r2 = Math.sqrt(dX * dX + dY * dY + dZ * dZ);
        double yaw = -Math.atan2(dX, dZ) / Math.PI * 180.0;
        if (yaw < 0.0) {
            yaw = 360.0 + yaw;
        }
        double pitch = -Math.asin(dY / r2) / Math.PI * 180.0;
        wrapper.write(Types.FLOAT, Float.valueOf((float)yaw));
        wrapper.write(Types.FLOAT, Float.valueOf((float)pitch));
    }

    private static String jvmdowngrader$concat$cacheEntityPosition$1(int n2, double d2, double d3, double d4, String string) {
        return "Stored entity with id " + n2 + " missing at position: " + d2 + " - " + d3 + " - " + d4 + " in " + string;
    }

    private static String jvmdowngrader$concat$cacheEntityPosition$1(int n2, String string) {
        return "Stored entity with id " + n2 + " missing " + string;
    }

    private static String jvmdowngrader$concat$getStorage$1(int n2, String string) {
        return "Untracked entity with id " + n2 + " in " + string;
    }
}

