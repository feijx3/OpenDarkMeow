/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/ArmorBreaker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "enchantLevelLimitValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onlySwordValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onlyHurtTimeZeroValue", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nArmorBreaker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArmorBreaker.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ArmorBreaker\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n20#2,3:67\n1583#3,11:70\n1878#3,2:81\n1880#3:85\n1594#3:86\n1999#3,14:87\n1#4:83\n1#4:84\n*S KotlinDebug\n*F\n+ 1 ArmorBreaker.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ArmorBreaker\n*L\n37#1:67,3\n41#1:70,11\n41#1:81,2\n41#1:85\n41#1:86\n50#1:87,14\n41#1:84\n*E\n"})
public final class ArmorBreaker
extends Module {
    @JvmField
    @NotNull
    public final IntegerValue enchantLevelLimitValue = new IntegerValue("EnchantLevelLimit", 1, new IntRange(1, 10));
    @JvmField
    @NotNull
    public final BoolValue onlySwordValue = new BoolValue("OnlySword", true);
    @JvmField
    @NotNull
    public final BoolValue onlyHurtTimeZeroValue = new BoolValue("OnlyHurtTimeZero", true);

    /*
     * WARNING - void declaration
     */
    public ArmorBreaker() {
        super("ArmorBreaker", ModuleCategory.COMBAT, null, null, 12, null);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, ControllerUseEntityAttackEvent, Unit> function$iv = (arg_0, arg_1) -> ArmorBreaker._init_$lambda$9(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<ControllerUseEntityAttackEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerUseEntityAttackEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit lambda$9$lambda$8$lambda$7(SafeListenerBase $this_safeListener, Entity target) {
        Intrinsics.checkNotNullParameter(target, "target");
        ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem($this_safeListener.getPlayerController());
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final Unit _init_$lambda$9(ArmorBreaker this$0, SafeListenerBase $this$safeListener, ControllerUseEntityAttackEvent event) {
        block11: {
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            if (((Boolean)this$0.onlyHurtTimeZeroValue.get()).booleanValue()) {
                var4_3 /* !! */  = event.getTarget();
                v0 = var4_3 /* !! */  instanceof EntityLivingBase != false ? (EntityLivingBase)var4_3 /* !! */  : null;
                if (!(v0 != null ? v0.field_70737_aN == 0 : false)) {
                    return Unit.INSTANCE;
                }
            }
            v1 = $this$safeListener.getPlayer().field_71069_bz.func_75138_a().subList(36, 44);
            Intrinsics.checkNotNullExpressionValue(v1, "subList(...)");
            var4_3 /* !! */  = v1;
            $i$f$mapIndexedNotNull = false;
            var6_6 = $this$mapIndexedNotNull$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$mapIndexedNotNullTo = false;
            $this$forEachIndexed$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv;
            $i$f$forEachIndexed = false;
            index$iv$iv$iv = 0;
            for (T item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
                if ((var14_20 = index$iv$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                var15_21 = item$iv$iv$iv;
                index$iv$iv = var14_20;
                $i$a$-forEachIndexed-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$iv$iv = false;
                var18_24 = (ItemStack)element$iv$iv;
                index = index$iv$iv;
                $i$a$-mapIndexedNotNull-ArmorBreaker$1$1 = false;
                var21_27 = stack;
                it = var21_27;
                $i$a$-takeUnless-ArmorBreaker$1$1$1 = false;
                v2 = var24_31 = $this$safeListener.getPlayer().field_71071_by.field_70461_c == index == false ? var21_27 : null;
                if (var24_31 == null) ** GOTO lbl-1000
                it = var22_28 = var24_31;
                $i$a$-takeIf-ArmorBreaker$1$1$2 = false;
                v3 = var21_27 = ((Boolean)this$0.onlySwordValue.get() == false || it.func_77973_b() instanceof ItemSword != false) != false ? var22_28 : null;
                if (var21_27 == null) ** GOTO lbl-1000
                it = var21_27;
                $i$a$-let-ArmorBreaker$1$1$3 = false;
                var22_28 = (Integer)EnchantmentHelper.func_82781_a(it).get(Enchantments.field_185302_k);
                if (var22_28 == null) ** GOTO lbl-1000
                var25_33 = var22_28;
                level = ((Number)var25_33).intValue();
                $i$a$-takeIf-ArmorBreaker$1$1$4 = false;
                v4 = var23_30 = ((Number)this$0.enchantLevelLimitValue.get()).intValue() <= level != false ? var25_33 : null;
                if (var23_30 != null) {
                    level = ((Number)var23_30).intValue();
                    $i$a$-let-ArmorBreaker$1$1$5 = false;
                    v5 = TuplesKt.to(index, level);
                } else lbl-1000:
                // 4 sources

                {
                    v5 = null;
                }
                if (v5 == null) continue;
                it$iv$iv = v5;
                $i$a$-let-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$1$iv$iv = false;
                destination$iv$iv.add(it$iv$iv);
            }
            $this$mapIndexedNotNull$iv = (List)destination$iv$iv;
            $i$f$maxByOrNull = false;
            iterator$iv = $this$maxByOrNull$iv.iterator();
            if (!iterator$iv.hasNext()) {
                v6 = null;
            } else {
                maxElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    v6 = maxElem$iv;
                } else {
                    it = (Pair)maxElem$iv;
                    $i$a$-maxByOrNull-ArmorBreaker$1$2 = false;
                    maxValue$iv = ((Number)it.getFirst()).intValue();
                    do {
                        e$iv = iterator$iv.next();
                        it = (Pair)e$iv;
                        $i$a$-maxByOrNull-ArmorBreaker$1$2 = false;
                        v$iv = ((Number)it.getFirst()).intValue();
                        if (maxValue$iv >= v$iv) continue;
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    } while (iterator$iv.hasNext());
                    v6 = maxElem$iv;
                }
            }
            var3_38 = v6;
            if (var3_38 == null) break block11;
            var5_5 = ((Number)var3_38.getFirst()).intValue();
            slot = ((Number)var5_5).intValue();
            $i$a$-also-ArmorBreaker$1$3 = false;
            prevSlot = $this$safeListener.getPlayer().field_71071_by.field_70461_c;
            $this$safeListener.getPlayer().field_71071_by.field_70461_c = slot;
            ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem($this$safeListener.getPlayerController());
            $this$safeListener.getPlayer().field_71071_by.field_70461_c = prevSlot;
            event.setCancelSyncCurrentItem(true);
            event.postAction((Function1<Entity, Unit>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, lambda$9$lambda$8$lambda$7(net.darkmeow.darkmeow.event.listenable.SafeListenerBase net.minecraft.entity.Entity ), (Lnet/minecraft/entity/Entity;)Lkotlin/Unit;)((SafeListenerBase)$this$safeListener));
        }
        return Unit.INSTANCE;
    }
}

