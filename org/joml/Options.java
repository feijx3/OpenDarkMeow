/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public final class Options {
    public static final boolean DEBUG = Options.hasOption(System.getProperty("joml.debug", "false"));
    public static final boolean NO_UNSAFE = Options.hasOption(System.getProperty("joml.nounsafe", "false"));
    public static final boolean FORCE_UNSAFE = Options.hasOption(System.getProperty("joml.forceUnsafe", "false"));
    public static final boolean FASTMATH = Options.hasOption(System.getProperty("joml.fastmath", "false"));
    public static final boolean SIN_LOOKUP = Options.hasOption(System.getProperty("joml.sinLookup", "false"));
    public static final int SIN_LOOKUP_BITS = Integer.parseInt(System.getProperty("joml.sinLookup.bits", "14"));
    public static final boolean useNumberFormat = Options.hasOption(System.getProperty("joml.format", "true"));
    public static final boolean USE_MATH_FMA = Options.hasOption(System.getProperty("joml.useMathFma", "false"));
    public static final int numberFormatDecimals = Integer.parseInt(System.getProperty("joml.format.decimals", "3"));
    public static final NumberFormat NUMBER_FORMAT = Options.decimalFormat();

    private Options() {
    }

    private static NumberFormat decimalFormat() {
        NumberFormat df2;
        if (useNumberFormat) {
            char[] prec = new char[numberFormatDecimals];
            Arrays.fill(prec, '0');
            df2 = new DecimalFormat(" 0." + new String(prec) + "E0;-");
        } else {
            df2 = NumberFormat.getNumberInstance(Locale.ENGLISH);
            df2.setGroupingUsed(false);
        }
        return df2;
    }

    private static boolean hasOption(String v2) {
        if (v2 == null) {
            return false;
        }
        if (v2.trim().length() == 0) {
            return true;
        }
        return Boolean.valueOf(v2);
    }
}

