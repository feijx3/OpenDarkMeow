/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.client.CPacketClickWindow
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketClickWindow.class})
public interface AccessorCPacketClickWindow {
    @Accessor(value="windowId")
    public int func_149548_c();

    @Accessor(value="windowId")
    public void setWindowId(int var1);

    @Accessor(value="slotId")
    public int func_149544_d();

    @Accessor(value="slotId")
    public void setSlotId(int var1);

    @Accessor(value="packedClickData")
    public int getPackedClickData();

    @Accessor(value="packedClickData")
    public void setPackedClickData(int var1);

    @Accessor(value="actionNumber")
    public short func_149547_f();

    @Accessor(value="actionNumber")
    public void setActionNumber(short var1);

    @Accessor(value="clickedItem")
    public ItemStack func_149546_g();

    @Accessor(value="clickedItem")
    public void setClickedItem(ItemStack var1);

    @Accessor(value="mode")
    public ClickType getMode();

    @Accessor(value="mode")
    public void setMode(ClickType var1);
}

