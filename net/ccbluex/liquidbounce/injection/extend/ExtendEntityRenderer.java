/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.render.AccessorEntityRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendEntityRenderer;", "", "<init>", "()V", "getFOVModifier", "", "Lnet/minecraft/client/renderer/EntityRenderer;", "partialTicks", "useFOVSetting", "", "DarkMeow"})
public final class ExtendEntityRenderer {
    @NotNull
    public static final ExtendEntityRenderer INSTANCE = new ExtendEntityRenderer();

    private ExtendEntityRenderer() {
    }

    public final float getFOVModifier(@NotNull EntityRenderer $this$getFOVModifier, float partialTicks, boolean useFOVSetting) {
        Intrinsics.checkNotNullParameter($this$getFOVModifier, "<this>");
        return ((AccessorEntityRenderer)$this$getFOVModifier).darkMeow_getFOVModifier(partialTicks, useFOVSetting);
    }
}

