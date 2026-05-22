/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiNewChat
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.render.add_message;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.AddMessageEvent;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiNewChat.class})
public abstract class MixinGuiNewChat {
    @Inject(method={"printChatMessageWithOptionalDeletion"}, at={@At(value="HEAD")}, cancellable=true)
    private void printChatMessageWithOptionalDeletion$callEvent(ITextComponent component, int id, CallbackInfo ci2) {
        AddMessageEvent event = new AddMessageEvent(component, id);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }
}

