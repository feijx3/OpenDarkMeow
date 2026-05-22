/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/event/EventState;", "", "stateName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStateName", "()Ljava/lang/String;", "PRE", "POST", "DarkMeow"})
public final class EventState
extends Enum<EventState> {
    @NotNull
    private final String stateName;
    public static final /* enum */ EventState PRE = new EventState("PRE");
    public static final /* enum */ EventState POST = new EventState("POST");
    private static final /* synthetic */ EventState[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private EventState(String stateName) {
        this.stateName = stateName;
    }

    @NotNull
    public final String getStateName() {
        return this.stateName;
    }

    public static EventState[] values() {
        return (EventState[])$VALUES.clone();
    }

    public static EventState valueOf(String value) {
        return Enum.valueOf(EventState.class, value);
    }

    @NotNull
    public static EnumEntries<EventState> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = eventStateArray = new EventState[]{EventState.PRE, EventState.POST};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

