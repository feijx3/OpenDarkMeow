/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiTextField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.gui.AccessorGuiChat;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/gui/ExtendGuiChat;", "", "<init>", "()V", "inputField", "Lnet/minecraft/client/gui/GuiTextField;", "Lnet/minecraft/client/gui/GuiChat;", "getInputField", "(Lnet/minecraft/client/gui/GuiChat;)Lnet/minecraft/client/gui/GuiTextField;", "DarkMeow"})
public final class ExtendGuiChat {
    @NotNull
    public static final ExtendGuiChat INSTANCE = new ExtendGuiChat();

    private ExtendGuiChat() {
    }

    @NotNull
    public final GuiTextField getInputField(@NotNull GuiChat $this$inputField) {
        Intrinsics.checkNotNullParameter($this$inputField, "<this>");
        GuiTextField guiTextField = ((AccessorGuiChat)$this$inputField).getInputField();
        Intrinsics.checkNotNullExpressionValue(guiTextField, "getInputField(...)");
        return guiTextField;
    }
}

