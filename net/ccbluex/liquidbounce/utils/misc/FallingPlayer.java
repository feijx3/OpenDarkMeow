/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.misc;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="\u5728 2025.6.6 \u4ee5\u540e\u7528\u8fd9\u4e2a\u65b9\u6cd5\u6b7b\u5988")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "x", "", "y", "z", "motionX", "motionY", "motionZ", "yaw", "", "strafe", "forward", "<init>", "(DDDDDDFFF)V", "calculateForTick", "", "findCollision", "Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer$CollisionResult;", "ticks", "", "rayTrace", "Lnet/minecraft/util/math/BlockPos;", "start", "Lnet/minecraft/util/math/Vec3d;", "end", "CollisionResult", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFallingPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FallingPlayer.kt\nnet/ccbluex/liquidbounce/utils/misc/FallingPlayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
public final class FallingPlayer
extends MinecraftInstance {
    private double x;
    private double y;
    private double z;
    private double motionX;
    private double motionY;
    private double motionZ;
    private final float yaw;
    private float strafe;
    private float forward;

    public FallingPlayer(double x2, double y2, double z2, double motionX, double motionY, double motionZ, float yaw, float strafe, float forward) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        this.yaw = yaw;
        this.strafe = strafe;
        this.forward = forward;
    }

    private final void calculateForTick() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.strafe *= 0.98f;
        this.forward *= 0.98f;
        float v2 = this.strafe * this.strafe + this.forward * this.forward;
        if (v2 >= 1.0E-4f) {
            if ((v2 = (float)Math.sqrt(v2)) < 1.0f) {
                v2 = 1.0f;
            }
            v2 = player.field_70747_aH / v2;
            this.strafe *= v2;
            this.forward *= v2;
            float f1 = (float)Math.sin(this.yaw * (float)Math.PI / 180.0f);
            float f2 = (float)Math.cos(this.yaw * (float)Math.PI / 180.0f);
            this.motionX += (double)(this.strafe * f2 - this.forward * f1);
            this.motionZ += (double)(this.forward * f2 + this.strafe * f1);
        }
        this.motionY -= 0.08;
        this.motionX *= 0.91;
        this.motionY *= (double)0.98f;
        this.motionY *= 0.91;
        this.motionZ *= 0.91;
        this.x += this.motionX;
        this.y += this.motionY;
        this.z += this.motionZ;
    }

    @Nullable
    public final CollisionResult findCollision(int ticks) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return null;
        }
        EntityPlayerSP player = entityPlayerSP;
        for (int i2 = 0; i2 < ticks; ++i2) {
            BlockPos blockPos;
            Vec3d start = new Vec3d(this.x, this.y, this.z);
            this.calculateForTick();
            Vec3d end = new Vec3d(this.x, this.y, this.z);
            BlockPos raytracedBlock = null;
            double w2 = (double)player.field_70130_N / (double)2.0f;
            BlockPos it = blockPos = this.rayTrace(start, end);
            boolean bl2 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d = start.func_72441_c(w2, 0.0, w2);
            Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
            it = blockPos = this.rayTrace(vec3d, end);
            boolean bl3 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d2 = start.func_72441_c(-w2, 0.0, w2);
            Intrinsics.checkNotNullExpressionValue(vec3d2, "add(...)");
            it = blockPos = this.rayTrace(vec3d2, end);
            boolean bl4 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d3 = start.func_72441_c(w2, 0.0, -w2);
            Intrinsics.checkNotNullExpressionValue(vec3d3, "add(...)");
            it = blockPos = this.rayTrace(vec3d3, end);
            boolean bl5 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d4 = start.func_72441_c(-w2, 0.0, -w2);
            Intrinsics.checkNotNullExpressionValue(vec3d4, "add(...)");
            it = blockPos = this.rayTrace(vec3d4, end);
            boolean bl6 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d5 = start.func_72441_c(w2, 0.0, w2 / (double)2.0f);
            Intrinsics.checkNotNullExpressionValue(vec3d5, "add(...)");
            it = blockPos = this.rayTrace(vec3d5, end);
            boolean bl7 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d6 = start.func_72441_c(-w2, 0.0, w2 / (double)2.0f);
            Intrinsics.checkNotNullExpressionValue(vec3d6, "add(...)");
            it = blockPos = this.rayTrace(vec3d6, end);
            boolean bl8 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d7 = start.func_72441_c(w2 / (double)2.0f, 0.0, w2);
            Intrinsics.checkNotNullExpressionValue(vec3d7, "add(...)");
            it = blockPos = this.rayTrace(vec3d7, end);
            boolean bl9 = false;
            raytracedBlock = it;
            if (blockPos != null) {
                return new CollisionResult(raytracedBlock, i2);
            }
            Vec3d vec3d8 = start.func_72441_c(w2 / (double)2.0f, 0.0, -w2);
            Intrinsics.checkNotNullExpressionValue(vec3d8, "add(...)");
            it = blockPos = this.rayTrace(vec3d8, end);
            boolean bl10 = false;
            raytracedBlock = it;
            if (blockPos == null) continue;
            return new CollisionResult(raytracedBlock, i2);
        }
        return null;
    }

    private final BlockPos rayTrace(Vec3d start, Vec3d end) {
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return null;
        }
        WorldClient world = worldClient;
        RayTraceResult result = world.func_72901_a(start, end, true);
        if (result != null && result.field_72313_a == RayTraceResult.Type.BLOCK && result.field_178784_b == EnumFacing.UP) {
            return result.func_178782_a();
        }
        return null;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer$CollisionResult;", "", "pos", "Lnet/minecraft/util/math/BlockPos;", "tick", "", "<init>", "(Lnet/minecraft/util/math/BlockPos;I)V", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getTick", "()I", "DarkMeow"})
    public static final class CollisionResult {
        @Nullable
        private final BlockPos pos;
        private final int tick;

        public CollisionResult(@Nullable BlockPos pos, int tick) {
            this.pos = pos;
            this.tick = tick;
        }

        @Nullable
        public final BlockPos getPos() {
            return this.pos;
        }

        public final int getTick() {
            return this.tick;
        }
    }
}

