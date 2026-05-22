/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.clickgui.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.manager.ClickGuiManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0003H&J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH&J \u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "name", "", "manager", "Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;)V", "getName", "()Ljava/lang/String;", "getManager", "()Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "onGuiInit", "", "onGuiClose", "drawStart", "drawPanel", "mouseX", "", "mouseY", "panel", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/Panel;", "drawDescription", "text", "drawButtonElement", "buttonElement", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ButtonElement;", "drawModuleElement", "moduleElement", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/elements/ModuleElement;", "handleKey", "", "c", "", "keyCode", "DarkMeow"})
public abstract class Style
extends MinecraftInstance {
    @NotNull
    private final String name;
    @NotNull
    private final ClickGuiManager manager;

    public Style(@NotNull String name, @NotNull ClickGuiManager manager) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.name = name;
        this.manager = manager;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public ClickGuiManager getManager() {
        return this.manager;
    }

    public abstract void onGuiInit();

    public abstract void onGuiClose();

    public abstract void drawStart();

    public abstract void drawPanel(int var1, int var2, @NotNull Panel var3);

    public abstract void drawDescription(int var1, int var2, @NotNull String var3);

    public abstract void drawButtonElement(int var1, int var2, @NotNull ButtonElement var3);

    public abstract void drawModuleElement(int var1, int var2, @NotNull ModuleElement var3);

    public abstract boolean handleKey(char var1, int var2);
}

