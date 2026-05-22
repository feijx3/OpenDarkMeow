/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package net.darkmeow.darkmeow.injection.mixin.events.tick.base;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.tick.TickEvent;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Inject(method={"runTick"}, at={@At(value="HEAD")})
    public void runTick$Inject$HEAD(CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new TickEvent.Pre());
    }

    @Inject(method={"runTick"}, at={@At(value="RETURN")})
    public void runTick$Inject$RETURN(CallbackInfo ci2) {
        DarkMeow.eventManager.callEvent(new TickEvent.Post());
    }
}

