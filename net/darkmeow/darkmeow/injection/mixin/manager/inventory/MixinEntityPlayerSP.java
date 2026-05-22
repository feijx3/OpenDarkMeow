/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiContainer
 */
package net.darkmeow.darkmeow.injection.mixin.manager.inventory;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.container.ContainerCloseEvent;
import net.ccbluex.liquidbounce.event.events.container.ContainerOpenEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityPlayerSP.class})
public class MixinEntityPlayerSP {
    @Shadow
    protected Minecraft field_71159_c;

    @Redirect(method={"displayGUIChest", "displayGui", "displayVillagerTradeGui", "openGuiHorseInventory"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V"))
    public void displayGUIChest$redirectDisplay(Minecraft instance, GuiScreen screen) {
        GuiContainer containerScreen = (GuiContainer)screen;
        DarkMeow.inventoryManager.getContainerManager().setScreen(containerScreen);
        ContainerOpenEvent event = new ContainerOpenEvent(containerScreen);
        DarkMeow.eventManager.callEvent(event);
        if (event.getSilent()) {
            containerScreen.func_146280_a(this.field_71159_c, 0, 0);
            containerScreen.func_73866_w_();
        } else {
            instance.func_147108_a((GuiScreen)containerScreen);
        }
    }

    @Inject(method={"closeScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void closeScreen$call(CallbackInfo ci2) {
        GuiContainer containerScreen = DarkMeow.inventoryManager.getContainerManager().getScreen();
        if (containerScreen != null) {
            ContainerCloseEvent event = new ContainerCloseEvent(containerScreen);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
                this.field_71159_c.func_147108_a(null);
            }
        }
    }

    @Inject(method={"closeScreenAndDropStack"}, at={@At(value="HEAD")})
    public void closeScreenAndDropStack$clear(CallbackInfo ci2) {
        DarkMeow.inventoryManager.getContainerManager().setScreen(null);
    }
}

