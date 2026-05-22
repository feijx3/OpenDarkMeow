/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.item.ItemLingeringPotion
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemSplashPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.potion.PotionUtils
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.impl;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import net.minecraft.item.ItemLingeringPotion;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModePotion;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "<init>", "()V", "noDrinkPotion", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "noSplashPotion", "noLingeringPotion", "weightEffectNormalValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "weightEffectBadValue", "keepAll", "", "getKeepAll", "()Z", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "getPotionWeight", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerSortSlotModePotion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerSortSlotModePotion.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModePotion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n12434#2,2:62\n12637#2,2:64\n1#3:66\n*S KotlinDebug\n*F\n+ 1 InvManagerSortSlotModePotion.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/impl/InvManagerSortSlotModePotion\n*L\n47#1:62,2\n48#1:64,2\n*E\n"})
public final class InvManagerSortSlotModePotion
extends InvManagerSortSlotMode {
    @NotNull
    private final BoolValue noDrinkPotion = new BoolValue(this.getValuePrefix() + "NoDrinkPotion", false);
    @NotNull
    private final BoolValue noSplashPotion = new BoolValue(this.getValuePrefix() + "NoSplashPotion", false);
    @NotNull
    private final BoolValue noLingeringPotion = new BoolValue(this.getValuePrefix() + "NoLingeringPotion", false);
    @NotNull
    private final IntegerValue weightEffectNormalValue = new IntegerValue(this.getValuePrefix() + "WeightEffectNormal", 1, new IntRange(0, 10));
    @NotNull
    private final IntegerValue weightEffectBadValue = new IntegerValue(this.getValuePrefix() + "WeightEffectBad", 0, new IntRange(0, 10));
    private final boolean keepAll;

    public InvManagerSortSlotModePotion() {
        super("Potion", 0, 2, null);
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
        inventory.forEach((arg_0, arg_1) -> InvManagerSortSlotModePotion.searchSlot$lambda$2$lambda$1((arg_0, arg_1) -> InvManagerSortSlotModePotion.searchSlot$lambda$2$lambda$0(it, this, arg_0, arg_1), arg_0, arg_1));
        return invManagerSortSlotResult;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int getPotionWeight(ItemStack stack) {
        int n2;
        ItemStack itemStack;
        block7: {
            void $this$any$iv;
            boolean bl2;
            block6: {
                void $this$all$iv;
                ItemStack itemStack2 = itemStack = stack;
                boolean bl3 = false;
                Boolean[] booleanArray = new Boolean[3];
                booleanArray[0] = itemStack2.func_77973_b() instanceof ItemSplashPotion && (Boolean)this.noSplashPotion.get() == false;
                booleanArray[1] = itemStack2.func_77973_b() instanceof ItemLingeringPotion && (Boolean)this.noLingeringPotion.get() == false;
                Boolean[] booleanArray2 = new Boolean[]{itemStack2.func_77973_b() instanceof ItemPotion, !(itemStack2.func_77973_b() instanceof ItemSplashPotion), !(itemStack2.func_77973_b() instanceof ItemLingeringPotion), (Boolean)this.noDrinkPotion.get() == false};
                n2 = 2;
                Boolean[] booleanArray3 = booleanArray;
                boolean $i$f$all = false;
                for (void element$iv : $this$all$iv) {
                    boolean it = element$iv.booleanValue();
                    boolean bl4 = false;
                    if (it) continue;
                    bl2 = false;
                    break block6;
                }
                bl2 = true;
            }
            boolean bl5 = bl2;
            booleanArray3[n2] = bl5;
            boolean $i$f$any = false;
            int n3 = 0;
            int n4 = ((void)$this$any$iv).length;
            while (n3 < n4) {
                void element$iv = $this$any$iv[n3];
                boolean it = element$iv.booleanValue();
                boolean bl6 = false;
                if (!it) {
                    ++n3;
                    continue;
                }
                break block7;
            }
            return Integer.MIN_VALUE;
        }
        boolean bl7 = true;
        if (!bl7) return Integer.MIN_VALUE;
        ItemStack itemStack3 = itemStack;
        ItemStack itemStack4 = itemStack3;
        if (itemStack4 == null) return Integer.MIN_VALUE;
        ItemStack it = itemStack4;
        boolean bl8 = false;
        List list = PotionUtils.func_185191_c((ItemStack)stack).func_185170_a();
        Intrinsics.checkNotNullExpressionValue(list, "getEffects(...)");
        Iterable $i$f$any = list;
        n2 = 0;
        for (Object e2 : $i$f$any) {
            int n5;
            void it2;
            PotionEffect potionEffect = (PotionEffect)e2;
            int n6 = n2;
            boolean bl9 = false;
            boolean bl10 = it2.func_188419_a().func_76398_f();
            if (bl10) {
                n5 = ((Number)this.weightEffectBadValue.get()).intValue();
            } else {
                if (bl10) throw new NoWhenBranchMatchedException();
                n5 = ((Number)this.weightEffectNormalValue.get()).intValue();
            }
            int n7 = n5 * (it2.func_76458_c() + 1);
            n2 = n6 + n7;
        }
        Integer n8 = n2;
        int it3 = ((Number)n8).intValue();
        boolean bl11 = false;
        if (it3 <= 0) return Integer.MIN_VALUE;
        boolean bl12 = true;
        if (!bl12) return Integer.MIN_VALUE;
        Integer n9 = n8;
        Integer n10 = n9;
        if (n10 == null) return Integer.MIN_VALUE;
        int n11 = n10;
        return n11;
    }

    private static final Unit searchSlot$lambda$2$lambda$0(InvManagerSortSlotResult $it, InvManagerSortSlotModePotion this$0, Integer index, ItemStack stack) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ((Map)$it).put(index, this$0.getPotionWeight(stack));
        return Unit.INSTANCE;
    }

    private static final void searchSlot$lambda$2$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }
}

