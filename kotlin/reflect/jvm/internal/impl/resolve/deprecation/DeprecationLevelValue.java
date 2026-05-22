/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class DeprecationLevelValue
extends Enum<DeprecationLevelValue> {
    public static final /* enum */ DeprecationLevelValue WARNING = new DeprecationLevelValue();
    public static final /* enum */ DeprecationLevelValue ERROR = new DeprecationLevelValue();
    public static final /* enum */ DeprecationLevelValue HIDDEN = new DeprecationLevelValue();
    private static final /* synthetic */ DeprecationLevelValue[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[])$VALUES.clone();
    }

    public static DeprecationLevelValue valueOf(String value) {
        return Enum.valueOf(DeprecationLevelValue.class, value);
    }

    static {
        $VALUES = deprecationLevelValueArray = new DeprecationLevelValue[]{DeprecationLevelValue.WARNING, DeprecationLevelValue.ERROR, DeprecationLevelValue.HIDDEN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

