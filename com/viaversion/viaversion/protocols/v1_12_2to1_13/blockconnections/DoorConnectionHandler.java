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

@NestMembers(value={DoorData.class})
public class DoorConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<DoorData> DOOR_DATA_MAP = new Int2ObjectOpenHashMap<DoorData>();
    private static final Map<Short, Integer> CONNECTED_STATES = new HashMap<Short, Integer>();

    static ConnectionData.ConnectorInitAction init() {
        LinkedList<String> baseDoors = new LinkedList<String>();
        baseDoors.add("minecraft:oak_door");
        baseDoors.add("minecraft:birch_door");
        baseDoors.add("minecraft:jungle_door");
        baseDoors.add("minecraft:dark_oak_door");
        baseDoors.add("minecraft:acacia_door");
        baseDoors.add("minecraft:spruce_door");
        baseDoors.add("minecraft:iron_door");
        DoorConnectionHandler connectionHandler = new DoorConnectionHandler();
        return blockData -> {
            int type = baseDoors.indexOf(blockData.getMinecraftKey());
            if (type == -1) {
                return;
            }
            int id = blockData.getSavedBlockStateId();
            DoorData doorData = new DoorData(blockData.getValue("half").equals("lower"), blockData.getValue("hinge").equals("right"), blockData.getValue("powered").equals("true"), blockData.getValue("open").equals("true"), BlockFace.valueOf(blockData.getValue("facing").toUpperCase(Locale.ROOT)), type);
            DOOR_DATA_MAP.put(id, doorData);
            CONNECTED_STATES.put(DoorConnectionHandler.getStates(doorData), id);
            ConnectionData.connectionHandlerMap.put(id, (ConnectionHandler)connectionHandler);
        };
    }

    private static short getStates(DoorData doorData) {
        short s2 = 0;
        if (doorData.lower()) {
            s2 = (short)(s2 | 1);
        }
        if (doorData.open()) {
            s2 = (short)(s2 | 2);
        }
        if (doorData.powered()) {
            s2 = (short)(s2 | 4);
        }
        if (doorData.rightHinge()) {
            s2 = (short)(s2 | 8);
        }
        s2 = (short)(s2 | doorData.facing().ordinal() << 4);
        s2 = (short)(s2 | (doorData.type() & 7) << 6);
        return s2;
    }

    @Override
    public int connect(UserConnection user, BlockPosition position, int blockState) {
        DoorData doorData = (DoorData)DOOR_DATA_MAP.get(blockState);
        if (doorData == null) {
            return blockState;
        }
        short s2 = 0;
        s2 = (short)(s2 | (doorData.type() & 7) << 6);
        if (doorData.lower()) {
            DoorData upperHalf = (DoorData)DOOR_DATA_MAP.get(this.getBlockData(user, position.getRelative(BlockFace.TOP)));
            if (upperHalf == null) {
                return blockState;
            }
            s2 = (short)(s2 | 1);
            if (doorData.open()) {
                s2 = (short)(s2 | 2);
            }
            if (upperHalf.powered()) {
                s2 = (short)(s2 | 4);
            }
            if (upperHalf.rightHinge()) {
                s2 = (short)(s2 | 8);
            }
            s2 = (short)(s2 | doorData.facing().ordinal() << 4);
        } else {
            DoorData lowerHalf = (DoorData)DOOR_DATA_MAP.get(this.getBlockData(user, position.getRelative(BlockFace.BOTTOM)));
            if (lowerHalf == null) {
                return blockState;
            }
            if (lowerHalf.open()) {
                s2 = (short)(s2 | 2);
            }
            if (doorData.powered()) {
                s2 = (short)(s2 | 4);
            }
            if (doorData.rightHinge()) {
                s2 = (short)(s2 | 8);
            }
            s2 = (short)(s2 | lowerHalf.facing().ordinal() << 4);
        }
        Integer newBlockState = CONNECTED_STATES.get(s2);
        return newBlockState == null ? blockState : newBlockState;
    }

    @RecordComponents(value={@RecordComponents.Value(name="lower", type=boolean.class), @RecordComponents.Value(name="rightHinge", type=boolean.class), @RecordComponents.Value(name="powered", type=boolean.class), @RecordComponents.Value(name="open", type=boolean.class), @RecordComponents.Value(name="facing", type=BlockFace.class), @RecordComponents.Value(name="type", type=int.class)})
    @NestHost(value=DoorConnectionHandler.class)
    private static final class DoorData
    extends J_L_Record {
        private final boolean lower;
        private final boolean rightHinge;
        private final boolean powered;
        private final boolean open;
        private final BlockFace facing;
        private final int type;

        DoorData(boolean lower, boolean rightHinge, boolean powered, boolean open, BlockFace facing, int type) {
            this.lower = lower;
            this.rightHinge = rightHinge;
            this.powered = powered;
            this.open = open;
            this.facing = facing;
            this.type = type;
        }

        @Override
        public final String toString() {
            return DoorData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return DoorData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return DoorData.jvmdowngrader$equals$equals(this, o2);
        }

        public boolean lower() {
            return this.lower;
        }

        public boolean rightHinge() {
            return this.rightHinge;
        }

        public boolean powered() {
            return this.powered;
        }

        public boolean open() {
            return this.open;
        }

        public BlockFace facing() {
            return this.facing;
        }

        public int type() {
            return this.type;
        }

        private static String jvmdowngrader$toString$toString(DoorData doorData) {
            DoorData doorData2 = doorData;
            return "DoorConnectionHandler$DoorData[" + "lower=" + doorData.lower + ", " + "rightHinge=" + doorData.rightHinge + ", " + "powered=" + doorData.powered + ", " + "open=" + doorData.open + ", " + "facing=" + (Object)((Object)doorData.facing) + ", " + "type=" + doorData.type + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(DoorData doorData) {
            Object[] objectArray = new Object[]{doorData.lower, doorData.rightHinge, doorData.powered, doorData.open, doorData.facing, doorData.type};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(DoorData doorData, Object object) {
            if (doorData == object) {
                return true;
            }
            if (object != null && object instanceof DoorData) {
                DoorData doorData2 = (DoorData)object;
                if (doorData.lower == doorData2.lower && doorData.rightHinge == doorData2.rightHinge && doorData.powered == doorData2.powered && doorData.open == doorData2.open && Objects.equals((Object)doorData.facing, (Object)doorData2.facing) && doorData.type == doorData2.type) {
                    return true;
                }
            }
            return false;
        }
    }
}

