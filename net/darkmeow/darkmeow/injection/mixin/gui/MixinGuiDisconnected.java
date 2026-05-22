/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiDisconnected
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiDisconnected.class})
public abstract class MixinGuiDisconnected
extends MixinGuiScreen {
    @Shadow
    private int field_175353_i;
    @Shadow
    @Final
    private GuiScreen field_146307_h;

    @Inject(method={"initGui"}, at={@At(value="RETURN")})
    private void initGui(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (!GuiTweaks.isGuiConnectingActive()) {
            return;
        }
        if (this.field_146292_n.size() == 1) {
            this.field_146292_n.clear();
            this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b, 200, 20, "Back to server list"));
        }
        if (!GuiTweaks.guiConnectingReconnectButtonValue.get().booleanValue()) {
            this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 22, 200, 20, "Reconnect"));
        }
    }

    @Inject(method={"actionPerformed"}, at={@At(value="HEAD")})
    public void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (!GuiTweaks.isGuiConnectingActive()) {
            return;
        }
        switch (button.field_146127_k) {
            case 0: {
                this.field_146297_k.func_147108_a(this.field_146307_h);
                break;
            }
            case 1: {
                DarkMeow.networkManager.connectLatestServer();
            }
        }
    }
}

