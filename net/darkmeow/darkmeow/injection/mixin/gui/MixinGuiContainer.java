/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.gui.inventory.GuiScreenHorseInventory
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.render.EaseUtils;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiContainer.class})
public abstract class MixinGuiContainer
extends MixinGuiScreen {
    @Unique
    private float darkMeow$progress = 0.0f;
    @Unique
    private long darkMeow$lastMS = 0L;

    @Inject(method={"initGui"}, at={@At(value="HEAD")})
    public void injectInitGui(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (!GuiTweaks.isGuiContainerActive()) {
            return;
        }
        this.darkMeow$lastMS = System.currentTimeMillis();
        this.darkMeow$progress = 0.0f;
        if (this.field_146297_k.field_71462_r instanceof GuiInventory || this.field_146297_k.field_71462_r instanceof GuiScreenHorseInventory) {
            return;
        }
        int y2 = 5;
        if (GuiTweaks.guiContainerButtonDisconnectValue.get().booleanValue()) {
            this.field_146292_n.add(new GuiButton(80000, 5, y2, 140, 20, "Disconnect"));
            y2 += 30;
        }
        if (GuiTweaks.guiContainerButtonReconnectValue.get().booleanValue() && !this.field_146297_k.func_71356_B()) {
            this.field_146292_n.add(new GuiButton(80001, 5, y2, 140, 20, "Reconnect"));
            y2 += 30;
        }
    }

    @Unique
    private void darkMeow$actionPerformed(GuiButton button) {
        switch (button.field_146127_k) {
            case 80000: {
                MinecraftInstance.mc.quitWorld();
                break;
            }
            case 80001: {
                DarkMeow.networkManager.connectLatestServer();
            }
        }
    }

    @Inject(method={"mouseClicked"}, at={@At(value="RETURN")})
    private void mouseClicked(int mouseX, int mouseY, int mouseButton, CallbackInfo callbackInfo) {
        for (GuiButton aButtonList : this.field_146292_n) {
            if (!aButtonList.func_146116_c(this.field_146297_k, mouseX, mouseY)) continue;
            this.darkMeow$actionPerformed(aButtonList);
        }
    }

    @Inject(method={"drawScreen"}, at={@At(value="HEAD")})
    protected void drawScreenHead(CallbackInfo callbackInfo) {
        if (!GuiTweaks.isGuiContainerActive()) {
            return;
        }
        this.darkMeow$progress = this.darkMeow$progress >= 1.0f ? 1.0f : (float)(System.currentTimeMillis() - this.darkMeow$lastMS) / 300.0f;
        double trueAnim = EaseUtils.easeOutQuart(this.darkMeow$progress);
        switch (GuiTweaks.guiContainerAnimationValue.get()) {
            case "Zoom": {
                GlStateManager.func_179137_b((double)((1.0 - trueAnim) * ((double)this.field_146294_l / 2.0)), (double)((1.0 - trueAnim) * ((double)this.field_146295_m / 2.0)), (double)0.0);
                GlStateManager.func_179139_a((double)trueAnim, (double)trueAnim, (double)trueAnim);
                break;
            }
            case "HSlide": {
                GlStateManager.func_179137_b((double)((1.0 - trueAnim) * (double)(-this.field_146294_l)), (double)0.0, (double)0.0);
                break;
            }
            case "VSlide": {
                GlStateManager.func_179137_b((double)0.0, (double)((1.0 - trueAnim) * (double)(-this.field_146295_m)), (double)0.0);
                break;
            }
            case "HVSlide": {
                GlStateManager.func_179137_b((double)((1.0 - trueAnim) * (double)(-this.field_146294_l)), (double)((1.0 - trueAnim) * (double)(-this.field_146295_m)), (double)0.0);
            }
        }
        GlStateManager.func_179094_E();
    }

    @Inject(method={"drawScreen"}, at={@At(value="RETURN")})
    protected void drawScreenReturn(CallbackInfo callbackInfo) {
        if (!GuiTweaks.isGuiContainerActive()) {
            return;
        }
        GlStateManager.func_179121_F();
    }
}

