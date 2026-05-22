/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.template;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.template.BlockItemPacketRewriter1_99;
import com.viaversion.viaversion.protocols.template.ComponentRewriter1_99;
import com.viaversion.viaversion.protocols.template.EntityPacketRewriter1_99;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.AttributeRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.SerializerVersion;

final class Protocol1_98To1_99
extends AbstractProtocol<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_4> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.98", "1.99");
    private final EntityPacketRewriter1_99 entityRewriter = new EntityPacketRewriter1_99(this);
    private final BlockItemPacketRewriter1_99 itemRewriter = new BlockItemPacketRewriter1_99(this);
    private final ParticleRewriter<ClientboundPacket1_21_2> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_2>(this);
    private final TagRewriter<ClientboundPacket1_21_2> tagRewriter = new TagRewriter<ClientboundPacket1_21_2>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_2> componentRewriter = new ComponentRewriter1_99(this);

    public Protocol1_98To1_99() {
        super(ClientboundPacket1_21_2.class, ClientboundPacket1_21_2.class, ServerboundPacket1_21_4.class, ServerboundPacket1_21_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.registerGeneric(ClientboundPackets1_21_2.UPDATE_TAGS);
        this.tagRewriter.registerGeneric(ClientboundConfigurationPackets1_21.UPDATE_TAGS);
        this.componentRewriter.registerOpenScreen1_14(ClientboundPackets1_21_2.OPEN_SCREEN);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_ACTION_BAR_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_TITLE_TEXT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21_2.SET_SUBTITLE_TEXT);
        this.componentRewriter.registerBossEvent(ClientboundPackets1_21_2.BOSS_EVENT);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21_2.DISCONNECT);
        this.componentRewriter.registerTabList(ClientboundPackets1_21_2.TAB_LIST);
        this.componentRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_21_2.PLAYER_COMBAT_KILL);
        this.componentRewriter.registerPlayerInfoUpdate1_21_4(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE);
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_21_2.SYSTEM_CHAT);
        this.componentRewriter.registerDisguisedChat(ClientboundPackets1_21_2.DISGUISED_CHAT);
        this.componentRewriter.registerPlayerChat1_21_5(ClientboundPackets1_21_2.PLAYER_CHAT);
        this.componentRewriter.registerPing();
        this.particleRewriter.registerLevelParticles1_21_4(ClientboundPackets1_21_2.LEVEL_PARTICLES);
        this.particleRewriter.registerExplode1_21_2(ClientboundPackets1_21_2.EXPLODE);
        SoundRewriter<ClientboundPacket1_21_2> soundRewriter = new SoundRewriter<ClientboundPacket1_21_2>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_2.SOUND);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_2.SOUND_ENTITY);
        new StatisticsRewriter<ClientboundPacket1_21_2>(this).register(ClientboundPackets1_21_2.AWARD_STATS);
        new AttributeRewriter<ClientboundPacket1_21_2>(this).register1_21(ClientboundPackets1_21_2.UPDATE_ATTRIBUTES);
    }

    @Override
    protected void onMappingDataLoaded() {
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection connection) {
        this.addEntityTracker(connection, new EntityTrackerBase(connection, EntityTypes1_21_4.PLAYER));
        this.addItemHasher(connection, new ItemHasherBase(this, connection, SerializerVersion.V1_21_6, SerializerVersion.V1_21_6));
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_99 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_99 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_2> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> types() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> mappedTypes() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_4> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_4>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

