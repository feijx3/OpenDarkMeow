/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.movement.stuck;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0004\b\u000f\u0010\u0013J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003J\t\u0010-\u001a\u00020\tH\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\tH\u00c6\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u00c6\u0001J\u0013\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!\u00a8\u00068"}, d2={"Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckInfo;", "", "motionX", "", "motionY", "motionZ", "fallDistance", "", "beforeSprintingStatus", "", "beforeSneakingStatus", "beforeMovementInputForward", "beforeMovementInputBack", "beforeMovementInputLeft", "beforeMovementInputRight", "<init>", "(DDDFZZZZZZ)V", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "(Lnet/minecraft/client/entity/EntityPlayerSP;)V", "getMotionX", "()D", "setMotionX", "(D)V", "getMotionY", "setMotionY", "getMotionZ", "setMotionZ", "getFallDistance", "()F", "setFallDistance", "(F)V", "getBeforeSprintingStatus", "()Z", "getBeforeSneakingStatus", "getBeforeMovementInputForward", "getBeforeMovementInputBack", "getBeforeMovementInputLeft", "getBeforeMovementInputRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class MovementStuckInfo {
    private double motionX;
    private double motionY;
    private double motionZ;
    private float fallDistance;
    private final boolean beforeSprintingStatus;
    private final boolean beforeSneakingStatus;
    private final boolean beforeMovementInputForward;
    private final boolean beforeMovementInputBack;
    private final boolean beforeMovementInputLeft;
    private final boolean beforeMovementInputRight;

    public MovementStuckInfo(double motionX, double motionY, double motionZ, float fallDistance, boolean beforeSprintingStatus, boolean beforeSneakingStatus, boolean beforeMovementInputForward, boolean beforeMovementInputBack, boolean beforeMovementInputLeft, boolean beforeMovementInputRight) {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        this.fallDistance = fallDistance;
        this.beforeSprintingStatus = beforeSprintingStatus;
        this.beforeSneakingStatus = beforeSneakingStatus;
        this.beforeMovementInputForward = beforeMovementInputForward;
        this.beforeMovementInputBack = beforeMovementInputBack;
        this.beforeMovementInputLeft = beforeMovementInputLeft;
        this.beforeMovementInputRight = beforeMovementInputRight;
    }

    public final double getMotionX() {
        return this.motionX;
    }

    public final void setMotionX(double d2) {
        this.motionX = d2;
    }

    public final double getMotionY() {
        return this.motionY;
    }

    public final void setMotionY(double d2) {
        this.motionY = d2;
    }

    public final double getMotionZ() {
        return this.motionZ;
    }

    public final void setMotionZ(double d2) {
        this.motionZ = d2;
    }

    public final float getFallDistance() {
        return this.fallDistance;
    }

    public final void setFallDistance(float f2) {
        this.fallDistance = f2;
    }

    public final boolean getBeforeSprintingStatus() {
        return this.beforeSprintingStatus;
    }

    public final boolean getBeforeSneakingStatus() {
        return this.beforeSneakingStatus;
    }

    public final boolean getBeforeMovementInputForward() {
        return this.beforeMovementInputForward;
    }

    public final boolean getBeforeMovementInputBack() {
        return this.beforeMovementInputBack;
    }

    public final boolean getBeforeMovementInputLeft() {
        return this.beforeMovementInputLeft;
    }

    public final boolean getBeforeMovementInputRight() {
        return this.beforeMovementInputRight;
    }

    public MovementStuckInfo(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this(player.field_70159_w, player.field_70181_x, player.field_70179_y, player.field_70143_R, player.func_70051_ag(), player.func_70093_af(), player.field_71158_b.field_187255_c, player.field_71158_b.field_187256_d, player.field_71158_b.field_187257_e, player.field_71158_b.field_187258_f);
    }

    public final double component1() {
        return this.motionX;
    }

    public final double component2() {
        return this.motionY;
    }

    public final double component3() {
        return this.motionZ;
    }

    public final float component4() {
        return this.fallDistance;
    }

    public final boolean component5() {
        return this.beforeSprintingStatus;
    }

    public final boolean component6() {
        return this.beforeSneakingStatus;
    }

    public final boolean component7() {
        return this.beforeMovementInputForward;
    }

    public final boolean component8() {
        return this.beforeMovementInputBack;
    }

    public final boolean component9() {
        return this.beforeMovementInputLeft;
    }

    public final boolean component10() {
        return this.beforeMovementInputRight;
    }

    @NotNull
    public final MovementStuckInfo copy(double motionX, double motionY, double motionZ, float fallDistance, boolean beforeSprintingStatus, boolean beforeSneakingStatus, boolean beforeMovementInputForward, boolean beforeMovementInputBack, boolean beforeMovementInputLeft, boolean beforeMovementInputRight) {
        return new MovementStuckInfo(motionX, motionY, motionZ, fallDistance, beforeSprintingStatus, beforeSneakingStatus, beforeMovementInputForward, beforeMovementInputBack, beforeMovementInputLeft, beforeMovementInputRight);
    }

    public static /* synthetic */ MovementStuckInfo copy$default(MovementStuckInfo movementStuckInfo, double d2, double d3, double d4, float f2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = movementStuckInfo.motionX;
        }
        if ((n2 & 2) != 0) {
            d3 = movementStuckInfo.motionY;
        }
        if ((n2 & 4) != 0) {
            d4 = movementStuckInfo.motionZ;
        }
        if ((n2 & 8) != 0) {
            f2 = movementStuckInfo.fallDistance;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = movementStuckInfo.beforeSprintingStatus;
        }
        if ((n2 & 0x20) != 0) {
            bl3 = movementStuckInfo.beforeSneakingStatus;
        }
        if ((n2 & 0x40) != 0) {
            bl4 = movementStuckInfo.beforeMovementInputForward;
        }
        if ((n2 & 0x80) != 0) {
            bl5 = movementStuckInfo.beforeMovementInputBack;
        }
        if ((n2 & 0x100) != 0) {
            bl6 = movementStuckInfo.beforeMovementInputLeft;
        }
        if ((n2 & 0x200) != 0) {
            bl7 = movementStuckInfo.beforeMovementInputRight;
        }
        return movementStuckInfo.copy(d2, d3, d4, f2, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    @NotNull
    public String toString() {
        return "MovementStuckInfo(motionX=" + this.motionX + ", motionY=" + this.motionY + ", motionZ=" + this.motionZ + ", fallDistance=" + this.fallDistance + ", beforeSprintingStatus=" + this.beforeSprintingStatus + ", beforeSneakingStatus=" + this.beforeSneakingStatus + ", beforeMovementInputForward=" + this.beforeMovementInputForward + ", beforeMovementInputBack=" + this.beforeMovementInputBack + ", beforeMovementInputLeft=" + this.beforeMovementInputLeft + ", beforeMovementInputRight=" + this.beforeMovementInputRight + ')';
    }

    public int hashCode() {
        int result = Double.hashCode(this.motionX);
        result = result * 31 + Double.hashCode(this.motionY);
        result = result * 31 + Double.hashCode(this.motionZ);
        result = result * 31 + Float.hashCode(this.fallDistance);
        result = result * 31 + Boolean.hashCode(this.beforeSprintingStatus);
        result = result * 31 + Boolean.hashCode(this.beforeSneakingStatus);
        result = result * 31 + Boolean.hashCode(this.beforeMovementInputForward);
        result = result * 31 + Boolean.hashCode(this.beforeMovementInputBack);
        result = result * 31 + Boolean.hashCode(this.beforeMovementInputLeft);
        result = result * 31 + Boolean.hashCode(this.beforeMovementInputRight);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovementStuckInfo)) {
            return false;
        }
        MovementStuckInfo movementStuckInfo = (MovementStuckInfo)other;
        if (Double.compare(this.motionX, movementStuckInfo.motionX) != 0) {
            return false;
        }
        if (Double.compare(this.motionY, movementStuckInfo.motionY) != 0) {
            return false;
        }
        if (Double.compare(this.motionZ, movementStuckInfo.motionZ) != 0) {
            return false;
        }
        if (Float.compare(this.fallDistance, movementStuckInfo.fallDistance) != 0) {
            return false;
        }
        if (this.beforeSprintingStatus != movementStuckInfo.beforeSprintingStatus) {
            return false;
        }
        if (this.beforeSneakingStatus != movementStuckInfo.beforeSneakingStatus) {
            return false;
        }
        if (this.beforeMovementInputForward != movementStuckInfo.beforeMovementInputForward) {
            return false;
        }
        if (this.beforeMovementInputBack != movementStuckInfo.beforeMovementInputBack) {
            return false;
        }
        if (this.beforeMovementInputLeft != movementStuckInfo.beforeMovementInputLeft) {
            return false;
        }
        return this.beforeMovementInputRight == movementStuckInfo.beforeMovementInputRight;
    }
}

