/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketEntityVelocity.class})
public interface AccessorSPacketEntityVelocity {
    @Accessor(value="entityID")
    public int func_149412_c();

    @Accessor(value="entityID")
    public void setEntityID(int var1);

    @Accessor(value="motionX")
    public int func_149411_d();

    @Accessor(value="motionX")
    public void setMotionX(int var1);

    @Accessor(value="motionY")
    public int func_149410_e();

    @Accessor(value="motionY")
    public void setMotionY(int var1);

    @Accessor(value="motionZ")
    public int func_149409_f();

    @Accessor(value="motionZ")
    public void setMotionZ(int var1);
}

