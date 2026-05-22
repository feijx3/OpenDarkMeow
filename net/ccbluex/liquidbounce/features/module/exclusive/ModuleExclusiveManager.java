/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.exclusive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.events.client.ClientModuleToggleEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R8\u0010\b\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/exclusive/ModuleExclusiveManager;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "manager", "Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/ModuleManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "exclusives", "Ljava/util/HashMap;", "", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "Lkotlin/collections/HashMap;", "registerExclusive", "", "group", "module", "unregisterExclusive", "clearExclusives", "", "onModuleToggle", "event", "Lnet/ccbluex/liquidbounce/event/events/client/ClientModuleToggleEvent;", "(Lnet/ccbluex/liquidbounce/event/events/client/ClientModuleToggleEvent;)Lkotlin/Unit;", "handleEvents", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nModuleExclusiveManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleExclusiveManager.kt\nnet/ccbluex/liquidbounce/features/module/exclusive/ModuleExclusiveManager\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n382#2,7:60\n1#3:67\n774#4:68\n865#4,2:69\n774#4:71\n865#4,2:72\n1869#4,2:74\n*S KotlinDebug\n*F\n+ 1 ModuleExclusiveManager.kt\nnet/ccbluex/liquidbounce/features/module/exclusive/ModuleExclusiveManager\n*L\n29#1:60,7\n53#1:68\n53#1:69,2\n55#1:71\n55#1:72,2\n56#1:74,2\n*E\n"})
public final class ModuleExclusiveManager
implements Listenable {
    @NotNull
    private final ModuleManager manager;
    @JvmField
    @NotNull
    public final HashMap<String, List<Module>> exclusives;

    public ModuleExclusiveManager(@NotNull ModuleManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.exclusives = new HashMap();
    }

    @NotNull
    public final ModuleManager getManager() {
        return this.manager;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean registerExclusive(@NotNull String group, @NotNull Module module) {
        Object object;
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(module, "module");
        Map map = this.exclusives;
        String key$iv = group;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(key$iv);
        if (value$iv == null) {
            boolean bl2 = false;
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(key$iv, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        return ((List)object).add(module);
    }

    public final boolean unregisterExclusive(@NotNull String group, @NotNull Module module) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(module, "module");
        List<Module> list = this.exclusives.get(group);
        return list != null ? list.remove(module) : false;
    }

    public final void clearExclusives() {
        this.exclusives.clear();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget
    @Nullable
    public final Unit onModuleToggle(@NotNull ClientModuleToggleEvent event) {
        void $this$forEach$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Iterable $this$filterTo$iv$iv2;
        Collection<List<Module>> collection;
        Intrinsics.checkNotNullParameter(event, "event");
        Collection<List<Module>> collection2 = collection = this.exclusives.values();
        boolean bl2 = false;
        if (!event.getState()) return null;
        Collection<List<Module>> collection3 = collection;
        Collection<List<Module>> collection4 = collection3;
        if (collection4 == null) return null;
        Iterable iterable = collection4;
        boolean $i$f$filter = false;
        Iterable iterable2 = iterable;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo22 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            List it = (List)element$iv$iv;
            boolean bl3 = false;
            if (!it.contains(event.getModule())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List list = CollectionsKt.flatten((List)destination$iv$iv);
        if (list == null) return null;
        $this$filterTo$iv$iv2 = list;
        boolean $i$f$filter2 = false;
        void $i$f$filterTo22 = $this$filter$iv;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Module it = (Module)element$iv$iv;
            boolean bl4 = false;
            if (!(!Intrinsics.areEqual(it, event.getModule()) && it.getState())) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv2;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Module it = (Module)element$iv;
            boolean bl5 = false;
            it.setState(false);
        }
        Unit unit = Unit.INSTANCE;
        return unit;
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

