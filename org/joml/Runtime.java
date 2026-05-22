/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.text.NumberFormat;
import org.joml.Math;
import org.joml.Options;

public final class Runtime {
    public static final boolean HAS_floatToRawIntBits = Runtime.hasFloatToRawIntBits();
    public static final boolean HAS_doubleToRawLongBits = Runtime.hasDoubleToRawLongBits();
    public static final boolean HAS_Long_rotateLeft = Runtime.hasLongRotateLeft();
    public static final boolean HAS_Math_fma = Options.USE_MATH_FMA && Runtime.hasMathFma();

    private static boolean hasMathFma() {
        try {
            java.lang.Math.class.getDeclaredMethod("fma", Float.TYPE, Float.TYPE, Float.TYPE);
            return true;
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }

    private Runtime() {
    }

    private static boolean hasFloatToRawIntBits() {
        try {
            Float.class.getDeclaredMethod("floatToRawIntBits", Float.TYPE);
            return true;
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }

    private static boolean hasDoubleToRawLongBits() {
        try {
            Double.class.getDeclaredMethod("doubleToRawLongBits", Double.TYPE);
            return true;
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }

    private static boolean hasLongRotateLeft() {
        try {
            Long.class.getDeclaredMethod("rotateLeft", Long.TYPE, Integer.TYPE);
            return true;
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }

    public static int floatToIntBits(float flt) {
        if (HAS_floatToRawIntBits) {
            return Runtime.floatToIntBits1_3(flt);
        }
        return Runtime.floatToIntBits1_2(flt);
    }

    private static int floatToIntBits1_3(float flt) {
        return Float.floatToRawIntBits(flt);
    }

    private static int floatToIntBits1_2(float flt) {
        return Float.floatToIntBits(flt);
    }

    public static long doubleToLongBits(double dbl) {
        if (HAS_doubleToRawLongBits) {
            return Runtime.doubleToLongBits1_3(dbl);
        }
        return Runtime.doubleToLongBits1_2(dbl);
    }

    private static long doubleToLongBits1_3(double dbl) {
        return Double.doubleToRawLongBits(dbl);
    }

    private static long doubleToLongBits1_2(double dbl) {
        return Double.doubleToLongBits(dbl);
    }

    public static String formatNumbers(String str) {
        StringBuffer res = new StringBuffer();
        int eIndex = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < str.length(); ++i2) {
            char c2 = str.charAt(i2);
            if (c2 == 'E') {
                eIndex = i2;
            } else {
                if (c2 == ' ' && eIndex == i2 - 1) {
                    res.append('+');
                    continue;
                }
                if (Character.isDigit(c2) && eIndex == i2 - 1) {
                    res.append('+');
                }
            }
            res.append(c2);
        }
        return res.toString();
    }

    public static String format(double number, NumberFormat format) {
        if (Double.isNaN(number)) {
            return Runtime.padLeft(format, " NaN");
        }
        if (Double.isInfinite(number)) {
            return Runtime.padLeft(format, number > 0.0 ? " +Inf" : " -Inf");
        }
        return format.format(number);
    }

    private static String padLeft(NumberFormat format, String str) {
        int len = format.format(0.0).length();
        StringBuffer sb = new StringBuffer();
        for (int i2 = 0; i2 < len - str.length() + 1; ++i2) {
            sb.append(" ");
        }
        return sb.append(str).toString();
    }

    public static boolean equals(float a2, float b2, float delta) {
        return Float.floatToIntBits(a2) == Float.floatToIntBits(b2) || Math.abs(a2 - b2) <= delta;
    }

    public static boolean equals(double a2, double b2, double delta) {
        return Double.doubleToLongBits(a2) == Double.doubleToLongBits(b2) || Math.abs(a2 - b2) <= delta;
    }
}

