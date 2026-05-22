/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.entity.item.EntityItem
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/ItemPhysics;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "fallDownRotateSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "transform", "", "entity", "Lnet/minecraft/entity/item/EntityItem;", "x", "", "y", "z", "partialTicks", "", "model", "Lnet/minecraft/client/renderer/block/model/IBakedModel;", "DarkMeow"})
public final class ItemPhysics
extends Module {
    @NotNull
    public static final ItemPhysics INSTANCE = new ItemPhysics();
    @JvmField
    @NotNull
    public static final FloatValue fallDownRotateSpeedValue = new FloatValue("FallDownRotateSpeed", 1.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 10.0f));

    private ItemPhysics() {
        super("ItemPhysics", ModuleCategory.RENDER, null, null, 12, null);
    }

    @JvmStatic
    public static final void transform(@NotNull EntityItem entity, double x2, double y2, double z2, float partialTicks, @NotNull IBakedModel model) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(model, "model");
        GlStateManager.func_179137_b((double)x2, (double)(y2 + (double)(model.func_177556_c() ? 0.1f : 0.0f)), (double)z2);
        if (entity.field_70122_E) {
            GlStateManager.func_179114_b((float)entity.field_70177_z, (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)(entity.field_70125_A + 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        } else {
            GlStateManager.func_179114_b((float)((((float)entity.func_174872_o() + partialTicks) / 20.0f + entity.field_70290_d) * 57.295776f), (float)((Number)fallDownRotateSpeedValue.get()).floatValue(), (float)((Number)fallDownRotateSpeedValue.get()).floatValue(), (float)0.0f);
        }
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        ColorUtils.INSTANCE.setGlColor(color);
    }
}

