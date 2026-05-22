/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.clickgui.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(value=Side.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012\u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ButtonElement;", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/Element;", "displayName", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "color", "", "getColor", "()I", "setColor", "(I)V", "height", "getHeight", "setHeight", "hoverTime", "getHoverTime", "setHoverTime", "drawScreen", "", "mouseX", "mouseY", "button", "", "isHovering", "", "DarkMeow"})
public class ButtonElement
extends Element {
    @NotNull
    private String displayName;
    @NotNull
    private String description;
    private int color;
    private int height;
    private int hoverTime;

    public ButtonElement(@Nullable String displayName, @Nullable String description) {
        String string;
        this.displayName = "";
        this.description = "";
        this.color = 0xFFFFFF;
        this.height = 16;
        String string2 = displayName;
        if (string2 == null) {
            string2 = this.displayName = "";
        }
        if ((string = description) == null) {
            string = "";
        }
        this.description = string;
    }

    public /* synthetic */ ButtonElement(String string, String string2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            string2 = null;
        }
        this(string, string2);
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.displayName = string;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.description = string;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int n2) {
        this.color = n2;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int n2) {
        this.height = n2;
    }

    public final int getHoverTime() {
        return this.hoverTime;
    }

    public final void setHoverTime(int n2) {
        this.hoverTime = n2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float button) {
        Style style = DarkMeow.INSTANCE.getClickGuiManager().getCui().getStyle();
        if (style != null) {
            style.drawButtonElement(mouseX, mouseY, this);
        }
        super.drawScreen(mouseX, mouseY, button);
    }

    public final boolean isHovering(int mouseX, int mouseY) {
        return mouseX >= this.getX() && mouseX <= this.getX() + this.getWidth() && mouseY >= this.getY() && mouseY <= this.getY() + 16;
    }
}

