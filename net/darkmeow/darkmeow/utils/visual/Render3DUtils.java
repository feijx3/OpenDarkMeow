/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.utils.visual;

import java.awt.Color;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.darkmeow.darkmeow.utils.world.AxisAlignedBBUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0010J:\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\tJU\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0015JD\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\tJE\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0018J4\u0010\u0019\u001a\u00020\u0005*\u00020\u00172\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\tJ \u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\tH\u0002\u00a8\u0006\u001d"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/Render3DUtils;", "", "<init>", "()V", "drawBlockBoxOutlined", "", "Lnet/minecraft/entity/Entity;", "pos", "partialTicks", "", "color", "Ljava/awt/Color;", "width", "disableDepth", "", "scale", "(Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;FLjava/awt/Color;Ljava/lang/Float;ZF)V", "drawBlockBoxFilled", "Lnet/minecraft/util/math/BlockPos;", "originPoint", "Lnet/darkmeow/darkmeow/utils/visual/Render3DUtils$OriginPoint;", "(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/BlockPos;FLjava/awt/Color;Ljava/lang/Float;ZLnet/darkmeow/darkmeow/utils/visual/Render3DUtils$OriginPoint;F)V", "drawBoxOutlined", "Lnet/minecraft/util/math/AxisAlignedBB;", "(Lnet/minecraft/util/math/AxisAlignedBB;Ljava/awt/Color;Ljava/lang/Float;ZLnet/darkmeow/darkmeow/utils/visual/Render3DUtils$OriginPoint;F)V", "drawBoxFilled", "calculateAdjustedBounds", "bb", "OriginPoint", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRender3DUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Render3DUtils.kt\nnet/darkmeow/darkmeow/utils/visual/Render3DUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1#2:297\n*E\n"})
public final class Render3DUtils {
    @NotNull
    public static final Render3DUtils INSTANCE = new Render3DUtils();

    private Render3DUtils() {
    }

    public final void drawBlockBoxOutlined(@NotNull Entity $this$drawBlockBoxOutlined, @NotNull Entity pos, float partialTicks, @Nullable Color color, @Nullable Float width, boolean disableDepth, float scale) {
        Intrinsics.checkNotNullParameter($this$drawBlockBoxOutlined, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        AxisAlignedBB axisAlignedBB = pos.func_184177_bl().func_72317_d(-($this$drawBlockBoxOutlined.field_70142_S + ($this$drawBlockBoxOutlined.field_70165_t - $this$drawBlockBoxOutlined.field_70142_S) * (double)partialTicks), -($this$drawBlockBoxOutlined.field_70137_T + ($this$drawBlockBoxOutlined.field_70163_u - $this$drawBlockBoxOutlined.field_70137_T) * (double)partialTicks), -($this$drawBlockBoxOutlined.field_70136_U + ($this$drawBlockBoxOutlined.field_70161_v - $this$drawBlockBoxOutlined.field_70136_U) * (double)partialTicks));
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "offset(...)");
        Render3DUtils.drawBoxOutlined$default(this, AxisAlignedBBUtils.INSTANCE.scale(axisAlignedBB, scale), color, width, disableDepth, null, 0.0f, 24, null);
    }

    public static /* synthetic */ void drawBlockBoxOutlined$default(Render3DUtils render3DUtils, Entity entity, Entity entity2, float f2, Color color, Float f3, boolean bl2, float f4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            color = null;
        }
        if ((n2 & 8) != 0) {
            f3 = null;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x20) != 0) {
            f4 = 1.0f;
        }
        render3DUtils.drawBlockBoxOutlined(entity, entity2, f2, color, f3, bl2, f4);
    }

    public final void drawBlockBoxFilled(@NotNull Entity $this$drawBlockBoxFilled, @NotNull Entity pos, float partialTicks, @Nullable Color color, boolean disableDepth, float scale) {
        Intrinsics.checkNotNullParameter($this$drawBlockBoxFilled, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        AxisAlignedBB axisAlignedBB = pos.func_184177_bl().func_72317_d(-($this$drawBlockBoxFilled.field_70142_S + ($this$drawBlockBoxFilled.field_70165_t - $this$drawBlockBoxFilled.field_70142_S) * (double)partialTicks), -($this$drawBlockBoxFilled.field_70137_T + ($this$drawBlockBoxFilled.field_70163_u - $this$drawBlockBoxFilled.field_70137_T) * (double)partialTicks), -($this$drawBlockBoxFilled.field_70136_U + ($this$drawBlockBoxFilled.field_70161_v - $this$drawBlockBoxFilled.field_70136_U) * (double)partialTicks));
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "offset(...)");
        Render3DUtils.drawBoxFilled$default(this, AxisAlignedBBUtils.INSTANCE.scale(axisAlignedBB, scale), color, disableDepth, null, 0.0f, 12, null);
    }

    public static /* synthetic */ void drawBlockBoxFilled$default(Render3DUtils render3DUtils, Entity entity, Entity entity2, float f2, Color color, boolean bl2, float f3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            color = null;
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x10) != 0) {
            f3 = 1.0f;
        }
        render3DUtils.drawBlockBoxFilled(entity, entity2, f2, color, bl2, f3);
    }

    public final void drawBlockBoxOutlined(@NotNull Entity $this$drawBlockBoxOutlined, @NotNull BlockPos pos, float partialTicks, @Nullable Color color, @Nullable Float width, boolean disableDepth, @NotNull OriginPoint originPoint, float scale) {
        Intrinsics.checkNotNullParameter($this$drawBlockBoxOutlined, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter((Object)originPoint, "originPoint");
        AxisAlignedBB axisAlignedBB = $this$drawBlockBoxOutlined.field_70170_p.func_180495_p(pos).func_185900_c((IBlockAccess)$this$drawBlockBoxOutlined.field_70170_p, pos).func_186670_a(pos).func_72321_a(0.006, 0.006, 0.006).func_72317_d(-($this$drawBlockBoxOutlined.field_70142_S + ($this$drawBlockBoxOutlined.field_70165_t - $this$drawBlockBoxOutlined.field_70142_S) * (double)partialTicks), -($this$drawBlockBoxOutlined.field_70137_T + ($this$drawBlockBoxOutlined.field_70163_u - $this$drawBlockBoxOutlined.field_70137_T) * (double)partialTicks), -($this$drawBlockBoxOutlined.field_70136_U + ($this$drawBlockBoxOutlined.field_70161_v - $this$drawBlockBoxOutlined.field_70136_U) * (double)partialTicks));
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "offset(...)");
        this.drawBoxOutlined(axisAlignedBB, color, width, disableDepth, originPoint, scale);
    }

    public static /* synthetic */ void drawBlockBoxOutlined$default(Render3DUtils render3DUtils, Entity entity, BlockPos blockPos, float f2, Color color, Float f3, boolean bl2, OriginPoint originPoint, float f4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            color = null;
        }
        if ((n2 & 8) != 0) {
            f3 = null;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x20) != 0) {
            originPoint = OriginPoint.CENTER;
        }
        if ((n2 & 0x40) != 0) {
            f4 = 1.0f;
        }
        render3DUtils.drawBlockBoxOutlined(entity, blockPos, f2, color, f3, bl2, originPoint, f4);
    }

    public final void drawBlockBoxFilled(@NotNull Entity $this$drawBlockBoxFilled, @NotNull BlockPos pos, float partialTicks, @Nullable Color color, boolean disableDepth, @NotNull OriginPoint originPoint, float scale) {
        Intrinsics.checkNotNullParameter($this$drawBlockBoxFilled, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter((Object)originPoint, "originPoint");
        AxisAlignedBB axisAlignedBB = $this$drawBlockBoxFilled.field_70170_p.func_180495_p(pos).func_185900_c((IBlockAccess)$this$drawBlockBoxFilled.field_70170_p, pos).func_186670_a(pos).func_72321_a(0.006, 0.006, 0.006).func_72317_d(-($this$drawBlockBoxFilled.field_70142_S + ($this$drawBlockBoxFilled.field_70165_t - $this$drawBlockBoxFilled.field_70142_S) * (double)partialTicks), -($this$drawBlockBoxFilled.field_70137_T + ($this$drawBlockBoxFilled.field_70163_u - $this$drawBlockBoxFilled.field_70137_T) * (double)partialTicks), -($this$drawBlockBoxFilled.field_70136_U + ($this$drawBlockBoxFilled.field_70161_v - $this$drawBlockBoxFilled.field_70136_U) * (double)partialTicks));
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "offset(...)");
        this.drawBoxFilled(axisAlignedBB, color, disableDepth, originPoint, scale);
    }

    public static /* synthetic */ void drawBlockBoxFilled$default(Render3DUtils render3DUtils, Entity entity, BlockPos blockPos, float f2, Color color, boolean bl2, OriginPoint originPoint, float f3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            color = null;
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x10) != 0) {
            originPoint = OriginPoint.CENTER;
        }
        if ((n2 & 0x20) != 0) {
            f3 = 1.0f;
        }
        render3DUtils.drawBlockBoxFilled(entity, blockPos, f2, color, bl2, originPoint, f3);
    }

    public final void drawBoxOutlined(@NotNull AxisAlignedBB $this$drawBoxOutlined, @Nullable Color color, @Nullable Float width, boolean disableDepth, @NotNull OriginPoint originPoint, float scale) {
        BufferBuilder bufferBuilder;
        Serializable serializable;
        Intrinsics.checkNotNullParameter($this$drawBoxOutlined, "<this>");
        Intrinsics.checkNotNullParameter((Object)originPoint, "originPoint");
        Float f2 = width;
        if (f2 != null) {
            serializable = f2;
            float lineWidth = ((Number)serializable).floatValue();
            boolean bl2 = false;
            GlStateManager.func_187441_d((float)lineWidth);
        }
        GlStateManagerUtils.INSTANCE.applyBlend();
        GlStateManager.func_179090_x();
        GlStateManager.func_179129_p();
        if (disableDepth) {
            GlStateManager.func_179097_i();
        }
        Color color2 = color;
        if (color2 != null) {
            ColorUtils.INSTANCE.setGlColor(color2);
        }
        Float it = serializable = Tessellator.func_178181_a();
        boolean bl3 = false;
        AxisAlignedBB aBB = INSTANCE.calculateAdjustedBounds($this$drawBoxOutlined, originPoint, scale);
        BufferBuilder $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241 = bufferBuilder = it.func_178180_c();
        boolean bl4 = false;
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181668_a(3, DefaultVertexFormats.field_181705_e);
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxOutlined_u24lambda_u242_u24lambda_u241.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        serializable.func_78381_a();
        if (disableDepth) {
            GlStateManager.func_179126_j();
        }
        GlStateManagerUtils.INSTANCE.unapplyBlend();
        Color color3 = color;
        if (color3 != null) {
            it = serializable = color3;
            boolean bl5 = false;
            GlStateManager.func_179117_G();
        }
        GlStateManager.func_179098_w();
    }

    public static /* synthetic */ void drawBoxOutlined$default(Render3DUtils render3DUtils, AxisAlignedBB axisAlignedBB, Color color, Float f2, boolean bl2, OriginPoint originPoint, float f3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            color = null;
        }
        if ((n2 & 2) != 0) {
            f2 = null;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            originPoint = OriginPoint.CENTER;
        }
        if ((n2 & 0x10) != 0) {
            f3 = 1.0f;
        }
        render3DUtils.drawBoxOutlined(axisAlignedBB, color, f2, bl2, originPoint, f3);
    }

    public final void drawBoxFilled(@NotNull AxisAlignedBB $this$drawBoxFilled, @Nullable Color color, boolean disableDepth, @NotNull OriginPoint originPoint, float scale) {
        BufferBuilder bufferBuilder;
        Object object;
        Intrinsics.checkNotNullParameter($this$drawBoxFilled, "<this>");
        Intrinsics.checkNotNullParameter((Object)originPoint, "originPoint");
        GlStateManagerUtils.INSTANCE.applyBlend();
        GlStateManager.func_179090_x();
        GlStateManager.func_179129_p();
        if (disableDepth) {
            GlStateManager.func_179097_i();
        }
        Color color2 = color;
        if (color2 != null) {
            ColorUtils.INSTANCE.setGlColor(color2);
        }
        Tessellator it = object = Tessellator.func_178181_a();
        boolean bl2 = false;
        AxisAlignedBB aBB = INSTANCE.calculateAdjustedBounds($this$drawBoxFilled, originPoint, scale);
        BufferBuilder $this$drawBoxFilled_u24lambda_u245_u24lambda_u244 = bufferBuilder = it.func_178180_c();
        boolean bl3 = false;
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72337_e, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72340_a, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72339_c).func_181675_d();
        $this$drawBoxFilled_u24lambda_u245_u24lambda_u244.func_181662_b(aBB.field_72336_d, aBB.field_72338_b, aBB.field_72334_f).func_181675_d();
        object.func_78381_a();
        if (disableDepth) {
            GlStateManager.func_179126_j();
        }
        GlStateManagerUtils.INSTANCE.unapplyBlend();
        Color color3 = color;
        if (color3 != null) {
            it = object = color3;
            boolean bl4 = false;
            GlStateManager.func_179117_G();
        }
        GlStateManager.func_179098_w();
    }

    public static /* synthetic */ void drawBoxFilled$default(Render3DUtils render3DUtils, AxisAlignedBB axisAlignedBB, Color color, boolean bl2, OriginPoint originPoint, float f2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            color = null;
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            originPoint = OriginPoint.CENTER;
        }
        if ((n2 & 8) != 0) {
            f2 = 1.0f;
        }
        render3DUtils.drawBoxFilled(axisAlignedBB, color, bl2, originPoint, f2);
    }

    private final AxisAlignedBB calculateAdjustedBounds(AxisAlignedBB bb2, OriginPoint originPoint, float scale) {
        double centerX = (bb2.field_72340_a + bb2.field_72336_d) / (double)2;
        double centerY = (bb2.field_72338_b + bb2.field_72337_e) / (double)2;
        double centerZ = (bb2.field_72339_c + bb2.field_72334_f) / (double)2;
        double minX = bb2.field_72340_a;
        double maxX = bb2.field_72336_d;
        double minY = bb2.field_72338_b;
        double maxY = bb2.field_72337_e;
        double minZ = bb2.field_72339_c;
        double maxZ = bb2.field_72334_f;
        switch (WhenMappings.$EnumSwitchMapping$0[originPoint.ordinal()]) {
            case 1: {
                double height = bb2.field_72337_e - bb2.field_72338_b;
                maxY = bb2.field_72338_b + height * (double)scale;
                break;
            }
            case 2: {
                double height = bb2.field_72337_e - bb2.field_72338_b;
                minY = bb2.field_72337_e - height * (double)scale;
                break;
            }
            case 3: {
                minX = centerX - (centerX - bb2.field_72340_a) * (double)scale;
                maxX = centerX + (bb2.field_72336_d - centerX) * (double)scale;
                minY = centerY - (centerY - bb2.field_72338_b) * (double)scale;
                maxY = centerY + (bb2.field_72337_e - centerY) * (double)scale;
                minZ = centerZ - (centerZ - bb2.field_72339_c) * (double)scale;
                maxZ = centerZ + (bb2.field_72334_f - centerZ) * (double)scale;
                break;
            }
            case 4: {
                minX = centerX - (centerX - bb2.field_72340_a) * (double)(1.0f - scale);
                maxX = centerX + (bb2.field_72336_d - centerX) * (double)(1.0f - scale);
                minY = centerY - (centerY - bb2.field_72338_b) * (double)(1.0f - scale);
                maxY = centerY + (bb2.field_72337_e - centerY) * (double)(1.0f - scale);
                minZ = centerZ - (centerZ - bb2.field_72339_c) * (double)(1.0f - scale);
                maxZ = centerZ + (bb2.field_72334_f - centerZ) * (double)(1.0f - scale);
                break;
            }
            case 5: {
                minX = bb2.field_72336_d - (bb2.field_72336_d - bb2.field_72340_a) * (double)scale;
                break;
            }
            case 6: {
                maxX = bb2.field_72340_a + (bb2.field_72336_d - bb2.field_72340_a) * (double)scale;
                break;
            }
            case 7: {
                maxZ = bb2.field_72339_c + (bb2.field_72334_f - bb2.field_72339_c) * (double)scale;
                break;
            }
            case 8: {
                minZ = bb2.field_72334_f - (bb2.field_72334_f - bb2.field_72339_c) * (double)scale;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/Render3DUtils$OriginPoint;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", "TOP", "CENTER", "SURROUND", "EAST", "WEST", "NORTH", "SOUTH", "DarkMeow"})
    public static final class OriginPoint
    extends Enum<OriginPoint> {
        public static final /* enum */ OriginPoint BOTTOM = new OriginPoint();
        public static final /* enum */ OriginPoint TOP = new OriginPoint();
        public static final /* enum */ OriginPoint CENTER = new OriginPoint();
        public static final /* enum */ OriginPoint SURROUND = new OriginPoint();
        public static final /* enum */ OriginPoint EAST = new OriginPoint();
        public static final /* enum */ OriginPoint WEST = new OriginPoint();
        public static final /* enum */ OriginPoint NORTH = new OriginPoint();
        public static final /* enum */ OriginPoint SOUTH = new OriginPoint();
        private static final /* synthetic */ OriginPoint[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static OriginPoint[] values() {
            return (OriginPoint[])$VALUES.clone();
        }

        public static OriginPoint valueOf(String value) {
            return Enum.valueOf(OriginPoint.class, value);
        }

        @NotNull
        public static EnumEntries<OriginPoint> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = originPointArray = new OriginPoint[]{OriginPoint.BOTTOM, OriginPoint.TOP, OriginPoint.CENTER, OriginPoint.SURROUND, OriginPoint.EAST, OriginPoint.WEST, OriginPoint.NORTH, OriginPoint.SOUTH};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[OriginPoint.values().length];
            try {
                nArray[OriginPoint.BOTTOM.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.TOP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.CENTER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.SURROUND.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.EAST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.WEST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.NORTH.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OriginPoint.SOUTH.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

