/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockMode;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockPrevSwingExtend;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/impl/AnimationModeLegacySwordBlockModePush;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockMode;", "<init>", "()V", "rotateValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "apply", "", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "partialTicks", "", "DarkMeow"})
public final class AnimationModeLegacySwordBlockModePush
extends AnimationModeLegacySwordBlockMode {
    @JvmField
    @NotNull
    public final FloatValue rotateValue = new FloatValue("Rotate", 10.0f, (ClosedRange<Float>)RangesKt.rangeTo(10.0f, 20.0f));

    public AnimationModeLegacySwordBlockModePush() {
        super("Push");
    }

    @Override
    public void apply(@NotNull AbstractClientPlayer player, float partialTicks) {
        float f2;
        int n2;
        Intrinsics.checkNotNullParameter(player, "player");
        int side = n2 = AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getGLRotationBaseBySide(player);
        boolean bl2 = false;
        GlStateManager.func_179114_b((float)-102.25f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)side * 13.365f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)side * 78.05f), (float)0.0f, (float)0.0f, (float)1.0f);
        float swingProgress = f2 = AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getCurrentSwingProgress(player, partialTicks);
        boolean bl3 = false;
        double f3 = Math.sin((double)(swingProgress * swingProgress) * Math.PI);
        double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
        GlStateManager.func_179114_b((float)((float)(f3 * (double)(-((Number)this.rotateValue.get()).floatValue()))), (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179114_b((float)((float)(f1 * (double)(-((Number)this.rotateValue.get()).floatValue()))), (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179114_b((float)((float)(f1 * (double)(-((Number)this.rotateValue.get()).floatValue()))), (float)1.0f, (float)1.0f, (float)1.0f);
    }
}

