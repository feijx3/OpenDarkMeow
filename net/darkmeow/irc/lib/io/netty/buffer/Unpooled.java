/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.buffer.CompositeByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.EmptyByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.FixedCompositeByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ReadOnlyByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ReadOnlyByteBufferBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ReadOnlyUnsafeDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledHeapByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.UnreleasableByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.WrappedUnpooledUnsafeDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.util.CharsetUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;

public final class Unpooled {
    private static final ByteBufAllocator ALLOC = UnpooledByteBufAllocator.DEFAULT;
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER = ALLOC.buffer(0, 0);

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    public static ByteBuf buffer(int initialCapacity) {
        return ALLOC.heapBuffer(initialCapacity);
    }

    public static ByteBuf directBuffer(int initialCapacity) {
        return ALLOC.directBuffer(initialCapacity);
    }

    public static ByteBuf buffer(int initialCapacity, int maxCapacity) {
        return ALLOC.heapBuffer(initialCapacity, maxCapacity);
    }

    public static ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
        return ALLOC.directBuffer(initialCapacity, maxCapacity);
    }

    public static ByteBuf wrappedBuffer(byte[] array) {
        if (array.length == 0) {
            return EMPTY_BUFFER;
        }
        return new UnpooledHeapByteBuf(ALLOC, array, array.length);
    }

    public static ByteBuf wrappedBuffer(byte[] array, int offset, int length) {
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (offset == 0 && length == array.length) {
            return Unpooled.wrappedBuffer(array);
        }
        return Unpooled.wrappedBuffer(array).slice(offset, length);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer buffer) {
        if (!buffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!buffer.isDirect() && buffer.hasArray()) {
            return Unpooled.wrappedBuffer(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining()).order(buffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (buffer.isReadOnly()) {
                if (buffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, buffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, buffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, buffer, buffer.remaining());
        }
        if (buffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, buffer);
        }
        return new UnpooledDirectByteBuf(ALLOC, buffer, buffer.remaining());
    }

    public static ByteBuf wrappedBuffer(long memoryAddress, int size, boolean doFree) {
        return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, memoryAddress, size, doFree);
    }

    public static ByteBuf wrappedBuffer(ByteBuf buffer) {
        if (buffer.isReadable()) {
            return buffer.slice();
        }
        buffer.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[] ... arrays) {
        return Unpooled.wrappedBuffer(arrays.length, arrays);
    }

    public static ByteBuf wrappedBuffer(ByteBuf ... buffers) {
        return Unpooled.wrappedBuffer(buffers.length, buffers);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer ... buffers) {
        return Unpooled.wrappedBuffer(buffers.length, buffers);
    }

    static <T> ByteBuf wrappedBuffer(int maxNumComponents, CompositeByteBuf.ByteWrapper<T> wrapper, T[] array) {
        switch (array.length) {
            case 0: {
                break;
            }
            case 1: {
                if (wrapper.isEmpty(array[0])) break;
                return wrapper.wrap(array[0]);
            }
            default: {
                int len = array.length;
                for (int i2 = 0; i2 < len; ++i2) {
                    T bytes = array[i2];
                    if (bytes == null) {
                        return EMPTY_BUFFER;
                    }
                    if (wrapper.isEmpty(bytes)) continue;
                    return new CompositeByteBuf(ALLOC, false, maxNumComponents, wrapper, array, i2);
                }
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int maxNumComponents, byte[] ... arrays) {
        return Unpooled.wrappedBuffer(maxNumComponents, CompositeByteBuf.BYTE_ARRAY_WRAPPER, arrays);
    }

    public static ByteBuf wrappedBuffer(int maxNumComponents, ByteBuf ... buffers) {
        switch (buffers.length) {
            case 0: {
                break;
            }
            case 1: {
                ByteBuf buffer = buffers[0];
                if (buffer.isReadable()) {
                    return Unpooled.wrappedBuffer(buffer.order(BIG_ENDIAN));
                }
                buffer.release();
                break;
            }
            default: {
                for (int i2 = 0; i2 < buffers.length; ++i2) {
                    ByteBuf buf = buffers[i2];
                    if (buf.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, maxNumComponents, buffers, i2);
                    }
                    buf.release();
                }
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int maxNumComponents, ByteBuffer ... buffers) {
        return Unpooled.wrappedBuffer(maxNumComponents, CompositeByteBuf.BYTE_BUFFER_WRAPPER, buffers);
    }

    public static CompositeByteBuf compositeBuffer() {
        return Unpooled.compositeBuffer(16);
    }

    public static CompositeByteBuf compositeBuffer(int maxNumComponents) {
        return new CompositeByteBuf(ALLOC, false, maxNumComponents);
    }

    public static ByteBuf copiedBuffer(byte[] array) {
        if (array.length == 0) {
            return EMPTY_BUFFER;
        }
        return Unpooled.wrappedBuffer((byte[])array.clone());
    }

    public static ByteBuf copiedBuffer(byte[] array, int offset, int length) {
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        byte[] copy = PlatformDependent.allocateUninitializedArray(length);
        System.arraycopy(array, offset, copy, 0, length);
        return Unpooled.wrappedBuffer(copy);
    }

    public static ByteBuf copiedBuffer(ByteBuffer buffer) {
        int length = buffer.remaining();
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        byte[] copy = PlatformDependent.allocateUninitializedArray(length);
        ByteBuffer duplicate = buffer.duplicate();
        duplicate.get(copy);
        return Unpooled.wrappedBuffer(copy).order(duplicate.order());
    }

    public static ByteBuf copiedBuffer(ByteBuf buffer) {
        int readable = buffer.readableBytes();
        if (readable > 0) {
            ByteBuf copy = Unpooled.buffer(readable);
            copy.writeBytes(buffer, buffer.readerIndex(), readable);
            return copy;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(byte[] ... arrays) {
        switch (arrays.length) {
            case 0: {
                return EMPTY_BUFFER;
            }
            case 1: {
                if (arrays[0].length == 0) {
                    return EMPTY_BUFFER;
                }
                return Unpooled.copiedBuffer(arrays[0]);
            }
        }
        int length = 0;
        for (byte[] a2 : arrays) {
            if (Integer.MAX_VALUE - length < a2.length) {
                throw new IllegalArgumentException("The total length of the specified arrays is too big.");
            }
            length += a2.length;
        }
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        byte[] mergedArray = PlatformDependent.allocateUninitializedArray(length);
        int j2 = 0;
        for (int i2 = 0; i2 < arrays.length; ++i2) {
            byte[] a2;
            a2 = arrays[i2];
            System.arraycopy(a2, 0, mergedArray, j2, a2.length);
            j2 += a2.length;
        }
        return Unpooled.wrappedBuffer(mergedArray);
    }

    public static ByteBuf copiedBuffer(ByteBuf ... buffers) {
        int bLen;
        switch (buffers.length) {
            case 0: {
                return EMPTY_BUFFER;
            }
            case 1: {
                return Unpooled.copiedBuffer(buffers[0]);
            }
        }
        ByteOrder order = null;
        int length = 0;
        for (ByteBuf b2 : buffers) {
            bLen = b2.readableBytes();
            if (bLen <= 0) continue;
            if (Integer.MAX_VALUE - length < bLen) {
                throw new IllegalArgumentException("The total length of the specified buffers is too big.");
            }
            length += bLen;
            if (order != null) {
                if (order.equals(b2.order())) continue;
                throw new IllegalArgumentException("inconsistent byte order");
            }
            order = b2.order();
        }
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        byte[] mergedArray = PlatformDependent.allocateUninitializedArray(length);
        int j2 = 0;
        for (int i2 = 0; i2 < buffers.length; ++i2) {
            ByteBuf b2;
            b2 = buffers[i2];
            bLen = b2.readableBytes();
            b2.getBytes(b2.readerIndex(), mergedArray, j2, bLen);
            j2 += bLen;
        }
        return Unpooled.wrappedBuffer(mergedArray).order(order);
    }

    public static ByteBuf copiedBuffer(ByteBuffer ... buffers) {
        int bLen;
        switch (buffers.length) {
            case 0: {
                return EMPTY_BUFFER;
            }
            case 1: {
                return Unpooled.copiedBuffer(buffers[0]);
            }
        }
        ByteOrder order = null;
        int length = 0;
        for (ByteBuffer b2 : buffers) {
            bLen = b2.remaining();
            if (bLen <= 0) continue;
            if (Integer.MAX_VALUE - length < bLen) {
                throw new IllegalArgumentException("The total length of the specified buffers is too big.");
            }
            length += bLen;
            if (order != null) {
                if (order.equals(b2.order())) continue;
                throw new IllegalArgumentException("inconsistent byte order");
            }
            order = b2.order();
        }
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        byte[] mergedArray = PlatformDependent.allocateUninitializedArray(length);
        int j2 = 0;
        for (int i2 = 0; i2 < buffers.length; ++i2) {
            ByteBuffer b2;
            b2 = buffers[i2].duplicate();
            bLen = b2.remaining();
            b2.get(mergedArray, j2, bLen);
            j2 += bLen;
        }
        return Unpooled.wrappedBuffer(mergedArray).order(order);
    }

    public static ByteBuf copiedBuffer(CharSequence string, Charset charset) {
        ObjectUtil.checkNotNull(string, "string");
        if (CharsetUtil.UTF_8.equals(charset)) {
            return Unpooled.copiedBufferUtf8(string);
        }
        if (CharsetUtil.US_ASCII.equals(charset)) {
            return Unpooled.copiedBufferAscii(string);
        }
        if (string instanceof CharBuffer) {
            return Unpooled.copiedBuffer((CharBuffer)string, charset);
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap(string), charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ByteBuf copiedBufferUtf8(CharSequence string) {
        boolean release = true;
        ByteBuf buffer = ALLOC.heapBuffer(ByteBufUtil.utf8Bytes(string));
        try {
            ByteBufUtil.writeUtf8(buffer, string);
            release = false;
            ByteBuf byteBuf = buffer;
            return byteBuf;
        }
        finally {
            if (release) {
                buffer.release();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ByteBuf copiedBufferAscii(CharSequence string) {
        boolean release = true;
        ByteBuf buffer = ALLOC.heapBuffer(string.length());
        try {
            ByteBufUtil.writeAscii(buffer, string);
            release = false;
            ByteBuf byteBuf = buffer;
            return byteBuf;
        }
        finally {
            if (release) {
                buffer.release();
            }
        }
    }

    public static ByteBuf copiedBuffer(CharSequence string, int offset, int length, Charset charset) {
        ObjectUtil.checkNotNull(string, "string");
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (string instanceof CharBuffer) {
            CharBuffer buf = (CharBuffer)string;
            if (buf.hasArray()) {
                return Unpooled.copiedBuffer(buf.array(), buf.arrayOffset() + buf.position() + offset, length, charset);
            }
            buf = buf.slice();
            buf.limit(length);
            buf.position(offset);
            return Unpooled.copiedBuffer(buf, charset);
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap(string, offset, offset + length), charset);
    }

    public static ByteBuf copiedBuffer(char[] array, Charset charset) {
        ObjectUtil.checkNotNull(array, "array");
        return Unpooled.copiedBuffer(array, 0, array.length, charset);
    }

    public static ByteBuf copiedBuffer(char[] array, int offset, int length, Charset charset) {
        ObjectUtil.checkNotNull(array, "array");
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap(array, offset, length), charset);
    }

    private static ByteBuf copiedBuffer(CharBuffer buffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, buffer, charset, 0);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf buffer) {
        ByteOrder endianness = buffer.order();
        if (endianness == BIG_ENDIAN) {
            return new ReadOnlyByteBuf(buffer);
        }
        return new ReadOnlyByteBuf(buffer.order(BIG_ENDIAN)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf copyInt(int value) {
        ByteBuf buf = Unpooled.buffer(4);
        buf.writeInt(value);
        return buf;
    }

    public static ByteBuf copyInt(int ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 4);
        for (int v2 : values) {
            buffer.writeInt(v2);
        }
        return buffer;
    }

    public static ByteBuf copyShort(int value) {
        ByteBuf buf = Unpooled.buffer(2);
        buf.writeShort(value);
        return buf;
    }

    public static ByteBuf copyShort(short ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 2);
        for (short v2 : values) {
            buffer.writeShort(v2);
        }
        return buffer;
    }

    public static ByteBuf copyShort(int ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 2);
        for (int v2 : values) {
            buffer.writeShort(v2);
        }
        return buffer;
    }

    public static ByteBuf copyMedium(int value) {
        ByteBuf buf = Unpooled.buffer(3);
        buf.writeMedium(value);
        return buf;
    }

    public static ByteBuf copyMedium(int ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 3);
        for (int v2 : values) {
            buffer.writeMedium(v2);
        }
        return buffer;
    }

    public static ByteBuf copyLong(long value) {
        ByteBuf buf = Unpooled.buffer(8);
        buf.writeLong(value);
        return buf;
    }

    public static ByteBuf copyLong(long ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 8);
        for (long v2 : values) {
            buffer.writeLong(v2);
        }
        return buffer;
    }

    public static ByteBuf copyBoolean(boolean value) {
        ByteBuf buf = Unpooled.buffer(1);
        buf.writeBoolean(value);
        return buf;
    }

    public static ByteBuf copyBoolean(boolean ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length);
        for (boolean v2 : values) {
            buffer.writeBoolean(v2);
        }
        return buffer;
    }

    public static ByteBuf copyFloat(float value) {
        ByteBuf buf = Unpooled.buffer(4);
        buf.writeFloat(value);
        return buf;
    }

    public static ByteBuf copyFloat(float ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 4);
        for (float v2 : values) {
            buffer.writeFloat(v2);
        }
        return buffer;
    }

    public static ByteBuf copyDouble(double value) {
        ByteBuf buf = Unpooled.buffer(8);
        buf.writeDouble(value);
        return buf;
    }

    public static ByteBuf copyDouble(double ... values) {
        if (values == null || values.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = Unpooled.buffer(values.length * 8);
        for (double v2 : values) {
            buffer.writeDouble(v2);
        }
        return buffer;
    }

    public static ByteBuf unreleasableBuffer(ByteBuf buf) {
        return new UnreleasableByteBuf(buf);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf ... buffers) {
        return Unpooled.wrappedUnmodifiableBuffer(true, buffers);
    }

    public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf ... buffers) {
        return Unpooled.wrappedUnmodifiableBuffer(false, buffers);
    }

    private static ByteBuf wrappedUnmodifiableBuffer(boolean copy, ByteBuf ... buffers) {
        switch (buffers.length) {
            case 0: {
                return EMPTY_BUFFER;
            }
            case 1: {
                return buffers[0].asReadOnly();
            }
        }
        if (copy) {
            buffers = (ByteBuf[])Arrays.copyOf(buffers, buffers.length, ByteBuf[].class);
        }
        return new FixedCompositeByteBuf(ALLOC, buffers);
    }

    private Unpooled() {
    }

    static {
        assert (EMPTY_BUFFER instanceof EmptyByteBuf) : "EMPTY_BUFFER must be an EmptyByteBuf.";
    }
}

