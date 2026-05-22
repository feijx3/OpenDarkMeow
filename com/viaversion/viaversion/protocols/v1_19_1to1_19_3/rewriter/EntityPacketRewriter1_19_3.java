/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.Protocol1_19_1To1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.BitSet;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={2.class, 1.class})
public final class EntityPacketRewriter1_19_3
extends EntityRewriter<ClientboundPackets1_19_1, Protocol1_19_1To1_19_3> {
    public EntityPacketRewriter1_19_3(Protocol1_19_1To1_19_3 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_19_1.ADD_ENTITY, EntityTypes1_19_3.FALLING_BLOCK);
        this.registerTracker(ClientboundPackets1_19_1.ADD_EXPERIENCE_ORB, EntityTypes1_19_3.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_19_1.ADD_PLAYER, EntityTypes1_19_3.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_19_1.SET_ENTITY_DATA, Types1_19.ENTITY_DATA_LIST, Types1_19_3.ENTITY_DATA_LIST);
        this.registerRemoveEntities(ClientboundPackets1_19_1.REMOVE_ENTITIES);
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_3.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_19_3.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(EntityPacketRewriter1_19_3.this.playerTrackerHandler());
                this.handler(wrapper -> {
                    PacketWrapper enableFeaturesPacket = wrapper.create(ClientboundPackets1_19_3.UPDATE_ENABLED_FEATURES);
                    enableFeaturesPacket.write(Types.STRING_ARRAY, new String[]{"minecraft:vanilla"});
                    if (wrapper.user().getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_20_2)) {
                        enableFeaturesPacket.send(Protocol1_19_1To1_19_3.class);
                    } else {
                        enableFeaturesPacket.scheduleSend(Protocol1_19_1To1_19_3.class);
                    }
                });
            }
        });
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(wrapper -> {
                    boolean keepAttributes = wrapper.read(Types.BOOLEAN);
                    byte keepDataMask = 2;
                    if (keepAttributes) {
                        keepDataMask = (byte)(keepDataMask | 1);
                    }
                    wrapper.write(Types.BYTE, keepDataMask);
                });
            }
        });
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.PLAYER_INFO, ClientboundPackets1_19_3.PLAYER_INFO_UPDATE, wrapper -> {
            int action = wrapper.read(Types.VAR_INT);
            if (action == 4) {
                int entries = wrapper.read(Types.VAR_INT);
                UUID[] uuidsToRemove = new UUID[entries];
                for (int i2 = 0; i2 < entries; ++i2) {
                    uuidsToRemove[i2] = wrapper.read(Types.UUID);
                }
                wrapper.write(Types.UUID_ARRAY, uuidsToRemove);
                wrapper.setPacketType(ClientboundPackets1_19_3.PLAYER_INFO_REMOVE);
                return;
            }
            BitSet set = new BitSet(6);
            if (action == 0) {
                set.set(0, 6);
            } else {
                set.set(action == 1 ? action + 1 : action + 2);
            }
            wrapper.write(Types.PROFILE_ACTIONS_ENUM1_19_3, set);
            int entries = wrapper.passthrough(Types.VAR_INT);
            for (int i3 = 0; i3 < entries; ++i3) {
                JsonElement displayName;
                wrapper.passthrough(Types.UUID);
                if (action == 0) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    int gamemode = wrapper.read(Types.VAR_INT);
                    int ping = wrapper.read(Types.VAR_INT);
                    JsonElement displayName2 = wrapper.read(Types.OPTIONAL_COMPONENT);
                    if (displayName2 != null) {
                        ((Protocol1_19_1To1_19_3)this.protocol).getComponentRewriter().processText(wrapper.user(), displayName2);
                    }
                    wrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    wrapper.write(Types.BOOLEAN, false);
                    wrapper.write(Types.VAR_INT, gamemode);
                    wrapper.write(Types.BOOLEAN, true);
                    wrapper.write(Types.VAR_INT, ping);
                    wrapper.write(Types.OPTIONAL_COMPONENT, displayName2);
                    continue;
                }
                if (action == 1 || action == 2) {
                    wrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (action != 3 || (displayName = wrapper.passthrough(Types.OPTIONAL_COMPONENT)) == null) continue;
                ((Protocol1_19_1To1_19_3)this.protocol).getComponentRewriter().processText(wrapper.user(), displayName);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(typeId -> Types1_19_3.ENTITY_DATA_TYPES.byId(typeId >= 2 ? typeId + 1 : typeId));
        this.registerEntityDataTypeHandler(Types1_19_3.ENTITY_DATA_TYPES.itemType, Types1_19_3.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_19_3.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_19_3.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_3.ENTITY).index(6).handler((event, data) -> {
            int pose = (Integer)data.value();
            if (pose >= 10) {
                data.setValue(pose + 1);
            }
        });
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_19_3.getTypeFromId(type);
    }
}

