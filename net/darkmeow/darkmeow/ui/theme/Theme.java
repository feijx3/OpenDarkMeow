/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.theme;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\nH\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00064"}, d2={"Lnet/darkmeow/darkmeow/ui/theme/Theme;", "", "colorRectNormal", "Ljava/awt/Color;", "colorRectActive", "colorFont", "colorFontReadOnly", "colorFontTip", "colorBackground", "blurPass", "", "font", "Lnet/minecraft/client/gui/FontRenderer;", "<init>", "(Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;ILnet/minecraft/client/gui/FontRenderer;)V", "getColorRectNormal", "()Ljava/awt/Color;", "setColorRectNormal", "(Ljava/awt/Color;)V", "getColorRectActive", "setColorRectActive", "getColorFont", "setColorFont", "getColorFontReadOnly", "setColorFontReadOnly", "getColorFontTip", "setColorFontTip", "getColorBackground", "setColorBackground", "getBlurPass", "()I", "setBlurPass", "(I)V", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "setFont", "(Lnet/minecraft/client/gui/FontRenderer;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "DarkMeow"})
public final class Theme {
    @NotNull
    private Color colorRectNormal;
    @NotNull
    private Color colorRectActive;
    @NotNull
    private Color colorFont;
    @NotNull
    private Color colorFontReadOnly;
    @NotNull
    private Color colorFontTip;
    @NotNull
    private Color colorBackground;
    private int blurPass;
    @NotNull
    private FontRenderer font;

    public Theme(@NotNull Color colorRectNormal, @NotNull Color colorRectActive, @NotNull Color colorFont, @NotNull Color colorFontReadOnly, @NotNull Color colorFontTip, @NotNull Color colorBackground, int blurPass, @NotNull FontRenderer font) {
        Intrinsics.checkNotNullParameter(colorRectNormal, "colorRectNormal");
        Intrinsics.checkNotNullParameter(colorRectActive, "colorRectActive");
        Intrinsics.checkNotNullParameter(colorFont, "colorFont");
        Intrinsics.checkNotNullParameter(colorFontReadOnly, "colorFontReadOnly");
        Intrinsics.checkNotNullParameter(colorFontTip, "colorFontTip");
        Intrinsics.checkNotNullParameter(colorBackground, "colorBackground");
        Intrinsics.checkNotNullParameter(font, "font");
        this.colorRectNormal = colorRectNormal;
        this.colorRectActive = colorRectActive;
        this.colorFont = colorFont;
        this.colorFontReadOnly = colorFontReadOnly;
        this.colorFontTip = colorFontTip;
        this.colorBackground = colorBackground;
        this.blurPass = blurPass;
        this.font = font;
    }

    @NotNull
    public final Color getColorRectNormal() {
        return this.colorRectNormal;
    }

    public final void setColorRectNormal(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorRectNormal = color;
    }

    @NotNull
    public final Color getColorRectActive() {
        return this.colorRectActive;
    }

    public final void setColorRectActive(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorRectActive = color;
    }

    @NotNull
    public final Color getColorFont() {
        return this.colorFont;
    }

    public final void setColorFont(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorFont = color;
    }

    @NotNull
    public final Color getColorFontReadOnly() {
        return this.colorFontReadOnly;
    }

    public final void setColorFontReadOnly(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorFontReadOnly = color;
    }

    @NotNull
    public final Color getColorFontTip() {
        return this.colorFontTip;
    }

    public final void setColorFontTip(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorFontTip = color;
    }

    @NotNull
    public final Color getColorBackground() {
        return this.colorBackground;
    }

    public final void setColorBackground(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.colorBackground = color;
    }

    public final int getBlurPass() {
        return this.blurPass;
    }

    public final void setBlurPass(int n2) {
        this.blurPass = n2;
    }

    @NotNull
    public final FontRenderer getFont() {
        return this.font;
    }

    public final void setFont(@NotNull FontRenderer fontRenderer) {
        Intrinsics.checkNotNullParameter(fontRenderer, "<set-?>");
        this.font = fontRenderer;
    }

    @NotNull
    public final Color component1() {
        return this.colorRectNormal;
    }

    @NotNull
    public final Color component2() {
        return this.colorRectActive;
    }

    @NotNull
    public final Color component3() {
        return this.colorFont;
    }

    @NotNull
    public final Color component4() {
        return this.colorFontReadOnly;
    }

    @NotNull
    public final Color component5() {
        return this.colorFontTip;
    }

    @NotNull
    public final Color component6() {
        return this.colorBackground;
    }

    public final int component7() {
        return this.blurPass;
    }

    @NotNull
    public final FontRenderer component8() {
        return this.font;
    }

    @NotNull
    public final Theme copy(@NotNull Color colorRectNormal, @NotNull Color colorRectActive, @NotNull Color colorFont, @NotNull Color colorFontReadOnly, @NotNull Color colorFontTip, @NotNull Color colorBackground, int blurPass, @NotNull FontRenderer font) {
        Intrinsics.checkNotNullParameter(colorRectNormal, "colorRectNormal");
        Intrinsics.checkNotNullParameter(colorRectActive, "colorRectActive");
        Intrinsics.checkNotNullParameter(colorFont, "colorFont");
        Intrinsics.checkNotNullParameter(colorFontReadOnly, "colorFontReadOnly");
        Intrinsics.checkNotNullParameter(colorFontTip, "colorFontTip");
        Intrinsics.checkNotNullParameter(colorBackground, "colorBackground");
        Intrinsics.checkNotNullParameter(font, "font");
        return new Theme(colorRectNormal, colorRectActive, colorFont, colorFontReadOnly, colorFontTip, colorBackground, blurPass, font);
    }

    public static /* synthetic */ Theme copy$default(Theme theme, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int n2, FontRenderer fontRenderer, int n3, Object object) {
        if ((n3 & 1) != 0) {
            color = theme.colorRectNormal;
        }
        if ((n3 & 2) != 0) {
            color2 = theme.colorRectActive;
        }
        if ((n3 & 4) != 0) {
            color3 = theme.colorFont;
        }
        if ((n3 & 8) != 0) {
            color4 = theme.colorFontReadOnly;
        }
        if ((n3 & 0x10) != 0) {
            color5 = theme.colorFontTip;
        }
        if ((n3 & 0x20) != 0) {
            color6 = theme.colorBackground;
        }
        if ((n3 & 0x40) != 0) {
            n2 = theme.blurPass;
        }
        if ((n3 & 0x80) != 0) {
            fontRenderer = theme.font;
        }
        return theme.copy(color, color2, color3, color4, color5, color6, n2, fontRenderer);
    }

    @NotNull
    public String toString() {
        return "Theme(colorRectNormal=" + this.colorRectNormal + ", colorRectActive=" + this.colorRectActive + ", colorFont=" + this.colorFont + ", colorFontReadOnly=" + this.colorFontReadOnly + ", colorFontTip=" + this.colorFontTip + ", colorBackground=" + this.colorBackground + ", blurPass=" + this.blurPass + ", font=" + this.font + ')';
    }

    public int hashCode() {
        int result = this.colorRectNormal.hashCode();
        result = result * 31 + this.colorRectActive.hashCode();
        result = result * 31 + this.colorFont.hashCode();
        result = result * 31 + this.colorFontReadOnly.hashCode();
        result = result * 31 + this.colorFontTip.hashCode();
        result = result * 31 + this.colorBackground.hashCode();
        result = result * 31 + Integer.hashCode(this.blurPass);
        result = result * 31 + this.font.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Theme)) {
            return false;
        }
        Theme theme = (Theme)other;
        if (!Intrinsics.areEqual(this.colorRectNormal, theme.colorRectNormal)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colorRectActive, theme.colorRectActive)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colorFont, theme.colorFont)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colorFontReadOnly, theme.colorFontReadOnly)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colorFontTip, theme.colorFontTip)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.colorBackground, theme.colorBackground)) {
            return false;
        }
        if (this.blurPass != theme.blurPass) {
            return false;
        }
        return Intrinsics.areEqual(this.font, theme.font);
    }
}

