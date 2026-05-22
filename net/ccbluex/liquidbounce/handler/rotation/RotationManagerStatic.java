/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.rotation;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerStatic;", "", "<init>", "()V", "RAT_TRACE_MISS", "Lnet/minecraft/util/math/RayTraceResult;", "DarkMeow"})
public final class RotationManagerStatic {
    @NotNull
    public static final RotationManagerStatic INSTANCE = new RotationManagerStatic();
    @JvmField
    @NotNull
    public static final RayTraceResult RAT_TRACE_MISS = new RayTraceResult(RayTraceResult.Type.MISS, Vec3d.field_186680_a, EnumFacing.DOWN, BlockPos.field_177992_a);

    private RotationManagerStatic() {
    }
}

