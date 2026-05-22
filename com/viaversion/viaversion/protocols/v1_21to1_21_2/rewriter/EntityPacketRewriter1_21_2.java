/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ChunkLoadTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.EntityTracker1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.GroundFlagTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.PlayerPositionStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.TeleportAckCancelStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class EntityPacketRewriter1_21_2
extends EntityRewriter<ClientboundPacket1_21, Protocol1_21To1_21_2> {
    private static final String[] GOAT_HORN_INSTRUMENTS = new String[]{"ponder_goat_horn", "sing_goat_horn", "seek_goat_horn", "feel_goat_horn", "admire_goat_horn", "call_goat_horn", "yearn_goat_horn", "dream_goat_horn"};
    private static final float IMPULSE = 0.98f;
    private final boolean isVF = Via.getPlatform().getPlatformName().equals("ViaFabric");

    public EntityPacketRewriter1_21_2(Protocol1_21To1_21_2 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21.ADD_ENTITY, EntityTypes1_21_2.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21.REMOVE_ENTITIES);
        ((Protocol1_21To1_21_2)this.protocol).appendClientbound(ClientboundPackets1_21.ADD_ENTITY, wrapper -> {
            int entityType = wrapper.get(Types.VAR_INT, 1);
            EntityType type = this.typeFromId(entityType);
            if (type == null || !type.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
                return;
            }
            int entityId = wrapper.get(Types.VAR_INT, 0);
            UUID uuid = wrapper.get(Types.UUID, 0);
            double x2 = wrapper.get(Types.DOUBLE, 0);
            double y2 = wrapper.get(Types.DOUBLE, 1);
            double z2 = wrapper.get(Types.DOUBLE, 2);
            float pitch = (float)wrapper.get(Types.BYTE, 0).byteValue() * 256.0f / 360.0f;
            float yaw = (float)wrapper.get(Types.BYTE, 1).byteValue() * 256.0f / 360.0f;
            int data = wrapper.get(Types.VAR_INT, 2);
            EntityTracker1_21_2 tracker = (EntityTracker1_21_2)this.tracker(wrapper.user());
            EntityTracker1_21_2.BoatEntity entity = tracker.trackBoatEntity(entityId, uuid, data);
            entity.setPosition(x2, y2, z2);
            entity.setRotation(yaw, pitch);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerFinishConfiguration(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, wrapper -> {
            PacketWrapper instrumentsPacket = wrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA);
            instrumentsPacket.write(Types.STRING, "minecraft:instrument");
            RegistryEntry[] entries = new RegistryEntry[GOAT_HORN_INSTRUMENTS.length];
            for (int i2 = 0; i2 < GOAT_HORN_INSTRUMENTS.length; ++i2) {
                CompoundTag tag = new CompoundTag();
                tag.putString("sound_event", EntityPacketRewriter1_21_2.jvmdowngrader$concat$lambda$registerPackets$1$1(i2));
                tag.putFloat("use_duration", 7.0f);
                tag.putInt("range", 256);
                tag.putString("description", "");
                entries[i2] = new RegistryEntry(GOAT_HORN_INSTRUMENTS[i2], tag);
            }
            instrumentsPacket.write(Types.REGISTRY_ENTRY_ARRAY, entries);
            instrumentsPacket.send(Protocol1_21To1_21_2.class);
        });
        RegistryDataRewriter registryDataRewriter = this.registryDataRewriter();
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING_ARRAY);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.map(Types.VAR_INT);
                this.handler(EntityPacketRewriter1_21_2.this.worldDataTrackerHandlerByKey1_20_5(3));
                this.handler(EntityPacketRewriter1_21_2.this.playerTrackerHandler());
                this.create(Types.VAR_INT, 64);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.RESPAWN, wrapper -> {
            ChunkLoadTracker chunkLoadTracker;
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.write(Types.VAR_INT, 64);
            byte keepDataMask = wrapper.passthrough(Types.BYTE);
            EntityTracker1_21_2 entityTracker = (EntityTracker1_21_2)this.tracker(wrapper.user());
            if (entityTracker.currentWorld() != null && !entityTracker.currentWorld().equals(world) && (chunkLoadTracker = wrapper.user().get(ChunkLoadTracker.class)) != null) {
                chunkLoadTracker.clear();
            }
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
            wrapper.user().put(new GroundFlagTracker());
            wrapper.user().remove(ClientVehicleStorage.class);
            if ((keepDataMask & 1) == 0) {
                entityTracker.setPlayerMaxHealthAttributeValue(20.0);
            }
            if ((keepDataMask & 2) != 0) {
                boolean isBundling = wrapper.user().get(BundleStateTracker.class).isBundling();
                if (!isBundling) {
                    PacketWrapper bundleStart = wrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    bundleStart.send(Protocol1_21To1_21_2.class);
                }
                wrapper.send(Protocol1_21To1_21_2.class);
                wrapper.cancel();
                PacketWrapper entityDataPacket = wrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA);
                entityDataPacket.write(Types.VAR_INT, entityTracker.clientEntityId());
                ArrayList<EntityData> entityData = new ArrayList<EntityData>();
                entityData.add(new EntityData(6, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).poseType, 0));
                entityData.add(new EntityData(9, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).floatType, Float.valueOf((float)entityTracker.playerMaxHealthAttributeValue())));
                entityDataPacket.write(VersionedTypes.V1_21_2.entityDataList, entityData);
                entityDataPacket.send(Protocol1_21To1_21_2.class);
                int teleportId = ThreadLocalRandom.current().nextInt();
                wrapper.user().get(TeleportAckCancelStorage.class).cancelTeleportId(teleportId);
                PlayerPositionStorage positionStorage = wrapper.user().get(PlayerPositionStorage.class);
                if (positionStorage != null) {
                    positionStorage.sendPing(wrapper.user(), ThreadLocalRandom.current().nextInt());
                }
                PacketWrapper positionPacket = wrapper.create(ClientboundPackets1_21_2.PLAYER_POSITION);
                positionPacket.write(Types.VAR_INT, teleportId);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.DOUBLE, 0.0);
                positionPacket.write(Types.FLOAT, Float.valueOf(-180.0f));
                positionPacket.write(Types.FLOAT, Float.valueOf(0.0f));
                positionPacket.write(Types.INT, 7);
                positionPacket.send(Protocol1_21To1_21_2.class);
                if (!isBundling) {
                    PacketWrapper bundleEnd = wrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    bundleEnd.send(Protocol1_21To1_21_2.class);
                }
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.PLAYER_POSITION, wrapper -> {
            wrapper.write(Types.VAR_INT, 0);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.write(Types.DOUBLE, 0.0);
            wrapper.write(Types.DOUBLE, 0.0);
            wrapper.write(Types.DOUBLE, 0.0);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            int relativeArguments = wrapper.read(Types.BYTE) & 0x1F;
            if ((relativeArguments & 1) != 0) {
                relativeArguments |= 0x20;
            }
            if ((relativeArguments & 2) != 0) {
                relativeArguments |= 0x40;
            }
            if ((relativeArguments & 4) != 0) {
                relativeArguments |= 0x80;
            }
            wrapper.write(Types.INT, relativeArguments);
            int teleportId = wrapper.read(Types.VAR_INT);
            wrapper.set(Types.VAR_INT, 0, teleportId);
            PlayerPositionStorage positionStorage = wrapper.user().get(PlayerPositionStorage.class);
            if (positionStorage == null) {
                return;
            }
            boolean isBundling = wrapper.user().get(BundleStateTracker.class).isBundling();
            if (!isBundling) {
                PacketWrapper bundleStart = wrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                bundleStart.send(Protocol1_21To1_21_2.class);
            }
            positionStorage.sendPing(wrapper.user(), ThreadLocalRandom.current().nextInt());
            wrapper.send(Protocol1_21To1_21_2.class);
            wrapper.cancel();
            if (!isBundling) {
                PacketWrapper bundleEnd = wrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                bundleEnd.send(Protocol1_21To1_21_2.class);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.SET_PASSENGERS, wrapper -> {
            EntityTracker1_21_2 tracker;
            EntityTracker1_21_2.BoatEntity entity;
            int vehicleId = wrapper.passthrough(Types.VAR_INT);
            int[] passengerIds = wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            ClientVehicleStorage storage = wrapper.user().get(ClientVehicleStorage.class);
            if (storage != null && vehicleId == storage.vehicleId()) {
                wrapper.user().remove(ClientVehicleStorage.class);
            }
            if ((entity = (tracker = (EntityTracker1_21_2)this.tracker(wrapper.user())).trackedBoatEntity(vehicleId)) != null) {
                entity.setPassengers(passengerIds);
            }
            int clientEntityId = this.tracker(wrapper.user()).clientEntityId();
            for (int passenger : passengerIds) {
                if (passenger != clientEntityId) continue;
                wrapper.user().put(new ClientVehicleStorage(vehicleId));
                break;
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).appendClientbound(ClientboundPackets1_21.REMOVE_ENTITIES, wrapper -> {
            int[] entityIds;
            ClientVehicleStorage vehicleStorage = wrapper.user().get(ClientVehicleStorage.class);
            if (vehicleStorage == null) {
                return;
            }
            for (int entityId : entityIds = wrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0)) {
                if (entityId != vehicleStorage.vehicleId()) continue;
                wrapper.user().remove(ClientVehicleStorage.class);
                break;
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.PLAYER_INPUT, wrapper -> {
            boolean backward;
            boolean right;
            wrapper.cancel();
            ClientVehicleStorage vehicleStorage = wrapper.user().get(ClientVehicleStorage.class);
            if (vehicleStorage == null) {
                return;
            }
            byte flags = wrapper.read(Types.BYTE);
            boolean left = (flags & 4) != 0;
            boolean bl2 = right = (flags & 8) != 0;
            float sidewaysMovement = left ? 0.98f : (right ? -0.98f : 0.0f);
            boolean forward = (flags & 1) != 0;
            boolean bl3 = backward = (flags & 2) != 0;
            float forwardMovement = forward ? 0.98f : (backward ? -0.98f : 0.0f);
            byte updatedFlags = 0;
            if ((flags & 0x10) != 0) {
                updatedFlags = (byte)(updatedFlags | 1);
            }
            if ((flags & 0x20) != 0) {
                updatedFlags = (byte)(updatedFlags | 2);
            }
            if (wrapper.user().isServerSide() && this.isVF) {
                wrapper.write(Types.FLOAT, Float.valueOf(sidewaysMovement));
                wrapper.write(Types.FLOAT, Float.valueOf(forwardMovement));
                wrapper.write(Types.BYTE, flags);
            } else {
                vehicleStorage.storeMovement(sidewaysMovement, forwardMovement, updatedFlags);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.TELEPORT_ENTITY, ClientboundPackets1_21_2.ENTITY_POSITION_SYNC, wrapper -> {
            int entityId = wrapper.passthrough(Types.VAR_INT);
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            wrapper.write(Types.DOUBLE, 0.0);
            wrapper.write(Types.DOUBLE, 0.0);
            wrapper.write(Types.DOUBLE, 0.0);
            float yaw = (float)wrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f;
            float pitch = (float)wrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f;
            wrapper.write(Types.FLOAT, Float.valueOf(yaw));
            wrapper.write(Types.FLOAT, Float.valueOf(pitch));
            EntityTracker1_21_2 tracker = (EntityTracker1_21_2)this.tracker(wrapper.user());
            EntityTracker1_21_2.BoatEntity trackedEntity = tracker.trackedBoatEntity(entityId);
            if (trackedEntity == null) {
                return;
            }
            trackedEntity.setPosition(x2, y2, z2);
            trackedEntity.setRotation(yaw, pitch);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_POS, wrapper -> this.storeEntityPositionRotation(wrapper, true, false));
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_POS_ROT, wrapper -> this.storeEntityPositionRotation(wrapper, true, true));
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_ROT, wrapper -> this.storeEntityPositionRotation(wrapper, false, true));
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_POS, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            this.handleOnGround(wrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_POS_ROT, wrapper -> {
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
            float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
            this.handleOnGround(wrapper);
            PlayerPositionStorage playerPositionStorage = wrapper.user().get(PlayerPositionStorage.class);
            if (playerPositionStorage != null && playerPositionStorage.checkCaptureNextPlayerPositionPacket()) {
                boolean onGround = wrapper.get(Types.BOOLEAN, 0);
                playerPositionStorage.setPlayerPosition(new PlayerPositionStorage.PlayerPosition(x2, y2, z2, yaw, pitch, onGround));
                wrapper.cancel();
            } else if (wrapper.user().get(TeleportAckCancelStorage.class).checkShouldCancelPlayerPositionPacket()) {
                wrapper.cancel();
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_ROT, wrapper -> {
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            this.handleOnGround(wrapper);
            ClientVehicleStorage vehicleStorage = wrapper.user().get(ClientVehicleStorage.class);
            if (vehicleStorage == null || wrapper.user().isServerSide() && this.isVF) {
                return;
            }
            wrapper.sendToServer(Protocol1_21To1_21_2.class);
            wrapper.cancel();
            PacketWrapper playerInput = wrapper.create(ServerboundPackets1_20_5.PLAYER_INPUT);
            playerInput.write(Types.FLOAT, Float.valueOf(vehicleStorage.sidewaysMovement()));
            playerInput.write(Types.FLOAT, Float.valueOf(vehicleStorage.forwardMovement()));
            playerInput.write(Types.BYTE, vehicleStorage.flags());
            playerInput.sendToServer(Protocol1_21To1_21_2.class);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_STATUS_ONLY, wrapper -> {
            GroundFlagTracker tracker = wrapper.user().get(GroundFlagTracker.class);
            boolean prevOnGround = tracker.onGround();
            boolean prevHorizontalCollision = tracker.horizontalCollision();
            this.handleOnGround(wrapper);
            if (prevOnGround == tracker.onGround() && prevHorizontalCollision != tracker.horizontalCollision()) {
                wrapper.cancel();
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.ACCEPT_TELEPORTATION, wrapper -> {
            TeleportAckCancelStorage teleportAckCancelStorage = wrapper.user().get(TeleportAckCancelStorage.class);
            PlayerPositionStorage playerPositionStorage = wrapper.user().get(PlayerPositionStorage.class);
            int teleportId = wrapper.passthrough(Types.VAR_INT);
            if (teleportAckCancelStorage.checkShouldCancelTeleportAck(teleportId)) {
                wrapper.cancel();
                if (playerPositionStorage != null && playerPositionStorage.checkHasPlayerPosition()) {
                    playerPositionStorage.reset();
                    teleportAckCancelStorage.checkShouldCancelPlayerPositionPacket();
                }
                return;
            }
            if (playerPositionStorage != null && playerPositionStorage.checkHasPlayerPosition()) {
                wrapper.sendToServer(Protocol1_21To1_21_2.class);
                wrapper.cancel();
                playerPositionStorage.sendMovePlayerPosRot(wrapper.user());
            }
        });
    }

    private RegistryDataRewriter registryDataRewriter() {
        CompoundTag enderpearlData = new CompoundTag();
        enderpearlData.putString("scaling", "when_caused_by_living_non_player");
        enderpearlData.putString("message_id", "fall");
        enderpearlData.putFloat("exhaustion", 0.0f);
        CompoundTag maceSmashData = new CompoundTag();
        maceSmashData.putString("scaling", "when_caused_by_living_non_player");
        maceSmashData.putString("message_id", "mace_smash");
        maceSmashData.putFloat("exhaustion", 0.1f);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        registryDataRewriter.addEntries("damage_type", new RegistryEntry("minecraft:ender_pearl", enderpearlData), new RegistryEntry("minecraft:mace_smash", maceSmashData));
        registryDataRewriter.addEnchantmentEffectRewriter("damage_item", tag -> tag.putString("type", "change_item_damage"));
        return registryDataRewriter;
    }

    private void handleOnGround(PacketWrapper wrapper) {
        GroundFlagTracker tracker = wrapper.user().get(GroundFlagTracker.class);
        short data = wrapper.read(Types.UNSIGNED_BYTE);
        wrapper.write(Types.BOOLEAN, tracker.setOnGround((data & 1) != 0));
        tracker.setHorizontalCollision((data & 2) != 0);
    }

    private void storeEntityPositionRotation(PacketWrapper wrapper, boolean position, boolean rotation) {
        int entityId = wrapper.passthrough(Types.VAR_INT);
        EntityTracker1_21_2 tracker = (EntityTracker1_21_2)this.tracker(wrapper.user());
        EntityTracker1_21_2.BoatEntity trackedEntity = tracker.trackedBoatEntity(entityId);
        if (trackedEntity == null) {
            return;
        }
        if (position) {
            double x2 = (double)wrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double y2 = (double)wrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double z2 = (double)wrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            trackedEntity.setPosition(trackedEntity.x() + x2, trackedEntity.y() + y2, trackedEntity.z() + z2);
        }
        if (rotation) {
            float yaw = (float)wrapper.passthrough(Types.BYTE).byteValue() * 360.0f / 256.0f;
            float pitch = (float)wrapper.passthrough(Types.BYTE).byteValue() * 360.0f / 256.0f;
            trackedEntity.setRotation(yaw, pitch);
        }
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes)::byId);
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_2.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_BOAT).handler((event, data) -> {
            int dataIndex = event.index();
            if (dataIndex > 11) {
                event.setIndex(dataIndex - 1);
                return;
            }
            if (dataIndex != 11) {
                return;
            }
            event.cancel();
            EntityTracker1_21_2 tracker = (EntityTracker1_21_2)this.tracker(event.user());
            EntityTracker1_21_2.BoatEntity entity = tracker.trackedBoatEntity(event.entityId());
            if (entity == null) {
                return;
            }
            boolean isBundling = event.user().get(BundleStateTracker.class).isBundling();
            if (!isBundling) {
                PacketWrapper bundleStart = PacketWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER, event.user());
                bundleStart.send(Protocol1_21To1_21_2.class);
            }
            PacketWrapper removeEntityPacket = PacketWrapper.create(ClientboundPackets1_21_2.REMOVE_ENTITIES, event.user());
            removeEntityPacket.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{event.entityId()});
            removeEntityPacket.send(Protocol1_21To1_21_2.class);
            int boatType = (Integer)data.getValue();
            EntityType entityType = tracker.entityType(event.entityId()).isOrHasParent(EntityTypes1_21_2.ABSTRACT_CHEST_BOAT) ? this.entityTypeFromChestBoatType(boatType) : this.entityTypeFromBoatType(boatType);
            PacketWrapper spawnEntityPacket = PacketWrapper.create(ClientboundPackets1_21_2.ADD_ENTITY, event.user());
            spawnEntityPacket.write(Types.VAR_INT, event.entityId());
            spawnEntityPacket.write(Types.UUID, entity.uuid());
            spawnEntityPacket.write(Types.VAR_INT, entityType.getId());
            spawnEntityPacket.write(Types.DOUBLE, entity.x());
            spawnEntityPacket.write(Types.DOUBLE, entity.y());
            spawnEntityPacket.write(Types.DOUBLE, entity.z());
            spawnEntityPacket.write(Types.BYTE, (byte)Math.floor(entity.pitch() * 256.0f / 360.0f));
            spawnEntityPacket.write(Types.BYTE, (byte)Math.floor(entity.yaw() * 256.0f / 360.0f));
            spawnEntityPacket.write(Types.BYTE, (byte)0);
            spawnEntityPacket.write(Types.VAR_INT, entity.data());
            spawnEntityPacket.write(Types.SHORT, (short)0);
            spawnEntityPacket.write(Types.SHORT, (short)0);
            spawnEntityPacket.write(Types.SHORT, (short)0);
            spawnEntityPacket.send(Protocol1_21To1_21_2.class);
            tracker.updateBoatType(event.entityId(), entityType);
            PacketWrapper setEntityDataPacket = PacketWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA, event.user());
            setEntityDataPacket.write(Types.VAR_INT, event.entityId());
            setEntityDataPacket.write(VersionedTypes.V1_21_2.entityDataList, entity.entityData());
            setEntityDataPacket.send(Protocol1_21To1_21_2.class);
            if (entity.passengers() != null) {
                PacketWrapper setPassengersPacket = PacketWrapper.create(ClientboundPackets1_21_2.SET_PASSENGERS, event.user());
                setPassengersPacket.write(Types.VAR_INT, event.entityId());
                setPassengersPacket.write(Types.VAR_INT_ARRAY_PRIMITIVE, entity.passengers());
                setPassengersPacket.send(Protocol1_21To1_21_2.class);
            }
            if (!isBundling) {
                PacketWrapper bundleEnd = PacketWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER, event.user());
                bundleEnd.send(Protocol1_21To1_21_2.class);
            }
        });
        this.filter().type(EntityTypes1_21_2.SALMON).addIndex(17);
        this.filter().type(EntityTypes1_21_2.AGEABLE_WATER_CREATURE).addIndex(16);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_ARROW).addIndex(10);
    }

    @Override
    public void handleEntityData(int entityId, List<EntityData> dataList, UserConnection connection) {
        super.handleEntityData(entityId, dataList, connection);
        EntityTracker1_21_2 tracker = (EntityTracker1_21_2)this.tracker(connection);
        EntityType entityType = tracker.entityType(entityId);
        if (entityType == null || !entityType.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
            return;
        }
        List<EntityData> entityData = tracker.trackedBoatEntity(entityId).entityData();
        entityData.removeIf(first -> dataList.stream().anyMatch(second -> first.id() == second.id()));
        for (EntityData data : dataList) {
            Object value = data.value();
            if (value instanceof Item) {
                Item item = (Item)value;
                entityData.add(new EntityData(data.id(), data.dataType(), item.copy()));
                continue;
            }
            entityData.add(new EntityData(data.id(), data.dataType(), value));
        }
    }

    private EntityType entityTypeFromBoatType(int boatType) {
        if (boatType == 0) {
            return EntityTypes1_21_2.OAK_BOAT;
        }
        if (boatType == 1) {
            return EntityTypes1_21_2.SPRUCE_BOAT;
        }
        if (boatType == 2) {
            return EntityTypes1_21_2.BIRCH_BOAT;
        }
        if (boatType == 3) {
            return EntityTypes1_21_2.JUNGLE_BOAT;
        }
        if (boatType == 4) {
            return EntityTypes1_21_2.ACACIA_BOAT;
        }
        if (boatType == 5) {
            return EntityTypes1_21_2.CHERRY_BOAT;
        }
        if (boatType == 6) {
            return EntityTypes1_21_2.DARK_OAK_BOAT;
        }
        if (boatType == 7) {
            return EntityTypes1_21_2.MANGROVE_BOAT;
        }
        if (boatType == 8) {
            return EntityTypes1_21_2.BAMBOO_RAFT;
        }
        return EntityTypes1_21_2.OAK_BOAT;
    }

    private EntityType entityTypeFromChestBoatType(int chestBoatType) {
        if (chestBoatType == 0) {
            return EntityTypes1_21_2.OAK_CHEST_BOAT;
        }
        if (chestBoatType == 1) {
            return EntityTypes1_21_2.SPRUCE_CHEST_BOAT;
        }
        if (chestBoatType == 2) {
            return EntityTypes1_21_2.BIRCH_CHEST_BOAT;
        }
        if (chestBoatType == 3) {
            return EntityTypes1_21_2.JUNGLE_CHEST_BOAT;
        }
        if (chestBoatType == 4) {
            return EntityTypes1_21_2.ACACIA_CHEST_BOAT;
        }
        if (chestBoatType == 5) {
            return EntityTypes1_21_2.CHERRY_CHEST_BOAT;
        }
        if (chestBoatType == 6) {
            return EntityTypes1_21_2.DARK_OAK_CHEST_BOAT;
        }
        if (chestBoatType == 7) {
            return EntityTypes1_21_2.MANGROVE_CHEST_BOAT;
        }
        if (chestBoatType == 8) {
            return EntityTypes1_21_2.BAMBOO_CHEST_RAFT;
        }
        return EntityTypes1_21_2.OAK_CHEST_BOAT;
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_2.getTypeFromId(type);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    private static String jvmdowngrader$concat$lambda$registerPackets$1$1(int n2) {
        return "item.goat_horn.sound." + n2;
    }
}

