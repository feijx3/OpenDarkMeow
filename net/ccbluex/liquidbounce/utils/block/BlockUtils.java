/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.block;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="\u5728 2025.6.6 \u4ee5\u540e\u7528\u8fd9\u4e2a\u65b9\u6cd5\u6b7b\u5988")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0007J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00160\u001aj\u0002`\u001bH\u0007\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/utils/block/BlockUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "getBlock", "Lnet/minecraft/block/Block;", "blockPos", "Lnet/minecraft/util/math/BlockPos;", "x", "", "y", "z", "", "getState", "Lnet/minecraft/block/state/IBlockState;", "getBlockName", "", "id", "searchBlocks", "", "radius", "collideBlock", "", "axisAlignedBB", "Lnet/minecraft/util/math/AxisAlignedBB;", "collide", "Lkotlin/Function1;", "Lnet/ccbluex/liquidbounce/utils/block/Collidable;", "DarkMeow"})
public final class BlockUtils
extends MinecraftInstance {
    @NotNull
    public static final BlockUtils INSTANCE = new BlockUtils();

    private BlockUtils() {
    }

    @JvmStatic
    @NotNull
    public static final Block getBlock(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter(blockPos, "blockPos");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null || (worldClient = worldClient.func_180495_p(blockPos)) == null || (worldClient = worldClient.func_177230_c()) == null) {
            Block block = Blocks.field_150350_a;
            Intrinsics.checkNotNullExpressionValue(block, "AIR");
            return block;
        }
        return worldClient;
    }

    @JvmStatic
    @NotNull
    public static final Block getBlock(int x2, int y2, int z2) {
        return BlockUtils.getBlock(new BlockPos(x2, y2, z2));
    }

    @JvmStatic
    @NotNull
    public static final Block getBlock(double x2, double y2, double z2) {
        return BlockUtils.getBlock(new BlockPos(x2, y2, z2));
    }

    @JvmStatic
    @NotNull
    public static final IBlockState getState(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter(blockPos, "blockPos");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        Intrinsics.checkNotNull(worldClient);
        IBlockState iBlockState = worldClient.func_180495_p(blockPos);
        Intrinsics.checkNotNullExpressionValue(iBlockState, "getBlockState(...)");
        return iBlockState;
    }

    @JvmStatic
    @NotNull
    public static final String getBlockName(int id) {
        String string = Block.func_149729_e((int)id).func_149732_F();
        Intrinsics.checkNotNullExpressionValue(string, "getLocalizedName(...)");
        return string;
    }

    @Deprecated(message="LiquidBounce Trash Utils")
    @JvmStatic
    @NotNull
    public static final Map<BlockPos, Block> searchBlocks(int radius) {
        Map blocks = new LinkedHashMap();
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return blocks;
        }
        EntityPlayerSP thePlayer = entityPlayerSP;
        int n2 = -radius + 1;
        int x2 = radius;
        if (n2 <= x2) {
            while (true) {
                int y2;
                int n3;
                if ((n3 = -radius + 1) <= (y2 = radius)) {
                    while (true) {
                        int z2;
                        int n4;
                        if ((n4 = -radius + 1) <= (z2 = radius)) {
                            while (true) {
                                BlockPos blockPos = new BlockPos((int)thePlayer.field_70165_t + x2, (int)thePlayer.field_70163_u + y2, (int)thePlayer.field_70161_v + z2);
                                Block block = BlockUtils.getBlock(blockPos);
                                blocks.put(blockPos, block);
                                if (z2 == n4) break;
                                --z2;
                            }
                        }
                        if (y2 == n3) break;
                        --y2;
                    }
                }
                if (x2 == n2) break;
                --x2;
            }
        }
        return blocks;
    }

    @JvmStatic
    public static final boolean collideBlock(@NotNull AxisAlignedBB axisAlignedBB, @NotNull Function1<? super Block, Boolean> collide) {
        Intrinsics.checkNotNullParameter(axisAlignedBB, "axisAlignedBB");
        Intrinsics.checkNotNullParameter(collide, "collide");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP thePlayer = entityPlayerSP;
        long l2 = (long)((int)Math.floor(thePlayer.func_174813_aQ().field_72336_d)) + 1L;
        for (long x2 = (long)((int)Math.floor(thePlayer.func_174813_aQ().field_72340_a)); x2 < l2; ++x2) {
            int n2 = (int)Math.floor(thePlayer.func_174813_aQ().field_72334_f) + 1;
            for (int z2 = (int)Math.floor(thePlayer.func_174813_aQ().field_72339_c); z2 < n2; ++z2) {
                Block block = BlockUtils.getBlock(new BlockPos((double)x2, axisAlignedBB.field_72338_b, (double)z2));
                if (collide.invoke((Block)block).booleanValue()) continue;
                return false;
            }
        }
        return true;
    }
}

