/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.render.camera_tweaks.CameraTweaksMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/CameraTweaks;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/camera_tweaks/CameraTweaksMode;", "onWorld", "", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onEnable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCameraTweaks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/CameraTweaks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1#2:57\n1563#3:58\n1634#3,3:59\n1056#3:62\n1869#3:63\n1869#3,2:64\n1870#3:66\n774#3:67\n865#3,2:68\n1869#3,2:70\n*S KotlinDebug\n*F\n+ 1 CameraTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/CameraTweaks\n*L\n21#1:58\n21#1:59,3\n22#1:62\n23#1:63\n34#1:64,2\n23#1:66\n53#1:67\n53#1:68,2\n54#1:70,2\n*E\n"})
public final class CameraTweaks
extends Module {
    @NotNull
    private final Map<String, CameraTweaksMode> modes = new LinkedHashMap();

    /*
     * WARNING - void declaration
     */
    public CameraTweaks() {
        super("CameraTweaks", ModuleCategory.RENDER, null, null, 12, null);
        List<Class<CameraTweaksMode>> list;
        List<Class<CameraTweaksMode>> list2;
        List<Class<CameraTweaksMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".camera_tweaks", CameraTweaksMode.class);
        boolean bl2 = false;
        List<Class<CameraTweaksMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            Iterable $this$sortedBy$iv;
            String it2;
            boolean bl3;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                bl3 = false;
                collection.add((CameraTweaksMode)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    CameraTweaksMode it = (CameraTweaksMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (CameraTweaksMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    CameraTweaksMode it3 = (CameraTweaksMode)element$iv;
                    boolean bl4 = false;
                    it2 = it3.getName();
                    bl3 = it3.getDefaultState();
                    BoolValue modulesValue2 = new BoolValue(this, it3, it2, bl3){
                        final /* synthetic */ CameraTweaks this$0;
                        final /* synthetic */ CameraTweaksMode $it;
                        {
                            this.this$0 = $receiver;
                            this.$it = $it;
                            super($super_call_param$1, $super_call_param$2);
                        }

                        protected void onChange(boolean oldValue, boolean newValue) {
                            if (this.this$0.getState() && newValue) {
                                this.$it.onReload();
                            }
                        }
                    };
                    it3.setInstance(this);
                    it3.setLinkedStatValue(modulesValue2);
                    this.getValues().add(modulesValue2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(it3.getName() + value.getName());
                        value.setSuperValue(modulesValue2);
                        this.getValues().add(value);
                    }
                    this.modes.put(it3.getName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
            }
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.onEnable();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            CameraTweaksMode it = (CameraTweaksMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CameraTweaksMode it = (CameraTweaksMode)element$iv;
            boolean bl3 = false;
            it.onReload();
        }
    }
}

