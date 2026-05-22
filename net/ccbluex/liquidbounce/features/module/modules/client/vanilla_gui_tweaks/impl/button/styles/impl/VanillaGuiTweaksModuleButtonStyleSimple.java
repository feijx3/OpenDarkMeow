/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.button.styles.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.button.styles.VanillaGuiTweaksModuleButtonStyle;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/styles/impl/VanillaGuiTweaksModuleButtonStyleSimple;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/styles/VanillaGuiTweaksModuleButtonStyle;", "<init>", "()V", "rectValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "rectColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "render", "", "Lnet/minecraft/client/gui/GuiButton;", "mc", "Lnet/minecraft/client/Minecraft;", "state", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVanillaGuiTweaksModuleButtonStyleSimple.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VanillaGuiTweaksModuleButtonStyleSimple.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/styles/impl/VanillaGuiTweaksModuleButtonStyleSimple\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class VanillaGuiTweaksModuleButtonStyleSimple
extends VanillaGuiTweaksModuleButtonStyle {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final BoolValue rectValue = new BoolValue("Rect", true);
    @JvmField
    @NotNull
    public final ColorValue rectColorValue;
    @NotNull
    private static final Color COLOR_NORMAL = new Color(30, 30, 30, 150);
    @NotNull
    private static final Color COLOR_HOVERED = new Color(60, 60, 60, 150);

    /*
     * WARNING - void declaration
     */
    public VanillaGuiTweaksModuleButtonStyleSimple() {
        super("Simple");
        void $this$rectColorValue_u24lambda_u240;
        ColorValue colorValue;
        ColorValue colorValue2 = colorValue = new ColorValue("RectColor", ColorValueManager.Companion.getDEFAULT_NORMAL(), false, 4, null);
        VanillaGuiTweaksModuleButtonStyleSimple vanillaGuiTweaksModuleButtonStyleSimple = this;
        boolean bl2 = false;
        $this$rectColorValue_u24lambda_u240.setSuperValue(this.rectValue);
        vanillaGuiTweaksModuleButtonStyleSimple.rectColorValue = colorValue;
    }

    @Override
    public void render(@NotNull GuiButton $this$render, @NotNull Minecraft mc, int state) {
        Intrinsics.checkNotNullParameter($this$render, "<this>");
        Intrinsics.checkNotNullParameter(mc, "mc");
        RenderUtils.INSTANCE.drawRect($this$render.field_146128_h, $this$render.field_146129_i, $this$render.field_146128_h + $this$render.field_146120_f, $this$render.field_146129_i + $this$render.field_146121_g, state == 2 ? COLOR_HOVERED : COLOR_NORMAL);
        if (((Boolean)this.rectValue.get()).booleanValue()) {
            RenderUtils.INSTANCE.drawRect($this$render.field_146128_h, $this$render.field_146129_i + $this$render.field_146121_g - 1, $this$render.field_146128_h + $this$render.field_146120_f, $this$render.field_146129_i + $this$render.field_146121_g, ColorValue.getColor$default(this.rectColorValue, null, 1, null));
        }
        FontRenderer fontRenderer = mc.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        String string = $this$render.field_146126_j;
        Intrinsics.checkNotNullExpressionValue(string, "displayString");
        Number number = $this$render.field_146128_h + $this$render.field_146120_f / 2;
        Number number2 = $this$render.field_146129_i + ($this$render.field_146121_g - 8) / 2;
        Color color = $this$render.field_146124_l ? Color.WHITE : Color.GRAY;
        Intrinsics.checkNotNull(color);
        FontRendererUtils.drawStringCentered$default(FontRendererUtils.INSTANCE, fontRenderer, string, number, number2, color, false, false, 48, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/styles/impl/VanillaGuiTweaksModuleButtonStyleSimple$Companion;", "", "<init>", "()V", "COLOR_NORMAL", "Ljava/awt/Color;", "getCOLOR_NORMAL", "()Ljava/awt/Color;", "COLOR_HOVERED", "getCOLOR_HOVERED", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Color getCOLOR_NORMAL() {
            return COLOR_NORMAL;
        }

        @NotNull
        public final Color getCOLOR_HOVERED() {
            return COLOR_HOVERED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

