/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;

public class TextColorUtils {
    public static TextComponent gradient(String s2, TextFormatting ... colors) {
        if (colors.length == 0) {
            return new StringComponent(s2);
        }
        if (colors.length == 1) {
            return new StringComponent(s2).setStyle(new Style().setFormatting(colors[0]));
        }
        StringComponent out = new StringComponent("");
        float[] fractions = new float[colors.length];
        for (int i2 = 0; i2 < colors.length; ++i2) {
            fractions[i2] = (float)i2 / (float)(colors.length - 1);
        }
        char[] chars = s2.toCharArray();
        for (int i3 = 0; i3 < chars.length; ++i3) {
            float progress = (float)i3 / (float)(chars.length - 1);
            int fromI = 0;
            int toI = 0;
            for (int j2 = 0; j2 < colors.length - 1; ++j2) {
                if (!(progress >= fractions[j2]) || !(progress <= fractions[j2 + 1])) continue;
                fromI = j2;
                toI = j2 + 1;
                break;
            }
            float ratio = (progress - fractions[fromI]) / (fractions[toI] - fractions[fromI]);
            int rgb = TextColorUtils.interpolate(colors[fromI], colors[toI], ratio);
            out.append(new StringComponent(String.valueOf(chars[i3])).setStyle(new Style().setColor(rgb)));
        }
        return out;
    }

    public static TextComponent rainbow(String s2) {
        return TextColorUtils.gradient(s2, new TextFormatting(0xFF0000), new TextFormatting(0xFFFF00), new TextFormatting(65280), new TextFormatting(65535), new TextFormatting(255), new TextFormatting(0xFF00FF), new TextFormatting(0xFF0000));
    }

    private static int interpolate(TextFormatting from, TextFormatting to, float ratio) {
        int ar2 = from.getRgbValue() >> 16 & 0xFF;
        int ag2 = from.getRgbValue() >> 8 & 0xFF;
        int ab2 = from.getRgbValue() & 0xFF;
        int br2 = to.getRgbValue() >> 16 & 0xFF;
        int bg2 = to.getRgbValue() >> 8 & 0xFF;
        int bb2 = to.getRgbValue() & 0xFF;
        int r2 = (int)((float)ar2 + (float)(br2 - ar2) * ratio);
        int g2 = (int)((float)ag2 + (float)(bg2 - ag2) * ratio);
        int b2 = (int)((float)ab2 + (float)(bb2 - ab2) * ratio);
        return r2 << 16 | g2 << 8 | b2;
    }
}

