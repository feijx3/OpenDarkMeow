/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ThrowableHelper", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "useEggValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "useSnowballValue", "throwDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "searchThrowableSlot", "", "()Ljava/lang/Integer;", "checkItemIsThrowable", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nThrowableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThrowableHelper.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,72:1\n1#2:73\n785#3:74\n796#3:75\n1878#3,2:76\n797#3,2:78\n1880#3:80\n799#3:81\n1573#3:82\n1604#3,4:83\n295#3,2:87\n12637#4,2:89\n*S KotlinDebug\n*F\n+ 1 ThrowableHelper.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableHelper\n*L\n57#1:74\n57#1:75\n57#1:76,2\n57#1:78,2\n57#1:80\n57#1:81\n60#1:82\n60#1:83,4\n63#1:87,2\n71#1:89,2\n*E\n"})
public final class ThrowableHelper
extends Module {
    @NotNull
    private final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(200, 200), new IntRange(0, 1000));
    @NotNull
    private final BoolValue useEggValue = new BoolValue("UseEgg", true);
    @NotNull
    private final BoolValue useSnowballValue = new BoolValue("UseSnowball", true);
    @NotNull
    private final MSDelay throwDelay = new MSDelay();

    public ThrowableHelper() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        this.throwDelay.reset(this.delayValue);
    }

    @EventTarget(ignoreCanceled=true)
    public final void onUpdate(@NotNull UpdateEvent event) {
        block7: {
            Boolean bl2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient == null) {
                return;
            }
            NetHandlerPlayClient connection = netHandlerPlayClient;
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74312_F;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindAttack");
            Boolean bl3 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding);
            boolean it = bl3;
            boolean bl4 = false;
            Boolean bl5 = bl2 = it ? bl3 : null;
            if (bl2 == null) break block7;
            Boolean bl6 = bl2;
            boolean it2 = bl6;
            boolean bl7 = false;
            Boolean bl8 = bl3 = MSDelay.hasPassed$default(this.throwDelay, 0L, 1, null) ? bl6 : null;
            if (bl3 != null) {
                Comparable<Boolean> comparable = bl3;
                boolean it3 = comparable;
                boolean bl9 = false;
                this.onEnable();
                boolean it4 = comparable;
                boolean bl10 = false;
                comparable = this.searchThrowableSlot();
                if (comparable != null) {
                    Comparable<Boolean> comparable2;
                    Comparable<Boolean> comparable3 = comparable;
                    int it5 = ((Number)((Object)comparable3)).intValue();
                    boolean bl11 = false;
                    RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
                    Comparable<Boolean> comparable4 = comparable2 = (rayTraceResult != null ? rayTraceResult.field_72313_a : null) == RayTraceResult.Type.MISS ? comparable3 : null;
                    if (comparable2 != null) {
                        comparable3 = comparable2;
                        it5 = ((Number)((Object)comparable3)).intValue();
                        boolean bl12 = false;
                        if (it5 != player.field_71071_by.field_70461_c) {
                            connection.func_147297_a((Packet)new CPacketHeldItemChange(it5));
                        }
                        connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                        if (it5 != player.field_71071_by.field_70461_c) {
                            connection.func_147297_a((Packet)new CPacketHeldItemChange(player.field_71071_by.field_70461_c));
                        }
                    }
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer searchThrowableSlot() {
        Object v1;
        block5: {
            void $this$firstOrNull$iv;
            void $this$mapIndexedTo$iv$iv;
            void $this$mapIndexed$iv;
            void $this$filterIndexedTo$iv$iv;
            void $this$filterIndexed$iv;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) return null;
            Container container = entityPlayerSP.field_71069_bz;
            if (container == null) return null;
            NonNullList nonNullList = container.func_75138_a();
            if (nonNullList == null) return null;
            Iterable iterable = (Iterable)nonNullList;
            boolean $i$f$filterIndexed22 = false;
            void var6_7 = $this$filterIndexed$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIndexedTo = false;
            void $this$forEachIndexed$iv$iv$iv = $this$filterIndexedTo$iv$iv;
            boolean $i$f$forEachIndexed = false;
            int index$iv$iv$iv = 0;
            for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
                void element$iv$iv;
                int n2;
                if ((n2 = index$iv$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object t2 = item$iv$iv$iv;
                int index$iv$iv = n2;
                boolean bl2 = false;
                ItemStack cfr_ignored_0 = (ItemStack)element$iv$iv;
                int index = index$iv$iv;
                boolean bl3 = false;
                boolean bl4 = 36 <= index ? index < 45 : false;
                if (!bl4) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $i$f$filterIndexed22 = (List)destination$iv$iv;
            boolean $i$f$mapIndexed22 = false;
            destination$iv$iv = $this$mapIndexed$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void stack;
                void index;
                int n3;
                if ((n3 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack = (ItemStack)item$iv$iv;
                int element$iv$iv = n3;
                Collection collection = destination$iv$iv2;
                boolean bl5 = false;
                collection.add(TuplesKt.to((int)index, stack));
            }
            Iterable $i$f$mapIndexed22 = (List)destination$iv$iv2;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Pair pair = (Pair)element$iv;
                boolean bl6 = false;
                ItemStack stack = (ItemStack)pair.component2();
                Intrinsics.checkNotNull(stack);
                if (!this.checkItemIsThrowable(stack)) continue;
                v1 = element$iv;
                break block5;
            }
            v1 = null;
        }
        Pair pair = v1;
        if (pair == null) return null;
        Integer n4 = (Integer)pair.getFirst();
        return n4;
    }

    private final boolean checkItemIsThrowable(ItemStack stack) {
        boolean bl2;
        block1: {
            Boolean[] booleanArray = new Boolean[]{stack.func_77973_b() instanceof ItemEgg && (Boolean)this.useEggValue.get() != false, stack.func_77973_b() instanceof ItemSnowball && (Boolean)this.useSnowballValue.get() != false};
            Boolean[] $this$any$iv = booleanArray;
            boolean $i$f$any = false;
            for (Boolean element$iv : $this$any$iv) {
                boolean it = element$iv;
                boolean bl3 = false;
                if (!it) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }
}

