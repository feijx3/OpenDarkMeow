/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotMode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotResult;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeEnderPearl;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "keepAll", "", "getKeepAll", "()Z", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getPearlWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
public final class InvManagerSortSlotModeEnderPearl
extends InvManagerSortSlotMode {
    private final boolean keepAll;

    public InvManagerSortSlotModeEnderPearl() {
        super("EnderPearl", 0, 2, null);
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
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeEnderPearl.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeEnderPearl.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    private final int getPearlWeight(ItemStack stack) {
        if (!(stack.func_77973_b() instanceof ItemEnderPearl)) {
            return Integer.MIN_VALUE;
        }
        return stack.func_190916_E();
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeEnderPearl this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getPearlWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

