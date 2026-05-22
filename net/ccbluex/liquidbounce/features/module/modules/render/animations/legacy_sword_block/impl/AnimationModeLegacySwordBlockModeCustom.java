/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockMode;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockPrevSwingExtend;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/impl/AnimationModeLegacySwordBlockModeCustom;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockMode;", "<init>", "()V", "translateValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "translateXBaseValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "translateXRateValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "translateXExtraValue", "translateYBaseValue", "translateYRateValue", "translateYExtraValue", "translateZBaseValue", "translateZRateValue", "translateZExtraValue", "progressRotateXValue", "progressRotateYValue", "progressRotateZValue", "getTranslateBase", "", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "partialTicks", "apply", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAnimationModeLegacySwordBlockModeCustom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationModeLegacySwordBlockModeCustom.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/impl/AnimationModeLegacySwordBlockModeCustom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
public final class AnimationModeLegacySwordBlockModeCustom
extends AnimationModeLegacySwordBlockMode {
    @JvmField
    @NotNull
    public final BoolValue translateValue = new BoolValue("Translate", true);
    @JvmField
    @NotNull
    public final ListValue translateXBaseValue;
    @JvmField
    @NotNull
    public final FloatValue translateXRateValue;
    @JvmField
    @NotNull
    public final FloatValue translateXExtraValue;
    @JvmField
    @NotNull
    public final ListValue translateYBaseValue;
    @JvmField
    @NotNull
    public final FloatValue translateYRateValue;
    @JvmField
    @NotNull
    public final FloatValue translateYExtraValue;
    @JvmField
    @NotNull
    public final ListValue translateZBaseValue;
    @JvmField
    @NotNull
    public final FloatValue translateZRateValue;
    @JvmField
    @NotNull
    public final FloatValue translateZExtraValue;
    @JvmField
    @NotNull
    public final FloatValue progressRotateXValue;
    @JvmField
    @NotNull
    public final FloatValue progressRotateYValue;
    @JvmField
    @NotNull
    public final FloatValue progressRotateZValue;

    /*
     * WARNING - void declaration
     */
    public AnimationModeLegacySwordBlockModeCustom() {
        super("Custom");
        void $this$translateZExtraValue_u24lambda_u2411;
        Object $this$translateZRateValue_u24lambda_u2410;
        Object $this$translateZRateValue_u24lambda_u249;
        Object $this$translateZBaseValue_u24lambda_u248;
        Object $this$translateYExtraValue_u24lambda_u247;
        String[] $this$translateYRateValue_u24lambda_u246;
        Object $this$translateYRateValue_u24lambda_u245;
        Object $this$translateYBaseValue_u24lambda_u244;
        Object $this$translateXExtraValue_u24lambda_u243;
        String[] $this$translateXRateValue_u24lambda_u242;
        Object $this$translateXRateValue_u24lambda_u241;
        Object $this$translateXBaseValue_u24lambda_u240;
        Object object = new String[]{"None", "SwingProgress"};
        Object object2 = object = new ListValue("TranslateXBase", (String[])object, "None");
        AnimationModeLegacySwordBlockModeCustom animationModeLegacySwordBlockModeCustom = this;
        boolean bl2 = false;
        $this$translateXBaseValue_u24lambda_u240.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateXBaseValue = object;
        $this$translateXBaseValue_u24lambda_u240 = object = new FloatValue("TranslateXRate", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl3 = false;
        $this$translateXRateValue_u24lambda_u241.setSuperValue(this.translateXBaseValue);
        $this$translateXRateValue_u24lambda_u241 = object;
        boolean bl4 = false;
        $this$translateXRateValue_u24lambda_u242.setSuperValueMeta("!None");
        animationModeLegacySwordBlockModeCustom.translateXRateValue = object;
        $this$translateXRateValue_u24lambda_u242 = object = new FloatValue("TranslateXExtra", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl5 = false;
        $this$translateXExtraValue_u24lambda_u243.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateXExtraValue = object;
        object = new String[]{"None", "SwingProgress"};
        $this$translateXExtraValue_u24lambda_u243 = object = new ListValue("TranslateYBase", (String[])object, "SwingProgress");
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl6 = false;
        $this$translateYBaseValue_u24lambda_u244.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateYBaseValue = object;
        $this$translateYBaseValue_u24lambda_u244 = object = new FloatValue("TranslateYRate", -0.6f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl7 = false;
        $this$translateYRateValue_u24lambda_u245.setSuperValue(this.translateYBaseValue);
        $this$translateYRateValue_u24lambda_u245 = object;
        boolean bl8 = false;
        $this$translateYRateValue_u24lambda_u246.setSuperValueMeta("!None");
        animationModeLegacySwordBlockModeCustom.translateYRateValue = object;
        $this$translateYRateValue_u24lambda_u246 = object = new FloatValue("TranslateYExtra", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl9 = false;
        $this$translateYExtraValue_u24lambda_u247.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateYExtraValue = object;
        object = new String[]{"None", "SwingProgress"};
        $this$translateYExtraValue_u24lambda_u247 = object = new ListValue("TranslateZBase", (String[])object, "None");
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl10 = false;
        $this$translateZBaseValue_u24lambda_u248.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateZBaseValue = object;
        $this$translateZBaseValue_u24lambda_u248 = object = new FloatValue("TranslateZRate", -0.0f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl11 = false;
        $this$translateZRateValue_u24lambda_u249.setSuperValue(this.translateZBaseValue);
        $this$translateZRateValue_u24lambda_u249 = object;
        boolean bl12 = false;
        $this$translateZRateValue_u24lambda_u2410.setSuperValueMeta("!None");
        animationModeLegacySwordBlockModeCustom.translateZRateValue = object;
        $this$translateZRateValue_u24lambda_u2410 = object = new FloatValue("TranslateZExtra", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(-1.0f, 1.0f));
        animationModeLegacySwordBlockModeCustom = this;
        boolean bl13 = false;
        $this$translateZExtraValue_u24lambda_u2411.setSuperValue(this.translateValue);
        animationModeLegacySwordBlockModeCustom.translateZExtraValue = object;
        this.progressRotateXValue = new FloatValue("ProgressRotateX", -20.0f, (ClosedRange<Float>)RangesKt.rangeTo(-100.0f, 100.0f));
        this.progressRotateYValue = new FloatValue("ProgressRotateY", -20.0f, (ClosedRange<Float>)RangesKt.rangeTo(-100.0f, 100.0f));
        this.progressRotateZValue = new FloatValue("ProgressRotateZ", -20.0f, (ClosedRange<Float>)RangesKt.rangeTo(-100.0f, 100.0f));
    }

    private final float getTranslateBase(ListValue $this$getTranslateBase, AbstractClientPlayer player, float partialTicks) {
        return Intrinsics.areEqual((String)$this$getTranslateBase.getValue(), "SwingProgress") ? AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getCurrentSwingProgress(player, partialTicks) : 1.0f;
    }

    @Override
    public void apply(@NotNull AbstractClientPlayer player, float partialTicks) {
        float f2;
        int n2;
        Intrinsics.checkNotNullParameter(player, "player");
        if (((Boolean)this.translateValue.get()).booleanValue()) {
            GlStateManager.func_179109_b((float)(this.getTranslateBase(this.translateXBaseValue, player, partialTicks) * ((Number)this.translateXRateValue.get()).floatValue() + ((Number)this.translateXExtraValue.get()).floatValue()), (float)(this.getTranslateBase(this.translateYBaseValue, player, partialTicks) * ((Number)this.translateYRateValue.get()).floatValue() + ((Number)this.translateYExtraValue.get()).floatValue()), (float)(this.getTranslateBase(this.translateZBaseValue, player, partialTicks) * ((Number)this.translateZRateValue.get()).floatValue() + ((Number)this.translateZExtraValue.get()).floatValue()));
        }
        int side = n2 = AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getGLRotationBaseBySide(player);
        boolean bl2 = false;
        GlStateManager.func_179114_b((float)-102.25f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)side * 13.365f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)side * 78.05f), (float)0.0f, (float)0.0f, (float)1.0f);
        float swingProgress = f2 = AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getCurrentSwingProgress(player, partialTicks);
        boolean bl3 = false;
        double f3 = Math.sin((double)(swingProgress * swingProgress) * Math.PI);
        double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
        GlStateManager.func_179114_b((float)((float)f3 * ((Number)this.progressRotateXValue.get()).floatValue()), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)f1 * ((Number)this.progressRotateYValue.get()).floatValue()), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.func_179114_b((float)((float)f1 * ((Number)this.progressRotateZValue.get()).floatValue()), (float)1.0f, (float)0.0f, (float)0.0f);
    }
}

