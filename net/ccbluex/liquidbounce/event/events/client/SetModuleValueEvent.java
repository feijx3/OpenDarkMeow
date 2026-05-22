/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/event/events/client/SetModuleValueEvent;", "T", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "value", "Lnet/ccbluex/liquidbounce/value/Value;", "oldValue", "newValue", "eventState", "Lnet/ccbluex/liquidbounce/event/EventState;", "<init>", "(Lnet/ccbluex/liquidbounce/value/Value;Ljava/lang/Object;Ljava/lang/Object;Lnet/ccbluex/liquidbounce/event/EventState;)V", "getValue", "()Lnet/ccbluex/liquidbounce/value/Value;", "getOldValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getNewValue", "getEventState", "()Lnet/ccbluex/liquidbounce/event/EventState;", "DarkMeow"})
public final class SetModuleValueEvent<T>
extends CancellableEvent {
    @NotNull
    private final Value<?> value;
    private final T oldValue;
    private final T newValue;
    @NotNull
    private final EventState eventState;

    public SetModuleValueEvent(@NotNull Value<?> value, T oldValue, T newValue, @NotNull EventState eventState) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter((Object)eventState, "eventState");
        this.value = value;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.eventState = eventState;
    }

    @NotNull
    public final Value<?> getValue() {
        return this.value;
    }

    public final T getOldValue() {
        return this.oldValue;
    }

    public final T getNewValue() {
        return this.newValue;
    }

    @NotNull
    public final EventState getEventState() {
        return this.eventState;
    }
}

