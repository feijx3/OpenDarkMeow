/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.DurationUnitKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1062:1\n1015#1,6:1064\n1018#1,3:1070\n1015#1,6:1073\n1015#1,6:1079\n1018#1,3:1085\n1#2:1063\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n930#1:1064,6\n964#1:1070,3\n967#1:1073,6\n970#1:1079,6\n1015#1:1085,3\n*E\n"})
public final class DurationKt {
    public static final int NANOS_IN_MILLIS = 1000000;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final long MAX_MILLIS = 0x3FFFFFFFFFFFFFFFL;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;

    @SinceKotlin(version="1.6")
    public static final long toDuration(int $this$toDuration, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        return unit.compareTo((Enum)DurationUnit.SECONDS) <= 0 ? DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS)) : DurationKt.toDuration((long)$this$toDuration, unit);
    }

    @SinceKotlin(version="1.6")
    public static final long toDuration(long $this$toDuration, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        long maxNsInUnit = DurationUnitKt.convertDurationUnitOverflow(4611686018426999999L, DurationUnit.NANOSECONDS, unit);
        boolean bl2 = -maxNsInUnit <= $this$toDuration ? $this$toDuration <= maxNsInUnit : false;
        if (bl2) {
            return DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        long millis = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS);
        return DurationKt.durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL));
    }

    @SinceKotlin(version="1.6")
    public static final long toDuration(double $this$toDuration, @NotNull DurationUnit unit) {
        long l2;
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        double valueInNs = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.NANOSECONDS);
        if (!(!Double.isNaN(valueInNs))) {
            boolean bl2 = false;
            String string = "Duration value cannot be NaN.";
            throw new IllegalArgumentException(string.toString());
        }
        long nanos = MathKt.roundToLong(valueInNs);
        boolean bl3 = -4611686018426999999L <= nanos ? nanos < 4611686018427000000L : false;
        if (bl3) {
            l2 = DurationKt.durationOfNanos(nanos);
        } else {
            long millis = MathKt.roundToLong(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS));
            l2 = DurationKt.durationOfMillisNormalized(millis);
        }
        return l2;
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final long times-mvk6XK0(int $this$times_u2dmvk6XK0, long duration) {
        return Duration.times-UwyO8pc(duration, $this$times_u2dmvk6XK0);
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final long times-kIfJnKk(double $this$times_u2dkIfJnKk, long duration) {
        return Duration.times-UwyO8pc(duration, $this$times_u2dkIfJnKk);
    }

    private static final long parseDuration(String value, boolean strictIso) {
        int length = value.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int index = 0;
        long result = Duration.Companion.getZERO-UwyO8pc();
        String infinityString = "Infinity";
        switch (value.charAt(index)) {
            case '+': 
            case '-': {
                ++index;
            }
        }
        boolean hasSign = index > 0;
        boolean isNegative = hasSign && StringsKt.startsWith$default((CharSequence)value, '-', false, 2, null);
        if (length <= index) {
            throw new IllegalArgumentException("No components");
        }
        if (value.charAt(index) == 'P') {
            if (++index == length) {
                throw new IllegalArgumentException();
            }
            String nonDigitSymbols = "+-.";
            boolean isTimeComponent = false;
            DurationUnit prevUnit = null;
            while (index < length) {
                String component;
                int i$iv$iv;
                if (value.charAt(index) == 'T') {
                    if (isTimeComponent || ++index == length) {
                        throw new IllegalArgumentException();
                    }
                    isTimeComponent = true;
                    continue;
                }
                String $this$substringWhile$iv = value;
                boolean $i$f$substringWhile22 = false;
                String string = $this$substringWhile$iv;
                String $this$skipWhile$iv$iv22 = $this$substringWhile$iv;
                boolean $i$f$skipWhile2 = false;
                for (i$iv$iv = index; i$iv$iv < $this$skipWhile$iv$iv22.length(); ++i$iv$iv) {
                    char it = $this$skipWhile$iv$iv22.charAt(i$iv$iv);
                    boolean bl2 = false;
                    boolean bl3 = '0' <= it ? it < ':' : false;
                    if (!(bl3 || StringsKt.contains$default((CharSequence)nonDigitSymbols, it, false, 2, null))) break;
                }
                int $this$skipWhile$iv$iv22 = i$iv$iv;
                Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
                Intrinsics.checkNotNullExpressionValue(string.substring(index, $this$skipWhile$iv$iv22), "substring(...)");
                if (((CharSequence)component).length() == 0) {
                    throw new IllegalArgumentException();
                }
                CharSequence $i$f$substringWhile22 = value;
                if (!(0 <= (index += component.length()) ? index < $i$f$substringWhile22.length() : false)) {
                    int it = index;
                    boolean bl4 = false;
                    throw new IllegalArgumentException("Missing unit for value " + component);
                }
                char unitChar = $i$f$substringWhile22.charAt(index);
                ++index;
                DurationUnit unit = DurationUnitKt.durationUnitByIsoChar(unitChar, isTimeComponent);
                if (prevUnit != null && prevUnit.compareTo((Enum)unit) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                prevUnit = unit;
                int dotIndex = StringsKt.indexOf$default((CharSequence)component, '.', 0, false, 6, null);
                if (unit == DurationUnit.SECONDS && dotIndex > 0) {
                    String whole;
                    String $i$f$skipWhile2 = component;
                    i$iv$iv = 0;
                    Intrinsics.checkNotNull($i$f$skipWhile2, "null cannot be cast to non-null type java.lang.String");
                    Intrinsics.checkNotNullExpressionValue($i$f$skipWhile2.substring(i$iv$iv, dotIndex), "substring(...)");
                    result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(DurationKt.parseOverLongIsoComponent(whole), unit));
                    String string2 = component;
                    Intrinsics.checkNotNull(string2, "null cannot be cast to non-null type java.lang.String");
                    String string3 = string2.substring(dotIndex);
                    Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
                    result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(Double.parseDouble(string3), unit));
                    continue;
                }
                result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(DurationKt.parseOverLongIsoComponent(component), unit));
            }
        } else {
            if (strictIso) {
                throw new IllegalArgumentException();
            }
            int nonDigitSymbols = length - index;
            int isTimeComponent = infinityString.length();
            if (StringsKt.regionMatches(value, index, infinityString, 0, Math.max(nonDigitSymbols, isTimeComponent), true)) {
                result = Duration.Companion.getINFINITE-UwyO8pc();
            } else {
                boolean allowSpaces;
                DurationUnit prevUnit = null;
                boolean afterFirst = false;
                boolean bl5 = allowSpaces = !hasSign;
                if (hasSign && value.charAt(index) == '(' && StringsKt.last(value) == ')') {
                    allowSpaces = true;
                    if (++index == --length) {
                        throw new IllegalArgumentException("No components");
                    }
                }
                while (index < length) {
                    String unitName;
                    int i$iv$iv;
                    String component;
                    int i$iv$iv2;
                    if (afterFirst && allowSpaces) {
                        int i$iv;
                        String $this$skipWhile$iv = value;
                        boolean $i$f$skipWhile = false;
                        for (i$iv = index; i$iv < $this$skipWhile$iv.length(); ++i$iv) {
                            char it = $this$skipWhile$iv.charAt(i$iv);
                            boolean bl6 = false;
                            if (!(it == ' ')) break;
                        }
                        index = i$iv;
                    }
                    afterFirst = true;
                    String $this$substringWhile$iv = value;
                    boolean $i$f$substringWhile = false;
                    String it = $this$substringWhile$iv;
                    String $this$skipWhile$iv$iv422 = $this$substringWhile$iv;
                    boolean $i$f$skipWhile = false;
                    for (i$iv$iv2 = index; i$iv$iv2 < $this$skipWhile$iv$iv422.length(); ++i$iv$iv2) {
                        char it2 = $this$skipWhile$iv$iv422.charAt(i$iv$iv2);
                        boolean bl7 = false;
                        boolean bl8 = '0' <= it2 ? it2 < ':' : false;
                        if (!(bl8 || it2 == '.')) break;
                    }
                    int $this$skipWhile$iv$iv422 = i$iv$iv2;
                    Intrinsics.checkNotNull(it, "null cannot be cast to non-null type java.lang.String");
                    Intrinsics.checkNotNullExpressionValue(it.substring(index, $this$skipWhile$iv$iv422), "substring(...)");
                    if (((CharSequence)component).length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    index += component.length();
                    String $this$substringWhile$iv2 = value;
                    boolean $i$f$substringWhile2 = false;
                    String $this$skipWhile$iv$iv422 = $this$substringWhile$iv2;
                    String $this$skipWhile$iv$iv = $this$substringWhile$iv2;
                    boolean $i$f$skipWhile3 = false;
                    for (i$iv$iv = index; i$iv$iv < $this$skipWhile$iv$iv.length(); ++i$iv$iv) {
                        char it3 = $this$skipWhile$iv$iv.charAt(i$iv$iv);
                        boolean bl9 = false;
                        boolean bl10 = 'a' <= it3 ? it3 < '{' : false;
                        if (!bl10) break;
                    }
                    int n2 = i$iv$iv;
                    Intrinsics.checkNotNull($this$skipWhile$iv$iv422, "null cannot be cast to non-null type java.lang.String");
                    Intrinsics.checkNotNullExpressionValue($this$skipWhile$iv$iv422.substring(index, n2), "substring(...)");
                    index += unitName.length();
                    DurationUnit unit = DurationUnitKt.durationUnitByShortName(unitName);
                    if (prevUnit != null && prevUnit.compareTo((Enum)unit) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    prevUnit = unit;
                    int dotIndex = StringsKt.indexOf$default((CharSequence)component, '.', 0, false, 6, null);
                    if (dotIndex > 0) {
                        String whole;
                        String string = component;
                        int n3 = 0;
                        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
                        Intrinsics.checkNotNullExpressionValue(string.substring(n3, dotIndex), "substring(...)");
                        result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(Long.parseLong(whole), unit));
                        String string4 = component;
                        Intrinsics.checkNotNull(string4, "null cannot be cast to non-null type java.lang.String");
                        String string5 = string4.substring(dotIndex);
                        Intrinsics.checkNotNullExpressionValue(string5, "substring(...)");
                        result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(Double.parseDouble(string5), unit));
                        if (index >= length) continue;
                        throw new IllegalArgumentException("Fractional component must be last");
                    }
                    result = Duration.plus-LRDsOJo(result, DurationKt.toDuration(Long.parseLong(component), unit));
                }
            }
        }
        return isNegative ? Duration.unaryMinus-UwyO8pc(result) : result;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final long parseOverLongIsoComponent(String value) {
        long l2;
        int n2;
        int length;
        block8: {
            length = value.length();
            int startIndex = 0;
            if (length > 0 && StringsKt.contains$default((CharSequence)"+-", value.charAt(0), false, 2, null)) {
                n2 = startIndex;
                startIndex = n2 + 1;
            }
            if (length - startIndex > 16) {
                boolean bl2 = false;
                int firstNonZero = startIndex;
                for (int index = startIndex; index < length; ++index) {
                    char c2 = value.charAt(index);
                    if (c2 == '0') {
                        if (firstNonZero != index) continue;
                        ++firstNonZero;
                        continue;
                    }
                    boolean bl3 = '1' <= c2 ? c2 < ':' : false;
                    if (bl3) {
                        continue;
                    }
                    break block8;
                }
                if (length - firstNonZero > 16) {
                    if (value.charAt(0) != '-') return Long.MAX_VALUE;
                    return Long.MIN_VALUE;
                }
            }
        }
        if (StringsKt.startsWith$default(value, "+", false, 2, null) && length > 1) {
            n2 = value.charAt(1);
            boolean bl4 = 48 <= n2 ? n2 < 58 : false;
            if (bl4) {
                l2 = Long.parseLong(StringsKt.drop(value, 1));
                return l2;
            }
        }
        l2 = Long.parseLong(value);
        return l2;
    }

    private static final String substringWhile(String $this$substringWhile, int startIndex, Function1<? super Character, Boolean> predicate) {
        int i$iv;
        boolean $i$f$substringWhile = false;
        String string = $this$substringWhile;
        String $this$skipWhile$iv = $this$substringWhile;
        boolean $i$f$skipWhile = false;
        for (i$iv = startIndex; i$iv < $this$skipWhile$iv.length() && predicate.invoke(Character.valueOf($this$skipWhile$iv.charAt(i$iv))).booleanValue(); ++i$iv) {
        }
        int n2 = i$iv;
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string2 = string.substring(startIndex, n2);
        Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
        return string2;
    }

    private static final int skipWhile(String $this$skipWhile, int startIndex, Function1<? super Character, Boolean> predicate) {
        int i2;
        boolean $i$f$skipWhile = false;
        for (i2 = startIndex; i2 < $this$skipWhile.length() && predicate.invoke(Character.valueOf($this$skipWhile.charAt(i2))).booleanValue(); ++i2) {
        }
        return i2;
    }

    private static final long nanosToMillis(long nanos) {
        return nanos / (long)1000000;
    }

    private static final long millisToNanos(long millis) {
        return millis * (long)1000000;
    }

    private static final long durationOfNanos(long normalNanos) {
        return Duration.constructor-impl(normalNanos << 1);
    }

    private static final long durationOfMillis(long normalMillis) {
        return Duration.constructor-impl((normalMillis << 1) + 1L);
    }

    private static final long durationOf(long normalValue, int unitDiscriminator) {
        return Duration.constructor-impl((normalValue << 1) + (long)unitDiscriminator);
    }

    private static final long durationOfNanosNormalized(long nanos) {
        return (-4611686018426999999L <= nanos ? nanos < 4611686018427000000L : false) ? DurationKt.durationOfNanos(nanos) : DurationKt.durationOfMillis(DurationKt.nanosToMillis(nanos));
    }

    private static final long durationOfMillisNormalized(long millis) {
        return (-4611686018426L <= millis ? millis < 4611686018427L : false) ? DurationKt.durationOfNanos(DurationKt.millisToNanos(millis)) : DurationKt.durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL));
    }

    public static final /* synthetic */ long access$parseDuration(String value, boolean strictIso) {
        return DurationKt.parseDuration(value, strictIso);
    }

    public static final /* synthetic */ long access$durationOf(long normalValue, int unitDiscriminator) {
        return DurationKt.durationOf(normalValue, unitDiscriminator);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long nanos) {
        return DurationKt.durationOfNanosNormalized(nanos);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long millis) {
        return DurationKt.durationOfMillisNormalized(millis);
    }

    public static final /* synthetic */ long access$nanosToMillis(long nanos) {
        return DurationKt.nanosToMillis(nanos);
    }

    public static final /* synthetic */ long access$millisToNanos(long millis) {
        return DurationKt.millisToNanos(millis);
    }

    public static final /* synthetic */ long access$durationOfNanos(long normalNanos) {
        return DurationKt.durationOfNanos(normalNanos);
    }

    public static final /* synthetic */ long access$durationOfMillis(long normalMillis) {
        return DurationKt.durationOfMillis(normalMillis);
    }
}

