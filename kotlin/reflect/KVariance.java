/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/KVariance;", "", "<init>", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"})
@SinceKotlin(version="1.1")
public final class KVariance
extends Enum<KVariance> {
    public static final /* enum */ KVariance INVARIANT = new KVariance();
    public static final /* enum */ KVariance IN = new KVariance();
    public static final /* enum */ KVariance OUT = new KVariance();
    private static final /* synthetic */ KVariance[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KVariance[] values() {
        return (KVariance[])$VALUES.clone();
    }

    public static KVariance valueOf(String value) {
        return Enum.valueOf(KVariance.class, value);
    }

    @NotNull
    public static EnumEntries<KVariance> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = kVarianceArray = new KVariance[]{KVariance.INVARIANT, KVariance.IN, KVariance.OUT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

