/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiInventory.class})
public abstract class MixinGuiInventory
extends MixinGuiScreen {
    @Inject(method={"drawEntityOnScreen"}, at={@At(value="HEAD")})
    private static void drawEntityOnScreen$HEAD(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent, CallbackInfo ci2) {
        try {
            DarkMeow.rotationManager.pauseRotationVisualFix = true;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"drawEntityOnScreen"}, at={@At(value="RETURN")})
    private static void drawEntityOnScreen$RETURN(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent, CallbackInfo ci2) {
        try {
            DarkMeow.rotationManager.pauseRotationVisualFix = false;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

