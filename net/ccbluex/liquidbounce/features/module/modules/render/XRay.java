/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="XRay", description="Allows you to see ores through walls.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "xrayBlocks", "", "Lnet/minecraft/block/Block;", "getXrayBlocks", "()Ljava/util/List;", "onToggle", "", "state", "", "DarkMeow"})
public final class XRay
extends Module {
    @NotNull
    private final List<Block> xrayBlocks;

    public XRay() {
        super(null, null, null, null, 15, null);
        Block[] blockArray = new Block[34];
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150365_q, "COAL_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150366_p, "IRON_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150352_o, "GOLD_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150450_ax, "REDSTONE_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150369_x, "LAPIS_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150482_ag, "DIAMOND_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150412_bA, "EMERALD_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150449_bY, "QUARTZ_ORE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150435_aG, "CLAY");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150426_aN, "GLOWSTONE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150462_ai, "CRAFTING_TABLE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150478_aa, "TORCH");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150468_ap, "LADDER");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150335_W, "TNT");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150402_ci, "COAL_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150339_S, "IRON_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150340_R, "GOLD_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150484_ah, "DIAMOND_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150475_bE, "EMERALD_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150451_bX, "REDSTONE_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150368_y, "LAPIS_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150480_ab, "FIRE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150341_Y, "MOSSY_COBBLESTONE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150474_ac, "MOB_SPAWNER");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150378_br, "END_PORTAL_FRAME");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150381_bn, "ENCHANTING_TABLE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150342_X, "BOOKSHELF");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150483_bI, "COMMAND_BLOCK");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150353_l, "LAVA");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150356_k, "FLOWING_LAVA");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150355_j, "WATER");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150358_i, "FLOWING_WATER");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150460_al, "FURNACE");
        Intrinsics.checkNotNullExpressionValue(Blocks.field_150470_am, "LIT_FURNACE");
        this.xrayBlocks = CollectionsKt.mutableListOf(blockArray);
    }

    @NotNull
    public final List<Block> getXrayBlocks() {
        return this.xrayBlocks;
    }

    @Override
    public void onToggle(boolean state) {
        MinecraftInstance.mc.getRenderGlobal().func_72712_a();
    }
}

