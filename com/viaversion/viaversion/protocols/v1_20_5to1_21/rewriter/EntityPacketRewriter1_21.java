/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.Paintings1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.PlayerPositionStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;

public final class EntityPacketRewriter1_21
extends EntityRewriter<ClientboundPacket1_20_5, Protocol1_20_5To1_21> {
    public EntityPacketRewriter1_21(Protocol1_20_5To1_21 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_20_5.ADD_ENTITY, EntityTypes1_20_5.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_20_5.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_20_5.REMOVE_ENTITIES);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        CompoundTag campfireDamageType = new CompoundTag();
        campfireDamageType.putString("scaling", "when_caused_by_living_non_player");
        campfireDamageType.putString("message_id", "inFire");
        campfireDamageType.putFloat("exhaustion", 0.1f);
        registryDataRewriter.addEntries("damage_type", new RegistryEntry("minecraft:campfire", campfireDamageType));
        ((Protocol1_20_5To1_21)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_20_5To1_21)this.protocol).registerFinishConfiguration(ClientboundConfigurationPackets1_20_5.FINISH_CONFIGURATION, wrapper -> {
            PacketWrapper paintingRegistryPacket = wrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            paintingRegistryPacket.write(Types.STRING, "minecraft:painting_variant");
            RegistryEntry[] paintingsRegistry = new RegistryEntry[Paintings1_20_5.PAINTINGS.length];
            for (int i2 = 0; i2 < Paintings1_20_5.PAINTINGS.length; ++i2) {
                PaintingVariant painting = Paintings1_20_5.PAINTINGS[i2];
                CompoundTag tag = new CompoundTag();
                tag.putInt("width", painting.width());
                tag.putInt("height", painting.height());
                tag.putString("asset_id", painting.assetId());
                paintingsRegistry[i2] = new RegistryEntry(painting.assetId(), tag);
            }
            paintingRegistryPacket.write(Types.REGISTRY_ENTRY_ARRAY, paintingsRegistry);
            paintingRegistryPacket.send(Protocol1_20_5To1_21.class);
            PacketWrapper enchantmentRegistryPacket = wrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            enchantmentRegistryPacket.write(Types.STRING, "minecraft:enchantment");
            RegistryEntry[] enchantmentRegistry = new RegistryEntry[Enchantments1_20_5.ENCHANTMENTS.size()];
            for (int i3 = 0; i3 < Enchantments1_20_5.ENCHANTMENTS.size(); ++i3) {
                String key = Enchantments1_20_5.idToKey(i3);
                CompoundTag tag = ((Protocol1_20_5To1_21)this.protocol).getMappingData().enchantment(i3);
                enchantmentRegistry[i3] = new RegistryEntry(key, tag);
            }
            enchantmentRegistryPacket.write(Types.REGISTRY_ENTRY_ARRAY, enchantmentRegistry);
            enchantmentRegistryPacket.send(Protocol1_20_5To1_21.class);
            PacketWrapper jukeboxSongsPacket = wrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            jukeboxSongsPacket.write(Types.STRING, "minecraft:jukebox_song");
            jukeboxSongsPacket.write(Types.REGISTRY_ENTRY_ARRAY, ((Protocol1_20_5To1_21)this.protocol).getMappingData().jukeboxSongs());
            jukeboxSongsPacket.send(Protocol1_20_5To1_21.class);
        });
        this.registerLogin1_20_5(ClientboundPackets1_20_5.LOGIN);
        ((Protocol1_20_5To1_21)this.protocol).appendClientbound(ClientboundPackets1_20_5.LOGIN, wrapper -> wrapper.user().get(EfficiencyAttributeStorage.class).onLoginSent(wrapper.get(Types.INT, 0), wrapper.user()));
        ((Protocol1_20_5To1_21)this.protocol).registerClientbound(ClientboundPackets1_20_5.RESPAWN, wrapper -> {
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
            wrapper.user().get(EfficiencyAttributeStorage.class).onRespawn(wrapper.user());
            wrapper.user().put(new PlayerPositionStorage());
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS, wrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storePosition(wrapper);
                this.storeOnGround(wrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, wrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                wrapper.passthrough(Types.FLOAT);
                wrapper.passthrough(Types.FLOAT);
                this.storeOnGround(wrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, wrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storePosition(wrapper);
                wrapper.passthrough(Types.FLOAT);
                wrapper.passthrough(Types.FLOAT);
                this.storeOnGround(wrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_STATUS_ONLY, wrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storeOnGround(wrapper);
            }
        });
    }

    private void storePosition(PacketWrapper wrapper) {
        double x2 = wrapper.passthrough(Types.DOUBLE);
        double y2 = wrapper.passthrough(Types.DOUBLE);
        double z2 = wrapper.passthrough(Types.DOUBLE);
        wrapper.user().get(PlayerPositionStorage.class).setPosition(x2, y2, z2);
    }

    private void storeOnGround(PacketWrapper wrapper) {
        boolean onGround = wrapper.passthrough(Types.BOOLEAN);
        wrapper.user().get(PlayerPositionStorage.class).setOnGround(onGround);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((event, data) -> {
            EntityDataType type = data.dataType();
            if (type == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType) {
                int variant = (Integer)data.value();
                data.setTypeAndValue(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).wolfVariantType, Holder.of(variant));
            } else if (type == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).paintingVariantType) {
                int variant = (Integer)data.value();
                data.setTypeAndValue(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).paintingVariantType, Holder.of(variant));
            } else {
                data.setDataType(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).byId(type.typeId()));
            }
        });
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).itemType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).blockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particleType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particlesType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).componentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_20_5.getTypeFromId(type);
    }
}

