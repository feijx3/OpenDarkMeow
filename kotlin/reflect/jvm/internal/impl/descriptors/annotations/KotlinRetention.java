/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class KotlinRetention
extends Enum<KotlinRetention> {
    public static final /* enum */ KotlinRetention RUNTIME = new KotlinRetention();
    public static final /* enum */ KotlinRetention BINARY = new KotlinRetention();
    public static final /* enum */ KotlinRetention SOURCE = new KotlinRetention();
    private static final /* synthetic */ KotlinRetention[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KotlinRetention[] values() {
        return (KotlinRetention[])$VALUES.clone();
    }

    public static KotlinRetention valueOf(String value) {
        return Enum.valueOf(KotlinRetention.class, value);
    }

    static {
        $VALUES = kotlinRetentionArray = new KotlinRetention[]{KotlinRetention.RUNTIME, KotlinRetention.BINARY, KotlinRetention.SOURCE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

