/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package com.viaversion.nbt.stringified;

import com.viaversion.nbt.stringified.CharBuffer;
import com.viaversion.nbt.stringified.StringifiedTagParseException;
import com.viaversion.nbt.stringified.Tokens;
import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.jetbrains.annotations.Nullable;

final class TagStringReader {
    private static final int MAX_DEPTH = 512;
    private static final int HEX_RADIX = 16;
    private static final int BINARY_RADIX = 2;
    private static final int DECIMAL_RADIX = 10;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private final CharBuffer buffer;
    private boolean acceptLegacy = true;
    private int depth;

    TagStringReader(CharBuffer buffer) {
        this.buffer = buffer;
    }

    public CompoundTag compound() throws StringifiedTagParseException {
        this.buffer.expect('{');
        CompoundTag compoundTag = new CompoundTag();
        if (this.buffer.takeIf('}')) {
            return compoundTag;
        }
        while (this.buffer.hasMore()) {
            compoundTag.put(this.key(), this.tag());
            if (!this.separatorOrCompleteWith('}')) continue;
            return compoundTag;
        }
        throw this.buffer.makeError("Unterminated compound tag!");
    }

    public ListTag<?> list() throws StringifiedTagParseException {
        boolean prefixedIndex;
        ArrayList<Tag> list = new ArrayList<Tag>();
        this.buffer.expect('[');
        boolean bl2 = prefixedIndex = this.acceptLegacy && this.buffer.peek() == '0' && this.buffer.peek(1) == ':';
        if (!prefixedIndex && this.buffer.takeIf(']')) {
            return ListTag.of(list);
        }
        while (this.buffer.hasMore()) {
            if (prefixedIndex) {
                this.buffer.takeUntil(':');
            }
            Tag next = this.tag();
            list.add(next);
            if (!this.separatorOrCompleteWith(']')) continue;
            return ListTag.of(list);
        }
        throw this.buffer.makeError("Reached end of file without end of list tag!");
    }

    public Tag array(char elementType) throws StringifiedTagParseException {
        this.buffer.expect('[').expect(elementType).expect(';');
        elementType = Character.toLowerCase(elementType);
        if (elementType == 'b') {
            return new ByteArrayTag(this.byteArray());
        }
        if (elementType == 'i') {
            return new IntArrayTag(this.intArray());
        }
        if (elementType == 'l') {
            return new LongArrayTag(this.longArray());
        }
        throw this.buffer.makeError("Type " + elementType + " is not a valid element type in an array!");
    }

    private byte[] byteArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_BYTE_ARRAY;
        }
        IntArrayList bytes = new IntArrayList();
        while (this.buffer.hasMore()) {
            CharSequence value = this.buffer.skipWhitespace().takeUntil('b');
            try {
                bytes.add(Byte.parseByte(value.toString()));
            }
            catch (NumberFormatException ex2) {
                throw this.buffer.makeError("All elements of a byte array must be bytes!");
            }
            if (!this.separatorOrCompleteWith(']')) continue;
            byte[] result = new byte[bytes.size()];
            for (int i2 = 0; i2 < bytes.size(); ++i2) {
                result[i2] = (byte)bytes.getInt(i2);
            }
            return result;
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private int[] intArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_INT_ARRAY;
        }
        IntStream.Builder builder = IntStream.builder();
        while (this.buffer.hasMore()) {
            Tag value = this.tag();
            if (!(value instanceof IntTag)) {
                throw this.buffer.makeError("All elements of an int array must be ints!");
            }
            builder.add(((NumberTag)value).asInt());
            if (!this.separatorOrCompleteWith(']')) continue;
            return builder.build().toArray();
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private long[] longArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_LONG_ARRAY;
        }
        LongStream.Builder longs = LongStream.builder();
        while (this.buffer.hasMore()) {
            CharSequence value = this.buffer.skipWhitespace().takeUntil('l');
            try {
                longs.add(Long.parseLong(value.toString()));
            }
            catch (NumberFormatException ex2) {
                throw this.buffer.makeError("All elements of a long array must be longs!");
            }
            if (!this.separatorOrCompleteWith(']')) continue;
            return longs.build().toArray();
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String key() throws StringifiedTagParseException {
        this.buffer.skipWhitespace();
        char starChar = this.buffer.peek();
        try {
            if (starChar == '\'' || starChar == '\"') {
                String string = TagStringReader.unescape(this.buffer.takeUntil(this.buffer.take()).toString());
                return string;
            }
            StringBuilder builder = new StringBuilder();
            while (this.buffer.hasMore()) {
                char peek = this.buffer.peek();
                if (!Tokens.id(peek)) {
                    if (!this.acceptLegacy) break;
                    if (peek == '\\') {
                        this.buffer.take();
                        continue;
                    }
                    if (peek == ':') break;
                    builder.append(this.buffer.take());
                    continue;
                }
                builder.append(this.buffer.take());
            }
            String string = builder.toString();
            return string;
        }
        finally {
            this.buffer.expect(':');
        }
    }

    public Tag tag() throws StringifiedTagParseException {
        if (this.depth++ > 512) {
            throw this.buffer.makeError("Exceeded maximum allowed depth of 512 when reading tag");
        }
        try {
            char startToken = this.buffer.skipWhitespace().peek();
            switch (startToken) {
                case '{': {
                    CompoundTag compoundTag = this.compound();
                    return compoundTag;
                }
                case '[': {
                    if (this.buffer.hasMore(2) && this.buffer.peek(2) == ';') {
                        Tag tag = this.array(this.buffer.peek(1));
                        return tag;
                    }
                    ListTag<?> listTag = this.list();
                    return listTag;
                }
                case '\"': 
                case '\'': {
                    this.buffer.advance();
                    StringTag stringTag = new StringTag(TagStringReader.unescape(this.buffer.takeUntil(startToken).toString()));
                    return stringTag;
                }
            }
            Tag tag = this.scalar();
            return tag;
        }
        finally {
            --this.depth;
        }
    }

    private Tag scalar() throws StringifiedTagParseException {
        String original;
        block18: {
            char signChar;
            boolean signed;
            StringBuilder builder = new StringBuilder();
            while (this.buffer.hasMore()) {
                char current = this.buffer.peek();
                if (current == '\\') {
                    this.buffer.advance();
                    current = this.buffer.take();
                } else {
                    if (!Tokens.id(current)) break;
                    this.buffer.advance();
                }
                builder.append(current);
            }
            if (builder.length() == 0) {
                throw this.buffer.makeError("Expected a value but got nothing");
            }
            original = builder.toString();
            int radix = this.extractRadix(builder, original);
            char last = builder.charAt(builder.length() - 1);
            boolean hasSignToken = false;
            boolean bl2 = signed = radix != 16;
            if (builder.length() > 2 && ((signChar = builder.charAt(builder.length() - 2)) == 's' || signChar == 'u')) {
                hasSignToken = true;
                signed = signChar == 's';
                builder.deleteCharAt(builder.length() - 2);
            }
            boolean hasTypeToken = false;
            char typeToken = 'i';
            if (Tokens.numericType(last) && (hasSignToken || radix != 16)) {
                hasTypeToken = true;
                typeToken = Character.toLowerCase(last);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (!(signed || typeToken != 'f' && typeToken != 'd')) {
                throw this.buffer.makeError("Cannot create unsigned floating point numbers");
            }
            String strippedString = builder.toString().replace("_", "");
            if (hasTypeToken) {
                try {
                    NumberTag tag = this.parseNumberTag(strippedString, typeToken, radix, signed);
                    if (tag != null) {
                        return tag;
                    }
                }
                catch (NumberFormatException tag) {}
            } else {
                try {
                    return new IntTag(this.parseInt(strippedString, radix, signed));
                }
                catch (NumberFormatException ex2) {
                    if (strippedString.indexOf(46) == -1) break block18;
                    try {
                        return new DoubleTag(Double.parseDouble(strippedString));
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
            }
        }
        if (original.equalsIgnoreCase("true")) {
            return new ByteTag(1);
        }
        if (original.equalsIgnoreCase("false")) {
            return new ByteTag(0);
        }
        return new StringTag(original);
    }

    private int extractRadix(StringBuilder builder, String original) {
        int radix;
        int radixPrefixOffset = 0;
        char first = builder.charAt(0);
        if (first == '+' || first == '-') {
            radixPrefixOffset = 1;
        }
        if (builder.length() < 3 + radixPrefixOffset) {
            return 10;
        }
        if (original.startsWith("0b", radixPrefixOffset) || original.startsWith("0B", radixPrefixOffset)) {
            radix = 2;
        } else if (original.startsWith("0x", radixPrefixOffset) || original.startsWith("0X", radixPrefixOffset)) {
            radix = 16;
        } else {
            return 10;
        }
        builder.delete(radixPrefixOffset, 2 + radixPrefixOffset);
        return radix;
    }

    @Nullable
    private NumberTag parseNumberTag(String s2, char typeToken, int radix, boolean signed) {
        switch (typeToken) {
            case 'b': {
                return new ByteTag(this.parseByte(s2, radix, signed));
            }
            case 's': {
                return new ShortTag(this.parseShort(s2, radix, signed));
            }
            case 'i': {
                return new IntTag(this.parseInt(s2, radix, signed));
            }
            case 'l': {
                return new LongTag(this.parseLong(s2, radix, signed));
            }
            case 'f': {
                float floatValue = Float.parseFloat(s2);
                if (!Float.isFinite(floatValue)) break;
                return new FloatTag(floatValue);
            }
            case 'd': {
                double doubleValue = Double.parseDouble(s2);
                if (!Double.isFinite(doubleValue)) break;
                return new DoubleTag(doubleValue);
            }
        }
        return null;
    }

    private byte parseByte(String s2, int radix, boolean signed) {
        if (signed) {
            return Byte.parseByte(s2, radix);
        }
        int parsedInt = Integer.parseInt(s2, radix);
        if (parsedInt >> 8 == 0) {
            return (byte)parsedInt;
        }
        throw new NumberFormatException();
    }

    private short parseShort(String s2, int radix, boolean signed) {
        if (signed) {
            return Short.parseShort(s2, radix);
        }
        int parsedInt = Integer.parseInt(s2, radix);
        if (parsedInt >> 16 == 0) {
            return (short)parsedInt;
        }
        throw new NumberFormatException();
    }

    private int parseInt(String s2, int radix, boolean signed) {
        return signed ? Integer.parseInt(s2, radix) : Integer.parseUnsignedInt(s2, radix);
    }

    private long parseLong(String s2, int radix, boolean signed) {
        return signed ? Long.parseLong(s2, radix) : Long.parseUnsignedLong(s2, radix);
    }

    private boolean separatorOrCompleteWith(char endCharacter) throws StringifiedTagParseException {
        if (this.buffer.takeIf(endCharacter)) {
            return true;
        }
        this.buffer.expect(',');
        return this.buffer.takeIf(endCharacter);
    }

    private static String unescape(String withEscapes) {
        int escapeIdx = withEscapes.indexOf(92);
        if (escapeIdx == -1) {
            return withEscapes;
        }
        int lastEscape = 0;
        StringBuilder output = new StringBuilder(withEscapes.length());
        do {
            output.append(withEscapes, lastEscape, escapeIdx);
        } while ((escapeIdx = withEscapes.indexOf(92, (lastEscape = escapeIdx + 1) + 1)) != -1);
        output.append(withEscapes.substring(lastEscape));
        return output.toString();
    }

    public void legacy(boolean acceptLegacy) {
        this.acceptLegacy = acceptLegacy;
    }
}

