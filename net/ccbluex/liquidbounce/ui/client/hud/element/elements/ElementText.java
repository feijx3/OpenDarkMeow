/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementText;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "displayTextValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "shadowValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "editTick", "", "editDisplaySuffix", "", "prevClick", "fontRenderer", "Lnet/minecraft/client/gui/FontRenderer;", "color", "Ljava/awt/Color;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "updateElement", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "updateId", "handleMouseClick", "x", "", "y", "mouseButton", "", "handleKey", "c", "", "keyCode", "DarkMeow"})
public final class ElementText
extends Element {
    @NotNull
    private final TextValue displayTextValue = new TextValue("DisplayText", "");
    @NotNull
    private final ColorValue colorValue = new ColorValue("Color", null, false, 6, null);
    @NotNull
    private final BoolValue shadowValue = new BoolValue("Shadow", true);
    @NotNull
    private FontValue fontValue = new FontValue("Font", new FontValue.FontInfo(null, 0, 3, null));
    private long editTick = -1L;
    private boolean editDisplaySuffix;
    private long prevClick;
    @Nullable
    private FontRenderer fontRenderer;
    @NotNull
    private Color color;

    public ElementText() {
        super("Text", 10.0, 10.0, 0.0f, null, 0, 56, null);
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        this.color = color;
    }

    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        FontRenderer fontRenderer = this.fontRenderer;
        if (fontRenderer == null) {
            return null;
        }
        FontRenderer renderer = fontRenderer;
        int length = FontRendererUtils.INSTANCE.drawString(renderer, (String)this.displayTextValue.get(), (Number)Float.valueOf(0.0f), (Number)Float.valueOf(0.0f), this.color, (Boolean)this.shadowValue.get());
        if (this.editTick != -1L && this.editDisplaySuffix && MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner) {
            FontRendererUtils.INSTANCE.drawString(renderer, "_", (Number)Float.valueOf((float)length + 1.0f), (Number)Float.valueOf(0.0f), this.color, (Boolean)this.shadowValue.get());
        }
        return new ElementBorder(-2.0f, -2.0f, (float)length + 2.0f, renderer.field_78288_b);
    }

    @Override
    public void updateElement(@NotNull EntityPlayerSP player, long updateId) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.fontRenderer = this.fontValue.getFont();
        this.color = ColorValue.getColor$default(this.colorValue, null, 1, null);
        this.editDisplaySuffix = (updateId - this.editTick) % 20L == 0L;
    }

    @Override
    public void handleMouseClick(double x2, double y2, int mouseButton) {
        if (this.isInBorder(x2, y2) && mouseButton == 0) {
            if (System.currentTimeMillis() - this.prevClick <= 250L) {
                this.editTick = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
            }
            this.prevClick = System.currentTimeMillis();
        } else {
            this.editTick = -1L;
        }
    }

    @Override
    public void handleKey(char c2, int keyCode) {
        if (this.editTick != -1L && MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner) {
            if (keyCode == 14) {
                if (((CharSequence)this.displayTextValue.get()).length() > 0) {
                    Value value = this.displayTextValue;
                    String string = ((String)this.displayTextValue.get()).substring(0, ((String)this.displayTextValue.get()).length() - 1);
                    Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                    Value.set$default(value, string, false, 2, null);
                }
                this.updateElement();
                return;
            }
            if (ColorUtils.INSTANCE.isAllowedCharacter(c2) || c2 == '\u00a7') {
                Value.set$default(this.displayTextValue, (String)this.displayTextValue.get() + c2, false, 2, null);
            }
            this.updateElement();
        }
    }
}

