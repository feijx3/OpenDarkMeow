/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class TypeComponentPosition
extends Enum<TypeComponentPosition> {
    public static final /* enum */ TypeComponentPosition FLEXIBLE_LOWER = new TypeComponentPosition();
    public static final /* enum */ TypeComponentPosition FLEXIBLE_UPPER = new TypeComponentPosition();
    public static final /* enum */ TypeComponentPosition INFLEXIBLE = new TypeComponentPosition();
    private static final /* synthetic */ TypeComponentPosition[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[])$VALUES.clone();
    }

    public static TypeComponentPosition valueOf(String value) {
        return Enum.valueOf(TypeComponentPosition.class, value);
    }

    static {
        $VALUES = typeComponentPositionArray = new TypeComponentPosition[]{TypeComponentPosition.FLEXIBLE_LOWER, TypeComponentPosition.FLEXIBLE_UPPER, TypeComponentPosition.INFLEXIBLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

