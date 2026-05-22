/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.world;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ*\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00050\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ*\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00050\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/darkmeow/utils/world/AxisAlignedBBUtils;", "", "<init>", "()V", "getFaceAABB", "Lnet/minecraft/util/math/AxisAlignedBB;", "facing", "Lnet/minecraft/util/EnumFacing;", "expand", "", "scale", "", "getClosest", "Lnet/minecraft/util/math/Vec3d;", "eye", "shirkSafe", "kotlin.jvm.PlatformType", "x", "y", "z", "shirk", "DarkMeow"})
public final class AxisAlignedBBUtils {
    @NotNull
    public static final AxisAlignedBBUtils INSTANCE = new AxisAlignedBBUtils();

    private AxisAlignedBBUtils() {
    }

    @NotNull
    public final AxisAlignedBB getFaceAABB(@NotNull AxisAlignedBB $this$getFaceAABB, @NotNull EnumFacing facing, double expand) {
        AxisAlignedBB axisAlignedBB;
        Intrinsics.checkNotNullParameter($this$getFaceAABB, "<this>");
        Intrinsics.checkNotNullParameter(facing, "facing");
        switch (WhenMappings.$EnumSwitchMapping$0[facing.ordinal()]) {
            case 1: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72340_a, $this$getFaceAABB.field_72338_b - expand, $this$getFaceAABB.field_72339_c, $this$getFaceAABB.field_72336_d, $this$getFaceAABB.field_72338_b + expand, $this$getFaceAABB.field_72334_f);
                break;
            }
            case 2: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72340_a, $this$getFaceAABB.field_72337_e - expand, $this$getFaceAABB.field_72339_c, $this$getFaceAABB.field_72336_d, $this$getFaceAABB.field_72337_e + expand, $this$getFaceAABB.field_72334_f);
                break;
            }
            case 3: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72340_a, $this$getFaceAABB.field_72338_b, $this$getFaceAABB.field_72339_c - expand, $this$getFaceAABB.field_72336_d, $this$getFaceAABB.field_72337_e, $this$getFaceAABB.field_72339_c + expand);
                break;
            }
            case 4: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72340_a, $this$getFaceAABB.field_72338_b, $this$getFaceAABB.field_72334_f - expand, $this$getFaceAABB.field_72336_d, $this$getFaceAABB.field_72337_e, $this$getFaceAABB.field_72334_f + expand);
                break;
            }
            case 5: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72340_a - expand, $this$getFaceAABB.field_72338_b, $this$getFaceAABB.field_72339_c, $this$getFaceAABB.field_72340_a + expand, $this$getFaceAABB.field_72337_e, $this$getFaceAABB.field_72334_f);
                break;
            }
            case 6: {
                axisAlignedBB = new AxisAlignedBB($this$getFaceAABB.field_72336_d - expand, $this$getFaceAABB.field_72338_b, $this$getFaceAABB.field_72339_c, $this$getFaceAABB.field_72336_d + expand, $this$getFaceAABB.field_72337_e, $this$getFaceAABB.field_72334_f);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return axisAlignedBB;
    }

    public static /* synthetic */ AxisAlignedBB getFaceAABB$default(AxisAlignedBBUtils axisAlignedBBUtils, AxisAlignedBB axisAlignedBB, EnumFacing enumFacing, double d2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            d2 = 0.2;
        }
        return axisAlignedBBUtils.getFaceAABB(axisAlignedBB, enumFacing, d2);
    }

    @NotNull
    public final AxisAlignedBB scale(@NotNull AxisAlignedBB $this$scale, float scale) {
        Intrinsics.checkNotNullParameter($this$scale, "<this>");
        if (scale == 1.0f) {
            return $this$scale;
        }
        double centerX = ($this$scale.field_72340_a + $this$scale.field_72336_d) / (double)2;
        double centerY = ($this$scale.field_72338_b + $this$scale.field_72337_e) / (double)2;
        double centerZ = ($this$scale.field_72339_c + $this$scale.field_72334_f) / (double)2;
        double newHalfX = ($this$scale.field_72336_d - $this$scale.field_72340_a) / (double)2 * (double)scale;
        double newHalfY = ($this$scale.field_72337_e - $this$scale.field_72338_b) / (double)2 * (double)scale;
        double newHalfZ = ($this$scale.field_72334_f - $this$scale.field_72339_c) / (double)2 * (double)scale;
        return new AxisAlignedBB(centerX - newHalfX, centerY - newHalfY, centerZ - newHalfZ, centerX + newHalfX, centerY + newHalfY, centerZ + newHalfZ);
    }

    @NotNull
    public final Vec3d getClosest(@NotNull AxisAlignedBB $this$getClosest, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter($this$getClosest, "<this>");
        Intrinsics.checkNotNullParameter(eye, "eye");
        AxisAlignedBB aabb = $this$getClosest;
        boolean bl2 = false;
        return new Vec3d(((Number)RangesKt.coerceIn((Comparable)Double.valueOf(eye.field_72450_a), RangesKt.rangeTo(aabb.field_72340_a, aabb.field_72336_d))).doubleValue(), ((Number)RangesKt.coerceIn((Comparable)Double.valueOf(eye.field_72448_b), RangesKt.rangeTo(aabb.field_72338_b, aabb.field_72337_e))).doubleValue(), ((Number)RangesKt.coerceIn((Comparable)Double.valueOf(eye.field_72449_c), RangesKt.rangeTo(aabb.field_72339_c, aabb.field_72334_f))).doubleValue());
    }

    public final AxisAlignedBB shirkSafe(@NotNull AxisAlignedBB $this$shirkSafe, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter($this$shirkSafe, "<this>");
        return this.shirk($this$shirkSafe, ((Number)RangesKt.coerceIn((Comparable)Double.valueOf(x2), RangesKt.rangeTo(0.0, ($this$shirkSafe.field_72336_d - $this$shirkSafe.field_72340_a) * 0.5))).doubleValue(), ((Number)RangesKt.coerceIn((Comparable)Double.valueOf(y2), RangesKt.rangeTo(0.0, ($this$shirkSafe.field_72337_e - $this$shirkSafe.field_72338_b) * 0.5))).doubleValue(), ((Number)RangesKt.coerceIn((Comparable)Double.valueOf(z2), RangesKt.rangeTo(0.0, ($this$shirkSafe.field_72334_f - $this$shirkSafe.field_72339_c) * 0.5))).doubleValue());
    }

    public final AxisAlignedBB shirk(@NotNull AxisAlignedBB $this$shirk, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter($this$shirk, "<this>");
        return $this$shirk.func_72314_b(-x2, -y2, -z2);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumFacing.values().length];
            try {
                nArray[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

