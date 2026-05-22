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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecModeCenter;", "Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecMode;", "<init>", "()V", "apply", "Lnet/minecraft/util/math/Vec3d;", "aabb", "Lnet/minecraft/util/math/AxisAlignedBB;", "eye", "Companion", "DarkMeow"})
public final class AABBToVecModeCenter
implements AABBToVecMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final AABBToVecModeCenter INSTANCE = new AABBToVecModeCenter();

    @Override
    @NotNull
    public Vec3d apply(@NotNull AxisAlignedBB aabb, @NotNull Vec3d eye) {
        Intrinsics.checkNotNullParameter(aabb, "aabb");
        Intrinsics.checkNotNullParameter(eye, "eye");
        Vec3d vec3d = aabb.func_189972_c();
        Intrinsics.checkNotNullExpressionValue(vec3d, "getCenter(...)");
        return vec3d;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecModeCenter$Companion;", "", "<init>", "()V", "INSTANCE", "Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecModeCenter;", "getINSTANCE", "()Lnet/darkmeow/darkmeow/utils/movement/rotation/aabb_to_vec/AABBToVecModeCenter;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AABBToVecModeCenter getINSTANCE() {
            return INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

