/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiTextField
 */
package net.darkmeow.darkmeow.injection.mixin.module.vanilla_gui_tweaks.chat;

import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.chat.VanillaGuiTweaksModuleChatKeepInput;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiChat.class})
public abstract class MixinGuiChat {
    @Unique
    public boolean darkMeow$messageSent = false;
    @Shadow
    protected GuiTextField field_146415_a;
    @Shadow
    private String field_146409_v;

    @Inject(method={"<init>()V"}, at={@At(value="RETURN")})
    public void init$setLastSavedMessage(CallbackInfo ci2) {
        try {
            if (VanillaGuiTweaksModuleChatKeepInput.INSTANCE.handleEvents()) {
                this.field_146409_v = VanillaGuiTweaksModuleChatKeepInput.message;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"onGuiClosed"}, at={@At(value="TAIL")})
    public void onGuiClosed$saveMessage(CallbackInfo ci2) {
        try {
            if (VanillaGuiTweaksModuleChatKeepInput.INSTANCE.handleEvents()) {
                VanillaGuiTweaksModuleChatKeepInput.message = this.darkMeow$messageSent ? "" : this.field_146415_a.func_146179_b();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"keyTyped"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V", ordinal=0)})
    public void keyTyped$lonPressEsc(char typedChar, int keyCode, CallbackInfo ci2) {
        if (((Boolean)VanillaGuiTweaksModuleChatKeepInput.onlyRemoteCloseValue.get()).booleanValue()) {
            this.darkMeow$messageSent = true;
        }
    }

    @Inject(method={"keyTyped"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V", ordinal=1)})
    public void keyTyped$logSent(char typedChar, int keyCode, CallbackInfo ci2) {
        this.darkMeow$messageSent = true;
    }
}

