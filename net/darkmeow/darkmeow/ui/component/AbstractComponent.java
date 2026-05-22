/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.base.IDarkGuiBase;
import net.darkmeow.darkmeow.ui.component.event.ComponentKeyTypedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickMoveEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseReleaseEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010#\u001a\u00020$H\u0016J(\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u0010,\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020$2\u0006\u0010,\u001a\u000203H\u0016J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0016J\b\u00106\u001a\u00020$H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u00067"}, d2={"Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "", "posX", "", "posY", "width", "height", "<init>", "(IIII)V", "getPosX", "()I", "setPosX", "(I)V", "getPosY", "setPosY", "getWidth", "setWidth", "getHeight", "setHeight", "prevPosX", "getPrevPosX", "setPrevPosX", "prevPosY", "getPrevPosY", "setPrevPosY", "base", "Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "getBase", "()Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "setBase", "(Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;)V", "allowFocus", "", "getAllowFocus", "()Z", "onInit", "", "drawComponent", "mouseX", "mouseY", "isFocused", "partialTicks", "", "onKeyTyped", "event", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentKeyTypedEvent;", "onMouseClick", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "onMouseClickMove", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickMoveEvent;", "onMouseRelease", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseReleaseEvent;", "onFocus", "onUnfocus", "onUpdate", "DarkMeow"})
public abstract class AbstractComponent {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int prevPosX;
    private int prevPosY;
    public IDarkGuiBase base;
    private final boolean allowFocus;

    public AbstractComponent(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
    }

    public /* synthetic */ AbstractComponent(int n2, int n3, int n4, int n5, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 1) != 0) {
            n2 = 0;
        }
        if ((n6 & 2) != 0) {
            n3 = 0;
        }
        if ((n6 & 4) != 0) {
            n4 = 0;
        }
        if ((n6 & 8) != 0) {
            n5 = 0;
        }
        this(n2, n3, n4, n5);
    }

    public final int getPosX() {
        return this.posX;
    }

    public final void setPosX(int n2) {
        this.posX = n2;
    }

    public final int getPosY() {
        return this.posY;
    }

    public final void setPosY(int n2) {
        this.posY = n2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int n2) {
        this.width = n2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int n2) {
        this.height = n2;
    }

    public final int getPrevPosX() {
        return this.prevPosX;
    }

    public final void setPrevPosX(int n2) {
        this.prevPosX = n2;
    }

    public final int getPrevPosY() {
        return this.prevPosY;
    }

    public final void setPrevPosY(int n2) {
        this.prevPosY = n2;
    }

    @NotNull
    public final IDarkGuiBase getBase() {
        IDarkGuiBase iDarkGuiBase = this.base;
        if (iDarkGuiBase != null) {
            return iDarkGuiBase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("base");
        return null;
    }

    public final void setBase(@NotNull IDarkGuiBase iDarkGuiBase) {
        Intrinsics.checkNotNullParameter(iDarkGuiBase, "<set-?>");
        this.base = iDarkGuiBase;
    }

    public boolean getAllowFocus() {
        return this.allowFocus;
    }

    public void onInit() {
    }

    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
    }

    public void onKeyTyped(@NotNull ComponentKeyTypedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onMouseClick(@NotNull ComponentMouseClickedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onMouseClickMove(@NotNull ComponentMouseClickMoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onMouseRelease(@NotNull ComponentMouseReleaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onFocus() {
    }

    public void onUnfocus() {
    }

    public void onUpdate() {
    }

    public AbstractComponent() {
        this(0, 0, 0, 0, 15, null);
    }
}

