/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExperimentalStdlibApi
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.WasExperimental
 *  kotlin.internal.InlineOnly
 *  kotlin.internal.IntrinsicConstEvaluation
 *  kotlin.jvm.JvmInline
 *  org.jetbrains.annotations.NotNull
 */
package kotlin;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b \u0010\u0018J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b!\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b#\u0010\u001eJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b%\u0010\u0018J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b&\u0010\u001aJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b'\u0010\u001cJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b(\u0010\u001eJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b*\u0010\u0018J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b+\u0010\u001aJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b,\u0010\u001cJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b-\u0010\u001eJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u00a2\u0006\u0004\b/\u0010\u0018J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u00a2\u0006\u0004\b0\u0010\u001aJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n\u00a2\u0006\u0004\b1\u0010\u001cJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b2\u0010\u001eJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u00a2\u0006\u0004\b4\u0010\u0018J\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\b\u00a2\u0006\u0004\b5\u0010\u001aJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b6\u0010\u001cJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\b7\u0010\u001eJ\u0018\u00108\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u00a2\u0006\u0004\b9\u0010:J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000eH\u0087\b\u00a2\u0006\u0004\b;\u0010<J\u0018\u00108\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011H\u0087\b\u00a2\u0006\u0004\b=\u0010\u0013J\u0018\u00108\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\b>\u0010\u001eJ\u0010\u0010?\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b@\u0010\u0005J\u0010\u0010A\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\bB\u0010\u0005J\u0018\u0010C\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\bH\u0010FJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f\u00a2\u0006\u0004\bK\u0010\u001cJ\u0018\u0010L\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f\u00a2\u0006\u0004\bM\u0010\u001cJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bO\u0010\u001eJ\u0018\u0010P\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bQ\u0010\u001eJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bS\u0010\u001eJ\u0010\u0010T\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\tH\u0087\b\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020\u000bH\u0087\b\u00a2\u0006\u0004\bd\u0010YJ\u0010\u0010e\u001a\u00020\u000eH\u0087\b\u00a2\u0006\u0004\bf\u0010]J\u0010\u0010g\u001a\u00020\u0011H\u0087\b\u00a2\u0006\u0004\bh\u0010`J\u0010\u0010i\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\bj\u0010\u0005J\u0010\u0010k\u001a\u00020lH\u0087\b\u00a2\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020pH\u0087\b\u00a2\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020tH\u0016\u00a2\u0006\u0004\bu\u0010vJ\u0013\u0010w\u001a\u00020x2\b\u0010\n\u001a\u0004\u0018\u00010yH\u00d6\u0003J\t\u0010z\u001a\u00020\tH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00a8\u0006|"}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", "", "toByte-impl", "(J)B", "toShort", "", "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(J)F", "toDouble", "", "toDouble-impl", "(J)D", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
public final class ULong
implements Comparable<ULong> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long data;
    public static final long MIN_VALUE = 0L;
    public static final long MAX_VALUE = -1L;
    public static final int SIZE_BYTES = 8;
    public static final int SIZE_BITS = 64;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static final int compareTo-7apg3OU(long arg0, byte other) {
        return Long.compareUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final int compareTo-xj2QHRw(long arg0, short other) {
        return Long.compareUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final int compareTo-WZ4Q5Ns(long arg0, int other) {
        return Long.compareUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static int compareTo-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongCompare(arg0, other);
    }

    @InlineOnly
    private int compareTo-VKZWuLQ(long other) {
        return UnsignedKt.ulongCompare(this.unbox-impl(), other);
    }

    @InlineOnly
    private static final long plus-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(arg0 + ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long plus-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(arg0 + ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long plus-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(arg0 + ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long plus-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 + other);
    }

    @InlineOnly
    private static final long minus-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(arg0 - ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long minus-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(arg0 - ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long minus-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(arg0 - ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long minus-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 - other);
    }

    @InlineOnly
    private static final long times-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(arg0 * ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long times-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(arg0 * ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long times-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(arg0 * ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long times-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 * other);
    }

    @InlineOnly
    private static final long div-7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long div-xj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long div-WZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long div-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongDivide-eb3DHEI(arg0, other);
    }

    @InlineOnly
    private static final long rem-7apg3OU(long arg0, byte other) {
        return Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long rem-xj2QHRw(long arg0, short other) {
        return Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long rem-WZ4Q5Ns(long arg0, int other) {
        return Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long rem-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongRemainder-eb3DHEI(arg0, other);
    }

    @InlineOnly
    private static final long floorDiv-7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFL));
    }

    @InlineOnly
    private static final long floorDiv-xj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFL));
    }

    @InlineOnly
    private static final long floorDiv-WZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long floorDiv-VKZWuLQ(long arg0, long other) {
        return Long.divideUnsigned(arg0, other);
    }

    @InlineOnly
    private static final byte mod-7apg3OU(long arg0, byte other) {
        return UByte.constructor-impl((byte)Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFL)));
    }

    @InlineOnly
    private static final short mod-xj2QHRw(long arg0, short other) {
        return UShort.constructor-impl((short)Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFL)));
    }

    @InlineOnly
    private static final int mod-WZ4Q5Ns(long arg0, int other) {
        return UInt.constructor-impl((int)Long.remainderUnsigned(arg0, ULong.constructor-impl((long)other & 0xFFFFFFFFL)));
    }

    @InlineOnly
    private static final long mod-VKZWuLQ(long arg0, long other) {
        return Long.remainderUnsigned(arg0, other);
    }

    @InlineOnly
    private static final long inc-s-VKNKU(long arg0) {
        return ULong.constructor-impl(arg0 + 1L);
    }

    @InlineOnly
    private static final long dec-s-VKNKU(long arg0) {
        return ULong.constructor-impl(arg0 + -1L);
    }

    @InlineOnly
    private static final ULongRange rangeTo-VKZWuLQ(long arg0, long other) {
        return new ULongRange(arg0, other, null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final ULongRange rangeUntil-VKZWuLQ(long arg0, long other) {
        return URangesKt.until-eb3DHEI(arg0, other);
    }

    @InlineOnly
    private static final long shl-s-VKNKU(long arg0, int bitCount) {
        return ULong.constructor-impl(arg0 << bitCount);
    }

    @InlineOnly
    private static final long shr-s-VKNKU(long arg0, int bitCount) {
        return ULong.constructor-impl(arg0 >>> bitCount);
    }

    @InlineOnly
    private static final long and-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 & other);
    }

    @InlineOnly
    private static final long or-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 | other);
    }

    @InlineOnly
    private static final long xor-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 ^ other);
    }

    @InlineOnly
    private static final long inv-s-VKNKU(long arg0) {
        return ULong.constructor-impl(arg0 ^ 0xFFFFFFFFFFFFFFFFL);
    }

    @InlineOnly
    private static final byte toByte-impl(long arg0) {
        return (byte)arg0;
    }

    @InlineOnly
    private static final short toShort-impl(long arg0) {
        return (short)arg0;
    }

    @InlineOnly
    private static final int toInt-impl(long arg0) {
        return (int)arg0;
    }

    @InlineOnly
    private static final long toLong-impl(long arg0) {
        return arg0;
    }

    @InlineOnly
    private static final byte toUByte-w2LRezQ(long arg0) {
        return UByte.constructor-impl((byte)arg0);
    }

    @InlineOnly
    private static final short toUShort-Mh2AYeg(long arg0) {
        return UShort.constructor-impl((short)arg0);
    }

    @InlineOnly
    private static final int toUInt-pVg5ArA(long arg0) {
        return UInt.constructor-impl((int)arg0);
    }

    @InlineOnly
    private static final long toULong-s-VKNKU(long arg0) {
        return arg0;
    }

    @InlineOnly
    private static final float toFloat-impl(long arg0) {
        return (float)UnsignedKt.ulongToDouble(arg0);
    }

    @InlineOnly
    private static final double toDouble-impl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    @NotNull
    public static String toString-impl(long arg0) {
        return UnsignedKt.ulongToString(arg0, 10);
    }

    @NotNull
    public String toString() {
        return ULong.toString-impl(this.data);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return ULong.hashCode-impl(this.data);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof ULong)) {
            return false;
        }
        long l2 = ((ULong)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return ULong.equals-impl(this.data, other);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ ULong(long data) {
        this.data = data;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static long constructor-impl(long data) {
        return data;
    }

    public static final /* synthetic */ ULong box-impl(long v2) {
        return new ULong(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.data;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/ULong$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/ULong;", "J", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

