/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.BulkChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_1;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EffectIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.PotionIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.SoundEffectMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CommandBlockProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.HandItemProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.ClientWorld1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Optional;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={7.class, 6.class, 5.class, 4.class, 3.class, 2.class, 1.class})
public class WorldPacketRewriter1_9 {
    public static void register(Protocol1_8To1_9 protocol) {
        protocol.registerClientbound(ClientboundPackets1_8.UPDATE_SIGN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(wrapper -> {
                    for (int i2 = 0; i2 < 4; ++i2) {
                        String line = wrapper.read(Types.STRING);
                        Protocol1_8To1_9.STRING_TO_JSON.write(wrapper, line);
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_8.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.handler(wrapper -> {
                    int id = wrapper.get(Types.INT, 0);
                    id = EffectIdMappings1_9.getNewId(id);
                    wrapper.set(Types.INT, 0, id);
                });
                this.handler(wrapper -> {
                    int id = wrapper.get(Types.INT, 0);
                    if (id == 2002) {
                        int data = wrapper.get(Types.INT, 1);
                        int newData = PotionIdMappings1_9.getNewPotionID(data);
                        wrapper.set(Types.INT, 1, newData);
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_8.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(wrapper -> {
                    String name = Key.stripMinecraftNamespace(wrapper.get(Types.STRING, 0));
                    SoundEffectMappings1_9 effect = SoundEffectMappings1_9.getByName(name);
                    int catid = 0;
                    String newname = name;
                    if (effect != null) {
                        catid = effect.getCategory().getId();
                        newname = effect.getNewName();
                    }
                    wrapper.set(Types.STRING, 0, newname);
                    wrapper.write(Types.VAR_INT, catid);
                    if (!Via.getConfig().cancelBlockSounds()) {
                        return;
                    }
                    if (effect != null && effect.isBreakSound()) {
                        EntityTracker1_9 tracker = (EntityTracker1_9)wrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        int x2 = wrapper.passthrough(Types.INT);
                        int y2 = wrapper.passthrough(Types.INT);
                        int z2 = wrapper.passthrough(Types.INT);
                        if (tracker.interactedBlockRecently((int)Math.floor((double)x2 / 8.0), (int)Math.floor((double)y2 / 8.0), (int)Math.floor((double)z2 / 8.0))) {
                            wrapper.cancel();
                        }
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_8.LEVEL_CHUNK, wrapper -> {
            block6: {
                long chunkHash;
                Chunk chunk;
                ClientWorld1_9 clientWorld;
                block5: {
                    clientWorld = (ClientWorld1_9)wrapper.user().getClientWorld(Protocol1_8To1_9.class);
                    chunk = wrapper.read(ChunkType1_8.forEnvironment(clientWorld.getEnvironment()));
                    chunkHash = ChunkPosition.chunkKey(chunk.getX(), chunk.getZ());
                    if (!chunk.isFullChunk() || chunk.getBitmask() != 0) break block5;
                    wrapper.setPacketType(ClientboundPackets1_9.FORGET_LEVEL_CHUNK);
                    wrapper.write(Types.INT, chunk.getX());
                    wrapper.write(Types.INT, chunk.getZ());
                    CommandBlockProvider provider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    provider.unloadChunk(wrapper.user(), chunk.getX(), chunk.getZ());
                    clientWorld.getLoadedChunks().remove(chunkHash);
                    if (!Via.getConfig().isChunkBorderFix()) break block6;
                    for (int modX = -1; modX <= 1; ++modX) {
                        for (int modZ = -1; modZ <= 1; ++modZ) {
                            if (modX == 0 && modZ == 0) continue;
                            int chunkX = chunk.getX() + modX;
                            int chunkZ = chunk.getZ() + modZ;
                            if (clientWorld.getLoadedChunks().contains(ChunkPosition.chunkKey(chunkX, chunkZ))) continue;
                            PacketWrapper unloadChunk = wrapper.create(ClientboundPackets1_9.FORGET_LEVEL_CHUNK);
                            unloadChunk.write(Types.INT, chunkX);
                            unloadChunk.write(Types.INT, chunkZ);
                            unloadChunk.send(Protocol1_8To1_9.class);
                        }
                    }
                    break block6;
                }
                ChunkType1_9_1 chunkType = ChunkType1_9_1.forEnvironment(clientWorld.getEnvironment());
                wrapper.write(chunkType, chunk);
                clientWorld.getLoadedChunks().add(chunkHash);
                if (Via.getConfig().isChunkBorderFix()) {
                    for (int modX = -1; modX <= 1; ++modX) {
                        for (int modZ = -1; modZ <= 1; ++modZ) {
                            if (modX == 0 && modZ == 0) continue;
                            int chunkX = chunk.getX() + modX;
                            int chunkZ = chunk.getZ() + modZ;
                            if (clientWorld.getLoadedChunks().contains(ChunkPosition.chunkKey(chunkX, chunkZ))) continue;
                            PacketWrapper emptyChunk = wrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                            BaseChunk c2 = new BaseChunk(chunkX, chunkZ, true, false, 0, new ChunkSection[16], new int[256], new ArrayList<CompoundTag>());
                            emptyChunk.write(chunkType, c2);
                            emptyChunk.send(Protocol1_8To1_9.class);
                        }
                    }
                }
            }
        });
        protocol.registerClientbound(ClientboundPackets1_8.MAP_BULK_CHUNK, null, wrapper -> {
            wrapper.cancel();
            ClientWorld1_9 clientWorld = (ClientWorld1_9)wrapper.user().getClientWorld(Protocol1_8To1_9.class);
            Chunk[] chunks = wrapper.read(BulkChunkType1_8.TYPE);
            ChunkType1_9_1 chunkType = ChunkType1_9_1.forEnvironment(clientWorld.getEnvironment());
            for (Chunk chunk : chunks) {
                PacketWrapper chunkData = wrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                chunkData.write(chunkType, chunk);
                chunkData.send(Protocol1_8To1_9.class);
                clientWorld.getLoadedChunks().add(ChunkPosition.chunkKey(chunk.getX(), chunk.getZ()));
            }
            if (!Via.getConfig().isChunkBorderFix()) {
                return;
            }
            for (Chunk chunk : chunks) {
                for (int modX = -1; modX <= 1; ++modX) {
                    for (int modZ = -1; modZ <= 1; ++modZ) {
                        if (modX == 0 && modZ == 0) continue;
                        int chunkX = chunk.getX() + modX;
                        int chunkZ = chunk.getZ() + modZ;
                        if (clientWorld.getLoadedChunks().contains(ChunkPosition.chunkKey(chunkX, chunkZ))) continue;
                        PacketWrapper emptyChunk = wrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                        BaseChunk c2 = new BaseChunk(chunkX, chunkZ, true, false, 0, new ChunkSection[16], new int[256], new ArrayList<CompoundTag>());
                        emptyChunk.write(chunkType, c2);
                        emptyChunk.send(Protocol1_8To1_9.class);
                    }
                }
            }
        });
        protocol.registerClientbound(ClientboundPackets1_8.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(wrapper -> {
                    CompoundTag tag;
                    short action = wrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (action == 1 && (tag = wrapper.get(Types.NAMED_COMPOUND_TAG, 0)) != null) {
                        StringTag entityId = tag.getStringTag("EntityId");
                        if (entityId != null) {
                            String entity = entityId.getValue();
                            CompoundTag spawn = new CompoundTag();
                            spawn.putString("id", entity);
                            tag.put("SpawnData", spawn);
                        } else {
                            CompoundTag spawn = new CompoundTag();
                            spawn.putString("id", "AreaEffectCloud");
                            tag.put("SpawnData", spawn);
                        }
                    }
                    if (action == 2) {
                        CommandBlockProvider provider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                        provider.addOrUpdateBlock(wrapper.user(), wrapper.get(Types.BLOCK_POSITION1_8, 0), wrapper.get(Types.NAMED_COMPOUND_TAG, 0));
                        wrapper.cancel();
                    }
                });
            }
        });
        protocol.registerServerbound(ServerboundPackets1_9.SIGN_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(wrapper -> {
                    for (int i2 = 0; i2 < 4; ++i2) {
                        String line = wrapper.read(Types.STRING);
                        wrapper.write(Types.COMPONENT, ComponentUtil.plainToJson(line));
                    }
                });
            }
        });
        protocol.registerServerbound(ServerboundPackets1_9.PLAYER_ACTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(wrapper -> {
                    int status = wrapper.get(Types.VAR_INT, 0);
                    if (status == 6) {
                        wrapper.cancel();
                    }
                });
                this.handler(wrapper -> {
                    EntityTracker1_9 entityTracker;
                    int status = wrapper.get(Types.VAR_INT, 0);
                    if ((status == 5 || status == 4 || status == 3) && (entityTracker = (EntityTracker1_9)wrapper.user().getEntityTracker(Protocol1_8To1_9.class)).isBlocking()) {
                        entityTracker.setBlocking(false);
                        if (!Via.getConfig().isShowShieldWhenSwordInHand()) {
                            entityTracker.setSecondHand(null);
                        }
                    }
                });
            }
        });
        protocol.registerServerbound(ServerboundPackets1_9.USE_ITEM, null, wrapper -> {
            int hand = wrapper.read(Types.VAR_INT);
            wrapper.clearInputBuffer();
            wrapper.setPacketType(ServerboundPackets1_8.USE_ITEM_ON);
            wrapper.write(Types.BLOCK_POSITION1_8, new BlockPosition(-1, -1, -1));
            wrapper.write(Types.UNSIGNED_BYTE, (short)255);
            Item item = Via.getManager().getProviders().get(HandItemProvider.class).getHandItem(wrapper.user());
            if (Via.getConfig().isShieldBlocking() && wrapper.user().getProtocolInfo().protocolVersion().olderThan(ProtocolVersion.v1_21_4)) {
                boolean isSword;
                EntityTracker1_9 tracker = (EntityTracker1_9)wrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                boolean showShieldWhenSwordInHand = Via.getConfig().isShowShieldWhenSwordInHand();
                boolean bl2 = showShieldWhenSwordInHand ? tracker.hasSwordInHand() : (isSword = item != null && Protocol1_8To1_9.isSword(item.identifier()));
                if (isSword) {
                    boolean blockUsingMainHand;
                    if (hand == 0 && !tracker.isBlocking()) {
                        tracker.setBlocking(true);
                        if (!showShieldWhenSwordInHand && tracker.getItemInSecondHand() == null) {
                            DataItem shield = new DataItem(442, 1, 0, null);
                            tracker.setSecondHand(shield);
                        }
                    }
                    boolean bl3 = blockUsingMainHand = Via.getConfig().isNoDelayShieldBlocking() && !showShieldWhenSwordInHand;
                    if (blockUsingMainHand && hand == 1 || !blockUsingMainHand && hand == 0) {
                        wrapper.cancel();
                    }
                } else {
                    if (!showShieldWhenSwordInHand) {
                        tracker.setSecondHand(null);
                    }
                    tracker.setBlocking(false);
                }
            }
            wrapper.write(Types.ITEM1_8, item);
            wrapper.write(Types.UNSIGNED_BYTE, (short)0);
            wrapper.write(Types.UNSIGNED_BYTE, (short)0);
            wrapper.write(Types.UNSIGNED_BYTE, (short)0);
        });
        protocol.registerServerbound(ServerboundPackets1_9.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT, Types.UNSIGNED_BYTE);
                this.handler(wrapper -> {
                    int hand = wrapper.read(Types.VAR_INT);
                    if (hand != 0) {
                        wrapper.cancel();
                    }
                });
                this.handler(wrapper -> {
                    Item item = Via.getManager().getProviders().get(HandItemProvider.class).getHandItem(wrapper.user());
                    wrapper.write(Types.ITEM1_8, item);
                });
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(wrapper -> {
                    CommandBlockProvider provider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    BlockPosition pos = wrapper.get(Types.BLOCK_POSITION1_8, 0);
                    Optional<CompoundTag> tag = provider.get(wrapper.user(), pos);
                    if (tag.isPresent()) {
                        PacketWrapper updateBlockEntity = PacketWrapper.create(ClientboundPackets1_9.BLOCK_ENTITY_DATA, null, wrapper.user());
                        updateBlockEntity.write(Types.BLOCK_POSITION1_8, pos);
                        updateBlockEntity.write(Types.UNSIGNED_BYTE, (short)2);
                        updateBlockEntity.write(Types.NAMED_COMPOUND_TAG, tag.get());
                        updateBlockEntity.scheduleSend(Protocol1_8To1_9.class);
                    }
                });
                if (!Via.getConfig().cancelBlockSounds()) {
                    return;
                }
                this.handler(wrapper -> {
                    short face = wrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (face == 255) {
                        return;
                    }
                    BlockPosition p2 = wrapper.get(Types.BLOCK_POSITION1_8, 0);
                    int x2 = p2.x();
                    int y2 = p2.y();
                    int z2 = p2.z();
                    switch (face) {
                        case 0: {
                            --y2;
                            break;
                        }
                        case 1: {
                            ++y2;
                            break;
                        }
                        case 2: {
                            --z2;
                            break;
                        }
                        case 3: {
                            ++z2;
                            break;
                        }
                        case 4: {
                            --x2;
                            break;
                        }
                        case 5: {
                            ++x2;
                        }
                    }
                    EntityTracker1_9 tracker = (EntityTracker1_9)wrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    tracker.addBlockInteraction(new BlockPosition(x2, y2, z2));
                });
            }
        });
    }
}

