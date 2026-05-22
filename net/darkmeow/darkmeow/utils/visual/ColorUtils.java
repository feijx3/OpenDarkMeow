/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.visual;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\n\u0010\f\u001a\u00020\r*\u00020\u0005J\u0014\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/ColorUtils;", "", "<init>", "()V", "getGradientOffset", "Ljava/awt/Color;", "color1", "color2", "speed", "", "offset", "", "setGlColor", "", "darker", "factor", "withAlpha", "alpha", "DarkMeow"})
public final class ColorUtils {
    @NotNull
    public static final ColorUtils INSTANCE = new ColorUtils();

    private ColorUtils() {
    }

    @NotNull
    public final Color getGradientOffset(@NotNull Color color1, @NotNull Color color2, int speed, double offset) {
        Intrinsics.checkNotNullParameter(color1, "color1");
        Intrinsics.checkNotNullParameter(color2, "color2");
        double offs = Math.abs((double)System.currentTimeMillis() / 16.0 + offset) / (double)speed;
        if (offs > 1.0) {
            double left = offs % 1.0;
            int off = (int)offs;
            offs = off % 2 == 0 ? left : 1.0 - left;
        }
        double inversePercent = 1.0 - offs;
        int redPart = (int)((double)color1.getRed() * inversePercent + (double)color2.getRed() * offs);
        int greenPart = (int)((double)color1.getGreen() * inversePercent + (double)color2.getGreen() * offs);
        int bluePart = (int)((double)color1.getBlue() * inversePercent + (double)color2.getBlue() * offs);
        return new Color(redPart, greenPart, bluePart);
    }

    public final void setGlColor(@NotNull Color $this$setGlColor) {
        Intrinsics.checkNotNullParameter($this$setGlColor, "<this>");
        GlStateManager.func_179131_c((float)((float)$this$setGlColor.getRed() / 255.0f), (float)((float)$this$setGlColor.getGreen() / 255.0f), (float)((float)$this$setGlColor.getBlue() / 255.0f), (float)((float)$this$setGlColor.getAlpha() / 255.0f));
    }

    @NotNull
    public final Color darker(@NotNull Color $this$darker, double factor) {
        Intrinsics.checkNotNullParameter($this$darker, "<this>");
        return new Color(Math.max((int)((double)$this$darker.getRed() * factor), 0), Math.max((int)((double)$this$darker.getGreen() * factor), 0), Math.max((int)((double)$this$darker.getBlue() * factor), 0), $this$darker.getAlpha());
    }

    public static /* synthetic */ Color darker$default(ColorUtils colorUtils, Color color, double d2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = 0.7;
        }
        return colorUtils.darker(color, d2);
    }

    @NotNull
    public final Color withAlpha(@NotNull Color $this$withAlpha, int alpha) {
        Intrinsics.checkNotNullParameter($this$withAlpha, "<this>");
        return new Color($this$withAlpha.getRed(), $this$withAlpha.getGreen(), $this$withAlpha.getBlue(), alpha);
    }
}

