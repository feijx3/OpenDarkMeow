/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import net.darkmeow.irc.lib.io.netty.util.AsciiStringUtil;
import net.darkmeow.irc.lib.io.netty.util.ByteProcessor;
import net.darkmeow.irc.lib.io.netty.util.CharsetUtil;
import net.darkmeow.irc.lib.io.netty.util.HashingStrategy;
import net.darkmeow.irc.lib.io.netty.util.internal.EmptyArrays;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;
import net.darkmeow.irc.lib.io.netty.util.internal.MathUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;

public final class AsciiString
implements CharSequence,
Comparable<CharSequence> {
    public static final AsciiString EMPTY_STRING = AsciiString.cached("");
    private static final char MAX_CHAR_VALUE = '\u00ff';
    public static final int INDEX_NOT_FOUND = -1;
    private final byte[] value;
    private final int offset;
    private final int length;
    private int hash;
    private String string;
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>(){

        @Override
        public int hashCode(CharSequence o2) {
            return AsciiString.hashCode(o2);
        }

        @Override
        public boolean equals(CharSequence a2, CharSequence b2) {
            return AsciiString.contentEqualsIgnoreCase(a2, b2);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>(){

        @Override
        public int hashCode(CharSequence o2) {
            return AsciiString.hashCode(o2);
        }

        @Override
        public boolean equals(CharSequence a2, CharSequence b2) {
            return AsciiString.contentEquals(a2, b2);
        }
    };

    public AsciiString(byte[] value) {
        this(value, true);
    }

    public AsciiString(byte[] value, boolean copy) {
        this(value, 0, value.length, copy);
    }

    public AsciiString(byte[] value, int start, int length, boolean copy) {
        if (copy) {
            byte[] rangedCopy = new byte[length];
            System.arraycopy(value, start, rangedCopy, 0, rangedCopy.length);
            this.value = rangedCopy;
            this.offset = 0;
        } else {
            if (MathUtil.isOutOfBounds(start, length, value.length)) {
                throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length + ')');
            }
            this.value = value;
            this.offset = start;
        }
        this.length = length;
    }

    public AsciiString(ByteBuffer value) {
        this(value, true);
    }

    public AsciiString(ByteBuffer value, boolean copy) {
        this(value, value.position(), value.remaining(), copy);
    }

    public AsciiString(ByteBuffer value, int start, int length, boolean copy) {
        if (MathUtil.isOutOfBounds(start, length, value.capacity())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.capacity(" + value.capacity() + ')');
        }
        if (value.hasArray()) {
            if (copy) {
                int bufferOffset = value.arrayOffset() + start;
                this.value = Arrays.copyOfRange(value.array(), bufferOffset, bufferOffset + length);
                this.offset = 0;
            } else {
                this.value = value.array();
                this.offset = start;
            }
        } else {
            this.value = PlatformDependent.allocateUninitializedArray(length);
            int oldPos = value.position();
            value.get(this.value, 0, length);
            value.position(oldPos);
            this.offset = 0;
        }
        this.length = length;
    }

    public AsciiString(char[] value) {
        this(value, 0, value.length);
    }

    public AsciiString(char[] value, int start, int length) {
        if (MathUtil.isOutOfBounds(start, length, value.length)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length + ')');
        }
        this.value = PlatformDependent.allocateUninitializedArray(length);
        int i2 = 0;
        int j2 = start;
        while (i2 < length) {
            this.value[i2] = AsciiString.c2b(value[j2]);
            ++i2;
            ++j2;
        }
        this.offset = 0;
        this.length = length;
    }

    public AsciiString(char[] value, Charset charset) {
        this(value, charset, 0, value.length);
    }

    public AsciiString(char[] value, Charset charset, int start, int length) {
        CharBuffer cbuf = CharBuffer.wrap(value, start, length);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer nativeBuffer = ByteBuffer.allocate((int)(encoder.maxBytesPerChar() * (float)length));
        encoder.encode(cbuf, nativeBuffer, true);
        int bufferOffset = nativeBuffer.arrayOffset();
        this.value = Arrays.copyOfRange(nativeBuffer.array(), bufferOffset, bufferOffset + nativeBuffer.position());
        this.offset = 0;
        this.length = this.value.length;
    }

    public AsciiString(CharSequence value) {
        this(value, 0, value.length());
    }

    public AsciiString(CharSequence value, int start, int length) {
        if (MathUtil.isOutOfBounds(start, length, value.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length() + ')');
        }
        this.value = PlatformDependent.allocateUninitializedArray(length);
        int i2 = 0;
        int j2 = start;
        while (i2 < length) {
            this.value[i2] = AsciiString.c2b(value.charAt(j2));
            ++i2;
            ++j2;
        }
        this.offset = 0;
        this.length = length;
    }

    public AsciiString(CharSequence value, Charset charset) {
        this(value, charset, 0, value.length());
    }

    public AsciiString(CharSequence value, Charset charset, int start, int length) {
        CharBuffer cbuf = CharBuffer.wrap(value, start, start + length);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer nativeBuffer = ByteBuffer.allocate((int)(encoder.maxBytesPerChar() * (float)length));
        encoder.encode(cbuf, nativeBuffer, true);
        int offset = nativeBuffer.arrayOffset();
        this.value = Arrays.copyOfRange(nativeBuffer.array(), offset, offset + nativeBuffer.position());
        this.offset = 0;
        this.length = this.value.length;
    }

    public int forEachByte(ByteProcessor visitor2) throws Exception {
        return this.forEachByte0(0, this.length(), visitor2);
    }

    public int forEachByte(int index, int length, ByteProcessor visitor2) throws Exception {
        if (MathUtil.isOutOfBounds(index, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= index(" + index + ") <= start + length(" + length + ") <= length(" + this.length() + ')');
        }
        return this.forEachByte0(index, length, visitor2);
    }

    private int forEachByte0(int index, int length, ByteProcessor visitor2) throws Exception {
        int len = this.offset + index + length;
        for (int i2 = this.offset + index; i2 < len; ++i2) {
            if (visitor2.process(this.value[i2])) continue;
            return i2 - this.offset;
        }
        return -1;
    }

    public int forEachByteDesc(ByteProcessor visitor2) throws Exception {
        return this.forEachByteDesc0(0, this.length(), visitor2);
    }

    public int forEachByteDesc(int index, int length, ByteProcessor visitor2) throws Exception {
        if (MathUtil.isOutOfBounds(index, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= index(" + index + ") <= start + length(" + length + ") <= length(" + this.length() + ')');
        }
        return this.forEachByteDesc0(index, length, visitor2);
    }

    private int forEachByteDesc0(int index, int length, ByteProcessor visitor2) throws Exception {
        int end = this.offset + index;
        for (int i2 = this.offset + index + length - 1; i2 >= end; --i2) {
            if (visitor2.process(this.value[i2])) continue;
            return i2 - this.offset;
        }
        return -1;
    }

    public byte byteAt(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("index: " + index + " must be in the range [0," + this.length + ")");
        }
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getByte(this.value, index + this.offset);
        }
        return this.value[index + this.offset];
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public byte[] array() {
        return this.value;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public byte[] toByteArray() {
        return this.toByteArray(0, this.length());
    }

    public byte[] toByteArray(int start, int end) {
        return Arrays.copyOfRange(this.value, start + this.offset, end + this.offset);
    }

    public void copy(int srcIdx, byte[] dst, int dstIdx, int length) {
        if (MathUtil.isOutOfBounds(srcIdx, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + this.length() + ')');
        }
        System.arraycopy(this.value, srcIdx + this.offset, ObjectUtil.checkNotNull(dst, "dst"), dstIdx, length);
    }

    @Override
    public char charAt(int index) {
        return AsciiString.b2c(this.byteAt(index));
    }

    public boolean contains(CharSequence cs2) {
        return this.indexOf(cs2) >= 0;
    }

    @Override
    public int compareTo(CharSequence string) {
        if (this == string) {
            return 0;
        }
        int length1 = this.length();
        int length2 = string.length();
        int minLength = Math.min(length1, length2);
        int i2 = 0;
        int j2 = this.arrayOffset();
        while (i2 < minLength) {
            int result = AsciiString.b2c(this.value[j2]) - string.charAt(i2);
            if (result != 0) {
                return result;
            }
            ++i2;
            ++j2;
        }
        return length1 - length2;
    }

    public AsciiString concat(CharSequence string) {
        int thisLen = this.length();
        int thatLen = string.length();
        if (thatLen == 0) {
            return this;
        }
        if (string instanceof AsciiString) {
            AsciiString that = (AsciiString)string;
            if (this.isEmpty()) {
                return that;
            }
            byte[] newValue = PlatformDependent.allocateUninitializedArray(thisLen + thatLen);
            System.arraycopy(this.value, this.arrayOffset(), newValue, 0, thisLen);
            System.arraycopy(that.value, that.arrayOffset(), newValue, thisLen, thatLen);
            return new AsciiString(newValue, false);
        }
        if (this.isEmpty()) {
            return new AsciiString(string);
        }
        byte[] newValue = PlatformDependent.allocateUninitializedArray(thisLen + thatLen);
        System.arraycopy(this.value, this.arrayOffset(), newValue, 0, thisLen);
        int i2 = thisLen;
        int j2 = 0;
        while (i2 < newValue.length) {
            newValue[i2] = AsciiString.c2b(string.charAt(j2));
            ++i2;
            ++j2;
        }
        return new AsciiString(newValue, false);
    }

    public boolean endsWith(CharSequence suffix) {
        int suffixLen = suffix.length();
        return this.regionMatches(this.length() - suffixLen, suffix, 0, suffixLen);
    }

    public boolean contentEqualsIgnoreCase(CharSequence string) {
        if (this == string) {
            return true;
        }
        if (string == null || string.length() != this.length()) {
            return false;
        }
        if (string instanceof AsciiString) {
            AsciiString other = (AsciiString)string;
            byte[] value = this.value;
            if (this.offset == 0 && other.offset == 0 && this.length == value.length) {
                byte[] otherValue = other.value;
                for (int i2 = 0; i2 < value.length; ++i2) {
                    if (AsciiString.equalsIgnoreCase(value[i2], otherValue[i2])) continue;
                    return false;
                }
                return true;
            }
            return this.misalignedEqualsIgnoreCase(other);
        }
        byte[] value = this.value;
        int i3 = this.offset;
        for (int j2 = 0; j2 < string.length(); ++j2) {
            if (!AsciiString.equalsIgnoreCase(AsciiString.b2c(value[i3]), string.charAt(j2))) {
                return false;
            }
            ++i3;
        }
        return true;
    }

    private boolean misalignedEqualsIgnoreCase(AsciiString other) {
        byte[] value = this.value;
        byte[] otherValue = other.value;
        int i2 = this.offset;
        int j2 = other.offset;
        int end = this.offset + this.length;
        while (i2 < end) {
            if (!AsciiString.equalsIgnoreCase(value[i2], otherValue[j2])) {
                return false;
            }
            ++i2;
            ++j2;
        }
        return true;
    }

    public char[] toCharArray() {
        return this.toCharArray(0, this.length());
    }

    public char[] toCharArray(int start, int end) {
        int length = end - start;
        if (length == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (MathUtil.isOutOfBounds(start, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= srcIdx + length(" + length + ") <= srcLen(" + this.length() + ')');
        }
        char[] buffer = new char[length];
        int i2 = 0;
        int j2 = start + this.arrayOffset();
        while (i2 < length) {
            buffer[i2] = AsciiString.b2c(this.value[j2]);
            ++i2;
            ++j2;
        }
        return buffer;
    }

    public void copy(int srcIdx, char[] dst, int dstIdx, int length) {
        ObjectUtil.checkNotNull(dst, "dst");
        if (MathUtil.isOutOfBounds(srcIdx, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + this.length() + ')');
        }
        int dstEnd = dstIdx + length;
        int i2 = dstIdx;
        int j2 = srcIdx + this.arrayOffset();
        while (i2 < dstEnd) {
            dst[i2] = AsciiString.b2c(this.value[j2]);
            ++i2;
            ++j2;
        }
    }

    public AsciiString subSequence(int start) {
        return this.subSequence(start, this.length());
    }

    @Override
    public AsciiString subSequence(int start, int end) {
        return this.subSequence(start, end, true);
    }

    public AsciiString subSequence(int start, int end, boolean copy) {
        if (MathUtil.isOutOfBounds(start, end - start, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= end (" + end + ") <= length(" + this.length() + ')');
        }
        if (start == 0 && end == this.length()) {
            return this;
        }
        if (end == start) {
            return EMPTY_STRING;
        }
        return new AsciiString(this.value, start + this.offset, end - start, copy);
    }

    public int indexOf(CharSequence string) {
        return this.indexOf(string, 0);
    }

    public int indexOf(CharSequence subString, int start) {
        int subCount = subString.length();
        if (start < 0) {
            start = 0;
        }
        if (subCount <= 0) {
            return start < this.length ? start : this.length;
        }
        if (subCount > this.length - start) {
            return -1;
        }
        char firstChar = subString.charAt(0);
        if (firstChar > '\u00ff') {
            return -1;
        }
        byte firstCharAsByte = AsciiString.c2b0(firstChar);
        int len = this.offset + this.length - subCount;
        for (int i2 = start + this.offset; i2 <= len; ++i2) {
            if (this.value[i2] != firstCharAsByte) continue;
            int o1 = i2;
            int o2 = 0;
            while (++o2 < subCount && AsciiString.b2c(this.value[++o1]) == subString.charAt(o2)) {
            }
            if (o2 != subCount) continue;
            return i2 - this.offset;
        }
        return -1;
    }

    public int indexOf(char ch2, int start) {
        if (ch2 > '\u00ff') {
            return -1;
        }
        if (start < 0) {
            start = 0;
        }
        byte chAsByte = AsciiString.c2b0(ch2);
        int len = this.offset + this.length;
        for (int i2 = start + this.offset; i2 < len; ++i2) {
            if (this.value[i2] != chAsByte) continue;
            return i2 - this.offset;
        }
        return -1;
    }

    public int lastIndexOf(CharSequence string) {
        return this.lastIndexOf(string, this.length);
    }

    public int lastIndexOf(CharSequence subString, int start) {
        int subCount = subString.length();
        if ((start = Math.min(start, this.length - subCount)) < 0) {
            return -1;
        }
        if (subCount == 0) {
            return start;
        }
        char firstChar = subString.charAt(0);
        if (firstChar > '\u00ff') {
            return -1;
        }
        byte firstCharAsByte = AsciiString.c2b0(firstChar);
        for (int i2 = this.offset + start; i2 >= this.offset; --i2) {
            if (this.value[i2] != firstCharAsByte) continue;
            int o1 = i2;
            int o2 = 0;
            while (++o2 < subCount && AsciiString.b2c(this.value[++o1]) == subString.charAt(o2)) {
            }
            if (o2 != subCount) continue;
            return i2 - this.offset;
        }
        return -1;
    }

    public boolean regionMatches(int thisStart, CharSequence string, int start, int length) {
        ObjectUtil.checkNotNull(string, "string");
        if (start < 0 || string.length() - start < length) {
            return false;
        }
        int thisLen = this.length();
        if (thisStart < 0 || thisLen - thisStart < length) {
            return false;
        }
        if (length <= 0) {
            return true;
        }
        if (string instanceof AsciiString) {
            AsciiString asciiString = (AsciiString)string;
            return PlatformDependent.equals(this.value, thisStart + this.offset, asciiString.value, start + asciiString.offset, length);
        }
        int thatEnd = start + length;
        int i2 = start;
        int j2 = thisStart + this.arrayOffset();
        while (i2 < thatEnd) {
            if (AsciiString.b2c(this.value[j2]) != string.charAt(i2)) {
                return false;
            }
            ++i2;
            ++j2;
        }
        return true;
    }

    public boolean regionMatches(boolean ignoreCase, int thisStart, CharSequence string, int start, int length) {
        if (!ignoreCase) {
            return this.regionMatches(thisStart, string, start, length);
        }
        ObjectUtil.checkNotNull(string, "string");
        int thisLen = this.length();
        if (thisStart < 0 || length > thisLen - thisStart) {
            return false;
        }
        if (start < 0 || length > string.length() - start) {
            return false;
        }
        int thisEnd = (thisStart += this.arrayOffset()) + length;
        if (string instanceof AsciiString) {
            AsciiString asciiString = (AsciiString)string;
            byte[] value = this.value;
            byte[] otherValue = asciiString.value;
            start += asciiString.offset;
            while (thisStart < thisEnd) {
                if (AsciiString.equalsIgnoreCase(value[thisStart++], otherValue[start++])) continue;
                return false;
            }
            return true;
        }
        while (thisStart < thisEnd) {
            if (AsciiString.equalsIgnoreCase(AsciiString.b2c(this.value[thisStart++]), string.charAt(start++))) continue;
            return false;
        }
        return true;
    }

    public AsciiString replace(char oldChar, char newChar) {
        if (oldChar > '\u00ff') {
            return this;
        }
        byte oldCharAsByte = AsciiString.c2b0(oldChar);
        byte newCharAsByte = AsciiString.c2b(newChar);
        int len = this.offset + this.length;
        for (int i2 = this.offset; i2 < len; ++i2) {
            if (this.value[i2] != oldCharAsByte) continue;
            byte[] buffer = PlatformDependent.allocateUninitializedArray(this.length());
            System.arraycopy(this.value, this.offset, buffer, 0, i2 - this.offset);
            buffer[i2 - this.offset] = newCharAsByte;
            ++i2;
            while (i2 < len) {
                byte oldValue = this.value[i2];
                buffer[i2 - this.offset] = oldValue != oldCharAsByte ? oldValue : newCharAsByte;
                ++i2;
            }
            return new AsciiString(buffer, false);
        }
        return this;
    }

    public boolean startsWith(CharSequence prefix) {
        return this.startsWith(prefix, 0);
    }

    public boolean startsWith(CharSequence prefix, int start) {
        return this.regionMatches(start, prefix, 0, prefix.length());
    }

    public AsciiString toLowerCase() {
        return AsciiStringUtil.toLowerCase(this);
    }

    public AsciiString toUpperCase() {
        return AsciiStringUtil.toUpperCase(this);
    }

    public static CharSequence trim(CharSequence c2) {
        int start;
        int last;
        if (c2 instanceof AsciiString) {
            return ((AsciiString)c2).trim();
        }
        if (c2 instanceof String) {
            return ((String)c2).trim();
        }
        int end = last = c2.length() - 1;
        for (start = 0; start <= end && c2.charAt(start) <= ' '; ++start) {
        }
        while (end >= start && c2.charAt(end) <= ' ') {
            --end;
        }
        if (start == 0 && end == last) {
            return c2;
        }
        return c2.subSequence(start, end);
    }

    public AsciiString trim() {
        int start;
        int last;
        int end = last = this.arrayOffset() + this.length() - 1;
        for (start = this.arrayOffset(); start <= end && this.value[start] <= 32; ++start) {
        }
        while (end >= start && this.value[end] <= 32) {
            --end;
        }
        if (start == 0 && end == last) {
            return this;
        }
        return new AsciiString(this.value, start, end - start + 1, false);
    }

    public boolean contentEquals(CharSequence a2) {
        if (this == a2) {
            return true;
        }
        if (a2 == null || a2.length() != this.length()) {
            return false;
        }
        if (a2 instanceof AsciiString) {
            return this.equals(a2);
        }
        int i2 = this.arrayOffset();
        for (int j2 = 0; j2 < a2.length(); ++j2) {
            if (AsciiString.b2c(this.value[i2]) != a2.charAt(j2)) {
                return false;
            }
            ++i2;
        }
        return true;
    }

    public boolean matches(String expr) {
        return Pattern.matches(expr, this);
    }

    public AsciiString[] split(String expr, int max) {
        return AsciiString.toAsciiStringArray(Pattern.compile(expr).split(this, max));
    }

    public AsciiString[] split(char delim) {
        int i2;
        ArrayList<AsciiString> res = InternalThreadLocalMap.get().arrayList();
        int start = 0;
        int length = this.length();
        for (i2 = start; i2 < length; ++i2) {
            if (this.charAt(i2) != delim) continue;
            if (start == i2) {
                res.add(EMPTY_STRING);
            } else {
                res.add(new AsciiString(this.value, start + this.arrayOffset(), i2 - start, false));
            }
            start = i2 + 1;
        }
        if (start == 0) {
            res.add(this);
        } else if (start != length) {
            res.add(new AsciiString(this.value, start + this.arrayOffset(), length - start, false));
        } else {
            for (i2 = res.size() - 1; i2 >= 0 && ((AsciiString)res.get(i2)).isEmpty(); --i2) {
                res.remove(i2);
            }
        }
        return res.toArray(EmptyArrays.EMPTY_ASCII_STRINGS);
    }

    public int hashCode() {
        int h2 = this.hash;
        if (h2 == 0) {
            this.hash = h2 = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
        }
        return h2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != AsciiString.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        AsciiString other = (AsciiString)obj;
        return this.length() == other.length() && this.hashCode() == other.hashCode() && PlatformDependent.equals(this.array(), this.arrayOffset(), other.array(), other.arrayOffset(), this.length());
    }

    @Override
    public String toString() {
        String cache2 = this.string;
        if (cache2 == null) {
            this.string = cache2 = this.toString(0);
        }
        return cache2;
    }

    public String toString(int start) {
        return this.toString(start, this.length());
    }

    public String toString(int start, int end) {
        int length = end - start;
        if (length == 0) {
            return "";
        }
        if (MathUtil.isOutOfBounds(start, length, this.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= srcIdx + length(" + length + ") <= srcLen(" + this.length() + ')');
        }
        String str = new String(this.value, 0, start + this.offset, length);
        return str;
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar() {
        return this.parseChar(0);
    }

    public char parseChar(int start) {
        if (start + 1 >= this.length()) {
            throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + start + " would go out of bounds.");
        }
        int startWithOffset = start + this.offset;
        return (char)(AsciiString.b2c(this.value[startWithOffset]) << 8 | AsciiString.b2c(this.value[startWithOffset + 1]));
    }

    public short parseShort() {
        return this.parseShort(0, this.length(), 10);
    }

    public short parseShort(int radix) {
        return this.parseShort(0, this.length(), radix);
    }

    public short parseShort(int start, int end) {
        return this.parseShort(start, end, 10);
    }

    public short parseShort(int start, int end, int radix) {
        int intValue = this.parseInt(start, end, radix);
        short result = (short)intValue;
        if (result != intValue) {
            throw new NumberFormatException(this.subSequence(start, end, false).toString());
        }
        return result;
    }

    public int parseInt() {
        return this.parseInt(0, this.length(), 10);
    }

    public int parseInt(int radix) {
        return this.parseInt(0, this.length(), radix);
    }

    public int parseInt(int start, int end) {
        return this.parseInt(start, end, 10);
    }

    public int parseInt(int start, int end, int radix) {
        boolean negative;
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException();
        }
        if (start == end) {
            throw new NumberFormatException();
        }
        int i2 = start;
        boolean bl2 = negative = this.byteAt(i2) == 45;
        if (negative && ++i2 == end) {
            throw new NumberFormatException(this.subSequence(start, end, false).toString());
        }
        return this.parseInt(i2, end, radix, negative);
    }

    private int parseInt(int start, int end, int radix, boolean negative) {
        int max = Integer.MIN_VALUE / radix;
        int result = 0;
        int currOffset = start;
        while (currOffset < end) {
            int digit;
            if ((digit = Character.digit((char)(this.value[currOffset++ + this.offset] & 0xFF), radix)) == -1) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            if (max > result) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            int next = result * radix - digit;
            if (next > result) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            result = next;
        }
        if (!negative && (result = -result) < 0) {
            throw new NumberFormatException(this.subSequence(start, end, false).toString());
        }
        return result;
    }

    public long parseLong() {
        return this.parseLong(0, this.length(), 10);
    }

    public long parseLong(int radix) {
        return this.parseLong(0, this.length(), radix);
    }

    public long parseLong(int start, int end) {
        return this.parseLong(start, end, 10);
    }

    public long parseLong(int start, int end, int radix) {
        boolean negative;
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException();
        }
        if (start == end) {
            throw new NumberFormatException();
        }
        int i2 = start;
        boolean bl2 = negative = this.byteAt(i2) == 45;
        if (negative && ++i2 == end) {
            throw new NumberFormatException(this.subSequence(start, end, false).toString());
        }
        return this.parseLong(i2, end, radix, negative);
    }

    private long parseLong(int start, int end, int radix, boolean negative) {
        long max = Long.MIN_VALUE / (long)radix;
        long result = 0L;
        int currOffset = start;
        while (currOffset < end) {
            int digit;
            if ((digit = Character.digit((char)(this.value[currOffset++ + this.offset] & 0xFF), radix)) == -1) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            if (max > result) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            long next = result * (long)radix - (long)digit;
            if (next > result) {
                throw new NumberFormatException(this.subSequence(start, end, false).toString());
            }
            result = next;
        }
        if (!negative && (result = -result) < 0L) {
            throw new NumberFormatException(this.subSequence(start, end, false).toString());
        }
        return result;
    }

    public float parseFloat() {
        return this.parseFloat(0, this.length());
    }

    public float parseFloat(int start, int end) {
        return Float.parseFloat(this.toString(start, end));
    }

    public double parseDouble() {
        return this.parseDouble(0, this.length());
    }

    public double parseDouble(int start, int end) {
        return Double.parseDouble(this.toString(start, end));
    }

    public static AsciiString of(CharSequence string) {
        return string instanceof AsciiString ? (AsciiString)string : new AsciiString(string);
    }

    public static AsciiString cached(String string) {
        AsciiString asciiString = new AsciiString(string);
        asciiString.string = string;
        return asciiString;
    }

    public static int hashCode(CharSequence value) {
        if (value == null) {
            return 0;
        }
        if (value instanceof AsciiString) {
            return value.hashCode();
        }
        return PlatformDependent.hashCodeAscii(value);
    }

    public static boolean contains(CharSequence a2, CharSequence b2) {
        return AsciiString.contains(a2, b2, DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean containsIgnoreCase(CharSequence a2, CharSequence b2) {
        return AsciiString.contains(a2, b2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    public static boolean contentEqualsIgnoreCase(CharSequence a2, CharSequence b2) {
        if (a2 == null || b2 == null) {
            return a2 == b2;
        }
        if (a2 instanceof AsciiString) {
            return ((AsciiString)a2).contentEqualsIgnoreCase(b2);
        }
        if (b2 instanceof AsciiString) {
            return ((AsciiString)b2).contentEqualsIgnoreCase(a2);
        }
        if (a2.length() != b2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < a2.length(); ++i2) {
            if (AsciiString.equalsIgnoreCase(a2.charAt(i2), b2.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence value) {
        for (CharSequence v2 : collection) {
            if (!AsciiString.contentEqualsIgnoreCase(value, v2)) continue;
            return true;
        }
        return false;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> a2, Collection<CharSequence> b2) {
        for (CharSequence v2 : b2) {
            if (AsciiString.containsContentEqualsIgnoreCase(a2, v2)) continue;
            return false;
        }
        return true;
    }

    public static boolean contentEquals(CharSequence a2, CharSequence b2) {
        if (a2 == null || b2 == null) {
            return a2 == b2;
        }
        if (a2 instanceof AsciiString) {
            return ((AsciiString)a2).contentEquals(b2);
        }
        if (b2 instanceof AsciiString) {
            return ((AsciiString)b2).contentEquals(a2);
        }
        if (a2.length() != b2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < a2.length(); ++i2) {
            if (a2.charAt(i2) == b2.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    private static AsciiString[] toAsciiStringArray(String[] jdkResult) {
        AsciiString[] res = new AsciiString[jdkResult.length];
        for (int i2 = 0; i2 < jdkResult.length; ++i2) {
            res[i2] = new AsciiString(jdkResult[i2]);
        }
        return res;
    }

    private static boolean contains(CharSequence a2, CharSequence b2, CharEqualityComparator cmp) {
        if (a2 == null || b2 == null || a2.length() < b2.length()) {
            return false;
        }
        if (b2.length() == 0) {
            return true;
        }
        int bStart = 0;
        for (int i2 = 0; i2 < a2.length(); ++i2) {
            if (cmp.equals(b2.charAt(bStart), a2.charAt(i2))) {
                if (++bStart != b2.length()) continue;
                return true;
            }
            if (a2.length() - i2 < b2.length()) {
                return false;
            }
            bStart = 0;
        }
        return false;
    }

    private static boolean regionMatchesCharSequences(CharSequence cs2, int csStart, CharSequence string, int start, int length, CharEqualityComparator charEqualityComparator) {
        if (csStart < 0 || length > cs2.length() - csStart) {
            return false;
        }
        if (start < 0 || length > string.length() - start) {
            return false;
        }
        int csIndex = csStart;
        int csEnd = csIndex + length;
        int stringIndex = start;
        while (csIndex < csEnd) {
            char c2;
            char c1;
            if (charEqualityComparator.equals(c1 = cs2.charAt(csIndex++), c2 = string.charAt(stringIndex++))) continue;
            return false;
        }
        return true;
    }

    public static boolean regionMatches(CharSequence cs2, boolean ignoreCase, int csStart, CharSequence string, int start, int length) {
        if (cs2 == null || string == null) {
            return false;
        }
        if (cs2 instanceof String && string instanceof String) {
            return ((String)cs2).regionMatches(ignoreCase, csStart, (String)string, start, length);
        }
        if (cs2 instanceof AsciiString) {
            return ((AsciiString)cs2).regionMatches(ignoreCase, csStart, string, start, length);
        }
        return AsciiString.regionMatchesCharSequences(cs2, csStart, string, start, length, ignoreCase ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean regionMatchesAscii(CharSequence cs2, boolean ignoreCase, int csStart, CharSequence string, int start, int length) {
        if (cs2 == null || string == null) {
            return false;
        }
        if (!ignoreCase && cs2 instanceof String && string instanceof String) {
            return ((String)cs2).regionMatches(false, csStart, (String)string, start, length);
        }
        if (cs2 instanceof AsciiString) {
            return ((AsciiString)cs2).regionMatches(ignoreCase, csStart, string, start, length);
        }
        return AsciiString.regionMatchesCharSequences(cs2, csStart, string, start, length, ignoreCase ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        if (startPos < 0) {
            startPos = 0;
        }
        int searchStrLen = searchStr.length();
        int endLimit = str.length() - searchStrLen + 1;
        if (startPos > endLimit) {
            return -1;
        }
        if (searchStrLen == 0) {
            return startPos;
        }
        for (int i2 = startPos; i2 < endLimit; ++i2) {
            if (!AsciiString.regionMatches(str, true, i2, searchStr, 0, searchStrLen)) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence str, CharSequence searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        if (startPos < 0) {
            startPos = 0;
        }
        int searchStrLen = searchStr.length();
        int endLimit = str.length() - searchStrLen + 1;
        if (startPos > endLimit) {
            return -1;
        }
        if (searchStrLen == 0) {
            return startPos;
        }
        for (int i2 = startPos; i2 < endLimit; ++i2) {
            if (!AsciiString.regionMatchesAscii(str, true, i2, searchStr, 0, searchStrLen)) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(CharSequence cs2, char searchChar, int start) {
        int i2;
        if (cs2 instanceof String) {
            return ((String)cs2).indexOf(searchChar, start);
        }
        if (cs2 instanceof AsciiString) {
            return ((AsciiString)cs2).indexOf(searchChar, start);
        }
        if (cs2 == null) {
            return -1;
        }
        int sz = cs2.length();
        int n2 = i2 = start < 0 ? 0 : start;
        while (i2 < sz) {
            if (cs2.charAt(i2) == searchChar) {
                return i2;
            }
            ++i2;
        }
        return -1;
    }

    private static boolean equalsIgnoreCase(byte a2, byte b2) {
        return a2 == b2 || AsciiStringUtil.toLowerCase(a2) == AsciiStringUtil.toLowerCase(b2);
    }

    private static boolean equalsIgnoreCase(char a2, char b2) {
        return a2 == b2 || AsciiString.toLowerCase(a2) == AsciiString.toLowerCase(b2);
    }

    public static char toLowerCase(char c2) {
        return AsciiString.isUpperCase(c2) ? (char)(c2 + 32) : c2;
    }

    private static byte toUpperCase(byte b2) {
        return AsciiStringUtil.toUpperCase(b2);
    }

    public static boolean isUpperCase(byte value) {
        return AsciiStringUtil.isUpperCase(value);
    }

    public static boolean isUpperCase(char value) {
        return value >= 'A' && value <= 'Z';
    }

    public static byte c2b(char c2) {
        return (byte)(c2 > '\u00ff' ? 63 : (int)c2);
    }

    private static byte c2b0(char c2) {
        return (byte)c2;
    }

    public static char b2c(byte b2) {
        return (char)(b2 & 0xFF);
    }

    private static final class GeneralCaseInsensitiveCharEqualityComparator
    implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override
        public boolean equals(char a2, char b2) {
            return Character.toUpperCase(a2) == Character.toUpperCase(b2) || Character.toLowerCase(a2) == Character.toLowerCase(b2);
        }
    }

    private static final class AsciiCaseInsensitiveCharEqualityComparator
    implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override
        public boolean equals(char a2, char b2) {
            return AsciiString.equalsIgnoreCase(a2, b2);
        }
    }

    private static final class DefaultCharEqualityComparator
    implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        private DefaultCharEqualityComparator() {
        }

        @Override
        public boolean equals(char a2, char b2) {
            return a2 == b2;
        }
    }

    private static interface CharEqualityComparator {
        public boolean equals(char var1, char var2);
    }
}

