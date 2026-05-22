/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "Ljava/util/LinkedHashMap;", "", "Lnet/minecraft/item/ItemStack;", "Lkotlin/collections/LinkedHashMap;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotPlayerInventory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotPlayerInventory.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,28:1\n1332#2,3:29\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotPlayerInventory.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory\n*L\n16#1:29,3\n*E\n"})
public final class InvManagerSortSlotPlayerInventory
extends LinkedHashMap<Integer, ItemStack> {
    /*
     * WARNING - void declaration
     */
    public InvManagerSortSlotPlayerInventory(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        NonNullList nonNullList = player.field_71069_bz.func_75138_a();
        Intrinsics.checkNotNullExpressionValue(nonNullList, "getInventory(...)");
        Sequence $this$forEachIndexed$iv = CollectionsKt.asSequence((Iterable)nonNullList);
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        Iterator iterator2 = $this$forEachIndexed$iv.iterator();
        while (iterator2.hasNext()) {
            void stack;
            int n2;
            Object item$iv = iterator2.next();
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ItemStack itemStack = (ItemStack)item$iv;
            int index = n2;
            boolean bl2 = false;
            Integer n3 = index;
            int it = ((Number)n3).intValue();
            boolean bl3 = false;
            Integer n4 = (5 <= it ? it < 46 : false) ? n3 : null;
            if (n4 == null) continue;
            n3 = n4;
            it = ((Number)n3).intValue();
            boolean bl4 = false;
            ((Map)this).put(index, stack.func_77946_l());
        }
    }
}

