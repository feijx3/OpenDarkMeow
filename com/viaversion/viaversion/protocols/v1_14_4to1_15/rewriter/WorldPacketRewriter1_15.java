/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_14_4to1_15.rewriter;

import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.Protocol1_14_4To1_15;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class WorldPacketRewriter1_15 {
    public static void register(final Protocol1_14_4To1_15 protocol) {
        BlockRewriter<ClientboundPackets1_14_4> blockRewriter = BlockRewriter.for1_14(protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_14_4.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_14_4.BLOCK_UPDATE);
        blockRewriter.registerChunkBlocksUpdate(ClientboundPackets1_14_4.CHUNK_BLOCKS_UPDATE);
        blockRewriter.registerBlockBreakAck(ClientboundPackets1_14_4.BLOCK_BREAK_ACK);
        blockRewriter.registerLevelChunk(ClientboundPackets1_14_4.LEVEL_CHUNK, ChunkType1_14.TYPE, ChunkType1_15.TYPE, (connection, chunk) -> {
            if (chunk.isFullChunk()) {
                int[] biomeData = chunk.getBiomeData();
                int[] newBiomeData = new int[1024];
                if (biomeData != null) {
                    int i2;
                    for (i2 = 0; i2 < 4; ++i2) {
                        for (int j2 = 0; j2 < 4; ++j2) {
                            int x2 = (j2 << 2) + 2;
                            int z2 = (i2 << 2) + 2;
                            int oldIndex = z2 << 4 | x2;
                            newBiomeData[i2 << 2 | j2] = biomeData[oldIndex];
                        }
                    }
                    for (i2 = 1; i2 < 64; ++i2) {
                        System.arraycopy(newBiomeData, 0, newBiomeData, i2 * 16, 16);
                    }
                }
                chunk.setBiomeData(newBiomeData);
            }
        });
        blockRewriter.registerLevelEvent(ClientboundPackets1_14_4.LEVEL_EVENT, 1010, 2001);
        protocol.registerClientbound(ClientboundPackets1_14_4.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(wrapper -> {
                    int id = wrapper.get(Types.INT, 0);
                    if (id == 3 || id == 23) {
                        int data = wrapper.passthrough(Types.VAR_INT);
                        wrapper.set(Types.VAR_INT, 0, protocol.getMappingData().getNewBlockStateId(data));
                    } else if (id == 32) {
                        protocol.getItemRewriter().handleItemToClient(wrapper.user(), wrapper.passthrough(Types.ITEM1_13_2));
                    }
                });
            }
        });
    }
}

