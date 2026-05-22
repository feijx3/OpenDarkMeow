/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicLong;
import net.darkmeow.irc.lib.io.netty.util.internal.ConstantTimeUtils;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ReflectionUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;
import sun.misc.Unsafe;

final class PlatformDependent0 {
    private static final InternalLogger logger;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MethodHandle DIRECT_BUFFER_CONSTRUCTOR;
    private static final MethodHandle ALLOCATE_ARRAY_METHOD;
    private static final MethodHandle ALIGN_SLICE;
    private static final boolean IS_ANDROID;
    private static final int JAVA_VERSION;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final boolean RUNNING_IN_NATIVE_IMAGE;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    static final MethodHandle IS_VIRTUAL_THREAD_METHOD_HANDLE;
    static final Unsafe UNSAFE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final long UNSAFE_COPY_THRESHOLD = 0x100000L;
    private static final boolean UNALIGNED;
    private static final long BITS_MAX_DIRECT_MEMORY;

    private static MethodHandle getIsVirtualThreadMethodHandle() {
        try {
            MethodHandle methodHandle = MethodHandles.publicLookup().findVirtual(Thread.class, "isVirtual", MethodType.methodType(Boolean.TYPE));
            boolean isVirtual = methodHandle.invokeExact(Thread.currentThread());
            return methodHandle;
        }
        catch (Throwable e2) {
            if (logger.isTraceEnabled()) {
                logger.debug("Thread.isVirtual() is not available: ", e2);
            } else {
                logger.debug("Thread.isVirtual() is not available: ", (Object)e2.getMessage());
            }
            return null;
        }
    }

    static boolean isVirtualThread(Thread thread2) {
        if (thread2 == null || IS_VIRTUAL_THREAD_METHOD_HANDLE == null) {
            return false;
        }
        try {
            return IS_VIRTUAL_THREAD_METHOD_HANDLE.invokeExact(thread2);
        }
        catch (Throwable t2) {
            if (t2 instanceof Error) {
                throw (Error)t2;
            }
            throw new Error(t2);
        }
    }

    private static boolean unsafeStaticFieldOffsetSupported() {
        return !RUNNING_IN_NATIVE_IMAGE;
    }

    static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean explicitProperty = SystemPropertyUtil.contains("net.darkmeow.irc.lib.io.netty.noUnsafe");
        boolean noUnsafe = SystemPropertyUtil.getBoolean("net.darkmeow.irc.lib.io.netty.noUnsafe", false);
        logger.debug("-Dio.netty.noUnsafe: {}", (Object)noUnsafe);
        String reason = "net.darkmeow.irc.lib.io.netty.noUnsafe";
        String unspecified = "<unspecified>";
        String unsafeMemoryAccess = SystemPropertyUtil.get("sun.misc.unsafe.memory.access", unspecified);
        if (!explicitProperty && unspecified.equals(unsafeMemoryAccess) && PlatformDependent0.javaVersion() >= 24) {
            reason = "net.darkmeow.irc.lib.io.netty.noUnsafe=true by default on Java 24+";
            noUnsafe = true;
        } else if (!"allow".equals(unsafeMemoryAccess) && !unspecified.equals(unsafeMemoryAccess)) {
            reason = "--sun-misc-unsafe-memory-access=" + unsafeMemoryAccess;
            noUnsafe = true;
        }
        if (noUnsafe) {
            String msg = "sun.misc.Unsafe: unavailable (" + reason + ')';
            logger.debug(msg);
            return new UnsupportedOperationException(msg);
        }
        String unsafePropName = SystemPropertyUtil.contains("net.darkmeow.irc.lib.io.netty.tryUnsafe") ? "net.darkmeow.irc.lib.io.netty.tryUnsafe" : "org.jboss.netty.tryUnsafe";
        if (!SystemPropertyUtil.getBoolean(unsafePropName, true)) {
            String msg = "sun.misc.Unsafe: unavailable (" + unsafePropName + ')';
            logger.debug(msg);
            return new UnsupportedOperationException(msg);
        }
        return null;
    }

    static boolean isUnaligned() {
        return UNALIGNED;
    }

    static long bitsMaxDirectMemory() {
        return BITS_MAX_DIRECT_MEMORY;
    }

    static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    static boolean unalignedAccess() {
        return UNALIGNED;
    }

    static void throwException(Throwable cause) {
        PlatformDependent0.throwException0(cause);
    }

    private static <E extends Throwable> void throwException0(Throwable t2) throws E {
        throw t2;
    }

    static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    static ByteBuffer reallocateDirectNoCleaner(ByteBuffer buffer, int capacity) {
        return PlatformDependent0.newDirectBuffer(UNSAFE.reallocateMemory(PlatformDependent0.directBufferAddress(buffer), capacity), capacity);
    }

    static ByteBuffer allocateDirectNoCleaner(int capacity) {
        return PlatformDependent0.newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, capacity)), capacity);
    }

    static boolean hasAlignSliceMethod() {
        return ALIGN_SLICE != null;
    }

    static ByteBuffer alignSlice(ByteBuffer buffer, int alignment) {
        try {
            return ALIGN_SLICE.invokeExact(buffer, alignment);
        }
        catch (Throwable e2) {
            PlatformDependent0.rethrowIfPossible(e2);
            throw new LinkageError("ByteBuffer.alignedSlice not available", e2);
        }
    }

    static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    static byte[] allocateUninitializedArray(int size) {
        try {
            return (byte[])ALLOCATE_ARRAY_METHOD.invokeExact(Byte.TYPE, size);
        }
        catch (Throwable e2) {
            PlatformDependent0.rethrowIfPossible(e2);
            throw new LinkageError("Unsafe.allocateUninitializedArray not available", e2);
        }
    }

    static ByteBuffer newDirectBuffer(long address, int capacity) {
        ObjectUtil.checkPositiveOrZero(capacity, "capacity");
        try {
            return DIRECT_BUFFER_CONSTRUCTOR.invokeExact(address, capacity);
        }
        catch (Throwable cause) {
            PlatformDependent0.rethrowIfPossible(cause);
            throw new LinkageError("DirectByteBuffer constructor not available", cause);
        }
    }

    private static void rethrowIfPossible(Throwable cause) {
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
    }

    static long directBufferAddress(ByteBuffer buffer) {
        return PlatformDependent0.getLong(buffer, ADDRESS_FIELD_OFFSET);
    }

    static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static Object getObject(Object object, long fieldOffset) {
        return UNSAFE.getObject(object, fieldOffset);
    }

    static int getInt(Object object, long fieldOffset) {
        return UNSAFE.getInt(object, fieldOffset);
    }

    static void safeConstructPutInt(Object object, long fieldOffset, int value) {
        UNSAFE.putInt(object, fieldOffset, value);
        UNSAFE.storeFence();
    }

    private static long getLong(Object object, long fieldOffset) {
        return UNSAFE.getLong(object, fieldOffset);
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static byte getByte(long address) {
        return UNSAFE.getByte(address);
    }

    static short getShort(long address) {
        return UNSAFE.getShort(address);
    }

    static int getInt(long address) {
        return UNSAFE.getInt(address);
    }

    static long getLong(long address) {
        return UNSAFE.getLong(address);
    }

    static byte getByte(byte[] data, int index) {
        return UNSAFE.getByte((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index);
    }

    static byte getByte(byte[] data, long index) {
        return UNSAFE.getByte((Object)data, BYTE_ARRAY_BASE_OFFSET + index);
    }

    static short getShort(byte[] data, int index) {
        return UNSAFE.getShort((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index);
    }

    static int getInt(byte[] data, int index) {
        return UNSAFE.getInt((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index);
    }

    static int getInt(int[] data, long index) {
        return UNSAFE.getInt((Object)data, INT_ARRAY_BASE_OFFSET + INT_ARRAY_INDEX_SCALE * index);
    }

    static int getIntVolatile(long address) {
        return UNSAFE.getIntVolatile(null, address);
    }

    static void putIntOrdered(long adddress, int newValue) {
        UNSAFE.putOrderedInt(null, adddress, newValue);
    }

    static long getLong(byte[] data, int index) {
        return UNSAFE.getLong((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index);
    }

    static long getLong(long[] data, long index) {
        return UNSAFE.getLong((Object)data, LONG_ARRAY_BASE_OFFSET + LONG_ARRAY_INDEX_SCALE * index);
    }

    static void putByte(long address, byte value) {
        UNSAFE.putByte(address, value);
    }

    static void putShort(long address, short value) {
        UNSAFE.putShort(address, value);
    }

    static void putShortOrdered(long adddress, short newValue) {
        UNSAFE.storeFence();
        UNSAFE.putShort(null, adddress, newValue);
    }

    static void putInt(long address, int value) {
        UNSAFE.putInt(address, value);
    }

    static void putLong(long address, long value) {
        UNSAFE.putLong(address, value);
    }

    static void putByte(byte[] data, int index, byte value) {
        UNSAFE.putByte((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index, value);
    }

    static void putByte(Object data, long offset, byte value) {
        UNSAFE.putByte(data, offset, value);
    }

    static void putShort(byte[] data, int index, short value) {
        UNSAFE.putShort((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index, value);
    }

    static void putInt(byte[] data, int index, int value) {
        UNSAFE.putInt((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index, value);
    }

    static void putLong(byte[] data, int index, long value) {
        UNSAFE.putLong((Object)data, BYTE_ARRAY_BASE_OFFSET + (long)index, value);
    }

    static void putObject(Object o2, long offset, Object x2) {
        UNSAFE.putObject(o2, offset, x2);
    }

    static void copyMemory(long srcAddr, long dstAddr, long length) {
        if (PlatformDependent0.javaVersion() <= 8) {
            PlatformDependent0.copyMemoryWithSafePointPolling(srcAddr, dstAddr, length);
        } else {
            UNSAFE.copyMemory(srcAddr, dstAddr, length);
        }
    }

    private static void copyMemoryWithSafePointPolling(long srcAddr, long dstAddr, long length) {
        while (length > 0L) {
            long size = Math.min(length, 0x100000L);
            UNSAFE.copyMemory(srcAddr, dstAddr, size);
            length -= size;
            srcAddr += size;
            dstAddr += size;
        }
    }

    static void copyMemory(Object src, long srcOffset, Object dst, long dstOffset, long length) {
        if (PlatformDependent0.javaVersion() <= 8) {
            PlatformDependent0.copyMemoryWithSafePointPolling(src, srcOffset, dst, dstOffset, length);
        } else {
            UNSAFE.copyMemory(src, srcOffset, dst, dstOffset, length);
        }
    }

    private static void copyMemoryWithSafePointPolling(Object src, long srcOffset, Object dst, long dstOffset, long length) {
        while (length > 0L) {
            long size = Math.min(length, 0x100000L);
            UNSAFE.copyMemory(src, srcOffset, dst, dstOffset, size);
            length -= size;
            srcOffset += size;
            dstOffset += size;
        }
    }

    static void setMemory(long address, long bytes, byte value) {
        UNSAFE.setMemory(address, bytes, value);
    }

    static void setMemory(Object o2, long offset, long bytes, byte value) {
        UNSAFE.setMemory(o2, offset, bytes, value);
    }

    static boolean equals(byte[] bytes1, int startPos1, byte[] bytes2, int startPos2, int length) {
        long pos;
        int remainingBytes = length & 7;
        long baseOffset1 = BYTE_ARRAY_BASE_OFFSET + (long)startPos1;
        long diff = startPos2 - startPos1;
        if (length >= 8) {
            long end = baseOffset1 + (long)remainingBytes;
            for (long i2 = baseOffset1 - 8L + (long)length; i2 >= end; i2 -= 8L) {
                if (UNSAFE.getLong((Object)bytes1, i2) == UNSAFE.getLong((Object)bytes2, i2 + diff)) continue;
                return false;
            }
        }
        if (remainingBytes >= 4 && UNSAFE.getInt((Object)bytes1, pos = baseOffset1 + (long)(remainingBytes -= 4)) != UNSAFE.getInt((Object)bytes2, pos + diff)) {
            return false;
        }
        long baseOffset2 = baseOffset1 + diff;
        if (remainingBytes >= 2) {
            return UNSAFE.getChar((Object)bytes1, baseOffset1) == UNSAFE.getChar((Object)bytes2, baseOffset2) && (remainingBytes == 2 || UNSAFE.getByte((Object)bytes1, baseOffset1 + 2L) == UNSAFE.getByte((Object)bytes2, baseOffset2 + 2L));
        }
        return remainingBytes == 0 || UNSAFE.getByte((Object)bytes1, baseOffset1) == UNSAFE.getByte((Object)bytes2, baseOffset2);
    }

    static int equalsConstantTime(byte[] bytes1, int startPos1, byte[] bytes2, int startPos2, int length) {
        long pos;
        long result = 0L;
        long remainingBytes = length & 7;
        long baseOffset1 = BYTE_ARRAY_BASE_OFFSET + (long)startPos1;
        long end = baseOffset1 + remainingBytes;
        long diff = startPos2 - startPos1;
        for (long i2 = baseOffset1 - 8L + (long)length; i2 >= end; i2 -= 8L) {
            result |= UNSAFE.getLong((Object)bytes1, i2) ^ UNSAFE.getLong((Object)bytes2, i2 + diff);
        }
        if (remainingBytes >= 4L) {
            result |= (long)(UNSAFE.getInt((Object)bytes1, baseOffset1) ^ UNSAFE.getInt((Object)bytes2, baseOffset1 + diff));
            remainingBytes -= 4L;
        }
        if (remainingBytes >= 2L) {
            pos = end - remainingBytes;
            result |= (long)(UNSAFE.getChar((Object)bytes1, pos) ^ UNSAFE.getChar((Object)bytes2, pos + diff));
            remainingBytes -= 2L;
        }
        if (remainingBytes == 1L) {
            pos = end - 1L;
            result |= (long)(UNSAFE.getByte((Object)bytes1, pos) ^ UNSAFE.getByte((Object)bytes2, pos + diff));
        }
        return ConstantTimeUtils.equalsConstantTime(result, 0L);
    }

    static boolean isZero(byte[] bytes, int startPos, int length) {
        if (length <= 0) {
            return true;
        }
        long baseOffset = BYTE_ARRAY_BASE_OFFSET + (long)startPos;
        int remainingBytes = length & 7;
        long end = baseOffset + (long)remainingBytes;
        for (long i2 = baseOffset - 8L + (long)length; i2 >= end; i2 -= 8L) {
            if (UNSAFE.getLong((Object)bytes, i2) == 0L) continue;
            return false;
        }
        if (remainingBytes >= 4 && UNSAFE.getInt((Object)bytes, baseOffset + (long)(remainingBytes -= 4)) != 0) {
            return false;
        }
        if (remainingBytes >= 2) {
            return UNSAFE.getChar((Object)bytes, baseOffset) == '\u0000' && (remainingBytes == 2 || bytes[startPos + 2] == 0);
        }
        return bytes[startPos] == 0;
    }

    static int hashCodeAscii(byte[] bytes, int startPos, int length) {
        int hash = -1028477387;
        long baseOffset = BYTE_ARRAY_BASE_OFFSET + (long)startPos;
        int remainingBytes = length & 7;
        long end = baseOffset + (long)remainingBytes;
        for (long i2 = baseOffset - 8L + (long)length; i2 >= end; i2 -= 8L) {
            hash = PlatformDependent0.hashCodeAsciiCompute(UNSAFE.getLong((Object)bytes, i2), hash);
        }
        if (remainingBytes == 0) {
            return hash;
        }
        int hcConst = -862048943;
        if (remainingBytes != 2 & remainingBytes != 4 & remainingBytes != 6) {
            hash = hash * -862048943 + PlatformDependent0.hashCodeAsciiSanitize(UNSAFE.getByte((Object)bytes, baseOffset));
            hcConst = 461845907;
            ++baseOffset;
        }
        if (remainingBytes != 1 & remainingBytes != 4 & remainingBytes != 5) {
            hash = hash * hcConst + PlatformDependent0.hashCodeAsciiSanitize(UNSAFE.getShort((Object)bytes, baseOffset));
            hcConst = hcConst == -862048943 ? 461845907 : -862048943;
            baseOffset += 2L;
        }
        if (remainingBytes >= 4) {
            return hash * hcConst + PlatformDependent0.hashCodeAsciiSanitize(UNSAFE.getInt((Object)bytes, baseOffset));
        }
        return hash;
    }

    static int hashCodeAsciiCompute(long value, int hash) {
        return hash * -862048943 + PlatformDependent0.hashCodeAsciiSanitize((int)value) * 461845907 + (int)((value & 0x1F1F1F1F00000000L) >>> 32);
    }

    static int hashCodeAsciiSanitize(int value) {
        return value & 0x1F1F1F1F;
    }

    static int hashCodeAsciiSanitize(short value) {
        return value & 0x1F1F;
    }

    static int hashCodeAsciiSanitize(byte value) {
        return value & 0x1F;
    }

    static ClassLoader getClassLoader(final Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            @Override
            public ClassLoader run() {
                return clazz.getClassLoader();
            }
        });
    }

    static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            @Override
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            @Override
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int addressSize() {
        return UNSAFE.addressSize();
    }

    static long allocateMemory(long size) {
        return UNSAFE.allocateMemory(size);
    }

    static void freeMemory(long address) {
        UNSAFE.freeMemory(address);
    }

    static long reallocateMemory(long address, long newSize) {
        return UNSAFE.reallocateMemory(address, newSize);
    }

    static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        String vmName = SystemPropertyUtil.get("java.vm.name");
        boolean isAndroid = "Dalvik".equals(vmName);
        if (isAndroid) {
            logger.debug("Platform: Android");
        }
        return isAndroid;
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("net.darkmeow.irc.lib.io.netty.tryReflectionSetAccessible", PlatformDependent0.javaVersion() < 9 || RUNNING_IN_NATIVE_IMAGE);
    }

    static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersion = PlatformDependent0.isAndroid() ? 6 : PlatformDependent0.majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", (Object)majorVersion);
        return majorVersion;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return PlatformDependent0.majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    static int majorVersion(String javaSpecVersion) {
        String[] components = javaSpecVersion.split("\\.");
        int[] version = new int[components.length];
        for (int i2 = 0; i2 < components.length; ++i2) {
            version[i2] = Integer.parseInt(components[i2]);
        }
        if (version[0] == 1) {
            assert (version[1] >= 6);
            return version[1];
        }
        return version[0];
    }

    private PlatformDependent0() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Unsafe unsafe;
        ByteBuffer direct;
        logger = InternalLoggerFactory.getInstance(PlatformDependent0.class);
        IS_ANDROID = PlatformDependent0.isAndroid0();
        JAVA_VERSION = PlatformDependent0.javaVersion0();
        EXPLICIT_NO_UNSAFE_CAUSE = PlatformDependent0.explicitNoUnsafeCause0();
        RUNNING_IN_NATIVE_IMAGE = SystemPropertyUtil.contains("org.graalvm.nativeimage.imagecode");
        IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = PlatformDependent0.explicitTryReflectionSetAccessible0();
        IS_VIRTUAL_THREAD_METHOD_HANDLE = PlatformDependent0.getIsVirtualThreadMethodHandle();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        Field addressField = null;
        MethodHandle allocateArrayMethod = null;
        Throwable unsafeUnavailabilityCause = EXPLICIT_NO_UNSAFE_CAUSE;
        if (unsafeUnavailabilityCause != null) {
            direct = null;
            addressField = null;
            unsafe = null;
        } else {
            long byteArrayIndexScale;
            Unsafe finalUnsafe;
            direct = ByteBuffer.allocateDirect(1);
            Object maybeUnsafe = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                @Override
                public Object run() {
                    try {
                        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable cause = ReflectionUtil.trySetAccessible(unsafeField, false);
                        if (cause != null) {
                            return cause;
                        }
                        return unsafeField.get(null);
                    }
                    catch (NoSuchFieldException e2) {
                        return e2;
                    }
                    catch (SecurityException e3) {
                        return e3;
                    }
                    catch (IllegalAccessException e4) {
                        return e4;
                    }
                    catch (NoClassDefFoundError e5) {
                        return e5;
                    }
                }
            });
            if (maybeUnsafe instanceof Throwable) {
                unsafe = null;
                unsafeUnavailabilityCause = (Throwable)maybeUnsafe;
                if (logger.isTraceEnabled()) {
                    logger.debug("sun.misc.Unsafe.theUnsafe: unavailable", (Throwable)maybeUnsafe);
                } else {
                    logger.debug("sun.misc.Unsafe.theUnsafe: unavailable: {}", (Object)unsafeUnavailabilityCause.getMessage());
                }
            } else {
                unsafe = (Unsafe)maybeUnsafe;
                logger.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                finalUnsafe = unsafe;
                Object maybeException = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                    @Override
                    public Object run() {
                        try {
                            Class<?> cls = finalUnsafe.getClass();
                            cls.getDeclaredMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                            if (PlatformDependent0.javaVersion() > 23) {
                                cls.getDeclaredMethod("objectFieldOffset", Field.class);
                                cls.getDeclaredMethod("staticFieldOffset", Field.class);
                                cls.getDeclaredMethod("staticFieldBase", Field.class);
                                cls.getDeclaredMethod("arrayBaseOffset", Class.class);
                                cls.getDeclaredMethod("arrayIndexScale", Class.class);
                                cls.getDeclaredMethod("allocateMemory", Long.TYPE);
                                cls.getDeclaredMethod("reallocateMemory", Long.TYPE, Long.TYPE);
                                cls.getDeclaredMethod("freeMemory", Long.TYPE);
                                cls.getDeclaredMethod("setMemory", Long.TYPE, Long.TYPE, Byte.TYPE);
                                cls.getDeclaredMethod("setMemory", Object.class, Long.TYPE, Long.TYPE, Byte.TYPE);
                                cls.getDeclaredMethod("getBoolean", Object.class, Long.TYPE);
                                cls.getDeclaredMethod("getByte", Long.TYPE);
                                cls.getDeclaredMethod("getByte", Object.class, Long.TYPE);
                                cls.getDeclaredMethod("getInt", Long.TYPE);
                                cls.getDeclaredMethod("getInt", Object.class, Long.TYPE);
                                cls.getDeclaredMethod("getLong", Long.TYPE);
                                cls.getDeclaredMethod("getLong", Object.class, Long.TYPE);
                                cls.getDeclaredMethod("putByte", Long.TYPE, Byte.TYPE);
                                cls.getDeclaredMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
                                cls.getDeclaredMethod("putInt", Long.TYPE, Integer.TYPE);
                                cls.getDeclaredMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                                cls.getDeclaredMethod("putLong", Long.TYPE, Long.TYPE);
                                cls.getDeclaredMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                                cls.getDeclaredMethod("addressSize", new Class[0]);
                            }
                            if (PlatformDependent0.javaVersion() >= 23) {
                                long address = finalUnsafe.allocateMemory(8L);
                                finalUnsafe.putLong(address, 42L);
                                finalUnsafe.freeMemory(address);
                            }
                            return null;
                        }
                        catch (UnsupportedOperationException e2) {
                            return e2;
                        }
                        catch (NoSuchMethodException e3) {
                            return e3;
                        }
                        catch (SecurityException e4) {
                            return e4;
                        }
                    }
                });
                if (maybeException == null) {
                    logger.debug("sun.misc.Unsafe base methods: all available");
                } else {
                    unsafe = null;
                    unsafeUnavailabilityCause = (Throwable)maybeException;
                    if (logger.isTraceEnabled()) {
                        logger.debug("sun.misc.Unsafe method unavailable:", unsafeUnavailabilityCause);
                    } else {
                        logger.debug("sun.misc.Unsafe method unavailable: {}", (Object)((Throwable)maybeException).getMessage());
                    }
                }
            }
            if (unsafe != null) {
                finalUnsafe = unsafe;
                Object maybeAddressField = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                    @Override
                    public Object run() {
                        try {
                            Field field = Buffer.class.getDeclaredField("address");
                            long offset = finalUnsafe.objectFieldOffset(field);
                            long address = finalUnsafe.getLong((Object)direct, offset);
                            if (address == 0L) {
                                return null;
                            }
                            return field;
                        }
                        catch (NoSuchFieldException e2) {
                            return e2;
                        }
                        catch (SecurityException e3) {
                            return e3;
                        }
                    }
                });
                if (maybeAddressField instanceof Field) {
                    addressField = (Field)maybeAddressField;
                    logger.debug("java.nio.Buffer.address: available");
                } else {
                    unsafeUnavailabilityCause = (Throwable)maybeAddressField;
                    if (logger.isTraceEnabled()) {
                        logger.debug("java.nio.Buffer.address: unavailable", (Throwable)maybeAddressField);
                    } else {
                        logger.debug("java.nio.Buffer.address: unavailable: {}", (Object)((Throwable)maybeAddressField).getMessage());
                    }
                    unsafe = null;
                }
            }
            if (unsafe != null && (byteArrayIndexScale = (long)unsafe.arrayIndexScale(byte[].class)) != 1L) {
                logger.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", (Object)byteArrayIndexScale);
                unsafeUnavailabilityCause = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                unsafe = null;
            }
        }
        UNSAFE_UNAVAILABILITY_CAUSE = unsafeUnavailabilityCause;
        UNSAFE = unsafe;
        if (unsafe == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            LONG_ARRAY_BASE_OFFSET = -1L;
            LONG_ARRAY_INDEX_SCALE = -1L;
            INT_ARRAY_BASE_OFFSET = -1L;
            INT_ARRAY_INDEX_SCALE = -1L;
            UNALIGNED = false;
            BITS_MAX_DIRECT_MEMORY = -1L;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
        } else {
            boolean unaligned;
            MethodHandle directBufferConstructor;
            long address = -1L;
            try {
                Object maybeDirectBufferConstructor = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                    @Override
                    public Object run() {
                        try {
                            Class<?> directClass = direct.getClass();
                            Constructor<?> constructor = PlatformDependent0.javaVersion() >= 21 ? directClass.getDeclaredConstructor(Long.TYPE, Long.TYPE) : directClass.getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable cause = ReflectionUtil.trySetAccessible(constructor, true);
                            if (cause != null) {
                                return cause;
                            }
                            return lookup.unreflectConstructor(constructor).asType(MethodType.methodType(ByteBuffer.class, Long.TYPE, Integer.TYPE));
                        }
                        catch (Throwable e2) {
                            return e2;
                        }
                    }
                });
                if (maybeDirectBufferConstructor instanceof MethodHandle) {
                    address = UNSAFE.allocateMemory(1L);
                    try {
                        MethodHandle constructor = (MethodHandle)maybeDirectBufferConstructor;
                        ByteBuffer ignore = constructor.invokeExact(address, 1);
                        directBufferConstructor = constructor;
                        logger.debug("direct buffer constructor: available");
                    }
                    catch (Throwable e2) {
                        directBufferConstructor = null;
                    }
                } else {
                    if (logger.isTraceEnabled()) {
                        logger.debug("direct buffer constructor: unavailable", (Throwable)maybeDirectBufferConstructor);
                    } else {
                        logger.debug("direct buffer constructor: unavailable: {}", (Object)((Throwable)maybeDirectBufferConstructor).getMessage());
                    }
                    directBufferConstructor = null;
                }
            }
            finally {
                if (address != -1L) {
                    UNSAFE.freeMemory(address);
                }
            }
            DIRECT_BUFFER_CONSTRUCTOR = directBufferConstructor;
            ADDRESS_FIELD_OFFSET = PlatformDependent0.objectFieldOffset(addressField);
            BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
            INT_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(int[].class);
            INT_ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(int[].class);
            LONG_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(long[].class);
            LONG_ARRAY_INDEX_SCALE = UNSAFE.arrayIndexScale(long[].class);
            final AtomicLong maybeMaxMemory = new AtomicLong(-1L);
            Object maybeUnaligned = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                @Override
                public Object run() {
                    try {
                        Method unalignedMethod;
                        Throwable cause;
                        Class<?> bitsClass = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader());
                        int version = PlatformDependent0.javaVersion();
                        if (PlatformDependent0.unsafeStaticFieldOffsetSupported() && version >= 9) {
                            Object object;
                            long offset;
                            String fieldName = version >= 11 ? "MAX_MEMORY" : "maxMemory";
                            try {
                                Field maxMemoryField = bitsClass.getDeclaredField(fieldName);
                                if (maxMemoryField.getType() == Long.TYPE) {
                                    offset = UNSAFE.staticFieldOffset(maxMemoryField);
                                    object = UNSAFE.staticFieldBase(maxMemoryField);
                                    maybeMaxMemory.lazySet(UNSAFE.getLong(object, offset));
                                }
                            }
                            catch (Throwable maxMemoryField) {
                                // empty catch block
                            }
                            fieldName = version >= 11 ? "UNALIGNED" : "unaligned";
                            try {
                                Field unalignedField = bitsClass.getDeclaredField(fieldName);
                                if (unalignedField.getType() == Boolean.TYPE) {
                                    offset = UNSAFE.staticFieldOffset(unalignedField);
                                    object = UNSAFE.staticFieldBase(unalignedField);
                                    return UNSAFE.getBoolean(object, offset);
                                }
                            }
                            catch (NoSuchFieldException unalignedField) {
                                // empty catch block
                            }
                        }
                        if ((cause = ReflectionUtil.trySetAccessible(unalignedMethod = bitsClass.getDeclaredMethod("unaligned", new Class[0]), true)) != null) {
                            return cause;
                        }
                        return unalignedMethod.invoke(null, new Object[0]);
                    }
                    catch (NoSuchMethodException e2) {
                        return e2;
                    }
                    catch (SecurityException e3) {
                        return e3;
                    }
                    catch (IllegalAccessException e4) {
                        return e4;
                    }
                    catch (ClassNotFoundException e5) {
                        return e5;
                    }
                    catch (InvocationTargetException e6) {
                        return e6;
                    }
                }
            });
            if (maybeUnaligned instanceof Boolean) {
                unaligned = (Boolean)maybeUnaligned;
                logger.debug("java.nio.Bits.unaligned: available, {}", (Object)unaligned);
            } else {
                String arch = SystemPropertyUtil.get("os.arch", "");
                unaligned = arch.matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                Throwable t2 = (Throwable)maybeUnaligned;
                if (logger.isTraceEnabled()) {
                    logger.debug("java.nio.Bits.unaligned: unavailable, {}", (Object)unaligned, (Object)t2);
                } else {
                    logger.debug("java.nio.Bits.unaligned: unavailable, {}, {}", (Object)unaligned, (Object)t2.getMessage());
                }
            }
            UNALIGNED = unaligned;
            long l2 = BITS_MAX_DIRECT_MEMORY = maybeMaxMemory.get() >= 0L ? maybeMaxMemory.get() : -1L;
            if (PlatformDependent0.javaVersion() >= 9) {
                Object finalInternalUnsafe;
                Object maybeException = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                    @Override
                    public Object run() {
                        try {
                            Class<?> cls = PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe");
                            return lookup.findStatic(cls, "getUnsafe", MethodType.methodType(cls)).invoke();
                        }
                        catch (Throwable e2) {
                            return e2;
                        }
                    }
                });
                if (!(maybeException instanceof Throwable) && (maybeException = AccessController.doPrivileged(new PrivilegedAction<Object>(finalInternalUnsafe = maybeException, lookup){
                    final /* synthetic */ Object val$finalInternalUnsafe;
                    final /* synthetic */ MethodHandles.Lookup val$lookup;
                    {
                        this.val$finalInternalUnsafe = object;
                        this.val$lookup = lookup;
                    }

                    @Override
                    public Object run() {
                        try {
                            Class<?> finalInternalUnsafeClass = this.val$finalInternalUnsafe.getClass();
                            return this.val$lookup.findVirtual(finalInternalUnsafeClass, "allocateUninitializedArray", MethodType.methodType(Object.class, Class.class, Integer.TYPE));
                        }
                        catch (Throwable e2) {
                            return e2;
                        }
                    }
                })) instanceof MethodHandle) {
                    try {
                        MethodHandle m2 = (MethodHandle)maybeException;
                        m2 = m2.bindTo(finalInternalUnsafe);
                        byte[] bytes = (byte[])m2.invokeExact(Byte.TYPE, 8);
                        assert (bytes.length == 8);
                        allocateArrayMethod = m2;
                    }
                    catch (Throwable e3) {
                        maybeException = e3;
                    }
                }
                if (maybeException instanceof Throwable) {
                    if (logger.isTraceEnabled()) {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable)maybeException);
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable: {}", (Object)((Throwable)maybeException).getMessage());
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                }
            } else {
                logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
            }
            ALLOCATE_ARRAY_METHOD = allocateArrayMethod;
        }
        ALIGN_SLICE = PlatformDependent0.javaVersion() > 9 ? (MethodHandle)AccessController.doPrivileged(new PrivilegedAction<Object>(){

            @Override
            public Object run() {
                try {
                    return MethodHandles.publicLookup().findVirtual(ByteBuffer.class, "alignedSlice", MethodType.methodType(ByteBuffer.class, Integer.TYPE));
                }
                catch (Throwable e2) {
                    return null;
                }
            }
        }) : null;
        logger.debug("java.nio.DirectByteBuffer.<init>(long, {int,long}): {}", (Object)(DIRECT_BUFFER_CONSTRUCTOR != null ? "available" : "unavailable"));
    }
}

