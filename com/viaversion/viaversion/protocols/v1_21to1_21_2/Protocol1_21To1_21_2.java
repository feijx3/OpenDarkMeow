/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ComponentRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.EntityPacketRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ParticleRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ChunkLoadTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.EntityTracker1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.GroundFlagTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.PlayerPositionStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.TeleportAckCancelStorage;
import com.viaversion.viaversion.rewriter.AttributeRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;

public final class Protocol1_21To1_21_2
extends AbstractProtocol<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.21", "1.21.2");
    private final EntityPacketRewriter1_21_2 entityRewriter = new EntityPacketRewriter1_21_2(this);
    private final BlockItemPacketRewriter1_21_2 itemRewriter = new BlockItemPacketRewriter1_21_2(this);
    private final ParticleRewriter1_21_2 particleRewriter = new ParticleRewriter1_21_2(this);
    private final TagRewriter<ClientboundPacket1_21> tagRewriter = new TagRewriter<ClientboundPacket1_21>(this);
    private final ComponentRewriter1_21_2 componentRewriter = new ComponentRewriter1_21_2(this);
    private final SoundRewriter<ClientboundPacket1_21> soundRewriter = new SoundRewriter<ClientboundPacket1_21>(this);

    public Protocol1_21To1_21_2() {
        super(ClientboundPacket1_21.class, ClientboundPacket1_21_2.class, ServerboundPacket1_20_5.class, ServerboundPacket1_21_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.registerGeneric(ClientboundPackets1_21.UPDATE_TAGS);
        this.tagRewriter.registerGeneric(ClientboundConfigurationPackets1_21.UPDATE_TAGS);
        this.componentRewriter.registerOpenScreen1_14(ClientboundPackets1_21.OPEN_SCREEN);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21.SET_ACTION_BAR_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21.SET_TITLE_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21.SET_SUBTITLE_TEXT);
        this.componentRewriter.registerBossEvent(ClientboundPackets1_21.BOSS_EVENT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21.DISCONNECT);
        this.componentRewriter.registerTabList(ClientboundPackets1_21.TAB_LIST);
        this.componentRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_21.PLAYER_COMBAT_KILL);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21.SYSTEM_CHAT);
        this.componentRewriter.registerDisguisedChat(ClientboundPackets1_21.DISGUISED_CHAT);
        this.componentRewriter.registerPlayerChat(ClientboundPackets1_21.PLAYER_CHAT, ChatType.TYPE);
        this.componentRewriter.registerPing();
        this.particleRewriter.registerLevelParticles1_20_5(ClientboundPackets1_21.LEVEL_PARTICLES);
        this.soundRewriter.registerSound1_19_3(ClientboundPackets1_21.SOUND);
        this.soundRewriter.registerSound1_19_3(ClientboundPackets1_21.SOUND_ENTITY);
        new StatisticsRewriter<ClientboundPacket1_21>(this).register(ClientboundPackets1_21.AWARD_STATS);
        new AttributeRewriter<ClientboundPacket1_21>(this).register1_21(ClientboundPackets1_21.UPDATE_ATTRIBUTES);
        this.registerServerbound(ServerboundPackets1_21_2.CLIENT_INFORMATION, this::clientInformation);
        this.registerServerbound(ServerboundConfigurationPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.cancelServerbound(ServerboundPackets1_21_2.BUNDLE_ITEM_SELECTED);
        this.cancelServerbound(ServerboundPackets1_21_2.CLIENT_TICK_END);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper wrapper) -> {
            wrapper.passthrough(Types.UUID);
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            wrapper.read(Types.BOOLEAN);
        });
        this.registerClientbound(ClientboundPackets1_21.SET_TIME, wrapper -> {
            wrapper.passthrough(Types.LONG);
            long dayTime = wrapper.read(Types.LONG);
            boolean doDaylightCycle = true;
            if (dayTime < 0L) {
                dayTime = -dayTime;
                doDaylightCycle = false;
            }
            wrapper.write(Types.LONG, dayTime);
            wrapper.write(Types.BOOLEAN, doDaylightCycle);
        });
        this.registerClientbound(ClientboundPackets1_21.PLAYER_INFO_UPDATE, wrapper -> {
            BitSet actions = wrapper.passthroughAndMap(Types.PROFILE_ACTIONS_ENUM1_19_3, Types.PROFILE_ACTIONS_ENUM1_21_2);
            if (!actions.get(5)) {
                return;
            }
            int entries = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < entries; ++i2) {
                wrapper.passthrough(Types.UUID);
                if (actions.get(0)) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (actions.get(1) && wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    wrapper.passthrough(Types.UUID);
                    wrapper.passthrough(Types.PROFILE_KEY);
                }
                if (actions.get(2)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                if (actions.get(3)) {
                    wrapper.passthrough(Types.BOOLEAN);
                }
                if (actions.get(4)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                this.componentRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            }
        });
        this.appendClientbound(ClientboundPackets1_21.UPDATE_ATTRIBUTES, wrapper -> {
            wrapper.resetReader();
            int entityId = wrapper.passthrough(Types.VAR_INT);
            EntityTracker1_21_2 entityTracker = (EntityTracker1_21_2)wrapper.user().getEntityTracker(Protocol1_21To1_21_2.class);
            if (entityId != entityTracker.clientEntityId()) {
                return;
            }
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                int attributeId = wrapper.passthrough(Types.VAR_INT);
                if (attributeId == 18) {
                    double base = wrapper.passthrough(Types.DOUBLE);
                    int modifierSize = wrapper.passthrough(Types.VAR_INT);
                    Int2ObjectOpenHashMap attributeModifiers = new Int2ObjectOpenHashMap();
                    for (int j2 = 0; j2 < modifierSize; ++j2) {
                        String modifierId = wrapper.passthrough(Types.STRING);
                        double amount = wrapper.passthrough(Types.DOUBLE);
                        byte operation = wrapper.passthrough(Types.BYTE);
                        attributeModifiers.computeIfAbsent((int)operation, k2 -> new HashMap()).put(modifierId, amount);
                    }
                    double v1 = base;
                    for (Double value : attributeModifiers.getOrDefault(0, Collections.emptyMap()).values()) {
                        v1 += value.doubleValue();
                    }
                    double v2 = v1;
                    for (Double value : attributeModifiers.getOrDefault(1, Collections.emptyMap()).values()) {
                        v2 += v1 * value;
                    }
                    for (Double value : attributeModifiers.getOrDefault(2, Collections.emptyMap()).values()) {
                        v2 *= 1.0 + value;
                    }
                    entityTracker.setPlayerMaxHealthAttributeValue(Math.max(1.0, Math.min(1024.0, v2)));
                    continue;
                }
                wrapper.passthrough(Types.DOUBLE);
                int modifierSize = wrapper.passthrough(Types.VAR_INT);
                for (int j3 = 0; j3 < modifierSize; ++j3) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.DOUBLE);
                    wrapper.passthrough(Types.BYTE);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_21.BUNDLE_DELIMITER, wrapper -> wrapper.user().get(BundleStateTracker.class).toggleBundling());
        this.registerServerbound(ServerboundPackets1_21_2.PONG, wrapper -> {
            int id = wrapper.passthrough(Types.INT);
            PlayerPositionStorage playerPositionStorage = wrapper.user().get(PlayerPositionStorage.class);
            if (playerPositionStorage != null && playerPositionStorage.checkPong(id)) {
                wrapper.cancel();
            }
        });
    }

    private void clientInformation(PacketWrapper wrapper) {
        wrapper.passthrough(Types.STRING);
        wrapper.passthrough(Types.BYTE);
        wrapper.passthrough(Types.VAR_INT);
        wrapper.passthrough(Types.BOOLEAN);
        wrapper.passthrough(Types.UNSIGNED_BYTE);
        wrapper.passthrough(Types.VAR_INT);
        wrapper.passthrough(Types.BOOLEAN);
        wrapper.passthrough(Types.BOOLEAN);
        wrapper.read(Types.VAR_INT);
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_21_2.initialize(this);
        VersionedTypes.V1_21_2.particle.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust_pillar", ParticleType.Readers.BLOCK).reader("falling_dust", ParticleType.Readers.BLOCK).reader("block_crumble", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST1_21_2).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION1_21_2).reader("vibration", ParticleType.Readers.VIBRATION1_20_3).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK).reader("entity_effect", ParticleType.Readers.COLOR).reader("trail", ParticleType.Readers.TRAIL1_21_2).reader("item", ParticleType.Readers.item(VersionedTypes.V1_21_2.item));
        VersionedTypes.V1_21_2.structuredData.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE, StructuredDataKey.UNBREAKABLE1_20_5, StructuredDataKey.RARITY, StructuredDataKey.HIDE_TOOLTIP, StructuredDataKey.DAMAGE_RESISTANT, StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS1_20_5, StructuredDataKey.CAN_PLACE_ON1_20_5, StructuredDataKey.CAN_BREAK1_20_5, StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, StructuredDataKey.DYED_COLOR1_20_5, StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT, StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_2, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA, StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA, StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.PROFILE, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES, StructuredDataKey.LOCK, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL1_20_5, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.ITEM_MODEL, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION);
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection connection) {
        this.addEntityTracker(connection, new EntityTracker1_21_2(connection));
        connection.put(new BundleStateTracker());
        connection.put(new GroundFlagTracker());
        connection.put(new TeleportAckCancelStorage());
        ProtocolVersion protocolVersion = connection.getProtocolInfo().protocolVersion();
        if (protocolVersion.olderThan(ProtocolVersion.v1_21_4)) {
            connection.put(new PlayerPositionStorage());
        }
        if (protocolVersion.equals(ProtocolVersion.v1_21_2)) {
            connection.put(new ChunkLoadTracker());
        }
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_2 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter1_21_2 getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public ComponentRewriter getComponentRewriter() {
        return this.componentRewriter;
    }

    public SoundRewriter<ClientboundPacket1_21> getSoundRewriter() {
        return this.soundRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

