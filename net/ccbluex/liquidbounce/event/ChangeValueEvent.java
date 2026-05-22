/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.Event;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "T", "Lnet/ccbluex/liquidbounce/event/Event;", "value", "<init>", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "", "isChanged", "()Z", "getReturnValue", "()Ljava/lang/Object;", "setReturnValue", "", "newValue", "markAsChanged", "DarkMeow"})
public class ChangeValueEvent<T>
extends Event {
    private T value;
    private boolean isChanged;

    public ChangeValueEvent(T value) {
        this.value = value;
    }

    public final boolean isChanged() {
        return this.isChanged;
    }

    public final T getReturnValue() {
        return this.value;
    }

    public final void setReturnValue(T newValue) {
        this.value = newValue;
        this.isChanged = true;
    }

    public final void markAsChanged() {
        this.isChanged = true;
    }
}

