/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.component.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentRenderUtils;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b\u00a8\u0006%"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentText;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "posX", "", "posY", "width", "height", "title", "", "color", "Ljava/awt/Color;", "center", "", "rect", "<init>", "(IIIILjava/lang/String;Ljava/awt/Color;ZZ)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getColor", "()Ljava/awt/Color;", "setColor", "(Ljava/awt/Color;)V", "getCenter", "()Z", "setCenter", "(Z)V", "getRect", "setRect", "drawComponent", "", "mouseX", "mouseY", "isFocused", "partialTicks", "", "DarkMeow"})
public final class ComponentText
extends AbstractComponent {
    @NotNull
    private String title;
    @Nullable
    private Color color;
    private boolean center;
    private boolean rect;

    public ComponentText(int posX, int posY, int width, int height, @NotNull String title, @Nullable Color color, boolean center, boolean rect) {
        Intrinsics.checkNotNullParameter(title, "title");
        super(posX, posY, width, height);
        this.title = title;
        this.color = color;
        this.center = center;
        this.rect = rect;
    }

    public /* synthetic */ ComponentText(int n2, int n3, int n4, int n5, String string, Color color, boolean bl2, boolean bl3, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 0x20) != 0) {
            color = null;
        }
        if ((n6 & 0x40) != 0) {
            bl2 = false;
        }
        if ((n6 & 0x80) != 0) {
            bl3 = false;
        }
        this(n2, n3, n4, n5, string, color, bl2, bl3);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.title = string;
    }

    @Nullable
    public final Color getColor() {
        return this.color;
    }

    public final void setColor(@Nullable Color color) {
        this.color = color;
    }

    public final boolean getCenter() {
        return this.center;
    }

    public final void setCenter(boolean bl2) {
        this.center = bl2;
    }

    public final boolean getRect() {
        return this.rect;
    }

    public final void setRect(boolean bl2) {
        this.rect = bl2;
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
        int n2;
        if (this.rect) {
            ComponentRenderUtils.INSTANCE.drawBoardRect(this, this.getBase().getTheme(), isFocused);
        }
        if (this.center) {
            FontRenderer fontRenderer = this.getBase().getTheme().getFont();
            Number number = this.getWidth() / 2;
            Number number2 = this.getHeight() / 2;
            Color color = this.color;
            if (color == null) {
                color = this.getBase().getTheme().getColorFont();
            }
            n2 = FontRendererUtils.drawStringCentered$default(FontRendererUtils.INSTANCE, fontRenderer, this.title, number, number2, color, false, true, 16, null);
        } else {
            FontRenderer fontRenderer = this.getBase().getTheme().getFont();
            Number number = 0;
            Number number3 = 0;
            Color color = this.color;
            if (color == null) {
                color = this.getBase().getTheme().getColorFont();
            }
            n2 = FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, this.title, number, number3, color, false, 16, null);
        }
    }
}

