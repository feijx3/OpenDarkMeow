/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.contracts.ExperimentalContracts
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.contracts.ExperimentalContracts;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@ExperimentalContracts
public final class KmEffectType
extends Enum<KmEffectType> {
    public static final /* enum */ KmEffectType RETURNS_CONSTANT = new KmEffectType();
    public static final /* enum */ KmEffectType CALLS = new KmEffectType();
    public static final /* enum */ KmEffectType RETURNS_NOT_NULL = new KmEffectType();
    private static final /* synthetic */ KmEffectType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KmEffectType[] values() {
        return (KmEffectType[])$VALUES.clone();
    }

    public static KmEffectType valueOf(String value) {
        return Enum.valueOf(KmEffectType.class, value);
    }

    static {
        $VALUES = kmEffectTypeArray = new KmEffectType[]{KmEffectType.RETURNS_CONSTANT, KmEffectType.CALLS, KmEffectType.RETURNS_NOT_NULL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

