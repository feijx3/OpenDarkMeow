/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import net.ccbluex.liquidbounce.features.module.modules.misc.staffdetects.StaffDetectMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="StaffDetect", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/StaffDetect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/StaffDetectMode;", "Lkotlin/collections/LinkedHashMap;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "debugValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "debug", "", "message", "onDetectedStaff", "name", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStaffDetect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaffDetect.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/StaffDetect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,67:1\n1#2:68\n1563#3:69\n1634#3,3:70\n1056#3:73\n1869#3:74\n1869#3,2:75\n1870#3:77\n37#4:78\n36#4,3:79\n*S KotlinDebug\n*F\n+ 1 StaffDetect.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/StaffDetect\n*L\n34#1:69\n34#1:70,3\n35#1:73\n36#1:74\n38#1:75,2\n36#1:77\n53#1:78\n53#1:79,3\n*E\n"})
public final class StaffDetect
extends Module {
    @NotNull
    private final LinkedHashMap<String, StaffDetectMode> modes;
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final BoolValue debugValue;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public StaffDetect() {
        Unit unit;
        List<Class<StaffDetectMode>> list;
        block6: {
            Unit unit2;
            Iterator $i$f$mapTo22;
            block5: {
                block4: {
                    void $this$forEach$iv;
                    void $this$sortedBy$iv;
                    void $this$mapTo$iv$iv;
                    List<Class<StaffDetectMode>> list2;
                    super(null, null, null, null, 15, null);
                    this.modes = new LinkedHashMap();
                    this.modeValue = new ListValue(this){
                        final /* synthetic */ StaffDetect this$0;
                        {
                            this.this$0 = $receiver;
                            super("Mode", null, "Hyt", 2, null);
                        }

                        protected void onChanged(String oldValue, String newValue) {
                            block2: {
                                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                                Intrinsics.checkNotNullParameter(newValue, "newValue");
                                if (!this.this$0.getState()) break block2;
                                StaffDetectMode staffDetectMode = (StaffDetectMode)StaffDetect.access$getModes$p(this.this$0).get(oldValue);
                                if (staffDetectMode != null) {
                                    staffDetectMode.onDisable();
                                }
                                StaffDetectMode staffDetectMode2 = (StaffDetectMode)StaffDetect.access$getModes$p(this.this$0).get(newValue);
                                if (staffDetectMode2 != null) {
                                    staffDetectMode2.onEnable();
                                }
                            }
                        }
                    };
                    this.debugValue = new BoolValue("Debug", false);
                    List<Class<StaffDetectMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".staffdetects", StaffDetectMode.class);
                    boolean bl2 = false;
                    this.getValues().add(this.modeValue);
                    it = list2;
                    boolean bl3 = false;
                    List<Class<StaffDetectMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
                    if (list == null) break block4;
                    List $this$map$iv = list;
                    boolean $i$f$map22 = false;
                    List list4 = $this$map$iv;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    boolean $i$f$mapTo22 = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it2;
                        Class clazz = (Class)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        boolean bl4 = false;
                        collection.add((StaffDetectMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Iterable $i$f$map22 = (List)destination$iv$iv;
                    boolean $i$f$sortedBy22 = false;
                    $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                        public final int compare(T a2, T b2) {
                            StaffDetectMode it = (StaffDetectMode)a2;
                            boolean bl2 = false;
                            Comparable comparable = (Comparable)((Object)it.getName());
                            it = (StaffDetectMode)b2;
                            Comparable comparable2 = comparable;
                            bl2 = false;
                            return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                        }
                    });
                    if ($this$map$iv == null) break block4;
                    Iterable $i$f$sortedBy22 = $this$map$iv;
                    boolean $i$f$forEach = false;
                    $i$f$mapTo22 = $this$forEach$iv.iterator();
                    break block5;
                }
                unit = null;
                break block6;
            }
            while ($i$f$mapTo22.hasNext()) {
                Object element$iv = $i$f$mapTo22.next();
                StaffDetectMode it = (StaffDetectMode)element$iv;
                boolean bl5 = false;
                it.setInstance(this);
                Iterable $this$forEach$iv = it.getValues();
                boolean $i$f$forEach = false;
                for (Object element$iv2 : $this$forEach$iv) {
                    Value value = (Value)element$iv2;
                    boolean bl6 = false;
                    value.setName(it.getName() + value.getName());
                    if (value.getSuperValue() == null) {
                        value.setSuperValue(this.modeValue);
                        value.setSuperValueMeta(it.getName());
                    }
                    this.getValues().add(value);
                }
                ((Map)this.modes).put(it.getName(), it);
                EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                Intrinsics.checkNotNull(it);
                EventManager.registerListener$default(eventManager, it, false, false, 6, null);
            }
            Unit it = unit2 = Unit.INSTANCE;
            boolean bl7 = false;
            Set<String> set = this.modes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            unit = Unit.INSTANCE;
        }
        List<Class<StaffDetectMode>> it = list = unit;
        boolean bl8 = false;
        this.getValues().add(this.debugValue);
    }

    public final void debug(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (((Boolean)this.debugValue.get()).booleanValue()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo(message);
        }
    }

    public final void onDetectedStaff(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u68c0\u6d4b\u5230\u5728\u7ebf\u7ba1\u7406\u5458: " + name);
    }

    public static final /* synthetic */ LinkedHashMap access$getModes$p(StaffDetect $this) {
        return $this.modes;
    }
}

