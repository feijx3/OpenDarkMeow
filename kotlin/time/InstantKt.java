/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.time;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.ExperimentalTime;
import kotlin.time.Instant;
import kotlin.time.InstantParseResult;
import kotlin.time.UnboundLocalDateTime;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0003\u001a'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\u0014\u0010'\u001a\u00020\u0015*\u00020\u00152\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u0012*\u00020\u00102\u0006\u0010.\u001a\u00020\u0015H\u0002\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001f\u0010\u0006\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"isDistantPast", "", "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", "", "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lkotlin/time/InstantParseResult;", "isoString", "", "formatIso", "", "instant", "DAYS_PER_CYCLE", "", "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lkotlin/Function0;", "", "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", "", "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/UnboundLocalDateTime\n*L\n1#1,864:1\n1#2:865\n479#3,28:866\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n*L\n689#1:866,28\n*E\n"})
public final class InstantKt {
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int SECONDS_PER_DAY = 86400;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int MILLIS_PER_SECOND = 1000;
    @NotNull
    private static final int[] POWERS_OF_TEN;
    @NotNull
    private static final int[] asciiDigitPositionsInIsoStringAfterYear;
    @NotNull
    private static final int[] colonsInIsoOffsetString;
    @NotNull
    private static final int[] asciiDigitsInIsoOffsetString;

    private static final boolean isDistantPast(Instant $this$isDistantPast) {
        Intrinsics.checkNotNullParameter($this$isDistantPast, "<this>");
        return $this$isDistantPast.compareTo(Instant.Companion.getDISTANT_PAST()) <= 0;
    }

    @SinceKotlin(version="2.1")
    @ExperimentalTime
    @InlineOnly
    public static /* synthetic */ void isDistantPast$annotations(Instant instant) {
    }

    private static final boolean isDistantFuture(Instant $this$isDistantFuture) {
        Intrinsics.checkNotNullParameter($this$isDistantFuture, "<this>");
        return $this$isDistantFuture.compareTo(Instant.Companion.getDISTANT_FUTURE()) >= 0;
    }

    @SinceKotlin(version="2.1")
    @ExperimentalTime
    @InlineOnly
    public static /* synthetic */ void isDistantFuture$annotations(Instant instant) {
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @ExperimentalTime
    private static final InstantParseResult parseIso(CharSequence isoString) {
        void p1;
        int n2;
        int nanosecond;
        int n3;
        int year;
        int n4;
        CharSequence s2 = isoString;
        int i2 = 0;
        if (s2.length() == 0) {
            return new InstantParseResult.Failure("An empty string is not a valid Instant", isoString);
        }
        char c2 = s2.charAt(i2);
        switch (c2) {
            case '+': 
            case '-': {
                ++i2;
                n4 = c2;
                break;
            }
            default: {
                n4 = 32;
            }
        }
        int yearSign = n4;
        int yearStart = i2;
        int absYear = 0;
        while (i2 < s2.length()) {
            char c3 = s2.charAt(i2);
            boolean bl2 = '0' <= c3 ? c3 < ':' : false;
            if (!bl2) break;
            absYear = absYear * 10 + (s2.charAt(i2) - 48);
            ++i2;
        }
        int yearStrLength = i2 - yearStart;
        if (yearStrLength > 10) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected at most 10 digits for the year number, got " + yearStrLength + " digits");
        }
        if (yearStrLength == 10 && Intrinsics.compare(s2.charAt(yearStart), 50) >= 0) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected at most 9 digits for the year number or year 1000000000, got " + yearStrLength + " digits");
        }
        if (yearStrLength < 4) {
            return InstantKt.parseIso$parseFailure(isoString, "The year number must be padded to 4 digits, got " + yearStrLength + " digits");
        }
        if (yearSign == 43 && yearStrLength == 4) {
            return InstantKt.parseIso$parseFailure(isoString, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
        }
        if (yearSign == 32 && yearStrLength != 4) {
            return InstantKt.parseIso$parseFailure(isoString, "A '+' or '-' sign is required for year numbers longer than 4 digits");
        }
        int n5 = year = yearSign == 45 ? -absYear : absYear;
        if (s2.length() < i2 + 16) {
            return InstantKt.parseIso$parseFailure(isoString, "The input string is too short");
        }
        Object object = InstantKt.parseIso$expect(isoString, "'-'", i2, InstantKt::parseIso$lambda$0);
        if (object != null) {
            InstantParseResult.Failure it = object;
            return it;
        }
        object = InstantKt.parseIso$expect(isoString, "'-'", i2 + 3, InstantKt::parseIso$lambda$2);
        if (object != null) {
            InstantParseResult.Failure it = object;
            return it;
        }
        object = InstantKt.parseIso$expect(isoString, "'T' or 't'", i2 + 6, InstantKt::parseIso$lambda$4);
        if (object != null) {
            InstantParseResult.Failure it = object;
            return it;
        }
        object = InstantKt.parseIso$expect(isoString, "':'", i2 + 9, InstantKt::parseIso$lambda$6);
        if (object != null) {
            InstantParseResult.Failure it = object;
            return it;
        }
        object = InstantKt.parseIso$expect(isoString, "':'", i2 + 12, InstantKt::parseIso$lambda$8);
        if (object != null) {
            InstantParseResult.Failure it = object;
            return it;
        }
        for (Object j2 : (Object)asciiDigitPositionsInIsoStringAfterYear) {
            InstantParseResult.Failure failure = InstantKt.parseIso$expect(isoString, "an ASCII digit", i2 + j2, InstantKt::parseIso$lambda$10);
            if (failure == null) continue;
            InstantParseResult.Failure it = failure;
            return it;
        }
        int month = InstantKt.parseIso$twoDigitNumber(s2, i2 + 1);
        int day = InstantKt.parseIso$twoDigitNumber(s2, i2 + 4);
        int hour = InstantKt.parseIso$twoDigitNumber(s2, i2 + 7);
        int minute = InstantKt.parseIso$twoDigitNumber(s2, i2 + 10);
        int second = InstantKt.parseIso$twoDigitNumber(s2, i2 + 13);
        if (s2.charAt(i2 + 15) == '.') {
            int fractionStrLength;
            int fractionStart;
            int fraction = 0;
            for (i2 = fractionStart = i2 + 16; i2 < s2.length(); ++i2) {
                char c4 = s2.charAt(i2);
                boolean bl3 = '0' <= c4 ? c4 < ':' : false;
                if (!bl3) break;
                fraction = fraction * 10 + (s2.charAt(i2) - 48);
            }
            boolean bl4 = 1 <= (fractionStrLength = i2 - fractionStart) ? fractionStrLength < 10 : false;
            if (!bl4) return InstantKt.parseIso$parseFailure(isoString, "1..9 digits are supported for the fraction of the second, got " + fractionStrLength + " digits");
            n3 = fraction * POWERS_OF_TEN[9 - fractionStrLength];
        } else {
            i2 += 15;
            n3 = nanosecond = 0;
        }
        if (i2 >= s2.length()) {
            return InstantKt.parseIso$parseFailure(isoString, "The UTC offset at the end of the string is missing");
        }
        char sign = s2.charAt(i2);
        switch (sign) {
            case 'Z': 
            case 'z': {
                if (s2.length() != i2 + 1) return InstantKt.parseIso$parseFailure(isoString, "Extra text after the instant at position " + (i2 + 1));
                n2 = 0;
                break;
            }
            case '+': 
            case '-': {
                int offsetSecond;
                int n6;
                int offsetStrLength = s2.length() - i2;
                if (offsetStrLength > 9) {
                    CharSequence charSequence = s2;
                    int n7 = charSequence.length();
                    return InstantKt.parseIso$parseFailure(isoString, "The UTC offset string \"" + InstantKt.truncateForErrorMessage(((Object)charSequence.subSequence(i2, n7)).toString(), 16) + "\" is too long");
                }
                if (offsetStrLength % 3 != 0) {
                    CharSequence charSequence = s2;
                    int n8 = charSequence.length();
                    return InstantKt.parseIso$parseFailure(isoString, "Invalid UTC offset string \"" + ((Object)charSequence.subSequence(i2, n8)).toString() + '\"');
                }
                for (int j3 : colonsInIsoOffsetString) {
                    if (i2 + j3 >= s2.length()) break;
                    if (s2.charAt(i2 + j3) == ':') continue;
                    return InstantKt.parseIso$parseFailure(isoString, "Expected ':' at index " + (i2 + j3) + ", got '" + s2.charAt(i2 + j3) + '\'');
                }
                for (int j3 : asciiDigitsInIsoOffsetString) {
                    if (i2 + j3 >= s2.length()) break;
                    n6 = s2.charAt(i2 + j3);
                    if (48 <= n6 ? n6 < 58 : false) continue;
                    return InstantKt.parseIso$parseFailure(isoString, "Expected an ASCII digit at index " + (i2 + j3) + ", got '" + s2.charAt(i2 + j3) + '\'');
                }
                int offsetHour = InstantKt.parseIso$twoDigitNumber(s2, i2 + 1);
                int offsetMinute = offsetStrLength > 3 ? InstantKt.parseIso$twoDigitNumber(s2, i2 + 4) : 0;
                int n9 = offsetSecond = offsetStrLength > 6 ? InstantKt.parseIso$twoDigitNumber(s2, i2 + 7) : 0;
                if (offsetMinute > 59) {
                    return InstantKt.parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                }
                if (offsetSecond > 59) {
                    return InstantKt.parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                }
                if (offsetHour > 17 && (offsetHour != 18 || offsetMinute != 0 || offsetSecond != 0)) {
                    CharSequence j4 = s2;
                    n6 = j4.length();
                    return InstantKt.parseIso$parseFailure(isoString, "Expected an offset in -18:00..+18:00, got " + ((Object)j4.subSequence(i2, n6)).toString());
                }
                n2 = (offsetHour * 3600 + offsetMinute * 60 + offsetSecond) * (sign == '-' ? -1 : 1);
                break;
            }
            default: {
                return InstantKt.parseIso$parseFailure(isoString, "Expected the UTC offset at position " + i2 + ", got '" + sign + '\'');
            }
        }
        int offsetSeconds = n2;
        if (!(1 <= month ? month < 13 : false)) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected a month number in 1..12, got " + month);
        }
        if (!(1 <= day ? day <= InstantKt.monthLength(month, InstantKt.isLeapYear(year)) : false)) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected a valid day-of-month for month " + month + " of year " + year + ", got " + day);
        }
        if (hour > 23) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected hour in 0..23, got " + hour);
        }
        if (minute > 59) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected minute-of-hour in 0..59, got " + minute);
        }
        if (second > 59) {
            return InstantKt.parseIso$parseFailure(isoString, "Expected second-of-minute in 0..59, got " + second);
        }
        UnboundLocalDateTime this_$iv = new UnboundLocalDateTime(year, month, day, hour, minute, second, nanosecond);
        boolean $i$f$toInstant = false;
        UnboundLocalDateTime $this$toInstant_u24lambda_u241$iv = this_$iv;
        boolean bl5 = false;
        UnboundLocalDateTime $this$toInstant_u24lambda_u241_u24lambda_u240$iv = $this$toInstant_u24lambda_u241$iv;
        boolean bl6 = false;
        long y$iv = $this$toInstant_u24lambda_u241_u24lambda_u240$iv.getYear();
        long total$iv = (long)365 * y$iv;
        total$iv = y$iv >= 0L ? (total$iv += (y$iv + (long)3) / (long)4 - (y$iv + (long)99) / (long)100 + (y$iv + (long)399) / (long)400) : (total$iv -= y$iv / (long)-4 - y$iv / (long)-100 + y$iv / (long)-400);
        total$iv += (long)((367 * $this$toInstant_u24lambda_u241_u24lambda_u240$iv.getMonth() - 362) / 12);
        total$iv += (long)($this$toInstant_u24lambda_u241_u24lambda_u240$iv.getDay() - 1);
        if ($this$toInstant_u24lambda_u241_u24lambda_u240$iv.getMonth() > 2) {
            total$iv += -1L;
            if (!InstantKt.isLeapYear($this$toInstant_u24lambda_u241_u24lambda_u240$iv.getYear())) {
                total$iv += -1L;
            }
        }
        long epochDays$iv = total$iv - (long)719528;
        int daySeconds$iv = $this$toInstant_u24lambda_u241$iv.getHour() * 3600 + $this$toInstant_u24lambda_u241$iv.getMinute() * 60 + $this$toInstant_u24lambda_u241$iv.getSecond();
        long epochSeconds$iv = epochDays$iv * (long)86400 + (long)daySeconds$iv - (long)offsetSeconds;
        int n10 = this_$iv.getNanosecond();
        long p0 = epochSeconds$iv;
        return new InstantParseResult.Success(p0, (int)p1);
    }

    @ExperimentalTime
    private static final String formatIso(Instant instant) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        StringBuilder $this$formatIso_u24lambda_u2413 = stringBuilder2 = new StringBuilder();
        boolean bl2 = false;
        UnboundLocalDateTime ldt = UnboundLocalDateTime.Companion.fromInstant(instant);
        StringBuilder $this$formatIso_u24lambda_u2413_u24lambda_u2412 = $this$formatIso_u24lambda_u2413;
        boolean bl3 = false;
        int number = ldt.getYear();
        if (Math.abs(number) < 1000) {
            StringBuilder stringBuilder3;
            StringBuilder innerBuilder = new StringBuilder();
            if (number >= 0) {
                StringBuilder stringBuilder4 = innerBuilder.append(number + 10000).deleteCharAt(0);
                stringBuilder3 = stringBuilder4;
                Intrinsics.checkNotNullExpressionValue(stringBuilder4, "deleteCharAt(...)");
            } else {
                StringBuilder stringBuilder5 = innerBuilder.append(number - 10000).deleteCharAt(1);
                stringBuilder3 = stringBuilder5;
                Intrinsics.checkNotNullExpressionValue(stringBuilder5, "deleteCharAt(...)");
            }
            stringBuilder = $this$formatIso_u24lambda_u2413_u24lambda_u2412.append((CharSequence)innerBuilder);
        } else {
            if (number >= 10000) {
                $this$formatIso_u24lambda_u2413_u24lambda_u2412.append('+');
            }
            stringBuilder = $this$formatIso_u24lambda_u2413_u24lambda_u2412.append(number);
        }
        $this$formatIso_u24lambda_u2413.append('-');
        InstantKt.formatIso$lambda$13$appendTwoDigits($this$formatIso_u24lambda_u2413, $this$formatIso_u24lambda_u2413, ldt.getMonth());
        $this$formatIso_u24lambda_u2413.append('-');
        InstantKt.formatIso$lambda$13$appendTwoDigits($this$formatIso_u24lambda_u2413, $this$formatIso_u24lambda_u2413, ldt.getDay());
        $this$formatIso_u24lambda_u2413.append('T');
        InstantKt.formatIso$lambda$13$appendTwoDigits($this$formatIso_u24lambda_u2413, $this$formatIso_u24lambda_u2413, ldt.getHour());
        $this$formatIso_u24lambda_u2413.append(':');
        InstantKt.formatIso$lambda$13$appendTwoDigits($this$formatIso_u24lambda_u2413, $this$formatIso_u24lambda_u2413, ldt.getMinute());
        $this$formatIso_u24lambda_u2413.append(':');
        InstantKt.formatIso$lambda$13$appendTwoDigits($this$formatIso_u24lambda_u2413, $this$formatIso_u24lambda_u2413, ldt.getSecond());
        if (ldt.getNanosecond() != 0) {
            $this$formatIso_u24lambda_u2413.append('.');
            int zerosToStrip = 0;
            while (ldt.getNanosecond() % POWERS_OF_TEN[zerosToStrip + 1] == 0) {
                ++zerosToStrip;
            }
            zerosToStrip -= zerosToStrip % 3;
            int numberToOutput = ldt.getNanosecond() / POWERS_OF_TEN[zerosToStrip];
            String string = String.valueOf(numberToOutput + POWERS_OF_TEN[9 - zerosToStrip]);
            int n2 = 1;
            Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
            String string2 = string.substring(n2);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            $this$formatIso_u24lambda_u2413.append(string2);
        }
        $this$formatIso_u24lambda_u2413.append('Z');
        return stringBuilder2.toString();
    }

    private static final long safeAddOrElse(long a2, long b2, Function0 action) {
        boolean $i$f$safeAddOrElse = false;
        long sum = a2 + b2;
        if ((a2 ^ sum) < 0L && (a2 ^ b2) >= 0L) {
            action.invoke();
            throw new KotlinNothingValueException();
        }
        return sum;
    }

    private static final long safeMultiplyOrElse(long a2, long b2, Function0 action) {
        boolean $i$f$safeMultiplyOrElse = false;
        if (b2 == 1L) {
            return a2;
        }
        if (a2 == 1L) {
            return b2;
        }
        if (a2 == 0L || b2 == 0L) {
            return 0L;
        }
        long total = a2 * b2;
        if (total / b2 != a2 || a2 == Long.MIN_VALUE && b2 == -1L || b2 == Long.MIN_VALUE && a2 == -1L) {
            action.invoke();
            throw new KotlinNothingValueException();
        }
        return total;
    }

    public static final boolean isLeapYear(int year) {
        return (year & 3) == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static final int monthLength(int $this$monthLength, boolean isLeapYear) {
        int n2;
        switch ($this$monthLength) {
            case 2: {
                if (isLeapYear) {
                    n2 = 29;
                    break;
                }
                n2 = 28;
                break;
            }
            case 4: 
            case 6: 
            case 9: 
            case 11: {
                n2 = 30;
                break;
            }
            default: {
                n2 = 31;
            }
        }
        return n2;
    }

    private static final String truncateForErrorMessage(CharSequence $this$truncateForErrorMessage, int maxLength) {
        return $this$truncateForErrorMessage.length() <= maxLength ? ((Object)$this$truncateForErrorMessage).toString() : ((Object)$this$truncateForErrorMessage.subSequence(0, maxLength)).toString() + "...";
    }

    private static final InstantParseResult.Failure parseIso$parseFailure(CharSequence $isoString, String error) {
        return new InstantParseResult.Failure(error + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage($isoString, 64) + '\"', $isoString);
    }

    private static final InstantParseResult.Failure parseIso$expect(CharSequence $isoString, String what, int where, Function1<? super Character, Boolean> predicate) {
        char c2 = $isoString.charAt(where);
        return predicate.invoke(Character.valueOf(c2)) != false ? null : InstantKt.parseIso$parseFailure($isoString, "Expected " + what + ", but got '" + c2 + "' at position " + where);
    }

    private static final boolean parseIso$lambda$0(char it) {
        return it == '-';
    }

    private static final boolean parseIso$lambda$2(char it) {
        return it == '-';
    }

    private static final boolean parseIso$lambda$4(char it) {
        return it == 'T' || it == 't';
    }

    private static final boolean parseIso$lambda$6(char it) {
        return it == ':';
    }

    private static final boolean parseIso$lambda$8(char it) {
        return it == ':';
    }

    private static final boolean parseIso$lambda$10(char it) {
        return '0' <= it ? it < ':' : false;
    }

    private static final int parseIso$twoDigitNumber(CharSequence s2, int index) {
        return (s2.charAt(index) - 48) * 10 + (s2.charAt(index + 1) - 48);
    }

    private static final void formatIso$lambda$13$appendTwoDigits(Appendable $this$formatIso_u24lambda_u2413_u24appendTwoDigits, StringBuilder $this_buildString, int number) {
        if (number < 10) {
            $this$formatIso_u24lambda_u2413_u24appendTwoDigits.append('0');
        }
        $this_buildString.append(number);
    }

    public static final /* synthetic */ String access$formatIso(Instant instant) {
        return InstantKt.formatIso(instant);
    }

    public static final /* synthetic */ InstantParseResult access$parseIso(CharSequence isoString) {
        return InstantKt.parseIso(isoString);
    }

    public static final /* synthetic */ String access$truncateForErrorMessage(CharSequence $receiver, int maxLength) {
        return InstantKt.truncateForErrorMessage($receiver, maxLength);
    }

    static {
        int[] nArray = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        POWERS_OF_TEN = nArray;
        nArray = new int[]{1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
        asciiDigitPositionsInIsoStringAfterYear = nArray;
        nArray = new int[]{3, 6};
        colonsInIsoOffsetString = nArray;
        nArray = new int[]{1, 2, 4, 5, 7, 8};
        asciiDigitsInIsoOffsetString = nArray;
    }
}

