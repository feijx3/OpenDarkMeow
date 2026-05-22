/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.entity.AccessorEntityLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u001a\u001a\u00020\u0005*\u00020\u0007J\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0007J\n\u0010\u001d\u001a\u00020\u001e*\u00020\u0007J\n\u0010\u001f\u001a\u00020\u001e*\u00020\u0007J\n\u0010 \u001a\u00020\u001e*\u00020\u0007J\n\u0010!\u001a\u00020\u001c*\u00020\u0007R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR(\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u00020\u0011*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/entity/ExtendEntityLivingBase;", "", "<init>", "()V", "value", "", "isJumping", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)Z", "setJumping", "(Lnet/minecraft/entity/EntityLivingBase;Z)V", "", "jumpTicks", "getJumpTicks", "(Lnet/minecraft/entity/EntityLivingBase;)I", "setJumpTicks", "(Lnet/minecraft/entity/EntityLivingBase;I)V", "Lnet/minecraft/item/ItemStack;", "activeItemStackSlot", "getActiveItemStackSlot", "(Lnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/item/ItemStack;", "setActiveItemStackSlot", "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/item/ItemStack;)V", "activeItemStackUseCount", "getActiveItemStackUseCount", "setActiveItemStackUseCount", "isMovementBlocked", "getJumpUpwardsMotion", "", "jump", "", "handleJumpWater", "handleJumpLava", "getWaterSlowDown", "DarkMeow"})
public final class ExtendEntityLivingBase {
    @NotNull
    public static final ExtendEntityLivingBase INSTANCE = new ExtendEntityLivingBase();

    private ExtendEntityLivingBase() {
    }

    public final boolean isJumping(@NotNull EntityLivingBase $this$isJumping) {
        Intrinsics.checkNotNullParameter($this$isJumping, "<this>");
        return ((AccessorEntityLivingBase)$this$isJumping).getIsJumping();
    }

    public final void setJumping(@NotNull EntityLivingBase $this$isJumping, boolean value) {
        Intrinsics.checkNotNullParameter($this$isJumping, "<this>");
        ((AccessorEntityLivingBase)$this$isJumping).setIsJumping(value);
    }

    public final int getJumpTicks(@NotNull EntityLivingBase $this$jumpTicks) {
        Intrinsics.checkNotNullParameter($this$jumpTicks, "<this>");
        return ((AccessorEntityLivingBase)$this$jumpTicks).getJumpTicks();
    }

    public final void setJumpTicks(@NotNull EntityLivingBase $this$jumpTicks, int value) {
        Intrinsics.checkNotNullParameter($this$jumpTicks, "<this>");
        ((AccessorEntityLivingBase)$this$jumpTicks).setJumpTicks(value);
    }

    @NotNull
    public final ItemStack getActiveItemStackSlot(@NotNull EntityLivingBase $this$activeItemStackSlot) {
        Intrinsics.checkNotNullParameter($this$activeItemStackSlot, "<this>");
        ItemStack itemStack = ((AccessorEntityLivingBase)$this$activeItemStackSlot).func_184607_cu();
        Intrinsics.checkNotNullExpressionValue(itemStack, "getActiveItemStack(...)");
        return itemStack;
    }

    public final void setActiveItemStackSlot(@NotNull EntityLivingBase $this$activeItemStackSlot, @NotNull ItemStack value) {
        Intrinsics.checkNotNullParameter($this$activeItemStackSlot, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        ((AccessorEntityLivingBase)$this$activeItemStackSlot).setActiveItemStack(value);
    }

    public final int getActiveItemStackUseCount(@NotNull EntityLivingBase $this$activeItemStackUseCount) {
        Intrinsics.checkNotNullParameter($this$activeItemStackUseCount, "<this>");
        return ((AccessorEntityLivingBase)$this$activeItemStackUseCount).getActiveItemStackUseCount();
    }

    public final void setActiveItemStackUseCount(@NotNull EntityLivingBase $this$activeItemStackUseCount, int value) {
        Intrinsics.checkNotNullParameter($this$activeItemStackUseCount, "<this>");
        ((AccessorEntityLivingBase)$this$activeItemStackUseCount).setActiveItemStackUseCount(value);
    }

    public final boolean isMovementBlocked(@NotNull EntityLivingBase $this$isMovementBlocked) {
        Intrinsics.checkNotNullParameter($this$isMovementBlocked, "<this>");
        return ((AccessorEntityLivingBase)$this$isMovementBlocked).darkMeow_isMovementBlocked();
    }

    public final float getJumpUpwardsMotion(@NotNull EntityLivingBase $this$getJumpUpwardsMotion) {
        Intrinsics.checkNotNullParameter($this$getJumpUpwardsMotion, "<this>");
        return ((AccessorEntityLivingBase)$this$getJumpUpwardsMotion).darkMeow_getJumpUpwardsMotion();
    }

    public final void jump(@NotNull EntityLivingBase $this$jump) {
        Intrinsics.checkNotNullParameter($this$jump, "<this>");
        ((AccessorEntityLivingBase)$this$jump).darkMeow_jump();
    }

    public final void handleJumpWater(@NotNull EntityLivingBase $this$handleJumpWater) {
        Intrinsics.checkNotNullParameter($this$handleJumpWater, "<this>");
        ((AccessorEntityLivingBase)$this$handleJumpWater).darkMeow_handleJumpWater();
    }

    public final void handleJumpLava(@NotNull EntityLivingBase $this$handleJumpLava) {
        Intrinsics.checkNotNullParameter($this$handleJumpLava, "<this>");
        ((AccessorEntityLivingBase)$this$handleJumpLava).darkMeow_handleJumpLava();
    }

    public final float getWaterSlowDown(@NotNull EntityLivingBase $this$getWaterSlowDown) {
        Intrinsics.checkNotNullParameter($this$getWaterSlowDown, "<this>");
        return ((AccessorEntityLivingBase)$this$getWaterSlowDown).darkMeow_getWaterSlowDown();
    }
}

