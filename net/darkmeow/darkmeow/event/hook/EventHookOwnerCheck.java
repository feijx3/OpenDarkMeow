/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.event.hook;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.hook.EventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BF\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\b\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/darkmeow/event/hook/EventHookOwnerCheck;", "Type", "Lnet/ccbluex/liquidbounce/event/Event;", "Lnet/darkmeow/darkmeow/event/hook/EventHook;", "priority", "", "function", "Lkotlin/Function2;", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "", "Lkotlin/ExtensionFunctionType;", "type", "Lkotlin/reflect/KClass;", "owner", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/reflect/KClass;Lnet/darkmeow/darkmeow/event/ListenableOwner;)V", "invoke", "base", "event", "(Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;Lnet/ccbluex/liquidbounce/event/Event;)V", "DarkMeow"})
public class EventHookOwnerCheck<Type extends Event>
extends EventHook<Type> {
    public EventHookOwnerCheck(int priority, @NotNull Function2<? super ListenerBase, ? super Type, Unit> function, @NotNull KClass<Type> type, @NotNull ListenableOwner owner) {
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super(priority, function, type, owner);
    }

    public /* synthetic */ EventHookOwnerCheck(int n2, Function2 function2, KClass kClass, ListenableOwner listenableOwner, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        this(n2, function2, kClass, listenableOwner);
    }

    @Override
    public void invoke(@NotNull ListenerBase base, @NotNull Type event) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.getOwner().handleEvents()) {
            return;
        }
        super.invoke(base, event);
    }
}

