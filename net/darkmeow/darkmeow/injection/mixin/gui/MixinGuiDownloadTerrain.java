/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiDownloadTerrain
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.ccbluex.liquidbounce.ui.client.minecraft.gui.screen.GuiRendererConnecting;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiDownloadTerrain.class})
public abstract class MixinGuiDownloadTerrain
extends MixinGuiScreen {
    @Inject(method={"initGui"}, at={@At(value="RETURN")})
    private void addConsoleLog(CallbackInfo ci2) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (!GuiTweaks.isGuiConnectingActive()) {
            return;
        }
        if (GuiTweaks.guiConnectingRemoveDownloadTerrainValue.get().booleanValue()) {
            this.field_146297_k.field_71462_r = null;
        }
    }

    @Inject(method={"drawScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci2) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (!GuiTweaks.isGuiConnectingActive()) {
            return;
        }
        ScaledResolution scaledResolution = StaticStorage.scaledResolution;
        this.func_146276_q_();
        GuiRendererConnecting.INSTANCE.render(mouseX, mouseY, partialTicks, scaledResolution);
        ci2.cancel();
    }
}

