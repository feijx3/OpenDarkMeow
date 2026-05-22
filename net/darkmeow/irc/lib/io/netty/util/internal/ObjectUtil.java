/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.util.Collection;
import java.util.Map;

public final class ObjectUtil {
    private static final float FLOAT_ZERO = 0.0f;
    private static final double DOUBLE_ZERO = 0.0;
    private static final long LONG_ZERO = 0L;
    private static final int INT_ZERO = 0;
    private static final short SHORT_ZERO = 0;

    private ObjectUtil() {
    }

    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }

    public static <T> T[] deepCheckNotNull(String text, T ... varargs) {
        if (varargs == null) {
            throw new NullPointerException(text);
        }
        for (T element : varargs) {
            if (element != null) continue;
            throw new NullPointerException(text);
        }
        return varargs;
    }

    public static <T> T checkNotNullWithIAE(T arg, String paramName) throws IllegalArgumentException {
        if (arg == null) {
            throw new IllegalArgumentException("Param '" + paramName + "' must not be null");
        }
        return arg;
    }

    public static <T> T checkNotNullArrayParam(T value, int index, String name) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("Array index " + index + " of parameter '" + name + "' must not be null");
        }
        return value;
    }

    public static int checkPositive(int i2, String name) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(name + " : " + i2 + " (expected: > 0)");
        }
        return i2;
    }

    public static long checkPositive(long l2, String name) {
        if (l2 <= 0L) {
            throw new IllegalArgumentException(name + " : " + l2 + " (expected: > 0)");
        }
        return l2;
    }

    public static double checkPositive(double d2, String name) {
        if (d2 <= 0.0) {
            throw new IllegalArgumentException(name + " : " + d2 + " (expected: > 0)");
        }
        return d2;
    }

    public static float checkPositive(float f2, String name) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException(name + " : " + f2 + " (expected: > 0)");
        }
        return f2;
    }

    public static short checkPositive(short s2, String name) {
        if (s2 <= 0) {
            throw new IllegalArgumentException(name + " : " + s2 + " (expected: > 0)");
        }
        return s2;
    }

    public static int checkPositiveOrZero(int i2, String name) {
        if (i2 < 0) {
            throw new IllegalArgumentException(name + " : " + i2 + " (expected: >= 0)");
        }
        return i2;
    }

    public static long checkPositiveOrZero(long l2, String name) {
        if (l2 < 0L) {
            throw new IllegalArgumentException(name + " : " + l2 + " (expected: >= 0)");
        }
        return l2;
    }

    public static double checkPositiveOrZero(double d2, String name) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException(name + " : " + d2 + " (expected: >= 0)");
        }
        return d2;
    }

    public static float checkPositiveOrZero(float f2, String name) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(name + " : " + f2 + " (expected: >= 0)");
        }
        return f2;
    }

    public static int checkInRange(int i2, int start, int end, String name) {
        if (i2 < start || i2 > end) {
            throw new IllegalArgumentException(name + ": " + i2 + " (expected: " + start + "-" + end + ")");
        }
        return i2;
    }

    public static long checkInRange(long l2, long start, long end, String name) {
        if (l2 < start || l2 > end) {
            throw new IllegalArgumentException(name + ": " + l2 + " (expected: " + start + "-" + end + ")");
        }
        return l2;
    }

    public static <T> T[] checkNonEmpty(T[] array, String name) {
        if (ObjectUtil.checkNotNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    public static byte[] checkNonEmpty(byte[] array, String name) {
        if (ObjectUtil.checkNotNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    public static char[] checkNonEmpty(char[] array, String name) {
        if (ObjectUtil.checkNotNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    public static <T extends Collection<?>> T checkNonEmpty(T collection, String name) {
        if (ObjectUtil.checkNotNull(collection, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return collection;
    }

    public static String checkNonEmpty(String value, String name) {
        if (ObjectUtil.checkNotNull(value, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    public static <K, V, T extends Map<K, V>> T checkNonEmpty(T value, String name) {
        if (ObjectUtil.checkNotNull(value, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    public static CharSequence checkNonEmpty(CharSequence value, String name) {
        if (ObjectUtil.checkNotNull(value, name).length() == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    public static String checkNonEmptyAfterTrim(String value, String name) {
        String trimmed = ObjectUtil.checkNotNull(value, name).trim();
        return ObjectUtil.checkNonEmpty(trimmed, name);
    }

    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }

    public static long longValue(Long wrapper, long defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }
}

