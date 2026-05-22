/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.particles;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.Particles;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0006\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0006\u0010\rJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/particles/Particle;", "", "position", "Lnet/minecraft/util/math/Vec3d;", "color", "Ljava/awt/Color;", "<init>", "(Lnet/minecraft/util/math/Vec3d;Ljava/awt/Color;)V", "entity", "Lnet/minecraft/entity/Entity;", "base", "Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles;", "(Lnet/minecraft/entity/Entity;Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles;)V", "(Lnet/minecraft/util/math/Vec3d;Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles;)V", "lastPosition", "lastColor", "isNotCulling", "", "distanceToCurrentEntity", "", "delta", "updatePosition", "", "currentEntity", "frustum", "Lnet/minecraft/client/renderer/culling/Frustum;", "updateColor", "DarkMeow"})
public final class Particle {
    @JvmField
    @NotNull
    public Vec3d position;
    @JvmField
    @NotNull
    public Color color;
    @JvmField
    @NotNull
    public Vec3d lastPosition;
    @JvmField
    @NotNull
    public Color lastColor;
    @JvmField
    public boolean isNotCulling;
    @JvmField
    public double distanceToCurrentEntity;
    @NotNull
    private Vec3d delta;

    public Particle(@NotNull Vec3d position, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(color, "color");
        this.position = position;
        this.color = color;
        this.lastPosition = this.position;
        this.lastColor = this.color;
        this.isNotCulling = true;
        this.delta = new Vec3d(RandomUtils.INSTANCE.random(-1.25, 1.25) * 0.04, RandomUtils.INSTANCE.random(-0.2, 0.3) * 0.04, RandomUtils.INSTANCE.random(-1.25, 1.25) * 0.04);
    }

    public Particle(@NotNull Entity entity, @NotNull Particles base) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(base, "base");
        Vec3d vec3d = entity.func_174791_d().func_72441_c(0.0, (double)entity.func_70047_e(), 0.0);
        Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
        this(vec3d, base);
    }

    public Particle(@NotNull Vec3d position, @NotNull Particles base) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(base, "base");
        this(position, ColorValue.getColor$default(base.colorValue, null, 1, null));
    }

    public final void updatePosition(@NotNull Entity currentEntity, @NotNull Frustum frustum) {
        Intrinsics.checkNotNullParameter(currentEntity, "currentEntity");
        Intrinsics.checkNotNullParameter(frustum, "frustum");
        double nextPosX = this.position.field_72450_a + this.delta.field_72450_a;
        double nextPosY = this.position.field_72448_b + this.delta.field_72448_b;
        double nextPosZ = this.position.field_72449_c + this.delta.field_72449_c;
        AxisAlignedBB bboxX = new AxisAlignedBB(nextPosX, this.position.field_72448_b, this.position.field_72449_c, nextPosX, this.position.field_72448_b, this.position.field_72449_c).func_72321_a(0.001, 0.001, 0.001);
        AxisAlignedBB bboxY = new AxisAlignedBB(this.position.field_72450_a, nextPosY, this.position.field_72449_c, this.position.field_72450_a, nextPosY, this.position.field_72449_c).func_72321_a(0.001, 0.001, 0.001);
        AxisAlignedBB bboxZ = new AxisAlignedBB(this.position.field_72450_a, this.position.field_72448_b, nextPosZ, this.position.field_72450_a, this.position.field_72448_b, nextPosZ).func_72321_a(0.001, 0.001, 0.001);
        if (currentEntity.field_70170_p.func_72829_c(bboxX)) {
            Vec3d vec3d = this.delta.func_72441_c(-2.0 * this.delta.field_72450_a, 0.0, 0.0);
            Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
            this.delta = vec3d;
        }
        if (currentEntity.field_70170_p.func_72829_c(bboxY)) {
            Vec3d vec3d = this.delta.func_72441_c(0.0, -2.0 * this.delta.field_72448_b, 0.0);
            Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
            this.delta = vec3d;
        }
        if (currentEntity.field_70170_p.func_72829_c(bboxZ)) {
            Vec3d vec3d = this.delta.func_72441_c(0.0, 0.0, -2.0 * this.delta.field_72449_c);
            Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
            this.delta = vec3d;
        }
        this.lastPosition = this.position;
        Vec3d vec3d = this.position.func_178787_e(this.delta);
        Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
        this.position = vec3d;
        this.isNotCulling = frustum.func_78546_a(new AxisAlignedBB(this.position.field_72450_a - 0.1, this.position.field_72448_b - 0.1, this.position.field_72449_c - 0.1, this.position.field_72450_a + 0.1, this.position.field_72448_b + 0.1, this.position.field_72449_c + 0.1));
        if (this.isNotCulling) {
            this.distanceToCurrentEntity = currentEntity.func_70011_f(this.position.field_72450_a, this.position.field_72448_b, this.position.field_72449_c);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void updateColor(@NotNull Particles base) {
        block10: {
            block14: {
                block12: {
                    block13: {
                        block11: {
                            Intrinsics.checkNotNullParameter(base, "base");
                            if (!this.isNotCulling) break block10;
                            this.lastColor = this.color;
                            v0 = base.colorValue;
                            var2_2 = (String)base.colorOffsetModeValue.get();
                            switch (var2_2.hashCode()) {
                                case 2818: {
                                    if (!var2_2.equals("XZ")) {
                                        ** break;
                                    }
                                    break block11;
                                }
                                case -1854418717: {
                                    if (!var2_2.equals("Random")) {
                                        ** break;
                                    }
                                    break block12;
                                }
                                case 87417: {
                                    if (!var2_2.equals("XYZ")) {
                                        ** break;
                                    }
                                    break block13;
                                }
                                case 89: {
                                    if (var2_2.equals("Y")) break;
                                    ** break;
                                }
                                case 2433880: {
                                    if (!var2_2.equals("None")) ** break;
                                    v1 = 0;
                                    break block14;
                                }
                            }
                            v1 = (int)(this.position.field_72448_b * (double)100);
                            break block14;
                        }
                        v1 = (int)((this.position.field_72450_a + this.position.field_72449_c) * (double)100);
                        break block14;
                    }
                    v1 = (int)((this.position.field_72450_a + this.position.field_72448_b + this.position.field_72449_c) * (double)100);
                    break block14;
                }
                v1 = RandomUtils.INSTANCE.random(0, 1000);
                break block14;
lbl37:
                // 6 sources

                v1 = 0;
            }
            this.color = v0.getColor(v1);
        }
    }
}

