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
import net.darkmeow.darkmeow.event.hook.IEventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BD\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\b\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\b\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2={"Lnet/darkmeow/darkmeow/event/hook/EventHookSafe;", "Type", "Lnet/ccbluex/liquidbounce/event/Event;", "Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "priority", "", "function", "Lkotlin/Function2;", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "", "Lkotlin/ExtensionFunctionType;", "type", "Lkotlin/reflect/KClass;", "owner", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/reflect/KClass;Lnet/darkmeow/darkmeow/event/ListenableOwner;)V", "getPriority", "()I", "getFunction", "()Lkotlin/jvm/functions/Function2;", "getType", "()Lkotlin/reflect/KClass;", "getOwner", "()Lnet/darkmeow/darkmeow/event/ListenableOwner;", "invoke", "base", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "event", "(Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;Lnet/ccbluex/liquidbounce/event/Event;)V", "DarkMeow"})
public class EventHookSafe<Type extends Event>
implements IEventHook<Type> {
    private final int priority;
    @NotNull
    private final Function2<SafeListenerBase, Type, Unit> function;
    @NotNull
    private final KClass<Type> type;
    @NotNull
    private final ListenableOwner owner;

    public EventHookSafe(int priority, @NotNull Function2<? super SafeListenerBase, ? super Type, Unit> function, @NotNull KClass<Type> type, @NotNull ListenableOwner owner) {
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.priority = priority;
        this.function = function;
        this.type = type;
        this.owner = owner;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @NotNull
    public final Function2<SafeListenerBase, Type, Unit> getFunction() {
        return this.function;
    }

    @Override
    @NotNull
    public KClass<Type> getType() {
        return this.type;
    }

    @Override
    @NotNull
    public ListenableOwner getOwner() {
        return this.owner;
    }

    @Override
    public void invoke(@NotNull ListenerBase base, @NotNull Type event) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(event, "event");
        if (base instanceof SafeListenerBase) {
            this.function.invoke((SafeListenerBase)base, event);
        }
    }
}

