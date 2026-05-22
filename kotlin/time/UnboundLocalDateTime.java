/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ExperimentalTime;
import kotlin.time.Instant;
import kotlin.time.InstantKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJW\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u000326\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002H\u00150\u0018H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2={"Lkotlin/time/UnboundLocalDateTime;", "", "year", "", "month", "day", "hour", "minute", "second", "nanosecond", "<init>", "(IIIIIII)V", "getYear", "()I", "getMonth", "getDay", "getHour", "getMinute", "getSecond", "getNanosecond", "toInstant", "T", "offsetSeconds", "buildInstant", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "epochSeconds", "nanosecondOfSecond", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", "", "Companion", "kotlin-stdlib"})
@ExperimentalTime
final class UnboundLocalDateTime {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;
    private final int nanosecond;

    public UnboundLocalDateTime(int year, int month, int day, int hour, int minute, int second, int nanosecond) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.nanosecond = nanosecond;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final <T> T toInstant(int offsetSeconds, @NotNull Function2<? super Long, ? super Integer, ? extends T> buildInstant) {
        Intrinsics.checkNotNullParameter(buildInstant, "buildInstant");
        boolean $i$f$toInstant = false;
        UnboundLocalDateTime $this$toInstant_u24lambda_u241 = this;
        boolean bl2 = false;
        UnboundLocalDateTime $this$toInstant_u24lambda_u241_u24lambda_u240 = $this$toInstant_u24lambda_u241;
        boolean bl3 = false;
        long y2 = $this$toInstant_u24lambda_u241_u24lambda_u240.getYear();
        long total = (long)365 * y2;
        total = y2 >= 0L ? (total += (y2 + (long)3) / (long)4 - (y2 + (long)99) / (long)100 + (y2 + (long)399) / (long)400) : (total -= y2 / (long)-4 - y2 / (long)-100 + y2 / (long)-400);
        total += (long)((367 * $this$toInstant_u24lambda_u241_u24lambda_u240.getMonth() - 362) / 12);
        total += (long)($this$toInstant_u24lambda_u241_u24lambda_u240.getDay() - 1);
        if ($this$toInstant_u24lambda_u241_u24lambda_u240.getMonth() > 2) {
            total += -1L;
            if (!InstantKt.isLeapYear($this$toInstant_u24lambda_u241_u24lambda_u240.getYear())) {
                total += -1L;
            }
        }
        long epochDays = total - (long)719528;
        int daySeconds = $this$toInstant_u24lambda_u241.getHour() * 3600 + $this$toInstant_u24lambda_u241.getMinute() * 60 + $this$toInstant_u24lambda_u241.getSecond();
        long epochSeconds = epochDays * (long)86400 + (long)daySeconds - (long)offsetSeconds;
        return buildInstant.invoke(epochSeconds, this.getNanosecond());
    }

    @NotNull
    public String toString() {
        return "UnboundLocalDateTime(" + this.year + '-' + this.month + '-' + this.day + ' ' + this.hour + ':' + this.minute + ':' + this.second + '.' + this.nanosecond + ')';
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lkotlin/time/UnboundLocalDateTime$Companion;", "", "<init>", "()V", "fromInstant", "Lkotlin/time/UnboundLocalDateTime;", "instant", "Lkotlin/time/Instant;", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UnboundLocalDateTime fromInstant(@NotNull Instant instant) {
            long yearEst;
            long doyEst;
            long localSecond;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long l2 = localSecond = instant.getEpochSeconds();
            long l3 = 86400L;
            long l4 = l2 / l3;
            if ((l2 ^ l3) < 0L && l4 * l3 != l2) {
                l4 += -1L;
            }
            long epochDays = l4;
            long l5 = localSecond;
            long l6 = 86400L;
            long l7 = l5 % l6;
            int secsOfDay = (int)(l7 + (l6 & ((l7 ^ l6) & (l7 | -l7)) >> 63));
            int year = 0;
            int month = 0;
            int day = 0;
            Companion $this$fromInstant_u24lambda_u240 = this;
            boolean bl2 = false;
            long zeroDay = epochDays + (long)719528;
            long adjust = 0L;
            if ((zeroDay -= (long)60) < 0L) {
                long adjustCycles = (zeroDay + 1L) / (long)146097 - 1L;
                adjust = adjustCycles * (long)400;
                zeroDay += -adjustCycles * (long)146097;
            }
            if ((doyEst = zeroDay - ((long)365 * (yearEst = ((long)400 * zeroDay + (long)591) / (long)146097) + yearEst / (long)4 - yearEst / (long)100 + yearEst / (long)400)) < 0L) {
                doyEst = zeroDay - ((long)365 * (yearEst += -1L) + yearEst / (long)4 - yearEst / (long)100 + yearEst / (long)400);
            }
            int marchDoy0 = (int)doyEst;
            int marchMonth0 = (marchDoy0 * 5 + 2) / 153;
            month = (marchMonth0 + 2) % 12 + 1;
            day = marchDoy0 - (marchMonth0 * 306 + 5) / 10 + 1;
            year = (int)((yearEst += adjust) + (long)(marchMonth0 / 10));
            int hours = secsOfDay / 3600;
            int secondWithoutHours = secsOfDay - hours * 3600;
            int minutes = secondWithoutHours / 60;
            int second = secondWithoutHours - minutes * 60;
            return new UnboundLocalDateTime(year, month, day, hours, minutes, second, instant.getNanosecondsOfSecond());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

