/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArrow
 *  net.minecraft.item.ItemBow
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
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBow;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "weightEnchantPowerValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "weightEnchantPunchValue", "weightEnchantInfinityValue", "weightEnchantUnBreakingValue", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getBowWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModeBow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModeBow.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBow\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n1869#2,2:52\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModeBow.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeBow\n*L\n34#1:52,2\n*E\n"})
public final class InvManagerSortSlotModeBow
extends InvManagerSortSlotMode {
    @NotNull
    private final IntegerValue weightEnchantPowerValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantPower", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantPunchValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantPunch", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantInfinityValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantInfinity", 2, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEnchantUnBreakingValue = new IntegerValue(this.getValuePrefix() + "WeightEnchantUnBreaking", 0, new IntRange(0, 10));

    public InvManagerSortSlotModeBow() {
        super("Bow", 0, 2, null);
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeBow.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeBow.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    /*
     * WARNING - void declaration
     */
    private final int getBowWeight(ItemStack stack) {
        int n2;
        Item item = stack.func_77973_b();
        if (item instanceof ItemBow) {
            void var3_3;
            int weight = 0;
            Iterable $this$forEach$iv = ItemUtils.INSTANCE.getEnchantments(stack);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ItemUtils.ItemEnchantInfo it = (ItemUtils.ItemEnchantInfo)element$iv;
                boolean bl2 = false;
                Enchantment enchantment = it.getEnchant();
                weight += Intrinsics.areEqual(enchantment, Enchantments.field_185309_u) ? ((Number)this.weightEnchantPowerValue.get()).intValue() * it.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185310_v) ? ((Number)this.weightEnchantPunchValue.get()).intValue() * it.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185312_x) ? ((Number)this.weightEnchantInfinityValue.get()).intValue() * it.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185307_s) ? ((Number)this.weightEnchantUnBreakingValue.get()).intValue() * it.getLevel() : 0)));
            }
            n2 = var3_3;
        } else {
            n2 = item instanceof ItemArrow ? -1 : Integer.MIN_VALUE;
        }
        return n2;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeBow this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getBowWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

