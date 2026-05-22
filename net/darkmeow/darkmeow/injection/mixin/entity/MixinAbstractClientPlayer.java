/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.entity;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.RenderFovModifierEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityPlayerSkinEvent;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinEntityPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer
extends MixinEntityPlayer {
    @Shadow
    private NetworkPlayerInfo field_175157_a;

    @Inject(method={"getLocationCape"}, at={@At(value="RETURN")}, cancellable=true)
    public void getCape(CallbackInfoReturnable<ResourceLocation> cir) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            RenderEntityPlayerSkinEvent.Cape event = new RenderEntityPlayerSkinEvent.Cape(this.field_175157_a, cir.getReturnValue());
            DarkMeow.eventManager.callEvent(event);
            if (event.isChanged()) {
                cir.setReturnValue((ResourceLocation)event.getReturnValue());
                cir.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"}, at={@At(value="RETURN")}, cancellable=true)
    public void getSkin(CallbackInfoReturnable<ResourceLocation> cir) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            RenderEntityPlayerSkinEvent.Skin event = new RenderEntityPlayerSkinEvent.Skin(this.field_175157_a, cir.getReturnValue());
            DarkMeow.eventManager.callEvent(event);
            if (event.isChanged()) {
                cir.setReturnValue((ResourceLocation)event.getReturnValue());
                cir.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"getSkinType"}, at={@At(value="RETURN")}, cancellable=true)
    public void getSkinType(CallbackInfoReturnable<String> cir) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            RenderEntityPlayerSkinEvent.SkinType event = new RenderEntityPlayerSkinEvent.SkinType(this.field_175157_a, RenderEntityPlayerSkinEvent.SkinType.Type.fromVanillaName(cir.getReturnValue()));
            DarkMeow.eventManager.callEvent(event);
            if (event.isChanged()) {
                cir.setReturnValue(((RenderEntityPlayerSkinEvent.SkinType.Type)((Object)event.getReturnValue())).getVanillaName());
                cir.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"getFovModifier"}, at={@At(value="RETURN")}, cancellable=true)
    public void getFovModifier(CallbackInfoReturnable<Float> cir) {
        RenderFovModifierEvent event = new RenderFovModifierEvent(cir.getReturnValue().floatValue());
        DarkMeow.eventManager.callEvent(event);
        if (event.isChanged()) {
            cir.setReturnValue((Float)event.getReturnValue());
        }
    }
}

