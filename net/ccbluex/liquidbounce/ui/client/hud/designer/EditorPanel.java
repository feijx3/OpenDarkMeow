/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.ui.client.hud.designer;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.HUDManager;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.impl.ListBodyElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListHeaderElement;
import net.ccbluex.liquidbounce.value.elements.impl.SelectionElement;
import net.ccbluex.liquidbounce.value.elements.impl.SingleSeekBarElement;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\u0018\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010/\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "hudDesigner", "Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;", "x", "", "y", "<init>", "(Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;II)V", "getX", "()I", "setX", "(I)V", "getY", "setY", "font", "Lnet/minecraft/client/gui/FontRenderer;", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "setFont", "(Lnet/minecraft/client/gui/FontRenderer;)V", "value", "width", "getWidth", "height", "getHeight", "realHeight", "getRealHeight", "drag", "", "dragX", "dragY", "mouseDown", "scroll", "create", "getCreate", "()Z", "setCreate", "(Z)V", "currentElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "drawPanel", "", "mouseX", "mouseY", "wheel", "drawCreate", "drawSelection", "drawEditor", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEditorPanel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditorPanel.kt\nnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,438:1\n1869#2,2:439\n1869#2,2:449\n37#3:441\n36#3,3:442\n37#3:445\n36#3,3:446\n*S KotlinDebug\n*F\n+ 1 EditorPanel.kt\nnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel\n*L\n112#1:439,2\n267#1:449,2\n224#1:441\n224#1:442,3\n246#1:445\n246#1:446,3\n*E\n"})
public final class EditorPanel
extends MinecraftInstance {
    @NotNull
    private final GuiHudDesigner hudDesigner;
    private int x;
    private int y;
    @NotNull
    private FontRenderer font;
    private int width;
    private int height;
    private int realHeight;
    private boolean drag;
    private int dragX;
    private int dragY;
    private boolean mouseDown;
    private int scroll;
    private boolean create;
    @Nullable
    private Element currentElement;

    public EditorPanel(@NotNull GuiHudDesigner hudDesigner, int x2, int y2) {
        Intrinsics.checkNotNullParameter((Object)hudDesigner, "hudDesigner");
        this.hudDesigner = hudDesigner;
        this.x = x2;
        this.y = y2;
        this.font = DarkMeow.INSTANCE.getClickGuiManager().getClickGuiFont();
        this.width = 80;
        this.height = 20;
        this.realHeight = 20;
    }

    public final int getX() {
        return this.x;
    }

    public final void setX(int n2) {
        this.x = n2;
    }

    public final int getY() {
        return this.y;
    }

    public final void setY(int n2) {
        this.y = n2;
    }

    @NotNull
    public final FontRenderer getFont() {
        return this.font;
    }

    public final void setFont(@NotNull FontRenderer fontRenderer) {
        Intrinsics.checkNotNullParameter(fontRenderer, "<set-?>");
        this.font = fontRenderer;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getRealHeight() {
        return this.realHeight;
    }

    public final boolean getCreate() {
        return this.create;
    }

    public final void setCreate(boolean bl2) {
        this.create = bl2;
    }

    public final void drawPanel(int mouseX, int mouseY, int wheel) {
        boolean shouldScroll;
        this.drag(mouseX, mouseY);
        if (!Intrinsics.areEqual(this.currentElement, this.hudDesigner.getSelectedElement())) {
            this.scroll = 0;
        }
        this.currentElement = this.hudDesigner.getSelectedElement();
        int currMouseY = mouseY;
        boolean bl2 = shouldScroll = this.realHeight > 200;
        if (shouldScroll) {
            GL11.glPushMatrix();
            RenderUtils.makeScissorBox(this.x, (float)this.y + 1.0f, (float)this.x + (float)this.width, (float)this.y + 200.0f);
            GL11.glEnable((int)3089);
            if (this.y + 200 < currMouseY) {
                currMouseY = -1;
            }
            if (mouseX >= this.x && mouseX <= this.x + this.width && currMouseY >= this.y && currMouseY <= this.y + 200 && Mouse.hasWheel()) {
                if (wheel < 0 && -this.scroll + 205 <= this.realHeight) {
                    this.scroll -= 12;
                } else if (wheel > 0) {
                    this.scroll += 12;
                    if (this.scroll > 0) {
                        this.scroll = 0;
                    }
                }
            }
        }
        RenderUtils.drawRect(this.x, this.y + 12, this.x + this.width, this.y + this.realHeight, new Color(27, 34, 40, 120).getRGB());
        if (this.create) {
            this.drawCreate(mouseX, currMouseY);
        } else if (this.currentElement != null) {
            this.drawEditor(mouseX, currMouseY);
        } else {
            this.drawSelection(mouseX, currMouseY);
        }
        if (shouldScroll) {
            RenderUtils.drawRect(this.x + this.width - 5, this.y + 15, this.x + this.width - 2, this.y + 197, new Color(41, 41, 41).getRGB());
            float v2 = (float)197 * ((float)(-this.scroll) / ((float)this.realHeight - 170.0f));
            RenderUtils.drawRect((float)(this.x + this.width) - 5.0f, (float)(this.y + 15) + v2, (float)(this.x + this.width) - 2.0f, (float)(this.y + 20) + v2, new Color(37, 126, 255).getRGB());
            GL11.glDisable((int)3089);
            GL11.glPopMatrix();
        }
        this.mouseDown = Mouse.isButtonDown((int)0);
    }

    private final void drawCreate(int mouseX, int mouseY) {
        this.height = 15 + this.scroll;
        this.realHeight = 15;
        this.width = 90;
        Set<Map.Entry<String, Class<? extends Element>>> set = DarkMeow.INSTANCE.getHudManager().getElementsBase().entrySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
        Iterable $this$forEach$iv = set;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry entry = (Map.Entry)element$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(entry);
            Object k2 = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(k2, "component1(...)");
            String name = (String)k2;
            Object v2 = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(v2, "component2(...)");
            Class element = (Class)v2;
            this.font.func_175065_a(name, (float)this.x + 2.0f, (float)(this.y + this.height), Color.WHITE.getRGB(), false);
            int stringWidth = this.font.func_78256_a(name);
            if (this.width < stringWidth + 8) {
                this.width = stringWidth + 8;
            }
            if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
                try {
                    Element newElement = (Element)element.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newElement.createElement()) {
                        HUDManager hUDManager = DarkMeow.INSTANCE.getHudManager();
                        Intrinsics.checkNotNull(newElement);
                        hUDManager.addElement(newElement);
                    }
                }
                catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
                catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
                this.create = false;
            }
            this.height += 10;
            this.realHeight += 10;
        }
        RenderUtils.drawRect(this.x, this.y, this.x + this.width, this.y + 12, ColorValue.getColor$default(DarkMeow.INSTANCE.getClickGuiManager().getConfig().getColorFontValue(), null, 1, null).getRGB());
        this.font.func_175065_a("\u00a7lCreate element", (float)this.x + 2.0f, (float)this.y + 3.5f, Color.WHITE.getRGB(), false);
    }

    private final void drawSelection(int mouseX, int mouseY) {
        this.height = 15 + this.scroll;
        this.realHeight = 15;
        this.width = 120;
        this.font.func_175065_a("\u00a7lCreate element", (float)this.x + 2.0f, (float)this.y + (float)this.height, Color.WHITE.getRGB(), false);
        if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
            this.create = true;
        }
        this.height += 10;
        this.realHeight += 10;
        this.font.func_175065_a("\u00a7lReset", (float)this.x + 2.0f, (float)this.y + (float)this.height, Color.WHITE.getRGB(), false);
        if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
            DarkMeow.INSTANCE.getHudManager().createDefault();
        }
        this.height += 15;
        this.realHeight += 15;
        this.font.func_175065_a("\u00a7lAvailable Elements", (float)this.x + 2.0f, (float)this.y + (float)this.height, Color.WHITE.getRGB(), false);
        this.height += 10;
        this.realHeight += 10;
        for (Element element : DarkMeow.INSTANCE.getHudManager().getElements()) {
            this.font.func_78276_b(element.getName(), this.x + 2, this.y + this.height, Color.WHITE.getRGB());
            int stringWidth = this.font.func_78256_a(element.getName());
            if (this.width < stringWidth + 8) {
                this.width = stringWidth + 8;
            }
            if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
                this.hudDesigner.setSelectedElement(element);
            }
            this.height += 10;
            this.realHeight += 10;
        }
        RenderUtils.drawRect(this.x, this.y, this.x + this.width, this.y + 12, ColorValue.getColor$default(DarkMeow.INSTANCE.getClickGuiManager().getConfig().getColorFontValue(), null, 1, null).getRGB());
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.font.func_175065_a("\u00a7lEditor", (float)this.x + 2.0f, (float)this.y + 3.5f, Color.WHITE.getRGB(), false);
    }

    private final void drawEditor(int mouseX, int mouseY) {
        Object values;
        Collection thisCollection$iv;
        this.height = this.scroll + 15;
        this.realHeight = 15;
        int prevWidth = this.width;
        this.width = 100;
        Element element = this.currentElement;
        if (element == null) {
            return;
        }
        Element element2 = element;
        StringBuilder stringBuilder = new StringBuilder().append("X: ");
        String string = "%.2f";
        Object[] objectArray2 = new Object[]{element2.getRenderX()};
        objectArray2 = objectArray2;
        String string2 = String.format(string, Arrays.copyOf(objectArray2, objectArray2.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        StringBuilder stringBuilder2 = stringBuilder.append(string2).append(" (");
        string = "%.2f";
        Object[] objectArray4 = new Object[]{element2.getX()};
        objectArray4 = objectArray4;
        String string3 = String.format(string, Arrays.copyOf(objectArray4, objectArray4.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(...)");
        this.font.func_78276_b(stringBuilder2.append(string3).append(')').toString(), this.x + 2, this.y + this.height, Color.WHITE.getRGB());
        this.height += 10;
        this.realHeight += 10;
        StringBuilder stringBuilder3 = new StringBuilder().append("Y: ");
        string = "%.2f";
        Object[] objectArray6 = new Object[]{element2.getRenderY()};
        objectArray6 = objectArray6;
        String string4 = String.format(string, Arrays.copyOf(objectArray6, objectArray6.length));
        Intrinsics.checkNotNullExpressionValue(string4, "format(...)");
        StringBuilder stringBuilder4 = stringBuilder3.append(string4).append(" (");
        string = "%.2f";
        Object[] objectArray8 = new Object[]{element2.getY()};
        objectArray8 = objectArray8;
        String string5 = String.format(string, Arrays.copyOf(objectArray8, objectArray8.length));
        Intrinsics.checkNotNullExpressionValue(string5, "format(...)");
        this.font.func_78276_b(stringBuilder4.append(string5).append(')').toString(), this.x + 2, this.y + this.height, Color.WHITE.getRGB());
        this.height += 10;
        this.realHeight += 10;
        StringBuilder stringBuilder5 = new StringBuilder().append("Scale: ");
        string = "%.2f";
        Object[] objectArray10 = new Object[]{Float.valueOf(element2.getScale())};
        objectArray10 = objectArray10;
        String string6 = String.format(string, Arrays.copyOf(objectArray10, objectArray10.length));
        Intrinsics.checkNotNullExpressionValue(string6, "format(...)");
        this.font.func_78276_b(stringBuilder5.append(string6).toString(), this.x + 2, this.y + this.height, Color.WHITE.getRGB());
        this.height += 10;
        this.realHeight += 10;
        this.font.func_78276_b("H:", this.x + 2, this.y + this.height, Color.WHITE.getRGB());
        this.font.func_78276_b(element2.getSide().getHorizontal().getSideName(), this.x + 12, this.y + this.height, Color.GRAY.getRGB());
        if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
            double d2;
            Collection collection = ElementSide.Horizontal.getEntries();
            boolean $i$f$toTypedArray = false;
            thisCollection$iv = collection;
            values = thisCollection$iv.toArray(new ElementSide.Horizontal[0]);
            int n2 = ArraysKt.indexOf(values, element2.getSide().getHorizontal());
            double x2 = element2.getRenderX();
            element2.getSide().setHorizontal(values[n2 + 1 >= ((ElementSide.Horizontal[])values).length ? 0 : n2 + 1]);
            switch (WhenMappings.$EnumSwitchMapping$0[element2.getSide().getHorizontal().ordinal()]) {
                case 1: {
                    d2 = x2;
                    break;
                }
                case 2: {
                    d2 = (double)(new ScaledResolution(MinecraftInstance.mc_nowarp).func_78326_a() / 2) - x2;
                    break;
                }
                case 3: {
                    d2 = (double)new ScaledResolution(MinecraftInstance.mc_nowarp).func_78326_a() - x2;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            element2.setX(d2);
        }
        this.height += 10;
        this.realHeight += 10;
        this.font.func_78276_b("V:", this.x + 2, this.y + this.height, Color.WHITE.getRGB());
        this.font.func_78276_b(element2.getSide().getVertical().getSideName(), this.x + 12, this.y + this.height, Color.GRAY.getRGB());
        if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
            double d3;
            Collection collection = ElementSide.Vertical.getEntries();
            boolean $i$f$toTypedArray = false;
            thisCollection$iv = collection;
            values = thisCollection$iv.toArray(new ElementSide.Vertical[0]);
            int n3 = ArraysKt.indexOf(values, element2.getSide().getVertical());
            double y2 = element2.getRenderY();
            element2.getSide().setVertical((ElementSide.Vertical)((Object)values[n3 + 1 >= ((Object)values).length ? 0 : n3 + 1]));
            switch (WhenMappings.$EnumSwitchMapping$1[element2.getSide().getVertical().ordinal()]) {
                case 1: {
                    d3 = y2;
                    break;
                }
                case 2: {
                    d3 = (double)(new ScaledResolution(MinecraftInstance.mc_nowarp).func_78328_b() / 2) - y2;
                    break;
                }
                case 3: {
                    d3 = (double)new ScaledResolution(MinecraftInstance.mc_nowarp).func_78328_b() - y2;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            element2.setY(d3);
        }
        this.height += 10;
        this.realHeight += 10;
        for (Value value : element2.getValues()) {
            if (!value.getDisplayable()) continue;
            Iterable $this$forEach$iv = value.getClickGuiElement();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                net.ccbluex.liquidbounce.value.elements.Element it = (net.ccbluex.liquidbounce.value.elements.Element)element$iv;
                boolean bl2 = false;
                if (!it.isDisplayable()) continue;
                net.ccbluex.liquidbounce.value.elements.Element element3 = it;
                if (element3 instanceof SelectionElement) {
                    String title = ((SelectionElement)it).getTitle();
                    boolean isActive = ((SelectionElement)it).getIsActive();
                    GlStateManager.func_179117_G();
                    this.font.func_78276_b(title, this.x + 2, this.y + this.height, isActive ? Color.WHITE.getRGB() : Color.GRAY.getRGB());
                    int stringWidth = this.font.func_78256_a(value.getName());
                    if (this.width < stringWidth + 8) {
                        this.width = stringWidth + 8;
                    }
                    if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
                        ((SelectionElement)it).onClicked(isActive);
                    }
                    this.height += 10;
                    this.realHeight += 10;
                    continue;
                }
                if (element3 instanceof ListHeaderElement) {
                    Color color;
                    int expandWidth;
                    String title = ((ListHeaderElement)it).getTitle();
                    int stringWidth = this.font.func_78256_a(title);
                    if (this.width < stringWidth + (expandWidth = it.getExpandWidth())) {
                        this.width = stringWidth + expandWidth;
                    }
                    if ((color = ((ListHeaderElement)it).getDisplayColor()) != null) {
                        GlStateManager.func_179117_G();
                        RenderUtils.drawRect((float)(this.x + this.width) - 12.0f, (float)(this.y + this.height), (float)(this.x + this.width) - 8.0f, (float)(this.y + this.height) - 4.0f, color);
                    }
                    GlStateManager.func_179117_G();
                    this.font.func_78276_b(title, this.x + 2, this.y + this.height, Color.WHITE.getRGB());
                    boolean isOpenList = ((ListHeaderElement)it).isOpenList();
                    GlStateManager.func_179117_G();
                    this.font.func_78276_b(isOpenList ? "-" : "+", this.x + this.width - (isOpenList ? 5 : 6), this.y + this.height, 0xFFFFFF);
                    if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
                        ((ListHeaderElement)it).onClicked(isOpenList);
                    }
                    this.height += 10;
                    this.realHeight += 10;
                    continue;
                }
                if (element3 instanceof ListBodyElement) {
                    String selected = ((ListBodyElement)it).getSelected();
                    for (String s2 : ((ListBodyElement)it).getList()) {
                        GlStateManager.func_179117_G();
                        String text = "\u00a7c> \u00a7r" + s2;
                        this.font.func_78276_b(text, this.x + 2, this.y + this.height, Intrinsics.areEqual(s2, selected) ? Color.WHITE.getRGB() : Color.GRAY.getRGB());
                        int stringWidth = this.font.func_78256_a(text);
                        if (this.width < stringWidth + 8) {
                            this.width = stringWidth + 8;
                        }
                        if (Mouse.isButtonDown((int)0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= this.y + this.height + 10) {
                            ((ListBodyElement)it).onClicked(s2);
                        }
                        this.height += 10;
                        this.realHeight += 10;
                    }
                    continue;
                }
                if (!(element3 instanceof SingleSeekBarElement)) continue;
                float current = ((SingleSeekBarElement)it).getValue();
                float max = ((SingleSeekBarElement)it).getLength();
                String title = ((SingleSeekBarElement)it).getTitle();
                GlStateManager.func_179117_G();
                this.font.func_78276_b(title, this.x + 2, this.y + this.height, Color.WHITE.getRGB());
                int stringWidth = this.font.func_78256_a(title);
                if (this.width < stringWidth + 8) {
                    this.width = stringWidth + 8;
                }
                RenderUtils.drawRect((float)this.x + 8.0f, (float)(this.y + this.height) + 12.0f, (float)(this.x + prevWidth) - 8.0f, (float)(this.y + this.height) + 13.0f, Color.WHITE);
                float sliderValue = (float)this.x + ((float)prevWidth - 18.0f) * current / max;
                RenderUtils.drawRect(8.0f + sliderValue, (float)(this.y + this.height) + 9.0f, sliderValue + 11.0f, (float)(this.y + this.height) + 15.0f, new Color(37, 126, 255).getRGB());
                if (mouseX >= this.x + 8 && mouseX <= this.x + prevWidth && mouseY >= this.y + this.height + 9 && mouseY <= this.y + this.height + 15 && Mouse.isButtonDown((int)0)) {
                    float curr = MathHelper.func_76131_a((float)(((float)(mouseX - this.x) - 8.0f) / ((float)prevWidth - 18.0f)), (float)0.0f, (float)1.0f);
                    ((SingleSeekBarElement)it).onClicked(max * curr);
                }
                this.height += 20;
                this.realHeight += 20;
            }
        }
        RenderUtils.drawRect(this.x, this.y, this.x + this.width, this.y + 12, ColorValue.getColor$default(DarkMeow.INSTANCE.getClickGuiManager().getConfig().getColorFontValue(), null, 1, null).getRGB());
        this.font.func_175065_a("\u00a7l" + element2.getName(), (float)this.x + 2.0f, (float)this.y + 3.5f, Color.WHITE.getRGB(), false);
        float deleteWidth = (float)(this.x + this.width - this.font.func_78256_a("\u00a7lDelete")) - 2.0f;
        GlStateManager.func_179117_G();
        this.font.func_175065_a("\u00a7lDelete", deleteWidth, (float)this.y + 3.5f, Color.WHITE.getRGB(), false);
        if (Mouse.isButtonDown((int)0) && !this.mouseDown && (float)mouseX >= deleteWidth && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + 10) {
            DarkMeow.INSTANCE.getHudManager().removeElement(element2);
        }
    }

    private final void drag(int mouseX, int mouseY) {
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + 12 && Mouse.isButtonDown((int)0) && !this.mouseDown) {
            this.drag = true;
            this.dragX = mouseX - this.x;
            this.dragY = mouseY - this.y;
        }
        if (Mouse.isButtonDown((int)0) && this.drag) {
            this.x = mouseX - this.dragX;
            this.y = mouseY - this.dragY;
        } else {
            this.drag = false;
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[ElementSide.Horizontal.values().length];
            try {
                nArray[ElementSide.Horizontal.LEFT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Horizontal.MIDDLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Horizontal.RIGHT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[ElementSide.Vertical.values().length];
            try {
                nArray[ElementSide.Vertical.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Vertical.MIDDLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Vertical.DOWN.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

