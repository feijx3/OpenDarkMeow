/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.MovementInputFromOptions
 */
package net.darkmeow.darkmeow.injection.mixin.util;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.darkmeow.darkmeow.injection.mixin.util.MixinMovementInput;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MovementInputFromOptions.class})
public class MixinMovementInputFromOptions
extends MixinMovementInput {
    @Shadow
    @Final
    private GameSettings field_78903_e;
    @Unique
    public MovementInputEvent.PRE darkMeow_movementInputEvent;

    @Inject(method={"updatePlayerMoveState"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=0)}, cancellable=true)
    private void onUpdatePlayerMoveState$callEvent$Pre(CallbackInfo ci2) {
        MovementInputEvent.PRE event = new MovementInputEvent.PRE(this.field_78903_e.field_74351_w.func_151470_d(), this.field_78903_e.field_74368_y.func_151470_d(), this.field_78903_e.field_74370_x.func_151470_d(), this.field_78903_e.field_74366_z.func_151470_d(), this.field_78903_e.field_74314_A.func_151470_d(), this.field_78903_e.field_74311_E.func_151470_d());
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
            DarkMeow.eventManager.callEvent(new MovementInputEvent.POST((MovementInput)this, true));
        } else {
            this.darkMeow_movementInputEvent = event;
        }
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=0))
    private boolean onUpdatePlayerMoveState$redirect$forward(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateForward();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=1))
    private boolean onUpdatePlayerMoveState$redirect$Back(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateBack();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=2))
    private boolean onUpdatePlayerMoveState$redirect$left(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateLeft();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=3))
    private boolean onUpdatePlayerMoveState$redirect$right(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateRight();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=4))
    private boolean onUpdatePlayerMoveState$redirect$jump(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateJump();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=5))
    private boolean onUpdatePlayerMoveState$redirect$sneak(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.getKeyStateSneak();
    }

    @Redirect(method={"updatePlayerMoveState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=5))
    private boolean onUpdatePlayerMoveState$redirect$shouldApplySneakSlow(KeyBinding instance) {
        return this.darkMeow_movementInputEvent.shouldApplySneakSlow;
    }

    @Inject(method={"updatePlayerMoveState"}, at={@At(value="RETURN")})
    private void onUpdatePlayerMoveState$callEvent$Post(CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new MovementInputEvent.POST((MovementInput)this, false));
    }
}

