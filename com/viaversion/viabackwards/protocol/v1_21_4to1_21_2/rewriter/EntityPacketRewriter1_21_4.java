/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.Protocol1_21_4To1_21_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class EntityPacketRewriter1_21_4
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_4To1_21_2> {
    public EntityPacketRewriter1_21_4(Protocol1_21_4To1_21_2 protocol) {
        super(protocol, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_2.ADD_ENTITY, EntityTypes1_21_4.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_2.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_2.REMOVE_ENTITIES);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol){

            @Override
            public RegistryEntry[] handle(UserConnection connection, String key, RegistryEntry[] entries) {
                block4: {
                    String strippedKey;
                    block3: {
                        strippedKey = Key.stripMinecraftNamespace(key);
                        if (!strippedKey.equals("worldgen/biome")) break block3;
                        for (RegistryEntry entry : entries) {
                            CompoundTag effectsTag;
                            ListTag<CompoundTag> weightedMusicTags;
                            if (entry.tag() == null || (weightedMusicTags = (effectsTag = ((CompoundTag)entry.tag()).getCompoundTag("effects")).getListTag("music", CompoundTag.class)) == null) continue;
                            if (weightedMusicTags.isEmpty()) {
                                effectsTag.remove("music");
                                continue;
                            }
                            CompoundTag musicTag = weightedMusicTags.get(0);
                            effectsTag.put("music", musicTag.get("data"));
                        }
                        break block4;
                    }
                    if (!strippedKey.equals("trim_material")) break block4;
                    for (RegistryEntry entry : entries) {
                        if (entry.tag() == null) continue;
                        CompoundTag compoundTag = (CompoundTag)entry.tag();
                        compoundTag.putFloat("item_model_index", EntityPacketRewriter1_21_4.this.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_4to1_21_2_rewriter_EntityPacketRewriter1_21_4$itemModelIndex(entry.key()));
                    }
                }
                return super.handle(connection, key, entries);
            }
        };
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21_2.LOGIN, wrapper -> {
            int entityId = wrapper.passthrough(Types.INT);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.STRING_ARRAY);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
            this.trackPlayer(wrapper.user(), entityId);
            PacketWrapper playerLoadedPacket = wrapper.create(ServerboundPackets1_21_4.PLAYER_LOADED);
            playerLoadedPacket.scheduleSendToServer(Protocol1_21_4To1_21_2.class);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21_2.RESPAWN, wrapper -> {
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
            PacketWrapper playerLoadedPacket = wrapper.create(ServerboundPackets1_21_4.PLAYER_LOADED);
            playerLoadedPacket.scheduleSendToServer(Protocol1_21_4To1_21_2.class);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_VEHICLE, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.write(Types.BOOLEAN, true);
        });
    }

    private float itemModelIndex(String trim) {
        float f2;
        switch (Key.stripNamespace(trim)) {
            case "amethyst": {
                f2 = 1.0f;
                break;
            }
            case "copper": {
                f2 = 0.5f;
                break;
            }
            case "diamond": {
                f2 = 0.8f;
                break;
            }
            case "emerald": {
                f2 = 0.7f;
                break;
            }
            case "gold": {
                f2 = 0.6f;
                break;
            }
            case "iron": {
                f2 = 0.2f;
                break;
            }
            case "lapis": {
                f2 = 0.9f;
                break;
            }
            case "netherite": {
                f2 = 0.3f;
                break;
            }
            case "quartz": {
                f2 = 0.1f;
                break;
            }
            case "redstone": {
                f2 = 0.4f;
                break;
            }
            default: {
                f2 = 1.0f;
            }
        }
        return f2;
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes)::byId);
        this.registerEntityDataTypeHandler1_20_3(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_4.CREAKING).removeIndex(19);
        this.filter().type(EntityTypes1_21_4.CREAKING).removeIndex(18);
        this.filter().type(EntityTypes1_21_4.SALMON).index(17).handler((event, data) -> {
            String string;
            int typeId = (Integer)data.value();
            switch (typeId) {
                case 0: {
                    string = "small";
                    break;
                }
                case 2: {
                    string = "large";
                    break;
                }
                default: {
                    string = "medium";
                }
            }
            String type = string;
            data.setTypeAndValue(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).stringType, type);
        });
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_4.getTypeFromId(type);
    }

    public float jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_4to1_21_2_rewriter_EntityPacketRewriter1_21_4$itemModelIndex(String string) {
        return this.itemModelIndex(string);
    }
}

