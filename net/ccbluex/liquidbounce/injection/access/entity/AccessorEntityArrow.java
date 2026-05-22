/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.projectile.EntityArrow
 */
package net.ccbluex.liquidbounce.injection.access.entity;

import net.minecraft.entity.projectile.EntityArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityArrow.class})
public interface AccessorEntityArrow {
    @Accessor(value="ticksInGround")
    public int getTicksInGround();

    @Accessor(value="ticksInGround")
    public void setTicksInGround(int var1);

    @Accessor(value="ticksInAir")
    public int getTicksInAir();

    @Accessor(value="ticksInAir")
    public void setTicksInAir(int var1);

    @Accessor(value="damage")
    public double func_70242_d();

    @Accessor(value="damage")
    public void func_70239_b(double var1);

    @Accessor(value="knockbackStrength")
    public int getKnockbackStrength();

    @Accessor(value="knockbackStrength")
    public void func_70240_a(int var1);
}

