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
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={1.class, StairData.class})
public class StairConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<StairData> STAIR_DATA_MAP = new Int2ObjectOpenHashMap<StairData>();
    private static final Map<Short, Integer> CONNECTED_BLOCKS = new HashMap<Short, Integer>();

    static ConnectionData.ConnectorInitAction init() {
        LinkedList<String> baseStairs = new LinkedList<String>();
        baseStairs.add("minecraft:oak_stairs");
        baseStairs.add("minecraft:cobblestone_stairs");
        baseStairs.add("minecraft:brick_stairs");
        baseStairs.add("minecraft:stone_brick_stairs");
        baseStairs.add("minecraft:nether_brick_stairs");
        baseStairs.add("minecraft:sandstone_stairs");
        baseStairs.add("minecraft:spruce_stairs");
        baseStairs.add("minecraft:birch_stairs");
        baseStairs.add("minecraft:jungle_stairs");
        baseStairs.add("minecraft:quartz_stairs");
        baseStairs.add("minecraft:acacia_stairs");
        baseStairs.add("minecraft:dark_oak_stairs");
        baseStairs.add("minecraft:red_sandstone_stairs");
        baseStairs.add("minecraft:purpur_stairs");
        baseStairs.add("minecraft:prismarine_stairs");
        baseStairs.add("minecraft:prismarine_brick_stairs");
        baseStairs.add("minecraft:dark_prismarine_stairs");
        StairConnectionHandler connectionHandler = new StairConnectionHandler();
        return blockData -> {
            byte shape;
            int type = baseStairs.indexOf(blockData.getMinecraftKey());
            if (type == -1) {
                return;
            }
            if (blockData.getValue("waterlogged").equals("true")) {
                return;
            }
            switch (blockData.getValue("shape")) {
                case "straight": {
                    shape = 0;
                    break;
                }
                case "inner_left": {
                    shape = 1;
                    break;
                }
                case "inner_right": {
                    shape = 2;
                    break;
                }
                case "outer_left": {
                    shape = 3;
                    break;
                }
                case "outer_right": {
                    shape = 4;
                    break;
                }
                default: {
                    return;
                }
            }
            StairData stairData = new StairData(blockData.getValue("half").equals("bottom"), shape, (byte)type, BlockFace.valueOf(blockData.getValue("facing").toUpperCase(Locale.ROOT)));
            STAIR_DATA_MAP.put(blockData.getSavedBlockStateId(), stairData);
            CONNECTED_BLOCKS.put(StairConnectionHandler.getStates(stairData), blockData.getSavedBlockStateId());
            ConnectionData.connectionHandlerMap.put(blockData.getSavedBlockStateId(), (ConnectionHandler)connectionHandler);
        };
    }

    private static short getStates(StairData stairData) {
        short s2 = 0;
        if (stairData.bottom()) {
            s2 = (short)(s2 | 1);
        }
        s2 = (short)(s2 | stairData.shape() << 1);
        s2 = (short)(s2 | stairData.type() << 4);
        s2 = (short)(s2 | stairData.facing().ordinal() << 9);
        return s2;
    }

    @Override
    public int connect(UserConnection user, BlockPosition position, int blockState) {
        StairData stairData = (StairData)STAIR_DATA_MAP.get(blockState);
        if (stairData == null) {
            return blockState;
        }
        short s2 = 0;
        if (stairData.bottom()) {
            s2 = (short)(s2 | 1);
        }
        s2 = (short)(s2 | this.getShape(user, position, stairData) << 1);
        s2 = (short)(s2 | stairData.type() << 4);
        Integer newBlockState = CONNECTED_BLOCKS.get(s2 = (short)(s2 | stairData.facing().ordinal() << 9));
        return newBlockState == null ? blockState : newBlockState;
    }

    private int getShape(UserConnection user, BlockPosition position, StairData stair) {
        BlockFace facing2;
        BlockFace facing = stair.facing();
        StairData relativeStair = (StairData)STAIR_DATA_MAP.get(this.getBlockData(user, position.getRelative(facing)));
        if (relativeStair != null && relativeStair.bottom() == stair.bottom()) {
            facing2 = relativeStair.facing();
            if (facing.axis() != facing2.axis() && this.checkOpposite(user, stair, position, facing2.opposite())) {
                return facing2 == this.rotateAntiClockwise(facing) ? 3 : 4;
            }
        }
        if ((relativeStair = (StairData)STAIR_DATA_MAP.get(this.getBlockData(user, position.getRelative(facing.opposite())))) != null && relativeStair.bottom() == stair.bottom()) {
            facing2 = relativeStair.facing();
            if (facing.axis() != facing2.axis() && this.checkOpposite(user, stair, position, facing2)) {
                return facing2 == this.rotateAntiClockwise(facing) ? 1 : 2;
            }
        }
        return 0;
    }

    private boolean checkOpposite(UserConnection user, StairData stair, BlockPosition position, BlockFace face) {
        StairData relativeStair = (StairData)STAIR_DATA_MAP.get(this.getBlockData(user, position.getRelative(face)));
        return relativeStair == null || relativeStair.facing() != stair.facing() || relativeStair.bottom() != stair.bottom();
    }

    private BlockFace rotateAntiClockwise(BlockFace face) {
        BlockFace blockFace;
        switch (face) {
            case NORTH: {
                blockFace = BlockFace.WEST;
                break;
            }
            case SOUTH: {
                blockFace = BlockFace.EAST;
                break;
            }
            case EAST: {
                blockFace = BlockFace.NORTH;
                break;
            }
            case WEST: {
                blockFace = BlockFace.SOUTH;
                break;
            }
            default: {
                blockFace = face;
            }
        }
        return blockFace;
    }

    @RecordComponents(value={@RecordComponents.Value(name="bottom", type=boolean.class), @RecordComponents.Value(name="shape", type=byte.class), @RecordComponents.Value(name="type", type=byte.class), @RecordComponents.Value(name="facing", type=BlockFace.class)})
    @NestHost(value=StairConnectionHandler.class)
    private static final class StairData
    extends J_L_Record {
        private final boolean bottom;
        private final byte shape;
        private final byte type;
        private final BlockFace facing;

        StairData(boolean bottom, byte shape, byte type, BlockFace facing) {
            this.bottom = bottom;
            this.shape = shape;
            this.type = type;
            this.facing = facing;
        }

        @Override
        public final String toString() {
            return StairData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return StairData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return StairData.jvmdowngrader$equals$equals(this, o2);
        }

        public boolean bottom() {
            return this.bottom;
        }

        public byte shape() {
            return this.shape;
        }

        public byte type() {
            return this.type;
        }

        public BlockFace facing() {
            return this.facing;
        }

        private static String jvmdowngrader$toString$toString(StairData stairData) {
            StairData stairData2 = stairData;
            return "StairConnectionHandler$StairData[" + "bottom=" + stairData.bottom + ", " + "shape=" + stairData.shape + ", " + "type=" + stairData.type + ", " + "facing=" + (Object)((Object)stairData.facing) + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(StairData stairData) {
            Object[] objectArray = new Object[]{stairData.bottom, stairData.shape, stairData.type, stairData.facing};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(StairData stairData, Object object) {
            if (stairData == object) {
                return true;
            }
            if (object != null && object instanceof StairData) {
                StairData stairData2 = (StairData)object;
                if (stairData.bottom == stairData2.bottom && stairData.shape == stairData2.shape && stairData.type == stairData2.type && Objects.equals((Object)stairData.facing, (Object)stairData2.facing)) {
                    return true;
                }
            }
            return false;
        }
    }
}

