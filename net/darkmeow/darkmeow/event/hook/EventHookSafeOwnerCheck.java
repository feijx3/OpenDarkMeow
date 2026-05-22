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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.hook.EventHookSafe;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BD\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\b\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/event/hook/EventHookSafeOwnerCheck;", "Type", "Lnet/ccbluex/liquidbounce/event/Event;", "Lnet/darkmeow/darkmeow/event/hook/EventHookSafe;", "priority", "", "function", "Lkotlin/Function2;", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "", "Lkotlin/ExtensionFunctionType;", "type", "Lkotlin/reflect/KClass;", "owner", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/reflect/KClass;Lnet/darkmeow/darkmeow/event/ListenableOwner;)V", "invoke", "base", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "event", "(Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;Lnet/ccbluex/liquidbounce/event/Event;)V", "DarkMeow"})
public class EventHookSafeOwnerCheck<Type extends Event>
extends EventHookSafe<Type> {
    public EventHookSafeOwnerCheck(int priority, @NotNull Function2<? super SafeListenerBase, ? super Type, Unit> function, @NotNull KClass<Type> type, @NotNull ListenableOwner owner) {
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super(priority, function, type, owner);
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

