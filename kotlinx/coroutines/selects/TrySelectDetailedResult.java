/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"})
public final class TrySelectDetailedResult
extends Enum<TrySelectDetailedResult> {
    public static final /* enum */ TrySelectDetailedResult SUCCESSFUL = new TrySelectDetailedResult();
    public static final /* enum */ TrySelectDetailedResult REREGISTER = new TrySelectDetailedResult();
    public static final /* enum */ TrySelectDetailedResult CANCELLED = new TrySelectDetailedResult();
    public static final /* enum */ TrySelectDetailedResult ALREADY_SELECTED = new TrySelectDetailedResult();
    private static final /* synthetic */ TrySelectDetailedResult[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[])$VALUES.clone();
    }

    public static TrySelectDetailedResult valueOf(String value) {
        return Enum.valueOf(TrySelectDetailedResult.class, value);
    }

    @NotNull
    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = trySelectDetailedResultArray = new TrySelectDetailedResult[]{TrySelectDetailedResult.SUCCESSFUL, TrySelectDetailedResult.REREGISTER, TrySelectDetailedResult.CANCELLED, TrySelectDetailedResult.ALREADY_SELECTED};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

