/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockGlass
 *  net.minecraft.block.BlockGravel
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockSand
 *  net.minecraft.block.BlockStructure
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotMode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotResult;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.BlockWeb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBlock;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "minCountValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onlyFullBlockValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "noFallingBlocksValue", "noAdminBlocksValue", "keepAll", "", "getKeepAll", "()Z", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getBlockWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModeBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModeBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBlock\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,78:1\n1#2:79\n12637#3,2:80\n12637#3,2:82\n12637#3,2:84\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModeBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBlock\n*L\n54#1:80,2\n64#1:82,2\n73#1:84,2\n*E\n"})
public final class InvManagerSortSlotModeBlock
extends InvManagerSortSlotMode {
    @NotNull
    private final IntegerValue minCountValue = new IntegerValue(this.getValuePrefix() + "MinCount", 1, new IntRange(1, 32));
    @NotNull
    private final BoolValue onlyFullBlockValue = new BoolValue(this.getValuePrefix() + "OnlyFullBlock", true);
    @NotNull
    private final BoolValue noFallingBlocksValue = new BoolValue(this.getValuePrefix() + "NoFallingBlocks", true);
    @NotNull
    private final BoolValue noAdminBlocksValue = new BoolValue(this.getValuePrefix() + "NoAdminBlocks", true);
    private final boolean keepAll;

    public InvManagerSortSlotModeBlock() {
        super("Block", 0, 2, null);
        this.keepAll = true;
    }

    @Override
    public boolean getKeepAll() {
        return this.keepAll;
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeBlock.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeBlock.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int getBlockWeight(ItemStack stack) {
        ItemStack itemStack;
        ItemStack itemStack2;
        ItemBlock blockX;
        ItemStack itemStack3;
        ItemStack itemStack4;
        ItemStack itemStack5;
        ItemStack itemStack6;
        ItemStack it = itemStack6 = stack;
        boolean bl2 = false;
        if (!(it.func_77973_b() instanceof ItemBlock)) return Integer.MIN_VALUE;
        ItemStack itemStack7 = itemStack6;
        ItemStack itemStack8 = itemStack7;
        if (itemStack8 == null) return Integer.MIN_VALUE;
        ItemStack it2 = itemStack5 = itemStack8;
        boolean bl3 = false;
        Item item = it2.func_77973_b();
        ItemBlock itemBlock = item instanceof ItemBlock ? (ItemBlock)item : null;
        if ((itemBlock != null ? itemBlock.func_179223_d() : null) instanceof BlockWeb) return Integer.MIN_VALUE;
        boolean bl4 = true;
        if (!bl4) return Integer.MIN_VALUE;
        ItemStack itemStack9 = itemStack5;
        itemStack6 = itemStack9;
        if (itemStack6 == null) return Integer.MIN_VALUE;
        ItemStack block = itemStack4 = itemStack6;
        boolean bl5 = false;
        if (block.func_190916_E() < ((Number)this.minCountValue.get()).intValue()) return Integer.MIN_VALUE;
        boolean bl6 = true;
        if (!bl6) return Integer.MIN_VALUE;
        ItemStack itemStack10 = itemStack4;
        itemStack5 = itemStack10;
        if (itemStack5 == null) return Integer.MIN_VALUE;
        ItemStack block2 = itemStack3 = itemStack5;
        boolean bl7 = false;
        if (((Boolean)this.onlyFullBlockValue.get()).booleanValue()) {
            block7: {
                void $this$any$iv;
                Item item2 = block2.func_77973_b();
                if (!(item2 instanceof ItemBlock)) return Integer.MIN_VALUE;
                ItemBlock itemBlock3 = (ItemBlock)item2;
                itemBlock3 = itemBlock3;
                if (itemBlock2 == null) return Integer.MIN_VALUE;
                Block block3 = itemBlock3.func_179223_d();
                itemBlock3 = block3;
                if (block3 == null) return Integer.MIN_VALUE;
                blockX = itemBlock3;
                boolean bl8 = false;
                Boolean[] booleanArray = new Boolean[]{blockX.func_176223_P().func_185913_b(), blockX instanceof BlockGlass, blockX instanceof BlockLeaves};
                boolean $i$f$any = false;
                int n2 = 0;
                int n3 = ((void)$this$any$iv).length;
                while (n2 < n3) {
                    void element$iv = $this$any$iv[n2];
                    boolean it3 = element$iv.booleanValue();
                    boolean bl9 = false;
                    if (!it3) {
                        ++n2;
                        continue;
                    }
                    break block7;
                }
                return Integer.MIN_VALUE;
            }
            boolean bl10 = true;
            if (!bl10) return Integer.MIN_VALUE;
            boolean bl11 = true;
            if (!bl11) return Integer.MIN_VALUE;
        }
        boolean bl12 = true;
        if (!bl12) return Integer.MIN_VALUE;
        ItemStack itemStack11 = itemStack3;
        itemStack4 = itemStack11;
        if (itemStack4 == null) return Integer.MIN_VALUE;
        ItemStack block4 = itemStack2 = itemStack4;
        boolean bl13 = false;
        if (((Boolean)this.noFallingBlocksValue.get()).booleanValue()) {
            void $this$any$iv;
            blockX = block4.func_77973_b();
            if (!(blockX instanceof ItemBlock)) return Integer.MIN_VALUE;
            ItemBlock itemBlock5 = blockX;
            itemBlock5 = itemBlock5;
            if (itemBlock4 == null) return Integer.MIN_VALUE;
            Block block5 = itemBlock5.func_179223_d();
            itemBlock5 = block5;
            if (block5 == null) return Integer.MIN_VALUE;
            ItemBlock blockX2 = itemBlock5;
            boolean bl14 = false;
            Boolean[] $i$f$any = new Boolean[]{blockX2 instanceof BlockSand, blockX2 instanceof BlockGravel, blockX2 instanceof BlockAnvil};
            boolean $i$f$any2 = false;
            for (void element$iv : $this$any$iv) {
                boolean it4 = element$iv.booleanValue();
                boolean bl15 = false;
                if (!it4) continue;
                return Integer.MIN_VALUE;
            }
            boolean bl16 = false;
            if (bl16) return Integer.MIN_VALUE;
            boolean bl17 = true;
            if (!bl17) return Integer.MIN_VALUE;
            boolean bl18 = true;
            if (!bl18) return Integer.MIN_VALUE;
        }
        boolean bl19 = true;
        if (!bl19) return Integer.MIN_VALUE;
        ItemStack itemStack12 = itemStack2;
        itemStack3 = itemStack12;
        if (itemStack3 == null) return Integer.MIN_VALUE;
        ItemStack block6 = itemStack = itemStack3;
        boolean bl20 = false;
        if (((Boolean)this.noAdminBlocksValue.get()).booleanValue()) {
            void $this$any$iv;
            Item item3 = block6.func_77973_b();
            if (!(item3 instanceof ItemBlock)) return Integer.MIN_VALUE;
            ItemBlock itemBlock7 = (ItemBlock)item3;
            itemBlock7 = itemBlock7;
            if (itemBlock6 == null) return Integer.MIN_VALUE;
            Block block7 = itemBlock7.func_179223_d();
            itemBlock7 = block7;
            if (block7 == null) return Integer.MIN_VALUE;
            ItemBlock blockX3 = itemBlock7;
            boolean bl21 = false;
            Boolean[] $i$f$any2 = new Boolean[]{blockX3 instanceof BlockCommandBlock, blockX3 instanceof BlockStructure};
            boolean $i$f$any = false;
            for (void element$iv : $this$any$iv) {
                boolean it5 = element$iv.booleanValue();
                boolean bl22 = false;
                if (!it5) continue;
                return Integer.MIN_VALUE;
            }
            boolean bl23 = false;
            if (bl23) return Integer.MIN_VALUE;
            boolean bl24 = true;
            if (!bl24) return Integer.MIN_VALUE;
            boolean bl25 = true;
            if (!bl25) return Integer.MIN_VALUE;
        }
        boolean bl26 = true;
        if (!bl26) return Integer.MIN_VALUE;
        ItemStack itemStack13 = itemStack;
        itemStack2 = itemStack13;
        if (itemStack2 == null) return Integer.MIN_VALUE;
        int n4 = itemStack2.func_190916_E();
        return n4;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeBlock this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getBlockWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

