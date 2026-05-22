/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class KmVersionRequirementVersionKind
extends Enum<KmVersionRequirementVersionKind> {
    public static final /* enum */ KmVersionRequirementVersionKind LANGUAGE_VERSION = new KmVersionRequirementVersionKind();
    public static final /* enum */ KmVersionRequirementVersionKind COMPILER_VERSION = new KmVersionRequirementVersionKind();
    public static final /* enum */ KmVersionRequirementVersionKind API_VERSION = new KmVersionRequirementVersionKind();
    public static final /* enum */ KmVersionRequirementVersionKind UNKNOWN = new KmVersionRequirementVersionKind();
    private static final /* synthetic */ KmVersionRequirementVersionKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KmVersionRequirementVersionKind[] values() {
        return (KmVersionRequirementVersionKind[])$VALUES.clone();
    }

    public static KmVersionRequirementVersionKind valueOf(String value) {
        return Enum.valueOf(KmVersionRequirementVersionKind.class, value);
    }

    static {
        $VALUES = kmVersionRequirementVersionKindArray = new KmVersionRequirementVersionKind[]{KmVersionRequirementVersionKind.LANGUAGE_VERSION, KmVersionRequirementVersionKind.COMPILER_VERSION, KmVersionRequirementVersionKind.API_VERSION, KmVersionRequirementVersionKind.UNKNOWN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

