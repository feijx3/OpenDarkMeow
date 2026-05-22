/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class JavaTypeFlexibility
extends Enum<JavaTypeFlexibility> {
    public static final /* enum */ JavaTypeFlexibility INFLEXIBLE = new JavaTypeFlexibility();
    public static final /* enum */ JavaTypeFlexibility FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility();
    public static final /* enum */ JavaTypeFlexibility FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility();
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[])$VALUES.clone();
    }

    public static JavaTypeFlexibility valueOf(String value) {
        return Enum.valueOf(JavaTypeFlexibility.class, value);
    }

    static {
        $VALUES = javaTypeFlexibilityArray = new JavaTypeFlexibility[]{JavaTypeFlexibility.INFLEXIBLE, JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND, JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

