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
public final class KmEffectInvocationKind
extends Enum<KmEffectInvocationKind> {
    public static final /* enum */ KmEffectInvocationKind AT_MOST_ONCE = new KmEffectInvocationKind();
    public static final /* enum */ KmEffectInvocationKind EXACTLY_ONCE = new KmEffectInvocationKind();
    public static final /* enum */ KmEffectInvocationKind AT_LEAST_ONCE = new KmEffectInvocationKind();
    private static final /* synthetic */ KmEffectInvocationKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KmEffectInvocationKind[] values() {
        return (KmEffectInvocationKind[])$VALUES.clone();
    }

    public static KmEffectInvocationKind valueOf(String value) {
        return Enum.valueOf(KmEffectInvocationKind.class, value);
    }

    static {
        $VALUES = kmEffectInvocationKindArray = new KmEffectInvocationKind[]{KmEffectInvocationKind.AT_MOST_ONCE, KmEffectInvocationKind.EXACTLY_ONCE, KmEffectInvocationKind.AT_LEAST_ONCE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

