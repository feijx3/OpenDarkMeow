/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class CaptureStatus
extends Enum<CaptureStatus> {
    public static final /* enum */ CaptureStatus FOR_SUBTYPING = new CaptureStatus();
    public static final /* enum */ CaptureStatus FOR_INCORPORATION = new CaptureStatus();
    public static final /* enum */ CaptureStatus FROM_EXPRESSION = new CaptureStatus();
    private static final /* synthetic */ CaptureStatus[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static CaptureStatus[] values() {
        return (CaptureStatus[])$VALUES.clone();
    }

    public static CaptureStatus valueOf(String value) {
        return Enum.valueOf(CaptureStatus.class, value);
    }

    static {
        $VALUES = captureStatusArray = new CaptureStatus[]{CaptureStatus.FOR_SUBTYPING, CaptureStatus.FOR_INCORPORATION, CaptureStatus.FROM_EXPRESSION};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

