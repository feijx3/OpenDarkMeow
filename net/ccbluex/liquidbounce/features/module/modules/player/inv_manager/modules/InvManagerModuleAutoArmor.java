/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModeStatusCode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModule;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.item.ItemUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleAutoArmor;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModule;", "<init>", "()V", "clickModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "clickModePickModeButtonValue", "clickModePickModeDropOldArmorValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "weightMaterialDiamondValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "weightMaterialIronValue", "weightMaterialGoldValue", "weightMaterialChainmailValue", "weightMaterialLeatherValue", "weightEnchantProtectionValue", "weightEnchantUnBreakingValue", "onExecute", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode;", "isUseful", "", "slot", "", "stack", "Lnet/minecraft/item/ItemStack;", "(ILnet/minecraft/item/ItemStack;)Ljava/lang/Boolean;", "searchBestArmor", "type", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "(Lnet/minecraft/inventory/EntityEquipmentSlot;)Ljava/lang/Integer;", "getAmorWeight", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerModuleAutoArmor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerModuleAutoArmor.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleAutoArmor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1#2:127\n216#3,2:128\n1463#4,14:130\n1869#5,2:144\n*S KotlinDebug\n*F\n+ 1 InvManagerModuleAutoArmor.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleAutoArmor\n*L\n47#1:128,2\n95#1:130,14\n115#1:144,2\n*E\n"})
public final class InvManagerModuleAutoArmor
extends InvManagerModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ListValue clickModeValue;
    @NotNull
    private final ListValue clickModePickModeButtonValue;
    @NotNull
    private final BoolValue clickModePickModeDropOldArmorValue;
    @NotNull
    private final IntegerValue weightMaterialDiamondValue;
    @NotNull
    private final IntegerValue weightMaterialIronValue;
    @NotNull
    private final IntegerValue weightMaterialGoldValue;
    @NotNull
    private final IntegerValue weightMaterialChainmailValue;
    @NotNull
    private final IntegerValue weightMaterialLeatherValue;
    @NotNull
    private final IntegerValue weightEnchantProtectionValue;
    @NotNull
    private final IntegerValue weightEnchantUnBreakingValue;
    @NotNull
    private static final LinkedHashMap<EntityEquipmentSlot, Integer> SEARCH_ARMORS;

    /*
     * WARNING - void declaration
     */
    public InvManagerModuleAutoArmor() {
        super("AutoArmor", 0);
        void $this$clickModePickModeDropOldArmorValue_u24lambda_u243;
        Object $this$clickModePickModeDropOldArmorValue_u24lambda_u242;
        Object $this$clickModePickModeButtonValue_u24lambda_u241;
        Object $this$clickModePickModeButtonValue_u24lambda_u240;
        Object object = new String[]{"Pick", "Swap"};
        this.clickModeValue = new ListValue("ClickMode", (String[])object, "Pick");
        object = new String[]{"Left", "Right"};
        Object object2 = object = new ListValue("ClickModePickMouseButton", (String[])object, "Left");
        InvManagerModuleAutoArmor invManagerModuleAutoArmor = this;
        boolean bl2 = false;
        $this$clickModePickModeButtonValue_u24lambda_u240.setSuperValue(this.clickModeValue);
        $this$clickModePickModeButtonValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$clickModePickModeButtonValue_u24lambda_u241.setSuperValueMeta("Pick");
        invManagerModuleAutoArmor.clickModePickModeButtonValue = object;
        $this$clickModePickModeButtonValue_u24lambda_u241 = object = new BoolValue("ClickModePickDropOldArmor", true);
        invManagerModuleAutoArmor = this;
        boolean bl4 = false;
        $this$clickModePickModeDropOldArmorValue_u24lambda_u242.setSuperValue(this.clickModeValue);
        $this$clickModePickModeDropOldArmorValue_u24lambda_u242 = object;
        boolean bl5 = false;
        $this$clickModePickModeDropOldArmorValue_u24lambda_u243.setSuperValueMeta("Pick");
        invManagerModuleAutoArmor.clickModePickModeDropOldArmorValue = object;
        this.weightMaterialDiamondValue = new IntegerValue("WeightMaterialDiamond", 10, new IntRange(0, 10));
        this.weightMaterialIronValue = new IntegerValue("WeightMaterialIron", 4, new IntRange(0, 10));
        this.weightMaterialGoldValue = new IntegerValue("WeightMaterialGold", 0, new IntRange(0, 10));
        this.weightMaterialChainmailValue = new IntegerValue("WeightMaterialChainmail", 0, new IntRange(0, 10));
        this.weightMaterialLeatherValue = new IntegerValue("WeightMaterialLeather", 0, new IntRange(0, 10));
        this.weightEnchantProtectionValue = new IntegerValue("WeightEnchantProtection", 1, new IntRange(0, 10));
        this.weightEnchantUnBreakingValue = new IntegerValue("WeightEnchantUnBreaking", 0, new IntRange(0, 10));
    }

    @Override
    @NotNull
    public InvManagerModeStatusCode onExecute() {
        boolean doAny;
        block2: {
            doAny = false;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block2;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            Map $this$forEach$iv = SEARCH_ARMORS;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl3 = false;
                EntityEquipmentSlot type = (EntityEquipmentSlot)entry.getKey();
                int armorSlot = ((Number)entry.getValue()).intValue();
                Integer n2 = this.searchBestArmor(type);
                if (n2 == null) continue;
                Integer n3 = n2;
                int bestSlot = ((Number)n3).intValue();
                boolean bl4 = false;
                Integer n4 = (9 <= bestSlot ? bestSlot < 45 : false) ? n3 : null;
                if (n4 == null) continue;
                bestSlot = ((Number)n4).intValue();
                boolean bl5 = false;
                if (!this.getInstance().checkDelay()) {
                    return InvManagerModeStatusCode.Companion.fromBooleanCancel(doAny);
                }
                this.getInstance().debug("AutoArmor(armorSlot=" + armorSlot + ", bestSlot=" + bestSlot + ')');
                if (!Intrinsics.areEqual((String)this.clickModeValue.get(), "Pick")) continue;
                String string = (String)this.clickModePickModeButtonValue.get();
                int mouseButton = Intrinsics.areEqual(string, "Left") ? 0 : (Intrinsics.areEqual(string, "Right") ? 1 : 0);
                MinecraftInstance.mc.getPlayerController().func_187098_a(0, bestSlot, mouseButton, ClickType.PICKUP, (EntityPlayer)player);
                MinecraftInstance.mc.getPlayerController().func_187098_a(0, armorSlot, mouseButton, ClickType.PICKUP, (EntityPlayer)player);
                MinecraftInstance.mc.getPlayerController().func_187098_a(0, (Boolean)this.clickModePickModeDropOldArmorValue.get() != false ? -999 : bestSlot, mouseButton, ClickType.PICKUP, (EntityPlayer)player);
                doAny = true;
            }
        }
        return InvManagerModeStatusCode.Companion.fromBooleanNormal(doAny);
    }

    @Override
    @Nullable
    public Boolean isUseful(int slot, @NotNull ItemStack stack) {
        Boolean bl2;
        Intrinsics.checkNotNullParameter(stack, "stack");
        Item it = stack.func_77973_b();
        boolean bl3 = false;
        Object object = stack.func_77973_b();
        ItemArmor itemArmor = object instanceof ItemArmor ? (ItemArmor)object : null;
        if (itemArmor != null) {
            boolean bl4;
            it = itemArmor;
            boolean bl5 = false;
            Item item = stack.func_77973_b();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type net.minecraft.item.ItemArmor");
            EntityEquipmentSlot entityEquipmentSlot = ((ItemArmor)item).field_77881_a;
            Intrinsics.checkNotNullExpressionValue(entityEquipmentSlot, "armorType");
            object = this.searchBestArmor(entityEquipmentSlot);
            if (object != null) {
                int bestSlot = ((Number)object).intValue();
                boolean bl6 = false;
                bl4 = bestSlot == slot;
            } else {
                bl4 = false;
            }
            bl2 = bl4;
        } else {
            bl2 = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private final Integer searchBestArmor(EntityEquipmentSlot type) {
        Integer n2;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            Object v4;
            void $this$maxByOrNull$iv;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            Integer n3 = SEARCH_ARMORS.get(type);
            if (n3 == null) {
                return -1;
            }
            Object object = player.field_71069_bz.func_75138_a().get(n3.intValue());
            Intrinsics.checkNotNullExpressionValue(object, "get(...)");
            int minWeight = this.getAmorWeight((ItemStack)object);
            NonNullList nonNullList = player.field_71069_bz.func_75138_a();
            Intrinsics.checkNotNullExpressionValue(nonNullList, "getInventory(...)");
            Sequence<Pair> sequence = SequencesKt.filter(SequencesKt.mapIndexedNotNull(CollectionsKt.asSequence((Iterable)nonNullList), (arg_0, arg_1) -> InvManagerModuleAutoArmor.searchBestArmor$lambda$14$lambda$11(type, this, arg_0, arg_1)), arg_0 -> InvManagerModuleAutoArmor.searchBestArmor$lambda$14$lambda$12(minWeight, arg_0));
            boolean $i$f$maxByOrNull = false;
            Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
            if (!iterator$iv.hasNext()) {
                v4 = null;
            } else {
                Object maxElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    v4 = maxElem$iv;
                } else {
                    int weight2;
                    Pair pair = (Pair)maxElem$iv;
                    boolean bl3 = false;
                    int maxValue$iv = weight2 = ((Number)pair.component2()).intValue();
                    do {
                        Object e$iv = iterator$iv.next();
                        Pair weight2 = (Pair)e$iv;
                        $i$a$-maxByOrNull-InvManagerModuleAutoArmor$searchBestArmor$1$3 = false;
                        int weight3 = ((Number)weight2.component2()).intValue();
                        int v$iv = weight3;
                        if (maxValue$iv >= v$iv) continue;
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    } while (iterator$iv.hasNext());
                    v4 = maxElem$iv;
                }
            }
            Pair pair = v4;
            n2 = pair != null ? (Integer)pair.getFirst() : null;
        } else {
            n2 = null;
        }
        return n2;
    }

    private final int getAmorWeight(ItemStack stack) {
        int n2;
        Item item = stack.func_77973_b();
        ItemArmor itemArmor = item instanceof ItemArmor ? (ItemArmor)item : null;
        if (itemArmor == null) {
            return Integer.MIN_VALUE;
        }
        ItemArmor item2 = itemArmor;
        int weight = 0;
        ItemArmor.ArmorMaterial armorMaterial = item2.func_82812_d();
        switch (armorMaterial == null ? -1 : WhenMappings.$EnumSwitchMapping$0[armorMaterial.ordinal()]) {
            case 1: {
                n2 = ((Number)this.weightMaterialDiamondValue.get()).intValue();
                break;
            }
            case 2: {
                n2 = ((Number)this.weightMaterialIronValue.get()).intValue();
                break;
            }
            case 3: {
                n2 = ((Number)this.weightMaterialGoldValue.get()).intValue();
                break;
            }
            case 4: {
                n2 = ((Number)this.weightMaterialChainmailValue.get()).intValue();
                break;
            }
            case 5: {
                n2 = ((Number)this.weightMaterialLeatherValue.get()).intValue();
                break;
            }
            default: {
                n2 = 0;
            }
        }
        weight += n2;
        Iterable $this$forEach$iv = ItemUtils.INSTANCE.getEnchantments(stack);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ItemUtils.ItemEnchantInfo it = (ItemUtils.ItemEnchantInfo)element$iv;
            boolean bl2 = false;
            Enchantment enchantment = it.getEnchant();
            weight += Intrinsics.areEqual(enchantment, Enchantments.field_180310_c) ? ((Number)this.weightEnchantProtectionValue.get()).intValue() * it.getLevel() : (Intrinsics.areEqual(enchantment, Enchantments.field_185307_s) ? ((Number)this.weightEnchantUnBreakingValue.get()).intValue() * it.getLevel() : 0);
        }
        return weight;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Pair searchBestArmor$lambda$14$lambda$11(EntityEquipmentSlot $type, InvManagerModuleAutoArmor this$0, int index, ItemStack stack) {
        if (9 > index) return null;
        if (index >= 45) return null;
        boolean bl2 = true;
        if (!bl2) return null;
        Item item = stack.func_77973_b();
        ItemArmor itemArmor = item instanceof ItemArmor ? (ItemArmor)item : null;
        if ((itemArmor != null ? itemArmor.field_77881_a : null) != $type) return null;
        Integer n2 = index;
        Intrinsics.checkNotNull(stack);
        Pair<Integer, Integer> pair = TuplesKt.to(n2, this$0.getAmorWeight(stack));
        return pair;
    }

    private static final boolean searchBestArmor$lambda$14$lambda$12(int $minWeight, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        int weight = ((Number)pair.component2()).intValue();
        return weight > $minWeight;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(EntityEquipmentSlot.HEAD, 5), TuplesKt.to(EntityEquipmentSlot.CHEST, 6), TuplesKt.to(EntityEquipmentSlot.LEGS, 7), TuplesKt.to(EntityEquipmentSlot.FEET, 8)};
        SEARCH_ARMORS = MapsKt.linkedMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleAutoArmor$Companion;", "", "<init>", "()V", "SEARCH_ARMORS", "Ljava/util/LinkedHashMap;", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "", "Lkotlin/collections/LinkedHashMap;", "getSEARCH_ARMORS", "()Ljava/util/LinkedHashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final LinkedHashMap<EntityEquipmentSlot, Integer> getSEARCH_ARMORS() {
            return SEARCH_ARMORS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ItemArmor.ArmorMaterial.values().length];
            try {
                nArray[ItemArmor.ArmorMaterial.DIAMOND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ItemArmor.ArmorMaterial.IRON.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ItemArmor.ArmorMaterial.GOLD.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ItemArmor.ArmorMaterial.CHAIN.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ItemArmor.ArmorMaterial.LEATHER.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

