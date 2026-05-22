/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.Event;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "<init>", "()V", "value", "", "isCancelled", "()Z", "cancelEvent", "", "cancelEventAndNext", "DarkMeow"})
public class CancellableEvent
extends Event {
    private boolean isCancelled;

    public final boolean isCancelled() {
        return this.isCancelled;
    }

    public final void cancelEvent() {
        this.isCancelled = true;
    }

    public final void cancelEventAndNext() {
        this.isCancelled = true;
        this.cancelNext();
    }
}

