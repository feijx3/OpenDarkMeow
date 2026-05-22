/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiOverlayDebug
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import java.util.List;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.gui.RenderGuiOverlayDebugEvent;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiOverlayDebug.class})
public abstract class MixinGuiOverlayDebug {
    @Unique
    public boolean darkMeow_updating;
    @Unique
    public RenderGuiOverlayDebugEvent darkMeow_event;

    @Shadow
    protected abstract List<String> func_175238_c();

    @Inject(method={"call"}, at={@At(value="RETURN")}, cancellable=true)
    public void call$callEvent(CallbackInfoReturnable<List<String>> cir) {
        if (!this.darkMeow_updating) {
            this.darkMeow_updating = true;
            RenderGuiOverlayDebugEvent event = new RenderGuiOverlayDebugEvent(cir.getReturnValue(), this.func_175238_c());
            this.darkMeow_updating = false;
            DarkMeow.eventManager.callEvent(event);
            this.darkMeow_event = event;
            cir.setReturnValue(event.getLeft());
            cir.cancel();
        }
    }

    @Inject(method={"getDebugInfoRight"}, at={@At(value="HEAD")}, cancellable=true)
    public void getDebugInfoRight$redirect(CallbackInfoReturnable<List<String>> cir) {
        if (!this.darkMeow_updating) {
            cir.setReturnValue(this.darkMeow_event.getRight());
            cir.cancel();
        }
    }
}

