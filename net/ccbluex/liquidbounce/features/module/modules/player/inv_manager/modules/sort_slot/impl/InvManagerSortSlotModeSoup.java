/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotMode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotResult;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeSoup;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getSoupWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "Companion", "DarkMeow"})
public final class InvManagerSortSlotModeSoup
extends InvManagerSortSlotMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Item[] ITEM_SOUPS;

    public InvManagerSortSlotModeSoup() {
        super("Soup", 0, 2, null);
    }

    @Override
    @NotNull
    public InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory inventory) {
        InvManagerSortSlotResult invManagerSortSlotResult;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        InvManagerSortSlotResult it = invManagerSortSlotResult = new InvManagerSortSlotResult();
        boolean bl2 = false;
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModeSoup.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModeSoup.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    private final int getSoupWeight(ItemStack stack) {
        return ArraysKt.contains(ITEM_SOUPS, stack.func_77973_b()) ? 1 : Integer.MIN_VALUE;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModeSoup this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getSoupWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }

    static {
        Item[] itemArray = new Item[]{Items.field_151009_A, Items.field_185165_cW, Items.field_151170_bI};
        ITEM_SOUPS = itemArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModeSoup$Companion;", "", "<init>", "()V", "ITEM_SOUPS", "", "Lnet/minecraft/item/Item;", "kotlin.jvm.PlatformType", "getITEM_SOUPS", "()[Lnet/minecraft/item/Item;", "[Lnet/minecraft/item/Item;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Item[] getITEM_SOUPS() {
            return ITEM_SOUPS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

