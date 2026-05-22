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
import net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.AntiCobwebMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/AntiCobweb;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/AntiCobwebMode;", "getModes", "()Ljava/util/Map;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onEnable", "", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiCobweb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiCobweb.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/AntiCobweb\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,67:1\n1#2:68\n1563#3:69\n1634#3,3:70\n1056#3:73\n1869#3:74\n1869#3,2:75\n1870#3:77\n37#4:78\n36#4,3:79\n*S KotlinDebug\n*F\n+ 1 AntiCobweb.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/AntiCobweb\n*L\n30#1:69\n30#1:70,3\n31#1:73\n32#1:74\n35#1:75,2\n32#1:77\n51#1:78\n51#1:79,3\n*E\n"})
public final class AntiCobweb
extends Module {
    @NotNull
    private final Map<String, AntiCobwebMode> modes;
    @JvmField
    @NotNull
    public final ListValue modeValue;

    /*
     * WARNING - void declaration
     */
    public AntiCobweb() {
        block5: {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            List<Class<AntiCobwebMode>> list;
            List<Class<AntiCobwebMode>> list2;
            super("AntiCobweb", ModuleCategory.MOVEMENT, null, null, 12, null);
            this.modes = new LinkedHashMap();
            this.modeValue = new ListValue(this){
                final /* synthetic */ AntiCobweb this$0;
                {
                    this.this$0 = $receiver;
                    super("Mode", null, null, 6, null);
                }

                protected void onChanged(String oldValue, String newValue) {
                    block2: {
                        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                        Intrinsics.checkNotNullParameter(newValue, "newValue");
                        if (!this.this$0.getState()) break block2;
                        AntiCobwebMode antiCobwebMode = this.this$0.getModes().get(oldValue);
                        if (antiCobwebMode != null) {
                            antiCobwebMode.onDisable();
                        }
                        AntiCobwebMode antiCobwebMode2 = this.this$0.getModes().get(newValue);
                        if (antiCobwebMode2 != null) {
                            antiCobwebMode2.onEnable();
                        }
                    }
                }
            };
            List<Class<AntiCobwebMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".anti_cobweb", AntiCobwebMode.class);
            boolean bl2 = false;
            this.getValues().add(this.modeValue);
            it = list2;
            boolean bl3 = false;
            List<Class<AntiCobwebMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
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
                collection.add((AntiCobwebMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AntiCobwebMode it = (AntiCobwebMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (AntiCobwebMode)b2;
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
                    AntiCobwebMode it3 = (AntiCobwebMode)element$iv;
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

    @NotNull
    public final Map<String, AntiCobwebMode> getModes() {
        return this.modes;
    }

    @Override
    public void onEnable() {
        block0: {
            AntiCobwebMode antiCobwebMode = this.modes.get(this.modeValue.get());
            if (antiCobwebMode == null) break block0;
            antiCobwebMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            AntiCobwebMode antiCobwebMode = this.modes.get(this.modeValue.get());
            if (antiCobwebMode == null) break block0;
            antiCobwebMode.onDisable();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)this.modeValue.get();
    }
}

