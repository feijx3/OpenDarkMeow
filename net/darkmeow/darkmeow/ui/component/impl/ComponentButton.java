/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentRenderUtils;
import net.darkmeow.darkmeow.ui.component.event.ComponentKeyTypedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015\u00a8\u0006*"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentButton;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "posX", "", "posY", "width", "height", "title", "", "disable", "", "onClicked", "Lkotlin/Function0;", "", "<init>", "(IIIILjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getDisable", "()Z", "setDisable", "(Z)V", "getOnClicked", "()Lkotlin/jvm/functions/Function0;", "setOnClicked", "(Lkotlin/jvm/functions/Function0;)V", "allowFocus", "getAllowFocus", "drawComponent", "mouseX", "mouseY", "isFocused", "partialTicks", "", "onKeyTyped", "event", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentKeyTypedEvent;", "onMouseClick", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "invokeOnClicked", "DarkMeow"})
public final class ComponentButton
extends AbstractComponent {
    @NotNull
    private String title;
    private boolean disable;
    @NotNull
    private Function0<Unit> onClicked;
    private final boolean allowFocus;

    public ComponentButton(int posX, int posY, int width, int height, @NotNull String title, boolean disable, @NotNull Function0<Unit> onClicked) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        super(posX, posY, width, height);
        this.title = title;
        this.disable = disable;
        this.onClicked = onClicked;
        this.allowFocus = true;
    }

    public /* synthetic */ ComponentButton(int n2, int n3, int n4, int n5, String string, boolean bl2, Function0 function0, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 0x20) != 0) {
            bl2 = false;
        }
        if ((n6 & 0x40) != 0) {
            function0 = ComponentButton::_init_$lambda$0;
        }
        this(n2, n3, n4, n5, string, bl2, function0);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.title = string;
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public final void setDisable(boolean bl2) {
        this.disable = bl2;
    }

    @NotNull
    public final Function0<Unit> getOnClicked() {
        return this.onClicked;
    }

    public final void setOnClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClicked = function0;
    }

    @Override
    public boolean getAllowFocus() {
        return this.allowFocus;
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
        ComponentRenderUtils.INSTANCE.drawBoardRect(this, this.getBase().getTheme(), isFocused);
        FontRendererUtils.drawStringCentered$default(FontRendererUtils.INSTANCE, this.getBase().getTheme().getFont(), this.title, this.getWidth() / 2, this.getHeight() / 2, this.disable ? this.getBase().getTheme().getColorFontReadOnly() : this.getBase().getTheme().getColorFont(), false, true, 16, null);
    }

    @Override
    public void onKeyTyped(@NotNull ComponentKeyTypedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getCode() == 57) {
            this.invokeOnClicked();
            event.cancelNext();
        }
    }

    @Override
    public void onMouseClick(@NotNull ComponentMouseClickedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getButton() == 0) {
            this.invokeOnClicked();
        }
    }

    public final void invokeOnClicked() {
        if (!this.disable) {
            this.onClicked.invoke();
        }
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }
}

