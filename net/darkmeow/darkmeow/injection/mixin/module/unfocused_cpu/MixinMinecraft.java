/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.lwjgl.opengl.Display
 */
package net.darkmeow.darkmeow.injection.mixin.module.unfocused_cpu;

import net.ccbluex.liquidbounce.features.module.modules.misc.UnfocusedCPU;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Minecraft.class})
public class MixinMinecraft {
    @Inject(method={"runGameLoop"}, at={@At(value="INVOKE", target="Lnet/minecraft/profiler/Snooper;addMemoryStatsToSnooper()V")})
    public void runGameLoop$queryWindowState(CallbackInfo ci2) {
        if (UnfocusedCPU.INSTANCE.getState()) {
            UnfocusedCPU.status = !Display.isVisible() ? UnfocusedCPU.Status.UN_VISIBLE : (!Display.isActive() ? UnfocusedCPU.Status.UN_ACTIVE : UnfocusedCPU.Status.NORMAL);
        }
    }

    @Inject(method={"getLimitFramerate"}, at={@At(value="HEAD")}, cancellable=true)
    public void getLimitFramerate$limitFramerate(CallbackInfoReturnable<Integer> cir) {
        if (UnfocusedCPU.INSTANCE.getState()) {
            switch (UnfocusedCPU.status) {
                case UN_VISIBLE: {
                    cir.setReturnValue((Integer)UnfocusedCPU.unVisibleFPSValue.get());
                    break;
                }
                case UN_ACTIVE: {
                    cir.setReturnValue((Integer)UnfocusedCPU.unActiveFPSValue.get());
                }
            }
        }
    }
}

