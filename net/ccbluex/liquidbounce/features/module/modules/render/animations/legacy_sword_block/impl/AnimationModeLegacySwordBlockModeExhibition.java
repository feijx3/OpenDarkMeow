/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockMode;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockPrevSwingExtend;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/impl/AnimationModeLegacySwordBlockModeExhibition;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockMode;", "<init>", "()V", "transformFirstPersonItem", "", "equipProgress", "", "swingProgress", "apply", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "partialTicks", "DarkMeow"})
public final class AnimationModeLegacySwordBlockModeExhibition
extends AnimationModeLegacySwordBlockMode {
    public AnimationModeLegacySwordBlockModeExhibition() {
        super("Exhibition");
    }

    private final void transformFirstPersonItem(float equipProgress, float swingProgress) {
        GlStateManager.func_179109_b((float)0.56f, (float)-0.52f, (float)-0.71999997f);
        GlStateManager.func_179109_b((float)0.0f, (float)(equipProgress * -0.6f), (float)0.0f);
        GlStateManager.func_179114_b((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        float f2 = MathHelper.func_76126_a((float)(swingProgress * swingProgress * (float)Math.PI));
        float f1 = MathHelper.func_76126_a((float)(MathHelper.func_76129_c((float)swingProgress) * (float)Math.PI));
        GlStateManager.func_179114_b((float)(f2 * -20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(f1 * -20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.func_179114_b((float)(f1 * -80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
    }

    @Override
    public void apply(@NotNull AbstractClientPlayer player, float partialTicks) {
        Intrinsics.checkNotNullParameter(player, "player");
        float swingProgress = AnimationModeLegacySwordBlockPrevSwingExtend.INSTANCE.getCurrentSwingProgress(player, partialTicks);
        float easedSwing = swingProgress * 0.8f - swingProgress * swingProgress * 0.8f;
        float f5 = (float)Math.sin(Math.sqrt(swingProgress) * 3.1);
        GlStateManager.func_179137_b((double)0.0, (double)0.0, (double)easedSwing);
        this.transformFirstPersonItem(-0.1f, 1.0f);
        GlStateManager.func_179114_b((float)(-f5 * 25.0f), (float)(f5 / 2.0f), (float)0.0f, (float)4.0f);
        GlStateManager.func_179114_b((float)(-f5 * 30.0f), (float)1.0f, (float)(f5 / 2.0f), (float)0.0f);
        GlStateManager.func_179109_b((float)-0.5f, (float)0.2f, (float)0.0f);
        GlStateManager.func_179114_b((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
    }
}

