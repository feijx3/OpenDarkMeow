/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.rotation.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/utils/RotationUtils;", "", "<init>", "()V", "limitAngleChange", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "currentRotation", "targetRotation", "turnSpeed", "", "getRotationDifference", "", "rotation", "a", "b", "getAngleDifference", "getVectorForRotation", "Lnet/minecraft/util/math/Vec3d;", "normalizeAngle", "angleIn", "DarkMeow"})
public final class RotationUtils {
    @NotNull
    public static final RotationUtils INSTANCE = new RotationUtils();

    private RotationUtils() {
    }

    @NotNull
    public final Rotation limitAngleChange(@NotNull Rotation currentRotation, @NotNull Rotation targetRotation, float turnSpeed) {
        Intrinsics.checkNotNullParameter(currentRotation, "currentRotation");
        Intrinsics.checkNotNullParameter(targetRotation, "targetRotation");
        float yawDifference = this.getAngleDifference(targetRotation.yaw, currentRotation.yaw);
        float pitchDifference = this.getAngleDifference(targetRotation.pitch, currentRotation.pitch);
        return new Rotation(currentRotation.yaw + (yawDifference > turnSpeed ? turnSpeed : Math.max(yawDifference, -turnSpeed)), currentRotation.pitch + (pitchDifference > turnSpeed ? turnSpeed : Math.max(pitchDifference, -turnSpeed)));
    }

    public final double getRotationDifference(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Rotation rotation2 = DarkMeow.INSTANCE.getRotationManager().serverRotation;
        if (rotation2 == null) {
            return 0.0;
        }
        Rotation sr = rotation2;
        return this.getRotationDifference(rotation, sr);
    }

    public final double getRotationDifference(@NotNull Rotation a2, @Nullable Rotation b2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        float f2 = a2.yaw;
        Rotation rotation = b2;
        Intrinsics.checkNotNull(rotation);
        return Math.hypot(this.getAngleDifference(f2, rotation.yaw), a2.pitch - b2.pitch);
    }

    public final float getAngleDifference(float a2, float b2) {
        return ((a2 - b2) % 360.0f + 540.0f) % 360.0f - 180.0f;
    }

    @NotNull
    public final Vec3d getVectorForRotation(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        float yawCos = (float)Math.cos(-rotation.yaw * ((float)Math.PI / 180) - (float)Math.PI);
        float yawSin = (float)Math.sin(-rotation.yaw * ((float)Math.PI / 180) - (float)Math.PI);
        float pitchCos = (float)(-Math.cos(-rotation.pitch * ((float)Math.PI / 180)));
        float pitchSin = (float)Math.sin(-rotation.pitch * ((float)Math.PI / 180));
        return new Vec3d((double)(yawSin * pitchCos), (double)pitchSin, (double)(yawCos * pitchCos));
    }

    public final double normalizeAngle(double angleIn) {
        double angle = angleIn;
        if ((angle %= 360.0) >= 180.0) {
            angle -= 360.0;
        }
        if (angle < -180.0) {
            angle += 360.0;
        }
        return angle;
    }

    public final float normalizeAngle(float angleIn) {
        float angle = angleIn;
        if ((angle %= 360.0f) >= 180.0f) {
            angle -= 360.0f;
        } else if (angle < -180.0f) {
            angle += 360.0f;
        }
        return angle;
    }
}

