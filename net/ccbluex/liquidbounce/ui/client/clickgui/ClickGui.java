/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.ui.client.clickgui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.manager.ClickGuiManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.ccbluex.liquidbounce.utils.render.EaseUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0016J \u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0016J \u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013H\u0014J\u000e\u0010/\u001a\n 1*\u0004\u0018\u00010000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;", "Lnet/minecraft/client/gui/GuiScreen;", "manager", "Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "<init>", "(Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;)V", "panels", "", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/Panel;", "getPanels", "()Ljava/util/List;", "style", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;", "getStyle", "()Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;", "setStyle", "(Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;)V", "clickedPanel", "mouseX", "", "mouseY", "scroll", "slide", "", "lastMS", "", "progress", "setup", "", "initGui", "drawScreen", "initialMouseX", "initialMouseY", "partialTicks", "", "mouseClicked", "mouseButton", "mouseReleased", "state", "updateScreen", "onGuiClosed", "doesGuiPauseGame", "", "keyTyped", "typedChar", "", "keyCode", "drawBackground", "Lnet/minecraft/client/gui/ScaledResolution;", "kotlin.jvm.PlatformType", "DarkMeow"})
public final class ClickGui
extends GuiScreen {
    @NotNull
    private final ClickGuiManager manager;
    @NotNull
    private final List<Panel> panels;
    @Nullable
    private Style style;
    @Nullable
    private Panel clickedPanel;
    private int mouseX;
    private int mouseY;
    private int scroll;
    private double slide;
    private long lastMS;
    private double progress;

    public ClickGui(@NotNull ClickGuiManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.panels = new ArrayList();
    }

    @NotNull
    public final List<Panel> getPanels() {
        return this.panels;
    }

    @Nullable
    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(@Nullable Style style) {
        this.style = style;
    }

    public final void setup() {
        int width = 100;
        int height = 18;
        Ref.IntRef yPos = new Ref.IntRef();
        yPos.element = 5;
        this.panels.clear();
        for (ModuleCategory category : ModuleCategory.getEntries()) {
            ClickGuiManager clickGuiManager = this.manager;
            String string = category.getDisplayName();
            this.panels.add(new Panel(yPos, width, height, category, clickGuiManager, string){
                final /* synthetic */ ModuleCategory $category;
                {
                    this.$category = $category;
                    super($super_call_param$1, $super_call_param$2, 100, $yPos.element, $width, $height, false);
                }

                public void setupItems() {
                    Iterator<Module> iterator2 = DarkMeow.INSTANCE.getModuleManager().getModules().iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
                    Iterator<Module> iterator3 = iterator2;
                    while (iterator3.hasNext()) {
                        Module module;
                        Intrinsics.checkNotNullExpressionValue(iterator3.next(), "next(...)");
                        if (module.getCategory() != this.$category) continue;
                        this.elements.add(new ModuleElement(module));
                    }
                }
            });
            yPos.element += 20;
        }
    }

    public void func_73866_w_() {
        block1: {
            this.lastMS = System.currentTimeMillis();
            this.slide = this.progress = 0.0;
            if (((Boolean)this.manager.getConfig().getScrollResetOnClickGuiOpenValue().get()).booleanValue() || !((Boolean)this.manager.getConfig().getScrollValue().get()).booleanValue()) {
                this.scroll = 0;
            }
            super.func_73866_w_();
            Style style = this.style;
            if (style == null) break block1;
            style.onGuiInit();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void func_73863_a(int initialMouseX, int initialMouseY, float partialTicks) {
        block59: {
            block57: {
                block58: {
                    block54: {
                        mouseX = 0;
                        mouseX = initialMouseX;
                        mouseY = 0;
                        mouseY = initialMouseY;
                        this.style = this.manager.getStyles().get(this.manager.getConfig().getStyleValue().get());
                        GlStateManager.func_179094_E();
                        v0 = this.style;
                        if (v0 != null) {
                            v0.drawStart();
                        }
                        this.drawBackground();
                        if (!((Boolean)this.manager.getConfig().getAnimationValue().get()).booleanValue()) break block54;
                        this.progress = this.progress < 1.0 ? (double)(System.currentTimeMillis() - this.lastMS) / (double)((Number)this.manager.getConfig().getAnimationSpeedValue().get()).intValue() : 1.0;
                        var6_6 = (String)this.manager.getConfig().getAnimationModeValue().get();
                        tmp = -1;
                        switch (var6_6.hashCode()) {
                            case 857372763: {
                                if (var6_6.equals("ZoomBounce")) {
                                    tmp = 1;
                                }
                                break;
                            }
                            case 79973777: {
                                if (var6_6.equals("Slide")) {
                                    tmp = 2;
                                }
                                break;
                            }
                            case 63779435: {
                                if (var6_6.equals("Azura")) {
                                    tmp = 2;
                                }
                                break;
                            }
                            case 250675065: {
                                if (var6_6.equals("SlideBounce")) {
                                    tmp = 1;
                                }
                                break;
                            }
                            case 2791411: {
                                if (var6_6.equals("Zoom")) {
                                    tmp = 2;
                                }
                                break;
                            }
                            case 2433880: {
                                if (var6_6.equals("None")) {
                                    tmp = 3;
                                }
                                break;
                            }
                        }
                        switch (tmp) {
                            case 1: {
                                this.slide = EaseUtils.easeOutBack(this.progress);
                                break;
                            }
                            case 2: {
                                this.slide = EaseUtils.easeOutQuart(this.progress);
                                break;
                            }
                            case 3: {
                                this.slide = 1.0;
                            }
                        }
                    }
                    scale = ((Number)this.manager.getConfig().getScaleValue().get()).floatValue();
                    GlStateManager.func_179109_b((float)0.0f, (float)this.scroll, (float)0.0f);
                    mouseY -= this.scroll;
                    mouseX = (int)((double)mouseX / scale);
                    mouseY = (int)((double)mouseY / scale);
                    this.mouseX = mouseX;
                    this.mouseY = mouseY;
                    var8_8 = (Boolean)this.manager.getConfig().getAnimationValue().get() != false ? (String)this.manager.getConfig().getAnimationModeValue().get() : "None";
                    tmp = -1;
                    switch (var8_8.hashCode()) {
                        case 857372763: {
                            if (var8_8.equals("ZoomBounce")) {
                                tmp = 1;
                            }
                            break;
                        }
                        case 79973777: {
                            if (var8_8.equals("Slide")) {
                                tmp = 2;
                            }
                            break;
                        }
                        case 63779435: {
                            if (var8_8.equals("Azura")) {
                                tmp = 3;
                            }
                            break;
                        }
                        case 250675065: {
                            if (var8_8.equals("SlideBounce")) {
                                tmp = 2;
                            }
                            break;
                        }
                        case 2791411: {
                            if (var8_8.equals("Zoom")) {
                                tmp = 4;
                            }
                            break;
                        }
                        case 2433880: {
                            if (var8_8.equals("None")) {
                                tmp = 5;
                            }
                            break;
                        }
                    }
                    switch (tmp) {
                        case 3: {
                            GlStateManager.func_179137_b((double)0.0, (double)((1.0 - this.slide) * (double)this.field_146295_m * 2.0), (double)0.0);
                            GlStateManager.func_179139_a((double)scale, (double)(scale + (1.0 - this.slide) * 2.0), (double)scale);
                            break;
                        }
                        case 2: {
                            GlStateManager.func_179137_b((double)0.0, (double)((1.0 - this.slide) * (double)this.field_146295_m * 2.0), (double)0.0);
                            GlStateManager.func_179139_a((double)scale, (double)scale, (double)scale);
                            break;
                        }
                        case 4: {
                            GlStateManager.func_179137_b((double)((1.0 - this.slide) * ((double)this.field_146294_l / 2.0)), (double)((1.0 - this.slide) * ((double)this.field_146295_m / 2.0)), (double)((1.0 - this.slide) * ((double)this.field_146294_l / 2.0)));
                            GlStateManager.func_179139_a((double)(scale * this.slide), (double)(scale * this.slide), (double)(scale * this.slide));
                            break;
                        }
                        case 1: {
                            GlStateManager.func_179137_b((double)((1.0 - this.slide) * ((double)this.field_146294_l / 2.0)), (double)((1.0 - this.slide) * ((double)this.field_146295_m / 2.0)), (double)0.0);
                            GlStateManager.func_179139_a((double)(scale * this.slide), (double)(scale * this.slide), (double)(scale * this.slide));
                            break;
                        }
                        case 5: {
                            GlStateManager.func_179139_a((double)scale, (double)scale, (double)scale);
                        }
                    }
                    for (Panel panel : this.panels) {
                        panel.updateFade(RenderUtils.deltaTime);
                        panel.drawScreen(mouseX, mouseY, partialTicks);
                    }
                    for (Panel panel : this.panels) {
                        for (Element element : panel.elements) {
                            if (!(element instanceof ModuleElement)) continue;
                            moduleElement = element;
                            if (mouseX == 0 || mouseY == 0 || !((ModuleElement)moduleElement).isHovering(mouseX, mouseY) || !moduleElement.isVisible() || !((float)element.getY() <= (float)panel.y + panel.getFade())) continue;
                            v1 = this.style;
                            if (v1 == null) continue;
                            v1.drawDescription(mouseX, mouseY, ((ModuleElement)moduleElement).getDescription());
                        }
                    }
                    GlStateManager.func_179140_f();
                    RenderHelper.func_74518_a();
                    GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
                    if (!((Boolean)this.manager.getConfig().getScrollValue().get()).booleanValue()) break block57;
                    guiWheel = null;
                    if (!((Boolean)this.manager.getConfig().getScrollUseMouseWheelValue().get()).booleanValue()) break block58;
                    $this$drawScreen_u24lambda_u240 = this;
                    $i$a$-run-ClickGui$drawScreen$1 = false;
                    if (!Mouse.hasWheel()) break block58;
                    wheel = Mouse.getDWheel();
                    var13_18 = ((Collection)$this$drawScreen_u24lambda_u240.panels).size() + -1;
                    if (0 > var13_18) ** GOTO lbl148
                    while (!$this$drawScreen_u24lambda_u240.panels.get(i = var13_18--).handleScroll(mouseX, mouseY, wheel)) {
                        if (0 <= var13_18) continue;
lbl148:
                        // 2 sources

                        guiWheel = wheel == 0 ? null : Boolean.valueOf(wheel < 0);
                        break;
                    }
                }
                if (((Boolean)this.manager.getConfig().getScrollUseKeyValue().get()).booleanValue()) {
                    upKeyDown = Keyboard.isKeyDown((int)200);
                    downKeyDown = Keyboard.isKeyDown((int)208);
                    if (!upKeyDown || !downKeyDown) {
                        if (upKeyDown) {
                            guiWheel = false;
                        }
                        if (downKeyDown) {
                            guiWheel = true;
                        }
                    }
                }
                if (Intrinsics.areEqual(var9_11 = guiWheel, true)) {
                    this.scroll -= ((Number)this.manager.getConfig().getScrollSpeedValue().get()).intValue();
                } else if (Intrinsics.areEqual(var9_11, false)) {
                    this.scroll = this.scroll + ((Number)this.manager.getConfig().getScrollSpeedValue().get()).intValue() >= 0 ? 0 : (this.scroll += ((Number)this.manager.getConfig().getScrollSpeedValue().get()).intValue());
                } else if (var9_11 != null) {
                    throw new NoWhenBranchMatchedException();
                }
                break block59;
            }
            this.scroll = 0;
        }
        GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179121_F();
    }

    public void func_73864_a(int initialMouseX, int initialMouseY, int mouseButton) throws IOException {
        int mouseX = initialMouseX;
        int mouseY = initialMouseY;
        float scale = ((Number)this.manager.getConfig().getScaleValue().get()).floatValue();
        mouseY -= this.scroll;
        mouseX = (int)((float)mouseX / scale);
        mouseY = (int)((float)mouseY / scale);
        for (Panel panel : this.panels) {
            panel.mouseClicked(mouseX, mouseY, mouseButton);
            panel.setDrag(false);
            if (mouseButton != 0 || !panel.isHovering(mouseX, mouseY)) continue;
            this.clickedPanel = panel;
        }
        if (this.clickedPanel != null) {
            Panel panel = this.clickedPanel;
            Intrinsics.checkNotNull(panel);
            Panel panel2 = this.clickedPanel;
            Intrinsics.checkNotNull(panel2);
            panel.setX2(panel2.x - mouseX);
            Panel panel3 = this.clickedPanel;
            Intrinsics.checkNotNull(panel3);
            Panel panel4 = this.clickedPanel;
            Intrinsics.checkNotNull(panel4);
            panel3.setY2(panel4.y - mouseY);
            Panel panel5 = this.clickedPanel;
            Intrinsics.checkNotNull(panel5);
            panel5.setDrag(true);
            Collection collection = this.panels;
            Panel panel6 = this.clickedPanel;
            TypeIntrinsics.asMutableCollection(collection).remove(panel6);
            Panel panel7 = this.clickedPanel;
            Intrinsics.checkNotNull(panel7);
            this.panels.add(panel7);
            this.clickedPanel = null;
        }
        super.func_73864_a(mouseX, mouseY, mouseButton);
    }

    public void func_146286_b(int initialMouseX, int initialMouseY, int state) {
        int mouseX = initialMouseX;
        int mouseY = initialMouseY;
        float scale = ((Number)this.manager.getConfig().getScaleValue().get()).floatValue();
        mouseY -= this.scroll;
        mouseX = (int)((float)mouseX / scale);
        mouseY = (int)((float)mouseY / scale);
        for (Panel panel : this.panels) {
            panel.mouseReleased(mouseX, mouseY, state);
        }
    }

    public void func_73876_c() {
        for (Panel panel : this.panels) {
            for (Element element : panel.elements) {
                ButtonElement buttonElement;
                if (element instanceof ButtonElement) {
                    int n2;
                    if (((ButtonElement)element).isHovering(this.mouseX, this.mouseY)) {
                        if (((ButtonElement)element).getHoverTime() < 7) {
                            buttonElement = (ButtonElement)element;
                            n2 = buttonElement.getHoverTime();
                            buttonElement.setHoverTime(n2 + 1);
                        }
                    } else if (((ButtonElement)element).getHoverTime() > 0) {
                        buttonElement = (ButtonElement)element;
                        n2 = buttonElement.getHoverTime();
                        buttonElement.setHoverTime(n2 + -1);
                    }
                }
                if (!(element instanceof ModuleElement)) continue;
                if (((ModuleElement)element).module.getState()) {
                    if (((ModuleElement)element).slowlyFade < 255) {
                        buttonElement = (ModuleElement)element;
                        ((ModuleElement)buttonElement).slowlyFade += 20;
                    }
                } else if (((ModuleElement)element).slowlyFade > 0) {
                    buttonElement = (ModuleElement)element;
                    ((ModuleElement)buttonElement).slowlyFade -= 20;
                }
                if (((ModuleElement)element).slowlyFade > 255) {
                    ((ModuleElement)element).slowlyFade = 255;
                }
                if (((ModuleElement)element).slowlyFade >= 0) continue;
                ((ModuleElement)element).slowlyFade = 0;
            }
        }
        super.func_73876_c();
    }

    public void func_146281_b() {
        Style style = this.style;
        if (style != null) {
            style.onGuiClose();
        }
        DarkMeow.INSTANCE.getFileManager().saveConfig(DarkMeow.INSTANCE.getFileManager().getClickGuiConfig());
    }

    public boolean func_73868_f() {
        return false;
    }

    protected void func_73869_a(char typedChar, int keyCode) {
        Style style = this.style;
        boolean bl2 = style != null ? style.handleKey(typedChar, keyCode) : false;
        if (bl2) {
            return;
        }
        if (1 == keyCode && this.manager.getLastGui() != null) {
            this.field_146297_k.func_147108_a(this.manager.getLastGui());
            this.manager.setLastGui(null);
            return;
        }
        super.func_73869_a(typedChar, keyCode);
    }

    public final ScaledResolution drawBackground() {
        ScaledResolution scaledResolution;
        block3: {
            Object object;
            block2: {
                WorldClient worldClient;
                ScaledResolution sr = scaledResolution = StaticStorage.scaledResolution;
                boolean bl2 = false;
                GlStateManager.func_179140_f();
                GlStateManager.func_179106_n();
                object = this.field_146297_k.field_71441_e;
                if (object == null) break block2;
                WorldClient it = worldClient = object;
                boolean bl3 = false;
                RenderUtils.drawRect(0, 0, sr.func_78326_a(), sr.func_78328_b() - this.scroll, ColorValue.getColor$default(DarkMeow.INSTANCE.getClickGuiManager().getConfig().getColorBackgroundValue(), null, 1, null).getRGB());
                object = worldClient;
                if (object != null) break block3;
            }
            ClickGui $this$drawBackground_u24lambda_u243_u24lambda_u242 = this;
            boolean bl4 = false;
            $this$drawBackground_u24lambda_u243_u24lambda_u242.func_146276_q_();
            object = Unit.INSTANCE;
        }
        return scaledResolution;
    }
}

