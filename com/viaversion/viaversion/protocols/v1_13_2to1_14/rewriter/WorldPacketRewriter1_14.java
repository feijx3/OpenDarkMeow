/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.storage.EntityTracker1_14;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.util.CompactArrayUtil;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={10.class, 9.class, 8.class, 7.class, 6.class, 5.class, 4.class, 3.class, 2.class, 1.class})
public class WorldPacketRewriter1_14 {
    public static final int SERVERSIDE_VIEW_DISTANCE = 64;
    private static final byte[] FULL_LIGHT = new byte[2048];
    public static int air;
    public static int voidAir;
    public static int caveAir;

    public static void register(final Protocol1_13_2To1_14 protocol) {
        BlockRewriter<ClientboundPackets1_13> blockRewriter = BlockRewriter.for1_14(protocol);
        protocol.registerClientbound(ClientboundPackets1_13.BLOCK_DESTRUCTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.BYTE);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(wrapper -> wrapper.set(Types.VAR_INT, 0, protocol.getMappingData().getNewBlockId(wrapper.get(Types.VAR_INT, 0))));
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.VAR_INT);
                this.handler(wrapper -> {
                    int id = wrapper.get(Types.VAR_INT, 0);
                    wrapper.set(Types.VAR_INT, 0, protocol.getMappingData().getNewBlockStateId(id));
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.CHANGE_DIFFICULTY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.handler(wrapper -> wrapper.write(Types.BOOLEAN, false));
            }
        });
        blockRewriter.registerChunkBlocksUpdate(ClientboundPackets1_13.CHUNK_BLOCKS_UPDATE);
        protocol.registerClientbound(ClientboundPackets1_13.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(wrapper -> {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        float coord = wrapper.get(Types.FLOAT, i2).floatValue();
                        if (!(coord < 0.0f)) continue;
                        coord = (int)coord;
                        wrapper.set(Types.FLOAT, i2, Float.valueOf(coord));
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.LEVEL_CHUNK, wrapper -> {
            int i2;
            Object clientWorld = wrapper.user().getClientWorld(Protocol1_13_2To1_14.class);
            Chunk chunk = wrapper.read(ChunkType1_13.forEnvironment(((ClientWorld)clientWorld).getEnvironment()));
            wrapper.write(ChunkType1_14.TYPE, chunk);
            int[] motionBlocking = new int[256];
            int[] worldSurface = new int[256];
            for (int s2 = 0; s2 < chunk.getSections().length; ++s2) {
                ChunkSection section = chunk.getSections()[s2];
                if (section == null) continue;
                DataPalette blocks = section.palette(PaletteType.BLOCKS);
                boolean hasBlock = false;
                for (i2 = 0; i2 < blocks.size(); ++i2) {
                    int old = blocks.idByIndex(i2);
                    int newId = protocol.getMappingData().getNewBlockStateId(old);
                    if (!hasBlock && newId != air && newId != voidAir && newId != caveAir) {
                        hasBlock = true;
                    }
                    blocks.setIdByIndex(i2, newId);
                }
                if (!hasBlock) {
                    section.setNonAirBlocksCount(0);
                    continue;
                }
                int nonAirBlockCount = 0;
                int sy = s2 << 4;
                for (int idx = 0; idx < 4096; ++idx) {
                    int id = blocks.idAt(idx);
                    if (id == air || id == voidAir || id == caveAir) continue;
                    ++nonAirBlockCount;
                    int xz = idx & 0xFF;
                    int y2 = ChunkSection.yFromIndex(idx);
                    worldSurface[xz] = sy + y2 + 1;
                    if (protocol.getMappingData().getMotionBlocking().contains(id)) {
                        motionBlocking[xz] = sy + y2 + 1;
                    }
                    if (!Via.getConfig().isNonFullBlockLightFix() || !protocol.getMappingData().getNonFullBlocks().contains(id)) continue;
                    int x2 = ChunkSection.xFromIndex(idx);
                    int z2 = ChunkSection.zFromIndex(idx);
                    WorldPacketRewriter1_14.setNonFullLight(chunk, section, s2, x2, y2, z2);
                }
                section.setNonAirBlocksCount(nonAirBlockCount);
            }
            CompoundTag heightMap = new CompoundTag();
            heightMap.put("MOTION_BLOCKING", new LongArrayTag(WorldPacketRewriter1_14.encodeHeightMap(motionBlocking)));
            heightMap.put("WORLD_SURFACE", new LongArrayTag(WorldPacketRewriter1_14.encodeHeightMap(worldSurface)));
            chunk.setHeightMap(heightMap);
            PacketWrapper lightPacket = wrapper.create(ClientboundPackets1_14.LIGHT_UPDATE);
            lightPacket.write(Types.VAR_INT, chunk.getX());
            lightPacket.write(Types.VAR_INT, chunk.getZ());
            int skyLightMask = chunk.isFullChunk() ? 262143 : 0;
            int blockLightMask = 0;
            for (i2 = 0; i2 < chunk.getSections().length; ++i2) {
                ChunkSection sec = chunk.getSections()[i2];
                if (sec == null) continue;
                if (!chunk.isFullChunk() && sec.getLight().hasSkyLight()) {
                    skyLightMask |= 1 << i2 + 1;
                }
                blockLightMask |= 1 << i2 + 1;
            }
            lightPacket.write(Types.VAR_INT, skyLightMask);
            lightPacket.write(Types.VAR_INT, blockLightMask);
            lightPacket.write(Types.VAR_INT, 0);
            lightPacket.write(Types.VAR_INT, 0);
            if (chunk.isFullChunk()) {
                lightPacket.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
            }
            for (ChunkSection section : chunk.getSections()) {
                if (section == null || !section.getLight().hasSkyLight()) {
                    if (!chunk.isFullChunk()) continue;
                    lightPacket.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
                    continue;
                }
                lightPacket.write(Types.BYTE_ARRAY_PRIMITIVE, section.getLight().getSkyLight());
            }
            if (chunk.isFullChunk()) {
                lightPacket.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
            }
            for (ChunkSection section : chunk.getSections()) {
                if (section == null) continue;
                lightPacket.write(Types.BYTE_ARRAY_PRIMITIVE, section.getLight().getBlockLight());
            }
            EntityTracker1_14 entityTracker = (EntityTracker1_14)wrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
            int diffX = Math.abs(entityTracker.getChunkCenterX() - chunk.getX());
            int diffZ = Math.abs(entityTracker.getChunkCenterZ() - chunk.getZ());
            if (entityTracker.isForceSendCenterChunk() || diffX >= 64 || diffZ >= 64) {
                PacketWrapper fakePosLook = wrapper.create(ClientboundPackets1_14.SET_CHUNK_CACHE_CENTER);
                fakePosLook.write(Types.VAR_INT, chunk.getX());
                fakePosLook.write(Types.VAR_INT, chunk.getZ());
                fakePosLook.send(Protocol1_13_2To1_14.class);
                entityTracker.setChunkCenterX(chunk.getX());
                entityTracker.setChunkCenterZ(chunk.getZ());
            }
            lightPacket.send(Protocol1_13_2To1_14.class);
            for (ChunkSection section : chunk.getSections()) {
                if (section == null) continue;
                section.setLight(null);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.INT);
                this.handler(wrapper -> {
                    int id = wrapper.get(Types.INT, 0);
                    int data = wrapper.get(Types.INT, 1);
                    if (id == 1010) {
                        wrapper.set(Types.INT, 1, protocol.getMappingData().getNewItemId(data));
                    } else if (id == 2001) {
                        wrapper.set(Types.INT, 1, protocol.getMappingData().getNewBlockStateId(data));
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(wrapper -> wrapper.write(Types.BOOLEAN, false));
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(wrapper -> {
                    int dimensionId;
                    short difficulty = wrapper.read(Types.UNSIGNED_BYTE);
                    Object clientWorld = wrapper.user().getClientWorld(Protocol1_13_2To1_14.class);
                    if (!((ClientWorld)clientWorld).setEnvironment(dimensionId = wrapper.get(Types.INT, 0).intValue())) {
                        return;
                    }
                    EntityTracker1_14 entityTracker = (EntityTracker1_14)wrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
                    entityTracker.clearEntities();
                    entityTracker.setForceSendCenterChunk(true);
                    PacketWrapper difficultyPacket = wrapper.create(ClientboundPackets1_14.CHANGE_DIFFICULTY);
                    difficultyPacket.write(Types.UNSIGNED_BYTE, difficulty);
                    difficultyPacket.write(Types.BOOLEAN, false);
                    difficultyPacket.scheduleSend(protocol.getClass());
                    wrapper.send(Protocol1_13_2To1_14.class);
                    wrapper.cancel();
                    WorldPacketRewriter1_14.sendViewDistancePacket(wrapper.user());
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
            }
        });
    }

    static void sendViewDistancePacket(UserConnection connection) {
        PacketWrapper setViewDistance = PacketWrapper.create(ClientboundPackets1_14.SET_CHUNK_CACHE_RADIUS, connection);
        setViewDistance.write(Types.VAR_INT, 64);
        setViewDistance.send(Protocol1_13_2To1_14.class);
    }

    private static long[] encodeHeightMap(int[] heightMap) {
        return CompactArrayUtil.createCompactArray(9, heightMap.length, i2 -> heightMap[i2]);
    }

    private static void setNonFullLight(Chunk chunk, ChunkSection section, int ySection, int x2, int y2, int z2) {
        int skyLight = 0;
        int blockLight = 0;
        for (BlockFace blockFace : BlockFace.values()) {
            NibbleArray skyLightArray = section.getLight().getSkyLightNibbleArray();
            NibbleArray blockLightArray = section.getLight().getBlockLightNibbleArray();
            int neighbourX = x2 + blockFace.modX();
            int neighbourY = y2 + blockFace.modY();
            int neighbourZ = z2 + blockFace.modZ();
            if (blockFace.modX() != 0) {
                if (neighbourX == 16 || neighbourX == -1) {
                    continue;
                }
            } else if (blockFace.modY() != 0) {
                if (neighbourY == 16 || neighbourY == -1) {
                    ChunkSection newSection;
                    if (neighbourY == 16) {
                        ++ySection;
                        neighbourY = 0;
                    } else {
                        --ySection;
                        neighbourY = 15;
                    }
                    if (ySection == chunk.getSections().length || ySection == -1 || (newSection = chunk.getSections()[ySection]) == null) continue;
                    skyLightArray = newSection.getLight().getSkyLightNibbleArray();
                    blockLightArray = newSection.getLight().getBlockLightNibbleArray();
                }
            } else if (blockFace.modZ() != 0 && (neighbourZ == 16 || neighbourZ == -1)) continue;
            if (blockLightArray != null && blockLight != 15) {
                int neighbourBlockLight = blockLightArray.get(neighbourX, neighbourY, neighbourZ);
                if (neighbourBlockLight == 15) {
                    blockLight = 14;
                } else if (neighbourBlockLight > blockLight) {
                    blockLight = neighbourBlockLight - 1;
                }
            }
            if (skyLightArray == null || skyLight == 15) continue;
            int neighbourSkyLight = skyLightArray.get(neighbourX, neighbourY, neighbourZ);
            if (neighbourSkyLight == 15) {
                if (blockFace.modY() == 1) {
                    skyLight = 15;
                    continue;
                }
                skyLight = 14;
                continue;
            }
            if (neighbourSkyLight <= skyLight) continue;
            skyLight = neighbourSkyLight - 1;
        }
        if (skyLight != 0) {
            if (!section.getLight().hasSkyLight()) {
                byte[] newSkyLight = new byte[2028];
                section.getLight().setSkyLight(newSkyLight);
            }
            section.getLight().getSkyLightNibbleArray().set(x2, y2, z2, skyLight);
        }
        if (blockLight != 0) {
            section.getLight().getBlockLightNibbleArray().set(x2, y2, z2, blockLight);
        }
    }

    static {
        Arrays.fill(FULL_LIGHT, (byte)-1);
    }
}

