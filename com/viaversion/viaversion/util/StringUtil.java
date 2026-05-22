/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

public final class StringUtil {
    public static String forLogging(Object o2) {
        return StringUtil.forLogging(String.valueOf(o2));
    }

    public static String forLogging(String s2) {
        StringBuilder builder = new StringBuilder(s2.length());
        int len = s2.length();
        for (int i2 = 0; i2 < len; ++i2) {
            char c2 = s2.charAt(i2);
            if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
                builder.append(' ');
                continue;
            }
            if (Character.isISOControl(c2)) continue;
            builder.append(c2);
        }
        return builder.toString();
    }
}

