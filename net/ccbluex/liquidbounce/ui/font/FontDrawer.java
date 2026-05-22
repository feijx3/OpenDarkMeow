/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.ui.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.utils.StringUtils;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0004\b\u0007\u0018\u0000 42\u00020\u0001:\u000234B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019JM\u0010\u001a\u001a\u00020\u0010\"\b\b\u0000\u0010\u001b*\u00020\u001c\"\b\b\u0001\u0010\u001d*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u0002H\u001b2\u0006\u0010 \u001a\u0002H\u001d2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010$J.\u0010%\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0005JF\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0018\u00010\fR\u00020\u00002\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0014\u0010/\u001a\u00060\fR\u00020\u00002\u0006\u00100\u001a\u000201H\u0002J\u0014\u00102\u001a\u00060\fR\u00020\u00002\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0018\u00010\fR\u00020\u00000\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u00065"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;", "", "font", "Ljava/awt/Font;", "antiAliasing", "", "<init>", "(Ljava/awt/Font;Z)V", "getFont", "()Ljava/awt/Font;", "glyphs", "", "Lnet/ccbluex/liquidbounce/ui/font/FontDrawer$Glyph;", "[Lnet/ccbluex/liquidbounce/ui/font/FontDrawer$Glyph;", "runtimeFont", "imageSize", "", "height", "getHeight", "()I", "setHeight", "(I)V", "getRuntimeFont", "getStringWidth", "s", "", "drawString", "X", "", "Y", "text", "x", "y", "color", "Ljava/awt/Color;", "hasShadow", "(Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;Z)I", "drawStringFinal", "", "dropShadow", "drawGlyph", "", "glyph", "bold", "strikethrough", "underline", "italic", "getGlyph", "c", "", "createGlyph", "Glyph", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFontDrawer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontDrawer.kt\nnet/ccbluex/liquidbounce/ui/font/FontDrawer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,306:1\n1#2:307\n*E\n"})
public final class FontDrawer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Font font;
    private final boolean antiAliasing;
    @NotNull
    private final Glyph[] glyphs;
    @NotNull
    private final Font runtimeFont;
    private final int imageSize;
    private int height;
    @NotNull
    private static final Map<Integer, Font> RUNTIME_FONT_MAP = new HashMap();
    private static boolean RuntimeFontAntiAliasing = true;

    public FontDrawer(@NotNull Font font, boolean antiAliasing) {
        Intrinsics.checkNotNullParameter(font, "font");
        this.font = font;
        this.antiAliasing = antiAliasing;
        this.glyphs = new Glyph[65536];
        this.height = this.font.getSize();
        this.imageSize = this.font.getSize() + 4;
        this.runtimeFont = this.getRuntimeFont();
    }

    @NotNull
    public final Font getFont() {
        return this.font;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int n2) {
        this.height = n2;
    }

    private final Font getRuntimeFont() {
        Font runtimeFont = RUNTIME_FONT_MAP.get(this.height);
        if (runtimeFont == null) {
            runtimeFont = new Font("SansSerif", 0, this.height);
            RUNTIME_FONT_MAP.put(this.height, runtimeFont);
        }
        return runtimeFont;
    }

    public final int getStringWidth(@NotNull String s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        CharSequence charSequence = s2;
        Regex regex = new Regex("\u00a7[0-9a-fklmnor]");
        String string = "";
        String text = regex.replace(charSequence, string);
        if (((CharSequence)text).length() > 0) {
            int ret = 0;
            int n2 = text.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char element = text.charAt(i2);
                ret += this.getGlyph(element).getHalfWidth();
            }
            return ret + 2;
        }
        return 0;
    }

    @JvmOverloads
    public final <X extends Number, Y extends Number> int drawString(@NotNull String text, @NotNull X x2, @NotNull Y y2, @NotNull Color color, boolean hasShadow) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return Math.max(hasShadow ? this.drawStringFinal(text, x2.doubleValue() + 1.0, y2.doubleValue() + 1.0, color, true) + 1 : 0, this.drawStringFinal(text, x2.doubleValue(), y2.doubleValue(), color, false));
    }

    public static /* synthetic */ int drawString$default(FontDrawer fontDrawer, String string, Number number, Number number2, Color color, boolean bl2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            Color color2 = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color2, "WHITE");
            color = color2;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = true;
        }
        return fontDrawer.drawString(string, number, number2, color, bl2);
    }

    public final int drawStringFinal(@NotNull String text, double x2, double y2, @NotNull Color color, boolean dropShadow) {
        int n2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        String it = string2 = StringUtils.INSTANCE.filterEmoji(text);
        boolean bl2 = false;
        String string3 = string = ((CharSequence)it).length() > 0 ? string2 : null;
        if (string != null) {
            String s2 = string;
            boolean bl3 = false;
            if (this.font.getSize() == 18) {
                this.height = 18;
            }
            GlStateManager.func_179141_d();
            boolean bl4 = dropShadow;
            if (bl4) {
                ColorUtils.INSTANCE.setGlColor(ColorUtils.INSTANCE.darker(color, 0.1));
            } else if (!bl4) {
                ColorUtils.INSTANCE.setGlColor(color);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            GlStateManagerUtils.INSTANCE.applyBlend();
            GlStateManager.func_179098_w();
            GlStateManager.func_179094_E();
            GlStateManager.func_179139_a((double)0.5, (double)0.5, (double)0.5);
            double drawX = (x2 - 2.0) * 2.0;
            double drawY = (y2 - 1.0) * 2.0;
            boolean bold = false;
            boolean italic = false;
            boolean strikethrough = false;
            boolean underline = false;
            for (int i2 = 0; i2 < s2.length(); ++i2) {
                Glyph glyph;
                char c2 = s2.charAt(i2);
                if (c2 == '\u00a7') {
                    Color color2;
                    Object object;
                    String string4;
                    Object object2;
                    glyph = this.getGlyph('\u00a7');
                    if (++i2 >= s2.length()) {
                        this.drawGlyph(glyph, drawX, drawY, bold, strikethrough, underline, italic);
                        drawX += (double)glyph.getWidth();
                        continue;
                    }
                    int colorIndex = StringsKt.indexOf$default((CharSequence)"0123456789abcdefklmnorx", Character.toLowerCase(s2.charAt(i2)), 0, false, 6, null);
                    boolean bl5 = 0 <= colorIndex ? colorIndex < 17 : false;
                    if (bl5) {
                        object2 = net.ccbluex.liquidbounce.utils.render.ColorUtils.colorCode$default(colorIndex, 0, 2, null);
                        Color finalColor = object2;
                        boolean bl6 = false;
                        bold = false;
                        italic = false;
                        underline = false;
                        strikethrough = false;
                        boolean bl7 = dropShadow;
                        if (bl7) {
                            ColorUtils.INSTANCE.setGlColor(ColorUtils.INSTANCE.darker(finalColor, 0.1));
                            continue;
                        }
                        if (!bl7) {
                            ColorUtils.INSTANCE.setGlColor(finalColor);
                            continue;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (colorIndex == 17) {
                        bold = true;
                        continue;
                    }
                    if (colorIndex == 18) {
                        strikethrough = true;
                        continue;
                    }
                    if (colorIndex == 19) {
                        underline = true;
                        continue;
                    }
                    if (colorIndex == 20) {
                        italic = true;
                        continue;
                    }
                    if (colorIndex == 21) {
                        bold = false;
                        italic = false;
                        underline = false;
                        strikethrough = false;
                        boolean bl8 = dropShadow;
                        if (bl8) {
                            ColorUtils.INSTANCE.setGlColor(ColorUtils.INSTANCE.darker(color, 0.1));
                            continue;
                        }
                        if (!bl8) {
                            ColorUtils.INSTANCE.setGlColor(color);
                            continue;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (colorIndex != 22) continue;
                    String it2 = string4 = s2;
                    boolean bl9 = false;
                    Object object3 = object2 = it2.length() > i2 + 13 ? string4 : null;
                    if (object2 == null || (string4 = StringsKt.substring((String)object2, new IntRange(i2 + 1, i2 + 13))) == null) continue;
                    String it3 = string4;
                    boolean bl10 = false;
                    MatchResult matchResult = Regex.find$default(new Regex("\u00a7([0-9a-fA-F])\u00a7([0-9a-fA-F])\u00a7([0-9a-fA-F])\u00a7([0-9a-fA-F])\u00a7([0-9a-fA-F])\u00a7([0-9a-fA-F])"), it3, 0, 2, null);
                    if (matchResult == null) continue;
                    MatchResult result = matchResult;
                    boolean bl11 = false;
                    Object object4 = this;
                    try {
                        FontDrawer $this$drawStringFinal_u24lambda_u248_u24lambda_u245_u24lambda_u244 = object4;
                        boolean bl12 = false;
                        object = Result.constructor-impl(new Color(Integer.parseInt(result.getGroupValues().get(1) + result.getGroupValues().get(2), CharsKt.checkRadix(16)), Integer.parseInt(result.getGroupValues().get(3) + result.getGroupValues().get(4), CharsKt.checkRadix(16)), Integer.parseInt(result.getGroupValues().get(5) + result.getGroupValues().get(6), CharsKt.checkRadix(16))));
                    }
                    catch (Throwable throwable) {
                        object = Result.constructor-impl(ResultKt.createFailure(throwable));
                    }
                    object4 = object;
                    Color color3 = (Color)(Result.isFailure-impl(object4) ? null : object4);
                    if (color3 == null) continue;
                    Color finalColor = color2 = color3;
                    boolean bl13 = false;
                    boolean bl14 = dropShadow;
                    if (bl14) {
                        ColorUtils.INSTANCE.setGlColor(ColorUtils.INSTANCE.darker(finalColor, 0.1));
                    } else if (!bl14) {
                        ColorUtils.INSTANCE.setGlColor(finalColor);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    Color it4 = color2;
                    boolean bl15 = false;
                    i2 += 12;
                    continue;
                }
                glyph = this.getGlyph(c2);
                this.drawGlyph(glyph, drawX, drawY, bold, strikethrough, underline, italic);
                drawX += (double)glyph.getWidth();
            }
            GlStateManagerUtils.INSTANCE.unapplyBlend();
            Color color4 = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color4, "WHITE");
            ColorUtils.INSTANCE.setGlColor(color4);
            GlStateManager.func_179117_G();
            GlStateManager.func_179121_F();
            n2 = this.getStringWidth(s2);
        } else {
            n2 = 0;
        }
        return n2;
    }

    private final void drawGlyph(Glyph glyph, double x2, double y2, boolean bold, boolean strikethrough, boolean underline, boolean italic) {
        if (bold) {
            Glyph glyph2 = glyph;
            Intrinsics.checkNotNull(glyph2);
            glyph2.draw(x2 + 1.0, y2, italic);
        }
        Glyph glyph3 = glyph;
        Intrinsics.checkNotNull(glyph3);
        glyph3.draw(x2, y2, italic);
        if (strikethrough) {
            double mid = y2 + (double)this.height / 2.0;
            FontDrawer.Companion.drawLine(x2, mid - 1.0, x2 + (double)glyph.getWidth(), mid + 1.0);
        }
        if (underline) {
            FontDrawer.Companion.drawLine(x2, y2 + (double)this.height - 1.0, x2 + (double)glyph.getWidth(), y2 + (double)this.height + 1.0);
        }
    }

    private final Glyph getGlyph(char c2) {
        Glyph glyph = this.glyphs[c2];
        if (glyph == null) {
            this.glyphs[c2] = glyph = this.createGlyph(c2);
        }
        return glyph;
    }

    private final Glyph createGlyph(char c2) {
        String s2 = String.valueOf(c2);
        BufferedImage image2 = new BufferedImage(this.imageSize, this.imageSize, 2);
        Graphics2D g2 = image2.createGraphics();
        int offset = 0;
        if (this.font.canDisplay(c2)) {
            Intrinsics.checkNotNull(g2);
            FontDrawer.Companion.setRenderingHints(g2, this.antiAliasing);
            g2.setFont(this.font);
        } else {
            Intrinsics.checkNotNull(g2);
            FontDrawer.Companion.setRenderingHints(g2, FontDrawer.RuntimeFontAntiAliasing);
            g2.setFont(this.runtimeFont);
            offset = 1;
        }
        FontMetrics fontMetrics = g2.getFontMetrics();
        g2.setColor(Color.WHITE);
        g2.drawString(s2, 0, this.height - 1 + offset);
        g2.dispose();
        return new Glyph(new DynamicTexture(image2), fontMetrics.getStringBounds((String)s2, (Graphics)((Graphics)g2)).getBounds().width);
    }

    @JvmOverloads
    public final <X extends Number, Y extends Number> int drawString(@NotNull String text, @NotNull X x2, @NotNull Y y2, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return FontDrawer.drawString$default(this, text, x2, y2, color, false, 16, null);
    }

    @JvmOverloads
    public final <X extends Number, Y extends Number> int drawString(@NotNull String text, @NotNull X x2, @NotNull Y y2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        return FontDrawer.drawString$default(this, text, x2, y2, null, false, 24, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/FontDrawer$Companion;", "", "<init>", "()V", "RUNTIME_FONT_MAP", "", "", "Ljava/awt/Font;", "RuntimeFontAntiAliasing", "", "getRuntimeFontAntiAliasing", "()Z", "setRuntimeFontAntiAliasing", "(Z)V", "setRenderingHints", "", "g", "Ljava/awt/Graphics2D;", "antiAliasing", "drawLine", "left", "", "top", "right", "bottom", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean getRuntimeFontAntiAliasing() {
            return RuntimeFontAntiAliasing;
        }

        public final void setRuntimeFontAntiAliasing(boolean bl2) {
            RuntimeFontAntiAliasing = bl2;
        }

        private final void setRenderingHints(Graphics2D g2, boolean antiAliasing) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (antiAliasing) {
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            } else {
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            }
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        }

        private final void drawLine(double left, double top, double right, double bottom) {
            BufferBuilder bufferBuilder;
            Tessellator tessellator;
            double finalLeft = Math.min(left, right);
            double finalRight = Math.max(left, right);
            double finalTop = Math.min(top, bottom);
            double finalBottom = Math.max(top, bottom);
            GlStateManager.func_179090_x();
            Tessellator it = tessellator = Tessellator.func_178181_a();
            boolean bl2 = false;
            BufferBuilder $this$drawLine_u24lambda_u241_u24lambda_u240 = bufferBuilder = it.func_178180_c();
            boolean bl3 = false;
            $this$drawLine_u24lambda_u241_u24lambda_u240.func_181668_a(7, DefaultVertexFormats.field_181705_e);
            $this$drawLine_u24lambda_u241_u24lambda_u240.func_181662_b(finalLeft, finalBottom, 0.0).func_181675_d();
            $this$drawLine_u24lambda_u241_u24lambda_u240.func_181662_b(finalRight, finalBottom, 0.0).func_181675_d();
            $this$drawLine_u24lambda_u241_u24lambda_u240.func_181662_b(finalRight, finalTop, 0.0).func_181675_d();
            $this$drawLine_u24lambda_u241_u24lambda_u240.func_181662_b(finalLeft, finalTop, 0.0).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179098_w();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/FontDrawer$Glyph;", "", "texture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "width", "", "<init>", "(Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;Lnet/minecraft/client/renderer/texture/DynamicTexture;I)V", "getTexture", "()Lnet/minecraft/client/renderer/texture/DynamicTexture;", "getWidth", "()I", "halfWidth", "getHalfWidth", "draw", "", "x", "", "y", "italic", "", "DarkMeow"})
    public final class Glyph {
        @NotNull
        private final DynamicTexture texture;
        private final int width;
        private final int halfWidth;

        public Glyph(DynamicTexture texture, int width) {
            Intrinsics.checkNotNullParameter(texture, "texture");
            this.texture = texture;
            this.width = width;
            this.halfWidth = this.width / 2;
        }

        @NotNull
        public final DynamicTexture getTexture() {
            return this.texture;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHalfWidth() {
            return this.halfWidth;
        }

        public final void draw(double x2, double y2, boolean italic) {
            GlStateManager.func_179144_i((int)this.texture.func_110552_b());
            double offset = italic ? 2.0 : 0.0;
            GL11.glBegin((int)5);
            GL11.glTexCoord2d((double)0.0, (double)0.0);
            GL11.glVertex3d((double)(x2 + offset), (double)y2, (double)0.0);
            GL11.glTexCoord2d((double)0.0, (double)1.0);
            GL11.glVertex3d((double)(x2 - offset), (double)(y2 + (double)FontDrawer.this.imageSize), (double)0.0);
            GL11.glTexCoord2d((double)1.0, (double)0.0);
            GL11.glVertex3d((double)(x2 + (double)FontDrawer.this.imageSize + offset), (double)y2, (double)0.0);
            GL11.glTexCoord2d((double)1.0, (double)1.0);
            GL11.glVertex3d((double)(x2 + (double)FontDrawer.this.imageSize - offset), (double)(y2 + (double)FontDrawer.this.imageSize), (double)0.0);
            GL11.glEnd();
        }
    }
}

