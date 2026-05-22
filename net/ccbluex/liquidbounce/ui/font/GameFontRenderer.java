/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.font;

import java.awt.Color;
import java.awt.Font;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.ui.font.FontDrawer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fJ&\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fJ(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J.\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J&\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fJ0\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "Lnet/minecraft/client/gui/FontRenderer;", "name", "", "font", "Ljava/awt/Font;", "<init>", "(Ljava/lang/String;Ljava/awt/Font;)V", "getName", "()Ljava/lang/String;", "getFont", "()Ljava/awt/Font;", "drawer", "Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;", "fontHeight", "", "getFontHeight", "()I", "height", "getHeight", "size", "getSize", "deriveFont", "drawString", "s", "x", "", "y", "color", "drawStringWithShadow", "text", "drawCenteredString", "shadow", "", "getStringWidth", "Companion", "DarkMeow"})
public class GameFontRenderer
extends FontRenderer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @NotNull
    private final Font font;
    @NotNull
    private final FontDrawer drawer;
    private final int fontHeight;

    public GameFontRenderer(@NotNull String name, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(font, "font");
        super(Minecraft.func_71410_x().field_71474_y, new ResourceLocation("textures/font/ascii.png"), Minecraft.func_71410_x().func_110434_K(), false);
        this.name = name;
        this.font = font;
        this.drawer = new FontDrawer(this.font, true);
        this.fontHeight = this.getHeight();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Font getFont() {
        return this.font;
    }

    public final int getFontHeight() {
        return this.fontHeight;
    }

    public final int getHeight() {
        return this.drawer.getHeight();
    }

    public final int getSize() {
        return this.font.getSize();
    }

    @NotNull
    public final GameFontRenderer deriveFont(int size) {
        Font font = this.font.deriveFont(0, size);
        Intrinsics.checkNotNullExpressionValue(font, "deriveFont(...)");
        return new GameFontRenderer(this.name, font);
    }

    public final int drawString(@NotNull String s2, float x2, float y2, int color) {
        Intrinsics.checkNotNullParameter(s2, "s");
        return this.func_175065_a(s2, x2, y2, color, false);
    }

    public int func_175063_a(@NotNull String text, float x2, float y2, int color) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.func_175065_a(text, x2, y2, color, true);
    }

    public final int drawCenteredString(@NotNull String s2, float x2, float y2, int color, boolean shadow) {
        Intrinsics.checkNotNullParameter(s2, "s");
        return this.func_175065_a(s2, x2 - (float)this.func_78256_a(s2) / 2.0f, y2, color, shadow);
    }

    public final int drawCenteredString(@NotNull String s2, float x2, float y2, int color) {
        Intrinsics.checkNotNullParameter(s2, "s");
        return this.func_175063_a(s2, x2 - (float)this.func_78256_a(s2) / 2.0f, y2, color);
    }

    public int func_175065_a(@NotNull String text, float x2, float y2, int color, boolean shadow) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.drawer.drawString(text, (Number)Float.valueOf(x2), (Number)Float.valueOf(y2), new Color(color), shadow);
    }

    public int func_78256_a(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.drawer.getStringWidth(text);
    }

    @Deprecated(message="L")
    @JvmStatic
    public static final int getColorIndex(char type) {
        return Companion.getColorIndex(type);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer$Companion;", "", "<init>", "()V", "getColorIndex", "", "type", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @Deprecated(message="L")
        @JvmStatic
        public final int getColorIndex(char type) {
            int n2;
            block1: {
                char c2;
                block0: {
                    c2 = type;
                    boolean bl2 = '0' <= c2 ? c2 < ':' : false;
                    if (!bl2) break block0;
                    n2 = type - 48;
                    break block1;
                }
                n2 = ('a' <= c2 ? c2 < 'g' : false) ? type - 97 + 10 : (('k' <= c2 ? c2 < 'p' : false) ? type - 107 + 16 : (c2 == 'r' ? 21 : -1));
            }
            return n2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

