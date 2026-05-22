/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

public final class Limit {
    public static int max(int value, int max) {
        if (value > max) {
            throw new IllegalArgumentException(Limit.jvmdowngrader$concat$max$1(value, max));
        }
        return value;
    }

    private static String jvmdowngrader$concat$max$1(int n2, int n3) {
        return "Value " + n2 + " is higher than the maximum " + n3;
    }
}

