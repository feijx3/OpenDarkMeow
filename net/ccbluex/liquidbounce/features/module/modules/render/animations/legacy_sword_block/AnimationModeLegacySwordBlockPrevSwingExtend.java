/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.util.EnumHandSide
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.EnumHandSide;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockPrevSwingExtend;", "", "<init>", "()V", "getGLRotationBaseBySide", "", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "getCurrentSwingProgress", "", "partialTicks", "DarkMeow"})
public final class AnimationModeLegacySwordBlockPrevSwingExtend {
    @NotNull
    public static final AnimationModeLegacySwordBlockPrevSwingExtend INSTANCE = new AnimationModeLegacySwordBlockPrevSwingExtend();

    private AnimationModeLegacySwordBlockPrevSwingExtend() {
    }

    public final int getGLRotationBaseBySide(@NotNull AbstractClientPlayer $this$getGLRotationBaseBySide) {
        Intrinsics.checkNotNullParameter($this$getGLRotationBaseBySide, "<this>");
        return $this$getGLRotationBaseBySide.func_184591_cq() == EnumHandSide.RIGHT ? 1 : -1;
    }

    public final float getCurrentSwingProgress(@NotNull AbstractClientPlayer $this$getCurrentSwingProgress, float partialTicks) {
        Intrinsics.checkNotNullParameter($this$getCurrentSwingProgress, "<this>");
        return $this$getCurrentSwingProgress.field_70732_aI + ($this$getCurrentSwingProgress.field_70733_aJ - $this$getCurrentSwingProgress.field_70732_aI) * partialTicks;
    }
}

