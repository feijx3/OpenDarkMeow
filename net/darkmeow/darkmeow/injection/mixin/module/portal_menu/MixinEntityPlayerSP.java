/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 */
package net.darkmeow.darkmeow.injection.mixin.module.portal_menu;

import net.ccbluex.liquidbounce.features.module.modules.exploit.PortalMenu;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={EntityPlayerSP.class})
public class MixinEntityPlayerSP {
    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiScreen;doesGuiPauseGame()Z"))
    private boolean onLivingUpdate$cancelPortalCloseScreen(GuiScreen instance) {
        return PortalMenu.INSTANCE.getState() || instance.func_73868_f();
    }
}

