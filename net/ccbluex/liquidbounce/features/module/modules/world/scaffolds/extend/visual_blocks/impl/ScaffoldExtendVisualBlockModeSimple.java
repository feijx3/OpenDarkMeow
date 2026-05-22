/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks.ScaffoldExtendVisualBlockMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/impl/ScaffoldExtendVisualBlockModeSimple;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/ScaffoldExtendVisualBlockMode;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "outlineWidthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "lastPlace", "Lnet/minecraft/util/math/BlockPos;", "onRender", "", "partialTicks", "", "onPlaced", "pos", "onClear", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendVisualBlockModeSimple.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendVisualBlockModeSimple.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/impl/ScaffoldExtendVisualBlockModeSimple\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class ScaffoldExtendVisualBlockModeSimple
extends ScaffoldExtendVisualBlockMode {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final FloatValue outlineWidthValue;
    @JvmField
    @NotNull
    public final ColorValue colorValue;
    @Nullable
    private BlockPos lastPlace;

    /*
     * WARNING - void declaration
     */
    public ScaffoldExtendVisualBlockModeSimple() {
        super("Simple");
        void $this$outlineWidthValue_u24lambda_u241;
        Object $this$outlineWidthValue_u24lambda_u240;
        Object object = new String[]{"Fill", "Outline"};
        this.modeValue = new ListValue("Mode", (String[])object, "Fill");
        Object object2 = object = new FloatValue("OutlineWidth", 2.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 2.0f));
        ScaffoldExtendVisualBlockModeSimple scaffoldExtendVisualBlockModeSimple = this;
        boolean bl2 = false;
        $this$outlineWidthValue_u24lambda_u240.setSuperValue(this.modeValue);
        $this$outlineWidthValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$outlineWidthValue_u24lambda_u241.setSuperValueMeta("Outline");
        scaffoldExtendVisualBlockModeSimple.outlineWidthValue = object;
        Color color = Color.RED;
        Intrinsics.checkNotNullExpressionValue(color, "RED");
        this.colorValue = new ColorValue("Color", new ColorValueInfo(color), false, 4, null);
    }

    @Override
    public void onRender(float partialTicks) {
        block1: {
            String string;
            BlockPos blockPos;
            Entity renderEntity;
            block2: {
                BlockPos blockPos2;
                Entity entity = MinecraftInstance.mc.getRenderViewEntity();
                if (entity == null) {
                    return;
                }
                renderEntity = entity;
                BlockPos blockPos3 = this.lastPlace;
                if (blockPos3 == null) break block1;
                blockPos = blockPos2 = blockPos3;
                boolean bl2 = false;
                string = (String)this.modeValue.get();
                if (!Intrinsics.areEqual(string, "Fill")) break block2;
                Render3DUtils.drawBlockBoxFilled$default(Render3DUtils.INSTANCE, renderEntity, blockPos, partialTicks, ColorValue.getColor$default(this.colorValue, null, 1, null), false, null, 0.0f, 56, null);
                break block1;
            }
            if (!Intrinsics.areEqual(string, "Outline")) break block1;
            Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, renderEntity, blockPos, partialTicks, ColorValue.getColor$default(this.colorValue, null, 1, null), (Float)this.outlineWidthValue.get(), false, null, 0.0f, 112, null);
        }
    }

    @Override
    public void onPlaced(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.lastPlace = pos;
    }

    @Override
    public void onClear() {
        this.lastPlace = null;
    }
}

