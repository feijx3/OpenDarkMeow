/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 */
package net.ccbluex.liquidbounce.injection.access.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityLivingBase.class})
public interface AccessorEntityLivingBase {
    @Accessor(value="isJumping")
    public boolean getIsJumping();

    @Accessor(value="isJumping")
    public void setIsJumping(boolean var1);

    @Accessor(value="activeItemStack")
    public ItemStack func_184607_cu();

    @Accessor(value="activeItemStack")
    public void setActiveItemStack(ItemStack var1);

    @Accessor(value="activeItemStackUseCount")
    public int getActiveItemStackUseCount();

    @Accessor(value="activeItemStackUseCount")
    public void setActiveItemStackUseCount(int var1);

    @Accessor(value="jumpTicks")
    public int getJumpTicks();

    @Accessor(value="jumpTicks")
    public void setJumpTicks(int var1);

    @Invoker(value="isMovementBlocked")
    public boolean darkMeow_isMovementBlocked();

    @Invoker(value="getJumpUpwardsMotion")
    public float darkMeow_getJumpUpwardsMotion();

    @Invoker(value="jump")
    public void darkMeow_jump();

    @Invoker(value="handleJumpWater")
    public void darkMeow_handleJumpWater();

    @Invoker(value="handleJumpWater")
    public void darkMeow_handleJumpLava();

    @Invoker(value="getWaterSlowDown")
    public float darkMeow_getWaterSlowDown();

    @Invoker(value="updateArmSwingProgress")
    public void darkMeow_updateArmSwingProgress();
}

