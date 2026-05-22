/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viabackwards.api.entities.storage.PlayerPositionStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PlayerInput.class})
public final class PlayerStorage
extends PlayerPositionStorage {
    private static final PlayerInput EMPTY = new PlayerInput(false, false, false, false, false, false, false);
    private static final float PLAYER_JUMP_HEIGHT = 0.42f;
    private float yaw;
    private float pitch;
    private boolean playerCommandTrackedSneaking;
    private boolean playerCommandTrackedSprinting;
    private PlayerInput lastInput = EMPTY;
    private double prevX;
    private double prevY;
    private double prevZ;

    public void tick(UserConnection user) {
        boolean jump;
        boolean right;
        boolean left;
        boolean backwards;
        double deltaX = this.x() - this.prevX;
        double deltaY = this.y() - this.prevY;
        double deltaZ = this.z() - this.prevZ;
        double magnitude = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
        double directionX = magnitude > 0.0 ? deltaX / magnitude : 0.0;
        double directionZ = magnitude > 0.0 ? deltaZ / magnitude : 0.0;
        directionX = Math.max(-1.0, Math.min(1.0, directionX));
        directionZ = Math.max(-1.0, Math.min(1.0, directionZ));
        double angle = Math.toRadians(-this.yaw);
        double newDirectionX = directionX * Math.cos(angle) - directionZ * Math.sin(angle);
        double newDirectionZ = directionX * Math.sin(angle) + directionZ * Math.cos(angle);
        boolean forward = newDirectionZ >= (double)0.65f;
        PlayerInput input = new PlayerInput(forward, backwards = newDirectionZ <= (double)-0.65f, left = newDirectionX >= (double)0.65f, right = newDirectionX <= (double)-0.65f, jump = Math.abs(deltaY - (double)0.42f) <= (double)1.0E-4f, this.playerCommandTrackedSneaking, this.playerCommandTrackedSprinting);
        if (!this.lastInput.equals(input)) {
            PacketWrapper playerInputPacket = PacketWrapper.create(ServerboundPackets1_21_2.PLAYER_INPUT, user);
            byte flags = 0;
            flags = (byte)(flags | (input.forward() ? 1 : 0));
            flags = (byte)(flags | (input.backward() ? 2 : 0));
            flags = (byte)(flags | (input.left() ? 4 : 0));
            flags = (byte)(flags | (input.right() ? 8 : 0));
            flags = (byte)(flags | (input.jump() ? 16 : 0));
            flags = (byte)(flags | (input.sneak() ? 32 : 0));
            flags = (byte)(flags | (input.sprint() ? 64 : 0));
            playerInputPacket.write(Types.BYTE, flags);
            playerInputPacket.sendToServer(Protocol1_21_2To1_21.class);
            this.lastInput = input;
        }
        this.prevX = this.x();
        this.prevY = this.y();
        this.prevZ = this.z();
    }

    public float yaw() {
        return this.yaw;
    }

    public float pitch() {
        return this.pitch;
    }

    public void setRotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public void setPlayerCommandTrackedSneaking(boolean playerCommandTrackedSneaking) {
        this.playerCommandTrackedSneaking = playerCommandTrackedSneaking;
    }

    public void setPlayerCommandTrackedSprinting(boolean playerCommandTrackedSprinting) {
        this.playerCommandTrackedSprinting = playerCommandTrackedSprinting;
    }

    public boolean setSneaking(boolean sneaking) {
        boolean changed = this.playerCommandTrackedSneaking != sneaking;
        this.playerCommandTrackedSneaking = sneaking;
        return changed;
    }

    @RecordComponents(value={@RecordComponents.Value(name="forward", type=boolean.class), @RecordComponents.Value(name="backward", type=boolean.class), @RecordComponents.Value(name="left", type=boolean.class), @RecordComponents.Value(name="right", type=boolean.class), @RecordComponents.Value(name="jump", type=boolean.class), @RecordComponents.Value(name="sneak", type=boolean.class), @RecordComponents.Value(name="sprint", type=boolean.class)})
    @NestHost(value=PlayerStorage.class)
    public static final class PlayerInput
    extends J_L_Record {
        private final boolean forward;
        private final boolean backward;
        private final boolean left;
        private final boolean right;
        private final boolean jump;
        private final boolean sneak;
        private final boolean sprint;

        public PlayerInput(boolean forward, boolean backward, boolean left, boolean right, boolean jump, boolean sneak, boolean sprint) {
            this.forward = forward;
            this.backward = backward;
            this.left = left;
            this.right = right;
            this.jump = jump;
            this.sneak = sneak;
            this.sprint = sprint;
        }

        @Override
        public final String toString() {
            return PlayerInput.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PlayerInput.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PlayerInput.jvmdowngrader$equals$equals(this, o2);
        }

        public boolean forward() {
            return this.forward;
        }

        public boolean backward() {
            return this.backward;
        }

        public boolean left() {
            return this.left;
        }

        public boolean right() {
            return this.right;
        }

        public boolean jump() {
            return this.jump;
        }

        public boolean sneak() {
            return this.sneak;
        }

        public boolean sprint() {
            return this.sprint;
        }

        private static String jvmdowngrader$toString$toString(PlayerInput playerInput) {
            PlayerInput playerInput2 = playerInput;
            return "PlayerStorage$PlayerInput[" + "forward=" + playerInput.forward + ", " + "backward=" + playerInput.backward + ", " + "left=" + playerInput.left + ", " + "right=" + playerInput.right + ", " + "jump=" + playerInput.jump + ", " + "sneak=" + playerInput.sneak + ", " + "sprint=" + playerInput.sprint + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PlayerInput playerInput) {
            Object[] objectArray = new Object[]{playerInput.forward, playerInput.backward, playerInput.left, playerInput.right, playerInput.jump, playerInput.sneak, playerInput.sprint};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PlayerInput playerInput, Object object) {
            if (playerInput == object) {
                return true;
            }
            if (object != null && object instanceof PlayerInput) {
                PlayerInput playerInput2 = (PlayerInput)object;
                if (playerInput.forward == playerInput2.forward && playerInput.backward == playerInput2.backward && playerInput.left == playerInput2.left && playerInput.right == playerInput2.right && playerInput.jump == playerInput2.jump && playerInput.sneak == playerInput2.sneak && playerInput.sprint == playerInput2.sprint) {
                    return true;
                }
            }
            return false;
        }
    }
}

