/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\f\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010R!\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldStatic;", "", "<init>", "()V", "invalidBlocks", "", "Lnet/minecraft/block/Block;", "kotlin.jvm.PlatformType", "getInvalidBlocks", "()[Lnet/minecraft/block/Block;", "[Lnet/minecraft/block/Block;", "allowScaffoldUse", "", "Lnet/minecraft/item/ItemStack;", "getScaffoldPlaceHand", "Lnet/minecraft/util/EnumHand;", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class ScaffoldStatic {
    @NotNull
    public static final ScaffoldStatic INSTANCE = new ScaffoldStatic();
    @NotNull
    private static final Block[] invalidBlocks;

    private ScaffoldStatic() {
    }

    @NotNull
    public final Block[] getInvalidBlocks() {
        return invalidBlocks;
    }

    public final boolean allowScaffoldUse(@NotNull ItemStack $this$allowScaffoldUse) {
        boolean bl2;
        ItemBlock itemBlock;
        Intrinsics.checkNotNullParameter($this$allowScaffoldUse, "<this>");
        Item item = $this$allowScaffoldUse.func_77973_b();
        ItemBlock itemBlock2 = itemBlock = item instanceof ItemBlock ? (ItemBlock)item : null;
        if (itemBlock != null) {
            ItemBlock item2 = itemBlock;
            boolean bl3 = false;
            bl2 = !ArraysKt.contains(invalidBlocks, item2.func_179223_d());
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Nullable
    public final EnumHand getScaffoldPlaceHand(@NotNull EntityPlayerSP $this$getScaffoldPlaceHand) {
        Object object;
        Intrinsics.checkNotNullParameter($this$getScaffoldPlaceHand, "<this>");
        ItemStack itemStack = $this$getScaffoldPlaceHand.func_184614_ca();
        Intrinsics.checkNotNullExpressionValue(itemStack, "getHeldItemMainhand(...)");
        if (this.allowScaffoldUse(itemStack)) {
            object = EnumHand.MAIN_HAND;
        } else {
            ItemStack itemStack2 = $this$getScaffoldPlaceHand.func_184592_cb();
            Intrinsics.checkNotNullExpressionValue(itemStack2, "getHeldItemOffhand(...)");
            object = this.allowScaffoldUse(itemStack2) ? EnumHand.OFF_HAND : null;
        }
        return object;
    }

    static {
        Block[] blockArray = new Block[]{Blocks.field_150467_bQ, Blocks.field_150486_ae, Blocks.field_150447_bR, Blocks.field_150460_al, Blocks.field_150381_bn, Blocks.field_150462_ai, Blocks.field_150367_z, Blocks.field_150323_B, Blocks.field_150421_aI, Blocks.field_150430_aB, Blocks.field_150471_bO, Blocks.field_150478_aa, Blocks.field_150429_aA, Blocks.field_150437_az, Blocks.field_150382_bo, Blocks.field_150444_as, Blocks.field_150472_an, Blocks.field_150404_cg, Blocks.field_150392_bi, Blocks.field_150431_aC, Blocks.field_150337_Q, Blocks.field_150338_P, Blocks.field_150468_ap, Blocks.field_150395_bd, Blocks.field_150355_j, Blocks.field_150358_i, Blocks.field_150353_l, Blocks.field_150356_k};
        invalidBlocks = blockArray;
    }
}

