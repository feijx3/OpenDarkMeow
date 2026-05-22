/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks.ScaffoldExtendVisualBlockMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.utils.kotlin.BoundedArrayDeque;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/impl/ScaffoldExtendVisualBlockModeDarkMeow;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/ScaffoldExtendVisualBlockMode;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "places", "Lnet/darkmeow/darkmeow/utils/kotlin/BoundedArrayDeque;", "Lnet/minecraft/util/math/BlockPos;", "onRender", "", "partialTicks", "", "onPlaced", "pos", "onClear", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendVisualBlockModeDarkMeow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendVisualBlockModeDarkMeow.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/impl/ScaffoldExtendVisualBlockModeDarkMeow\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n2767#2:53\n1878#2,2:55\n1880#2:58\n1#3:54\n1#3:57\n*S KotlinDebug\n*F\n+ 1 ScaffoldExtendVisualBlockModeDarkMeow.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/impl/ScaffoldExtendVisualBlockModeDarkMeow\n*L\n28#1:53\n28#1:55,2\n28#1:58\n28#1:54\n*E\n"})
public final class ScaffoldExtendVisualBlockModeDarkMeow
extends ScaffoldExtendVisualBlockMode {
    @JvmField
    @NotNull
    public final IntegerValue rangeValue = new IntegerValue("Range", 8, new IntRange(4, 16));
    @JvmField
    @NotNull
    public final ColorValue colorValue = new ColorValue("Color", new ColorValueInfo("Rainbow", null, 0, false, 0, 30, null), true);
    @NotNull
    private final BoundedArrayDeque<BlockPos> places = new BoundedArrayDeque(((Number)this.rangeValue.get()).intValue());

    public ScaffoldExtendVisualBlockModeDarkMeow() {
        super("DarkMeow");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender(float partialTicks) {
        Iterable iterable;
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity renderEntity = entity;
        Iterable $this$onEachIndexed$iv = CollectionsKt.reversed((Iterable)this.places);
        boolean $i$f$onEachIndexed = false;
        Iterable $this$onEachIndexed_u24lambda_u2419$iv = iterable = $this$onEachIndexed$iv;
        boolean bl2 = false;
        Iterable $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
            void blockPos;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BlockPos blockPos2 = (BlockPos)item$iv$iv;
            int index = n2;
            boolean bl3 = false;
            Entity entity2 = renderEntity;
            Object it = entity2;
            boolean bl4 = false;
            Object object = (0 <= index ? index <= ((Number)this.rangeValue.get()).intValue() : false) ? entity2 : null;
            if (object == null) continue;
            Intrinsics.checkNotNull(blockPos);
            it = this.colorValue.getColor(index * 40);
            float f2 = partialTicks;
            void var22_22 = blockPos;
            Entity entity3 = object;
            Render3DUtils render3DUtils = Render3DUtils.INSTANCE;
            boolean bl5 = false;
            Color color = new Color(((Color)it).getRed(), ((Color)it).getGreen(), ((Color)it).getBlue(), (int)(255.0f / ((Number)this.rangeValue.get()).floatValue() * (float)(((Number)this.rangeValue.get()).intValue() - index)));
            Render3DUtils.drawBlockBoxOutlined$default(render3DUtils, entity3, (BlockPos)var22_22, f2, color, Float.valueOf(2.0f), false, null, 0.0f, 112, null);
        }
    }

    @Override
    public void onPlaced(@NotNull BlockPos pos) {
        BoundedArrayDeque<BlockPos> boundedArrayDeque;
        BoundedArrayDeque<BlockPos> boundedArrayDeque2;
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.places.limitSize = ((Number)this.rangeValue.get()).intValue();
        BoundedArrayDeque<BlockPos> it = boundedArrayDeque2 = this.places;
        boolean bl2 = false;
        BoundedArrayDeque<Object> boundedArrayDeque3 = boundedArrayDeque = !it.contains(pos) ? boundedArrayDeque2 : null;
        if (boundedArrayDeque != null) {
            boundedArrayDeque.add(pos);
        }
    }

    @Override
    public void onClear() {
        this.places.clear();
    }
}

