/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.gui.AccessorGuiContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/gui/ExtendGuiContainer;", "", "<init>", "()V", "keyTyped", "", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "typedChar", "", "keyCode", "", "DarkMeow"})
public final class ExtendGuiContainer {
    @NotNull
    public static final ExtendGuiContainer INSTANCE = new ExtendGuiContainer();

    private ExtendGuiContainer() {
    }

    public final void keyTyped(@NotNull GuiContainer $this$keyTyped, char typedChar, int keyCode) {
        Intrinsics.checkNotNullParameter($this$keyTyped, "<this>");
        ((AccessorGuiContainer)$this$keyTyped).darkMeow_keyTyped(typedChar, keyCode);
    }
}

