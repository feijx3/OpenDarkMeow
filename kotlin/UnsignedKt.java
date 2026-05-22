/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 */
package kotlin;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001\u00a2\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001\u00a2\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u00a2\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b\u00a2\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b\u00a2\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0001\u001a\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\u0010#\u001a\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0000\u00a8\u0006("}, d2={"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "kotlin-stdlib"})
@JvmName(name="UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int uintRemainder-J1ME1BU(int v1, int v2) {
        return UInt.constructor-impl((int)(((long)v1 & 0xFFFFFFFFL) % ((long)v2 & 0xFFFFFFFFL)));
    }

    @PublishedApi
    public static final int uintDivide-J1ME1BU(int v1, int v2) {
        return UInt.constructor-impl((int)(((long)v1 & 0xFFFFFFFFL) / ((long)v2 & 0xFFFFFFFFL)));
    }

    @PublishedApi
    public static final long ulongDivide-eb3DHEI(long v1, long v2) {
        long quotient;
        long dividend = v1;
        long divisor = v2;
        if (divisor < 0L) {
            return Long.compareUnsigned(v1, v2) < 0 ? ULong.constructor-impl(0L) : ULong.constructor-impl(1L);
        }
        if (dividend >= 0L) {
            return ULong.constructor-impl(dividend / divisor);
        }
        long rem = dividend - (quotient = (dividend >>> 1) / divisor << 1) * divisor;
        return ULong.constructor-impl(quotient + (long)(Long.compareUnsigned(ULong.constructor-impl(rem), ULong.constructor-impl(divisor)) >= 0 ? 1 : 0));
    }

    @PublishedApi
    public static final long ulongRemainder-eb3DHEI(long v1, long v2) {
        long rem;
        long dividend = v1;
        long divisor = v2;
        if (divisor < 0L) {
            return Long.compareUnsigned(v1, v2) < 0 ? v1 : ULong.constructor-impl(v1 - v2);
        }
        if (dividend >= 0L) {
            return ULong.constructor-impl(dividend % divisor);
        }
        long quotient = (dividend >>> 1) / divisor << 1;
        return ULong.constructor-impl(rem - (Long.compareUnsigned(ULong.constructor-impl(rem = dividend - quotient * divisor), ULong.constructor-impl(divisor)) >= 0 ? divisor : 0L));
    }

    @PublishedApi
    public static final int uintCompare(int v1, int v2) {
        return Intrinsics.compare(v1 ^ Integer.MIN_VALUE, v2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int ulongCompare(long v1, long v2) {
        return Intrinsics.compare(v1 ^ Long.MIN_VALUE, v2 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToULong(int value) {
        return ULong.constructor-impl((long)value & 0xFFFFFFFFL);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToLong(int value) {
        return (long)value & 0xFFFFFFFFL;
    }

    @PublishedApi
    @InlineOnly
    private static final float uintToFloat(int value) {
        return (float)UnsignedKt.uintToDouble(value);
    }

    @PublishedApi
    @InlineOnly
    private static final int floatToUInt(float value) {
        return UnsignedKt.doubleToUInt(value);
    }

    @PublishedApi
    public static final double uintToDouble(int value) {
        return (double)(value & Integer.MAX_VALUE) + (double)(value >>> 31 << 30) * (double)2;
    }

    @PublishedApi
    public static final int doubleToUInt(double value) {
        return Double.isNaN(value) ? 0 : (value <= UnsignedKt.uintToDouble(0) ? 0 : (value >= UnsignedKt.uintToDouble(-1) ? -1 : (value <= 2.147483647E9 ? UInt.constructor-impl((int)value) : UInt.constructor-impl(UInt.constructor-impl((int)(value - (double)Integer.MAX_VALUE)) + UInt.constructor-impl(Integer.MAX_VALUE)))));
    }

    @PublishedApi
    @InlineOnly
    private static final float ulongToFloat(long value) {
        return (float)UnsignedKt.ulongToDouble(value);
    }

    @PublishedApi
    @InlineOnly
    private static final long floatToULong(float value) {
        return UnsignedKt.doubleToULong(value);
    }

    @PublishedApi
    public static final double ulongToDouble(long value) {
        return (double)(value >>> 11) * (double)2048 + (double)(value & 0x7FFL);
    }

    @PublishedApi
    public static final long doubleToULong(double value) {
        return Double.isNaN(value) ? 0L : (value <= UnsignedKt.ulongToDouble(0L) ? 0L : (value >= UnsignedKt.ulongToDouble(-1L) ? -1L : (value < 9.223372036854776E18 ? ULong.constructor-impl((long)value) : ULong.constructor-impl(ULong.constructor-impl((long)(value - 9.223372036854776E18)) + Long.MIN_VALUE))));
    }

    @InlineOnly
    private static final String uintToString(int value) {
        return String.valueOf((long)value & 0xFFFFFFFFL);
    }

    @InlineOnly
    private static final String uintToString(int value, int base) {
        return UnsignedKt.ulongToString((long)value & 0xFFFFFFFFL, base);
    }

    @InlineOnly
    private static final String ulongToString(long value) {
        return UnsignedKt.ulongToString(value, 10);
    }

    @NotNull
    public static final String ulongToString(long value, int base) {
        if (value >= 0L) {
            String string = Long.toString(value, CharsKt.checkRadix(base));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long quotient = (value >>> 1) / (long)base << 1;
        long rem = value - quotient * (long)base;
        if (rem >= (long)base) {
            rem -= (long)base;
            ++quotient;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string = Long.toString(quotient, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        StringBuilder stringBuilder2 = stringBuilder.append(string);
        String string2 = Long.toString(rem, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return stringBuilder2.append(string2).toString();
    }
}

