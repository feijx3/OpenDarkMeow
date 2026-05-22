/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class MutabilityQualifier
extends Enum<MutabilityQualifier> {
    public static final /* enum */ MutabilityQualifier READ_ONLY = new MutabilityQualifier();
    public static final /* enum */ MutabilityQualifier MUTABLE = new MutabilityQualifier();
    private static final /* synthetic */ MutabilityQualifier[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[])$VALUES.clone();
    }

    public static MutabilityQualifier valueOf(String value) {
        return Enum.valueOf(MutabilityQualifier.class, value);
    }

    static {
        $VALUES = mutabilityQualifierArray = new MutabilityQualifier[]{MutabilityQualifier.READ_ONLY, MutabilityQualifier.MUTABLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

