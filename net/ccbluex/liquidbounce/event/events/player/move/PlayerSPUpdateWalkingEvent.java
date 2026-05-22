/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.move;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent;", "", "<init>", "()V", "SyncPositionType", "PRE", "POST", "DarkMeow"})
public final class PlayerSPUpdateWalkingEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0012\u0010\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$POST;", "Lnet/ccbluex/liquidbounce/event/Event;", "isCancelled", "", "lastSyncPositionType", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$SyncPositionType;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "sprintState", "sneakState", "posX", "", "posY", "posZ", "rotationYaw", "", "rotationPitch", "onGround", "<init>", "(ZLnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$SyncPositionType;Lnet/minecraft/client/entity/EntityPlayerSP;ZZDDDFFZ)V", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "(Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;)V", "DarkMeow"})
    public static final class POST
    extends Event {
        @JvmField
        public final boolean isCancelled;
        @JvmField
        @NotNull
        public final SyncPositionType lastSyncPositionType;
        @JvmField
        @NotNull
        public final EntityPlayerSP player;
        @JvmField
        public final boolean sprintState;
        @JvmField
        public final boolean sneakState;
        @JvmField
        public final double posX;
        @JvmField
        public final double posY;
        @JvmField
        public final double posZ;
        @JvmField
        public final float rotationYaw;
        @JvmField
        public final float rotationPitch;
        @JvmField
        public final boolean onGround;

        public POST(boolean isCancelled, @NotNull SyncPositionType lastSyncPositionType, @NotNull EntityPlayerSP player, boolean sprintState, boolean sneakState, double posX, double posY, double posZ, float rotationYaw, float rotationPitch, boolean onGround) {
            Intrinsics.checkNotNullParameter((Object)lastSyncPositionType, "lastSyncPositionType");
            Intrinsics.checkNotNullParameter(player, "player");
            this.isCancelled = isCancelled;
            this.lastSyncPositionType = lastSyncPositionType;
            this.player = player;
            this.sprintState = sprintState;
            this.sneakState = sneakState;
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
            this.rotationYaw = rotationYaw;
            this.rotationPitch = rotationPitch;
            this.onGround = onGround;
        }

        public POST(@NotNull PRE event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this(event.isCancelled(), event.getSyncPositionType(), event.player, event.sprintState, event.sneakState, event.posX, event.posY, event.posZ, event.rotationYaw, event.rotationPitch, event.onGround);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "syncPosition", "", "serverSprintState", "serverSneakState", "lastReportedPosX", "", "lastReportedPosY", "lastReportedPosZ", "lastReportedYaw", "", "lastReportedPitch", "lastReportedOnGround", "positionUpdateTicks", "", "sprintState", "sneakState", "posX", "posY", "posZ", "rotationYaw", "rotationPitch", "onGround", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;ZZZDDDFFZIZZDDDFFZ)V", "getSyncPositionType", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$SyncPositionType;", "DarkMeow"})
    public static final class PRE
    extends CancellableEvent {
        @JvmField
        @NotNull
        public final EntityPlayerSP player;
        @JvmField
        public boolean syncPosition;
        @JvmField
        public final boolean serverSprintState;
        @JvmField
        public final boolean serverSneakState;
        @JvmField
        public final double lastReportedPosX;
        @JvmField
        public final double lastReportedPosY;
        @JvmField
        public final double lastReportedPosZ;
        @JvmField
        public final float lastReportedYaw;
        @JvmField
        public final float lastReportedPitch;
        @JvmField
        public final boolean lastReportedOnGround;
        @JvmField
        public final int positionUpdateTicks;
        @JvmField
        public final boolean sprintState;
        @JvmField
        public final boolean sneakState;
        @JvmField
        public double posX;
        @JvmField
        public double posY;
        @JvmField
        public double posZ;
        @JvmField
        public float rotationYaw;
        @JvmField
        public float rotationPitch;
        @JvmField
        public boolean onGround;

        public PRE(@NotNull EntityPlayerSP player, boolean syncPosition, boolean serverSprintState, boolean serverSneakState, double lastReportedPosX, double lastReportedPosY, double lastReportedPosZ, float lastReportedYaw, float lastReportedPitch, boolean lastReportedOnGround, int positionUpdateTicks, boolean sprintState, boolean sneakState, double posX, double posY, double posZ, float rotationYaw, float rotationPitch, boolean onGround) {
            Intrinsics.checkNotNullParameter(player, "player");
            this.player = player;
            this.syncPosition = syncPosition;
            this.serverSprintState = serverSprintState;
            this.serverSneakState = serverSneakState;
            this.lastReportedPosX = lastReportedPosX;
            this.lastReportedPosY = lastReportedPosY;
            this.lastReportedPosZ = lastReportedPosZ;
            this.lastReportedYaw = lastReportedYaw;
            this.lastReportedPitch = lastReportedPitch;
            this.lastReportedOnGround = lastReportedOnGround;
            this.positionUpdateTicks = positionUpdateTicks;
            this.sprintState = sprintState;
            this.sneakState = sneakState;
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
            this.rotationYaw = rotationYaw;
            this.rotationPitch = rotationPitch;
            this.onGround = onGround;
        }

        @NotNull
        public final SyncPositionType getSyncPositionType() {
            double posXOffset = this.posX - this.lastReportedPosX;
            double posYOffset = this.posY - this.lastReportedPosY;
            double posZOffset = this.posZ - this.lastReportedPosZ;
            boolean syncPosition = posXOffset * posXOffset + posYOffset * posYOffset + posZOffset * posZOffset > 9.0E-4 || this.positionUpdateTicks >= 20;
            boolean syncRotation = !(this.rotationYaw - this.lastReportedYaw == 0.0f) || !(this.rotationPitch - this.lastReportedPitch == 0.0f);
            return this.player.func_184218_aH() ? SyncPositionType.RIDING : (syncPosition && syncRotation ? SyncPositionType.POSITION_ROTATION : (syncPosition ? SyncPositionType.POSITION : (syncRotation ? SyncPositionType.ROTATION : (this.lastReportedOnGround != this.onGround ? SyncPositionType.ONLY_ON_GROUND : SyncPositionType.NONE))));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$SyncPositionType;", "", "position", "", "rotation", "<init>", "(Ljava/lang/String;IZZ)V", "getPosition", "()Z", "getRotation", "RIDING", "POSITION_ROTATION", "POSITION", "ROTATION", "ONLY_ON_GROUND", "NONE", "DarkMeow"})
    public static final class SyncPositionType
    extends Enum<SyncPositionType> {
        private final boolean position;
        private final boolean rotation;
        public static final /* enum */ SyncPositionType RIDING = new SyncPositionType(false, true);
        public static final /* enum */ SyncPositionType POSITION_ROTATION = new SyncPositionType(true, true);
        public static final /* enum */ SyncPositionType POSITION = new SyncPositionType(true, false);
        public static final /* enum */ SyncPositionType ROTATION = new SyncPositionType(false, true);
        public static final /* enum */ SyncPositionType ONLY_ON_GROUND = new SyncPositionType(false, false);
        public static final /* enum */ SyncPositionType NONE = new SyncPositionType(false, false);
        private static final /* synthetic */ SyncPositionType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private SyncPositionType(boolean position, boolean rotation) {
            this.position = position;
            this.rotation = rotation;
        }

        public final boolean getPosition() {
            return this.position;
        }

        public final boolean getRotation() {
            return this.rotation;
        }

        public static SyncPositionType[] values() {
            return (SyncPositionType[])$VALUES.clone();
        }

        public static SyncPositionType valueOf(String value) {
            return Enum.valueOf(SyncPositionType.class, value);
        }

        @NotNull
        public static EnumEntries<SyncPositionType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = syncPositionTypeArray = new SyncPositionType[]{SyncPositionType.RIDING, SyncPositionType.POSITION_ROTATION, SyncPositionType.POSITION, SyncPositionType.ROTATION, SyncPositionType.ONLY_ON_GROUND, SyncPositionType.NONE};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

