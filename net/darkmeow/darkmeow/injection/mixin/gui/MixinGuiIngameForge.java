/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.client.GuiIngameForge
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.ui.client.minecraft.ingame.PlayerList;
import net.darkmeow.darkmeow.injection.mixin.gui.MixinGuiInGame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiIngameForge.class})
public abstract class MixinGuiIngameForge
extends MixinGuiInGame {
    @Unique
    private float darkMeow$xScale = 0.0f;

    @Shadow(remap=false)
    protected abstract boolean pre(RenderGameOverlayEvent.ElementType var1);

    @Shadow(remap=false)
    protected abstract void post(RenderGameOverlayEvent.ElementType var1);

    @Inject(method={"renderChat"}, slice={@Slice(from=@At(value="INVOKE", target="Lnet/minecraftforge/fml/common/eventhandler/EventBus;post(Lnet/minecraftforge/fml/common/eventhandler/Event;)Z", ordinal=0, remap=false))}, at={@At(value="RETURN", ordinal=0)}, remap=false)
    private void fixProfilerSectionNotEnding(int width, int height, CallbackInfo ci2) {
        Minecraft mc = Minecraft.func_71410_x();
        if (mc.field_71424_I.func_76322_c().endsWith("chat")) {
            mc.field_71424_I.func_76319_b();
        }
    }

    @Inject(method={"renderExperience"}, at={@At(value="HEAD")}, remap=false)
    private void enableExperienceAlpha(int filled, int top, CallbackInfo ci2) {
        GlStateManager.func_179141_d();
    }

    @Inject(method={"renderExperience"}, at={@At(value="RETURN")}, remap=false)
    private void disableExperienceAlpha(int filled, int top, CallbackInfo ci2) {
        GlStateManager.func_179118_c();
    }

    @Inject(method={"renderPlayerList"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private void renderPlayerList(int width, int height, CallbackInfo ci2) {
        if (GuiTweaks.isGuiTabPlayerListActive()) {
            PlayerList.render(width, height, this.field_175196_v, this::pre, type -> {
                this.post((RenderGameOverlayEvent.ElementType)type);
                return true;
            }, () -> Float.valueOf(this.darkMeow$xScale), value -> {
                this.darkMeow$xScale = value.floatValue();
                return true;
            });
            ci2.cancel();
        }
    }
}

