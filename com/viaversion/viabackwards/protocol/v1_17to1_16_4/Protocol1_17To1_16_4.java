/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_17to1_16_4;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter.BlockItemPacketRewriter1_17;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter.EntityPacketRewriter1_17;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.storage.PlayerLastCursorItem;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={3.class, 2.class, 1.class})
public final class Protocol1_17To1_16_4
extends BackwardsProtocol<ClientboundPackets1_17, ClientboundPackets1_16_2, ServerboundPackets1_17, ServerboundPackets1_16_2> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.17", "1.16.2", Protocol1_16_4To1_17.class);
    private static final RegistryType[] TAG_REGISTRY_TYPES = new RegistryType[]{RegistryType.BLOCK, RegistryType.ITEM, RegistryType.FLUID, RegistryType.ENTITY};
    private static final int[] EMPTY_ARRAY = new int[0];
    private final EntityPacketRewriter1_17 entityRewriter = new EntityPacketRewriter1_17(this);
    private final BlockItemPacketRewriter1_17 blockItemPackets = new BlockItemPacketRewriter1_17(this);
    private final ParticleRewriter<ClientboundPackets1_17> particleRewriter = new ParticleRewriter<ClientboundPackets1_17>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_17> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_17>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_17> tagRewriter = new TagRewriter<ClientboundPackets1_17>(this);

    public Protocol1_17To1_16_4() {
        super(ClientboundPackets1_17.class, ClientboundPackets1_16_2.class, ServerboundPackets1_17.class, ServerboundPackets1_16_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_17.CHAT);
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_17.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_17.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_17.TAB_LIST);
        this.translatableRewriter.registerOpenScreen1_14(ClientboundPackets1_17.OPEN_SCREEN);
        this.translatableRewriter.registerPing();
        SoundRewriter<ClientboundPackets1_17> soundRewriter = new SoundRewriter<ClientboundPackets1_17>(this);
        soundRewriter.registerSound(ClientboundPackets1_17.SOUND);
        soundRewriter.registerSound(ClientboundPackets1_17.SOUND_ENTITY);
        soundRewriter.registerNamedSound(ClientboundPackets1_17.CUSTOM_SOUND);
        soundRewriter.registerStopSound(ClientboundPackets1_17.STOP_SOUND);
        this.registerClientbound(ClientboundPackets1_17.UPDATE_TAGS, wrapper -> {
            HashMap tags = new HashMap();
            int length = wrapper.read(Types.VAR_INT);
            for (int i2 = 0; i2 < length; ++i2) {
                String resourceKey = Key.stripMinecraftNamespace(wrapper.read(Types.STRING));
                ArrayList<TagData> tagList = new ArrayList<TagData>();
                tags.put(resourceKey, tagList);
                int tagLength = wrapper.read(Types.VAR_INT);
                for (int j2 = 0; j2 < tagLength; ++j2) {
                    String identifier = wrapper.read(Types.STRING);
                    int[] entries = wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                    tagList.add(new TagData(identifier, entries));
                }
            }
            for (RegistryType type : TAG_REGISTRY_TYPES) {
                List tagList = (List)tags.get(type.resourceLocation());
                if (tagList == null) {
                    wrapper.write(Types.VAR_INT, 0);
                    continue;
                }
                IdRewriteFunction rewriter = this.tagRewriter.getRewriter(type);
                wrapper.write(Types.VAR_INT, tagList.size());
                for (TagData tagData : tagList) {
                    int[] entries = tagData.entries();
                    if (rewriter != null) {
                        IntArrayList idList = new IntArrayList(entries.length);
                        for (int id : entries) {
                            int mappedId = rewriter.rewrite(id);
                            if (mappedId == -1) continue;
                            idList.add(mappedId);
                        }
                        entries = idList.toArray(EMPTY_ARRAY);
                    }
                    wrapper.write(Types.STRING, tagData.identifier());
                    wrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, entries);
                }
            }
        });
        new StatisticsRewriter<ClientboundPackets1_17>(this).register(ClientboundPackets1_17.AWARD_STATS);
        this.registerClientbound(ClientboundPackets1_17.RESOURCE_PACK, wrapper -> {
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.STRING);
            wrapper.read(Types.BOOLEAN);
            wrapper.read(Types.OPTIONAL_COMPONENT);
        });
        this.registerClientbound(ClientboundPackets1_17.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(wrapper -> wrapper.write(Types.INT, wrapper.read(Types.VAR_INT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_17.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.handler(wrapper -> wrapper.read(Types.FLOAT));
            }
        });
        this.registerClientbound(ClientboundPackets1_17.PING, null, (PacketWrapper wrapper) -> {
            wrapper.cancel();
            int id = wrapper.read(Types.INT);
            short shortId = (short)id;
            if (id == shortId && ViaBackwards.getConfig().handlePingsAsInvAcknowledgements()) {
                PacketWrapper acknowledgementPacket = wrapper.create(ClientboundPackets1_16_2.CONTAINER_ACK);
                acknowledgementPacket.write(Types.UNSIGNED_BYTE, (short)0);
                acknowledgementPacket.write(Types.SHORT, shortId);
                acknowledgementPacket.write(Types.BOOLEAN, false);
                acknowledgementPacket.send(Protocol1_17To1_16_4.class);
                return;
            }
            PacketWrapper pongPacket = wrapper.create(ServerboundPackets1_17.PONG);
            pongPacket.write(Types.INT, id);
            pongPacket.sendToServer(Protocol1_17To1_16_4.class);
        });
        this.registerServerbound(ServerboundPackets1_16_2.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(wrapper -> wrapper.write(Types.BOOLEAN, false));
            }
        });
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_TITLE_TEXT, 0);
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_SUBTITLE_TEXT, 1);
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_ACTION_BAR_TEXT, 2);
        this.mergePacket(ClientboundPackets1_17.SET_TITLES_ANIMATION, ClientboundPackets1_16_2.SET_TITLES, 3);
        this.registerClientbound(ClientboundPackets1_17.CLEAR_TITLES, ClientboundPackets1_16_2.SET_TITLES, (PacketWrapper wrapper) -> {
            if (wrapper.read(Types.BOOLEAN).booleanValue()) {
                wrapper.write(Types.VAR_INT, 5);
            } else {
                wrapper.write(Types.VAR_INT, 4);
            }
        });
        this.cancelClientbound(ClientboundPackets1_17.ADD_VIBRATION_SIGNAL);
    }

    @Override
    public void init(UserConnection user) {
        this.addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_17.PLAYER));
        user.put(new PlayerLastCursorItem());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_17> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public void mergePacket(ClientboundPackets1_17 newPacketType, ClientboundPackets1_16_2 oldPacketType, int type) {
        this.registerClientbound(newPacketType, oldPacketType, (PacketWrapper wrapper) -> wrapper.write(Types.VAR_INT, type));
    }

    private void rewriteTitlePacket(ClientboundPackets1_17 newPacketType, int type) {
        this.registerClientbound(newPacketType, ClientboundPackets1_16_2.SET_TITLES, (PacketWrapper wrapper) -> {
            wrapper.write(Types.VAR_INT, type);
            this.translatableRewriter.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
        });
    }

    public EntityPacketRewriter1_17 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_17 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_17> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_17> getTagRewriter() {
        return this.tagRewriter;
    }
}

