/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.darkmeow.irc.lib.io.netty.util.internal.EmptyArrays;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;

public final class StringUtil {
    public static final String EMPTY_STRING = "";
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
    public static final char DOUBLE_QUOTE = '\"';
    public static final char COMMA = ',';
    public static final char LINE_FEED = '\n';
    public static final char CARRIAGE_RETURN = '\r';
    public static final char TAB = '\t';
    public static final char SPACE = ' ';
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];
    private static final byte[] HEX2B;
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    private static final char PACKAGE_SEPARATOR_CHAR = '.';

    private StringUtil() {
    }

    public static String substringAfter(String value, char delim) {
        int pos = value.indexOf(delim);
        if (pos >= 0) {
            return value.substring(pos + 1);
        }
        return null;
    }

    public static String substringBefore(String value, char delim) {
        int pos = value.indexOf(delim);
        if (pos >= 0) {
            return value.substring(0, pos);
        }
        return null;
    }

    public static boolean commonSuffixOfLength(String s2, String p2, int len) {
        return s2 != null && p2 != null && len >= 0 && s2.regionMatches(s2.length() - len, p2, p2.length() - len, len);
    }

    public static String byteToHexStringPadded(int value) {
        return BYTE2HEX_PAD[value & 0xFF];
    }

    public static <T extends Appendable> T byteToHexStringPadded(T buf, int value) {
        try {
            buf.append(StringUtil.byteToHexStringPadded(value));
        }
        catch (IOException e2) {
            PlatformDependent.throwException(e2);
        }
        return buf;
    }

    public static String toHexStringPadded(byte[] src) {
        return StringUtil.toHexStringPadded(src, 0, src.length);
    }

    public static String toHexStringPadded(byte[] src, int offset, int length) {
        return StringUtil.toHexStringPadded(new StringBuilder(length << 1), src, offset, length).toString();
    }

    public static <T extends Appendable> T toHexStringPadded(T dst, byte[] src) {
        return StringUtil.toHexStringPadded(dst, src, 0, src.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T dst, byte[] src, int offset, int length) {
        int end = offset + length;
        for (int i2 = offset; i2 < end; ++i2) {
            StringUtil.byteToHexStringPadded(dst, src[i2]);
        }
        return dst;
    }

    public static String byteToHexString(int value) {
        return BYTE2HEX_NOPAD[value & 0xFF];
    }

    public static <T extends Appendable> T byteToHexString(T buf, int value) {
        try {
            buf.append(StringUtil.byteToHexString(value));
        }
        catch (IOException e2) {
            PlatformDependent.throwException(e2);
        }
        return buf;
    }

    public static String toHexString(byte[] src) {
        return StringUtil.toHexString(src, 0, src.length);
    }

    public static String toHexString(byte[] src, int offset, int length) {
        return StringUtil.toHexString(new StringBuilder(length << 1), src, offset, length).toString();
    }

    public static <T extends Appendable> T toHexString(T dst, byte[] src) {
        return StringUtil.toHexString(dst, src, 0, src.length);
    }

    public static <T extends Appendable> T toHexString(T dst, byte[] src, int offset, int length) {
        int i2;
        assert (length >= 0);
        if (length == 0) {
            return dst;
        }
        int end = offset + length;
        int endMinusOne = end - 1;
        for (i2 = offset; i2 < endMinusOne && src[i2] == 0; ++i2) {
        }
        StringUtil.byteToHexString(dst, src[i2++]);
        int remaining = end - i2;
        StringUtil.toHexStringPadded(dst, src, i2, remaining);
        return dst;
    }

    public static int decodeHexNibble(char c2) {
        return HEX2B[c2];
    }

    public static int decodeHexNibble(byte b2) {
        return HEX2B[b2];
    }

    public static byte decodeHexByte(CharSequence s2, int pos) {
        int hi = StringUtil.decodeHexNibble(s2.charAt(pos));
        int lo = StringUtil.decodeHexNibble(s2.charAt(pos + 1));
        if (hi == -1 || lo == -1) {
            throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", s2.subSequence(pos, pos + 2), pos, s2));
        }
        return (byte)((hi << 4) + lo);
    }

    public static byte[] decodeHexDump(CharSequence hexDump, int fromIndex, int length) {
        if (length < 0 || (length & 1) != 0) {
            throw new IllegalArgumentException("length: " + length);
        }
        if (length == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        byte[] bytes = new byte[length >>> 1];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bytes[i2 >>> 1] = StringUtil.decodeHexByte(hexDump, fromIndex + i2);
        }
        return bytes;
    }

    public static byte[] decodeHexDump(CharSequence hexDump) {
        return StringUtil.decodeHexDump(hexDump, 0, hexDump.length());
    }

    public static String simpleClassName(Object o2) {
        if (o2 == null) {
            return "null_object";
        }
        return StringUtil.simpleClassName(o2.getClass());
    }

    public static String simpleClassName(Class<?> clazz) {
        String className = ObjectUtil.checkNotNull(clazz, "clazz").getName();
        int lastDotIdx = className.lastIndexOf(46);
        if (lastDotIdx > -1) {
            return className.substring(lastDotIdx + 1);
        }
        return className;
    }

    public static CharSequence escapeCsv(CharSequence value) {
        return StringUtil.escapeCsv(value, false);
    }

    public static CharSequence escapeCsv(CharSequence value, boolean trimWhiteSpace) {
        int last;
        int start;
        int length = ObjectUtil.checkNotNull(value, "value").length();
        if (trimWhiteSpace) {
            start = StringUtil.indexOfFirstNonOwsChar(value, length);
            last = StringUtil.indexOfLastNonOwsChar(value, start, length);
        } else {
            start = 0;
            last = length - 1;
        }
        if (start > last) {
            return EMPTY_STRING;
        }
        int firstUnescapedSpecial = -1;
        boolean quoted = false;
        if (StringUtil.isDoubleQuote(value.charAt(start))) {
            boolean bl2 = quoted = StringUtil.isDoubleQuote(value.charAt(last)) && last > start;
            if (quoted) {
                ++start;
                --last;
            } else {
                firstUnescapedSpecial = start;
            }
        }
        if (firstUnescapedSpecial < 0) {
            int i2;
            if (quoted) {
                for (i2 = start; i2 <= last; ++i2) {
                    if (!StringUtil.isDoubleQuote(value.charAt(i2))) continue;
                    if (i2 == last || !StringUtil.isDoubleQuote(value.charAt(i2 + 1))) {
                        firstUnescapedSpecial = i2;
                        break;
                    }
                    ++i2;
                }
            } else {
                for (i2 = start; i2 <= last; ++i2) {
                    char c2 = value.charAt(i2);
                    if (c2 == '\n' || c2 == '\r' || c2 == ',') {
                        firstUnescapedSpecial = i2;
                        break;
                    }
                    if (!StringUtil.isDoubleQuote(c2)) continue;
                    if (i2 == last || !StringUtil.isDoubleQuote(value.charAt(i2 + 1))) {
                        firstUnescapedSpecial = i2;
                        break;
                    }
                    ++i2;
                }
            }
            if (firstUnescapedSpecial < 0) {
                return quoted ? value.subSequence(start - 1, last + 2) : value.subSequence(start, last + 1);
            }
        }
        StringBuilder result = new StringBuilder(last - start + 1 + 7);
        result.append('\"').append(value, start, firstUnescapedSpecial);
        for (int i3 = firstUnescapedSpecial; i3 <= last; ++i3) {
            char c3 = value.charAt(i3);
            if (StringUtil.isDoubleQuote(c3)) {
                result.append('\"');
                if (i3 < last && StringUtil.isDoubleQuote(value.charAt(i3 + 1))) {
                    ++i3;
                }
            }
            result.append(c3);
        }
        return result.append('\"');
    }

    public static CharSequence unescapeCsv(CharSequence value) {
        boolean quoted;
        int length = ObjectUtil.checkNotNull(value, "value").length();
        if (length == 0) {
            return value;
        }
        int last = length - 1;
        boolean bl2 = quoted = StringUtil.isDoubleQuote(value.charAt(0)) && StringUtil.isDoubleQuote(value.charAt(last)) && length != 1;
        if (!quoted) {
            StringUtil.validateCsvFormat(value);
            return value;
        }
        StringBuilder unescaped = InternalThreadLocalMap.get().stringBuilder();
        for (int i2 = 1; i2 < last; ++i2) {
            char current = value.charAt(i2);
            if (current == '\"') {
                if (StringUtil.isDoubleQuote(value.charAt(i2 + 1)) && i2 + 1 != last) {
                    ++i2;
                } else {
                    throw StringUtil.newInvalidEscapedCsvFieldException(value, i2);
                }
            }
            unescaped.append(current);
        }
        return unescaped.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence value) {
        ArrayList<CharSequence> unescaped = new ArrayList<CharSequence>(2);
        StringBuilder current = InternalThreadLocalMap.get().stringBuilder();
        boolean quoted = false;
        int last = value.length() - 1;
        block8: for (int i2 = 0; i2 <= last; ++i2) {
            char c2 = value.charAt(i2);
            if (quoted) {
                switch (c2) {
                    case '\"': {
                        char next;
                        if (i2 == last) {
                            unescaped.add(current.toString());
                            return unescaped;
                        }
                        if ((next = value.charAt(++i2)) == '\"') {
                            current.append('\"');
                            break;
                        }
                        if (next == ',') {
                            quoted = false;
                            unescaped.add(current.toString());
                            current.setLength(0);
                            break;
                        }
                        throw StringUtil.newInvalidEscapedCsvFieldException(value, i2 - 1);
                    }
                    default: {
                        current.append(c2);
                        break;
                    }
                }
                continue;
            }
            switch (c2) {
                case ',': {
                    unescaped.add(current.toString());
                    current.setLength(0);
                    continue block8;
                }
                case '\"': {
                    if (current.length() == 0) {
                        quoted = true;
                        continue block8;
                    }
                }
                case '\n': 
                case '\r': {
                    throw StringUtil.newInvalidEscapedCsvFieldException(value, i2);
                }
                default: {
                    current.append(c2);
                }
            }
        }
        if (quoted) {
            throw StringUtil.newInvalidEscapedCsvFieldException(value, last);
        }
        unescaped.add(current.toString());
        return unescaped;
    }

    private static void validateCsvFormat(CharSequence value) {
        int length = value.length();
        for (int i2 = 0; i2 < length; ++i2) {
            switch (value.charAt(i2)) {
                case '\n': 
                case '\r': 
                case '\"': 
                case ',': {
                    throw StringUtil.newInvalidEscapedCsvFieldException(value, i2);
                }
            }
        }
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence value, int index) {
        return new IllegalArgumentException("invalid escaped CSV field: " + value + " index: " + index);
    }

    public static int length(String s2) {
        return s2 == null ? 0 : s2.length();
    }

    public static boolean isNullOrEmpty(String s2) {
        return s2 == null || s2.isEmpty();
    }

    public static int indexOfNonWhiteSpace(CharSequence seq, int offset) {
        while (offset < seq.length()) {
            if (!Character.isWhitespace(seq.charAt(offset))) {
                return offset;
            }
            ++offset;
        }
        return -1;
    }

    public static int indexOfWhiteSpace(CharSequence seq, int offset) {
        while (offset < seq.length()) {
            if (Character.isWhitespace(seq.charAt(offset))) {
                return offset;
            }
            ++offset;
        }
        return -1;
    }

    public static boolean isSurrogate(char c2) {
        return c2 >= '\ud800' && c2 <= '\udfff';
    }

    private static boolean isDoubleQuote(char c2) {
        return c2 == '\"';
    }

    public static boolean endsWith(CharSequence s2, char c2) {
        int len = s2.length();
        return len > 0 && s2.charAt(len - 1) == c2;
    }

    public static CharSequence trimOws(CharSequence value) {
        int length = value.length();
        if (length == 0) {
            return value;
        }
        int start = StringUtil.indexOfFirstNonOwsChar(value, length);
        int end = StringUtil.indexOfLastNonOwsChar(value, start, length);
        return start == 0 && end == length - 1 ? value : value.subSequence(start, end + 1);
    }

    public static CharSequence join(CharSequence separator, Iterable<? extends CharSequence> elements) {
        ObjectUtil.checkNotNull(separator, "separator");
        ObjectUtil.checkNotNull(elements, "elements");
        Iterator<? extends CharSequence> iterator2 = elements.iterator();
        if (!iterator2.hasNext()) {
            return EMPTY_STRING;
        }
        CharSequence firstElement = iterator2.next();
        if (!iterator2.hasNext()) {
            return firstElement;
        }
        StringBuilder builder = new StringBuilder(firstElement);
        do {
            builder.append(separator).append(iterator2.next());
        } while (iterator2.hasNext());
        return builder;
    }

    private static int indexOfFirstNonOwsChar(CharSequence value, int length) {
        int i2;
        for (i2 = 0; i2 < length && StringUtil.isOws(value.charAt(i2)); ++i2) {
        }
        return i2;
    }

    private static int indexOfLastNonOwsChar(CharSequence value, int start, int length) {
        int i2;
        for (i2 = length - 1; i2 > start && StringUtil.isOws(value.charAt(i2)); --i2) {
        }
        return i2;
    }

    private static boolean isOws(char c2) {
        return c2 == ' ' || c2 == '\t';
    }

    static {
        for (int i2 = 0; i2 < BYTE2HEX_PAD.length; ++i2) {
            String str = Integer.toHexString(i2);
            StringUtil.BYTE2HEX_PAD[i2] = i2 > 15 ? str : '0' + str;
            StringUtil.BYTE2HEX_NOPAD[i2] = str;
        }
        HEX2B = new byte[65536];
        Arrays.fill(HEX2B, (byte)-1);
        StringUtil.HEX2B[48] = 0;
        StringUtil.HEX2B[49] = 1;
        StringUtil.HEX2B[50] = 2;
        StringUtil.HEX2B[51] = 3;
        StringUtil.HEX2B[52] = 4;
        StringUtil.HEX2B[53] = 5;
        StringUtil.HEX2B[54] = 6;
        StringUtil.HEX2B[55] = 7;
        StringUtil.HEX2B[56] = 8;
        StringUtil.HEX2B[57] = 9;
        StringUtil.HEX2B[65] = 10;
        StringUtil.HEX2B[66] = 11;
        StringUtil.HEX2B[67] = 12;
        StringUtil.HEX2B[68] = 13;
        StringUtil.HEX2B[69] = 14;
        StringUtil.HEX2B[70] = 15;
        StringUtil.HEX2B[97] = 10;
        StringUtil.HEX2B[98] = 11;
        StringUtil.HEX2B[99] = 12;
        StringUtil.HEX2B[100] = 13;
        StringUtil.HEX2B[101] = 14;
        StringUtil.HEX2B[102] = 15;
    }
}

