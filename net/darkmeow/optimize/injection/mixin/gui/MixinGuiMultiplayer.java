/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.optimize.injection.mixin.gui;

import net.darkmeow.optimize.injection.mixin.gui.MixinGuiScreen;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiMultiplayer.class})
public class MixinGuiMultiplayer
extends MixinGuiScreen {
    @Inject(method={"connectToServer"}, at={@At(value="HEAD")})
    private void connectToServer$fixMultiConnect(CallbackInfo ci2) {
        try {
            this.field_146297_k.field_71441_e.func_72882_A();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

