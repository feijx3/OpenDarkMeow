/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/event/MotionEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "eventState", "Lnet/ccbluex/liquidbounce/event/EventState;", "<init>", "(Lnet/ccbluex/liquidbounce/event/EventState;)V", "getEventState", "()Lnet/ccbluex/liquidbounce/event/EventState;", "isPre", "", "DarkMeow"})
public final class MotionEvent
extends CancellableEvent {
    @NotNull
    private final EventState eventState;

    public MotionEvent(@NotNull EventState eventState) {
        Intrinsics.checkNotNullParameter((Object)eventState, "eventState");
        this.eventState = eventState;
    }

    @NotNull
    public final EventState getEventState() {
        return this.eventState;
    }

    public final boolean isPre() {
        return this.eventState == EventState.PRE;
    }
}

