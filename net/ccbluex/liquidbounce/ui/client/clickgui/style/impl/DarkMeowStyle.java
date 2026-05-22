/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.StringUtils
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.ui.client.clickgui.style.impl;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.features.manager.ClickGuiManager;
import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.ccbluex.liquidbounce.utils.math.ClosedRangeUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.DoubleSeekBarElement;
import net.ccbluex.liquidbounce.value.elements.impl.KeySelectionElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListBodyElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListHeaderElement;
import net.ccbluex.liquidbounce.value.elements.impl.RectElement;
import net.ccbluex.liquidbounce.value.elements.impl.SelectionElement;
import net.ccbluex.liquidbounce.value.elements.impl.SingleSeekBarElement;
import net.ccbluex.liquidbounce.value.elements.impl.TextElement;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.darkmeow.darkmeow.ui.gui.GuiInputFieldBox;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(value=Side.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/impl/DarkMeowStyle;", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;", "manager", "Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "<init>", "(Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;)V", "mouseDown", "", "rightMouseDown", "font", "Lnet/minecraft/client/gui/FontRenderer;", "lastEditSubElement", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "onGuiInit", "", "onGuiClose", "drawStart", "drawPanel", "mouseX", "", "mouseY", "panel", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/Panel;", "drawDescription", "text", "", "drawButtonElement", "buttonElement", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ButtonElement;", "drawModuleElement", "moduleElement", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ModuleElement;", "handleKey", "c", "", "keyCode", "round", "Ljava/math/BigDecimal;", "f", "", "resetLastEditSubElement", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nDarkMeowStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DarkMeowStyle.kt\nnet/ccbluex/liquidbounce/ui/client/clickgui/style/impl/DarkMeowStyle\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,724:1\n1878#2,2:725\n1880#2:728\n1617#2,9:729\n1869#2:738\n1870#2:740\n1626#2:741\n1#3:727\n1#3:739\n*S KotlinDebug\n*F\n+ 1 DarkMeowStyle.kt\nnet/ccbluex/liquidbounce/ui/client/clickgui/style/impl/DarkMeowStyle\n*L\n159#1:725,2\n159#1:728\n549#1:729,9\n549#1:738\n549#1:740\n549#1:741\n549#1:739\n*E\n"})
public final class DarkMeowStyle
extends Style {
    private boolean mouseDown;
    private boolean rightMouseDown;
    @NotNull
    private FontRenderer font;
    @Nullable
    private Element lastEditSubElement;

    public DarkMeowStyle(@NotNull ClickGuiManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super("DarkMeow", manager);
        this.font = manager.getClickGuiFont();
    }

    @Override
    public void onGuiInit() {
        Keyboard.enableRepeatEvents((boolean)true);
    }

    @Override
    public void onGuiClose() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public void drawStart() {
        this.font = this.getManager().getClickGuiFont();
    }

    @Override
    public void drawPanel(int mouseX, int mouseY, @NotNull Panel panel) {
        Intrinsics.checkNotNullParameter(panel, "panel");
        RenderUtils.drawBorderedRect(panel.x, (float)panel.y - 3.0f, (float)panel.x + (float)panel.width, (float)panel.y + 17.0f, 3.0f, new Color(97, 95, 95, 34).getRGB(), new Color(20, 20, 20, 174).getRGB());
        String name = "\u00a7f" + StringUtils.func_76338_a((String)panel.name);
        float textWidth = this.font.func_78256_a(name);
        this.font.func_78276_b(name, (int)((float)panel.x - (textWidth - 100.0f) / 2.0f), panel.y + 5, Color.WHITE.getRGB());
        RenderUtils.drawBorderedRect(panel.x, (float)panel.y + 17.0f, (float)panel.x + (float)panel.width, (float)(panel.y + 19) + panel.getFade(), 3.0f, new Color(33, 33, 33, 65).getRGB(), new Color(29, 29, 29, 86).getRGB());
        RenderUtils.drawBorderedRect(panel.x, (float)(panel.y + 17) + panel.getFade(), (float)panel.x + (float)panel.width, (float)(panel.y + 19) + panel.getFade() + (float)5, 3.0f, new Color(47, 46, 46, 0).getRGB(), new Color(20, 20, 20, 0).getRGB());
        if (panel.getScrollbar() && panel.getFade() > 0.0f) {
            RenderUtils.drawRect((float)(panel.x - 2), (float)(panel.y + 21), (float)panel.x, (float)(panel.y + 16) + panel.getFade(), Integer.MAX_VALUE);
            RenderUtils.drawRect((float)(panel.x - 2), (float)(panel.y + 30) + (panel.getFade() - 24.0f) / (float)(panel.elements.size() - ((Number)this.getManager().getConfig().getMaxElementsValue().get()).intValue()) * (float)panel.getDragged() - 10.0f, (float)panel.x, (float)(panel.y + 40) + (panel.getFade() - 24.0f) / (float)(panel.elements.size() - ((Number)this.getManager().getConfig().getMaxElementsValue().get()).intValue()) * (float)panel.getDragged(), Integer.MIN_VALUE);
        }
    }

    @Override
    public void drawDescription(int mouseX, int mouseY, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int textWidth = this.font.func_78256_a(text);
        RenderUtils.drawBorderedRect(mouseX + 9, mouseY, mouseX + textWidth + 14, mouseY + this.font.field_78288_b + 5, 1.0f, new Color(255, 255, 255, 89).getRGB(), Integer.MIN_VALUE);
        GlStateManager.func_179117_G();
        this.font.func_78276_b(text, mouseX + 12, mouseY + this.font.field_78288_b / 2, new Color(160, 160, 160).getRGB());
    }

    @Override
    public void drawButtonElement(int mouseX, int mouseY, @NotNull ButtonElement buttonElement) {
        Intrinsics.checkNotNullParameter(buttonElement, "buttonElement");
        GlStateManager.func_179117_G();
        this.font.func_78276_b(buttonElement.getDisplayName(), (int)((float)buttonElement.getX() - ((float)this.font.func_78256_a(buttonElement.getDisplayName()) - 100.0f) / 2.0f), buttonElement.getY() + 6, buttonElement.getColor());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawModuleElement(int mouseX, int mouseY, @NotNull ModuleElement moduleElement) {
        Intrinsics.checkNotNullParameter(moduleElement, "moduleElement");
        int guiColor = ColorValue.getColor$default(this.getManager().getConfig().getColorFontValue(), null, 1, null).getRGB();
        GlStateManager.func_179117_G();
        this.font.func_78276_b(moduleElement.getDisplayName(), (int)((float)moduleElement.getX() - ((float)this.font.func_78256_a(moduleElement.getDisplayName()) - 100.0f) / 2.0f), moduleElement.getY() + 6, moduleElement.module.getState() ? guiColor : new Color(160, 160, 160).getRGB());
        List<Value<?>> moduleValues = moduleElement.module.getValues();
        if (!((Collection)moduleValues).isEmpty()) {
            this.font.func_78276_b("+", moduleElement.getX() + moduleElement.getWidth() - 8, moduleElement.getY() + moduleElement.getHeight() / 2, Color.WHITE.getRGB());
            if (moduleElement.isShowSettings()) {
                int yPos = 0;
                yPos = moduleElement.getY() + 4;
                for (Value<?> value : moduleValues) {
                    if (!value.getDisplayable()) continue;
                    Iterable $this$forEachIndexed$iv = value.getClickGuiElement();
                    boolean $i$f$forEachIndexed = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        void it;
                        int n2;
                        if ((n2 = index$iv++) < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Element element = (Element)item$iv;
                        int index = n2;
                        boolean bl2 = false;
                        if (!it.isDisplayable()) continue;
                        void var18_18 = it;
                        if (var18_18 instanceof KeySelectionElement) {
                            int expandWidth;
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u240 = this;
                            boolean bl3 = false;
                            String title = ((KeySelectionElement)it).getTitle();
                            float textWidth = (float)$this$drawModuleElement_u24lambda_u2420_u24lambda_u240.font.func_78256_a(title) + (float)50;
                            if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = it.getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 14), Integer.MIN_VALUE);
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u240.font.func_78276_b("\u00a7c" + title, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 0xFFFFFF);
                            String content = Intrinsics.areEqual($this$drawModuleElement_u24lambda_u2420_u24lambda_u240.lastEditSubElement, it) ? "[Listening]" : '[' + ((KeySelectionElement)it).getSelected() + ']';
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u240.font.func_78276_b(content, (int)((float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - (float)$this$drawModuleElement_u24lambda_u2420_u24lambda_u240.font.func_78256_a(content) - (float)2), yPos + 4, 0xFFFFFF);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth && mouseY >= yPos + 2 && mouseY <= yPos + 14) {
                                if (Mouse.isButtonDown((int)0) && moduleElement.isntPressed()) {
                                    $this$drawModuleElement_u24lambda_u2420_u24lambda_u240.lastEditSubElement = it;
                                }
                                if (Mouse.isButtonDown((int)1) && moduleElement.isntPressed() && Intrinsics.areEqual($this$drawModuleElement_u24lambda_u2420_u24lambda_u240.lastEditSubElement, it)) {
                                    ((KeySelectionElement)it).onClicked("ESCAPE");
                                    $this$drawModuleElement_u24lambda_u2420_u24lambda_u240.resetLastEditSubElement();
                                }
                            }
                            yPos += 12;
                            continue;
                        }
                        if (var18_18 instanceof ListHeaderElement) {
                            int expandWidth;
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u241 = this;
                            boolean bl4 = false;
                            String title = ((ListHeaderElement)it).getTitle();
                            float textWidth = $this$drawModuleElement_u24lambda_u2420_u24lambda_u241.font.func_78256_a(title);
                            if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = it.getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            boolean isOpenList = ((ListHeaderElement)it).isOpenList();
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 14), Integer.MIN_VALUE);
                            Color color = ((ListHeaderElement)it).getDisplayColor();
                            if (color != null) {
                                GlStateManager.func_179117_G();
                                RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - 14.0f, (float)yPos + 7.0f, (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - 10.0f, (float)yPos + 11.0f, color);
                            }
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u241.font.func_78276_b("\u00a7c" + title, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 0xFFFFFF);
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u241.font.func_78276_b(isOpenList ? "-" : "+", (int)((float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - (float)(isOpenList ? 5 : 6)), yPos + 4, 0xFFFFFF);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth && mouseY >= yPos + 2 && mouseY <= yPos + 14 && Mouse.isButtonDown((int)0) && moduleElement.isntPressed()) {
                                ((ListHeaderElement)it).onClicked(isOpenList);
                                $this$drawModuleElement_u24lambda_u2420_u24lambda_u241.resetLastEditSubElement();
                            }
                            yPos += 12;
                            continue;
                        }
                        if (var18_18 instanceof ListBodyElement) {
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u242 = this;
                            boolean bl5 = false;
                            for (String valueOfList : ((ListBodyElement)it).getList()) {
                                int expandWidth;
                                float textWidth = $this$drawModuleElement_u24lambda_u2420_u24lambda_u242.font.func_78256_a('>' + valueOfList);
                                if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = ((ListBodyElement)it).getExpandWidth())) {
                                    moduleElement.settingsWidth = textWidth + (float)expandWidth;
                                }
                                RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 14), Integer.MIN_VALUE);
                                if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth && mouseY >= yPos + 2 && mouseY <= yPos + 14 && Mouse.isButtonDown((int)0) && moduleElement.isntPressed()) {
                                    ((ListBodyElement)it).onClicked(valueOfList);
                                    $this$drawModuleElement_u24lambda_u2420_u24lambda_u242.resetLastEditSubElement();
                                }
                                GlStateManager.func_179117_G();
                                $this$drawModuleElement_u24lambda_u2420_u24lambda_u242.font.func_78276_b(">", moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, new Color(160, 160, 160).getRGB());
                                $this$drawModuleElement_u24lambda_u2420_u24lambda_u242.font.func_78276_b(valueOfList, moduleElement.getX() + moduleElement.getWidth() + 14, yPos + 4, StringsKt.equals(((ListBodyElement)it).getSelected(), valueOfList, true) ? guiColor : new Color(160, 160, 160).getRGB());
                                yPos += 12;
                            }
                            continue;
                        }
                        if (var18_18 instanceof SelectionElement) {
                            int expandWidth;
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u243 = this;
                            boolean bl6 = false;
                            String title = ((SelectionElement)it).getTitle();
                            boolean isActive = ((SelectionElement)it).getIsActive();
                            float textWidth = $this$drawModuleElement_u24lambda_u2420_u24lambda_u243.font.func_78256_a(title);
                            if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = ((SelectionElement)it).getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 14), Integer.MIN_VALUE);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth && mouseY >= yPos + 2 && mouseY <= yPos + 14 && Mouse.isButtonDown((int)0) && moduleElement.isntPressed()) {
                                ((SelectionElement)it).onClicked(isActive);
                                $this$drawModuleElement_u24lambda_u2420_u24lambda_u243.resetLastEditSubElement();
                            }
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u243.font.func_78276_b(title, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, isActive ? guiColor : new Color(160, 160, 160).getRGB());
                            yPos += 12;
                            continue;
                        }
                        if (var18_18 instanceof SingleSeekBarElement) {
                            int expandWidth;
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u247 = this;
                            boolean bl7 = false;
                            String title = ((SingleSeekBarElement)it).getTitle();
                            float textWidth = $this$drawModuleElement_u24lambda_u2420_u24lambda_u247.font.func_78256_a(title);
                            if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = it.getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 24), Integer.MIN_VALUE);
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 8), (float)(yPos + 18), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - 4.0f, (float)(yPos + 19), Integer.MAX_VALUE);
                            float sliderValue = (float)(moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.settingsWidth - (float)12) * ((SingleSeekBarElement)it).getValue() / ((SingleSeekBarElement)it).getLength();
                            RenderUtils.drawRect(8.0f + sliderValue, (float)(yPos + 15), sliderValue + 11.0f, (float)(yPos + 21), guiColor);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - (float)4 && mouseY >= yPos + 15 && mouseY <= yPos + 21) {
                                if (Mouse.isButtonDown((int)0)) {
                                    double i2 = MathHelper.func_76131_a((float)((float)(mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.settingsWidth - (float)12)), (float)0.0f, (float)1.0f);
                                    ((SingleSeekBarElement)it).onClicked($this$drawModuleElement_u24lambda_u2420_u24lambda_u247.round((float)((double)((SingleSeekBarElement)it).getLength() * i2)).floatValue());
                                    $this$drawModuleElement_u24lambda_u2420_u24lambda_u247.resetLastEditSubElement();
                                }
                                if (Mouse.isButtonDown((int)1) && !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInputFieldBox)) {
                                    void it2;
                                    boolean isInt = ((SingleSeekBarElement)it).getIsInt();
                                    float f2 = ((SingleSeekBarElement)it).getValue() + ((SingleSeekBarElement)it).getOffset();
                                    String string = "Please input new value.";
                                    GuiScreen guiScreen = MinecraftInstance.mc.getCurrentScreen();
                                    MinecraftImpl minecraftImpl = MinecraftInstance.mc;
                                    boolean bl8 = false;
                                    Number number = isInt ? (Number)((int)it2) : (Number)Float.valueOf((float)it2);
                                    Function1<String, Unit> function1 = arg_0 -> DarkMeowStyle.drawModuleElement$lambda$20$lambda$7$lambda$6((Element)it, arg_0);
                                    int n3 = 64;
                                    String string2 = number.toString();
                                    String string3 = string;
                                    GuiScreen guiScreen2 = guiScreen;
                                    minecraftImpl.displayGuiScreen(new GuiInputFieldBox(guiScreen2, string3, string2, n3, function1));
                                    $this$drawModuleElement_u24lambda_u2420_u24lambda_u247.resetLastEditSubElement();
                                }
                            }
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u247.font.func_78276_b(title, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 0xFFFFFF);
                            yPos += 22;
                            continue;
                        }
                        if (var18_18 instanceof DoubleSeekBarElement) {
                            int expandWidth;
                            DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418 = this;
                            boolean bl9 = false;
                            String title = ((DoubleSeekBarElement)it).getTitle();
                            float valueLimit = ((DoubleSeekBarElement)it).getLength();
                            ClosedRange<Float> $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u248 = ((DoubleSeekBarElement)it).getValue();
                            boolean bl10 = false;
                            Pair<Float, Float> pair = TuplesKt.to($this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u248.getStart(), $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u248.getEndInclusive());
                            float valueMin = ((Number)pair.component1()).floatValue();
                            float valueMax = ((Number)pair.component2()).floatValue();
                            float textWidth = $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418.font.func_78256_a(title);
                            if (moduleElement.settingsWidth < textWidth + (float)(expandWidth = it.getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 24), Integer.MIN_VALUE);
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 8), (float)(yPos + 18), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - 4.0f, (float)(yPos + 19), Integer.MAX_VALUE);
                            float sliderXA = (float)(moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.settingsWidth - (float)12) * valueMin / valueLimit + 8.0f;
                            float sliderXB = (float)(moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.settingsWidth - (float)12) * valueMax / valueLimit + 8.0f;
                            RenderUtils.drawRect(sliderXA + 3.0f, (float)(yPos + 18), sliderXB, (float)(yPos + 19), guiColor);
                            RenderUtils.drawRect(sliderXA, (float)(yPos + 15), sliderXA + 3.0f, (float)(yPos + 21), guiColor);
                            RenderUtils.drawRect(sliderXB, (float)(yPos + 15), sliderXB + 3.0f, (float)(yPos + 21), guiColor);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 2 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth - (float)2 && mouseY >= yPos + 15 && mouseY <= yPos + 21) {
                                if (((DoubleSeekBarElement)it).getSelected() != null) {
                                    DoubleSeekBarElement.DoubleSeekBarSelected selected;
                                    boolean bl11 = false;
                                    double i3 = MathHelper.func_76131_a((float)((float)(mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.settingsWidth - (float)12)), (float)0.0f, (float)1.0f);
                                    float currentValue = $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418.round((float)((double)((DoubleSeekBarElement)it).getLength() * i3)).floatValue();
                                    switch (WhenMappings.$EnumSwitchMapping$0[selected.ordinal()]) {
                                        case 1: {
                                            ((DoubleSeekBarElement)it).onClicked(ClosedRangeUtils.INSTANCE.smartCreate((Comparable)Float.valueOf(currentValue), (Comparable)Float.valueOf(valueMax)));
                                            Unit unit = Unit.INSTANCE;
                                            break;
                                        }
                                        case 2: {
                                            ((DoubleSeekBarElement)it).onClicked(ClosedRangeUtils.INSTANCE.smartCreate((Comparable)Float.valueOf(valueMin), (Comparable)Float.valueOf(currentValue)));
                                            Unit unit = Unit.INSTANCE;
                                            break;
                                        }
                                        default: {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    if (!Mouse.isButtonDown((int)0)) {
                                        ((DoubleSeekBarElement)it).setSelected(null);
                                    }
                                } else {
                                    DarkMeowStyle $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u2417 = $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418;
                                    boolean bl12 = false;
                                    if (Mouse.isButtonDown((int)0)) {
                                        ((DoubleSeekBarElement)it).setSelected((float)mouseX > sliderXA && (float)mouseX < sliderXA + 3.0f ? DoubleSeekBarElement.DoubleSeekBarSelected.MIN : ((float)mouseX > sliderXB && (float)mouseX < sliderXB + 3.0f ? DoubleSeekBarElement.DoubleSeekBarSelected.MAX : null));
                                        $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u2417.resetLastEditSubElement();
                                    }
                                    if (Mouse.isButtonDown((int)1) && !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInputFieldBox)) {
                                        void a2;
                                        boolean isInt = ((DoubleSeekBarElement)it).getIsInt();
                                        float offset = ((DoubleSeekBarElement)it).getOffset();
                                        ClosedRange<Float> currentValue = ((DoubleSeekBarElement)it).getValue();
                                        String string = "Please input new value.";
                                        GuiScreen guiScreen = MinecraftInstance.mc.getCurrentScreen();
                                        MinecraftImpl minecraftImpl = MinecraftInstance.mc;
                                        boolean bl13 = false;
                                        float f3 = ((Number)a2.getStart()).floatValue() + ((DoubleSeekBarElement)it).getOffset();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        boolean bl14 = false;
                                        float it3 = ((Number)a2.getEndInclusive()).floatValue() + ((DoubleSeekBarElement)it).getOffset();
                                        stringBuilder = stringBuilder.append(isInt ? (Number)((int)it3) : (Number)Float.valueOf(it3)).append('|');
                                        boolean bl15 = false;
                                        String string4 = stringBuilder.append(isInt ? (Number)((int)it3) : (Number)Float.valueOf(it3)).toString();
                                        Function1<String, Unit> function1 = arg_0 -> DarkMeowStyle.drawModuleElement$lambda$20$lambda$18$lambda$17$lambda$16(isInt, (Element)it, offset, arg_0);
                                        int n4 = 64;
                                        String string5 = string4;
                                        String string6 = string;
                                        GuiScreen guiScreen3 = guiScreen;
                                        minecraftImpl.displayGuiScreen(new GuiInputFieldBox(guiScreen3, string6, string5, n4, function1));
                                        $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418_u24lambda_u2417.resetLastEditSubElement();
                                    }
                                }
                            }
                            GlStateManager.func_179117_G();
                            $this$drawModuleElement_u24lambda_u2420_u24lambda_u2418.font.func_78276_b(title, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 0xFFFFFF);
                            yPos += 22;
                            continue;
                        }
                        if (var18_18 instanceof TextElement) {
                            int expandWidth;
                            String text;
                            float textWidth;
                            String valueText = ((TextElement)it).getValue();
                            StringBuilder stringBuilder = new StringBuilder().append(((TextElement)it).getTitle()).append("\u00a7f: \u00a7c");
                            String string = ((TextElement)it).getEditingString();
                            if (string == null) {
                                string = valueText;
                            }
                            if (moduleElement.settingsWidth < (textWidth = (float)this.font.func_78256_a(text = stringBuilder.append(string).append(((TextElement)it).getEditingDisplayStatus() > 11 ? "_" : "").toString())) + (float)(expandWidth = it.getExpandWidth())) {
                                moduleElement.settingsWidth = textWidth + (float)expandWidth;
                            }
                            RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 14), Integer.MIN_VALUE);
                            GlStateManager.func_179117_G();
                            this.font.func_78276_b(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 0xFFFFFF);
                            if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && (float)mouseX <= (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth && mouseY >= yPos + 2 && mouseY <= yPos + 14) {
                                if (Mouse.isButtonDown((int)0) && moduleElement.isntPressed()) {
                                    if (!Intrinsics.areEqual(this.lastEditSubElement, it)) {
                                        ((TextElement)it).setEditingString(valueText);
                                    }
                                    Element element2 = this.lastEditSubElement = !Intrinsics.areEqual(this.lastEditSubElement, it) ? it : null;
                                }
                                if (Mouse.isButtonDown((int)1) && !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInputFieldBox)) {
                                    MinecraftInstance.mc.displayGuiScreen(new GuiInputFieldBox(MinecraftInstance.mc.getCurrentScreen(), "Please input new value.", ((TextElement)it).getValue(), 64, arg_0 -> DarkMeowStyle.drawModuleElement$lambda$20$lambda$19((Element)it, arg_0)));
                                    this.resetLastEditSubElement();
                                }
                            }
                            if (((TextElement)it).getEditingString() != null) {
                                if (Intrinsics.areEqual(this.lastEditSubElement, it)) {
                                    ((TextElement)it).setEditingDisplayStatus(((TextElement)it).getEditingDisplayStatus() > 20 ? 0 : ((TextElement)it).getEditingDisplayStatus() + 1);
                                } else {
                                    TextElement textElement = (TextElement)it;
                                    String string7 = ((TextElement)it).getEditingString();
                                    if (string7 == null) {
                                        string7 = "Error";
                                    }
                                    textElement.onClicked(string7);
                                    ((TextElement)it).setEditingString(null);
                                    ((TextElement)it).setEditingDisplayStatus(0);
                                }
                            }
                            yPos += 12;
                            continue;
                        }
                        if (!(var18_18 instanceof RectElement) || ((RectElement)it).getNoDisplayInLast() && index == CollectionsKt.getLastIndex(value.getClickGuiElement()) && Intrinsics.areEqual(CollectionsKt.last(moduleValues), value)) continue;
                        float expandWidth = ((RectElement)it).getExpandWidth();
                        if (moduleElement.settingsWidth < expandWidth) {
                            moduleElement.settingsWidth = expandWidth;
                        }
                        RenderUtils.drawRect((float)(moduleElement.getX() + moduleElement.getWidth() + 4), (float)(yPos + 2), (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, (float)(yPos + 2 + ((RectElement)it).getHeight()), Integer.MIN_VALUE);
                        GlStateManager.func_179117_G();
                        yPos += ((RectElement)it).getHeight();
                    }
                }
                moduleElement.updatePressed();
                this.mouseDown = Mouse.isButtonDown((int)0);
                this.rightMouseDown = Mouse.isButtonDown((int)1);
                if (moduleElement.settingsWidth > 0.0f && yPos > moduleElement.getY() + 4) {
                    RenderUtils.drawBorderedRect(moduleElement.getX() + moduleElement.getWidth() + 4, moduleElement.getY() + 6, (float)(moduleElement.getX() + moduleElement.getWidth()) + moduleElement.settingsWidth, yPos + 2, 1.0f, Integer.MIN_VALUE, 0);
                }
            }
        }
    }

    @Override
    public boolean handleKey(char c2, int keyCode) {
        Element element = this.lastEditSubElement;
        if (element != null) {
            Element lastEdit = element;
            boolean bl2 = false;
            Element element2 = lastEdit;
            if (element2 instanceof TextElement) {
                switch (keyCode) {
                    case 14: {
                        String string;
                        String string2 = ((TextElement)lastEdit).getEditingString();
                        if ((string2 != null ? string2.length() : 0) < 1) break;
                        TextElement textElement = (TextElement)lastEdit;
                        String string3 = ((TextElement)lastEdit).getEditingString();
                        if (string3 != null) {
                            String string4 = string3;
                            int n2 = 0;
                            String string5 = ((TextElement)lastEdit).getEditingString();
                            int n3 = (string5 != null ? string5.length() : 1) - 1;
                            String string6 = string4.substring(n2, n3);
                            string = string6;
                            Intrinsics.checkNotNullExpressionValue(string6, "substring(...)");
                        } else {
                            string = null;
                        }
                        textElement.setEditingString(string);
                        break;
                    }
                    case 1: 
                    case 28: {
                        this.resetLastEditSubElement();
                        break;
                    }
                    default: {
                        Object object;
                        Object object2;
                        Object object3;
                        Character c3;
                        Character c4 = Character.valueOf(c2);
                        char it = c4.charValue();
                        boolean bl3 = false;
                        Character c5 = c3 = !CharsKt.isWhitespace(it) ? c4 : null;
                        if (c3 == null) break;
                        Object object4 = c3;
                        char it2 = ((Character)object4).charValue();
                        boolean bl4 = false;
                        Character c6 = c4 = it2 != '\u0000' ? object4 : null;
                        if (c4 == null || (object4 = c4.toString()) == null) break;
                        Object it3 = object3 = object4;
                        boolean bl5 = false;
                        Object object5 = object2 = !StringsKt.isBlank((CharSequence)it3) ? object3 : null;
                        if (object2 == null) break;
                        Object it4 = object = object2;
                        boolean bl6 = false;
                        Object object6 = object3 = ((CharSequence)it4).length() > 0 ? object : null;
                        if (object3 == null) break;
                        it4 = object = object3;
                        boolean bl7 = false;
                        TextElement textElement = (TextElement)lastEdit;
                        textElement.setEditingString(textElement.getEditingString() + (String)it4);
                        break;
                    }
                }
                return true;
            }
            if (element2 instanceof KeySelectionElement) {
                KeySelectionElement keySelectionElement = (KeySelectionElement)lastEdit;
                String string = Keyboard.getKeyName((int)keyCode);
                Intrinsics.checkNotNullExpressionValue(string, "getKeyName(...)");
                keySelectionElement.onClicked(string);
                this.resetLastEditSubElement();
                return true;
            }
            return false;
        }
        return false;
    }

    private final BigDecimal round(float f2) {
        BigDecimal bd2 = new BigDecimal(String.valueOf(f2));
        BigDecimal bigDecimal = bd2.setScale(2, RoundingMode.valueOf(4));
        Intrinsics.checkNotNullExpressionValue(bigDecimal, "setScale(...)");
        bd2 = bigDecimal;
        return bd2;
    }

    private final void resetLastEditSubElement() {
        this.lastEditSubElement = null;
    }

    private static final Unit drawModuleElement$lambda$20$lambda$7$lambda$6(Element $it, String string) {
        block0: {
            Intrinsics.checkNotNullParameter(string, "new");
            Float f2 = StringsKt.toFloatOrNull(string);
            if (f2 == null) break block0;
            Float f3 = Float.valueOf(f2.floatValue() - ((SingleSeekBarElement)$it).getOffset());
            float newValue = ((Number)f3).floatValue();
            boolean bl2 = false;
            ((SingleSeekBarElement)$it).onClicked(newValue);
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit drawModuleElement$lambda$20$lambda$18$lambda$17$lambda$16(boolean $isInt, Element $it, float $offset, String string) {
        block1: {
            Object object;
            void $this$mapNotNullTo$iv$iv;
            void $this$mapNotNull$iv;
            Intrinsics.checkNotNullParameter(string, "new");
            Object object2 = new String[]{"|"};
            object2 = StringsKt.split$default((CharSequence)string, (String[])object2, false, 0, 6, null);
            boolean $i$f$mapNotNull = false;
            void var7_7 = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                Number it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                String it = (String)element$iv$iv;
                boolean bl3 = false;
                if (($isInt ? (Number)StringsKt.toIntOrNull(it) : (Number)StringsKt.toFloatOrNull(it)) == null) continue;
                it$iv$iv = it$iv$iv;
                boolean bl4 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            Object it = object2 = (List)destination$iv$iv;
            boolean bl5 = false;
            Object object3 = object = it.size() == 2 ? object2 : null;
            if (object == null) break block1;
            Object newValue = object2 = object;
            boolean bl6 = false;
            ((DoubleSeekBarElement)$it).onClicked((ClosedRange<Float>)RangesKt.rangeTo(((Number)newValue.get(0)).floatValue() - $offset, ((Number)newValue.get(1)).floatValue() - $offset));
        }
        return Unit.INSTANCE;
    }

    private static final Unit drawModuleElement$lambda$20$lambda$19(Element $it, String string) {
        Intrinsics.checkNotNullParameter(string, "new");
        ((TextElement)$it).onClicked(string);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[DoubleSeekBarElement.DoubleSeekBarSelected.values().length];
            try {
                nArray[DoubleSeekBarElement.DoubleSeekBarSelected.MIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[DoubleSeekBarElement.DoubleSeekBarSelected.MAX.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

