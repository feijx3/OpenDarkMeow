/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage.MessageIndexStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class EntityPacketRewriter1_21_5
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_4To1_21_5> {
    private static final int ATTACK_BLOCKED_ENTITY_EVENT = 29;
    private static final int SHIELD_DISABLED_ENTITY_EVENT = 30;
    private static final int SADDLE_ITEM_ID = 800;
    private static final byte SADDLE_EQUIPMENT_SLOT = 7;

    public EntityPacketRewriter1_21_5(Protocol1_21_4To1_21_5 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21_2.ADD_ENTITY, EntityTypes1_21_5.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21_2.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_2.REMOVE_ENTITIES);
        this.registerPlayerAbilities(ClientboundPackets1_21_2.PLAYER_ABILITIES);
        this.registerGameEvent(ClientboundPackets1_21_2.GAME_EVENT);
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.ADD_EXPERIENCE_ORB, ClientboundPackets1_21_5.ADD_ENTITY, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.write(Types.UUID, UUID.randomUUID());
            wrapper.write(Types.VAR_INT, EntityTypes1_21_5.EXPERIENCE_ORB.getId());
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.write(Types.BYTE, (byte)0);
            wrapper.write(Types.BYTE, (byte)0);
            wrapper.write(Types.BYTE, (byte)0);
            wrapper.passthroughAndMap(Types.SHORT, Types.VAR_INT);
            wrapper.write(Types.SHORT, (short)0);
            wrapper.write(Types.SHORT, (short)0);
            wrapper.write(Types.SHORT, (short)0);
        });
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        registryDataRewriter.addHandler("wolf_variant", (key, variant) -> {
            CompoundTag assets = new CompoundTag();
            variant.put("assets", assets);
            assets.put("wild", variant.remove("wild_texture"));
            assets.put("tame", variant.remove("tame_texture"));
            assets.put("angry", variant.remove("angry_texture"));
            variant.remove("biomes");
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registryDataRewriter::handle);
        ((Protocol1_21_4To1_21_5)this.protocol).registerFinishConfiguration(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, wrapper -> {
            this.sendEntityVariants(wrapper.user(), "minecraft:frog_variant", "frog", true, "temperate", "warm", "cold");
            this.sendEntityVariants(wrapper.user(), "minecraft:cat_variant", "cat", false, "tabby", "black", "red", "siamese", "british_shorthair", "calico", "persian", "ragdoll", "white", "jellie", "all_black");
            this.sendEntityVariants(wrapper.user(), "minecraft:pig_variant", "pig", true, "temperate");
            this.sendEntityVariants(wrapper.user(), "minecraft:cow_variant", "cow", true, "temperate");
            this.sendEntityVariants(wrapper.user(), "minecraft:chicken_variant", "chicken", true, "temperate");
            PacketWrapper wolfSoundVariantsPacket = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, wrapper.user());
            wolfSoundVariantsPacket.write(Types.STRING, "minecraft:wolf_sound_variant");
            wolfSoundVariantsPacket.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{this.wolfSoundVariant()});
            wolfSoundVariantsPacket.send(Protocol1_21_4To1_21_5.class);
        });
        this.registerRespawn1_20_5(ClientboundPackets1_21_2.RESPAWN);
        this.registerLogin1_20_5(ClientboundPackets1_21_2.LOGIN);
        ((Protocol1_21_4To1_21_5)this.protocol).appendClientbound(ClientboundPackets1_21_2.LOGIN, wrapper -> wrapper.user().get(MessageIndexStorage.class).setIndex(0));
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_PLAYER_TEAM, wrapper -> {
            wrapper.passthrough(Types.STRING);
            byte action = wrapper.passthrough(Types.BYTE);
            if (action == 0 || action == 2) {
                wrapper.passthrough(Types.TAG);
                wrapper.passthrough(Types.BYTE);
                String nametagVisibility = wrapper.read(Types.STRING);
                String collisionRule = wrapper.read(Types.STRING);
                wrapper.write(Types.VAR_INT, this.visibilityId(nametagVisibility));
                wrapper.write(Types.VAR_INT, this.collisionId(collisionRule));
                wrapper.passthrough(Types.VAR_INT);
                wrapper.passthrough(Types.TAG);
                wrapper.passthrough(Types.TAG);
            }
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.ENTITY_EVENT, wrapper -> {
            int entityId = wrapper.read(Types.INT);
            byte event = wrapper.read(Types.BYTE);
            if (event == 29) {
                this.playShieldSound(wrapper, entityId, 1273, 1.0f);
                return;
            }
            if (event == 30) {
                this.playShieldSound(wrapper, entityId, 1274, 0.8f);
                return;
            }
            wrapper.write(Types.INT, entityId);
            wrapper.write(Types.BYTE, event);
        });
    }

    private void playShieldSound(PacketWrapper wrapper, int entityId, int soundId, float volume) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        wrapper.setPacketType(ClientboundPackets1_21_5.SOUND_ENTITY);
        wrapper.write(Types.SOUND_EVENT, Holder.of(soundId));
        wrapper.write(Types.VAR_INT, 7);
        wrapper.write(Types.VAR_INT, entityId);
        wrapper.write(Types.FLOAT, Float.valueOf(volume));
        wrapper.write(Types.FLOAT, Float.valueOf(0.8f + random.nextFloat() * 0.4f));
        wrapper.write(Types.LONG, random.nextLong());
    }

    private RegistryEntry wolfSoundVariant() {
        CompoundTag classicWolfSoundVariant = new CompoundTag();
        classicWolfSoundVariant.putString("ambient_sound", "entity.wolf.ambient");
        classicWolfSoundVariant.putString("death_sound", "entity.wolf.death");
        classicWolfSoundVariant.putString("growl_sound", "entity.wolf.growl");
        classicWolfSoundVariant.putString("hurt_sound", "entity.wolf.hurt");
        classicWolfSoundVariant.putString("pant_sound", "entity.wolf.pant");
        classicWolfSoundVariant.putString("whine_sound", "entity.wolf.whine");
        return new RegistryEntry("classic", classicWolfSoundVariant);
    }

    private int collisionId(String collisionRule) {
        int n2;
        switch (collisionRule) {
            case "always": {
                n2 = 0;
                break;
            }
            case "never": {
                n2 = 1;
                break;
            }
            case "pushOtherTeams": {
                n2 = 2;
                break;
            }
            case "pushOwnTeam": {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private int visibilityId(String visibilityRule) {
        int n2;
        switch (visibilityRule) {
            case "always": {
                n2 = 0;
                break;
            }
            case "never": {
                n2 = 1;
                break;
            }
            case "hideForOtherTeams": {
                n2 = 2;
                break;
            }
            case "hideForOwnTeam": {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void sendEntityVariants(UserConnection connection, String key, String entityName, boolean suffixedWithOwnName, String ... entryKeys) {
        PacketWrapper variantsPacket = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, connection);
        variantsPacket.write(Types.STRING, key);
        RegistryEntry[] entries = new RegistryEntry[entryKeys.length];
        for (int i2 = 0; i2 < entryKeys.length; ++i2) {
            CompoundTag tag = new CompoundTag();
            String assetId = EntityPacketRewriter1_21_5.jvmdowngrader$concat$sendEntityVariants$1(entityName, entryKeys[i2]);
            if (suffixedWithOwnName) {
                assetId = EntityPacketRewriter1_21_5.jvmdowngrader$concat$sendEntityVariants$2(assetId, entityName);
            }
            tag.putString("asset_id", assetId);
            entries[i2] = new RegistryEntry(entryKeys[i2], tag);
        }
        variantsPacket.write(Types.REGISTRY_ENTRY_ARRAY, entries);
        variantsPacket.send(Protocol1_21_4To1_21_5.class);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((event, data) -> {
            int id = data.dataType().typeId();
            if (id == ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).wolfVariantType.typeId()) {
                Holder wolfVariant = (Holder)data.value();
                data.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).wolfVariantType, wolfVariant.hasId() ? wolfVariant.id() : 0);
                return;
            }
            int mappedId = id;
            if (mappedId >= ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).cowVariantType.typeId()) {
                ++mappedId;
            }
            if (mappedId >= ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).wolfSoundVariantType.typeId()) {
                ++mappedId;
            }
            if (mappedId >= ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).pigVariantType.typeId()) {
                ++mappedId;
            }
            if (mappedId >= ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).chickenVariantType.typeId()) {
                ++mappedId;
            }
            data.setDataType(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).byId(mappedId));
        });
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).itemType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).blockStateType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).particleType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).particlesType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).componentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalComponentType);
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).index(11).handler((event, data) -> {
            int state = (Integer)data.getValue();
            int mappedBlockState = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData().getNewBlockStateId(state);
            if (mappedBlockState == 0) {
                event.cancel();
                return;
            }
            data.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalBlockStateType, mappedBlockState);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).removeIndex(13);
        this.filter().type(EntityTypes1_21_5.MOOSHROOM).index(17).handler((event, data) -> {
            String typeName = (String)data.value();
            int typeId = typeName.equals("red") ? 0 : 1;
            data.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).varIntType, typeId);
        });
        this.filter().type(EntityTypes1_21_5.PIG).index(17).handler((event, data) -> {
            boolean saddled = (Boolean)data.value();
            this.sendSaddleEquipment(event, saddled);
        });
        this.filter().type(EntityTypes1_21_5.PIG).removeIndex(17);
        this.filter().type(EntityTypes1_21_5.STRIDER).index(19).handler((event, data) -> {
            event.cancel();
            boolean saddled = (Boolean)data.value();
            this.sendSaddleEquipment(event, saddled);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_HORSE).index(17).handler((event, data) -> {
            byte flags = (Byte)data.value();
            this.sendSaddleEquipment(event, (flags & 4) != 0);
        });
        this.filter().type(EntityTypes1_21_5.DOLPHIN).removeIndex(17);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(22);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(21);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(20);
        this.filter().type(EntityTypes1_21_5.TURTLE).removeIndex(17);
    }

    private void sendSaddleEquipment(EntityDataHandlerEvent event, boolean saddled) {
        PacketWrapper equipmentPacket = PacketWrapper.create(ClientboundPackets1_21_5.SET_EQUIPMENT, event.user());
        equipmentPacket.write(Types.VAR_INT, event.entityId());
        equipmentPacket.write(Types.BYTE, (byte)7);
        equipmentPacket.write(VersionedTypes.V1_21_5.item, saddled ? new StructuredItem(800, 1) : StructuredItem.empty());
        equipmentPacket.send(Protocol1_21_4To1_21_5.class);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_5.getTypeFromId(type);
    }

    private static String jvmdowngrader$concat$sendEntityVariants$1(String string, String string2) {
        return "entity/" + string + "/" + string2;
    }

    private static String jvmdowngrader$concat$sendEntityVariants$2(String string, String string2) {
        return string + "_" + string2;
    }
}

