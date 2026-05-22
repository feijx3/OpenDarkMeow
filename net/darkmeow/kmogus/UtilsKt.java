/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.kmogus;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\u001a\u0006\u0010E\u001a\u00020C\u001a\u0006\u0010F\u001a\u00020G\u001a\u0006\u0010H\u001a\u00020I\u001a\u0006\u0010J\u001a\u00020K\u001a\u0006\u0010L\u001a\u00020M\u001a\u0006\u0010N\u001a\u00020O\u001a\u0006\u0010P\u001a\u00020Q\u001a%\u0010R\u001a\u00020C*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010C\u00a2\u0006\u0004\bV\u0010W\u001a\u0019\u0010R\u001a\u00020C*\u00020S2\u0006\u0010X\u001a\u00020C\u00a2\u0006\u0004\bY\u0010Z\u001a%\u0010[\u001a\u00020G*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\b\\\u0010]\u001a\u0019\u0010[\u001a\u00020G*\u00020S2\u0006\u0010X\u001a\u00020G\u00a2\u0006\u0004\b^\u0010_\u001a%\u0010`\u001a\u00020I*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\ba\u0010b\u001a\u0019\u0010`\u001a\u00020I*\u00020S2\u0006\u0010X\u001a\u00020I\u00a2\u0006\u0004\bc\u0010d\u001a%\u0010e\u001a\u00020K*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bf\u0010g\u001a\u0019\u0010e\u001a\u00020K*\u00020S2\u0006\u0010X\u001a\u00020K\u00a2\u0006\u0004\bh\u0010i\u001a%\u0010j\u001a\u00020M*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bk\u0010l\u001a\u0019\u0010j\u001a\u00020M*\u00020S2\u0006\u0010X\u001a\u00020M\u00a2\u0006\u0004\bm\u0010n\u001a%\u0010o\u001a\u00020O*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bp\u0010q\u001a\u0019\u0010o\u001a\u00020O*\u00020S2\u0006\u0010X\u001a\u00020O\u00a2\u0006\u0004\br\u0010s\u001a%\u0010t\u001a\u00020Q*\u00020S2\u0006\u0010T\u001a\u00020 2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bu\u0010v\u001a\u0019\u0010t\u001a\u00020Q*\u00020S2\u0006\u0010X\u001a\u00020Q\u00a2\u0006\u0004\bw\u0010x\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0014\u0010\u000e\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0014\u0010\u0010\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0014\u0010\u0012\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"(\u0010\u001a\u001a\u00020\u0005*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00058@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\"(\u0010!\u001a\u00020 *\u00020\u001b2\u0006\u0010\u0019\u001a\u00020 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"(\u0010&\u001a\u00020 *\u00020\u001b2\u0006\u0010\u0019\u001a\u00020 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%\"(\u0010)\u001a\u00020 *\u00020\u001b2\u0006\u0010\u0019\u001a\u00020 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%\"(\u0010,\u001a\u00020 *\u00020\u001b2\u0006\u0010\u0019\u001a\u00020 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%\"\u0018\u0010/\u001a\u00020\u0005*\u00020\u001b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001d\"\u0015\u00101\u001a\u00020\u0005*\u0002028F\u00a2\u0006\u0006\u001a\u0004\b3\u00104\"\u0015\u00101\u001a\u00020\u0005*\u0002058F\u00a2\u0006\u0006\u001a\u0004\b3\u00106\"\u0015\u00101\u001a\u00020\u0005*\u0002078F\u00a2\u0006\u0006\u001a\u0004\b3\u00108\"\u0015\u00101\u001a\u00020\u0005*\u0002098F\u00a2\u0006\u0006\u001a\u0004\b3\u0010:\"\u0015\u00101\u001a\u00020\u0005*\u00020;8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010<\"\u0015\u00101\u001a\u00020\u0005*\u00020=8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010>\"\u0015\u00101\u001a\u00020\u0005*\u00020?8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010@\"\u001c\u0010A\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010C0C0BX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006y"}, d2={"UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE", "()Lsun/misc/Unsafe;", "BYTE_ARRAY_OFFSET", "", "getBYTE_ARRAY_OFFSET", "()J", "SHORT_ARRAY_OFFSET", "getSHORT_ARRAY_OFFSET", "CHAR_ARRAY_OFFSET", "getCHAR_ARRAY_OFFSET", "INT_ARRAY_OFFSET", "getINT_ARRAY_OFFSET", "LONG_ARRAY_OFFSET", "getLONG_ARRAY_OFFSET", "FLOAT_ARRAY_OFFSET", "getFLOAT_ARRAY_OFFSET", "DOUBLE_ARRAY_OFFSET", "getDOUBLE_ARRAY_OFFSET", "ADDRESS_OFFSET", "POSITION_OFFSET", "MARK_OFFSET", "LIMIT_OFFSET", "CAPACITY_OFFSET", "value", "address", "Ljava/nio/Buffer;", "getAddress", "(Ljava/nio/Buffer;)J", "setAddress", "(Ljava/nio/Buffer;J)V", "", "position", "getPosition", "(Ljava/nio/Buffer;)I", "setPosition", "(Ljava/nio/Buffer;I)V", "mark", "getMark", "setMark", "limit", "getLimit", "setLimit", "capacity", "getCapacity", "setCapacity", "byteCapacity", "getByteCapacity", "byteLength", "", "getByteLength", "([B)J", "", "([S)J", "", "([C)J", "", "([I)J", "", "([J)J", "", "([F)J", "", "([D)J", "DIRECT_BYTE_BUFFER_CLASS", "Ljava/lang/Class;", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "nullByteBuffer", "nullShortBuffer", "Ljava/nio/ShortBuffer;", "nullCharBuffer", "Ljava/nio/CharBuffer;", "nullIntBuffer", "Ljava/nio/IntBuffer;", "nullLongBuffer", "Ljava/nio/LongBuffer;", "nullFloatBuffer", "Ljava/nio/FloatBuffer;", "nullDoubleBuffer", "Ljava/nio/DoubleBuffer;", "asByteBuffer", "Lnet/darkmeow/kmogus/Ptr;", "size", "oldBuffer", "asByteBuffer-n7w3U7I", "(JILjava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "buffer", "asByteBuffer-FPr3vG0", "(JLjava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "asShortBuffer", "asShortBuffer-n7w3U7I", "(JILjava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;", "asShortBuffer-FPr3vG0", "(JLjava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;", "asCharBuffer", "asCharBuffer-n7w3U7I", "(JILjava/nio/CharBuffer;)Ljava/nio/CharBuffer;", "asCharBuffer-FPr3vG0", "(JLjava/nio/CharBuffer;)Ljava/nio/CharBuffer;", "asIntBuffer", "asIntBuffer-n7w3U7I", "(JILjava/nio/IntBuffer;)Ljava/nio/IntBuffer;", "asIntBuffer-FPr3vG0", "(JLjava/nio/IntBuffer;)Ljava/nio/IntBuffer;", "asLongBuffer", "asLongBuffer-n7w3U7I", "(JILjava/nio/LongBuffer;)Ljava/nio/LongBuffer;", "asLongBuffer-FPr3vG0", "(JLjava/nio/LongBuffer;)Ljava/nio/LongBuffer;", "asFloatBuffer", "asFloatBuffer-n7w3U7I", "(JILjava/nio/FloatBuffer;)Ljava/nio/FloatBuffer;", "asFloatBuffer-FPr3vG0", "(JLjava/nio/FloatBuffer;)Ljava/nio/FloatBuffer;", "asDoubleBuffer", "asDoubleBuffer-n7w3U7I", "(JILjava/nio/DoubleBuffer;)Ljava/nio/DoubleBuffer;", "asDoubleBuffer-FPr3vG0", "(JLjava/nio/DoubleBuffer;)Ljava/nio/DoubleBuffer;", "kmogus-core"})
public final class UtilsKt {
    @NotNull
    private static final Unsafe UNSAFE;
    private static final long BYTE_ARRAY_OFFSET;
    private static final long SHORT_ARRAY_OFFSET;
    private static final long CHAR_ARRAY_OFFSET;
    private static final long INT_ARRAY_OFFSET;
    private static final long LONG_ARRAY_OFFSET;
    private static final long FLOAT_ARRAY_OFFSET;
    private static final long DOUBLE_ARRAY_OFFSET;
    private static final long ADDRESS_OFFSET;
    private static final long POSITION_OFFSET;
    private static final long MARK_OFFSET;
    private static final long LIMIT_OFFSET;
    private static final long CAPACITY_OFFSET;
    @NotNull
    private static final Class<ByteBuffer> DIRECT_BYTE_BUFFER_CLASS;

    @NotNull
    public static final Unsafe getUNSAFE() {
        return UNSAFE;
    }

    public static final long getBYTE_ARRAY_OFFSET() {
        return BYTE_ARRAY_OFFSET;
    }

    public static final long getSHORT_ARRAY_OFFSET() {
        return SHORT_ARRAY_OFFSET;
    }

    public static final long getCHAR_ARRAY_OFFSET() {
        return CHAR_ARRAY_OFFSET;
    }

    public static final long getINT_ARRAY_OFFSET() {
        return INT_ARRAY_OFFSET;
    }

    public static final long getLONG_ARRAY_OFFSET() {
        return LONG_ARRAY_OFFSET;
    }

    public static final long getFLOAT_ARRAY_OFFSET() {
        return FLOAT_ARRAY_OFFSET;
    }

    public static final long getDOUBLE_ARRAY_OFFSET() {
        return DOUBLE_ARRAY_OFFSET;
    }

    public static final long getAddress(@NotNull Buffer $this$address) {
        Intrinsics.checkNotNullParameter($this$address, "<this>");
        return UNSAFE.getLong((Object)$this$address, ADDRESS_OFFSET);
    }

    public static final void setAddress(@NotNull Buffer $this$address, long value) {
        Intrinsics.checkNotNullParameter($this$address, "<this>");
        UNSAFE.putLong((Object)$this$address, ADDRESS_OFFSET, value);
    }

    public static final int getPosition(@NotNull Buffer $this$position) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        return $this$position.position();
    }

    public static final void setPosition(@NotNull Buffer $this$position, int value) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        UNSAFE.putInt((Object)$this$position, POSITION_OFFSET, value);
    }

    public static final int getMark(@NotNull Buffer $this$mark) {
        Intrinsics.checkNotNullParameter($this$mark, "<this>");
        return UNSAFE.getInt((Object)$this$mark, MARK_OFFSET);
    }

    public static final void setMark(@NotNull Buffer $this$mark, int value) {
        Intrinsics.checkNotNullParameter($this$mark, "<this>");
        UNSAFE.putInt((Object)$this$mark, MARK_OFFSET, value);
    }

    public static final int getLimit(@NotNull Buffer $this$limit) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        return $this$limit.limit();
    }

    public static final void setLimit(@NotNull Buffer $this$limit, int value) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        UNSAFE.putInt((Object)$this$limit, LIMIT_OFFSET, value);
    }

    public static final int getCapacity(@NotNull Buffer $this$capacity) {
        Intrinsics.checkNotNullParameter($this$capacity, "<this>");
        return $this$capacity.capacity();
    }

    public static final void setCapacity(@NotNull Buffer $this$capacity, int value) {
        Intrinsics.checkNotNullParameter($this$capacity, "<this>");
        UNSAFE.putInt((Object)$this$capacity, CAPACITY_OFFSET, value);
    }

    public static final long getByteCapacity(@NotNull Buffer $this$byteCapacity) {
        long l2;
        Intrinsics.checkNotNullParameter($this$byteCapacity, "<this>");
        Buffer buffer = $this$byteCapacity;
        if (buffer instanceof ByteBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * 1L;
        } else if (buffer instanceof ShortBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)2;
        } else if (buffer instanceof CharBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)2;
        } else if (buffer instanceof IntBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)4;
        } else if (buffer instanceof LongBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)8;
        } else if (buffer instanceof FloatBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)4;
        } else if (buffer instanceof DoubleBuffer) {
            l2 = (long)$this$byteCapacity.capacity() * (long)8;
        } else {
            throw new IllegalArgumentException("Unsupported buffer type: " + $this$byteCapacity.getClass());
        }
        return l2;
    }

    public static final long getByteLength(@NotNull byte[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * 1L;
    }

    public static final long getByteLength(@NotNull short[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)2;
    }

    public static final long getByteLength(@NotNull char[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)2;
    }

    public static final long getByteLength(@NotNull int[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)4;
    }

    public static final long getByteLength(@NotNull long[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)8;
    }

    public static final long getByteLength(@NotNull float[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)4;
    }

    public static final long getByteLength(@NotNull double[] $this$byteLength) {
        Intrinsics.checkNotNullParameter($this$byteLength, "<this>");
        return (long)$this$byteLength.length * (long)8;
    }

    @NotNull
    public static final ByteBuffer nullByteBuffer() {
        Object object = UNSAFE.allocateInstance(DIRECT_BYTE_BUFFER_CLASS);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.nio.ByteBuffer");
        ByteBuffer buffer = ((ByteBuffer)object).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNull(buffer);
        UtilsKt.setAddress(buffer, 0L);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, 0);
        UtilsKt.setCapacity(buffer, 0);
        return buffer;
    }

    @NotNull
    public static final ShortBuffer nullShortBuffer() {
        ShortBuffer shortBuffer = UtilsKt.nullByteBuffer().asShortBuffer();
        Intrinsics.checkNotNullExpressionValue(shortBuffer, "asShortBuffer(...)");
        return shortBuffer;
    }

    @NotNull
    public static final CharBuffer nullCharBuffer() {
        CharBuffer charBuffer = UtilsKt.nullByteBuffer().asCharBuffer();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "asCharBuffer(...)");
        return charBuffer;
    }

    @NotNull
    public static final IntBuffer nullIntBuffer() {
        IntBuffer intBuffer = UtilsKt.nullByteBuffer().asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(intBuffer, "asIntBuffer(...)");
        return intBuffer;
    }

    @NotNull
    public static final LongBuffer nullLongBuffer() {
        LongBuffer longBuffer = UtilsKt.nullByteBuffer().asLongBuffer();
        Intrinsics.checkNotNullExpressionValue(longBuffer, "asLongBuffer(...)");
        return longBuffer;
    }

    @NotNull
    public static final FloatBuffer nullFloatBuffer() {
        FloatBuffer floatBuffer = UtilsKt.nullByteBuffer().asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(floatBuffer, "asFloatBuffer(...)");
        return floatBuffer;
    }

    @NotNull
    public static final DoubleBuffer nullDoubleBuffer() {
        DoubleBuffer doubleBuffer = UtilsKt.nullByteBuffer().asDoubleBuffer();
        Intrinsics.checkNotNullExpressionValue(doubleBuffer, "asDoubleBuffer(...)");
        return doubleBuffer;
    }

    @NotNull
    public static final ByteBuffer asByteBuffer-n7w3U7I(long $this$asByteBuffer_u2dn7w3U7I, int size, @Nullable ByteBuffer oldBuffer) {
        ByteBuffer byteBuffer = oldBuffer;
        if (byteBuffer == null) {
            byteBuffer = UtilsKt.nullByteBuffer();
        }
        ByteBuffer buffer = byteBuffer;
        UtilsKt.setAddress(buffer, $this$asByteBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ ByteBuffer asByteBuffer-n7w3U7I$default(long l2, int n2, ByteBuffer byteBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            byteBuffer = null;
        }
        return UtilsKt.asByteBuffer-n7w3U7I(l2, n2, byteBuffer);
    }

    @NotNull
    public static final ByteBuffer asByteBuffer-FPr3vG0(long $this$asByteBuffer_u2dFPr3vG0, @NotNull ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asByteBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final ShortBuffer asShortBuffer-n7w3U7I(long $this$asShortBuffer_u2dn7w3U7I, int size, @Nullable ShortBuffer oldBuffer) {
        ShortBuffer shortBuffer = oldBuffer;
        if (shortBuffer == null) {
            shortBuffer = UtilsKt.nullShortBuffer();
        }
        ShortBuffer buffer = shortBuffer;
        UtilsKt.setAddress(buffer, $this$asShortBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ ShortBuffer asShortBuffer-n7w3U7I$default(long l2, int n2, ShortBuffer shortBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            shortBuffer = null;
        }
        return UtilsKt.asShortBuffer-n7w3U7I(l2, n2, shortBuffer);
    }

    @NotNull
    public static final ShortBuffer asShortBuffer-FPr3vG0(long $this$asShortBuffer_u2dFPr3vG0, @NotNull ShortBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asShortBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final CharBuffer asCharBuffer-n7w3U7I(long $this$asCharBuffer_u2dn7w3U7I, int size, @Nullable CharBuffer oldBuffer) {
        CharBuffer charBuffer = oldBuffer;
        if (charBuffer == null) {
            charBuffer = UtilsKt.nullCharBuffer();
        }
        CharBuffer buffer = charBuffer;
        UtilsKt.setAddress(buffer, $this$asCharBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ CharBuffer asCharBuffer-n7w3U7I$default(long l2, int n2, CharBuffer charBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            charBuffer = null;
        }
        return UtilsKt.asCharBuffer-n7w3U7I(l2, n2, charBuffer);
    }

    @NotNull
    public static final CharBuffer asCharBuffer-FPr3vG0(long $this$asCharBuffer_u2dFPr3vG0, @NotNull CharBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asCharBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final IntBuffer asIntBuffer-n7w3U7I(long $this$asIntBuffer_u2dn7w3U7I, int size, @Nullable IntBuffer oldBuffer) {
        IntBuffer intBuffer = oldBuffer;
        if (intBuffer == null) {
            intBuffer = UtilsKt.nullIntBuffer();
        }
        IntBuffer buffer = intBuffer;
        UtilsKt.setAddress(buffer, $this$asIntBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ IntBuffer asIntBuffer-n7w3U7I$default(long l2, int n2, IntBuffer intBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            intBuffer = null;
        }
        return UtilsKt.asIntBuffer-n7w3U7I(l2, n2, intBuffer);
    }

    @NotNull
    public static final IntBuffer asIntBuffer-FPr3vG0(long $this$asIntBuffer_u2dFPr3vG0, @NotNull IntBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asIntBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final LongBuffer asLongBuffer-n7w3U7I(long $this$asLongBuffer_u2dn7w3U7I, int size, @Nullable LongBuffer oldBuffer) {
        LongBuffer longBuffer = oldBuffer;
        if (longBuffer == null) {
            longBuffer = UtilsKt.nullLongBuffer();
        }
        LongBuffer buffer = longBuffer;
        UtilsKt.setAddress(buffer, $this$asLongBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ LongBuffer asLongBuffer-n7w3U7I$default(long l2, int n2, LongBuffer longBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            longBuffer = null;
        }
        return UtilsKt.asLongBuffer-n7w3U7I(l2, n2, longBuffer);
    }

    @NotNull
    public static final LongBuffer asLongBuffer-FPr3vG0(long $this$asLongBuffer_u2dFPr3vG0, @NotNull LongBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asLongBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final FloatBuffer asFloatBuffer-n7w3U7I(long $this$asFloatBuffer_u2dn7w3U7I, int size, @Nullable FloatBuffer oldBuffer) {
        FloatBuffer floatBuffer = oldBuffer;
        if (floatBuffer == null) {
            floatBuffer = UtilsKt.nullFloatBuffer();
        }
        FloatBuffer buffer = floatBuffer;
        UtilsKt.setAddress(buffer, $this$asFloatBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ FloatBuffer asFloatBuffer-n7w3U7I$default(long l2, int n2, FloatBuffer floatBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            floatBuffer = null;
        }
        return UtilsKt.asFloatBuffer-n7w3U7I(l2, n2, floatBuffer);
    }

    @NotNull
    public static final FloatBuffer asFloatBuffer-FPr3vG0(long $this$asFloatBuffer_u2dFPr3vG0, @NotNull FloatBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asFloatBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    @NotNull
    public static final DoubleBuffer asDoubleBuffer-n7w3U7I(long $this$asDoubleBuffer_u2dn7w3U7I, int size, @Nullable DoubleBuffer oldBuffer) {
        DoubleBuffer doubleBuffer = oldBuffer;
        if (doubleBuffer == null) {
            doubleBuffer = UtilsKt.nullDoubleBuffer();
        }
        DoubleBuffer buffer = doubleBuffer;
        UtilsKt.setAddress(buffer, $this$asDoubleBuffer_u2dn7w3U7I);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        UtilsKt.setLimit(buffer, size);
        UtilsKt.setCapacity(buffer, size);
        return buffer;
    }

    public static /* synthetic */ DoubleBuffer asDoubleBuffer-n7w3U7I$default(long l2, int n2, DoubleBuffer doubleBuffer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            doubleBuffer = null;
        }
        return UtilsKt.asDoubleBuffer-n7w3U7I(l2, n2, doubleBuffer);
    }

    @NotNull
    public static final DoubleBuffer asDoubleBuffer-FPr3vG0(long $this$asDoubleBuffer_u2dFPr3vG0, @NotNull DoubleBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        UtilsKt.setAddress(buffer, $this$asDoubleBuffer_u2dFPr3vG0);
        UtilsKt.setPosition(buffer, 0);
        UtilsKt.setMark(buffer, -1);
        return buffer;
    }

    static {
        boolean bl2 = false;
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Object object = field.get(null);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type sun.misc.Unsafe");
        UNSAFE = (Unsafe)object;
        BYTE_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
        SHORT_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(short[].class);
        CHAR_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(char[].class);
        INT_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(int[].class);
        LONG_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(long[].class);
        FLOAT_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(float[].class);
        DOUBLE_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(double[].class);
        ADDRESS_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        POSITION_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("position"));
        MARK_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("mark"));
        LIMIT_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("limit"));
        CAPACITY_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("capacity"));
        DIRECT_BYTE_BUFFER_CLASS = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder()).getClass();
    }
}

