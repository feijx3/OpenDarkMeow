/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemAxe
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeAxe;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "weightMaterialDiamondValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "weightMaterialIronValue", "weightMaterialGoldValue", "weightMaterialStoneValue", "weightMaterialWoodValue", "weightEnchantSharpnessValue", "weightEnchantEfficiencyValue", "weightEnchantUnBreakingValue", "weightEnchantFortuneValue", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getSwordWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModeAxe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModeAxe.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeAxe\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1869#2,2:66\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModeAxe.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeAxe\n*L\n50#1:66,2\n*E\n"})
public final class InvManagerSortSlotModeAxe
extends InvManagerSortSlotMode {
    @NotNull
    private final IntegerValue weightMaterialDiamondValue = new IntegerValue(this.getValuePrefix() + "WeightMaterialDiamond", 5, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightMaterialIronValue = new IntegerValue(this.getValuePrefix() + "WeightMaterialIron", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightMaterialGoldValue = new IntegerValue(this.getValuePrefix() + "WeightMaterialGold", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightMaterialStoneValue = new IntegerValue(this.getValuePrefix() + "WeightMaterialStone", 0, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightMaterialWoodValue = new IntegerValue(this.getValuePrefix() + "WeightMaterialWood", 0, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantSharpnessValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantSharpness", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantEfficiencyValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantEfficiency", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantUnBreakingValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantUnBreaking", 0, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantFortuneValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantFortune", 0, new IntRange(0, 10));

    public InvManagerSortSlotModeAxe() {
        super("Axe", 0, 2, null);
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeAxe.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeAxe.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    private final int getSwordWeight(ItemStack stack) {
        int n2;
        ItemStack it = stack;
        boolean bl2 = false;
        Object object = stack.func_77973_b();
        ItemAxe itemAxe = object instanceof ItemAxe ? (ItemAxe)object : null;
        if (itemAxe == null) {
            n2 = Integer.MIN_VALUE;
        } else {
            ItemAxe item = itemAxe;
            int weight = 0;
            object = item.func_77861_e();
            weight += Intrinsics.areEqual(object, Item.ToolMaterial.WOOD.toString()) ? ((Number)this.weightMaterialWoodValue.get()).intValue() : (Intrinsics.areEqual(object, Item.ToolMaterial.STONE.toString()) ? ((Number)this.weightMaterialStoneValue.get()).intValue() : (Intrinsics.areEqual(object, Item.ToolMaterial.IRON.toString()) ? ((Number)this.weightMaterialIronValue.get()).intValue() : (Intrinsics.areEqual(object, Item.ToolMaterial.GOLD.toString()) ? ((Number)this.weightMaterialGoldValue.get()).intValue() : (Intrinsics.areEqual(object, Item.ToolMaterial.DIAMOND.toString()) ? ((Number)this.weightMaterialDiamondValue.get()).intValue() : 0))));
            Iterable $this$forEach$iv = ItemUtils.INSTANCE.getEnchantments(stack);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ItemUtils.ItemEnchantInfo it2 = (ItemUtils.ItemEnchantInfo)element$iv;
                boolean bl3 = false;
                Enchantment enchantment = it2.getEnchant();
                weight += Intrinsics.areEqual(enchantment, Enchantments.field_185302_k) ? ((Number)this.weightEnchantSharpnessValue.get()).intValue() * it2.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185305_q) ? ((Number)this.weightEnchantEfficiencyValue.get()).intValue() * it2.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185307_s) ? ((Number)this.weightEnchantUnBreakingValue.get()).intValue() * it2.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185308_t) ? ((Number)this.weightEnchantFortuneValue.get()).intValue() * it2.getLevel() : 0)));
            }
            n2 = weight;
        }
        return n2;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeAxe this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getSwordWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

