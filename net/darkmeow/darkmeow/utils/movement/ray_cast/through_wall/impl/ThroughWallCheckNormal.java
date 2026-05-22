/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.ThroughWallCheck;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/impl/ThroughWallCheckNormal;", "Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;", "<init>", "()V", "apply", "", "range", "entity", "Lnet/minecraft/entity/Entity;", "eyeVec", "Lnet/minecraft/util/math/Vec3d;", "partialTicks", "", "DarkMeow"})
public final class ThroughWallCheckNormal
implements ThroughWallCheck {
    @Override
    public double apply(double range, @NotNull Entity entity, @NotNull Vec3d eyeVec, float partialTicks) {
        Vec3d vec3d;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(eyeVec, "eyeVec");
        RayTraceResult rayTraceResult = entity.func_174822_a(range + 1.0, partialTicks);
        return rayTraceResult != null && (vec3d = rayTraceResult.field_72307_f) != null ? vec3d.func_72438_d(eyeVec) : range;
    }
}

