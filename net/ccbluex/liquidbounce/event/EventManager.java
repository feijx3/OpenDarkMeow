/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventHookLegacy;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.hook.IEventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.ListenerBaseUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\fJ&\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0018\u00010\u0019H\u0007RJ\u0010\u0004\u001a>\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0005j\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/event/EventManager;", "", "<init>", "()V", "registry", "Ljava/util/HashMap;", "Lkotlin/reflect/KClass;", "", "Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "Lnet/ccbluex/liquidbounce/event/Event;", "Lkotlin/collections/HashMap;", "registerListener", "", "listener", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "noSort", "", "includeInherited", "sortListener", "unregisterListener", "owner", "unregisterAllListeners", "callEvent", "event", "excludeEventCall", "", "Ljava/lang/Class;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEventManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventManager.kt\nnet/ccbluex/liquidbounce/event/EventManager\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n382#2,7:88\n382#2,7:96\n1869#3:95\n1870#3:103\n1869#3:104\n1021#3,2:105\n1870#3:107\n1869#3,2:108\n1869#3:110\n1870#3:112\n1#4:111\n*S KotlinDebug\n*F\n+ 1 EventManager.kt\nnet/ccbluex/liquidbounce/event/EventManager\n*L\n29#1:88,7\n36#1:96,7\n35#1:95\n35#1:103\n43#1:104\n44#1:105,2\n43#1:107\n54#1:108,2\n73#1:110\n73#1:112\n*E\n"})
public final class EventManager {
    @NotNull
    private final HashMap<KClass<?>, List<IEventHook<Event>>> registry = new HashMap();

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    public final void registerListener(@NotNull ListenableOwner listener, boolean noSort, boolean includeInherited) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (listener instanceof Listenable) {
            Iterator<Method> iterator2 = ArrayIteratorKt.iterator(includeInherited ? listener.getClass().getMethods() : listener.getClass().getDeclaredMethods());
            while (iterator2.hasNext()) {
                Object object;
                void $this$getOrPut$iv;
                Method method = iterator2.next();
                if (!method.isAnnotationPresent(EventTarget.class) || method.getParameterTypes().length != 1) continue;
                method.setAccessible(true);
                Class<?> clazz = method.getParameterTypes()[0];
                Intrinsics.checkNotNullExpressionValue(clazz, "get(...)");
                KClass<?> eventClass = JvmClassMappingKt.getKotlinClass(clazz);
                EventTarget eventTarget = method.getAnnotation(EventTarget.class);
                Map map = this.registry;
                KClass<?> key$iv = eventClass;
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
                List list = (List)object;
                Listenable listenable = (Listenable)listener;
                Intrinsics.checkNotNull(method);
                Intrinsics.checkNotNull(eventTarget);
                list.add(new EventHookLegacy(listenable, method, eventTarget));
            }
        }
        Iterable $this$forEach$iv = ListenableOwnerExtends.INSTANCE.getListenableItems(listener);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object object;
            void $this$getOrPut$iv;
            IEventHook hook = (IEventHook)element$iv;
            boolean bl3 = false;
            Map $i$f$getOrPut = this.registry;
            KClass key$iv = hook.getType();
            boolean $i$f$getOrPut2 = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                boolean bl4 = false;
                List answer$iv = new ArrayList();
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            List list = (List)object;
            Intrinsics.checkNotNull(hook, "null cannot be cast to non-null type net.darkmeow.darkmeow.event.hook.IEventHook<net.ccbluex.liquidbounce.event.Event>");
            list.add(hook);
        }
        if (!noSort) {
            this.sortListener();
        }
    }

    public static /* synthetic */ void registerListener$default(EventManager eventManager, ListenableOwner listenableOwner, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        eventManager.registerListener(listenableOwner, bl2, bl3);
    }

    public final void sortListener() {
        Collection<List<IEventHook<Event>>> collection = this.registry.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            List hooks = (List)element$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(hooks);
            List $this$sortByDescending$iv = hooks;
            boolean $i$f$sortByDescending = false;
            if ($this$sortByDescending$iv.size() <= 1) continue;
            CollectionsKt.sortWith($this$sortByDescending$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    IEventHook it = (IEventHook)b2;
                    boolean bl2 = false;
                    Comparable comparable = Integer.valueOf(it.getPriority());
                    it = (IEventHook)a2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, it.getPriority());
                }
            });
        }
    }

    public final void unregisterListener(@NotNull ListenableOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Collection<List<IEventHook<Event>>> collection = this.registry.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            List hooks = (List)element$iv;
            boolean bl2 = false;
            hooks.removeIf(arg_0 -> EventManager.unregisterListener$lambda$7$lambda$6(arg_0 -> EventManager.unregisterListener$lambda$7$lambda$5(owner, arg_0), arg_0));
        }
    }

    public final void unregisterAllListeners() {
        this.registry.clear();
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    public final void callEvent(@NotNull Event event, @Nullable List<? extends Class<?>> excludeEventCall) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (DarkMeow.isDestroy) {
            return;
        }
        ListenerBase base = ListenerBaseUtils.get$default(ListenerBaseUtils.INSTANCE, null, 1, null);
        List<IEventHook<Event>> list = this.registry.get(Reflection.getOrCreateKotlinClass(event.getClass()));
        if (list != null) {
            void $this$forEach$iv;
            Iterable iterable = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                Object object2;
                IEventHook target = (IEventHook)element$iv;
                boolean bl2 = false;
                if (event.isCancelledNext()) {
                    return;
                }
                List<Class<?>> list2 = excludeEventCall;
                if (list2 != null) {
                    object2 = list2;
                    List<Class<?>> it = object2;
                    boolean bl3 = false;
                    if (it.contains(target.getOwner().getClass())) {
                        return;
                    }
                }
                object2 = this;
                try {
                    EventManager $this$callEvent_u24lambda_u2411_u24lambda_u249 = (EventManager)object2;
                    boolean bl4 = false;
                    target.invoke(base, event);
                    object = Result.constructor-impl(Unit.INSTANCE);
                }
                catch (Throwable bl4) {
                    object = Result.constructor-impl(ResultKt.createFailure(bl4));
                }
                object2 = object;
                Throwable throwable = Result.exceptionOrNull-impl(object2);
                if (throwable == null) continue;
                Object e2 = object = throwable;
                boolean bl5 = false;
                ClientUtils.logger.error("CallEvent", (Throwable)e2);
            }
        }
    }

    public static /* synthetic */ void callEvent$default(EventManager eventManager, Event event, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            list = null;
        }
        eventManager.callEvent(event, list);
    }

    @JvmOverloads
    public final void registerListener(@NotNull ListenableOwner listener, boolean noSort) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        EventManager.registerListener$default(this, listener, noSort, false, 4, null);
    }

    @JvmOverloads
    public final void registerListener(@NotNull ListenableOwner listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        EventManager.registerListener$default(this, listener, false, false, 6, null);
    }

    @JvmOverloads
    public final void callEvent(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventManager.callEvent$default(this, event, null, 2, null);
    }

    private static final boolean unregisterListener$lambda$7$lambda$5(ListenableOwner $owner, IEventHook it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getOwner(), $owner);
    }

    private static final boolean unregisterListener$lambda$7$lambda$6(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

