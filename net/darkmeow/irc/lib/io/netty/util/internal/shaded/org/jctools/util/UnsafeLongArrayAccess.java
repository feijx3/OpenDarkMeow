/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

public final class UnsafeLongArrayAccess {
    public static final long LONG_ARRAY_BASE;
    public static final int LONG_ELEMENT_SHIFT;

    public static void spLongElement(long[] buffer, long offset, long e2) {
        UnsafeAccess.UNSAFE.putLong((Object)buffer, offset, e2);
    }

    public static void soLongElement(long[] buffer, long offset, long e2) {
        UnsafeAccess.UNSAFE.putOrderedLong(buffer, offset, e2);
    }

    public static long lpLongElement(long[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getLong((Object)buffer, offset);
    }

    public static long lvLongElement(long[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getLongVolatile(buffer, offset);
    }

    public static long calcLongElementOffset(long index) {
        return LONG_ARRAY_BASE + (index << LONG_ELEMENT_SHIFT);
    }

    public static long calcCircularLongElementOffset(long index, long mask) {
        return LONG_ARRAY_BASE + ((index & mask) << LONG_ELEMENT_SHIFT);
    }

    public static long[] allocateLongArray(int capacity) {
        return new long[capacity];
    }

    static {
        int scale = UnsafeAccess.UNSAFE.arrayIndexScale(long[].class);
        if (8 != scale) {
            throw new IllegalStateException("Unknown pointer size: " + scale);
        }
        LONG_ELEMENT_SHIFT = 3;
        LONG_ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class);
    }
}

