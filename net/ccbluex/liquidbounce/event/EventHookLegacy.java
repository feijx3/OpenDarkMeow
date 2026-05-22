/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event;

import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.darkmeow.darkmeow.event.hook.IEventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="\u8bf7\u66f4\u65b0")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0019X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/event/EventHookLegacy;", "Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "Lnet/ccbluex/liquidbounce/event/Event;", "eventClass", "Lnet/ccbluex/liquidbounce/event/Listenable;", "method", "Ljava/lang/reflect/Method;", "eventTarget", "Lnet/ccbluex/liquidbounce/event/EventTarget;", "<init>", "(Lnet/ccbluex/liquidbounce/event/Listenable;Ljava/lang/reflect/Method;Lnet/ccbluex/liquidbounce/event/EventTarget;)V", "getEventClass", "()Lnet/ccbluex/liquidbounce/event/Listenable;", "getMethod", "()Ljava/lang/reflect/Method;", "isIgnoreCondition", "", "()Z", "ignoreCanceled", "getIgnoreCanceled", "priority", "", "getPriority", "()I", "type", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "owner", "getOwner", "invoke", "", "base", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "event", "DarkMeow"})
public final class EventHookLegacy
implements IEventHook<Event> {
    @NotNull
    private final Listenable eventClass;
    @NotNull
    private final Method method;
    private final boolean isIgnoreCondition;
    private final boolean ignoreCanceled;
    private final int priority;
    @NotNull
    private final KClass<? extends Event> type;
    @NotNull
    private final Listenable owner;

    public EventHookLegacy(@NotNull Listenable eventClass, @NotNull Method method, @NotNull EventTarget eventTarget) {
        Intrinsics.checkNotNullParameter(eventClass, "eventClass");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(eventTarget, "eventTarget");
        this.eventClass = eventClass;
        this.method = method;
        this.isIgnoreCondition = eventTarget.ignoreCondition();
        this.ignoreCanceled = eventTarget.ignoreCanceled();
        this.priority = eventTarget.priority();
        Class<?> clazz = this.method.getParameterTypes()[0];
        Intrinsics.checkNotNullExpressionValue(clazz, "get(...)");
        KClass<?> kClass = JvmClassMappingKt.getKotlinClass(clazz);
        Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out net.ccbluex.liquidbounce.event.Event>");
        this.type = kClass;
        this.owner = this.eventClass;
    }

    @NotNull
    public final Listenable getEventClass() {
        return this.eventClass;
    }

    @NotNull
    public final Method getMethod() {
        return this.method;
    }

    public final boolean isIgnoreCondition() {
        return this.isIgnoreCondition;
    }

    public final boolean getIgnoreCanceled() {
        return this.ignoreCanceled;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    @NotNull
    public KClass<? extends Event> getType() {
        return this.type;
    }

    @Override
    @NotNull
    public Listenable getOwner() {
        return this.owner;
    }

    @Override
    public void invoke(@NotNull ListenerBase base, @NotNull Event event) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isIgnoreCondition && !this.eventClass.handleEvents()) {
            return;
        }
        if (this.ignoreCanceled && event instanceof CancellableEvent && ((CancellableEvent)event).isCancelled()) {
            return;
        }
        Object[] objectArray = new Object[]{event};
        this.method.invoke(this.eventClass, objectArray);
    }
}

