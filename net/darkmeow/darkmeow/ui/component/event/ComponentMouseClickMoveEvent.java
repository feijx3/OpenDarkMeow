/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickMoveEvent;", "", "mouseX", "", "mouseY", "clickX", "clickY", "button", "timeSinceLastClick", "", "<init>", "(IIIIIJ)V", "component", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "(IIIJLnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "event", "(Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickMoveEvent;Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "getMouseX", "()I", "getMouseY", "getClickX", "getClickY", "getButton", "getTimeSinceLastClick", "()J", "DarkMeow"})
public final class ComponentMouseClickMoveEvent {
    private final int mouseX;
    private final int mouseY;
    private final int clickX;
    private final int clickY;
    private final int button;
    private final long timeSinceLastClick;

    public ComponentMouseClickMoveEvent(int mouseX, int mouseY, int clickX, int clickY, int button, long timeSinceLastClick) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.clickX = clickX;
        this.clickY = clickY;
        this.button = button;
        this.timeSinceLastClick = timeSinceLastClick;
    }

    public final int getMouseX() {
        return this.mouseX;
    }

    public final int getMouseY() {
        return this.mouseY;
    }

    public final int getClickX() {
        return this.clickX;
    }

    public final int getClickY() {
        return this.clickY;
    }

    public final int getButton() {
        return this.button;
    }

    public final long getTimeSinceLastClick() {
        return this.timeSinceLastClick;
    }

    public ComponentMouseClickMoveEvent(int mouseX, int mouseY, int button, long timeSinceLastClick, @NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this(mouseX, mouseY, mouseX - component.getPosX(), mouseY - component.getPosY(), button, timeSinceLastClick);
    }

    public ComponentMouseClickMoveEvent(@NotNull ComponentMouseClickMoveEvent event, @NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(component, "component");
        this(event.mouseX, event.mouseY, event.clickX - component.getPosX(), event.clickY - component.getPosY(), event.button, event.timeSinceLastClick);
    }
}

