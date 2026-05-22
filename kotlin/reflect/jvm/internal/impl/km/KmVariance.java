/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class KmVariance
extends Enum<KmVariance> {
    public static final /* enum */ KmVariance INVARIANT = new KmVariance();
    public static final /* enum */ KmVariance IN = new KmVariance();
    public static final /* enum */ KmVariance OUT = new KmVariance();
    private static final /* synthetic */ KmVariance[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KmVariance[] values() {
        return (KmVariance[])$VALUES.clone();
    }

    public static KmVariance valueOf(String value) {
        return Enum.valueOf(KmVariance.class, value);
    }

    static {
        $VALUES = kmVarianceArray = new KmVariance[]{KmVariance.INVARIANT, KmVariance.IN, KmVariance.OUT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

