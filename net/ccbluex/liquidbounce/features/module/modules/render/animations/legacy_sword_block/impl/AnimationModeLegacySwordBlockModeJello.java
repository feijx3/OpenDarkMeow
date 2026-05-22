/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockMode;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockPrevSwingExtend;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/impl/AnimationModeLegacySwordBlockModeJello;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockMode;", "<init>", "()V", "apply", "", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "partialTicks", "", "DarkMeow"})
public final class AnimationModeLegacySwordBlockModeJello
extends AnimationModeLegacySwordBlockMode {
    public AnimationModeLegacySwordBlockModeJello() {
        super("Jello");
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
        GlStateManager.func_179114_b((float)((float)Math.sin(Math.sqrt(swingProgress) * Math.PI) * 20.0f), (float)1.0f, (float)1.0f, (float)1.0f);
    }
}

