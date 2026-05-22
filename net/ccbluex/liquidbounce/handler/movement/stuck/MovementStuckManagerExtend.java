/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.movement.stuck;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckInfo;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManager;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerStatic;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007J\n\u0010\u000b\u001a\u00020\u0005*\u00020\u0006J\n\u0010\f\u001a\u00020\r*\u00020\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManagerExtend;", "", "<init>", "()V", "travelOnStuck", "", "Lnet/minecraft/client/entity/EntityPlayerSP;", "strafe", "", "vertical", "forward", "syncPositionToServerOnStuck", "getSafeReleaseCount", "", "Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager;", "DarkMeow"})
public final class MovementStuckManagerExtend {
    @NotNull
    public static final MovementStuckManagerExtend INSTANCE = new MovementStuckManagerExtend();

    private MovementStuckManagerExtend() {
    }

    @JvmOverloads
    public final void travelOnStuck(@NotNull EntityPlayerSP $this$travelOnStuck, float strafe, float vertical, float forward) {
        MovementStuckInfo info;
        MovementStuckInfo movementStuckInfo;
        Intrinsics.checkNotNullParameter($this$travelOnStuck, "<this>");
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().allowMoving = true;
        DarkMeow.mc.field_71476_x = RotationManagerStatic.RAT_TRACE_MISS;
        MovementStuckInfo movementStuckInfo2 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().getStuckInfo();
        if (movementStuckInfo2 != null) {
            info = movementStuckInfo = movementStuckInfo2;
            boolean bl2 = false;
            $this$travelOnStuck.field_70159_w = info.getMotionX();
            $this$travelOnStuck.field_70181_x = info.getMotionY();
            $this$travelOnStuck.field_70179_y = info.getMotionZ();
            $this$travelOnStuck.field_70143_R = info.getFallDistance();
        }
        $this$travelOnStuck.func_191986_a(strafe, vertical, forward);
        MovementStuckInfo movementStuckInfo3 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().getStuckInfo();
        if (movementStuckInfo3 != null) {
            info = movementStuckInfo = movementStuckInfo3;
            boolean bl3 = false;
            info.setMotionX($this$travelOnStuck.field_70159_w);
            info.setMotionY($this$travelOnStuck.field_70181_x);
            info.setMotionZ($this$travelOnStuck.field_70179_y);
            info.setFallDistance($this$travelOnStuck.field_70143_R);
        }
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().allowMoving = false;
    }

    public static /* synthetic */ void travelOnStuck$default(MovementStuckManagerExtend movementStuckManagerExtend, EntityPlayerSP entityPlayerSP, float f2, float f3, float f4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = entityPlayerSP.field_70702_br;
        }
        if ((n2 & 2) != 0) {
            f3 = entityPlayerSP.field_70701_bs;
        }
        if ((n2 & 4) != 0) {
            f4 = entityPlayerSP.field_191988_bg;
        }
        movementStuckManagerExtend.travelOnStuck(entityPlayerSP, f2, f3, f4);
    }

    public final void syncPositionToServerOnStuck(@NotNull EntityPlayerSP $this$syncPositionToServerOnStuck) {
        Intrinsics.checkNotNullParameter($this$syncPositionToServerOnStuck, "<this>");
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().allowUpdatingWalking = true;
        ExtendEntityPlayerSP.INSTANCE.onUpdateWalkingPlayer($this$syncPositionToServerOnStuck);
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().allowUpdatingWalking = false;
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().setCancelPlayerSPUpdateWalkingCount(0);
        DarkMeow.mc.field_71460_t.func_78473_a(1.0f);
    }

    public final int getSafeReleaseCount(@NotNull MovementStuckManager $this$getSafeReleaseCount) {
        Intrinsics.checkNotNullParameter($this$getSafeReleaseCount, "<this>");
        return RangesKt.coerceIn($this$getSafeReleaseCount.getCancelPlayerSPUpdateWalkingCount(), new IntRange(2, 40)) - 2;
    }

    @JvmOverloads
    public final void travelOnStuck(@NotNull EntityPlayerSP $this$travelOnStuck, float strafe, float vertical) {
        Intrinsics.checkNotNullParameter($this$travelOnStuck, "<this>");
        MovementStuckManagerExtend.travelOnStuck$default(this, $this$travelOnStuck, strafe, vertical, 0.0f, 4, null);
    }

    @JvmOverloads
    public final void travelOnStuck(@NotNull EntityPlayerSP $this$travelOnStuck, float strafe) {
        Intrinsics.checkNotNullParameter($this$travelOnStuck, "<this>");
        MovementStuckManagerExtend.travelOnStuck$default(this, $this$travelOnStuck, strafe, 0.0f, 0.0f, 6, null);
    }

    @JvmOverloads
    public final void travelOnStuck(@NotNull EntityPlayerSP $this$travelOnStuck) {
        Intrinsics.checkNotNullParameter($this$travelOnStuck, "<this>");
        MovementStuckManagerExtend.travelOnStuck$default(this, $this$travelOnStuck, 0.0f, 0.0f, 0.0f, 7, null);
    }
}

