/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.rotation.utils.RotationUtils;
import net.darkmeow.darkmeow.utils.math.MathUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\n\u0010\r\u001a\u00020\u000e*\u00020\u000fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016J\n\u0010\u0017\u001a\u00020\u0015*\u00020\u0016J\n\u0010\u0018\u001a\u00020\u0015*\u00020\u0016J\n\u0010\u0019\u001a\u00020\u0007*\u00020\u0016\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/utils/MovementUtils;", "", "<init>", "()V", "calcMovementInput", "Lnet/minecraft/util/math/Vec3d;", "forward", "", "backward", "left", "right", "up", "down", "calcMoveYaw", "", "Lnet/minecraft/client/entity/EntityPlayerSP;", "yaw", "", "moveForward", "moveStrafe", "resetMove", "", "Lnet/minecraft/util/MovementInput;", "resetJumpSneak", "reset", "hasMove", "DarkMeow"})
public final class MovementUtils {
    @NotNull
    public static final MovementUtils INSTANCE = new MovementUtils();

    private MovementUtils() {
    }

    @NotNull
    public final Vec3d calcMovementInput(boolean forward, boolean backward, boolean left, boolean right, boolean up, boolean down) {
        double d2;
        double moveForward = 0.0;
        double moveStrafing = 0.0;
        double moveVertical = 0.0;
        if (forward) {
            d2 = moveForward;
            moveForward = d2 + 1.0;
        }
        if (backward) {
            d2 = moveForward;
            moveForward = d2 + -1.0;
        }
        if (left) {
            d2 = moveStrafing;
            moveStrafing = d2 + 1.0;
        }
        if (right) {
            d2 = moveStrafing;
            moveStrafing = d2 + -1.0;
        }
        if (up) {
            d2 = moveVertical;
            moveVertical = d2 + 1.0;
        }
        if (down) {
            d2 = moveVertical;
            moveVertical = d2 + -1.0;
        }
        return new Vec3d(moveStrafing, moveVertical, moveForward);
    }

    public final double calcMoveYaw(@NotNull EntityPlayerSP $this$calcMoveYaw) {
        Intrinsics.checkNotNullParameter($this$calcMoveYaw, "<this>");
        return this.calcMoveYaw($this$calcMoveYaw.field_70177_z, $this$calcMoveYaw.field_71158_b.field_192832_b, $this$calcMoveYaw.field_71158_b.field_78902_a);
    }

    public final double calcMoveYaw(float yaw, float moveForward, float moveStrafe) {
        double moveYaw = moveForward == 0.0f && moveStrafe == 0.0f ? 0.0 : (double)MathUtils.INSTANCE.toDegree((float)Math.atan2(moveForward, moveStrafe)) - 90.0;
        return MathUtils.INSTANCE.toRadians(RotationUtils.INSTANCE.normalizeAngle((double)yaw + moveYaw));
    }

    public final void resetMove(@NotNull MovementInput $this$resetMove) {
        Intrinsics.checkNotNullParameter($this$resetMove, "<this>");
        $this$resetMove.field_192832_b = 0.0f;
        $this$resetMove.field_78902_a = 0.0f;
        $this$resetMove.field_187255_c = false;
        $this$resetMove.field_187256_d = false;
        $this$resetMove.field_187257_e = false;
        $this$resetMove.field_187258_f = false;
    }

    public final void resetJumpSneak(@NotNull MovementInput $this$resetJumpSneak) {
        Intrinsics.checkNotNullParameter($this$resetJumpSneak, "<this>");
        $this$resetJumpSneak.field_78901_c = false;
        $this$resetJumpSneak.field_78899_d = false;
    }

    public final void reset(@NotNull MovementInput $this$reset) {
        Intrinsics.checkNotNullParameter($this$reset, "<this>");
        this.resetMove($this$reset);
        this.resetJumpSneak($this$reset);
    }

    public final boolean hasMove(@NotNull MovementInput $this$hasMove) {
        Intrinsics.checkNotNullParameter($this$hasMove, "<this>");
        return !($this$hasMove.field_192832_b == 0.0f) || !($this$hasMove.field_78902_a == 0.0f) || $this$hasMove.field_78901_c;
    }
}

