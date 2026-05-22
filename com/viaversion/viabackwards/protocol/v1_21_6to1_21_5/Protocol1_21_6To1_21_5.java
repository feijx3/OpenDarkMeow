/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.ChestDialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.DialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.BlockItemPacketRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.ComponentRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.EntityPacketRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ServerLinks;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.AttributeRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class Protocol1_21_6To1_21_5
extends BackwardsProtocol<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.6", "1.21.5", Protocol1_21_5To1_21_6.class);
    private final EntityPacketRewriter1_21_6 entityRewriter = new EntityPacketRewriter1_21_6(this);
    private final BlockItemPacketRewriter1_21_6 itemRewriter = new BlockItemPacketRewriter1_21_6(this);
    private final ParticleRewriter<ClientboundPacket1_21_6> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_6>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_6> translatableRewriter = new ComponentRewriter1_21_6(this);
    private final TagRewriter<ClientboundPacket1_21_6> tagRewriter = new TagRewriter<ClientboundPacket1_21_6>(this);

    public Protocol1_21_6To1_21_5() {
        super(ClientboundPacket1_21_6.class, ClientboundPacket1_21_5.class, ServerboundPacket1_21_6.class, ServerboundPacket1_21_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_21_6.UPDATE_TAGS, this::updateTags);
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.UPDATE_TAGS, this::updateTags);
        SoundRewriter<ClientboundPacket1_21_6> soundRewriter = new SoundRewriter<ClientboundPacket1_21_6>(this);
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_6.SOUND);
        this.appendClientbound(ClientboundPackets1_21_6.SOUND, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            this.fixSoundSource(wrapper);
        });
        soundRewriter.registerSound1_19_3(ClientboundPackets1_21_6.SOUND_ENTITY);
        this.appendClientbound(ClientboundPackets1_21_6.SOUND_ENTITY, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            this.fixSoundSource(wrapper);
        });
        soundRewriter.registerStopSound(ClientboundPackets1_21_6.STOP_SOUND);
        this.appendClientbound(ClientboundPackets1_21_6.STOP_SOUND, wrapper -> {
            byte flags = wrapper.get(Types.BYTE, 0);
            if ((flags & 1) != 0) {
                this.fixSoundSource(wrapper);
            }
        });
        new StatisticsRewriter<ClientboundPacket1_21_6>(this).register(ClientboundPackets1_21_6.AWARD_STATS);
        new AttributeRewriter<ClientboundPacket1_21_6>(this).register1_21(ClientboundPackets1_21_6.UPDATE_ATTRIBUTES);
        new CommandRewriter1_19_4<ClientboundPacket1_21_6>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper wrapper, String argumentType) {
                if (argumentType.equals("minecraft:hex_color") || argumentType.equals("minecraft:dialog")) {
                    wrapper.write(Types.VAR_INT, 0);
                } else {
                    super.handleArgument(wrapper, argumentType);
                }
            }
        }.registerDeclareCommands1_19(ClientboundPackets1_21_6.COMMANDS);
        this.translatableRewriter.registerOpenScreen1_14(ClientboundPackets1_21_6.OPEN_SCREEN);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_6.SET_ACTION_BAR_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_6.SET_TITLE_TEXT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_6.SET_SUBTITLE_TEXT);
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_21_6.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_6.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_21_6.TAB_LIST);
        this.translatableRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_21_6.PLAYER_COMBAT_KILL);
        this.translatableRewriter.registerPlayerInfoUpdate1_21_4(ClientboundPackets1_21_6.PLAYER_INFO_UPDATE);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_21_6.SYSTEM_CHAT);
        this.translatableRewriter.registerDisguisedChat(ClientboundPackets1_21_6.DISGUISED_CHAT);
        this.translatableRewriter.registerPlayerChat1_21_5(ClientboundPackets1_21_6.PLAYER_CHAT);
        this.translatableRewriter.registerPing();
        this.particleRewriter.registerLevelParticles1_21_4(ClientboundPackets1_21_6.LEVEL_PARTICLES);
        this.particleRewriter.registerExplode1_21_2(ClientboundPackets1_21_6.EXPLODE);
        this.registerClientbound(ClientboundPackets1_21_6.CHANGE_DIFFICULTY, wrapper -> {
            int difficulty = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.UNSIGNED_BYTE, (short)difficulty);
        });
        this.registerServerbound(ServerboundPackets1_21_5.CHANGE_DIFFICULTY, wrapper -> {
            short difficulty = wrapper.read(Types.UNSIGNED_BYTE);
            wrapper.write(Types.VAR_INT, Integer.valueOf(difficulty));
        });
        this.registerClientbound(ClientboundPackets1_21_6.SHOW_DIALOG, null, (PacketWrapper wrapper) -> {
            wrapper.cancel();
            RegistryAndTags registryAndTags = wrapper.user().get(RegistryAndTags.class);
            ServerLinks serverLinks = wrapper.user().get(ServerLinks.class);
            int id = wrapper.read(Types.VAR_INT) - 1;
            CompoundTag tag = id == -1 ? (CompoundTag)wrapper.read(Types.TAG) : registryAndTags.fromRegistry(id);
            DialogViewProvider provider = Via.getManager().getProviders().get(DialogViewProvider.class);
            provider.openDialog(wrapper.user(), new Dialog(registryAndTags, serverLinks, tag));
        });
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.SHOW_DIALOG, null, (PacketWrapper wrapper) -> {
            wrapper.cancel();
            RegistryAndTags registryAndTags = wrapper.user().get(RegistryAndTags.class);
            ServerLinks serverLinks = wrapper.user().get(ServerLinks.class);
            CompoundTag tag = (CompoundTag)wrapper.read(Types.TAG);
            DialogViewProvider provider = Via.getManager().getProviders().get(DialogViewProvider.class);
            provider.openDialog(wrapper.user(), new Dialog(registryAndTags, serverLinks, tag));
        });
        this.registerClientbound(ClientboundPackets1_21_6.CLEAR_DIALOG, null, this::clearDialog);
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.CLEAR_DIALOG, null, this::clearDialog);
        this.registerClientbound(ClientboundPackets1_21_6.SERVER_LINKS, this::storeServerLinks);
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.SERVER_LINKS, this::storeServerLinks);
        this.registerServerbound(ServerboundPackets1_21_5.CHAT_COMMAND, wrapper -> {
            String command = wrapper.passthrough(Types.STRING);
            ClickEvents clickEvents = wrapper.user().get(ClickEvents.class);
            if (clickEvents.handleChatCommand(wrapper.user(), command)) {
                wrapper.cancel();
            }
        });
        this.registerServerbound(ServerboundPackets1_21_5.CONTAINER_CLOSE, wrapper -> {
            ChestDialogStorage storage = wrapper.user().get(ChestDialogStorage.class);
            if (storage == null) {
                return;
            }
            ChestDialogViewProvider provider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            if (storage.phase() == ChestDialogStorage.Phase.ANVIL_VIEW) {
                wrapper.cancel();
                provider.openChestView(wrapper.user(), storage, ChestDialogStorage.Phase.DIALOG_VIEW);
                return;
            }
            if (storage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
                wrapper.cancel();
                if (storage.closeButtonEnabled()) {
                    provider.openChestView(wrapper.user(), storage, ChestDialogStorage.Phase.DIALOG_VIEW);
                } else {
                    provider.openChestView(wrapper.user(), storage, ChestDialogStorage.Phase.WAITING_FOR_RESPONSE);
                }
                return;
            }
            boolean allowClosing = storage.allowClosing();
            if (!allowClosing) {
                wrapper.cancel();
                if (storage.dialog().canCloseWithEscape()) {
                    provider.clickButton(wrapper.user(), Dialog.AfterAction.CLOSE, storage.dialog().actionButton());
                } else {
                    provider.openChestView(wrapper.user(), storage, ChestDialogStorage.Phase.DIALOG_VIEW);
                }
            }
            storage.setAllowClosing(false);
        });
        this.registerServerbound(ServerboundPackets1_21_5.RENAME_ITEM, wrapper -> {
            ChestDialogStorage storage = wrapper.user().get(ChestDialogStorage.class);
            if (storage == null || storage.phase() != ChestDialogStorage.Phase.ANVIL_VIEW) {
                return;
            }
            wrapper.cancel();
            String name = wrapper.read(Types.STRING);
            ChestDialogViewProvider provider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            provider.updateAnvilText(wrapper.user(), name);
        });
        this.appendServerbound(ServerboundPackets1_21_5.CONTAINER_CLICK, wrapper -> {
            ChestDialogViewProvider provider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            if (provider == null) {
                return;
            }
            int containerId = wrapper.get(Types.VAR_INT, 0);
            short slot = wrapper.get(Types.SHORT, 0);
            byte button = wrapper.get(Types.BYTE, 0);
            int mode = wrapper.get(Types.VAR_INT, 2);
            if (provider.clickDialog(wrapper.user(), containerId, slot, button, mode)) {
                wrapper.cancel();
            }
        });
        this.cancelClientbound(ClientboundPackets1_21_6.TRACKED_WAYPOINT);
    }

    private void fixSoundSource(PacketWrapper wrapper) {
        int source = wrapper.get(Types.VAR_INT, 0);
        if (source == 10) {
            wrapper.set(Types.VAR_INT, 0, 0);
        }
    }

    private void updateTags(PacketWrapper wrapper) {
        this.tagRewriter.handleGeneric(wrapper);
        wrapper.resetReader();
        RegistryAndTags registryAndTags = wrapper.user().get(RegistryAndTags.class);
        int length = wrapper.passthrough(Types.VAR_INT);
        for (int i2 = 0; i2 < length; ++i2) {
            int j2;
            int tagsSize;
            String registryKey = wrapper.read(Types.STRING);
            boolean dialog = "dialog".equals(Key.stripMinecraftNamespace(registryKey));
            if (dialog) {
                tagsSize = wrapper.read(Types.VAR_INT);
                for (j2 = 0; j2 < tagsSize; ++j2) {
                    String key = wrapper.read(Types.STRING);
                    int[] ids = wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                    registryAndTags.storeTags(key, ids);
                }
                continue;
            }
            wrapper.write(Types.STRING, registryKey);
            tagsSize = wrapper.passthrough(Types.VAR_INT);
            for (j2 = 0; j2 < tagsSize; ++j2) {
                wrapper.passthrough(Types.STRING);
                wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            }
        }
        if (registryAndTags.tagsSent()) {
            wrapper.set(Types.VAR_INT, 0, length - 1);
        }
    }

    private void clearDialog(PacketWrapper wrapper) {
        wrapper.cancel();
        DialogViewProvider provider = Via.getManager().getProviders().get(DialogViewProvider.class);
        provider.closeDialog(wrapper.user());
    }

    private void storeServerLinks(PacketWrapper wrapper) {
        ServerLinks serverLinks = new ServerLinks();
        int length = wrapper.passthrough(Types.VAR_INT);
        for (int i2 = 0; i2 < length; ++i2) {
            String url;
            if (wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int id = wrapper.passthrough(Types.VAR_INT);
                url = wrapper.passthrough(Types.STRING);
                serverLinks.storeLink(id, url);
                continue;
            }
            Tag tag = wrapper.passthrough(Types.COMPOUND_TAG);
            url = wrapper.passthrough(Types.STRING);
            serverLinks.storeLink(tag, url);
        }
        wrapper.user().put(serverLinks);
    }

    @Override
    public void init(UserConnection user) {
        this.addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_21_6.PLAYER));
        this.addItemHasher(user, new ItemHasherBase(this, user, SerializerVersion.V1_21_5, SerializerVersion.V1_21_5));
        user.put(new RegistryAndTags());
        user.put(new ClickEvents());
    }

    @Override
    public void register(ViaProviders providers) {
        providers.register(DialogViewProvider.class, new ChestDialogViewProvider(this));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_6 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_6 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_6> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_6> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_6> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_6;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_6.class, ClientboundConfigurationPackets1_21_6.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_5.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_6.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

