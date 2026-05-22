/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.TextureMap
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.visual;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\u00062\u0006\u0010\r\u001a\u0002H\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u00a2\u0006\u0002\u0010\u0012J[\u0010\u0013\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\u00062\u0006\u0010\r\u001a\u0002H\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0011H\u0007\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/FontRendererUtils;", "", "<init>", "()V", "drawString", "", "T1", "", "T2", "Lnet/minecraft/client/gui/FontRenderer;", "text", "", "x", "y", "color", "Ljava/awt/Color;", "shadow", "", "(Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;Z)I", "drawStringCentered", "centerY", "(Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;ZZ)I", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFontRendererUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontRendererUtils.kt\nnet/darkmeow/darkmeow/utils/visual/FontRendererUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
public final class FontRendererUtils {
    @NotNull
    public static final FontRendererUtils INSTANCE = new FontRendererUtils();

    private FontRendererUtils() {
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawString(@NotNull FontRenderer $this$drawString, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2, @NotNull Color color, boolean shadow) {
        int n2;
        FontRenderer fontRenderer;
        Intrinsics.checkNotNullParameter($this$drawString, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        FontRenderer it = fontRenderer = $this$drawString;
        boolean bl2 = false;
        GlStateManagerUtils.INSTANCE.prepare();
        GlStateManager.func_179098_w();
        Minecraft.func_71410_x().func_110434_K().func_110577_a(TextureMap.field_110575_b);
        Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110575_b).func_174935_a();
        int it2 = n2 = fontRenderer.func_175065_a(text, x2.floatValue(), y2.floatValue(), color.getRGB(), shadow);
        boolean bl3 = false;
        GlStateManagerUtils.INSTANCE.release();
        return n2;
    }

    public static /* synthetic */ int drawString$default(FontRendererUtils fontRendererUtils, FontRenderer fontRenderer, String string, Number number, Number number2, Color color, boolean bl2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            Color color2 = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color2, "WHITE");
            color = color2;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = true;
        }
        return fontRendererUtils.drawString(fontRenderer, string, number, number2, color, bl2);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawStringCentered(@NotNull FontRenderer $this$drawStringCentered, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2, @NotNull Color color, boolean shadow, boolean centerY) {
        Intrinsics.checkNotNullParameter($this$drawStringCentered, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return this.drawString($this$drawStringCentered, text, (Number)Float.valueOf(x2.floatValue() - (float)$this$drawStringCentered.func_78256_a(text) / 2.0f), (Number)Float.valueOf(y2.floatValue() - (centerY ? (float)$this$drawStringCentered.field_78288_b / 2.0f : 0.0f)), color, shadow);
    }

    public static /* synthetic */ int drawStringCentered$default(FontRendererUtils fontRendererUtils, FontRenderer fontRenderer, String string, Number number, Number number2, Color color, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 8) != 0) {
            Color color2 = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color2, "WHITE");
            color = color2;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = true;
        }
        if ((n2 & 0x20) != 0) {
            bl3 = false;
        }
        return fontRendererUtils.drawStringCentered(fontRenderer, string, number, number2, color, bl2, bl3);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawString(@NotNull FontRenderer $this$drawString, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2, @NotNull Color color) {
        Intrinsics.checkNotNullParameter($this$drawString, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return FontRendererUtils.drawString$default(this, $this$drawString, text, x2, y2, color, false, 16, null);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawString(@NotNull FontRenderer $this$drawString, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2) {
        Intrinsics.checkNotNullParameter($this$drawString, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        return FontRendererUtils.drawString$default(this, $this$drawString, text, x2, y2, null, false, 24, null);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawStringCentered(@NotNull FontRenderer $this$drawStringCentered, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2, @NotNull Color color, boolean shadow) {
        Intrinsics.checkNotNullParameter($this$drawStringCentered, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return FontRendererUtils.drawStringCentered$default(this, $this$drawStringCentered, text, x2, y2, color, shadow, false, 32, null);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawStringCentered(@NotNull FontRenderer $this$drawStringCentered, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2, @NotNull Color color) {
        Intrinsics.checkNotNullParameter($this$drawStringCentered, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(color, "color");
        return FontRendererUtils.drawStringCentered$default(this, $this$drawStringCentered, text, x2, y2, color, false, false, 48, null);
    }

    @JvmOverloads
    public final <T1 extends Number, T2 extends Number> int drawStringCentered(@NotNull FontRenderer $this$drawStringCentered, @NotNull String text, @NotNull T1 x2, @NotNull T2 y2) {
        Intrinsics.checkNotNullParameter($this$drawStringCentered, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        return FontRendererUtils.drawStringCentered$default(this, $this$drawStringCentered, text, x2, y2, null, false, false, 56, null);
    }
}

