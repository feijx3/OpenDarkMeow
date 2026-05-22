/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.ItemShears
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
import net.ccbluex.liquidbounce.utils.item.ItemUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeShears;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "weightEnchantEfficiencyValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "weightEnchantUnBreakingValue", "weightEnchantFortuneValue", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getShearsWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModeShears.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModeShears.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeShears\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1869#2,2:50\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModeShears.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeShears\n*L\n36#1:50,2\n*E\n"})
public final class InvManagerSortSlotModeShears
extends InvManagerSortSlotMode {
    @NotNull
    private final IntegerValue weightEnchantEfficiencyValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantEfficiency", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantUnBreakingValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantUnBreaking", 0, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantFortuneValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantFortune", 0, new IntRange(0, 10));

    public InvManagerSortSlotModeShears() {
        super("Shears", 0, 2, null);
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeShears.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeShears.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    private final int getShearsWeight(ItemStack stack) {
        int n2;
        ItemStack itemStack;
        ItemStack itemStack2;
        ItemStack s2 = itemStack2 = stack;
        boolean bl2 = false;
        Object object = itemStack = s2.func_77973_b() instanceof ItemShears ? itemStack2 : null;
        if (itemStack != null) {
            ItemStack it = itemStack;
            boolean bl3 = false;
            int weight = 0;
            Iterable $this$forEach$iv = ItemUtils.INSTANCE.getEnchantments(stack);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ItemUtils.ItemEnchantInfo it2 = (ItemUtils.ItemEnchantInfo)element$iv;
                boolean bl4 = false;
                Enchantment enchantment = it2.getEnchant();
                weight += Intrinsics.areEqual(enchantment, Enchantments.field_185305_q) ? ((Number)this.weightEnchantEfficiencyValue.get()).intValue() * it2.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185307_s) ? ((Number)this.weightEnchantUnBreakingValue.get()).intValue() * it2.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185308_t) ? ((Number)this.weightEnchantFortuneValue.get()).intValue() * it2.getLevel() : 0));
            }
            n2 = weight;
        } else {
            n2 = Integer.MIN_VALUE;
        }
        return n2;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeShears this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getShearsWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

