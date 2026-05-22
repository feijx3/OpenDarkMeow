/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiChat.class})
public abstract class MixinGuiChat
extends MixinGuiScreen {
    @Shadow
    protected GuiTextField field_146415_a;
    @Shadow
    private int field_146416_h;
    @Shadow
    private String field_146410_g;
    @Unique
    private float darkmeow$yPosOfInputField;
    @Unique
    private float darkmeow$fade = 0.0f;

    @Inject(method={"initGui"}, at={@At(value="RETURN")})
    private void init(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy || !GuiTweaks.isGuiChatFadeActive()) {
            return;
        }
        this.field_146415_a.field_146210_g = this.field_146295_m + 1;
        this.darkmeow$yPosOfInputField = this.field_146415_a.field_146210_g;
    }

    @Inject(method={"keyTyped"}, at={@At(value="HEAD")})
    private void keyTyped(char typedChar, int keyCode, CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (GuiTweaks.isGuiChatRemoveInputLengthLimitActive()) {
            this.field_146415_a.func_146203_f(114514);
        } else {
            this.field_146415_a.func_146203_f(100);
        }
    }

    @Inject(method={"updateScreen"}, at={@At(value="HEAD")})
    private void updateScreen(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy || !GuiTweaks.isGuiChatActive()) {
            return;
        }
        int delta = RenderUtils.deltaTime;
        if (this.darkmeow$fade < 14.0f) {
            this.darkmeow$fade = GuiTweaks.isGuiChatFadeActive() ? (this.darkmeow$fade += 0.4f * (float)delta) : 14.0f;
        }
        if (this.darkmeow$fade > 14.0f) {
            this.darkmeow$fade = 14.0f;
        }
        if (this.darkmeow$yPosOfInputField > (float)(this.field_146295_m - 12)) {
            this.darkmeow$yPosOfInputField = GuiTweaks.isGuiChatFadeActive() ? (this.darkmeow$yPosOfInputField -= 0.4f * (float)delta) : (this.darkmeow$yPosOfInputField -= (float)(this.field_146295_m - 12));
        }
        if (this.darkmeow$yPosOfInputField < (float)(this.field_146295_m - 12)) {
            this.darkmeow$yPosOfInputField = this.field_146295_m - 12;
        }
        this.field_146415_a.field_146210_g = (int)this.darkmeow$yPosOfInputField;
    }

    @Inject(method={"getSentHistory"}, at={@At(value="HEAD")}, cancellable=true)
    public void getSentHistory(int p_getSentHistory_1_, CallbackInfo ci2) {
        if (DarkMeow.isDestroy) {
            return;
        }
        int i2 = this.field_146416_h + p_getSentHistory_1_;
        int j2 = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
        if ((i2 = MathHelper.func_76125_a((int)i2, (int)0, (int)j2)) != this.field_146416_h) {
            if (i2 == j2) {
                this.field_146416_h = j2;
                this.darkmeow$setText(this.field_146410_g);
            } else {
                if (this.field_146416_h == j2) {
                    this.field_146410_g = this.field_146415_a.func_146179_b();
                }
                this.darkmeow$setText((String)this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().get(i2));
                this.field_146416_h = i2;
            }
        }
        ci2.cancel();
    }

    @Unique
    private void darkmeow$setText(String text) {
        if (text.startsWith(String.valueOf(DarkMeow.commandManager.getPrefix()))) {
            this.field_146415_a.func_146203_f(114514);
        } else if (GuiTweaks.isGuiChatRemoveInputLengthLimitActive()) {
            this.field_146415_a.func_146203_f(114514);
        } else {
            this.field_146415_a.func_146203_f(100);
        }
        this.field_146415_a.func_146180_a(text);
    }
}

