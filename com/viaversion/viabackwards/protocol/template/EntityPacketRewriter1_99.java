/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.template;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.template.Protocol1_99To1_98;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;

final class EntityPacketRewriter1_99
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_99To1_98> {
    public EntityPacketRewriter1_99(Protocol1_99To1_98 protocol) {
        super(protocol, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_2.ADD_ENTITY, EntityTypes1_21_4.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_2.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_2.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_2.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_2.GAME_EVENT);
        this.registerLogin1_20_5(ClientboundPackets1_21_2.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_2.RESPAWN);
        BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter((BackwardsProtocol)this.protocol);
        ((Protocol1_99To1_98)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_2 mappedEntityDataTypes = (EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes;
        this.registerEntityDataTypeHandler1_20_3(mappedEntityDataTypes.itemType, mappedEntityDataTypes.blockStateType, mappedEntityDataTypes.optionalBlockStateType, mappedEntityDataTypes.particleType, mappedEntityDataTypes.particlesType, mappedEntityDataTypes.componentType, mappedEntityDataTypes.optionalComponentType);
    }

    @Override
    public void onMappingDataLoaded() {
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_4.getTypeFromId(type);
    }
}

