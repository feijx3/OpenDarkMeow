/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.play.server.SPacketWindowItems
 */
package net.darkmeow.darkmeow.injection.mixin.manager.inventory;

import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.manager.inventory.ContainerManager;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.SPacketWindowItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetHandlerPlayClient.class})
public class MixinNetHandlerPlayClient {
    @Inject(method={"handleWindowItems"}, at={@At(value="HEAD")})
    public void handleWindowItems$mark(SPacketWindowItems packetIn, CallbackInfo ci2) {
        ContainerManager manager = DarkMeow.inventoryManager.getContainerManager();
        GuiContainer screen = manager.getScreen();
        if (screen != null && screen.field_147002_h.field_75152_c == packetIn.func_148911_c()) {
            manager.setReadyWindowItems(true);
        }
    }
}

