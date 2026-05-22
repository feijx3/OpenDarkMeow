/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiGameOver.class})
public abstract class MixinGuiGameOver
extends MixinGuiScreen {
    @Inject(method={"keyTyped"}, at={@At(value="HEAD")})
    private void keyTyped(char typedChar, int keyCode, CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        DarkMeow.clickGuiManager.onGuiKeyTyped(keyCode);
    }
}

