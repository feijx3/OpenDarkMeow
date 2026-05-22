/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.ThroughWallCheck;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/impl/ThroughWallCheckLimit;", "Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;", "throughWallRange", "", "<init>", "(D)V", "apply", "range", "entity", "Lnet/minecraft/entity/Entity;", "eyeVec", "Lnet/minecraft/util/math/Vec3d;", "partialTicks", "", "DarkMeow"})
public final class ThroughWallCheckLimit
implements ThroughWallCheck {
    @JvmField
    public final double throughWallRange;

    public ThroughWallCheckLimit(double throughWallRange) {
        this.throughWallRange = throughWallRange;
    }

    @Override
    public double apply(double range, @NotNull Entity entity, @NotNull Vec3d eyeVec, float partialTicks) {
        Vec3d vec3d;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(eyeVec, "eyeVec");
        RayTraceResult rayTraceResult = entity.func_174822_a(range + 1.0, partialTicks);
        return rayTraceResult != null && (vec3d = rayTraceResult.field_72307_f) != null ? RangesKt.coerceAtLeast(vec3d.func_72438_d(eyeVec), this.throughWallRange) : range;
    }
}

