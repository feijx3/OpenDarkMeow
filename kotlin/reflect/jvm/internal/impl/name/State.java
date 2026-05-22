/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

final class State
extends Enum<State> {
    public static final /* enum */ State BEGINNING = new State();
    public static final /* enum */ State MIDDLE = new State();
    public static final /* enum */ State AFTER_DOT = new State();
    private static final /* synthetic */ State[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static State[] values() {
        return (State[])$VALUES.clone();
    }

    public static State valueOf(String value) {
        return Enum.valueOf(State.class, value);
    }

    static {
        $VALUES = stateArray = new State[]{State.BEGINNING, State.MIDDLE, State.AFTER_DOT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

