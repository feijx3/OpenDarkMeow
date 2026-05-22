/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package net.ccbluex.liquidbounce.injection.access.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityPlayerSP.class})
public interface AccessorEntityPlayerSP {
    @Accessor(value="mc")
    public Minecraft getMinecraft();

    @Accessor(value="handActive")
    public void setHandActive(boolean var1);

    @Accessor(value="horseJumpPowerCounter")
    public int getHorseJumpPowerCounter();

    @Accessor(value="horseJumpPowerCounter")
    public void setHorseJumpPowerCounter(int var1);

    @Accessor(value="horseJumpPower")
    public float func_110319_bJ();

    @Accessor(value="horseJumpPower")
    public void setHorseJumpPower(float var1);

    @Accessor(value="serverSprintState")
    public boolean getServerSprintState();

    @Accessor(value="serverSprintState")
    public void setServerSprintState(boolean var1);

    @Accessor(value="serverSneakState")
    public boolean getServerSneakState();

    @Accessor(value="serverSneakState")
    public void setServerSneakState(boolean var1);

    @Accessor(value="positionUpdateTicks")
    public int getPositionUpdateTicks();

    @Accessor(value="positionUpdateTicks")
    public void setPositionUpdateTicks(int var1);

    @Invoker(value="onUpdateWalkingPlayer")
    public void invokeOnUpdateWalkingPlayer();
}

