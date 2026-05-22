/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class EntityPacketRewriter1_21_6
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_6To1_21_5> {
    public EntityPacketRewriter1_21_6(Protocol1_21_6To1_21_5 protocol) {
        super(protocol, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_21_6.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_6.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_6.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_6.GAME_EVENT);
        this.registerLogin1_20_5(ClientboundPackets1_21_6.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_6.RESPAWN);
        ((Protocol1_21_6To1_21_5)this.protocol).appendClientbound(ClientboundPackets1_21_6.ADD_ENTITY, wrapper -> {
            int entityId = wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.UUID);
            int entityType = wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.VAR_INT);
            short velocityX = wrapper.passthrough(Types.SHORT);
            short velocityY = wrapper.passthrough(Types.SHORT);
            short velocityZ = wrapper.passthrough(Types.SHORT);
            this.getSpawnTrackerWithDataHandler1_19(EntityTypes1_21_6.FALLING_BLOCK).handle(wrapper);
            if (!(velocityX == 0 && velocityY == 0 && velocityZ == 0 || this.typeFromId(entityType).isOrHasParent(EntityTypes1_21_6.LIVING_ENTITY))) {
                PacketWrapper motionPacket = wrapper.create(ClientboundPackets1_21_5.SET_ENTITY_MOTION);
                motionPacket.write(Types.VAR_INT, entityId);
                motionPacket.write(Types.SHORT, velocityX);
                motionPacket.write(Types.SHORT, velocityY);
                motionPacket.write(Types.SHORT, velocityZ);
                wrapper.send(Protocol1_21_6To1_21_5.class);
                motionPacket.send(Protocol1_21_6To1_21_5.class);
                wrapper.cancel();
            }
        });
        BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter((BackwardsProtocol)this.protocol){

            @Override
            public RegistryEntry[] handle(UserConnection connection, String key, RegistryEntry[] entries) {
                if (Key.stripMinecraftNamespace(key).equals("dialog")) {
                    String[] keys = new String[entries.length];
                    for (int i2 = 0; i2 < entries.length; ++i2) {
                        keys[i2] = Key.stripMinecraftNamespace(entries[i2].key());
                    }
                    Object2ObjectArrayMap<String, CompoundTag> dialogs = new Object2ObjectArrayMap<String, CompoundTag>();
                    for (RegistryEntry entry : entries) {
                        Tag tag = entry.tag();
                        if (!(tag instanceof CompoundTag)) continue;
                        CompoundTag tag2 = (CompoundTag)tag;
                        dialogs.put(Key.stripMinecraftNamespace(entry.key()), tag2);
                    }
                    RegistryAndTags registryAndTags = connection.get(RegistryAndTags.class);
                    registryAndTags.storeRegistry(new KeyMappings(keys), dialogs);
                }
                return super.handle(connection, key, entries);
            }
        };
        registryDataRewriter.remove("dialog");
        ((Protocol1_21_6To1_21_5)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21_6.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_21_6To1_21_5)this.protocol).registerServerbound(ServerboundPackets1_21_5.PLAYER_COMMAND, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int action = wrapper.read(Types.VAR_INT);
            if (action < 2) {
                wrapper.cancel();
            }
            wrapper.write(Types.VAR_INT, action - 2);
        });
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes = (EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes;
        this.filter().mapDataType(entityDataTypes::byId);
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes.itemType, entityDataTypes.blockStateType, entityDataTypes.optionalBlockStateType, entityDataTypes.particleType, entityDataTypes.particlesType, entityDataTypes.componentType, entityDataTypes.optionalComponentType);
        this.filter().type(EntityTypes1_21_6.HANGING_ENTITY).removeIndex(8);
        this.filter().type(EntityTypes1_21_6.HAPPY_GHAST).cancel(17);
        this.filter().type(EntityTypes1_21_6.HAPPY_GHAST).cancel(18);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
        this.mapEntityTypeWithData(EntityTypes1_21_6.HAPPY_GHAST, EntityTypes1_21_6.GHAST).tagName();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_6.getTypeFromId(type);
    }
}

