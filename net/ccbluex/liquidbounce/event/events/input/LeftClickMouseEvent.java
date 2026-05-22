/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 */
package net.ccbluex.liquidbounce.event.events.input;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.ccbluex.liquidbounce.event.CancellableEvent;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/input/LeftClickMouseEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "clickCounter", "", "<init>", "(I)V", "DarkMeow"})
public final class LeftClickMouseEvent
extends CancellableEvent {
    @JvmField
    public int clickCounter;

    public LeftClickMouseEvent(int clickCounter) {
        this.clickCounter = clickCounter;
    }
}

