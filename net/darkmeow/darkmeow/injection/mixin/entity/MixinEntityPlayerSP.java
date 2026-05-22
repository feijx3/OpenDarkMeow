/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.MoverType
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.FoodStats
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.entity;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.event.PushOutEvent;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.event.events.player.move.SlowDownEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
import net.ccbluex.liquidbounce.features.module.modules.render.NoSwing;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinAbstractClientPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.MoverType;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityPlayerSP.class}, priority=0x7FFFFFFF)
public abstract class MixinEntityPlayerSP
extends MixinAbstractClientPlayer {
    @Shadow
    private boolean field_184842_cm;
    @Shadow
    @Final
    public NetHandlerPlayClient field_71174_a;
    @Shadow
    protected Minecraft field_71159_c;

    @Override
    @Shadow
    public abstract boolean func_70093_af();

    @Shadow
    protected abstract void func_189810_i(float var1, float var2);

    @Inject(method={"isCurrentViewEntity"}, at={@At(value="HEAD")}, cancellable=true)
    protected void isCurrentViewEntity(CallbackInfoReturnable<Boolean> cir) {
        if (FreeCam.INSTANCE.getState()) {
            cir.setReturnValue(this.field_71159_c.func_175606_aa() == FreeCam.camera);
        }
    }

    @Deprecated
    @Inject(method={"onUpdate"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;onUpdateWalkingPlayer()V", shift=At.Shift.BEFORE)}, cancellable=true)
    private void onUpdate$INVOKE$OnUpdateWalkingPlayer$PRE(CallbackInfo ci2) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            MotionEvent event = new MotionEvent(EventState.PRE);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Deprecated
    @Inject(method={"onUpdate"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;onUpdateWalkingPlayer()V", shift=At.Shift.AFTER)})
    private void onUpdate$INVOKE$OnUpdateWalkingPlayer$POST(CallbackInfo ci2) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            MotionEvent event = new MotionEvent(EventState.POST);
            DarkMeow.eventManager.callEvent(event);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"swingArm"}, at={@At(value="HEAD")}, cancellable=true)
    private void swingItem(EnumHand hand, CallbackInfo callbackInfo) {
        NoSwing noSwing = DarkMeow.moduleManager.getModule(NoSwing.class);
        if (noSwing == null) {
            return;
        }
        if (noSwing.getState()) {
            callbackInfo.cancel();
            if (!((Boolean)noSwing.getServerSideValue().get()).booleanValue()) {
                this.field_71174_a.func_147297_a((Packet)new CPacketAnimation(hand));
            }
        }
    }

    @Inject(method={"pushOutOfBlocks"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPushOutOfBlocks(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        PushOutEvent event = new PushOutEvent();
        if (this.field_70145_X) {
            event.cancelEvent();
        }
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"onUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void onUpdate$HEAD(CallbackInfo ci2) {
        try {
            if (DarkMeow.updateManager.callUpdateEvent((EntityPlayerSP)this)) {
                ci2.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z", ordinal=0))
    private boolean onLivingUpdate$onSlowDown(EntityPlayerSP player) {
        boolean slowDown = this.field_184842_cm || this.func_184614_ca().func_77973_b() instanceof ItemSword && this.field_71159_c.field_71474_y.field_74313_G.func_151470_d();
        try {
            if (slowDown) {
                Item item = this.field_184842_cm ? player.func_184586_b(player.func_184600_cs()).func_77973_b() : Items.field_151048_u;
                SlowDownEvent event = new SlowDownEvent(player, SlowDownEvent.SlowDownType.getSlowDownTypeByItem(item));
                DarkMeow.eventManager.callEvent(event);
                return !event.isCancelled();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return slowDown;
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isPotionActive(Lnet/minecraft/potion/Potion;)Z", ordinal=1))
    private boolean onLivingUpdate$sprintIgnoreBlindness1(EntityPlayerSP instance, Potion potion) {
        try {
            if (!DarkMeow.isDestroy && potion == MobEffects.field_76440_q) {
                Sprint sprint = DarkMeow.moduleManager.getModule(Sprint.class);
                if (sprint == null) {
                    throw new Throwable("ignored");
                }
                if (sprint.getState() && ((Boolean)sprint.getCheckBlindnessValue().get()).booleanValue()) {
                    return false;
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return instance.func_70644_a(potion);
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isPotionActive(Lnet/minecraft/potion/Potion;)Z", ordinal=2))
    private boolean onLivingUpdate$sprintIgnoreBlindness2(EntityPlayerSP instance, Potion potion) {
        return this.onLivingUpdate$sprintIgnoreBlindness1(instance, potion);
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;getFoodStats()Lnet/minecraft/util/FoodStats;"))
    private FoodStats onLivingUpdate$sprintIgnoreHungry(EntityPlayerSP instance) {
        try {
            if (!DarkMeow.isDestroy) {
                Sprint sprint = DarkMeow.moduleManager.getModule(Sprint.class);
                if (sprint == null) {
                    throw new Throwable("ignored");
                }
                if (sprint.getState() && ((Boolean)sprint.getCheckHungryValue().get()).booleanValue()) {
                    return new FoodStats();
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return instance.func_71024_bL();
    }

    @Inject(method={"move"}, at={@At(value="HEAD")}, cancellable=true)
    public void move(MoverType type, double x2, double y2, double z2, CallbackInfo ci2) {
        ci2.cancel();
        MoveEvent event = new MoveEvent(type, x2, y2, z2);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            return;
        }
        DarkMeow.movementManager.setSafeWalk(event.isSafeWalk());
        double prevX = this.field_70165_t;
        double prevZ = this.field_70161_v;
        super.func_70091_d(type, event.getX(), event.getY(), event.getZ());
        if (!event.getNoAutoJump()) {
            this.func_189810_i((float)(this.field_70165_t - prevX), (float)(this.field_70161_v - prevZ));
        }
    }
}

