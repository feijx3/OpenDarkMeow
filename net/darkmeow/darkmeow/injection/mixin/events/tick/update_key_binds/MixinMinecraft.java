/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.tick.update_key_binds;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.tick.TickInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Unique
    private final GuiScreen darkMeow$fakeScreen = new GuiChat();
    @Shadow
    public GameSettings field_71474_y;
    @Unique
    public boolean darkMeow$event$allowUserInput;

    @Redirect(method={"runTick"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;currentScreen:Lnet/minecraft/client/gui/GuiScreen;", ordinal=9))
    private GuiScreen processTick$allowUserInput$currentScreen(Minecraft instance) {
        try {
            TickInputEvent.AllowUserInput event = new TickInputEvent.AllowUserInput(instance, instance.field_71462_r, instance.field_71462_r == null || instance.field_71462_r.field_146291_p);
            DarkMeow.eventManager.callEvent(event);
            this.darkMeow$event$allowUserInput = (Boolean)event.getReturnValue();
            return this.darkMeow$event$allowUserInput ? (instance.field_71462_r != null ? instance.field_71462_r : this.darkMeow$fakeScreen) : null;
        }
        catch (Throwable ignored) {
            return instance.field_71462_r;
        }
    }

    @Redirect(method={"runTick"}, at=@At(value="FIELD", target="Lnet/minecraft/client/gui/GuiScreen;allowUserInput:Z"))
    private boolean processTick$allowUserInput$allowUserInput(GuiScreen instance) {
        return this.darkMeow$event$allowUserInput;
    }

    @Inject(method={"runTickKeyboard"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;processKeyBinds()V")})
    private void processKeyBinds$callEvent(CallbackInfo ci2) {
        try {
            TickInputEvent.UpdateKeyboard event = new TickInputEvent.UpdateKeyboard(this.field_71474_y);
            DarkMeow.eventManager.callEvent(event);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

