/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.minecraft.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/utils/minecraft/container/ContainerUtils;", "", "<init>", "()V", "isFull", "", "Lnet/minecraft/inventory/Container;", "excludeSlots", "", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerUtils.kt\nnet/ccbluex/liquidbounce/utils/minecraft/container/ContainerUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,17:1\n774#2:18\n865#2,2:19\n1761#2,3:21\n*S KotlinDebug\n*F\n+ 1 ContainerUtils.kt\nnet/ccbluex/liquidbounce/utils/minecraft/container/ContainerUtils\n*L\n15#1:18\n15#1:19,2\n16#1:21,3\n*E\n"})
public final class ContainerUtils {
    @NotNull
    public static final ContainerUtils INSTANCE = new ContainerUtils();

    private ContainerUtils() {
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    public final boolean isFull(@NotNull Container $this$isFull, @NotNull Collection<Integer> excludeSlots) {
        boolean bl2;
        block4: {
            void $this$filterTo$iv$iv;
            Intrinsics.checkNotNullParameter($this$isFull, "<this>");
            Intrinsics.checkNotNullParameter(excludeSlots, "excludeSlots");
            NonNullList nonNullList = $this$isFull.func_75138_a();
            Intrinsics.checkNotNullExpressionValue(nonNullList, "getInventory(...)");
            Iterable $this$filter$iv = CollectionsKt.withIndex((Iterable)nonNullList);
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                IndexedValue it = (IndexedValue)element$iv$iv;
                boolean bl3 = false;
                if (!(!excludeSlots.contains(it.getIndex()))) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$any$iv = (List)destination$iv$iv;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    IndexedValue it = (IndexedValue)element$iv;
                    boolean bl4 = false;
                    if (!((ItemStack)it.getValue()).func_190926_b()) continue;
                    bl2 = true;
                    break block4;
                }
                bl2 = false;
            }
        }
        return !bl2;
    }

    public static /* synthetic */ boolean isFull$default(ContainerUtils containerUtils, Container container, Collection collection, int n2, Object object) {
        if ((n2 & 1) != 0) {
            Integer[] integerArray = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 45};
            collection = SetsKt.setOf(integerArray);
        }
        return containerUtils.isFull(container, collection);
    }

    @JvmOverloads
    public final boolean isFull(@NotNull Container $this$isFull) {
        Intrinsics.checkNotNullParameter($this$isFull, "<this>");
        return ContainerUtils.isFull$default(this, $this$isFull, null, 1, null);
    }
}

