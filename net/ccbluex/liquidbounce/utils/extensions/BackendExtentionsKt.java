/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.extensions;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u00a8\u0006\u0007"}, d2={"toClickType", "Lnet/minecraft/inventory/ClickType;", "", "isSplash", "", "Lnet/minecraft/item/ItemStack;", "item", "DarkMeow"})
public final class BackendExtentionsKt {
    @Deprecated(message="\u5728 2025.6.6 \u4ee5\u540e\u7528\u8fd9\u4e2a\u65b9\u6cd5\u6b7b\u5988")
    @NotNull
    public static final ClickType toClickType(int $this$toClickType) {
        ClickType clickType;
        boolean $i$f$toClickType = false;
        switch ($this$toClickType) {
            case 0: {
                clickType = ClickType.PICKUP;
                break;
            }
            case 1: {
                clickType = ClickType.QUICK_MOVE;
                break;
            }
            case 2: {
                clickType = ClickType.SWAP;
                break;
            }
            case 3: {
                clickType = ClickType.CLONE;
                break;
            }
            case 4: {
                clickType = ClickType.THROW;
                break;
            }
            case 5: {
                clickType = ClickType.QUICK_CRAFT;
                break;
            }
            case 6: {
                clickType = ClickType.PICKUP_ALL;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid mode " + $this$toClickType);
            }
        }
        return clickType;
    }

    @Deprecated(message="\u5728 2025.6.6 \u4ee5\u540e\u7528\u8fd9\u4e2a\u65b9\u6cd5\u6b7b\u5988")
    public static final boolean isSplash(@NotNull ItemStack $this$isSplash, @NotNull ItemStack item) {
        Intrinsics.checkNotNullParameter($this$isSplash, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        boolean $i$f$isSplash = false;
        return Intrinsics.areEqual(item.func_77973_b(), Items.field_185155_bH);
    }
}

