/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.features.spoof_held_item;

import net.ccbluex.liquidbounce.DarkMeow;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiIngame.class})
public abstract class MixinGuiInGame {
    @Shadow
    protected int field_92017_k;

    @Redirect(method={"renderHotbar"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/player/InventoryPlayer;currentItem:I"))
    private int renderHotbar$modifySlot(InventoryPlayer instance) {
        if (DarkMeow.inventoryManager.currentSpoofSlot != null) {
            this.field_92017_k = 0;
            return DarkMeow.inventoryManager.currentSpoofSlot;
        }
        return instance.field_70461_c;
    }
}

