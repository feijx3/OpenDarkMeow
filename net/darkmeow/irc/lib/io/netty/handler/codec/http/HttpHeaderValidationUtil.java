/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaderNames;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaderValues;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpUtil;
import net.darkmeow.irc.lib.io.netty.util.AsciiString;

public final class HttpHeaderValidationUtil {
    private HttpHeaderValidationUtil() {
    }

    public static boolean isConnectionHeader(CharSequence name, boolean ignoreTeHeader) {
        int len = name.length();
        switch (len) {
            case 2: {
                return ignoreTeHeader ? false : AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.TE);
            }
            case 7: {
                return AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.UPGRADE);
            }
            case 10: {
                return AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.CONNECTION) || AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.KEEP_ALIVE);
            }
            case 16: {
                return AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.PROXY_CONNECTION);
            }
            case 17: {
                return AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.TRANSFER_ENCODING);
            }
        }
        return false;
    }

    public static boolean isTeNotTrailers(CharSequence name, CharSequence value) {
        if (name.length() == 2) {
            return AsciiString.contentEqualsIgnoreCase(name, HttpHeaderNames.TE) && !AsciiString.contentEqualsIgnoreCase(value, HttpHeaderValues.TRAILERS);
        }
        return false;
    }

    public static int validateValidHeaderValue(CharSequence value) {
        int length = value.length();
        if (length == 0) {
            return -1;
        }
        if (value instanceof AsciiString) {
            return HttpHeaderValidationUtil.verifyValidHeaderValueAsciiString((AsciiString)value);
        }
        return HttpHeaderValidationUtil.verifyValidHeaderValueCharSequence(value);
    }

    private static int verifyValidHeaderValueAsciiString(AsciiString value) {
        int start;
        byte[] array = value.array();
        int b2 = array[start = value.arrayOffset()] & 0xFF;
        if (b2 < 33 || b2 == 127) {
            return 0;
        }
        int end = start + value.length();
        for (int i2 = start + 1; i2 < end; ++i2) {
            b2 = array[i2] & 0xFF;
            if ((b2 >= 32 || b2 == 9) && b2 != 127) continue;
            return i2 - start;
        }
        return -1;
    }

    private static int verifyValidHeaderValueCharSequence(CharSequence value) {
        char b2 = value.charAt(0);
        if (b2 < '!' || b2 == '\u007f') {
            return 0;
        }
        int length = value.length();
        for (int i2 = 1; i2 < length; ++i2) {
            b2 = value.charAt(i2);
            if ((b2 >= ' ' || b2 == '\t') && b2 != '\u007f') continue;
            return i2;
        }
        return -1;
    }

    public static int validateToken(CharSequence token) {
        return HttpUtil.validateToken(token);
    }
}

