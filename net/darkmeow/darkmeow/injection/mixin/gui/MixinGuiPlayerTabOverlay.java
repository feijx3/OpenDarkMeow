/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.gui;

import java.util.List;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={GuiPlayerTabOverlay.class})
public abstract class MixinGuiPlayerTabOverlay {
    @Shadow
    private ITextComponent field_175256_i;
    @Shadow
    private ITextComponent field_175255_h;
    @Unique
    public Render2DPlayerTabOverlayEvent.PRE darkMeow$event;

    @ModifyVariable(method={"renderPlayerlist"}, at=@At(value="STORE", ordinal=0))
    private List<NetworkPlayerInfo> renderPlayerlist$callEvent$PRE(List<NetworkPlayerInfo> list) {
        Render2DPlayerTabOverlayEvent.PRE event = new Render2DPlayerTabOverlayEvent.PRE(list, this.field_175256_i, this.field_175255_h);
        DarkMeow.eventManager.callEvent(event);
        this.darkMeow$event = event;
        return event.getList();
    }

    @Inject(method={"getPlayerName"}, at={@At(value="HEAD")}, cancellable=true)
    private void getPlayerName$setName(NetworkPlayerInfo info, CallbackInfoReturnable<String> cir) {
        if (this.darkMeow$event.getOverwriteNames().containsKey(info)) {
            cir.setReturnValue(this.darkMeow$event.getOverwriteNames().get(info));
            cir.cancel();
        }
    }

    @Redirect(method={"renderPlayerlist"}, at=@At(value="FIELD", target="Lnet/minecraft/client/gui/GuiPlayerTabOverlay;header:Lnet/minecraft/util/text/ITextComponent;"))
    private ITextComponent renderPlayerlist$setHeader(GuiPlayerTabOverlay instance) {
        return this.darkMeow$event.getHeader();
    }

    @Redirect(method={"renderPlayerlist"}, at=@At(value="FIELD", target="Lnet/minecraft/client/gui/GuiPlayerTabOverlay;footer:Lnet/minecraft/util/text/ITextComponent;"))
    private ITextComponent renderPlayerlist$setFooter(GuiPlayerTabOverlay instance) {
        return this.darkMeow$event.getFooter();
    }

    @Inject(method={"renderPlayerlist"}, at={@At(value="RETURN")})
    private void renderPlayerlist$callEvent$POST(CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new Render2DPlayerTabOverlayEvent.POST());
    }
}

