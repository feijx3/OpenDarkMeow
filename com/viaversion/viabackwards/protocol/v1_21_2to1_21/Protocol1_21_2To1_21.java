/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.ComponentRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.EntityPacketRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.ParticleRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.InventoryStateIdStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.ItemTagStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.RecipeStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.AttributeRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.ProtocolUtil;

public final class Protocol1_21_2To1_21
extends BackwardsProtocol<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.2", "1.21", Protocol1_21To1_21_2.class);
    private final EntityPacketRewriter1_21_2 entityRewriter = new EntityPacketRewriter1_21_2(this);
    private final BlockItemPacketRewriter1_21_2 itemRewriter = new BlockItemPacketRewriter1_21_2(this);
    private final ParticleRewriter1_21_2 particleRewriter = new ParticleRewriter1_21_2(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_21_2> translatableRewriter = new ComponentRewriter1_21_2(this);
    private final TagRewriter<ClientboundPacket1_21_2> tagRewriter = new TagRewriter<ClientboundPacket1_21_2>(this);

    public Protocol1_21_2To1_21() {
        super(ClientboundPacket1_21_2.class, ClientboundPacket1_21.class, ServerboundPacket1_21_2.class, ServerboundPacket1_20_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_21_2.UPDATE_TAGS, this::storeTags);
        this.registerClientbound(ClientboundConfigurationPackets1_21.UPDATE_TAGS, this::storeTags);
        SoundRewriter<ClientboundPacket1_21_2> soundRewriter = new SoundRewriter<ClientboundPacket1_21_2>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_2.SOUND);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_2.SOUND_ENTITY);
        soundRewriter.registerStopSound(ClientboundPackets1_21_2.STOP_SOUND);
        this.particleRewriter.registerLevelParticles1_20_5(ClientboundPackets1_21_2.LEVEL_PARTICLES);
        new StatisticsRewriter<ClientboundPacket1_21_2>(this).register(ClientboundPackets1_21_2.AWARD_STATS);
        new AttributeRewriter<ClientboundPacket1_21_2>(this).register1_21(ClientboundPackets1_21_2.UPDATE_ATTRIBUTES);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_ACTION_BAR_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_TITLE_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_SUBTITLE_TEXT);
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_21_2.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_2.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_21_2.TAB_LIST);
        this.translatableRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_21_2.PLAYER_COMBAT_KILL);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_2.SYSTEM_CHAT);
        this.translatableRewriter.registerDisguisedChat(ClientboundPackets1_21_2.DISGUISED_CHAT);
        this.translatableRewriter.registerPlayerChat(ClientboundPackets1_21_2.PLAYER_CHAT, ChatType.TYPE);
        this.translatableRewriter.registerPing();
        this.registerServerbound(ServerboundPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.registerServerbound(ServerboundConfigurationPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.registerClientbound(ClientboundConfigurationPackets1_21.UPDATE_ENABLED_FEATURES, wrapper -> {
            String[] enabledFeatures = wrapper.read(Types.STRING_ARRAY);
            wrapper.write(Types.STRING_ARRAY, ArrayUtil.add(enabledFeatures, "bundle"));
        });
        this.cancelClientbound(ClientboundPackets1_21_2.MOVE_MINECART_ALONG_TRACK);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper wrapper) -> {
            wrapper.passthrough(Types.UUID);
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            wrapper.write(Types.BOOLEAN, true);
        });
        this.registerClientbound(ClientboundPackets1_21_2.SET_TIME, wrapper -> {
            wrapper.passthrough(Types.LONG);
            long dayTime = wrapper.read(Types.LONG);
            boolean daylightCycle = wrapper.read(Types.BOOLEAN);
            if (!daylightCycle) {
                dayTime = dayTime == 0L ? -1L : -dayTime;
            }
            wrapper.write(Types.LONG, dayTime);
        });
    }

    private void storeTags(PacketWrapper wrapper) {
        this.tagRewriter.handleGeneric(wrapper);
        wrapper.resetReader();
        wrapper.user().get(ItemTagStorage.class).readItemTags(wrapper);
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
        wrapper.write(Types.VAR_INT, 0);
    }

    @Override
    public void init(UserConnection user) {
        this.addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_20_5.PLAYER));
        user.put(new InventoryStateIdStorage());
        user.put(new ItemTagStorage());
        user.put(new RecipeStorage(this));
        user.put(new PlayerStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
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
    public JsonNBTComponentRewriter<ClientboundPacket1_21_2> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

