/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class LightClassOriginKind
extends Enum<LightClassOriginKind> {
    public static final /* enum */ LightClassOriginKind SOURCE = new LightClassOriginKind();
    public static final /* enum */ LightClassOriginKind BINARY = new LightClassOriginKind();
    private static final /* synthetic */ LightClassOriginKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[])$VALUES.clone();
    }

    public static LightClassOriginKind valueOf(String value) {
        return Enum.valueOf(LightClassOriginKind.class, value);
    }

    static {
        $VALUES = lightClassOriginKindArray = new LightClassOriginKind[]{LightClassOriginKind.SOURCE, LightClassOriginKind.BINARY};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

