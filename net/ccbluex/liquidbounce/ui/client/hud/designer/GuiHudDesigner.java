/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.ui.client.hud.designer;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.config.ConfigManager;
import net.ccbluex.liquidbounce.ui.client.hud.HUDManager;
import net.ccbluex.liquidbounce.ui.client.hud.designer.EditorPanel;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0014J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0014J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;", "Lnet/minecraft/client/gui/GuiScreen;", "<init>", "()V", "editorPanel", "Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;", "selectedElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "getSelectedElement", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "setSelectedElement", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)V", "buttonAction", "", "initGui", "", "doesGuiPauseGame", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "mouseClicked", "mouseButton", "mouseReleased", "state", "onGuiClosed", "keyTyped", "typedChar", "", "keyCode", "DarkMeow"})
public final class GuiHudDesigner
extends GuiScreen {
    @NotNull
    private EditorPanel editorPanel = new EditorPanel(this, 2, 2);
    @Nullable
    private Element selectedElement;
    private boolean buttonAction;

    @Nullable
    public final Element getSelectedElement() {
        return this.selectedElement;
    }

    public final void setSelectedElement(@Nullable Element element) {
        this.selectedElement = element;
    }

    public void func_73866_w_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.editorPanel = new EditorPanel(this, this.field_146294_l / 2, this.field_146295_m / 2);
    }

    public boolean func_73868_f() {
        return false;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        DarkMeow.INSTANCE.getHudManager().render(partialTicks, true);
        DarkMeow.INSTANCE.getHudManager().handleMouseMove(mouseX, mouseY);
        if (!CollectionsKt.contains((Iterable)DarkMeow.INSTANCE.getHudManager().getElements(), this.selectedElement)) {
            this.selectedElement = null;
        }
        int wheel = Mouse.getDWheel();
        this.editorPanel.drawPanel(mouseX, mouseY, wheel);
        if (wheel != 0) {
            for (Element element : DarkMeow.INSTANCE.getHudManager().getElements()) {
                if (!element.isInBorder((double)((float)mouseX / element.getScale()) - element.getRenderX(), (double)((float)mouseY / element.getScale()) - element.getRenderY())) continue;
                element.setScale(element.getScale() + (wheel > 0 ? 0.05f : -0.05f));
                break;
            }
        }
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
        super.func_73864_a(mouseX, mouseY, mouseButton);
        if (this.buttonAction) {
            this.buttonAction = false;
            return;
        }
        DarkMeow.INSTANCE.getHudManager().handleMouseClick(mouseX, mouseY, mouseButton);
        if (mouseX < this.editorPanel.getX() || mouseX > this.editorPanel.getX() + this.editorPanel.getWidth() || mouseY < this.editorPanel.getY() || mouseY > this.editorPanel.getY() + Math.min(this.editorPanel.getRealHeight(), 200)) {
            this.selectedElement = null;
            this.editorPanel.setCreate(false);
        }
        if (mouseButton == 0) {
            for (Element element : DarkMeow.INSTANCE.getHudManager().getElements()) {
                if (!element.isInBorder((double)((float)mouseX / element.getScale()) - element.getRenderX(), (double)((float)mouseY / element.getScale()) - element.getRenderY())) continue;
                this.selectedElement = element;
                break;
            }
        }
    }

    protected void func_146286_b(int mouseX, int mouseY, int state) {
        super.func_146286_b(mouseX, mouseY, state);
        DarkMeow.INSTANCE.getHudManager().handleMouseReleased();
    }

    public void func_146281_b() {
        Keyboard.enableRepeatEvents((boolean)false);
        ConfigManager.save$default(DarkMeow.INSTANCE.getConfigManager(), false, 1, null);
        super.func_146281_b();
    }

    protected void func_73869_a(char typedChar, int keyCode) {
        switch (keyCode) {
            case 211: {
                if (this.selectedElement == null) break;
                HUDManager hUDManager = DarkMeow.INSTANCE.getHudManager();
                Element element = this.selectedElement;
                Intrinsics.checkNotNull(element);
                hUDManager.removeElement(element);
                break;
            }
            case 1: {
                this.selectedElement = null;
                this.editorPanel.setCreate(false);
                break;
            }
            default: {
                DarkMeow.INSTANCE.getHudManager().handleKey(typedChar, keyCode);
            }
        }
        super.func_73869_a(typedChar, keyCode);
    }
}

