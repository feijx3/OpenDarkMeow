/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/utils/RaycastUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "raycastEntity", "Lnet/minecraft/entity/Entity;", "range", "", "entityFilter", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "yaw", "", "pitch", "EntityFilter", "DarkMeow"})
public final class RaycastUtils
extends MinecraftInstance {
    @NotNull
    public static final RaycastUtils INSTANCE = new RaycastUtils();

    private RaycastUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Entity raycastEntity(double range, @NotNull EntityFilter entityFilter) {
        Intrinsics.checkNotNullParameter(entityFilter, "entityFilter");
        return INSTANCE.raycastEntity(range, DarkMeow.INSTANCE.getRotationManager().serverRotation.yaw, DarkMeow.INSTANCE.getRotationManager().serverRotation.pitch, entityFilter);
    }

    @Nullable
    public final Entity raycastEntity(double range, float yaw, float pitch, @NotNull EntityFilter entityFilter) {
        Intrinsics.checkNotNullParameter(entityFilter, "entityFilter");
        Entity renderViewEntity = MinecraftInstance.mc.getRenderViewEntity();
        if (renderViewEntity != null && MinecraftInstance.mc.getWorld() != null) {
            double blockReachDistance = range;
            Vec3d eyePosition = renderViewEntity.func_174824_e(1.0f);
            float yawCos = (float)Math.cos(-yaw * ((float)Math.PI / 180) - (float)Math.PI);
            float yawSin = (float)Math.sin(-yaw * ((float)Math.PI / 180) - (float)Math.PI);
            float pitchCos = (float)(-Math.cos((double)(-pitch) * 0.01745329238474369));
            float pitchSin = (float)Math.sin((double)(-pitch) * 0.01745329238474369);
            Vec3d entityLook = new Vec3d((double)(yawSin * pitchCos), (double)pitchSin, (double)(yawCos * pitchCos));
            Vec3d vector = eyePosition.func_72441_c(entityLook.field_72450_a * blockReachDistance, entityLook.field_72448_b * blockReachDistance, entityLook.field_72449_c * blockReachDistance);
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            Intrinsics.checkNotNull(worldClient);
            List entityList = worldClient.func_175674_a(renderViewEntity, renderViewEntity.func_174813_aQ().func_72321_a(entityLook.field_72450_a * blockReachDistance, entityLook.field_72448_b * blockReachDistance, entityLook.field_72449_c * blockReachDistance).func_72321_a(1.0, 1.0, 1.0), arg_0 -> RaycastUtils.raycastEntity$lambda$1(RaycastUtils::raycastEntity$lambda$0, arg_0));
            Entity pointedEntity = null;
            for (Entity entity : entityList) {
                double eyeDistance;
                if (!entityFilter.canRaycast(entity)) continue;
                double collisionBorderSize = entity.func_70111_Y();
                AxisAlignedBB axisAlignedBB = entity.func_174813_aQ().func_72321_a(collisionBorderSize, collisionBorderSize, collisionBorderSize);
                RayTraceResult movingObjectPosition = axisAlignedBB.func_72327_a(eyePosition, vector);
                if (axisAlignedBB.func_72318_a(eyePosition)) {
                    if (!(blockReachDistance >= 0.0)) continue;
                    pointedEntity = entity;
                    blockReachDistance = 0.0;
                    continue;
                }
                if (movingObjectPosition == null || !((eyeDistance = eyePosition.func_72438_d(movingObjectPosition.field_72307_f)) < blockReachDistance) && !(blockReachDistance == 0.0)) continue;
                if (Intrinsics.areEqual(entity, renderViewEntity.func_184187_bx()) && !renderViewEntity.canRiderInteract()) {
                    if (!(blockReachDistance == 0.0)) continue;
                    pointedEntity = entity;
                    continue;
                }
                pointedEntity = entity;
                blockReachDistance = eyeDistance;
            }
            return pointedEntity;
        }
        return null;
    }

    private static final boolean raycastEntity$lambda$0(Entity it) {
        return it != null && (!(it instanceof EntityPlayer) || !((EntityPlayer)it).func_175149_v()) && it.func_70067_L();
    }

    private static final boolean raycastEntity$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "", "canRaycast", "", "entity", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
    public static interface EntityFilter {
        public boolean canRaycast(@Nullable Entity var1);
    }
}

