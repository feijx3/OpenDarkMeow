/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class TypeUsage
extends Enum<TypeUsage> {
    public static final /* enum */ TypeUsage SUPERTYPE = new TypeUsage();
    public static final /* enum */ TypeUsage COMMON = new TypeUsage();
    private static final /* synthetic */ TypeUsage[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static TypeUsage[] values() {
        return (TypeUsage[])$VALUES.clone();
    }

    public static TypeUsage valueOf(String value) {
        return Enum.valueOf(TypeUsage.class, value);
    }

    static {
        $VALUES = typeUsageArray = new TypeUsage[]{TypeUsage.SUPERTYPE, TypeUsage.COMMON};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

