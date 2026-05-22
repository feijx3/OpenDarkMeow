/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.entity;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.controller.ControllerDestroyBlockEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerStoppedUsingItemEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerSyncCurrentItemEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerTryUseItemEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerTryUseItemOnBlockEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityInteractAtEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityInteractEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerWindowClickEvent;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP {
    @Shadow
    @Final
    private Minecraft field_78776_a;
    @Shadow
    private int field_78777_l;
    @Unique
    public ControllerSyncCurrentItemEvent darkMeow$event$syncCurrentPlayItem;
    @Unique
    public ControllerUseEntityAttackEvent darkMeow$attackEntity;

    @Inject(method={"syncCurrentPlayItem"}, at={@At(value="FIELD", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;currentPlayerItem:I", ordinal=1)}, cancellable=true)
    public void syncCurrentPlayItem$pre(CallbackInfo ci2) {
        try {
            this.darkMeow$event$syncCurrentPlayItem = new ControllerSyncCurrentItemEvent(this.field_78776_a.field_71439_g.field_71071_by.field_70461_c, this.field_78777_l, new ArrayList<Function0<Unit>>());
            DarkMeow.eventManager.callEvent(this.darkMeow$event$syncCurrentPlayItem);
            if (this.darkMeow$event$syncCurrentPlayItem.isCancelled()) {
                ci2.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller sync current play item event.", e2);
        }
    }

    @Inject(method={"syncCurrentPlayItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/NetHandlerPlayClient;sendPacket(Lnet/minecraft/network/Packet;)V", shift=At.Shift.AFTER)})
    public void syncCurrentPlayItem$post(CallbackInfo ci2) {
        this.darkMeow$event$syncCurrentPlayItem.invokePostAction();
    }

    @Inject(method={"processRightClick"}, at={@At(value="HEAD")}, cancellable=true)
    public void processRightClick$HEAD(EntityPlayer player, World worldIn, EnumHand hand, CallbackInfoReturnable<EnumActionResult> cir) {
        try {
            ControllerTryUseItemEvent event = new ControllerTryUseItemEvent(player, worldIn, hand);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(EnumActionResult.PASS);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller try use item event.", e2);
        }
    }

    @Inject(method={"processRightClickBlock"}, at={@At(value="HEAD")}, cancellable=true)
    public void processRightClickBlock$HEAD(EntityPlayerSP player, WorldClient worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand, CallbackInfoReturnable<EnumActionResult> cir) {
        try {
            ControllerTryUseItemOnBlockEvent event = new ControllerTryUseItemOnBlockEvent((EntityPlayer)player, (World)worldIn, pos, direction, vec, hand);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(EnumActionResult.PASS);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller try use item on block event.", e2);
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void attackEntity$pre(EntityPlayer playerIn, Entity targetEntity, CallbackInfo ci2) {
        try {
            ControllerUseEntityAttackEvent event = new ControllerUseEntityAttackEvent(playerIn, targetEntity, false, new ArrayList<Function1<Entity, Unit>>());
            DarkMeow.eventManager.callEvent(event);
            this.darkMeow$attackEntity = event;
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller use entity attack event.", e2);
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="TAIL")})
    private void attackEntity$post(EntityPlayer playerIn, Entity targetEntity, CallbackInfo ci2) {
        this.darkMeow$attackEntity.invokePostAction();
    }

    @Inject(method={"attackEntity"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;syncCurrentPlayItem()V")}, cancellable=true)
    private void attackEntity$cancelSyncCurrentPlayItem(CallbackInfo ci2) {
        if (this.darkMeow$attackEntity.getCancelSyncCurrentItem()) {
            ci2.cancel();
        }
    }

    @Inject(method={"interactWithEntity(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/EnumHand;)Lnet/minecraft/util/EnumActionResult;"}, at={@At(value="HEAD")}, cancellable=true)
    public void interactWithEntity$HEAD$Interact(EntityPlayer player, Entity target, EnumHand hand, CallbackInfoReturnable<EnumActionResult> cir) {
        try {
            ControllerUseEntityInteractEvent event = new ControllerUseEntityInteractEvent(player, target, hand);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(EnumActionResult.PASS);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller use entity interact event.", e2);
        }
    }

    @Inject(method={"interactWithEntity(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/RayTraceResult;Lnet/minecraft/util/EnumHand;)Lnet/minecraft/util/EnumActionResult;"}, at={@At(value="HEAD")}, cancellable=true)
    public void interactWithEntity$HEAD$InteractAt(EntityPlayer player, Entity target, RayTraceResult ray, EnumHand hand, CallbackInfoReturnable<EnumActionResult> cir) {
        try {
            ControllerUseEntityInteractAtEvent event = new ControllerUseEntityInteractAtEvent(player, target, ray, hand);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(EnumActionResult.PASS);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller use entity interact at event.", e2);
        }
    }

    @Inject(method={"windowClick"}, at={@At(value="HEAD")}, cancellable=true)
    public void windowClick$HEAD(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player, CallbackInfoReturnable<ItemStack> cir) {
        try {
            ControllerWindowClickEvent event = new ControllerWindowClickEvent(player, windowId, slotId, mouseButton, type);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(ItemStack.field_190927_a);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller window click event.", e2);
        }
    }

    @Inject(method={"onPlayerDamageBlock"}, at={@At(value="HEAD")}, cancellable=true)
    public void onPlayerDamageBlock$callEvent(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        try {
            ControllerDestroyBlockEvent event = new ControllerDestroyBlockEvent(posBlock, directionFacing);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller destroy block event.", e2);
        }
    }

    @Inject(method={"onStoppedUsingItem"}, at={@At(value="HEAD")}, cancellable=true)
    public void onStoppedUsingItem$callEvent(EntityPlayer playerIn, CallbackInfo ci2) {
        try {
            ControllerStoppedUsingItemEvent event = new ControllerStoppedUsingItemEvent(playerIn);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call controller stopped using item event.", e2);
        }
    }
}

