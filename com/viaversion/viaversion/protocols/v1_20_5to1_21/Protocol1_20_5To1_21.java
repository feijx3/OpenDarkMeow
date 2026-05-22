/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.AttributeModifierMappings1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.MappingData1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.ComponentRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.EntityPacketRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.PlayerPositionStorage;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.Locale;
import java.util.UUID;

public final class Protocol1_20_5To1_21
extends AbstractProtocol<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5> {
    public static final MappingData1_21 MAPPINGS = new MappingData1_21();
    private final EntityPacketRewriter1_21 entityRewriter = new EntityPacketRewriter1_21(this);
    private final BlockItemPacketRewriter1_21 itemRewriter = new BlockItemPacketRewriter1_21(this);
    private final ParticleRewriter<ClientboundPacket1_20_5> particleRewriter = new ParticleRewriter<ClientboundPacket1_20_5>(this);
    private final TagRewriter<ClientboundPacket1_20_5> tagRewriter = new TagRewriter<ClientboundPacket1_20_5>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_20_5> componentRewriter = new ComponentRewriter1_21(this);

    public Protocol1_20_5To1_21() {
        super(ClientboundPacket1_20_5.class, ClientboundPacket1_21.class, ServerboundPacket1_20_5.class, ServerboundPacket1_20_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.registerGeneric(ClientboundPackets1_20_5.UPDATE_TAGS);
        this.tagRewriter.registerGeneric(ClientboundConfigurationPackets1_20_5.UPDATE_TAGS);
        SoundRewriter<ClientboundPacket1_20_5> soundRewriter = new SoundRewriter<ClientboundPacket1_20_5>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_20_5.SOUND);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_20_5.SOUND_ENTITY);
        new StatisticsRewriter<ClientboundPacket1_20_5>(this).register(ClientboundPackets1_20_5.AWARD_STATS);
        this.componentRewriter.registerOpenScreen1_14(ClientboundPackets1_20_5.OPEN_SCREEN);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_ACTION_BAR_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_TITLE_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_SUBTITLE_TEXT);
        this.componentRewriter.registerBossEvent(ClientboundPackets1_20_5.BOSS_EVENT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_20_5.DISCONNECT);
        this.componentRewriter.registerTabList(ClientboundPackets1_20_5.TAB_LIST);
        this.componentRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_20_5.PLAYER_COMBAT_KILL);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_20_5.SYSTEM_CHAT);
        this.particleRewriter.registerLevelParticles1_20_5(ClientboundPackets1_20_5.LEVEL_PARTICLES);
        this.particleRewriter.registerExplode1_20_5(ClientboundPackets1_20_5.EXPLODE);
        this.registerClientbound(ClientboundPackets1_20_5.DISGUISED_CHAT, wrapper -> {
            this.componentRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            int chatType = wrapper.read(Types.VAR_INT);
            wrapper.write(ChatType.TYPE, Holder.of(chatType));
        });
        this.registerClientbound(ClientboundPackets1_20_5.PLAYER_CHAT, wrapper -> {
            wrapper.passthrough(Types.UUID);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.LONG);
            int lastSeen = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < lastSeen; ++i2) {
                int index = wrapper.passthrough(Types.VAR_INT);
                if (index != 0) continue;
                wrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            this.componentRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            int filterMaskType = wrapper.passthrough(Types.VAR_INT);
            if (filterMaskType == 2) {
                wrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            int chatType = wrapper.read(Types.VAR_INT);
            wrapper.write(ChatType.TYPE, Holder.of(chatType));
            this.componentRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            this.componentRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
        });
        this.registerClientbound(ClientboundPackets1_20_5.UPDATE_ATTRIBUTES, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                int attributeId = wrapper.read(Types.VAR_INT);
                wrapper.write(Types.VAR_INT, MAPPINGS.getNewAttributeId(attributeId));
                wrapper.passthrough(Types.DOUBLE);
                int modifierSize = wrapper.passthrough(Types.VAR_INT);
                for (int j2 = 0; j2 < modifierSize; ++j2) {
                    UUID uuid = wrapper.read(Types.UUID);
                    wrapper.write(Types.STRING, Protocol1_20_5To1_21.mapAttributeUUID(uuid, null));
                    wrapper.passthrough(Types.DOUBLE);
                    wrapper.passthrough(Types.BYTE);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_20_5.PROJECTILE_POWER, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            double xPower = wrapper.read(Types.DOUBLE);
            double yPower = wrapper.read(Types.DOUBLE);
            double zPower = wrapper.read(Types.DOUBLE);
            double accelerationPower = Math.sqrt(xPower * xPower + yPower * yPower + zPower * zPower);
            wrapper.write(Types.DOUBLE, accelerationPower);
        });
    }

    public static String mapAttributeUUID(UUID uuid, String name) {
        String id = AttributeModifierMappings1_21.uuidToId(uuid);
        if (id != null) {
            return id;
        }
        if (name != null) {
            id = AttributeModifierMappings1_21.nameToId(name);
        }
        return id != null ? id : uuid.toString().toLowerCase(Locale.ROOT);
    }

    public static UUID mapAttributeId(String id) {
        UUID uuid = AttributeModifierMappings1_21.idToUuid(id);
        if (uuid != null) {
            return uuid;
        }
        uuid = UUIDUtil.parseUUID(Key.stripNamespace(id).toUpperCase(Locale.ROOT));
        return uuid != null ? uuid : UUID.randomUUID();
    }

    @Override
    protected void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        VersionedTypes.V1_21.particle.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("dust_pillar", ParticleType.Readers.BLOCK).reader("falling_dust", ParticleType.Readers.BLOCK).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION).reader("item", ParticleType.Readers.item(VersionedTypes.V1_21.item)).reader("vibration", ParticleType.Readers.VIBRATION1_20_3).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK).reader("entity_effect", ParticleType.Readers.COLOR);
        VersionedTypes.V1_21.structuredData.filler(this).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_DATA).add((StructuredDataKey<?>)StructuredDataKey.MAX_STACK_SIZE).add((StructuredDataKey<?>)StructuredDataKey.MAX_DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.UNBREAKABLE1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RARITY).add((StructuredDataKey<?>)StructuredDataKey.HIDE_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.FIRE_RESISTANT).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_NAME).add((StructuredDataKey<?>)StructuredDataKey.LORE).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_PLACE_ON1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_BREAK1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_MODEL_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.REPAIR_COST).add((StructuredDataKey<?>)StructuredDataKey.CREATIVE_SLOT_LOCK).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE).add((StructuredDataKey<?>)StructuredDataKey.INTANGIBLE_PROJECTILE).add((StructuredDataKey<?>)StructuredDataKey.STORED_ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DYED_COLOR1_20_5).add((StructuredDataKey<?>)StructuredDataKey.MAP_COLOR).add((StructuredDataKey<?>)StructuredDataKey.MAP_ID).add((StructuredDataKey<?>)StructuredDataKey.MAP_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.MAP_POST_PROCESSING).add((StructuredDataKey<?>)StructuredDataKey.POTION_CONTENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.SUSPICIOUS_STEW_EFFECTS).add((StructuredDataKey<?>)StructuredDataKey.WRITABLE_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.WRITTEN_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.TRIM1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DEBUG_STICK_STATE).add((StructuredDataKey<?>)StructuredDataKey.ENTITY_DATA).add((StructuredDataKey<?>)StructuredDataKey.BUCKET_ENTITY_DATA).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_ENTITY_DATA).add((StructuredDataKey<?>)StructuredDataKey.INSTRUMENT1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RECIPES).add((StructuredDataKey<?>)StructuredDataKey.LODESTONE_TRACKER).add((StructuredDataKey<?>)StructuredDataKey.FIREWORK_EXPLOSION).add((StructuredDataKey<?>)StructuredDataKey.FIREWORKS).add((StructuredDataKey<?>)StructuredDataKey.PROFILE).add((StructuredDataKey<?>)StructuredDataKey.NOTE_BLOCK_SOUND).add((StructuredDataKey<?>)StructuredDataKey.BANNER_PATTERNS).add((StructuredDataKey<?>)StructuredDataKey.BASE_COLOR).add((StructuredDataKey<?>)StructuredDataKey.POT_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_STATE).add((StructuredDataKey<?>)StructuredDataKey.BEES).add((StructuredDataKey<?>)StructuredDataKey.LOCK).add((StructuredDataKey<?>)StructuredDataKey.CONTAINER_LOOT).add((StructuredDataKey<?>)StructuredDataKey.TOOL1_20_5).add((StructuredDataKey<?>)StructuredDataKey.ITEM_NAME).add((StructuredDataKey<?>)StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER).add((StructuredDataKey<?>)StructuredDataKey.FOOD1_21).add((StructuredDataKey<?>)StructuredDataKey.JUKEBOX_PLAYABLE1_21).add((StructuredDataKey<?>)StructuredDataKey.ATTRIBUTE_MODIFIERS1_21);
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:blocks_wind_charge_explosions");
        this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:can_turn_in_boats", "minecraft:deflects_projectiles", "minecraft:immune_to_infested", "minecraft:immune_to_oozing", "minecraft:no_anger_from_wind_charge");
        this.tagRewriter.addTag(RegistryType.ENCHANTMENT, "minecraft:curse", 10, 41);
        this.tagRewriter.addEmptyTags(RegistryType.ENCHANTMENT, "double_trade_price", "in_enchanting_table", "non_treasure", "on_mob_spawn_equipment", "on_random_loot", "on_traded_equipment", "prevents_bee_spawns_when_mining", "prevents_decorated_pot_shattering", "prevents_ice_melting", "prevents_infested_spawns", "smelts_loot", "tooltip_order", "tradeable", "treasure", "exclusive_set/armor", "exclusive_set/boots", "exclusive_set/bow", "exclusive_set/crossbow", "exclusive_set/damage", "exclusive_set/mining", "exclusive_set/riptide");
    }

    @Override
    public void init(UserConnection connection) {
        this.addEntityTracker(connection, new EntityTrackerBase(connection, EntityTypes1_20_5.PLAYER));
        connection.put(new EfficiencyAttributeStorage());
        connection.put(new PlayerPositionStorage());
    }

    @Override
    public MappingData1_21 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_20_5> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_5> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_20_5> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_20_5;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_5.class, ClientboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

