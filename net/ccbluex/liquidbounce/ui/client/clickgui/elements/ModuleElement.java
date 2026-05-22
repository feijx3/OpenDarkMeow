/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.ui.client.clickgui.elements;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Mouse;

@SideOnly(value=Side.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ModuleElement;", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ButtonElement;", "module", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/Module;)V", "isShowSettings", "", "()Z", "setShowSettings", "(Z)V", "settingsWidth", "", "wasPressed", "slowlyFade", "", "drawScreen", "", "mouseX", "mouseY", "button", "mouseClicked", "mouseButton", "isntPressed", "updatePressed", "DarkMeow"})
public final class ModuleElement
extends ButtonElement {
    @JvmField
    @NotNull
    public final Module module;
    private boolean isShowSettings;
    @JvmField
    public float settingsWidth;
    private boolean wasPressed;
    @JvmField
    public int slowlyFade;

    public ModuleElement(@NotNull Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        super(module.getModuleDisplayName(), module.getModuleDescription());
        this.module = module;
    }

    public final boolean isShowSettings() {
        return this.isShowSettings;
    }

    public final void setShowSettings(boolean bl2) {
        this.isShowSettings = bl2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float button) {
        try {
            Style style = DarkMeow.INSTANCE.getClickGuiManager().getCui().getStyle();
            if (style != null) {
                style.drawModuleElement(mouseX, mouseY, this);
            }
        }
        catch (Throwable e2) {
            ClientUtils.INSTANCE.logError("[ClickGui] failed to drawScreen", e2);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && this.isHovering(mouseX, mouseY) && this.isVisible()) {
            this.module.toggle();
        }
        if (mouseButton == 1 && this.isHovering(mouseX, mouseY) && this.isVisible()) {
            this.isShowSettings = !this.isShowSettings;
        }
    }

    public final boolean isntPressed() {
        return !this.wasPressed;
    }

    public final void updatePressed() {
        this.wasPressed = Mouse.isButtonDown((int)0);
    }
}

