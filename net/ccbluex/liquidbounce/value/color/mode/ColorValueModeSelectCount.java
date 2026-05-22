/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.color.mode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueModeSelectCount;", "", "colorCount", "", "<init>", "(Ljava/lang/String;II)V", "getColorCount", "()I", "NONE", "SINGLE", "DOUBLE", "DarkMeow"})
public final class ColorValueModeSelectCount
extends Enum<ColorValueModeSelectCount> {
    private final int colorCount;
    public static final /* enum */ ColorValueModeSelectCount NONE = new ColorValueModeSelectCount(0);
    public static final /* enum */ ColorValueModeSelectCount SINGLE = new ColorValueModeSelectCount(1);
    public static final /* enum */ ColorValueModeSelectCount DOUBLE = new ColorValueModeSelectCount(2);
    private static final /* synthetic */ ColorValueModeSelectCount[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ColorValueModeSelectCount(int colorCount) {
        this.colorCount = colorCount;
    }

    public final int getColorCount() {
        return this.colorCount;
    }

    public static ColorValueModeSelectCount[] values() {
        return (ColorValueModeSelectCount[])$VALUES.clone();
    }

    public static ColorValueModeSelectCount valueOf(String value) {
        return Enum.valueOf(ColorValueModeSelectCount.class, value);
    }

    @NotNull
    public static EnumEntries<ColorValueModeSelectCount> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = colorValueModeSelectCountArray = new ColorValueModeSelectCount[]{ColorValueModeSelectCount.NONE, ColorValueModeSelectCount.SINGLE, ColorValueModeSelectCount.DOUBLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

