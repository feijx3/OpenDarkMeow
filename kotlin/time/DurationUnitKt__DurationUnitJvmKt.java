/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.WasExperimental
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001\u001a \u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001\u00a8\u0006\u000b"}, d2={"toTimeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDurationUnit", "convertDurationUnit", "", "value", "sourceUnit", "targetUnit", "convertDurationUnitOverflow", "", "kotlin-stdlib"}, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {
    @SinceKotlin(version="1.8")
    @WasExperimental(markerClass={ExperimentalTime.class})
    @NotNull
    public static final TimeUnit toTimeUnit(@NotNull DurationUnit $this$toTimeUnit) {
        Intrinsics.checkNotNullParameter((Object)$this$toTimeUnit, "<this>");
        return $this$toTimeUnit.getTimeUnit$kotlin_stdlib();
    }

    @SinceKotlin(version="1.8")
    @WasExperimental(markerClass={ExperimentalTime.class})
    @NotNull
    public static final DurationUnit toDurationUnit(@NotNull TimeUnit $this$toDurationUnit) {
        DurationUnit durationUnit;
        Intrinsics.checkNotNullParameter((Object)$this$toDurationUnit, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toDurationUnit.ordinal()]) {
            case 1: {
                durationUnit = DurationUnit.NANOSECONDS;
                break;
            }
            case 2: {
                durationUnit = DurationUnit.MICROSECONDS;
                break;
            }
            case 3: {
                durationUnit = DurationUnit.MILLISECONDS;
                break;
            }
            case 4: {
                durationUnit = DurationUnit.SECONDS;
                break;
            }
            case 5: {
                durationUnit = DurationUnit.MINUTES;
                break;
            }
            case 6: {
                durationUnit = DurationUnit.HOURS;
                break;
            }
            case 7: {
                durationUnit = DurationUnit.DAYS;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return durationUnit;
    }

    @SinceKotlin(version="1.3")
    public static final double convertDurationUnit(double value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter((Object)sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter((Object)targetUnit, "targetUnit");
        long sourceInTargets = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        if (sourceInTargets > 0L) {
            return value * (double)sourceInTargets;
        }
        long otherInThis = sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
        return value / (double)otherInThis;
    }

    @SinceKotlin(version="1.5")
    public static final long convertDurationUnitOverflow(long value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter((Object)sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter((Object)targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version="1.5")
    public static final long convertDurationUnit(long value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter((Object)sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter((Object)targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[TimeUnit.values().length];
            try {
                nArray[TimeUnit.NANOSECONDS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.MICROSECONDS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.MILLISECONDS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.SECONDS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.MINUTES.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.HOURS.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TimeUnit.DAYS.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

