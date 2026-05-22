/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.item;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0007\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/utils/item/ItemUtils;", "", "<init>", "()V", "getEnchantments", "", "Lnet/ccbluex/liquidbounce/utils/item/ItemUtils$ItemEnchantInfo;", "Lnet/minecraft/item/ItemStack;", "ItemEnchantInfo", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nItemUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemUtils.kt\nnet/ccbluex/liquidbounce/utils/item/ItemUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1#2:29\n*E\n"})
public final class ItemUtils {
    @NotNull
    public static final ItemUtils INSTANCE = new ItemUtils();

    private ItemUtils() {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<ItemEnchantInfo> getEnchantments(@NotNull ItemStack $this$getEnchantments) {
        Intrinsics.checkNotNullParameter($this$getEnchantments, "<this>");
        NBTTagList nBTTagList = $this$getEnchantments.func_77986_q();
        if (nBTTagList == null) {
            return CollectionsKt.emptyList();
        }
        NBTTagList enchantmentTagList = nBTTagList;
        int n2 = enchantmentTagList.func_74745_c();
        ArrayList<ItemEnchantInfo> arrayList = new ArrayList<ItemEnchantInfo>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            ItemEnchantInfo itemEnchantInfo;
            void index;
            int n3;
            int n4 = n3 = i2;
            ArrayList<ItemEnchantInfo> arrayList2 = arrayList;
            boolean bl2 = false;
            NBTTagCompound enchantmentTag = enchantmentTagList.func_150305_b((int)index);
            short id = enchantmentTag.func_74765_d("id");
            short level = enchantmentTag.func_74765_d("lvl");
            Enchantment enchantment = Enchantment.func_185262_c((int)id);
            if (enchantment != null) {
                Enchantment it;
                boolean bl3 = false;
                itemEnchantInfo = new ItemEnchantInfo(it, level);
            } else {
                itemEnchantInfo = null;
            }
            arrayList2.add(itemEnchantInfo);
        }
        return CollectionsKt.filterNotNull((Iterable)arrayList);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/utils/item/ItemUtils$ItemEnchantInfo;", "", "enchant", "Lnet/minecraft/enchantment/Enchantment;", "level", "", "<init>", "(Lnet/minecraft/enchantment/Enchantment;S)V", "getEnchant", "()Lnet/minecraft/enchantment/Enchantment;", "getLevel", "()S", "DarkMeow"})
    public static final class ItemEnchantInfo {
        @NotNull
        private final Enchantment enchant;
        private final short level;

        public ItemEnchantInfo(@NotNull Enchantment enchant, short level) {
            Intrinsics.checkNotNullParameter(enchant, "enchant");
            this.enchant = enchant;
            this.level = level;
        }

        @NotNull
        public final Enchantment getEnchant() {
            return this.enchant;
        }

        public final short getLevel() {
            return this.level;
        }
    }
}

