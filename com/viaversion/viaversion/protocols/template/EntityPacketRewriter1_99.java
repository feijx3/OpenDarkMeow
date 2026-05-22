/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.template;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.template.Protocol1_98To1_99;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;

final class EntityPacketRewriter1_99
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_98To1_99> {
    public EntityPacketRewriter1_99(Protocol1_98To1_99 protocol) {
        super(protocol);
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
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        ((Protocol1_98To1_99)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes = (EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_98To1_99)this.protocol).types()).entityDataTypes();
        this.registerEntityDataTypeHandler(entityDataTypes.itemType, entityDataTypes.blockStateType, entityDataTypes.optionalBlockStateType, entityDataTypes.particleType, entityDataTypes.particlesType, entityDataTypes.componentType, entityDataTypes.optionalComponentType);
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

