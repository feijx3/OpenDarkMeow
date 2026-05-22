/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketVehicleMove
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketVehicleMove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketVehicleMove.class})
public interface AccessorCPacketVehicleMove {
    @Accessor(value="x")
    public double func_187004_a();

    @Accessor(value="x")
    public void setX(double var1);

    @Accessor(value="y")
    public double func_187002_b();

    @Accessor(value="y")
    public void setY(double var1);

    @Accessor(value="z")
    public double func_187003_c();

    @Accessor(value="z")
    public void setZ(double var1);

    @Accessor(value="yaw")
    public float func_187006_d();

    @Accessor(value="yaw")
    public void setYaw(float var1);

    @Accessor(value="pitch")
    public float func_187005_e();

    @Accessor(value="pitch")
    public void setPitch(float var1);
}

