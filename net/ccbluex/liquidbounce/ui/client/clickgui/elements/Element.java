/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.ui.client.clickgui.elements;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J \u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/Element;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "x", "", "getX", "()I", "setX", "(I)V", "y", "getY", "setY", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "isVisible", "", "()Z", "setVisible", "(Z)V", "setLocation", "", "drawScreen", "mouseX", "mouseY", "button", "", "mouseClicked", "mouseButton", "mouseReleased", "state", "DarkMeow"})
public class Element
extends MinecraftInstance {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;

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

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int n2) {
        this.width = n2;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n2) {
        this.height = n2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean bl2) {
        this.isVisible = bl2;
    }

    public final void setLocation(int x2, int y2) {
        this.x = x2;
        this.y = y2;
    }

    public void drawScreen(int mouseX, int mouseY, float button) {
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
    }
}

