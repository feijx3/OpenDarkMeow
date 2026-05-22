/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.version.Ref
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

@NestMembers(value={1.class})
public final class EntityPacketRewriter1_21_2
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_2To1_21> {
    private static final int REL_X = 0;
    private static final int REL_Y = 1;
    private static final int REL_Z = 2;
    private static final int REL_Y_ROT = 3;
    private static final int REL_X_ROT = 4;
    private static final int REL_DELTA_X = 5;
    private static final int REL_DELTA_Y = 6;
    private static final int REL_DELTA_Z = 7;
    private static final int REL_ROTATE_DELTA = 8;
    private boolean warned = ViaBackwards.getConfig().suppressEmulationWarnings();

    public EntityPacketRewriter1_21_2(Protocol1_21_2To1_21 protocol) {
        super(protocol, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_21_2.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_2.REMOVE_ENTITIES);
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.ADD_ENTITY, wrapper -> {
            int entityId = wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.UUID);
            int entityTypeId = wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.VAR_INT);
            this.getSpawnTrackerWithDataHandler1_19(EntityTypes1_21_2.FALLING_BLOCK).handle(wrapper);
            EntityType type = EntityTypes1_21_2.getTypeFromId(entityTypeId);
            if (type.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
                wrapper.send(Protocol1_21_2To1_21.class);
                wrapper.cancel();
                ArrayList<EntityData> data = new ArrayList<EntityData>();
                int boatType = type.isOrHasParent(EntityTypes1_21_2.ABSTRACT_CHEST_BOAT) ? this.chestBoatTypeFromEntityType(type) : this.boatTypeFromEntityType(type);
                data.add(new EntityData(11, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).varIntType, boatType));
                PacketWrapper entityDataPacket = wrapper.create(ClientboundPackets1_21.SET_ENTITY_DATA);
                entityDataPacket.write(Types.VAR_INT, entityId);
                entityDataPacket.write(VersionedTypes.V1_21.entityDataList, data);
                entityDataPacket.send(Protocol1_21_2To1_21.class);
            }
        });
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        registryDataRewriter.addEnchantmentEffectRewriter("change_item_damage", tag -> tag.putString("type", "damage_item"));
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, wrapper -> {
            String registryKey = Key.stripMinecraftNamespace(wrapper.passthrough(Types.STRING));
            RegistryEntry[] entries = wrapper.read(Types.REGISTRY_ENTRY_ARRAY);
            if (registryKey.equals("instrument")) {
                wrapper.cancel();
                return;
            }
            if (registryKey.equals("worldgen/biome")) {
                for (RegistryEntry entry : entries) {
                    CompoundTag effects;
                    CompoundTag particle;
                    if (entry.tag() == null || (particle = (effects = ((CompoundTag)entry.tag()).getCompoundTag("effects")).getCompoundTag("particle")) == null) continue;
                    CompoundTag particleOptions = particle.getCompoundTag("options");
                    String particleType = particleOptions.getString("type");
                    this.updateParticleFormat(particleOptions, Key.stripMinecraftNamespace(particleType));
                }
            }
            wrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryDataRewriter.handle(wrapper.user(), registryKey, entries));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.LOGIN, new PacketHandlers(){

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
                this.read(Types.VAR_INT);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RESPAWN, wrapper -> {
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.read(Types.VAR_INT);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.ENTITY_POSITION_SYNC, ClientboundPackets1_21.TELEPORT_ENTITY, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.read(Types.DOUBLE);
            wrapper.read(Types.DOUBLE);
            wrapper.read(Types.DOUBLE);
            float yaw = wrapper.read(Types.FLOAT).floatValue();
            float pitch = wrapper.read(Types.FLOAT).floatValue();
            this.writePackedRotation(wrapper, yaw, pitch);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLAYER_ROTATION, ClientboundPackets1_21.PLAYER_LOOK_AT, wrapper -> {
            float yaw = wrapper.read(Types.FLOAT).floatValue();
            float pitch = wrapper.read(Types.FLOAT).floatValue();
            double yRadians = Math.toRadians(yaw);
            double xRadians = Math.toRadians(pitch);
            double factor = -Math.cos(-xRadians);
            double deltaX = Math.sin(-yRadians - 3.1415927410125732) * factor;
            double deltaY = Math.sin(-xRadians);
            double deltaZ = Math.cos(-yRadians - 3.1415927410125732) * factor;
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            wrapper.write(Types.VAR_INT, 0);
            wrapper.write(Types.DOUBLE, storage.x() + deltaX);
            wrapper.write(Types.DOUBLE, storage.y() + deltaY);
            wrapper.write(Types.DOUBLE, storage.z() + deltaZ);
            wrapper.write(Types.BOOLEAN, false);
            PacketWrapper entityMotionPacket = PacketWrapper.create(ServerboundPackets1_21_2.MOVE_PLAYER_ROT, wrapper.user());
            entityMotionPacket.write(Types.FLOAT, Float.valueOf(yaw));
            entityMotionPacket.write(Types.FLOAT, Float.valueOf(pitch));
            entityMotionPacket.write(Types.UNSIGNED_BYTE, (short)0);
            entityMotionPacket.sendToServer(Protocol1_21_2To1_21.class);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.TELEPORT_ENTITY, wrapper -> {
            int entityId = wrapper.passthrough(Types.VAR_INT);
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            double movementX = wrapper.read(Types.DOUBLE);
            double movementY = wrapper.read(Types.DOUBLE);
            double movementZ = wrapper.read(Types.DOUBLE);
            float yaw = wrapper.read(Types.FLOAT).floatValue();
            float pitch = wrapper.read(Types.FLOAT).floatValue();
            this.writePackedRotation(wrapper, yaw, pitch);
            int relativeArguments = wrapper.read(Types.INT);
            wrapper.send(Protocol1_21_2To1_21.class);
            wrapper.cancel();
            this.handleRelativeArguments(wrapper, x2, y2, z2, yaw, pitch, relativeArguments, movementX, movementY, movementZ, entityId);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLAYER_POSITION, wrapper -> {
            int teleportId = wrapper.read(Types.VAR_INT);
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            double movementX = wrapper.read(Types.DOUBLE);
            double movementY = wrapper.read(Types.DOUBLE);
            double movementZ = wrapper.read(Types.DOUBLE);
            float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
            float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
            int relativeArguments = wrapper.read(Types.INT);
            wrapper.write(Types.BYTE, (byte)relativeArguments);
            wrapper.write(Types.VAR_INT, teleportId);
            wrapper.send(Protocol1_21_2To1_21.class);
            wrapper.cancel();
            this.handleRelativeArguments(wrapper, x2, y2, z2, yaw, pitch, relativeArguments, movementX, movementY, movementZ, null);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLAYER_COMMAND, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int action = wrapper.passthrough(Types.VAR_INT);
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            if (action == 0) {
                storage.setPlayerCommandTrackedSneaking(true);
            } else if (action == 1) {
                storage.setPlayerCommandTrackedSneaking(false);
            } else if (action == 3) {
                storage.setPlayerCommandTrackedSprinting(true);
            } else if (action == 4) {
                storage.setPlayerCommandTrackedSprinting(false);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLAYER_INPUT, wrapper -> {
            boolean sneaking;
            float sideways = wrapper.read(Types.FLOAT).floatValue();
            float forward = wrapper.read(Types.FLOAT).floatValue();
            byte flags = wrapper.read(Types.BYTE);
            byte updatedFlags = 0;
            if (forward > 0.0f) {
                updatedFlags = (byte)(updatedFlags | 1);
            } else if (forward < 0.0f) {
                updatedFlags = (byte)(updatedFlags | 2);
            }
            if (sideways > 0.0f) {
                updatedFlags = (byte)(updatedFlags | 4);
            } else if (sideways < 0.0f) {
                updatedFlags = (byte)(updatedFlags | 8);
            }
            if ((flags & 1) != 0) {
                updatedFlags = (byte)(updatedFlags | 0x10);
            }
            boolean bl2 = sneaking = (flags & 2) != 0;
            if (sneaking) {
                updatedFlags = (byte)(updatedFlags | 0x20);
            }
            wrapper.write(Types.BYTE, updatedFlags);
            this.sendSneakingPlayerCommand(wrapper, sneaking);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS, wrapper -> {
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            this.fixOnGround(wrapper);
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            storage.setPosition(x2, y2, z2);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, wrapper -> {
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
            float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
            this.fixOnGround(wrapper);
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            storage.setPosition(x2, y2, z2);
            storage.setRotation(yaw, pitch);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, wrapper -> {
            float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
            float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
            this.fixOnGround(wrapper);
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            storage.setRotation(yaw, pitch);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_STATUS_ONLY, this::fixOnGround);
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_VEHICLE, wrapper -> {
            double x2 = wrapper.passthrough(Types.DOUBLE);
            double y2 = wrapper.passthrough(Types.DOUBLE);
            double z2 = wrapper.passthrough(Types.DOUBLE);
            float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
            float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
            PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
            storage.setPosition(x2, y2, z2);
            storage.setRotation(yaw, pitch);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE, wrapper -> {
            BitSet actions = wrapper.read(Types.PROFILE_ACTIONS_ENUM1_21_2);
            BitSet updatedActions = new BitSet(6);
            for (int i2 = 0; i2 < 6; ++i2) {
                if (!actions.get(i2)) continue;
                updatedActions.set(i2);
            }
            wrapper.write(Types.PROFILE_ACTIONS_ENUM1_19_3, updatedActions);
            int entries = wrapper.passthrough(Types.VAR_INT);
            for (int i3 = 0; i3 < entries; ++i3) {
                wrapper.passthrough(Types.UUID);
                if (actions.get(0)) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (actions.get(1) && wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    wrapper.passthrough(Types.UUID);
                    wrapper.passthrough(Types.PROFILE_KEY);
                }
                if (actions.get(2)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                if (actions.get(3)) {
                    wrapper.passthrough(Types.BOOLEAN);
                }
                if (actions.get(4)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                if (actions.get(5)) {
                    Tag displayName = wrapper.passthrough(Types.OPTIONAL_TAG);
                    ((ComponentRewriterBase)((Object)((Protocol1_21_2To1_21)this.protocol).getComponentRewriter())).processTag(wrapper.user(), displayName);
                }
                if (!actions.get(6)) continue;
                wrapper.read(Types.VAR_INT);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_PASSENGERS, wrapper -> {
            int vehicleId = wrapper.passthrough(Types.VAR_INT);
            int[] passengerIds = wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            ClientVehicleStorage storage = wrapper.user().get(ClientVehicleStorage.class);
            if (storage != null && vehicleId == storage.vehicleId()) {
                wrapper.user().remove(ClientVehicleStorage.class);
                this.sendSneakingPlayerCommand(wrapper, false);
            }
            int clientEntityId = this.tracker(wrapper.user()).clientEntityId();
            for (int passenger : passengerIds) {
                if (passenger != clientEntityId) continue;
                wrapper.user().put(new ClientVehicleStorage(vehicleId));
                break;
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).appendClientbound(ClientboundPackets1_21_2.REMOVE_ENTITIES, wrapper -> {
            int[] entityIds;
            ClientVehicleStorage vehicleStorage = wrapper.user().get(ClientVehicleStorage.class);
            if (vehicleStorage == null) {
                return;
            }
            for (int entityId : entityIds = wrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0)) {
                if (entityId != vehicleStorage.vehicleId()) continue;
                wrapper.user().remove(ClientVehicleStorage.class);
                this.sendSneakingPlayerCommand(wrapper, false);
                break;
            }
        });
    }

    private void updateParticleFormat(CompoundTag options, String particleType) {
        if ("dust_color_transition".equals(particleType)) {
            this.replaceColor(options, "from_color");
            this.replaceColor(options, "to_color");
        } else if ("dust".equals(particleType)) {
            this.replaceColor(options, "color");
        }
    }

    private void replaceColor(CompoundTag options, String to_color) {
        IntTag toColorTag = options.getIntTag(to_color);
        if (toColorTag == null) {
            return;
        }
        int rgb = toColorTag.asInt();
        float r2 = (float)(rgb >> 16 & 0xFF) / 255.0f;
        float g2 = (float)(rgb >> 8 & 0xFF) / 255.0f;
        float b2 = (float)(rgb & 0xFF) / 255.0f;
        options.put(to_color, new ListTag<FloatTag>(EntityPacketRewriter1_21_2.jvmdg$inlined$of(new FloatTag(r2), new FloatTag(g2), new FloatTag(b2))));
    }

    private void writePackedRotation(PacketWrapper wrapper, float yaw, float pitch) {
        wrapper.write(Types.BYTE, (byte)Math.floor(yaw * 256.0f / 360.0f));
        wrapper.write(Types.BYTE, (byte)Math.floor(pitch * 256.0f / 360.0f));
    }

    private void handleRelativeArguments(PacketWrapper wrapper, double x2, double y2, double z2, float yaw, float pitch, int relativeArguments, double movementX, double movementY, double movementZ, @Nullable Integer entityId) {
        PlayerStorage storage = wrapper.user().get(PlayerStorage.class);
        if ((relativeArguments & 1) != 0) {
            x2 += storage.x();
        }
        if ((relativeArguments & 2) != 0) {
            y2 += storage.y();
        }
        if ((relativeArguments & 4) != 0) {
            z2 += storage.z();
        }
        if ((relativeArguments & 8) != 0) {
            yaw += storage.yaw();
        }
        if ((relativeArguments & 0x10) != 0) {
            pitch += storage.pitch();
        }
        if ((relativeArguments & 0x100) != 0) {
            double deltaYaw = Math.toRadians(storage.yaw() - yaw);
            double deltaYawCos = Math.cos(deltaYaw);
            double deltaYawSin = Math.sin(deltaYaw);
            movementX = movementX * deltaYawCos + movementZ * deltaYawSin;
            movementZ = movementZ * deltaYawCos - movementX * deltaYawSin;
            double deltaPitch = Math.toRadians(storage.pitch() - pitch);
            double deltaPitchCos = Math.cos(deltaPitch);
            double deltaPitchSin = Math.sin(deltaPitch);
            movementY = movementY * deltaPitchCos + movementZ * deltaPitchSin;
            movementZ = movementZ * deltaPitchCos - movementY * deltaPitchSin;
        }
        boolean relativeDeltaX = (relativeArguments & 0x20) != 0;
        boolean relativeDeltaY = (relativeArguments & 0x40) != 0;
        boolean relativeDeltaZ = (relativeArguments & 0x80) != 0;
        storage.setPosition(x2, y2, z2);
        storage.setRotation(yaw, pitch);
        if (relativeDeltaX && relativeDeltaY && relativeDeltaZ) {
            if (entityId != null && entityId.intValue() != this.tracker(wrapper.user()).clientEntityId()) {
                return;
            }
            PacketWrapper explosionPacket = wrapper.create(ClientboundPackets1_21.EXPLODE);
            explosionPacket.write(Types.DOUBLE, 0.0);
            explosionPacket.write(Types.DOUBLE, 0.0);
            explosionPacket.write(Types.DOUBLE, 0.0);
            explosionPacket.write(Types.FLOAT, Float.valueOf(0.0f));
            explosionPacket.write(Types.VAR_INT, 0);
            explosionPacket.write(Types.FLOAT, Float.valueOf((float)movementX));
            explosionPacket.write(Types.FLOAT, Float.valueOf((float)movementY));
            explosionPacket.write(Types.FLOAT, Float.valueOf((float)movementZ));
            explosionPacket.write(Types.VAR_INT, 0);
            explosionPacket.write(VersionedTypes.V1_21.particle(), new Particle(0));
            explosionPacket.write(VersionedTypes.V1_21.particle(), new Particle(0));
            explosionPacket.write(Types.SOUND_EVENT, Holder.of(new SoundEvent("", null)));
            explosionPacket.send(Protocol1_21_2To1_21.class);
        } else if (!(relativeDeltaX || relativeDeltaY || relativeDeltaZ)) {
            PacketWrapper entityMotionPacket = wrapper.create(ClientboundPackets1_21.SET_ENTITY_MOTION);
            entityMotionPacket.write(Types.VAR_INT, entityId != null ? entityId.intValue() : this.tracker(wrapper.user()).clientEntityId());
            entityMotionPacket.write(Types.SHORT, (short)(movementX * 8000.0));
            entityMotionPacket.write(Types.SHORT, (short)(movementY * 8000.0));
            entityMotionPacket.write(Types.SHORT, (short)(movementZ * 8000.0));
            entityMotionPacket.send(Protocol1_21_2To1_21.class);
        } else if (!this.warned) {
            ((Protocol1_21_2To1_21)this.protocol).getLogger().warning("Mixed combinations of relative and absolute delta movements are not supported for 1.21.1 players. This will result in incorrect movement for the player. ");
            this.warned = true;
        }
    }

    private void sendSneakingPlayerCommand(PacketWrapper wrapper, boolean sneaking) {
        PlayerStorage sneakingStorage = wrapper.user().get(PlayerStorage.class);
        if (sneakingStorage.setSneaking(sneaking)) {
            PacketWrapper playerCommandPacket = wrapper.create(ServerboundPackets1_21_2.PLAYER_COMMAND);
            playerCommandPacket.write(Types.VAR_INT, this.tracker(wrapper.user()).clientEntityId());
            playerCommandPacket.write(Types.VAR_INT, sneaking ? 0 : 1);
            playerCommandPacket.write(Types.VAR_INT, 0);
            playerCommandPacket.sendToServer(Protocol1_21_2To1_21.class);
        }
    }

    private int boatTypeFromEntityType(EntityType type) {
        if (type == EntityTypes1_21_2.OAK_BOAT) {
            return 0;
        }
        if (type == EntityTypes1_21_2.SPRUCE_BOAT) {
            return 1;
        }
        if (type == EntityTypes1_21_2.BIRCH_BOAT) {
            return 2;
        }
        if (type == EntityTypes1_21_2.JUNGLE_BOAT) {
            return 3;
        }
        if (type == EntityTypes1_21_2.ACACIA_BOAT) {
            return 4;
        }
        if (type == EntityTypes1_21_2.CHERRY_BOAT) {
            return 5;
        }
        if (type == EntityTypes1_21_2.DARK_OAK_BOAT) {
            return 6;
        }
        if (type == EntityTypes1_21_2.MANGROVE_BOAT) {
            return 7;
        }
        if (type == EntityTypes1_21_2.BAMBOO_RAFT) {
            return 8;
        }
        return 0;
    }

    private int chestBoatTypeFromEntityType(EntityType type) {
        if (type == EntityTypes1_21_2.OAK_CHEST_BOAT) {
            return 0;
        }
        if (type == EntityTypes1_21_2.SPRUCE_CHEST_BOAT) {
            return 1;
        }
        if (type == EntityTypes1_21_2.BIRCH_CHEST_BOAT) {
            return 2;
        }
        if (type == EntityTypes1_21_2.JUNGLE_CHEST_BOAT) {
            return 3;
        }
        if (type == EntityTypes1_21_2.ACACIA_CHEST_BOAT) {
            return 4;
        }
        if (type == EntityTypes1_21_2.CHERRY_CHEST_BOAT) {
            return 5;
        }
        if (type == EntityTypes1_21_2.DARK_OAK_CHEST_BOAT) {
            return 6;
        }
        if (type == EntityTypes1_21_2.MANGROVE_CHEST_BOAT) {
            return 7;
        }
        if (type == EntityTypes1_21_2.BAMBOO_CHEST_RAFT) {
            return 8;
        }
        return 0;
    }

    private void fixOnGround(PacketWrapper wrapper) {
        boolean data = wrapper.read(Types.BOOLEAN);
        wrapper.write(Types.UNSIGNED_BYTE, data ? (short)1 : 0);
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes)::byId);
        this.registerEntityDataTypeHandler1_20_3(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).itemType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).blockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particleType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particlesType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).componentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_2.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_2.CREAKING).cancel(17);
        this.filter().type(EntityTypes1_21_2.CREAKING).cancel(16);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_BOAT).addIndex(11);
        this.filter().type(EntityTypes1_21_2.SALMON).removeIndex(17);
        this.filter().type(EntityTypes1_21_2.AGEABLE_WATER_CREATURE).removeIndex(16);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_ARROW).removeIndex(10);
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_2.getTypeFromId(type);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
        this.mapEntityTypeWithData(EntityTypes1_21_2.CREAKING, EntityTypes1_21_2.WARDEN).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_2.CREAKING_TRANSIENT, EntityTypes1_21_2.WARDEN).tagName();
    }

    @Stub(ref=@Ref(value="Ljava/util/List;"))
    private static <E> List<E> jvmdg$inlined$of(E e1, E e2, E e3) {
        return Collections.unmodifiableList(Arrays.asList(e1, e2, e3));
    }
}

