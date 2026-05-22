/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketPlayerTryUseItemOnBlock.class})
public interface AccessorCPacketPlayerTryUseItemOnBlock {
    @Accessor(value="position")
    public BlockPos getPosition();

    @Accessor(value="position")
    public void setPosition(BlockPos var1);

    @Accessor(value="placedBlockDirection")
    public EnumFacing getPlacedBlockDirection();

    @Accessor(value="placedBlockDirection")
    public void setPlacedBlockDirection(EnumFacing var1);

    @Accessor(value="hand")
    public EnumHand func_187022_c();

    @Accessor(value="hand")
    public void setHand(EnumHand var1);

    @Accessor(value="facingX")
    public float func_187026_d();

    @Accessor(value="facingX")
    public void setFacingX(float var1);

    @Accessor(value="facingY")
    public float func_187025_e();

    @Accessor(value="facingY")
    public void setFacingY(float var1);

    @Accessor(value="facingZ")
    public float func_187020_f();

    @Accessor(value="facingZ")
    public void setFacingZ(float var1);
}

