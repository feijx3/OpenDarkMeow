/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.GuiChat
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.ccbluex.liquidbounce.event.events.tick.TickEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleManager;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.ui.IDarkGui;
import net.minecraft.client.gui.GuiChat;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/manager/ModuleKeyBindUpdateManager;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "manager", "Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/ModuleManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "lastKeyBindState", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nModuleKeyBindUpdateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleKeyBindUpdateManager.kt\nnet/ccbluex/liquidbounce/features/module/manager/ModuleKeyBindUpdateManager\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n20#2,3:45\n1#3:48\n1025#4,3:49\n1028#4,3:59\n382#5,7:52\n126#6:62\n153#6,3:63\n774#7:66\n865#7,2:67\n1869#7:69\n1869#7,2:70\n1870#7:72\n*S KotlinDebug\n*F\n+ 1 ModuleKeyBindUpdateManager.kt\nnet/ccbluex/liquidbounce/features/module/manager/ModuleKeyBindUpdateManager\n*L\n23#1:45,3\n29#1:49,3\n29#1:59,3\n29#1:52,7\n30#1:62\n30#1:63,3\n31#1:66\n31#1:67,2\n32#1:69\n33#1:70,2\n32#1:72\n*E\n"})
public final class ModuleKeyBindUpdateManager
implements ListenableOwner {
    @NotNull
    private final ModuleManager manager;
    @JvmField
    @NotNull
    public final HashMap<Integer, Boolean> lastKeyBindState;

    /*
     * WARNING - void declaration
     */
    public ModuleKeyBindUpdateManager(@NotNull ModuleManager manager) {
        void $receiver$iv;
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.lastKeyBindState = new HashMap();
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, TickEvent.Pre, Unit> function$iv = (arg_0, arg_1) -> ModuleKeyBindUpdateManager._init_$lambda$8(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<TickEvent.Pre>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(TickEvent.Pre.class), (ListenableOwner)$receiver$iv));
    }

    @NotNull
    public final ModuleManager getManager() {
        return this.manager;
    }

    private static final boolean lambda$8$lambda$2(Module it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int n2 = it.getBaseConfig().getKeyBindId();
        return 1 <= n2 ? n2 < 257 : false;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$8(ModuleKeyBindUpdateManager this$0, SafeListenerBase $this$safeListener, TickEvent.Pre it) {
        TreeSet<Module> treeSet;
        TreeSet<Module> treeSet2;
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        TreeSet<Module> it2 = treeSet2 = this$0.manager.getModules();
        boolean bl2 = false;
        TreeSet<Module> treeSet3 = treeSet = !this$0.manager.isLoadingModules ? treeSet2 : null;
        if (treeSet != null) {
            Sequence<Module> sequence;
            Object object = treeSet;
            TreeSet<Module> it3 = object;
            boolean bl3 = false;
            TreeSet<Module> treeSet4 = treeSet2 = !($this$safeListener.getMc().field_71462_r instanceof IDarkGui) && !($this$safeListener.getMc().field_71462_r instanceof GuiChat) ? object : null;
            if (treeSet2 != null && (object = CollectionsKt.asSequence((Iterable)treeSet2)) != null && (sequence = SequencesKt.filter(object, ModuleKeyBindUpdateManager::lambda$8$lambda$2)) != null) {
                void $this$forEach$iv;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Object $this$getOrPut$iv$iv;
                void $this$groupByTo$iv;
                Sequence<Module> sequence2 = sequence;
                Map destination$iv = new LinkedHashMap();
                boolean $i$f$groupByTo = false;
                for (Object element$iv : $this$groupByTo$iv) {
                    Object object2;
                    Module it4 = (Module)element$iv;
                    boolean bl4 = false;
                    Integer key$iv = it4.getBaseConfig().getKeyBindId();
                    $this$getOrPut$iv$iv = destination$iv;
                    boolean $i$f$getOrPut = false;
                    Object value$iv$iv = $this$getOrPut$iv$iv.get(key$iv);
                    if (value$iv$iv == null) {
                        boolean bl5 = false;
                        List answer$iv$iv = new ArrayList();
                        $this$getOrPut$iv$iv.put(key$iv, answer$iv$iv);
                        object2 = answer$iv$iv;
                    } else {
                        object2 = value$iv$iv;
                    }
                    List list$iv = (List)object2;
                    list$iv.add(element$iv);
                }
                boolean $i$f$map22 = false;
                Iterator iterator2 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList($this$map$iv.size());
                boolean $i$f$mapTo = false;
                Iterator bl4 = $this$mapTo$iv$iv.entrySet().iterator();
                while (bl4.hasNext()) {
                    void it5;
                    Object item$iv$iv;
                    $this$getOrPut$iv$iv = item$iv$iv = bl4.next();
                    Collection collection = destination$iv$iv;
                    boolean bl6 = false;
                    collection.add(TuplesKt.to(it5, KeyUtils.INSTANCE.isSystemKeyDown(((Number)it5.getKey()).intValue())));
                }
                Iterable $i$f$map22 = (List)destination$iv$iv;
                boolean $i$f$filter = false;
                destination$iv$iv = $this$filter$iv;
                Collection destination$iv$iv2 = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    Pair it6 = (Pair)element$iv$iv;
                    boolean bl7 = false;
                    if (!(!Intrinsics.areEqual(it6.getSecond(), this$0.lastKeyBindState.get(((Map.Entry)it6.getFirst()).getKey())))) continue;
                    destination$iv$iv2.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv2;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Pair pair = (Pair)element$iv;
                    boolean bl8 = false;
                    Map.Entry info = (Map.Entry)pair.component1();
                    boolean keyBindState = (Boolean)pair.component2();
                    Iterable $this$forEach$iv2 = (Iterable)info.getValue();
                    boolean $i$f$forEach2 = false;
                    block8: for (Object element$iv2 : $this$forEach$iv2) {
                        Module module = (Module)element$iv2;
                        boolean bl9 = false;
                        switch (WhenMappings.$EnumSwitchMapping$0[module.getBaseConfig().getKeyBindType().ordinal()]) {
                            case 1: {
                                if (!keyBindState) continue block8;
                                module.setState(!module.getState());
                                break;
                            }
                            case 2: {
                                module.setState(keyBindState);
                                break;
                            }
                            default: {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    ((Map)this$0.lastKeyBindState).put(info.getKey(), keyBindState);
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ModuleBaseConfig.KeyBindType.values().length];
            try {
                nArray[ModuleBaseConfig.KeyBindType.TOGGLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ModuleBaseConfig.KeyBindType.HOLD.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

