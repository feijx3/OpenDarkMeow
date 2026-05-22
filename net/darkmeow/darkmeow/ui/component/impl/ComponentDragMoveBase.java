/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.component.impl;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentRenderUtils;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickMoveEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseReleaseEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentDragMoveBase;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "posX", "", "posY", "width", "height", "disable", "", "<init>", "(IIIIZ)V", "getDisable", "()Z", "setDisable", "(Z)V", "allowFocus", "getAllowFocus", "drawComponent", "", "mouseX", "mouseY", "isFocused", "partialTicks", "", "dragOffset", "Lkotlin/Pair;", "getDragOffset", "()Lkotlin/Pair;", "setDragOffset", "(Lkotlin/Pair;)V", "onMouseClick", "event", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "onMouseClickMove", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickMoveEvent;", "onMouseRelease", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseReleaseEvent;", "DarkMeow"})
public class ComponentDragMoveBase
extends AbstractComponent {
    private boolean disable;
    private final boolean allowFocus;
    @Nullable
    private Pair<Integer, Integer> dragOffset;

    public ComponentDragMoveBase(int posX, int posY, int width, int height, boolean disable) {
        super(posX, posY, width, height);
        this.disable = disable;
        this.allowFocus = true;
    }

    public /* synthetic */ ComponentDragMoveBase(int n2, int n3, int n4, int n5, boolean bl2, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 0x10) != 0) {
            bl2 = false;
        }
        this(n2, n3, n4, n5, bl2);
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public final void setDisable(boolean bl2) {
        this.disable = bl2;
    }

    @Override
    public boolean getAllowFocus() {
        return this.allowFocus;
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
        ComponentRenderUtils.INSTANCE.drawBoardRect(this, this.getBase().getTheme(), isFocused);
    }

    @Nullable
    public final Pair<Integer, Integer> getDragOffset() {
        return this.dragOffset;
    }

    public final void setDragOffset(@Nullable Pair<Integer, Integer> pair) {
        this.dragOffset = pair;
    }

    @Override
    public void onMouseClick(@NotNull ComponentMouseClickedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dragOffset = new Pair<Integer, Integer>(event.getMouseX() - this.getPosX(), event.getMouseY() - this.getPosY());
    }

    @Override
    public void onMouseClickMove(@NotNull ComponentMouseClickMoveEvent event) {
        block0: {
            Pair<Integer, Integer> pair;
            Intrinsics.checkNotNullParameter(event, "event");
            Pair<Integer, Integer> pair2 = this.dragOffset;
            if (pair2 == null) break block0;
            Pair<Integer, Integer> offset = pair = pair2;
            boolean bl2 = false;
            this.setPosX(event.getMouseX() - ((Number)offset.getFirst()).intValue());
            this.setPosY(event.getMouseY() - ((Number)offset.getSecond()).intValue());
        }
    }

    @Override
    public void onMouseRelease(@NotNull ComponentMouseReleaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dragOffset = null;
    }
}

