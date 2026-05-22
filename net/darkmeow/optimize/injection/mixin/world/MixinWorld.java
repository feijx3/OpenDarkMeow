/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package net.darkmeow.optimize.injection.mixin.world;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"isSpawnChunk(II)Z"}, at={@At(value="HEAD")}, cancellable=true, require=0, expect=0)
    public void isSpawnChunk$HEAD$skipLoadingWorldScreen(int x2, int z2, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method={"getHorizon"}, at={@At(value="HEAD")}, cancellable=true)
    public void getHorizon$removeVoidRender(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(-9999999.0);
    }
}

