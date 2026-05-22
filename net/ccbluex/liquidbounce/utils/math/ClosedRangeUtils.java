/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.math;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u000e\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\b\u001a\u0002H\u00062\u0006\u0010\t\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/utils/math/ClosedRangeUtils;", "", "<init>", "()V", "smartCreate", "Lkotlin/ranges/ClosedRange;", "T", "", "min", "max", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "DarkMeow"})
public final class ClosedRangeUtils {
    @NotNull
    public static final ClosedRangeUtils INSTANCE = new ClosedRangeUtils();

    private ClosedRangeUtils() {
    }

    @NotNull
    public final <T extends Comparable<? super T>> ClosedRange<T> smartCreate(@NotNull T min, @NotNull T max) {
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        return RangesKt.rangeTo(ComparisonsKt.minOf(min, max), ComparisonsKt.maxOf(min, max));
    }
}

