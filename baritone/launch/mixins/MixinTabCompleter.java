/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bje
 *  blq
 */
package baritone.launch.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={blq.class})
public abstract class MixinTabCompleter {
    @Shadow
    @Final
    protected bje a;
    @Shadow
    protected boolean d;
    @Unique
    protected boolean dontComplete = false;

    @Shadow
    public abstract void a(String ... var1);

    @Inject(method={"requestCompletions"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRequestCompletions(String string, CallbackInfo callbackInfo) {
    }
}

