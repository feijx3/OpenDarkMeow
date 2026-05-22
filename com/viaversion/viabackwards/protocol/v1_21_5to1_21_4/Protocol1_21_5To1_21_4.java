/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.BlockItemPacketRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.EntityPacketRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HashedItemConverterStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.ProtocolUtil;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={2.class, 1.class})
public final class Protocol1_21_5To1_21_4
extends BackwardsProtocol<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.5", "1.21.4", Protocol1_21_4To1_21_5.class);
    private final EntityPacketRewriter1_21_5 entityRewriter = new EntityPacketRewriter1_21_5(this);
    private final BlockItemPacketRewriter1_21_5 itemRewriter = new BlockItemPacketRewriter1_21_5(this);
    private final ParticleRewriter<ClientboundPacket1_21_5> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_5>((Protocol)this){

        @Override
        public void rewriteParticle(UserConnection connection, Particle particle) {
            if (particle.id() == MAPPINGS.getParticleMappings().id("tinted_leaves")) {
                particle.getArguments().clear();
            }
            super.rewriteParticle(connection, particle);
        }
    };
    private final ComponentRewriter1_21_5 translatableRewriter = new ComponentRewriter1_21_5(this);
    private final TagRewriter<ClientboundPacket1_21_5> tagRewriter = new TagRewriter<ClientboundPacket1_21_5>(this);

    public Protocol1_21_5To1_21_4() {
        super(ClientboundPacket1_21_5.class, ClientboundPacket1_21_2.class, ServerboundPacket1_21_5.class, ServerboundPacket1_21_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.registerGeneric(ClientboundPackets1_21_5.UPDATE_TAGS);
        this.tagRewriter.registerGeneric(ClientboundConfigurationPackets1_21.UPDATE_TAGS);
        SoundRewriter<ClientboundPacket1_21_5> soundRewriter = new SoundRewriter<ClientboundPacket1_21_5>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_5.SOUND);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_5.SOUND_ENTITY);
        soundRewriter.registerStopSound(ClientboundPackets1_21_5.STOP_SOUND);
        new StatisticsRewriter<ClientboundPacket1_21_5>(this).register(ClientboundPackets1_21_5.AWARD_STATS);
        this.translatableRewriter.registerOpenScreen1_14(ClientboundPackets1_21_5.OPEN_SCREEN);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_5.SET_ACTION_BAR_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_5.SET_TITLE_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_5.SET_SUBTITLE_TEXT);
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_21_5.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_5.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_21_5.TAB_LIST);
        this.translatableRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_21_5.PLAYER_COMBAT_KILL);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_5.SYSTEM_CHAT);
        this.translatableRewriter.registerDisguisedChat(ClientboundPackets1_21_5.DISGUISED_CHAT);
        this.translatableRewriter.registerPlayerInfoUpdate1_21_4(ClientboundPackets1_21_5.PLAYER_INFO_UPDATE);
        this.translatableRewriter.registerPing();
        this.particleRewriter.registerLevelParticles1_21_4(ClientboundPackets1_21_5.LEVEL_PARTICLES);
        this.particleRewriter.registerExplode1_21_2(ClientboundPackets1_21_5.EXPLODE);
        new CommandRewriter1_19_4<ClientboundPacket1_21_5>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper wrapper, String argumentType) {
                if (argumentType.equals("minecraft:resource")) {
                    String resource = wrapper.read(Types.STRING);
                    if (Key.equals(resource, "test_instance")) {
                        resource = "minecraft:item";
                    }
                    wrapper.write(Types.STRING, resource);
                } else if (argumentType.equals("minecraft:resource_selector")) {
                    wrapper.read(Types.STRING);
                    wrapper.write(Types.VAR_INT, 1);
                } else {
                    super.handleArgument(wrapper, argumentType);
                }
            }
        }.registerDeclareCommands1_19(ClientboundPackets1_21_5.COMMANDS);
        this.registerClientbound(ClientboundPackets1_21_5.PLAYER_CHAT, wrapper -> {
            wrapper.read(Types.VAR_INT);
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
            this.translatableRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            int filterMaskType = wrapper.passthrough(Types.VAR_INT);
            if (filterMaskType == 2) {
                wrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            wrapper.passthrough(ChatType.TYPE);
            this.translatableRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            this.translatableRewriter.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
        });
        this.registerServerbound(ServerboundPackets1_21_4.CHAT_COMMAND_SIGNED, wrapper -> {
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.LONG);
            int signatures = Limit.max(wrapper.passthrough(Types.VAR_INT), 8);
            for (int i2 = 0; i2 < signatures; ++i2) {
                wrapper.passthrough(Types.STRING);
                wrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.ACKNOWLEDGED_BIT_SET);
            wrapper.write(Types.BYTE, (byte)0);
        });
        this.registerServerbound(ServerboundPackets1_21_4.CHAT, wrapper -> {
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.ACKNOWLEDGED_BIT_SET);
            wrapper.write(Types.BYTE, (byte)0);
        });
        this.cancelClientbound(ClientboundPackets1_21_5.TEST_INSTANCE_BLOCK_STATUS);
    }

    @Override
    public void init(UserConnection user) {
        this.addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_21_4.PLAYER));
        user.put(new HashedItemConverterStorage(this));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_5 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_5 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_5> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_21_5 getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_5> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> types() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2> mappedTypes() {
        return VersionedTypes.V1_21_4;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_5.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

