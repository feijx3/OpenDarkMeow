/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.storage.SneakStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;

public final class EntityPacketRewriter1_21_6
extends EntityRewriter<ClientboundPacket1_21_5, Protocol1_21_5To1_21_6> {
    public EntityPacketRewriter1_21_6(Protocol1_21_5To1_21_6 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_5.ADD_ENTITY, EntityTypes1_21_6.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_5.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_5.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_5.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_5.GAME_EVENT);
        this.registerLogin1_20_5(ClientboundPackets1_21_5.LOGIN);
        this.registerRespawn1_20_5(ClientboundPackets1_21_5.RESPAWN);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        registryDataRewriter.addHandler("dimension_type", (key, dimension) -> {
            String effects = dimension.getString("effects");
            if (effects != null && ("the_nether".equals(effects = Key.stripMinecraftNamespace(effects)) || "the_end".equals(effects))) {
                return;
            }
            if (!dimension.contains("cloud_height")) {
                dimension.putInt("cloud_height", 192);
            }
        });
        ((Protocol1_21_5To1_21_6)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_21_5To1_21_6)this.protocol).registerFinishConfiguration(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, wrapper -> {
            PacketWrapper dialogsPacket = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, wrapper.user());
            dialogsPacket.write(Types.STRING, "minecraft:dialog");
            dialogsPacket.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{this.serverLinksDialog()});
            dialogsPacket.send(Protocol1_21_5To1_21_6.class);
        });
        ((Protocol1_21_5To1_21_6)this.protocol).appendClientbound(ClientboundPackets1_21_5.RESPAWN, wrapper -> wrapper.user().get(SneakStorage.class).setSneaking(false));
        ((Protocol1_21_5To1_21_6)this.protocol).registerServerbound(ServerboundPackets1_21_6.PLAYER_COMMAND, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int action = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.VAR_INT, action + 2);
        });
        ((Protocol1_21_5To1_21_6)this.protocol).registerServerbound(ServerboundPackets1_21_6.PLAYER_INPUT, wrapper -> {
            boolean pressingShift;
            byte flags = wrapper.passthrough(Types.BYTE);
            boolean bl2 = pressingShift = (flags & 0x20) != 0;
            if (wrapper.user().get(SneakStorage.class).setSneaking(pressingShift)) {
                PacketWrapper playerCommandPacket = wrapper.create(ServerboundPackets1_21_5.PLAYER_COMMAND);
                playerCommandPacket.write(Types.VAR_INT, this.tracker(wrapper.user()).clientEntityId());
                playerCommandPacket.write(Types.VAR_INT, pressingShift ? 0 : 1);
                playerCommandPacket.write(Types.VAR_INT, 0);
                playerCommandPacket.sendToServer(Protocol1_21_5To1_21_6.class);
            }
        });
    }

    private RegistryEntry serverLinksDialog() {
        CompoundTag serverLinksDialog = new CompoundTag();
        serverLinksDialog.putString("type", "minecraft:server_links");
        CompoundTag title = new CompoundTag();
        title.putString("translate", "menu.server_links.title");
        serverLinksDialog.put("title", title);
        CompoundTag externalTitle = new CompoundTag();
        externalTitle.putString("translate", "menu.server_links");
        serverLinksDialog.put("external_title", externalTitle);
        CompoundTag exitAction = new CompoundTag();
        exitAction.putInt("width", 200);
        CompoundTag exitActionLabel = new CompoundTag();
        exitActionLabel.putString("translate", "gui.back");
        exitAction.put("label", exitActionLabel);
        serverLinksDialog.put("exit_action", exitAction);
        serverLinksDialog.putInt("columns", 1);
        serverLinksDialog.putInt("button_width", 310);
        return new RegistryEntry("server_links", serverLinksDialog);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes = (EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes;
        this.filter().mapDataType(entityDataTypes::byId);
        this.registerEntityDataTypeHandler(entityDataTypes.itemType, entityDataTypes.blockStateType, entityDataTypes.optionalBlockStateType, entityDataTypes.particleType, entityDataTypes.particlesType, entityDataTypes.componentType, entityDataTypes.optionalComponentType);
        this.filter().type(EntityTypes1_21_6.HANGING_ENTITY).addIndex(8);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_6.getTypeFromId(type);
    }
}

