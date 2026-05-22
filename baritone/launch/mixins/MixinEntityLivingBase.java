/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  bud
 *  vg
 *  vp
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.RotationMoveEvent;
import java.util.Optional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={vp.class})
public abstract class MixinEntityLivingBase
extends vg {
    @Unique
    private RotationMoveEvent jumpRotationEvent;
    @Unique
    private RotationMoveEvent elytraRotationEvent;

    private MixinEntityLivingBase(amu amu2) {
        super(amu2);
    }

    @Inject(method={"jump"}, at={@At(value="HEAD")})
    private void preMoveRelative(CallbackInfo callbackInfo) {
        this.getBaritone().ifPresent(iBaritone -> {
            this.jumpRotationEvent = new RotationMoveEvent(RotationMoveEvent.Type.JUMP, this.v, this.w);
            iBaritone.getGameEventHandler().onPlayerRotationMove(this.jumpRotationEvent);
        });
    }

    @Redirect(method={"jump"}, at=@At(value="FIELD", opcode=180, target="net/minecraft/entity/EntityLivingBase.rotationYaw:F"))
    private float overrideYaw(vp vp2) {
        if (vp2 instanceof bud && BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this) != null) {
            return this.jumpRotationEvent.getYaw();
        }
        return vp2.v;
    }

    @Inject(method={"travel"}, at={@At(value="INVOKE", target="net/minecraft/entity/EntityLivingBase.getLookVec()Lnet/minecraft/util/math/Vec3d;")})
    private void onPreElytraMove(float f2, float f3, float f4, CallbackInfo callbackInfo) {
        this.getBaritone().ifPresent(iBaritone -> {
            this.elytraRotationEvent = new RotationMoveEvent(RotationMoveEvent.Type.MOTION_UPDATE, this.v, this.w);
            iBaritone.getGameEventHandler().onPlayerRotationMove(this.elytraRotationEvent);
            this.v = this.elytraRotationEvent.getYaw();
            this.w = this.elytraRotationEvent.getPitch();
        });
    }

    @Inject(method={"travel"}, at={@At(value="INVOKE", target="net/minecraft/entity/EntityLivingBase.move(Lnet/minecraft/entity/MoverType;DDD)V", shift=At.Shift.AFTER)})
    private void onPostElytraMove(float f2, float f3, float f4, CallbackInfo callbackInfo) {
        if (this.elytraRotationEvent != null) {
            this.v = this.elytraRotationEvent.getOriginal().getYaw();
            this.w = this.elytraRotationEvent.getOriginal().getPitch();
            this.elytraRotationEvent = null;
        }
    }

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="net/minecraft/entity/EntityLivingBase.moveRelative(FFFF)V"))
    private void onMoveRelative(vp object, float f2, float f3, float f4, float f5) {
        object = this.getBaritone();
        if (!((Optional)object).isPresent()) {
            this.b(f2, f3, f4, f5);
            return;
        }
        RotationMoveEvent rotationMoveEvent = new RotationMoveEvent(RotationMoveEvent.Type.MOTION_UPDATE, this.v, this.w);
        ((IBaritone)((Optional)object).get()).getGameEventHandler().onPlayerRotationMove(rotationMoveEvent);
        this.v = rotationMoveEvent.getYaw();
        this.w = rotationMoveEvent.getPitch();
        this.b(f2, f3, f4, f5);
        this.v = rotationMoveEvent.getOriginal().getYaw();
        this.w = rotationMoveEvent.getOriginal().getPitch();
    }

    @Unique
    private Optional<IBaritone> getBaritone() {
        if (bud.class.isInstance((Object)this)) {
            return Optional.ofNullable(BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this));
        }
        return Optional.empty();
    }
}

