/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.utils.movement;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.ThroughWallCheck;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.impl.ThroughWallCheckDisable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JD\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J,\u0010\u0016\u001a\u0004\u0018\u00010\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0017"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/RayCastUtils;", "", "<init>", "()V", "DEFAULT_THROUGH_WALL_CHECK", "Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/impl/ThroughWallCheckDisable;", "getDEFAULT_THROUGH_WALL_CHECK", "()Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/impl/ThroughWallCheckDisable;", "rayCastEntities", "", "Lnet/minecraft/util/math/RayTraceResult;", "Lnet/minecraft/entity/Entity;", "range", "", "partialTicks", "", "throughWall", "Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;", "noRiding", "", "lookVec", "Lnet/minecraft/util/math/Vec3d;", "rayTraceBlock", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRayCastUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RayCastUtils.kt\nnet/darkmeow/darkmeow/utils/movement/RayCastUtils\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n608#2:99\n1#3:100\n*S KotlinDebug\n*F\n+ 1 RayCastUtils.kt\nnet/darkmeow/darkmeow/utils/movement/RayCastUtils\n*L\n72#1:99\n*E\n"})
public final class RayCastUtils {
    @NotNull
    public static final RayCastUtils INSTANCE = new RayCastUtils();
    @NotNull
    private static final ThroughWallCheckDisable DEFAULT_THROUGH_WALL_CHECK = new ThroughWallCheckDisable();

    private RayCastUtils() {
    }

    @NotNull
    public final ThroughWallCheckDisable getDEFAULT_THROUGH_WALL_CHECK() {
        return DEFAULT_THROUGH_WALL_CHECK;
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities, double range, float partialTicks, @NotNull ThroughWallCheck throughWall, boolean noRiding, @NotNull Vec3d lookVec) {
        void $this$sortedBy$iv;
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        Intrinsics.checkNotNullParameter(throughWall, "throughWall");
        Intrinsics.checkNotNullParameter(lookVec, "lookVec");
        Vec3d eyeVec = $this$rayCastEntities.func_174824_e(partialTicks);
        Vec3d reachVec = eyeVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        Intrinsics.checkNotNull(eyeVec);
        double filterRange = throughWall.apply(range, $this$rayCastEntities, eyeVec, partialTicks);
        Object object = $this$rayCastEntities.field_70170_p.func_175674_a($this$rayCastEntities, $this$rayCastEntities.func_174813_aQ().func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b(1.0, 1.0, 1.0), Predicates.and((Predicate)EntitySelectors.field_180132_d, arg_0 -> RayCastUtils.rayCastEntities$lambda$1(RayCastUtils::rayCastEntities$lambda$0, arg_0)));
        Intrinsics.checkNotNullExpressionValue(object, "getEntitiesInAABBexcluding(...)");
        object = SequencesKt.filter(SequencesKt.mapNotNull(SequencesKt.filter(SequencesKt.filterNotNull(CollectionsKt.asSequence((Iterable)object)), arg_0 -> RayCastUtils.rayCastEntities$lambda$2(noRiding, $this$rayCastEntities, arg_0)), arg_0 -> RayCastUtils.rayCastEntities$lambda$4(eyeVec, reachVec, arg_0)), arg_0 -> RayCastUtils.rayCastEntities$lambda$5(eyeVec, filterRange, arg_0));
        boolean $i$f$sortedBy = false;
        return SequencesKt.toMutableList(SequencesKt.sortedWith($this$sortedBy$iv, new Comparator(eyeVec){
            final /* synthetic */ Vec3d $eyeVec$inlined;
            {
                this.$eyeVec$inlined = vec3d;
            }

            public final int compare(T a2, T b2) {
                RayTraceResult result = (RayTraceResult)a2;
                boolean bl2 = false;
                result = (RayTraceResult)b2;
                Comparable comparable = Double.valueOf(result.field_72307_f == this.$eyeVec$inlined ? Double.MAX_VALUE : this.$eyeVec$inlined.func_72438_d(result.field_72307_f));
                bl2 = false;
                return ComparisonsKt.compareValues(comparable, result.field_72307_f == this.$eyeVec$inlined ? Double.MAX_VALUE : this.$eyeVec$inlined.func_72438_d(result.field_72307_f));
            }
        }));
    }

    public static /* synthetic */ List rayCastEntities$default(Entity entity, double d2, float f2, ThroughWallCheck throughWallCheck, boolean bl2, Vec3d vec3d, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = 3.0;
        }
        if ((n2 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((n2 & 4) != 0) {
            throughWallCheck = DEFAULT_THROUGH_WALL_CHECK;
        }
        if ((n2 & 8) != 0) {
            bl2 = true;
        }
        if ((n2 & 0x10) != 0) {
            Vec3d vec3d2 = entity.func_70676_i(f2);
            Intrinsics.checkNotNullExpressionValue(vec3d2, "getLook(...)");
            vec3d = vec3d2;
        }
        return RayCastUtils.rayCastEntities(entity, d2, f2, throughWallCheck, bl2, vec3d);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final RayTraceResult rayTraceBlock(@NotNull Entity $this$rayTraceBlock, double range, float partialTicks, @NotNull Vec3d lookVec) {
        Intrinsics.checkNotNullParameter($this$rayTraceBlock, "<this>");
        Intrinsics.checkNotNullParameter(lookVec, "lookVec");
        Vec3d positionVec = $this$rayTraceBlock.func_174824_e(partialTicks);
        return $this$rayTraceBlock.field_70170_p.func_147447_a(positionVec, positionVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range), false, false, true);
    }

    public static /* synthetic */ RayTraceResult rayTraceBlock$default(Entity entity, double d2, float f2, Vec3d vec3d, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = Minecraft.func_71410_x().field_71442_b.func_78757_d();
        }
        if ((n2 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((n2 & 4) != 0) {
            Vec3d vec3d2 = entity.func_70676_i(f2);
            Intrinsics.checkNotNullExpressionValue(vec3d2, "getLook(...)");
            vec3d = vec3d2;
        }
        return RayCastUtils.rayTraceBlock(entity, d2, f2, vec3d);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities, double range, float partialTicks, @NotNull ThroughWallCheck throughWall, boolean noRiding) {
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        Intrinsics.checkNotNullParameter(throughWall, "throughWall");
        return RayCastUtils.rayCastEntities$default($this$rayCastEntities, range, partialTicks, throughWall, noRiding, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities, double range, float partialTicks, @NotNull ThroughWallCheck throughWall) {
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        Intrinsics.checkNotNullParameter(throughWall, "throughWall");
        return RayCastUtils.rayCastEntities$default($this$rayCastEntities, range, partialTicks, throughWall, false, null, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities, double range, float partialTicks) {
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        return RayCastUtils.rayCastEntities$default($this$rayCastEntities, range, partialTicks, null, false, null, 28, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities, double range) {
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        return RayCastUtils.rayCastEntities$default($this$rayCastEntities, range, 0.0f, null, false, null, 30, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<RayTraceResult> rayCastEntities(@NotNull Entity $this$rayCastEntities) {
        Intrinsics.checkNotNullParameter($this$rayCastEntities, "<this>");
        return RayCastUtils.rayCastEntities$default($this$rayCastEntities, 0.0, 0.0f, null, false, null, 31, null);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final RayTraceResult rayTraceBlock(@NotNull Entity $this$rayTraceBlock, double range, float partialTicks) {
        Intrinsics.checkNotNullParameter($this$rayTraceBlock, "<this>");
        return RayCastUtils.rayTraceBlock$default($this$rayTraceBlock, range, partialTicks, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final RayTraceResult rayTraceBlock(@NotNull Entity $this$rayTraceBlock, double range) {
        Intrinsics.checkNotNullParameter($this$rayTraceBlock, "<this>");
        return RayCastUtils.rayTraceBlock$default($this$rayTraceBlock, range, 0.0f, null, 6, null);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final RayTraceResult rayTraceBlock(@NotNull Entity $this$rayTraceBlock) {
        Intrinsics.checkNotNullParameter($this$rayTraceBlock, "<this>");
        return RayCastUtils.rayTraceBlock$default($this$rayTraceBlock, 0.0, 0.0f, null, 7, null);
    }

    private static final boolean rayCastEntities$lambda$0(Entity entity) {
        Entity entity2 = entity;
        return entity2 != null ? entity2.func_70067_L() : false;
    }

    private static final boolean rayCastEntities$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean rayCastEntities$lambda$2(boolean $noRiding, Entity $this_rayCastEntities, Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return !$noRiding || entity.func_184208_bv() != $this_rayCastEntities.func_184208_bv() || entity.canRiderInteract();
    }

    private static final RayTraceResult rayCastEntities$lambda$4(Vec3d $eyeVec, Vec3d $reachVec, Entity entity) {
        RayTraceResult rayTraceResult;
        Vec3d vec3d;
        Intrinsics.checkNotNullParameter(entity, "entity");
        AxisAlignedBB box = entity.func_174813_aQ().func_186662_g((double)entity.func_70111_Y());
        if (box.func_72318_a($eyeVec)) {
            return new RayTraceResult(entity, $eyeVec);
        }
        RayTraceResult rayTraceResult2 = box.func_72327_a($eyeVec, $reachVec);
        if (rayTraceResult2 != null && (vec3d = rayTraceResult2.field_72307_f) != null) {
            Vec3d it = vec3d;
            boolean bl2 = false;
            rayTraceResult = new RayTraceResult(entity, it);
        } else {
            rayTraceResult = null;
        }
        return rayTraceResult;
    }

    private static final boolean rayCastEntities$lambda$5(Vec3d $eyeVec, double $filterRange, RayTraceResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return $eyeVec.func_72438_d(result.field_72307_f) <= $filterRange;
    }
}

