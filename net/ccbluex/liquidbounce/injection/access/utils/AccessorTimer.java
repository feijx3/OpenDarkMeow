/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Timer
 */
package net.ccbluex.liquidbounce.injection.access.utils;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Timer.class})
public interface AccessorTimer {
    @Accessor(value="lastSyncSysClock")
    public long getLastSyncSysClock();

    @Accessor(value="lastSyncSysClock")
    public void setLastSyncSysClock(long var1);

    @Accessor(value="tickLength")
    public float getTickLength();

    @Accessor(value="tickLength")
    public void setTickLength(float var1);
}

