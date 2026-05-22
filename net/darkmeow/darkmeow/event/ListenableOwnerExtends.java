/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.event;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHook;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafe;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.hook.IEventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0004\u001a\u00020\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\b\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\u0002\b\u000eH\u0086\b\u00f8\u0001\u0000JG\u0010\u000f\u001a\u00020\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\b\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\u0002\b\u000eH\u0086\b\u00f8\u0001\u0000JG\u0010\u0010\u001a\u00020\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\b\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\u0002\b\u000eH\u0086\b\u00f8\u0001\u0000JG\u0010\u0012\u001a\u00020\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\b\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\u0002\b\u000eH\u0086\b\u00f8\u0001\u0000J\u0018\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00150\u0014*\u00020\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/event/ListenableOwnerExtends;", "", "<init>", "()V", "listener", "", "Type", "Lnet/ccbluex/liquidbounce/event/Event;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "priority", "", "function", "Lkotlin/Function2;", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "Lkotlin/ExtensionFunctionType;", "listenerAlways", "safeListener", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "safeListenerAlways", "getListenableItems", "", "Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "DarkMeow"})
public final class ListenableOwnerExtends {
    @NotNull
    public static final ListenableOwnerExtends INSTANCE = new ListenableOwnerExtends();

    private ListenableOwnerExtends() {
    }

    public final /* synthetic */ <Type extends Event> void listener(ListenableOwner $this$listener, int priority, Function2<? super ListenerBase, ? super Type, Unit> function) {
        Intrinsics.checkNotNullParameter($this$listener, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$listener = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($this$listener);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookOwnerCheck<Type>(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $this$listener));
    }

    public static /* synthetic */ void listener$default(ListenableOwnerExtends $this, ListenableOwner $receiver, int priority, Function2 function, int n2, Object object) {
        if ((n2 & 1) != 0) {
            priority = 0;
        }
        Intrinsics.checkNotNullParameter($receiver, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$listener = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($receiver);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookOwnerCheck(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $receiver));
    }

    public final /* synthetic */ <Type extends Event> void listenerAlways(ListenableOwner $this$listenerAlways, int priority, Function2<? super ListenerBase, ? super Type, Unit> function) {
        Intrinsics.checkNotNullParameter($this$listenerAlways, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$listenerAlways = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($this$listenerAlways);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHook<Type>(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $this$listenerAlways));
    }

    public static /* synthetic */ void listenerAlways$default(ListenableOwnerExtends $this, ListenableOwner $receiver, int priority, Function2 function, int n2, Object object) {
        if ((n2 & 1) != 0) {
            priority = 0;
        }
        Intrinsics.checkNotNullParameter($receiver, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$listenerAlways = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($receiver);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHook(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $receiver));
    }

    public final /* synthetic */ <Type extends Event> void safeListener(ListenableOwner $this$safeListener, int priority, Function2<? super SafeListenerBase, ? super Type, Unit> function) {
        Intrinsics.checkNotNullParameter($this$safeListener, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$safeListener = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookSafeOwnerCheck<Type>(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $this$safeListener));
    }

    public static /* synthetic */ void safeListener$default(ListenableOwnerExtends $this, ListenableOwner $receiver, int priority, Function2 function, int n2, Object object) {
        if ((n2 & 1) != 0) {
            priority = 0;
        }
        Intrinsics.checkNotNullParameter($receiver, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$safeListener = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($receiver);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookSafeOwnerCheck(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $receiver));
    }

    public final /* synthetic */ <Type extends Event> void safeListenerAlways(ListenableOwner $this$safeListenerAlways, int priority, Function2<? super SafeListenerBase, ? super Type, Unit> function) {
        Intrinsics.checkNotNullParameter($this$safeListenerAlways, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$safeListenerAlways = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($this$safeListenerAlways);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookSafe<Type>(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $this$safeListenerAlways));
    }

    public static /* synthetic */ void safeListenerAlways$default(ListenableOwnerExtends $this, ListenableOwner $receiver, int priority, Function2 function, int n2, Object object) {
        if ((n2 & 1) != 0) {
            priority = 0;
        }
        Intrinsics.checkNotNullParameter($receiver, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        boolean $i$f$safeListenerAlways = false;
        List<IEventHook<? extends Event>> list = ListenableOwnerStaticStorage.INSTANCE.get($receiver);
        Intrinsics.reifiedOperationMarker(4, "Type");
        list.add(new EventHookSafe(priority, function, Reflection.getOrCreateKotlinClass(Event.class), $receiver));
    }

    @NotNull
    public final List<IEventHook<? extends Event>> getListenableItems(@NotNull ListenableOwner $this$getListenableItems) {
        Intrinsics.checkNotNullParameter($this$getListenableItems, "<this>");
        return ListenableOwnerStaticStorage.INSTANCE.get($this$getListenableItems);
    }
}

