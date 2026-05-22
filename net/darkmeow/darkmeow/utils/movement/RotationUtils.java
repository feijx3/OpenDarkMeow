/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.utils.movement;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.darkmeow.darkmeow.utils.movement.rotation.aabb_to_vec.AABBToVecMode;
import net.darkmeow.darkmeow.utils.movement.rotation.aabb_to_vec.AABBToVecModeCenter;
import net.darkmeow.darkmeow.utils.world.AxisAlignedBBUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\n\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005J6\u0010\u0010\u001a\u0004\u0018\u00010\u0006*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J*\u0010\u001a\u001a\u0004\u0018\u00010\u0006*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010\u001a\u001a\u0004\u0018\u00010\u0006*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u001e\u001a\u00020\u0006*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0005J\u0012\u0010 \u001a\u00020\u0006*\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001e\u001a\u00020\u0006*\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0005J\u0012\u0010\"\u001a\u00020\u0006*\u00020#2\u0006\u0010\u001b\u001a\u00020\u0011J\u0014\u0010 \u001a\u00020\u0006*\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u001a\u0010$\u001a\n %*\u0004\u0018\u00010\u00190\u0019*\u00020\u00112\u0006\u0010&\u001a\u00020\u0006\u00a8\u0006'"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/RotationUtils;", "", "<init>", "()V", "getDifference", "", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "other", "getYawDifference", "yaw", "getPitchDifference", "pitch", "limitAngleChange", "currentRotation", "targetRotation", "turnSpeed", "getRotationBlock", "Lnet/minecraft/entity/Entity;", "pos", "Lnet/minecraft/util/math/BlockPos;", "offset", "", "facing", "Lnet/minecraft/util/EnumFacing;", "eye", "Lnet/minecraft/util/math/Vec3d;", "getRotationEntity", "entity", "aabbToVecMode", "Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecMode;", "getRotationThrowable", "velocity", "getRotation", "Lnet/minecraft/util/math/AxisAlignedBB;", "getThrowRotation", "Lnet/minecraft/client/entity/EntityPlayerSP;", "getVectorForRotation", "kotlin.jvm.PlatformType", "rotation", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRotationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RotationUtils.kt\nnet/darkmeow/darkmeow/utils/movement/RotationUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n12637#2,2:201\n12637#2,2:204\n1#3:203\n*S KotlinDebug\n*F\n+ 1 RotationUtils.kt\nnet/darkmeow/darkmeow/utils/movement/RotationUtils\n*L\n96#1:201,2\n136#1:204,2\n*E\n"})
public final class RotationUtils {
    @NotNull
    public static final RotationUtils INSTANCE = new RotationUtils();

    private RotationUtils() {
    }

    public final float getDifference(@NotNull Rotation $this$getDifference, @NotNull Rotation other) {
        Intrinsics.checkNotNullParameter($this$getDifference, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return (float)Math.hypot(this.getYawDifference($this$getDifference, other.yaw), this.getPitchDifference($this$getDifference, other.pitch));
    }

    public final float getYawDifference(@NotNull Rotation $this$getYawDifference, float yaw) {
        Intrinsics.checkNotNullParameter($this$getYawDifference, "<this>");
        return (($this$getYawDifference.yaw - yaw) % 360.0f + 540.0f) % 360.0f - 180.0f;
    }

    public final float getPitchDifference(@NotNull Rotation $this$getPitchDifference, float pitch) {
        Intrinsics.checkNotNullParameter($this$getPitchDifference, "<this>");
        return (($this$getPitchDifference.pitch - pitch) % 360.0f + 540.0f) % 360.0f - 180.0f;
    }

    @NotNull
    public final Rotation limitAngleChange(@NotNull Rotation currentRotation, @NotNull Rotation targetRotation, float turnSpeed) {
        Intrinsics.checkNotNullParameter(currentRotation, "currentRotation");
        Intrinsics.checkNotNullParameter(targetRotation, "targetRotation");
        float yawDifference = net.ccbluex.liquidbounce.handler.rotation.utils.RotationUtils.INSTANCE.getAngleDifference(targetRotation.yaw, currentRotation.yaw);
        float pitchDifference = net.ccbluex.liquidbounce.handler.rotation.utils.RotationUtils.INSTANCE.getAngleDifference(targetRotation.pitch, currentRotation.pitch);
        return new Rotation(currentRotation.yaw + (yawDifference > turnSpeed ? turnSpeed : Math.max(yawDifference, -turnSpeed)), currentRotation.pitch + (pitchDifference > turnSpeed ? turnSpeed : Math.max(pitchDifference, -turnSpeed)));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    @Nullable
    public final Rotation getRotationBlock(@NotNull Entity $this$getRotationBlock, @NotNull BlockPos pos, double offset, @Nullable EnumFacing facing, @NotNull Vec3d eye) {
        void $this$any$iv;
        EnumFacing enumFacing;
        EnumFacing enumFacing2;
        block4: {
            AxisAlignedBB aabb;
            block3: {
                Intrinsics.checkNotNullParameter($this$getRotationBlock, "<this>");
                Intrinsics.checkNotNullParameter(pos, "pos");
                Intrinsics.checkNotNullParameter(eye, "eye");
                AxisAlignedBB axisAlignedBB = $this$getRotationBlock.field_70170_p.func_180495_p(pos).func_185890_d((IBlockAccess)$this$getRotationBlock.field_70170_p, pos);
                if (axisAlignedBB == null) return null;
                aabb = axisAlignedBB;
                boolean bl2 = false;
                enumFacing2 = facing;
                if (enumFacing2 == null) break block3;
                EnumFacing it = enumFacing2;
                boolean bl3 = false;
                AxisAlignedBB axisAlignedBB2 = AxisAlignedBBUtils.INSTANCE.getFaceAABB(aabb, it, -offset + 0.01);
                enumFacing2 = axisAlignedBB2;
                if (axisAlignedBB2 != null) break block4;
            }
            enumFacing2 = aabb;
        }
        EnumFacing aabb = enumFacing = enumFacing2;
        boolean bl4 = false;
        Boolean[] bl3 = new Boolean[]{offset * (double)2 >= aabb.field_72336_d - aabb.field_72340_a, offset * (double)2 >= aabb.field_72337_e - aabb.field_72338_b, offset * (double)2 >= aabb.field_72334_f - aabb.field_72339_c};
        boolean $i$f$any = false;
        for (void element$iv : $this$any$iv) {
            boolean it = element$iv.booleanValue();
            boolean bl5 = false;
            if (!it) continue;
            return null;
        }
        boolean bl6 = false;
        if (bl6) return null;
        boolean bl7 = true;
        if (!bl7) return null;
        EnumFacing enumFacing3 = enumFacing;
        EnumFacing enumFacing4 = enumFacing3;
        if (enumFacing4 == null) return null;
        enumFacing = enumFacing4.func_186670_a(pos);
        if (enumFacing == null) return null;
        Vec3d vec3d = AxisAlignedBBUtils.INSTANCE.getClosest((AxisAlignedBB)enumFacing, eye);
        if (vec3d == null) return null;
        Rotation rotation = this.getRotation(vec3d, eye);
        return rotation;
    }

    public static /* synthetic */ Rotation getRotationBlock$default(RotationUtils rotationUtils, Entity entity, BlockPos blockPos, double d2, EnumFacing enumFacing, Vec3d vec3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            d2 = -0.2;
        }
        if ((n2 & 4) != 0) {
            enumFacing = null;
        }
        if ((n2 & 8) != 0) {
            vec3d = new Vec3d(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e(), entity.field_70161_v);
        }
        return rotationUtils.getRotationBlock(entity, blockPos, d2, enumFacing, vec3d);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationEntity(@NotNull Entity $this$getRotationEntity, @NotNull Entity entity, @NotNull AABBToVecMode aabbToVecMode, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter($this$getRotationEntity, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(aabbToVecMode, "aabbToVecMode");
        Intrinsics.checkNotNullParameter(eye, "eye");
        AxisAlignedBB it = entity.func_174813_aQ();
        boolean bl2 = false;
        Intrinsics.checkNotNull(it);
        Vec3d vec3d = aabbToVecMode.apply(it, eye);
        return vec3d != null ? this.getRotation(vec3d, eye) : null;
    }

    public static /* synthetic */ Rotation getRotationEntity$default(RotationUtils rotationUtils, Entity entity, Entity entity2, AABBToVecMode aABBToVecMode, Vec3d vec3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            aABBToVecMode = AABBToVecModeCenter.Companion.getINSTANCE();
        }
        if ((n2 & 4) != 0) {
            vec3d = new Vec3d(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e(), entity.field_70161_v);
        }
        return rotationUtils.getRotationEntity(entity, entity2, aABBToVecMode, vec3d);
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    @Nullable
    public final Rotation getRotationEntity(@NotNull Entity $this$getRotationEntity, @NotNull Vec3d eye, double offset) {
        boolean bl2;
        AxisAlignedBB axisAlignedBB;
        block1: {
            void $this$any$iv;
            Intrinsics.checkNotNullParameter($this$getRotationEntity, "<this>");
            Intrinsics.checkNotNullParameter(eye, "eye");
            AxisAlignedBB aabb = axisAlignedBB = $this$getRotationEntity.func_174813_aQ();
            boolean bl3 = false;
            Boolean[] booleanArray = new Boolean[]{offset * (double)2 >= aabb.field_72336_d - aabb.field_72340_a, offset * (double)2 >= aabb.field_72337_e - aabb.field_72338_b, offset * (double)2 >= aabb.field_72334_f - aabb.field_72339_c};
            boolean $i$f$any = false;
            for (void element$iv : $this$any$iv) {
                boolean it = element$iv.booleanValue();
                boolean bl4 = false;
                if (!it) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        AxisAlignedBB axisAlignedBB2 = !bl2 ? axisAlignedBB : null;
        return axisAlignedBB2 != null ? this.getRotation(axisAlignedBB2, eye) : null;
    }

    public static /* synthetic */ Rotation getRotationEntity$default(RotationUtils rotationUtils, Entity entity, Vec3d vec3d, double d2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            d2 = -0.2;
        }
        return rotationUtils.getRotationEntity(entity, vec3d, d2);
    }

    @NotNull
    public final Rotation getRotationThrowable(@NotNull Entity $this$getRotationThrowable, @NotNull Vec3d eye, float velocity) {
        Intrinsics.checkNotNullParameter($this$getRotationThrowable, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        AxisAlignedBB axisAlignedBB = $this$getRotationThrowable.func_174813_aQ();
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "getEntityBoundingBox(...)");
        return this.getRotationThrowable(axisAlignedBB, eye, velocity);
    }

    @NotNull
    public final Rotation getRotation(@NotNull AxisAlignedBB $this$getRotation, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter($this$getRotation, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        Vec3d direction = AxisAlignedBBUtils.INSTANCE.getClosest($this$getRotation, eye).func_178788_d(eye).func_72432_b();
        boolean bl2 = false;
        return new Rotation((float)(Math.atan2(direction.field_72449_c, direction.field_72450_a) * 180.0 / Math.PI) - 90.0f, (float)(-Math.atan2(direction.field_72448_b, MathHelper.func_76133_a((double)(direction.field_72450_a * direction.field_72450_a + direction.field_72449_c * direction.field_72449_c))) * 180.0 / Math.PI));
    }

    @NotNull
    public final Rotation getRotationThrowable(@NotNull AxisAlignedBB $this$getRotationThrowable, @NotNull Vec3d eye, float velocity) {
        Intrinsics.checkNotNullParameter($this$getRotationThrowable, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        Vec3d direction = $this$getRotationThrowable.func_189972_c().func_178788_d(eye).func_72432_b();
        boolean bl2 = false;
        double posSqrt = Math.sqrt(direction.field_72450_a * direction.field_72450_a + direction.field_72449_c * direction.field_72449_c);
        return new Rotation((float)(Math.atan2(direction.field_72449_c, direction.field_72450_a) * 180.0 / Math.PI) - 90.0f, -((float)Math.toDegrees(Math.atan(((double)(velocity * velocity) - Math.sqrt((double)(velocity * velocity * velocity * velocity) - (double)0.006f * ((double)0.006f * (posSqrt * posSqrt) + (double)2 * direction.field_72448_b * (double)(velocity * velocity)))) / ((double)0.006f * posSqrt)))));
    }

    @NotNull
    public final Rotation getThrowRotation(@NotNull EntityPlayerSP $this$getThrowRotation, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter($this$getThrowRotation, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        double deltaX = entity.field_70165_t - $this$getThrowRotation.field_70165_t - $this$getThrowRotation.field_70159_w;
        double deltaY = entity.field_70163_u + (double)entity.func_70047_e() - ($this$getThrowRotation.field_70163_u + (double)$this$getThrowRotation.func_70047_e());
        double deltaZ = entity.field_70161_v - $this$getThrowRotation.field_70161_v - $this$getThrowRotation.field_70179_y;
        float yaw = (float)(Math.atan2(deltaZ, deltaX) * 180.0 / Math.PI) - 90.0f;
        float pitch = (float)(-(Math.atan2(deltaY, Math.sqrt(deltaX * deltaX + deltaZ * deltaZ)) * 180.0 / Math.PI));
        return new Rotation($this$getThrowRotation.field_70177_z + MathHelper.func_76142_g((float)(yaw - $this$getThrowRotation.field_70177_z)), $this$getThrowRotation.field_70125_A + MathHelper.func_76142_g((float)(pitch - $this$getThrowRotation.field_70125_A)));
    }

    @NotNull
    public final Rotation getRotation(@NotNull Vec3d $this$getRotation, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter($this$getRotation, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        Vec3d vec = new Vec3d($this$getRotation.field_72450_a - eye.field_72450_a, $this$getRotation.field_72448_b - eye.field_72448_b, $this$getRotation.field_72449_c - eye.field_72449_c);
        return new Rotation((float)(Math.atan2(vec.field_72449_c, vec.field_72450_a) * 180.0 / Math.PI) - 90.0f, (float)(-Math.atan2(vec.field_72448_b, MathHelper.func_76133_a((double)(vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c))) * 180.0 / Math.PI));
    }

    public static /* synthetic */ Rotation getRotation$default(RotationUtils rotationUtils, Vec3d vec3d, Vec3d vec3d2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vec3d2 = new Vec3d(0.0, 0.0, 0.0);
        }
        return rotationUtils.getRotation(vec3d, vec3d2);
    }

    public final Vec3d getVectorForRotation(@NotNull Entity $this$getVectorForRotation, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter($this$getVectorForRotation, "<this>");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        return ExtendEntity.INSTANCE.getVectorForRotation($this$getVectorForRotation, rotation.pitch, rotation.yaw);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationBlock(@NotNull Entity $this$getRotationBlock, @NotNull BlockPos pos, double offset, @Nullable EnumFacing facing) {
        Intrinsics.checkNotNullParameter($this$getRotationBlock, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        return RotationUtils.getRotationBlock$default(this, $this$getRotationBlock, pos, offset, facing, null, 8, null);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationBlock(@NotNull Entity $this$getRotationBlock, @NotNull BlockPos pos, double offset) {
        Intrinsics.checkNotNullParameter($this$getRotationBlock, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        return RotationUtils.getRotationBlock$default(this, $this$getRotationBlock, pos, offset, null, null, 12, null);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationBlock(@NotNull Entity $this$getRotationBlock, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$getRotationBlock, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        return RotationUtils.getRotationBlock$default(this, $this$getRotationBlock, pos, 0.0, null, null, 14, null);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationEntity(@NotNull Entity $this$getRotationEntity, @NotNull Entity entity, @NotNull AABBToVecMode aabbToVecMode) {
        Intrinsics.checkNotNullParameter($this$getRotationEntity, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(aabbToVecMode, "aabbToVecMode");
        return RotationUtils.getRotationEntity$default(this, $this$getRotationEntity, entity, aabbToVecMode, null, 4, null);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationEntity(@NotNull Entity $this$getRotationEntity, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter($this$getRotationEntity, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return RotationUtils.getRotationEntity$default(this, $this$getRotationEntity, entity, null, null, 6, null);
    }

    @JvmOverloads
    @Nullable
    public final Rotation getRotationEntity(@NotNull Entity $this$getRotationEntity, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter($this$getRotationEntity, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        return RotationUtils.getRotationEntity$default(this, $this$getRotationEntity, eye, 0.0, 2, null);
    }
}

