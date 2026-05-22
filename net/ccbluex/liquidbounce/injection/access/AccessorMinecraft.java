/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 *  net.minecraft.util.Timer
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Minecraft.class})
public interface AccessorMinecraft {
    @Accessor(value="timer")
    public Timer getTimer();

    @Accessor(value="session")
    public void setSession(Session var1);

    @Accessor(value="renderPartialTicksPaused")
    public float getRenderPartialTicksPaused();

    @Accessor(value="rightClickDelayTimer")
    public int getRightClickDelayTimer();

    @Accessor(value="rightClickDelayTimer")
    public void setRightClickDelayTimer(int var1);

    @Invoker(value="rightClickMouse")
    public void invokeRightClickMouse();

    @Accessor(value="running")
    public boolean getRunning();

    @Invoker(value="sendClickBlockToController")
    public void invokeSendClickBlockToController(boolean var1);

    @Invoker(value="setWindowIcon")
    public void darkMeow_setWindowIcon();
}

