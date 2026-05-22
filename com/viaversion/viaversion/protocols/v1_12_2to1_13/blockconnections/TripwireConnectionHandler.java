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
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;
import java.util.Arrays;
import java.util.Locale;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={TripwireData.class})
public class TripwireConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<TripwireData> TRIPWIRE_DATA_MAP = new Int2ObjectOpenHashMap<TripwireData>();
    private static final Int2ObjectMap<BlockFace> TRIPWIRE_HOOKS = new Int2ObjectArrayMap<BlockFace>();
    private static final int[] CONNECTED_BLOCKS = new int[128];

    static ConnectionData.ConnectorInitAction init() {
        Arrays.fill(CONNECTED_BLOCKS, -1);
        TripwireConnectionHandler connectionHandler = new TripwireConnectionHandler();
        return blockData -> {
            if (blockData.getMinecraftKey().equals("minecraft:tripwire_hook")) {
                TRIPWIRE_HOOKS.put(blockData.getSavedBlockStateId(), BlockFace.valueOf(blockData.getValue("facing").toUpperCase(Locale.ROOT)));
            } else if (blockData.getMinecraftKey().equals("minecraft:tripwire")) {
                TripwireData tripwireData = new TripwireData(blockData.getValue("attached").equals("true"), blockData.getValue("disarmed").equals("true"), blockData.getValue("powered").equals("true"));
                TRIPWIRE_DATA_MAP.put(blockData.getSavedBlockStateId(), tripwireData);
                TripwireConnectionHandler.CONNECTED_BLOCKS[TripwireConnectionHandler.getStates((WrappedBlockData)blockData)] = blockData.getSavedBlockStateId();
                ConnectionData.connectionHandlerMap.put(blockData.getSavedBlockStateId(), (ConnectionHandler)connectionHandler);
            }
        };
    }

    private static byte getStates(WrappedBlockData blockData) {
        byte b2 = 0;
        if (blockData.getValue("attached").equals("true")) {
            b2 = (byte)(b2 | 1);
        }
        if (blockData.getValue("disarmed").equals("true")) {
            b2 = (byte)(b2 | 2);
        }
        if (blockData.getValue("powered").equals("true")) {
            b2 = (byte)(b2 | 4);
        }
        if (blockData.getValue("east").equals("true")) {
            b2 = (byte)(b2 | 8);
        }
        if (blockData.getValue("north").equals("true")) {
            b2 = (byte)(b2 | 0x10);
        }
        if (blockData.getValue("south").equals("true")) {
            b2 = (byte)(b2 | 0x20);
        }
        if (blockData.getValue("west").equals("true")) {
            b2 = (byte)(b2 | 0x40);
        }
        return b2;
    }

    @Override
    public int connect(UserConnection user, BlockPosition position, int blockState) {
        int newBlockState;
        TripwireData tripwireData = (TripwireData)TRIPWIRE_DATA_MAP.get(blockState);
        if (tripwireData == null) {
            return blockState;
        }
        byte b2 = 0;
        if (tripwireData.attached()) {
            b2 = (byte)(b2 | 1);
        }
        if (tripwireData.disarmed()) {
            b2 = (byte)(b2 | 2);
        }
        if (tripwireData.powered()) {
            b2 = (byte)(b2 | 4);
        }
        int east = this.getBlockData(user, position.getRelative(BlockFace.EAST));
        int north = this.getBlockData(user, position.getRelative(BlockFace.NORTH));
        int south = this.getBlockData(user, position.getRelative(BlockFace.SOUTH));
        int west = this.getBlockData(user, position.getRelative(BlockFace.WEST));
        if (TRIPWIRE_DATA_MAP.containsKey(east) || TRIPWIRE_HOOKS.get(east) == BlockFace.WEST) {
            b2 = (byte)(b2 | 8);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(north) || TRIPWIRE_HOOKS.get(north) == BlockFace.SOUTH) {
            b2 = (byte)(b2 | 0x10);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(south) || TRIPWIRE_HOOKS.get(south) == BlockFace.NORTH) {
            b2 = (byte)(b2 | 0x20);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(west) || TRIPWIRE_HOOKS.get(west) == BlockFace.EAST) {
            b2 = (byte)(b2 | 0x40);
        }
        return (newBlockState = CONNECTED_BLOCKS[b2]) == -1 ? blockState : newBlockState;
    }

    @RecordComponents(value={@RecordComponents.Value(name="attached", type=boolean.class), @RecordComponents.Value(name="disarmed", type=boolean.class), @RecordComponents.Value(name="powered", type=boolean.class)})
    @NestHost(value=TripwireConnectionHandler.class)
    private static final class TripwireData
    extends J_L_Record {
        private final boolean attached;
        private final boolean disarmed;
        private final boolean powered;

        TripwireData(boolean attached, boolean disarmed, boolean powered) {
            this.attached = attached;
            this.disarmed = disarmed;
            this.powered = powered;
        }

        @Override
        public final String toString() {
            return TripwireData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return TripwireData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return TripwireData.jvmdowngrader$equals$equals(this, o2);
        }

        public boolean attached() {
            return this.attached;
        }

        public boolean disarmed() {
            return this.disarmed;
        }

        public boolean powered() {
            return this.powered;
        }

        private static String jvmdowngrader$toString$toString(TripwireData tripwireData) {
            TripwireData tripwireData2 = tripwireData;
            return "TripwireConnectionHandler$TripwireData[" + "attached=" + tripwireData.attached + ", " + "disarmed=" + tripwireData.disarmed + ", " + "powered=" + tripwireData.powered + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(TripwireData tripwireData) {
            Object[] objectArray = new Object[]{tripwireData.attached, tripwireData.disarmed, tripwireData.powered};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(TripwireData tripwireData, Object object) {
            if (tripwireData == object) {
                return true;
            }
            if (object != null && object instanceof TripwireData) {
                TripwireData tripwireData2 = (TripwireData)object;
                if (tripwireData.attached == tripwireData2.attached && tripwireData.disarmed == tripwireData2.disarmed && tripwireData.powered == tripwireData2.powered) {
                    return true;
                }
            }
            return false;
        }
    }
}

