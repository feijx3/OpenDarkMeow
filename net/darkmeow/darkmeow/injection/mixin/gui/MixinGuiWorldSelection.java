/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiWorldSelection
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import java.io.IOException;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiWorldSelection.class})
public abstract class MixinGuiWorldSelection
extends MixinGuiScreen {
    @Inject(method={"drawScreen"}, at={@At(value="HEAD")})
    private void injectDrawDefaultBackground(int mouseX, int mouseY, float partialTicks, CallbackInfo ci2) {
        this.func_146276_q_();
    }

    @Override
    protected void func_73869_a(char typedChar, int keyCode) throws IOException {
        if (DarkMeow.isDestroy) {
            return;
        }
        DarkMeow.clickGuiManager.onGuiKeyTyped(keyCode);
    }
}

