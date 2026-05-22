/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
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
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowMode;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoSlow", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016Rd\u0010\u0004\u001aV\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t0\u0005j*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t`\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "onEnable", "", "onDisable", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlow.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,86:1\n216#2,2:87\n216#2,2:89\n216#2:112\n217#2:115\n1#3:91\n1563#4:92\n1634#4,3:93\n1056#4:96\n1869#4:97\n774#4:98\n865#4,2:99\n1563#4:101\n1634#4,3:102\n1056#4:105\n1869#4,2:106\n1869#4,2:113\n1870#4:116\n37#5:108\n36#5,3:109\n*S KotlinDebug\n*F\n+ 1 NoSlow.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow\n*L\n81#1:87,2\n82#1:89,2\n67#1:112\n67#1:115\n26#1:92\n26#1:93,3\n27#1:96\n28#1:97\n33#1:98\n33#1:99,2\n34#1:101\n34#1:102,3\n35#1:105\n36#1:106,2\n68#1:113,2\n28#1:116\n50#1:108\n50#1:109,3\n*E\n"})
public final class NoSlow
extends Module {
    @NotNull
    public static final NoSlow INSTANCE;
    @JvmField
    @NotNull
    public static final LinkedHashMap<NoSlowMode, LinkedHashMap<String, NoSlowSubMode>> modes;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @NotNull
    private static final List<Value<?>> values;

    private NoSlow() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        Map $this$forEach$iv = modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            NoSlowMode mode = (NoSlowMode)entry.getKey();
            mode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        Map $this$forEach$iv = modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            NoSlowMode mode = (NoSlowMode)entry.getKey();
            mode.onDisable();
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    /*
     * WARNING - void declaration
     */
    static {
        List<Class<NoSlowMode>> list;
        List<Class<NoSlowMode>> list2;
        INSTANCE = new NoSlow();
        modes = new LinkedHashMap();
        settingsModuleValues = new ArrayList();
        List<Class<NoSlowMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".noslows.category", NoSlowMode.class);
        boolean bl2 = false;
        List<Class<NoSlowMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            Object it2;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((NoSlowMode)ClassUtils.INSTANCE.getObjectInstance(it2));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    NoSlowMode it = (NoSlowMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeCategory());
                    it = (NoSlowMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeCategory()));
                }
            });
            if (list4 != null) {
                Iterable $this$forEach$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    void $this$toTypedArray$iv;
                    Collection<Object> $this$map$iv22;
                    String[] $this$filter$iv;
                    List<Class<NoSlowSubMode>> list5;
                    NoSlowMode mode = (NoSlowMode)element$iv;
                    boolean bl4 = false;
                    EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), mode, false, true, 2, null);
                    StringBuilder stringBuilder = new StringBuilder().append(INSTANCE.getClass().getPackage().getName()).append(".noslows.modules.");
                    String string = mode.getModeCategory().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                    it2 = ClassUtils.INSTANCE.resolvePackage(stringBuilder.append(string).toString(), NoSlowSubMode.class);
                    Iterable<Class<NoSlowSubMode>> it3 = it2;
                    boolean bl5 = false;
                    List<Class<NoSlowSubMode>> list6 = list5 = !((Collection)it3).isEmpty() ? it2 : null;
                    if (list5 != null) {
                        Iterable $this$sortedBy$iv2;
                        void $this$mapTo$iv$iv2;
                        List $this$map$iv22;
                        Object element$iv$iv2;
                        void $this$filterTo$iv$iv;
                        it3 = list5;
                        boolean $i$f$filter22 = false;
                        void var13_21 = $this$filter$iv;
                        Collection destination$iv$iv2 = new ArrayList();
                        boolean $i$f$filterTo = false;
                        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
                            Class it4 = (Class)element$iv$iv2;
                            boolean bl6 = false;
                            if (!(!Modifier.isAbstract(it4.getModifiers()))) continue;
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        Iterable $i$f$filter22 = (List)destination$iv$iv2;
                        boolean $i$f$map22 = false;
                        destination$iv$iv2 = $this$map$iv22;
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
                        boolean $i$f$mapTo2 = false;
                        element$iv$iv2 = $this$mapTo$iv$iv2.iterator();
                        while (element$iv$iv2.hasNext()) {
                            void it5;
                            Object item$iv$iv = element$iv$iv2.next();
                            Class bl6 = (Class)item$iv$iv;
                            Collection collection = destination$iv$iv3;
                            boolean bl7 = false;
                            collection.add((NoSlowSubMode)it5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                        Iterable $i$f$map22 = (List)destination$iv$iv3;
                        boolean $i$f$sortedBy2 = false;
                        $this$map$iv22 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator(){

                            public final int compare(T a2, T b2) {
                                NoSlowSubMode it = (NoSlowSubMode)a2;
                                boolean bl2 = false;
                                Comparable comparable = (Comparable)((Object)it.getModeName());
                                it = (NoSlowSubMode)b2;
                                Comparable comparable2 = comparable;
                                bl2 = false;
                                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                            }
                        });
                        if ($this$map$iv22 != null) {
                            void $this$forEach$iv2;
                            $this$sortedBy$iv2 = $this$map$iv22;
                            boolean $i$f$forEach2 = false;
                            for (Object element$iv2 : $this$forEach$iv2) {
                                NoSlowSubMode subMode = (NoSlowSubMode)element$iv2;
                                boolean bl8 = false;
                                subMode.setInstance(mode);
                                EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                                Intrinsics.checkNotNull(subMode);
                                EventManager.registerListener$default(eventManager, subMode, false, true, 2, null);
                                ((Map)mode.getSubModes()).put(subMode.getModeName(), subMode);
                            }
                        }
                    }
                    it2 = mode.getModeCategory();
                    Set<String> set = mode.getSubModes().keySet();
                    Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
                    List it6 = $this$map$iv22 = CollectionsKt.toMutableList((Collection)set);
                    boolean bl9 = false;
                    it6.add("None");
                    $this$map$iv22 = $this$map$iv22;
                    boolean $i$f$toTypedArray = false;
                    void thisCollection$iv = $this$toTypedArray$iv;
                    $this$filter$iv = thisCollection$iv.toArray(new String[0]);
                    ListValue modeValue2 = new ListValue(mode, (String)it2, $this$filter$iv){
                        final /* synthetic */ NoSlowMode $mode;
                        {
                            this.$mode = $mode;
                            super($super_call_param$1, $super_call_param$2, "None");
                        }

                        protected void onChanged(String oldValue, String newValue) {
                            block2: {
                                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                                Intrinsics.checkNotNullParameter(newValue, "newValue");
                                if (!NoSlow.INSTANCE.getState()) break block2;
                                NoSlowSubMode noSlowSubMode = this.$mode.getSubModes().get(oldValue);
                                if (noSlowSubMode != null) {
                                    noSlowSubMode.onDisable();
                                }
                                NoSlowSubMode noSlowSubMode2 = this.$mode.getSubModes().get(newValue);
                                if (noSlowSubMode2 != null) {
                                    noSlowSubMode2.onEnable();
                                }
                            }
                        }
                    };
                    mode.setInstance(INSTANCE);
                    mode.setModeValue(modeValue2);
                    settingsModuleValues.add(modeValue2);
                    Map $this$forEach$iv3 = mode.getSubModes();
                    boolean $i$f$forEach3 = false;
                    Iterator iterator2 = $this$forEach$iv3.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        Map.Entry element$iv3;
                        Map.Entry entry = element$iv3 = iterator2.next();
                        boolean bl10 = false;
                        NoSlowSubMode subMode = (NoSlowSubMode)entry.getValue();
                        Iterable $this$forEach$iv4 = subMode.getValues();
                        boolean $i$f$forEach4 = false;
                        for (Object element$iv4 : $this$forEach$iv4) {
                            Value value = (Value)element$iv4;
                            boolean bl11 = false;
                            value.setName(mode.getModeCategory() + subMode.getModeName() + value.getName());
                            value.setSuperValue(modeValue2);
                            value.setSuperValueMeta(subMode.getModeName());
                            settingsModuleValues.add(value);
                        }
                    }
                    ((Map)modes).put(mode, mode.getSubModes());
                }
            }
        }
        values = settingsModuleValues;
    }
}

