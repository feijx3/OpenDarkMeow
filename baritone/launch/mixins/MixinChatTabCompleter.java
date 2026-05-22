/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bkn$a
 */
package baritone.launch.mixins;

import baritone.launch.mixins.MixinTabCompleter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bkn.a.class})
public abstract class MixinChatTabCompleter
extends MixinTabCompleter {
    @Inject(method={"complete"}, at={@At(value="HEAD")}, cancellable=true)
    private void onComplete(CallbackInfo callbackInfo) {
        if (this.dontComplete) {
            callbackInfo.cancel();
        }
    }
}

