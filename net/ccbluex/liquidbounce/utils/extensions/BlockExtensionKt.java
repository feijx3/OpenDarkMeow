/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2={"getVec", "Lnet/minecraft/util/math/Vec3d;", "Lnet/minecraft/util/math/BlockPos;", "DarkMeow"})
public final class BlockExtensionKt {
    @NotNull
    public static final Vec3d getVec(@NotNull BlockPos $this$getVec) {
        Intrinsics.checkNotNullParameter($this$getVec, "<this>");
        return new Vec3d((double)$this$getVec.func_177958_n() + 0.5, (double)$this$getVec.func_177956_o() + 0.5, (double)$this$getVec.func_177952_p() + 0.5);
    }
}

