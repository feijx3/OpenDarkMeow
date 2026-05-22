/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lnet/darkmeow/darkmeow/utils/world/VecUtils;", "", "<init>", "()V", "getEyeVec", "Lnet/minecraft/util/math/Vec3d;", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class VecUtils {
    @NotNull
    public static final VecUtils INSTANCE = new VecUtils();

    private VecUtils() {
    }

    @NotNull
    public final Vec3d getEyeVec(@NotNull Entity $this$getEyeVec) {
        Intrinsics.checkNotNullParameter($this$getEyeVec, "<this>");
        return new Vec3d($this$getEyeVec.field_70165_t, $this$getEyeVec.field_70163_u + (double)$this$getEyeVec.func_70047_e(), $this$getEyeVec.field_70161_v);
    }
}

