/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.util.StringUtils
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.clickgui;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.manager.ClickGuiManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@SideOnly(value=Side.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\b'\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u00104\u001a\u000205H&J\u001e\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020.J\u001e\u0010:\u001a\u0002052\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007J\u001e\u0010<\u001a\u0002052\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007J\u001e\u0010>\u001a\u00020\f2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007J\b\u0010B\u001a\u00020\u0007H\u0002J\u0016\u0010C\u001a\u00020\f2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006D"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/Panel;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "manager", "Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "name", "", "x", "", "y", "width", "height", "open", "", "<init>", "(Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;Ljava/lang/String;IIIIZ)V", "getManager", "()Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "getHeight", "()I", "getOpen", "()Z", "setOpen", "(Z)V", "x2", "getX2", "setX2", "(I)V", "y2", "getY2", "setY2", "scroll", "dragged", "getDragged", "setDragged", "drag", "getDrag", "setDrag", "scrollbar", "getScrollbar", "setScrollbar", "elements", "", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/Element;", "isVisible", "setVisible", "elementsHeight", "", "fade", "getFade", "()F", "setFade", "(F)V", "setupItems", "", "drawScreen", "mouseX", "mouseY", "button", "mouseClicked", "mouseButton", "mouseReleased", "state", "handleScroll", "wheel", "updateFade", "delta", "getElementsHeight", "isHovering", "DarkMeow"})
public abstract class Panel
extends MinecraftInstance {
    @NotNull
    private final ClickGuiManager manager;
    @JvmField
    @NotNull
    public final String name;
    @JvmField
    public int x;
    @JvmField
    public int y;
    @JvmField
    public final int width;
    private final int height;
    private boolean open;
    private int x2;
    private int y2;
    private int scroll;
    private int dragged;
    private boolean drag;
    private boolean scrollbar;
    @JvmField
    @NotNull
    public final List<Element> elements;
    private boolean isVisible;
    private float elementsHeight;
    private float fade;

    public Panel(@NotNull ClickGuiManager manager, @NotNull String name, int x2, int y2, int width, int height, boolean open) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(name, "name");
        this.manager = manager;
        this.name = name;
        this.x = x2;
        this.y = y2;
        this.width = width;
        this.height = height;
        this.open = open;
        this.elements = new ArrayList();
        this.isVisible = true;
        this.setupItems();
    }

    @NotNull
    public final ClickGuiManager getManager() {
        return this.manager;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final void setOpen(boolean bl2) {
        this.open = bl2;
    }

    public final int getX2() {
        return this.x2;
    }

    public final void setX2(int n2) {
        this.x2 = n2;
    }

    public final int getY2() {
        return this.y2;
    }

    public final void setY2(int n2) {
        this.y2 = n2;
    }

    public final int getDragged() {
        return this.dragged;
    }

    public final void setDragged(int n2) {
        this.dragged = n2;
    }

    public final boolean getDrag() {
        return this.drag;
    }

    public final void setDrag(boolean bl2) {
        this.drag = bl2;
    }

    public final boolean getScrollbar() {
        return this.scrollbar;
    }

    public final void setScrollbar(boolean bl2) {
        this.scrollbar = bl2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean bl2) {
        this.isVisible = bl2;
    }

    public final float getFade() {
        return this.fade;
    }

    public final void setFade(float f2) {
        this.fade = f2;
    }

    public abstract void setupItems();

    public final void drawScreen(int mouseX, int mouseY, float button) {
        boolean scrollbar;
        if (!this.isVisible) {
            return;
        }
        Style style = DarkMeow.INSTANCE.getClickGuiManager().getCui().getStyle();
        if (style == null) {
            ClientUtils.INSTANCE.logError("Unable to draw click-gui screen", new Exception("style is empty"));
            return;
        }
        Style style2 = style;
        int maxElements = ((Number)this.manager.getConfig().getMaxElementsValue().get()).intValue();
        if (this.drag) {
            int nx = this.x2 + mouseX;
            int ny = this.y2 + mouseY;
            if (nx > -1) {
                this.x = nx;
            }
            if (ny > -1) {
                this.y = ny;
            }
        }
        this.elementsHeight = this.getElementsHeight() - 1;
        boolean bl2 = scrollbar = this.elements.size() >= maxElements;
        if (this.scrollbar != scrollbar) {
            this.scrollbar = scrollbar;
        }
        style2.drawPanel(mouseX, mouseY, this);
        int y2 = this.y + this.height - 2;
        int count = 0;
        for (Element element : this.elements) {
            if (++count > this.scroll && count < this.scroll + (maxElements + 1) && this.scroll < this.elements.size()) {
                element.setLocation(this.x, y2);
                element.setWidth(this.width);
                if ((float)y2 <= (float)this.y + this.fade) {
                    element.drawScreen(mouseX, mouseY, button);
                }
                y2 += element.getHeight() + 1;
                element.setVisible(true);
                continue;
            }
            element.setVisible(false);
        }
    }

    public final void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (!this.isVisible) {
            return;
        }
        if (mouseButton == 1 && this.isHovering(mouseX, mouseY)) {
            this.open = !this.open;
            return;
        }
        for (Element element : this.elements) {
            if (!((float)element.getY() <= (float)this.y + this.fade)) continue;
            element.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    public final void mouseReleased(int mouseX, int mouseY, int state) {
        if (!this.isVisible) {
            return;
        }
        this.drag = false;
        if (!this.open) {
            return;
        }
        for (Element element : this.elements) {
            element.mouseReleased(mouseX, mouseY, state);
        }
    }

    public final boolean handleScroll(int mouseX, int mouseY, int wheel) {
        int maxElements = ((Number)this.manager.getConfig().getMaxElementsValue().get()).intValue();
        if (!this.isVisible) {
            return false;
        }
        if (!this.open) {
            return false;
        }
        if (mouseX >= this.x && mouseX <= this.x + 100 && mouseY >= this.y && (float)mouseY <= (float)(this.y + 19) + this.elementsHeight) {
            if (wheel < 0 && this.scroll < this.elements.size() - maxElements) {
                ++this.scroll;
                if (this.scroll < 0) {
                    this.scroll = 0;
                }
            } else if (wheel > 0) {
                this.scroll += -1;
                if (this.scroll < 0) {
                    this.scroll = 0;
                }
            }
            if (wheel < 0) {
                if (this.dragged < this.elements.size() - maxElements) {
                    ++this.dragged;
                }
            } else if (wheel > 0 && this.dragged >= 1) {
                this.dragged += -1;
            }
            return true;
        }
        return false;
    }

    public final void updateFade(int delta) {
        if (this.open) {
            if (this.fade < this.elementsHeight) {
                this.fade += 0.4f * (float)delta;
            }
            if (this.fade > this.elementsHeight) {
                this.fade = (int)this.elementsHeight;
            }
        } else {
            if (this.fade > 0.0f) {
                this.fade -= 0.4f * (float)delta;
            }
            if (this.fade < 0.0f) {
                this.fade = 0.0f;
            }
        }
    }

    public final int getFade() {
        return (int)this.fade;
    }

    private final int getElementsHeight() {
        int height = 0;
        int count = 0;
        for (Element element : this.elements) {
            if (count >= ((Number)this.manager.getConfig().getMaxElementsValue().get()).intValue()) continue;
            height += element.getHeight() + 1;
            ++count;
        }
        return height;
    }

    public final boolean isHovering(int mouseX, int mouseY) {
        float textWidth = (float)MinecraftInstance.mc_nowarp.field_71466_p.func_78256_a(StringUtils.func_76338_a((String)this.name)) - 100.0f;
        return (float)mouseX >= (float)this.x - textWidth / 2.0f - 19.0f && (float)mouseX <= (float)this.x - textWidth / 2.0f + (float)MinecraftInstance.mc_nowarp.field_71466_p.func_78256_a(StringUtils.func_76338_a((String)this.name)) + 19.0f && mouseY >= this.y && mouseY <= this.y + this.height - (this.open ? 2 : 0);
    }
}

