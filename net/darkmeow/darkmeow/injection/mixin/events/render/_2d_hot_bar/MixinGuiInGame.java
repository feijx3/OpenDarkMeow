/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 */
package net.darkmeow.darkmeow.injection.mixin.events.render._2d_hot_bar;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DHotBar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngame.class})
public abstract class MixinGuiInGame {
    @Shadow
    @Final
    protected Minecraft field_73839_d;
    @Unique
    public Render2DHotBar.PRE darkMeow_event;

    @Inject(method={"renderHotbar"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V", ordinal=0)}, cancellable=true)
    private void renderHotbar$callEvent$PRE(ScaledResolution sr, float partialTicks, CallbackInfo ci2) {
        Entity currentEntity = this.field_73839_d.func_175606_aa();
        if (currentEntity instanceof EntityPlayer) {
            Render2DHotBar.PRE event = new Render2DHotBar.PRE((EntityPlayer)currentEntity);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            } else {
                this.darkMeow_event = event;
            }
        }
    }

    @Redirect(method={"renderHotbar"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/NonNullList;get(I)Ljava/lang/Object;"))
    private Object renderHotbar$setHotBarItem(NonNullList<ItemStack> instance, int index) {
        return this.darkMeow_event.getHotBarItems().getOrDefault(index, ItemStack.field_190927_a);
    }

    @Redirect(method={"renderHotbar"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/player/EntityPlayer;getHeldItemOffhand()Lnet/minecraft/item/ItemStack;"))
    private ItemStack renderHotbar$setOffHandItem(EntityPlayer instance) {
        return this.darkMeow_event.getOffhandItem();
    }

    @Inject(method={"renderHotbar"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;disableBlend()V")})
    private void renderHotbar$callEvent$POST(ScaledResolution sr, float partialTicks, CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new Render2DHotBar.POST(this.darkMeow_event));
    }
}

