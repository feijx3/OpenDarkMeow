/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aeb
 *  ahw
 *  aip
 *  bhy
 *  bud
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.ChatEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.SprintStateEvent;
import baritone.api.event.events.type.Cancellable;
import baritone.api.event.events.type.EventState;
import baritone.api.utils.Rotation;
import baritone.e;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bud.class})
public class MixinEntityPlayerSP {
    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendChatMessage(String object, CallbackInfo callbackInfo) {
        object = new ChatEvent((String)object);
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (iBaritone == null) {
            return;
        }
        iBaritone.getGameEventHandler().onSendChatMessage((ChatEvent)object);
        if (((Cancellable)object).isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onUpdate"}, at={@At(value="INVOKE", target="net/minecraft/client/entity/AbstractClientPlayer.onUpdate()V", shift=At.Shift.AFTER)})
    private void onPreUpdate(CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (object != null) {
            object.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.PRE));
        }
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="FIELD", target="net/minecraft/entity/player/PlayerCapabilities.allowFlying:Z"))
    private boolean isAllowFlying(aeb aeb2) {
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (iBaritone == null) {
            return aeb2.c;
        }
        return !iBaritone.getPathingBehavior().isPathing() && aeb2.c;
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="net/minecraft/client/settings/KeyBinding.isKeyDown()Z"))
    private boolean isKeyDown(bhy bhy2) {
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (iBaritone == null) {
            return bhy2.e();
        }
        SprintStateEvent sprintStateEvent = new SprintStateEvent();
        iBaritone.getGameEventHandler().onPlayerSprintState(sprintStateEvent);
        if (sprintStateEvent.getState() != null) {
            return sprintStateEvent.getState();
        }
        if (iBaritone != BaritoneAPI.getProvider().getPrimaryBaritone()) {
            return false;
        }
        return bhy2.e();
    }

    @Inject(method={"updateRidden"}, at={@At(value="HEAD")})
    private void updateRidden(CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (object != null) {
            object = (e)object.getLookBehavior();
            if (((e)object).a != null) {
                Rotation rotation = ((e)object).a.peekRotation(((e)object).a.a);
                ((e)object).a.player().v = rotation.getYaw();
            }
        }
    }

    @Redirect(method={"onLivingUpdate"}, at=@At(value="INVOKE", target="net/minecraft/item/ItemElytra.isUsable(Lnet/minecraft/item/ItemStack;)Z"))
    private boolean isElytraUsable(aip aip2) {
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForPlayer((bud)this);
        if (iBaritone != null && iBaritone.getPathingBehavior().isPathing()) {
            return false;
        }
        return ahw.d((aip)aip2);
    }
}

