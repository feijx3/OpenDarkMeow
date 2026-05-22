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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "", "mouseX", "", "mouseY", "clickX", "clickY", "button", "<init>", "(IIIII)V", "component", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "(IIILnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "event", "(Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "getMouseX", "()I", "getMouseY", "getClickX", "getClickY", "getButton", "DarkMeow"})
public final class ComponentMouseClickedEvent {
    private final int mouseX;
    private final int mouseY;
    private final int clickX;
    private final int clickY;
    private final int button;

    public ComponentMouseClickedEvent(int mouseX, int mouseY, int clickX, int clickY, int button) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.clickX = clickX;
        this.clickY = clickY;
        this.button = button;
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

    public ComponentMouseClickedEvent(int mouseX, int mouseY, int button, @NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this(mouseX, mouseY, mouseX - component.getPosX(), mouseY - component.getPosY(), button);
    }

    public ComponentMouseClickedEvent(@NotNull ComponentMouseClickedEvent event, @NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(component, "component");
        this(event.mouseX, event.mouseY, event.clickX - component.getPosX(), event.clickY - component.getPosY(), event.button);
    }
}

