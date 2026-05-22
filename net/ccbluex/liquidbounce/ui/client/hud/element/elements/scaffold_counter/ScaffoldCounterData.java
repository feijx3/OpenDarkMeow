/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldStatic;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData;", "", "heldBlock", "Lnet/minecraft/item/ItemStack;", "countHotBar", "", "countInventory", "<init>", "(Lnet/minecraft/item/ItemStack;II)V", "getHeldBlock", "()Lnet/minecraft/item/ItemStack;", "getCountHotBar", "()I", "getCountInventory", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "DarkMeow"})
public final class ScaffoldCounterData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ItemStack heldBlock;
    private final int countHotBar;
    private final int countInventory;
    @JvmField
    @NotNull
    public static final ItemStack EMPTY_ITEM_STACK_DISPLAY = new ItemStack(Blocks.field_180401_cv, 1);

    public ScaffoldCounterData(@NotNull ItemStack heldBlock, int countHotBar, int countInventory) {
        Intrinsics.checkNotNullParameter(heldBlock, "heldBlock");
        this.heldBlock = heldBlock;
        this.countHotBar = countHotBar;
        this.countInventory = countInventory;
    }

    @NotNull
    public final ItemStack getHeldBlock() {
        return this.heldBlock;
    }

    public final int getCountHotBar() {
        return this.countHotBar;
    }

    public final int getCountInventory() {
        return this.countInventory;
    }

    @NotNull
    public final ItemStack component1() {
        return this.heldBlock;
    }

    public final int component2() {
        return this.countHotBar;
    }

    public final int component3() {
        return this.countInventory;
    }

    @NotNull
    public final ScaffoldCounterData copy(@NotNull ItemStack heldBlock, int countHotBar, int countInventory) {
        Intrinsics.checkNotNullParameter(heldBlock, "heldBlock");
        return new ScaffoldCounterData(heldBlock, countHotBar, countInventory);
    }

    public static /* synthetic */ ScaffoldCounterData copy$default(ScaffoldCounterData scaffoldCounterData, ItemStack itemStack, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            itemStack = scaffoldCounterData.heldBlock;
        }
        if ((n4 & 2) != 0) {
            n2 = scaffoldCounterData.countHotBar;
        }
        if ((n4 & 4) != 0) {
            n3 = scaffoldCounterData.countInventory;
        }
        return scaffoldCounterData.copy(itemStack, n2, n3);
    }

    @NotNull
    public String toString() {
        return "ScaffoldCounterData(heldBlock=" + this.heldBlock + ", countHotBar=" + this.countHotBar + ", countInventory=" + this.countInventory + ')';
    }

    public int hashCode() {
        int result = this.heldBlock.hashCode();
        result = result * 31 + Integer.hashCode(this.countHotBar);
        result = result * 31 + Integer.hashCode(this.countInventory);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScaffoldCounterData)) {
            return false;
        }
        ScaffoldCounterData scaffoldCounterData = (ScaffoldCounterData)other;
        if (!Intrinsics.areEqual(this.heldBlock, scaffoldCounterData.heldBlock)) {
            return false;
        }
        if (this.countHotBar != scaffoldCounterData.countHotBar) {
            return false;
        }
        return this.countInventory == scaffoldCounterData.countInventory;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData$Companion;", "", "<init>", "()V", "EMPTY_ITEM_STACK_DISPLAY", "Lnet/minecraft/item/ItemStack;", "fromPlayer", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nScaffoldCounterData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldCounterData.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1#2:36\n774#3:37\n865#3,2:38\n774#3:40\n865#3,2:41\n*S KotlinDebug\n*F\n+ 1 ScaffoldCounterData.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData$Companion\n*L\n26#1:37\n26#1:38,2\n29#1:40\n29#1:41,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final ScaffoldCounterData fromPlayer(@NotNull EntityPlayerSP player) {
            int n2;
            int n3;
            ItemStack it;
            Object element$iv$iv;
            Iterable $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            EnumHand enumHand;
            block7: {
                block6: {
                    Intrinsics.checkNotNullParameter(player, "player");
                    enumHand = ScaffoldStatic.INSTANCE.getScaffoldPlaceHand(player);
                    if (enumHand == null) break block6;
                    EnumHand hand = enumHand;
                    boolean bl2 = false;
                    ItemStack itemStack = player.func_184586_b(hand);
                    enumHand = itemStack;
                    if (itemStack != null) break block7;
                }
                enumHand = EMPTY_ITEM_STACK_DISPLAY;
            }
            EnumHand stack = enumHand;
            List list = player.field_71069_bz.func_75138_a().subList(36, 44);
            Intrinsics.checkNotNullExpressionValue(list, "subList(...)");
            Iterable iterable = list;
            EnumHand enumHand2 = stack;
            int $i$f$filter = 0;
            Iterator iterator2 = $this$filter$iv;
            Collection<Object> destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo2 = false;
            Iterator iterator3 = $this$filterTo$iv$iv.iterator();
            while (iterator3.hasNext()) {
                element$iv$iv = iterator3.next();
                it = (ItemStack)element$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                if (!ScaffoldStatic.INSTANCE.allowScaffoldUse(it)) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv2;
            $i$f$filter = 0;
            for (Collection<Object> destination$iv$iv2 : $this$filter$iv) {
                void it2;
                ItemStack $i$f$filterTo2 = (ItemStack)destination$iv$iv2;
                n3 = $i$f$filter;
                boolean bl4 = false;
                int n4 = it2.func_190916_E();
                $i$f$filter = n3 + n4;
            }
            n3 = $i$f$filter;
            NonNullList nonNullList = player.field_71069_bz.func_75138_a();
            Intrinsics.checkNotNullExpressionValue(nonNullList, "getInventory(...)");
            $this$filter$iv = (Iterable)nonNullList;
            $i$f$filter = 0;
            $this$filterTo$iv$iv = $this$filter$iv;
            destination$iv$iv2 = new ArrayList();
            $i$f$filterTo2 = false;
            Iterator bl4 = $this$filterTo$iv$iv.iterator();
            while (bl4.hasNext()) {
                element$iv$iv = bl4.next();
                it = (ItemStack)element$iv$iv;
                boolean bl5 = false;
                Intrinsics.checkNotNull(it);
                if (!ScaffoldStatic.INSTANCE.allowScaffoldUse(it)) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            List list2 = (List)destination$iv$iv2;
            iterable = list2;
            int n5 = 0;
            for (Object t2 : iterable) {
                void it3;
                ItemStack $i$f$filterTo3 = (ItemStack)t2;
                int n6 = n5;
                boolean bl6 = false;
                int n7 = it3.func_190916_E();
                n5 = n6 + n7;
            }
            int n8 = n2 = n5;
            int n9 = n3;
            EnumHand enumHand3 = enumHand2;
            return new ScaffoldCounterData((ItemStack)enumHand3, n9, n8);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

