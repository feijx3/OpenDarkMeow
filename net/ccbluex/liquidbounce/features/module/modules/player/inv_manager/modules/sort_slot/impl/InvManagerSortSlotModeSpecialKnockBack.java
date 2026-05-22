/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotMode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotResult;
import net.ccbluex.liquidbounce.utils.item.ItemUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeSpecialKnockBack;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "minEnchantLevelValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "keepAllValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "keepAll", "", "getKeepAll", "()Z", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getSpecialKnockBackWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModeSpecialKnockBack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModeSpecialKnockBack.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeSpecialKnockBack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n295#2,2:43\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModeSpecialKnockBack.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeSpecialKnockBack\n*L\n32#1:43,2\n*E\n"})
public final class InvManagerSortSlotModeSpecialKnockBack
extends InvManagerSortSlotMode {
    @JvmField
    @NotNull
    public final IntegerValue minEnchantLevelValue = new IntegerValue(this.getValuePrefix() + "MinEnchantLevel", 1, new IntRange(1, 10));
    @JvmField
    @NotNull
    public final BoolValue keepAllValue = new BoolValue(this.getValuePrefix() + "KeepAll", true);

    public InvManagerSortSlotModeSpecialKnockBack() {
        super("SpecialKnockBack", 0, 2, null);
    }

    @Override
    public boolean getKeepAll() {
        return (Boolean)this.keepAllValue.get();
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeSpecialKnockBack.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeSpecialKnockBack.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int getSpecialKnockBackWeight(ItemStack stack) {
        ItemUtils.ItemEnchantInfo itemEnchantInfo;
        Object v0;
        block1: {
            Iterable $this$firstOrNull$iv = ItemUtils.INSTANCE.getEnchantments(stack);
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ItemUtils.ItemEnchantInfo it = (ItemUtils.ItemEnchantInfo)element$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(it.getEnchant(), Enchantments.field_180313_o)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        ItemUtils.ItemEnchantInfo itemEnchantInfo2 = v0;
        if (itemEnchantInfo2 == null) return Integer.MIN_VALUE;
        ItemUtils.ItemEnchantInfo it = itemEnchantInfo = itemEnchantInfo2;
        boolean bl3 = false;
        if (it.getLevel() < ((Number)this.minEnchantLevelValue.get()).intValue()) return Integer.MIN_VALUE;
        boolean bl4 = true;
        if (!bl4) return Integer.MIN_VALUE;
        ItemUtils.ItemEnchantInfo itemEnchantInfo3 = itemEnchantInfo;
        ItemUtils.ItemEnchantInfo itemEnchantInfo4 = itemEnchantInfo3;
        if (itemEnchantInfo4 == null) return Integer.MIN_VALUE;
        int n2 = itemEnchantInfo4.getLevel();
        return n2;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeSpecialKnockBack this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getSpecialKnockBackWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

