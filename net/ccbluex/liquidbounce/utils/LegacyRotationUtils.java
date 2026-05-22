/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.Rotation;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="Use DarkMeow.rotationManager")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/utils/LegacyRotationUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "<init>", "()V", "Companion", "DarkMeow"})
public final class LegacyRotationUtils
extends MinecraftInstance
implements Listenable {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/utils/LegacyRotationUtils$Companion;", "", "<init>", "()V", "toRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "vec", "Lnet/minecraft/util/math/Vec3d;", "predict", "", "getCenter", "bb", "Lnet/minecraft/util/math/AxisAlignedBB;", "getRotationDifference", "", "entity", "Lnet/minecraft/entity/Entity;", "a", "b", "getRotationBackDifference", "getAngleDifference", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Rotation toRotation(@NotNull Vec3d vec, boolean predict) {
            Intrinsics.checkNotNullParameter(vec, "vec");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return new Rotation(0.0f, 0.0f);
            }
            EntityPlayerSP player = entityPlayerSP;
            Vec3d eyesPos = new Vec3d(player.field_70165_t, player.func_174813_aQ().field_72338_b + (double)player.func_70047_e(), player.field_70161_v);
            if (predict) {
                eyesPos.func_72441_c(player.field_70159_w, player.field_70181_x, player.field_70179_y);
            }
            double diffX = vec.field_72450_a - eyesPos.field_72450_a;
            double diffY = vec.field_72448_b - eyesPos.field_72448_b;
            double diffZ = vec.field_72449_c - eyesPos.field_72449_c;
            return new Rotation(MathHelper.func_76142_g((float)((float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0f)), MathHelper.func_76142_g((float)((float)(-Math.toDegrees(Math.atan2(diffY, Math.sqrt(diffX * diffX + diffZ * diffZ)))))));
        }

        @NotNull
        public final Vec3d getCenter(@NotNull AxisAlignedBB bb2) {
            Intrinsics.checkNotNullParameter(bb2, "bb");
            return new Vec3d(bb2.field_72340_a + (bb2.field_72336_d - bb2.field_72340_a) * 0.5, bb2.field_72338_b + (bb2.field_72337_e - bb2.field_72338_b) * 0.5, bb2.field_72339_c + (bb2.field_72334_f - bb2.field_72339_c) * 0.5);
        }

        public final double getRotationDifference(@NotNull Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return 0.0;
            }
            EntityPlayerSP player = entityPlayerSP;
            AxisAlignedBB axisAlignedBB = entity.func_174813_aQ();
            Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "getEntityBoundingBox(...)");
            Rotation rotation = this.toRotation(this.getCenter(axisAlignedBB), true);
            return this.getRotationDifference(rotation, new Rotation(player.field_70177_z, player.field_70125_A));
        }

        public final double getRotationDifference(@NotNull Rotation a2, @Nullable Rotation b2) {
            Intrinsics.checkNotNullParameter(a2, "a");
            float f2 = a2.getYaw();
            Rotation rotation = b2;
            Intrinsics.checkNotNull(rotation);
            return Math.hypot(this.getAngleDifference(f2, rotation.getYaw()), a2.getPitch() - b2.getPitch());
        }

        public final double getRotationBackDifference(@NotNull Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return 0.0;
            }
            EntityPlayerSP player = entityPlayerSP;
            AxisAlignedBB axisAlignedBB = entity.func_174813_aQ();
            Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "getEntityBoundingBox(...)");
            Rotation rotation = this.toRotation(this.getCenter(axisAlignedBB), true);
            return this.getRotationDifference(rotation, new Rotation(player.field_70177_z - (float)180, player.field_70125_A));
        }

        public final float getAngleDifference(float a2, float b2) {
            return ((a2 - b2) % 360.0f + 540.0f) % 360.0f - 180.0f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

