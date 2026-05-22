/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.movement.rotation.aabb_to_vec;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.utils.movement.rotation.aabb_to_vec.AABBToVecMode;
import net.darkmeow.darkmeow.utils.world.AxisAlignedBBUtils;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecModeClosest;", "Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecMode;", "shirk", "", "<init>", "(D)V", "getShirk", "()D", "apply", "Lnet/minecraft/util/math/Vec3d;", "aabb", "Lnet/minecraft/util/math/AxisAlignedBB;", "eye", "DarkMeow"})
public final class AABBToVecModeClosest
implements AABBToVecMode {
    private final double shirk;

    public AABBToVecModeClosest(double shirk) {
        this.shirk = shirk;
    }

    public /* synthetic */ AABBToVecModeClosest(double d2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            d2 = 0.0;
        }
        this(d2);
    }

    public final double getShirk() {
        return this.shirk;
    }

    @Override
    @NotNull
    public Vec3d apply(@NotNull AxisAlignedBB aabb, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter(aabb, "aabb");
        Intrinsics.checkNotNullParameter(eye, "eye");
        AxisAlignedBB axisAlignedBB = AxisAlignedBBUtils.INSTANCE.shirkSafe(aabb, this.shirk, this.shirk, this.shirk);
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "shirkSafe(...)");
        return AxisAlignedBBUtils.INSTANCE.getClosest(axisAlignedBB, eye);
    }

    public AABBToVecModeClosest() {
        this(0.0, 1, null);
    }
}

