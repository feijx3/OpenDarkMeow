/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.rewriter;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.Protocol1_21_7To1_21_6;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;

public final class EntityPacketRewriter1_21_7
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_7To1_21_6> {
    public EntityPacketRewriter1_21_7(Protocol1_21_7To1_21_6 protocol) {
        super(protocol, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_6.ADD_ENTITY, EntityTypes1_21_4.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_6.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_6.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_6.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_6.GAME_EVENT);
        this.registerLogin1_20_5(ClientboundPackets1_21_6.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_6.RESPAWN);
        BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter((BackwardsProtocol)this.protocol);
        ((Protocol1_21_7To1_21_6)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21_6.REGISTRY_DATA, registryDataRewriter::handle);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 mappedEntityDataTypes = (EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes;
        this.registerEntityDataTypeHandler1_20_3(mappedEntityDataTypes.itemType, mappedEntityDataTypes.blockStateType, mappedEntityDataTypes.optionalBlockStateType, mappedEntityDataTypes.particleType, mappedEntityDataTypes.particlesType, mappedEntityDataTypes.componentType, mappedEntityDataTypes.optionalComponentType);
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_6.getTypeFromId(type);
    }
}

