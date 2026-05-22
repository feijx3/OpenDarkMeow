/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiNewChat
 */
package net.darkmeow.darkmeow.injection.mixin.module.vanilla_gui_tweaks.chat;

import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.chat.VanillaGuiTweaksModuleChatNoHistoryClear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Redirect(method={"displayGuiScreen"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiNewChat;clearChatMessages(Z)V"))
    public void displayGuiScreen$redirectClear(GuiNewChat instance, boolean state) {
        try {
            if (VanillaGuiTweaksModuleChatNoHistoryClear.INSTANCE.handleEvents()) {
                switch ((String)VanillaGuiTweaksModuleChatNoHistoryClear.modeValue.get()) {
                    case "OnlySendHistory": {
                        instance.func_146231_a(false);
                        break;
                    }
                }
            } else {
                instance.func_146231_a(state);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

