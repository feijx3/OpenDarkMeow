/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/LazyThreadSafetyMode;", "", "<init>", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"})
public final class LazyThreadSafetyMode
extends Enum<LazyThreadSafetyMode> {
    public static final /* enum */ LazyThreadSafetyMode SYNCHRONIZED = new LazyThreadSafetyMode();
    public static final /* enum */ LazyThreadSafetyMode PUBLICATION = new LazyThreadSafetyMode();
    public static final /* enum */ LazyThreadSafetyMode NONE = new LazyThreadSafetyMode();
    private static final /* synthetic */ LazyThreadSafetyMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[])$VALUES.clone();
    }

    public static LazyThreadSafetyMode valueOf(String value) {
        return Enum.valueOf(LazyThreadSafetyMode.class, value);
    }

    @NotNull
    public static EnumEntries<LazyThreadSafetyMode> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = lazyThreadSafetyModeArray = new LazyThreadSafetyMode[]{LazyThreadSafetyMode.SYNCHRONIZED, LazyThreadSafetyMode.PUBLICATION, LazyThreadSafetyMode.NONE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

