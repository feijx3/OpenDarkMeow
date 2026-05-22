/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util;

public final class RangeUtil {
    public static long checkPositive(long n2, String name) {
        if (n2 <= 0L) {
            throw new IllegalArgumentException(name + ": " + n2 + " (expected: > 0)");
        }
        return n2;
    }

    public static int checkPositiveOrZero(int n2, String name) {
        if (n2 < 0) {
            throw new IllegalArgumentException(name + ": " + n2 + " (expected: >= 0)");
        }
        return n2;
    }

    public static int checkLessThan(int n2, int expected, String name) {
        if (n2 >= expected) {
            throw new IllegalArgumentException(name + ": " + n2 + " (expected: < " + expected + ')');
        }
        return n2;
    }

    public static int checkLessThanOrEqual(int n2, long expected, String name) {
        if ((long)n2 > expected) {
            throw new IllegalArgumentException(name + ": " + n2 + " (expected: <= " + expected + ')');
        }
        return n2;
    }

    public static int checkGreaterThanOrEqual(int n2, int expected, String name) {
        if (n2 < expected) {
            throw new IllegalArgumentException(name + ": " + n2 + " (expected: >= " + expected + ')');
        }
        return n2;
    }
}

