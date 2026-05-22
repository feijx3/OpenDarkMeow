/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 */
package dev.fastmc.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000P\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u000e\u0010+\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u0016\u0010-\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017\u001a\n\u0010.\u001a\u00020/*\u00020\u0005\u001a!\u00100\u001a\u000201\"\b\b\u0000\u00102*\u000201*\u0002H22\u0006\u00103\u001a\u00020\u0017\u00a2\u0006\u0002\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"(\u0010\u0012\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"(\u0010\u0018\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"(\u0010\u001d\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c\"(\u0010 \u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c\"(\u0010#\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c\u00a8\u00065"}, d2={"ADDRESS_OFFSET", "", "CAPACITY_OFFSET", "DIRECT_BYTE_BUFFER_CLASS", "Ljava/lang/Class;", "Ljava/nio/ByteBuffer;", "getDIRECT_BYTE_BUFFER_CLASS", "()Ljava/lang/Class;", "FREE_FUNC", "Ljava/util/function/Consumer;", "LIMIT_OFFSET", "MARK_OFFSET", "POSITION_OFFSET", "UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE", "()Lsun/misc/Unsafe;", "value", "address", "getAddress", "(Ljava/nio/ByteBuffer;)J", "setAddress", "(Ljava/nio/ByteBuffer;J)V", "", "capacity", "getCapacity", "(Ljava/nio/ByteBuffer;)I", "setCapacity", "(Ljava/nio/ByteBuffer;I)V", "limit", "getLimit", "setLimit", "mark", "getMark", "setMark", "position", "getPosition", "setPosition", "allocateByte", "allocateFloat", "Ljava/nio/FloatBuffer;", "allocateInt", "Ljava/nio/IntBuffer;", "allocateShort", "Ljava/nio/ShortBuffer;", "wrapDirectByteBuffer", "free", "", "skip", "Ljava/nio/Buffer;", "T", "count", "(Ljava/nio/Buffer;I)Ljava/nio/Buffer;", "fastmc-common_java8"})
@JvmName(name="BufferUtils")
public final class BufferUtils {
    @NotNull
    private static final Unsafe UNSAFE;
    private static final long ADDRESS_OFFSET;
    private static final long POSITION_OFFSET;
    private static final long MARK_OFFSET;
    private static final long LIMIT_OFFSET;
    private static final long CAPACITY_OFFSET;
    @NotNull
    private static final Class<ByteBuffer> DIRECT_BYTE_BUFFER_CLASS;
    @NotNull
    private static final Consumer<ByteBuffer> FREE_FUNC;

    @NotNull
    public static final ByteBuffer allocateByte(int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(byteBuffer, "allocateDirect(capacity)\u2026(ByteOrder.nativeOrder())");
        return byteBuffer;
    }

    @NotNull
    public static final ShortBuffer allocateShort(int capacity) {
        ShortBuffer shortBuffer = BufferUtils.allocateByte(capacity * 4).asShortBuffer();
        Intrinsics.checkNotNullExpressionValue(shortBuffer, "allocateByte(capacity * 4).asShortBuffer()");
        return shortBuffer;
    }

    @NotNull
    public static final IntBuffer allocateInt(int capacity) {
        IntBuffer intBuffer = BufferUtils.allocateByte(capacity * 4).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(intBuffer, "allocateByte(capacity * 4).asIntBuffer()");
        return intBuffer;
    }

    @NotNull
    public static final FloatBuffer allocateFloat(int capacity) {
        FloatBuffer floatBuffer = BufferUtils.allocateByte(capacity * 4).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(floatBuffer, "allocateByte(capacity * 4).asFloatBuffer()");
        return floatBuffer;
    }

    @NotNull
    public static final <T extends Buffer> Buffer skip(@NotNull T $this$skip, int count) {
        Intrinsics.checkNotNullParameter($this$skip, "<this>");
        $this$skip.position($this$skip.position() + count);
        return $this$skip;
    }

    @NotNull
    public static final Unsafe getUNSAFE() {
        return UNSAFE;
    }

    public static final long getAddress(@NotNull ByteBuffer $this$address) {
        Intrinsics.checkNotNullParameter($this$address, "<this>");
        return UNSAFE.getLong((Object)$this$address, ADDRESS_OFFSET);
    }

    public static final void setAddress(@NotNull ByteBuffer $this$address, long value) {
        Intrinsics.checkNotNullParameter($this$address, "<this>");
        UNSAFE.putLong((Object)$this$address, ADDRESS_OFFSET, value);
    }

    public static final int getPosition(@NotNull ByteBuffer $this$position) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        return $this$position.position();
    }

    public static final void setPosition(@NotNull ByteBuffer $this$position, int value) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        UNSAFE.putInt((Object)$this$position, POSITION_OFFSET, value);
    }

    public static final int getMark(@NotNull ByteBuffer $this$mark) {
        Intrinsics.checkNotNullParameter($this$mark, "<this>");
        return UNSAFE.getInt((Object)$this$mark, MARK_OFFSET);
    }

    public static final void setMark(@NotNull ByteBuffer $this$mark, int value) {
        Intrinsics.checkNotNullParameter($this$mark, "<this>");
        UNSAFE.putInt((Object)$this$mark, MARK_OFFSET, value);
    }

    public static final int getLimit(@NotNull ByteBuffer $this$limit) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        return $this$limit.limit();
    }

    public static final void setLimit(@NotNull ByteBuffer $this$limit, int value) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        UNSAFE.putInt((Object)$this$limit, LIMIT_OFFSET, value);
    }

    public static final int getCapacity(@NotNull ByteBuffer $this$capacity) {
        Intrinsics.checkNotNullParameter($this$capacity, "<this>");
        return $this$capacity.capacity();
    }

    public static final void setCapacity(@NotNull ByteBuffer $this$capacity, int value) {
        Intrinsics.checkNotNullParameter($this$capacity, "<this>");
        UNSAFE.putInt((Object)$this$capacity, CAPACITY_OFFSET, value);
    }

    @NotNull
    public static final Class<ByteBuffer> getDIRECT_BYTE_BUFFER_CLASS() {
        return DIRECT_BYTE_BUFFER_CLASS;
    }

    @NotNull
    public static final ByteBuffer wrapDirectByteBuffer(long address, int capacity) {
        Object object = UNSAFE.allocateInstance(DIRECT_BYTE_BUFFER_CLASS);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.nio.ByteBuffer");
        ByteBuffer buffer = (ByteBuffer)object;
        BufferUtils.setAddress(buffer, address);
        BufferUtils.setMark(buffer, -1);
        BufferUtils.setLimit(buffer, capacity);
        BufferUtils.setCapacity(buffer, capacity);
        return buffer;
    }

    public static final void free(@NotNull ByteBuffer $this$free) {
        Intrinsics.checkNotNullParameter($this$free, "<this>");
        FREE_FUNC.accept($this$free);
    }

    private static final void FREE_FUNC$lambda$4$lambda$1(Method $invokeCleanerMethod, ByteBuffer it) {
        Object[] objectArray = new Object[]{it};
        $invokeCleanerMethod.invoke(UNSAFE, objectArray);
    }

    private static final void FREE_FUNC$lambda$4$lambda$3(long $cleanerOffset, Method $cleanMethod, ByteBuffer buffer) {
        block0: {
            Object object = UNSAFE.getObject((Object)buffer, $cleanerOffset);
            if (object == null) break block0;
            Object it = object;
            boolean bl2 = false;
            $cleanMethod.invoke(it, new Object[0]);
        }
    }

    static {
        Consumer<ByteBuffer> consumer;
        boolean bl2 = false;
        Class[] field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Object object = field.get(null);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type sun.misc.Unsafe");
        UNSAFE = (Unsafe)object;
        ADDRESS_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        POSITION_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("position"));
        MARK_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("mark"));
        LIMIT_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("limit"));
        CAPACITY_OFFSET = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("capacity"));
        DIRECT_BYTE_BUFFER_CLASS = BufferUtils.allocateByte(0).getClass();
        boolean bl3 = false;
        try {
            field = new Class[]{ByteBuffer.class};
            Method invokeCleanerMethod = UNSAFE.getClass().getDeclaredMethod("invokeCleaner", field);
            consumer = arg_0 -> BufferUtils.FREE_FUNC$lambda$4$lambda$1(invokeCleanerMethod, arg_0);
        }
        catch (NoSuchMethodException e2) {
            Field cleanerField = DIRECT_BYTE_BUFFER_CLASS.getDeclaredField("cleaner");
            long cleanerOffset = UNSAFE.objectFieldOffset(cleanerField);
            Method cleanMethod = cleanerField.getType().getDeclaredMethod("clean", new Class[0]);
            cleanMethod.setAccessible(true);
            consumer = arg_0 -> BufferUtils.FREE_FUNC$lambda$4$lambda$3(cleanerOffset, cleanMethod, arg_0);
        }
        FREE_FUNC = consumer;
    }
}

