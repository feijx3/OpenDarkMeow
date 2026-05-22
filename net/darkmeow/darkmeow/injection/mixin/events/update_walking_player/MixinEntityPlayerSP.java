/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.update_walking_player;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.darkmeow.darkmeow.injection.mixin.entity.MixinAbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP
extends MixinAbstractClientPlayer {
    @Shadow
    private double field_175172_bI;
    @Shadow
    private double field_175166_bJ;
    @Shadow
    private double field_175167_bK;
    @Shadow
    private float field_175164_bL;
    @Shadow
    private float field_175165_bM;
    @Shadow
    private boolean field_184841_cd;
    @Shadow
    private boolean field_175171_bO;
    @Shadow
    private boolean field_175170_bN;
    @Shadow
    private int field_175168_bP;
    @Unique
    public PlayerSPUpdateWalkingEvent.PRE darkMeow$event;

    @Shadow
    protected abstract boolean func_175160_A();

    @Inject(method={"onUpdateWalkingPlayer"}, at={@At(value="HEAD")}, cancellable=true)
    private void onUpdateWalkingPlayer$callEvent$Pre(CallbackInfo ci2) {
        try {
            EntityPlayerSP player = (EntityPlayerSP)this;
            PlayerSPUpdateWalkingEvent.PRE event = new PlayerSPUpdateWalkingEvent.PRE(player, this.func_175160_A(), this.field_175171_bO, this.field_175170_bN, this.field_175172_bI, this.field_175166_bJ, this.field_175167_bK, this.field_175164_bL, this.field_175165_bM, this.field_184841_cd, this.field_175168_bP, this.func_70051_ag(), this.func_70093_af(), this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v, this.field_70177_z, this.field_70125_A, this.field_70122_E);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
                DarkMeow.eventManager.callEvent(new PlayerSPUpdateWalkingEvent.POST(event));
            } else {
                this.darkMeow$event = event;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isCurrentViewEntity()Z"))
    private boolean onUpdateWalkingPlayer$redirect$syncPosition(EntityPlayerSP instance) {
        return this.darkMeow$event.syncPosition;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isSprinting()Z"))
    private boolean onUpdateWalkingPlayer$redirect$sprintState(EntityPlayerSP instance) {
        return this.darkMeow$event.sprintState;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isSneaking()Z"))
    private boolean onUpdateWalkingPlayer$redirect$sneakState(EntityPlayerSP instance) {
        return this.darkMeow$event.sneakState;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/EntityPlayerSP;posX:D"))
    private double onUpdateWalkingPlayer$redirect$posX(EntityPlayerSP instance) {
        return this.darkMeow$event.posX;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/util/math/AxisAlignedBB;minY:D"))
    private double onUpdateWalkingPlayer$redirect$posY(AxisAlignedBB instance) {
        return this.darkMeow$event.posY;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/EntityPlayerSP;posZ:D"))
    private double onUpdateWalkingPlayer$redirect$posZ(EntityPlayerSP instance) {
        return this.darkMeow$event.posZ;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/EntityPlayerSP;rotationYaw:F"))
    private float onUpdateWalkingPlayer$redirect$rotationYaw(EntityPlayerSP instance) {
        return this.darkMeow$event.rotationYaw;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/EntityPlayerSP;rotationPitch:F"))
    private float onUpdateWalkingPlayer$redirect$rotationPitch(EntityPlayerSP instance) {
        return this.darkMeow$event.rotationPitch;
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="FIELD", target="Lnet/minecraft/client/entity/EntityPlayerSP;onGround:Z"))
    private boolean onUpdateWalkingPlayer$redirect$onGround(EntityPlayerSP instance) {
        return this.darkMeow$event.onGround;
    }

    @Inject(method={"onUpdateWalkingPlayer"}, at={@At(value="RETURN")})
    private void onUpdateWalkingPlayer$callEvent$Post(CallbackInfo ci2) {
        try {
            DarkMeow.eventManager.callEvent(new PlayerSPUpdateWalkingEvent.POST(this.darkMeow$event));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

