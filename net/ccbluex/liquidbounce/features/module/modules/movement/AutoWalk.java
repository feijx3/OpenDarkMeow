/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
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
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.movement.auto_walk.AutoWalkMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/AutoWalk;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/auto_walk/AutoWalkMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoWalk.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/AutoWalk\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,49:1\n1#2:50\n1563#3:51\n1634#3,3:52\n1056#3:55\n1869#3:56\n1869#3,2:57\n1870#3:59\n37#4:60\n36#4,3:61\n*S KotlinDebug\n*F\n+ 1 AutoWalk.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/AutoWalk\n*L\n24#1:51\n24#1:52,3\n25#1:55\n26#1:56\n29#1:57,2\n26#1:59\n45#1:60\n45#1:61,3\n*E\n"})
public final class AutoWalk
extends Module {
    @NotNull
    private final Map<String, AutoWalkMode> modes;
    @JvmField
    @NotNull
    public final ListValue modeValue;

    /*
     * WARNING - void declaration
     */
    public AutoWalk() {
        block5: {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            List<Class<AutoWalkMode>> list;
            List<Class<AutoWalkMode>> list2;
            super("AutoWalk", ModuleCategory.MOVEMENT, null, null, 12, null);
            this.modes = new LinkedHashMap();
            this.modeValue = new ListValue("Mode", null, null, 6, null);
            List<Class<AutoWalkMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".auto_walk.impl", AutoWalkMode.class);
            boolean bl2 = false;
            this.getValues().add(this.modeValue);
            it = list2;
            boolean bl3 = false;
            List<Class<AutoWalkMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
            if (list == null) break block5;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add((AutoWalkMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AutoWalkMode it = (AutoWalkMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (AutoWalkMode)b2;
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
                    AutoWalkMode it3 = (AutoWalkMode)element$iv;
                    boolean bl5 = false;
                    it3.setInstance(this);
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
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
                Unit it4 = unit = Unit.INSTANCE;
                boolean bl7 = false;
                Collection $this$toTypedArray$iv = this.modes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
    }
}

