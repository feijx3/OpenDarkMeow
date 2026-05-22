/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.MoreObjects
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.item;

import com.google.common.base.MoreObjects;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DItemInFirstPersonEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.AntiBlind;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
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

@SideOnly(value=Side.CLIENT)
@Mixin(value={ItemRenderer.class})
public abstract class MixinItemRenderer {
    @Shadow
    private float field_187470_g;
    @Shadow
    private float field_187472_i;
    @Shadow
    private float field_187471_h;
    @Shadow
    private float field_187469_f;
    @Unique
    public Render2DItemInFirstPersonEvent.PRE darkMeow$render2DItemInFirstPersonEvent;

    @Redirect(method={"renderItemInFirstPerson(F)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;getSwingProgress(F)F"))
    private float renderItemInFirstPerson$redirect$swingProgress(AbstractClientPlayer player, float partialTicks) {
        EnumHand hand = (EnumHand)MoreObjects.firstNonNull((Object)player.field_184622_au, (Object)EnumHand.MAIN_HAND);
        Render2DItemInFirstPersonEvent.PRE event = new Render2DItemInFirstPersonEvent.PRE(player, hand, player.func_70678_g(partialTicks), DarkMeow.inventoryManager.currentSpoofSlot == null ? player.func_184614_ca() : (ItemStack)player.field_71069_bz.func_75138_a().get(DarkMeow.inventoryManager.currentSpoofSlot + 36), player.func_184592_cb(), 1.0f - (this.field_187470_g + (this.field_187469_f - this.field_187470_g) * partialTicks), 1.0f - (this.field_187472_i + (this.field_187471_h - this.field_187472_i) * partialTicks), partialTicks);
        DarkMeow.eventManager.callEvent(event);
        this.darkMeow$render2DItemInFirstPersonEvent = event;
        return event.getSwingProgress();
    }

    @Redirect(method={"renderItemInFirstPerson(F)V"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/AbstractClientPlayer;swingingHand:Lnet/minecraft/util/EnumHand;"))
    private EnumHand renderItemInFirstPerson$redirect$swingHand(AbstractClientPlayer player, float partialTicks) {
        return this.darkMeow$render2DItemInFirstPersonEvent.getSwingHand();
    }

    @Redirect(method={"renderItemInFirstPerson(F)V"}, at=@At(value="FIELD", target="Lnet/minecraft/client/renderer/ItemRenderer;itemStackMainHand:Lnet/minecraft/item/ItemStack;"))
    private ItemStack renderItemInFirstPerson$redirect$itemStackMainHand(ItemRenderer instance) {
        return this.darkMeow$render2DItemInFirstPersonEvent.getItemStackMainHand();
    }

    @Redirect(method={"renderItemInFirstPerson(F)V"}, at=@At(value="FIELD", target="Lnet/minecraft/client/renderer/ItemRenderer;itemStackOffHand:Lnet/minecraft/item/ItemStack;"))
    private ItemStack renderItemInFirstPerson$redirect$itemStackOffHand(ItemRenderer instance) {
        return this.darkMeow$render2DItemInFirstPersonEvent.getItemStackOffHand();
    }

    @ModifyVariable(method={"renderItemInFirstPerson(F)V"}, at=@At(value="STORE", ordinal=0), ordinal=5)
    private float renderItemInFirstPerson$modifyVariable$equippedProgressMainHand(float value) {
        return this.darkMeow$render2DItemInFirstPersonEvent.getEquippedProgressMainHand();
    }

    @ModifyVariable(method={"renderItemInFirstPerson(F)V"}, at=@At(value="STORE", ordinal=1), ordinal=5)
    private float renderItemInFirstPerson$modifyVariable$equippedProgressOffHand(float value) {
        return this.darkMeow$render2DItemInFirstPersonEvent.getEquippedProgressOffHand();
    }

    @Redirect(method={"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/ItemRenderer;renderItemSide(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;Z)V"))
    private void renderItemInFirstPerson$redirect$render(ItemRenderer instance, EntityLivingBase player, ItemStack itemStack, ItemCameraTransforms.TransformType transformType, boolean leftHand) {
        Render2DItemInFirstPersonEvent.RenderItemSide.PRE event = new Render2DItemInFirstPersonEvent.RenderItemSide.PRE((AbstractClientPlayer)player, itemStack, transformType, leftHand, this.darkMeow$render2DItemInFirstPersonEvent);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            return;
        }
        instance.func_187462_a((EntityLivingBase)event.getPlayer(), event.getItemStack(), event.getTransformType(), event.getLeftHand());
        DarkMeow.eventManager.callEvent(new Render2DItemInFirstPersonEvent.RenderItemSide.POST(event));
    }

    @Inject(method={"renderFireInFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderFireInFirstPerson(CallbackInfo callbackInfo) {
        AntiBlind antiBlind = DarkMeow.moduleManager.getModule(AntiBlind.class);
        if (antiBlind.getState() && ((Boolean)antiBlind.getFireEffect().get()).booleanValue()) {
            callbackInfo.cancel();
        }
    }
}

