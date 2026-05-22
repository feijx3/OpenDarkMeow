/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiScreen.class})
public abstract class MixinGuiScreen {
    @Shadow
    public Minecraft field_146297_k;
    @Shadow
    protected List<GuiButton> field_146292_n;
    @Shadow
    public int field_146294_l;
    @Shadow
    public int field_146295_m;
    @Shadow
    protected FontRenderer field_146289_q;

    @Shadow
    public abstract void func_146283_a(List<String> var1, int var2, int var3);

    @Shadow
    public abstract void func_146276_q_();

    @Inject(method={"drawWorldBackground"}, at={@At(value="HEAD")}, cancellable=true)
    private void drawWorldBackground(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (GuiTweaks.isGuiContainerActive() && GuiTweaks.guiContainerRemoveBackgroundValue.get().booleanValue() && this.field_146297_k.field_71462_r instanceof GuiContainer) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"drawBackground"}, at={@At(value="HEAD")}, cancellable=true)
    private void drawClientBackground(CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        try {
            GlStateManager.func_179140_f();
            GlStateManager.func_179106_n();
            DarkMeow.fileManager.backgroundManager.doRender();
            int width = StaticStorage.scaledResolution.func_78326_a();
            int height = StaticStorage.scaledResolution.func_78328_b();
            Gui.func_152125_a((int)0, (int)0, (float)0.0f, (float)0.0f, (int)width, (int)height, (int)width, (int)height, (float)width, (float)height);
            callbackInfo.cancel();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"handleComponentHover"}, at={@At(value="HEAD")})
    private void handleHoverOverComponent(ITextComponent component, int x2, int y2, CallbackInfo callbackInfo) {
        if (DarkMeow.isDestroy) {
            return;
        }
        if (component == null || component.func_150256_b().func_150235_h() == null || !GuiTweaks.isGuiTextComponentOnHoverActive()) {
            return;
        }
        Style chatStyle = component.func_150256_b();
        ClickEvent clickEvent = chatStyle.func_150235_h();
        HoverEvent hoverEvent = chatStyle.func_150210_i();
        this.func_146283_a(Collections.singletonList("\u00a7c\u00a7l" + clickEvent.func_150669_a().func_150673_b().toUpperCase() + ": \u00a7a" + clickEvent.func_150668_b()), x2, y2 - (hoverEvent != null ? 17 : 0));
    }

    @Shadow
    protected void func_73869_a(char typedChar, int keyCode) throws IOException {
    }
}

