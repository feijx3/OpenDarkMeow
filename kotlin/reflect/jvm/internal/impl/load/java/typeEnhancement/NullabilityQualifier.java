/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class NullabilityQualifier
extends Enum<NullabilityQualifier> {
    public static final /* enum */ NullabilityQualifier FORCE_FLEXIBILITY = new NullabilityQualifier();
    public static final /* enum */ NullabilityQualifier NULLABLE = new NullabilityQualifier();
    public static final /* enum */ NullabilityQualifier NOT_NULL = new NullabilityQualifier();
    private static final /* synthetic */ NullabilityQualifier[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[])$VALUES.clone();
    }

    public static NullabilityQualifier valueOf(String value) {
        return Enum.valueOf(NullabilityQualifier.class, value);
    }

    static {
        $VALUES = nullabilityQualifierArray = new NullabilityQualifier[]{NullabilityQualifier.FORCE_FLEXIBILITY, NullabilityQualifier.NULLABLE, NullabilityQualifier.NOT_NULL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

