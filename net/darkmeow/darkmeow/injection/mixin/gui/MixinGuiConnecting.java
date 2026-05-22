/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.GuiConnecting
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.ccbluex.liquidbounce.ui.client.minecraft.gui.screen.GuiRendererConnecting;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiConnecting.class})
public abstract class MixinGuiConnecting
extends GuiScreen {
    @Inject(method={"connect"}, at={@At(value="HEAD")})
    private void headConnect(String ip, int port, CallbackInfo callbackInfo) {
        DarkMeow.networkManager.latestServer = new ServerData("", ip + ":" + port, false);
    }

    @Inject(method={"drawScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci2) {
        ScaledResolution scaledResolution = StaticStorage.scaledResolution;
        this.func_146276_q_();
        GuiRendererConnecting.INSTANCE.render(mouseX, mouseY, partialTicks, scaledResolution);
        super.func_73863_a(mouseX, mouseY, partialTicks);
        ci2.cancel();
    }
}

