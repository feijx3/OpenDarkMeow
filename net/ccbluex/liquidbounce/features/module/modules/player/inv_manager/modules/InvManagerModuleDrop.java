/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.player.InvManager;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModeStatusCode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModule;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleDrop;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModule;", "<init>", "()V", "slotSortValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "slotInventoryValue", "slotOffhandValue", "ignoreDelayValue", "onExecute", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManagerModuleDrop.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManagerModuleDrop.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleDrop\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,62:1\n1573#2:63\n1604#2,4:64\n536#3:68\n521#3,2:69\n523#3,4:73\n536#3:77\n521#3,6:78\n12637#4,2:71\n216#5,2:84\n*S KotlinDebug\n*F\n+ 1 InvManagerModuleDrop.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleDrop\n*L\n32#1:63\n32#1:64,4\n35#1:68\n35#1:69,2\n35#1:73,4\n43#1:77\n43#1:78,6\n40#1:71,2\n45#1:84,2\n*E\n"})
public final class InvManagerModuleDrop
extends InvManagerModule {
    @NotNull
    private final BoolValue slotSortValue = new BoolValue("SlotSort", true);
    @NotNull
    private final BoolValue slotInventoryValue = new BoolValue("SlotInventory", true);
    @NotNull
    private final BoolValue slotOffhandValue = new BoolValue("SlotOffhand", false);
    @NotNull
    private final BoolValue ignoreDelayValue = new BoolValue("IgnoreDelay", false);

    public InvManagerModuleDrop() {
        super("Drop", 2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public InvManagerModeStatusCode onExecute() {
        boolean doAny;
        block8: {
            void $this$forEach$iv;
            Object $this$filterTo$iv$iv;
            Object $this$filter$iv;
            Object item$iv$iv2;
            void $this$mapIndexedTo$iv$iv;
            Map $this$mapIndexed$iv;
            doAny = false;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block8;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            NonNullList nonNullList = player.field_71069_bz.func_75138_a();
            Intrinsics.checkNotNullExpressionValue(nonNullList, "getInventory(...)");
            Iterable iterable = (Iterable)nonNullList;
            boolean $i$f$mapIndexed = false;
            Iterator iterator2 = $this$mapIndexed$iv;
            Object destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv2 : $this$mapIndexedTo$iv$iv) {
                void stack;
                void index2;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack = (ItemStack)item$iv$iv2;
                int n3 = n2;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(TuplesKt.to((int)index2, stack));
            }
            $this$mapIndexed$iv = MapsKt.toMap((List)destination$iv$iv);
            boolean $i$f$filter = false;
            $this$mapIndexedTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new LinkedHashMap();
            boolean $i$f$filterTo = false;
            for (Map.Entry element$iv$iv : $this$filterTo$iv$iv.entrySet()) {
                boolean bl4;
                block7: {
                    void $this$any$iv;
                    item$iv$iv2 = element$iv$iv;
                    boolean bl5 = false;
                    int index = ((Number)item$iv$iv2.getKey()).intValue();
                    Boolean[] index2 = new Boolean[3];
                    index2[0] = (9 <= index ? index < 36 : false) && (Boolean)this.slotInventoryValue.get() != false;
                    index2[1] = (36 <= index ? index < 45 : false) && (Boolean)this.slotSortValue.get() != false;
                    index2[2] = index == 45 && (Boolean)this.slotOffhandValue.get() != false;
                    boolean $i$f$any = false;
                    for (void element$iv : $this$any$iv) {
                        boolean it = element$iv.booleanValue();
                        boolean bl6 = false;
                        if (!it) continue;
                        bl4 = true;
                        break block7;
                    }
                    bl4 = false;
                }
                if (!bl4) continue;
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
            $this$filter$iv = destination$iv$iv;
            $i$f$filter = false;
            $this$filterTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new LinkedHashMap();
            $i$f$filterTo = false;
            for (Map.Entry element$iv$iv : $this$filterTo$iv$iv.entrySet()) {
                item$iv$iv2 = element$iv$iv;
                boolean bl7 = false;
                ItemStack stack = (ItemStack)item$iv$iv2.getValue();
                if (!(!stack.func_190926_b())) continue;
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
            $this$filter$iv = destination$iv$iv;
            boolean $i$f$forEach = false;
            iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl8 = false;
                int index = ((Number)entry.getKey()).intValue();
                ItemStack stack = (ItemStack)entry.getValue();
                InvManager invManager = this.getInstance();
                Intrinsics.checkNotNull(stack);
                if (InvManager.isUseful$default(invManager, stack, index, false, 4, null)) continue;
                if (!((Boolean)this.ignoreDelayValue.get()).booleanValue() && !this.getInstance().checkDelay()) {
                    return InvManagerModeStatusCode.Companion.fromBooleanCancel(doAny);
                }
                MinecraftInstance.mc.getPlayerController().func_187098_a(0, index, 1, ClickType.THROW, (EntityPlayer)player);
                this.getInstance().debug("DropItem(slot=" + index + ')');
                doAny = true;
            }
        }
        return InvManagerModeStatusCode.Companion.fromBooleanNormal(doAny);
    }
}

