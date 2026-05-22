/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;

public final class EntityPacketRewriter1_21_4
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_2To1_21_4> {
    public EntityPacketRewriter1_21_4(Protocol1_21_2To1_21_4 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_2.ADD_ENTITY, EntityTypes1_21_4.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_2.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_2.REMOVE_ENTITIES);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        registryDataRewriter.addHandler("worldgen/biome", (key, biome) -> {
            CompoundTag effectsTag = biome.getCompoundTag("effects");
            CompoundTag musicTag = effectsTag.getCompoundTag("music");
            if (musicTag == null) {
                return;
            }
            ListTag<CompoundTag> weightedMusicTags = new ListTag<CompoundTag>(CompoundTag.class);
            CompoundTag weightedMusicTag = new CompoundTag();
            weightedMusicTag.put("data", musicTag);
            weightedMusicTag.putInt("weight", 1);
            weightedMusicTags.add(weightedMusicTag);
            effectsTag.put("music", weightedMusicTags);
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
        this.registerLogin1_20_5(ClientboundPackets1_21_2.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_2.RESPAWN);
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.MOVE_VEHICLE, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.read(Types.BOOLEAN);
        });
        ((Protocol1_21_2To1_21_4)this.protocol).cancelServerbound(ServerboundPackets1_21_4.PLAYER_LOADED);
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes)::byId);
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_4.CREAKING).addIndex(18);
        this.filter().type(EntityTypes1_21_4.SALMON).index(17).handler((event, data) -> {
            int n2;
            String type;
            switch (type = (String)data.value()) {
                case "small": {
                    n2 = 0;
                    break;
                }
                case "large": {
                    n2 = 2;
                    break;
                }
                default: {
                    n2 = 1;
                }
            }
            int typeId = n2;
            data.setTypeAndValue(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).varIntType, typeId);
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
}

