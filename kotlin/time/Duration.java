/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.DurationJvmKt;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.DurationUnitKt;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002\u00a2\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r\u00a2\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r\u00a2\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r\u00a2\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r\u00a2\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002\u00a2\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013\u00a2\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013\u00a2\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013\u00a2\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016\u00a2\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t\u00a2\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u\u00a2\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001H\u00d6\u0003J\n\u0010\u0088\u0001\u001a\u00020\tH\u00d6\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u008a\u0001"}, d2={"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.6")
@SourceDebugExtension(value={"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1062:1\n37#1:1063\n37#1:1064\n37#1:1065\n37#1:1066\n37#1:1067\n500#1:1068\n517#1:1076\n170#2,6:1069\n1#3:1075\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n38#1:1063\n39#1:1064\n274#1:1065\n294#1:1066\n478#1:1067\n727#1:1068\n818#1:1076\n769#1:1069,6\n*E\n"})
public final class Duration
implements Comparable<Duration> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long rawValue;
    private static final long ZERO = Duration.constructor-impl(0L);
    private static final long INFINITE = DurationKt.access$durationOfMillis(0x3FFFFFFFFFFFFFFFL);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    private static final long getValue-impl(long arg0) {
        return arg0 >> 1;
    }

    private static final int getUnitDiscriminator-impl(long arg0) {
        boolean bl2 = false;
        return (int)arg0 & 1;
    }

    private static final boolean isInNanos-impl(long arg0) {
        boolean bl2 = false;
        return ((int)arg0 & 1) == 0;
    }

    private static final boolean isInMillis-impl(long arg0) {
        boolean bl2 = false;
        return ((int)arg0 & 1) == 1;
    }

    private static final DurationUnit getStorageUnit-impl(long arg0) {
        return Duration.isInNanos-impl(arg0) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final long unaryMinus-UwyO8pc(long arg0) {
        boolean bl2 = false;
        return DurationKt.access$durationOf(-Duration.getValue-impl(arg0), (int)arg0 & 1);
    }

    public static final long plus-LRDsOJo(long arg0, long other) {
        long l2;
        if (Duration.isInfinite-impl(arg0)) {
            if (Duration.isFinite-impl(other) || (arg0 ^ other) >= 0L) {
                return arg0;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (Duration.isInfinite-impl(other)) {
            return other;
        }
        boolean bl2 = false;
        bl2 = false;
        if (((int)arg0 & 1) == ((int)other & 1)) {
            long result = Duration.getValue-impl(arg0) + Duration.getValue-impl(other);
            l2 = Duration.isInNanos-impl(arg0) ? DurationKt.access$durationOfNanosNormalized(result) : DurationKt.access$durationOfMillisNormalized(result);
        } else {
            l2 = Duration.isInMillis-impl(arg0) ? Duration.addValuesMixedRanges-UwyO8pc(arg0, Duration.getValue-impl(arg0), Duration.getValue-impl(other)) : Duration.addValuesMixedRanges-UwyO8pc(arg0, Duration.getValue-impl(other), Duration.getValue-impl(arg0));
        }
        return l2;
    }

    private static final long addValuesMixedRanges-UwyO8pc(long arg0, long thisMillis, long otherNanos) {
        long l2;
        long otherMillis = DurationKt.access$nanosToMillis(otherNanos);
        long resultMillis = thisMillis + otherMillis;
        boolean bl2 = -4611686018426L <= resultMillis ? resultMillis < 4611686018427L : false;
        if (bl2) {
            long otherNanoRemainder = otherNanos - DurationKt.access$millisToNanos(otherMillis);
            l2 = DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(resultMillis) + otherNanoRemainder);
        } else {
            l2 = DurationKt.access$durationOfMillis(RangesKt.coerceIn(resultMillis, -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL));
        }
        return l2;
    }

    public static final long minus-LRDsOJo(long arg0, long other) {
        return Duration.plus-LRDsOJo(arg0, Duration.unaryMinus-UwyO8pc(other));
    }

    public static final long times-UwyO8pc(long arg0, int scale) {
        long l2;
        if (Duration.isInfinite-impl(arg0)) {
            if (scale == 0) {
                throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            }
            return scale > 0 ? arg0 : Duration.unaryMinus-UwyO8pc(arg0);
        }
        if (scale == 0) {
            return ZERO;
        }
        long value = Duration.getValue-impl(arg0);
        long result = value * (long)scale;
        if (Duration.isInNanos-impl(arg0)) {
            boolean bl2 = -2147483647L <= value ? value < 0x80000000L : false;
            if (bl2) {
                l2 = DurationKt.access$durationOfNanos(result);
            } else if (result / (long)scale == value) {
                l2 = DurationKt.access$durationOfNanosNormalized(result);
            } else {
                long millis = DurationKt.access$nanosToMillis(value);
                long remNanos = value - DurationKt.access$millisToNanos(millis);
                long resultMillis = millis * (long)scale;
                long totalMillis = resultMillis + DurationKt.access$nanosToMillis(remNanos * (long)scale);
                l2 = resultMillis / (long)scale == millis && (totalMillis ^ resultMillis) >= 0L ? DurationKt.access$durationOfMillis(RangesKt.coerceIn(totalMillis, new LongRange(-4611686018427387903L, 0x3FFFFFFFFFFFFFFFL))) : (MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE);
            }
        } else {
            l2 = result / (long)scale == value ? DurationKt.access$durationOfMillis(RangesKt.coerceIn(result, new LongRange(-4611686018427387903L, 0x3FFFFFFFFFFFFFFFL))) : (MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE);
        }
        return l2;
    }

    public static final long times-UwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if ((double)intScale == scale) {
            return Duration.times-UwyO8pc(arg0, intScale);
        }
        DurationUnit unit = Duration.getStorageUnit-impl(arg0);
        double result = Duration.toDouble-impl(arg0, unit) * scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final long div-UwyO8pc(long arg0, int scale) {
        if (scale == 0) {
            long l2;
            if (Duration.isPositive-impl(arg0)) {
                l2 = INFINITE;
            } else if (Duration.isNegative-impl(arg0)) {
                l2 = NEG_INFINITE;
            } else {
                throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
            }
            return l2;
        }
        if (Duration.isInNanos-impl(arg0)) {
            return DurationKt.access$durationOfNanos(Duration.getValue-impl(arg0) / (long)scale);
        }
        if (Duration.isInfinite-impl(arg0)) {
            return Duration.times-UwyO8pc(arg0, MathKt.getSign(scale));
        }
        long result = Duration.getValue-impl(arg0) / (long)scale;
        boolean bl2 = -4611686018426L <= result ? result < 4611686018427L : false;
        if (bl2) {
            long rem = DurationKt.access$millisToNanos(Duration.getValue-impl(arg0) - result * (long)scale) / (long)scale;
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(result) + rem);
        }
        return DurationKt.access$durationOfMillis(result);
    }

    public static final long div-UwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if ((double)intScale == scale && intScale != 0) {
            return Duration.div-UwyO8pc(arg0, intScale);
        }
        DurationUnit unit = Duration.getStorageUnit-impl(arg0);
        double result = Duration.toDouble-impl(arg0, unit) / scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final double div-LRDsOJo(long arg0, long other) {
        DurationUnit coarserUnit = (DurationUnit)((Object)ComparisonsKt.maxOf((Comparable)((Object)Duration.getStorageUnit-impl(arg0)), (Comparable)((Object)Duration.getStorageUnit-impl(other))));
        return Duration.toDouble-impl(arg0, coarserUnit) / Duration.toDouble-impl(other, coarserUnit);
    }

    public static final long truncateTo-UwyO8pc$kotlin_stdlib(long arg0, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        DurationUnit storageUnit = Duration.getStorageUnit-impl(arg0);
        if (unit.compareTo((Enum)storageUnit) <= 0 || Duration.isInfinite-impl(arg0)) {
            return arg0;
        }
        long scale = DurationUnitKt.convertDurationUnit(1L, unit, storageUnit);
        long result = Duration.getValue-impl(arg0) - Duration.getValue-impl(arg0) % scale;
        return DurationKt.toDuration(result, storageUnit);
    }

    public static final boolean isNegative-impl(long arg0) {
        return arg0 < 0L;
    }

    public static final boolean isPositive-impl(long arg0) {
        return arg0 > 0L;
    }

    public static final boolean isInfinite-impl(long arg0) {
        return arg0 == INFINITE || arg0 == NEG_INFINITE;
    }

    public static final boolean isFinite-impl(long arg0) {
        return !Duration.isInfinite-impl(arg0);
    }

    public static final long getAbsoluteValue-UwyO8pc(long arg0) {
        return Duration.isNegative-impl(arg0) ? Duration.unaryMinus-UwyO8pc(arg0) : arg0;
    }

    public static int compareTo-LRDsOJo(long arg0, long other) {
        long compareBits = arg0 ^ other;
        if (compareBits < 0L || ((int)compareBits & 1) == 0) {
            return Intrinsics.compare(arg0, other);
        }
        boolean bl2 = false;
        bl2 = false;
        int r2 = ((int)arg0 & 1) - ((int)other & 1);
        return Duration.isNegative-impl(arg0) ? -r2 : r2;
    }

    public int compareTo-LRDsOJo(long other) {
        return Duration.compareTo-LRDsOJo(this.rawValue, other);
    }

    public static final <T> T toComponents-impl(long arg0, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean bl2 = false;
        return action.invoke(Duration.getInWholeDays-impl(arg0), Duration.getHoursComponent-impl(arg0), Duration.getMinutesComponent-impl(arg0), Duration.getSecondsComponent-impl(arg0), Duration.getNanosecondsComponent-impl(arg0));
    }

    public static final <T> T toComponents-impl(long arg0, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean bl2 = false;
        return action.invoke(Duration.getInWholeHours-impl(arg0), Duration.getMinutesComponent-impl(arg0), Duration.getSecondsComponent-impl(arg0), Duration.getNanosecondsComponent-impl(arg0));
    }

    public static final <T> T toComponents-impl(long arg0, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean bl2 = false;
        return action.invoke(Duration.getInWholeMinutes-impl(arg0), Duration.getSecondsComponent-impl(arg0), Duration.getNanosecondsComponent-impl(arg0));
    }

    public static final <T> T toComponents-impl(long arg0, @NotNull Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean bl2 = false;
        return action.invoke(Duration.getInWholeSeconds-impl(arg0), Duration.getNanosecondsComponent-impl(arg0));
    }

    public static final int getHoursComponent-impl(long arg0) {
        return Duration.isInfinite-impl(arg0) ? 0 : (int)(Duration.getInWholeHours-impl(arg0) % (long)24);
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static final int getMinutesComponent-impl(long arg0) {
        return Duration.isInfinite-impl(arg0) ? 0 : (int)(Duration.getInWholeMinutes-impl(arg0) % (long)60);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static final int getSecondsComponent-impl(long arg0) {
        return Duration.isInfinite-impl(arg0) ? 0 : (int)(Duration.getInWholeSeconds-impl(arg0) % (long)60);
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    public static final int getNanosecondsComponent-impl(long arg0) {
        return Duration.isInfinite-impl(arg0) ? 0 : (Duration.isInMillis-impl(arg0) ? (int)DurationKt.access$millisToNanos(Duration.getValue-impl(arg0) % (long)1000) : (int)(Duration.getValue-impl(arg0) % (long)1000000000));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static final double toDouble-impl(long arg0, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        long l2 = arg0;
        return l2 == INFINITE ? Double.POSITIVE_INFINITY : (l2 == NEG_INFINITE ? Double.NEGATIVE_INFINITY : DurationUnitKt.convertDurationUnit((double)Duration.getValue-impl(arg0), Duration.getStorageUnit-impl(arg0), unit));
    }

    public static final long toLong-impl(long arg0, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        long l2 = arg0;
        return l2 == INFINITE ? Long.MAX_VALUE : (l2 == NEG_INFINITE ? Long.MIN_VALUE : DurationUnitKt.convertDurationUnit(Duration.getValue-impl(arg0), Duration.getStorageUnit-impl(arg0), unit));
    }

    public static final int toInt-impl(long arg0, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        return (int)RangesKt.coerceIn(Duration.toLong-impl(arg0, unit), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static final long getInWholeDays-impl(long arg0) {
        return Duration.toLong-impl(arg0, DurationUnit.DAYS);
    }

    public static final long getInWholeHours-impl(long arg0) {
        return Duration.toLong-impl(arg0, DurationUnit.HOURS);
    }

    public static final long getInWholeMinutes-impl(long arg0) {
        return Duration.toLong-impl(arg0, DurationUnit.MINUTES);
    }

    public static final long getInWholeSeconds-impl(long arg0) {
        return Duration.toLong-impl(arg0, DurationUnit.SECONDS);
    }

    public static final long getInWholeMilliseconds-impl(long arg0) {
        return Duration.isInMillis-impl(arg0) && Duration.isFinite-impl(arg0) ? Duration.getValue-impl(arg0) : Duration.toLong-impl(arg0, DurationUnit.MILLISECONDS);
    }

    public static final long getInWholeMicroseconds-impl(long arg0) {
        return Duration.toLong-impl(arg0, DurationUnit.MICROSECONDS);
    }

    public static final long getInWholeNanoseconds-impl(long arg0) {
        long value = Duration.getValue-impl(arg0);
        return Duration.isInNanos-impl(arg0) ? value : (value > 9223372036854L ? Long.MAX_VALUE : (value < -9223372036854L ? Long.MIN_VALUE : DurationKt.access$millisToNanos(value)));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static String toString-impl(long arg0) {
        String string;
        long l2 = arg0;
        if (l2 == 0L) {
            string = "0s";
        } else if (l2 == INFINITE) {
            string = "Infinity";
        } else if (l2 == NEG_INFINITE) {
            string = "-Infinity";
        } else {
            void nanoseconds;
            void seconds;
            void minutes;
            void hours;
            StringBuilder stringBuilder;
            boolean isNegative = Duration.isNegative-impl(arg0);
            StringBuilder $this$toString_impl_u24lambda_u241 = stringBuilder = new StringBuilder();
            boolean bl2 = false;
            if (isNegative) {
                $this$toString_impl_u24lambda_u241.append('-');
            }
            long arg0$iv = Duration.getAbsoluteValue-UwyO8pc(arg0);
            boolean bl3 = false;
            int n2 = Duration.getNanosecondsComponent-impl(arg0$iv);
            int n3 = Duration.getSecondsComponent-impl(arg0$iv);
            int n4 = Duration.getMinutesComponent-impl(arg0$iv);
            int n5 = Duration.getHoursComponent-impl(arg0$iv);
            long days = Duration.getInWholeDays-impl(arg0$iv);
            boolean bl4 = false;
            boolean hasDays = days != 0L;
            boolean hasHours = hours != false;
            boolean hasMinutes = minutes != false;
            boolean hasSeconds = seconds != false || nanoseconds != false;
            int components = 0;
            if (hasDays) {
                $this$toString_impl_u24lambda_u241.append(days).append('d');
                ++components;
            }
            if (hasHours || hasDays && (hasMinutes || hasSeconds)) {
                if (components++ > 0) {
                    $this$toString_impl_u24lambda_u241.append(' ');
                }
                $this$toString_impl_u24lambda_u241.append((int)hours).append('h');
            }
            if (hasMinutes || hasSeconds && (hasHours || hasDays)) {
                if (components++ > 0) {
                    $this$toString_impl_u24lambda_u241.append(' ');
                }
                $this$toString_impl_u24lambda_u241.append((int)minutes).append('m');
            }
            if (hasSeconds) {
                if (components++ > 0) {
                    $this$toString_impl_u24lambda_u241.append(' ');
                }
                if (seconds != false || hasDays || hasHours || hasMinutes) {
                    Duration.appendFractional-impl(arg0, $this$toString_impl_u24lambda_u241, (int)seconds, (int)nanoseconds, 9, "s", false);
                } else if (nanoseconds >= 1000000) {
                    Duration.appendFractional-impl(arg0, $this$toString_impl_u24lambda_u241, (int)(nanoseconds / 1000000), (int)(nanoseconds % 1000000), 6, "ms", false);
                } else if (nanoseconds >= 1000) {
                    Duration.appendFractional-impl(arg0, $this$toString_impl_u24lambda_u241, (int)(nanoseconds / 1000), (int)(nanoseconds % 1000), 3, "us", false);
                } else {
                    $this$toString_impl_u24lambda_u241.append((int)nanoseconds).append("ns");
                }
            }
            if (isNegative && components > 1) {
                $this$toString_impl_u24lambda_u241.insert(1, '(').append(')');
            }
            string = stringBuilder.toString();
        }
        return string;
    }

    @NotNull
    public String toString() {
        return Duration.toString-impl(this.rawValue);
    }

    private static final void appendFractional-impl(long arg0, StringBuilder $this$appendFractional, int whole, int fractional, int fractionalSize, String unit, boolean isoZeroes) {
        $this$appendFractional.append(whole);
        if (fractional != 0) {
            StringBuilder stringBuilder;
            int n2;
            String fracString;
            block5: {
                $this$appendFractional.append('.');
                fracString = StringsKt.padStart(String.valueOf(fractional), fractionalSize, '0');
                CharSequence $this$indexOfLast$iv = fracString;
                boolean $i$f$indexOfLast = false;
                int n3 = $this$indexOfLast$iv.length() + -1;
                if (0 <= n3) {
                    do {
                        int index$iv = n3--;
                        char it = $this$indexOfLast$iv.charAt(index$iv);
                        boolean bl2 = false;
                        if (!(it != '0')) continue;
                        n2 = index$iv;
                        break block5;
                    } while (0 <= n3);
                }
                n2 = -1;
            }
            int nonZeroDigits = n2 + 1;
            if (!isoZeroes && nonZeroDigits < 3) {
                StringBuilder stringBuilder2 = $this$appendFractional.append(fracString, 0, nonZeroDigits);
                stringBuilder = stringBuilder2;
                Intrinsics.checkNotNullExpressionValue(stringBuilder2, "append(...)");
            } else {
                StringBuilder stringBuilder3 = $this$appendFractional.append(fracString, 0, (nonZeroDigits + 2) / 3 * 3);
                stringBuilder = stringBuilder3;
                Intrinsics.checkNotNullExpressionValue(stringBuilder3, "append(...)");
            }
        }
        $this$appendFractional.append(unit);
    }

    @NotNull
    public static final String toString-impl(long arg0, @NotNull DurationUnit unit, int decimals) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        if (!(decimals >= 0)) {
            boolean bl2 = false;
            String string = "decimals must be not negative, but was " + decimals;
            throw new IllegalArgumentException(string.toString());
        }
        double number = Duration.toDouble-impl(arg0, unit);
        if (Double.isInfinite(number)) {
            return String.valueOf(number);
        }
        return DurationJvmKt.formatToExactDecimals(number, RangesKt.coerceAtMost(decimals, 12)) + DurationUnitKt.shortName(unit);
    }

    public static /* synthetic */ String toString-impl$default(long l2, DurationUnit durationUnit, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return Duration.toString-impl(l2, durationUnit, n2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String toIsoString-impl(long arg0) {
        void minutes;
        boolean hasMinutes;
        void nanoseconds;
        void seconds;
        StringBuilder stringBuilder;
        StringBuilder $this$toIsoString_impl_u24lambda_u245 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        if (Duration.isNegative-impl(arg0)) {
            $this$toIsoString_impl_u24lambda_u245.append('-');
        }
        $this$toIsoString_impl_u24lambda_u245.append("PT");
        long arg0$iv = Duration.getAbsoluteValue-UwyO8pc(arg0);
        boolean bl3 = false;
        int n2 = Duration.getNanosecondsComponent-impl(arg0$iv);
        int n3 = Duration.getSecondsComponent-impl(arg0$iv);
        int n4 = Duration.getMinutesComponent-impl(arg0$iv);
        long hours = Duration.getInWholeHours-impl(arg0$iv);
        boolean bl4 = false;
        long hours2 = hours;
        if (Duration.isInfinite-impl(arg0)) {
            hours2 = 9999999999999L;
        }
        boolean hasHours = hours2 != 0L;
        boolean hasSeconds = seconds != false || nanoseconds != false;
        boolean bl5 = hasMinutes = minutes != false || hasSeconds && hasHours;
        if (hasHours) {
            $this$toIsoString_impl_u24lambda_u245.append(hours2).append('H');
        }
        if (hasMinutes) {
            $this$toIsoString_impl_u24lambda_u245.append((int)minutes).append('M');
        }
        if (hasSeconds || !hasHours && !hasMinutes) {
            Duration.appendFractional-impl(arg0, $this$toIsoString_impl_u24lambda_u245, (int)seconds, (int)nanoseconds, 9, "S", true);
        }
        return stringBuilder.toString();
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return Duration.hashCode-impl(this.rawValue);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof Duration)) {
            return false;
        }
        long l2 = ((Duration)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return Duration.equals-impl(this.rawValue, other);
    }

    private /* synthetic */ Duration(long rawValue) {
        this.rawValue = rawValue;
    }

    public static long constructor-impl(long rawValue) {
        long l2 = rawValue;
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (Duration.isInNanos-impl(l2)) {
                long l3 = Duration.getValue-impl(l2);
                if (!(-4611686018426999999L <= l3 ? l3 < 4611686018427000000L : false)) {
                    throw new AssertionError((Object)(Duration.getValue-impl(l2) + " ns is out of nanoseconds range"));
                }
            } else {
                long l4 = Duration.getValue-impl(l2);
                if (!(-4611686018427387903L <= l4 ? l4 < 0x4000000000000000L : false)) {
                    throw new AssertionError((Object)(Duration.getValue-impl(l2) + " ms is out of milliseconds range"));
                }
                l4 = Duration.getValue-impl(l2);
                boolean bl2 = -4611686018426L <= l4 ? l4 < 4611686018427L : false;
                if (bl2) {
                    throw new AssertionError((Object)(Duration.getValue-impl(l2) + " ms is denormalized"));
                }
            }
        }
        return l2;
    }

    public static final /* synthetic */ Duration box-impl(long v2) {
        return new Duration(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.rawValue;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201\u00a2\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201\u00a2\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201\u00a2\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201\u00a2\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d\u00a8\u0006:"}, d2={"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lkotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public final long getZERO-UwyO8pc() {
            return ZERO;
        }

        public final long getINFINITE-UwyO8pc() {
            return INFINITE;
        }

        public final long getNEG_INFINITE-UwyO8pc$kotlin_stdlib() {
            return NEG_INFINITE;
        }

        @ExperimentalTime
        public final double convert(double value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter((Object)sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter((Object)targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        private final long getNanoseconds-UwyO8pc(int $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getNanoseconds-UwyO8pc$annotations(int n2) {
        }

        private final long getNanoseconds-UwyO8pc(long $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getNanoseconds-UwyO8pc$annotations(long l2) {
        }

        private final long getNanoseconds-UwyO8pc(double $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getNanoseconds-UwyO8pc$annotations(double d2) {
        }

        private final long getMicroseconds-UwyO8pc(int $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMicroseconds-UwyO8pc$annotations(int n2) {
        }

        private final long getMicroseconds-UwyO8pc(long $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMicroseconds-UwyO8pc$annotations(long l2) {
        }

        private final long getMicroseconds-UwyO8pc(double $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMicroseconds-UwyO8pc$annotations(double d2) {
        }

        private final long getMilliseconds-UwyO8pc(int $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMilliseconds-UwyO8pc$annotations(int n2) {
        }

        private final long getMilliseconds-UwyO8pc(long $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMilliseconds-UwyO8pc$annotations(long l2) {
        }

        private final long getMilliseconds-UwyO8pc(double $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getMilliseconds-UwyO8pc$annotations(double d2) {
        }

        private final long getSeconds-UwyO8pc(int $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getSeconds-UwyO8pc$annotations(int n2) {
        }

        private final long getSeconds-UwyO8pc(long $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getSeconds-UwyO8pc$annotations(long l2) {
        }

        private final long getSeconds-UwyO8pc(double $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void getSeconds-UwyO8pc$annotations(double d2) {
        }

        private final long getMinutes-UwyO8pc(int $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        @InlineOnly
        public static /* synthetic */ void getMinutes-UwyO8pc$annotations(int n2) {
        }

        private final long getMinutes-UwyO8pc(long $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        @InlineOnly
        public static /* synthetic */ void getMinutes-UwyO8pc$annotations(long l2) {
        }

        private final long getMinutes-UwyO8pc(double $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        @InlineOnly
        public static /* synthetic */ void getMinutes-UwyO8pc$annotations(double d2) {
        }

        private final long getHours-UwyO8pc(int $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        @InlineOnly
        public static /* synthetic */ void getHours-UwyO8pc$annotations(int n2) {
        }

        private final long getHours-UwyO8pc(long $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        @InlineOnly
        public static /* synthetic */ void getHours-UwyO8pc$annotations(long l2) {
        }

        private final long getHours-UwyO8pc(double $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        @InlineOnly
        public static /* synthetic */ void getHours-UwyO8pc$annotations(double d2) {
        }

        private final long getDays-UwyO8pc(int $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        @InlineOnly
        public static /* synthetic */ void getDays-UwyO8pc$annotations(int n2) {
        }

        private final long getDays-UwyO8pc(long $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        @InlineOnly
        public static /* synthetic */ void getDays-UwyO8pc$annotations(long l2) {
        }

        private final long getDays-UwyO8pc(double $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        @InlineOnly
        public static /* synthetic */ void getDays-UwyO8pc$annotations(double d2) {
        }

        public final long parse-UwyO8pc(@NotNull String value) {
            long l2;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                l2 = DurationKt.access$parseDuration(value, false);
            }
            catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e2);
            }
            return l2;
        }

        public final long parseIsoString-UwyO8pc(@NotNull String value) {
            long l2;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                l2 = DurationKt.access$parseDuration(value, true);
            }
            catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e2);
            }
            return l2;
        }

        @Nullable
        public final Duration parseOrNull-FghU774(@NotNull String value) {
            Duration duration;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                duration = Duration.box-impl(DurationKt.access$parseDuration(value, false));
            }
            catch (IllegalArgumentException e2) {
                duration = null;
            }
            return duration;
        }

        @Nullable
        public final Duration parseIsoStringOrNull-FghU774(@NotNull String value) {
            Duration duration;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                duration = Duration.box-impl(DurationKt.access$parseDuration(value, true));
            }
            catch (IllegalArgumentException e2) {
                duration = null;
            }
            return duration;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

