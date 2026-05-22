/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModeStatusCode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModule;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotMode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0002J\u0017\u0010$\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0002\u00a2\u0006\u0002\u0010%R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u0005j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u00a8\u0006)"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModule;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "slot1Value", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "slot2Value", "slot3Value", "slot4Value", "slot5Value", "slot6Value", "slot7Value", "slot8Value", "slot9Value", "slotOffHandValue", "clickModeValue", "slotValueLinks", "", "onExecute", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode;", "isUseful", "", "slot", "stack", "Lnet/minecraft/item/ItemStack;", "(ILnet/minecraft/item/ItemStack;)Ljava/lang/Boolean;", "getSkipSlots", "getSkipDrops", "getBestItem", "(I)Ljava/lang/Integer;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerModuleSortSlot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerModuleSortSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,245:1\n1563#2:246\n1634#2,3:247\n1056#2:250\n1869#2:251\n1869#2,2:252\n1870#2:254\n295#2,2:315\n37#3:255\n36#3,3:256\n37#3:259\n36#3,3:260\n37#3:263\n36#3,3:264\n37#3:267\n36#3,3:268\n37#3:271\n36#3,3:272\n37#3:275\n36#3,3:276\n37#3:279\n36#3,3:280\n37#3:283\n36#3,3:284\n37#3:287\n36#3,3:288\n37#3:291\n36#3,3:292\n216#4,2:295\n136#4,9:298\n216#4:307\n217#4:318\n145#4:319\n188#4,3:323\n216#4:330\n217#4:338\n188#4,3:353\n1#5:297\n1#5:317\n536#6:308\n521#6,6:309\n536#6:320\n521#6,2:321\n523#6,4:326\n536#6:331\n521#6,6:332\n536#6:339\n521#6,6:340\n536#6:346\n521#6,6:347\n*S KotlinDebug\n*F\n+ 1 InvManagerModuleSortSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot\n*L\n21#1:246\n21#1:247,3\n22#1:250\n23#1:251\n26#1:252,2\n23#1:254\n142#1:315,2\n40#1:255\n40#1:256,3\n41#1:259\n41#1:260,3\n42#1:263\n42#1:264,3\n43#1:267\n43#1:268,3\n44#1:271\n44#1:272,3\n45#1:275\n45#1:276,3\n46#1:279\n46#1:280,3\n47#1:283\n47#1:284,3\n48#1:287\n48#1:288,3\n49#1:291\n49#1:292,3\n74#1:295,2\n133#1:298,9\n133#1:307\n133#1:318\n133#1:319\n164#1:323,3\n168#1:330\n168#1:338\n29#1:353,3\n133#1:317\n136#1:308\n136#1:309,6\n163#1:320\n163#1:321,2\n163#1:326,4\n171#1:331\n171#1:332,6\n198#1:339\n198#1:340,6\n202#1:346\n202#1:347,6\n*E\n"})
public final class InvManagerModuleSortSlot
extends InvManagerModule {
    @NotNull
    private final LinkedHashMap<String, InvManagerSortSlotMode> modes = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final ListValue slot1Value;
    @NotNull
    private final ListValue slot2Value;
    @NotNull
    private final ListValue slot3Value;
    @NotNull
    private final ListValue slot4Value;
    @NotNull
    private final ListValue slot5Value;
    @NotNull
    private final ListValue slot6Value;
    @NotNull
    private final ListValue slot7Value;
    @NotNull
    private final ListValue slot8Value;
    @NotNull
    private final ListValue slot9Value;
    @NotNull
    private final ListValue slotOffHandValue;
    @NotNull
    private final ListValue clickModeValue;
    @NotNull
    private final LinkedHashMap<Integer, ListValue> slotValueLinks;
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public InvManagerModuleSortSlot() {
        super("SortShot", 0);
        void it;
        Object object;
        Iterator $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".sort_slot.impl", InvManagerSortSlotMode.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it2;
            Object item$iv$iv = iterator2.next();
            Class clazz = (Class)item$iv$iv;
            object = destination$iv$iv;
            boolean bl2 = false;
            object.add((InvManagerSortSlotMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                InvManagerSortSlotMode it = (InvManagerSortSlotMode)a2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(it.getSort());
                it = (InvManagerSortSlotMode)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, it.getSort());
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            InvManagerSortSlotMode it3 = (InvManagerSortSlotMode)element$iv;
            boolean bl3 = false;
            it3.setInstance(this);
            Iterable $this$forEach$iv2 = it3.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                this.settingsModuleValues.add(value.displayable(() -> InvManagerModuleSortSlot.lambda$5$lambda$4$lambda$3(this, it3)));
            }
            ((Map)this.modes).put(it3.getModeName(), it3);
        }
        Set<String> set = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Collection $this$toTypedArray$iv = set;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.slot1Value = new ListValue("Slot1", thisCollection$iv.toArray(new String[0]), "Sword");
        Set<String> set2 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set2, "<get-keys>(...)");
        $this$toTypedArray$iv = set2;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot2Value = new ListValue("Sort2", thisCollection$iv.toArray(new String[0]), "Block");
        Set<String> set3 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set3, "<get-keys>(...)");
        $this$toTypedArray$iv = set3;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot3Value = new ListValue("Sort3", thisCollection$iv.toArray(new String[0]), "Bow");
        Set<String> set4 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set4, "<get-keys>(...)");
        $this$toTypedArray$iv = set4;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot4Value = new ListValue("Sort4", thisCollection$iv.toArray(new String[0]), "EnderPearl");
        Set<String> set5 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set5, "<get-keys>(...)");
        $this$toTypedArray$iv = set5;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot5Value = new ListValue("Sort5", thisCollection$iv.toArray(new String[0]), "Potion");
        Set<String> set6 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set6, "<get-keys>(...)");
        $this$toTypedArray$iv = set6;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot6Value = new ListValue("Sort6", thisCollection$iv.toArray(new String[0]), "Pickaxe");
        Set<String> set7 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set7, "<get-keys>(...)");
        $this$toTypedArray$iv = set7;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot7Value = new ListValue("Sort7", thisCollection$iv.toArray(new String[0]), "Throwable");
        Set<String> set8 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set8, "<get-keys>(...)");
        $this$toTypedArray$iv = set8;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot8Value = new ListValue("Sort8", thisCollection$iv.toArray(new String[0]), "SpecialSharpness");
        Set<String> set9 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set9, "<get-keys>(...)");
        $this$toTypedArray$iv = set9;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slot9Value = new ListValue("Sort9", thisCollection$iv.toArray(new String[0]), "GoldenApple");
        Set<String> set10 = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set10, "<get-keys>(...)");
        $this$toTypedArray$iv = set10;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.slotOffHandValue = new ListValue("SortOffHand", thisCollection$iv.toArray(new String[0]), "None");
        Object object2 = new String[]{"Pick", "Swap"};
        this.clickModeValue = new ListValue("ClickMode", (String[])object2, "Swap");
        object2 = new Pair[]{TuplesKt.to(36, this.slot1Value), TuplesKt.to(37, this.slot2Value), TuplesKt.to(38, this.slot3Value), TuplesKt.to(39, this.slot4Value), TuplesKt.to(40, this.slot5Value), TuplesKt.to(41, this.slot6Value), TuplesKt.to(42, this.slot7Value), TuplesKt.to(43, this.slot8Value), TuplesKt.to(44, this.slot9Value), TuplesKt.to(45, this.slotOffHandValue)};
        this.slotValueLinks = MapsKt.linkedMapOf(object2);
        Object $i$f$toTypedArray2 = object2 = this.settingsModuleValues;
        object = this;
        boolean bl5 = false;
        ListValue[] listValueArray = new ListValue[]{this.slot1Value, this.slot2Value, this.slot3Value, this.slot4Value, this.slot5Value, this.slot6Value, this.slot7Value, this.slot8Value, this.slot9Value, this.slotOffHandValue, this.clickModeValue};
        it.addAll(0, (Collection)CollectionsKt.mutableListOf(listValueArray));
        ((InvManagerModuleSortSlot)object).values = object2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @NotNull
    public InvManagerModeStatusCode onExecute() {
        block7: {
            doAny = false;
            v0 = MinecraftInstance.mc.getPlayer();
            if (v0 == null) break block7;
            player = v0;
            $i$a$-let-InvManagerModuleSortSlot$onExecute$1 = false;
            if (!((ItemStack)player.field_71069_bz.func_75138_a().get(0)).func_190926_b()) break block7;
            $this$forEach$iv = this.slotValueLinks;
            $i$f$forEach = false;
            var6_6 = $this$forEach$iv.entrySet().iterator();
            while (var6_6.hasNext()) {
                var8_8 = element$iv = var6_6.next();
                $i$a$-forEach-InvManagerModuleSortSlot$onExecute$1$1 = false;
                currentSlot = ((Number)var8_8.getKey()).intValue();
                var11_11 = this.getBestItem(currentSlot);
                if (var11_11 == null) continue;
                var12_12 = var11_11;
                it = ((Number)var12_12).intValue();
                $i$a$-takeIf-InvManagerModuleSortSlot$onExecute$1$1$1 = false;
                if (it == currentSlot) ** GOTO lbl-1000
                v1 = 1 <= it ? it < 46 : false;
                if (v1) {
                    v2 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v2 = false;
                }
                if ((var15_15 = v2 != false ? var12_12 : null) == null) continue;
                bestSlot = ((Number)var15_15).intValue();
                $i$a$-let-InvManagerModuleSortSlot$onExecute$1$1$2 = false;
                if (!this.getInstance().checkDelay()) {
                    return InvManagerModeStatusCode.Companion.fromBooleanCancel(doAny);
                }
                var16_16 = (String)this.clickModeValue.get();
                if (Intrinsics.areEqual(var16_16, "Pick")) {
                    MinecraftInstance.mc.getPlayerController().func_187098_a(0, bestSlot, 0, ClickType.PICKUP, (EntityPlayer)player);
                    MinecraftInstance.mc.getPlayerController().func_187098_a(0, currentSlot, 0, ClickType.PICKUP, (EntityPlayer)player);
                    MinecraftInstance.mc.getPlayerController().func_187098_a(0, bestSlot, 0, ClickType.PICKUP, (EntityPlayer)player);
                } else if (Intrinsics.areEqual(var16_16, "Swap")) {
                    MinecraftInstance.mc.getPlayerController().func_187098_a(0, bestSlot, currentSlot - 36, ClickType.SWAP, (EntityPlayer)player);
                }
                doAny = true;
            }
        }
        return InvManagerModeStatusCode.Companion.fromBooleanNormal(doAny);
    }

    @Override
    @Nullable
    public Boolean isUseful(int slot, @NotNull ItemStack stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Boolean bl2 = this.getSkipDrops().contains(slot);
        boolean it = bl2;
        boolean bl3 = false;
        return it ? bl2 : null;
    }

    /*
     * WARNING - void declaration
     */
    private final List<Integer> getSkipSlots() {
        Object object;
        block15: {
            block14: {
                void $this$mapNotNullTo$iv$iv;
                object = MinecraftInstance.mc.getPlayer();
                if (object == null) break block14;
                EntityPlayerSP player = object;
                boolean bl2 = false;
                Map $this$mapNotNull$iv = this.slotValueLinks;
                boolean $i$f$mapNotNull = false;
                Map map = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Integer n2;
                    Map.Entry element$iv$iv$iv;
                    Map.Entry element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl3 = false;
                    Map.Entry entry = element$iv$iv;
                    boolean bl4 = false;
                    int checkSlot = ((Number)entry.getKey()).intValue();
                    Map map2 = this.modes;
                    ListValue listValue = this.slotValueLinks.get(checkSlot);
                    InvManagerSortSlotMode invManagerSortSlotMode = (InvManagerSortSlotMode)map2.get(listValue != null ? (String)listValue.get() : null);
                    if (invManagerSortSlotMode != null && (map2 = invManagerSortSlotMode.searchSlot(new InvManagerSortSlotPlayerInventory(player))) != null) {
                        void $this$filterTo$iv$iv;
                        void $this$filter$iv;
                        Map map3 = map2;
                        boolean $i$f$filter = false;
                        void var21_23 = $this$filter$iv;
                        Map destination$iv$iv2 = new LinkedHashMap();
                        boolean $i$f$filterTo22 = false;
                        Iterator iterator3 = $this$filterTo$iv$iv.entrySet().iterator();
                        while (iterator3.hasNext()) {
                            Map.Entry entry2;
                            Map.Entry entry3 = entry2 = iterator3.next();
                            boolean bl5 = false;
                            int weight = ((Number)entry3.getValue()).intValue();
                            if (!(weight >= 0)) continue;
                            destination$iv$iv2.put(entry2.getKey(), entry2.getValue());
                        }
                        Map it = destination$iv$iv2;
                        boolean bl6 = false;
                        Integer n3 = (Integer)it.get(checkSlot);
                        if (n3 == null) {
                            n2 = null;
                        } else {
                            Object v4;
                            block13: {
                                void $this$firstOrNull$iv;
                                int checkSlotWeight = n3;
                                Iterable $i$f$filterTo22 = it.values();
                                boolean $i$f$firstOrNull = false;
                                for (Object element$iv : $this$firstOrNull$iv) {
                                    int checkSubSlot = ((Number)element$iv).intValue();
                                    boolean bl7 = false;
                                    if (!(checkSubSlot > checkSlotWeight)) continue;
                                    v4 = element$iv;
                                    break block13;
                                }
                                v4 = null;
                            }
                            Integer n4 = v4;
                            if (n4 != null) {
                                int it2 = ((Number)n4).intValue();
                                boolean bl5 = false;
                                n2 = null;
                            } else {
                                n2 = checkSlot;
                            }
                        }
                    } else {
                        n2 = null;
                    }
                    if (n2 == null) continue;
                    Integer it$iv$iv = n2;
                    boolean bl9 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                List list = CollectionsKt.toMutableList((List)destination$iv$iv);
                object = list;
                if (list != null) break block15;
            }
            object = new ArrayList();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private final List<Integer> getSkipDrops() {
        List list;
        List it = list = (List)new ArrayList();
        boolean bl2 = false;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            void $this$forEach$iv;
            Object object;
            Object it2;
            void $this$filterTo$iv$iv;
            Map $this$filter$iv;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl3 = false;
            Map map = this.modes;
            boolean $i$f$filter = false;
            Iterator iterator2 = $this$filter$iv;
            Map destination$iv$iv = new LinkedHashMap();
            boolean $i$f$filterTo = false;
            for (Map.Entry element$iv$iv : $this$filterTo$iv$iv.entrySet()) {
                boolean bl4;
                block7: {
                    it2 = element$iv$iv;
                    boolean bl5 = false;
                    Map $this$any$iv = this.slotValueLinks;
                    boolean $i$f$any = false;
                    if ($this$any$iv.isEmpty()) {
                        bl4 = false;
                    } else {
                        for (Map.Entry element$iv : $this$any$iv.entrySet()) {
                            object = element$iv;
                            boolean bl6 = false;
                            ListValue value = (ListValue)object.getValue();
                            if (!Intrinsics.areEqual(value.get(), it2.getKey())) continue;
                            bl4 = true;
                            break block7;
                        }
                        bl4 = false;
                    }
                }
                if (!bl4) continue;
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
            $this$filter$iv = destination$iv$iv;
            boolean $i$f$forEach = false;
            iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                void $this$filterTo$iv$iv2;
                void $this$filter$iv2;
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl7 = false;
                InvManagerSortSlotMode mode = (InvManagerSortSlotMode)entry.getValue();
                it2 = mode.searchSlot(new InvManagerSortSlotPlayerInventory(player));
                List list2 = it;
                boolean $i$f$filter2 = false;
                void $i$f$any = $this$filter$iv2;
                Map destination$iv$iv2 = new LinkedHashMap();
                boolean $i$f$filterTo2 = false;
                object = $this$filterTo$iv$iv2.entrySet().iterator();
                while (object.hasNext()) {
                    Map.Entry element$iv$iv;
                    Map.Entry entry2 = element$iv$iv = (Map.Entry)object.next();
                    boolean bl8 = false;
                    int weight = ((Number)entry2.getValue()).intValue();
                    boolean bl9 = mode.getKeepAll() ? weight >= -1 : weight == -1;
                    if (!bl9) continue;
                    destination$iv$iv2.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                }
                list2.addAll(destination$iv$iv2.keySet());
            }
        }
        it = list;
        boolean bl10 = false;
        it.addAll((Collection)this.getSkipSlots());
        return CollectionsKt.toMutableList(CollectionsKt.distinct(list));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer getBestItem(int slot) {
        Object v2;
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        void $this$filterTo$iv$iv2;
        void $this$filter$iv2;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) return null;
        EntityPlayerSP player = entityPlayerSP;
        boolean bl2 = false;
        List<Integer> skipSlots = this.getSkipSlots();
        if (skipSlots.contains(slot)) {
            return null;
        }
        Map map = this.modes;
        ListValue listValue = this.slotValueLinks.get(slot);
        InvManagerSortSlotMode invManagerSortSlotMode = (InvManagerSortSlotMode)map.get(listValue != null ? (String)listValue.get() : null);
        if (invManagerSortSlotMode == null) return null;
        map = invManagerSortSlotMode.searchSlot(new InvManagerSortSlotPlayerInventory(player));
        if (map == null) return null;
        Map map2 = map;
        boolean $i$f$filter22 = false;
        void var9_10 = $this$filter$iv2;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = iterator2.next();
            boolean bl3 = false;
            int checkSlot = ((Number)entry2.getKey()).intValue();
            if (!(!skipSlots.contains(checkSlot))) continue;
            destination$iv$iv.put(entry.getKey(), entry.getValue());
        }
        Map $i$f$filter22 = destination$iv$iv;
        boolean $i$f$filter = false;
        destination$iv$iv = $this$filter$iv;
        Map destination$iv$iv2 = new LinkedHashMap();
        boolean bl4 = false;
        Iterator iterator3 = $this$filterTo$iv$iv.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry bl3 = element$iv$iv = iterator3.next();
            boolean bl5 = false;
            int weight = ((Number)bl3.getValue()).intValue();
            if (!(weight >= 0)) continue;
            destination$iv$iv2.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        Object object = destination$iv$iv2.entrySet();
        Iterator iterator4 = object.iterator();
        if (!iterator4.hasNext()) {
            v2 = null;
        } else {
            Object t2 = iterator4.next();
            if (!iterator4.hasNext()) {
                v2 = t2;
            } else {
                void var12_18;
                int checkWeight;
                Map.Entry entry = (Map.Entry)t2;
                boolean bl62 = false;
                int n2 = checkWeight = ((Number)entry.getValue()).intValue();
                do {
                    int n3;
                    Object bl62 = iterator4.next();
                    Map.Entry entry3 = (Map.Entry)bl62;
                    boolean $i$a$-maxByOrNull-InvManagerModuleSortSlot$getBestItem$1$4 = false;
                    int checkWeight2 = ((Number)entry3.getValue()).intValue();
                    int n4 = checkWeight2;
                    if (n3 >= n4) continue;
                    Object e2 = bl62;
                    n3 = n4;
                } while (iterator4.hasNext());
                v2 = var12_18;
            }
        }
        Map.Entry entry = v2;
        if (entry == null) return null;
        iterator4 = ((Number)entry.getKey()).intValue();
        int n5 = ((Number)((Object)iterator4)).intValue();
        boolean bl7 = false;
        if (1 > n5) return null;
        if (n5 >= 46) return null;
        boolean bl8 = true;
        if (!bl8) return null;
        Iterator iterator5 = iterator4;
        object = iterator5;
        if (object == null) return null;
        Object object2 = object;
        int n6 = ((Number)object2).intValue();
        boolean bl9 = false;
        if (n6 == slot) return null;
        boolean bl10 = true;
        if (!bl10) return null;
        Object object3 = object2;
        iterator4 = object3;
        if (iterator4 == null) return null;
        Iterator iterator6 = iterator4;
        int n7 = ((Number)((Object)iterator6)).intValue();
        boolean bl11 = false;
        Object[] objectArray = new String[]{"SortSlot(", "slot=" + slot + ", ", "skips=" + (skipSlots.isEmpty() ? "null" : CollectionsKt.joinToString$default(skipSlots, ",", null, null, 0, null, null, 62, null)) + ", ", "bestSlot=" + n7, ")"};
        this.getInstance().debug(ArraysKt.joinToString$default(objectArray, (CharSequence)"", null, null, 0, null, null, 62, null));
        Iterator iterator7 = iterator6;
        return iterator7;
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(InvManagerModuleSortSlot this$0, InvManagerSortSlotMode $it) {
        boolean bl2;
        block3: {
            Map $this$any$iv = this$0.slotValueLinks;
            boolean $i$f$any = false;
            if ($this$any$iv.isEmpty()) {
                bl2 = false;
            } else {
                Iterator iterator2 = $this$any$iv.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry element$iv;
                    Map.Entry entry = element$iv = iterator2.next();
                    boolean bl3 = false;
                    ListValue value = (ListValue)entry.getValue();
                    if (!Intrinsics.areEqual(value.get(), $it.getModeName())) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }
}

