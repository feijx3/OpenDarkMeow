/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.render;

import java.awt.Color;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b&\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0007J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0007J\"\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0007J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u000fJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010)\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010*\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J \u0010+\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000fH\u0007J\u0014\u0010.\u001a\u0004\u0018\u00010\u001c2\b\u0010/\u001a\u0004\u0018\u00010\u001cH\u0007J6\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u0012J \u00107\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0012H\u0007J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001cH\u0007J\u000e\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\rH\u0007J\u0016\u0010>\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010=\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010=\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0010\u0010=\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0018\u0010=\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0010\u0010@\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010A\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0007J*\u0010B\u001a\u0004\u0018\u00010\r2\u0006\u0010C\u001a\u00020'2\u0006\u00108\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0007J\u0018\u0010=\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0018\u0010F\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J \u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0007J\u001e\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2={"Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;", "", "<init>", "()V", "allowedCharactersArray", "", "getAllowedCharactersArray", "()[C", "isAllowedCharacter", "", "character", "", "hsbTransition", "Ljava/awt/Color;", "from", "", "to", "angle", "", "s", "b", "rainbowWithAlpha", "alpha", "COLOR_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "colorCode", "code", "", "hexColors", "", "healthColor", "hp", "maxHP", "darker", "color", "percentage", "rainbowW", "offset", "", "redRainbow", "greenRainbow", "blueRainbow", "rainbow3", "rainbowSpeed", "rainbowBright", "stripColor", "input", "startTime", "hslRainbow", "index", "lowest", "bigest", "indexOffset", "timeSplit", "fade", "count", "translateAlternateColorCodes", "textToTranslate", "randomMagicText", "text", "rainbow", "reAlpha", "rainbow2", "ALLColor", "originalrainbow", "LiquidSlowly", "time", "qd", "sq", "TwoRainbow", "astolfoRainbow", "delay", "getColor", "hueoffset", "saturation", "brightness", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nColorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorUtils.kt\nnet/ccbluex/liquidbounce/utils/render/ColorUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
public final class ColorUtils {
    @NotNull
    public static final ColorUtils INSTANCE = new ColorUtils();
    @NotNull
    private static final char[] allowedCharactersArray;
    private static final Pattern COLOR_PATTERN;
    @JvmField
    @NotNull
    public static final int[] hexColors;
    private static final long startTime;

    private ColorUtils() {
    }

    @NotNull
    public final char[] getAllowedCharactersArray() {
        return allowedCharactersArray;
    }

    public final boolean isAllowedCharacter(char character) {
        return character != '\u00a7' && character >= ' ' && character != '\u007f';
    }

    @NotNull
    public final Color hsbTransition(float from, float to, int angle, float s2, float b2) {
        Color color = Color.getHSBColor(angle < 180 ? from + (to - from) * ((float)angle / 180.0f) : from + (to - from) * ((float)(-(angle - 360)) / 180.0f), s2, b2);
        Intrinsics.checkNotNullExpressionValue(color, "getHSBColor(...)");
        return color;
    }

    public static /* synthetic */ Color hsbTransition$default(ColorUtils colorUtils, float f2, float f3, int n2, float f4, float f5, int n3, Object object) {
        if ((n3 & 8) != 0) {
            f4 = 1.0f;
        }
        if ((n3 & 0x10) != 0) {
            f5 = 1.0f;
        }
        return colorUtils.hsbTransition(f2, f3, n2, f4, f5);
    }

    @NotNull
    public final Color rainbowWithAlpha(int alpha) {
        return this.reAlpha(ColorUtils.hslRainbow$default(this, 1, 0.0f, 0.0f, 0, 0, 30, null), alpha);
    }

    @JvmStatic
    @NotNull
    public static final Color colorCode(@NotNull String code, int alpha) {
        Color color;
        Intrinsics.checkNotNullParameter(code, "code");
        String string = code.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        switch (string) {
            case "0": {
                color = new Color(0, 0, 0, alpha);
                break;
            }
            case "1": {
                color = new Color(0, 0, 170, alpha);
                break;
            }
            case "2": {
                color = new Color(0, 170, 0, alpha);
                break;
            }
            case "3": {
                color = new Color(0, 170, 170, alpha);
                break;
            }
            case "4": {
                color = new Color(170, 0, 0, alpha);
                break;
            }
            case "5": {
                color = new Color(170, 0, 170, alpha);
                break;
            }
            case "6": {
                color = new Color(255, 170, 0, alpha);
                break;
            }
            case "7": {
                color = new Color(170, 170, 170, alpha);
                break;
            }
            case "8": {
                color = new Color(85, 85, 85, alpha);
                break;
            }
            case "9": {
                color = new Color(85, 85, 255, alpha);
                break;
            }
            case "a": {
                color = new Color(85, 255, 85, alpha);
                break;
            }
            case "b": {
                color = new Color(85, 255, 255, alpha);
                break;
            }
            case "c": {
                color = new Color(255, 85, 85, alpha);
                break;
            }
            case "d": {
                color = new Color(255, 85, 255, alpha);
                break;
            }
            case "e": {
                color = new Color(255, 255, 85, alpha);
                break;
            }
            default: {
                color = new Color(255, 255, 255, alpha);
            }
        }
        return color;
    }

    public static /* synthetic */ Color colorCode$default(String string, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 255;
        }
        return ColorUtils.colorCode(string, n2);
    }

    @JvmStatic
    @NotNull
    public static final Color colorCode(int code, int alpha) {
        Color color;
        switch (code) {
            case 0: {
                color = new Color(0, 0, 0, alpha);
                break;
            }
            case 1: {
                color = new Color(0, 0, 170, alpha);
                break;
            }
            case 2: {
                color = new Color(0, 170, 0, alpha);
                break;
            }
            case 3: {
                color = new Color(0, 170, 170, alpha);
                break;
            }
            case 4: {
                color = new Color(170, 0, 0, alpha);
                break;
            }
            case 5: {
                color = new Color(170, 0, 170, alpha);
                break;
            }
            case 6: {
                color = new Color(255, 170, 0, alpha);
                break;
            }
            case 7: {
                color = new Color(170, 170, 170, alpha);
                break;
            }
            case 8: {
                color = new Color(85, 85, 85, alpha);
                break;
            }
            case 9: {
                color = new Color(85, 85, 255, alpha);
                break;
            }
            case 10: {
                color = new Color(85, 255, 85, alpha);
                break;
            }
            case 11: {
                color = new Color(85, 255, 255, alpha);
                break;
            }
            case 12: {
                color = new Color(255, 85, 85, alpha);
                break;
            }
            case 13: {
                color = new Color(255, 85, 255, alpha);
                break;
            }
            case 14: {
                color = new Color(255, 255, 85, alpha);
                break;
            }
            default: {
                color = new Color(255, 255, 255, alpha);
            }
        }
        return color;
    }

    public static /* synthetic */ Color colorCode$default(int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = 255;
        }
        return ColorUtils.colorCode(n2, n3);
    }

    @JvmStatic
    @NotNull
    public static final Color healthColor(float hp, float maxHP, int alpha) {
        int pct = (int)(hp / maxHP * 255.0f);
        return new Color(Math.max(Math.min(255 - pct, 255), 0), Math.max(Math.min(pct, 255), 0), 0, alpha);
    }

    public static /* synthetic */ Color healthColor$default(float f2, float f3, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = 255;
        }
        return ColorUtils.healthColor(f2, f3, n2);
    }

    @NotNull
    public final Color darker(@NotNull Color color, float percentage) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new Color((int)((float)color.getRed() * percentage), (int)((float)color.getGreen() * percentage), (int)((float)color.getBlue() * percentage), (int)((float)color.getAlpha() * percentage));
    }

    @JvmStatic
    @NotNull
    public static final Color rainbowW(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 0.6f, 1.0f));
        return new Color(0.0f, (float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color redRainbow(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 0.5f, 1.0f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, 0.0f, 0.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color greenRainbow(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 0.5f, 1.0f));
        return new Color(0.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, 0.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color blueRainbow(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 0.5f, 1.0f));
        return new Color(0.0f, 0.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow3(long offset, float rainbowSpeed, float rainbowBright) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, rainbowSpeed, rainbowBright));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @Nullable
    public static final String stripColor(@Nullable String input) {
        String string = input;
        if (string == null) {
            return null;
        }
        return COLOR_PATTERN.matcher(string).replaceAll("");
    }

    @NotNull
    public final Color hslRainbow(int index, float lowest, float bigest, int indexOffset, int timeSplit) {
        Color color = Color.getHSBColor(Math.abs((float)((int)(System.currentTimeMillis() - startTime) + index * indexOffset) / (float)timeSplit % (float)2 - 1.0f) * (bigest - lowest) + lowest, 0.7f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(color, "getHSBColor(...)");
        return color;
    }

    public static /* synthetic */ Color hslRainbow$default(ColorUtils colorUtils, int n2, float f2, float f3, int n3, int n4, int n5, Object object) {
        if ((n5 & 2) != 0) {
            f2 = 0.41f;
        }
        if ((n5 & 4) != 0) {
            f3 = 0.58f;
        }
        if ((n5 & 8) != 0) {
            n3 = 300;
        }
        if ((n5 & 0x10) != 0) {
            n4 = 1500;
        }
        return colorUtils.hslRainbow(n2, f2, f3, n3, n4);
    }

    @JvmStatic
    @NotNull
    public static final Color fade(@NotNull Color color, int index, int count) {
        Intrinsics.checkNotNullParameter(color, "color");
        float[] hsb = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
        float brightness = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0f + (float)index / (float)count * 2.0f) % 2.0f - 1.0f);
        brightness = 0.5f + 0.5f * brightness;
        hsb[2] = brightness % 2.0f;
        return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
    }

    @JvmStatic
    @NotNull
    public static final String translateAlternateColorCodes(@NotNull String textToTranslate) {
        Intrinsics.checkNotNullParameter(textToTranslate, "textToTranslate");
        char[] cArray = textToTranslate.toCharArray();
        Intrinsics.checkNotNullExpressionValue(cArray, "toCharArray(...)");
        char[] chars = cArray;
        int n2 = chars.length - 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (chars[i2] != '&' || !StringsKt.contains((CharSequence)"0123456789AaBbCcDdEeFfKkLlMmNnOoRr", chars[i2 + 1], true)) continue;
            chars[i2] = 167;
            chars[i2 + 1] = Character.toLowerCase(chars[i2 + 1]);
        }
        return new String(chars);
    }

    @NotNull
    public final String randomMagicText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        StringBuilder stringBuilder = new StringBuilder();
        String allowedCharacters = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000";
        char[] cArray = text.toCharArray();
        Intrinsics.checkNotNullExpressionValue(cArray, "toCharArray(...)");
        for (char c2 : cArray) {
            if (!this.isAllowedCharacter(c2)) continue;
            int index = new Random().nextInt(allowedCharacters.length());
            char[] cArray2 = allowedCharacters.toCharArray();
            Intrinsics.checkNotNullExpressionValue(cArray2, "toCharArray(...)");
            stringBuilder.append(cArray2[index]);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow() {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + 400000L) / 1.0E10f % 1.0f, 1.0f, 1.0f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @NotNull
    public final Color reAlpha(@NotNull Color color, int alpha) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 1.0f, 1.0f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow(float alpha) {
        return ColorUtils.rainbow(400000L, alpha);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow(int alpha) {
        return ColorUtils.rainbow(400000L, alpha / 255);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow2(int alpha) {
        return ColorUtils.rainbow(400000L, alpha);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow(long offset, int alpha) {
        return ColorUtils.rainbow(offset, (float)alpha / (float)255);
    }

    @JvmStatic
    @NotNull
    public static final Color ALLColor(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)((double)Minecraft.func_71410_x().field_71439_g.field_70173_aa / 50.0 + Math.sin(1.6) % 1.0), 0.4f, 0.9f));
        return new Color(currentColor.getRGB());
    }

    @JvmStatic
    @NotNull
    public static final Color originalrainbow(long offset) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 1.0f, 1.0f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, (float)currentColor.getAlpha() / 255.0f);
    }

    @JvmStatic
    @Nullable
    public static final Color LiquidSlowly(long time, int count, float qd, float sq) {
        Color color = new Color(Color.HSBtoRGB(((float)time + (float)count * -3000000.0f) / (float)2 / 1.0E9f, qd, sq));
        return new Color((float)color.getRed() / 255.0f * 1.0f, (float)color.getGreen() / 255.0f * 1.0f, (float)color.getBlue() / 255.0f * 1.0f, (float)color.getAlpha() / 255.0f);
    }

    @JvmStatic
    @NotNull
    public static final Color rainbow(long offset, float alpha) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 1.0E10f % 1.0f, 1.0f, 1.0f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, alpha);
    }

    @JvmStatic
    @NotNull
    public static final Color TwoRainbow(long offset, float alpha) {
        Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 8.9999999E10f % 1.0f, 0.75f, 0.8f));
        return new Color((float)currentColor.getRed() / 255.0f * 1.0f, (float)currentColor.getGreen() / 255.0f * 1.0f, (float)currentColor.getBlue() / 255.0f * 1.0f, alpha);
    }

    @JvmStatic
    public static final int astolfoRainbow(int delay, int offset, int index) {
        double d2;
        double rainbowDelay = 0.0;
        rainbowDelay = Math.ceil(System.currentTimeMillis() + (long)(delay * index)) / (double)offset;
        double it = d2 = 360.0;
        boolean bl2 = false;
        return Color.getHSBColor((double)((float)(d2 / 360.0)) < 0.5 ? -((float)(rainbowDelay / 360.0)) : (float)((rainbowDelay %= it) / 360.0), 0.5f, 1.0f).getRGB();
    }

    public final int getColor(float hueoffset, float saturation, float brightness) {
        float speed = 4500.0f;
        float hue = (float)(System.currentTimeMillis() % (long)((int)speed)) / speed;
        return Color.HSBtoRGB(hue - hueoffset / (float)54, saturation, brightness);
    }

    static {
        char[] cArray = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};
        allowedCharactersArray = cArray;
        COLOR_PATTERN = Pattern.compile("(?i)\u00a7[0-9A-FK-OR]");
        hexColors = new int[16];
        int n2 = 16;
        for (int i2 = 0; i2 < n2; ++i2) {
            int i3 = i2;
            boolean bl2 = false;
            int baseColor = (i3 >> 3 & 1) * 85;
            int red = (i3 >> 2 & 1) * 170 + baseColor + (i3 == 6 ? 85 : 0);
            int green = (i3 >> 1 & 1) * 170 + baseColor;
            int blue = (i3 & 1) * 170 + baseColor;
            ColorUtils.hexColors[i3] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
        }
        startTime = System.currentTimeMillis();
    }
}

