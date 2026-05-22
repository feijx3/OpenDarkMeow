/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.darkmeow.viamcp.gui.GuiProtocolSelector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiMultiplayer.class})
public abstract class MixinGuiMultiplayer
extends MixinGuiScreen {
    @Inject(method={"initGui"}, at={@At(value="RETURN")})
    private void initGui(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        this.field_146292_n.add(new GuiButton(80000, 4, 8, 98, 20, "Protocol"));
    }

    @Inject(method={"actionPerformed"}, at={@At(value="HEAD")})
    public void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        switch (button.field_146127_k) {
            case 80000: {
                this.field_146297_k.func_147108_a((GuiScreen)new GuiProtocolSelector((GuiScreen)this));
            }
        }
    }

    @Inject(method={"keyTyped"}, at={@At(value="HEAD")})
    public void keyTyped(char typedChar, int keyCode, CallbackInfo ci2) {
        if (DarkMeow.isDestroy) {
            return;
        }
        DarkMeow.clickGuiManager.onGuiKeyTyped(keyCode);
    }
}

