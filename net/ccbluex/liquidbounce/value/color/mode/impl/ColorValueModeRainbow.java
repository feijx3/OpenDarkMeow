/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.color.mode.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueMode;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueModeSelectCount;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/value/color/mode/impl/ColorValueModeRainbow;", "Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueMode;", "<init>", "()V", "getColor", "Ljava/awt/Color;", "value", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "offset", "", "DarkMeow"})
public final class ColorValueModeRainbow
extends ColorValueMode {
    public ColorValueModeRainbow() {
        super("Rainbow", ColorValueModeSelectCount.NONE, 2, false, false, 24, null);
    }

    @Override
    @NotNull
    public Color getColor(@NotNull ColorValueInfo value, int offset) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ColorUtils.rainbow2(value.getAlpha());
    }
}

