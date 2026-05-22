/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

public final class Variance
extends Enum<Variance> {
    @NotNull
    private final String label;
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final int superpositionFactor;
    public static final /* enum */ Variance INVARIANT = new Variance("", true, true, 0);
    public static final /* enum */ Variance IN_VARIANCE = new Variance("in", true, false, -1);
    public static final /* enum */ Variance OUT_VARIANCE = new Variance("out", false, true, 1);
    private static final /* synthetic */ Variance[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Variance(String label, boolean allowsInPosition, boolean allowsOutPosition, int superpositionFactor) {
        this.label = label;
        this.allowsInPosition = allowsInPosition;
        this.allowsOutPosition = allowsOutPosition;
        this.superpositionFactor = superpositionFactor;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @NotNull
    public String toString() {
        return this.label;
    }

    public static Variance[] values() {
        return (Variance[])$VALUES.clone();
    }

    public static Variance valueOf(String value) {
        return Enum.valueOf(Variance.class, value);
    }

    static {
        $VALUES = varianceArray = new Variance[]{Variance.INVARIANT, Variance.IN_VARIANCE, Variance.OUT_VARIANCE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

