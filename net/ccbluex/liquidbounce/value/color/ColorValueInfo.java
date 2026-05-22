/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u0001/B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rB+\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0004\b\f\u0010\u0014J\u0006\u0010%\u001a\u00020\u0000J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\bH\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003JA\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\bH\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e\u00a8\u00060"}, d2={"Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "", "mode", "", "colors", "", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo$ColorValueInfoColor;", "alpha", "", "noOffset", "", "speed", "<init>", "(Ljava/lang/String;Ljava/util/List;IZI)V", "red", "green", "blue", "(IIII)V", "color", "Ljava/awt/Color;", "(Ljava/awt/Color;)V", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "getColors", "()Ljava/util/List;", "getAlpha", "()I", "setAlpha", "(I)V", "getNoOffset", "()Z", "setNoOffset", "(Z)V", "getSpeed", "setSpeed", "copy", "component1", "component2", "component3", "component4", "component5", "equals", "other", "hashCode", "toString", "ColorValueInfoColor", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nColorValueInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorValueInfo.kt\nnet/ccbluex/liquidbounce/value/color/ColorValueInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n1563#2:54\n1634#2,3:55\n*S KotlinDebug\n*F\n+ 1 ColorValueInfo.kt\nnet/ccbluex/liquidbounce/value/color/ColorValueInfo\n*L\n48#1:54\n48#1:55,3\n*E\n"})
public final class ColorValueInfo {
    @NotNull
    private String mode;
    @NotNull
    private final List<ColorValueInfoColor> colors;
    private int alpha;
    private boolean noOffset;
    private int speed;

    public ColorValueInfo(@NotNull String mode, @NotNull List<ColorValueInfoColor> colors, int alpha, boolean noOffset, int speed) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.mode = mode;
        this.colors = colors;
        this.alpha = alpha;
        this.noOffset = noOffset;
        this.speed = speed;
    }

    public /* synthetic */ ColorValueInfo(String string, List list, int n2, boolean bl2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 1) != 0) {
            string = "Custom";
        }
        if ((n4 & 2) != 0) {
            ColorValueInfoColor[] colorValueInfoColorArray = new ColorValueInfoColor[]{new ColorValueInfoColor(0, 0, 0, 7, null)};
            list = CollectionsKt.mutableListOf(colorValueInfoColorArray);
        }
        if ((n4 & 4) != 0) {
            n2 = 255;
        }
        if ((n4 & 8) != 0) {
            bl2 = false;
        }
        if ((n4 & 0x10) != 0) {
            n3 = 1000;
        }
        this(string, list, n2, bl2, n3);
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    public final void setMode(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.mode = string;
    }

    @NotNull
    public final List<ColorValueInfoColor> getColors() {
        return this.colors;
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(int n2) {
        this.alpha = n2;
    }

    public final boolean getNoOffset() {
        return this.noOffset;
    }

    public final void setNoOffset(boolean bl2) {
        this.noOffset = bl2;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final void setSpeed(int n2) {
        this.speed = n2;
    }

    public ColorValueInfo(int red, int green, int blue, int alpha) {
        ColorValueInfoColor[] colorValueInfoColorArray = new ColorValueInfoColor[]{new ColorValueInfoColor(red, green, blue)};
        this("Custom", CollectionsKt.mutableListOf(colorValueInfoColorArray), alpha, false, 0, 24, null);
    }

    public /* synthetic */ ColorValueInfo(int n2, int n3, int n4, int n5, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 8) != 0) {
            n5 = 255;
        }
        this(n2, n3, n4, n5);
    }

    public ColorValueInfo(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ColorValueInfo copy() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = this.colors;
        String string = this.mode;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ColorValueInfoColor colorValueInfoColor = (ColorValueInfoColor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.copy());
        }
        int n2 = this.speed;
        boolean bl3 = this.noOffset;
        int n3 = this.alpha;
        List<ColorValueInfoColor> list = CollectionsKt.toMutableList((List)destination$iv$iv);
        String string2 = string;
        return new ColorValueInfo(string2, list, n3, bl3, n2);
    }

    @NotNull
    public final String component1() {
        return this.mode;
    }

    @NotNull
    public final List<ColorValueInfoColor> component2() {
        return this.colors;
    }

    public final int component3() {
        return this.alpha;
    }

    public final boolean component4() {
        return this.noOffset;
    }

    public final int component5() {
        return this.speed;
    }

    @NotNull
    public final ColorValueInfo copy(@NotNull String mode, @NotNull List<ColorValueInfoColor> colors, int alpha, boolean noOffset, int speed) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new ColorValueInfo(mode, colors, alpha, noOffset, speed);
    }

    public static /* synthetic */ ColorValueInfo copy$default(ColorValueInfo colorValueInfo, String string, List list, int n2, boolean bl2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            string = colorValueInfo.mode;
        }
        if ((n4 & 2) != 0) {
            list = colorValueInfo.colors;
        }
        if ((n4 & 4) != 0) {
            n2 = colorValueInfo.alpha;
        }
        if ((n4 & 8) != 0) {
            bl2 = colorValueInfo.noOffset;
        }
        if ((n4 & 0x10) != 0) {
            n3 = colorValueInfo.speed;
        }
        return colorValueInfo.copy(string, list, n2, bl2, n3);
    }

    @NotNull
    public String toString() {
        return "ColorValueInfo(mode=" + this.mode + ", colors=" + this.colors + ", alpha=" + this.alpha + ", noOffset=" + this.noOffset + ", speed=" + this.speed + ')';
    }

    public int hashCode() {
        int result = this.mode.hashCode();
        result = result * 31 + ((Object)this.colors).hashCode();
        result = result * 31 + Integer.hashCode(this.alpha);
        result = result * 31 + Boolean.hashCode(this.noOffset);
        result = result * 31 + Integer.hashCode(this.speed);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorValueInfo)) {
            return false;
        }
        ColorValueInfo colorValueInfo = (ColorValueInfo)other;
        if (!Intrinsics.areEqual(this.mode, colorValueInfo.mode)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colors, colorValueInfo.colors)) {
            return false;
        }
        if (this.alpha != colorValueInfo.alpha) {
            return false;
        }
        if (this.noOffset != colorValueInfo.noOffset) {
            return false;
        }
        return this.speed == colorValueInfo.speed;
    }

    public ColorValueInfo() {
        this(null, null, 0, false, 0, 31, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0000J\u0006\u0010\u0016\u001a\u00020\tJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo$ColorValueInfoColor;", "", "red", "", "green", "blue", "<init>", "(III)V", "color", "Ljava/awt/Color;", "(Ljava/awt/Color;)V", "getRed", "()I", "setRed", "(I)V", "getGreen", "setGreen", "getBlue", "setBlue", "fixColorRGB", "", "copy", "toColor", "component1", "component2", "component3", "equals", "", "other", "hashCode", "toString", "", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nColorValueInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorValueInfo.kt\nnet/ccbluex/liquidbounce/value/color/ColorValueInfo$ColorValueInfoColor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
    public static final class ColorValueInfoColor {
        private int red;
        private int green;
        private int blue;

        public ColorValueInfoColor(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.fixColorRGB();
        }

        public /* synthetic */ ColorValueInfoColor(int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n5 & 1) != 0) {
                n2 = 255;
            }
            if ((n5 & 2) != 0) {
                n3 = 255;
            }
            if ((n5 & 4) != 0) {
                n4 = 255;
            }
            this(n2, n3, n4);
        }

        public final int getRed() {
            return this.red;
        }

        public final void setRed(int n2) {
            this.red = n2;
        }

        public final int getGreen() {
            return this.green;
        }

        public final void setGreen(int n2) {
            this.green = n2;
        }

        public final int getBlue() {
            return this.blue;
        }

        public final void setBlue(int n2) {
            this.blue = n2;
        }

        public ColorValueInfoColor(@NotNull Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            this(color.getRed(), color.getGreen(), color.getBlue());
        }

        private final void fixColorRGB() {
            this.red = RangesKt.coerceIn(this.red, new IntRange(0, 255));
            this.green = RangesKt.coerceIn(this.green, new IntRange(0, 255));
            this.blue = RangesKt.coerceIn(this.blue, new IntRange(0, 255));
        }

        @NotNull
        public final ColorValueInfoColor copy() {
            this.fixColorRGB();
            Unit it = Unit.INSTANCE;
            boolean bl2 = false;
            return new ColorValueInfoColor(this.red, this.green, this.blue);
        }

        @NotNull
        public final Color toColor() {
            this.fixColorRGB();
            Unit it = Unit.INSTANCE;
            boolean bl2 = false;
            return new Color(this.red, this.green, this.blue);
        }

        public final int component1() {
            return this.red;
        }

        public final int component2() {
            return this.green;
        }

        public final int component3() {
            return this.blue;
        }

        @NotNull
        public final ColorValueInfoColor copy(int red, int green, int blue) {
            return new ColorValueInfoColor(red, green, blue);
        }

        public static /* synthetic */ ColorValueInfoColor copy$default(ColorValueInfoColor colorValueInfoColor, int n2, int n3, int n4, int n5, Object object) {
            if ((n5 & 1) != 0) {
                n2 = colorValueInfoColor.red;
            }
            if ((n5 & 2) != 0) {
                n3 = colorValueInfoColor.green;
            }
            if ((n5 & 4) != 0) {
                n4 = colorValueInfoColor.blue;
            }
            return colorValueInfoColor.copy(n2, n3, n4);
        }

        @NotNull
        public String toString() {
            return "ColorValueInfoColor(red=" + this.red + ", green=" + this.green + ", blue=" + this.blue + ')';
        }

        public int hashCode() {
            int result = Integer.hashCode(this.red);
            result = result * 31 + Integer.hashCode(this.green);
            result = result * 31 + Integer.hashCode(this.blue);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorValueInfoColor)) {
                return false;
            }
            ColorValueInfoColor colorValueInfoColor = (ColorValueInfoColor)other;
            if (this.red != colorValueInfoColor.red) {
                return false;
            }
            if (this.green != colorValueInfoColor.green) {
                return false;
            }
            return this.blue == colorValueInfoColor.blue;
        }

        public ColorValueInfoColor() {
            this(0, 0, 0, 7, null);
        }
    }
}

