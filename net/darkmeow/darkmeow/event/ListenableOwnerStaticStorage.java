/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.hook.IEventHook;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\r\u001a\u00020\u0006H\u0086\u0002R+\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/event/ListenableOwnerStaticStorage;", "", "<init>", "()V", "listenable", "Ljava/util/WeakHashMap;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "", "Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "Lnet/ccbluex/liquidbounce/event/Event;", "getListenable", "()Ljava/util/WeakHashMap;", "get", "owner", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nListenableOwnerStaticStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListenableOwnerStaticStorage.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerStaticStorage\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,11:1\n382#2,7:12\n*S KotlinDebug\n*F\n+ 1 ListenableOwnerStaticStorage.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerStaticStorage\n*L\n10#1:12,7\n*E\n"})
public final class ListenableOwnerStaticStorage {
    @NotNull
    public static final ListenableOwnerStaticStorage INSTANCE = new ListenableOwnerStaticStorage();
    @NotNull
    private static final WeakHashMap<ListenableOwner, List<IEventHook<? extends Event>>> listenable = new WeakHashMap();

    private ListenableOwnerStaticStorage() {
    }

    @NotNull
    public final WeakHashMap<ListenableOwner, List<IEventHook<? extends Event>>> getListenable() {
        return listenable;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<IEventHook<? extends Event>> get(@NotNull ListenableOwner owner) {
        Object object;
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Map map = listenable;
        ListenableOwner key$iv = owner;
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
        return (List)object;
    }
}

