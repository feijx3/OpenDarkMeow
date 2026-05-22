/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.audio.SoundEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DHotBar;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DItemInFirstPersonEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.AnimationMode;
import net.ccbluex.liquidbounce.features.module.modules.render.animations.legacy_sword_block.AnimationModeLegacySwordBlockMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlock;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/AnimationMode;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlockMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "activeOnKeyDownValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "removeOffHandShieldValue", "onRender2DItemInFirstPersonSwingProgress", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE;", "onSound", "Lnet/ccbluex/liquidbounce/event/events/audio/SoundEvent;", "onRender2DItemInFirstPersonSwingProgressRenderItemSidePre", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide$PRE;", "isLegacySwordBlockActive", "", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAnimationModeLegacySwordBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationModeLegacySwordBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlock\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,124:1\n1#2:125\n1563#3:126\n1634#3,3:127\n1056#3:130\n1869#3:131\n1869#3,2:132\n1870#3:134\n37#4:135\n36#4,3:136\n12637#5,2:139\n12434#5,2:141\n*S KotlinDebug\n*F\n+ 1 AnimationModeLegacySwordBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/animations/legacy_sword_block/AnimationModeLegacySwordBlock\n*L\n44#1:126\n44#1:127,3\n45#1:130\n46#1:131\n47#1:132,2\n46#1:134\n60#1:135\n60#1:136,3\n121#1:139,2\n122#1:141,2\n*E\n"})
public final class AnimationModeLegacySwordBlock
extends AnimationMode {
    @NotNull
    private final Map<String, AnimationModeLegacySwordBlockMode> modes = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue modeValue = new ListValue("Mode", null, null, 6, null);
    @JvmField
    @NotNull
    public final BoolValue activeOnKeyDownValue = new BoolValue("ActiveOnKeyDown", true);
    @JvmField
    @NotNull
    public final BoolValue removeOffHandShieldValue = new BoolValue("RemoveOffHandShield", true);

    /*
     * WARNING - void declaration
     */
    public AnimationModeLegacySwordBlock() {
        super("LegacySwordBlock", true);
        BoolValue[] boolValueArray;
        BoolValue[] boolValueArray2;
        BoolValue[] it = boolValueArray2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".impl", AnimationModeLegacySwordBlockMode.class);
        boolean bl2 = false;
        this.getValues().add(this.modeValue);
        it = boolValueArray2;
        boolean bl3 = false;
        Object object = boolValueArray = !((Collection)it).isEmpty() ? boolValueArray2 : null;
        if (boolValueArray != null) {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = (Iterable)boolValueArray;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add((AnimationModeLegacySwordBlockMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AnimationModeLegacySwordBlockMode it = (AnimationModeLegacySwordBlockMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (AnimationModeLegacySwordBlockMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list != null) {
                Unit unit;
                void $this$forEach$iv;
                Iterable $i$f$sortedBy2 = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    AnimationModeLegacySwordBlockMode it3 = (AnimationModeLegacySwordBlockMode)element$iv;
                    boolean bl5 = false;
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl6 = false;
                        value.setName(it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(this.modeValue);
                            value.setSuperValueMeta(it3.getName());
                        }
                        this.getValues().add(value);
                    }
                    this.modes.put(it3.getName(), it3);
                }
                Unit it4 = unit = Unit.INSTANCE;
                boolean bl7 = false;
                Collection $this$toTypedArray$iv = this.modes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
        boolValueArray = new BoolValue[]{this.activeOnKeyDownValue, this.removeOffHandShieldValue};
        this.getValues().addAll((Collection)CollectionsKt.mutableListOf(boolValueArray));
    }

    @EventTarget
    public final void onRender2DItemInFirstPersonSwingProgress(@NotNull Render2DItemInFirstPersonEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isLegacySwordBlockActive(event.getPlayer())) {
            event.setSwingProgress(0.0f);
            event.removeEquippedProgressMainHand();
            event.removeEquippedProgressOffHand();
        }
        if (event.getItemStackOffHand().func_77973_b() instanceof ItemShield && ((Boolean)this.removeOffHandShieldValue.get()).booleanValue()) {
            ItemStack itemStack = ItemStack.field_190927_a;
            Intrinsics.checkNotNullExpressionValue(itemStack, "EMPTY");
            event.setItemStackOffHand(itemStack);
        }
    }

    @EventTarget
    public final void onRender2DItemInFirstPersonSwingProgress(@NotNull Render2DHotBar.PRE event) {
        block1: {
            ItemStack itemStack;
            ItemStack itemStack2;
            ItemStack itemStack3;
            Intrinsics.checkNotNullParameter(event, "event");
            ItemStack it = itemStack3 = event.getOffhandItem();
            boolean bl2 = false;
            Object object = itemStack2 = (Boolean)this.removeOffHandShieldValue.get() != false ? itemStack3 : null;
            if (itemStack2 == null) break block1;
            ItemStack it2 = itemStack = itemStack2;
            boolean bl3 = false;
            Object object2 = itemStack3 = it2.func_77973_b() instanceof ItemShield ? itemStack : null;
            if (itemStack3 != null) {
                it2 = itemStack = itemStack3;
                boolean bl4 = false;
                ItemStack itemStack4 = ItemStack.field_190927_a;
                Intrinsics.checkNotNullExpressionValue(itemStack4, "EMPTY");
                event.setOffhandItem(itemStack4);
            }
        }
    }

    @EventTarget
    public final void onSound(@NotNull SoundEvent event) {
        block1: {
            SoundEvent soundEvent;
            SoundEvent soundEvent2;
            SoundEvent soundEvent3;
            Intrinsics.checkNotNullParameter(event, "event");
            SoundEvent it = soundEvent3 = event;
            boolean bl2 = false;
            SoundEvent soundEvent4 = soundEvent2 = (Boolean)this.removeOffHandShieldValue.get() != false ? soundEvent3 : null;
            if (soundEvent2 == null) break block1;
            SoundEvent it2 = soundEvent = soundEvent2;
            boolean bl3 = false;
            SoundEvent soundEvent5 = soundEvent3 = Intrinsics.areEqual(it2.getSound().func_147650_b().toString(), "minecraft:item.armor.equip_generic") ? soundEvent : null;
            if (soundEvent3 != null) {
                it2 = soundEvent = soundEvent3;
                boolean bl4 = false;
                event.cancelEvent();
            }
        }
    }

    @EventTarget
    public final void onRender2DItemInFirstPersonSwingProgressRenderItemSidePre(@NotNull Render2DItemInFirstPersonEvent.RenderItemSide.PRE event) {
        block2: {
            AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode;
            AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode2;
            Intrinsics.checkNotNullParameter(event, "event");
            AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode3 = this.modes.get(this.modeValue.get());
            if (animationModeLegacySwordBlockMode3 == null) break block2;
            AnimationModeLegacySwordBlockMode it = animationModeLegacySwordBlockMode2 = animationModeLegacySwordBlockMode3;
            boolean bl2 = false;
            AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode4 = animationModeLegacySwordBlockMode = !event.getLeftHand() ? animationModeLegacySwordBlockMode2 : null;
            if (animationModeLegacySwordBlockMode != null) {
                AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode5;
                AnimationModeLegacySwordBlockMode it2 = animationModeLegacySwordBlockMode5 = animationModeLegacySwordBlockMode;
                boolean bl3 = false;
                AnimationModeLegacySwordBlockMode animationModeLegacySwordBlockMode6 = animationModeLegacySwordBlockMode2 = this.isLegacySwordBlockActive(event.getPlayer()) ? animationModeLegacySwordBlockMode5 : null;
                if (animationModeLegacySwordBlockMode2 != null) {
                    animationModeLegacySwordBlockMode2.apply(event.getPlayer(), event.getPartialTicks());
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private final boolean isLegacySwordBlockActive(AbstractClientPlayer player) {
        boolean bl2;
        block3: {
            boolean bl3;
            Boolean[] booleanArray;
            block2: {
                void $this$any$iv;
                booleanArray = new Boolean[2];
                booleanArray[0] = player.func_184614_ca().func_77973_b() instanceof ItemSword;
                Boolean[] booleanArray2 = new Boolean[]{player.func_184587_cr(), MinecraftInstance.mc.getGameSettings().field_74313_G.func_151470_d() && (Boolean)this.activeOnKeyDownValue.get() != false};
                int n2 = 1;
                Boolean[] booleanArray3 = booleanArray;
                boolean $i$f$any = false;
                for (void element$iv : $this$any$iv) {
                    boolean it = element$iv.booleanValue();
                    boolean bl4 = false;
                    if (!it) continue;
                    bl3 = true;
                    break block2;
                }
                bl3 = false;
            }
            boolean bl5 = bl3;
            booleanArray3[n2] = bl5;
            Boolean[] $this$all$iv = booleanArray;
            boolean $i$f$all = false;
            for (Boolean element$iv : $this$all$iv) {
                boolean it = element$iv;
                boolean bl6 = false;
                if (it) continue;
                bl2 = false;
                break block3;
            }
            bl2 = true;
        }
        return bl2;
    }
}

