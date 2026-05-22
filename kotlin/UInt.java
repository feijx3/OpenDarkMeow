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
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b\u0016\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b\u0018\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b\u001d\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b\u001f\u0010\u001aJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b!\u0010\fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b\"\u0010\u000fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b#\u0010\u0011J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b$\u0010\u001aJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b&\u0010\fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b'\u0010\u000fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b(\u0010\u0011J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b)\u0010\u001aJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n\u00a2\u0006\u0004\b+\u0010\fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00a2\u0006\u0004\b,\u0010\u000fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b-\u0010\u0011J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n\u00a2\u0006\u0004\b.\u0010\u001aJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\b\u00a2\u0006\u0004\b0\u0010\fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b1\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\b2\u0010\u0011J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b\u00a2\u0006\u0004\b3\u0010\u001aJ\u0018\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0087\b\u00a2\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b7\u00108J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\b9\u0010\u0011J\u0018\u00104\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b\u00a2\u0006\u0004\b:\u0010\u001aJ\u0010\u0010;\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b<\u0010\u0005J\u0010\u0010=\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\b>\u0010\u0005J\u0018\u0010?\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010C\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00a2\u0006\u0004\bD\u0010BJ\u0018\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f\u00a2\u0006\u0004\bG\u0010\u0011J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f\u00a2\u0006\u0004\bI\u0010\u0011J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bK\u0010\u0011J\u0018\u0010L\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bM\u0010\u0011J\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00a2\u0006\u0004\bO\u0010\u0011J\u0010\u0010P\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\bQ\u0010\u0005J\u0010\u0010R\u001a\u00020SH\u0087\b\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\b[\u0010\u0005J\u0010\u0010\\\u001a\u00020]H\u0087\b\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\nH\u0087\b\u00a2\u0006\u0004\ba\u0010UJ\u0010\u0010b\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\bc\u0010YJ\u0010\u0010d\u001a\u00020\u0000H\u0087\b\u00a2\u0006\u0004\be\u0010\u0005J\u0010\u0010f\u001a\u00020\u0012H\u0087\b\u00a2\u0006\u0004\bg\u0010_J\u0010\u0010h\u001a\u00020iH\u0087\b\u00a2\u0006\u0004\bj\u0010kJ\u0010\u0010l\u001a\u00020mH\u0087\b\u00a2\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016\u00a2\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020u2\b\u0010\t\u001a\u0004\u0018\u00010vH\u00d6\u0003J\t\u0010w\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00a8\u0006y"}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
public final class UInt
implements Comparable<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int data;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = -1;
    public static final int SIZE_BYTES = 4;
    public static final int SIZE_BITS = 32;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static final int compareTo-7apg3OU(int arg0, byte other) {
        return Integer.compareUnsigned(arg0, UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int compareTo-xj2QHRw(int arg0, short other) {
        return Integer.compareUnsigned(arg0, UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static int compareTo-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintCompare(arg0, other);
    }

    @InlineOnly
    private int compareTo-WZ4Q5Ns(int other) {
        return UnsignedKt.uintCompare(this.unbox-impl(), other);
    }

    @InlineOnly
    private static final int compareTo-VKZWuLQ(int arg0, long other) {
        return Long.compareUnsigned(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL), other);
    }

    @InlineOnly
    private static final int plus-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(arg0 + UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int plus-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(arg0 + UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int plus-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 + other);
    }

    @InlineOnly
    private static final long plus-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL) + other);
    }

    @InlineOnly
    private static final int minus-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(arg0 - UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int minus-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(arg0 - UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int minus-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 - other);
    }

    @InlineOnly
    private static final long minus-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL) - other);
    }

    @InlineOnly
    private static final int times-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(arg0 * UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int times-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(arg0 * UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int times-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 * other);
    }

    @InlineOnly
    private static final long times-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL) * other);
    }

    @InlineOnly
    private static final int div-7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int div-xj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int div-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintDivide-J1ME1BU(arg0, other);
    }

    @InlineOnly
    private static final long div-VKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL), other);
    }

    @InlineOnly
    private static final int rem-7apg3OU(int arg0, byte other) {
        return Integer.remainderUnsigned(arg0, UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int rem-xj2QHRw(int arg0, short other) {
        return Integer.remainderUnsigned(arg0, UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int rem-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintRemainder-J1ME1BU(arg0, other);
    }

    @InlineOnly
    private static final long rem-VKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL), other);
    }

    @InlineOnly
    private static final int floorDiv-7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 0xFF));
    }

    @InlineOnly
    private static final int floorDiv-xj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 0xFFFF));
    }

    @InlineOnly
    private static final int floorDiv-WZ4Q5Ns(int arg0, int other) {
        return Integer.divideUnsigned(arg0, other);
    }

    @InlineOnly
    private static final long floorDiv-VKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL), other);
    }

    @InlineOnly
    private static final byte mod-7apg3OU(int arg0, byte other) {
        return UByte.constructor-impl((byte)Integer.remainderUnsigned(arg0, UInt.constructor-impl(other & 0xFF)));
    }

    @InlineOnly
    private static final short mod-xj2QHRw(int arg0, short other) {
        return UShort.constructor-impl((short)Integer.remainderUnsigned(arg0, UInt.constructor-impl(other & 0xFFFF)));
    }

    @InlineOnly
    private static final int mod-WZ4Q5Ns(int arg0, int other) {
        return Integer.remainderUnsigned(arg0, other);
    }

    @InlineOnly
    private static final long mod-VKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL), other);
    }

    @InlineOnly
    private static final int inc-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 + 1);
    }

    @InlineOnly
    private static final int dec-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 + -1);
    }

    @InlineOnly
    private static final UIntRange rangeTo-WZ4Q5Ns(int arg0, int other) {
        return new UIntRange(arg0, other, null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final UIntRange rangeUntil-WZ4Q5Ns(int arg0, int other) {
        return URangesKt.until-J1ME1BU(arg0, other);
    }

    @InlineOnly
    private static final int shl-pVg5ArA(int arg0, int bitCount) {
        return UInt.constructor-impl(arg0 << bitCount);
    }

    @InlineOnly
    private static final int shr-pVg5ArA(int arg0, int bitCount) {
        return UInt.constructor-impl(arg0 >>> bitCount);
    }

    @InlineOnly
    private static final int and-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 & other);
    }

    @InlineOnly
    private static final int or-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 | other);
    }

    @InlineOnly
    private static final int xor-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 ^ other);
    }

    @InlineOnly
    private static final int inv-pVg5ArA(int arg0) {
        return UInt.constructor-impl(~arg0);
    }

    @InlineOnly
    private static final byte toByte-impl(int arg0) {
        return (byte)arg0;
    }

    @InlineOnly
    private static final short toShort-impl(int arg0) {
        return (short)arg0;
    }

    @InlineOnly
    private static final int toInt-impl(int arg0) {
        return arg0;
    }

    @InlineOnly
    private static final long toLong-impl(int arg0) {
        return (long)arg0 & 0xFFFFFFFFL;
    }

    @InlineOnly
    private static final byte toUByte-w2LRezQ(int arg0) {
        return UByte.constructor-impl((byte)arg0);
    }

    @InlineOnly
    private static final short toUShort-Mh2AYeg(int arg0) {
        return UShort.constructor-impl((short)arg0);
    }

    @InlineOnly
    private static final int toUInt-pVg5ArA(int arg0) {
        return arg0;
    }

    @InlineOnly
    private static final long toULong-s-VKNKU(int arg0) {
        return ULong.constructor-impl((long)arg0 & 0xFFFFFFFFL);
    }

    @InlineOnly
    private static final float toFloat-impl(int arg0) {
        return (float)UnsignedKt.uintToDouble(arg0);
    }

    @InlineOnly
    private static final double toDouble-impl(int arg0) {
        return UnsignedKt.uintToDouble(arg0);
    }

    @NotNull
    public static String toString-impl(int arg0) {
        return String.valueOf((long)arg0 & 0xFFFFFFFFL);
    }

    @NotNull
    public String toString() {
        return UInt.toString-impl(this.data);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public int hashCode() {
        return UInt.hashCode-impl(this.data);
    }

    public static boolean equals-impl(int arg0, Object other) {
        if (!(other instanceof UInt)) {
            return false;
        }
        int n2 = ((UInt)other).unbox-impl();
        return arg0 == n2;
    }

    public boolean equals(Object other) {
        return UInt.equals-impl(this.data, other);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ UInt(int data) {
        this.data = data;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static int constructor-impl(int data) {
        return data;
    }

    public static final /* synthetic */ UInt box-impl(int v2) {
        return new UInt(v2);
    }

    public final /* synthetic */ int unbox-impl() {
        return this.data;
    }

    public static final boolean equals-impl0(int p1, int p2) {
        return p1 == p2;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

