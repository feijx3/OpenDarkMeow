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
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Speed", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Speed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "values", "getValues", "()Ljava/util/List;", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSpeed.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Speed.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Speed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,61:1\n1#2:62\n1563#3:63\n1634#3,3:64\n1056#3:67\n1869#3:68\n1869#3,2:69\n1870#3:71\n37#4:72\n36#4,3:73\n*S KotlinDebug\n*F\n+ 1 Speed.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Speed\n*L\n31#1:63\n31#1:64,3\n32#1:67\n33#1:68\n36#1:69,2\n33#1:71\n52#1:72\n52#1:73,3\n*E\n"})
public final class Speed
extends Module {
    @NotNull
    public static final Speed INSTANCE;
    @NotNull
    private static final Map<String, SpeedMode> modes;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @JvmField
    @NotNull
    public static final ListValue modeValue;
    @NotNull
    private static final List<Value<?>> values;

    private Speed() {
        super(null, null, null, null, 15, null);
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)modeValue.get();
    }

    public static final /* synthetic */ Map access$getModes$p() {
        return modes;
    }

    /*
     * WARNING - void declaration
     */
    static {
        List<Class<SpeedMode>> list;
        List<Class<SpeedMode>> list2;
        INSTANCE = new Speed();
        modes = new LinkedHashMap();
        settingsModuleValues = new ArrayList();
        modeValue = new ListValue(){

            protected void onChanged(String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                SpeedMode speedMode = (SpeedMode)Speed.access$getModes$p().get(oldValue);
                if (speedMode != null) {
                    speedMode.onDisable();
                }
                SpeedMode speedMode2 = (SpeedMode)Speed.access$getModes$p().get(newValue);
                if (speedMode2 != null) {
                    speedMode2.onEnable();
                }
                super.onChanged(oldValue, newValue);
            }
        };
        settingsModuleValues.add(modeValue);
        List<Class<SpeedMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".speeds", SpeedMode.class);
        boolean bl2 = false;
        List<Class<SpeedMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$mapTo$iv$iv;
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
                collection.add((SpeedMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    SpeedMode it = (SpeedMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (SpeedMode)b2;
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
                    SpeedMode it3 = (SpeedMode)element$iv;
                    boolean bl4 = false;
                    it3.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modeValue);
                            value.setSuperValueMeta(it3.getName());
                        }
                        settingsModuleValues.add(value);
                    }
                    modes.put(it3.getName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
                Unit it4 = unit = Unit.INSTANCE;
                boolean bl6 = false;
                Collection $this$toTypedArray$iv = modes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
        values = settingsModuleValues;
    }
}

