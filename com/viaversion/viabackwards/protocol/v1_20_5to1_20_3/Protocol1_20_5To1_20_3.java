/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.Types1_20_3;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.provider.TransferProvider;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter.BlockItemPacketRewriter1_20_5;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter.ComponentRewriter1_20_5;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter.EntityPacketRewriter1_20_5;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.storage.CookieStorage;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.storage.RegistryDataStorage;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.storage.SecureChatStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.BannerPatternStorage;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ProtocolUtil;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class Protocol1_20_5To1_20_3
extends BackwardsProtocol<ClientboundPacket1_20_5, ClientboundPacket1_20_3, ServerboundPacket1_20_5, ServerboundPacket1_20_3> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.20.5", "1.20.3", Protocol1_20_3To1_20_5.class);
    private final EntityPacketRewriter1_20_5 entityRewriter = new EntityPacketRewriter1_20_5(this);
    private final BlockItemPacketRewriter1_20_5 itemRewriter = new BlockItemPacketRewriter1_20_5(this);
    private final ParticleRewriter<ClientboundPacket1_20_5> particleRewriter = new ParticleRewriter<ClientboundPacket1_20_5>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_20_5> translatableRewriter = new ComponentRewriter1_20_5(this);
    private final TagRewriter<ClientboundPacket1_20_5> tagRewriter = new TagRewriter<ClientboundPacket1_20_5>(this);

    public Protocol1_20_5To1_20_3() {
        super(ClientboundPacket1_20_5.class, ClientboundPacket1_20_3.class, ServerboundPacket1_20_5.class, ServerboundPacket1_20_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:axolotl_tempt_items");
        this.tagRewriter.registerGeneric(ClientboundPackets1_20_5.UPDATE_TAGS);
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.UPDATE_TAGS, wrapper -> {
            this.sendRegistryData(wrapper.user());
            this.tagRewriter.handleGeneric(wrapper);
        });
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.FINISH_CONFIGURATION, wrapper -> this.sendRegistryData(wrapper.user()));
        this.registerClientbound(ClientboundPackets1_20_5.START_CONFIGURATION, wrapper -> wrapper.user().get(RegistryDataStorage.class).clear());
        SoundRewriter<ClientboundPacket1_20_5> soundRewriter = new SoundRewriter<ClientboundPacket1_20_5>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_20_5.SOUND);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_20_5.SOUND_ENTITY);
        soundRewriter.registerStopSound(ClientboundPackets1_20_5.STOP_SOUND);
        new StatisticsRewriter<ClientboundPacket1_20_5>(this).register(ClientboundPackets1_20_5.AWARD_STATS);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_ACTION_BAR_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_TITLE_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.SET_SUBTITLE_TEXT);
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_20_5.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_20_5.TAB_LIST);
        this.translatableRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_20_5.PLAYER_COMBAT_KILL);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.SYSTEM_CHAT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_20_5.DISGUISED_CHAT);
        this.translatableRewriter.registerPlayerChat(ClientboundPackets1_20_5.PLAYER_CHAT, Types.VAR_INT);
        this.translatableRewriter.registerPlayerInfoUpdate1_20_3(ClientboundPackets1_20_5.PLAYER_INFO_UPDATE);
        this.translatableRewriter.registerPing();
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketWrapper wrapper) -> {
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            wrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            wrapper.read(Types.BOOLEAN);
        });
        this.registerClientbound(ClientboundPackets1_20_5.SERVER_DATA, wrapper -> {
            wrapper.passthrough(Types.TAG);
            wrapper.passthrough(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
            wrapper.write(Types.BOOLEAN, wrapper.user().get(SecureChatStorage.class).enforcesSecureChat());
        });
        this.registerServerbound(ServerboundPackets1_20_3.CHAT_COMMAND, ServerboundPackets1_20_5.CHAT_COMMAND_SIGNED);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.COOKIE_REQUEST.getId(), -1, wrapper -> this.handleCookieRequest(wrapper, ServerboundLoginPackets.COOKIE_RESPONSE));
        this.cancelClientbound(ClientboundConfigurationPackets1_20_5.RESET_CHAT);
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.COOKIE_REQUEST, null, (PacketWrapper wrapper) -> this.handleCookieRequest(wrapper, ServerboundConfigurationPackets1_20_5.COOKIE_RESPONSE));
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.STORE_COOKIE, null, this::handleStoreCookie);
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.TRANSFER, null, this::handleTransfer);
        this.registerClientbound(ClientboundPackets1_20_5.COOKIE_REQUEST, null, (PacketWrapper wrapper) -> this.handleCookieRequest(wrapper, ServerboundPackets1_20_5.COOKIE_RESPONSE));
        this.registerClientbound(ClientboundPackets1_20_5.STORE_COOKIE, null, this::handleStoreCookie);
        this.registerClientbound(ClientboundPackets1_20_5.TRANSFER, null, this::handleTransfer);
        this.registerClientbound(ClientboundConfigurationPackets1_20_5.SELECT_KNOWN_PACKS, null, (PacketWrapper wrapper) -> {
            wrapper.cancel();
            PacketWrapper response = wrapper.create(ServerboundConfigurationPackets1_20_5.SELECT_KNOWN_PACKS);
            response.write(Types.VAR_INT, 0);
            response.sendToServer(Protocol1_20_5To1_20_3.class);
        });
        new CommandRewriter1_19_4<ClientboundPacket1_20_5>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper wrapper, String argumentType) {
                if (argumentType.equals("minecraft:loot_table") || argumentType.equals("minecraft:loot_predicate") || argumentType.equals("minecraft:loot_modifier")) {
                    wrapper.write(Types.VAR_INT, 0);
                } else {
                    super.handleArgument(wrapper, argumentType);
                }
            }
        }.registerDeclareCommands1_19(ClientboundPackets1_20_5.COMMANDS);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper wrapper) -> {
            wrapper.passthrough(Types.UUID);
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            wrapper.read(Types.BOOLEAN);
        });
        this.cancelClientbound(ClientboundPackets1_20_5.PROJECTILE_POWER);
        this.cancelClientbound(ClientboundPackets1_20_5.DEBUG_SAMPLE);
    }

    private void sendRegistryData(UserConnection connection) {
        RegistryDataStorage registryDataStorage = connection.get(RegistryDataStorage.class);
        CompoundTag registryData = registryDataStorage.registryData();
        if (!registryDataStorage.sentRegistryData() && !registryData.isEmpty()) {
            PacketWrapper registryDataPacket = PacketWrapper.create(ClientboundConfigurationPackets1_20_3.REGISTRY_DATA, connection);
            registryDataPacket.write(Types.COMPOUND_TAG, registryData.copy());
            registryDataPacket.send(Protocol1_20_5To1_20_3.class);
            registryDataStorage.setSentRegistryData();
        }
    }

    private void handleStoreCookie(PacketWrapper wrapper) {
        wrapper.cancel();
        String resourceLocation = wrapper.read(Types.STRING);
        byte[] data = wrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
        if (data.length > 5120) {
            throw new IllegalArgumentException("Cookie data too large");
        }
        wrapper.user().get(CookieStorage.class).cookies().put(resourceLocation, data);
    }

    private void handleCookieRequest(PacketWrapper wrapper, ServerboundPacketType responseType) {
        wrapper.cancel();
        String resourceLocation = wrapper.read(Types.STRING);
        byte[] data = wrapper.user().get(CookieStorage.class).cookies().get(resourceLocation);
        PacketWrapper responsePacket = wrapper.create(responseType);
        responsePacket.write(Types.STRING, resourceLocation);
        responsePacket.write(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE, data);
        responsePacket.sendToServer(Protocol1_20_5To1_20_3.class);
    }

    private void handleTransfer(PacketWrapper wrapper) {
        wrapper.cancel();
        String host = wrapper.read(Types.STRING);
        int port = wrapper.read(Types.VAR_INT);
        Via.getManager().getProviders().get(TransferProvider.class).connectToServer(wrapper.user(), host, port);
    }

    @Override
    public void init(UserConnection user) {
        this.addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_20_5.PLAYER));
        user.put(new SecureChatStorage());
        user.put(new CookieStorage());
        user.put(new RegistryDataStorage());
        user.put(new BannerPatternStorage());
        user.put(new ArmorTrimStorage());
    }

    @Override
    public void register(ViaProviders providers) {
        providers.register(TransferProvider.class, TransferProvider.NOOP);
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_20_5 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_20_5 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_20_5> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_20_5> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_5> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_20_5;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return new Types1_20_3();
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_20_3, ServerboundPacket1_20_5, ServerboundPacket1_20_3> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_20_3, ServerboundPacket1_20_5, ServerboundPacket1_20_3>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_5.class, ClientboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_20_3.class, ClientboundConfigurationPackets1_20_3.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_3.class, ServerboundConfigurationPackets1_20_2.class));
    }
}

