/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import net.ccbluex.liquidbounce.features.module.modules.combat.Velocity;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "debugValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getVelocityTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "velocityInput", "", "getVelocityInput", "()Z", "setVelocityInput", "(Z)V", "onEnable", "", "onDisable", "debug", "message", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Velocity.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n774#2:75\n865#2,2:76\n1869#2,2:78\n774#2:80\n865#2,2:81\n1869#2,2:83\n1563#2:86\n1634#2,3:87\n1056#2:90\n1869#2:91\n1869#2,2:92\n1870#2:94\n1#3:85\n*S KotlinDebug\n*F\n+ 1 Velocity.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity\n*L\n59#1:75\n59#1:76,2\n60#1:78,2\n65#1:80\n65#1:81,2\n66#1:83,2\n24#1:86\n24#1:87,3\n25#1:90\n26#1:91\n43#1:92,2\n26#1:94\n*E\n"})
public final class Velocity
extends Module {
    @NotNull
    public static final Velocity INSTANCE;
    @NotNull
    private static final Map<String, VelocityMode> modes;
    @JvmField
    @NotNull
    public static final BoolValue debugValue;
    @NotNull
    private static final MSTimer velocityTimer;
    private static boolean velocityInput;

    private Velocity() {
        super("Velocity", ModuleCategory.COMBAT, null, null, 12, null);
    }

    @NotNull
    public final MSTimer getVelocityTimer() {
        return velocityTimer;
    }

    public final boolean getVelocityInput() {
        return velocityInput;
    }

    public final void setVelocityInput(boolean bl2) {
        velocityInput = bl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            VelocityMode it = (VelocityMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VelocityMode it = (VelocityMode)element$iv;
            boolean bl3 = false;
            it.onEnable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            VelocityMode it = (VelocityMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VelocityMode it = (VelocityMode)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }

    public final boolean debug(@NotNull String message) {
        boolean bl2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(message, "message");
        String it = string2 = message;
        boolean bl3 = false;
        String string3 = string = (Boolean)debugValue.get() != false ? string2 : null;
        if (string != null) {
            String string4;
            String it2 = string4 = string;
            boolean bl4 = false;
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo(message);
            String it3 = string4;
            boolean bl5 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(4.modulesMode.1 $modulesMode) {
        return (Boolean)$modulesMode.get();
    }

    /*
     * WARNING - void declaration
     */
    static {
        List<Class<VelocityMode>> list;
        List<Class<VelocityMode>> list2;
        INSTANCE = new Velocity();
        modes = new LinkedHashMap();
        debugValue = new BoolValue("Debug", false);
        List<Class<VelocityMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".velocitys", VelocityMode.class);
        boolean bl2 = false;
        List<Class<VelocityMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            String it2;
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
                collection.add((VelocityMode)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    VelocityMode it = (VelocityMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (VelocityMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                Iterable $this$forEach$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    VelocityMode it3 = (VelocityMode)element$iv;
                    boolean bl4 = false;
                    it2 = it3.getName();
                    BoolValue modulesMode2 = new BoolValue(it3, it2){
                        final /* synthetic */ VelocityMode $it;
                        {
                            this.$it = $it;
                            super($super_call_param$1, false);
                        }

                        protected void onChange(boolean oldValue, boolean newValue) {
                            if (Velocity.INSTANCE.getState()) {
                                if (newValue && !oldValue) {
                                    this.$it.onEnable();
                                } else if (!newValue && oldValue) {
                                    this.$it.onDisable();
                                }
                            }
                        }
                    };
                    it3.setInstance(INSTANCE);
                    it3.setLinkedStatValue(modulesMode2);
                    INSTANCE.getValues().add(modulesMode2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        INSTANCE.getValues().add(value.displayable(() -> Velocity.lambda$5$lambda$4$lambda$3(modulesMode2)));
                    }
                    modes.put(it3.getName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
            }
        }
        INSTANCE.getValues().add(debugValue);
        velocityTimer = new MSTimer();
    }
}

