/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public class EntityPacketRewriter1_16_2
extends EntityRewriter<ClientboundPackets1_16, Protocol1_16_1To1_16_2> {
    public EntityPacketRewriter1_16_2(Protocol1_16_1To1_16_2 protocol) {
        super(protocol);
    }

    @Override
    protected void registerPackets() {
        this.registerTrackerWithData(ClientboundPackets1_16.ADD_ENTITY, EntityTypes1_16_2.FALLING_BLOCK);
        this.registerTracker(ClientboundPackets1_16.ADD_MOB);
        this.registerTracker(ClientboundPackets1_16.ADD_PLAYER, EntityTypes1_16_2.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_16.SET_ENTITY_DATA, Types1_16.ENTITY_DATA_LIST);
        this.registerRemoveEntities(ClientboundPackets1_16.REMOVE_ENTITIES);
        ((Protocol1_16_1To1_16_2)this.protocol).registerClientbound(ClientboundPackets1_16.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(wrapper -> {
                    short gamemode = wrapper.read(Types.UNSIGNED_BYTE);
                    wrapper.write(Types.BOOLEAN, (gamemode & 8) != 0);
                    wrapper.write(Types.BYTE, (byte)(gamemode & 0xFFFFFFF7));
                });
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.handler(wrapper -> {
                    wrapper.read(Types.NAMED_COMPOUND_TAG);
                    wrapper.write(Types.NAMED_COMPOUND_TAG, ((Protocol1_16_1To1_16_2)EntityPacketRewriter1_16_2.this.protocol).getMappingData().getDimensionRegistry());
                    String dimensionType = wrapper.read(Types.STRING);
                    wrapper.write(Types.NAMED_COMPOUND_TAG, EntityPacketRewriter1_16_2.this.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_16_1to1_16_2_rewriter_EntityPacketRewriter1_16_2$getDimensionData(dimensionType));
                });
                this.map(Types.STRING);
                this.handler(wrapper -> {
                    String world = wrapper.get(Types.STRING, 0);
                    EntityPacketRewriter1_16_2.this.tracker(wrapper.user()).setCurrentWorld(world);
                });
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE, Types.VAR_INT);
                this.handler(EntityPacketRewriter1_16_2.this.playerTrackerHandler());
            }
        });
        ((Protocol1_16_1To1_16_2)this.protocol).registerClientbound(ClientboundPackets1_16.RESPAWN, wrapper -> {
            String dimensionType = wrapper.read(Types.STRING);
            wrapper.write(Types.NAMED_COMPOUND_TAG, this.getDimensionData(dimensionType));
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorld(wrapper.user(), world);
        });
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_16.ENTITY_DATA_TYPES.itemType, Types1_16.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_16.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_16_2.ABSTRACT_MINECART, 10);
        this.filter().type(EntityTypes1_16_2.ABSTRACT_PIGLIN).handler((event, data) -> {
            if (data.id() == 15) {
                data.setId(16);
            } else if (data.id() == 16) {
                data.setId(15);
            }
        });
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_16_2.getTypeFromId(type);
    }

    private CompoundTag getDimensionData(String dimensionType) {
        CompoundTag tag = Protocol1_16_1To1_16_2.MAPPINGS.getDimensionDataMap().get(dimensionType);
        if (tag == null) {
            ((Protocol1_16_1To1_16_2)this.protocol).getLogger().severe(EntityPacketRewriter1_16_2.jvmdowngrader$concat$getDimensionData$1(dimensionType));
            throw new NullPointerException(EntityPacketRewriter1_16_2.jvmdowngrader$concat$getDimensionData$2(dimensionType));
        }
        return tag.copy();
    }

    public CompoundTag jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_16_1to1_16_2_rewriter_EntityPacketRewriter1_16_2$getDimensionData(String string) {
        return this.getDimensionData(string);
    }

    private static String jvmdowngrader$concat$getDimensionData$1(String string) {
        return "Could not get dimension data of " + string;
    }

    private static String jvmdowngrader$concat$getDimensionData$2(String string) {
        return "Dimension data for " + string + " is null!";
    }
}

