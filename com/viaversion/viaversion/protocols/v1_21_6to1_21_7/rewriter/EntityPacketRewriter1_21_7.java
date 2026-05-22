/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_6to1_21_7.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_6to1_21_7.Protocol1_21_6To1_21_7;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;

public final class EntityPacketRewriter1_21_7
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_6To1_21_7> {
    public EntityPacketRewriter1_21_7(Protocol1_21_6To1_21_7 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_6.ADD_ENTITY, EntityTypes1_21_6.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_6.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_6.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_6.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_6.GAME_EVENT);
        this.registerLogin1_20_5(ClientboundPackets1_21_6.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_6.RESPAWN);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        ((Protocol1_21_6To1_21_7)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21_6.REGISTRY_DATA, registryDataRewriter::handle);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes = (EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_21_6To1_21_7)this.protocol).types()).entityDataTypes();
        this.registerEntityDataTypeHandler(entityDataTypes.itemType, entityDataTypes.blockStateType, entityDataTypes.optionalBlockStateType, entityDataTypes.particleType, entityDataTypes.particlesType, entityDataTypes.componentType, entityDataTypes.optionalComponentType);
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_6.getTypeFromId(type);
    }
}

