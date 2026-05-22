/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import org.joml.Options;
import org.joml.Runtime;

public class Math {
    public static final double PI = java.lang.Math.PI;
    static final double PI2 = java.lang.Math.PI * 2;
    static final float PI_f = (float)java.lang.Math.PI;
    static final float PI2_f = (float)java.lang.Math.PI * 2;
    static final double PIHalf = 1.5707963267948966;
    static final float PIHalf_f = 1.5707964f;
    static final double PI_4 = 0.7853981633974483;
    static final double PI_INV = 0.3183098861837907;
    private static final int lookupBits = Options.SIN_LOOKUP_BITS;
    private static final int lookupTableSize = 1 << lookupBits;
    private static final int lookupTableSizeMinus1 = lookupTableSize - 1;
    private static final int lookupTableSizeWithMargin = lookupTableSize + 1;
    private static final float pi2OverLookupSize = (float)java.lang.Math.PI * 2 / (float)lookupTableSize;
    private static final float lookupSizeOverPi2 = (float)lookupTableSize / ((float)java.lang.Math.PI * 2);
    private static final float[] sinTable;
    private static final double c1;
    private static final double c2;
    private static final double c3;
    private static final double c4;
    private static final double c5;
    private static final double c6;
    private static final double c7;
    private static final double s5;
    private static final double s4;
    private static final double s3;
    private static final double s2;
    private static final double s1;
    private static final double k1;
    private static final double k2;
    private static final double k3;
    private static final double k4;
    private static final double k5;
    private static final double k6;
    private static final double k7;

    static double sin_theagentd_arith(double x2) {
        double xi = Math.floor((x2 + 0.7853981633974483) * 0.3183098861837907);
        double x_ = x2 - xi * java.lang.Math.PI;
        double sign = ((int)xi & 1) * -2 + 1;
        double x22 = x_ * x_;
        double sin = x_;
        double tx = x_ * x22;
        sin += tx * c1;
        sin += (tx *= x22) * c2;
        sin += (tx *= x22) * c3;
        sin += (tx *= x22) * c4;
        sin += (tx *= x22) * c5;
        sin += (tx *= x22) * c6;
        return sign * (sin += (tx *= x22) * c7);
    }

    static double sin_roquen_arith(double x2) {
        double xi = Math.floor((x2 + 0.7853981633974483) * 0.3183098861837907);
        double x_ = x2 - xi * java.lang.Math.PI;
        double sign = ((int)xi & 1) * -2 + 1;
        double x22 = x_ * x_;
        x_ = sign * x_;
        double sin = c7;
        sin = sin * x22 + c6;
        sin = sin * x22 + c5;
        sin = sin * x22 + c4;
        sin = sin * x22 + c3;
        sin = sin * x22 + c2;
        sin = sin * x22 + c1;
        return x_ + x_ * x22 * sin;
    }

    static double sin_roquen_9(double v2) {
        double i2 = java.lang.Math.rint(v2 * 0.3183098861837907);
        double x2 = v2 - i2 * java.lang.Math.PI;
        double qs = 1 - 2 * ((int)i2 & 1);
        double x22 = x2 * x2;
        x2 = qs * x2;
        double r2 = s5;
        r2 = r2 * x22 + s4;
        r2 = r2 * x22 + s3;
        r2 = r2 * x22 + s2;
        r2 = r2 * x22 + s1;
        return x2 * r2;
    }

    static double sin_roquen_newk(double v2) {
        double i2 = java.lang.Math.rint(v2 * 0.3183098861837907);
        double x2 = v2 - i2 * java.lang.Math.PI;
        double qs = 1 - 2 * ((int)i2 & 1);
        double x22 = x2 * x2;
        x2 = qs * x2;
        double r2 = k7;
        r2 = r2 * x22 + k6;
        r2 = r2 * x22 + k5;
        r2 = r2 * x22 + k4;
        r2 = r2 * x22 + k3;
        r2 = r2 * x22 + k2;
        r2 = r2 * x22 + k1;
        return x2 + x2 * x22 * r2;
    }

    static float sin_theagentd_lookup(float rad) {
        float index = rad * lookupSizeOverPi2;
        int ii = (int)java.lang.Math.floor(index);
        float alpha = index - (float)ii;
        int i2 = ii & lookupTableSizeMinus1;
        float sin1 = sinTable[i2];
        float sin2 = sinTable[i2 + 1];
        return sin1 + (sin2 - sin1) * alpha;
    }

    public static float sin(float rad) {
        if (Options.FASTMATH) {
            if (Options.SIN_LOOKUP) {
                return Math.sin_theagentd_lookup(rad);
            }
            return (float)Math.sin_roquen_newk(rad);
        }
        return (float)java.lang.Math.sin(rad);
    }

    public static double sin(double rad) {
        if (Options.FASTMATH) {
            if (Options.SIN_LOOKUP) {
                return Math.sin_theagentd_lookup((float)rad);
            }
            return Math.sin_roquen_newk(rad);
        }
        return java.lang.Math.sin(rad);
    }

    public static float cos(float rad) {
        if (Options.FASTMATH) {
            return Math.sin(rad + 1.5707964f);
        }
        return (float)java.lang.Math.cos(rad);
    }

    public static double cos(double rad) {
        if (Options.FASTMATH) {
            return Math.sin(rad + 1.5707963267948966);
        }
        return java.lang.Math.cos(rad);
    }

    public static float cosFromSin(float sin, float angle) {
        if (Options.FASTMATH) {
            return Math.sin(angle + 1.5707964f);
        }
        return Math.cosFromSinInternal(sin, angle);
    }

    private static float cosFromSinInternal(float sin, float angle) {
        float cos = Math.sqrt(1.0f - sin * sin);
        float a2 = angle + 1.5707964f;
        float b2 = a2 - (float)((int)(a2 / ((float)java.lang.Math.PI * 2))) * ((float)java.lang.Math.PI * 2);
        if ((double)b2 < 0.0) {
            b2 = (float)java.lang.Math.PI * 2 + b2;
        }
        if (b2 >= (float)java.lang.Math.PI) {
            return -cos;
        }
        return cos;
    }

    public static double cosFromSin(double sin, double angle) {
        if (Options.FASTMATH) {
            return Math.sin(angle + 1.5707963267948966);
        }
        double cos = Math.sqrt(1.0 - sin * sin);
        double a2 = angle + 1.5707963267948966;
        double b2 = a2 - (double)((int)(a2 / (java.lang.Math.PI * 2))) * (java.lang.Math.PI * 2);
        if (b2 < 0.0) {
            b2 = java.lang.Math.PI * 2 + b2;
        }
        if (b2 >= java.lang.Math.PI) {
            return -cos;
        }
        return cos;
    }

    public static float sqrt(float r2) {
        return (float)java.lang.Math.sqrt(r2);
    }

    public static double sqrt(double r2) {
        return java.lang.Math.sqrt(r2);
    }

    public static float invsqrt(float r2) {
        return 1.0f / (float)java.lang.Math.sqrt(r2);
    }

    public static double invsqrt(double r2) {
        return 1.0 / java.lang.Math.sqrt(r2);
    }

    public static float tan(float r2) {
        return (float)java.lang.Math.tan(r2);
    }

    public static double tan(double r2) {
        return java.lang.Math.tan(r2);
    }

    public static float acos(float r2) {
        return (float)java.lang.Math.acos(r2);
    }

    public static double acos(double r2) {
        return java.lang.Math.acos(r2);
    }

    public static float safeAcos(float v2) {
        if (v2 < -1.0f) {
            return (float)java.lang.Math.PI;
        }
        if (v2 > 1.0f) {
            return 0.0f;
        }
        return Math.acos(v2);
    }

    public static double safeAcos(double v2) {
        if (v2 < -1.0) {
            return java.lang.Math.PI;
        }
        if (v2 > 1.0) {
            return 0.0;
        }
        return Math.acos(v2);
    }

    private static double fastAtan2(double y2, double x2) {
        double ax2 = x2 >= 0.0 ? x2 : -x2;
        double ay2 = y2 >= 0.0 ? y2 : -y2;
        double a2 = Math.min(ax2, ay2) / Math.max(ax2, ay2);
        double s2 = a2 * a2;
        double r2 = ((-0.0464964749 * s2 + 0.15931422) * s2 - 0.327622764) * s2 * a2 + a2;
        if (ay2 > ax2) {
            r2 = 1.57079637 - r2;
        }
        if (x2 < 0.0) {
            r2 = 3.14159274 - r2;
        }
        return y2 >= 0.0 ? r2 : -r2;
    }

    public static float atan2(float y2, float x2) {
        return (float)java.lang.Math.atan2(y2, x2);
    }

    public static double atan2(double y2, double x2) {
        if (Options.FASTMATH) {
            return Math.fastAtan2(y2, x2);
        }
        return java.lang.Math.atan2(y2, x2);
    }

    public static float asin(float r2) {
        return (float)java.lang.Math.asin(r2);
    }

    public static double asin(double r2) {
        return java.lang.Math.asin(r2);
    }

    public static float safeAsin(float r2) {
        return r2 <= -1.0f ? -1.5707964f : (r2 >= 1.0f ? 1.5707964f : Math.asin(r2));
    }

    public static double safeAsin(double r2) {
        return r2 <= -1.0 ? -1.5707963267948966 : (r2 >= 1.0 ? 1.5707963267948966 : Math.asin(r2));
    }

    public static float abs(float r2) {
        return java.lang.Math.abs(r2);
    }

    public static double abs(double r2) {
        return java.lang.Math.abs(r2);
    }

    static boolean absEqualsOne(float r2) {
        return (Float.floatToRawIntBits(r2) & Integer.MAX_VALUE) == 1065353216;
    }

    static boolean absEqualsOne(double r2) {
        return (Double.doubleToRawLongBits(r2) & Long.MAX_VALUE) == 0x3FF0000000000000L;
    }

    public static int abs(int r2) {
        return java.lang.Math.abs(r2);
    }

    public static int max(int x2, int y2) {
        return java.lang.Math.max(x2, y2);
    }

    public static int min(int x2, int y2) {
        return java.lang.Math.min(x2, y2);
    }

    public static double min(double a2, double b2) {
        return a2 < b2 ? a2 : b2;
    }

    public static float min(float a2, float b2) {
        return a2 < b2 ? a2 : b2;
    }

    public static float max(float a2, float b2) {
        return a2 > b2 ? a2 : b2;
    }

    public static double max(double a2, double b2) {
        return a2 > b2 ? a2 : b2;
    }

    public static float clamp(float a2, float b2, float val) {
        return Math.max(a2, Math.min(b2, val));
    }

    public static double clamp(double a2, double b2, double val) {
        return Math.max(a2, Math.min(b2, val));
    }

    public static int clamp(int a2, int b2, int val) {
        return Math.max(a2, Math.min(b2, val));
    }

    public static float toRadians(float angles) {
        return (float)java.lang.Math.toRadians(angles);
    }

    public static double toRadians(double angles) {
        return java.lang.Math.toRadians(angles);
    }

    public static double toDegrees(double angles) {
        return java.lang.Math.toDegrees(angles);
    }

    public static double floor(double v2) {
        return java.lang.Math.floor(v2);
    }

    public static float floor(float v2) {
        return (float)java.lang.Math.floor(v2);
    }

    public static double ceil(double v2) {
        return java.lang.Math.ceil(v2);
    }

    public static float ceil(float v2) {
        return (float)java.lang.Math.ceil(v2);
    }

    public static long round(double v2) {
        return java.lang.Math.round(v2);
    }

    public static int round(float v2) {
        return java.lang.Math.round(v2);
    }

    public static double exp(double a2) {
        return java.lang.Math.exp(a2);
    }

    public static boolean isFinite(double d2) {
        return Math.abs(d2) <= Double.MAX_VALUE;
    }

    public static boolean isFinite(float f2) {
        return Math.abs(f2) <= Float.MAX_VALUE;
    }

    public static float fma(float a2, float b2, float c2) {
        if (Runtime.HAS_Math_fma) {
            return java.lang.Math.fma((float)a2, (float)b2, (float)c2);
        }
        return a2 * b2 + c2;
    }

    public static double fma(double a2, double b2, double c2) {
        if (Runtime.HAS_Math_fma) {
            return java.lang.Math.fma((double)a2, (double)b2, (double)c2);
        }
        return a2 * b2 + c2;
    }

    public static int roundUsing(float v2, int mode) {
        switch (mode) {
            case 0: {
                return (int)v2;
            }
            case 1: {
                return (int)java.lang.Math.ceil(v2);
            }
            case 2: {
                return (int)java.lang.Math.floor(v2);
            }
            case 4: {
                return Math.roundHalfDown(v2);
            }
            case 5: {
                return Math.roundHalfUp(v2);
            }
            case 3: {
                return Math.roundHalfEven(v2);
            }
        }
        throw new UnsupportedOperationException();
    }

    public static int roundUsing(double v2, int mode) {
        switch (mode) {
            case 0: {
                return (int)v2;
            }
            case 1: {
                return (int)java.lang.Math.ceil(v2);
            }
            case 2: {
                return (int)java.lang.Math.floor(v2);
            }
            case 4: {
                return Math.roundHalfDown(v2);
            }
            case 5: {
                return Math.roundHalfUp(v2);
            }
            case 3: {
                return Math.roundHalfEven(v2);
            }
        }
        throw new UnsupportedOperationException();
    }

    public static float lerp(float a2, float b2, float t2) {
        return Math.fma(b2 - a2, t2, a2);
    }

    public static double lerp(double a2, double b2, double t2) {
        return Math.fma(b2 - a2, t2, a2);
    }

    public static float biLerp(float q00, float q10, float q01, float q11, float tx, float ty) {
        float lerpX1 = Math.lerp(q00, q10, tx);
        float lerpX2 = Math.lerp(q01, q11, tx);
        return Math.lerp(lerpX1, lerpX2, ty);
    }

    public static double biLerp(double q00, double q10, double q01, double q11, double tx, double ty) {
        double lerpX1 = Math.lerp(q00, q10, tx);
        double lerpX2 = Math.lerp(q01, q11, tx);
        return Math.lerp(lerpX1, lerpX2, ty);
    }

    public static float triLerp(float q000, float q100, float q010, float q110, float q001, float q101, float q011, float q111, float tx, float ty, float tz) {
        float x00 = Math.lerp(q000, q100, tx);
        float x10 = Math.lerp(q010, q110, tx);
        float x01 = Math.lerp(q001, q101, tx);
        float x11 = Math.lerp(q011, q111, tx);
        float y0 = Math.lerp(x00, x10, ty);
        float y1 = Math.lerp(x01, x11, ty);
        return Math.lerp(y0, y1, tz);
    }

    public static double triLerp(double q000, double q100, double q010, double q110, double q001, double q101, double q011, double q111, double tx, double ty, double tz) {
        double x00 = Math.lerp(q000, q100, tx);
        double x10 = Math.lerp(q010, q110, tx);
        double x01 = Math.lerp(q001, q101, tx);
        double x11 = Math.lerp(q011, q111, tx);
        double y0 = Math.lerp(x00, x10, ty);
        double y1 = Math.lerp(x01, x11, ty);
        return Math.lerp(y0, y1, tz);
    }

    public static int roundHalfEven(float v2) {
        return (int)java.lang.Math.rint(v2);
    }

    public static int roundHalfDown(float v2) {
        return v2 > 0.0f ? (int)java.lang.Math.ceil((double)v2 - 0.5) : (int)java.lang.Math.floor((double)v2 + 0.5);
    }

    public static int roundHalfUp(float v2) {
        return v2 > 0.0f ? (int)java.lang.Math.floor((double)v2 + 0.5) : (int)java.lang.Math.ceil((double)v2 - 0.5);
    }

    public static int roundHalfEven(double v2) {
        return (int)java.lang.Math.rint(v2);
    }

    public static int roundHalfDown(double v2) {
        return v2 > 0.0 ? (int)java.lang.Math.ceil(v2 - 0.5) : (int)java.lang.Math.floor(v2 + 0.5);
    }

    public static int roundHalfUp(double v2) {
        return v2 > 0.0 ? (int)java.lang.Math.floor(v2 + 0.5) : (int)java.lang.Math.ceil(v2 - 0.5);
    }

    public static double random() {
        return java.lang.Math.random();
    }

    public static double signum(double v2) {
        return java.lang.Math.signum(v2);
    }

    public static float signum(float v2) {
        return java.lang.Math.signum(v2);
    }

    public static int signum(int v2) {
        int r2 = Integer.signum(v2);
        return r2;
    }

    public static int signum(long v2) {
        int r2 = Long.signum(v2);
        return r2;
    }

    static {
        if (Options.FASTMATH && Options.SIN_LOOKUP) {
            sinTable = new float[lookupTableSizeWithMargin];
            for (int i2 = 0; i2 < lookupTableSizeWithMargin; ++i2) {
                double d2 = (float)i2 * pi2OverLookupSize;
                Math.sinTable[i2] = (float)java.lang.Math.sin(d2);
            }
        } else {
            sinTable = null;
        }
        c1 = Double.longBitsToDouble(-4628199217061079772L);
        c2 = Double.longBitsToDouble(4575957461383582011L);
        c3 = Double.longBitsToDouble(-4671919876300759001L);
        c4 = Double.longBitsToDouble(4523617214285661942L);
        c5 = Double.longBitsToDouble(-4730215272828025532L);
        c6 = Double.longBitsToDouble(4460272573143870633L);
        c7 = Double.longBitsToDouble(-4797767418267846529L);
        s5 = Double.longBitsToDouble(4523227044276562163L);
        s4 = Double.longBitsToDouble(-4671934770969572232L);
        s3 = Double.longBitsToDouble(4575957211482072852L);
        s2 = Double.longBitsToDouble(-4628199223918090387L);
        s1 = Double.longBitsToDouble(4607182418589157889L);
        k1 = Double.longBitsToDouble(-4628199217061079959L);
        k2 = Double.longBitsToDouble(4575957461383549981L);
        k3 = Double.longBitsToDouble(-4671919876307284301L);
        k4 = Double.longBitsToDouble(4523617213632129738L);
        k5 = Double.longBitsToDouble(-4730215344060517252L);
        k6 = Double.longBitsToDouble(4460268259291226124L);
        k7 = Double.longBitsToDouble(-4798040743777455072L);
    }
}

