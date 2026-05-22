/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class KmVersionRequirementLevel
extends Enum<KmVersionRequirementLevel> {
    public static final /* enum */ KmVersionRequirementLevel WARNING = new KmVersionRequirementLevel();
    public static final /* enum */ KmVersionRequirementLevel ERROR = new KmVersionRequirementLevel();
    public static final /* enum */ KmVersionRequirementLevel HIDDEN = new KmVersionRequirementLevel();
    private static final /* synthetic */ KmVersionRequirementLevel[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KmVersionRequirementLevel[] values() {
        return (KmVersionRequirementLevel[])$VALUES.clone();
    }

    public static KmVersionRequirementLevel valueOf(String value) {
        return Enum.valueOf(KmVersionRequirementLevel.class, value);
    }

    static {
        $VALUES = kmVersionRequirementLevelArray = new KmVersionRequirementLevel[]{KmVersionRequirementLevel.WARNING, KmVersionRequirementLevel.ERROR, KmVersionRequirementLevel.HIDDEN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

