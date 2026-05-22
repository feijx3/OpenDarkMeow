/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.movement.fast_ladder.FastLadderMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0007J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000eH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/FastLadderMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "handleFastFall", "", "Lnet/minecraft/client/entity/EntityPlayerSP;", "handleFastClimb", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFastLadder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastLadder.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,67:1\n1#2:68\n1563#3:69\n1634#3,3:70\n1056#3:73\n1869#3:74\n1869#3,2:75\n1870#3:77\n37#4:78\n36#4,3:79\n*S KotlinDebug\n*F\n+ 1 FastLadder.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder\n*L\n31#1:69\n31#1:70,3\n32#1:73\n33#1:74\n36#1:75,2\n33#1:77\n49#1:78\n49#1:79,3\n*E\n"})
public final class FastLadder
extends Module {
    @NotNull
    public static final FastLadder INSTANCE;
    @NotNull
    private static final Map<String, FastLadderMode> modes;
    @NotNull
    private static final ListValue modeValue;

    private FastLadder() {
        super("FastLadder", ModuleCategory.MOVEMENT, null, null, 12, null);
    }

    @NotNull
    public final ListValue getModeValue() {
        return modeValue;
    }

    @JvmStatic
    public static final boolean handleFastFall(@NotNull EntityPlayerSP $this$handleFastFall) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$handleFastFall, "<this>");
        if ($this$handleFastFall.field_70122_E) {
            return false;
        }
        if ($this$handleFastFall.field_70181_x >= 0.0) {
            return false;
        }
        MovementInput movementInput = $this$handleFastFall.field_71158_b;
        Intrinsics.checkNotNullExpressionValue(movementInput, "movementInput");
        if (MovementUtils.INSTANCE.hasMove(movementInput)) {
            return false;
        }
        if ($this$handleFastFall.field_71158_b.field_78899_d) {
            return false;
        }
        FastLadderMode fastLadderMode = modes.get(modeValue.get());
        if (fastLadderMode != null) {
            FastLadderMode $this$handleFastFall_u24lambda_u246 = fastLadderMode;
            boolean bl3 = false;
            bl2 = $this$handleFastFall_u24lambda_u246.handleFastFall($this$handleFastFall);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @JvmStatic
    public static final void handleFastClimb(@NotNull EntityPlayerSP $this$handleFastClimb) {
        block0: {
            Intrinsics.checkNotNullParameter($this$handleFastClimb, "<this>");
            FastLadderMode fastLadderMode = modes.get(modeValue.get());
            if (fastLadderMode == null) break block0;
            FastLadderMode $this$handleFastClimb_u24lambda_u247 = fastLadderMode;
            boolean bl2 = false;
            $this$handleFastClimb_u24lambda_u247.handleFastClimb($this$handleFastClimb);
        }
    }

    public static final /* synthetic */ Map access$getModes$p() {
        return modes;
    }

    /*
     * WARNING - void declaration
     */
    static {
        block4: {
            void $this$mapTo$iv$iv;
            List<Class<FastLadderMode>> list;
            List<Class<FastLadderMode>> list2;
            INSTANCE = new FastLadder();
            modes = new LinkedHashMap();
            modeValue = new ListValue(){

                protected void onChanged(String oldValue, String newValue) {
                    block2: {
                        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                        Intrinsics.checkNotNullParameter(newValue, "newValue");
                        if (!FastLadder.INSTANCE.getState()) break block2;
                        FastLadderMode fastLadderMode = (FastLadderMode)FastLadder.access$getModes$p().get(oldValue);
                        if (fastLadderMode != null) {
                            fastLadderMode.onDisable();
                        }
                        FastLadderMode fastLadderMode2 = (FastLadderMode)FastLadder.access$getModes$p().get(newValue);
                        if (fastLadderMode2 != null) {
                            fastLadderMode2.onEnable();
                        }
                    }
                }
            };
            INSTANCE.getValues().add(modeValue);
            List<Class<FastLadderMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".fast_ladder", FastLadderMode.class);
            boolean bl2 = false;
            List<Class<FastLadderMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
            if (list == null) break block4;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((FastLadderMode)it2.getConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    FastLadderMode it = (FastLadderMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (FastLadderMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                Unit unit;
                void $this$forEach$iv;
                Iterable $i$f$sortedBy2 = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    FastLadderMode module = (FastLadderMode)element$iv;
                    boolean bl4 = false;
                    module.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = module.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(module.getName() + value.getName());
                        value.setSuperValue(modeValue);
                        value.setSuperValueMeta(module.getName());
                        INSTANCE.getValues().add(value);
                    }
                    modes.put(module.getName(), module);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(module);
                    EventManager.registerListener$default(eventManager, module, false, false, 6, null);
                }
                Unit it3 = unit = Unit.INSTANCE;
                boolean bl6 = false;
                Collection $this$toTypedArray$iv = modes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
    }
}

