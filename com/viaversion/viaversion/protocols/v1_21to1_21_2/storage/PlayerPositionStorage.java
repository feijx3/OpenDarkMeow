/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PlayerPosition.class})
public class PlayerPositionStorage
implements StorableObject {
    private final IntSet pendingPongs = new IntOpenHashSet();
    private boolean captureNextPlayerPositionPacket;
    private PlayerPosition playerPosition;

    public void sendPing(UserConnection connection, int id) {
        if (!this.pendingPongs.add(id)) {
            throw new IllegalStateException(PlayerPositionStorage.jvmdowngrader$concat$sendPing$1(id));
        }
        PacketWrapper ping = PacketWrapper.create(ClientboundPackets1_21_2.PING, connection);
        ping.write(Types.INT, id);
        ping.send(Protocol1_21To1_21_2.class);
    }

    public boolean checkPong(int id) {
        if (this.pendingPongs.remove(id)) {
            this.reset();
            this.captureNextPlayerPositionPacket = true;
            return true;
        }
        return false;
    }

    public boolean checkCaptureNextPlayerPositionPacket() {
        if (this.captureNextPlayerPositionPacket) {
            this.captureNextPlayerPositionPacket = false;
            return true;
        }
        this.reset();
        return false;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean checkHasPlayerPosition() {
        if (this.playerPosition != null) {
            return true;
        }
        this.reset();
        return false;
    }

    public void sendMovePlayerPosRot(UserConnection user) {
        PacketWrapper movePlayerPosRot = PacketWrapper.create(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, user);
        movePlayerPosRot.write(Types.DOUBLE, this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$x());
        movePlayerPosRot.write(Types.DOUBLE, this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$y());
        movePlayerPosRot.write(Types.DOUBLE, this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$z());
        movePlayerPosRot.write(Types.FLOAT, Float.valueOf(this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$yaw()));
        movePlayerPosRot.write(Types.FLOAT, Float.valueOf(this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$pitch()));
        movePlayerPosRot.write(Types.BOOLEAN, this.playerPosition.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$onGround());
        movePlayerPosRot.sendToServer(Protocol1_21To1_21_2.class);
        this.reset();
    }

    public void reset() {
        this.captureNextPlayerPositionPacket = false;
        this.playerPosition = null;
    }

    private static String jvmdowngrader$concat$sendPing$1(int n2) {
        return "Pong already pending for id " + n2;
    }

    @RecordComponents(value={@RecordComponents.Value(name="x", type=double.class), @RecordComponents.Value(name="y", type=double.class), @RecordComponents.Value(name="z", type=double.class), @RecordComponents.Value(name="yaw", type=float.class), @RecordComponents.Value(name="pitch", type=float.class), @RecordComponents.Value(name="onGround", type=boolean.class)})
    @NestHost(value=PlayerPositionStorage.class)
    public static final class PlayerPosition
    extends J_L_Record {
        private final double x;
        private final double y;
        private final double z;
        private final float yaw;
        private final float pitch;
        private final boolean onGround;

        public PlayerPosition(double x2, double y2, double z2, float yaw, float pitch, boolean onGround) {
            this.x = x2;
            this.y = y2;
            this.z = z2;
            this.yaw = yaw;
            this.pitch = pitch;
            this.onGround = onGround;
        }

        @Override
        public final String toString() {
            return PlayerPosition.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PlayerPosition.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PlayerPosition.jvmdowngrader$equals$equals(this, o2);
        }

        public double x() {
            return this.x;
        }

        public double y() {
            return this.y;
        }

        public double z() {
            return this.z;
        }

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }

        public boolean onGround() {
            return this.onGround;
        }

        private static String jvmdowngrader$toString$toString(PlayerPosition playerPosition) {
            PlayerPosition playerPosition2 = playerPosition;
            return "PlayerPositionStorage$PlayerPosition[" + "x=" + playerPosition.x + ", " + "y=" + playerPosition.y + ", " + "z=" + playerPosition.z + ", " + "yaw=" + playerPosition.yaw + ", " + "pitch=" + playerPosition.pitch + ", " + "onGround=" + playerPosition.onGround + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PlayerPosition playerPosition) {
            Object[] objectArray = new Object[]{playerPosition.x, playerPosition.y, playerPosition.z, Float.valueOf(playerPosition.yaw), Float.valueOf(playerPosition.pitch), playerPosition.onGround};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PlayerPosition playerPosition, Object object) {
            if (playerPosition == object) {
                return true;
            }
            if (object != null && object instanceof PlayerPosition) {
                PlayerPosition playerPosition2 = (PlayerPosition)object;
                if (playerPosition.x == playerPosition2.x && playerPosition.y == playerPosition2.y && playerPosition.z == playerPosition2.z && playerPosition.yaw == playerPosition2.yaw && playerPosition.pitch == playerPosition2.pitch && playerPosition.onGround == playerPosition2.onGround) {
                    return true;
                }
            }
            return false;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$x() {
            return this.x;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$x(double d2) {
            this.x = d2;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$y() {
            return this.y;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$y(double d2) {
            this.y = d2;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$z() {
            return this.z;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$z(double d2) {
            this.z = d2;
        }

        public float jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$pitch() {
            return this.pitch;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$pitch(float f2) {
            this.pitch = f2;
        }

        public boolean jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$onGround() {
            return this.onGround;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$onGround(boolean bl2) {
            this.onGround = bl2;
        }

        public float jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$get$yaw() {
            return this.yaw;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_storage_PlayerPositionStorage$PlayerPosition$set$yaw(float f2) {
            this.yaw = f2;
        }
    }
}

