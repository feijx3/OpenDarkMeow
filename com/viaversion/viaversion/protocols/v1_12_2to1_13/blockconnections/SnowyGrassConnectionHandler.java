/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import java.util.Arrays;
import java.util.HashSet;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={GrassBlock.class})
public class SnowyGrassConnectionHandler
implements ConnectionHandler {
    private static final Object2IntMap<GrassBlock> GRASS_BLOCKS = new Object2IntOpenHashMap<GrassBlock>();
    private static final IntSet SNOWY_GRASS_BLOCKS = new IntOpenHashSet();

    static ConnectionData.ConnectorInitAction init() {
        HashSet<String> snowyGrassBlocks = new HashSet<String>();
        snowyGrassBlocks.add("minecraft:grass_block");
        snowyGrassBlocks.add("minecraft:podzol");
        snowyGrassBlocks.add("minecraft:mycelium");
        GRASS_BLOCKS.defaultReturnValue(-1);
        SnowyGrassConnectionHandler handler = new SnowyGrassConnectionHandler();
        return blockData -> {
            if (snowyGrassBlocks.contains(blockData.getMinecraftKey())) {
                ConnectionData.connectionHandlerMap.put(blockData.getSavedBlockStateId(), (ConnectionHandler)handler);
                blockData.set("snowy", "true");
                GRASS_BLOCKS.put(new GrassBlock(blockData.getSavedBlockStateId(), true), blockData.getBlockStateId());
                blockData.set("snowy", "false");
                GRASS_BLOCKS.put(new GrassBlock(blockData.getSavedBlockStateId(), false), blockData.getBlockStateId());
            }
            if (blockData.getMinecraftKey().equals("minecraft:snow") || blockData.getMinecraftKey().equals("minecraft:snow_block")) {
                ConnectionData.connectionHandlerMap.put(blockData.getSavedBlockStateId(), (ConnectionHandler)handler);
                SNOWY_GRASS_BLOCKS.add(blockData.getSavedBlockStateId());
            }
        };
    }

    @Override
    public int connect(UserConnection user, BlockPosition position, int blockState) {
        int blockUpId = this.getBlockData(user, position.getRelative(BlockFace.TOP));
        int newId = GRASS_BLOCKS.getInt(new GrassBlock(blockState, SNOWY_GRASS_BLOCKS.contains(blockUpId)));
        return newId != -1 ? newId : blockState;
    }

    @RecordComponents(value={@RecordComponents.Value(name="blockStateId", type=int.class), @RecordComponents.Value(name="snowy", type=boolean.class)})
    @NestHost(value=SnowyGrassConnectionHandler.class)
    private static final class GrassBlock
    extends J_L_Record {
        private final int blockStateId;
        private final boolean snowy;

        GrassBlock(int blockStateId, boolean snowy) {
            this.blockStateId = blockStateId;
            this.snowy = snowy;
        }

        @Override
        public final String toString() {
            return GrassBlock.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return GrassBlock.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return GrassBlock.jvmdowngrader$equals$equals(this, o2);
        }

        public int blockStateId() {
            return this.blockStateId;
        }

        public boolean snowy() {
            return this.snowy;
        }

        private static String jvmdowngrader$toString$toString(GrassBlock grassBlock) {
            GrassBlock grassBlock2 = grassBlock;
            return "SnowyGrassConnectionHandler$GrassBlock[" + "blockStateId=" + grassBlock.blockStateId + ", " + "snowy=" + grassBlock.snowy + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(GrassBlock grassBlock) {
            Object[] objectArray = new Object[]{grassBlock.blockStateId, grassBlock.snowy};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(GrassBlock grassBlock, Object object) {
            if (grassBlock == object) {
                return true;
            }
            if (object != null && object instanceof GrassBlock) {
                GrassBlock grassBlock2 = (GrassBlock)object;
                if (grassBlock.blockStateId == grassBlock2.blockStateId && grassBlock.snowy == grassBlock2.snowy) {
                    return true;
                }
            }
            return false;
        }
    }
}

