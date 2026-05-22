/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiShulkerBox
 *  net.minecraft.inventory.IInventory
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.gui.AccessorGuiShulkerBox;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import net.minecraft.inventory.IInventory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/gui/ExtendGuiShulkerBox;", "", "<init>", "()V", "inventory", "Lnet/minecraft/inventory/IInventory;", "Lnet/minecraft/client/gui/inventory/GuiShulkerBox;", "getInventory", "(Lnet/minecraft/client/gui/inventory/GuiShulkerBox;)Lnet/minecraft/inventory/IInventory;", "DarkMeow"})
public final class ExtendGuiShulkerBox {
    @NotNull
    public static final ExtendGuiShulkerBox INSTANCE = new ExtendGuiShulkerBox();

    private ExtendGuiShulkerBox() {
    }

    @NotNull
    public final IInventory getInventory(@NotNull GuiShulkerBox $this$inventory) {
        Intrinsics.checkNotNullParameter($this$inventory, "<this>");
        IInventory iInventory = ((AccessorGuiShulkerBox)$this$inventory).getInventory();
        Intrinsics.checkNotNullExpressionValue(iInventory, "getInventory(...)");
        return iInventory;
    }
}

