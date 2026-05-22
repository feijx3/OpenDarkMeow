/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Timer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.util;

import net.ccbluex.liquidbounce.injection.implementations.IMixinTimer;
import net.minecraft.util.Timer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Timer.class})
public class MixinTimer
implements IMixinTimer {
    @Unique
    public float darkMeow$timerSpeed = 1.0f;
    @Shadow
    public float field_194148_c;

    @Inject(method={"updateTimer"}, at={@At(value="FIELD", target="Lnet/minecraft/util/Timer;elapsedPartialTicks:F", opcode=181, shift=At.Shift.AFTER)})
    private void onElapsedPartialTicksSet(CallbackInfo ci2) {
        this.field_194148_c *= this.darkMeow$timerSpeed;
    }

    @Override
    @Unique
    public float darkMeow_getTimerSpeed() {
        return this.darkMeow$timerSpeed;
    }

    @Override
    @Unique
    public void darkMeow_setTimerSpeed(float speed) {
        this.darkMeow$timerSpeed = speed;
    }
}

