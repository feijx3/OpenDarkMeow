/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
package net.ccbluex.liquidbounce.injection.access.entity;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityPlayer.class})
public interface AccessorEntityPlayer {
    @Accessor(value="sleeping")
    public boolean getSleeping();

    @Accessor(value="sleeping")
    public void setSleeping(boolean var1);

    @Accessor(value="sleepTimer")
    public void setSleepTimer(int var1);

    @Accessor(value="speedInAir")
    public float getSpeedInAir();

    @Accessor(value="speedInAir")
    public void setSpeedInAir(float var1);

    @Accessor(value="flyToggleTimer")
    public int getFlyToggleTimer();

    @Accessor(value="flyToggleTimer")
    public void setFlyToggleTimer(int var1);
}

