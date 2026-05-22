/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.gson.stream.MalformedJsonException;

public class LegacyGson {
    private static final String MODERN_ALLOWED_ESCAPES = "utbnrf\n'\"\\/";
    private static final String LENIENT_EXCEPTION = "Use JsonReader.setLenient(true) to accept malformed JSON";

    public static String fixInvalidEscapes(String json) {
        StringBuilder fixedJson = new StringBuilder();
        boolean quote = false;
        char quoteChar = '\u0000';
        boolean escape = false;
        for (char c2 : json.toCharArray()) {
            if (!escape) {
                if (c2 == '\"' || c2 == '\'') {
                    if (!quote) {
                        quote = true;
                        quoteChar = c2;
                    } else if (quoteChar == c2) {
                        quote = false;
                    }
                } else if (quote && c2 == '\\') {
                    escape = true;
                }
            } else {
                if (MODERN_ALLOWED_ESCAPES.indexOf(c2) == -1) {
                    fixedJson.setLength(fixedJson.length() - 1);
                }
                escape = false;
            }
            fixedJson.append(c2);
        }
        return fixedJson.toString();
    }

    public static void checkStartingType(String json, boolean lenient) {
        if (lenient) {
            return;
        }
        char c2 = LegacyGson.nextNonWhitespace(json);
        if (c2 == ']' || c2 == ';' || c2 == ',' || c2 == '[' || c2 == '{') {
            return;
        }
        throw new JsonSyntaxException(new MalformedJsonException(LENIENT_EXCEPTION));
    }

    private static char nextNonWhitespace(String s2) {
        char[] chars = s2.toCharArray();
        int i2 = 0;
        while (i2 < chars.length) {
            char c2;
            if ((c2 = chars[i2++]) == '\n' || c2 == ' ' || c2 == '\r' || c2 == '\t') continue;
            if (c2 == '/' || c2 == '#') {
                throw new JsonSyntaxException(new MalformedJsonException(LENIENT_EXCEPTION));
            }
            return c2;
        }
        return '{';
    }
}

