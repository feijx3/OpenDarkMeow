/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package net.ccbluex.liquidbounce.utils;

import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Deprecated
public final class InventoryUtils
extends MinecraftInstance {
    public static int findItem(int startSlot, int endSlot, Item item) {
        for (int i2 = startSlot; i2 < endSlot; ++i2) {
            ItemStack stack = InventoryUtils.mc_nowarp.field_71439_g.field_71069_bz.func_75139_a(i2).func_75211_c();
            if (stack == null || !stack.func_77973_b().equals(item)) continue;
            return i2;
        }
        return -1;
    }

    public static boolean hasSpaceHotbar() {
        for (int i2 = 36; i2 < 45; ++i2) {
            ItemStack stack = InventoryUtils.mc_nowarp.field_71439_g.field_71071_by.func_70301_a(i2);
            if (stack != null) continue;
            return true;
        }
        return false;
    }
}

