/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.utils.visual;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J_\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\t*\u00020\u0007\"\b\b\u0003\u0010\n*\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\r\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u0002H\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011Ji\u0010\u0012\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\t*\u00020\u0007\"\b\b\u0003\u0010\n*\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\r\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u0002H\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0015Jo\u0010\u0016\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\t*\u00020\u0007\"\b\b\u0003\u0010\n*\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\u0013\u001a\u0002H\t2\u0006\u0010\u0017\u001a\u0002H\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u001bJY\u0010\u001c\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0014H\u0007\u00a2\u0006\u0002\u0010$\u00a8\u0006%"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/RenderUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "drawRect", "", "T1", "", "T2", "T3", "T4", "x", "y", "x2", "y2", "color", "Ljava/awt/Color;", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;)V", "drawRoundedRect", "radius", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;FLjava/awt/Color;)V", "drawCircle", "width", "start", "", "end", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;IILjava/awt/Color;)V", "drawInGUIItem", "itemStack", "Lnet/minecraft/item/ItemStack;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "overlays", "", "zLevel", "(Ljava/lang/Number;Ljava/lang/Number;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityLivingBase;ZF)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRenderUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderUtils.kt\nnet/darkmeow/darkmeow/utils/visual/RenderUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
public final class RenderUtils
extends MinecraftInstance {
    @NotNull
    public static final RenderUtils INSTANCE = new RenderUtils();

    private RenderUtils() {
    }

    public final <T1 extends Number, T2 extends Number, T3 extends Number, T4 extends Number> void drawRect(@NotNull T1 x2, @NotNull T2 y2, @NotNull T3 x22, @NotNull T4 y22, @Nullable Color color) {
        block1: {
            BufferBuilder bufferBuilder;
            Object object;
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(y2, "y");
            Intrinsics.checkNotNullParameter(x22, "x2");
            Intrinsics.checkNotNullParameter(y22, "y2");
            GlStateManagerUtils.INSTANCE.applyBlend();
            GlStateManager.func_179090_x();
            Color color2 = color;
            if (color2 != null) {
                ColorUtils.INSTANCE.setGlColor(color2);
            }
            Tessellator it = object = Tessellator.func_178181_a();
            boolean bl2 = false;
            BufferBuilder $this$drawRect_u24lambda_u241_u24lambda_u240 = bufferBuilder = it.func_178180_c();
            boolean bl3 = false;
            $this$drawRect_u24lambda_u241_u24lambda_u240.func_181668_a(7, DefaultVertexFormats.field_181705_e);
            $this$drawRect_u24lambda_u241_u24lambda_u240.func_181662_b(x2.doubleValue(), y22.doubleValue(), 0.0).func_181675_d();
            $this$drawRect_u24lambda_u241_u24lambda_u240.func_181662_b(x22.doubleValue(), y22.doubleValue(), 0.0).func_181675_d();
            $this$drawRect_u24lambda_u241_u24lambda_u240.func_181662_b(x22.doubleValue(), y2.doubleValue(), 0.0).func_181675_d();
            $this$drawRect_u24lambda_u241_u24lambda_u240.func_181662_b(x2.doubleValue(), y2.doubleValue(), 0.0).func_181675_d();
            object.func_78381_a();
            GlStateManagerUtils.INSTANCE.unapplyBlend();
            Color color3 = color;
            if (color3 == null) break block1;
            it = object = color3;
            boolean bl4 = false;
            GlStateManager.func_179117_G();
        }
    }

    public static /* synthetic */ void drawRect$default(RenderUtils renderUtils, Number number, Number number2, Number number3, Number number4, Color color, int n2, Object object) {
        if ((n2 & 0x10) != 0) {
            color = null;
        }
        renderUtils.drawRect(number, number2, number3, number4, color);
    }

    public final <T1 extends Number, T2 extends Number, T3 extends Number, T4 extends Number> void drawRoundedRect(@NotNull T1 x2, @NotNull T2 y2, @NotNull T3 x22, @NotNull T4 y22, float radius, @Nullable Color color) {
        block6: {
            int i2;
            BufferBuilder bufferBuilder;
            Object object;
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(y2, "y");
            Intrinsics.checkNotNullParameter(x22, "x2");
            Intrinsics.checkNotNullParameter(y22, "y2");
            if (radius <= 0.0f) {
                this.drawRect(x2, y2, x22, y22, color);
                return;
            }
            GlStateManagerUtils.INSTANCE.applyBlend();
            GlStateManager.func_179090_x();
            SafeGlStateManager.enableLineSmooth();
            Color color2 = color;
            if (color2 != null) {
                ColorUtils.INSTANCE.setGlColor(color2);
            }
            double degree = Math.PI / 180;
            float realRadius = RangesKt.coerceIn(radius, 0.0f, Math.min(x22.floatValue() - x2.floatValue(), y22.floatValue() - y2.floatValue()) / (float)2);
            double posXA = x2.doubleValue() + (double)realRadius;
            double posYA = y2.doubleValue() + (double)realRadius;
            double posXB = x22.doubleValue() - (double)realRadius;
            double posYB = y22.doubleValue() - (double)realRadius;
            Tessellator it = object = Tessellator.func_178181_a();
            boolean bl2 = false;
            BufferBuilder $this$drawRoundedRect_u24lambda_u244_u24lambda_u243 = bufferBuilder = it.func_178180_c();
            boolean bl3 = false;
            $this$drawRoundedRect_u24lambda_u244_u24lambda_u243.func_181668_a(9, DefaultVertexFormats.field_181705_e);
            for (i2 = 0; i2 < 91; ++i2) {
                $this$drawRoundedRect_u24lambda_u244_u24lambda_u243.func_181662_b(posXB + Math.sin((double)i2 * degree) * (double)realRadius, posYB + Math.cos((double)i2 * degree) * (double)realRadius, 0.0).func_181675_d();
            }
            for (i2 = 90; i2 < 181; ++i2) {
                $this$drawRoundedRect_u24lambda_u244_u24lambda_u243.func_181662_b(posXB + Math.sin((double)i2 * degree) * (double)realRadius, posYA + Math.cos((double)i2 * degree) * (double)realRadius, 0.0).func_181675_d();
            }
            for (i2 = 180; i2 < 271; ++i2) {
                $this$drawRoundedRect_u24lambda_u244_u24lambda_u243.func_181662_b(posXA + Math.sin((double)i2 * degree) * (double)realRadius, posYA + Math.cos((double)i2 * degree) * (double)realRadius, 0.0).func_181675_d();
            }
            for (i2 = 270; i2 < 361; ++i2) {
                $this$drawRoundedRect_u24lambda_u244_u24lambda_u243.func_181662_b(posXA + Math.sin((double)i2 * degree) * (double)realRadius, posYB + Math.cos((double)i2 * degree) * (double)realRadius, 0.0).func_181675_d();
            }
            object.func_78381_a();
            SafeGlStateManager.disableLineSmooth();
            GlStateManagerUtils.INSTANCE.unapplyBlend();
            Color color3 = color;
            if (color3 == null) break block6;
            it = object = color3;
            boolean bl4 = false;
            GlStateManager.func_179117_G();
        }
    }

    public static /* synthetic */ void drawRoundedRect$default(RenderUtils renderUtils, Number number, Number number2, Number number3, Number number4, float f2, Color color, int n2, Object object) {
        if ((n2 & 0x10) != 0) {
            f2 = 1.0f;
        }
        if ((n2 & 0x20) != 0) {
            color = null;
        }
        renderUtils.drawRoundedRect(number, number2, number3, number4, f2, color);
    }

    public final <T1 extends Number, T2 extends Number, T3 extends Number, T4 extends Number> void drawCircle(@NotNull T1 x2, @NotNull T2 y2, @NotNull T3 radius, @NotNull T4 width, int start, int end, @Nullable Color color) {
        block3: {
            BufferBuilder bufferBuilder;
            Object object;
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(y2, "y");
            Intrinsics.checkNotNullParameter(radius, "radius");
            Intrinsics.checkNotNullParameter(width, "width");
            GlStateManagerUtils.INSTANCE.applyBlend();
            GlStateManager.func_179090_x();
            SafeGlStateManager.enableLineSmooth();
            SafeGlStateManager.glLineWidth(width.floatValue());
            Color color2 = color;
            if (color2 != null) {
                ColorUtils.INSTANCE.setGlColor(color2);
            }
            Tessellator it = object = Tessellator.func_178181_a();
            boolean bl2 = false;
            BufferBuilder $this$drawCircle_u24lambda_u247_u24lambda_u246 = bufferBuilder = it.func_178180_c();
            boolean bl3 = false;
            $this$drawCircle_u24lambda_u247_u24lambda_u246.func_181668_a(3, DefaultVertexFormats.field_181705_e);
            int n2 = start - 90;
            int n3 = end - 90;
            int i2 = n2;
            int n4 = ProgressionUtilKt.getProgressionLastElement(n2, n3, 4);
            if (i2 <= n4) {
                while (true) {
                    $this$drawCircle_u24lambda_u247_u24lambda_u246.func_181662_b(x2.doubleValue() + Math.cos(Math.toRadians(i2)) * (radius.doubleValue() * 1.001), y2.doubleValue() + Math.sin(Math.toRadians(i2)) * (radius.doubleValue() * 1.001), 0.0).func_181675_d();
                    if (i2 == n4) break;
                    i2 += 4;
                }
            }
            object.func_78381_a();
            SafeGlStateManager.disableLineSmooth();
            GlStateManagerUtils.INSTANCE.unapplyBlend();
            Color color3 = color;
            if (color3 == null) break block3;
            it = object = color3;
            boolean bl4 = false;
            GlStateManager.func_179117_G();
        }
    }

    public static /* synthetic */ void drawCircle$default(RenderUtils renderUtils, Number number, Number number2, Number number3, Number number4, int n2, int n3, Color color, int n4, Object object) {
        if ((n4 & 0x40) != 0) {
            color = null;
        }
        renderUtils.drawCircle(number, number2, number3, number4, n2, n3, color);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T1 extends Number, T2 extends Number> void drawInGUIItem(@NotNull T1 x2, @NotNull T2 y2, @NotNull ItemStack itemStack, @Nullable EntityLivingBase entity, boolean overlays, float zLevel) {
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(itemStack, "itemStack");
        RenderHelper.func_74520_c();
        GlStateManager.func_179098_w();
        MinecraftInstance.mc.getRenderItem().field_77023_b = zLevel;
        MinecraftInstance.mc.getRenderItem().func_184391_a(entity, itemStack, x2.intValue(), y2.intValue());
        if (overlays) {
            MinecraftInstance.mc.getRenderItem().func_180453_a(MinecraftInstance.mc.getFontRenderer(), itemStack, x2.intValue(), y2.intValue(), null);
        }
        RenderHelper.func_74518_a();
    }

    public static /* synthetic */ void drawInGUIItem$default(Number number, Number number2, ItemStack itemStack, EntityLivingBase entityLivingBase, boolean bl2, float f2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            entityLivingBase = null;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x20) != 0) {
            f2 = -150.0f;
        }
        RenderUtils.drawInGUIItem(number, number2, itemStack, entityLivingBase, bl2, f2);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T1 extends Number, T2 extends Number> void drawInGUIItem(@NotNull T1 x2, @NotNull T2 y2, @NotNull ItemStack itemStack, @Nullable EntityLivingBase entity, boolean overlays) {
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(itemStack, "itemStack");
        RenderUtils.drawInGUIItem$default(x2, y2, itemStack, entity, overlays, 0.0f, 32, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T1 extends Number, T2 extends Number> void drawInGUIItem(@NotNull T1 x2, @NotNull T2 y2, @NotNull ItemStack itemStack, @Nullable EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(itemStack, "itemStack");
        RenderUtils.drawInGUIItem$default(x2, y2, itemStack, entity, false, 0.0f, 48, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final <T1 extends Number, T2 extends Number> void drawInGUIItem(@NotNull T1 x2, @NotNull T2 y2, @NotNull ItemStack itemStack) {
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(itemStack, "itemStack");
        RenderUtils.drawInGUIItem$default(x2, y2, itemStack, null, false, 0.0f, 56, null);
    }
}

