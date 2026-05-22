/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="BlockOverlay", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockOverlay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "outlineWidthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBlockOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockOverlay.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/BlockOverlay\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class BlockOverlay
extends Module {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final FloatValue outlineWidthValue;
    @JvmField
    @NotNull
    public final ColorValue colorValue;

    /*
     * WARNING - void declaration
     */
    public BlockOverlay() {
        super(null, null, null, null, 15, null);
        void $this$outlineWidthValue_u24lambda_u241;
        Object $this$outlineWidthValue_u24lambda_u240;
        Object object = new String[]{"Fill", "Outline"};
        this.modeValue = new ListValue("Mode", (String[])object, "Fill");
        Object object2 = object = new FloatValue("OutlineWidth", 2.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 2.0f));
        BlockOverlay blockOverlay = this;
        boolean bl2 = false;
        $this$outlineWidthValue_u24lambda_u240.setSuperValue(this.modeValue);
        $this$outlineWidthValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$outlineWidthValue_u24lambda_u241.setSuperValueMeta("Outline");
        blockOverlay.outlineWidthValue = object;
        this.colorValue = new ColorValue("Color", new ColorValueInfo(new Color(68, 117, 255, 200)), false, 4, null);
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        block7: {
            RayTraceResult rayTraceResult;
            RayTraceResult rayTraceResult2;
            Intrinsics.checkNotNullParameter(event, "event");
            Entity entity = MinecraftInstance.mc.getRenderViewEntity();
            if (entity == null) {
                return;
            }
            Entity renderEntity = entity;
            RayTraceResult rayTraceResult3 = MinecraftInstance.mc.getObjectMouseOver();
            if (rayTraceResult3 == null) break block7;
            RayTraceResult it = rayTraceResult2 = rayTraceResult3;
            boolean bl2 = false;
            Object object = rayTraceResult = it.field_72313_a == RayTraceResult.Type.BLOCK ? rayTraceResult2 : null;
            if (rayTraceResult != null && (rayTraceResult2 = rayTraceResult.func_178782_a()) != null) {
                RayTraceResult rayTraceResult4;
                RayTraceResult rayTraceResult5;
                RayTraceResult it2 = rayTraceResult5 = rayTraceResult2;
                boolean bl3 = false;
                Object object2 = rayTraceResult4 = renderEntity.field_70170_p.func_175723_af().func_177746_a((BlockPos)it2) ? rayTraceResult5 : null;
                if (rayTraceResult4 != null) {
                    RayTraceResult rayTraceResult6;
                    RayTraceResult it3 = rayTraceResult6 = rayTraceResult4;
                    boolean bl4 = false;
                    IBlockState state = renderEntity.field_70170_p.func_180495_p((BlockPos)it3);
                    boolean bl5 = false;
                    Object object3 = rayTraceResult5 = state.func_177230_c().func_176209_a(state, false) ? rayTraceResult6 : null;
                    if (rayTraceResult5 != null) {
                        RayTraceResult pos = rayTraceResult6 = rayTraceResult5;
                        boolean bl6 = false;
                        GlStateManager.func_179132_a((boolean)false);
                        String string = (String)this.modeValue.get();
                        if (Intrinsics.areEqual(string, "Fill")) {
                            Render3DUtils.drawBlockBoxFilled$default(Render3DUtils.INSTANCE, renderEntity, (BlockPos)pos, event.getPartialTicks(), ColorValue.getColor$default(this.colorValue, null, 1, null), false, null, 0.0f, 56, null);
                        } else if (Intrinsics.areEqual(string, "Outline")) {
                            Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, renderEntity, (BlockPos)pos, event.getPartialTicks(), ColorValue.getColor$default(this.colorValue, null, 1, null), (Float)this.outlineWidthValue.get(), false, null, 0.0f, 112, null);
                        }
                        GlStateManager.func_179098_w();
                        GlStateManager.func_179132_a((boolean)true);
                    }
                }
            }
        }
    }
}

