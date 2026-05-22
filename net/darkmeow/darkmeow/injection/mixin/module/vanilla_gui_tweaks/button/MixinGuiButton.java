/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 */
package net.darkmeow.darkmeow.injection.mixin.module.vanilla_gui_tweaks.button;

import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.button.VanillaGuiTweaksModuleButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiButton.class})
public abstract class MixinGuiButton {
    @Shadow
    public int field_146128_h;
    @Shadow
    public int field_146129_i;
    @Shadow
    public int field_146120_f;
    @Shadow
    public int field_146121_g;
    @Shadow
    protected boolean field_146123_n;

    @Shadow
    protected abstract int func_146114_a(boolean var1);

    @Inject(method={"drawButton"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiButton;getHoverState(Z)I")}, cancellable=true)
    public void drawButton$render(Minecraft mc, int mouseX, int mouseY, float partialTicks, CallbackInfo ci2) {
        if (VanillaGuiTweaksModuleButton.INSTANCE.handleEvents()) {
            VanillaGuiTweaksModuleButton.handle((GuiButton)this, mc, this.func_146114_a(this.field_146123_n));
            ci2.cancel();
        }
    }
}

